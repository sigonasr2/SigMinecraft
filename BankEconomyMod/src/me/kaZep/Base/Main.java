package me.kaZep.Base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
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

import me.kaZep.Base.BonusEnchantment.ItemType;
import me.kaZep.Commands.JobsDataInfo;
import me.kaZep.Commands.JobsDataInfo.Job;
import me.kaZep.Commands.commandBankEconomy;
import net.jmhertlein.mctowns.MCTowns;
import net.milkbowl.vault.economy.Economy;

import org.apache.commons.lang.math.IntRange;
import org.apache.commons.lang.math.Range;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
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
import org.bukkit.entity.Creature;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Item;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Vector;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import sig.ItemSets.ColorSet;
import sig.ItemSets.ItemSet;
import sig.ItemSets.ItemSetList;

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
  public long last_player_death_time=0;
  public long last_sight_check_time=0;
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
  public List<TempBlock> TEMP_BLOCKS = null;
  public List<PlayerData> playerdata_list = null;
  public List<InvisibilityData> ninjavisible_list = null;
  public List<ReviveInventory> revive_inventory_list = null;
  public List<Chunk> chunk_queue_list = null;
  public static List<RecyclingCenterNode> recycling_center_list = null;
  public static List<BonusEnchantment> bonus_enchantment_list = null;
  public DamageAPI DMGCALC = null;
  public long lastMessage = 0;
  public static ItemSetList ItemSetList = null;
  
  
  public static BonusEnchantment ENCHANT_CRITICAL_CHANCE, ENCHANT_ARMOR_PENETRATION, ENCHANT_LIFE_STEAL,
  	ENCHANT_ATTACK_SPEED, ENCHANT_DAMAGE, ENCHANT_HEALTH, ENCHANT_DAMAGE_REDUCTION, ENCHANT_DURABILITY,
  	ENCHANT_BLOCK_CHANCE, ENCHANT_SPEED_BOOST_CHANCE, ENCHANT_STURDY, ENCHANT_REPAIR, ENCHANT_EXECUTE;
  

  public FileWriter outputStream = null;
  
  public EnchantLevelDatabase ENCHANTMENT_DATA;
  File f;
  
  public Material[] RARE_BLOCKS = {Material.BEACON,Material.ANVIL,Material.ACTIVATOR_RAIL,Material.BEDROCK,Material.BOOKSHELF,Material.DAYLIGHT_DETECTOR,Material.COAL_ORE,Material.CLAY,Material.DIAMOND_ORE,Material.IRON_ORE,Material.REDSTONE_ORE,Material.EMERALD_ORE,Material.GOLD_ORE,Material.LAPIS_ORE,Material.OBSIDIAN,Material.MOSSY_COBBLESTONE,Material.MOB_SPAWNER,Material.NETHER_BRICK,Material.NETHER_FENCE,Material.JUKEBOX,Material.QUARTZ_ORE,Material.PORTAL,Material.PISTON_BASE,Material.REDSTONE_WIRE,Material.DISPENSER,Material.LOG,Material.MYCEL,Material.HUGE_MUSHROOM_1,Material.HUGE_MUSHROOM_2};
  long GLOBAL_villagetimer=0,GLOBAL_templetimer=0,GLOBAL_cavetimer=0,GLOBAL_undergroundtimer=0,GLOBAL_nethertimer=0;
  

	public String[] ValidJobs = {"Woodcutter","Miner","Builder","Digger","Hunter","Fisherman","Weaponsmith","Blacksmith","Cook","Brewer","Enchanter","Breeder","Explorer","Support"};
	public ChatColor[] JobColors = {ChatColor.GREEN,ChatColor.GRAY,ChatColor.WHITE,ChatColor.GOLD,ChatColor.RED,ChatColor.AQUA,ChatColor.DARK_PURPLE,ChatColor.GOLD,
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
		  //Bukkit.broadcastMessage("Main: HP too high for ID "+id+". HP was "+hp);
	  }
	  return hp;
  }
  
  public void onEnable()
  {
    getServer().getPluginManager().registerEvents(this.pl, this);
    
    cleaned=false;
    
    if (Bukkit.getPluginManager().isPluginEnabled("MCTowns")) {
    	Bukkit.getLogger().info("MCTowns loaded.");
    }
    
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
    getCommand("line").setExecutor(new commandBankEconomy(this));
    getCommand("rectangle").setExecutor(new commandBankEconomy(this));

    setupEconomy();

    getConfig().options().copyDefaults(true);
    getConfig().addDefault("start-balance", Integer.valueOf(0));
    getConfig().addDefault("payday.enabled", Boolean.valueOf(false));
    getConfig().addDefault("payday.time", Integer.valueOf(60));
    getConfig().addDefault("payday.amount", Integer.valueOf(0));
    getConfig().addDefault("fed.mobs", String.valueOf(""));
    getConfig().addDefault("maintenance-mode", Boolean.valueOf(false));
    getConfig().addDefault("halloween-enabled", Boolean.valueOf(false));
    getConfig().addDefault("thanksgiving-enabled", Boolean.valueOf(false));
    getConfig().addDefault("item-cube-numb", Integer.valueOf(0));
    getConfig().addDefault("server-tick-time", Long.valueOf(143000000l));
    saveConfig();
    
    SERVER_TICK_TIME = getConfig().getLong("server-tick-time");

    getAccountsConfig().options().copyDefaults(true);
    //saveAccountsConfig() //Commented out;
    
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
    TEMP_BLOCKS = new ArrayList<TempBlock>();
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
    
    //Add Recipe for nether star crafting.
    ShapedRecipe nether_star = new ShapedRecipe(new ItemStack(Material.NETHER_STAR, 2));
    nether_star.shape("aaa", "bbb", "cbd");
    nether_star.setIngredient('a', new MaterialData(Material.SKULL_ITEM, (byte) 1));
    nether_star.setIngredient('b', Material.SOUL_SAND);
    nether_star.setIngredient('c', Material.NETHER_STAR);
    nether_star.setIngredient('d', Material.DIAMOND);
    Bukkit.addRecipe(nether_star);
    
    //Add Recipe for water source crafting.
    ItemStack water = new ItemStack(Material.WATER, 8);
    ItemMeta water_name = water.getItemMeta();
    

    
    List<String> waterlore = new ArrayList<String>();
    waterlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"Infused with the power of a");
    waterlore.add(ChatColor.AQUA+"Nether Star"+ChatColor.GRAY+""+ChatColor.ITALIC+", this water can");
    waterlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"be carried without a bucket,");
    waterlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"and does not evaporate when");
    waterlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"placed in the Nether.");
    water_name.setLore(waterlore);
    water_name.setDisplayName(ChatColor.AQUA+"Enchanted Water");

    water.setItemMeta(water_name);

    ShapedRecipe nether_water = new ShapedRecipe(water);
    
    nether_water.shape("aaa", "aba", "aaa");
    nether_water.setIngredient('a', Material.WATER_BUCKET);
    nether_water.setIngredient('b', Material.NETHER_STAR);

    Bukkit.addRecipe(nether_water);
    
    
    
    //Add Battle Shovel recipe.
    ItemStack shovel = new ItemStack(Material.WOOD_SPADE);
    ItemMeta shovel_meta = shovel.getItemMeta();
    List<String> shovel_meta_lore = new ArrayList<String>();
    shovel_meta_lore.add(ChatColor.GOLD+"Whenever this shovel destroys");
    shovel_meta_lore.add(ChatColor.GOLD+"a block, it releases 20 arrows");
    shovel_meta_lore.add(ChatColor.GOLD+"that fire in the destructing");
    shovel_meta_lore.add(ChatColor.GOLD+"player's facing direction.");
    shovel_meta.setLore(shovel_meta_lore);
    shovel_meta.setDisplayName(ChatColor.RED+"Battle Shovel");
    shovel.setItemMeta(shovel_meta);
    shovel.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
    ShapedRecipe battle_shovel = new ShapedRecipe(shovel);
    battle_shovel.shape("-a-","-b-","-b-");
    battle_shovel.setIngredient('a', Material.LAPIS_BLOCK);
    battle_shovel.setIngredient('b', Material.STICK);
    Bukkit.addRecipe(battle_shovel);
    
    //Add Recipe for orb of distortion
    ItemStack orb = new ItemStack(Material.SLIME_BALL, 1);
    ItemMeta orb_name = orb.getItemMeta();
   
    List<String> orblore = new ArrayList<String>();
    orblore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"");
    orblore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"This orb distorts space-time");
    orblore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"around it, preventing anyone");
    orblore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"from teleporting to its carrier.");
    orb_name.setLore(orblore);
    orb_name.setDisplayName(ChatColor.AQUA+"Orb of Distortion");

    orb.setItemMeta(orb_name);
    orb.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);

    ShapedRecipe distortion_orb = new ShapedRecipe(orb);
    
    distortion_orb.shape("aaa", "aba", "aaa");
    distortion_orb.setIngredient('a', Material.ENDER_PEARL);
    distortion_orb.setIngredient('b', Material.ENDER_STONE);

    Bukkit.addRecipe(distortion_orb);
    
    //Add Recipe for rose of distortion
    ItemStack rose = new ItemStack(Material.RED_ROSE, 1);
    ItemMeta rose_name = rose.getItemMeta();
   
    List<String> roselore = new ArrayList<String>();
    roselore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"");
    roselore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"This flower is infused with");
    roselore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"overwhelming magical power,");
    roselore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"causing it to never wilt.");
    roselore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"");
    roselore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"The holder of this flower");
    roselore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"will also be resistant to");
    roselore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"any "+ChatColor.RESET+"WITHER"+ChatColor.GRAY+""+ChatColor.ITALIC+" effects.");
    rose_name.setLore(roselore);
    rose_name.setDisplayName(ChatColor.AQUA+"Unwilting Flower");

    rose.setItemMeta(rose_name);
    rose.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);

    ShapedRecipe witherless_rose = new ShapedRecipe(rose);
    
    witherless_rose.shape(" a ", "aba", " a ");
    witherless_rose.setIngredient('a', Material.NETHER_STAR);
    witherless_rose.setIngredient('b', Material.RED_ROSE);

    Bukkit.addRecipe(witherless_rose);
    
  //Add Recipe for pocket crafting table
    ItemStack table = new ItemStack(Material.WORKBENCH);
    ItemMeta table_name = table.getItemMeta();
    table_name.setDisplayName(ChatColor.YELLOW+"Pocket Crafting Table");
   
    List<String> tablelore = new ArrayList<String>();
    tablelore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"This workbench can be");
    tablelore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"used anywhere! Simply");
    tablelore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"right click to open its");
    tablelore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"crafting interface.");
    table_name.setLore(tablelore);

    table.setItemMeta(table_name);

    ShapelessRecipe portable_table = new ShapelessRecipe(table);
    
    portable_table.addIngredient(Material.WORKBENCH);
    portable_table.addIngredient(Material.CHEST);
    portable_table.addIngredient(Material.IRON_AXE);

    Bukkit.addRecipe(portable_table);

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
    ShapedRecipe nether_quartz = new ShapedRecipe(new ItemStack(Material.QUARTZ_BLOCK, 1));
    nether_quartz.shape("aa");
    nether_quartz.setIngredient('a', new ItemStack(Material.STEP, 1, (short) 7).getData());
    Bukkit.addRecipe(nether_quartz);    

    //Add Recipes for chain armor crafting.
    ShapedRecipe chain_helmet = new ShapedRecipe(new ItemStack(Material.CHAINMAIL_HELMET));
    chain_helmet.shape("aaa","b b");
    chain_helmet.setIngredient('a', Material.IRON_BLOCK);
    chain_helmet.setIngredient('b', Material.IRON_INGOT);
    Bukkit.addRecipe(chain_helmet);
    
    ShapedRecipe chain_chestplate = new ShapedRecipe(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
    chain_chestplate.shape("b b","aba","aaa");
    chain_chestplate.setIngredient('a', Material.IRON_BLOCK);
    chain_chestplate.setIngredient('b', Material.IRON_INGOT);
    Bukkit.addRecipe(chain_chestplate);
    
    ShapedRecipe chain_leggings = new ShapedRecipe(new ItemStack(Material.CHAINMAIL_LEGGINGS));
    chain_leggings.shape("bbb","a a","a a");
    chain_leggings.setIngredient('a', Material.IRON_BLOCK);
    chain_leggings.setIngredient('b', Material.IRON_INGOT);
    Bukkit.addRecipe(chain_leggings);
    
    ShapedRecipe chain_boots = new ShapedRecipe(new ItemStack(Material.CHAINMAIL_BOOTS));
    chain_boots.shape("b b","a a");
    chain_boots.setIngredient('a', Material.IRON_BLOCK);
    chain_boots.setIngredient('b', Material.IRON_INGOT);
    Bukkit.addRecipe(chain_boots);
    
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
    
    // Add Recipe for fireproof Wooden Slab
    ItemStack slab = new ItemStack(Material.STEP, 3, (short) 2);
    ItemMeta slab_name = slab.getItemMeta();
    slab_name.setDisplayName(ChatColor.RESET+"Fireproof Wood Slab");
    slab.setItemMeta(slab_name);
    ShapedRecipe fireproof_wood_slab = new ShapedRecipe(slab);
    fireproof_wood_slab.shape(" a ","bbb");
    fireproof_wood_slab.setIngredient('a', Material.SLIME_BALL);
    fireproof_wood_slab.setIngredient('b', Material.WOOD_STEP);
    Bukkit.addRecipe(fireproof_wood_slab);
    
    // Add high efficiency recipes for wool
    // White
    ShapedRecipe woolRecipe;
    
    for (int i = 0; i < 16; i++) {
	    woolRecipe = new ShapedRecipe(new ItemStack(Material.WOOL, 8, (short) i));
	    woolRecipe.shape("aaa","aba", "aaa");
	    woolRecipe.setIngredient('a', Material.WOOL);
	    woolRecipe.setIngredient('b', new MaterialData(Material.INK_SACK, (byte) (15 - i)));
	    Bukkit.addRecipe(woolRecipe);
    }
    
    // Add Recipes for Item cube crafting.
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
    temp = new ItemStack(Material.ENDER_CHEST);
    tempmeta = temp.getItemMeta();
    tempmeta.setDisplayName(ChatColor.BLUE+"Ender Item Cube");
    templore = new ArrayList<String>();
    templore.add(ChatColor.AQUA+"Contains 27 item slots.");
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
    item_cube.setIngredient('c', Material.EMERALD_BLOCK);
    Bukkit.addRecipe(item_cube);
    
    ShapelessRecipe artifact_clay = new ShapelessRecipe(new ItemStack(Material.CLAY_BALL));
    artifact_clay.addIngredient(Material.CLAY_BALL);
    artifact_clay.addIngredient(Material.EYE_OF_ENDER);
    Bukkit.addRecipe(artifact_clay);
    
    //Add deconversion recipes.
    ShapelessRecipe DeConv_diamond_chestplate = new ShapelessRecipe(new ItemStack(Material.DIAMOND));
    DeConv_diamond_chestplate.addIngredient(Material.DIAMOND_CHESTPLATE);
    ShapelessRecipe DeConv_iron_chestplate = new ShapelessRecipe(new ItemStack(Material.IRON_INGOT));
    DeConv_iron_chestplate.addIngredient(Material.IRON_CHESTPLATE);
    ShapelessRecipe DeConv_gold_chestplate = new ShapelessRecipe(new ItemStack(Material.GOLD_INGOT));
    DeConv_gold_chestplate.addIngredient(Material.GOLD_CHESTPLATE);
    ShapelessRecipe DeConv_chainmail_chestplate = new ShapelessRecipe(new ItemStack(Material.IRON_INGOT));
    DeConv_chainmail_chestplate.addIngredient(Material.CHAINMAIL_CHESTPLATE);
    ShapelessRecipe DeConv_diamond_helmet = new ShapelessRecipe(new ItemStack(Material.DIAMOND));
    DeConv_diamond_helmet.addIngredient(Material.DIAMOND_HELMET);
    ShapelessRecipe DeConv_iron_helmet = new ShapelessRecipe(new ItemStack(Material.IRON_INGOT));
    DeConv_iron_helmet.addIngredient(Material.IRON_HELMET);
    ShapelessRecipe DeConv_gold_helmet = new ShapelessRecipe(new ItemStack(Material.GOLD_INGOT));
    DeConv_gold_helmet.addIngredient(Material.GOLD_HELMET);
    ShapelessRecipe DeConv_chainmail_helmet = new ShapelessRecipe(new ItemStack(Material.IRON_INGOT));
    DeConv_chainmail_helmet.addIngredient(Material.CHAINMAIL_HELMET);
    ShapelessRecipe DeConv_diamond_leggings = new ShapelessRecipe(new ItemStack(Material.DIAMOND));
    DeConv_diamond_leggings.addIngredient(Material.DIAMOND_LEGGINGS);
    ShapelessRecipe DeConv_iron_leggings = new ShapelessRecipe(new ItemStack(Material.IRON_INGOT));
    DeConv_iron_leggings.addIngredient(Material.IRON_LEGGINGS);
    ShapelessRecipe DeConv_gold_leggings = new ShapelessRecipe(new ItemStack(Material.GOLD_INGOT));
    DeConv_gold_leggings.addIngredient(Material.GOLD_LEGGINGS);
    ShapelessRecipe DeConv_chainmail_leggings = new ShapelessRecipe(new ItemStack(Material.IRON_INGOT));
    DeConv_chainmail_leggings.addIngredient(Material.CHAINMAIL_LEGGINGS);
    ShapelessRecipe DeConv_diamond_boots = new ShapelessRecipe(new ItemStack(Material.DIAMOND));
    DeConv_diamond_boots.addIngredient(Material.DIAMOND_BOOTS);
    ShapelessRecipe DeConv_iron_boots = new ShapelessRecipe(new ItemStack(Material.IRON_INGOT));
    DeConv_iron_boots.addIngredient(Material.IRON_BOOTS);
    ShapelessRecipe DeConv_gold_boots = new ShapelessRecipe(new ItemStack(Material.GOLD_INGOT));
    DeConv_gold_boots.addIngredient(Material.GOLD_BOOTS);
    ShapelessRecipe DeConv_chainmail_boots = new ShapelessRecipe(new ItemStack(Material.IRON_INGOT));
    DeConv_chainmail_boots.addIngredient(Material.CHAINMAIL_BOOTS);
    ShapelessRecipe DeConv_diamond_pickaxe = new ShapelessRecipe(new ItemStack(Material.DIAMOND));
    DeConv_diamond_pickaxe.addIngredient(Material.DIAMOND_PICKAXE);
    ShapelessRecipe DeConv_iron_pickaxe = new ShapelessRecipe(new ItemStack(Material.IRON_INGOT));
    DeConv_iron_pickaxe.addIngredient(Material.IRON_PICKAXE);
    ShapelessRecipe DeConv_gold_pickaxe = new ShapelessRecipe(new ItemStack(Material.GOLD_INGOT));
    DeConv_gold_pickaxe.addIngredient(Material.GOLD_PICKAXE);
    ShapelessRecipe DeConv_stone_pickaxe = new ShapelessRecipe(new ItemStack(Material.COBBLESTONE));
    DeConv_stone_pickaxe.addIngredient(Material.STONE_PICKAXE);
    ShapelessRecipe DeConv_diamond_spade = new ShapelessRecipe(new ItemStack(Material.DIAMOND));
    DeConv_diamond_spade.addIngredient(Material.DIAMOND_SPADE);
    ShapelessRecipe DeConv_iron_spade = new ShapelessRecipe(new ItemStack(Material.IRON_INGOT));
    DeConv_iron_spade.addIngredient(Material.IRON_SPADE);
    ShapelessRecipe DeConv_gold_spade = new ShapelessRecipe(new ItemStack(Material.GOLD_INGOT));
    DeConv_gold_spade.addIngredient(Material.GOLD_SPADE);
    ShapelessRecipe DeConv_stone_spade = new ShapelessRecipe(new ItemStack(Material.COBBLESTONE));
    DeConv_stone_spade.addIngredient(Material.STONE_SPADE);
    ShapelessRecipe DeConv_diamond_axe = new ShapelessRecipe(new ItemStack(Material.DIAMOND));
    DeConv_diamond_axe.addIngredient(Material.DIAMOND_AXE);
    ShapelessRecipe DeConv_iron_axe = new ShapelessRecipe(new ItemStack(Material.IRON_INGOT));
    DeConv_iron_axe.addIngredient(Material.IRON_AXE);
    ShapelessRecipe DeConv_gold_axe = new ShapelessRecipe(new ItemStack(Material.GOLD_INGOT));
    DeConv_gold_axe.addIngredient(Material.GOLD_AXE);
    ShapelessRecipe DeConv_stone_axe = new ShapelessRecipe(new ItemStack(Material.COBBLESTONE));
    DeConv_stone_axe.addIngredient(Material.STONE_AXE);
    ShapelessRecipe DeConv_diamond_hoe = new ShapelessRecipe(new ItemStack(Material.DIAMOND));
    DeConv_diamond_hoe.addIngredient(Material.DIAMOND_HOE);
    ShapelessRecipe DeConv_iron_hoe = new ShapelessRecipe(new ItemStack(Material.IRON_INGOT));
    DeConv_iron_hoe.addIngredient(Material.IRON_HOE);
    ShapelessRecipe DeConv_gold_hoe = new ShapelessRecipe(new ItemStack(Material.GOLD_INGOT));
    DeConv_gold_hoe.addIngredient(Material.GOLD_HOE);
    ShapelessRecipe DeConv_stone_hoe = new ShapelessRecipe(new ItemStack(Material.COBBLESTONE));
    DeConv_stone_hoe.addIngredient(Material.STONE_HOE);
    Bukkit.addRecipe(DeConv_diamond_chestplate);
    Bukkit.addRecipe(DeConv_iron_chestplate);
    Bukkit.addRecipe(DeConv_gold_chestplate);
    Bukkit.addRecipe(DeConv_chainmail_chestplate);
    Bukkit.addRecipe(DeConv_diamond_leggings);
    Bukkit.addRecipe(DeConv_iron_leggings);
    Bukkit.addRecipe(DeConv_gold_leggings);
    Bukkit.addRecipe(DeConv_chainmail_leggings);
    Bukkit.addRecipe(DeConv_diamond_helmet);
    Bukkit.addRecipe(DeConv_iron_helmet);
    Bukkit.addRecipe(DeConv_gold_helmet);
    Bukkit.addRecipe(DeConv_chainmail_helmet);
    Bukkit.addRecipe(DeConv_diamond_boots);
    Bukkit.addRecipe(DeConv_iron_boots);
    Bukkit.addRecipe(DeConv_gold_boots);
    Bukkit.addRecipe(DeConv_chainmail_boots);
    Bukkit.addRecipe(DeConv_diamond_axe);
    Bukkit.addRecipe(DeConv_iron_axe);
    Bukkit.addRecipe(DeConv_gold_axe);
    Bukkit.addRecipe(DeConv_stone_axe);
    Bukkit.addRecipe(DeConv_diamond_pickaxe);
    Bukkit.addRecipe(DeConv_iron_pickaxe);
    Bukkit.addRecipe(DeConv_gold_pickaxe);
    Bukkit.addRecipe(DeConv_stone_pickaxe);
    Bukkit.addRecipe(DeConv_diamond_hoe);
    Bukkit.addRecipe(DeConv_iron_hoe);
    Bukkit.addRecipe(DeConv_gold_hoe);
    Bukkit.addRecipe(DeConv_stone_hoe);
    Bukkit.addRecipe(DeConv_diamond_spade);
    Bukkit.addRecipe(DeConv_iron_spade);
    Bukkit.addRecipe(DeConv_gold_spade);
    Bukkit.addRecipe(DeConv_stone_spade);
    

    ItemSetList = new ItemSetList();
    ItemSetList.Init();
    //Create a list of item sets.
    ItemSet set = new ItemSet("Acrobat",new ColorSet(
    		Color.fromRGB(149, 193, 149),
    		Color.fromRGB(133, 184, 133),
    		Color.fromRGB(133, 184, 159),
    		Color.fromRGB(159, 184, 133)),
    		"Thin and light armor made for\n" +
    		"nimble and precise movement.",
    		"When getting hit, you will gain\n" +
    		"40% movement speed.",
    		"Every 20% of bonus movement speed\n" +
    		"gives you 10% block chance.",
    		"When jumping, you cannot be hit.");
    ItemSetList.addSet(set);
    
    //Add in custom enchantments.
    ENCHANT_CRITICAL_CHANCE = new BonusEnchantment("Critical Chance",true,false,ItemType.WEAPONS,new IntRange(0,100));
    ENCHANT_ARMOR_PENETRATION = new BonusEnchantment("Armor Penetration",false,false,ItemType.WEAPONS,new IntRange(0,100));
    ENCHANT_LIFE_STEAL = new BonusEnchantment("Life Steal",true,false,ItemType.WEAPONS,new IntRange(0,100));
    ENCHANT_ATTACK_SPEED = new BonusEnchantment("Attack Speed",true,false,ItemType.WEAPONS,new IntRange(0,500));
    ENCHANT_DAMAGE = new BonusEnchantment("Damage",false,false,ItemType.WEAPONS,new IntRange(0,1000));
    ENCHANT_HEALTH = new BonusEnchantment("Health",false,false,ItemType.ARMOR,new IntRange(0,1000));
    ENCHANT_DAMAGE_REDUCTION = new BonusEnchantment("Damage Reduction",true,false,ItemType.ARMOR,new IntRange(0,100));
    ENCHANT_DURABILITY = new BonusEnchantment("Durability",false,false,ItemType.ARMOR,new IntRange(0,9999999));
    ENCHANT_BLOCK_CHANCE = new BonusEnchantment("Block Chance",true,false,ItemType.ARMOR,new IntRange(0,100));
    ENCHANT_SPEED_BOOST_CHANCE = new BonusEnchantment("Speed Boost Chance",true,false,ItemType.ARMOR,new IntRange(0,100));
    ENCHANT_STURDY = new BonusEnchantment("Sturdy",false,true,ItemType.ARMOR,new IntRange(0,1000));
    ENCHANT_REPAIR = new BonusEnchantment("Repair",false,true,ItemType.ARMOR,new IntRange(0,1000));
    ENCHANT_EXECUTE = new BonusEnchantment("Execute",false,true,ItemType.WEAPONS,new IntRange(0,1000));
    
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
    Woodcutter_job.setBuffData("Leaves break instantly.",
    		"Crafting planks gives 6 planks per wood instead of 4.",
    		"Apples have a x4 higher rate of dropping from leaves. Breaking wood gives a Jump boost buff that lasts for 10 seconds. Axes last 200% longer.",
    		"Axes you use will never break. Making them viable weapons as well.",
    		"Crafting planks gives 10 planks per wood instead of 4. Saplings placed down will instantly grow trees.",
    		"Cuts down a whole tree with one whack. Crafting planks gives 20 planks per wood. Each time you cut down a tree, you get a 4 HP boost (stacks) that lasts for one minute.");
    
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
    Miner_job.setBuffData("Automatically mines ores next to each other when one ore is mined.",
    		"Gain Quadruple the experience from mining ores. Pickaxes gain Efficiency III.", 
    		"Mining with a diamond pickaxe will mine out 3x3 blocks at a time when using diamond pickaxes. Pickaxes used gain Efficiency VI and Unbreaking IV.",
    		"When holding a pickaxe, mobs that hit you only deal 25% damage.",
    		"Mining blocks will stack a haste buff up to Haste V for 10 seconds.",
    		"Mining ores will grant x2 the normal amount of minerals. Fortune is twice as effective, granting a possible total of x4 the normal minerals from ores.");

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
    Builder_job.setBuffData("Builders gain access to the 'line' tool. Typing /line will make building in straight lines easier.",
    		"Builders gain access to the 'rectangle' tool. Typing /rectangle will make building in rectangles easier.", 
    		"When crafting irreversible Builder blocks, 75% of the materials used for crafting will be restored to your inventory. When cooking Builder blocks, the block results will be doubled.",
    		"Gain experience orbs (equivalent to the job XP you get) as you build.",
    		"Building will stack a jump boost buff up to Jump Boost X for 10 seconds.",
    		"Builders gain the ability to fly when building. They immediately lose the ability to fly if they stop building for a moment, destroy a block, or enter combat. Every 100 Builder XP gained gives the Builder 5 Glowstone blocks and a stack of torches.");

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
    Digger_job.setBuffData("Ability to discover artifacts when digging up blocks.",
    		"Shovels gain Unbreaking V and Efficiency IV.", 
    		"Destroying the bottom row of Sand or Gravel with a Wooden Shovel will destroy the whole stack instantly. Artifact discovery rate increased by 25%.",
    		"Shovels you use will not break.",
    		"Diggers can craft a Battle Shovel (Use a Lapis block with sticks to build it). Any blocks you destroy with it will shoot 20 arrows rapidly from the destroyed block's position in the direction you are facing.",
    		"Artifacts will have a 100% identify rate.");
    
    /*
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
    Farmer_job.addData("PUMPKIN", 0.04, 8, 0);
    Farmer_job.addData("MELON", 0.05, 10, 0);
    Farmer_job.addData("SEEDS", 0.0025, 1, 1);
    Farmer_job.addData("PUMPKIN SEEDS", 0.005, 2, 1);
    Farmer_job.addData("MELON SEEDS", 0.005, 2, 1);
    //Farmer_job.addData("PUMPKIN", 0.00, -16, 1);
    Farmer_job.setBuffData("Hoes do not lose durability when used.",
    		"Killing skeletons yields triple the amount of bones.", 
    		"Nearby crops grow 30% faster.", 
    		"Nearby crops grow 200% faster. Bonemeal grows things instantly. (Just like before the bonemeal nerf) in one use.");
	*/
    
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
    Hunter_job.addData("CHARGE ZOMBIE", 0.02, 4, 0);
    Hunter_job.addData("ZOMBIE NINJA", 0.025, 5, 0);
    Hunter_job.addData("SNIPER", 0.025, 5, 0);
    Hunter_job.addData("CREEPER", 0.025, 5, 0);
    Hunter_job.addData("VENOMOUS SPIDER", 0.025, 5, 0);
    Hunter_job.addData("SNARING SPIDER", 0.025, 5, 0);
    Hunter_job.addData("PIG ZOMBIE", 0.03, 6, 0);
    Hunter_job.addData("EXPLOSIVE CREEPER", 0.035, 7, 0);
    Hunter_job.addData("DESTRUCTIVE CREEPER", 0.035, 7, 0);
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
    Hunter_job.addData("CHARGE ZOMBIE", 0.05, 10, 1);
    Hunter_job.addData("ZOMBIE NINJA", 0.05, 10, 1);
    Hunter_job.addData("SNIPER", 0.05, 10, 1);
    Hunter_job.addData("VENOMOUS SPIDER", 0.05, 10, 1);
    Hunter_job.addData("SNARING SPIDER", 0.05, 10, 1);
    Hunter_job.addData("CREEPER", 0.05, 10, 1);
    Hunter_job.addData("PIG ZOMBIE", 0.08, 16, 1);
    Hunter_job.addData("EXPLOSIVE CREEPER", 0.08, 16, 1);
    Hunter_job.addData("DESTRUCTIVE CREEPER", 0.08, 16, 1);
    Hunter_job.addData("GHAST", 0.10, 12, 1);
    Hunter_job.addData("ENDERMAN", 0.125, 16, 1);
    Hunter_job.addData("BLAZE", 0.15, 20, 1);
    Hunter_job.addData("ENDER DRAGON", 100.00, 3000, 1);
    Hunter_job.addData("WITHER", 550.00, 7800, 1);
    Hunter_job.setBuffData("Damage dealt increased by 4.",
    		"Sneaking gives you invisibility. Anything targeting you loses aggro.", 
    		"Swords inflict Poison II on mobs for 6 seconds. Movement speed increased by 20%.", 
    		"Each time you get hit, the next hit has a 10% increased stacking chance of blocking for 10 seconds. Hitting an enemy removes this buff.",
    		"Attacks deal an additional 10 armor penetration damage.",
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
    		"Fish Catching Rate increased by 30%. You will always catch at least two fish (And gain the amount of money and xp earned for them). Fishing rods last 4x as long.",
    		"Each successful catch will increase the fishing catch rate multiplicatively by 5%. Missing a fish will reset this rate.",
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
    		"All weaponsmith items crafted gain +X Damage bonus enchantments. (Increases by weaponsmithing level)",
    		"All weaponsmith items crafted gain +2% Lifesteal bonus enchantments. (Increases by 2% every weaponsmithing level after 30.)",
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
    Blacksmith_job.addData("CHAIN BOOTS", 0.375*5, 80*5, 0);
    Blacksmith_job.addData("CHAIN HELMET", 0.50*5, 100*5, 0);
    Blacksmith_job.addData("CHAIN LEGGINGS", 0.725*5, 140*5, 0);
    Blacksmith_job.addData("CHAIN CHESTPLATE", 0.875*5, 175*5, 0);
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
    		"All blacksmith items crafted gain +2 Health bonus enchantments. (Increases by +2 per blacksmithing level after 30.)",
    		"Blacksmiths gain the ability to craft armor they find back into ingots / materials, based on the remaining durability. (About 90% lossy)",
    		"All crafted Blacksmith items stack between 2 and 5 of the same item, effectively multiplying the amount you craft. Items are buffed with a Lv20 enchantment and have a 50% chance to be enchanted with a level 30 enchantment.");

    Cook_job.setJobName("Cook");
    Cook_job.setJobDescription("A cook's job is to provide food for others and themselves through cooking and crafting together ingredients.");
    Cook_job.setAction(0, "CRAFT");
    Cook_job.setAction(1, "SMELT");
    Cook_job.setExp(400, 250, 40, 1.04);
    Cook_job.addData("BREAD", 0.003125, 1.25, 0);
    Cook_job.addData("COOKIE", 0.016875, 0.45, 0);
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
    		"Food that is cooked/crafted gives double the amount of hunger restoration and heals 1 Heart of Health (2HP) when eaten.", 
    		"Food that is cooked/crafted gain magical buffs that apply when someone eats them. These last for 60 seconds.", 
    		"Increases buff strength of all food items by 1.",
    		"Increases bonus effect duration of all food items by x4.",
    		"Food that is cooked/crafted gain a 'Saturation' magical buff that lasts for 2 minutes and heals 3 hearts (6HP) for the player that eats it. All food magical buffs' durations will be increased an additional 3 minutes long and the strength of those buffs increase by 1. Food results that are cooked/crafted will be doubled.");

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
    Brewer_job.setBuffData("Gain access to the Teleport potion. Water Bottle + Lapis Lazuli. Throwing it will teleport you to the thrown location.",
    		"Potions can stack up to 2 at a time. Gain access to the Eye of Wonder potion. Teleport potion + Eye of Ender. Drinking it will reveal mobs' nametags nearby. Throwing it will turn stone into glass temporarily, revealing nearby ores within.", 
    		"Potions you throw have double the duration. Potions can stack up to 4 at a time. The stacking amount goes up by 1 with each Brewer level after 20.", 
    		"Gain the ability to create Strength potions with Strength IV buffs. Heal potions created by you heal 4x their normal amount.",
    		"Gain access to the Potion of Fury (Gives you attack speed. Strength Potion + Blaze Rod) and Potion of Resistance (Heal Potion + Obsidian) Potions.",
    		"Potions thrown by you last for 30 minutes. Potions can stack up to 64 at a time. Brewing wait time decreased by 4x the normal time.");

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
    		"Gain the ability to choose one type of enchantment/bonus enchantment to add to an item when enchanting.",
    		"Gain the ability to enchant legendary-tier items. (Has an unusually higher level of enchantment than normal)",
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
    		"Animals will become enticed by you whenever you are nearby, requiring no food to breed animals. Animals will be able to breed again at double the normal rate.",
    		"Wolves and horses you tame gain +150 Health, making these companions much more useful in fighting, and surviving longer. Feeding them one time will heal them completely. For each wolf and horse near you, you gain +2 Health.",
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
    		"When crafting maps, you will also gain 32 paper to zoom the map out completely. (Or use to create more maps.)",
    		"Increased movement speed to 40%.",
    		"When holding a pickaxe, it will detect ores around you based on what the pickaxe is made of.");

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
    		"When a nearby player is low in health, if you have health splash potions, one of your potions will be automatically consumed to heal them.",
    		"Provide a Fire Resistance buff to everyone around you.",
    		"Everyone around you gains Regeneration. You gain +5 Armor. Everyone around you gains +20 more Health. You gain +10 more health. Everyone around you including yourself moves 20% faster.");
}

