package me.kaZep.Base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.*;

import me.kaZep.Commands.JobsDataInfo;
import me.kaZep.Commands.commandBankEconomy;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BrewingStand;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.block.Furnace;
import org.bukkit.block.Jukebox;
import org.bukkit.block.Sign;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.enchantments.Enchantment;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.schematic.SchematicFormat;

public class Main extends JavaPlugin
{
  public final Logger logger = Logger.getLogger("Minecraft");
  public static Economy economy = null;
  public ItemStack[] spleef_inventory_a,spleef_inventory_b;
  public ItemStack[] spleef4_inventory_a,spleef4_inventory_b,spleef4_inventory_c,spleef4_inventory_d;
  public ItemStack store_shovel=null;
  public double spleef_last_broken_block;
  public double spleef4_last_broken_block;
  public boolean turnedon=false;
  public long last_world_time=0;
  public long hold_diff=0;
  public long accumulator=0;
  public long last_mob_random_time=0;
  public long last_lightning_random_time=0;
  public long last_lava_dump_time=0;
  public long last_check_mob_time=0;
  public long last_spawner_check_time=0;
  public long last_bank_deposit_use_time=0;
  public String last_bank_deposit_user="";
  public long last_bank_withdraw_use_time=0;
  public String last_bank_withdraw_user="";
  public long last_boss_dungeon_time=0;
  public long check_nether_time=0;
  public long check_lights_time=0;
  public long check_spleef_game=0;
  public boolean harrowing_night=false;
  public double randomitemchance = 800;
  public static long SERVER_TICK_TIME = 0;
  
  public int REVIVE_EFFECT=0; 
  public Location REVIVE_EFFECT_LOC; 
  public int BOSS_DEFEAT=0; 
  public Location BOSS_DEFEAT_LOC;
  public int POLYMORPH=0; 
  public Location POLYMORPH_LOC;
  
  public int LOGGING_UPDATE_COUNTS=-1;
  public int MAX_LOGGING_COUNT=12;
  public List<String> LOGGING_LOGS;
  
  public boolean cleaned=false;
  
  public JobsDataInfo Woodcutter_job = new JobsDataInfo();
  public JobsDataInfo Builder_job = new JobsDataInfo();
  public JobsDataInfo Miner_job = new JobsDataInfo();
  public JobsDataInfo Digger_job = new JobsDataInfo();
  public JobsDataInfo Farmer_job = new JobsDataInfo();
  public JobsDataInfo Hunter_job = new JobsDataInfo();
  public JobsDataInfo Fisherman_job = new JobsDataInfo();
  public JobsDataInfo Weaponsmith_job = new JobsDataInfo();
  public JobsDataInfo Blacksmith_job = new JobsDataInfo();
  public JobsDataInfo Cook_job = new JobsDataInfo();
  public JobsDataInfo Brewer_job = new JobsDataInfo();
  public JobsDataInfo Enchanter_job = new JobsDataInfo();
  public JobsDataInfo Breeder_job = new JobsDataInfo();
  public JobsDataInfo Explorer_job = new JobsDataInfo();
  public JobsDataInfo Support_job = new JobsDataInfo();
  public List<JukeboxData> jukeboxlist = null;
  public List<FurnaceData> furnacelist = null;
  public List<BrewingStandData> brewingstandlist = null;
  public List<EntityInteractData> animallist = null;
  public List<ExplorerData> explorerlist = null;
  public List<Item> supportstackslist = null;
  public List<SupportEntity> supportmoblist = null;
  public List<EntityHitData> hitmoblist = null;
  public List<PlayerBuffData> SPEED_CONTROL = null;
  public List<SupportPlayer> supportplayers = null;
  public List<Player> hunterplayers = null;
  public List<PersistentExplorerList> explorers = null;
  public List<ArrowShooter> ARROW_SHOOTERS = null;
  public List<TempWeb> TEMP_WEBS = null;
  public List<PlayerData> playerdata_list = null;
  public List<InvisibilityData> ninjavisible_list = null;
  public List<ReviveInventory> revive_inventory_list = null;
  public List<Chunk> chunk_queue_list = null;
  public static List<RecyclingCenterNode> recycling_center_list = null;
  public DamageAPI DMGCALC = null;
  public long lastMessage = 0;
  

  public FileWriter outputStream = null;
  
  public EnchantLevelDatabase ENCHANTMENT_DATA;
  File f;
  
  public Material[] RARE_BLOCKS = {Material.BEACON,Material.ANVIL,Material.ACTIVATOR_RAIL,Material.BEDROCK,Material.BOOKSHELF,Material.DAYLIGHT_DETECTOR,Material.COAL_ORE,Material.CLAY,Material.DIAMOND_ORE,Material.IRON_ORE,Material.REDSTONE_ORE,Material.EMERALD_ORE,Material.GOLD_ORE,Material.LAPIS_ORE,Material.OBSIDIAN,Material.MOSSY_COBBLESTONE,Material.MOB_SPAWNER,Material.NETHER_BRICK,Material.NETHER_FENCE,Material.JUKEBOX,Material.QUARTZ_ORE,Material.PORTAL,Material.PISTON_BASE,Material.REDSTONE_WIRE,Material.DISPENSER,Material.LOG,Material.MYCEL,Material.HUGE_MUSHROOM_1,Material.HUGE_MUSHROOM_2};
  long GLOBAL_villagetimer=0,GLOBAL_templetimer=0,GLOBAL_cavetimer=0,GLOBAL_undergroundtimer=0,GLOBAL_nethertimer=0;
  

	public String[] ValidJobs = {"Woodcutter","Miner","Builder","Digger","Farmer","Hunter","Fisherman","Weaponsmith","Blacksmith","Cook","Brewer","Enchanter","Breeder","Explorer","Support"};
	public ChatColor[] JobColors = {ChatColor.GREEN,ChatColor.GRAY,ChatColor.WHITE,ChatColor.GOLD,ChatColor.BLUE,ChatColor.RED,ChatColor.AQUA,ChatColor.DARK_PURPLE,ChatColor.GOLD,
			ChatColor.YELLOW,ChatColor.LIGHT_PURPLE,ChatColor.DARK_BLUE,ChatColor.DARK_GREEN,ChatColor.WHITE,ChatColor.DARK_RED};

  private FileConfiguration accountsConfig = null;
  private File accountsConfigFile = null;

  public final PlayerListener pl = new PlayerListener(this);

  String pluginPrefix = ChatColor.DARK_GREEN+"[BankEconomy]";

  public double Warning(LivingEntity l,int id) {
	  double hp = l.getHealth();
	  if (hp>65) {
		  //Bukkit.broadcastMessage("HP too high for ID "+id+". Removing entity "+l.getType().getName()+" with "+hp+" health.");
		  l.remove();
	  }
	  return hp;
  }
  
  public double Warning(double hp,int id) {
	  if (hp>65) {
		  Bukkit.broadcastMessage("Main: HP too high for ID "+id+". HP was "+hp);
	  }
	  return hp;
  }
  
