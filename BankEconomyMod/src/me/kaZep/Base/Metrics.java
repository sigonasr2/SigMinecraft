package me.kaZep.Base;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.YamlConfigurationOptions;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.scheduler.BukkitScheduler;

public class Metrics
{
  private static final int REVISION = 5;
  private static final String BASE_URL = "http://mcstats.org";
  private static final String REPORT_URL = "/report/%s";
  private static final String CONFIG_FILE = "plugins/PluginMetrics/config.yml";
  private static final String CUSTOM_DATA_SEPARATOR = "~~";
  private static final int PING_INTERVAL = 10;
  private final Plugin plugin;
  private final Set<Graph> graphs = Collections.synchronizedSet(new HashSet());

  private final Graph defaultGraph = new Graph("Default");
  private final YamlConfiguration configuration;
  private final File configurationFile;
  private final String guid;
  private final Object optOutLock = new Object();

  private volatile int taskId = -1;

  public Metrics(Plugin plugin) throws IOException {
    if (plugin == null) {
      throw new IllegalArgumentException("Plugin cannot be null");
    }

    this.plugin = plugin;

    this.configurationFile = new File("plugins/PluginMetrics/config.yml");
    this.configuration = YamlConfiguration.loadConfiguration(this.configurationFile);

    this.configuration.addDefault("opt-out", Boolean.valueOf(false));
    this.configuration.addDefault("guid", UUID.randomUUID().toString());

    if (this.configuration.get("guid", null) == null) {
      this.configuration.options().header("http://mcstats.org").copyDefaults(true);
      this.configuration.save(this.configurationFile);
    }

    this.guid = this.configuration.getString("guid");
  }

  public Graph createGraph(String name)
  {
    if (name == null) {
      throw new IllegalArgumentException("Graph name cannot be null");
    }

    Graph graph = new Graph(name);

    this.graphs.add(graph);

    return graph;
  }

  public void addCustomData(Plotter plotter)
  {
    if (plotter == null) {
      throw new IllegalArgumentException("Plotter cannot be null");
    }

    this.defaultGraph.addPlotter(plotter);

    this.graphs.add(this.defaultGraph);
  }

  public boolean start()
  {
    synchronized (this.optOutLock)
    {
      if (isOptOut()) {
        return false;
      }

      if (this.taskId >= 0) {
        return true;
      }

      this.taskId = this.plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(this.plugin, new Runnable()
      {
        private boolean firstPost = true;

        public void run()
        {
          try {
            synchronized (Metrics.this.optOutLock)
            {
              if ((Metrics.this.isOptOut()) && (Metrics.this.taskId > 0)) {
                Metrics.this.plugin.getServer().getScheduler().cancelTask(Metrics.this.taskId);
                Metrics.this.taskId = -1;
              }

            }

            Metrics.this.postPlugin(!this.firstPost);

            this.firstPost = false;
          } catch (IOException e) {
            Bukkit.getLogger().log(Level.INFO, "[Metrics] " + e.getMessage());
          }
        }
      }
      , 0L, 12000L);

      return true;
    }
  }

  public boolean isOptOut()
  {
    synchronized (this.optOutLock)
    {
      try {
        this.configuration.load("plugins/PluginMetrics/config.yml");
      } catch (IOException ex) {
        Bukkit.getLogger().log(Level.INFO, "[Metrics] " + ex.getMessage());
        return true;
      } catch (InvalidConfigurationException ex) {
        Bukkit.getLogger().log(Level.INFO, "[Metrics] " + ex.getMessage());
        return true;
      }
      return this.configuration.getBoolean("opt-out", false);
    }
  }

  public void enable()
    throws IOException
  {
    synchronized (this.optOutLock)
    {
      if (isOptOut()) {
        this.configuration.set("opt-out", Boolean.valueOf(false));
        this.configuration.save(this.configurationFile);
      }

      if (this.taskId < 0)
        start();
    }
  }