public void onDisable()
  {
	saveAccountsConfig();
	  getConfig().set("server-tick-time", Long.valueOf(SERVER_TICK_TIME));
	  saveConfig();
	  saveAccountsConfig();
    PluginDescriptionFile pdf = getDescription();
    System.out.println("[" + pdf.getName() + "] The plugin has been disabled succesfully.");
  }
  

  public void updateTopSPLEEFSigns() {
	  String name[] = {"","",""};
	  int rating[] = {-9999,-9999,-9999}, wins[] = {0,0,0}, losses[] = {0,0,0};
	  //Get list of all players on the server.
	  OfflinePlayer playerlist[] = Bukkit.getOfflinePlayers();
	  for (int i=0;i<playerlist.length;i++) {
		  if (getAccountsConfig().contains(playerlist[i].getName().toLowerCase())) {
			  if (getAccountsConfig().contains(playerlist[i].getName().toLowerCase()+".spleefrating") && getAccountsConfig().getInt(playerlist[i].getName().toLowerCase()+".spleefwins")+getAccountsConfig().getInt(playerlist[i].getName().toLowerCase()+".spleeflosses")>=20) {
				  if (getAccountsConfig().getDouble(playerlist[i].getName().toLowerCase()+".spleefrating")>rating[0]) {
					  //This beats the top record, move everything down.
					  name[2]=name[1];rating[2]=rating[1];wins[2]=wins[1];losses[2]=losses[1];
					  name[1]=name[0];rating[1]=rating[0];wins[1]=wins[0];losses[1]=losses[0];
					  name[0]=playerlist[i].getName().toLowerCase();
					  rating[0]=(int)getAccountsConfig().getDouble(playerlist[i].getName().toLowerCase()+".spleefrating");
					  wins[0]=getAccountsConfig().getInt(playerlist[i].getName().toLowerCase()+".spleefwins");
					  losses[0]=getAccountsConfig().getInt(playerlist[i].getName().toLowerCase()+".spleeflosses");
				  } else
				  if (getAccountsConfig().getDouble(playerlist[i].getName().toLowerCase()+".spleefrating")>rating[1]) {
					  //This beats the 2nd record, move everything down.
					  name[2]=name[1];rating[2]=rating[1];wins[2]=wins[1];losses[2]=losses[1];
					  name[1]=playerlist[i].getName().toLowerCase();
					  rating[1]=(int)getAccountsConfig().getDouble(playerlist[i].getName().toLowerCase()+".spleefrating");
					  wins[1]=getAccountsConfig().getInt(playerlist[i].getName().toLowerCase()+".spleefwins");
					  losses[1]=getAccountsConfig().getInt(playerlist[i].getName().toLowerCase()+".spleeflosses");
				  } else
				  if (getAccountsConfig().getDouble(playerlist[i].getName().toLowerCase()+".spleefrating")>rating[2]) {
					  //This beats the 3rd record, move everything down.
					  name[2]=playerlist[i].getName().toLowerCase();
					  rating[2]=(int)getAccountsConfig().getDouble(playerlist[i].getName().toLowerCase()+".spleefrating");
					  wins[2]=getAccountsConfig().getInt(playerlist[i].getName().toLowerCase()+".spleefwins");
					  losses[2]=getAccountsConfig().getInt(playerlist[i].getName().toLowerCase()+".spleeflosses");
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
	final Main plugin = this;
  this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new  Runnable(){
		  public void run(){
			SERVER_TICK_TIME++;
			for (int i=0;i<ARROW_SHOOTERS.size();i++) {
				ArrowShooter shooter = ARROW_SHOOTERS.get(i);
				shooter.timer--;
				if ((shooter.timer % shooter.frequency )==0) {
					Arrow arrow = Bukkit.getWorld("world").spawnArrow(shooter.loc, shooter.dir, shooter.spd, shooter.spread);
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
			for (int i=0;i<TEMP_BLOCKS.size();i++) {
				TempBlock block = TEMP_BLOCKS.get(i);
				block.timer--;
				if (block.timer<=0) {
					//Attempt to destroy the block in the world.
					if (block.loc.getBlock().getType()==Material.GLASS || block.loc.getBlock().getType()==Material.JACK_O_LANTERN) {
						block.loc.getBlock().setType(Material.STONE);
					}
					TEMP_BLOCKS.remove(i);
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
						  if (l.getCustomName()!=null && l.getCustomName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE+"Mythical Wither")) {
							  if (l.getMaxHealth()>l.getHealth()+5+(0.2*(l.getMaxHealth()/l.getHealth()))) {
							      DecimalFormat df = new DecimalFormat("#0.0");
							      //Bukkit.broadcastMessage("Healing for "+(+5+(0.2*(l.getMaxHealth()/l.getHealth())))+" health. "+df.format(l.getHealth())+"/"+l.getMaxHealth()+" HP");
								  l.setHealth(l.getHealth()+5+(0.2*(l.getMaxHealth()/l.getHealth())));
							  }
						  }
					  }
				  }
				  world_entities = Bukkit.getWorld("world_nether").getEntities();
				  for (int i=0;i<world_entities.size();i++) {
					  if (world_entities.get(i).getType()==EntityType.WITHER) {
						  Wither l = (Wither)world_entities.get(i);
						  if (l.getCustomName()!=null && l.getCustomName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE+"Mythical Wither")) {
							  if (l.getMaxHealth()>l.getHealth()+5+(0.2*(l.getMaxHealth()/l.getHealth()))) {
							      DecimalFormat df = new DecimalFormat("#0.0");
							      //Bukkit.broadcastMessage("Healing for "+(+5+(0.2*(l.getMaxHealth()/l.getHealth())))+" health. "+df.format(l.getHealth())+"/"+l.getMaxHealth()+" HP");
								  l.setHealth(l.getHealth()+5+(0.2*(l.getMaxHealth()/l.getHealth())));
							  }
						  }
					  }
				  }
				  world_entities = Bukkit.getWorld("world_the_end").getEntities();
				  for (int i=0;i<world_entities.size();i++) {
					  if (world_entities.get(i).getType()==EntityType.WITHER) {
						  Wither l = (Wither)world_entities.get(i);
						  if (l.getCustomName()!=null && l.getCustomName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE+"Mythical Wither")) {
							  if (l.getMaxHealth()>l.getHealth()+5+(0.2*(l.getMaxHealth()/l.getHealth()))) {
							      DecimalFormat df = new DecimalFormat("#0.0");
							      //Bukkit.broadcastMessage("Healing for "+(+5+(0.2*(l.getMaxHealth()/l.getHealth())))+" health. "+df.format(l.getHealth())+"/"+l.getMaxHealth()+" HP");
								  l.setHealth(l.getHealth()+5+(0.2*(l.getMaxHealth()/l.getHealth())));
							  }
						  }
					  }
				  }
			  }
			  for (int zx=0;zx<Bukkit.getOnlinePlayers().length;zx++) {
			  Player p = Bukkit.getOnlinePlayers()[zx];
			  //p.sendMessage("That's item slot #"+p.getInventory().getHeldItemSlot());
			  /*
			  if (p.getName().toLowerCase().compareTo("sigonasr2")==0) {
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
				  if (getConfig().getBoolean("thanksgiving-enabled") && Bukkit.getWorld("world").hasStorm() && Main.SERVER_TICK_TIME%160==0) {
					  Item i = null;
					  i=Bukkit.getWorld("world").dropItemNaturally(p.getLocation().add((int)(Math.random()*20)-(int)(Math.random()*20), 256, (int)(Math.random()*20)-(int)(Math.random()*20)),new ItemStack(Material.EGG));
					  i.setTicksLived(3600);
				  }
				  if (getConfig().getBoolean("thanksgiving-enabled") && Bukkit.getWorld("world").hasStorm() && Main.SERVER_TICK_TIME%160==0) {
					  Item i = null;
					  i=Bukkit.getWorld("world").dropItemNaturally(p.getLocation().add((int)(Math.random()*20)-(int)(Math.random()*20), 256, (int)(Math.random()*20)-(int)(Math.random()*20)),new ItemStack(Material.EGG));
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
										  enderdragon.setMaxHealth(200);
										  enderdragon.setHealth(200);
										  enderdragon.remove();
										  //enderdragon.teleport(new Location(p.getWorld(),p.getLocation().getBlockX()+i,-250,p.getLocation().getBlockZ()+j));
										  //p.sendMessage(ChatColor.DARK_PURPLE+"You feel a dark presence nearby.");
										  //Bukkit.getPlayer("sigonasr2").sendMessage("Trigger this.");
										  zombie.setRemoveWhenFarAway(false);
										  zombie.setMaxHealth(300);
										  zombie.setHealth(300);
										  zombie.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,999999,6));
										  zombie.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,999999,0));
										  zombie.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,999999,0));
										  zombie.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,999999,0));
										  zombie.setTicksLived(1);
										  /*Iterator<EnderDragon> e_list = Bukkit.getWorld("world").getEntitiesByClass(EnderDragon.class).iterator();
										  boolean first=false;
										  while (e_list.hasNext()) {
											  //p.sendMessage("Moving Enderdragon to "+new Location(p.getWorld(),p.getLocation().getBlockX()+i,-50,p.getLocation().getBlockZ()+j));
											  EnderDragon next = e_list.next();
											  if (!first) {
												  first=true;
											  } else {
												  next.remove();
											  }
										  }*/
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
								 if (!lineofsight_check.contains(l.getUniqueId()) && Main.SERVER_TICK_TIME-last_sight_check_time>200) {
									 l.setCustomNameVisible(false);
								 }
							  }
						  }
					  }
				  }
			  }
			  if (Main.SERVER_TICK_TIME%30==0) {
				  if (p.getWorld().getName().compareTo("world")==0) {
					  List<Entity> nearby = p.getNearbyEntities(20, 20, 20);
					  Location nearestwolf = null;
					  int minions=0;
					  for (int i=0;i<nearby.size();i++) {
						  if (nearby.get(i).getType()==EntityType.ENDERMAN) {
							  Creature l = (Creature)nearby.get(i);
							  if (l.getCustomName()!=null && l.getCustomName().equalsIgnoreCase(ChatColor.RED+"Lightning Mage") && l.getTarget()!=null) {
								  if (l.getTarget() instanceof Player) {
									  l.getTarget().getWorld().strikeLightning(l.getTarget().getLocation());
									  l.getTarget().getWorld().strikeLightning(l.getTarget().getLocation().add(-0.5,0,0.5));
									  l.getTarget().getWorld().strikeLightning(l.getTarget().getLocation().add(0.5,0,-0.5));
								  }
							  }
						  }
						  if (nearby.get(i).getType()==EntityType.CREEPER) {
							  Creature l = (Creature)nearby.get(i);
							  if (l.getCustomName()!=null && l.getCustomName().equalsIgnoreCase(ChatColor.RED+"Suicidal Creeper") && l.getTarget()!=null) {
								  l.removePotionEffect(PotionEffectType.INVISIBILITY);
							  }
						  }
						  if (nearby.get(i).getType()==EntityType.WOLF) {
							  minions++;
							  if (nearestwolf==null || nearby.get(i).getLocation().distanceSquared(p.getLocation())<nearestwolf.distanceSquared(p.getLocation())) {
								  nearestwolf = nearby.get(i).getLocation();
							  }
							  Creature l = (Creature)nearby.get(i);
							  if (Math.random()<=0.6 && l.getCustomName()!=null && l.getCustomName().equalsIgnoreCase(ChatColor.RED+"Hound Caller")) {
								  Wolf w = (Wolf)nearby.get(i);
								  if (w.getOwner()==null) {
									  if (!w.isAngry()) {
										  w.damage(0,p);
										  w.setHealth(w.getMaxHealth());
										  w.setAngry(true);
									  }
									  l.setTarget(p);
									  l.setLastDamage(0.01);
									  l.setLastDamageCause(new EntityDamageEvent(p, DamageCause.CUSTOM, 0.01));
								  }
							  }
						  }
					  }
					  if (minions<10 && nearestwolf!=null) {
						  if (Math.random()<=0.05) {
							  Entity entity = p.getWorld().spawnEntity(nearestwolf, EntityType.WOLF);
								LivingEntity l = (LivingEntity)entity;
								Creature c = (Creature)l;
								l.setCustomName(ChatColor.RED+"Wolf Minion");
								l.setCustomNameVisible(true);
								c.setTarget(p);
								Wolf w = (Wolf)l;
								w.setBaby();
								  if (!w.isAngry()) {
									  w.damage(0,p);
									  w.setHealth(w.getMaxHealth());
									  w.setAngry(true);
								  }
								l.setRemoveWhenFarAway(true);
								l.setLastDamageCause(new EntityDamageEvent(p, DamageCause.CUSTOM, 0.01));
								l.getLocation().getWorld().playSound(l.getLocation(), Sound.WOLF_HOWL, 0.2f, 0.9f);
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
				  saveAccountsConfig(); //Save account data once every 30 seconds.
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
							  (p.getName().toLowerCase().compareTo(getConfig().getString("spleefrequesta4player"))==0 || p.getName().compareTo(getConfig().getString("spleefrequestb4player"))==0
							  || p.getName().compareTo(getConfig().getString("spleefrequestc4player"))==0 || p.getName().compareTo(getConfig().getString("spleefrequestd4player"))==0))) {
						  //You lose.
						  //See if we're the winner.
						  int countdead=0; //We're looking for 3.
						  
						  
						  Player winningplayer = p,losingplayer = p;
						  if (getConfig().getString("spleefrequesta4player").compareTo("none")==0) {
							  countdead++;
						  } else {
							  if (getConfig().getString("spleefrequesta4player").compareTo(p.getName().toLowerCase())==0) {
								  losingplayer=Bukkit.getPlayer(getConfig().getString("spleefrequesta4player"));
							  } else {
								  winningplayer=Bukkit.getPlayer(getConfig().getString("spleefrequesta4player"));
							  }
						  }
						  if (getConfig().getString("spleefrequestb4player").compareTo("none")==0) {
							  countdead++;
						  } else {
							  if (getConfig().getString("spleefrequestb4player").compareTo(p.getName().toLowerCase())==0) {
								  losingplayer=Bukkit.getPlayer(getConfig().getString("spleefrequestb4player"));
							  } else {
								  winningplayer=Bukkit.getPlayer(getConfig().getString("spleefrequestb4player"));
							  }
						  }
						  if (getConfig().getString("spleefrequestc4player").compareTo("none")==0) {
							  countdead++;
						  } else {
							  if (getConfig().getString("spleefrequestc4player").compareTo(p.getName().toLowerCase())==0) {
								  losingplayer=Bukkit.getPlayer(getConfig().getString("spleefrequestc4player"));
							  } else {
								  winningplayer=Bukkit.getPlayer(getConfig().getString("spleefrequestc4player"));
							  }
						  }
						  if (getConfig().getString("spleefrequestd4player").compareTo("none")==0) {
							  countdead++;
						  } else {
							  if (getConfig().getString("spleefrequestd4player").compareTo(p.getName().toLowerCase())==0) {
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
								  if (getConfig().getString("spleefrequesta4player").compareTo(p.getName().toLowerCase())==0) {
									  for (int i=0;i<spleef4_inventory_a.length;i++) {
										  if (spleef4_inventory_a[i]!=null) {
										  p.getInventory().addItem(spleef4_inventory_a[i]);
										  }
									  }
									  getConfig().set("spleefrequesta4player",String.valueOf("none"));
								  } else
								  if (getConfig().getString("spleefrequestb4player").compareTo(p.getName().toLowerCase())==0) {
									  for (int i=0;i<spleef4_inventory_b.length;i++) {
										  if (spleef4_inventory_b[i]!=null) {
										  p.getInventory().addItem(spleef4_inventory_b[i]);
										  }
									  }
									  getConfig().set("spleefrequestb4player",String.valueOf("none"));
								  } else
								  if (getConfig().getString("spleefrequestc4player").compareTo(p.getName().toLowerCase())==0) {
									  for (int i=0;i<spleef4_inventory_c.length;i++) {
										  if (spleef4_inventory_c[i]!=null) {
										  p.getInventory().addItem(spleef4_inventory_c[i]);
										  }
									  }
									  getConfig().set("spleefrequestc4player",String.valueOf("none"));
								  } else
								  if (getConfig().getString("spleefrequestd4player").compareTo(p.getName().toLowerCase())==0) {
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
								  if (getConfig().getString("spleefrequesta4player").compareTo(winningplayer.getName().toLowerCase())==0) {
									  for (int i=0;i<spleef4_inventory_a.length;i++) {
										  if (spleef4_inventory_a[i]!=null) {
											  winningplayer.getInventory().addItem(spleef4_inventory_a[i]);
										  }
									  }
									  getConfig().set("spleefrequesta4player",String.valueOf("none"));
								  } else
								  if (getConfig().getString("spleefrequestb4player").compareTo(winningplayer.getName().toLowerCase())==0) {
									  for (int i=0;i<spleef4_inventory_b.length;i++) {
										  if (spleef4_inventory_b[i]!=null) {
											  winningplayer.getInventory().addItem(spleef4_inventory_b[i]);
										  }
									  }
									  getConfig().set("spleefrequestb4player",String.valueOf("none"));
								  } else
								  if (getConfig().getString("spleefrequestc4player").compareTo(winningplayer.getName().toLowerCase())==0) {
									  for (int i=0;i<spleef4_inventory_c.length;i++) {
										  if (spleef4_inventory_c[i]!=null) {
											  winningplayer.getInventory().addItem(spleef4_inventory_c[i]);
										  }
									  }
									  getConfig().set("spleefrequestc4player",String.valueOf("none"));
								  } else
								  if (getConfig().getString("spleefrequestd4player").compareTo(winningplayer.getName().toLowerCase())==0) {
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
								  Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+winningplayer.getName().toLowerCase()+"["+(int)getAccountsConfig().getDouble(winningplayer.getName().toLowerCase().toLowerCase()+".spleefrating")/10+"] is the winner of this 4-player spleef game!");
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
							  if (getConfig().getString("spleefrequesta4player").compareTo(p.getName().toLowerCase())==0) {
								  for (int i=0;i<spleef4_inventory_a.length;i++) {
									  if (spleef4_inventory_a[i]!=null) {
									  p.getInventory().addItem(spleef4_inventory_a[i]);
									  }
								  }
								  getConfig().set("spleefrequesta4player",String.valueOf("none"));
							  } else
							  if (getConfig().getString("spleefrequestb4player").compareTo(p.getName().toLowerCase())==0) {
								  for (int i=0;i<spleef4_inventory_b.length;i++) {
									  if (spleef4_inventory_b[i]!=null) {
									  p.getInventory().addItem(spleef4_inventory_b[i]);
									  }
								  }
								  getConfig().set("spleefrequestb4player",String.valueOf("none"));
							  } else
							  if (getConfig().getString("spleefrequestc4player").compareTo(p.getName().toLowerCase())==0) {
								  for (int i=0;i<spleef4_inventory_c.length;i++) {
									  if (spleef4_inventory_c[i]!=null) {
									  p.getInventory().addItem(spleef4_inventory_c[i]);
									  }
								  }
								  getConfig().set("spleefrequestc4player",String.valueOf("none"));
							  } else
							  if (getConfig().getString("spleefrequestd4player").compareTo(p.getName().toLowerCase())==0) {
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
					  if (getConfig().getString("spleefrequesta4player").compareTo(p.getName().toLowerCase())==0 ||
							  getConfig().getString("spleefrequestb4player").compareTo(p.getName().toLowerCase())==0 ||
							  getConfig().getString("spleefrequestc4player").compareTo(p.getName().toLowerCase())==0 ||
							  getConfig().getString("spleefrequestd4player").compareTo(p.getName().toLowerCase())==0) {
						  //If they are holding something, remove it.
						  if (p.getItemInHand()!=null) {
							  p.getInventory().remove(p.getInventory().getHeldItemSlot());
						  }
					  }
				  }
				  
				  if (getConfig().getBoolean("spleefinsession") && (p.getName().toLowerCase().compareTo(getConfig().getString("spleefrequestaplayer"))==0 || p.getName().compareTo(getConfig().getString("spleefrequestbplayer"))==0)) {
					  //Determine if we're still playing.
					  int blockwinner=0;
					  if (getConfig().getString("spleefrequestaplayer").compareTo(p.getName().toLowerCase())==0 ||
							  getConfig().getString("spleefrequestbplayer").compareTo(p.getName().toLowerCase())==0) {
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
						  if (p.getName().toLowerCase().compareTo(getConfig().getString("spleefrequestaplayer"))==0 || blockwinner==2) {
							  //We're player A.
							  //Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+getConfig().getString("spleefrequestbplayer")+" is the winner of this spleef game! "+getConfig().getString("spleefrequestaplayer")+" loses.");
							  losingplayer=p;
							  winningplayer=Bukkit.getPlayer(getConfig().getString("spleefrequestbplayer"));
	
							  double val1,val2,value,newval1,newval2;
							  if (getAccountsConfig().contains(winningplayer.getName().toLowerCase()+".spleefrating")) {
								  val1 = getAccountsConfig().getDouble(winningplayer.getName().toLowerCase()+".spleefrating");
							  } else {
								  val1 = 1000.0d;
							  }
							  if (getAccountsConfig().contains(losingplayer.getName().toLowerCase()+".spleefrating")) {
								  val2 = getAccountsConfig().getDouble(losingplayer.getName().toLowerCase()+".spleefrating");
							  } else {
								  val2 = 1000.0d;
							  }
							  value = 1.0d/(1.0d+Math.pow(10.0d, ((val2-val1)/400.0d)));
							  if (getAccountsConfig().contains(winningplayer.getName().toLowerCase()+".spleefwins")) {
								  getAccountsConfig().set(winningplayer.getName().toLowerCase()+".spleefwins", Integer.valueOf(getAccountsConfig().getInt(winningplayer.getName().toLowerCase()+".spleefwins")+1));
							  } else {
								  getAccountsConfig().set(winningplayer.getName().toLowerCase()+".spleefwins", Integer.valueOf(1));
							  }
							  if (getAccountsConfig().contains(winningplayer.getName().toLowerCase()+".spleeflosses")) {
								  getAccountsConfig().set(winningplayer.getName().toLowerCase()+".spleeflosses", Integer.valueOf(getAccountsConfig().getInt(winningplayer.getName().toLowerCase()+".spleeflosses")));
							  } else {
								  getAccountsConfig().set(winningplayer.getName().toLowerCase()+".spleeflosses", Integer.valueOf(0));
							  }
							  if (getAccountsConfig().contains(losingplayer.getName().toLowerCase()+".spleefwins")) {
								  getAccountsConfig().set(losingplayer.getName().toLowerCase()+".spleefwins", Integer.valueOf(getAccountsConfig().getInt(losingplayer.getName().toLowerCase()+".spleefwins")));
							  } else {
								  getAccountsConfig().set(losingplayer.getName().toLowerCase()+".spleefwins", Integer.valueOf(0));
							  }
							  if (getAccountsConfig().contains(losingplayer.getName().toLowerCase()+".spleeflosses")) {
								  getAccountsConfig().set(losingplayer.getName().toLowerCase()+".spleeflosses", Integer.valueOf(getAccountsConfig().getInt(losingplayer.getName().toLowerCase()+".spleeflosses")+1));
							  } else {
								  getAccountsConfig().set(losingplayer.getName().toLowerCase()+".spleeflosses", Integer.valueOf(1));
							  }
							  newval1 = (val1+Math.round(((50.0d/((getAccountsConfig().getDouble(winningplayer.getName().toLowerCase()+".spleefwins")+getAccountsConfig().getDouble(winningplayer.getName().toLowerCase()+".spleeflosses"))/20.0d))*(1.0d-value))));
							  newval2 = (val2+Math.round(((50.0d/((getAccountsConfig().getDouble(losingplayer.getName().toLowerCase()+".spleefwins")+getAccountsConfig().getDouble(losingplayer.getName().toLowerCase()+".spleeflosses"))/20.0d))*(0.0d-value))));
							  getAccountsConfig().set(winningplayer.getName().toLowerCase()+".spleefrating",Double.valueOf(newval1));
							  getAccountsConfig().set(losingplayer.getName().toLowerCase()+".spleefrating",Double.valueOf(newval2));
							  Location newloc = winningplayer.getLocation();
	
							  Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+getConfig().getString("spleefrequestbplayer")+"["+(int)newval1/10+"] is the winner of this spleef game! "+getConfig().getString("spleefrequestaplayer")+"["+(int)newval2/10+"] loses.");
							  newloc.setX(1622.5d);
							  newloc.setY(87.0d);
							  newloc.setZ(51.65d);
							  winningplayer.teleport(newloc);
							  updateTopSPLEEFSigns();
							  //saveAccountsConfig() //Commented out;
						  } else {
							  //We're player B.
							  //Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+getConfig().getString("spleefrequestaplayer")+" is the winner of this spleef game! "+getConfig().getString("spleefrequestbplayer")+" loses.");
							  losingplayer=p;
							  winningplayer=Bukkit.getPlayer(getConfig().getString("spleefrequestaplayer"));
							  double val1,val2,value,newval1,newval2;
							  if (getAccountsConfig().contains(winningplayer.getName().toLowerCase()+".spleefrating")) {
								  val1 = getAccountsConfig().getDouble(winningplayer.getName().toLowerCase()+".spleefrating");
							  } else {
								  val1 = 1000.0d;
							  }
							  if (getAccountsConfig().contains(losingplayer.getName().toLowerCase()+".spleefrating")) {
								  val2 = getAccountsConfig().getDouble(losingplayer.getName().toLowerCase()+".spleefrating");
							  } else {
								  val2 = 1000.0d;
							  }
							  value = 1.0d/(1.0d+Math.pow(10.0d, ((val2-val1)/400.0d)));
							  if (getAccountsConfig().contains(winningplayer.getName().toLowerCase()+".spleefwins")) {
								  getAccountsConfig().set(winningplayer.getName().toLowerCase()+".spleefwins", Integer.valueOf(getAccountsConfig().getInt(winningplayer.getName().toLowerCase()+".spleefwins")+1));
							  } else {
								  getAccountsConfig().set(winningplayer.getName().toLowerCase()+".spleefwins", Integer.valueOf(1));
							  }
							  if (getAccountsConfig().contains(winningplayer.getName().toLowerCase()+".spleeflosses")) {
								  getAccountsConfig().set(winningplayer.getName().toLowerCase()+".spleeflosses", Integer.valueOf(getAccountsConfig().getInt(winningplayer.getName().toLowerCase()+".spleeflosses")));
							  } else {
								  getAccountsConfig().set(winningplayer.getName().toLowerCase()+".spleeflosses", Integer.valueOf(0));
							  }
							  if (getAccountsConfig().contains(losingplayer.getName().toLowerCase()+".spleefwins")) {
								  getAccountsConfig().set(losingplayer.getName().toLowerCase()+".spleefwins", Integer.valueOf(getAccountsConfig().getInt(losingplayer.getName().toLowerCase()+".spleefwins")));
							  } else {
								  getAccountsConfig().set(losingplayer.getName().toLowerCase()+".spleefwins", Integer.valueOf(0));
							  }
							  if (getAccountsConfig().contains(losingplayer.getName().toLowerCase()+".spleeflosses")) {
								  getAccountsConfig().set(losingplayer.getName().toLowerCase()+".spleeflosses", Integer.valueOf(getAccountsConfig().getInt(losingplayer.getName().toLowerCase()+".spleeflosses")+1));
							  } else {
								  getAccountsConfig().set(losingplayer.getName().toLowerCase()+".spleeflosses", Integer.valueOf(1));
							  }
							  newval1 = ((val1+Math.round((50.0d/((getAccountsConfig().getDouble(winningplayer.getName().toLowerCase()+".spleefwins")+getAccountsConfig().getDouble(winningplayer.getName().toLowerCase()+".spleeflosses"))/20.0d))*(1.0d-value))));
							  newval2 = ((val2+Math.round((50.0d/((getAccountsConfig().getDouble(losingplayer.getName().toLowerCase()+".spleefwins")+getAccountsConfig().getDouble(losingplayer.getName().toLowerCase()+".spleeflosses"))/20.0d))*(0.0d-value))));
							  getAccountsConfig().set(winningplayer.getName().toLowerCase()+".spleefrating",Double.valueOf(newval1));
							  getAccountsConfig().set(losingplayer.getName().toLowerCase()+".spleefrating",Double.valueOf(newval2));
							  Location newloc = winningplayer.getLocation();
	
							  Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+getConfig().getString("spleefrequestaplayer")+"["+(int)newval1/10+"] is the winner of this spleef game! "+getConfig().getString("spleefrequestbplayer")+"["+(int)newval2/10+"] loses.");
							  newloc.setX(1622.5d);
							  newloc.setY(87.0d);
							  newloc.setZ(51.65d);
							  winningplayer.teleport(newloc);
							  updateTopSPLEEFSigns();
							  //saveAccountsConfig() //Commented out;
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
					  if (getConfig().getBoolean("spleefinsession") && (p.getName().toLowerCase().compareTo(getConfig().getString("spleefrequestaplayer"))!=0 && p.getName().compareTo(getConfig().getString("spleefrequestbplayer"))!=0)) {
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
	  //隨�ｿｽ隨�ｿｽ
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
	  //隨�ｿｽ隨�ｿｽ
	  int bits=(int)(Math.ceil(curHP/maxHP*10));
	  String bar=" ";
	  if (hunger>=17) {
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
    	if (Math.random()<=0.001 || (getConfig().getBoolean("thanksgiving-enabled") && Math.random()<=0.01)) {
    		//5% chance it will start storming.
    		Bukkit.getWorld("world").setWeatherDuration((int)(Math.random()*6000));
    		Bukkit.getWorld("world").setThundering(true);
    		Bukkit.getWorld("world").setThunderDuration((int)(Math.random()*6000));
    	}
    	LOGGING_UPDATE_COUNTS=0;
          for (int i=0;i<SPEED_CONTROL.size();i++) {
        	  SPEED_CONTROL.get(i).updatePlayerSpd();
        	  try
        	  {
        	      String filename= "PlayerBuffData.txt";
        	      FileWriter fw = new FileWriter(filename,true); //the true will append the new data
        	      fw.write("["+SERVER_TICK_TIME+"]"+"PlayerBuffData for "+SPEED_CONTROL.get(i).p.getName()+": "+SPEED_CONTROL.get(i).toString()+"\n");//appends the string to the file
        	      if (i+1==SPEED_CONTROL.size()) {
        	    	  fw.write("========\n");
        	      }
        	      fw.close();
        	  }
        	  catch(IOException ioe)
        	  {
        	      System.err.println("IOException: " + ioe.getMessage());
        	  }
          }
          if (SPEED_CONTROL.size()!=Bukkit.getOnlinePlayers().length) {
        	  Bukkit.getLogger().warning("["+SERVER_TICK_TIME+"]SPEED_CONTROL and ONLINE PLAYERS list length don't match! ("+SPEED_CONTROL.size()+"/"+Bukkit.getOnlinePlayers().length+")");
          }
          LOGGING_UPDATE_COUNTS++; //1
          for (int i=0;i<explorers.size();i++) {
        	  /*
			  int deadpoint=-1;
			  int exppoint=-1;
    		  Player p = Bukkit.getPlayer(explorers.get(i).name);
        	  if (explorers.get(i).event==1 && Bukkit.getPlayer(explorers.get(i).name)!=null && !Bukkit.getPlayer(explorers.get(i).name).isDead()) {
        		  if (getJobLv("Explorer", p)>=10) {
    				  PersistentExplorerList eve = new PersistentExplorerList(p.getName().toLowerCase());
    				  eve.event=1;
    				  eve.data=p.getExp();
    				  eve.data2=p.getLevel();
    				  eve.expiretime=Main.SERVER_TICK_TIME+1200;
    				  explorers.add(eve);
        		  }
        	  }
			  if (explorers.get(i).event==1 && explorers.get(i).name.compareTo(p.getName().toLowerCase())==0) {
				  exppoint=i;
				  //p.setTotalExperience(p.getTotalExperience()+explorers.get(j).data);
				  //p.sendMessage("Your experience: "+explorers.get(i).data+"/"+p.getTotalExperience());
			  } else
			  if (explorers.get(i).event==2 && explorers.get(i).name.compareTo(p.getName().toLowerCase())==0) {
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
    			if (getPlayerData(list[i]).furytime!=0 && Main.SERVER_TICK_TIME>getPlayerData(list[i]).furytime) {
    				getPlayerData(list[i]).furytime=0;
    				list[i].sendMessage(ChatColor.RED+""+ChatColor.ITALIC+"Fury Potion effect has worn off...");
    			}
    			if (getPlayerData(list[i]).invulntime!=0 && Main.SERVER_TICK_TIME>getPlayerData(list[i]).invulntime) {
    				getPlayerData(list[i]).invulntime=0;
    				list[i].sendMessage(ChatColor.RED+""+ChatColor.ITALIC+"Invulnerability Potion effect has worn off...");
    			}
    			if (hasJobBuff("Hunter", list[i],Job.JOB40)) {
    				if (Bukkit.getWorld("world").getTime()>13000) {
    					list[i].addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,200,1,true));
    				}
    			}
        		if (hasJobBuff("Hunter", list[i], Job.JOB30A)) {
        			getPlayerData(list[i]).blockstack=0;
        		}
    			if (list[i].getAllowFlight() && hasJobBuff("Builder", list[i], Job.JOB40) && SERVER_TICK_TIME-getPlayerData(list[i]).lastflighttime>=200) {
    				if (list[i].getGameMode()!=GameMode.CREATIVE) {
    					list[i].setAllowFlight(false);
						list[i].setFlying(false);
    				}
    				list[i].sendMessage(ChatColor.DARK_RED+""+ChatColor.ITALIC+"Flight disabled...");
    			}
    			if (list[i].getAllowFlight() && hasJobBuff("Fisherman", list[i], Job.JOB40) && !list[i].isOnGround() && SERVER_TICK_TIME-getPlayerData(list[i]).lastflighttime>=100) {
    				if (list[i].getGameMode()!=GameMode.CREATIVE) {
    					list[i].setAllowFlight(false);
						list[i].setFlying(false);
    				}
    				list[i].sendMessage(ChatColor.DARK_RED+""+ChatColor.ITALIC+"Flight disabled...");
    			}
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
    			int airmeasure=0;
    			//Get the underground chunk density of this chunk.
    			//Max chunk density is 12800.
    			Chunk c = list[i].getWorld().getChunkAt(list[i].getLocation());
    			for (int x=0;x<16;x++) {
        			for (int y=0;y<50;y++) {
            			for (int z=0;z<16;z++) {
            				if (c.getBlock(x, y, z).getType()==Material.AIR) {
            					airmeasure++;
            				}
            			}
        			}
    			}
    			//Bukkit.getLogger().info("For player "+list[i].getName()+", Chunk air density is "+((double)airmeasure/12800)*100.0d+"%");
    			if (!spawneddungeon && ((double)airmeasure/12800)*100.0d<=10) { //Make sure the air density is small enough that we are allowed to carve things.
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
    			}
    			list[i].getScoreboard().getTeam(list[i].getName().toLowerCase()).setSuffix(healthbar(list[i].getHealth(),list[i].getMaxHealth(),list[i].getFoodLevel()));
    			
    			/* Team t = list[i].getScoreboard().getTeam(list[i].getName());
    			double hp = list[i].getHealth();
    			double maxhp = list[i].getMaxHealth();
    			int food = list[i].getFoodLevel();
    			t.setSuffix(healthbar(hp, maxhp, food)); */
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
    }, 200, 200);
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
	  					  if (hasJobBuff("Brewer", brewingstandlist.get(i).owner, Job.JOB40)) {
	  						brewingstandlist.get(i).set_newTime(true);
	  						brewingstandlist.get(i).setBrewingTime(brewingstandlist.get(i).getBrewingTime()/4);
	  					  }
	  					  if (PlayerinJob(brewingstandlist.get(i).owner, "Brewer") && getJobLv("Brewer", brewingstandlist.get(i).owner)>=5) {
		  					  brewingstandlist.get(i).set_newTime(true);
		  					  //Bukkit.getPlayer("sigonasr2").sendMessage("Old Brewing time: "+brewingstandlist.get(i).getBrewingTime());
		  					  //brewingstandlist.get(i).setBrewingTime(brewingstandlist.get(i).getBrewingTime()/2);
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
  			//Bukkit.getWorld("world").setFullTime(Bukkit.getWorld("world").getFullTime()-4);
	  		  if (last_world_time==0) {
				  last_world_time = Bukkit.getWorld("world").getFullTime();
			  } else {
				  int raisecount=0;
				  while (Bukkit.getWorld("world").getFullTime()-last_world_time>=2) {
					  last_world_time+=2;
					  raisecount++;
				  }
				Bukkit.getWorld("world").setFullTime(Bukkit.getWorld("world").getFullTime()-raisecount);
			  }
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
          allOnlineP.sendMessage(ChatColor.GOLD+"Your Balance: $"+df.format((getAccountsConfig().getDouble(allOnlineP.getName().toLowerCase() + ".money")))+" -> $"+df.format(((Main.this.getConfig().getDouble("payday.amount")*(getAccountsConfig().getDouble(allOnlineP.getName().toLowerCase() + ".money"))+getAccountsConfig().getDouble(allOnlineP.getName().toLowerCase() + ".money")))));
          allOnlineP.sendMessage(ChatColor.DARK_GREEN+"<==========================>");
          getAccountsConfig().set(allOnlineP.getName().toLowerCase() + ".money", ((Main.this.getConfig().getDouble("payday.amount")*(getAccountsConfig().getDouble(allOnlineP.getName().toLowerCase() + ".money"))+getAccountsConfig().getDouble(allOnlineP.getName().toLowerCase() + ".money"))));
          //Main.economy.depositPlayer(allOnlineP.getName().toLowerCase(), (Main.this.getConfig().getDouble("payday.amount")*Main.economy.bankBalance(allOnlineP.getName().toLowerCase()).balance));
        }
        for (OfflinePlayer allOnlineP : Bukkit.getOfflinePlayers()) {
        	if (!allOnlineP.isOnline()) {
        		getAccountsConfig().set(allOnlineP.getName().toLowerCase() + ".money", ((Main.this.getConfig().getDouble("payday.amount")*(getAccountsConfig().getDouble(allOnlineP.getName().toLowerCase() + ".money"))+getAccountsConfig().getDouble(allOnlineP.getName().toLowerCase() + ".money"))));
        	}
            //Main.economy.depositPlayer(allOnlineP.getName().toLowerCase(), (Main.this.getConfig().getDouble("payday.amount")*Main.economy.bankBalance(allOnlineP.getName().toLowerCase()).balance));
        }
        //saveAccountsConfig() //Commented out;
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
		if (getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job1").compareTo("None")!=0) {
			count++;
		}
		if (getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job2").compareTo("None")!=0) {
			count++;
		}
		if (getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job3").compareTo("None")!=0) {
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
    		if (getJobLv(job,p)>=40) {
		    	getAccountsConfig().set(p.getName().toLowerCase()+".jobs.ultimate", String.valueOf(ValidJobs[matchedjob]));
		    	//saveAccountsConfig() //Commented out;
		    	p.sendMessage(ChatColor.YELLOW+"Set Declared Ultimate job to "+job);
		    	p.sendMessage("");
		    	p.sendMessage(ChatColor.GOLD+""+ChatColor.ITALIC+"Unlike other buffs, you do not just receive the buff immediately. You have to earn it.");
		    	p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+"Earn enough job exp to be proven worthy, and then search mob drops for a special trinket. The more exp you have built up, the better the chance you'll find one.");
		    	p.sendMessage("");
		    	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"(Note you can still change your declared ultimate at any time during this time.)");
    		} else {
        		p.sendMessage(ChatColor.GOLD+"Sorry, you are not a high enough level in that job yet!");
        		return;
    		}
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
    	if (getConfig().getInt("jobs."+ValidJobs[matchedjob])==0) {
    		//Simply set the string.
    		getConfig().set("jobs."+ValidJobs[matchedjob]+"_members",String.valueOf(p.getName().toLowerCase()));
    	} else {
    		//Append to list.
    		getConfig().set("jobs."+ValidJobs[matchedjob]+"_members",String.valueOf(getConfig().getString("jobs."+ValidJobs[matchedjob]+"_members")+", "+p.getName().toLowerCase()));
    	}
    	if (getConfig().getInt("jobs."+ValidJobs[matchedjob])==0) {
    		//Simply set the string.
    		getConfig().set("jobs."+ValidJobs[matchedjob]+"_members",String.valueOf(p.getName().toLowerCase()));
    	} else {
    		//Append to list.
    		getConfig().set("jobs."+ValidJobs[matchedjob]+"_members",String.valueOf(getConfig().getString("jobs."+ValidJobs[matchedjob]+"_members")+", "+p.getName().toLowerCase()));
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
    		if (getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job"+(i+1)).equalsIgnoreCase("None")) {
    			openslot=i;
    			Bukkit.getLogger().info("Found a None job slot.");
    			break;
    		}
    	}
    	if (ValidJobs[matchedjob].compareTo("Explorer")==0) {
    	    explorerlist.add(new ExplorerData(p.getName().toLowerCase(), p.getLocation().getX(), p.getLocation().getZ()));
    	}
    	if (ValidJobs[matchedjob].compareTo("Support")==0) {
    	    supportplayers.add(new SupportPlayer(p));
    	}
    	if (ValidJobs[matchedjob].compareTo("Hunter")==0) {
    	    hunterplayers.add(p);
    	}
		Bukkit.getLogger().info("Added extra job pieces when joining.");
    	getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job"+(openslot+1), String.valueOf(ValidJobs[matchedjob]));
    	getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job"+(openslot+1)+"lv", Integer.valueOf(1));
    	getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job"+(openslot+1)+"exp", Double.valueOf(0));
    	//saveAccountsConfig() //Commented out;
		Bukkit.getLogger().info("Set job data.");
    	Bukkit.broadcastMessage(p.getName().toLowerCase()+" has joined the "+JobColors[matchedjob]+ValidJobs[matchedjob]+ChatColor.WHITE+" job!");
    	p.sendMessage("You can check out your job progress anytime with "+ChatColor.GOLD+"/jobs stats"+ChatColor.WHITE+".");
    	return true;
    }
	
	public String[] getJobs(Player p) {
		return getJobs(p.getName());
	}
	
	public String[] getJobs(String p) {
		p=p.toLowerCase();
		String[] string= {getAccountsConfig().getString(p.toLowerCase()+".jobs.job1"),getAccountsConfig().getString(p.toLowerCase()+".jobs.job2"),getAccountsConfig().getString(p.toLowerCase()+".jobs.job3")};
		return string;
	}
	
	public boolean PlayerinJob(String p,String job) {
		p=p.toLowerCase();
		String[] jobs = getJobs(p);
		for (int i=0;i<jobs.length;i++) {
			if (job.equalsIgnoreCase(jobs[i])) {
				return true;
			}
		}
		return false;
	}
	
	public boolean PlayerinJob(Player p,String job) {
		return PlayerinJob(p.getName(), job);
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
		JobsDataInfo[] Jobsinfo = {Woodcutter_job,Miner_job,Builder_job,Digger_job,Hunter_job,Fisherman_job,Weaponsmith_job,Blacksmith_job,Cook_job,Brewer_job,Enchanter_job,Breeder_job,Explorer_job,Support_job};
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
		getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"exp", Double.valueOf(newexp));
		//saveAccountsConfig() //Commented out;
	}
	
	public double getPlayerCurrentJobExp(Player p, String job) {
		if (PlayerinJob(p, job)) {
			int slot = -1;
			String[] joblist = getJobs(p);
			for (int i=0;i<joblist.length;i++) {
				if (joblist[i].equalsIgnoreCase(job)) {
					slot=i;
					break;
				}
			}
			return getAccountsConfig().getDouble(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"exp");
		} else {
			return 0;
		}
	}

	public void gainMoneyExp(Player p,String job,double amount,double exp) {
		String[] jobs = getJobs(p);
		int slot=-1;
		if (getConfig().getBoolean("halloween-enabled") || getConfig().getBoolean("thanksgiving-enabled")) {
			amount*=2;
			exp*=2;
		}
		//Add to how much we've earned so far.
		for (int i=0;i<SPEED_CONTROL.size();i++) {
			if (SPEED_CONTROL.get(i).p.getName().equalsIgnoreCase(p.getName().toLowerCase())) {
				SPEED_CONTROL.get(i).money_gained+=amount;
				break;
			}
		}
		JobsDataInfo[] Jobsinfo = {Woodcutter_job,Miner_job,Builder_job,Digger_job,Hunter_job,Fisherman_job,Weaponsmith_job,Blacksmith_job,Cook_job,Brewer_job,Enchanter_job,Breeder_job,Explorer_job,Support_job};
		for (int i=0;i<jobs.length;i++) {
			if (job.equalsIgnoreCase(jobs[i])) {
				slot=i;
				break;
			}
		}
		JobsDataInfo info = Jobsinfo[getJobSlot(job)];
		economy.depositPlayer(p.getName(), amount*(1d+(info.moneymult*getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"lv"))));
		getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"exp", Double.valueOf(getAccountsConfig().getDouble(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"exp")+exp));
		if (getAccountsConfig().getDouble(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"exp")<0) {
			//It can't be negative.
			getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"exp", Double.valueOf(0.0));
		}
		//Check for lv up.
		if (getJobLv(job,p)<40 && getJobExp(job,getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"lv"))<=getAccountsConfig().getDouble(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"exp")) {
			//Level up! Level up! YEAH!
			getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"exp", Double.valueOf(getAccountsConfig().getDouble(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"exp")-getJobExp(job,getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"lv"))));
			getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"lv", Integer.valueOf(getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"lv")+1));
			Bukkit.broadcastMessage(p.getName()+" is now a Level "+getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"lv")+" "+getJobColor(job)+job+ChatColor.WHITE+".");
			notifyBuffMessages(p);
			if (getJobTotalLvs(p)%5==0) {
				Bukkit.broadcastMessage(ChatColor.GREEN+p.getName()+" has reached Level "+getJobTotalLvs(p)+"!");
				if ((((getJobTotalLvs(p)/5+1)-getStatPointTotal(p)))>0) {
					p.sendMessage(ChatColor.GOLD+"You have earned 1 stat point! You now have "+(((getJobTotalLvs(p)/5+1)-getStatPointTotal(p)))+" stat point"+((((getJobTotalLvs(p)/5+1)-getStatPointTotal(p)))==1?"":"s")+" to spend. "+ChatColor.ITALIC+ChatColor.BLUE+" Type /sp to spend them!");
				}
			}
		}
		//saveAccountsConfig() //Commented out;
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
				getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"lv", Integer.valueOf(getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"lv")+1));
				Bukkit.broadcastMessage(p.getName()+" is now a Level "+getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"lv")+" "+getJobColor(job)+job+ChatColor.WHITE+".");
				notifyBuffMessages(p);
				if (getJobTotalLvs(p)%5==0) {
					Bukkit.broadcastMessage(ChatColor.GREEN+p.getName()+" has reached Level "+getJobTotalLvs(p)+"!");
					if ((((getJobTotalLvs(p)/5+1)-getStatPointTotal(p)))>0) {
						p.sendMessage(ChatColor.GOLD+"You have earned 1 stat point! You now have "+(((getJobTotalLvs(p)/5+1)-getStatPointTotal(p)))+" stat point"+((((getJobTotalLvs(p)/5+1)-getStatPointTotal(p)))==1?"":"s")+" to spend. "+ChatColor.ITALIC+ChatColor.BLUE+" Type /sp to spend them!");
					}
				}
				//saveAccountsConfig() //Commented out;
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
		if (getConfig().getBoolean("halloween-enabled") || getConfig().getBoolean("thanksgiving-enabled")) {
			amount*=2;
		}
		//Add to how much we've earned so far.
		for (int i=0;i<SPEED_CONTROL.size();i++) {
			if (SPEED_CONTROL.get(i).p.getName().equalsIgnoreCase(p.getName().toLowerCase())) {
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
		economy.depositPlayer(p.getName(), amount*(1d+(info.moneymult*getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job"+slot+"lv"))));
	}
	
	public ChatColor getJobColor(String job) {
		for (int i=0;i<ValidJobs.length;i++) {
			if (job.equalsIgnoreCase(ValidJobs[i])) {
				return JobColors[i];
			}
		}
		return ChatColor.WHITE;
	}
	
	/**
	 * Returns the job slot of the job in the GLOBAL JOB LIST. NOT for players!
	 * @param job The job name to find the slot of.
	 * @return The slot in the array ValidJobs[].
	 */
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
				if (getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job"+(i+1)).equalsIgnoreCase(job)) {
					slot=i;
					break;
				}
			}
			if (slot!=-1) {
				return getAccountsConfig().getDouble(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"exp");
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
		if (item.getType()==Material.GOLD_SWORD) {enchant_data=ENCHANTMENT_DATA.golden_sword;} else
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
		if (item.getType()==Material.CHAINMAIL_HELMET) {enchant_data=ENCHANTMENT_DATA.chain_helmet;} else
		if (item.getType()==Material.CHAINMAIL_CHESTPLATE) {enchant_data=ENCHANTMENT_DATA.chain_chestplate;} else
		if (item.getType()==Material.CHAINMAIL_LEGGINGS) {enchant_data=ENCHANTMENT_DATA.chain_leggings;} else
		if (item.getType()==Material.CHAINMAIL_BOOTS) {enchant_data=ENCHANTMENT_DATA.chain_boots;}
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
					if (enchantments==1 && Math.random()<=0.07*((double)lv)) {
						keepgoing=true;
					} else
					if (enchantments==2 && Math.random()<=0.045*((double)lv)) {
						keepgoing=true;
					} else
					if (enchantments==3 && Math.random()<=0.03*((double)lv)) {
						keepgoing=true;
					}
					if (!keepgoing) {
						break;
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
								  if (is_PermanentProperty(thelore.get(i))) {
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
	
	/**
	 * DEPRECATED. Use hasJobBuff() to determine if a player has a buff.
	 * @param job The job name.
	 * @param p The name of the player we are checking.
	 * @return The level of the player in a specific job.
	 */
	@Deprecated
	public int getJobLv(String job, String p) {
		p=p.toLowerCase();
		if (PlayerinJob(p,job)) {
			int slot=-1;
			//Check which slot contains our job.
			for (int i=0;i<3;i++) {
				if (getAccountsConfig().getString(p.toLowerCase()+".jobs.job"+(i+1)).equalsIgnoreCase(job)) {
					slot=i;
					break;
				}
			}
			if (slot!=-1) {
				return getAccountsConfig().getInt(p.toLowerCase()+".jobs.job"+(slot+1)+"lv");
			} else {
				return 0;
			}
		}
		return 0;
	}
	
	public boolean hasJobBuff(String job, Player p, Job j) {
		return hasJobBuff(job, p.getName(), j);
	}
	
	public boolean hasJobBuff(String job, String p, Job j) {
		if (PlayerinJob(p,job) || j==Job.JOB40) {
			//Bukkit.getLogger().info("Inside 1.");
			int slot=-1;
			//Check which slot contains our job.
			for (int i=0;i<3;i++) {
				if (getAccountsConfig().getString(p.toLowerCase()+".jobs.job"+(i+1)).equalsIgnoreCase(job)) {
					slot=i;
					break;
				}
			}
			if (slot!=-1 || j==Job.JOB40) {
				//Bukkit.getLogger().info("Inside 2. j is "+j.toString()+". ultimate: "+getAccountsConfig().getString(p.toLowerCase()+".jobs.ultimate")+", Sealed ulti:"+ getAccountsConfig().getBoolean(p.toLowerCase()+".jobs.ultimatesealed"));
				int level = getAccountsConfig().getInt(p.toLowerCase()+".jobs.job"+(slot+1)+"lv");
				switch (j) {
					case JOB5: {
						if (level>=5) {
							return true;
						} else {
							return false;
						}
					}
					case JOB10: {
						if (level>=10) {
							return true;
						} else {
							return false;
						}
					}
					case JOB20: {
						if (level>=20) {
							return true;
						} else {
							return false;
						}
					}
					case JOB30A: {
						if (level>=30 && getAccountsConfig().getInt(p.toLowerCase()+".jobs.job"+(slot+1)+"_30")==1) {
							return true;
						} else {
							return false;
						}
					}
					case JOB30B: {
						if (level>=30 && getAccountsConfig().getInt(p.toLowerCase()+".jobs.job"+(slot+1)+"_30")==2) {
							return true;
						} else {
							return false;
						}
					}
					case JOB40: {
						if (getAccountsConfig().getString(p.toLowerCase()+".jobs.ultimate").equalsIgnoreCase(job) && getAccountsConfig().getBoolean(p.toLowerCase()+".jobs.ultimatesealed")) {
							//Bukkit.getLogger().info("Inside 3.");
							return true;
						} else {
							return false;
						}
					}
					default: {
						return false;
					}
				}
			} else {
				return false;
			}
		}
		return false;
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

	public PlayerData getPlayerData(Player p) {
		  //Find my data.
		  return playerdata_list.get(getPlayerDataSlot(p));
	}
	
	/**
	 * DEPRECATED. Use hasJobBuff() to determine if a player has a buff.
	 * @param job The job name.
	 * @param p The player we are checking.
	 * @return The level of the player in a specific job.
	 */
	@Deprecated
	public int getJobLv(String job, Player p) {
		if (PlayerinJob(p,job)) {
			int slot=-1;
			//Check which slot contains our job.
			for (int i=0;i<3;i++) {
				if (getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job"+(i+1)).equalsIgnoreCase(job)) {
					slot=i;
					break;
				}
			}
			if (slot!=-1) {
				return getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"lv");
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
			totallv+=getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job"+(i+1)+"lv");
		}
		return totallv;
	}
	
	public int getStatPointTotal(Player p) {
		int total=0;
		for (int i=0;i<10;i++) {
			total+=getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat"+(i+1));
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

	/**
	 * Gets the job number slot that the job holds.
	 * @param job The job string to look for. CASE-SENSITIVE.
	 * @param p The name of the player to search for.
	 * @return The slot number (1-3) of the job. -1 if the job could not be found.
	 */
	public int getPlayerJobSlot(String job, String p) {
		if (PlayerinJob(p, job)) {
			p=p.toLowerCase();
			if (getAccountsConfig().getString(p+".jobs.job1").equalsIgnoreCase(job)) {
				return 1;
			}
			if (getAccountsConfig().getString(p+".jobs.job2").equalsIgnoreCase(job)) {
				return 2;
			}
			if (getAccountsConfig().getString(p+".jobs.job3").equalsIgnoreCase(job)) {
				return 3;
			}
			return -1;
		} else {
			return -1;
		}
	}

	/**
	 * Gets the job number slot that the job holds.
	 * @param job The job string to look for. CASE-SENSITIVE.
	 * @param p The name of the player to search for.
	 * @return The slot number (1-3) of the job. -1 if the job could not be found.
	 */
	public int getPlayerJobSlot(String job, Player p) {
		return getPlayerJobSlot(job, p.getName());
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
    	if (job.equalsIgnoreCase(getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job1"))) {
    		String[] s = getConfig().getString("jobs."+getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job1")+"_members").split(", ");
    		String s2 = "";
    		for (int i=0;i<s.length;i++) {
    			if (!s[i].equalsIgnoreCase(p.getName().toLowerCase())) {
    				if (s2.equals("")) {
    					s2 = s[i];
    				} else {
    					s2 += ", "+s[i];
    				}
    			}
    		}
    		getConfig().set("jobs."+getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job1")+"_members", s2);
        	//Remove 1 from main config.
        	getConfig().set("jobs."+getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job1"), Integer.valueOf(getConfig().getInt("jobs."+getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job1"))-1));
        	saveConfig();
    		//Remove from job 1.
        	Bukkit.broadcastMessage(p.getName()+" has left the "+getJobColor(getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job1"))+getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job1")+ChatColor.WHITE+" job!");
        	getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job1", String.valueOf("None"));
        	getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job1lv", Integer.valueOf(0));
        	getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job1_30", Integer.valueOf(0));
        	getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job1exp", Double.valueOf(0));
        	//saveAccountsConfig() //Commented out;
        	return true;
    	} else
    		if (job.equalsIgnoreCase(getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job2"))) {
        		String[] s = getConfig().getString("jobs."+getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job2")+"_members").split(", ");
        		String s2 = "";
        		for (int i=0;i<s.length;i++) {
        			if (!s[i].equalsIgnoreCase(p.getName().toLowerCase())) {
        				if (s2.equals("")) {
        					s2 = s[i];
        				} else {
        					s2 += ", "+s[i];
        				}
        			}
        		}
        		getConfig().set("jobs."+getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job2")+"_members", s2);
        	getConfig().set("jobs."+getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job2"), Integer.valueOf(getConfig().getInt("jobs."+getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job2"))-1));
        	saveConfig();
    		//Remove from job 2.
        	Bukkit.broadcastMessage(p.getName()+" has left the "+getJobColor(getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job2"))+getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job2")+ChatColor.WHITE+" job!");
        	getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job2", String.valueOf("None"));
        	getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job2lv", Integer.valueOf(0));
        	getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job2_30", Integer.valueOf(0));
        	getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job2exp", Double.valueOf(0));
        	//saveAccountsConfig() //Commented out;
        	return true;
    	} else
    		if (job.equalsIgnoreCase(getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job3"))) {
        		String[] s = getConfig().getString("jobs."+getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job3")+"_members").split(", ");
        		String s2 = "";
        		for (int i=0;i<s.length;i++) {
        			if (!s[i].equalsIgnoreCase(p.getName().toLowerCase())) {
        				if (s2.equals("")) {
        					s2 = s[i];
        				} else {
        					s2 += ", "+s[i];
        				}
        			}
        		}
        		getConfig().set("jobs."+getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job3")+"_members", s2);
        	getConfig().set("jobs."+getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job3"), Integer.valueOf(getConfig().getInt("jobs."+getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job3"))-1));
        	saveConfig();
    		//Remove from job 3.
        	Bukkit.broadcastMessage(p.getName()+" has left the "+getJobColor(getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job3"))+getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job3")+ChatColor.WHITE+" job!");
        	getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job3", String.valueOf("None"));
        	getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job3lv", Integer.valueOf(0));
        	getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job3_30", Integer.valueOf(0));
        	getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job3exp", Double.valueOf(0));
        	//saveAccountsConfig() //Commented out;
        	return true;
    	}
		Bukkit.broadcastMessage(ChatColor.RED+"[SEVERE]An internal error occurred, triggered by "+p.getName().toLowerCase()+".");
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
  	  if (s.contains(enchant) && (!enchant.equals("Durability") || (enchant.equals("Durability") && !s.contains(ChatColor.RED+"-400% Durability")))) {
  		  return true;
  	  }
  	  return false;
    }
    
    public boolean is_ItemCube(ItemStack item_cube) {
		if (item_cube.hasItemMeta() && item_cube.getItemMeta().hasLore()) {
			//Check to see if the Lore contains anything.
			for (int i=0;i<item_cube.getItemMeta().getLore().size();i++) {
				if (item_cube.getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 9 item slots.")) {
					return true;
				}
				if (item_cube.getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 54 item slots.")) {
					return true;
				}
				if (item_cube.getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 27 item slots.")) {
					return true;
				}
			}
		}
		return false;
    }

    public boolean is_PocketWorkbench(ItemStack workbench) {
		if (workbench.hasItemMeta() && workbench.getItemMeta().hasLore()) {
			//Check to see if the Lore contains anything.
			for (int i=0;i<workbench.getItemMeta().getLore().size();i++) {
				if (workbench.getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.GRAY+""+ChatColor.ITALIC+"This workbench can be")) {
					return true;
				}
			}
		}
		return false;
	}

    public boolean is_LootChest(ItemStack chest) {
		if (chest.hasItemMeta() && chest.getItemMeta().hasLore()) {
			//Check to see if the Lore contains anything.
			for (int i=0;i<chest.getItemMeta().getLore().size();i++) {
				if (chest.getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.GRAY+""+ChatColor.ITALIC+"A mysterious chest!")) {
					return true;
				}
			}
		}
		return false;
	}

    public int get_LootChestTier(ItemStack chest) {
		if (chest.hasItemMeta() && chest.getItemMeta().hasLore()) {
			//Check to see if the Lore contains anything.
			for (int i=0;i<chest.getItemMeta().getLore().size();i++) {
				if (chest.getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.GRAY+""+ChatColor.ITALIC+"Something is rattling")) {
					return 1; // Single loot
				}
				if (chest.getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.GRAY+""+ChatColor.ITALIC+"You feel powerful magic")) {
					return 2; // Mythic loot
				}
				if (chest.getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.GRAY+""+ChatColor.ITALIC+"It is very heavy; there")) {
					return 3; // Quantity loot
				}
				if (chest.getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.GRAY+""+ChatColor.ITALIC+"You can feel a variety of")) {
					return 4; // Multiloot
				}
				if (chest.getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.GRAY+""+ChatColor.ITALIC+"A torrential flow of dark")) {
					return 5; // Chaos loot
				}
			}
			
			
		}
		return 0;
    }
    
    public ItemStack generate_LootChest() {
    	return generate_LootChest(-1);
    }
    
    public ItemStack generate_LootChest(int tier) {
    	ItemStack chest = new ItemStack(Material.CHEST);
	    ItemMeta chest_name = chest.getItemMeta();
	    List<String> chestlore = new ArrayList<String>();
	    double rand = 1; // Randomly generated number determined by fair dice roll.  
	    
	    if (tier == -1) {
		    rand = Math.random();
		    // No argument, randomize
	    }
	    if (tier == 0) {
	    	// Invalid chest, don't return anything
		    Bukkit.getLogger().warning("Invalid loot chest detected! This should never happen.");
		    return null;
	    }
	    
	    if (rand < 0.005 || tier == 2) {
	    	// Generate a mythic chest
	    	chest_name.setDisplayName(ChatColor.LIGHT_PURPLE+"Mythic Chest");
		 	   
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"A mysterious chest!");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"You feel powerful magic");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"emanating from within;");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"it must contain epic");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"equipment!");
		    chest_name.setLore(chestlore);

		    chest.setItemMeta(chest_name);
	    } else if (rand < 0.02 || tier == 3) {
	    	// Generate a loaded goods chest
	    	chest_name.setDisplayName(ChatColor.AQUA+"Heavy Chest");
		 	   
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"A mysterious chest!");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"It is very heavy; there");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"may be lots of loot within!");
		    chest_name.setLore(chestlore);

		    chest.setItemMeta(chest_name);
	    } else if (rand < 0.04 || tier == 5) {
	    	// Generate a chaos chest
	    	chest_name.setDisplayName(ChatColor.RED+"Chaos Chest");
		 	   
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"A mysterious chest!");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"A torrential flow of dark");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"energy causes the chest to");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"shake uncontrollably! You");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"have absolutely zero idea");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"what may be inside.");
		    chest_name.setLore(chestlore);

		    chest.setItemMeta(chest_name);
	    } else if (rand < 0.12 || tier == 4) {
	    	// Generate a loaded chest
	    	chest_name.setDisplayName(ChatColor.YELLOW+"Loaded Chest");
		 	   
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"A mysterious chest!");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"You can feel a variety of");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"items rattling around inside.");
		    chest_name.setLore(chestlore);

		    chest.setItemMeta(chest_name);
	    } else {
		    chest_name.setDisplayName(ChatColor.YELLOW+"Closed Chest");
			   
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"A mysterious chest!");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"Something is rattling");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"around inside; it may");
		    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"contain valuables!");
		    chest_name.setLore(chestlore);

		    chest.setItemMeta(chest_name);
	    }
	    
	    return chest;
    }
    
    public PlayerListener.Cube get_ItemCubeType(ItemStack item_cube) {
		if (item_cube.hasItemMeta() && item_cube.getItemMeta().hasLore()) {
			//Check to see if the Lore contains anything.
			for (int i=0;i<item_cube.getItemMeta().getLore().size();i++) {
				if (item_cube.getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 9 item slots.")) {
					return PlayerListener.Cube.SMALL;
				}
				if (item_cube.getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 54 item slots.")) {
					return PlayerListener.Cube.LARGE;
				}
				if (item_cube.getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 27 item slots.")) {
					return PlayerListener.Cube.ENDER;
				}
			}
		}
		return null;
    }
    
    public int get_ItemCubeID(ItemStack item_cube) {
		if (item_cube.hasItemMeta() && item_cube.getItemMeta().hasLore()) {
			//Check to see if the Lore contains anything.
			for (int i=0;i<item_cube.getItemMeta().getLore().size();i++) {
				if (item_cube.getItemMeta().getLore().get(i).contains("ID#")) {
					return Integer.valueOf(item_cube.getItemMeta().getLore().get(i).replace("ID#", ""));
				}
			}
		}
		return -1;
    }
    
    public boolean is_PermanentProperty(String property) {
    	//This function determines if the certain lore property is supposed to be kept on the item.
    	//Useful for checking what to remove and not remove from lore.
    	List<String> permanent_properties = new ArrayList<String>();
    	permanent_properties.add(ChatColor.RED+"-400% Durability");
    	permanent_properties.add(ChatColor.RED+"Duplicated");
    	if (permanent_properties.contains(property)) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public double getEnchantmentNumb(String s) {
  	  //Parse the string for spaces.
  	  String[] enchant = s.split(" ");
  	  if (!s.contains(ChatColor.RED+"-400% Durability") && enchant[0].contains(ChatColor.YELLOW+"")) {
  		  String newstring = ((enchant[0].replace(ChatColor.YELLOW.getChar(), ' ')).replace('%', ' ')).replace(Character.toString((char)0x00A7), Character.toString((char)0x0020));
  		  //Bukkit.getLogger().info("Enchant number is "+Double.valueOf(newstring));
  		  return Double.valueOf(newstring);
  	  } else {
  		  return 0;
  	  }
    }
    public boolean hasDistortionOrb(Player p) {
    	for (int m=0;m<p.getInventory().getContents().length;m++) {
			if (p.getInventory().getContents()[m]!=null && p.getInventory().getContents()[m].getType()==Material.SLIME_BALL) { 
				// See if lore matches distortion orb
				if (p.getInventory().getContents()[m].getItemMeta().getLore()!=null) {
					List<String> data = p.getInventory().getContents()[m].getItemMeta().getLore();
					
					for (int i=0;i<data.size();i++) {
						if (data.get(i).contains("This orb distorts space-time")) {
							return true;
						}
					}
				}
			}
		}
    	return false;
    }
    
    public int getWitherlessRoseCount(Player p) {
    	int count = 0;
    	for (int m=0;m<p.getInventory().getContents().length;m++) {
			if (p.getInventory().getContents()[m]!=null && p.getInventory().getContents()[m].getType()==Material.RED_ROSE) { 
				// See if lore matches distortion orb
				if (p.getInventory().getContents()[m].getItemMeta().getLore()!=null) {
					List<String> data = p.getInventory().getContents()[m].getItemMeta().getLore();
					
					for (int i=0;i<data.size();i++) {
						if (data.get(i).contains("This flower is infused with")) {
							count += p.getInventory().getContents()[m].getAmount();
						}
					}
				}
			}
		}
    	return count;
    }
    
    public void setLv30Choice(Player p, String arg1, String arg2) {
    	if (getJobLv(arg1, p)>=30) {
	    	if (arg2.equals("1") || arg2.equals("2")) {
	    		if (getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job"+(getPlayerJobSlot(arg1, p))+"_30")==0) {
		    		//We are making a valid choice.
	    			getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job"+(getPlayerJobSlot(arg1, p))+"_30",Integer.valueOf(arg2));
	    			//saveAccountsConfig() //Commented out;
	        		p.sendMessage(ChatColor.GREEN+"You have set your Lv30 Buff choice for your "+arg1+" job to the "+((Integer.valueOf(arg2)==1)?"first":"second")+" version.");
	    		} else {
	        		p.sendMessage(ChatColor.RED+"Sorry, you already picked your Lv30 Buff Choice for that job! You can't change it.");
	    		}
	    	} else {
	  		  p.sendMessage("Usage: "+ChatColor.GREEN+"/jobs [JobName] 1"+ChatColor.WHITE+" or "+ChatColor.GREEN+"/jobs [JobName] 2"+ChatColor.WHITE+" - Set Lv30 Buff Choice.");
	    	}
    	} else {
    		p.sendMessage(ChatColor.RED+"Sorry, you are not a high enough level in that job to set your buff choice yet!");
    	}
    }
    
    public void notifyBuffMessages(Player p) {
    	notifyBuffMessages(p, 20);
    }
    
    /**
     * 
     * @param numb The number to convert to Roman Numerals.
     * @return A String version of the number converted in Roman Numeral Format.
     */
    public String toRomanNumeral(int numb) {
    	String[] ones = {"I","II","III","IV","V","VI","VII","VIII","IX"};
    	String[] tens = {"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    	String[] hundreds = {"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    	String RomanNumeral = "";
    	if (numb>999) {
    		//The number is too big for our converter.
    		return String.valueOf(numb);
    	} else {
    		String numb_reader = String.valueOf(numb);
    		//Bukkit.getLogger().info("Number is "+numb_reader+". Length is "+numb_reader.length());
			int offset = 3-numb_reader.length();
    		for (int i=0;i<numb_reader.length();i++) {
    			switch (offset+i) {
    				case 0:{
    		    		//Bukkit.getLogger().info("Hundreds, Read number: "+numb_reader.charAt(i)+", Add "+hundreds[(int)(numb_reader.charAt(i)-'0')-1]);
    					RomanNumeral+=hundreds[(int)(numb_reader.charAt(i)-'0')-1];
    				}break;
    				case 1:{
    		    		if (Integer.valueOf(numb_reader.charAt(i))!=0) {
	    		    		//Bukkit.getLogger().info("Tens, Read number: "+numb_reader.charAt(i)+", Add "+tens[(int)(numb_reader.charAt(i)-'0')-1]);
	    					RomanNumeral+=tens[(int)(numb_reader.charAt(i)-'0')-1];
    		    		}
    				}break;
    				case 2:{
    		    		//Bukkit.getLogger().info("Ones, Read number: "+numb_reader.charAt(i)+", Add "+ones[(int)(numb_reader.charAt(i)-'0')-1]);
    		    		if (Integer.valueOf(numb_reader.charAt(i))!=0) {
    		    			RomanNumeral+=ones[(int)(numb_reader.charAt(i)-'0')-1];
    		    		}
    				}break;
    			}
    		}
    		return RomanNumeral;
    	}
    }
    
    /**
     * 
     * @param roman_numeral The string in roman numeral form.
     * @return The integer version of the roman numeral given.
     */
    public int toNumber(String roman_numeral) {
    	String[] ones = {"I","II","III","IV","V","VI","VII","VIII","IX"};
    	String[] tens = {"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    	String[] hundreds = {"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    	int finalval = 0;
    	for (int i=0;i<3;i++) {
    		switch (i) {
	    		case 0:{
	    			//We have to find a matching hundreds value and replace it.
	    			for (int j=0;j<hundreds.length;j++) {
	    				if (roman_numeral.contains(hundreds[hundreds.length-j-1])) {
	    					roman_numeral = roman_numeral.replaceFirst(hundreds[hundreds.length-j-1], "");
	    					//Bukkit.getLogger().info("Found "+hundreds[hundreds.length-j-1]+", converting to "+(100*(hundreds.length-j))+". New String is "+roman_numeral);
	    					finalval+=100*(hundreds.length-j);
	    					break; //There is only one hundreds place.
	    				}
	    			}
	    		}break;
	    		case 1:{
	    			//We have to find a matching tens value and replace it.
	    			for (int j=0;j<tens.length;j++) {
	    				if (roman_numeral.contains(tens[tens.length-j-1])) {
	    					roman_numeral = roman_numeral.replaceFirst(tens[tens.length-j-1], "");
	    					//Bukkit.getLogger().info("Found "+tens[tens.length-j-1]+", converting to "+(10*(tens.length-j))+". New String is "+roman_numeral);
	    					finalval+=10*(tens.length-j);
	    					break; //There is only one tens place.
	    				}
	    			}
	    		}break;
	    		case 2:{
	    			//We have to find a matching ones value and replace it.
	    			for (int j=0;j<ones.length;j++) {
	    				if (roman_numeral.contains(ones[ones.length-j-1])) {
	    					roman_numeral = roman_numeral.replaceFirst(ones[ones.length-j-1], "");
	    					//Bukkit.getLogger().info("Found "+ones[ones.length-j-1]+", converting to "+((ones.length-j))+". New String is "+roman_numeral);
	    					finalval+=ones.length-j;
	    					break; //There is only one ones place.
	    				}
	    			}
	    		}break;
    		}
    	}
    	if (!roman_numeral.equalsIgnoreCase("")) {
    		Bukkit.getLogger().severe("Number could not be resolved completely from roman numeral. \""+roman_numeral+"\" remaining.");
    	}
    	return finalval;
    }
    
    /**
     * Removes a bonus enchantment from the item.
     * If the enchantment does not exist on the item,
     * the same exact copy of the item is returned.
     * If you want to instead lower the enchantment
     * level that exists on the item, use addEnchantment()
     * with the override argument turned on to do so.
     * @param item The item to remove the bonus enchant from.
     * @param enchant The bonus enchantment to remove. (See Main.ENCHANT_)
     * @return The new item with the given enchantment removed.
     */
    public ItemStack removeBonusEnchantment(ItemStack item, BonusEnchantment enchant) {
    	if (item.hasItemMeta() && item.getItemMeta().hasLore()) {
    		List<String> newlore = item.getItemMeta().getLore();
    		for (int i=0;i<item.getItemMeta().getLore().size();i++) {
    			if (item.getItemMeta().getLore().get(i).contains(enchant.name)) {
    				//Include it in the new meta.
    				newlore.remove(i);
    				break;
    			}
    		}
    		ItemMeta meta = item.getItemMeta();
    		meta.setLore(newlore);
    		item.setItemMeta(meta);
    		return item;
    	} else {
    		return item;
    	}
    }
    
    /**
     * Adds a bonus enchantment to an item.
     * If the enchantment already exists on the item,
     * it will add to the old amount unless override
     * is turned off. This version of the function 
     * automatically has override set to false, meaning 
     * it will add to the enchantment amount.
     * @param item The item to add the bonus enchant to.
     * @param enchant The bonus enchantment to apply. (See Main.ENCHANT_)
     * @param amt The value of the enchantment to apply.
     * @param override Whether or not the enchantment should be overwritten.
     * @return The item with the new enchantment added in.
     */
    public ItemStack addBonusEnchantment(ItemStack item, BonusEnchantment enchant, int amt) {
    	return addBonusEnchantment(item, enchant, amt, false);
    }
    
    /**
     * Adds a bonus enchantment to an item.
     * If the enchantment already exists on the item,
     * it will add to the old amount unless override
     * is turned off.
     * @param item The item to add the bonus enchant to.
     * @param enchant The bonus enchantment to apply. (See Main.ENCHANT_)
     * @param amt The value of the enchantment to apply.
     * @param override Whether or not the enchantment should be overwritten.
     * @return The item with the new enchantment added in.
     */
    public ItemStack addBonusEnchantment(ItemStack item, BonusEnchantment enchant, int amt, boolean override) {
    	List<String> lore = null;
    	String enchant_string = enchant.name;
    	boolean percent=enchant.percent, enchant_format=enchant.enchant_format;
    	if (item.hasItemMeta() && item.getItemMeta().hasLore()) {
    		ItemMeta meta = item.getItemMeta();
    		lore = item.getItemMeta().getLore();
    		//Make sure the lore doesn't already exist. If it does, we have to actually
    		//replace it.
    		boolean added=false;
    		for (int i=0;i<lore.size();i++) {
    			if (lore.get(i).contains(enchant_string)) {
    				if (!enchant_format) {
    					//Take that old amount and add onto it.
    					double oldamt=0;
    					if (!override) {oldamt = getEnchantmentNumb(lore.get(i));} else {oldamt=0;}
    					lore.set(i, ChatColor.YELLOW+"+"+(int)(oldamt+amt)+((percent)?"% ":" ")+ChatColor.BLUE+enchant_string);
    				} else {
    					double oldamt=0;
    					if (!override) {oldamt = getEnchantmentNumb(lore.get(i));} else {oldamt=0;}
    					String parser = lore.get(i);
    					parser.replace(enchant_string, "");
    					if (!override) {oldamt=toNumber(parser);} else {oldamt=0;}
    					lore.set(i, ChatColor.GRAY+enchant_string+" "+toRomanNumeral((int)amt));
    				}
    				added=true;
    				break;
    			}
    		}
    		if (!added) {
    			//Add onto the lore.
				if (!enchant_format) {
					lore.add(ChatColor.YELLOW+"+"+(int)amt+((percent)?"% ":" ")+ChatColor.BLUE+enchant_string);
				} else {
					lore.add(ChatColor.GRAY+enchant_string+" "+toRomanNumeral((int)amt));
				}
				added=true;
    		}
    		meta.setLore(lore);
    		item.setItemMeta(meta);
    		return sortEnchantments(item); //Sort all enchants before returning.
    	} else {
    		lore = new ArrayList<String>();
    		ItemMeta meta = item.getItemMeta();
			//Add onto the lore.
			if (!enchant_format) {
				lore.add(ChatColor.YELLOW+"+"+(int)amt+((percent)?"% ":" ")+ChatColor.BLUE+enchant_string);
			} else {
				lore.add(ChatColor.GRAY+enchant_string+" "+toRomanNumeral((int)amt));
			}
    		meta.setLore(lore);
    		item.setItemMeta(meta);
    		return sortEnchantments(item); //Sort all enchants before returning.
    	}
    }
    
    /**
     * 
     * @param item The item to sort Enchantments on.
     * @return The item with all enchantments sorted out.
     */
    public ItemStack sortEnchantments(ItemStack item) {
    	//Sorts the enchantments so they are in the intended order.
    	//(All Enchantments with Roman numerals are first.)
    	//(All bonus enchantments are sorted via their ID.)
    	//(Extra effects and descriptions are below.)
    	if (item.hasItemMeta() && item.getItemMeta().hasLore()) {
    		List<String> LoreData = item.getItemMeta().getLore();
    		ItemMeta meta = item.getItemMeta();
    		List<String> newLoreData = new ArrayList<String>();
    		//First find all 'extra' special enchantments.
    		for (int i=0;i<LoreData.size();i++) {
    			if (LoreData.get(i).contains(ChatColor.GRAY+"Sturdy ")) {
    				newLoreData.add(LoreData.get(i));
    				LoreData.remove(i);
    			}
    		}
    		//Now find all bonus enchantments.
    		for (int i=0;i<LoreData.size();i++) {
    			if (LoreData.get(i).contains(ChatColor.YELLOW+"+") &&
    					LoreData.get(i).contains(" ") &&
    					(LoreData.get(i).contains(ChatColor.BLUE+"Damage Reduction") ||
    							LoreData.get(i).contains(ChatColor.BLUE+"Health") ||
    							LoreData.get(i).contains(ChatColor.BLUE+"Armor Penetration") ||
    							LoreData.get(i).contains(ChatColor.BLUE+"Critical Chance") ||
    							LoreData.get(i).contains(ChatColor.BLUE+"Life Steal") ||
    							LoreData.get(i).contains(ChatColor.BLUE+"Attack Speed") ||
    							LoreData.get(i).contains(ChatColor.BLUE+"Damage") ||
    							LoreData.get(i).contains(ChatColor.BLUE+"Durability") ||
    							LoreData.get(i).contains(ChatColor.BLUE+"Block Chance") ||
    							LoreData.get(i).contains(ChatColor.BLUE+"Speed Boost Chance"))) {
    				newLoreData.add(LoreData.get(i));
    				LoreData.remove(i);
    			}
    		}
    		//Now everything else.
    		for (int i=0;i<LoreData.size();i++) {
				newLoreData.add(LoreData.get(i));
				LoreData.remove(i);
    		}
    		meta.setLore(newLoreData);
    		item.setItemMeta(meta);
    		return item;
    	} else {
    		return item;
    	}
    }

    public ItemStack convertArtifact(ItemStack artifact) {
    	//Converts an artifact into a really good piece of equipment. Decide the equipment style.
    	int style = (int)(Math.random()*3);
    	boolean diamond=false;
    	if (Math.random()<=0.35) {
    		diamond=true; //35% chance of the item being diamond. Otherwise it's iron.
    	}
    	int[] enchantment_id_list = {0,1,2,3,4,5,6,7,16,17,18,19,20,21,32,33,34,35,48,49,50,51};
    	if (Math.random()<=0.95) {
	    	switch (style) {
		    	case 0: {
		    		//Adds 1 Level 8 enchantment and a Level 4 sub-enchant.
		    		String itemname = "";
		    		if (!diamond) {
		    			itemname+="Iron";
		    		} else {
		    			itemname+="Diamond";
		    		}
		    		double random_choose = Math.random()*9.0d;
		    		//Bukkit.getLogger().info("Random choose is "+random_choose);
		    		switch ((int)random_choose) {
		    			case 0: {
		    				itemname+=" Chestplate";
		    			}break;
		    			case 1: {
		    				itemname+=" Helmet";
		    			}break;
		    			case 2: {
		    				itemname+=" Leggings";
		    			}break;
		    			case 3: {
		    				itemname+=" Boots";
		    			}break;
		    			case 4: {
		    				itemname+=" Pickaxe";
		    			}break;
		    			case 5: {
		    				itemname+=" Axe";
		    			}break;
		    			case 6: {
		    				itemname+=" Spade";
		    			}break;
		    			case 7: {
		    				itemname+=" Sword";
		    			}break;
		    			case 8: {
		    				itemname="Bow";
		    			}break;
		    		}
		    		//Choose a random enchanment.
		    		int randomenchant = (int)(Math.random()*enchantment_id_list.length);
		    		ItemStack legendary = new ItemStack(Material.getMaterial(itemname.toUpperCase().replace(" ", "_")));
		    		legendary.addUnsafeEnchantment(Enchantment.getById(enchantment_id_list[randomenchant]), 8);
		    		ItemMeta meta = legendary.getItemMeta();
		    		meta.setDisplayName(ChatColor.BOLD+"Treasured "+PlayerListener.convertToItemName(Enchantment.getById(enchantment_id_list[randomenchant]).getName()) + " " + itemname);
		    		legendary.setItemMeta(meta);
		    		legendary.addUnsafeEnchantment(Enchantment.getById(enchantment_id_list[randomenchant = (int)(Math.random()*enchantment_id_list.length)]), 4);
		    		return legendary;
		    	}
		    	case 1: {
		    		//Adds many lower-level enchantments altogether. (Between Levels 2-4)
		    		String itemname = "";
		    		if (!diamond) {
		    			itemname+="Iron";
		    		} else {
		    			itemname+="Diamond";
		    		}
		    		double random_choose = Math.random()*9.0d;
		    		//Bukkit.getLogger().info("Random choose is "+random_choose);
		    		switch ((int)random_choose) {
		    			case 0: {
		    				itemname+=" Chestplate";
		    			}break;
		    			case 1: {
		    				itemname+=" Helmet";
		    			}break;
		    			case 2: {
		    				itemname+=" Leggings";
		    			}break;
		    			case 3: {
		    				itemname+=" Boots";
		    			}break;
		    			case 4: {
		    				itemname+=" Pickaxe";
		    			}break;
		    			case 5: {
		    				itemname+=" Axe";
		    			}break;
		    			case 6: {
		    				itemname+=" Spade";
		    			}break;
		    			case 7: {
		    				itemname+=" Sword";
		    			}break;
		    			case 8: {
		    				itemname="Bow";
		    			}break;
		    		}
		    		//Choose a random enchanment.
		    		int randomenchant = (int)(Math.random()*enchantment_id_list.length);
		    		int enchantcount=0;
		    		ItemStack legendary = new ItemStack(Material.getMaterial(itemname.toUpperCase().replace(" ", "_")));
		    		while (enchantcount<enchantment_id_list.length/2+((int)(Math.random()*(enchantment_id_list.length/2)))) {
		    			if (legendary.getEnchantmentLevel(Enchantment.getById(enchantment_id_list[randomenchant]))==0) {
		    				legendary.addUnsafeEnchantment(Enchantment.getById(enchantment_id_list[randomenchant]), (int)(Math.random()*4)+1);
		    				enchantcount++;
		    			}
	    				randomenchant = (int)(Math.random()*enchantment_id_list.length);
		    		}
		    		ItemMeta meta = legendary.getItemMeta();
		    		meta.setDisplayName(ChatColor.BOLD+"Powered "+PlayerListener.convertToItemName(Enchantment.getById(enchantment_id_list[randomenchant]).getName()) + " " + itemname);
		    		legendary.setItemMeta(meta);
		    		return legendary;
		    	}
		    	case 2: {
		    		//Only two focused bonus enchants. One if very highly specced, the other is average.
		    		//Adds many lower-level enchantments altogether. (Between Levels 2-4)
		    		String itemname = "";
		    		if (!diamond) {
		    			itemname+="Iron";
		    		} else {
		    			itemname+="Diamond";
		    		}
		    		int type=1;
		    		double random_choose = Math.random()*9.0d;
		    		//Bukkit.getLogger().info("Random choose is "+random_choose);
		    		switch ((int)random_choose) {
		    			case 0: {
		    				itemname+=" Chestplate";
		    				type=2;
		    			}break;
		    			case 1: {
		    				itemname+=" Helmet";
		    				type=2;
		    			}break;
		    			case 2: {
		    				itemname+=" Leggings";
		    				type=2;
		    			}break;
		    			case 3: {
		    				itemname+=" Boots";
		    				type=2;
		    			}break;
		    			case 4: {
		    				itemname+=" Pickaxe";
		    				type=1;
		    			}break;
		    			case 5: {
		    				itemname+=" Axe";
		    				type=1;
		    			}break;
		    			case 6: {
		    				itemname+=" Spade";
		    				type=1;
		    			}break;
		    			case 7: {
		    				itemname+=" Sword";
		    				type=1;
		    			}break;
		    			case 8: {
		    				itemname="Bow";
		    				type=1;
		    			}break;
		    		}
		    		//Choose a random enchanment.
		    		int randomenchant = (int)(Math.random()*enchantment_id_list.length);
		    		int enchantcount=0;
		    		ItemStack legendary = new ItemStack(Material.getMaterial(itemname.toUpperCase().replace(" ", "_")));
		    		//Get two random bonus enchantments.
		    		List<String> lore = new ArrayList<String>();
		    		if (type==2) {
			    		int bonus_enchant1 = (int)(Math.random()*6); //0-5.
			    		int bonus_enchant2 = (int)(Math.random()*6); //0-5.
			    		while (bonus_enchant2==bonus_enchant1) {
			    			bonus_enchant2 = (int)(Math.random()*6);
			    		}
			    		switch (bonus_enchant1) {
			    			case 0: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*32)+16+1)+" "+ChatColor.BLUE+"Health");
			    			}break;
			    			case 1: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*30)+20+1)+"% "+ChatColor.BLUE+"Damage Reduction");
			    			}break;
			    			case 2: {
			    				lore.add(ChatColor.YELLOW+"+"+(((int)(Math.random()*200)+100+1)*10)+"% "+ChatColor.BLUE+"Durability");
			    			}break;
			    			case 3: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*30)+10+1)+"% "+ChatColor.BLUE+"Block Chance");
			    			}break;
			    			case 4: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*35)+20+1)+"% "+ChatColor.BLUE+"Speed Boost Chance");
			    			}break;
			    			case 5: {
			    				lore.add(ChatColor.GRAY+"Sturdy "+toRomanNumeral((int)(Math.random()*9)+2));
			    			}break;
			    		}
			    		switch (bonus_enchant2) {
		    				case 0: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*16)+8+1)+" "+ChatColor.BLUE+"Health");
			    			}break;
			    			case 1: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*15)+10+1)+"% "+ChatColor.BLUE+"Damage Reduction");
			    			}break;
			    			case 2: {
			    				lore.add(ChatColor.YELLOW+"+"+(((int)(Math.random()*100)+50+1)*10)+"% "+ChatColor.BLUE+"Durability");
			    			}break;
			    			case 3: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*15)+5+1)+"% "+ChatColor.BLUE+"Block Chance");
			    			}break;
			    			case 4: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*16)+10+1)+"% "+ChatColor.BLUE+"Speed Boost Chance");
			    			}break;
			    			case 5: {
			    				lore.add(ChatColor.GRAY+"Sturdy "+toRomanNumeral((int)(Math.random()*4)+1));
			    			}break;
			    		}
		    		} else {
			    		int bonus_enchant1 = (int)(Math.random()*5); //0-4.
			    		int bonus_enchant2 = (int)(Math.random()*5); //0-4.
			    		while (bonus_enchant2==bonus_enchant1) {
			    			bonus_enchant2 = (int)(Math.random()*5);
			    		}
			    		switch (bonus_enchant1) {
			    			case 0: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*30)+20+1)+"% "+ChatColor.BLUE+"Critical Chance");
			    			}break;
			    			case 1: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+4+1)+" "+ChatColor.BLUE+"Armor Penetration");
			    			}break;
			    			case 2: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*30)+20+1)+"% "+ChatColor.BLUE+"Life Steal");
			    			}break;
			    			case 3: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*90)+60+1)+"% "+ChatColor.BLUE+"Attack Speed");
			    			}break;
			    			case 4: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*15)+10+1)+" "+ChatColor.BLUE+"Damage");
			    			}break;
			    		}
			    		switch (bonus_enchant2) {
		    			case 0: {
		    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*15)+10+1)+"% "+ChatColor.BLUE+"Critical Chance");
		    			}break;
		    			case 1: {
		    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*5)+2+1)+" "+ChatColor.BLUE+"Armor Penetration");
		    			}break;
		    			case 2: {
		    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*15)+10+1)+"% "+ChatColor.BLUE+"Life Steal");
		    			}break;
		    			case 3: {
		    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*45)+30+1)+"% "+ChatColor.BLUE+"Attack Speed");
		    			}break;
		    			case 4: {
		    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*7)+5+1)+" "+ChatColor.BLUE+"Damage");
		    			}break;
			    		}
		    		}
		    		ItemMeta meta = legendary.getItemMeta();
		    		meta.setLore(lore);
		    		meta.setDisplayName(ChatColor.BOLD+"Spiritual"+" " + itemname);
		    		legendary.setItemMeta(meta);
		    		sortEnchantments(legendary);
		    		return legendary;
		    	}
		    	default: {
		    		return new ItemStack(Material.AIR); //Something bad happened. So we just return nothing / a null item.
		    	}
	    	}
    	} else {
    		//This is an actual Artifact piece. Has extremely strong stats with very high durability.
    		String itemname = "";
    		if (!diamond) {
    			itemname+="Iron";
    		} else {
    			itemname+="Diamond";
    		}
    		int type=1;
    		double random_choose = Math.random()*9.0d;
    		//Bukkit.getLogger().info("Random choose is "+random_choose);
    		switch ((int)random_choose) {
				case 0: {
					itemname+=" Chestplate";
					type=2;
				}break;
				case 1: {
					itemname+=" Helmet";
					type=2;
				}break;
				case 2: {
					itemname+=" Leggings";
					type=2;
				}break;
				case 3: {
					itemname+=" Boots";
					type=2;
				}break;
				case 4: {
					itemname+=" Pickaxe";
					type=1;
				}break;
				case 5: {
					itemname+=" Axe";
					type=1;
				}break;
				case 6: {
					itemname+=" Spade";
					type=1;
				}break;
				case 7: {
					itemname+=" Sword";
					type=1;
				}
				case 8: {
					itemname="Bow";
					type=1;
				}break;
    		}
    		//Choose a random enchanment.
    		int randomenchant = (int)(Math.random()*enchantment_id_list.length);
    		int enchantcount=0;
    		
    		List<String> lore = new ArrayList<String>();
    		if (type==2) {
	    		int bonus_enchant1 = (int)(Math.random()*6); //0-5.
	    		int enchant_count = 0;
	    		boolean[] done = {false, false, false, false, false, false};
	    		while (enchant_count<3) {
		    		switch (bonus_enchant1) {
		    			case 0: {
		    				if (!done[bonus_enchant1]) {
		    					lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*32)+16+1)+" "+ChatColor.BLUE+"Health");
		    					enchant_count++;
		    				}
		    			}break;
		    			case 1: {
		    				if (!done[bonus_enchant1]) {
		    					lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*30)+20+1)+"% "+ChatColor.BLUE+"Damage Reduction");
		    					enchant_count++;
		    				}
		    			}break;
		    			case 2: {
		    				if (!done[bonus_enchant1]) {
		    					lore.add(ChatColor.YELLOW+"+"+(((int)(Math.random()*200)+100+1)*10)+"% "+ChatColor.BLUE+"Durability");
		    					enchant_count++;
		    				}
		    			}break;
		    			case 3: {
		    				if (!done[bonus_enchant1]) {
		    					lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*30)+10+1)+"% "+ChatColor.BLUE+"Block Chance");
		    					enchant_count++;
		    				}
		    			}break;
		    			case 4: {
		    				if (!done[bonus_enchant1]) {
		    					lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*35)+20+1)+"% "+ChatColor.BLUE+"Speed Boost Chance");
		    					enchant_count++;
		    				}
		    			}break;
		    			case 5: {
		    				if (!done[bonus_enchant1]) {
		    					lore.add(ChatColor.GRAY+"Sturdy "+toRomanNumeral((int)(Math.random()*9)+2));
		    				}
		    			}break;
		    		}
					done[bonus_enchant1]=true;
					bonus_enchant1 = (int)(Math.random()*6);
	    		}
    		} else {
	    		int bonus_enchant1 = (int)(Math.random()*5); //0-4.
	    		int enchant_count = 0;
	    		boolean[] done = {false, false, false, false, false};
	    		while (enchant_count<3) {
    				if (!done[bonus_enchant1]) {
			    		switch (bonus_enchant1) {
			    			case 0: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*30)+20+1)+"% "+ChatColor.BLUE+"Critical Chance");
			    			}break;
			    			case 1: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+4+1)+" "+ChatColor.BLUE+"Armor Penetration");
			    			}break;
			    			case 2: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*30)+20+1)+"% "+ChatColor.BLUE+"Life Steal");
			    			}break;
			    			case 3: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*90)+60+1)+"% "+ChatColor.BLUE+"Attack Speed");
			    			}break;
			    			case 4: {
			    				lore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*15)+10+1)+" "+ChatColor.BLUE+"Damage");
			    			}break;
			    		}
    					enchant_count++;
    					done[bonus_enchant1]=true;
    				}
					bonus_enchant1 = (int)(Math.random()*5);
	    		}
    		}
    		
    		ItemStack legendary = new ItemStack(Material.getMaterial(itemname.toUpperCase().replace(" ", "_")));
    		while (enchantcount<enchantment_id_list.length/4+((int)(Math.random()*(enchantment_id_list.length/1.5d)))) {
    			if (legendary.getEnchantmentLevel(Enchantment.getById(enchantment_id_list[randomenchant]))==0) {
    				legendary.addUnsafeEnchantment(Enchantment.getById(enchantment_id_list[randomenchant]), (int)(Math.random()*10)+5);
    				enchantcount++;
    			}
				randomenchant = (int)(Math.random()*enchantment_id_list.length);
    		}
    		ItemMeta meta = legendary.getItemMeta();
    		meta.setLore(lore);
    		meta.setDisplayName(ChatColor.BOLD+""+ChatColor.AQUA+"Ancient "+PlayerListener.convertToItemName(Enchantment.getById(enchantment_id_list[randomenchant]).getName()) + " " + itemname);
    		legendary.setItemMeta(meta);
    		sortEnchantments(legendary);
    		return legendary;
    	}
    }
    
    private static Method getMethod(Class<?> cl, String method)
    {
        for (Method m : cl.getMethods())
            if (m.getName().equals(method))
                return m;
        return null;
    }


    /**
     * Explodes random firework on location
     * 
     * @param loc
     *            Location to explode
     */
    public static void playFirework(Location loc)
    {
        Random gen = new Random();
        try
        {
            Firework fw = loc.getWorld().spawn(loc, Firework.class);
            Method d0 = getMethod(loc.getWorld().getClass(), "getHandle");
            Method d2 = getMethod(fw.getClass(), "getHandle");
            Object o3 = d0.invoke(loc.getWorld(), (Object[]) null);
            Object o4 = d2.invoke(fw, (Object[]) null);
            Method d1 = getMethod(o3.getClass(), "broadcastEntityEffect");
            FireworkMeta data = fw.getFireworkMeta();
            data.addEffect(FireworkEffect
                    .builder()
                    .with(FireworkEffect.Type.values()[gen
                            .nextInt(FireworkEffect.Type.values().length)])
                    .flicker(gen.nextBoolean())
                    .trail(gen.nextBoolean())
                    .withColor(
                            Color.fromRGB(gen.nextInt(255), gen.nextInt(255),
                                    gen.nextInt(255)))
                    .withFade(
                            Color.fromRGB(gen.nextInt(255), gen.nextInt(255),
                                    gen.nextInt(255))).build());
            fw.setFireworkMeta(data);
            d1.invoke(o3, new Object[] { o4, (byte) 17 });
            fw.remove();
        }
        catch (Exception ex)
        {
            // not a Beta1.4.6R0.2 Server
        }
    }
    
    public void notifyBuffMessages(final Player p, int tick_delay) {
    	//Same as notifyBuffMessages(), but waits a number of ticks before displaying it.
    	//See which messages we have to display.
    	int total_tick_delay=tick_delay;
    	if (getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job1lv")>=30 && getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job1_30")==0) {
    		//Have not selected first job's buff.
	    	Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
		      @Override
		      public void run() {
		    	  String job = getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job1");
		    	  int color_slot = 0;
		    	  for (int i=0;i<ValidJobs.length;i++) {
		    		  if (job.equalsIgnoreCase(ValidJobs[i])) {color_slot=i; break;}
		    	  }
		    	  p.sendMessage(ChatColor.AQUA+"You have not selected your Lv30 Buff for the "+JobColors[color_slot]+job+" job yet!");
		    	  p.sendMessage(ChatColor.ITALIC+"Don't know what they are? Type "+ChatColor.RESET+ChatColor.YELLOW+"/jobs buffs "+job+"!");
		    	  p.sendMessage(ChatColor.ITALIC+"Once you decided one, type "+ChatColor.RESET+ChatColor.YELLOW+"'/jobs "+job+" 1'"+ChatColor.RESET+ChatColor.ITALIC+" or "+ChatColor.RESET+ChatColor.YELLOW+"'/jobs "+job+" 2'"+ChatColor.RESET+ChatColor.ITALIC+" to pick!");
		      }
		  	},total_tick_delay+=tick_delay);
    	}
    	if (getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job2lv")>=30 && getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job2_30")==0) {
    		//Have not selected first job's buff.
	    	Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
		      @Override
		      public void run() {
		    	  String job = getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job2");
		    	  int color_slot = 0;
		    	  for (int i=0;i<ValidJobs.length;i++) {
		    		  if (job.equalsIgnoreCase(ValidJobs[i])) {color_slot=i; break;}
		    	  }
		    	  p.sendMessage(ChatColor.AQUA+"You have not selected your Lv30 Buff for the "+JobColors[color_slot]+job+" job yet!");
		    	  p.sendMessage(ChatColor.ITALIC+"Don't know what they are? Type "+ChatColor.RESET+ChatColor.YELLOW+"/jobs buffs "+job+"!");
		    	  p.sendMessage(ChatColor.ITALIC+"Once you decided one, type "+ChatColor.RESET+ChatColor.YELLOW+"'/jobs "+job+" 1'"+ChatColor.RESET+ChatColor.ITALIC+" or "+ChatColor.RESET+ChatColor.YELLOW+"'/jobs "+job+" 2'"+ChatColor.RESET+ChatColor.ITALIC+" to pick!");
		      }
		  	},total_tick_delay+=tick_delay);
    	}
    	if (getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job3lv")>=30 && getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job3_30")==0) {
    		//Have not selected first job's buff.
	    	Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
		      @Override
		      public void run() {
		    	  String job = getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job3");
		    	  int color_slot = 0;
		    	  for (int i=0;i<ValidJobs.length;i++) {
		    		  if (job.equalsIgnoreCase(ValidJobs[i])) {color_slot=i; break;}
		    	  }
		    	  p.sendMessage(ChatColor.AQUA+"You have not selected your Lv30 Buff for the "+JobColors[color_slot]+job+" job yet!");
		    	  p.sendMessage(ChatColor.ITALIC+"Don't know what they are? Type "+ChatColor.RESET+ChatColor.YELLOW+"/jobs buffs "+job+"!");
		    	  p.sendMessage(ChatColor.ITALIC+"Once you decided one, type "+ChatColor.RESET+ChatColor.YELLOW+"'/jobs "+job+" 1'"+ChatColor.RESET+ChatColor.ITALIC+" or "+ChatColor.RESET+ChatColor.YELLOW+"'/jobs "+job+" 2'"+ChatColor.RESET+ChatColor.ITALIC+" to pick!");
		      }
		  	},total_tick_delay+=tick_delay);
    	}
    	if (getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job3lv")>=30 && getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job3_30")==0) {
    		//Have not selected first job's buff.
	    	Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
		      @Override
		      public void run() {
		    	  String job = getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job3");
		    	  int color_slot = 0;
		    	  for (int i=0;i<ValidJobs.length;i++) {
		    		  if (job.equalsIgnoreCase(ValidJobs[i])) {color_slot=i; break;}
		    	  }
		    	  p.sendMessage(ChatColor.AQUA+"You have not selected your Lv30 Buff for the "+JobColors[color_slot]+job+" job yet!");
		    	  p.sendMessage(ChatColor.ITALIC+"Don't know what they are? Type "+ChatColor.RESET+ChatColor.YELLOW+"/jobs buffs "+job+ChatColor.RESET+ChatColor.ITALIC+"!");
		    	  p.sendMessage(ChatColor.ITALIC+"Once you decided one, type "+ChatColor.RESET+ChatColor.YELLOW+"'/jobs "+job+" 1'"+ChatColor.RESET+ChatColor.ITALIC+" or "+ChatColor.RESET+ChatColor.YELLOW+"'/jobs "+job+" 2'"+ChatColor.RESET+ChatColor.ITALIC+" to pick!");
		      }
		  	},total_tick_delay+=tick_delay);
    	}
    	if ((getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job1lv")>=40 || getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job2lv")>=40 || getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job3lv")>=40) && !getAccountsConfig().getBoolean(p.getName().toLowerCase()+".jobs.ultimatesealed")) {
	    	Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			      @Override
			      public void run() {
			    	  String job = getAccountsConfig().getString(p.getName().toLowerCase()+".jobs.job3");
			    	  int color_slot = 0;
			    	  for (int i=0;i<ValidJobs.length;i++) {
			    		  if (job.equalsIgnoreCase(ValidJobs[i])) {color_slot=i; break;}
			    	  }
			    	  p.sendMessage(ChatColor.AQUA+"You have not selected your Lv40 Ultimate Buff yet!");
			    	  p.sendMessage(ChatColor.ITALIC+"Type "+ChatColor.RESET+ChatColor.YELLOW+"/jobs ultimate <job>"+ChatColor.RESET+ChatColor.ITALIC+" replacing it with the ultimate job you want!");
			      }
			  	},total_tick_delay+=tick_delay);
    	}
    }
    
    /**
     * A helper function for Bonus Enchantments.
     * @return Returns all bonus enchantments in a list.
     */
    public static List<BonusEnchantment> getBonusEnchantments() {
    	return bonus_enchantment_list;
    }
    
    /**
     * A helper function for Bonus Enchantments.
     * @return Returns all enchantments in a list that weapons can use.
     */
    public static List<BonusEnchantment> getBonusWeaponEnchantments() {
    	List<BonusEnchantment> finallist = new ArrayList<BonusEnchantment>();
    	for (int i=0;i<bonus_enchantment_list.size();i++) {
    		if (bonus_enchantment_list.get(i).item_type==ItemType.WEAPONS ||
    				bonus_enchantment_list.get(i).item_type==ItemType.BOTH) {
    			finallist.add(bonus_enchantment_list.get(i));
    		}
    	}
    	return finallist;
    }
    
    /**
     * A helper function for Bonus Enchantments.
     * @return Returns all enchantments in a list that armor can use.
     */
    public static List<BonusEnchantment> getBonusArmorEnchantments() {
    	List<BonusEnchantment> finallist = new ArrayList<BonusEnchantment>();
    	for (int i=0;i<bonus_enchantment_list.size();i++) {
    		if (bonus_enchantment_list.get(i).item_type==ItemType.ARMOR ||
    				bonus_enchantment_list.get(i).item_type==ItemType.BOTH) {
    			finallist.add(bonus_enchantment_list.get(i));
    		}
    	}
    	return finallist;
    }
}