  public void onEnable()
  {
    getServer().getPluginManager().registerEvents(this.pl, this);
    
    cleaned=false;
    
    PluginDescriptionFile pdf = getDescription();
    System.out.println("[" + getDescription().getName() + "] Status: Activated (mb: kaZep)");
    System.out.println("[" + getDescription().getName() + "] PayDay: " + getConfig().getBoolean("payday.enabled"));
    System.out.println("[" + getDescription().getName() + "] Version: " + pdf.getVersion());
    
    getCommand("bankeconomy").setExecutor(new commandBankEconomy(this));
    getCommand("revive").setExecutor(new commandBankEconomy(this));
    getCommand("tele").setExecutor(new commandBankEconomy(this));
    getCommand("jobs").setExecutor(new commandBankEconomy(this));
    getCommand("unenchant").setExecutor(new commandBankEconomy(this));
    getCommand("sp").setExecutor(new commandBankEconomy(this));
    getCommand("transfer").setExecutor(new commandBankEconomy(this));
    getCommand("settings").setExecutor(new commandBankEconomy(this));
    getCommand("maintenance").setExecutor(new commandBankEconomy(this));
    getCommand("event").setExecutor(new commandBankEconomy(this));
    //getCommand("dungeon").setExecutor(new commandBankEconomy(this));
    getCommand("ticktime").setExecutor(new commandBankEconomy(this));

    setupEconomy();

    getConfig().options().copyDefaults(true);
    getConfig().addDefault("start-balance", Integer.valueOf(0));
    getConfig().addDefault("payday.enabled", Boolean.valueOf(false));
    getConfig().addDefault("payday.time", Integer.valueOf(60));
    getConfig().addDefault("payday.amount", Integer.valueOf(0));
    getConfig().addDefault("fed.mobs", String.valueOf(""));
    getConfig().addDefault("maintenance-mode", Boolean.valueOf(false));
    getConfig().addDefault("halloween-enabled", Boolean.valueOf(true));
    getConfig().addDefault("item-cube-numb", Integer.valueOf(0));
    getConfig().addDefault("server-tick-time", Long.valueOf(143000000l));
    saveConfig();
    
    SERVER_TICK_TIME = getConfig().getLong("server-tick-time");

    getAccountsConfig().options().copyDefaults(true);
    saveAccountsConfig();
    
    getConfig().set("spleefrequestatime", Integer.valueOf(0));
    getConfig().set("spleefrequestbtime", Integer.valueOf(0));
    getConfig().set("spleeflastrequesttime", Integer.valueOf(0));
    getConfig().set("spleef4insession", Boolean.valueOf(false));
    getConfig().set("spleefinsession", Boolean.valueOf(false));
    
    jukeboxlist = new ArrayList<JukeboxData>();
    furnacelist = new ArrayList<FurnaceData>();
    brewingstandlist = new ArrayList<BrewingStandData>();
    animallist = new ArrayList<EntityInteractData>();
    explorerlist = new ArrayList<ExplorerData>();
    supportstackslist = new ArrayList<Item>();
    supportmoblist = new ArrayList<SupportEntity>();
    hitmoblist = new ArrayList<EntityHitData>();
    ENCHANTMENT_DATA = new EnchantLevelDatabase();
    SPEED_CONTROL = new ArrayList<PlayerBuffData>();
    supportplayers = new ArrayList<SupportPlayer>();
    hunterplayers = new ArrayList<Player>();
    explorers = new ArrayList<PersistentExplorerList>();
    LOGGING_LOGS = new ArrayList<String>();
    ARROW_SHOOTERS = new ArrayList<ArrowShooter>();
    TEMP_WEBS = new ArrayList<TempWeb>();
    playerdata_list = new ArrayList<PlayerData>();
    ninjavisible_list = new ArrayList<InvisibilityData>();
    revive_inventory_list = new ArrayList<ReviveInventory>();
    chunk_queue_list = new ArrayList<Chunk>();
    
    recycling_center_list = new ArrayList<RecyclingCenterNode>();
    
    //Add in Twoside Recycling Center.
    RecyclingCenterNode Twoside_recycling_center = new RecyclingCenterNode(this);
    Twoside_recycling_center.addChest(new Location(Bukkit.getWorld("world"), 1617, 67, -351));
	Twoside_recycling_center.addChest(new Location(Bukkit.getWorld("world"), 1618, 67, -351));
	Twoside_recycling_center.addChest(new Location(Bukkit.getWorld("world"), 1617, 67, -355));
	Twoside_recycling_center.addChest(new Location(Bukkit.getWorld("world"), 1618, 67, -355));
	Twoside_recycling_center.addChest(new Location(Bukkit.getWorld("world"), 1622, 67, -355));
	Twoside_recycling_center.addChest(new Location(Bukkit.getWorld("world"), 1623, 67, -355));
	Twoside_recycling_center.addChest(new Location(Bukkit.getWorld("world"), 1622, 67, -351));
	Twoside_recycling_center.addChest(new Location(Bukkit.getWorld("world"), 1623, 67, -351));
    recycling_center_list.add(Twoside_recycling_center);
    
    //Add in Sarayn Recycling Center.
    RecyclingCenterNode Sarayn_recycling_center = new RecyclingCenterNode(this);
    Sarayn_recycling_center.addChest(new Location(Bukkit.getWorld("world"), 1540, 57, 154));
    Sarayn_recycling_center.addChest(new Location(Bukkit.getWorld("world"), 1541, 57, 154));
    recycling_center_list.add(Sarayn_recycling_center);
    
    //Add Recipe for melon slice crafting.
    ShapedRecipe melon_slice = new ShapedRecipe(new ItemStack(Material.MELON, 8));
    melon_slice.shape("a");
    melon_slice.setIngredient('a', Material.MELON_BLOCK);
    Bukkit.addRecipe(melon_slice);

    //Add wood slab recombining recipes.
    ShapedRecipe oak_planks = new ShapedRecipe(new ItemStack(Material.WOOD, 1, (short) 0));
    oak_planks.shape("aa");
    oak_planks.setIngredient('a', new ItemStack(Material.WOOD_STEP, 1, (short) 0).getData());
    Bukkit.addRecipe(oak_planks);
    ShapedRecipe spruce_planks = new ShapedRecipe(new ItemStack(Material.WOOD, 1, (short) 1));
    spruce_planks.shape("aa");
    spruce_planks.setIngredient('a', new ItemStack(Material.WOOD_STEP, 1, (short) 1).getData());
    Bukkit.addRecipe(spruce_planks);
    ShapedRecipe birch_planks = new ShapedRecipe(new ItemStack(Material.WOOD, 1, (short) 2));
    birch_planks.shape("aa");
    birch_planks.setIngredient('a', new ItemStack(Material.WOOD_STEP, 1, (short) 2).getData());
    Bukkit.addRecipe(birch_planks);
    ShapedRecipe jungle_planks = new ShapedRecipe(new ItemStack(Material.WOOD, 1, (short) 3));
    jungle_planks.shape("aa");
    jungle_planks.setIngredient('a', new ItemStack(Material.WOOD_STEP, 1, (short) 3).getData());
    Bukkit.addRecipe(jungle_planks);
    
    //Add non-wood slab recombining recipes.
    ShapedRecipe stone = new ShapedRecipe(new ItemStack(Material.STONE, 1));
    stone.shape("aa");
    stone.setIngredient('a', new ItemStack(Material.STEP, 1, (short) 0).getData());
    Bukkit.addRecipe(stone);
    ShapedRecipe sandstone = new ShapedRecipe(new ItemStack(Material.SANDSTONE, 1));
    sandstone.shape("aa");
    sandstone.setIngredient('a', new ItemStack(Material.STEP, 1, (short) 1).getData());
    Bukkit.addRecipe(sandstone);
    ShapedRecipe cobblestone = new ShapedRecipe(new ItemStack(Material.COBBLESTONE, 1));
    cobblestone.shape("aa");
    cobblestone.setIngredient('a', new ItemStack(Material.STEP, 1, (short) 3).getData());
    Bukkit.addRecipe(cobblestone);
    ShapedRecipe bricks = new ShapedRecipe(new ItemStack(Material.BRICK, 1));
    bricks.shape("aa");
    bricks.setIngredient('a', new ItemStack(Material.STEP, 1, (short) 4).getData());
    Bukkit.addRecipe(bricks);
    ShapedRecipe stone_bricks = new ShapedRecipe(new ItemStack(Material.SMOOTH_BRICK, 1));
    stone_bricks.shape("aa");
    stone_bricks.setIngredient('a', new ItemStack(Material.STEP, 1, (short) 5).getData());
    Bukkit.addRecipe(stone_bricks);
    ShapedRecipe nether_bricks = new ShapedRecipe(new ItemStack(Material.NETHER_BRICK, 1));
    nether_bricks.shape("aa");
    nether_bricks.setIngredient('a', new ItemStack(Material.STEP, 1, (short) 6).getData());
    Bukkit.addRecipe(nether_bricks);
    ShapedRecipe nether_quartz = new ShapedRecipe(new ItemStack(Material.QUARTZ, 1));
    nether_quartz.shape("aa");
    nether_quartz.setIngredient('a', new ItemStack(Material.STEP, 1, (short) 7).getData());
    Bukkit.addRecipe(nether_quartz);    
    
    //Add Recipes for new Block armor crafting.
    ShapedRecipe iron_helmet = new ShapedRecipe(new ItemStack(Material.IRON_HELMET));
    iron_helmet.shape("aaa","a a");
    iron_helmet.setIngredient('a', Material.IRON_BLOCK);
    Bukkit.addRecipe(iron_helmet);
    ShapedRecipe iron_chestplate = new ShapedRecipe(new ItemStack(Material.IRON_CHESTPLATE));
    iron_chestplate.shape("a a","aaa","aaa");
    iron_chestplate.setIngredient('a', Material.IRON_BLOCK);
    Bukkit.addRecipe(iron_chestplate);
    ShapedRecipe iron_leggings = new ShapedRecipe(new ItemStack(Material.IRON_LEGGINGS));
    iron_leggings.shape("aaa","a a","a a");
    iron_leggings.setIngredient('a', Material.IRON_BLOCK);
    Bukkit.addRecipe(iron_leggings);
    ShapedRecipe iron_boots = new ShapedRecipe(new ItemStack(Material.IRON_BOOTS));
    iron_boots.shape("a a","a a");
    iron_boots.setIngredient('a', Material.IRON_BLOCK);
    Bukkit.addRecipe(iron_boots);
    ShapedRecipe gold_helmet = new ShapedRecipe(new ItemStack(Material.GOLD_HELMET));
    gold_helmet.shape("aaa","a a");
    gold_helmet.setIngredient('a', Material.GOLD_BLOCK);
    Bukkit.addRecipe(gold_helmet);
    ShapedRecipe gold_chestplate = new ShapedRecipe(new ItemStack(Material.GOLD_CHESTPLATE));
    gold_chestplate.shape("a a","aaa","aaa");
    gold_chestplate.setIngredient('a', Material.GOLD_BLOCK);
    Bukkit.addRecipe(gold_chestplate);
    ShapedRecipe gold_leggings = new ShapedRecipe(new ItemStack(Material.GOLD_LEGGINGS));
    gold_leggings.shape("aaa","a a","a a");
    gold_leggings.setIngredient('a', Material.GOLD_BLOCK);
    Bukkit.addRecipe(gold_leggings);
    ShapedRecipe gold_boots = new ShapedRecipe(new ItemStack(Material.GOLD_BOOTS));
    gold_boots.shape("a a","a a");
    gold_boots.setIngredient('a', Material.GOLD_BLOCK);
    Bukkit.addRecipe(gold_boots);
    ShapedRecipe diamond_helmet = new ShapedRecipe(new ItemStack(Material.DIAMOND_HELMET));
    diamond_helmet.shape("aaa","a a");
    diamond_helmet.setIngredient('a', Material.DIAMOND_BLOCK);
    Bukkit.addRecipe(diamond_helmet);
    ShapedRecipe diamond_chestplate = new ShapedRecipe(new ItemStack(Material.DIAMOND_CHESTPLATE));
    diamond_chestplate.shape("a a","aaa","aaa");
    diamond_chestplate.setIngredient('a', Material.DIAMOND_BLOCK);
    Bukkit.addRecipe(diamond_chestplate);
    ShapedRecipe diamond_leggings = new ShapedRecipe(new ItemStack(Material.DIAMOND_LEGGINGS));
    diamond_leggings.shape("aaa","a a","a a");
    diamond_leggings.setIngredient('a', Material.DIAMOND_BLOCK);
    Bukkit.addRecipe(diamond_leggings);
    ShapedRecipe diamond_boots = new ShapedRecipe(new ItemStack(Material.DIAMOND_BOOTS));
    diamond_boots.shape("a a","a a");
    diamond_boots.setIngredient('a', Material.DIAMOND_BLOCK);
    Bukkit.addRecipe(diamond_boots);
    ItemStack temp = new ItemStack(Material.CHEST);
    ItemMeta tempmeta = temp.getItemMeta();
    tempmeta.setDisplayName(ChatColor.YELLOW+"Item Cube");
    List<String> templore = new ArrayList<String>();
    templore.add(ChatColor.AQUA+"Contains 9 item slots.");
    templore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"Click on an item and then");
    templore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"click the Item Cube to store");
    templore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"it inside. Right-Click the");
    templore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"Item Cube to view its contents.");
    tempmeta.setLore(templore);
    temp.setItemMeta(tempmeta);
    ShapedRecipe item_cube = new ShapedRecipe(temp);
    item_cube.shape("aaa","aba","aaa");
    item_cube.setIngredient('a', Material.CHEST);
    item_cube.setIngredient('b', Material.HOPPER);
    Bukkit.addRecipe(item_cube);
    temp = new ItemStack(Material.TRAPPED_CHEST);
    tempmeta = temp.getItemMeta();
    tempmeta.setDisplayName(ChatColor.LIGHT_PURPLE+"Large Item Cube");
    templore = new ArrayList<String>();
    templore.add(ChatColor.AQUA+"Contains 54 item slots.");
    templore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"Click on an item and then");
    templore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"click the Item Cube to store");
    templore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"it inside. Right-Click the");
    templore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"Item Cube to view its contents.");
    tempmeta.setLore(templore);
    temp.setItemMeta(tempmeta);
    item_cube = new ShapedRecipe(temp);
    item_cube.shape("cac","aba","cac");
    item_cube.setIngredient('a', Material.ENDER_CHEST);
    item_cube.setIngredient('b', Material.HOPPER);
    item_cube.setIngredient('c', Material.DIAMOND_BLOCK);
    Bukkit.addRecipe(item_cube);
    
    DMGCALC = new DamageAPI();
    //System.out.println("Running BankEconomy in "+this.getDataFolder().getAbsolutePath());
    //System.out.println("File size: "+f.length());
    checkJukeboxes();
    updateTime();
    runTick();
    
    if (!getConfig().getBoolean("payday.enabled"))
      return;
    if (getConfig().getBoolean("payday.enabled")) {
      payDay(getConfig().getInt("payday.time"));
    } else {
      System.out.println("[BANKECONOMY ALERT] Error caused at 'payday.enabled'. Changed boolean to false.");
      getConfig().set("payday.enabled", Boolean.valueOf(false));
      saveConfig();
    }
    try
    {
      Metrics metrics = new Metrics(this);
      metrics.start();
    } catch (IOException e) {
      System.out.println("[WARNING] " + getDescription().getName() + " didn't connect to McStats.org ! Please check your metrics settings.");
    }

    Woodcutter_job.setJobName("Woodcutter");
    Woodcutter_job.setJobDescription("A woodcutter's job is to cut down and replenish the supplies of trees constantly in order to keep getting income.");
    Woodcutter_job.setAction(0, "BREAK");
    Woodcutter_job.setExp(40, 10, 20, 1.03);
    Woodcutter_job.addData("WOOD", 0.01, 1, 0);
    Woodcutter_job.addData("WOOD W/ AXE", 0.025, 2, 0);
    Woodcutter_job.setAction(1, "PLACE");
    Woodcutter_job.addData("SAPLINGS", 0.015, 1, 1);
    Woodcutter_job.addData("WOOD", 0.01, 0.25, 1);
    Woodcutter_job.addData("WOODEN PLANK", 0.00, 0.10, 1);
    Woodcutter_job.setBuffData("Saplings have a higher chance of dropping from tree leaves. (+40%)",
    		"Axes used gain Efficiency +1 (Speed+30%)",
    		"Saplings have a higher chance of dropping from tree leaves. (+60%), Axes used gain Efficiency +2 (Speed+60%).",
    		"Axes that you use never break. Axes used gain Efficiency +3 (Speed+90%) 2-5 wood is dropped from each log. Saplings around you have a higher chance of growing quickly.");
    
    Miner_job.setJobName("Miner");
    Miner_job.setJobDescription("A miner's job is to venture into caves and collect precious minerals from within, eventually coming out with such treasures for use in other production.");
    Miner_job.setAction(0, "BREAK");
    Miner_job.setExp(60, 100, 65, 1.02);
    Miner_job.addData("STONE", 0.0025, 1, 0);
    Miner_job.addData("NETHERRACK", 0.005, 1, 0);
    Miner_job.addData("COAL", 0.0125, 3, 0);
    Miner_job.addData("GLOWSTONE", 0.015, 3, 0);
    Miner_job.addData("SANDSTONE", 0.015, 4, 0);
    Miner_job.addData("NETHER BRICK", 0.02, 3, 0);
    Miner_job.addData("QUARTZ ORE", 0.025, 4, 0);
    Miner_job.addData("LAPIS LAZULI ORE", 0.03, 5, 0);
    Miner_job.addData("MOSSY COBBLESTONE", 0.0375, 8, 0);
    Miner_job.addData("IRON ORE", 0.0375, 6, 0);
    Miner_job.addData("REDSTONE ORE", 0.05, 9, 0);
    Miner_job.addData("OBSIDIAN", 0.0625, 10, 0);
    Miner_job.addData("GOLD ORE", 0.0975, 12, 0);
    Miner_job.addData("DIAMOND ORE", 0.3125, 60, 0);
    Miner_job.addData("EMERALD ORE", 0.7625, 160, 0);
    Miner_job.setBuffData("Pickaxes used gain Efficiency +1 (Speed+30%)",
    		"Pickaxes have double the durability.", 
    		"Pickaxes used gain Efficiency +2 (Speed+60%)", 
    		"Pickaxes used give 240% more items from ore, have quadruple the durability, Efficiency +3 (Speed+90%). Minecart riding speed increased by 40%.");

    Builder_job.setJobName("Builder");
    Builder_job.setJobDescription("A builder's job is to use blocks in order to create and invent new buildings using materials that look nice.");
    Builder_job.setAction(0, "PLACE");
    Builder_job.setExp(80, 150, 50, 1.02);
    Builder_job.addData("COBBLESTONE", 0.005, 1, 0);
    Builder_job.addData("WOODEN PLANK", 0.005, 2, 0);
    Builder_job.addData("WOOD", 0.01, 3, 0);
    Builder_job.addData("COBBLESTONE SLAB", 0.015, 3, 0);
    Builder_job.addData("COBBLESTONE STAIRS", 0.015, 3, 0);
    Builder_job.addData("STONE", 0.015, 4, 0);
    Builder_job.addData("WOODEN FENCE", 0.015, 3, 0);
    Builder_job.addData("WOODEN SLAB", 0.015, 3, 0);
    Builder_job.addData("STONE SLAB", 0.02, 4, 0);
    Builder_job.addData("WOODEN STAIRS", 0.02, 4, 0);
    Builder_job.addData("LAPIS BLOCK", 0.02, 3, 0);
    Builder_job.addData("SANDSTONE SLAB", 0.025, 4, 0);
    Builder_job.addData("NETHER BRICK STAIRS", 0.025, 5, 0);
    Builder_job.addData("NETHER BRICK", 0.03, 5, 0);
    Builder_job.addData("NETHER BRICK SLAB", 0.03, 5, 0);
    Builder_job.addData("NETHER BRICK FENCE", 0.03, 6, 0);
    Builder_job.addData("STONE BRICK SLAB", 0.03, 5, 0);
    Builder_job.addData("WOOL", 0.035, 7, 0);
    Builder_job.addData("STONE BRICK STAIRS", 0.04, 8, 0);
    Builder_job.addData("STONE BRICK", 0.04, 8, 0);
    Builder_job.addData("GLASS", 0.04, 8, 0);
    Builder_job.addData("QUARTZ SLAB", 0.05, 9, 0);
    Builder_job.addData("BRICKS SLAB", 0.05, 9, 0);
    Builder_job.addData("GLOWSTONE", 0.05, 10, 0);
    Builder_job.addData("HARDENED CLAY", 0.05, 10, 0);
    Builder_job.addData("STAINED CLAY", 0.05, 10, 0);
    Builder_job.addData("SANDSTONE STAIRS", 0.06, 10, 0);
    Builder_job.addData("SANDSTONE", 0.06, 10, 0);
    Builder_job.addData("QUARTZ STAIRS", 0.06, 12, 0);
    Builder_job.addData("BRICK STAIRS", 0.065, 9, 0);
    Builder_job.addData("QUARTZ BLOCK", 0.07, 14, 0);
    Builder_job.addData("BRICK", 0.075, 11, 0);
    Builder_job.setBuffData("Every 5XP gives you one torch.",
    		"1% of blocks placed will be replenished to your inventory.", 
    		"5% of blocks placed will be replenished to your inventory.", 
    		"Placing blocks gives you experience orbs. 50% of blocks placed will be replenished to your inventory.");

    Digger_job.setJobName("Digger");
    Digger_job.setJobDescription("A digger's job is to collect blocks from the ground that are collectible with a shovel. The digger may also convert some blocks to other types for more XP and money.");
    Digger_job.setAction(0, "BREAK");
    Digger_job.setAction(1, "CRAFT");
    Digger_job.setAction(2, "SMELT");
    Digger_job.setExp(150, 100, 30, 1.02);
    Digger_job.addData("DIRT", 0.005, 1, 0);
    Digger_job.addData("GRASS", 0.005, 2, 0);
    Digger_job.addData("SAND", 0.01, 2, 0);
    Digger_job.addData("GRAVEL", 0.02, 5, 0);
    Digger_job.addData("SOUL SAND", 0.04, 8, 0);
    Digger_job.addData("CLAY", 0.05, 10, 0);
    Digger_job.addData("SANDSTONE", 0.02, 6, 1);
    Digger_job.addData("SMOOTH SANDSTONE", 0.02, 6, 1);
    Digger_job.addData("CHISELED SANDSTONE", 0.025, 7, 1);
    Digger_job.addData("BRICKS", 0.04, 8, 1);
    Digger_job.addData("GLASS", 0.015, 3, 2);
    Digger_job.addData("BRICK", 0.04, 8, 2);
    Digger_job.addData("HARDENED CLAY", 0.04, 8, 2);
    Digger_job.setBuffData("Shovels used gain Efficiency +1 (Speed+30%)",
    		"Shovels have double the durability.", 
    		"Shovels used gain Efficiency +2 (Speed+60%), Shovels have triple the durability.", 
    		"Shovels have quadruple the durability. Blocks dug up are doubled in quantity. Shovels have Efficiency +4 (Speed+120%).");

    Farmer_job.setJobName("Farmer");
    Farmer_job.setJobDescription("A farmer's job is to sustain and continue to replenish what nature provides to turn them into sustainable food items and other useful things.");
    Farmer_job.setAction(0, "BREAK");
    Farmer_job.setAction(1, "PLACE");
    Farmer_job.setExp(150, 100, 20, 1.02);
    Farmer_job.addData("SUGAR CANE", 0.00, 1, 0);
    Farmer_job.addData("CACTUS", 0.00, 3, 0);
    Farmer_job.addData("BROWN MUSHROOM", 0.00, 3, 0);
    Farmer_job.addData("RED MUSHROOM", 0.00, 3, 0);
    Farmer_job.addData("WHEAT", 0.005, 2, 0);
    Farmer_job.addData("CARROT", 0.005, 2, 0);
    Farmer_job.addData("POTATO", 0.015, 3, 0);
    Farmer_job.addData("NETHER WART", 0.015, 3, 0);
    //Farmer_job.addData("PUMPKIN SEEDS", 0.02, 4, 0);
    //Farmer_job.addData("PUMPKIN", 0.04, 8, 0);
    Farmer_job.addData("MELON", 0.05, 10, 0);
    Farmer_job.addData("SEEDS", 0.0025, 1, 1);
    Farmer_job.addData("PUMPKIN SEEDS", 0.005, 2, 1);
    Farmer_job.addData("MELON SEEDS", 0.005, 2, 1);
    //Farmer_job.addData("PUMPKIN", 0.00, -16, 1);
    Farmer_job.setBuffData("Hoes do not lose durability when used.",
    		"Killing skeletons yields triple the amount of bones.", 
    		"Nearby crops grow 30% faster.", 
    		"Nearby crops grow 200% faster. Bonemeal grows things instantly. (Just like before the bonemeal nerf) in one use.");

    Hunter_job.setJobName("Hunter");
    Hunter_job.setJobDescription("A hunter's job is to take care of the threats at night and protect others who may be in danger. Hunters that kill innocent creatures will be punished, thus they must resort to other methods for food.");
    Hunter_job.setAction(0, "HURT");
    Hunter_job.setAction(1, "KILL");
    Hunter_job.setExp(300, 250, 35, 1.01);
    Hunter_job.addData("SQUID", 0.00, 1, 0);
    Hunter_job.addData("SLIME", 0.005, 1, 0);
    Hunter_job.addData("ZOMBIE", 0.01, 2, 0);
    Hunter_job.addData("SPIDER", 0.01, 2, 0);
    Hunter_job.addData("SKELETON", 0.015, 3, 0);
    Hunter_job.addData("CREEPER", 0.025, 5, 0);
    Hunter_job.addData("PIG ZOMBIE", 0.03, 6, 0);
    Hunter_job.addData("GHAST", 0.04, 8, 0);
    Hunter_job.addData("ENDERMAN", 0.04, 8, 0);
    Hunter_job.addData("BLAZE", 0.05, 10, 0);
    Hunter_job.addData("ENDER DRAGON", 12.50, 250, 0);
    Hunter_job.addData("WITHER", 22.50, 450, 0);
    Hunter_job.addData("CHICKEN", 0.00, -2, 0);
    Hunter_job.addData("SHEEP", 0.00, -3, 0);
    Hunter_job.addData("PIG", 0.00, -4, 0);
    Hunter_job.addData("COW", 0.00, -6, 0);
    Hunter_job.addData("OCELOT", 0.00, -9, 0);
    Hunter_job.addData("WOLF", 0.00, -12, 0);
    Hunter_job.addData("MUSHROOM COW", 0.00, -20, 0);
    Hunter_job.addData("SQUID", 0.00, 0, 1);
    Hunter_job.addData("SLIME", 0.00, 0, 1);
    Hunter_job.addData("SPIDER", 0.02, 4, 1);
    Hunter_job.addData("ZOMBIE", 0.025, 5, 1);
    Hunter_job.addData("SKELETON", 0.035, 7, 1);
    Hunter_job.addData("CREEPER", 0.05, 10, 1);
    Hunter_job.addData("PIG ZOMBIE", 0.08, 16, 1);
    Hunter_job.addData("GHAST", 0.10, 12, 1);
    Hunter_job.addData("ENDERMAN", 0.125, 16, 1);
    Hunter_job.addData("BLAZE", 0.15, 20, 1);
    Hunter_job.addData("ENDER DRAGON", 100.00, 3000, 1);
    Hunter_job.addData("WITHER", 550.00, 7800, 1);
    Hunter_job.setBuffData("Damage dealt increased by 2.",
    		"Sneaking gives you invisibility.", 
    		"Swords gain Fire Aspect II. Movement speed increased by 20%.", 
    		"Damage dealt increased by 4, damage taken decreased by 30%, at night you are invisible. Health increased by 20.");

    Fisherman_job.setJobName("Fisherman");
    Fisherman_job.setJobDescription("A fisherman's job is to catch fish. And more fish. And cook them.");
    Fisherman_job.setAction(0, "CATCH");
    Fisherman_job.setAction(1, "SMELT");
    Fisherman_job.setExp(30, 40, 6, 1.04);
    Fisherman_job.addData("RAW FISH", 0.175, 3, 0);
    Fisherman_job.addData("COOKED FISH", 0.125, 2, 1);
    Fisherman_job.setBuffData("Fishing rods have double the durability.",
    		"Fish give double the exp orbs, two fish can be caught at the same time (25% chance)", 
    		"Up to four fish can be caught at one time. Sometimes fish will be automatically cooked. (Will gain exp and money for the cooked ones as well)", 
    		"Fishing rods do 10 damage when hooking an enemy mob. Fishing rods do not run out of durability. Chance of catching fish increased by 50%. Holding a fishing rod gives the ability to fly for 5 seconds at a time.");
    
    Weaponsmith_job.setJobName("Weaponsmith");
    Weaponsmith_job.setJobDescription("A weaponsmith's job is to craft weapons for others and themselves.");
    Weaponsmith_job.setAction(0, "CRAFT");
    Weaponsmith_job.setExp(100, 100, 32, 1.05);
    Weaponsmith_job.addData("ARROW", 0.025, 4, 0);
    //Weaponsmith_job.addData("WOODEN SWORD", 0.05, 10, 0);
    Weaponsmith_job.addData("FLINT AND STEEL", 0.06, 12, 0);
    Weaponsmith_job.addData("BOW", 0.075, 12, 0);
    Weaponsmith_job.addData("IRON SWORD", 0.375, 75, 0);
    Weaponsmith_job.addData("GOLD SWORD", 0.50, 100, 0);
    Weaponsmith_job.addData("DIAMOND SWORD", 3.60, 280, 0);
    Weaponsmith_job.setBuffData("Crafting Weaponsmith items have a 10% chance of preserving materials used.",
    		"Weapons crafted gain a free level 5 enchantment.", 
    		"Crafting Weaponsmith items have a 25% chance of preserving materials used.", 
    		"Weapons crafted gain free level 25 enchantments. Materials used in crafting have a 50% chance of being preserved. Weapons crafted have a 30% chance of stacking (duplicated), and 30% chance for every extra addition to the weapon stack.");

    Blacksmith_job.setJobName("Blacksmith");
    Blacksmith_job.setJobDescription("A blacksmith's job is to provide tools, armor, and other crafted materials to others and themselves to protect them.");
    Blacksmith_job.setAction(0, "CRAFT");
    Blacksmith_job.setExp(300, 180, 24, 1.06);
    //Blacksmith_job.addData("STONE HOE", 0.04, 7, 0);
    //Blacksmith_job.addData("STONE SHOVEL", 0.05, 8, 0);
    //Blacksmith_job.addData("STONE PICKAXE", 0.075, 15, 0);
    Blacksmith_job.addData("LEATHER BOOTS", 0.125, 8, 0);
    Blacksmith_job.addData("LEATHER CAP", 0.15, 14, 0);
    Blacksmith_job.addData("LEATHER PANTS", 0.175, 15, 0);
    Blacksmith_job.addData("LEATHER TUNIC", 0.20, 18, 0);
    Blacksmith_job.addData("IRON SHOVEL", 0.25, 18, 0);
    Blacksmith_job.addData("IRON HOE", 0.325, 38, 0);
    Blacksmith_job.addData("IRON AXE", 0.35, 40, 0);
    Blacksmith_job.addData("WEAK IRON BOOTS", 0.375, 80, 0);
    Blacksmith_job.addData("IRON PICKAXE", 0.40, 58, 0);
    Blacksmith_job.addData("WEAK IRON HELMET", 0.50, 100, 0);
    Blacksmith_job.addData("GOLDEN SHOVEL", 0.625, 23, 0);
    Blacksmith_job.addData("GOLDEN HOE", 0.65, 65, 0);
    Blacksmith_job.addData("GOLDEN AXE", 0.70, 70, 0);
    Blacksmith_job.addData("WEAK IRON LEGGINGS", 0.725, 140, 0);
    Blacksmith_job.addData("DIAMOND SHOVEL", 0.75, 90, 0);
    Blacksmith_job.addData("DIAMOND HOE", 0.8, 188, 0);
    Blacksmith_job.addData("DIAMOND AXE", 0.81, 196, 0);
    Blacksmith_job.addData("WEAK GOLDEN BOOTS", 0.825, 120, 0);
    Blacksmith_job.addData("WEAK IRON CHESTPLATE", 0.875, 175, 0);
    Blacksmith_job.addData("WEAK GOLDEN HELMET", 0.925, 150, 0);
    Blacksmith_job.addData("DIAMOND PICKAXE", 0.925, 290, 0);
    Blacksmith_job.addData("WEAK DIAMOND BOOTS", 1.0, 390, 0);
    Blacksmith_job.addData("WEAK GOLDEN LEGGINGS", 1.025, 170, 0);
    Blacksmith_job.addData("WEAK GOLDEN CHESTPLATE", 1.15, 192, 0);
    Blacksmith_job.addData("WEAK DIAMOND HELMET", 1.15, 480, 0);
    Blacksmith_job.addData("WEAK DIAMOND LEGGINGS", 1.325, 660, 0);
    Blacksmith_job.addData("WEAK DIAMOND CHESTPLATE", 1.50, 750, 0);
    Blacksmith_job.addData("IRON BOOTS", 0.375*10, 80*10, 0);
    Blacksmith_job.addData("IRON HELMET", 0.50*10, 100*10, 0);
    Blacksmith_job.addData("IRON LEGGINGS", 0.725*10, 140*10, 0);
    Blacksmith_job.addData("GOLDEN BOOTS", 0.825*10, 120*10, 0);
    Blacksmith_job.addData("IRON CHESTPLATE", 0.875*10, 175*10, 0);
    Blacksmith_job.addData("GOLDEN HELMET", 0.925*10, 150*10, 0);
    Blacksmith_job.addData("DIAMOND BOOTS", 1.0*10, 390*10, 0);
    Blacksmith_job.addData("GOLDEN LEGGINGS", 1.025*10, 170*10, 0);
    Blacksmith_job.addData("GOLDEN CHESTPLATE", 1.15*10, 192*10, 0);
    Blacksmith_job.addData("DIAMOND HELMET", 1.15*10, 480*10, 0);
    Blacksmith_job.addData("DIAMOND LEGGINGS", 1.325*10, 660*10, 0);
    Blacksmith_job.addData("DIAMOND CHESTPLATE", 1.50*10, 750*10, 0);
    Blacksmith_job.setBuffData("All crafted items are buffed with a Lv5 enchantment.",
    		"All crafted items are buffed with a Lv10 enchantment.", 
    		"Crafting Blacksmith items have a 30% chance of preserving materials used.", 
    		"All crafted Blacksmith items stack between 2 and 5 of the same item, effectively multiplying the amount you craft. Items are buffed with a Lv20 enchantment and have a 50% chance to be enchanted with a level 30 enchantment.");

    Cook_job.setJobName("Cook");
    Cook_job.setJobDescription("A cook's job is to provide food for others and themselves through cooking and crafting together ingredients.");
    Cook_job.setAction(0, "CRAFT");
    Cook_job.setAction(1, "SMELT");
    Cook_job.setExp(250, 200, 40, 1.04);
    Cook_job.addData("BREAD", 0.003125, 1.25, 0);
    Cook_job.addData("COOKIE", 0.016875, 1.50, 0);
    Cook_job.addData("MUSHROOM SOUP", 0.009375, 3.75, 0);
    Cook_job.addData("PUMPKIN PIE", 0.0375, 15, 0);
    Cook_job.addData("GOLDEN CARROT", 0.0875, 35, 0);
    Cook_job.addData("CAKE", 0.10625, 21.25, 0);
    Cook_job.addData("GOLDEN APPLE", 0.1125, 45, 0);
    Cook_job.addData("COOKED FISH", 0.06, 24, 1);
    Cook_job.addData("BAKED POTATO", 0.08, 32, 1);
    Cook_job.addData("COOKED CHICKEN", 0.09, 36, 1);
    Cook_job.addData("GRILLED PORK", 0.12, 48, 1);
    Cook_job.addData("COOKED BEEF", 0.20, 80, 1);
    Cook_job.setBuffData("Double the amount of cooking time with one fuel item in the furnace.",
    		"Results of crafting food is double the normal amount.", 
    		"Results of cooking food is double the normal amount.", 
    		"Cooking and crafting food gives 4x the normal amount. Cooking and crafting food gives exp orbs and has a chance of giving Golden Apples and Golden Carrots sometimes. (15% per crafted/cooked item.)");

    Brewer_job.setJobName("Brewer");
    Brewer_job.setJobDescription("A brewer's job is to create potions for others and themselves in order to change the outcome of situations.");
    Brewer_job.setAction(0, "BREW");
    Brewer_job.setExp(100, 55, 3, 1.05);
    Brewer_job.addData("SUGAR", 0.01, 2, 0);
    Brewer_job.addData("SPIDER EYE", 0.015, 2, 0);
    Brewer_job.addData("REDSTONE", 0.025, 2, 0);
    Brewer_job.addData("GLOWSTONE DUST", 0.025, 2, 0);
    Brewer_job.addData("GUNPOWDER", 0.03, 2, 0);
    Brewer_job.addData("FERMENTED SPIDER EYE", 0.035, 4, 0);
    Brewer_job.addData("GLISTERING MELON", 0.035, 4, 0);
    Brewer_job.addData("NETHER WART", 0.04, 4, 0);
    Brewer_job.addData("GOLDEN CARROT", 0.05, 5, 0);
    Brewer_job.addData("BLAZE POWDER", 0.05, 6, 0);
    Brewer_job.addData("MAGMA CREAM", 0.075, 8, 0);
    Brewer_job.addData("GHAST TEAR", 0.30, 20, 0);
    Brewer_job.setBuffData("Decrease brewing wait time by half.",
    		"Potions obtained are doubled. (Stacks of two)", 
    		"Potions created by you have double the duration.", 
    		"Potions created by you last for 30 minutes. Potions automatically stack up together in your inventory when grabbed. Splash potions provide full power regardless of how far from the splash the affected entities are. Potions obtained are quadrupled. Brewing wait time decreased by 4x the normal time.");

    Enchanter_job.setJobName("Enchanter");
    Enchanter_job.setJobDescription("An enchanter's job is to enchant items in order to make them more powerful and useful for everyday tasks.");
    Enchanter_job.setAction(0, "ENCHANT");
    Enchanter_job.setExp(90, 50, 15, 1.08);
    Enchanter_job.addExtraData("Each level of enchantment multiplies your income and exp gain exponentially.");
    Enchanter_job.addExtraData("Ex. If PROTECTION gives $0.08 and 4XP, PROTECTION III would give you x9 exp and money: $0.72 and 36XP.");
    Enchanter_job.addExtraData("");
    Enchanter_job.addExtraData("Enchanters also gain some exp and income if job buffs automatically enchant items, such as the Weaponsmith/Blacksmith job. Note this is a very small amount and does not give as much as enchanting an item of your own.");
    Enchanter_job.addData("PROTECTION", 0.08, 4, 0);
    Enchanter_job.addData("SMITE", 0.10, 8, 0);
    Enchanter_job.addData("FIRE PROTECTION", 0.10, 6, 0);
    Enchanter_job.addData("BANE OF ARTHROPODS", 0.12, 8, 0);
    Enchanter_job.addData("FEATHER FALLING", 0.14, 10, 0);
    Enchanter_job.addData("SHARPNESS", 0.15, 14, 0);
    Enchanter_job.addData("POWER", 0.15, 14, 0);
    Enchanter_job.addData("EFFICIENCY", 0.15, 14, 0);
    Enchanter_job.addData("BLAST PROTECTION", 0.20, 16, 0);
    Enchanter_job.addData("THORNS", 0.20, 16, 0);
    Enchanter_job.addData("KNOCKBACK", 0.20, 18, 0);
    Enchanter_job.addData("PUNCH", 0.20, 18, 0);
    Enchanter_job.addData("FIRE ASPECT", 0.22, 20, 0);
    Enchanter_job.addData("FLAME", 0.22, 20, 0);
    Enchanter_job.addData("AQUA AFFINITY", 0.25, 16, 0);
    Enchanter_job.addData("RESPIRATION", 0.30, 20, 0);
    Enchanter_job.addData("UNBREAKING", 0.35, 24, 0);
    Enchanter_job.addData("INFINITY", 0.40, 40, 0);
    Enchanter_job.addData("LOOTING", 0.40, 30, 0);
    Enchanter_job.addData("FORTUNE", 0.50, 40, 0);
    Enchanter_job.addData("SILK TOUCH", 0.50, 40, 0);
    Enchanter_job.setBuffData("Whenever you gain experience, the amount you gain is doubled.",
    		"Enchantments consume 25% less of your exp. (Lv20 enchantment costs 15 levels) Enchantments gain an extra stat enchantment bonus.", 
    		"Enchantments are more potent. (Gain extra enchantments, bonus enchantments, and higher levels than normal.)", 
    		"Enchanters receive quadruple the amount of experience from orbs. Enchanting consumes 75% less of your exp. (Lv20 enchantment costs 5 levels) Enchantments are at least level 5 or higher. Extra bonus enchantments are very likely, and super enchantments are added as well.");

    Breeder_job.setJobName("Breeder");
    Breeder_job.setJobDescription("A breeder's job is to populate and continue to grow animals and make sure there's plenty of animals in the area.");
    Breeder_job.setAction(0, "BREED");
    Breeder_job.setAction(1, "DYE");
    Breeder_job.setAction(2, "SHEAR");
    Breeder_job.setExp(70, 60, 8, 1.03);
    Breeder_job.addExtraData("In areas where there are little to no animals, breeders get 20x the amount of money and xp.");
    Breeder_job.addData("CHICKEN", 0.01, 2, 0);
    Breeder_job.addData("PIG", 0.02, 4, 0);
    Breeder_job.addData("SHEEP", 0.02, 4, 0);
    Breeder_job.addData("COW", 0.03, 4, 0);
    Breeder_job.addData("OCELOT", 0.04, 8, 0);
    Breeder_job.addData("WOLF", 0.06, 10, 0);
    Breeder_job.addData("MUSHROOM COW", 0.20, 16, 0);
    Breeder_job.addData("HORSE", 0.30, 30, 0);
    Breeder_job.addData("SHEEP", 0.02, 2, 1);
    Breeder_job.addData("SHEEP", 0.002, 0.2, 2);
    Breeder_job.addData("MUSHROOM COW", 0.005, 1, 2);
    Breeder_job.setBuffData("Nearby Sheep and Chickens reproduce wool and eggs at double the rate.",
    		"Breeding animals may yield twins and triplets half the time.", 
    		"Feeding animals will give you the item back half the time.", 
    		"Breeding animals will give between 2-5 of that animal, all of them will be grown up. Sheep will always regrow their wool instantly after shearing them, shears do not break. Chickens will give 64 eggs if you kill one. Cows and Pigs drop a stack of meat when killing them. Feeding pigs will give them a saddle.");

    Explorer_job.setJobName("Explorer");
    Explorer_job.setJobDescription("An explorer's job is to explore the whole world looking for new things and checking out places that are unusual.");
    Explorer_job.setAction(0, "TASKS");
    Explorer_job.setExp(400, 80, 20, 1.01);
    Explorer_job.addExtraData("You gain variable amounts of EXP and money for doing various tasks:");
    Explorer_job.addData("Walking Around: ", 0.005, 1, 0);
    Explorer_job.addData("Looking around and being aware of your surroundings: ", 0.01, 2, 0);
    Explorer_job.addData("Interacting with unusual blocks: ", 0.05, 25, 0);
    Explorer_job.addData("Checking out villages, temples, caves, underground areas, the nether: ", 0.50, 50, 0);
    Explorer_job.addData("Load a new region:", 0.00, 6, 0);
    Explorer_job.addData("Creating maps and uncovering new areas on them (Underground rewards more!): ", 0.01, 8, 0);
    Explorer_job.setBuffData("Movement speed increased by 20%.",
    		"Players lose no exp on death. When taking fatal damage, you will regain all health. This effect can be used once every hour.", 
    		"Don't lose any money on death. Reviving costs 75% less.", 
    		"When dying, you only lose 25% of your items. The rest stay in your inventory. Reviving costs 90% less. Teleporting to players costs 75% less. Movement speed increased by 40%. When dying, you will be placed back where you just died. This effect can be used once every hour.");

    Support_job.setJobName("Support");
    Support_job.setJobDescription("A support's job is to provide assistance and keep others alive by providing potions to heal, materials to allow others to craft things, and being useful overall.");
    /*Support_job.setAction(0, "GIVE");
    Support_job.setAction(1, "CRAFT");
    Support_job.setAction(2, "SPLASH");*/
    Support_job.setAction(0, "Supporting Situations");
    Support_job.setExp(100, 100, 5, 1.03);
    Support_job.addExtraData("Give players items to earn some money. Note that if they give it back you lose the xp you gained from it. Setting people on fire will clear all experience you've earned for that level.");
    /*Support_job.addData("TORCH", 0.005, 1, 0);
    Support_job.addData("WOOD", 0.005, 1, 0);
    Support_job.addData("COAL", 0.005, 1, 0);
    Support_job.addData("IRON", 0.005, 1, 0);
    Support_job.addData("POTIONS", 0.005, 1, 0);
    Support_job.addData("FOOD", 0.005, 1, 0);
    Support_job.addData("ARMOR", 0.005, 1, 0);
    Support_job.addData("WEAPONS", 0.005, 1, 0);
    Support_job.addData("FOOD", 0.015, 2, 1);
    Support_job.addData("IRON SWORD", 0.015, 3, 1);
    Support_job.addData("IRON ARMOR", 0.025, 5, 1);
    Support_job.addData("DIAMOND SWORD", 0.075, 8, 1);
    Support_job.addData("POTIONS, SPLASH POTIONS", 0.10, 5, 1);
    Support_job.addData("DIAMOND ARMOR", 0.20, 20, 1);
    Support_job.addData("NIGHT VISION", 0.10, 5, 2);
    Support_job.addData("SPEED", 0.15, 6, 2);
    Support_job.addData("STRENGTH", 0.40, 9, 2);
    Support_job.addData("FIRE RESISTANCE", 0.50, 12, 2);
    Support_job.addData("HEALING", 0.30, 14, 2);*/
    Support_job.addData("-Light up dark areas.", 0.01, 2, 0);
    Support_job.addData("-Help kill things with others.", 0.05, 6, 0);
    Support_job.addData("-Clear out lava areas to allow for safe passage.", 0.15, 60, 0);
    Support_job.addData("-Providing materials that someone ran out of.", 1.05, 90, 0);
    Support_job.addData("-Healing someone when they are low in health.", 2.40, 120, 0);
    Support_job.addData("-Dousing or using a fire resistance potion on someone burning.", 4.80, 240, 0);
    Support_job.setBuffData("Everyone around you gains +2 Armor.",
    		"Everyone around you gains +10 more Maximum Health.", 
    		"Everyone around you gains +4 Armor. Everyone's hunger degrades at half the speed. Players with 8 HP or less take half the damage from hits.", 
    		"Everyone around you gains Regeneration. You gain +10 Armor. Everyone around you gains +20 more Maximum Health. You gain +50 more maximum health. Everyone around you including yourself moves 20% faster.");
  }

  public void onDisable()
  {
	  getConfig().set("server-tick-time", Long.valueOf(SERVER_TICK_TIME));
	  saveConfig();
    PluginDescriptionFile pdf = getDescription();
    System.out.println("[" + pdf.getName() + "] The plugin has been disabled succesfully.");
  }
  

  public void updateTopSPLEEFSigns() {
	  String name[] = {"","",""};
	  int rating[] = {-9999,-9999,-9999}, wins[] = {0,0,0}, losses[] = {0,0,0};
	  //Get list of all players on the server.
	  OfflinePlayer playerlist[] = Bukkit.getOfflinePlayers();
	  for (int i=0;i<playerlist.length;i++) {
		  if (getAccountsConfig().contains(playerlist[i].getName())) {
			  if (getAccountsConfig().contains(playerlist[i].getName()+".spleefrating") && getAccountsConfig().getInt(playerlist[i].getName()+".spleefwins")+getAccountsConfig().getInt(playerlist[i].getName()+".spleeflosses")>=20) {
				  if (getAccountsConfig().getDouble(playerlist[i].getName()+".spleefrating")>rating[0]) {
					  //This beats the top record, move everything down.
					  name[2]=name[1];rating[2]=rating[1];wins[2]=wins[1];losses[2]=losses[1];
					  name[1]=name[0];rating[1]=rating[0];wins[1]=wins[0];losses[1]=losses[0];
					  name[0]=playerlist[i].getName();
					  rating[0]=(int)getAccountsConfig().getDouble(playerlist[i].getName()+".spleefrating");
					  wins[0]=getAccountsConfig().getInt(playerlist[i].getName()+".spleefwins");
					  losses[0]=getAccountsConfig().getInt(playerlist[i].getName()+".spleeflosses");
				  } else
				  if (getAccountsConfig().getDouble(playerlist[i].getName()+".spleefrating")>rating[1]) {
					  //This beats the 2nd record, move everything down.
					  name[2]=name[1];rating[2]=rating[1];wins[2]=wins[1];losses[2]=losses[1];
					  name[1]=playerlist[i].getName();
					  rating[1]=(int)getAccountsConfig().getDouble(playerlist[i].getName()+".spleefrating");
					  wins[1]=getAccountsConfig().getInt(playerlist[i].getName()+".spleefwins");
					  losses[1]=getAccountsConfig().getInt(playerlist[i].getName()+".spleeflosses");
				  } else
				  if (getAccountsConfig().getDouble(playerlist[i].getName()+".spleefrating")>rating[2]) {
					  //This beats the 3rd record, move everything down.
					  name[2]=playerlist[i].getName();
					  rating[2]=(int)getAccountsConfig().getDouble(playerlist[i].getName()+".spleefrating");
					  wins[2]=getAccountsConfig().getInt(playerlist[i].getName()+".spleefwins");
					  losses[2]=getAccountsConfig().getInt(playerlist[i].getName()+".spleeflosses");
				  }
			  }
		  }
	  }
	  Sign sign = (Sign)Bukkit.getWorld("world").getBlockAt(1611,85,42).getState();
	  sign.setLine(0, "");sign.setLine(2, "");sign.setLine(3, "");
	  sign.setLine(1, ChatColor.BOLD+name[0]);
	  sign.update();
	  sign = (Sign)Bukkit.getWorld("world").getBlockAt(1611,84,43).getState();
	  sign.setLine(0, "");sign.setLine(2, "");sign.setLine(3, "");
	  sign.setLine(1, ChatColor.BOLD+"Wins: "+ChatColor.DARK_GREEN+wins[0]);
	  sign.update();
	  sign = (Sign)Bukkit.getWorld("world").getBlockAt(1611,84,41).getState();
	  sign.setLine(0, "");sign.setLine(2, "");sign.setLine(3, "");
	  sign.setLine(1, ChatColor.BOLD+"Losses: "+ChatColor.DARK_GREEN+losses[0]);
	  sign.update();
	  sign = (Sign)Bukkit.getWorld("world").getBlockAt(1612,84,42).getState();
	  sign.setLine(0, "");sign.setLine(2, "");sign.setLine(3, "");
	  sign.setLine(1, ChatColor.BOLD+"RATING: "+ChatColor.DARK_GREEN+rating[0]/10);
	  sign.update();

	  sign = (Sign)Bukkit.getWorld("world").getBlockAt(1611,85,39).getState();
	  sign.setLine(0, ChatColor.BOLD+name[1]);
	  sign.setLine(1, "Rating: "+rating[1]/10);
	  sign.setLine(2, ChatColor.ITALIC+"Wins: "+wins[1]);
	  sign.setLine(3, ChatColor.ITALIC+"Losses: "+losses[1]);
	  sign.update();
	  
	  sign = (Sign)Bukkit.getWorld("world").getBlockAt(1611,84,37).getState();
	  sign.setLine(0, ChatColor.BOLD+name[2]);
	  sign.setLine(1, "Rating: "+rating[2]/10);
	  sign.setLine(2, ChatColor.ITALIC+"Wins: "+wins[2]);
	  sign.setLine(3, ChatColor.ITALIC+"Losses: "+losses[2]);
	  sign.update();
  }