  public void disable()
    throws IOException
  {
    synchronized (this.optOutLock)
    {
      if (!isOptOut()) {
        this.configuration.set("opt-out", Boolean.valueOf(true));
        this.configuration.save(this.configurationFile);
      }

      if (this.taskId > 0) {
        this.plugin.getServer().getScheduler().cancelTask(this.taskId);
        this.taskId = -1;
      }
    }
  }

  private void postPlugin(boolean isPing)
    throws IOException
  {
    PluginDescriptionFile description = this.plugin.getDescription();

    StringBuilder data = new StringBuilder();
    data.append(encode("guid")).append('=').append(encode(this.guid));
    encodeDataPair(data, "version", description.getVersion());
    encodeDataPair(data, "server", Bukkit.getVersion());
    encodeDataPair(data, "players", Integer.toString(Bukkit.getServer().getOnlinePlayers().length));
    encodeDataPair(data, "revision", String.valueOf(5));

    if (isPing) {
      encodeDataPair(data, "ping", "true");
    }

    synchronized (this.graphs) {
      Iterator iter = this.graphs.iterator();
      Iterator localIterator1;
      for (; iter.hasNext(); 
        localIterator1.hasNext())
      {
        Graph graph = (Graph)iter.next();

        localIterator1 = graph.getPlotters().iterator(); continue;
      }

    }

    URL url = new URL("http://mcstats.org" + String.format("/report/%s", new Object[] { encode(this.plugin.getDescription().getName()) }));
    URLConnection connection;
    if (isMineshafterPresent())
      connection = url.openConnection(Proxy.NO_PROXY);
    else {
      connection = url.openConnection();
    }

    connection.setDoOutput(true);

    OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
    writer.write(data.toString());
    writer.flush();

    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String response = reader.readLine();

    writer.close();
    reader.close();

    if ((response == null) || (response.startsWith("ERR"))) {
      throw new IOException(response);
    }

    if (response.contains("OK This is your first update this hour"))
      synchronized (this.graphs) {
        Iterator iter = this.graphs.iterator();
        Iterator localIterator2;
        for (; iter.hasNext(); 
          localIterator2.hasNext())
        {
          Graph graph = (Graph)iter.next();

          localIterator2 = graph.getPlotters().iterator(); continue;
        }
      }
  }

  private boolean isMineshafterPresent()
  {
    try
    {
      Class.forName("mineshafter.MineServer");
      return true; } catch (Exception e) {
    }
    return false;
  }

  private static void encodeDataPair(StringBuilder buffer, String key, String value)
    throws UnsupportedEncodingException
  {
    buffer.append('&').append(encode(key)).append('=').append(encode(value));
  }

  private static String encode(String text)
    throws UnsupportedEncodingException
  {
    return URLEncoder.encode(text, "UTF-8");
  }

  public static class Graph
  {
    private final String name;
    private final Set<Metrics.Plotter> plotters = new LinkedHashSet();

    private Graph(String name) {
      this.name = name;
    }

    public String getName()
    {
      return this.name;
    }

    public void addPlotter(Metrics.Plotter plotter)
    {
      this.plotters.add(plotter);
    }

    public void removePlotter(Metrics.Plotter plotter)
    {
      this.plotters.remove(plotter);
    }

    public Set<Metrics.Plotter> getPlotters()
    {
      return Collections.unmodifiableSet(this.plotters);
    }

    public int hashCode()
    {
      return this.name.hashCode();
    }

    public boolean equals(Object object)
    {
      if (!(object instanceof Graph)) {
        return false;
      }

      Graph graph = (Graph)object;
      return graph.name.equals(this.name);
    }
  }

  public static abstract class Plotter
  {
    private final String name;

    public Plotter()
    {
      this("Default");
    }

    public Plotter(String name)
    {
      this.name = name;
    }

    public abstract int getValue();

    public String getColumnName()
    {
      return this.name;
    }

    public void reset()
    {
    }

    public int hashCode()
    {
      return getColumnName().hashCode() + getValue();
    }

    public boolean equals(Object object)
    {
      if (!(object instanceof Plotter)) {
        return false;
      }

      Plotter plotter = (Plotter)object;
      return (plotter.name.equals(this.name)) && (plotter.getValue() == getValue());
    }
  }
}