class BonusEnchantment {
	public enum ItemType { WEAPONS, ARMOR, BOTH }
	String name; //The string name of the Bonus Enchantment.
	boolean percent; //Whether or not this enchantment is a percentage value, or an integer value.
	boolean enchant_format; //Whether or not this enchantment is type 1 (false) or type 2 (true). Type 2 enchants are the ones that look like actual in-game enchantments.
	ItemType item_type; //The item type this enchantment can apply to.
	Range value_range;
	/**
	 * Creates a new BonusEnchantment.
	 * @param name The string name of the Bonus enchantment.
	 * @param percent Whether or not this enchantment is a percentage value (true), or an integer value (false).
	 * @param enchant_format Whether or not this enchantment is type 1 (false) or type 2 (true). Type 2 enchants are the ones that look like actual in-game enchantments.
	 * @param type The type of items this enchantment can apply to (See BonusEnchantment.ItemType)
	 * @param values_range A value range that determines what the minimum and maximum amounts of these numbers can be. (Useful for other functions that need to determine how much of this enchantment to apply.)
	 */
	public BonusEnchantment(String name, boolean percent, boolean enchant_format, ItemType type, Range values_range) {
		this.name=name;
		this.percent=percent;
		this.enchant_format=enchant_format;
		this.item_type = type;
		this.value_range = values_range;
		Main.bonus_enchantment_list.add(this);
	}
}