public void runTick() {
  this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new  Runnable(){
		  public void run(){
			SERVER_TICK_TIME++;
			for (int i=0;i<ARROW_SHOOTERS.size();i++) {
				ArrowShooter shooter = ARROW_SHOOTERS.get(i);
				shooter.timer--;
				if ( ( shooter.timer % shooter.frequency )==0) {
					Arrow arrow = Bukkit.getWorld("world").spawnArrow(shooter.loc, shooter.spd, 0.6f, 12f);
					//arrow.setShooter(shooter.shooter);
					List<Entity> arrows = Bukkit.getWorld("world").getEntities();
					for (int j=0;j<arrows.size();j++) {
						if (arrows.get(j).getType()==EntityType.ARROW && arrows.get(j).getTicksLived()>60) {
							//Remove old arrows that have existed long enough. (2 seconds)
							arrows.get(j).remove();
						}
					}
				}
				if (shooter.timer<=0) {
					ARROW_SHOOTERS.remove(i);
					i--;
				}
			}
			for (int i=0;i<TEMP_WEBS.size();i++) {
				TempWeb web = TEMP_WEBS.get(i);
				web.timer--;
				if (web.timer<=0) {
					//Attempt to destroy the block in the world.
					if (Bukkit.getWorld("world").getBlockAt(web.loc).getType()==Material.WEB) {
						Bukkit.getWorld("world").getBlockAt(web.loc).setType(Material.AIR);
					}
					TEMP_WEBS.remove(i);
					i--;
				}
			}
			for (int i=0;i<ninjavisible_list.size();i++) {
				if (Main.SERVER_TICK_TIME>ninjavisible_list.get(i).resettime) {
					//Recloak this ninja if it's still alive.
					List<Entity> entities = Bukkit.getWorld("world").getEntities();
					for (int j=0;j<entities.size();j++) {
						if (entities.get(j).getType()==EntityType.ZOMBIE) {
							if (entities.get(j).getUniqueId()==ninjavisible_list.get(i).val) {
								LivingEntity e = (LivingEntity)entities.get(j);
								e.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 0, true));
								break;
							}
						}
					}
					ninjavisible_list.remove(i);
					i--;
				}
			}
		    //Put your code here...
			//Bukkit.getPlayer("sigonasr2").sendMessage("Server Tick "+Main.SERVER_TICK_TIME);
			  if (POLYMORPH>0) {
				  Bukkit.getWorld("world").playEffect(new Location(POLYMORPH_LOC.getWorld(),POLYMORPH_LOC.getX()+(Math.random()-Math.random())*2,POLYMORPH_LOC.getY()+(Math.random())*2+2,POLYMORPH_LOC.getZ()+(Math.random()-Math.random())*2), Effect.STEP_SOUND, Material.EMERALD_BLOCK);
				  Bukkit.getWorld("world").playEffect(new Location(POLYMORPH_LOC.getWorld(),POLYMORPH_LOC.getX()+(Math.random()-Math.random())*2,POLYMORPH_LOC.getY()+(Math.random())*2+2,POLYMORPH_LOC.getZ()+(Math.random()-Math.random())*2), Effect.STEP_SOUND, Material.WATER);
				  if (POLYMORPH==1) {
					  Bukkit.getWorld("world").playEffect(new Location(POLYMORPH_LOC.getWorld(),POLYMORPH_LOC.getX()+(Math.random()-Math.random())*2,POLYMORPH_LOC.getY()+(Math.random())*2+2,POLYMORPH_LOC.getZ()+(Math.random()-Math.random())*2), Effect.POTION_BREAK, 0);
				  }
				  POLYMORPH--;
			  }
			  if (BOSS_DEFEAT>0) {
				  if (BOSS_DEFEAT%4==0) {
					  Bukkit.getWorld("world").playEffect(BOSS_DEFEAT_LOC.add(Math.random()*5-Math.random()*5, BOSS_DEFEAT/20, Math.random()*5-Math.random()*5), Effect.SMOKE, 0);
				  }
				  if (BOSS_DEFEAT==1) {
					  Bukkit.getWorld("world").playEffect(BOSS_DEFEAT_LOC, Effect.ZOMBIE_DESTROY_DOOR, 0);
				  }
				  BOSS_DEFEAT--;
			  }
			  if (REVIVE_EFFECT>0) {
				  switch (REVIVE_EFFECT) { //starts at 90.
				  	case 90:
				  	case 88:
				  	case 86:
				  	case 84:
				  	case 82:
				  	case 80: {
				  		Bukkit.getWorld("world").playEffect(new Location(REVIVE_EFFECT_LOC.getWorld(),REVIVE_EFFECT_LOC.getX(),REVIVE_EFFECT_LOC.getY()+(90-REVIVE_EFFECT)/2,REVIVE_EFFECT_LOC.getZ()), Effect.MOBSPAWNER_FLAMES, 0);
				  	}break;
				  	case 89:
				  	case 85:
				  	case 79:
				  	case 75:
				  	case 70:
				  	case 65:
				  	case 60:
				  	case 55:
				  	case 50:
				  	case 45:
				  	case 40:
				  	case 35:
				  	case 30:
				  	case 25:
				  	case 20:
				  	case 15:
				  	case 10:
				  	case 5:{
				  		Bukkit.getWorld("world").playEffect(new Location(REVIVE_EFFECT_LOC.getWorld(),REVIVE_EFFECT_LOC.getX()+(Math.random()-Math.random())*2,REVIVE_EFFECT_LOC.getY(),REVIVE_EFFECT_LOC.getZ()+(Math.random()-Math.random())*2), Effect.EXTINGUISH, 0);
				  	}break;
				  	case 87:
				  	case 83:
				  	case 77:
				  	case 72:
				  	case 67:
				  	case 62:
				  	case 57:
				  	case 52:
				  	case 47:
				  	case 42:
				  	case 37:
				  	case 32:
				  	case 27:
				  	case 22:
				  	case 17:
				  	case 12:
				  	case 7: {
				  		Bukkit.getWorld("world").playEffect(new Location(REVIVE_EFFECT_LOC.getWorld(),REVIVE_EFFECT_LOC.getX()+(Math.random()-Math.random())*2,REVIVE_EFFECT_LOC.getY()+(Math.random())*2,REVIVE_EFFECT_LOC.getZ()+(Math.random()-Math.random())*2), Effect.SMOKE, (int)(Math.random()*9));
				  	}break;
				  }
			  	  Bukkit.getWorld("world").playEffect(new Location(REVIVE_EFFECT_LOC.getWorld(),REVIVE_EFFECT_LOC.getX()+(Math.random()-Math.random())*2,REVIVE_EFFECT_LOC.getY()+(Math.random())*2,REVIVE_EFFECT_LOC.getZ()+(Math.random()-Math.random())*2), Effect.STEP_SOUND, Material.BEACON);
				  REVIVE_EFFECT--;
				  //Bukkit.getPlayer("sigonasr2").sendMessage(REVIVE_EFFECT+"");
			  }
			  List<UUID> lineofsight_check = new ArrayList<UUID>();
			  if (Main.SERVER_TICK_TIME%100==0) {
				  //This is for events that occur once every 5 seconds. 
				  List<Entity> world_entities = Bukkit.getWorld("world").getEntities();
				  for (int i=0;i<world_entities.size();i++) {
					  if (world_entities.get(i).getType()==EntityType.WITHER) {
						  Wither l = (Wither)world_entities.get(i);
						  if (l.getMaxHealth()<l.getHealth()+5+(0.2*(l.getMaxHealth()/l.getHealth()))) {
						      DecimalFormat df = new DecimalFormat("#0.0");
							  l.setHealth(l.getHealth()+5+(0.2*(l.getMaxHealth()/l.getHealth())));
							  //Bukkit.broadcastMessage("Healed "+(+5+(0.2*(l.getMaxHealth()/l.getHealth())))+" health. "+df.format(l.getHealth())+"/"+l.getMaxHealth()+" HP");
						  }
					  }
				  }
			  }
			  for (int zx=0;zx<Bukkit.getOnlinePlayers().length;zx++) {
			  Player p = Bukkit.getOnlinePlayers()[zx];
			  //p.sendMessage("That's item slot #"+p.getInventory().getHeldItemSlot());
			  /*
			  if (p.getName().compareTo("sigonasr2")==0) {
				  //Packet61WorldEvent packet = new Packet61WorldEvent(2004, p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ(), 0, false);
				  
				  //((CraftPlayer)t).getHandle().netServerHandler.sendPacket(packet);
				  Bukkit.getWorld("world").playEffect(p.getLocation(), Effect.STEP_SOUND, Material.IRON_BLOCK.getId());
			  }*/
			  //p.removePotionEffect(PotionEffectType.SPEED);
			  //p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 20, true));
			  /*if (last_world_time==0) {
				  last_world_time = Bukkit.getWorld("world").getTime();
			  } else {
				  if (Bukkit.getWorld("world").getTime()-last_world_time>2) {
					  Bukkit.getPlayer("sigonasr2").sendMessage("Previous Time: "+Bukkit.getWorld("world").getTime());
					  Bukkit.getWorld("world").setTime((long) (Bukkit.getWorld("world").getTime()-((Bukkit.getWorld("world").getTime()-last_world_time)/2.0d)));
					  last_world_time = Bukkit.getWorld("world").getTime();
					  Bukkit.getPlayer("sigonasr2").sendMessage("New Time: "+Bukkit.getWorld("world").getTime());
				  }
			  }*/
			  //last_world_time = Main.SERVER_TICK_TIME;
			  if (p.getWorld().getName().compareTo("world")==0) {
				  //Bukkit.getWorld("world").spawnEntity(p.getLocation(), EntityType.EXPERIENCE_ORB);
				  //Bukkit.getWorld("world").dropItemNaturally(p.getLocation(), new ItemStack(Material.DIRT));
				  if (getConfig().getBoolean("halloween-enabled") && Main.SERVER_TICK_TIME%10==0) {
					  //1551,69,275
					  Location testloc = new Location(p.getWorld(),1551,69,-275);
					  if (p.getLocation().distanceSquared(testloc)<900) {
						  //p.sendMessage("In range.");
						  //We are close enough to the sheep pen. Check out the sheep.
						  List<Entity> ents = p.getNearbyEntities(15, 15, 15);
						  for (int i=0;i<ents.size();i++) {
							  if (ents.get(i).getType()!=EntityType.SHEEP) {
								  ents.remove(i);
								  i--;
							  }
						  }
						  boolean colorone=false;
						  for (int i=0;i<ents.size();i++) {
							  //Check all the sheep to see if they are blue. If so, un-toggle it.
							  if (ents.get(i) instanceof Sheep) {
								  Sheep s = (Sheep)ents.get(i);
								  if (s.getColor()==DyeColor.BLUE) {
									  if (Math.random()<=0.80) {
										  int col=(int)(Math.random()*4);
										  switch (col) {
										  	case 0: {s.setColor(DyeColor.WHITE);}break;
										  	case 1: {s.setColor(DyeColor.GRAY);}break;
										  	case 2: {s.setColor(DyeColor.BLACK);}break;
										  	case 3: {s.setColor(DyeColor.ORANGE);}break;
										  }
									  }
								  } else {
									  if (!colorone && Math.random()<=0.005) {
										  s.setColor(DyeColor.BLUE);
										  colorone=true;
									  }
								  }
							  }
						  }
					  }
				  }
				  if (getConfig().getBoolean("halloween-enabled") && Bukkit.getWorld("world").hasStorm() && Main.SERVER_TICK_TIME%20==0) {
					  Item i = null;
					  int item = (int)(Math.random()*4);
					  switch (item) {
					  	case 0: {i=Bukkit.getWorld("world").dropItemNaturally(p.getLocation().add((int)(Math.random()*20)-(int)(Math.random()*20), 256, (int)(Math.random()*20)-(int)(Math.random()*20)),new ItemStack(Material.PUMPKIN));}break;
					  	case 1: {i=Bukkit.getWorld("world").dropItemNaturally(p.getLocation().add((int)(Math.random()*20)-(int)(Math.random()*20), 256, (int)(Math.random()*20)-(int)(Math.random()*20)),new ItemStack(Material.EGG));}break;
					  	case 2: {i=Bukkit.getWorld("world").dropItemNaturally(p.getLocation().add((int)(Math.random()*20)-(int)(Math.random()*20), 256, (int)(Math.random()*20)-(int)(Math.random()*20)),new ItemStack(Material.SUGAR));}break;
					  	case 3: {i=Bukkit.getWorld("world").dropItemNaturally(p.getLocation().add((int)(Math.random()*20)-(int)(Math.random()*20), 256, (int)(Math.random()*20)-(int)(Math.random()*20)),new ItemStack(Material.PUMPKIN_PIE));}break;
					  }
					  i.setTicksLived(3600);
				  }
				  if (Main.SERVER_TICK_TIME%90==0) {
					  for (int i=-15;i<=15;i++) {
						  for (int j=-15;j<=15;j++) {
							  for (int k=-15;k<=15;k++) {
								  if (Bukkit.getWorld("world").getBlockAt(p.getLocation().getBlockX()+i,p.getLocation().getBlockY()+k,p.getLocation().getBlockZ()+j).getType()==Material.MOB_SPAWNER) {
									  int g=0,maxiter=1000;
									  CreatureSpawner spawner = (CreatureSpawner)Bukkit.getWorld("world").getBlockAt(p.getLocation().getBlockX()+i,p.getLocation().getBlockY()+k,p.getLocation().getBlockZ()+j).getState();
									  List<Entity> nearbylist = p.getNearbyEntities(15, 15, 5);
									  List<Entity> nearbylist2 = p.getNearbyEntities(3, 3, 5);
									  for (int l=0;l<nearbylist.size();l++) {
										  if (spawner.getCreatureTypeName().compareToIgnoreCase(nearbylist.get(l).getType().getName())!=0) {
											  nearbylist.remove(l);
											  l--;
										  }
									  }
									  for (int l=0;l<nearbylist2.size();l++) {
										  if (spawner.getCreatureTypeName().compareToIgnoreCase(nearbylist2.get(l).getType().getName())!=0) {
											  nearbylist2.remove(l);
											  l--;
										  }
									  }
									  if (nearbylist.size()>10) {
										  for (int l=0;l<nearbylist.size();l++) {
											  if (Math.random()<=0.5) {
												  nearbylist.get(l).remove();
												  nearbylist.remove(l);
												  l--;
											  }
										  }
									  } 
									  if (nearbylist2.size()<5) {
										  if (Math.random()<=0.2d) {
											  int l=0;
											  while (l<5) {
												  //CreatureSpawner spawner = (CreatureSpawner)Bukkit.getWorld("world").getBlockAt(p.getLocation().getBlockX()+i,p.getLocation().getBlockY()+k,p.getLocation().getBlockZ()+j).getState();
												  Location testloc = new Location(Bukkit.getWorld("world"),spawner.getLocation().getX()+Math.random()*2-Math.random()*2,spawner.getLocation().getY()+Math.random()*5,spawner.getLocation().getZ()+Math.random()*2-Math.random()*2);
												  if (p.getNearbyEntities(15, 15, 5).size()<50 && Bukkit.getWorld("world").getBlockAt(testloc).getType()==Material.AIR || Bukkit.getWorld("world").getBlockAt(testloc).getType()==Material.WEB) {
													  Bukkit.getWorld("world").spawnCreature(testloc,spawner.getCreatureType());
												  }
												  l++;
											  }
										  }
									  }
								  }
								  if (Math.abs(i)<4 && Math.abs(j)<4 && Math.abs(k)<4 &&Bukkit.getWorld("world").getBlockAt(p.getLocation().getBlockX()+i,p.getLocation().getBlockY()+k,p.getLocation().getBlockZ()+j).getType()==Material.COMMAND) {
									  //Bukkit.getWorld("world").getBlockAt(p.getLocation().getBlockX()+i,p.getLocation().getBlockY()+k,p.getLocation().getBlockZ()+j).setType(Material.COBBLESTONE);
									  List<Entity> nearby = p.getNearbyEntities(30, 30, 30);
									  boolean exists=false;
									  for (int m=0;m<nearby.size();m++) {
										  if (nearby.get(m) instanceof LivingEntity) {
											  LivingEntity ev = (LivingEntity)nearby.get(m);
											  if (nearby.get(m).getType()==EntityType.ZOMBIE) {
												  if (ev.getCustomName()!=null && ev.getCustomName().equalsIgnoreCase(ChatColor.DARK_PURPLE+"Charge Zombie III")) {
													  //ev.setTicksLived(0);
													  exists=true;
												  }
											  } else {
												  if (Math.random()<=0.5) {
													  ev.remove();
												  }
											  }
										  }
									  }
									  if (!exists) {
										  //Create an EnderDragon npc for the healthbar.
										  //Create the Charge Zombie III.
										  //Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "npc create Boss --type EnderDragon --at "+(p.getLocation().getBlockX()+i)+":-50:"+(p.getLocation().getBlockZ()+j));
										  LivingEntity zombie = (LivingEntity)Bukkit.getWorld("world").spawnEntity(new Location(p.getWorld(),p.getLocation().getBlockX()+i,p.getLocation().getBlockY()+k+2,p.getLocation().getBlockZ()+j),EntityType.ZOMBIE);
										  LivingEntity enderdragon = (LivingEntity)Bukkit.getWorld("world").spawnEntity(new Location(p.getWorld(),p.getLocation().getBlockX()+i,-250,p.getLocation().getBlockZ()+j),EntityType.ENDER_DRAGON);
										  //Bukkit.getWorld("world").spawn(p.getLocation(), enderdragon.getClass());
										  zombie.setCustomName(ChatColor.DARK_PURPLE+"Charge Zombie III");
										  zombie.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
										  zombie.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
										  zombie.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
										  zombie.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,999999,3));
										  ItemStack sword = new ItemStack(Material.IRON_SWORD);
										  sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
										  zombie.getEquipment().setItemInHand(sword);
										  ItemStack skull = new ItemStack(397);
										  skull.setDurability((short)3);
										  SkullMeta meta = (SkullMeta)skull.getItemMeta();
										  meta.setOwner("MHF_Enderman");
										  skull.setItemMeta(meta);
										  zombie.getEquipment().setHelmet(skull);
										  enderdragon.setCustomName(ChatColor.DARK_PURPLE+"Charge Zombie III");
										  enderdragon.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,127,999999));
										  enderdragon.setMaxHealth(200);
										  enderdragon.setHealth(200);
										  enderdragon.setRemoveWhenFarAway(false);
										  //enderdragon.teleport(new Location(p.getWorld(),p.getLocation().getBlockX()+i,-250,p.getLocation().getBlockZ()+j));
										  //p.sendMessage(ChatColor.DARK_PURPLE+"You feel a dark presence nearby.");
										  Bukkit.getPlayer("sigonasr2").sendMessage("Trigger this.");
										  zombie.setRemoveWhenFarAway(false);
										  zombie.setMaxHealth(300);
										  zombie.setHealth(300);
										  zombie.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,999999,6));
										  zombie.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,999999,0));
										  zombie.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,999999,0));
										  zombie.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,999999,0));
										  zombie.setTicksLived(1);
										  Iterator<EnderDragon> e_list = Bukkit.getWorld("world").getEntitiesByClass(EnderDragon.class).iterator();
										  boolean first=false;
										  while (e_list.hasNext()) {
											  //p.sendMessage("Moving Enderdragon to "+new Location(p.getWorld(),p.getLocation().getBlockX()+i,-50,p.getLocation().getBlockZ()+j));
											  EnderDragon next = e_list.next();
											  if (!first) {
												  first=true;
											  } else {
												  next.remove();
											  }
										  }
									  }
								  }
							  }
						  }
					  }
				  }
				  if (Main.SERVER_TICK_TIME%20==0) {
			    	for (int d=0;d<chunk_queue_list.size();d++) {
			    		if (chunk_queue_list.get(d)==null || !chunk_queue_list.get(d).isLoaded()) {
			    			chunk_queue_list.remove(0);
			    		} else {
			    			break;
			    		}
			    	}
			    	if (chunk_queue_list.size()>0 && chunk_queue_list.get(0).isLoaded() && chunk_queue_list.get(0).getWorld().getName().equalsIgnoreCase("world")) {
			    		//Load up this chunk if it's loaded and check things.
			    		//Attempt to load up the custom chunk.
						List<String> debugmessages = new ArrayList<String>();
						FileConfiguration customchunk = reloadChunksConfig(chunk_queue_list.get(0).getX(), chunk_queue_list.get(0).getZ());
						if (!customchunk.contains("animal-reset2")) {
							customchunk.set("animal-reset2", Long.valueOf(Main.SERVER_TICK_TIME+17280000));
							Chunk c = chunk_queue_list.get(0);
							Random r = new Random();
							  for (int x=0;x<16;x++) {
								  for (int z=0;z<16;z++) {
									  if (r.nextDouble()<=0.000244140625) {
										  Block b = Bukkit.getWorld("world").getBlockAt(x+c.getX()*16,Bukkit.getWorld("world").getHighestBlockYAt(x+c.getX()*16, z+c.getZ()*16),z+c.getZ()*16);
										  if (b.getType()!=Material.WATER && b.getType()!=Material.ICE && b.getType()!=Material.LAVA && !b.getBiome().name().equalsIgnoreCase("ocean") && !b.getBiome().name().equalsIgnoreCase("river")) {
											  if (b.getType()==Material.SNOW || b.getType()==Material.DIRT || b.getType()==Material.SAND || b.getType()==Material.LEAVES || b.getType()==Material.GRASS || b.getType()==Material.GRAVEL || b.getType()==Material.STONE || b.getType()==Material.COBBLESTONE || b.getType()==Material.MYCEL || b.getType()==Material.BROWN_MUSHROOM || b.getType()==Material.RED_MUSHROOM) {
												  if (b.getBiome().name().equalsIgnoreCase("plains")) {
													  //Best place for things to spawn. Any mob type can spawn here.
													  //Choose a mob type randomly.
													  EntityType[] mobs = {EntityType.COW,EntityType.HORSE,EntityType.PIG,EntityType.SHEEP,EntityType.CHICKEN,EntityType.WOLF};
													  int i=(int)(Math.random()*4)+2;
													  EntityType selected = mobs[(int)(mobs.length*Math.random())];
													  ////Bukkit.getLogger().info("Spawned "+i+" "+selected.getName()+" in Biome "+b.getBiome().name()+" for chunk "+e.getChunk().getX()+","+e.getChunk().getZ()+".");
													  debugmessages.add("  Spawned: "+i+" "+selected.getName());
													  while (i>0) {
														  LivingEntity f = (LivingEntity)Bukkit.getWorld("world").spawnEntity(b.getLocation().add(Math.random()*10-Math.random()*10,1,Math.random()*10-Math.random()*10), selected);
														  f.setRemoveWhenFarAway(false); //This should be a permanent mob.
														  i--;
													  }
												  } else {
													  if (b.getBiome().name().equalsIgnoreCase("forest")) {
														  //Wolves can still spawn here. Horses cannot.
														  //Choose a mob type randomly.
														  EntityType[] mobs = {EntityType.COW,EntityType.PIG,EntityType.SHEEP,EntityType.CHICKEN,EntityType.WOLF};
														  int i=(int)(Math.random()*4)+2;
														  EntityType selected = mobs[(int)(mobs.length*Math.random())];
														  ////Bukkit.getLogger().info("Spawned "+i+" "+selected.getName()+" in Biome "+b.getBiome().name()+" for chunk "+e.getChunk().getX()+","+e.getChunk().getZ()+".");
														  debugmessages.add("  Spawned: "+i+" "+selected.getName());
														  while (i>0) {
															  LivingEntity f = (LivingEntity)Bukkit.getWorld("world").spawnEntity(b.getLocation().add(Math.random()*10-Math.random()*10,1,Math.random()*10-Math.random()*10), selected);
															  f.setRemoveWhenFarAway(false); //This should be a permanent mob.
															  i--;
														  }
													  }else {
														  if (b.getBiome().name().equalsIgnoreCase("jungle")) {
															  //Chance to spawn ocelots here.
															  EntityType[] mobs = {EntityType.COW,EntityType.PIG,EntityType.SHEEP,EntityType.CHICKEN,EntityType.OCELOT};
															  int i=(int)(Math.random()*4)+2;
															  EntityType selected = mobs[(int)(mobs.length*Math.random())];
															  ////Bukkit.getLogger().info("Spawned "+i+" "+selected.getName()+" in Biome "+b.getBiome().name()+" for chunk "+e.getChunk().getX()+","+e.getChunk().getZ()+".");
															  debugmessages.add("  Spawned: "+i+" "+selected.getName());
															  while (i>0) {
																  LivingEntity f = (LivingEntity)Bukkit.getWorld("world").spawnEntity(b.getLocation().add(Math.random()*10-Math.random()*10,1,Math.random()*10-Math.random()*10), selected);
																  f.setRemoveWhenFarAway(false); //This should be a permanent mob.
																  i--;
															  }
														  }else {
															  //Choose a mob type randomly.
															  EntityType[] mobs = {EntityType.COW,EntityType.PIG,EntityType.SHEEP,EntityType.CHICKEN};
															  int i=(int)(Math.random()*4)+2;
															  EntityType selected = mobs[(int)(mobs.length*Math.random())];
															  ////Bukkit.getLogger().info("Spawned "+i+" "+selected.getName()+" in Biome "+b.getBiome().name()+" for chunk "+e.getChunk().getX()+","+e.getChunk().getZ()+".");
															  debugmessages.add("  Spawned: "+i+" "+selected.getName());
															  while (i>0) {
																  LivingEntity f = (LivingEntity)Bukkit.getWorld("world").spawnEntity(b.getLocation().add(Math.random()*10-Math.random()*10,1,Math.random()*10-Math.random()*10), selected);
																  f.setRemoveWhenFarAway(false); //This should be a permanent mob.
																  i--;
															  }
														  }
													  }
												  }
											  }
										  }
									  }
									  ////Bukkit.getLogger().info("Biome here is "+b.getBiome().name());
								  }
							  }
						} else {
							//Check the value and regenerate if necessary.
							if (Main.SERVER_TICK_TIME>customchunk.getLong("animal-reset2")) {
								customchunk.set("animal-reset2", Long.valueOf(Main.SERVER_TICK_TIME+17280000));
								Chunk c = chunk_queue_list.get(0);
								Random r = new Random();
								  for (int x=0;x<16;x++) {
									  for (int z=0;z<16;z++) {
										  if (r.nextDouble()<=0.000244140625) {
											  Block b = Bukkit.getWorld("world").getBlockAt(x+c.getX()*16,Bukkit.getWorld("world").getHighestBlockYAt(x+c.getX()*16, z+c.getZ()*16),z+c.getZ()*16);
											  if (b.getType()!=Material.WATER && b.getType()!=Material.ICE && b.getType()!=Material.LAVA && !b.getBiome().name().equalsIgnoreCase("ocean") && !b.getBiome().name().equalsIgnoreCase("river")) {
												  if (b.getType()==Material.SNOW || b.getType()==Material.DIRT || b.getType()==Material.SAND || b.getType()==Material.LEAVES || b.getType()==Material.GRASS || b.getType()==Material.GRAVEL || b.getType()==Material.STONE || b.getType()==Material.COBBLESTONE || b.getType()==Material.MYCEL || b.getType()==Material.BROWN_MUSHROOM || b.getType()==Material.RED_MUSHROOM) {
													  if (b.getBiome().name().equalsIgnoreCase("plains")) {
														  //Best place for things to spawn. Any mob type can spawn here.
														  //Choose a mob type randomly.
														  EntityType[] mobs = {EntityType.COW,EntityType.HORSE,EntityType.PIG,EntityType.SHEEP,EntityType.CHICKEN,EntityType.WOLF};
														  int i=(int)(Math.random()*4)+2;
														  EntityType selected = mobs[(int)(mobs.length*Math.random())];
														  ////Bukkit.getLogger().info("Spawned "+i+" "+selected.getName()+" in Biome "+b.getBiome().name()+" for chunk "+e.getChunk().getX()+","+e.getChunk().getZ()+".");
														  debugmessages.add("  Spawned: "+i+" "+selected.getName());
														  while (i>0) {
															  LivingEntity f = (LivingEntity)Bukkit.getWorld("world").spawnEntity(b.getLocation().add(Math.random()*10-Math.random()*10,1,Math.random()*10-Math.random()*10), selected);
															  f.setRemoveWhenFarAway(false); //This should be a permanent mob.
															  i--;
														  }
													  } else {
														  if (b.getBiome().name().equalsIgnoreCase("forest")) {
															  //Wolves can still spawn here. Horses cannot.
															  //Choose a mob type randomly.
															  EntityType[] mobs = {EntityType.COW,EntityType.PIG,EntityType.SHEEP,EntityType.CHICKEN,EntityType.WOLF};
															  int i=(int)(Math.random()*4)+2;
															  EntityType selected = mobs[(int)(mobs.length*Math.random())];
															  ////Bukkit.getLogger().info("Spawned "+i+" "+selected.getName()+" in Biome "+b.getBiome().name()+" for chunk "+e.getChunk().getX()+","+e.getChunk().getZ()+".");
															  debugmessages.add("  Spawned: "+i+" "+selected.getName());
															  while (i>0) {
																  LivingEntity f = (LivingEntity)Bukkit.getWorld("world").spawnEntity(b.getLocation().add(Math.random()*10-Math.random()*10,1,Math.random()*10-Math.random()*10), selected);
																  f.setRemoveWhenFarAway(false); //This should be a permanent mob.
																  i--;
															  }
														  }else {
															  if (b.getBiome().name().equalsIgnoreCase("jungle")) {
																  //Chance to spawn ocelots here.
																  EntityType[] mobs = {EntityType.COW,EntityType.PIG,EntityType.SHEEP,EntityType.CHICKEN,EntityType.OCELOT};
																  int i=(int)(Math.random()*4)+2;
																  EntityType selected = mobs[(int)(mobs.length*Math.random())];
																  ////Bukkit.getLogger().info("Spawned "+i+" "+selected.getName()+" in Biome "+b.getBiome().name()+" for chunk "+e.getChunk().getX()+","+e.getChunk().getZ()+".");
																  debugmessages.add("  Spawned: "+i+" "+selected.getName());
																  while (i>0) {
																	  LivingEntity f = (LivingEntity)Bukkit.getWorld("world").spawnEntity(b.getLocation().add(Math.random()*10-Math.random()*10,1,Math.random()*10-Math.random()*10), selected);
																	  f.setRemoveWhenFarAway(false); //This should be a permanent mob.
																	  i--;
																  }
															  }else {
																  //Choose a mob type randomly.
																  EntityType[] mobs = {EntityType.COW,EntityType.PIG,EntityType.SHEEP,EntityType.CHICKEN};
																  int i=(int)(Math.random()*4)+2;
																  EntityType selected = mobs[(int)(mobs.length*Math.random())];
																  ////Bukkit.getLogger().info("Spawned "+i+" "+selected.getName()+" in Biome "+b.getBiome().name()+" for chunk "+e.getChunk().getX()+","+e.getChunk().getZ()+".");
																  debugmessages.add("  Spawned: "+i+" "+selected.getName());
																  while (i>0) {
																	  LivingEntity f = (LivingEntity)Bukkit.getWorld("world").spawnEntity(b.getLocation().add(Math.random()*10-Math.random()*10,1,Math.random()*10-Math.random()*10), selected);
																	  f.setRemoveWhenFarAway(false); //This should be a permanent mob.
																	  i--;
																  }
															  }
														  }
													  }
												  }
											  }
										  }
										  ////Bukkit.getLogger().info("Biome here is "+b.getBiome().name());
									  }
								  }
							}
						}
						if (!customchunk.contains("diamond-generate")) {
							customchunk.set("diamond-generate", Boolean.valueOf(true));
							Chunk c = chunk_queue_list.get(0);
							  int adddiamond=0;
							  for (int x=0;x<16;x++) {
								  for (int y=5;y<25;y++) {
									  for (int z=0;z<16;z++) {
										  Block b = Bukkit.getWorld("world").getBlockAt(x+c.getX()*16,y,z+c.getZ()*16);
										  if (b!=null && b.getType()==Material.STONE) {
											  if (Math.random()<=0.000625) {
												  int i=(int)(Math.random()*8.0d)+1;
												  while (i>0) {
													  Block d = c.getBlock(x+(int)(Math.random()*i)-(int)(Math.random()*i), y+(int)(Math.random()*i)-(int)(Math.random()*i), z+(int)(Math.random()*i)-(int)(Math.random()*i));
													  adddiamond++;
													  b.setType(Material.DIAMOND_ORE);
													  i--;
												  }
												  //Make a patch between 1 and 8.
											  }
										  }
									  }
								  }
							  }
							////Bukkit.getLogger().info("Generated "+adddiamond+" new diamonds for chunk "+e.getChunk().getX()+","+e.getChunk().getZ());
							if (adddiamond>0) {
							  debugmessages.add("  Added "+adddiamond+" diamond"+((adddiamond!=1)?"s":"")+".");
							}
						}
						if (!customchunk.contains("limit-ore-generation")) {
							customchunk.set("limit-ore-generation", Boolean.valueOf(true));
							Chunk c = chunk_queue_list.get(0);
							  int removeore=0,totalore=0,newore=0;
							  for (int x=0;x<16;x++) {
								  for (int y=5;y<96;y++) {
									  for (int z=0;z<16;z++) {
										  Block b = Bukkit.getWorld("world").getBlockAt(x+c.getX()*16,y,z+c.getZ()*16);
										  if (b!=null && (b.getType()==Material.COAL_ORE ||
												  b.getType()==Material.IRON_ORE ||
												  b.getType()==Material.GOLD_ORE ||
												  b.getType()==Material.REDSTONE_ORE ||
												  b.getType()==Material.LAPIS_ORE ||
												  b.getType()==Material.DIAMOND_ORE)) {
											  if (Math.random()<=0.60) {
												  removeore++;
												  b.setType(Material.STONE);
												  //Make a patch between 1 and 8.
											  }
											  totalore++;
										  }
									  }
								  }
							  }
							  for (int x=0;x<16;x++) {
								  for (int y=5;y<96;y++) {
									  for (int z=0;z<16;z++) {
										  Block b = Bukkit.getWorld("world").getBlockAt(x+c.getX()*16,y,z+c.getZ()*16);
										  if (b!=null && (b.getType()==Material.COAL_ORE ||
												  b.getType()==Material.IRON_ORE ||
												  b.getType()==Material.GOLD_ORE ||
												  b.getType()==Material.REDSTONE_ORE ||
												  b.getType()==Material.LAPIS_ORE ||
												  b.getType()==Material.DIAMOND_ORE)) {
											  newore++;
										  }
									  }
								  }
							  }
								////Bukkit.getLogger().info("Removed "+removeore+"/"+totalore+" ore for chunk "+e.getChunk().getX()+","+e.getChunk().getZ()+". There are now "+newore+" ores left.");
							  debugmessages.add("  Removed: "+removeore+"/"+totalore+" ores.");
						}
						saveChunksConfig(customchunk, chunk_queue_list.get(0).getX(), chunk_queue_list.get(0).getZ());
						  if (debugmessages.size()>0) {
							  for (int i=0;i<debugmessages.size();i++) {
								  //Bukkit.getLogger().info(debugmessages.get(i));
							  }
							  //Bukkit.getLogger().info(new String(new char[("Chunk "+e.getChunk().getX()+","+e.getChunk().getZ()+" ("+e.getChunk().getX()*16+","+e.getChunk().getZ()*16+")").length()]).replace("\0", "="));
							  //Bukkit.getLogger().info("Chunk "+e.getChunk().getX()+","+e.getChunk().getZ()+" ("+e.getChunk().getX()*16+","+e.getChunk().getZ()*16+")");
						  }
			    	}
			    	
			    	
					  List<Entity> nearby = p.getNearbyEntities(20, 12, 20);
					  //List<Entity> nearby2 = p.getNearbyEntities(10, 6, 10);
					  for (int i=0;i<nearby.size();i++) {
						  //EntityType allowedtypes[] = {EntityType.BAT,EntityType.BLAZE,EntityType.CAVE_SPIDER,EntityType.ENDERMAN,EntityType.GHAST,EntityType.MAGMA_CUBE,EntityType.PIG_ZOMBIE,EntityType.SILVERFISH,EntityType.SLIME,EntityType.SPIDER,EntityType.ZOMBIE,EntityType.SKELETON,EntityType.CREEPER};
						  boolean contains=nearby.get(i) instanceof Monster;
						  if (contains) {
							  LivingEntity l = (LivingEntity)nearby.get(i);
							  if (l.getCustomName()!=null && l.hasLineOfSight(p)) {
									 if (!lineofsight_check.contains(l.getUniqueId())) {
										 l.setCustomNameVisible(true);
										 lineofsight_check.add(l.getUniqueId());
									 }
							  } else {
								 if (!lineofsight_check.contains(l.getUniqueId())) {
									 l.setCustomNameVisible(false);
								 }
							  }
						  }
						  int heightmodifier=0;
						  if (Bukkit.getWorld("world").getHighestBlockYAt(nearby.get(i).getLocation())>=96) {
							  heightmodifier=126;
						  } else {
							  heightmodifier=63;
						  }
						  if (nearby.get(i).getType()==EntityType.CREEPER) {
							  LivingEntity l = (LivingEntity)nearby.get(i);
							  if (l.getCustomName()==null && l.getTicksLived()<6400 && !l.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
								  if (l.getLocation().getY()<=40 && Math.random()<=0.08+((heightmodifier-l.getLocation().getY())*0.01d)) {
									  if (Math.random()<=0.35) {
										  l.setCustomName(ChatColor.YELLOW+"Explosive Creeper");
										  l.setCustomNameVisible(false);
										  //l.setCustomNameVisible(true);
										  l.setMaxHealth(Warning(l.getMaxHealth()*1.25d,1));
									  } else
									  if (Math.random()<=0.15) {
										  l.setCustomName(ChatColor.GOLD+"Explosive Creeper II");
										  l.setCustomNameVisible(false);
										  //l.setCustomNameVisible(true);
										  l.setMaxHealth(Warning(l.getMaxHealth()*1.75d,2));
									  } else
									  if (Math.random()<=0.35) {
										  l.setCustomName(ChatColor.YELLOW+"Destructive Creeper");
										  l.setCustomNameVisible(false);
										  //l.setCustomNameVisible(true);
										  l.setMaxHealth(Warning(l.getMaxHealth()*1.25d,3));
									  } else {
										  l.setCustomName(ChatColor.GOLD+"Destructive Creeper II");
										  l.setCustomNameVisible(false);
										  //l.setCustomNameVisible(true);
										  l.setMaxHealth(Warning(l.getMaxHealth()*1.75d,4));
									  }
									  if (l!=null && l.isValid()) {
										  l.setHealth(Warning(l.getMaxHealth(),20));
									  }
								  }
								  l.setTicksLived(6400);
							  }
						  } else
						  if (nearby.get(i).getType()==EntityType.SPIDER) {
							  LivingEntity l = (LivingEntity)nearby.get(i);
							  if (l.getCustomName()==null && l.getTicksLived()<6400 && !l.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
								  if (Math.random()<=0.08+((heightmodifier-l.getLocation().getY())*0.01d)) {
									  if (Math.random()<=0.35) {
										  l.setCustomName(ChatColor.YELLOW+"Venomous Spider");
										  l.setCustomNameVisible(false);
										  //l.setCustomNameVisible(true);
										  l.setMaxHealth(Warning(l.getMaxHealth(),5));
									  } else
									  if (Math.random()<=0.15) {
										  l.setCustomName(ChatColor.GOLD+"Venomous Spider II");
										  l.setCustomNameVisible(false);
										  //l.setCustomNameVisible(true);
										  l.setMaxHealth(Warning(l.getMaxHealth()*1.5,6));
									  } else
									  if (Math.random()<=0.35) {
										  l.setCustomName(ChatColor.YELLOW+"Snaring Spider");
										  l.setCustomNameVisible(false);
										  //l.setCustomNameVisible(true);
										  l.setMaxHealth(Warning(l.getMaxHealth()*1.5,7));
									  } else {
										  l.setCustomName(ChatColor.GOLD+"Snaring Spider II");
										  l.setCustomNameVisible(false);
										  //l.setCustomNameVisible(true);
										  l.setMaxHealth(Warning(l.getMaxHealth()*2,8));
									  }
									  if (l!=null && l.isValid()) {
										  l.setHealth(Warning(l.getMaxHealth(),21));
									  }
								  }
								  l.setTicksLived(6400);
							  }
						  } else
						  if (nearby.get(i).getType()==EntityType.SKELETON) {
							  LivingEntity l = (LivingEntity)nearby.get(i);
							  if (l.getCustomName()==null && l.getTicksLived()<6400 && !l.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
								  if (Math.random()<=0.10+((heightmodifier-l.getLocation().getY())*0.01d)) {
									  if (Math.random()<=0.85) {
										  l.setCustomName(ChatColor.YELLOW+"Sniper");
										  l.setCustomNameVisible(false);
										  //l.setCustomNameVisible(true);
										  l.setMaxHealth(Warning(l.getMaxHealth()/2,9));
									  } else {
										  l.setCustomName(ChatColor.GOLD+"Sniper II");
										  l.setCustomNameVisible(false);
										  //l.setCustomNameVisible(true);
										  l.setMaxHealth(Warning(l.getMaxHealth()/4,10));
									  }
									  if (l!=null && l.isValid()) {
										  l.setHealth(Warning(l.getMaxHealth(),11));
									  }
								  }
								  l.setTicksLived(6400);
							  }
						  } else
						  if (nearby.get(i).getType()==EntityType.ZOMBIE) {
							  LivingEntity l = (LivingEntity)nearby.get(i);
							  if (l.getCustomName()==null && l.getTicksLived()<6400 && !l.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
								  if (l.getLocation().getY()<=35 && Math.random()<=0.15) {
									  if (Math.random()<=0.85) {
										  l.setCustomName(ChatColor.YELLOW+"Charge Zombie");
										  l.setCustomNameVisible(false);
										  //l.setCustomNameVisible(true);
										  l.setMaxHealth(Warning(l.getMaxHealth()+5,12));
									  } else {
										  l.setCustomName(ChatColor.GOLD+"Charge Zombie II");
										  l.setCustomNameVisible(false);
										  //l.setCustomNameVisible(true);
										  Warning(l,13);
										  if (l!=null && l.isValid()) {
											  l.setMaxHealth(l.getMaxHealth()+20);
										  }
									  }
									  Warning(l,23);
									  if (l!=null && l.isValid()) {
										  l.setMaxHealth(l.getMaxHealth());
									  }
								  } else {
									  if (Math.random()<=0.10+((heightmodifier-l.getLocation().getY())*0.01d)) {
										  if (Math.random()<=0.25) {
											  l.setCustomName(ChatColor.GRAY+"Zombie Ninja");
											  l.setCustomNameVisible(false);
											  l.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 0, true));
											  l.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 2, true));
											  //l.setCustomNameVisible(true);
											  //A Zombie Ninja will not wear armor to stay hidden. But may carry a sword.
											  l.getEquipment().setChestplate(new ItemStack(Material.AIR));
											  l.getEquipment().setBoots(new ItemStack(Material.AIR));
											  l.getEquipment().setLeggings(new ItemStack(Material.AIR));
											  l.getEquipment().setHelmet(new ItemStack(Material.AIR));
											  Zombie g = (Zombie)l;
											  g.setBaby(true);
											  Warning(l,14);
											  if (l!=null && l.isValid()) {
												  l.setMaxHealth(l.getMaxHealth()*0.65d);
												  Warning(l,15);
												  if (l!=null && l.isValid()) {
													  l.setHealth(l.getMaxHealth());
												  }
											  }
										  }
									  }
								  }
								  l.setTicksLived(6400);
							  } else {
								  if (l.getCustomName()!=null && (l.getCustomName().compareTo(ChatColor.YELLOW+"Charge Zombie")==0 || l.getCustomName().compareTo(ChatColor.GOLD+"Charge Zombie II")==0 || l.getCustomName().compareTo(ChatColor.DARK_PURPLE+"Charge Zombie III")==0)) {
									  //Destroy blocks around it.
									  
									  boolean doit=true;
									  if (l.getKiller()!=null && l.getKiller().getLocation().getY()>l.getLocation().getY()) {
										  doit=false;
									  }
									  if (l.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
										  l.removePotionEffect(PotionEffectType.INVISIBILITY);
									  }
									  if (doit) {
										  //Bukkit.getPlayer("sigonasr2").sendMessage("Charge Zombie!");
										  if (l.getCustomName().compareTo(ChatColor.DARK_PURPLE+"Charge Zombie III")==0 && !l.isDead()) {
											  /*//OLD CHARGE ZOMBIE BEHAVIOR. Charge Zombie II now does this weak block destruction.
											  for (int k=-1;k<2;k++) {
												  for (int j=-1;j<2;j++) {
													  Location checkloc = l.getLocation().add(k,1,j);
													  Block bl = Bukkit.getWorld("world").getBlockAt(checkloc);
													  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
														  bl.breakNaturally();
													  }
													  bl = Bukkit.getWorld("world").getBlockAt(checkloc);
													  checkloc = l.getLocation().add(k,2,j);
													  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
														  bl.breakNaturally();
													  }
													  bl = Bukkit.getWorld("world").getBlockAt(checkloc);
													  checkloc = l.getLocation().add(k,0,j);
													  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
														  bl.breakNaturally();
													  }
												  }
											  }*/
											  for (int k=-1;k<2;k++) {
												  for (int j=-1;j<2;j++) {
													  Location checkloc = l.getLocation().add(k,1,j);
													  Block bl = Bukkit.getWorld("world").getBlockAt(checkloc);
													  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
														  bl.breakNaturally();
													  }
													  bl = Bukkit.getWorld("world").getBlockAt(checkloc);
													  checkloc = l.getLocation().add(k,2,j);
													  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
														  bl.breakNaturally();
													  }
													  bl = Bukkit.getWorld("world").getBlockAt(checkloc);
													  checkloc = l.getLocation().add(k,0,j);
													  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
														  bl.breakNaturally();
													  }
													  bl = Bukkit.getWorld("world").getBlockAt(checkloc);
													  checkloc = l.getLocation().add(k,-1,j);
													  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
														  bl.breakNaturally();
													  }
												  }
											  }
										  } else {
											  /*
											  for (int k=-1;k<2;k++) {
												  for (int j=-1;j<2;j++) {
													  Location checkloc = l.getLocation().add(k,1,j);
													  Block bl = Bukkit.getWorld("world").getBlockAt(checkloc);
													  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
														  bl.breakNaturally();
													  }
													  bl = Bukkit.getWorld("world").getBlockAt(checkloc);
													  checkloc = l.getLocation().add(k,2,j);
													  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
														  bl.breakNaturally();
													  }
													  bl = Bukkit.getWorld("world").getBlockAt(checkloc);
													  checkloc = l.getLocation().add(k,0,j);
													  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
														  bl.breakNaturally();
													  }
												  }
											  }*/ //Charge Zombie II's now only break blocks when YOU get hit by them.
											  /*//OLD CHARGE ZOMBIE II BEHAVIOR.
											  for (int k=-2;k<3;k++) {
												  for (int j=-2;j<3;j++) {
													  Location checkloc = l.getLocation().add(k,1,j);
													  Block bl = Bukkit.getWorld("world").getBlockAt(checkloc);
													  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
														  bl.breakNaturally();
													  }
													  bl = Bukkit.getWorld("world").getBlockAt(checkloc);
													  checkloc = l.getLocation().add(k,2,j);
													  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
														  bl.breakNaturally();
													  }
													  bl = Bukkit.getWorld("world").getBlockAt(checkloc);
													  checkloc = l.getLocation().add(k,0,j);
													  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL) {
														  bl.breakNaturally();
													  }
												  }
											  }*/
										  }
									  }
								  }
							  }
						  }
					  }
				  }
			  }
			  if (p.getWorld().getName().compareTo("world_nether")==0) {
				  if (Main.SERVER_TICK_TIME%60==0) {
					  for (int i=-15;i<=15;i++) {
						  for (int j=-15;j<=15;j++) {
							  for (int k=-5;k<=5;k++) {
								  if (Bukkit.getWorld("world_nether").getBlockAt(p.getLocation().getBlockX()+i,p.getLocation().getBlockY()+k,p.getLocation().getBlockZ()+j).getType()==Material.MOB_SPAWNER) {
									  if (Math.random()<=0.5) {
										  CreatureSpawner spawner = (CreatureSpawner)Bukkit.getWorld("world_nether").getBlockAt(p.getLocation().getBlockX()+i,p.getLocation().getBlockY()+k,p.getLocation().getBlockZ()+j).getState();
										  Location testloc = new Location(Bukkit.getWorld("world_nether"),spawner.getLocation().getX()+Math.random()*5,spawner.getLocation().getY()+Math.random()*3,spawner.getLocation().getZ()+Math.random()*5);
										  if (Bukkit.getWorld("world_nether").getBlockAt(testloc).getType()==Material.AIR && Bukkit.getWorld("world_nether").getBlockAt(testloc.add(0,1,0)).getType()==Material.AIR) {
											  Bukkit.getWorld("world_nether").spawnCreature(testloc,spawner.getCreatureType());
										  }
										  Bukkit.getWorld("world_nether").spawnCreature(spawner.getLocation(),spawner.getCreatureType());
									  }
									  
								  }
							  }
						  }
					  }
					  List<Entity> nearby = p.getNearbyEntities(30, 30, 30);
					  try {
						  for (int i=0;i<nearby.size();i++) {
							  if (nearby.get(i).getType()==EntityType.PIG_ZOMBIE) {
								  if (Math.random()<=0.25) {
									  PigZombie pigman = (PigZombie)nearby.get(i);
									  pigman.setAngry(true);
									  //Bukkit.getPlayer("sigonasr2").sendMessage("Pig Zombie angry.");
								  }
							  }
							  if (nearby.get(i).getType()==EntityType.MAGMA_CUBE) {
								  if (Math.random()<=0.05 && last_lava_dump_time<Bukkit.getWorld("world_nether").getFullTime()) {
									  if (Bukkit.getWorld("world_nether").getBlockAt(nearby.get(i).getLocation()).getType()==Material.AIR) {
										  Bukkit.getWorld("world_nether").getBlockAt(nearby.get(i).getLocation()).setType(Material.LAVA);
										  last_lava_dump_time=Bukkit.getWorld("world_nether").getFullTime()+100;
										  //Bukkit.getPlayer("sigonasr2").sendMessage("Magma Cube lava.");
									  }
								  }
							  }
						  }
					  } catch (ConcurrentModificationException ex_e) {
						  Bukkit.getLogger().warning("Could not check nearby entities in the nether.");
					  }
				  }
			  }
			  if (Main.SERVER_TICK_TIME%600==0) {
				  if (turnedon==false && Bukkit.getWorld("world").getTime()>13000) {
					  //Bukkit.getPlayer("sigonasr2").sendMessage("It's night now...");
					  turnedon=true;
					  for (int x=1562;x<1645;x++) {
						  for (int y=64;y<80;y++) {
							  for (int z=-357;z<-211;z++) {
								  Block theblock=Bukkit.getWorld("world").getBlockAt(x,y,z);
								  if (theblock.getType()==Material.REDSTONE_LAMP_OFF) {
									  theblock.setType(Material.REDSTONE_LAMP_ON);
								  }
							  }
						  }
					  }
				  }
				  if (turnedon==true && Bukkit.getWorld("world").getTime()<13000) {
					  turnedon=false;
					  //Bukkit.getPlayer("sigonasr2").sendMessage("It's day now...");
					  for (int x=1562;x<1645;x++) {
						  for (int y=64;y<80;y++) {
							  for (int z=-357;z<-211;z++) {
								  Block theblock=Bukkit.getWorld("world").getBlockAt(x,y,z);
								  if (theblock.getType()==Material.REDSTONE_LAMP_ON) {
									  theblock.setType(Material.REDSTONE_LAMP_OFF);
								  }
							  }
						  }
					  }
				  }
			  }
			  if (Main.SERVER_TICK_TIME%10==0) {
				  if (getConfig().getBoolean("spleef4insession")) {
					  //Check to see if we fall off.
					  if ((p.getLocation().getX()<1585 || p.getLocation().getX()>1600 || p.getLocation().getZ()<24 || p.getLocation().getZ()>39 || p.getLocation().getY()<86.5d) && (
							  (p.getName().compareTo(getConfig().getString("spleefrequesta4player"))==0 || p.getName().compareTo(getConfig().getString("spleefrequestb4player"))==0
							  || p.getName().compareTo(getConfig().getString("spleefrequestc4player"))==0 || p.getName().compareTo(getConfig().getString("spleefrequestd4player"))==0))) {
						  //You lose.
						  //See if we're the winner.
						  int countdead=0; //We're looking for 3.
						  
						  
						  Player winningplayer = p,losingplayer = p;
						  if (getConfig().getString("spleefrequesta4player").compareTo("none")==0) {
							  countdead++;
						  } else {
							  if (getConfig().getString("spleefrequesta4player").compareTo(p.getName())==0) {
								  losingplayer=Bukkit.getPlayer(getConfig().getString("spleefrequesta4player"));
							  } else {
								  winningplayer=Bukkit.getPlayer(getConfig().getString("spleefrequesta4player"));
							  }
						  }
						  if (getConfig().getString("spleefrequestb4player").compareTo("none")==0) {
							  countdead++;
						  } else {
							  if (getConfig().getString("spleefrequestb4player").compareTo(p.getName())==0) {
								  losingplayer=Bukkit.getPlayer(getConfig().getString("spleefrequestb4player"));
							  } else {
								  winningplayer=Bukkit.getPlayer(getConfig().getString("spleefrequestb4player"));
							  }
						  }
						  if (getConfig().getString("spleefrequestc4player").compareTo("none")==0) {
							  countdead++;
						  } else {
							  if (getConfig().getString("spleefrequestc4player").compareTo(p.getName())==0) {
								  losingplayer=Bukkit.getPlayer(getConfig().getString("spleefrequestc4player"));
							  } else {
								  winningplayer=Bukkit.getPlayer(getConfig().getString("spleefrequestc4player"));
							  }
						  }
						  if (getConfig().getString("spleefrequestd4player").compareTo("none")==0) {
							  countdead++;
						  } else {
							  if (getConfig().getString("spleefrequestd4player").compareTo(p.getName())==0) {
								  losingplayer=Bukkit.getPlayer(getConfig().getString("spleefrequestd4player"));
							  } else {
								  winningplayer=Bukkit.getPlayer(getConfig().getString("spleefrequestd4player"));
							  }
						  }
						  if (countdead==2) {
				        		getConfig().set("spleef4insession", Boolean.valueOf(false));
				        		
				        		
				        		
				        		
	
				        		//Stand someplace else when you win.
				        		
				        		
				        		//Losing player has losing player stuff happen.
				        		//This was a player that lost.
								  //Move them out, give them back their stuff.
								  Location newloc = p.getLocation();
								  //Look for the special shovel for the sake of storing it.
								  /*
								  ItemStack[] shovelstack = p.getInventory().getContents();
								  boolean shovelfound=false;
								  ItemStack shovel = shovelstack[0];
								  for (int i=0;i<shovelstack.length;i++) {
									  if (shovelstack[i]!=null && shovelstack[i].getItemMeta().hasDisplayName()==true && shovelstack[i].getItemMeta().getDisplayName().compareTo("Spleef Wooden Shovel")==0) {
										  //We found the shovel!
										  //Bukkit.getPlayer("sigonasr2").sendMessage("Found shovel in inventory.");
										  shovelfound=true;
										  shovel=shovelstack[i];
										  break;
									  }
								  }
								  store_shovel = shovel;
								  */
								  p.getInventory().clear();
								  p.getInventory().clear(p.getInventory().getHeldItemSlot());
								  //Give inventories back.
								  if (getConfig().getString("spleefrequesta4player").compareTo(p.getName())==0) {
									  for (int i=0;i<spleef4_inventory_a.length;i++) {
										  if (spleef4_inventory_a[i]!=null) {
										  p.getInventory().addItem(spleef4_inventory_a[i]);
										  }
									  }
									  getConfig().set("spleefrequesta4player",String.valueOf("none"));
								  } else
								  if (getConfig().getString("spleefrequestb4player").compareTo(p.getName())==0) {
									  for (int i=0;i<spleef4_inventory_b.length;i++) {
										  if (spleef4_inventory_b[i]!=null) {
										  p.getInventory().addItem(spleef4_inventory_b[i]);
										  }
									  }
									  getConfig().set("spleefrequestb4player",String.valueOf("none"));
								  } else
								  if (getConfig().getString("spleefrequestc4player").compareTo(p.getName())==0) {
									  for (int i=0;i<spleef4_inventory_c.length;i++) {
										  if (spleef4_inventory_c[i]!=null) {
										  p.getInventory().addItem(spleef4_inventory_c[i]);
										  }
									  }
									  getConfig().set("spleefrequestc4player",String.valueOf("none"));
								  } else
								  if (getConfig().getString("spleefrequestd4player").compareTo(p.getName())==0) {
									  for (int i=0;i<spleef4_inventory_d.length;i++) {
										  if (spleef4_inventory_d[i]!=null) {
										  p.getInventory().addItem(spleef4_inventory_d[i]);
										  }
									  }
									  getConfig().set("spleefrequestd4player",String.valueOf("none"));
								  }
								  Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+p.getName()+" fell out of the arena and is out of the match!");
								  
	
								  newloc = winningplayer.getLocation();
								  newloc.setX(1583);
								  newloc.setY(91);
								  newloc.setZ(31.5);
								  winningplayer.teleport(newloc);
								  //Look for the special shovel for the sake of storing it.
								  /*
								  shovelstack = winningplayer.getInventory().getContents();
								  shovelfound=false;
								  shovel = shovelstack[0];
								  for (int i=0;i<shovelstack.length;i++) {
									  if (shovelstack[i]!=null && shovelstack[i].getItemMeta().hasDisplayName()==true && shovelstack[i].getItemMeta().getDisplayName().compareTo("Spleef Wooden Shovel")==0) {
										  //We found the shovel!
										  //Bukkit.getPlayer("sigonasr2").sendMessage("Found shovel in inventory.");
										  shovelfound=true;
										  shovel=shovelstack[i];
										  break;
									  }
								  }
								  store_shovel = shovel;*/
								  winningplayer.getInventory().clear();
								  winningplayer.getInventory().clear(winningplayer.getInventory().getHeldItemSlot());
								  //Give inventories back.
								  if (getConfig().getString("spleefrequesta4player").compareTo(winningplayer.getName())==0) {
									  for (int i=0;i<spleef4_inventory_a.length;i++) {
										  if (spleef4_inventory_a[i]!=null) {
											  winningplayer.getInventory().addItem(spleef4_inventory_a[i]);
										  }
									  }
									  getConfig().set("spleefrequesta4player",String.valueOf("none"));
								  } else
								  if (getConfig().getString("spleefrequestb4player").compareTo(winningplayer.getName())==0) {
									  for (int i=0;i<spleef4_inventory_b.length;i++) {
										  if (spleef4_inventory_b[i]!=null) {
											  winningplayer.getInventory().addItem(spleef4_inventory_b[i]);
										  }
									  }
									  getConfig().set("spleefrequestb4player",String.valueOf("none"));
								  } else
								  if (getConfig().getString("spleefrequestc4player").compareTo(winningplayer.getName())==0) {
									  for (int i=0;i<spleef4_inventory_c.length;i++) {
										  if (spleef4_inventory_c[i]!=null) {
											  winningplayer.getInventory().addItem(spleef4_inventory_c[i]);
										  }
									  }
									  getConfig().set("spleefrequestc4player",String.valueOf("none"));
								  } else
								  if (getConfig().getString("spleefrequestd4player").compareTo(winningplayer.getName())==0) {
									  for (int i=0;i<spleef4_inventory_d.length;i++) {
										  if (spleef4_inventory_d[i]!=null) {
											  winningplayer.getInventory().addItem(spleef4_inventory_d[i]);
										  }
									  }
									  getConfig().set("spleefrequestd4player",String.valueOf("none"));
								  }
								  /*
								  Location l1 = new Location(Bukkit.getWorld("world"), 1593, 85, 29);
								  Chest c=(Chest)Bukkit.getWorld("world").getBlockAt(l1).getState();
								  shovelstack = c.getBlockInventory().getContents();
								  shovelfound=false;
								  shovel = shovelstack[0];
								  for (int i=0;i<shovelstack.length;i++) {
									  if (shovelstack[i]!=null && shovelstack[i].getItemMeta().hasDisplayName()==true && shovelstack[i].getItemMeta().getDisplayName().compareTo("Spleef Wooden Shovel")==0) {
										  //We found the shovel!
										  //Bukkit.getPlayer("sigonasr2").sendMessage("Found shovel in inventory.");
										  shovelfound=true;
										  shovel=shovelstack[i];
										  store_shovel = shovel;
										  break;
									  }
								  }
								  l1 = new Location(Bukkit.getWorld("world"), 1593, 85, 34);
								  c=(Chest)Bukkit.getWorld("world").getBlockAt(l1).getState();
								  shovelstack = c.getBlockInventory().getContents();
								  shovelfound=false;
								  shovel = shovelstack[0];
								  for (int i=0;i<shovelstack.length;i++) {
									  if (shovelstack[i]!=null && shovelstack[i].getItemMeta().hasDisplayName()==true && shovelstack[i].getItemMeta().getDisplayName().compareTo("Spleef Wooden Shovel")==0) {
										  //We found the shovel!
										  //Bukkit.getPlayer("sigonasr2").sendMessage("Found shovel in inventory.");
										  shovelfound=true;
										  shovel=shovelstack[i];
										  store_shovel = shovel;
										  break;
									  }
								  }
								  l1 = new Location(Bukkit.getWorld("world"), 1593, 85, 29);
								  c=(Chest)Bukkit.getWorld("world").getBlockAt(l1).getState();
								  if (!c.getBlockInventory().contains(store_shovel)) {
									  c.getBlockInventory().setItem((int)(Math.random()*27.0d), store_shovel);
								  }
								  l1 = new Location(Bukkit.getWorld("world"), 1593, 85, 34);
								  c=(Chest)Bukkit.getWorld("world").getBlockAt(l1).getState();
								  if (!c.getBlockInventory().contains(store_shovel)) {
									  c.getBlockInventory().setItem((int)(Math.random()*27.0d), store_shovel);
								  }
								  */
								  Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+winningplayer.getName()+"["+(int)getAccountsConfig().getDouble(winningplayer.getName()+".spleefrating")/10+"] is the winner of this 4-player spleef game!");
								  getConfig().set("spleeflastrequesttime",Double.valueOf(0.0d));
				        		getConfig().set("spleefrequesta4player", String.valueOf("none"));
				        		getConfig().set("spleefrequestb4player", String.valueOf("none"));
				        		getConfig().set("spleefrequestc4player", String.valueOf("none"));
				        		getConfig().set("spleefrequestd4player", String.valueOf("none"));
						  } else
						  {
							  //This was a player that lost.
							  //Move them out, give them back their stuff.
							  Location newloc = p.getLocation();
							  newloc.setX(1583);
							  newloc.setY(91);
							  newloc.setZ(31.5);
							  p.teleport(newloc);
							  /*
							  //Look for the special shovel for the sake of storing it.
							  ItemStack[] shovelstack = p.getInventory().getContents();
							  boolean shovelfound=false;
							  ItemStack shovel = shovelstack[0];
							  for (int i=0;i<shovelstack.length;i++) {
								  if (shovelstack[i]!=null && shovelstack[i].getItemMeta().hasDisplayName()==true && shovelstack[i].getItemMeta().getDisplayName().compareTo("Spleef Wooden Shovel")==0) {
									  //We found the shovel!
									  //Bukkit.getPlayer("sigonasr2").sendMessage("Found shovel in inventory.");
									  shovelfound=true;
									  shovel=shovelstack[i];
									  break;
								  }
							  }
							  store_shovel = shovel;*/
							  p.getInventory().clear();
							  p.getInventory().clear(p.getInventory().getHeldItemSlot());
							  //Give inventories back.
							  if (getConfig().getString("spleefrequesta4player").compareTo(p.getName())==0) {
								  for (int i=0;i<spleef4_inventory_a.length;i++) {
									  if (spleef4_inventory_a[i]!=null) {
									  p.getInventory().addItem(spleef4_inventory_a[i]);
									  }
								  }
								  getConfig().set("spleefrequesta4player",String.valueOf("none"));
							  } else
							  if (getConfig().getString("spleefrequestb4player").compareTo(p.getName())==0) {
								  for (int i=0;i<spleef4_inventory_b.length;i++) {
									  if (spleef4_inventory_b[i]!=null) {
									  p.getInventory().addItem(spleef4_inventory_b[i]);
									  }
								  }
								  getConfig().set("spleefrequestb4player",String.valueOf("none"));
							  } else
							  if (getConfig().getString("spleefrequestc4player").compareTo(p.getName())==0) {
								  for (int i=0;i<spleef4_inventory_c.length;i++) {
									  if (spleef4_inventory_c[i]!=null) {
									  p.getInventory().addItem(spleef4_inventory_c[i]);
									  }
								  }
								  getConfig().set("spleefrequestc4player",String.valueOf("none"));
							  } else
							  if (getConfig().getString("spleefrequestd4player").compareTo(p.getName())==0) {
								  for (int i=0;i<spleef4_inventory_d.length;i++) {
									  if (spleef4_inventory_d[i]!=null) {
									  p.getInventory().addItem(spleef4_inventory_d[i]);
									  }
								  }
								  getConfig().set("spleefrequestd4player",String.valueOf("none"));
							  }
							  Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+p.getName()+" fell out of the arena and is out of the match!");
							  
						  }
					  }
					  //Check to see if we are a player in spleef.
					  if (getConfig().getString("spleefrequesta4player").compareTo(p.getName())==0 ||
							  getConfig().getString("spleefrequestb4player").compareTo(p.getName())==0 ||
							  getConfig().getString("spleefrequestc4player").compareTo(p.getName())==0 ||
							  getConfig().getString("spleefrequestd4player").compareTo(p.getName())==0) {
						  //If they are holding something, remove it.
						  if (p.getItemInHand()!=null) {
							  p.getInventory().remove(p.getInventory().getHeldItemSlot());
						  }
					  }
				  }
				  
				  if (getConfig().getBoolean("spleefinsession") && (p.getName().compareTo(getConfig().getString("spleefrequestaplayer"))==0 || p.getName().compareTo(getConfig().getString("spleefrequestbplayer"))==0)) {
					  //Determine if we're still playing.
					  int blockwinner=0;
					  if (getConfig().getString("spleefrequestaplayer").compareTo(p.getName())==0 ||
							  getConfig().getString("spleefrequestbplayer").compareTo(p.getName())==0) {
						  //If they are holding something, remove it.
						  if (p.getItemInHand()!=null) {
							  p.getInventory().remove(p.getInventory().getHeldItemSlot());
						  }
					  }
					  if (p.getPlayerTime()-spleef_last_broken_block>=400) {
						  //WE have come to a standstill. Pick winner based on who has more blocks.
						  int player_a_blocks=0,player_b_blocks=0;
						  for (int i=Bukkit.getPlayer(getConfig().getString("spleefrequestaplayer")).getLocation().getBlockX()-4;i<Bukkit.getPlayer(getConfig().getString("spleefrequestaplayer")).getLocation().getBlockX()+4;i++) {
							  for (int j=Bukkit.getPlayer(getConfig().getString("spleefrequestaplayer")).getLocation().getBlockZ()-4;j<Bukkit.getPlayer(getConfig().getString("spleefrequestaplayer")).getLocation().getBlockZ()+4;j++) {
								  if (Bukkit.getWorld("world").getBlockAt(i,86,j).getType()==Material.DIRT) {
									  player_a_blocks+=1;
								  }
							  }
						  }
						  for (int i=Bukkit.getPlayer(getConfig().getString("spleefrequestbplayer")).getLocation().getBlockX()-4;i<Bukkit.getPlayer(getConfig().getString("spleefrequestbplayer")).getLocation().getBlockX()+4;i++) {
							  for (int j=Bukkit.getPlayer(getConfig().getString("spleefrequestbplayer")).getLocation().getBlockZ()-4;j<Bukkit.getPlayer(getConfig().getString("spleefrequestbplayer")).getLocation().getBlockZ()+4;j++) {
								  if (Bukkit.getWorld("world").getBlockAt(i,86,j).getType()==Material.DIRT) {
									  player_b_blocks+=1;
								  }
							  }
						  }
						  Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+"No blocks were destroyed in 20 seconds. The match's victor was determined by the player with the most block area around them.");
						  if (player_a_blocks>player_b_blocks) {
							  blockwinner=1;
						  } else {
							  blockwinner=2;
						  }
					  } else 
					  if ((p.getLocation().getY()<86.5d || p.getLocation().getZ()<52.0d || p.getLocation().getZ()>65.0d || p.getLocation().getX()>1628.0d || p.getLocation().getX()<1615.0d) || blockwinner!=0) {
						  //We lose. Other player wins.
						  getConfig().set("spleefinsession", Boolean.valueOf(false));
						  //Find out if we're player A, or player B.
						  Player winningplayer,losingplayer;
						  if (p.getName().compareTo(getConfig().getString("spleefrequestaplayer"))==0 || blockwinner==2) {
							  //We're player A.
							  //Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+getConfig().getString("spleefrequestbplayer")+" is the winner of this spleef game! "+getConfig().getString("spleefrequestaplayer")+" loses.");
							  losingplayer=p;
							  winningplayer=Bukkit.getPlayer(getConfig().getString("spleefrequestbplayer"));
	
							  double val1,val2,value,newval1,newval2;
							  if (getAccountsConfig().contains(winningplayer.getName()+".spleefrating")) {
								  val1 = getAccountsConfig().getDouble(winningplayer.getName()+".spleefrating");
							  } else {
								  val1 = 1000.0d;
							  }
							  if (getAccountsConfig().contains(losingplayer.getName()+".spleefrating")) {
								  val2 = getAccountsConfig().getDouble(losingplayer.getName()+".spleefrating");
							  } else {
								  val2 = 1000.0d;
							  }
							  value = 1.0d/(1.0d+Math.pow(10.0d, ((val2-val1)/400.0d)));
							  if (getAccountsConfig().contains(winningplayer.getName()+".spleefwins")) {
								  getAccountsConfig().set(winningplayer.getName()+".spleefwins", Integer.valueOf(getAccountsConfig().getInt(winningplayer.getName()+".spleefwins")+1));
							  } else {
								  getAccountsConfig().set(winningplayer.getName()+".spleefwins", Integer.valueOf(1));
							  }
							  if (getAccountsConfig().contains(winningplayer.getName()+".spleeflosses")) {
								  getAccountsConfig().set(winningplayer.getName()+".spleeflosses", Integer.valueOf(getAccountsConfig().getInt(winningplayer.getName()+".spleeflosses")));
							  } else {
								  getAccountsConfig().set(winningplayer.getName()+".spleeflosses", Integer.valueOf(0));
							  }
							  if (getAccountsConfig().contains(losingplayer.getName()+".spleefwins")) {
								  getAccountsConfig().set(losingplayer.getName()+".spleefwins", Integer.valueOf(getAccountsConfig().getInt(losingplayer.getName()+".spleefwins")));
							  } else {
								  getAccountsConfig().set(losingplayer.getName()+".spleefwins", Integer.valueOf(0));
							  }
							  if (getAccountsConfig().contains(losingplayer.getName()+".spleeflosses")) {
								  getAccountsConfig().set(losingplayer.getName()+".spleeflosses", Integer.valueOf(getAccountsConfig().getInt(losingplayer.getName()+".spleeflosses")+1));
							  } else {
								  getAccountsConfig().set(losingplayer.getName()+".spleeflosses", Integer.valueOf(1));
							  }
							  newval1 = (val1+Math.round(((50.0d/((getAccountsConfig().getDouble(winningplayer.getName()+".spleefwins")+getAccountsConfig().getDouble(winningplayer.getName()+".spleeflosses"))/20.0d))*(1.0d-value))));
							  newval2 = (val2+Math.round(((50.0d/((getAccountsConfig().getDouble(losingplayer.getName()+".spleefwins")+getAccountsConfig().getDouble(losingplayer.getName()+".spleeflosses"))/20.0d))*(0.0d-value))));
							  getAccountsConfig().set(winningplayer.getName()+".spleefrating",Double.valueOf(newval1));
							  getAccountsConfig().set(losingplayer.getName()+".spleefrating",Double.valueOf(newval2));
							  Location newloc = winningplayer.getLocation();
	
							  Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+getConfig().getString("spleefrequestbplayer")+"["+(int)newval1/10+"] is the winner of this spleef game! "+getConfig().getString("spleefrequestaplayer")+"["+(int)newval2/10+"] loses.");
							  newloc.setX(1622.5d);
							  newloc.setY(87.0d);
							  newloc.setZ(51.65d);
							  winningplayer.teleport(newloc);
							  updateTopSPLEEFSigns();
							  saveAccountsConfig();
						  } else {
							  //We're player B.
							  //Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+getConfig().getString("spleefrequestaplayer")+" is the winner of this spleef game! "+getConfig().getString("spleefrequestbplayer")+" loses.");
							  losingplayer=p;
							  winningplayer=Bukkit.getPlayer(getConfig().getString("spleefrequestaplayer"));
							  double val1,val2,value,newval1,newval2;
							  if (getAccountsConfig().contains(winningplayer.getName()+".spleefrating")) {
								  val1 = getAccountsConfig().getDouble(winningplayer.getName()+".spleefrating");
							  } else {
								  val1 = 1000.0d;
							  }
							  if (getAccountsConfig().contains(losingplayer.getName()+".spleefrating")) {
								  val2 = getAccountsConfig().getDouble(losingplayer.getName()+".spleefrating");
							  } else {
								  val2 = 1000.0d;
							  }
							  value = 1.0d/(1.0d+Math.pow(10.0d, ((val2-val1)/400.0d)));
							  if (getAccountsConfig().contains(winningplayer.getName()+".spleefwins")) {
								  getAccountsConfig().set(winningplayer.getName()+".spleefwins", Integer.valueOf(getAccountsConfig().getInt(winningplayer.getName()+".spleefwins")+1));
							  } else {
								  getAccountsConfig().set(winningplayer.getName()+".spleefwins", Integer.valueOf(1));
							  }
							  if (getAccountsConfig().contains(winningplayer.getName()+".spleeflosses")) {
								  getAccountsConfig().set(winningplayer.getName()+".spleeflosses", Integer.valueOf(getAccountsConfig().getInt(winningplayer.getName()+".spleeflosses")));
							  } else {
								  getAccountsConfig().set(winningplayer.getName()+".spleeflosses", Integer.valueOf(0));
							  }
							  if (getAccountsConfig().contains(losingplayer.getName()+".spleefwins")) {
								  getAccountsConfig().set(losingplayer.getName()+".spleefwins", Integer.valueOf(getAccountsConfig().getInt(losingplayer.getName()+".spleefwins")));
							  } else {
								  getAccountsConfig().set(losingplayer.getName()+".spleefwins", Integer.valueOf(0));
							  }
							  if (getAccountsConfig().contains(losingplayer.getName()+".spleeflosses")) {
								  getAccountsConfig().set(losingplayer.getName()+".spleeflosses", Integer.valueOf(getAccountsConfig().getInt(losingplayer.getName()+".spleeflosses")+1));
							  } else {
								  getAccountsConfig().set(losingplayer.getName()+".spleeflosses", Integer.valueOf(1));
							  }
							  newval1 = ((val1+Math.round((50.0d/((getAccountsConfig().getDouble(winningplayer.getName()+".spleefwins")+getAccountsConfig().getDouble(winningplayer.getName()+".spleeflosses"))/20.0d))*(1.0d-value))));
							  newval2 = ((val2+Math.round((50.0d/((getAccountsConfig().getDouble(losingplayer.getName()+".spleefwins")+getAccountsConfig().getDouble(losingplayer.getName()+".spleeflosses"))/20.0d))*(0.0d-value))));
							  getAccountsConfig().set(winningplayer.getName()+".spleefrating",Double.valueOf(newval1));
							  getAccountsConfig().set(losingplayer.getName()+".spleefrating",Double.valueOf(newval2));
							  Location newloc = winningplayer.getLocation();
	
							  Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+getConfig().getString("spleefrequestaplayer")+"["+(int)newval1/10+"] is the winner of this spleef game! "+getConfig().getString("spleefrequestbplayer")+"["+(int)newval2/10+"] loses.");
							  newloc.setX(1622.5d);
							  newloc.setY(87.0d);
							  newloc.setZ(51.65d);
							  winningplayer.teleport(newloc);
							  updateTopSPLEEFSigns();
							  saveAccountsConfig();
						  }
						  //Look for the special shovel.
						  /*
						  ItemStack[] shovelstack = Bukkit.getPlayer(getConfig().getString("spleefrequestaplayer")).getInventory().getContents();
						  boolean shovelfound=false;
						  ItemStack shovel = shovelstack[0];
						  Bukkit.getPlayer("sigonasr2").sendMessage("Starting shovel check.");
						  for (int i=0;i<shovelstack.length;i++) {
							  if (shovelstack[i]!=null && shovelstack[i].getItemMeta().hasDisplayName()==true && shovelstack[i].getItemMeta().getDisplayName().compareTo("Spleef Wooden Shovel")==0) {
								  //We found the shovel!
								  //Bukkit.getPlayer("sigonasr2").sendMessage("Found shovel in inventory.");
								  shovelfound=true;
								  shovel=shovelstack[i];
								  break;
							  }
						  }
						  shovelstack = Bukkit.getPlayer(getConfig().getString("spleefrequestbplayer")).getInventory().getContents();
						  //Bukkit.getPlayer("sigonasr2").sendMessage("Next shovel inventory check.");
						  if (!shovelfound) {
							  for (int i=0;i<shovelstack.length;i++) {
								  if (shovelstack[i]!=null && shovelstack[i].getItemMeta().hasDisplayName()==true && shovelstack[i].getItemMeta().getDisplayName().compareTo("Spleef Wooden Shovel")==0) {
									  //We found the shovel!
									  //Bukkit.getPlayer("sigonasr2").sendMessage("Found shovel in inventory.");
									  shovelfound=true;
									  shovel=shovelstack[i];
									  break;
								  }
							  }
						  }
						  if (shovelfound) {
							  //Bukkit.getPlayer("sigonasr2").sendMessage("Found a shovel, transporting in chest box.");
							  Location l1 = new Location(Bukkit.getWorld("world"), 1622, 85, 58);
							  Chest c=(Chest)Bukkit.getWorld("world").getBlockAt(l1).getState();
							  c.getBlockInventory().setItem((int)(Math.random()*27.0d), shovel);
						  }*/
						  Bukkit.getPlayer(getConfig().getString("spleefrequestaplayer")).getInventory().clear();
						  Bukkit.getPlayer(getConfig().getString("spleefrequestbplayer")).getInventory().clear();
							Bukkit.getPlayer(getConfig().getString("spleefrequestaplayer")).getInventory().clear(Bukkit.getPlayer(getConfig().getString("spleefrequestaplayer")).getInventory().getHeldItemSlot());
							Bukkit.getPlayer(getConfig().getString("spleefrequestbplayer")).getInventory().clear(Bukkit.getPlayer(getConfig().getString("spleefrequestbplayer")).getInventory().getHeldItemSlot());
						  //Give inventories back.
						  for (int i=0;i<spleef_inventory_a.length;i++) {
							  if (spleef_inventory_a[i]!=null) {
							  Bukkit.getPlayer(getConfig().getString("spleefrequestaplayer")).getInventory().addItem(spleef_inventory_a[i]);
							  }
						  }
						  for (int i=0;i<spleef_inventory_b.length;i++) {
							  if (spleef_inventory_b[i]!=null) {
							  Bukkit.getPlayer(getConfig().getString("spleefrequestbplayer")).getInventory().addItem(spleef_inventory_b[i]);
							  }
						  }
							//Bukkit.getPlayer(getConfig().getString("spleefrequestaplayer")).updateInventory();
							//Bukkit.getPlayer(getConfig().getString("spleefrequestbplayer")).updateInventory();
					  }
				  } else {
					  if (getConfig().getBoolean("spleefinsession") && (p.getName().compareTo(getConfig().getString("spleefrequestaplayer"))!=0 && p.getName().compareTo(getConfig().getString("spleefrequestbplayer"))!=0)) {
						  if (p.getLocation().getY()>78.0d && p.getLocation().getZ()>53.0d && p.getLocation().getZ()<64.0d && p.getLocation().getX()<1627.0d && p.getLocation().getX()>1616.0d) {
							  Location newloc = p.getLocation();
							  newloc.setX(1622.5d);
							  newloc.setY(87.0d);
							  newloc.setZ(51.65d);
							  p.teleport(newloc);
							  p.sendMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+"You are a spectator! What are you thinking?!");
						  }
					  }
				  }
			  }
			  }
		  }
	  }, 1l, 1l);
}

public String healthbar(double curHP,double maxHP) {
	  //笆�笆�
	  int bits=(int)(Math.ceil(curHP/maxHP*10));
	  String bar=" ";
	  if (bits>6) {
		  bar+=ChatColor.GREEN+"";
	  } else
	  if (bits>3) {
		  bar+=ChatColor.YELLOW+"";
	  } else
	  {
		  bar+=ChatColor.RED+"";
	  }
	  for (int i=0;i<bits/2;i++) {
		  bar+=Character.toString((char)0x2588);
	  }
	  if (bits%2!=0) {
		  bar+=Character.toString((char)0x258C);
	  }
	  return bar;
}

public String healthbar(double curHP,double maxHP,int hunger) {
	  //笆�笆�
	  int bits=(int)(Math.ceil(curHP/maxHP*10));
	  String bar=" ";
	  if (hunger==20) {
		  if (bits>6) {
			  bar+=ChatColor.GREEN+"";
		  } else
		  if (bits>3) {
			  bar+=ChatColor.YELLOW+"";
		  } else
		  {
			  bar+=ChatColor.RED+"";
		  }
	  } else {
		  if (bits>6) {
			  bar+=ChatColor.DARK_GREEN+"";
		  } else
		  if (bits>3) {
			  bar+=ChatColor.GOLD+"";
		  } else
		  {
			  bar+=ChatColor.DARK_RED+"";
		  }
	  }
	  for (int i=0;i<bits/2;i++) {
		  bar+=Character.toString((char)0x2588);
	  }
	  if (bits%2!=0) {
		  bar+=Character.toString((char)0x258C);
	  }
	  return bar;
}


@SuppressWarnings("deprecation")
public void checkJukeboxes() {
    getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
    {
    	public void run() {
    	//DURING 'THE END' EVENT ONLY.
    	if (Math.random()<=0.001) {
    		//5% chance it will start storming.
    		Bukkit.getWorld("world").setWeatherDuration((int)(Math.random()*6000));
    		Bukkit.getWorld("world").setThundering(true);
    		Bukkit.getWorld("world").setThunderDuration((int)(Math.random()*6000));
    	}
    	LOGGING_UPDATE_COUNTS=0;
          for (int i=0;i<SPEED_CONTROL.size();i++) {
        	  SPEED_CONTROL.get(i).updatePlayerSpd();
          }
          LOGGING_UPDATE_COUNTS++; //1
          for (int i=0;i<explorers.size();i++) {
        	  /*
			  int deadpoint=-1;
			  int exppoint=-1;
    		  Player p = Bukkit.getPlayer(explorers.get(i).name);
        	  if (explorers.get(i).event==1 && Bukkit.getPlayer(explorers.get(i).name)!=null && !Bukkit.getPlayer(explorers.get(i).name).isDead()) {
        		  if (getJobLv("Explorer", p)>=10) {
    				  PersistentExplorerList eve = new PersistentExplorerList(p.getName());
    				  eve.event=1;
    				  eve.data=p.getExp();
    				  eve.data2=p.getLevel();
    				  eve.expiretime=Main.SERVER_TICK_TIME+1200;
    				  explorers.add(eve);
        		  }
        	  }
			  if (explorers.get(i).event==1 && explorers.get(i).name.compareTo(p.getName())==0) {
				  exppoint=i;
				  //p.setTotalExperience(p.getTotalExperience()+explorers.get(j).data);
				  //p.sendMessage("Your experience: "+explorers.get(i).data+"/"+p.getTotalExperience());
			  } else
			  if (explorers.get(i).event==2 && explorers.get(i).name.compareTo(p.getName())==0) {
				  deadpoint=i;
			  }
			  if (exppoint!=-1 && deadpoint!=-1) {
				  p.setExp(explorers.get(exppoint).data);
				  p.setLevel((int)explorers.get(exppoint).data2);
				 explorers.get(exppoint).event=-1;
				 explorers.get(deadpoint).event=-1;
				 exppoint=-1;
				 deadpoint=-1;
			  }
			  */
        	  if (explorers.get(i).event==-1 || explorers.get(i).expiretime<Main.SERVER_TICK_TIME) {
        		  explorers.remove(i);
        		  i--;
        	  }
          }
          LOGGING_UPDATE_COUNTS++; //2
    		Player[] list = Bukkit.getOnlinePlayers();
    		for (int i=0;i<list.length;i++) {
    			if (Math.random()<0.5) {
				  if (!list[i].isDead() && PlayerinJob(list[i], "Breeder") && getJobLv("Breeder", list[i])>=5) {
					  List<Entity> entities = list[i].getNearbyEntities(10, 10, 10);
					  for (int j=0;j<entities.size();j++) {
						  if (entities.get(j).getType()==EntityType.SHEEP) {
							  if (Math.random()<0.5) {
								  Sheep sheep = (Sheep)entities.get(j);
								  sheep.setSheared(false);
							  }
						  } else 
						  if (entities.get(j).getType()==EntityType.CHICKEN) {
							  if (Math.random()<0.5) {
								  list[i].playSound(entities.get(j).getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
								  Bukkit.getWorld("world").dropItem(entities.get(j).getLocation(), new ItemStack(Material.EGG,1));
							  }
						  }
					  }
				  }
    			}
    			//We're going to see if we can spawn a boss dungeon.
    			boolean spawneddungeon=false;
    			if (list[i].getLocation().getY()<=20 &&  list[i].getWorld().getName().compareToIgnoreCase("world")==0) {
    				//Choose a random X and Z offset.
    				double xoffset = Math.random()*10+15;
    				double zoffset = Math.random()*10+15;
    				if (Math.random()<=0.5) {
    					xoffset*=-1;
    				}
    				if (Math.random()<=0.5) {
    					zoffset*=-1;
    				}
    				//Measure the perimeter. See if we can use it.
    				//Max blocks is 1792.
    				int unmatched=0;
    				boolean notallowed=false;
    				for (int j=-15;j<16;j++) {
    					for (int y=0;y<10;y++) {
	    					for (int k=-15;k<16;k++) {
	    						if (Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(xoffset+j,y,zoffset+k)).getType()!=Material.STONE && Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(xoffset+j,y,zoffset+k)).getType()!=Material.AIR) {
	    							unmatched++;
	    						}
	    						if (Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(xoffset+j,y,zoffset+k)).getType()==Material.TORCH || Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(xoffset+j,y,zoffset+k)).getType()==Material.GLOWSTONE || Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(xoffset+j,y,zoffset+k)).getType()==Material.COMMAND || Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(xoffset+j,y,zoffset+k)).getType()==Material.COBBLESTONE) {
	    							notallowed=true;
	    						}
	    					}
    					}
    				}
					boolean testing=false;
    				if (testing || !notallowed) {
    					if (testing || ((unmatched/9610.0d*100)>7 && (unmatched/9610.0d*100)<8.35 && (last_boss_dungeon_time==0 || last_boss_dungeon_time<Main.SERVER_TICK_TIME))) {
	    					if (Math.random()<0.25) {
	    	    				//Empty the whole area.
	    	    				for (int j=-15;j<16;j++) {
	    	    					for (int y=0;y<10;y++) {
	    		    					for (int k=-15;k<16;k++) {
	    		    						Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(xoffset+j,y,zoffset+k)).setType(Material.AIR);	
	    		    					}
	    	    					}
	    	    				}
	    						Bukkit.getLogger().info("Spawned a new boss area.");
	    						File file = new File("plugins/WorldEdit/schematics/boss.schematic");
	    					    if (file.exists()) {
	    					        try {
	    					            com.sk89q.worldedit.Vector v = new com.sk89q.worldedit.Vector(list[i].getLocation().getX()+xoffset-8, list[i].getLocation().getY(), list[i].getLocation().getZ()+zoffset-8);
	    					            World worldf = Bukkit.getWorld("world");
	    					            BukkitWorld BWf = new BukkitWorld(worldf);
	    					            EditSession es = new EditSession(BWf, 2000000);
	    					            CuboidClipboard c1 = SchematicFormat.MCEDIT.load(file);
	    					            c1.place(es, v, true);
	    					            spawneddungeon=true;
	    					            Bukkit.getWorld("world").getBlockAt(new Location(list[i].getWorld(),list[i].getLocation().getX()+xoffset, list[i].getLocation().getY()+2, list[i].getLocation().getZ()+zoffset)).setType(Material.COMMAND);
	    					        } catch (DataException ex) {
	    					            Bukkit.getLogger().warning("DataException while trying to create structure.");
	    					        } catch (IOException ex) {
	    					        	Bukkit.getLogger().warning("IOException while trying to create structure.");
	    					        } catch (MaxChangedBlocksException ex) {
	    					        	Bukkit.getLogger().warning("MaxChangedBlocksException while trying to create structure.");
	    					        }
	    					    } else {
	    					    	Bukkit.getLogger().warning(("File does not exist."));
	    					    }
	    					    last_boss_dungeon_time=Main.SERVER_TICK_TIME+12000;
	    					} else {
	    					    last_boss_dungeon_time=Main.SERVER_TICK_TIME+12000;
	    					}
    					}
    					//Bukkit.getLogger().info("Disparity is "+(unmatched/6727.0d*100)+"%");
    				}
    			}
    			if (!spawneddungeon) {
	    			//See if the player is very far underground and there is nothing around him/her. This would be odd behavior (Hint at strip mining) and we will force Charge Zombie II's to spawn and create areas.
	    			List<Entity> nearby = list[i].getNearbyEntities(20, 5, 20);
	    			for (int j=0;j<nearby.size();j++) {
						  if (nearby.get(j).getType()!=EntityType.SKELETON &&
								  nearby.get(j).getType()!=EntityType.ZOMBIE &&
								  nearby.get(j).getType()!=EntityType.CREEPER &&
								  nearby.get(j).getType()!=EntityType.SPIDER &&
								  nearby.get(j).getType()!=EntityType.ENDERMAN) {
							  nearby.remove(j);
							  j--;
						  }
	    			}
	    			if (list[i].getLocation().getY()<=30 && list[i].getWorld().getName().compareToIgnoreCase("world")==0 && nearby.size()<=20) {
	    				//Spawn 4 Charge Zombie II's in 4 corners farther off.
	    				int spread = (int)(Math.random()*10)+10;
	    				Entity e1=null,e2=null,e3=null,e4=null;
	    				boolean torch1=false,torch2=false,torch3=false,torch4=false;
	    				for (int j=5;j>-6;j--) {
	        				for (int k=2;k>-1;k--) {
	            				for (int l=5;l>-6;l--) {
	            					Block b =Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(20+j,k,spread+l));
	            					if (b.getType()==Material.TORCH || b.getType()==Material.GLOWSTONE || b.getType()==Material.COMMAND || b.getType()==Material.MOSSY_COBBLESTONE) {
	            						torch1=true;
	            					}
	            				}
	        				}
	    				}
	    				if (!torch1) {
	    					int lb1=(int)(Math.random()*5)+1,lb2=(int)(Math.random()*5)+1,ub1=-(int)(Math.random()*6)+1,ub2=-(int)(Math.random()*6)+1;
		    				for (int j=lb1;j>ub1;j--) {
		        				for (int k=2;k>-1;k--) {
		            				for (int l=lb2;l>-ub2;l--) {
		            					Block b =Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(20+j,k,spread+l));
		            					if (Math.random()<=0.75 && b.getType()!=Material.BEDROCK && b.getType()!=Material.MOB_SPAWNER && b.getType()!=Material.ENDER_PORTAL && b.getType()!=Material.ENDER_PORTAL_FRAME) {
		            						b.setType(Material.AIR);
		            					}
		            				}
		        				}
		    				}
		    				e1 = Bukkit.getWorld("world").spawnEntity(list[i].getLocation().add(20,0,spread), EntityType.ZOMBIE);
	    				}
	    				torch2=false;
	    				spread = (int)(Math.random()*10)+10;
	    				for (int j=5;j>-6;j--) {
	        				for (int k=2;k>-1;k--) {
	            				for (int l=5;l>-6;l--) {
	            					Block b =Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(-20+j,k,spread+l));
	            					if (b.getType()==Material.TORCH || b.getType()==Material.GLOWSTONE || b.getType()==Material.COMMAND || b.getType()==Material.MOSSY_COBBLESTONE) {
	            						torch2=true;
	            					}
	            				}
	        				}
	    				}
	    				if (!torch2) {
	    					int lb1=(int)(Math.random()*5)+1,lb2=(int)(Math.random()*5)+1,ub1=-(int)(Math.random()*6)+1,ub2=-(int)(Math.random()*6)+1;
		    				for (int j=lb1;j>ub1;j--) {
		        				for (int k=2;k>-1;k--) {
		            				for (int l=lb2;l>-ub2;l--) {
		            					Block b =Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(-20+j,k,spread+l));
		            					if (Math.random()<=0.75 && b.getType()!=Material.BEDROCK && b.getType()!=Material.MOB_SPAWNER && b.getType()!=Material.ENDER_PORTAL && b.getType()!=Material.ENDER_PORTAL_FRAME) {
		            						b.setType(Material.AIR);
		            					}
		            				}
		        				}
		    				}
		    				e2 = Bukkit.getWorld("world").spawnEntity(list[i].getLocation().add(-20,0,spread), EntityType.ZOMBIE);
	    				}
	    				spread = (int)(Math.random()*10)+10;
	    				for (int j=5;j>-6;j--) {
	        				for (int k=2;k>-1;k--) {
	            				for (int l=5;l>-6;l--) {
	            					Block b =Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(spread+j,k,20+l));
	            					if (b.getType()==Material.TORCH || b.getType()==Material.GLOWSTONE || b.getType()==Material.COMMAND || b.getType()==Material.MOSSY_COBBLESTONE) {
	            						torch3=true;
	            					}
	            				}
	        				}
	    				}
	    				if (!torch3) {
	    					int lb1=(int)(Math.random()*5)+1,lb2=(int)(Math.random()*5)+1,ub1=-(int)(Math.random()*6)+1,ub2=-(int)(Math.random()*6)+1;
		    				for (int j=lb1;j>ub1;j--) {
		        				for (int k=2;k>-1;k--) {
		            				for (int l=lb2;l>-ub2;l--) {
			        					Block b =Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(spread+j,k,20+l));
			        					if (Math.random()<=0.75 && b.getType()!=Material.BEDROCK && b.getType()!=Material.MOB_SPAWNER && b.getType()!=Material.ENDER_PORTAL && b.getType()!=Material.ENDER_PORTAL_FRAME) {
			        						b.setType(Material.AIR);
			        					}
			        				}
			    				}
							}
							e3 = Bukkit.getWorld("world").spawnEntity(list[i].getLocation().add(spread,0,20), EntityType.ZOMBIE);
	    				}
	    				spread = (int)(Math.random()*10)+10;
	    				for (int j=5;j>-6;j--) {
	        				for (int k=2;k>-1;k--) {
	            				for (int l=5;l>-6;l--) {
	            					Block b =Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(spread+j,k,-20+l));
	            					if (b.getType()==Material.TORCH || b.getType()==Material.GLOWSTONE || b.getType()==Material.COMMAND || b.getType()==Material.MOSSY_COBBLESTONE) {
	            						torch4=true;
	            					}
	            				}
	        				}
	    				}
	    				if (!torch4) {
	    					int lb1=(int)(Math.random()*5)+1,lb2=(int)(Math.random()*5)+1,ub1=-(int)(Math.random()*6)+1,ub2=-(int)(Math.random()*6)+1;
		    				for (int j=lb1;j>ub1;j--) {
		        				for (int k=2;k>-1;k--) {
		            				for (int l=lb2;l>-ub2;l--) {
		            					Block b =Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(spread+j,k,-20+l));
		            					if (Math.random()<=0.75 && b.getType()!=Material.BEDROCK && b.getType()!=Material.MOB_SPAWNER && b.getType()!=Material.ENDER_PORTAL && b.getType()!=Material.ENDER_PORTAL_FRAME) {
		            						b.setType(Material.AIR);
		            					}
		            				}
		        				}
		    				}
		    				e4 = Bukkit.getWorld("world").spawnEntity(list[i].getLocation().add(spread,0,-20), EntityType.ZOMBIE);
	    				}
    				}
    				/*
    				torch1=false;
    				torch2=false;
    				torch3=false;
    				torch4=false;
    				spread = (int)(Math.random()*20)+20;
    				int randomheight=(int)(Math.random()*5)-(int)(Math.random()*5);
    				for (int j=10;j>-11;j--) {
        				for (int k=4;k>-2;k--) {
            				for (int l=10;l>-11;l--) {
            					Block b =Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(30+j,k+randomheight,spread+l));
            					if (b.getType()==Material.TORCH || b.getType()==Material.GLOWSTONE) {
            						torch1=true;
            					}
            				}
        				}
    				}
    				if (!torch1) {
    					int lb1=(int)(Math.random()*5)+10,lb2=(int)(Math.random()*5)+10,ub1=-(int)(Math.random()*6)+10,ub2=-(int)(Math.random()*6)+10;
	    				for (int j=lb1;j>ub1;j--) {
	        				for (int k=(int)(Math.random()*4)+1;k>-1;k--) {
	            				for (int l=lb2;l>-ub2;l--) {
	            					Block b =Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(20+j,k+randomheight,spread+l));
	            					if (Math.random()<=0.75-k*0.10 && b.getType()!=Material.BEDROCK && b.getType()!=Material.MOB_SPAWNER && b.getType()!=Material.ENDER_PORTAL && b.getType()!=Material.ENDER_PORTAL_FRAME) {
	            						b.setType(Material.AIR);
	            					}
	            				}
	        				}
	    				}
    				}
    				torch2=false;
    				spread = (int)(Math.random()*20)+20;
    				randomheight=(int)(Math.random()*5)-(int)(Math.random()*5);
    				for (int j=10;j>-11;j--) {
        				for (int k=4;k>-2;k--) {
            				for (int l=10;l>-11;l--) {
            					Block b =Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(-20+j,k+randomheight,spread+l));
            					if (b.getType()==Material.TORCH || b.getType()==Material.GLOWSTONE) {
            						torch2=true;
            					}
            				}
        				}
    				}
    				if (!torch2) {
    					int lb1=(int)(Math.random()*5)+10,lb2=(int)(Math.random()*5)+10,ub1=-(int)(Math.random()*6)+10,ub2=-(int)(Math.random()*6)+10;
	    				for (int j=lb1;j>ub1;j--) {
	        				for (int k=(int)(Math.random()*4)+1;k>-1;k--) {
	            				for (int l=lb2;l>-ub2;l--) {
	            					Block b =Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(20+j,k+randomheight,spread+l));
	            					if (Math.random()<=0.75-k*0.10 && b.getType()!=Material.BEDROCK && b.getType()!=Material.MOB_SPAWNER && b.getType()!=Material.ENDER_PORTAL && b.getType()!=Material.ENDER_PORTAL_FRAME) {
	            						b.setType(Material.AIR);
	            					}
	            				}
	        				}
	    				}
    				}
    				spread = (int)(Math.random()*20)+20;
    				for (int j=10;j>-11;j--) {
        				for (int k=4;k>-2;k--) {
            				for (int l=10;l>-11;l--) {
            					Block b =Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(spread+j,k+randomheight,20+l));
            					if (b.getType()==Material.TORCH || b.getType()==Material.GLOWSTONE) {
            						torch3=true;
            					}
            				}
        				}
    				}
    				if (!torch3) {
    					int lb1=(int)(Math.random()*5)+10,lb2=(int)(Math.random()*5)+10,ub1=-(int)(Math.random()*6)+10,ub2=-(int)(Math.random()*6)+10;
	    				for (int j=lb1;j>ub1;j--) {
	        				for (int k=(int)(Math.random()*4)+1;k>-1;k--) {
	            				for (int l=lb2;l>-ub2;l--) {
	            					Block b =Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(20+j,k+randomheight,spread+l));
	            					if (Math.random()<=0.75-k*0.10 && b.getType()!=Material.BEDROCK && b.getType()!=Material.MOB_SPAWNER && b.getType()!=Material.ENDER_PORTAL && b.getType()!=Material.ENDER_PORTAL_FRAME) {
	            						b.setType(Material.AIR);
	            					}
	            				}
	        				}
	    				}
    				}
    				spread = (int)(Math.random()*20)+20;
    				for (int j=10;j>-11;j--) {
        				for (int k=4;k>-2;k--) {
            				for (int l=10;l>-11;l--) {
            					Block b =Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(spread+j,k+randomheight,-20+l));
            					if (b.getType()==Material.TORCH || b.getType()==Material.GLOWSTONE) {
            						torch4=true;
            					}
            				}
        				}
    				}
    				if (!torch4) {
    					int lb1=(int)(Math.random()*5)+10,lb2=(int)(Math.random()*5)+10,ub1=-(int)(Math.random()*6)+10,ub2=-(int)(Math.random()*6)+10;
	    				for (int j=lb1;j>ub1;j--) {
	        				for (int k=(int)(Math.random()*4)+1;k>-1;k--) {
	            				for (int l=lb2;l>-ub2;l--) {
	            					Block b =Bukkit.getWorld("world").getBlockAt(list[i].getLocation().add(20+j,k+randomheight,spread+l));
	            					if (Math.random()<=0.75-k*0.10 && b.getType()!=Material.BEDROCK && b.getType()!=Material.MOB_SPAWNER && b.getType()!=Material.ENDER_PORTAL && b.getType()!=Material.ENDER_PORTAL_FRAME) {
	            						b.setType(Material.AIR);
	            					}
	            				}
	        				}
	    				}
    				}
    				if (!torch1) {
        				Zombie z1 = (Zombie)e1;
	    				z1.setCustomName(ChatColor.GOLD+"Charge Zombie II");
	    				z1.setCustomNameVisible(false);
	    				z1.setTarget(list[i]);
    				}
    				if (!torch2) {
        				Zombie z2 = (Zombie)e2;
	    				z2.setCustomName(ChatColor.GOLD+"Charge Zombie II");
	    				z2.setCustomNameVisible(false);
	    				z2.setTarget(list[i]);
    				}
    				if (!torch3) {
        				Zombie z3 = (Zombie)e3;
	    				z3.setCustomName(ChatColor.GOLD+"Charge Zombie II");
	    				z3.setCustomNameVisible(false);
	    				z3.setTarget(list[i]);
    				}
    				if (!torch4) {
        				Zombie z4 = (Zombie)e4;
	    				z4.setCustomName(ChatColor.GOLD+"Charge Zombie II");
	    				z4.setCustomNameVisible(false);
	    				z4.setTarget(list[i]);
    				}*/
    			}
    			if (list[i].getWorld().getName().compareTo("world_the_end")==0) {
    				List<Entity> ents = Bukkit.getWorld("world_the_end").getEntities();
    				int enderdragoncount=0;
    				for (int j=0;j<ents.size();j++) {
    					if (ents.get(j).getType()==EntityType.ENDER_DRAGON) {
    						if (enderdragoncount==0) {
    							enderdragoncount=1;
    						} else {
    							ents.get(j).remove();
    						}
    					}
    				}
    			}
    			if (list[i].getWorld().getName().compareTo("world")==0) {
    				List<Entity> ents = Bukkit.getWorld("world").getEntities();
    				int enderdragoncount=0;
    				for (int j=0;j<ents.size();j++) {
    					if (ents.get(j).getType()==EntityType.ENDER_DRAGON) {
    							ents.get(j).remove();
    					}
    				}
    			}
                //Find out how much a player is worth.
    			if (list[i].getWorld().getName().compareTo("world")==0 && list[i].getLocation().getY()<=50) {
	    			double value=0;
	    			ItemStack[] items = list[i].getInventory().getContents();
	                for (int j=0;j<items.length;j++) {
	                	if (items[j]!=null) {
	                		if (items[j].getType()==Material.CHEST) {
	                			if (items[j].hasItemMeta() && items[j].getItemMeta().getLore()!=null) {
	                				List<String> loredata = items[j].getItemMeta().getLore();
	                				for (int m=0;m<loredata.size();m++) {
	                					if (loredata.get(m).equalsIgnoreCase(ChatColor.AQUA+"Contains 9 item slots.")) {
	                						value+=1*items[j].getAmount();
	                					}
	                				}
	                			}
	                		}
	                		if (items[j].getType()==Material.TRAPPED_CHEST) {
	                			if (items[j].hasItemMeta() && items[j].getItemMeta().getLore()!=null) {
	                				List<String> loredata = items[j].getItemMeta().getLore();
	                				for (int m=0;m<loredata.size();m++) {
	                					if (loredata.get(m).equalsIgnoreCase(ChatColor.AQUA+"Contains 54 item slots.")) {
	                						value+=10*items[j].getAmount();
	                					}
	                				}
	                			}
	                		}
	                		if (items[j].getType()==Material.COAL) {
	                			value+=0.001d*items[j].getAmount();
	                		} else 
	                		if (items[j].getType()==Material.IRON_INGOT) {
	                			value+=0.01d*items[j].getAmount();
	                		} else 
	                		if (items[j].getType()==Material.GOLD_INGOT) {
	                			value+=0.05d*items[j].getAmount();
	                		} else 
	                		if (items[j].getType()==Material.DIAMOND) {
	                			value+=0.25d*items[j].getAmount();
	                		} else 
	                		if (items[j].getType()==Material.LAPIS_ORE) {
	                			value+=0.01d*items[j].getAmount();
	                		} else 
	                		if (items[j].getType()==Material.EMERALD) {
	                			value+=0.3d*items[j].getAmount();
	                		} else 
	                		if (items[j].getType()==Material.COAL_BLOCK) {
	                			value+=0.001d*9*items[j].getAmount();
	                		} else 
	                		if (items[j].getType()==Material.IRON_BLOCK) {
	                			value+=0.01d*9*items[j].getAmount();
	                		} else 
	                		if (items[j].getType()==Material.GOLD_BLOCK) {
	                			value+=0.05d*9*items[j].getAmount();
	                		} else 
	                		if (items[j].getType()==Material.DIAMOND_BLOCK) {
	                			value+=0.25d*9*items[j].getAmount();
	                		} else 
	                		if (items[j].getType()==Material.LAPIS_BLOCK) {
	                			value+=0.01d*9*items[j].getAmount();
	                		} else 
	                		if (items[j].getType()==Material.IRON_AXE ||
	                				items[j].getType()==Material.IRON_PICKAXE ||
	                				items[j].getType()==Material.IRON_SPADE ||
	                				items[j].getType()==Material.IRON_SWORD ||
	                				items[j].getType()==Material.IRON_HOE) {
	                			value+=0.05d*items[j].getAmount();
	                		} else 
		                		if (items[j].getType()==Material.GOLD_AXE ||
                				items[j].getType()==Material.GOLD_PICKAXE ||
                				items[j].getType()==Material.GOLD_SPADE ||
                				items[j].getType()==Material.GOLD_SWORD ||
                				items[j].getType()==Material.GOLD_HOE) {
                			value+=0.25d*items[j].getAmount();
	                		} else 
		                		if (items[j].getType()==Material.DIAMOND_AXE ||
                				items[j].getType()==Material.DIAMOND_PICKAXE ||
                				items[j].getType()==Material.DIAMOND_SPADE ||
                				items[j].getType()==Material.DIAMOND_SWORD ||
                				items[j].getType()==Material.DIAMOND_HOE) {
                				value+=1.25d*items[j].getAmount();
	                		}
	                	}
	                }
	    			items = list[i].getEquipment().getArmorContents();
	                for (int j=0;j<items.length;j++) {
	                	if (items[j]!=null) {
	                		if (items[j].getType()==Material.IRON_CHESTPLATE ||
	                				items[j].getType()==Material.IRON_HELMET ||
	                				items[j].getType()==Material.IRON_LEGGINGS ||
	                				items[j].getType()==Material.IRON_BOOTS) {
	                			value+=0.05d*items[j].getAmount();
	                		} else 
	                		if (items[j].getType()==Material.GOLD_CHESTPLATE ||
                				items[j].getType()==Material.GOLD_HELMET ||
                				items[j].getType()==Material.GOLD_LEGGINGS ||
                				items[j].getType()==Material.GOLD_BOOTS) {
	                			value+=0.25d*items[j].getAmount();
	                		} else 
	                		if (items[j].getType()==Material.DIAMOND_CHESTPLATE ||
                				items[j].getType()==Material.DIAMOND_HELMET ||
                				items[j].getType()==Material.DIAMOND_LEGGINGS ||
                				items[j].getType()==Material.DIAMOND_BOOTS) {
	                			value+=1.25d*items[j].getAmount();
	                		}
	                	}
	                }
	                //Bukkit.getPlayer("sigonasr2").sendMessage("Player "+list[i].getName()+" has a value of "+value);
	                if (Math.random()<=value/2.0d) {
		                //Bukkit.getPlayer("sigonasr2").sendMessage("Generating..."+(((int)value*2)+1));
	                	switch ((int)(Math.random()*5)) {
		                	case 0: {
		                		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "mm pspawn skeleton "+(((int)(value/8))+1)+" "+list[i].getName());
		                	}break;
		                	case 1: {
		                		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "mm pspawn zombie "+(((int)(value/8))+1)+" "+list[i].getName());
		                	}break;
		                	case 2: {
		                		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "mm pspawn creeper "+(((int)(value/8))+1)+" "+list[i].getName());
		                	}break;
		                	case 3: {
		                		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "mm pspawn spider "+(((int)(value/8))+1)+" "+list[i].getName());
		                	}break;
		                	case 4: {
		                		if (Math.random()*3<=1) {
		                			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "mm pspawn enderman "+(((int)(value/8))+1)+" "+list[i].getName());
		                		}
		                	}break;
	                	}
	                }
    			}
    			list[i].getScoreboard().getTeam(list[i].getName()).setSuffix(healthbar(list[i].getHealth(),list[i].getMaxHealth(),list[i].getFoodLevel()));
    		}
          LOGGING_UPDATE_COUNTS++; //3
	  		  for (int i=0;i<supportmoblist.size();i++) {
    			  if (Bukkit.getPlayer(supportmoblist.get(i).p.getName())!=null) {
		  			  for (int j=0;j<supportmoblist.get(i).id.size();j++) {
						  if (supportmoblist.get(i).registeredtime<Main.SERVER_TICK_TIME) {
							  supportmoblist.get(i).id.remove(j);
							  j--;
						  }
		  			  }
					  /*if (supportmoblist.get(i).registeredtime<Main.SERVER_TICK_TIME) {
						  supportmoblist.remove(i);
						  i--;
					  }*/
    			  }
			  }
	          LOGGING_UPDATE_COUNTS++; //4
    		  for (int i=0;i<supportstackslist.size();i++) {
    			  if (!supportstackslist.get(i).isValid()) {
    				  supportstackslist.remove(i);
    				  i--;
    			  }
    		  }
              LOGGING_UPDATE_COUNTS++; //5
    		  for (int i=0;i<hunterplayers.size();i++) {
    			  if (Bukkit.getPlayer(hunterplayers.get(i).getName())!=null) {
    				  Player p = hunterplayers.get(i);
	    			  if (!p.isDead() && PlayerinJob(p,"Hunter")) {
	    				  int hunterlv=getJobLv("Hunter",p);
	    				  if (hunterlv>=10) {
	    					  if (p.isSneaking()) {
	    						  p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 12, 0, false));
	    					  }
	    				  }
	    			  }
    			  }
    		  }
              LOGGING_UPDATE_COUNTS++; //6
    		  for (int i=0;i<supportplayers.size();i++) {
    			  if (Bukkit.getPlayer(supportplayers.get(i).p.getName())!=null) {
    				  Player p = supportplayers.get(i).p;
	    			  if (!p.isDead() && PlayerinJob(p,"Support")) {
	    				  int supportlv=getJobLv("Support",p);
	    				  List<Entity> nearbyplayers = p.getNearbyEntities(20, 20, 20);
	    				  //Bukkit.getPlayer("sigonasr2").sendMessage("Entered 1.");
	    				  for (int j=0;j<nearbyplayers.size();j++) {
	    					  if (nearbyplayers.get(j).getType()==EntityType.PLAYER) {
		    					  Player p2 = (Player)nearbyplayers.get(j);
			    				  //Bukkit.getPlayer("sigonasr2").sendMessage("Entered 2.");
		    					  if (p2!=p) {
				    				  if (supportlv>=20) {
				    					  int get_resistance_level=-1;
				    					  Iterator<PotionEffect> effects = p2.getActivePotionEffects().iterator();
				    					  while (effects.hasNext()) {
				    						  PotionEffect pot = effects.next();
				    						  if (pot.getType().getName().equalsIgnoreCase(PotionEffectType.DAMAGE_RESISTANCE.getName())) {
				    							  get_resistance_level=pot.getAmplifier();
				    							  //Bukkit.broadcastMessage("Got REsistance of "+pot.getAmplifier());
				    							  break;
				    						  } else {
				    							  //Bukkit.broadcastMessage("Got buff of "+pot.getType());
				    						  }
				    					  }
				    					  if (get_resistance_level<1) {
				    	    				  //Bukkit.getPlayer("sigonasr2").sendMessage("Entered 4.");
				    						  p2.sendMessage(ChatColor.YELLOW+"[Aura]"+ChatColor.ITALIC+"Damage reduction buff (40%) from Support "+ChatColor.DARK_RED+p.getName());
				    						  p2.sendMessage(ChatColor.YELLOW+"[Aura]"+ChatColor.ITALIC+"Food Exhaustion buff (50% less food consumption) from Support "+ChatColor.DARK_RED+p.getName());
				    						  p2.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 601, 1, false));
				    					  } else {
				    						  p2.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
				    						  p2.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 601, 1, false));
				    					  }
				    				  } else
				    				  if (supportlv>=5) {
					    				  //Bukkit.getPlayer("sigonasr2").sendMessage("Entered 3.");
				    					  //Give them a resistance buff.
				    					  int get_resistance_level=-1;
				    					  Iterator<PotionEffect> effects = p2.getActivePotionEffects().iterator();
				    					  while (effects.hasNext()) {
				    						  PotionEffect pot = effects.next();
				    						  if (pot.getType().getName().equalsIgnoreCase(PotionEffectType.DAMAGE_RESISTANCE.getName())) {
				    							  get_resistance_level=pot.getAmplifier();
				    							  //Bukkit.broadcastMessage("Got REsistance of "+pot.getAmplifier());
				    							  break;
				    						  } else {
				    							  //Bukkit.broadcastMessage("Got buff of "+pot.getType());
				    						  }
				    					  }
				    					  if (get_resistance_level<0) {
				    	    				  //Bukkit.getPlayer("sigonasr2").sendMessage("Entered 4.");
				    						  p2.sendMessage(ChatColor.YELLOW+"[Aura]"+ChatColor.ITALIC+"Damage reduction buff (20%) from Support "+ChatColor.DARK_RED+p.getName());
				    						  p2.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 601, 0, false));
				    					  } else {
				    						  p2.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
				    						  p2.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 601, 0, false));
				    					  }
				    				  }
				    				  if (supportlv>=10) {
				    					  //Set that they have a lv10 hp buff.
				    					  for (int k=0;k<SPEED_CONTROL.size();k++) {
				    						  if (p2==SPEED_CONTROL.get(k).p) {
				    							  if (!SPEED_CONTROL.get(k).hpbufflist.contains(p)) {
				    								  SPEED_CONTROL.get(k).hpbufflist.add(p);
				    								  p2.sendMessage(ChatColor.YELLOW+"[Aura]"+ChatColor.ITALIC+"HP buff (+10) from Support "+ChatColor.DARK_RED+p.getName());
				    								  SPEED_CONTROL.get(k).hpbuff_time = Main.SERVER_TICK_TIME+260;
				    								  SPEED_CONTROL.get(k).updatePlayerSpd();
				    							  } else {
				    								  SPEED_CONTROL.get(k).hpbuff_time = Main.SERVER_TICK_TIME+260;
				    								  SPEED_CONTROL.get(k).updatePlayerSpd();
				    							  }
				    						  }
				    					  }
				    				  }
		    					  } else {
		    						  continue;
		    					  }
	    					  }
	    				  }
	    			  }
    			  }
    		  }
              LOGGING_UPDATE_COUNTS++; //7
    		  for (int i=0;i<explorerlist.size();i++) {
    			  if (Bukkit.getPlayer(explorerlist.get(i).player)!=null) {
    				  Player p =Bukkit.getPlayer(explorerlist.get(i).player);
	    			  if (!p.isDead() && PlayerinJob(p,"Explorer")) {
	    				  if (getJobLv("Explorer",p)>=10) {
	    					  //We store the exp and level too.
	    					  if (explorerlist.get(i).wedied) {
	    						  p.setExp(explorerlist.get(i).expamt);
	    						  p.setLevel(explorerlist.get(i).explv);
	    						  explorerlist.get(i).wedied=false;
	    					  } else {
		    					  explorerlist.get(i).expamt=p.getExp();
		    					  explorerlist.get(i).explv=p.getLevel();
	    					  }
	    				  }
	    				  //Give money for moving around.
	    				  double distance = Math.abs(explorerlist.get(i).xprevious-p.getLocation().getX())+Math.abs(explorerlist.get(i).zprevious-p.getLocation().getZ());
	    				  gainMoneyExp(p,"Explorer",0.005*distance/500.0d,distance/500.0d);
	    				  //Bukkit.getPlayer("sigonasr2").sendMessage("+"+distance/500.0d+"xp");
	    				  Block lookat = p.getTargetBlock(null, 50);
	    				  
	    				  if (distance>2) { 
		    				  //VILLAGE CRITERIA.
		    				  if (lookat.getType()==Material.SAND) {
		    					  explorerlist.get(i).villagecriteria--;
		    				  }
		    				  if (lookat.getType()==Material.SANDSTONE) {
		    					  explorerlist.get(i).villagecriteria-=2;
		    				  }
		    				  if (lookat.getType()==Material.WOOL && lookat.getData()==15) {
		    					  explorerlist.get(i).villagecriteria-=3;
		    				  }
		    				  if (lookat.getType()==Material.DIRT) {
		    					  explorerlist.get(i).villagecriteria=100;
		    				  }
		    				  if (lookat.getType()==Material.LOG || lookat.getType()==Material.WOOD) {
		    					  explorerlist.get(i).villagecriteria=100;
		    				  }
		    				  if (explorerlist.get(i).villagecriteria<40 && GLOBAL_villagetimer<Main.SERVER_TICK_TIME) {
		    					  //Start checking for villagers. Start going up if they aren't there.
		    					  boolean village=false;
		    					  List<Entity> lister = p.getNearbyEntities(10, 10, 10);
		    					  for (int j=0;j<lister.size();j++) {
		    						  if (lister.get(j).getType()==EntityType.VILLAGER) {
		    							  //Award the player for finding a village.
		    							  village=true;
		    							  explorerlist.get(i).villagecriteria=100;
		    							  gainMoneyExp(p,"Explorer",0.50,50);
		    							  GLOBAL_villagetimer=Main.SERVER_TICK_TIME+6000;
		    							  break;
		    						  }
		    					  }
		    					  if (!village) {
		    						  explorerlist.get(i).villagecriteria+=5;
		    					  }
		    				  }
		    				  
		    				  //TEMPLE CRITERIA.
		    				  if (lookat.getType()==Material.COBBLESTONE || lookat.getType()==Material.SAND) {
		    					  explorerlist.get(i).templecriteria--;
		    				  }
		    				  if (lookat.getType()==Material.MOSSY_COBBLESTONE || lookat.getType()==Material.SANDSTONE) {
		    					  explorerlist.get(i).templecriteria-=2;
		    				  }
		    				  if (lookat.getType()==Material.getMaterial(98) || (lookat.getType()==Material.WOOL && lookat.getData()==1)) {
		    					  explorerlist.get(i).templecriteria-=10;
		    				  }
		    				  if (lookat.getType()==Material.CHEST) {
		    					  explorerlist.get(i).templecriteria-=5;
		    				  }
		    				  if (lookat.getType()==Material.DIRT) {
		    					  explorerlist.get(i).templecriteria=100;
		    				  }
		    				  if (lookat.getType()==Material.LOG || lookat.getType()==Material.WOOD) {
		    					  explorerlist.get(i).templecriteria=100;
		    				  }
		    				  if (explorerlist.get(i).templecriteria<=0 && GLOBAL_templetimer<Main.SERVER_TICK_TIME) {
		    					  explorerlist.get(i).templecriteria=100;
								  gainMoneyExp(p,"Explorer",0.50,50);
								  GLOBAL_templetimer=Main.SERVER_TICK_TIME+36000;
		    				  }
	
		    				  //CAVE CRITERIA
		    				  if (lookat.getType()==Material.STONE) {
		    					  explorerlist.get(i).cavecriteria-=1;
		    				  }
		    				  if (lookat.getType()==Material.GRAVEL) {
		    					  explorerlist.get(i).cavecriteria-=1;
		    				  }
		    				  if (lookat.getType()==Material.MOB_SPAWNER) {
		    					  explorerlist.get(i).cavecriteria-=10;
		    				  }
		    				  if (lookat.getType()==Material.MOSSY_COBBLESTONE) {
		    					  explorerlist.get(i).cavecriteria-=3;
		    				  }
		    				  if (lookat.getLightLevel()<5) {
		    					  explorerlist.get(i).cavecriteria-=3;
		    				  }
		    				  if (p.getLocation().getY()>50) {
		    					  explorerlist.get(i).cavecriteria=100;
		    				  }
		    				  if (lookat.getType()==Material.LOG || lookat.getType()==Material.SAND) {
		    					  explorerlist.get(i).cavecriteria=100;
		    				  }
		    				  if (explorerlist.get(i).cavecriteria<=0 && GLOBAL_cavetimer<Main.SERVER_TICK_TIME) {
		    					  explorerlist.get(i).cavecriteria=100;
								  gainMoneyExp(p,"Explorer",0.50,50);
								  GLOBAL_cavetimer=Main.SERVER_TICK_TIME+3000;
		    				  }
		    				  
		    				  //UNDERGROUND CRITERIA
		    				  if (p.getLocation().getY()<30 && p.getLocation().getY()>10 && lookat.getLightLevel()<6) {
		    					  explorerlist.get(i).undergroundcriteria-=20;
		    				  }
		    				  if (explorerlist.get(i).undergroundcriteria<=0 && GLOBAL_undergroundtimer<Main.SERVER_TICK_TIME) {
		    					  explorerlist.get(i).undergroundcriteria=100;
								  gainMoneyExp(p,"Explorer",0.50,50);
								  GLOBAL_undergroundtimer=Main.SERVER_TICK_TIME+3000;
		    				  }
		    				  if (p.getLocation().getY()>50) {
		    					  explorerlist.get(i).undergroundcriteria=100;
		    				  }
		    				  if (lookat.getType()==Material.LOG || lookat.getType()==Material.SAND) {
		    					  explorerlist.get(i).undergroundcriteria=100;
		    				  }
		    				  
		    				  //NETHER CRITERIA
		    				  if (lookat.getType()==Material.NETHERRACK) {
		    					  explorerlist.get(i).nethercriteria-=1;
		    				  }
		    				  if (lookat.getType()==Material.LAVA) {
		    					  explorerlist.get(i).nethercriteria-=5;
		    				  }
		    				  if (explorerlist.get(i).nethercriteria<=0 && GLOBAL_nethertimer<Main.SERVER_TICK_TIME) {
		    					  explorerlist.get(i).nethercriteria=100;
								  gainMoneyExp(p,"Explorer",0.50,50);
								  GLOBAL_nethertimer=Main.SERVER_TICK_TIME+6000;
		    				  }
		    				  if (lookat.getType()==Material.DIRT) {
		    					  explorerlist.get(i).nethercriteria=100;
		    				  }
		    				  if (lookat.getType()==Material.LOG || lookat.getType()==Material.SAND) {
		    					  explorerlist.get(i).nethercriteria=100;
		    				  }
		    				  
		    				  //Check for map in hand.
		    				  if (p.getItemInHand()!=null && p.getItemInHand().getType()==Material.MAP) {
		    					  //MapView map = Bukkit.getServer().getMap(Short.parseShort((""+p.getItemInHand().getData()).replaceAll("[^\\d.]", "")));
		    					  //map.removeRenderer(map.getRenderers().get(1));
		    					  //map.addRenderer(new MyMapRenderer());
		    					  f = new File("world/data/map_"+Short.parseShort((""+p.getItemInHand().getData()).replaceAll("[^\\d.]", ""))+".dat");
		    					  long currentsize = f.length();
		    					  Bukkit.getWorld("world").save();
		    					  long newsize = f.length();
		    					  if (newsize>currentsize) {
		    						  //Award this explorer experience for growing the map.
		    						  if (p.getLocation().getY()<=60) {
			    						  gainMoneyExp(p,"Explorer",0.01,8);
		    						  } else {
			    						  gainMoneyExp(p,"Explorer",0.001,2);
		    						  }
		    					  }
		    				  }
	    				  }
	    				  
	    				  if (lookat.getType()!=Material.AIR && lookat.getType()!=explorerlist.get(i).lasttype) {
	    					  distance = Math.abs(explorerlist.get(i).xlookprevious-lookat.getLocation().getX())+Math.abs(explorerlist.get(i).zlookprevious-lookat.getLocation().getZ());
	    					  int mult=1;
	    					  for (int j=0;j<RARE_BLOCKS.length;j++) {
	    						  if (lookat.getType()==RARE_BLOCKS[j]) {
	    							  if (lookat.getType()==Material.LOG) {
	    								  if (lookat.getData()==3 || lookat.getData()==7 || lookat.getData()==11 || lookat.getData()==15) {
	    									  mult=20;
	    									  break;
	    								  } else {
	    									  break;
	    								  }
	    							  } else {
		    							  mult=10;
		    							  break;
	    							  }
	    						  }
	    					  }
	    					  //Bukkit.getPlayer("sigonasr2").sendMessage("+"+((distance/500.0d)*mult)+"xp");
	    					  gainMoneyExp(p,"Explorer",0.01*((distance/500.0d)*mult),(distance/500.0d)*mult);
	    					  explorerlist.get(i).lasttype=lookat.getType();
	    				  } else {
	    					  explorerlist.get(i).xlookprevious=lookat.getLocation().getX();
	    					  explorerlist.get(i).zlookprevious=lookat.getLocation().getZ();
	    				  }
	    				  explorerlist.get(i).xprevious=p.getLocation().getX();
	    				  explorerlist.get(i).zprevious=p.getLocation().getZ();
	    				  if (explorerlist.get(i).awardinteract!=explorerlist.get(i).lastinteract) {
	    					  for (int j=0;j<RARE_BLOCKS.length;j++) {
	    						  if (explorerlist.get(i).lastinteract==RARE_BLOCKS[j]) {
	    							  //Award the player for interacting.
	    							  gainMoneyExp(p,"Explorer",0.05,25);
	    							  explorerlist.get(i).awardinteract=explorerlist.get(i).lastinteract;
	    						  }
	    					  }
	    				  }
	    			  }
    			  }
    		  }
              LOGGING_UPDATE_COUNTS++; //8
	  		  for (int i=0;i<animallist.size();i++) {
	  			if (animallist.get(i).getTime()<Main.SERVER_TICK_TIME) {
	  				//Remove it.
	  				animallist.remove(i);
	  				i--;
	  			}
	  		  }
	          LOGGING_UPDATE_COUNTS++; //9
	  		  for (int i=0;i<furnacelist.size();i++) {
	  			  if (Bukkit.getWorld("world").getBlockAt(furnacelist.get(i).getLoc()).getType()==Material.FURNACE || Bukkit.getWorld("world").getBlockAt(furnacelist.get(i).getLoc()).getType()==Material.BURNING_FURNACE) {
		  			  if (furnacelist.get(i).getTime()<Main.SERVER_TICK_TIME && ((Furnace)Bukkit.getWorld("world").getBlockAt(furnacelist.get(i).getLoc()).getState()).getBurnTime()==0) {
		  				  //Remove it.
		  				  furnacelist.remove(i);
		  				  i--;
		  				  //Bukkit.getPlayer("sigonasr2").sendMessage("Furnace removed.");
		  			  }
	  			  } else {
	  				  furnacelist.remove(i);
	  				  i--;
	  			  }
	  		  }
	          LOGGING_UPDATE_COUNTS++; //10
    		  for (int i=0;i<jukeboxlist.size();i++) {
    			  	  if (jukeboxlist.get(i).getJukebox()!=null && jukeboxlist.get(i).getJukebox().getState()!=null && ((Jukebox)(jukeboxlist.get(i).getJukebox().getState())).getPlaying()!=null) {
		    			  if (((Jukebox)(jukeboxlist.get(i).getJukebox().getState())).getPlaying()==Material.AIR) {
		    				  jukeboxlist.remove(i);
		    				  i--;
		    			  } else {
		    				  //We are playing something still.
		    				  jukeboxlist.get(i).updateClosestPlayer();
		    				  //Check if the disk changed.
		    				  if (((Jukebox)jukeboxlist.get(i).getJukebox().getState()).getPlaying()!=jukeboxlist.get(i).getDisk()) {
		    					  jukeboxlist.get(i).setDisk(((Jukebox)jukeboxlist.get(i).getJukebox().getState()).getPlaying());
		    				  }
		    				  if (Main.SERVER_TICK_TIME-jukeboxlist.get(i).getSongStart()>jukeboxlist.get(i).getSongDuration()*20+60) {
		    					  //Check to see if players are closer to one or the other.
		    					  boolean closest=true;
		    					  for (int j=0;j<jukeboxlist.size();j++) {
		    						  if (j!=i) {
		    							  if (jukeboxlist.get(i).getClosestPlayer()>jukeboxlist.get(j).getClosestPlayer()) {
		    								  closest=false;
		    							  }
		    						  }
		    					  }
		    					  if (closest) {
		        					  //We have to loop it.
			    					  if (!jukeboxlist.get(i).Restart()) {
			    	    				  jukeboxlist.remove(i);
			    	    				  i--;
			    					  } else {
			    						  //Bukkit.getPlayer("sigonasr2").sendMessage("Restarted Jukebox "+i+" Properties: "+((Jukebox)(jukeboxlist.get(i).getJukebox().getState())).getPlaying()+","+((Jukebox)(jukeboxlist.get(i).getJukebox().getState())).isPlaying());
			    					  }
		    					  }
		    				  }
		    			  }
    			  	  } else {
	    				  jukeboxlist.remove(i);
	    				  i--;
    			  	  }
    			  //Bukkit.getPlayer("sigonasr2").sendMessage("Jukebox "+i+" Properties: "+((Jukebox)(jukeboxlist.get(i).getJukebox().getState())).getPlaying()+","+((Jukebox)(jukeboxlist.get(i).getJukebox().getState())).isPlaying());
    		  }
              LOGGING_UPDATE_COUNTS++; //11
              
              LOGGING_UPDATE_COUNTS++; //12
    	}
    }
    , 200, 200);
}

@SuppressWarnings("deprecation")
public void updateTime() {
    getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
    {
    	public void run() {
	  		  for (int i=0;i<brewingstandlist.size();i++) {
	  			  if (Bukkit.getWorld("world").getBlockAt(brewingstandlist.get(i).getLoc()).getType()==Material.BREWING_STAND) {
  					  //Bukkit.getPlayer("sigonasr2").sendMessage("Brewing stand. "+brewingstandlist.get(i).getBrewingTime());
	  				  if (brewingstandlist.get(i).getBrewingTime()>0 && !brewingstandlist.get(i).is_newTimeSet()) {
	  					  //Bukkit.getPlayer("sigonasr2").sendMessage("Brewing, time is not set: "+brewingstandlist.get(i).getBrewingTime());
	  					  if (PlayerinJob(brewingstandlist.get(i).owner, "Brewer") && getJobLv("Brewer", brewingstandlist.get(i).owner)>=5) {
		  					  brewingstandlist.get(i).set_newTime(true);
		  					  //Bukkit.getPlayer("sigonasr2").sendMessage("Old Brewing time: "+brewingstandlist.get(i).getBrewingTime());
		  					  brewingstandlist.get(i).setBrewingTime(brewingstandlist.get(i).getBrewingTime()/2);
		  					  //Bukkit.getPlayer("sigonasr2").sendMessage("New Brewing time: "+brewingstandlist.get(i).getBrewingTime());
	  					  }
	  				  }
		  			  if (brewingstandlist.get(i).getTime()<Main.SERVER_TICK_TIME && ((BrewingStand)Bukkit.getWorld("world").getBlockAt(brewingstandlist.get(i).getLoc()).getState()).getBrewingTime()==0) {
		  				  //Remove it.
		  				  brewingstandlist.remove(i);
		  				  i--;
		  				  //Bukkit.getPlayer("sigonasr2").sendMessage("Brewingstand removed.");
		  			  }
	  			  }
	  		  }
	  		  if (LOGGING_UPDATE_COUNTS!=-1 && LOGGING_UPDATE_COUNTS<MAX_LOGGING_COUNT) {
	    		  LOGGING_UPDATE_COUNTS=-1;
	  		  } else {
	  			  if (LOGGING_UPDATE_COUNTS==MAX_LOGGING_COUNT) {
	  				LOGGING_UPDATE_COUNTS=-1;
	  				//Bukkit.getLogger().info("All is fine.");
	  			  } else {
	  				  if (LOGGING_UPDATE_COUNTS!=-1) {
	  	  				Bukkit.getLogger().warning("Something got caught.");
	  				  }
	  			  }
	  		  }
  			Bukkit.getWorld("world").setFullTime(Main.SERVER_TICK_TIME-4);
    	}
    }
    , 8, 8);
}

  @SuppressWarnings("deprecation")
public void payDay(int time)
  {
    getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
    {
      public void run()
      {
        for (Player allOnlineP : Bukkit.getOnlinePlayers()) {
          allOnlineP.sendMessage(ChatColor.DARK_GREEN+"<=========["+ChatColor.LIGHT_PURPLE+"Interest"+ChatColor.DARK_GREEN+"]=========>");
          DecimalFormat df = new DecimalFormat("#0.00");
          allOnlineP.sendMessage(ChatColor.GOLD+"The money interest has been delivered to all players. ("+df.format((double)(Main.this.getConfig().getDouble("payday.amount")*100))+"% interest rate)");
          allOnlineP.sendMessage(ChatColor.GOLD+"Your Balance: $"+df.format((getAccountsConfig().getDouble(allOnlineP.getName() + ".money")))+" -> $"+df.format(((Main.this.getConfig().getDouble("payday.amount")*(getAccountsConfig().getDouble(allOnlineP.getName() + ".money"))+getAccountsConfig().getDouble(allOnlineP.getName() + ".money")))));
          allOnlineP.sendMessage(ChatColor.DARK_GREEN+"<==========================>");
          getAccountsConfig().set(allOnlineP.getName() + ".money", ((Main.this.getConfig().getDouble("payday.amount")*(getAccountsConfig().getDouble(allOnlineP.getName() + ".money"))+getAccountsConfig().getDouble(allOnlineP.getName() + ".money"))));
          //Main.economy.depositPlayer(allOnlineP.getName(), (Main.this.getConfig().getDouble("payday.amount")*Main.economy.bankBalance(allOnlineP.getName()).balance));
        }
        for (OfflinePlayer allOnlineP : Bukkit.getOfflinePlayers()) {
        	if (!allOnlineP.isOnline()) {
        		getAccountsConfig().set(allOnlineP.getName() + ".money", ((Main.this.getConfig().getDouble("payday.amount")*(getAccountsConfig().getDouble(allOnlineP.getName() + ".money"))+getAccountsConfig().getDouble(allOnlineP.getName() + ".money"))));
        	}
            //Main.economy.depositPlayer(allOnlineP.getName(), (Main.this.getConfig().getDouble("payday.amount")*Main.economy.bankBalance(allOnlineP.getName()).balance));
        }
        saveAccountsConfig();
        List<UUID> expired_uuids = new ArrayList<UUID>();
        String moblist = getConfig().getString("fed.mobs");
		String finalstring = "";
		int removed_count=0;
		if (getConfig().getString("fed.mobs").length()>4) {
			String[] mobslist = moblist.split(",");
			  for (int i=0;i<mobslist.length;i+=2) {
				  if (Main.SERVER_TICK_TIME>Long.valueOf(mobslist[i+1])) {
					  expired_uuids.add(UUID.fromString(mobslist[i]));
				  } else {
					  //Send this back for holding on until next time.
					  //Reconstruct the data
					  if (finalstring.equalsIgnoreCase("")) {
						  finalstring+=mobslist[i]+","+mobslist[i+1];
					  } else {
						  finalstring+=","+mobslist[i]+","+mobslist[i+1];
					  }
				  }
			  }
	        //Check all spawned entities in the world.
	        List<Entity> world_entities = Bukkit.getWorld("world").getEntities();
	        for (int i=0;i<world_entities.size();i++) {
	        	if (expired_uuids.contains(world_entities.get(i).getUniqueId())) {
	        		LivingEntity l = (LivingEntity)world_entities;
	        		l.setRemoveWhenFarAway(true);
	        		l.setHealth(0);
	        		l.remove();
	        		removed_count++;
	        		i--;
	        	}
	        }
			  getConfig().set("fed.mobs", String.valueOf(finalstring));
			  saveConfig();
	        
		}
		Bukkit.getLogger().info("Removed "+removed_count+" animals that have not been fed.");
      }
    }
    , 1200 * time, 1200 * time);
  }

  public void writeToLog(String msg) {
    try {
      FileWriter fWriter = new FileWriter(new File(getDataFolder(), "players.txt"), true);
      BufferedWriter writer = new BufferedWriter(fWriter);

      writer.write(msg);
      writer.newLine();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private boolean setupEconomy()
  {
    RegisteredServiceProvider economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
    if (economyProvider != null) {
      economy = (Economy)economyProvider.getProvider();
    } else {
      System.out.print("[" + getDescription().getName() + "][WARNING] NO ECONOMY SYSTEM FOUND! PLUGIN DISABLED.");
      getServer().getPluginManager().disablePlugin(this);
    }

    return economy != null;
  }

  public FileConfiguration reloadChunksConfig(int chunkX,int chunkZ)
  {
	File base;
	FileConfiguration myFile;
    base = new File(getDataFolder()+"/custom-region", "r."+chunkX+"."+chunkZ+".yml");
    myFile = YamlConfiguration.loadConfiguration(base);
    return myFile;
  }

  public void saveChunksConfig(FileConfiguration filer, int chunkX, int chunkZ) {
	File base;
    base = new File(getDataFolder()+"/custom-region", "r."+chunkX+"."+chunkZ+".yml");
    if ((filer == null) || (base == null))
      return;
    try
    {
      filer.save(base);
    } catch (IOException ex) {
      getLogger().log(Level.SEVERE, "Could not save chunk config to " + base, ex);
    }
  }

  public FileConfiguration reloadItemCubeConfig(int cubenumb)
  {
	File base;
	FileConfiguration myFile;
    base = new File(getDataFolder()+"/item-cube", "itemcube"+cubenumb+".yml");
    myFile = YamlConfiguration.loadConfiguration(base);
    return myFile;
  }

  public void saveItemCubeConfig(FileConfiguration filer, int cubenumb) {
	File base;
    base = new File(getDataFolder()+"/item-cube", "itemcube"+cubenumb+".yml");
    if ((filer == null) || (base == null))
      return;
    try
    {
      filer.save(base);
    } catch (IOException ex) {
      getLogger().log(Level.SEVERE, "Could not save item cube config to " + base, ex);
    }
  }

  public void reloadAccountsConfig()
  {
    if (this.accountsConfigFile == null) {
      this.accountsConfigFile = new File(getDataFolder(), "accounts.yml");
    }
    this.accountsConfig = YamlConfiguration.loadConfiguration(this.accountsConfigFile);

    InputStream defConfigStream = getResource("accounts.yml");
    if (defConfigStream != null) {
      YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
      this.accountsConfig.setDefaults(defConfig);
    }
  }

  public FileConfiguration getAccountsConfig() {
    if (this.accountsConfig == null) {
      reloadAccountsConfig();
    }
    return this.accountsConfig;
  }

  public void saveAccountsConfig() {
    if ((this.accountsConfig == null) || (this.accountsConfigFile == null))
      return;
    try
    {
      getAccountsConfig().save(this.accountsConfigFile);
    } catch (IOException ex) {
      getLogger().log(Level.SEVERE, "Could not save config to " + this.accountsConfigFile, ex);
    }
  }

  public void saveDefaultConfig() {
    if (this.accountsConfigFile == null) {
      this.accountsConfigFile = new File(getDataFolder(), "accounts.yml");
    }
    if (!this.accountsConfigFile.exists())
      saveResource("accounts.yml", false);
  }

	public int getPlayerJobCount(Player p) {
		int count=0;
		if (getAccountsConfig().getString(p.getName()+".jobs.job1").compareTo("None")!=0) {
			count++;
		}
		if (getAccountsConfig().getString(p.getName()+".jobs.job2").compareTo("None")!=0) {
			count++;
		}
		if (getAccountsConfig().getString(p.getName()+".jobs.job3").compareTo("None")!=0) {
			count++;
		}
		return count;
	}
	
	public void setUltimate(Player p, String job) {
    	boolean valid=false;
    	int matchedjob=0;
    	for (int i=0;i<ValidJobs.length;i++) {
    		if (job.equalsIgnoreCase(ValidJobs[i])) {
    			valid=true;
    			matchedjob=i;
    			Bukkit.getLogger().info("Found the job to set ultimate to.");
    			break;
    		}
    	}
    	if (!valid) {
    		p.sendMessage(ChatColor.GOLD+"Sorry, that is not a valid job!");
    		return;
    	}
    	if (PlayerinJob(p,job)) {
	    	getAccountsConfig().set(p.getName()+".jobs.ultimate", String.valueOf(ValidJobs[matchedjob]));
	    	saveAccountsConfig();
	    	p.sendMessage(ChatColor.YELLOW+"Set Declared Ultimate job to "+job);
    	} else {
    		p.sendMessage(ChatColor.GOLD+"Sorry, you are not in that job!");
    		return;
    	}
	}
  
    public boolean joinJob(Player p, String job) {
    	//Verify this is a valid job we can join.
    	boolean valid=false;
    	int matchedjob=0;
    	for (int i=0;i<ValidJobs.length;i++) {
    		if (job.equalsIgnoreCase(ValidJobs[i])) {
    			valid=true;
    			matchedjob=i;
    			Bukkit.getLogger().info("Found the job to join.");
    			break;
    		}
    	}
    	if (!valid) {
    		p.sendMessage(ChatColor.GOLD+"Sorry, that is not a valid job!");
    		return false;
    	}
		Bukkit.getLogger().info("Validity check passed.");
    	if (getPlayerJobCount(p)>=3) {
    		p.sendMessage(ChatColor.GOLD+"Sorry, you are already in 3 jobs!");
    		return false;
    	}
		Bukkit.getLogger().info("Max Job count checked.");
    	if (PlayerinJob(p,job)) {
    		p.sendMessage(ChatColor.GOLD+"Sorry, you are already in this job!");
    		return false;
    	}
		Bukkit.getLogger().info("Player's not in job checked.");
    	if (getConfig().getInt("jobs."+ValidJobs[matchedjob])>=getConfig().getInt("jobs.MAX_JOBS")) {
    		p.sendMessage(ChatColor.GOLD+"Sorry, there are already "+getConfig().getInt("jobs.MAX_JOBS")+" people in this job!");
    		return false;
    	}
		Bukkit.getLogger().info("Well, they are allowed to join this job.");
    	//Add 1 to main config.
    	getConfig().set("jobs."+ValidJobs[matchedjob], Integer.valueOf(getConfig().getInt("jobs."+ValidJobs[matchedjob])+1));
    	saveConfig();
		Bukkit.getLogger().info("Saved the config.");
    	//We can add them into this new job.
    	//Check for the slot we have "None" job in first.
    	int openslot=0;
    	for (int i=0;i<3;i++) {
    		if (getAccountsConfig().getString(p.getName()+".jobs.job"+(i+1)).equalsIgnoreCase("None")) {
    			openslot=i;
    			Bukkit.getLogger().info("Found a None job slot.");
    			break;
    		}
    	}
    	if (ValidJobs[matchedjob].compareTo("Explorer")==0) {
    	    explorerlist.add(new ExplorerData(p.getName(), p.getLocation().getX(), p.getLocation().getZ()));
    	}
    	if (ValidJobs[matchedjob].compareTo("Support")==0) {
    	    supportplayers.add(new SupportPlayer(p));
    	}
    	if (ValidJobs[matchedjob].compareTo("Hunter")==0) {
    	    hunterplayers.add(p);
    	}
		Bukkit.getLogger().info("Added extra job pieces when joining.");
    	getAccountsConfig().set(p.getName()+".jobs.job"+(openslot+1), String.valueOf(ValidJobs[matchedjob]));
    	getAccountsConfig().set(p.getName()+".jobs.job"+(openslot+1)+"lv", Integer.valueOf(1));
    	getAccountsConfig().set(p.getName()+".jobs.job"+(openslot+1)+"exp", Double.valueOf(0));
    	saveAccountsConfig();
		Bukkit.getLogger().info("Set job data.");
    	Bukkit.broadcastMessage(p.getName()+" has joined the "+JobColors[matchedjob]+ValidJobs[matchedjob]+ChatColor.WHITE+" job!");
    	p.sendMessage("You can check out your job progress anytime with "+ChatColor.GOLD+"/jobs stats"+ChatColor.WHITE+".");
    	return true;
    }
	
	public String[] getJobs(Player p) {
		String[] string= {getAccountsConfig().getString(p.getName()+".jobs.job1"),getAccountsConfig().getString(p.getName()+".jobs.job2"),getAccountsConfig().getString(p.getName()+".jobs.job3")};
		return string;
	}
	
	public String[] getJobs(String p) {
		String[] string= {getAccountsConfig().getString(p+".jobs.job1"),getAccountsConfig().getString(p+".jobs.job2"),getAccountsConfig().getString(p+".jobs.job3")};
		return string;
	}
	
	public boolean PlayerinJob(String p,String job) {
		String[] jobs = getJobs(p);
		for (int i=0;i<jobs.length;i++) {
			if (job.equalsIgnoreCase(jobs[i])) {
				return true;
			}
		}
		return false;
	}
	
	public boolean PlayerinJob(Player p,String job) {
		String[] jobs = getJobs(p);
		for (int i=0;i<jobs.length;i++) {
			if (job.equalsIgnoreCase(jobs[i])) {
				return true;
			}
		}
		return false;
	}
	
	public void gainMoneyExp(String p,String job,double amount,double exp) {
		Player m = Bukkit.getPlayer(p);
		if (m!=null) {
			gainMoneyExp(m,job,amount,exp);
		} else {
			Bukkit.getLogger().severe("Could not find player "+p+"! Could not add in job experience!");
		}
	}
	
	public void setMoneyExp(Player p,String job,double newamount,double newexp) {
		String[] jobs = getJobs(p);
		int slot=-1;
		JobsDataInfo[] Jobsinfo = {Woodcutter_job,Miner_job,Builder_job,Digger_job,Farmer_job,Hunter_job,Fisherman_job,Weaponsmith_job,Blacksmith_job,Cook_job,Brewer_job,Enchanter_job,Breeder_job,Explorer_job,Support_job};
		for (int i=0;i<jobs.length;i++) {
			if (job.equalsIgnoreCase(jobs[i])) {
				slot=i;
				break;
			}
		}
		JobsDataInfo info = Jobsinfo[getJobSlot(job)];
		  double val=0;
		val = economy.getBalance(p.getName());
		  economy.withdrawPlayer(p.getName(), val);
		getAccountsConfig().set(p.getName()+".jobs.job"+(slot+1)+"exp", Double.valueOf(newexp));
		saveAccountsConfig();
	}

	public void gainMoneyExp(Player p,String job,double amount,double exp) {
		String[] jobs = getJobs(p);
		int slot=-1;
		if (getConfig().getBoolean("halloween-enabled")) {
			amount*=2;
			exp*=2;
		}
		//Add to how much we've earned so far.
		for (int i=0;i<SPEED_CONTROL.size();i++) {
			if (SPEED_CONTROL.get(i).p.getName().equalsIgnoreCase(p.getName())) {
				SPEED_CONTROL.get(i).money_gained+=amount;
				break;
			}
		}
		JobsDataInfo[] Jobsinfo = {Woodcutter_job,Miner_job,Builder_job,Digger_job,Farmer_job,Hunter_job,Fisherman_job,Weaponsmith_job,Blacksmith_job,Cook_job,Brewer_job,Enchanter_job,Breeder_job,Explorer_job,Support_job};
		for (int i=0;i<jobs.length;i++) {
			if (job.equalsIgnoreCase(jobs[i])) {
				slot=i;
				break;
			}
		}
		JobsDataInfo info = Jobsinfo[getJobSlot(job)];
		economy.depositPlayer(p.getName(), amount*(1d+(info.moneymult*getAccountsConfig().getInt(p.getName()+".jobs.job"+(slot+1)+"lv"))));
		getAccountsConfig().set(p.getName()+".jobs.job"+(slot+1)+"exp", Double.valueOf(getAccountsConfig().getDouble(p.getName()+".jobs.job"+(slot+1)+"exp")+exp));
		if (getAccountsConfig().getDouble(p.getName()+".jobs.job"+(slot+1)+"exp")<0) {
			//It can't be negative.
			getAccountsConfig().set(p.getName()+".jobs.job"+(slot+1)+"exp", Double.valueOf(0.0));
		}
		//Check for lv up.
		if (getJobLv(job,p)<40 && getJobExp(job,getAccountsConfig().getInt(p.getName()+".jobs.job"+(slot+1)+"lv"))<=getAccountsConfig().getDouble(p.getName()+".jobs.job"+(slot+1)+"exp")) {
			//Level up! Level up! YEAH!
			getAccountsConfig().set(p.getName()+".jobs.job"+(slot+1)+"exp", Double.valueOf(getAccountsConfig().getDouble(p.getName()+".jobs.job"+(slot+1)+"exp")-getJobExp(job,getAccountsConfig().getInt(p.getName()+".jobs.job"+(slot+1)+"lv"))));
			getAccountsConfig().set(p.getName()+".jobs.job"+(slot+1)+"lv", Integer.valueOf(getAccountsConfig().getInt(p.getName()+".jobs.job"+(slot+1)+"lv")+1));
			Bukkit.broadcastMessage(p.getName()+" is now a Level "+getAccountsConfig().getInt(p.getName()+".jobs.job"+(slot+1)+"lv")+" "+getJobColor(job)+job+ChatColor.WHITE+".");
			if (getJobTotalLvs(p)%5==0) {
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getName()+" has reached Level "+getJobTotalLvs(p)+"!");
				if ((((getJobTotalLvs(p)/5+1)-getStatPointTotal(p)))>0) {
					p.sendMessage(ChatColor.GOLD+"You have earned 1 stat point! You now have "+(((getJobTotalLvs(p)/5+1)-getStatPointTotal(p)))+" stat point"+((((getJobTotalLvs(p)/5+1)-getStatPointTotal(p)))==1?"":"s")+" to spend. "+ChatColor.ITALIC+ChatColor.BLUE+" Type /sp to spend them!");
				}
			}
		}
		saveAccountsConfig();
	}
	
	public void levelUpJob(Player p, String job) {
		//If they have a job token, then do this. Otherwise they are not allowed.
		boolean has_job_token=false;
		ItemStack j = new ItemStack(Material.getMaterial(34));
		  ItemMeta meta = j.getItemMeta();
		  meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Job Boost Card");
		  List<String> lore = new ArrayList<String>();
		  lore.add("Use /jobs boost <jobname> to instantly level up");
		  lore.add("that job with this card!");
		  meta.setLore(lore);
		  j.setItemMeta(meta);
		if (p.getInventory().containsAtLeast(j, 1)) {
			String[] jobs = getJobs(p);
			int slot=-1;
			JobsDataInfo[] Jobsinfo = {Woodcutter_job,Miner_job,Builder_job,Digger_job,Farmer_job,Hunter_job,Fisherman_job,Weaponsmith_job,Blacksmith_job,Cook_job,Brewer_job,Enchanter_job,Breeder_job,Explorer_job,Support_job};
			for (int i=0;i<jobs.length;i++) {
				if (job.equalsIgnoreCase(jobs[i])) {
					slot=i;
					break;
				}
			}
			if (slot!=-1) {
				JobsDataInfo info = Jobsinfo[getJobSlot(job)];
				if (getJobLv(job,p)<40) {
				getAccountsConfig().set(p.getName()+".jobs.job"+(slot+1)+"lv", Integer.valueOf(getAccountsConfig().getInt(p.getName()+".jobs.job"+(slot+1)+"lv")+1));
				Bukkit.broadcastMessage(p.getName()+" is now a Level "+getAccountsConfig().getInt(p.getName()+".jobs.job"+(slot+1)+"lv")+" "+getJobColor(job)+job+ChatColor.WHITE+".");
				if (getJobTotalLvs(p)%5==0) {
					Bukkit.broadcastMessage(ChatColor.GREEN+p.getName()+" has reached Level "+getJobTotalLvs(p)+"!");
					if ((((getJobTotalLvs(p)/5+1)-getStatPointTotal(p)))>0) {
						p.sendMessage(ChatColor.GOLD+"You have earned 1 stat point! You now have "+(((getJobTotalLvs(p)/5+1)-getStatPointTotal(p)))+" stat point"+((((getJobTotalLvs(p)/5+1)-getStatPointTotal(p)))==1?"":"s")+" to spend. "+ChatColor.ITALIC+ChatColor.BLUE+" Type /sp to spend them!");
					}
				}
				saveAccountsConfig();
				p.getInventory().removeItem(j);
				} else {
		    		p.sendMessage(ChatColor.GOLD+"You can't level this job. It is already at max level.");
				}
			} else {
	    		p.sendMessage(ChatColor.GOLD+"Sorry, that is not a valid job!");
			}
		} else {
    		p.sendMessage(ChatColor.GOLD+"Sorry, you cannot do this!");
		}
	}
	
	public void gainMoney(Player p,String job,double amount) {
		String[] jobs = getJobs(p);
		int slot=-1;
		if (getConfig().getBoolean("halloween-enabled")) {
			amount*=2;
		}
		//Add to how much we've earned so far.
		for (int i=0;i<SPEED_CONTROL.size();i++) {
			if (SPEED_CONTROL.get(i).p.getName().equalsIgnoreCase(p.getName())) {
				SPEED_CONTROL.get(i).money_gained+=amount;
				break;
			}
		}
		JobsDataInfo[] Jobsinfo = {Woodcutter_job,Miner_job,Builder_job,Digger_job,Farmer_job,Hunter_job,Fisherman_job,Weaponsmith_job,Blacksmith_job,Cook_job,Brewer_job,Enchanter_job,Breeder_job,Explorer_job,Support_job};
		for (int i=0;i<jobs.length;i++) {
			if (job.equalsIgnoreCase(jobs[i])) {
				slot=i;
				break;
			}
		}
		JobsDataInfo info = Jobsinfo[getJobSlot(job)];
		economy.depositPlayer(p.getName(), amount*(1d+(info.moneymult*getAccountsConfig().getInt(p.getName()+".jobs.job"+slot+"lv"))));
	}
	
	public ChatColor getJobColor(String job) {
		for (int i=0;i<ValidJobs.length;i++) {
			if (job.equalsIgnoreCase(ValidJobs[i])) {
				return JobColors[i];
			}
		}
		return ChatColor.WHITE;
	}
	
	public int getJobSlot(String job) {
		for (int i=0;i<ValidJobs.length;i++) {
			if (job.equalsIgnoreCase(ValidJobs[i])) {
				return i;
			}
		}
		return -1;
	}
	public Player getClosestSupport(Location loc) {
		Player[] playerlist = Bukkit.getOnlinePlayers();
		Player support=null;
		double distance=9999999;
		for (int i=0;i<playerlist.length;i++) {
			if (PlayerinJob(playerlist[i], "Support")) {
				//Check their distance from location.
				double tempdist = Math.abs(playerlist[i].getLocation().getX()-loc.getX())+Math.abs(playerlist[i].getLocation().getY()-loc.getY())+Math.abs(playerlist[i].getLocation().getZ()-loc.getZ());
				if (tempdist<distance) {
					distance=tempdist;
					support=playerlist[i];
				}
			}
		}
		if (support!=null) {
			return support;
		} else {
			return null;
		}
	}

	public double getcurrentJobExp(String job, Player p) {
		if (PlayerinJob(p,job)) {
			int slot=-1;
			//Check which slot contains our job.
			for (int i=0;i<3;i++) {
				if (getAccountsConfig().getString(p.getName()+".jobs.job"+(i+1)).equalsIgnoreCase(job)) {
					slot=i;
					break;
				}
			}
			if (slot!=-1) {
				return getAccountsConfig().getDouble(p.getName()+".jobs.job"+(slot+1)+"exp");
			} else {
				return 0;
			}
		}
		return 0;
	}
	public ItemStack EnchantItem(ItemStack item,int lv,Player p) {
		return EnchantItem(item,lv,p,false);
	}
	
	public ItemStack EnchantItem(ItemStack item,int lv,Player p, boolean fromAuto) {
		boolean protection=false; //Set to true when a protection enchantment has been given.
		boolean silktouch=false; //Set to true if silk touch OR fortune is set. Only one of these can be there.
		boolean enhanceddmg=false; //Set to true if a damage increasing enchantment has been given.
		//First figure out which item this is.
	    final EnchantLevelDatabase ENCHANTMENT_DATA = new EnchantLevelDatabase();
		List<StoreValues> enchant_data = new ArrayList<StoreValues>(); //OMGGGG. forgot to initialize the dang list!
		if (item.getType()==Material.STONE_HOE || item.getType()==Material.IRON_HOE || item.getType()==Material.WOOD_HOE || item.getType()==Material.GOLD_HOE || item.getType()==Material.DIAMOND_HOE) {
			enchant_data=ENCHANTMENT_DATA.stone_hoe;
		} else
		//DERP
		if (item.getType()==Material.BOW) {enchant_data=ENCHANTMENT_DATA.bow;} else
		if (item.getType()==Material.IRON_SWORD) {enchant_data=ENCHANTMENT_DATA.iron_sword;} else
		if (item.getType()==Material.GOLD_SWORD) {enchant_data=ENCHANTMENT_DATA.gold_sword;} else
		if (item.getType()==Material.DIAMOND_SWORD) {enchant_data=ENCHANTMENT_DATA.diamond_sword;} else
		if (item.getType()==Material.STONE_SPADE) {enchant_data=ENCHANTMENT_DATA.stone_shovel;} else
		if (item.getType()==Material.STONE_PICKAXE) {enchant_data=ENCHANTMENT_DATA.stone_pickaxe;} else
		if (item.getType()==Material.LEATHER_BOOTS) {enchant_data=ENCHANTMENT_DATA.leather_boots;} else
		if (item.getType()==Material.LEATHER_LEGGINGS) {enchant_data=ENCHANTMENT_DATA.leather_pants;} else
		if (item.getType()==Material.LEATHER_CHESTPLATE) {enchant_data=ENCHANTMENT_DATA.leather_tunic;} else
		if (item.getType()==Material.LEATHER_HELMET) {enchant_data=ENCHANTMENT_DATA.leather_cap;} else
		if (item.getType()==Material.IRON_SPADE) {enchant_data=ENCHANTMENT_DATA.iron_shovel;} else
		if (item.getType()==Material.IRON_BOOTS) {enchant_data=ENCHANTMENT_DATA.iron_boots;} else
		if (item.getType()==Material.IRON_PICKAXE) {enchant_data=ENCHANTMENT_DATA.iron_pickaxe;} else
		if (item.getType()==Material.IRON_HELMET) {enchant_data=ENCHANTMENT_DATA.iron_helmet;} else
		if (item.getType()==Material.IRON_AXE) {enchant_data=ENCHANTMENT_DATA.iron_axe;} else
		if (item.getType()==Material.GOLD_SPADE) {enchant_data=ENCHANTMENT_DATA.golden_shovel;} else
		if (item.getType()==Material.GOLD_AXE) {enchant_data=ENCHANTMENT_DATA.golden_axe;} else
		if (item.getType()==Material.IRON_LEGGINGS) {enchant_data=ENCHANTMENT_DATA.iron_leggings;} else
		if (item.getType()==Material.DIAMOND_SPADE) {enchant_data=ENCHANTMENT_DATA.diamond_shovel;} else
		if (item.getType()==Material.GOLD_BOOTS) {enchant_data=ENCHANTMENT_DATA.golden_boots;} else
		if (item.getType()==Material.IRON_CHESTPLATE) {enchant_data=ENCHANTMENT_DATA.iron_chestplate;} else
		if (item.getType()==Material.GOLD_HELMET) {enchant_data=ENCHANTMENT_DATA.golden_helmet;} else
		if (item.getType()==Material.IRON_CHESTPLATE) {enchant_data=ENCHANTMENT_DATA.iron_chestplate;} else
		if (item.getType()==Material.DIAMOND_PICKAXE) {enchant_data=ENCHANTMENT_DATA.diamond_pickaxe;} else
		if (item.getType()==Material.DIAMOND_BOOTS) {enchant_data=ENCHANTMENT_DATA.diamond_boots;} else
		if (item.getType()==Material.DIAMOND_AXE) {enchant_data=ENCHANTMENT_DATA.diamond_axe;} else
		if (item.getType()==Material.GOLD_LEGGINGS) {enchant_data=ENCHANTMENT_DATA.golden_leggings;} else
		if (item.getType()==Material.GOLD_CHESTPLATE) {enchant_data=ENCHANTMENT_DATA.golden_chestplate;} else
		if (item.getType()==Material.DIAMOND_HELMET) {enchant_data=ENCHANTMENT_DATA.diamond_helmet;} else
		if (item.getType()==Material.DIAMOND_LEGGINGS) {enchant_data=ENCHANTMENT_DATA.diamond_leggings;} else
		if (item.getType()==Material.DIAMOND_CHESTPLATE) {enchant_data=ENCHANTMENT_DATA.diamond_chestplate;}
		int enchantments=0;
		int iterations=0;
		while (enchantments==0 && iterations<100) { //Attempt to enchant it, up to 100 tries.
			iterations++;
			//Bukkit.getPlayer("sigonasr2").sendMessage("Enchant data size is "+enchant_data.size());
			for (int i=0;i<enchant_data.size();i++) {
				//Bukkit.getPlayer("sigonasr2").sendMessage("Comparing level "+lv+" to enchant requirement: "+enchant_data.get(i).enchantlevel);
				if (enchant_data.get(i).enchantlevel==lv) {
					//Bukkit.getPlayer("sigonasr2").sendMessage("Checking "+enchant_data.get(i).enchant.getName());
					if (Math.random()<=enchant_data.get(i).chance) {
						//This enchantment can be added. (Assuming it's compatible.)
						if ((enchant_data.get(i).enchant.getName()==Enchantment.PROTECTION_ENVIRONMENTAL.getName() ||
								enchant_data.get(i).enchant.getName()==Enchantment.PROTECTION_EXPLOSIONS.getName() ||
								enchant_data.get(i).enchant.getName()==Enchantment.PROTECTION_FALL.getName() ||
								enchant_data.get(i).enchant.getName()==Enchantment.PROTECTION_FIRE.getName() ||
								enchant_data.get(i).enchant.getName()==Enchantment.PROTECTION_PROJECTILE.getName()) && !protection) {
							protection=true;
							enchantments++;
							item.addEnchantment(enchant_data.get(i).enchant, enchant_data.get(i).level);
						} else
						if ((enchant_data.get(i).enchant.getName()==Enchantment.DAMAGE_ALL.getName() ||
								enchant_data.get(i).enchant.getName()==Enchantment.DAMAGE_ARTHROPODS.getName() ||
								enchant_data.get(i).enchant.getName()==Enchantment.DAMAGE_UNDEAD.getName()) && !enhanceddmg) {
							enhanceddmg=true;
							enchantments++;
							item.addEnchantment(enchant_data.get(i).enchant, enchant_data.get(i).level);
						} else
						if ((enchant_data.get(i).enchant.getName()==Enchantment.SILK_TOUCH.getName() ||
								enchant_data.get(i).enchant.getName()==Enchantment.LOOT_BONUS_BLOCKS.getName() ||
								enchant_data.get(i).enchant.getName()==Enchantment.LOOT_BONUS_MOBS.getName()) && !silktouch) {
							silktouch=true;
							enchantments++;
							item.addEnchantment(enchant_data.get(i).enchant, enchant_data.get(i).level);
						} else {
							//It's not a special condition enchantment. Just make sure it doesn't exist and add it.
							if (!item.containsEnchantment(enchant_data.get(i).enchant)) {
								item.addEnchantment(enchant_data.get(i).enchant, enchant_data.get(i).level);
							}
						}
					}
					//see if we should try for a second/third/fourth enchantment.
					boolean keepgoing=false;
					if (lv==5) {
						if (enchantments==1 && Math.random()<=0.07) {
							keepgoing=true;
						} else
						if (enchantments==2 && Math.random()<=0.045) {
							keepgoing=true;
						} else
						if (enchantments==3 && Math.random()<=0.03) {
							keepgoing=true;
						}
						if (!keepgoing) {
							break;
						}
					}
				}
			}
		}
		Map<Enchantment,Integer> map = item.getEnchantments();
		boolean silk_touch=false;
		boolean fortune=false;
		  if (PlayerinJob(p, "Enchanter")) {
			  for (Map.Entry<Enchantment,Integer> entry : map.entrySet()) {
				  if (getJobLv("Enchanter", p)>=20) {
					  if (entry.getKey().getMaxLevel()<entry.getValue()) {
						  entry.setValue(entry.getValue()+1);
					  }
				  }
				  double mult=1.0d;
				  if (fromAuto) {
					  if (!item.getType().toString().toLowerCase().contains("leggings") && !item.getType().toString().toLowerCase().contains("helmet") && !item.getType().toString().toLowerCase().contains("chestplate") && !item.getType().toString().toLowerCase().contains("boots")) {
						  if (item.getType().toString().toLowerCase().contains("spade")) {
							  mult=0.015d;
						  } else
						  if (item.getType().toString().toLowerCase().contains("hoe")) {
							  mult=0.03d;
						  } else
						  if (item.getType().toString().toLowerCase().contains("sword")) {
							  mult=0.03d;
						  } else
						  if (item.getType().toString().toLowerCase().contains("pickaxe")) {
							  mult=0.045d;
						  } else
						  if (item.getType().toString().toLowerCase().contains("axe")) {
							  mult=0.045d;
						  }
					  } else {
						  if (item.hasItemMeta() && item.getItemMeta().getLore()!=null) {
							  List<String> thelore = item.getItemMeta().getLore();
							  for (int i=0;i<thelore.size();i++) {
								  if (thelore.get(i).contains(ChatColor.RED+"-400% Durability")) {
									  //This is a weak piece.
									  mult=0.10d;
								  }
							  }
						  }
					  }
					  if (item.getType().toString().toLowerCase().contains("iron")) {
						  mult/=4;
					  } else
					  if (item.getType().toString().toLowerCase().contains("gold")) {
						  mult/=2;
					  }
				  }
				  if (entry.getKey().getName()==Enchantment.PROTECTION_ENVIRONMENTAL.getName()) {
					  gainMoneyExp(p,"Enchanter",0.08*entry.getValue()*mult,4*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.DAMAGE_UNDEAD.getName()) {
					  gainMoneyExp(p,"Enchanter",0.10*entry.getValue()*mult,8*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.PROTECTION_FIRE.getName()) {
					  gainMoneyExp(p,"Enchanter",0.10*entry.getValue()*mult,6*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.DAMAGE_ARTHROPODS.getName()) {
					  gainMoneyExp(p,"Enchanter",0.12*entry.getValue()*mult,8*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.PROTECTION_FALL.getName()) {
					  gainMoneyExp(p,"Enchanter",0.14*entry.getValue()*mult,10*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.DAMAGE_ALL.getName()) {
					  gainMoneyExp(p,"Enchanter",0.15*entry.getValue()*mult,14*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.DIG_SPEED.getName()) {
					  gainMoneyExp(p,"Enchanter",0.15*entry.getValue()*mult,14*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.PROTECTION_EXPLOSIONS.getName()) {
					  gainMoneyExp(p,"Enchanter",0.20*entry.getValue()*mult,16*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.THORNS.getName()) {
					  gainMoneyExp(p,"Enchanter",0.20*entry.getValue()*mult,16*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.KNOCKBACK.getName()) {
					  gainMoneyExp(p,"Enchanter",0.20*entry.getValue()*mult,18*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.ARROW_KNOCKBACK.getName()) {
					  gainMoneyExp(p,"Enchanter",0.20*entry.getValue()*mult,18*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.FIRE_ASPECT.getName()) {
					  gainMoneyExp(p,"Enchanter",0.22*entry.getValue()*mult,20*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.ARROW_FIRE.getName()) {
					  gainMoneyExp(p,"Enchanter",0.22*entry.getValue()*mult,20*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.WATER_WORKER.getName()) {
					  gainMoneyExp(p,"Enchanter",0.25*entry.getValue()*mult,16*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.OXYGEN.getName()) {
					  gainMoneyExp(p,"Enchanter",0.30*entry.getValue()*mult,20*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.DURABILITY.getName()) {
					  gainMoneyExp(p,"Enchanter",0.35*entry.getValue()*mult,24*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.ARROW_INFINITE.getName()) {
					  gainMoneyExp(p,"Enchanter",0.40*entry.getValue()*mult,40*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.LOOT_BONUS_MOBS.getName()) {
					  gainMoneyExp(p,"Enchanter",0.40*entry.getValue()*mult,30*entry.getValue()*mult);
				  }
				  if (entry.getKey().getName()==Enchantment.LOOT_BONUS_BLOCKS.getName()) {
					  gainMoneyExp(p,"Enchanter",0.50*entry.getValue()*mult,40*entry.getValue()*mult);
					  fortune=true;
				  }
				  if (entry.getKey().getName()==Enchantment.SILK_TOUCH.getName()) {
					  gainMoneyExp(p,"Enchanter",0.50*entry.getValue()*mult,40*entry.getValue()*mult);
					  silk_touch=true;
				  }
			  }
		  }
		  if (fortune && silk_touch) {
			  if (Math.random()<=0.5) {
				  item.removeEnchantment(Enchantment.SILK_TOUCH);
			  } else {
				  item.removeEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
			  }
		  }
		return item;
	}
	
	public int getJobLv(String job, String p) {
		if (PlayerinJob(p,job)) {
			int slot=-1;
			//Check which slot contains our job.
			for (int i=0;i<3;i++) {
				if (getAccountsConfig().getString(p+".jobs.job"+(i+1)).equalsIgnoreCase(job)) {
					slot=i;
					break;
				}
			}
			if (slot!=-1) {
				return getAccountsConfig().getInt(p+".jobs.job"+(slot+1)+"lv");
			} else {
				return 0;
			}
		}
		return 0;
	}
	
	public int getPlayerDataSlot(Player p) {
		  //Find my data.
		  for (int i=0;i<playerdata_list.size();i++) {
			  if (playerdata_list.get(i).data.getName().compareToIgnoreCase(p.getName())==0) {
				  return i;
			  }
		  }
		  return 0;
	}
	
	public int getJobLv(String job, Player p) {
		if (PlayerinJob(p,job)) {
			int slot=-1;
			//Check which slot contains our job.
			for (int i=0;i<3;i++) {
				if (getAccountsConfig().getString(p.getName()+".jobs.job"+(i+1)).equalsIgnoreCase(job)) {
					slot=i;
					break;
				}
			}
			if (slot!=-1) {
				return getAccountsConfig().getInt(p.getName()+".jobs.job"+(slot+1)+"lv");
			} else {
				return 0;
			}
		}
		return 0;
	}
	
	public int getJobTotalLvs(Player p) {
		int totallv=0;
		//Check which slot contains our job.
		for (int i=0;i<3;i++) {
			totallv+=getAccountsConfig().getInt(p.getName()+".jobs.job"+(i+1)+"lv");
		}
		return totallv;
	}
	
	public int getStatPointTotal(Player p) {
		int total=0;
		for (int i=0;i<10;i++) {
			total+=getAccountsConfig().getInt(p.getName()+".stats.stat"+(i+1));
		}
		return total;
	}
	
	public int getStatBonus(int stat, int upgrade_lv) {
		switch (stat) {
			case 0: {
				switch (upgrade_lv) {
					case 1:{
						return 1;
					}
					case 2:{
						return 2;
					}
					case 3:{
						return 3;
					}
					case 4:{
						return 5;
					}
					case 5:{
						
					}
					case 6:{
						
					}
					case 7:{
						
					}
					case 8:{
						
					}
					case 9:{
						
					}
					case 10:{
						
					}
					case 11:{
						
					}
					case 12:{
						
					}
				}
			}
			case 1: {
				switch (upgrade_lv) {
					case 1:{
						return 20;
					}
					case 2:{
						return 40;
					}
					case 3:{
						return 60;
					}
					case 4:{
						return 80;
					}
					case 5:{
						return 120;
					}
					case 6:{
						
					}
					case 7:{
						
					}
					case 8:{
						
					}
					case 9:{
						
					}
					case 10:{
						
					}
					case 11:{
						
					}
					case 12:{
						
					}
				}
			}
			case 2: {
				switch (upgrade_lv) {
					case 1:{
						return 10;
					}
					case 2:{
						return 20;
					}
					case 3:{
						return 30;
					}
					case 4:{
						return 40;
					}
					case 5:{
						return 55;
					}
					case 6:{
						return 75;
					}
					case 7:{
						
					}
					case 8:{
						
					}
					case 9:{
						
					}
					case 10:{
						
					}
					case 11:{
						
					}
					case 12:{
						
					}
				}
			}
			case 3: {
				switch (upgrade_lv) {
					case 1:{
						return 4;
					}
					case 2:{
						return 8;
					}
					case 3:{
						return 12;
					}
					case 4:{
						return 16;
					}
					case 5:{
						return 22;
					}
					case 6:{
						return 28;
					}
					case 7:{
						return 32;
					}
					case 8:{
						return 40;
					}
					case 9:{
						
					}
					case 10:{
						
					}
					case 11:{
						
					}
					case 12:{
						
					}
				}
			}
			case 4: {
				switch (upgrade_lv) {
					case 1:{
						return 1;
					}
					case 2:{
						return 2;
					}
					case 3:{
						return 3;
					}
					case 4:{
						return 4;
					}
					case 5:{
						return 6;
					}
					case 6:{
						return 8;
					}
					case 7:{
						
					}
					case 8:{
						
					}
					case 9:{
						
					}
					case 10:{
						
					}
					case 11:{
						
					}
					case 12:{
						
					}
				}
			}
			case 5: {
				switch (upgrade_lv) {
					case 1:{
						return 1;
					}
					case 2:{
						return 2;
					}
					case 3:{
						return 3;
					}
					case 4:{
						return 4;
					}
					case 5:{
						return 6;
					}
					case 6:{
						return 7;
					}
					case 7:{
						return 8;
					}
					case 8:{
						return 12;
					}
					case 9:{
						
					}
					case 10:{
						
					}
					case 11:{
						
					}
					case 12:{
						
					}
				}
			}
			case 6: {
				switch (upgrade_lv) {
					case 1:{
						return 1;
					}
					case 2:{
						return 2;
					}
					case 3:{
						return 3;
					}
					case 4:{
						return 4;
					}
					case 5:{
						return 6;
					}
					case 6:{
						return 7;
					}
					case 7:{
						return 8;
					}
					case 8:{
						return 9;
					}
					case 9:{
						return 10;
					}
					case 10:{
						return 13;
					}
					case 11:{
						return 14;
					}
					case 12:{
						return 18;
					}
				}
			}
			case 7: {
				switch (upgrade_lv) {
					case 1:{
						return 2;
					}
					case 2:{
						return 4;
					}
					case 3:{
						return 6;
					}
					case 4:{
						return 8;
					}
					case 5:{
						return 14;
					}
					case 6:{
						return 16;
					}
					case 7:{
						return 18;
					}
					case 8:{
						return 20;
					}
					case 9:{
						return 22;
					}
					case 10:{
						return 30;
					}
					case 11:{
						return 32;
					}
					case 12:{
						return 48;
					}
				}
			}
			case 8: {
				return 4*upgrade_lv;
			}
			case 9: {
				return 10*upgrade_lv;
			}
			default: {
				return 0;
			}
		}
	}
	
	public double getJobExp(String job,int lv) {
		for (int i=0;i<ValidJobs.length;i++) {
			if (job.equalsIgnoreCase(ValidJobs[i])) {
				JobsDataInfo[] Jobsinfo = {Woodcutter_job,Miner_job,Builder_job,Digger_job,Farmer_job,Hunter_job,Fisherman_job,Weaponsmith_job,Blacksmith_job,Cook_job,Brewer_job,Enchanter_job,Breeder_job,Explorer_job,Support_job};
				double baseexp=Jobsinfo[i].basexp;
				double lvupexp=Jobsinfo[i].explvup;
				double lvupexpbooster=Jobsinfo[i].explvmult;
				double expbuildup=baseexp;
				for (int j=0;j<(lv-1);j++) {
					expbuildup+=lvupexp+(lvupexpbooster*(j+1));
				}
				return expbuildup;
			}
		}
		return 0;
	}

    public boolean leaveJob(Player p, String job) {
    	//Verify this is a valid job we can leave.
    	boolean valid=false;
    	int matchedjob=0;
    	for (int i=0;i<ValidJobs.length;i++) {
    		if (job.equalsIgnoreCase(ValidJobs[i])) {
    			valid=true;
    			matchedjob=i;
    			break;
    		}
    	}
    	if (!valid) {
    		p.sendMessage(ChatColor.GOLD+"Sorry, that is not a valid job!");
    		return false;
    	}
    	if (getPlayerJobCount(p)==0) {
    		p.sendMessage(ChatColor.GOLD+"Sorry, you are not in that job!");
    		return false;
    	}
    	if (!PlayerinJob(p,job)) {
    		p.sendMessage(ChatColor.GOLD+"Sorry, you are not in that job!");
    		return false;
    	}
    	
    	//Get their jobs.
    	String[] jobs = getJobs(p);
    	//We can remove them from this job.
    	if (job.equalsIgnoreCase(getAccountsConfig().getString(p.getName()+".jobs.job1"))) {
        	//Remove 1 from main config.
        	getConfig().set("jobs."+getAccountsConfig().getString(p.getName()+".jobs.job1"), Integer.valueOf(getConfig().getInt("jobs."+getAccountsConfig().getString(p.getName()+".jobs.job1"))-1));
        	saveConfig();
    		//Remove from job 1.
        	Bukkit.broadcastMessage(p.getName()+" has left the "+getJobColor(getAccountsConfig().getString(p.getName()+".jobs.job1"))+getAccountsConfig().getString(p.getName()+".jobs.job1")+ChatColor.WHITE+" job!");
        	getAccountsConfig().set(p.getName()+".jobs.job1", String.valueOf("None"));
        	getAccountsConfig().set(p.getName()+".jobs.job1lv", Integer.valueOf(0));
        	getAccountsConfig().set(p.getName()+".jobs.job1exp", Double.valueOf(0));
        	saveAccountsConfig();
        	return true;
    	} else
    	if (job.equalsIgnoreCase(getAccountsConfig().getString(p.getName()+".jobs.job2"))) {
        	//Remove 1 from main config.
        	getConfig().set("jobs."+getAccountsConfig().getString(p.getName()+".jobs.job2"), Integer.valueOf(getConfig().getInt("jobs."+getAccountsConfig().getString(p.getName()+".jobs.job2"))-1));
        	saveConfig();
    		//Remove from job 2.
        	Bukkit.broadcastMessage(p.getName()+" has left the "+getJobColor(getAccountsConfig().getString(p.getName()+".jobs.job2"))+getAccountsConfig().getString(p.getName()+".jobs.job2")+ChatColor.WHITE+" job!");
        	getAccountsConfig().set(p.getName()+".jobs.job2", String.valueOf("None"));
        	getAccountsConfig().set(p.getName()+".jobs.job2lv", Integer.valueOf(0));
        	getAccountsConfig().set(p.getName()+".jobs.job2exp", Double.valueOf(0));
        	saveAccountsConfig();
        	return true;
    	} else
    	if (job.equalsIgnoreCase(getAccountsConfig().getString(p.getName()+".jobs.job3"))) {
        	//Remove 1 from main config.
        	getConfig().set("jobs."+getAccountsConfig().getString(p.getName()+".jobs.job3"), Integer.valueOf(getConfig().getInt("jobs."+getAccountsConfig().getString(p.getName()+".jobs.job3"))-1));
        	saveConfig();
    		//Remove from job 3.
        	Bukkit.broadcastMessage(p.getName()+" has left the "+getJobColor(getAccountsConfig().getString(p.getName()+".jobs.job3"))+getAccountsConfig().getString(p.getName()+".jobs.job3")+ChatColor.WHITE+" job!");
        	getAccountsConfig().set(p.getName()+".jobs.job3", String.valueOf("None"));
        	getAccountsConfig().set(p.getName()+".jobs.job3lv", Integer.valueOf(0));
        	getAccountsConfig().set(p.getName()+".jobs.job3exp", Double.valueOf(0));
        	saveAccountsConfig();
        	return true;
    	}
		Bukkit.broadcastMessage(ChatColor.RED+"[SEVERE]An internal error occurred, triggered by "+p.getName()+".");
    	return false;
    }
    
    public boolean inventoryFull(Player p){
    	//Returns if the player's inventory is full(true) or not(false).
    	boolean full=true;
    	for (int i=0;i<p.getInventory().getContents().length;i++) {
    		if (p.getInventory().getContents()[i]==null || p.getInventory().getContents()[i].getType()==Material.AIR) {
    			full=false;
    			break;
    		}
    	}
    	return full;
    }
    
    public boolean isBroken(ItemStack i) {
    	if (i!=null && i.hasItemMeta() && i.getItemMeta().getLore()!=null) {
    		for (int j=0;j<i.getItemMeta().getLore().size();j++) {
    			if (i.getItemMeta().getLore().get(j).contains("Will be repaired @ ")) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public boolean containsEnchantment(String s, String enchant) {
  	  if (s.contains(enchant)) {
  		  return true;
  	  }
  	  return false;
    }
    
    public boolean is_ItemCube(ItemStack i) {
    	if (i.hasItemMeta() && i.getItemMeta().hasLore() && i.getItemMeta().getLore()!=null) {
			//Check to see if the Lore contains anything.
			for (int j=0;j<i.getItemMeta().getLore().size();j++) {
				if (i.getItemMeta().getLore().get(j).equalsIgnoreCase(ChatColor.AQUA+"Contains 9 item slots.")) {
					return true;
				}
				if (i.getItemMeta().getLore().get(j).equalsIgnoreCase(ChatColor.AQUA+"Contains 54 item slots.")) {
					return true;
				}
			}
    	}
    	return false;
    }
    
    public double getEnchantmentNumb(String s) {
  	  //Parse the string for spaces.
  	  String[] enchant = s.split(" ");
  	  if (enchant[0].contains(ChatColor.YELLOW+"")) {
  		  String newstring = ((enchant[0].replace(ChatColor.YELLOW.getChar(), ' ')).replace('%', ' ')).replace(Character.toString((char)0x00A7), Character.toString((char)0x0020));
  		  //Bukkit.getLogger().info("Enchant number is "+Double.valueOf(newstring));
  		  return Double.valueOf(newstring);
  	  } else {
  		  return 0;
  	  }
    }
}