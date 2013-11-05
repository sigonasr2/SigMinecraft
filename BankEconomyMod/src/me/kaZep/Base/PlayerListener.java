package me.kaZep.Base;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
//import net.minecraft.server.v1_4_R1.EntityWolf;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Difficulty;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BrewingStand;
import org.bukkit.block.Chest;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.block.DoubleChest;
import org.bukkit.block.Furnace;
import org.bukkit.block.Jukebox;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creature;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Monster;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.SheepDyeWoolEvent;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.event.world.WorldEvent;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Pumpkin;
import org.bukkit.material.Wool;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Vector;
import org.bukkit.potion.Potion;

import com.google.common.base.Objects;
import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.schematic.SchematicFormat;

import me.kaZep.Base.BrewingStandData;
import me.kaZep.Base.FurnaceData;
import me.kaZep.Base.PlayerBuffData;
import me.kaZep.Base.JukeboxData;
import me.kaZep.Base.ArrowShooter;
import me.kaZep.Base.EntityHitData;
import me.kaZep.Base.EntityInteractData;
import me.kaZep.Base.ExplorerData;
import me.kaZep.Base.InvisibilityData;
import me.kaZep.Base.PersistentExplorerList;
import me.kaZep.Base.PlayerData;
import me.kaZep.Base.SupportEntity;
import me.kaZep.Base.SupportPlayer;

public class PlayerListener
  implements Listener
{
  public Main plugin;

  public PlayerListener(Main plugin)
  {
    this.plugin = plugin;
  }
  
  public void updateTopSPLEEFSigns() {
	  String name[] = {"","",""};
	  int rating[] = {-9999,-9999,-9999}, wins[] = {0,0,0}, losses[] = {0,0,0};
	  //Get list of all players on the server.
	  OfflinePlayer playerlist[] = Bukkit.getOfflinePlayers();
	  for (int i=0;i<playerlist.length;i++) {
		  if (this.plugin.getAccountsConfig().contains(playerlist[i].getName())) {
			  if (this.plugin.getAccountsConfig().contains(playerlist[i].getName()+".spleefrating") && this.plugin.getAccountsConfig().getInt(playerlist[i].getName()+".spleefwins")+this.plugin.getAccountsConfig().getInt(playerlist[i].getName()+".spleeflosses")>=20) {
				  if (this.plugin.getAccountsConfig().getDouble(playerlist[i].getName()+".spleefrating")>rating[0]) {
					  //This beats the top record, move everything down.
					  name[2]=name[1];rating[2]=rating[1];wins[2]=wins[1];losses[2]=losses[1];
					  name[1]=name[0];rating[1]=rating[0];wins[1]=wins[0];losses[1]=losses[0];
					  name[0]=playerlist[i].getName();
					  rating[0]=(int)this.plugin.getAccountsConfig().getDouble(playerlist[i].getName()+".spleefrating");
					  wins[0]=this.plugin.getAccountsConfig().getInt(playerlist[i].getName()+".spleefwins");
					  losses[0]=this.plugin.getAccountsConfig().getInt(playerlist[i].getName()+".spleeflosses");
				  } else
				  if (this.plugin.getAccountsConfig().getDouble(playerlist[i].getName()+".spleefrating")>rating[1]) {
					  //This beats the 2nd record, move everything down.
					  name[2]=name[1];rating[2]=rating[1];wins[2]=wins[1];losses[2]=losses[1];
					  name[1]=playerlist[i].getName();
					  rating[1]=(int)this.plugin.getAccountsConfig().getDouble(playerlist[i].getName()+".spleefrating");
					  wins[1]=this.plugin.getAccountsConfig().getInt(playerlist[i].getName()+".spleefwins");
					  losses[1]=this.plugin.getAccountsConfig().getInt(playerlist[i].getName()+".spleeflosses");
				  } else
				  if (this.plugin.getAccountsConfig().getDouble(playerlist[i].getName()+".spleefrating")>rating[2]) {
					  //This beats the 3rd record, move everything down.
					  name[2]=playerlist[i].getName();
					  rating[2]=(int)this.plugin.getAccountsConfig().getDouble(playerlist[i].getName()+".spleefrating");
					  wins[2]=this.plugin.getAccountsConfig().getInt(playerlist[i].getName()+".spleefwins");
					  losses[2]=this.plugin.getAccountsConfig().getInt(playerlist[i].getName()+".spleeflosses");
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
  
  @EventHandler
  public void onServerListPing(ServerListPingEvent e) {
	  e.setMaxPlayers(15);
	  if (this.plugin.getConfig().getBoolean("maintenance-mode")) {
		  e.setMotd(ChatColor.RED+"Currently in Maintenance Mode.");
	  } else {
		  e.setMotd("Sig's Minecraft - "+ChatColor.BLUE+"Currently Online.");
	  }
	  return;
  }
  
  @EventHandler
  public void onPlayerGainEXP(PlayerExpChangeEvent e) {
	  Player p = e.getPlayer();
	  if (this.plugin.PlayerinJob(p, "Enchanter") && this.plugin.getJobLv("Enchanter", p)>=5) {
		  e.setAmount(e.getAmount()*2);
	  }
	  if (this.plugin.getAccountsConfig().getBoolean("halloween-enabled")) {
		  e.setAmount(e.getAmount()*2);
	  }
	  if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify3")) {
		  p.sendMessage(ChatColor.DARK_GREEN+""+ChatColor.ITALIC+"Gained "+e.getAmount()+" exp.");
	  }
  }

  @EventHandler
  public void onBrewingStandBrew(BrewEvent e) {
	  //Look for an owner to this brewingstand.
	  String owner="";
	  int mult=0;
	  boolean allowed=true;
	  for (int i=0;i<this.plugin.brewingstandlist.size();i++) {
		  if (e.getBlock().getLocation().getX()==this.plugin.brewingstandlist.get(i).getLoc().getX() &&
				  e.getBlock().getLocation().getY()==this.plugin.brewingstandlist.get(i).getLoc().getY() &&
				  e.getBlock().getLocation().getZ()==this.plugin.brewingstandlist.get(i).getLoc().getZ()) {
			  //This is the furnace! Get owner.
			  owner = this.plugin.brewingstandlist.get(i).owner;
			  //Reset time.
			  this.plugin.brewingstandlist.get(i).set_newTime(false);
			  mult=this.plugin.brewingstandlist.get(i).getBrewingPotions();
			  if (!this.plugin.brewingstandlist.get(i).arePotionsValid()) {
				  allowed=false;
			  }
			  break;
		  }
	  }
	  if (!allowed) {
		  e.setCancelled(true);
		  return;
	  }
	  
	  if (this.plugin.PlayerinJob(owner, "Brewer")) {
		  if (e.getContents().getIngredient().getType()==Material.SUGAR) {
			  this.plugin.gainMoneyExp(owner,"Brewer",0.01*mult,2*mult);
		  }
		  if (e.getContents().getIngredient().getType()==Material.SPIDER_EYE) {
			  this.plugin.gainMoneyExp(owner,"Brewer",0.015*mult,2*mult);
		  }
		  if (e.getContents().getIngredient().getType()==Material.REDSTONE) {
			  this.plugin.gainMoneyExp(owner,"Brewer",0.025*mult,2*mult);
		  }
		  if (e.getContents().getIngredient().getType()==Material.GLOWSTONE_DUST) {
			  this.plugin.gainMoneyExp(owner,"Brewer",0.025*mult,2*mult);
		  }
		  if (e.getContents().getIngredient().getType()==Material.SULPHUR) {
			  this.plugin.gainMoneyExp(owner,"Brewer",0.03*mult,2*mult);
		  }
		  if (e.getContents().getIngredient().getType()==Material.FERMENTED_SPIDER_EYE) {
			  this.plugin.gainMoneyExp(owner,"Brewer",0.035*mult,4*mult);
		  }
		  if (e.getContents().getIngredient().getType()==Material.SPECKLED_MELON) {
			  this.plugin.gainMoneyExp(owner,"Brewer",0.035*mult,4*mult);
		  }
		  if (e.getContents().getIngredient().getType()==Material.NETHER_STALK) {
			  this.plugin.gainMoneyExp(owner,"Brewer",0.04*mult,4*mult);
		  }
		  if (e.getContents().getIngredient().getType()==Material.GOLDEN_CARROT) {
			  this.plugin.gainMoneyExp(owner,"Brewer",0.05*mult,5*mult);
		  }
		  if (e.getContents().getIngredient().getType()==Material.BLAZE_POWDER) {
			  this.plugin.gainMoneyExp(owner,"Brewer",0.05*mult,6*mult);
		  }
		  if (e.getContents().getIngredient().getType()==Material.MAGMA_CREAM) {
			  this.plugin.gainMoneyExp(owner,"Brewer",0.075*mult,8*mult);
		  }
		  if (e.getContents().getIngredient().getType()==Material.GHAST_TEAR) {
			  this.plugin.gainMoneyExp(owner,"Brewer",0.30*mult,20*mult);
		  }
		  if (this.plugin.getJobLv("Brewer", owner)>=10) {
			  ItemStack[] items = e.getContents().getContents();
			  for (int i=0;i<items.length;i++) {
				  if (items[i]!=null) {
					  if (items[i].getType()==Material.POTION) {
						  if (items[i].getAmount()<2) {
							  items[i].setAmount(2);
						  }
					  }
				  }
			  }
		  }
	  }
  }


  @EventHandler
  public void onEnchantItem(EnchantItemEvent e) {
	  Map<Enchantment,Integer> map = e.getEnchantsToAdd();
	  Player p = e.getEnchanter();
	  /*e.getEnchanter().sendMessage("Enchantments are:");
	  for (Map.Entry<Enchantment,Integer> entry : map.entrySet()) {
		  e.getEnchanter().sendMessage(entry.getKey().getName()+" "+entry.getValue());
	  }*/
	  /*
	  if (Math.random()<=0.05) {
		  //5% chance of getting a book when enchanting.
	    ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
	    BookMeta bookdata = (BookMeta)book.getItemMeta();
	    int choosebook = (int)(Math.random()*9.0d);
	    switch (choosebook) {
		    case 0:{
			    bookdata.setAuthor("Steve");
			    bookdata.setTitle("Dangers of the Nether");
			    bookdata.addPage("Dangers of the Nether\n"+ChatColor.ITALIC+"  by Steve\n======\n"+ChatColor.RESET+"It didn't take me long to realize where we were. It was dangerous, very hot, and lots of torturous screams could be heard everywhere. I barely had time","to take it all in before a huge fireball was shot in my direction. I quickly looked to my side to find a convenient safe passage and hid there for a few minutes. I guess I was in there longer than I thought, I ended","up falling asleep and waking up to notice there was something scary on the wall.\n\n"+ChatColor.ITALIC+"\"TURN AND LEAVE NOW. DANGEROUS TO STAY. REAL WORLD HAS WHAT YOU ARE LOOKING FOR. I ONLY REMEMBER THE 1ST X POSITION...",ChatColor.ITALIC+"...IT WAS 7! I AM *POSITIVE*\""+ChatColor.RESET+"\n\nI did not know what to think. The 1st X position? I quickly remembered the 7 and sprinted out of the nether portal. And to think that was *THE END* of my adventures...");
		    }break;
		    case 1:{
		    	bookdata.setAuthor("Lacey");
		    	bookdata.setTitle("A Hole in the Flower Garden");
		    	bookdata.addPage("A Hole in the Flower Garden\n"+ChatColor.ITALIC+"  by Lacey\n======\n"+ChatColor.RESET+"It was a lovely day to pick flowers in the garden, they just finished blooming fully. I was so excited to pick them, but I didn't do so until","after I've taken in all the wonderful scents! Smelling all the flowers and wonderful smells of plants and trees and nature and grass. It was perfect. I was mindlessly walking along this prairie when I stumbled.","I fell, and fell, and fell. I hit the bottom of a ravine. It didn't even occur to me I would just walk into one. I took some minor damage, but when I got up, I noticed something strange.","There were two or three zombies gathered around a wall, etching something into it. I went over to read it once the zombies walked away. I saw on the wall:\n\n"+ChatColor.ITALIC+"X-2:6 <--END","It looked cryptic to me, but why would they write that on the wall? I quickly scribbled it down on a notepad I had in my pocket and started climbing out of the ravine to tend to my lovely flowers. What a day!");
		    }break;
		    case 2:{
		    	bookdata.setAuthor("Jimmy");
		    	bookdata.setTitle("Messages in Music");
		    	bookdata.addPage("Messages in Music\n"+ChatColor.ITALIC+"  by Jim"+"\n======"+ChatColor.RESET+"\nI popped out the disk from my Jukebox to put in another, I could jam to these all day! As I was looking through my collection for something to listen to","I found a really bent up disk. 'No way this could still play', I thought to myself. I put it in, and it crackled and snarled, but it was indeed playing! At first I heard some faint resemblence of music, but then suddenly,","a hiss, an explosion, and then 'CREEEEEEEEE----- 7X XSSSSSSSSSS 3RD EEEEEEE' mental images appeared in my head, but the 7X and 3RD stood out the most. It's like I was seeing them in my head while hearing something else!","I couldn't stand up anymore, or think. I forcibly reached up with my weak hand to find the eject button on the player and when I found the familiar nub in the button, pressed down on it and out popped the disk, hitting my face,","but putting me back into reality. Something was telling me that the 3RD and 7X was important. But I couldn't quite put my tongue on it.");
		    }break;
		    case 3:{
		    	bookdata.setAuthor("Creeper");
		    	bookdata.setTitle("HISS");
		    	bookdata.addPage("Y do i exisssst. nobody knowssss. i just want a hugssssss, HUGSSSSSSS. but i don't know Y i exist. there's no Y in the first position. it'sssss jusssst two digitssssss.... SSSSSSSSS. *THE END*");
		    }break;
		    case 4:{
		    	bookdata.setAuthor("Marco");
		    	bookdata.setTitle("The Hunt for a Dragon");
		    	bookdata.addPage("The Hunt for a Dragon\n"+ChatColor.ITALIC+"  by Marco"+"\n======"+ChatColor.RESET+"\nThere exists a rumor that a mythical dragon could be found in the depths of our world. It is even said he doesn't exist in OUR world, but ANOTHER world altogether!","That my friends already boggles me, but where the heck would I go to find it then? I have been told he exists, and I know he is. I believe deep in my heart. I searched day and night under and over ground.","One day I found something strange in the ground. It was pink wool, in the middle of a cave on the ground. It even said something, but I couldn't tell from so close up. So I literally dug all the way to the surface, keeping the boundaries","of that word uncovered the whole way up. When I got to the top and looked down, I was relieved to find it was made out of markings I could discern. It said: 'Y: X3?' It was definitely a weird group of symbols, but I have a strong feeling"," that it is directly linked with that dragon I am trying to hunt down. Maybe I can gather more clues and try to decipher the location of this thing.");
		    }break;
		    case 5:{
		    	bookdata.setAuthor("Steve");
		    	bookdata.setTitle("Cooking Food");
		    	bookdata.addPage("Cooking Food\n"+ChatColor.ITALIC+"  by Steve"+"\n======"+ChatColor.RESET+"\nIt was a bright and rather typical sunny day in the Minecraft world. I don't actually think it was very hot either. I just managed to catch a few fish and was cooking them up.","It wasn't long before I got distracted and heard a funny noise. It was an ocelote. Lucky me, an ocelote has smelled the scent of my fish! I grab a few and hold it out for the ocelote. It slowly creeps over, and then takes it and runs from me.","I thought it was full and finished cooking the rest of the fish. However, the ocelote returned a few minutes later with a neatly-folded piece of paper in its mouth. It came up to me and set it down, like it was some message just for me.","I opened it up and it read:\n\n"+ChatColor.ITALIC+"Don't let the fish get to your tongue! If you know what's wise, you will investigate further. The 3rd position of Y being the number 5."+ChatColor.RESET+"\n\n","I didn't notice the ocelote run away, but I knew something FISHY was going on. That message seemed important for some reason, I've seen similar cryptic messages before... Perhaps I'll hold onto this in case I need it in the future.");
		    }break;
		    case 6:{
		    	bookdata.setAuthor("Fredric");
		    	bookdata.setTitle("Math Behind the Void");
		    	bookdata.addPage("Math Behind the Void\n"+ChatColor.ITALIC+"  by Fredric"+"\n======"+ChatColor.RESET+"\nThis book describes a few principles that the void in this world follows. While no one has actually seen the void, we have found a few theories and rules regarding them.","1. The Void has a Light Level of -14. The Void actually absorbs light coming from light sources and thus, if The Void is ever opened to the real world, would suck up the light from it.","2. The Void always has a volume of 50,000m, being 50m x 20m x 50m. This means that The Void, regardless of location is always the same exact size. This would conclude to us that The Void is co-existing and multiple instaces of it may exist in the same realm.","3. Any Entity entering The Void will not be able to escape The Void as time passes much more quickly inside The Void. This means Entities that enter The Void feel accelerated processes and cannot combat it, since the time outside is behind them.","4. A point of connection between The Void and other dimensions has to exist, for The Void to exist. Speculation has it that one of these points has been leaked into the world, and is accessible by us directly. After further research,","we have learned that one of these points is located on the 1st respective numeral along our Z axis with the number 4. It has also been proven that this number has to be negative as the other two sources interacting with The Void are positive.");
		    }break;
		    case 7:{
		    	bookdata.setAuthor("Robert");
		    	bookdata.setTitle("TNT");
		    	bookdata.addPage("TNT\n"+ChatColor.ITALIC+"  by Robert"+"\n======"+ChatColor.RESET+"\nYou know, the easiest way to clear a tunnel is using an item called TNT. It is a rather small block, but it is loaded with gunpowder. When lit by an external force, it ignites","with the force of 5 Creeper explosions to clear whole caves out. Well lo and behold one day I discovered a rather strange abandoned mineshaft. It wasn't normal for sure, because there were green vines everywhere and lots of strange doors.","It was like somebody lived here ages ago, and I am discovering the ruins of such a place. Inoperable levers, a few mobs I have to kill here and there that have made this area their designated home. It was a mess. But I did discover that","someone was trying to find what we would call 'The End'. It's a magical place, and I believe with the right amount of effort, we can find it someday too. He had scribbled the coordinates of the location he was trying to reach.","However, most of it is faded out and I can only tell faintly the remains of it: \n\n"+ChatColor.ITALIC+"X:---\nY:---\nZ:--7-"+ChatColor.RESET+"\n\nYep, that's about it.","Hopefully by me recording this data, someone else can fill in the remaining numbers and we can all find The End together. Someday...");
		    }break;
		    case 8:{
		    	bookdata.setAuthor("Joshua");
		    	bookdata.setTitle("Fourside");
		    	bookdata.addPage("Fourside\n"+ChatColor.ITALIC+"  by Joshua"+"\n======"+ChatColor.RESET+"\n"+ChatColor.DARK_BLUE+"ABANDONED PROJECT"+ChatColor.RESET+". A city that would be developed with the best technology and the highest standards. It would","succeed every single Minecraft city that has ever been built. Casinos, diamond-lined walkways, towering skyscrapers as far as the eye can see. Museums, Libraries, Educational Institutions. This mega-city would be able to hold","and sustain every single Minecrafter in existence. But no, something went terribly wrong. Our engineering team finally developed the perfect transportation system and we were wiring it up to our fusion power plant.","Something went horribly wrong. The Fusion power plant started self-combusting itself, leaving behind hyper-cold atoms. This caused nucleic waste to interact with the environment around itself and freezing the whole world as we knew it.","The city idea as we knew it was scrapped, and we would wait 2000 years before we could attempt this again. We wrote plans for a much more portable solution and have named it 'Twoside' and archived it appropriately.","Maybe someone will pick up that book and be able to make the future bright with a mini version of Fourside. That being said, we left the 3rd slot of the Z position of our city at 7. This should give you enough clue as to where NOT to build.");
		    }break;
	    }
	    book.setItemMeta(bookdata);
	    //p.setItemInHand(book);
	    p.getInventory().addItem(book);
	    p.updateInventory();
	    p.sendMessage(ChatColor.LIGHT_PURPLE+"You feel a magical presence get inserted into your inventory.");
	  }*/
	  
	  
	  if (this.plugin.PlayerinJob(p, "Enchanter")) {
		  if (this.plugin.getJobLv("Enchanter", p)>=10) {
			  e.setExpLevelCost((int)(e.getExpLevelCost()*0.75));
			  if (e.getItem().getType()==Material.BOW) {
				  int enchants[] = {48,49,50,51};
				  for (int j=0;j<enchants.length;j++) {
					  if (Math.random()<1.0d/enchants.length) {
						  //e.getItem().addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
					  }
				  }
				  List<String> ourLore = new ArrayList<String>();
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Critical Chance");
				  } else
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*3)+1)+" "+ChatColor.BLUE+"Armor Penetration");
				  } else
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Life Steal");
				  } else
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*30)+1)+"% "+ChatColor.BLUE+"Attack Speed");
				  } else
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*5)+1)+" "+ChatColor.BLUE+"Damage");
				  }
				  ItemMeta meta = e.getItem().getItemMeta();
				  meta.setLore(ourLore);
				  e.getItem().setItemMeta(meta);
			  } else {
				  if (e.getItem().getType().toString().toLowerCase().contains("sword")) {
					  int enchants[] = {16,17,18,19,20,21,34};
					  for (int j=0;j<enchants.length;j++) {
						  if (Math.random()<1.0d/enchants.length) {
							  //e.getItem().addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
						  }
					  }
					  List<String> ourLore = new ArrayList<String>();
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Critical Chance");
					  } else
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*3)+1)+" "+ChatColor.BLUE+"Armor Penetration");
					  } else
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Life Steal");
					  } else
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*30)+1)+"% "+ChatColor.BLUE+"Attack Speed");
					  } else
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*5)+1)+" "+ChatColor.BLUE+"Damage");
					  }
					  ItemMeta meta = e.getItem().getItemMeta();
					  meta.setLore(ourLore);
					  e.getItem().setItemMeta(meta);
				  } else if (e.getItem().getType().toString().toLowerCase().contains("spade") ||
						  e.getItem().getType().toString().toLowerCase().contains("axe") ||
						  e.getItem().getType().toString().toLowerCase().contains("hoe") ||
						  e.getItem().getType().toString().toLowerCase().contains("pickaxe")) {
					  int enchants[] = {32,33,34,35};
					  for (int j=0;j<enchants.length;j++) {
						  if (Math.random()<1.0d/enchants.length) {
							  //e.getItem().addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
						  }
					  }
					  List<String> ourLore = new ArrayList<String>();
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Critical Chance");
					  } else
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*3)+1)+" "+ChatColor.BLUE+"Armor Penetration");
					  } else
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Life Steal");
					  } else
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*30)+1)+"% "+ChatColor.BLUE+"Attack Speed");
					  } else
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*5)+1)+" "+ChatColor.BLUE+"Damage");
					  }
					  ItemMeta meta = e.getItem().getItemMeta();
					  meta.setLore(ourLore);
					  e.getItem().setItemMeta(meta);
				  } else {
					  int enchants[] = {0,1,2,3,4,5,6,7,34};
					  for (int j=0;j<enchants.length;j++) {
						  if (Math.random()<1.0d/enchants.length) {
							  //e.getItem().addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
						  }
					  }
					  List<String> ourLore = new ArrayList<String>();
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*4)+1)+" "+ChatColor.BLUE+"Health");
					  } else
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Damage Reduction");
					  } else
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+(((int)(Math.random()*50)+1)*10)+"% "+ChatColor.BLUE+"Durability");
					  } else
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Block Chance");
					  } else
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Speed Boost Chance");
					  }
					  ItemMeta meta = e.getItem().getItemMeta();
					  meta.setLore(ourLore);
					  e.getItem().setItemMeta(meta);
				  }
			  }
		  }
		  for (Map.Entry<Enchantment,Integer> entry : map.entrySet()) {
			  if (this.plugin.getJobLv("Enchanter", p)>=20) {
				  if (entry.getKey().getMaxLevel()<entry.getValue()) {
					  entry.setValue(entry.getValue()+((int)(Math.random()*2)+1));
				  }
			  }
			  if (e.getItem().getType()==Material.BOW) {
				  int enchants[] = {48,49,50,51};
				  for (int j=0;j<enchants.length;j++) {
					  if (Math.random()<1.0d/enchants.length) {
						  e.getItem().addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*5)+1);
					  }
				  }
				  List<String> ourLore = new ArrayList<String>();
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*20)+1)+"% "+ChatColor.BLUE+"Critical Chance");
				  }
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*6)+1)+" "+ChatColor.BLUE+"Armor Penetration");
				  }
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*20)+1)+"% "+ChatColor.BLUE+"Life Steal");
				  }
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*60)+1)+"% "+ChatColor.BLUE+"Attack Speed");
				  }
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+" "+ChatColor.BLUE+"Damage");
				  }
				  ItemMeta meta = e.getItem().getItemMeta();
				  meta.setLore(ourLore);
				  e.getItem().setItemMeta(meta);
			  } else {
				  if (e.getItem().getType().toString().toLowerCase().contains("sword")) {
					  int enchants[] = {16,17,18,19,20,21,34};
					  for (int j=0;j<enchants.length;j++) {
						  if (Math.random()<1.0d/enchants.length) {
							  e.getItem().addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*5)+1);
						  }
					  }
					  List<String> ourLore = new ArrayList<String>();
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*20)+1)+"% "+ChatColor.BLUE+"Critical Chance");
					  }
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*6)+1)+" "+ChatColor.BLUE+"Armor Penetration");
					  }
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*20)+1)+"% "+ChatColor.BLUE+"Life Steal");
					  }
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*60)+1)+"% "+ChatColor.BLUE+"Attack Speed");
					  }
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+" "+ChatColor.BLUE+"Damage");
					  }
					  ItemMeta meta = e.getItem().getItemMeta();
					  meta.setLore(ourLore);
					  e.getItem().setItemMeta(meta);
				  } else if (e.getItem().getType().toString().toLowerCase().contains("spade") ||
						  e.getItem().getType().toString().toLowerCase().contains("axe") ||
						  e.getItem().getType().toString().toLowerCase().contains("hoe") ||
						  e.getItem().getType().toString().toLowerCase().contains("pickaxe")) {
					  int enchants[] = {32,33,34,35};
					  for (int j=0;j<enchants.length;j++) {
						  if (Math.random()<1.0d/enchants.length) {
							  e.getItem().addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*5)+1);
						  }
					  }
					  List<String> ourLore = new ArrayList<String>();
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*20)+1)+"% "+ChatColor.BLUE+"Critical Chance");
					  }
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*6)+1)+" "+ChatColor.BLUE+"Armor Penetration");
					  }
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*20)+1)+"% "+ChatColor.BLUE+"Life Steal");
					  }
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*60)+1)+"% "+ChatColor.BLUE+"Attack Speed");
					  }
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+" "+ChatColor.BLUE+"Damage");
					  }
					  ItemMeta meta = e.getItem().getItemMeta();
					  meta.setLore(ourLore);
					  e.getItem().setItemMeta(meta);
				  } else {
					  int enchants[] = {0,1,2,3,4,5,6,7,34};
					  for (int j=0;j<enchants.length;j++) {
						  if (Math.random()<1.0d/enchants.length) {
							  e.getItem().addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*5)+1);
						  }
					  }
					  List<String> ourLore = new ArrayList<String>();
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*6)+1)+" "+ChatColor.BLUE+"Health");
					  }
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*20)+1)+"% "+ChatColor.BLUE+"Damage Reduction");
					  }
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+(((int)(Math.random()*100)+1)*10)+"% "+ChatColor.BLUE+"Durability");
					  }
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*20)+1)+"% "+ChatColor.BLUE+"Block Chance");
					  }
					  if (Math.random()<=0.2) {
						  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*20)+1)+"% "+ChatColor.BLUE+"Speed Boost Chance");
					  }
					  ItemMeta meta = e.getItem().getItemMeta();
					  meta.setLore(ourLore);
					  e.getItem().setItemMeta(meta);
				  }
			  }
			  if (entry.getKey().getName()==Enchantment.PROTECTION_ENVIRONMENTAL.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.08*entry.getValue(),4*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.DAMAGE_UNDEAD.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.10*entry.getValue(),8*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.PROTECTION_FIRE.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.10*entry.getValue(),6*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.DAMAGE_ARTHROPODS.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.12*entry.getValue(),8*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.PROTECTION_FALL.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.14*entry.getValue(),10*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.DAMAGE_ALL.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.15*entry.getValue(),14*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.DIG_SPEED.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.15*entry.getValue(),14*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.PROTECTION_EXPLOSIONS.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.20*entry.getValue(),16*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.THORNS.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.20*entry.getValue(),16*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.KNOCKBACK.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.20*entry.getValue(),18*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.ARROW_KNOCKBACK.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.20*entry.getValue(),18*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.FIRE_ASPECT.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.22*entry.getValue(),20*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.ARROW_FIRE.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.22*entry.getValue(),20*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.WATER_WORKER.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.25*entry.getValue(),16*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.OXYGEN.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.30*entry.getValue(),20*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.DURABILITY.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.35*entry.getValue(),24*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.ARROW_INFINITE.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.40*entry.getValue(),40*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.LOOT_BONUS_MOBS.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.40*entry.getValue(),30*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.LOOT_BONUS_BLOCKS.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.50*entry.getValue(),40*entry.getValue());
			  }
			  if (entry.getKey().getName()==Enchantment.SILK_TOUCH.getName()) {
				  this.plugin.gainMoneyExp(p,"Enchanter",0.50*entry.getValue(),40*entry.getValue());
			  }
		  }
	  }
  }
  
  @EventHandler
  public void onFurnaceItemConsume(FurnaceBurnEvent e) {
	  String owner="";
	  for (int i=0;i<this.plugin.furnacelist.size();i++) {
		  if (e.getBlock().getLocation().getX()==this.plugin.furnacelist.get(i).getLoc().getX() &&
				  e.getBlock().getLocation().getY()==this.plugin.furnacelist.get(i).getLoc().getY() &&
				  e.getBlock().getLocation().getZ()==this.plugin.furnacelist.get(i).getLoc().getZ()) {
			  //This is the furnace! Get owner.
			  owner = this.plugin.furnacelist.get(i).owner;
			  break;
		  }
	  }
	  if (this.plugin.PlayerinJob(owner, "Cook") && this.plugin.getJobLv("Cook", owner)>=5) {
		  //Bukkit.getPlayer("sigonasr2").sendMessage("Old time: "+e.getBurnTime());
		  e.setBurnTime(e.getBurnTime()*2);
		  //Bukkit.getPlayer("sigonasr2").sendMessage("Doubled the furnace's burn time. New time: "+e.getBurnTime());
	  }
  }
  
  @EventHandler
  public void onFurnaceSmelt(FurnaceSmeltEvent e) {
	  //Bukkit.getPlayer("sigonasr2").sendMessage("Current time: "+((Furnace)e.getBlock().getState()).getBurnTime());
	  //Look for an owner to this furnace.
	  String owner="";
	  for (int i=0;i<this.plugin.furnacelist.size();i++) {
		  if (e.getBlock().getLocation().getX()==this.plugin.furnacelist.get(i).getLoc().getX() &&
				  e.getBlock().getLocation().getY()==this.plugin.furnacelist.get(i).getLoc().getY() &&
				  e.getBlock().getLocation().getZ()==this.plugin.furnacelist.get(i).getLoc().getZ()) {
			  //This is the furnace! Get owner.
			  owner = this.plugin.furnacelist.get(i).owner;
			  break;
		  }
	  }
	  if (this.plugin.PlayerinJob(owner, "Digger")) {
		  if (e.getResult().getType()==Material.GLASS) {
			  this.plugin.gainMoneyExp(owner,"Digger",0.015,3);
		  }
		  if (e.getResult().getType()==Material.BRICK) {
			  this.plugin.gainMoneyExp(owner,"Digger",0.04,8);
		  }
		  if (e.getResult().getType()==Material.HARD_CLAY) {
			  this.plugin.gainMoneyExp(owner,"Digger",0.04,8);
		  }
	  }
	  if (this.plugin.PlayerinJob(owner, "Fisherman")) {
		  if (e.getResult().getType()==Material.COOKED_FISH) {
			  this.plugin.gainMoneyExp(owner,"Fisherman",0.125,2);
		  }
	  }
	  if (this.plugin.PlayerinJob(owner, "Cook")) {
		  boolean crafteditem=false;
		  if (e.getResult().getType()==Material.COOKED_FISH) {
			  this.plugin.gainMoneyExp(owner,"Cook",0.06,24);
			  crafteditem=true;
		  }
		  if (e.getResult().getType()==Material.getMaterial(393)) {
			  this.plugin.gainMoneyExp(owner,"Cook",0.08,32);
			  crafteditem=true;
		  }
		  if (e.getResult().getType()==Material.COOKED_CHICKEN) {
			  this.plugin.gainMoneyExp(owner,"Cook",0.09,36);
			  crafteditem=true;
		  }
		  if (e.getResult().getType()==Material.GRILLED_PORK) {
			  this.plugin.gainMoneyExp(owner,"Cook",0.12,48);
			  crafteditem=true;
		  }
		  if (e.getResult().getType()==Material.COOKED_BEEF) {
			  this.plugin.gainMoneyExp(owner,"Cook",0.20,80);
			  crafteditem=true;
		  }
		  if (this.plugin.getJobLv("Cook", owner)>=20 && crafteditem) {
			  ItemStack result = e.getResult();
			  result.setAmount(result.getAmount()+1);
			  e.setResult(result);
		  }
	  }
  }
  
  @EventHandler
  public void onCreatureInteract(PlayerInteractEntityEvent e) {
	  Player p = e.getPlayer();
	  //When right-clicked on, check if it already exists in the entity list.
	  boolean contains=false;
	  int slot=0;
	  for (int i=0;i<this.plugin.animallist.size();i++) {
		  if (this.plugin.animallist.get(i).getID()==e.getRightClicked().getUniqueId()) {
			  contains=true;
			  slot=i;
			  break;
		  }
	  }
	  if (!contains) {
		  //We add it to the list.
		  this.plugin.animallist.add(new EntityInteractData(e.getRightClicked().getUniqueId(), p.getName()));
	  } else {
		  //Modify the owner.
		  this.plugin.animallist.get(slot).setOwner(p.getName());
	  }
		  if (p.getItemInHand().getType()==Material.WHEAT) {
			  if (e.getRightClicked().getType()==EntityType.COW) {
				  if (this.plugin.PlayerinJob(p, "Breeder") && this.plugin.getJobLv("Breeder", p)>=20) {
				  Cow a = (Cow)e.getRightClicked();
				  if (a.canBreed()) {
					  if (Math.random()<=0.50) {
						  p.getItemInHand().setAmount(p.getItemInHand().getAmount());
					  }
				  }
			  }
				  //See if it exists already.
				  boolean contains_uuid=false;
				  String finalstring = "";
				  if (this.plugin.getConfig().getString("fed.mobs").length()>4) {
					  String[] mobslist = this.plugin.getConfig().getString("fed.mobs").split(",");
					  //p.sendMessage("Mobs list length: "+mobslist.length);
					  for (int i=0;i<mobslist.length;i+=2) {
						  //First entry in the lists. Contains UUIDs.
							  UUID temp = UUID.fromString(mobslist[i]);
							  if (temp.equals(e.getRightClicked().getUniqueId())) {
								  //The next key contains the data then. Modify it.
								  contains_uuid=true;
								  mobslist[i+1]=String.valueOf(Bukkit.getWorld("world").getFullTime()+5184000);
							  }
						  //Reconstruct the data
						  if (finalstring.equalsIgnoreCase("")) {
							  finalstring+=mobslist[i]+","+mobslist[i+1];
						  } else {
							  finalstring+=","+mobslist[i]+","+mobslist[i+1];
						  }
					  }
				  }
				  if (contains_uuid) {
					  //p.sendMessage("Contained this UUID. Just resave it.");
					  //And finally save it.
					  this.plugin.getConfig().set("fed.mobs", String.valueOf(finalstring));
					  this.plugin.saveConfig();
				  } else {
					  //Set this entity to 'fed' status. You get 3 days to feed it after that.
					  if (this.plugin.getConfig().getString("fed.mobs").length()<4) {
						  this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+e.getRightClicked().getUniqueId()+","+(Bukkit.getWorld("world").getFullTime()+5184000)));
					  } else {
						  this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+","+e.getRightClicked().getUniqueId()+","+(Bukkit.getWorld("world").getFullTime()+5184000)));
					  }
					  this.plugin.saveConfig();
				  }
		  }
		  }
		  if (p.getItemInHand().getType()==Material.WHEAT) {
			  if (e.getRightClicked().getType()==EntityType.SHEEP) {
				  if (this.plugin.PlayerinJob(p, "Breeder") && this.plugin.getJobLv("Breeder", p)>=20) {
				  Sheep a = (Sheep)e.getRightClicked();
				  if (a.canBreed()) {
					  if (Math.random()<=0.50) {
						  p.getItemInHand().setAmount(p.getItemInHand().getAmount());
					  }
				  }
				  }
				  //See if it exists already.
				  boolean contains_uuid=false;
				  String finalstring = "";
				  if (this.plugin.getConfig().getString("fed.mobs").length()>4) {
					  String[] mobslist = this.plugin.getConfig().getString("fed.mobs").split(",");
					  //p.sendMessage("Mobs list length: "+mobslist.length);
					  for (int i=0;i<mobslist.length;i+=2) {
						  //First entry in the lists. Contains UUIDs.
							  UUID temp = UUID.fromString(mobslist[i]);
							  if (temp.equals(e.getRightClicked().getUniqueId())) {
								  //The next key contains the data then. Modify it.
								  contains_uuid=true;
								  mobslist[i+1]=String.valueOf(Bukkit.getWorld("world").getFullTime()+5184000);
							  }
						  //Reconstruct the data
						  if (finalstring.equalsIgnoreCase("")) {
							  finalstring+=mobslist[i]+","+mobslist[i+1];
						  } else {
							  finalstring+=","+mobslist[i]+","+mobslist[i+1];
						  }
					  }
				  }
				  if (contains_uuid) {
					  //p.sendMessage("Contained this UUID. Just resave it.");
					  //And finally save it.
					  this.plugin.getConfig().set("fed.mobs", String.valueOf(finalstring));
					  this.plugin.saveConfig();
				  } else {
					  //Set this entity to 'fed' status. You get 3 days to feed it after that.
					  if (this.plugin.getConfig().getString("fed.mobs").length()<4) {
						  this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+e.getRightClicked().getUniqueId()+","+(Bukkit.getWorld("world").getFullTime()+5184000)));
					  } else {
						  this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+","+e.getRightClicked().getUniqueId()+","+(Bukkit.getWorld("world").getFullTime()+5184000)));
					  }
					  this.plugin.saveConfig();
				  }
		  }
		  }
		  if (p.getItemInHand().getType()==Material.CARROT_ITEM) {
			  if (e.getRightClicked().getType()==EntityType.PIG) {
				  if (this.plugin.PlayerinJob(p, "Breeder") && this.plugin.getJobLv("Breeder", p)>=20) {
				  Pig a = (Pig)e.getRightClicked();
				  if (a.canBreed()) {
					  if (Math.random()<=0.50) {
						  p.getItemInHand().setAmount(p.getItemInHand().getAmount());
					  }
				  }
				  }
				  //See if it exists already.
				  boolean contains_uuid=false;
				  String finalstring = "";
				  if (this.plugin.getConfig().getString("fed.mobs").length()>4) {
					  String[] mobslist = this.plugin.getConfig().getString("fed.mobs").split(",");
					  //p.sendMessage("Mobs list length: "+mobslist.length);
					  for (int i=0;i<mobslist.length;i+=2) {
						  //First entry in the lists. Contains UUIDs.
							  UUID temp = UUID.fromString(mobslist[i]);
							  if (temp.equals(e.getRightClicked().getUniqueId())) {
								  //The next key contains the data then. Modify it.
								  contains_uuid=true;
								  mobslist[i+1]=String.valueOf(Bukkit.getWorld("world").getFullTime()+5184000);
							  }
						  //Reconstruct the data
						  if (finalstring.equalsIgnoreCase("")) {
							  finalstring+=mobslist[i]+","+mobslist[i+1];
						  } else {
							  finalstring+=","+mobslist[i]+","+mobslist[i+1];
						  }
					  }
				  }
				  if (contains_uuid) {
					  //p.sendMessage("Contained this UUID. Just resave it.");
					  //And finally save it.
					  this.plugin.getConfig().set("fed.mobs", String.valueOf(finalstring));
					  this.plugin.saveConfig();
				  } else {
					  //Set this entity to 'fed' status. You get 3 days to feed it after that.
					  if (this.plugin.getConfig().getString("fed.mobs").length()<4) {
						  this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+e.getRightClicked().getUniqueId()+","+(Bukkit.getWorld("world").getFullTime()+5184000)));
					  } else {
						  this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+","+e.getRightClicked().getUniqueId()+","+(Bukkit.getWorld("world").getFullTime()+5184000)));
					  }
					  this.plugin.saveConfig();
				  }
		  }
		  }
		  if (p.getItemInHand().getType()==Material.SEEDS) {
			  if (e.getRightClicked().getType()==EntityType.CHICKEN) {
				  if (this.plugin.PlayerinJob(p, "Breeder") && this.plugin.getJobLv("Breeder", p)>=20) {
				  Chicken a = (Chicken)e.getRightClicked();
				  if (a.canBreed()) {
					  if (Math.random()<=0.50) {
						  p.getItemInHand().setAmount(p.getItemInHand().getAmount());
					  }
				  }
				  }
				  //See if it exists already.
				  boolean contains_uuid=false;
				  String finalstring = "";
				  if (this.plugin.getConfig().getString("fed.mobs").length()>4) {
					  String[] mobslist = this.plugin.getConfig().getString("fed.mobs").split(",");
					  //p.sendMessage("Mobs list length: "+mobslist.length);
					  for (int i=0;i<mobslist.length;i+=2) {
						  //First entry in the lists. Contains UUIDs.
							  UUID temp = UUID.fromString(mobslist[i]);
							  if (temp.equals(e.getRightClicked().getUniqueId())) {
								  //The next key contains the data then. Modify it.
								  contains_uuid=true;
								  mobslist[i+1]=String.valueOf(Bukkit.getWorld("world").getFullTime()+5184000);
							  }
						  //Reconstruct the data
						  if (finalstring.equalsIgnoreCase("")) {
							  finalstring+=mobslist[i]+","+mobslist[i+1];
						  } else {
							  finalstring+=","+mobslist[i]+","+mobslist[i+1];
						  }
					  }
				  }
				  if (contains_uuid) {
					  //p.sendMessage("Contained this UUID. Just resave it.");
					  //And finally save it.
					  this.plugin.getConfig().set("fed.mobs", String.valueOf(finalstring));
					  this.plugin.saveConfig();
				  } else {
					  //Set this entity to 'fed' status. You get 3 days to feed it after that.
					  if (this.plugin.getConfig().getString("fed.mobs").length()<4) {
						  this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+e.getRightClicked().getUniqueId()+","+(Bukkit.getWorld("world").getFullTime()+5184000)));
					  } else {
						  this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+","+e.getRightClicked().getUniqueId()+","+(Bukkit.getWorld("world").getFullTime()+5184000)));
					  }
					  this.plugin.saveConfig();
				  }
		  }
		  }
		  if (p.getItemInHand().getType()==Material.ROTTEN_FLESH || p.getItemInHand().getType()==Material.RAW_BEEF || p.getItemInHand().getType()==Material.PORK || p.getItemInHand().getType()==Material.RAW_CHICKEN) {
			  if (e.getRightClicked().getType()==EntityType.WOLF) {
				  if (this.plugin.PlayerinJob(p, "Breeder") && this.plugin.getJobLv("Breeder", p)>=20) {
				  Wolf a = (Wolf)e.getRightClicked();
				  if (a.canBreed()) {
					  if (Math.random()<=0.50) {
						  p.getItemInHand().setAmount(p.getItemInHand().getAmount());
					  }
				  }
				  }
				  //See if it exists already.
				  boolean contains_uuid=false;
				  String finalstring = "";
				  if (this.plugin.getConfig().getString("fed.mobs").length()>4) {
					  String[] mobslist = this.plugin.getConfig().getString("fed.mobs").split(",");
					  //p.sendMessage("Mobs list length: "+mobslist.length);
					  for (int i=0;i<mobslist.length;i+=2) {
						  //First entry in the lists. Contains UUIDs.
							  UUID temp = UUID.fromString(mobslist[i]);
							  if (temp.equals(e.getRightClicked().getUniqueId())) {
								  //The next key contains the data then. Modify it.
								  contains_uuid=true;
								  mobslist[i+1]=String.valueOf(Bukkit.getWorld("world").getFullTime()+5184000);
							  }
						  //Reconstruct the data
						  if (finalstring.equalsIgnoreCase("")) {
							  finalstring+=mobslist[i]+","+mobslist[i+1];
						  } else {
							  finalstring+=","+mobslist[i]+","+mobslist[i+1];
						  }
					  }
				  }
				  if (contains_uuid) {
					  //p.sendMessage("Contained this UUID. Just resave it.");
					  //And finally save it.
					  this.plugin.getConfig().set("fed.mobs", String.valueOf(finalstring));
					  this.plugin.saveConfig();
				  } else {
					  //Set this entity to 'fed' status. You get 3 days to feed it after that.
					  if (this.plugin.getConfig().getString("fed.mobs").length()<4) {
						  this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+e.getRightClicked().getUniqueId()+","+(Bukkit.getWorld("world").getFullTime()+5184000)));
					  } else {
						  this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+","+e.getRightClicked().getUniqueId()+","+(Bukkit.getWorld("world").getFullTime()+5184000)));
					  }
					  this.plugin.saveConfig();
				  }
		  }
		  }
		  if (p.getItemInHand().getType()==Material.RAW_FISH) {
			  if (e.getRightClicked().getType()==EntityType.OCELOT) {
				  if (this.plugin.PlayerinJob(p, "Breeder") && this.plugin.getJobLv("Breeder", p)>=20) {
				  Ocelot a = (Ocelot)e.getRightClicked();
				  if (a.canBreed()) {
					  if (Math.random()<=0.50) {
						  p.getItemInHand().setAmount(p.getItemInHand().getAmount());
					  }
				  }
				  }
				  //See if it exists already.
				  boolean contains_uuid=false;
				  String finalstring = "";
				  if (this.plugin.getConfig().getString("fed.mobs").length()>4) {
					  String[] mobslist = this.plugin.getConfig().getString("fed.mobs").split(",");
					  ////p.sendMessage("Mobs list length: "+mobslist.length);
					  for (int i=0;i<mobslist.length;i+=2) {
						  //First entry in the lists. Contains UUIDs.
							  UUID temp = UUID.fromString(mobslist[i]);
							  if (temp.equals(e.getRightClicked().getUniqueId())) {
								  //The next key contains the data then. Modify it.
								  contains_uuid=true;
								  mobslist[i+1]=String.valueOf(Bukkit.getWorld("world").getFullTime()+5184000);
							  }
						  //Reconstruct the data
						  if (finalstring.equalsIgnoreCase("")) {
							  finalstring+=mobslist[i]+","+mobslist[i+1];
						  } else {
							  finalstring+=","+mobslist[i]+","+mobslist[i+1];
						  }
					  }
				  }
				  if (contains_uuid) {
					  ////p.sendMessage("Contained this UUID. Just resave it.");
					  //And finally save it.
					  this.plugin.getConfig().set("fed.mobs", String.valueOf(finalstring));
					  this.plugin.saveConfig();
				  } else {
					  //Set this entity to 'fed' status. You get 3 days to feed it after that.
					  if (this.plugin.getConfig().getString("fed.mobs").length()<4) {
						  this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+e.getRightClicked().getUniqueId()+","+(Bukkit.getWorld("world").getFullTime()+5184000)));
					  } else {
						  this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+","+e.getRightClicked().getUniqueId()+","+(Bukkit.getWorld("world").getFullTime()+5184000)));
					  }
					  this.plugin.saveConfig();
				  }
		  }
		  }
		  if (p.getItemInHand().getType()==Material.GOLDEN_APPLE || p.getItemInHand().getType()==Material.GOLDEN_CARROT) {
			  if (e.getRightClicked().getType()==EntityType.HORSE) {
				  if (this.plugin.PlayerinJob(p, "Breeder") && this.plugin.getJobLv("Breeder", p)>=20) {
				  Horse a = (Horse)e.getRightClicked();
				  if (a.canBreed()) {
					  if (Math.random()<=0.50) {
						  p.getItemInHand().setAmount(p.getItemInHand().getAmount());
					  }
				  }
				  }
				  //This is a special entity and won't be added to the list of animals to despawn for now.
		  }
		  }
	  }

  @EventHandler
  public void onShearEntity(PlayerShearEntityEvent e) {
	  Player p = e.getPlayer();
	  if (this.plugin.PlayerinJob(p, "Breeder")) {
		  if (e.getEntity().getType()==EntityType.SHEEP) {
			  this.plugin.gainMoneyExp(p,"Breeder",0.002,0.2);
		  }
		  if (e.getEntity().getType()==EntityType.MUSHROOM_COW) {
			  this.plugin.gainMoneyExp(p,"Breeder",0.005,1);
		  }
	  }
  }
  
  @EventHandler
  public void onSheepDye(SheepDyeWoolEvent e) {
	  int slot=-1;
	  Player p=null;
	  for (int i=0;i<this.plugin.animallist.size();i++) {
		  if (this.plugin.animallist.get(i).getID()==e.getEntity().getUniqueId()) {
			  slot=i;
			  p=Bukkit.getPlayer(this.plugin.animallist.get(i).getOwner());
			  break;
		  }
	  }
	  if (slot!=-1) {
		  Location testloc = new Location(p.getWorld(),1551,69,-275);
		  if (this.plugin.getConfig().getBoolean("halloween-enabled") && p.getLocation().distanceSquared(testloc)<900) {
			  e.setCancelled(true);
			  return;
		  }
		  if (this.plugin.PlayerinJob(p, "Breeder")) {
			  this.plugin.gainMoneyExp(p,"Breeder",0.02,2);
		  }
	  }
  }

  
  @EventHandler
  public void onPlayerWakeup(PlayerBedLeaveEvent e) {
	Player p = e.getPlayer();
	//p.sendMessage("Wakeup at "+Bukkit.getWorld("world").getTime());
	if (Bukkit.getWorld("world").getTime()==0) {
		this.plugin.last_world_time=0;
	}
	return;
  }
  
  @EventHandler
  public void onPlayerSneak(PlayerToggleSneakEvent e) {
	  if (e.isSneaking()) {
		  if (this.plugin.PlayerinJob(e.getPlayer(),"Hunter") && this.plugin.getJobLv("Hunter", e.getPlayer())>=10) {
			  e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 9999999, 0, true));
		  }
	  } else {
		  if (this.plugin.PlayerinJob(e.getPlayer(),"Hunter") && this.plugin.getJobLv("Hunter", e.getPlayer())>=10) {
			  if (e.getPlayer().hasPotionEffect(PotionEffectType.INVISIBILITY)) {
				  try {
					  Collection<PotionEffect> effects = e.getPlayer().getActivePotionEffects();
					  for (PotionEffect nextpotioneffect : effects) {
						  if (nextpotioneffect.getType().getName().compareTo("INVISIBILITY")==0 && nextpotioneffect.getDuration()>24000) {
							  //This is definitely not a potion given to you.
							  e.getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);
							  break;
						  }
					  }
				  } catch (ConcurrentModificationException ex_e) {
					  Bukkit.getLogger().warning("Potion Effect Collection not accessible for a hunter while toggling sneak mode.");
				  }
			  }
		  }
	  }
  }
  
  public String healthbar(double curHP,double maxHP) {
	  //█ ▌
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
		  bar+="█";
	  }
	  if (bits%2!=0) {
		  bar+="▌";
	  }
	  return bar;
  }
  
  public String healthbar(double curHP,double maxHP,int hunger) {
	  //█ ▌
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
		  bar+="█";
	  }
	  if (bits%2!=0) {
		  bar+="▌";
	  }
	  return bar;
  }
  
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent e) {
    Player p = e.getPlayer();
    Team tempteam;
    if (this.plugin.getConfig().getBoolean("halloween-enabled")) {
    	Bukkit.getWorld("world").setDifficulty(Difficulty.EASY);
    } else {
    	Bukkit.getWorld("world").setDifficulty(Difficulty.HARD);
    }
    if (p.getScoreboard().getTeam(p.getName())!=null) {
    	tempteam=p.getScoreboard().getTeam(p.getName());
    	tempteam.unregister();
    }
	tempteam=p.getScoreboard().registerNewTeam(p.getName());
	if (p.hasPermission("group.moderator")) {
		tempteam.setPrefix(ChatColor.GREEN+"");
	}
	if (p.hasPermission("group.administrators")) {
		tempteam.setPrefix(ChatColor.LIGHT_PURPLE+"");
	}
    tempteam.setSuffix(healthbar(p.getHealth(),p.getMaxHealth()));
    tempteam.addPlayer(p.getPlayer());
    if (this.plugin.getConfig().getBoolean("maintenance-mode") && !p.hasPermission("maintenance-mode")) {
    	p.kickPlayer("Sorry, the server is currently under "+ChatColor.GREEN+" Maintenance Mode.");
    	return;
    }
    //Look through inventory.
    for (int i=0;i<p.getInventory().getArmorContents().length;i++) {
    	if (p.getInventory().getArmorContents()[i].getItemMeta()!=null && p.getInventory().getArmorContents()[i].getItemMeta().getLore()!=null) {
    		//Look through the lore.
    		ItemMeta meta = p.getInventory().getArmorContents()[i].getItemMeta();
    		List<String> newlore = p.getInventory().getArmorContents()[i].getItemMeta().getLore();
    		for (int j=0;j<p.getInventory().getArmorContents()[i].getItemMeta().getLore().size();j++) {
    			if (p.getInventory().getArmorContents()[i].getItemMeta().getLore().get(j).contains("Lightning")) {
    				newlore.get(j).replace("Lightning", "Mob Freeze");
    			}
    		}
    		meta.setLore(newlore);
    		p.getInventory().getArmorContents()[i].setItemMeta(meta);
    	}
    }
    /*if (p.getName().equalsIgnoreCase("AaMay")) {
    	p.removePotionEffect(PotionEffectType.SPEED);
    }
    */
    Player[] list = Bukkit.getOnlinePlayers();
    for (int i=0;i<list.length;i++) {
    	if (list[i]!=p) {
    	    list[i].playSound(list[i].getLocation(), Sound.NOTE_PLING, 10, 1);
    	}
    }
    PlayerBuffData newplayer = new PlayerBuffData(p,this.plugin);
	  for (int i=0;i<Bukkit.getOnlinePlayers().length;i++) {
		  if (Bukkit.getOnlinePlayers()[i].hasPermission("bukkit.broadcast.admin")) {
			  Bukkit.getOnlinePlayers()[i].sendMessage(ChatColor.ITALIC+""+ChatColor.GRAY+"User "+p.getName()+" joined from IP "+p.getAddress().getAddress().getHostAddress());
		  }
	  }
    /*
    Block b = Bukkit.getWorld("world").getBlockAt(766,30,-486);
    b.setType(Material.MOB_SPAWNER);
    CreatureSpawner g = (CreatureSpawner)b.getState();
    g.setCreatureType(CreatureType.SILVERFISH);
    */
    /* How to create a book:
    ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
    BookMeta bookdata = (BookMeta)book.getItemMeta();
    bookdata.setAuthor("Steve");
    bookdata.setTitle("A Weird Occurrence");
    bookdata.addPage("This is a test page.");
    book.setItemMeta(bookdata);
    //p.setItemInHand(book);
    p.getInventory().addItem(book);
    p.updateInventory();
    */
    /*//Beginner Book.
    ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
    BookMeta bookdata = (BookMeta)book.getItemMeta();
    bookdata.setAuthor("sigonasr2");
    bookdata.setTitle("Guidebook to sig's Minecraft Server");
    bookdata.addPage("Welcome to sig's Minecraft! This guide has all the essential commands you need to know to play in our world!",
    		"Contents:\n\n1. Survival\n2. Cities\n3. Jobs\n4. Economy\n5. ");
    book.setItemMeta(bookdata);
    EntityType.
    p.getInventory().addItem(book);
    
    p.updateInventory();*/
	  
    p.updateInventory();
    if (this.plugin.PlayerinJob(p, "Explorer") && this.plugin.getJobLv("Explorer", p)>=5) {
    	//p.sendMessage("Explorer speed buff set.");
    	newplayer.setBaseSpd(1);
    }
    if (this.plugin.PlayerinJob(p, "Hunter") && this.plugin.getJobLv("Hunter", p)>=20) {
    	//p.sendMessage("Explorer speed buff set.");
    	newplayer.setBaseSpd(newplayer.base_spdlv+1);
    }
    //Bukkit.getPlayer("sigonasr2").sendMessage("Got to here.");
    newplayer.updatePlayerSpd();
    this.plugin.SPEED_CONTROL.add(newplayer);
    //Bukkit.getPlayer("sigonasr2").sendMessage("Got to here.");
    Iterator<OfflinePlayer> players = Bukkit.getWhitelistedPlayers().iterator();
    boolean playerwhitelisted=false;
    String playerslist = "";
    while (players.hasNext()) {
    	if (playerslist!="") {
    		playerslist += ",";
    	}
    	String name = players.next().getName();
    	playerslist += name;
    	if (name.compareToIgnoreCase(p.getName())==0) {
    		playerwhitelisted=true;
    	}
    }
    /*
    //Boss platform is created +,+ coordinates from the location specified.
    File file = new File("plugins/WorldEdit/schematics/boss.schematic");
    if (file.exists()) {
        try {
            com.sk89q.worldedit.Vector v = new com.sk89q.worldedit.Vector(p.getLocation().getX()-8, p.getLocation().getY(), p.getLocation().getZ()-8);
            World worldf = Bukkit.getWorld("world");
            BukkitWorld BWf = new BukkitWorld(worldf);
            EditSession es = new EditSession(BWf, 2000000);
            CuboidClipboard c1 = SchematicFormat.MCEDIT.load(file);
            c1.place(es, v, true);
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
    */
	//System.out.println("Whitelisted Players: "+playerslist);
	//System.out.println("Maximum Air: "+p.getMaximumAir());
    if (!this.plugin.getAccountsConfig().contains(p.getName())) {
      //This is a brand new player.
      Main.economy.withdrawPlayer(p.getName(), Main.economy.getBalance(p.getName()));
      Main.economy.depositPlayer(p.getName(), 70);
      this.plugin.getAccountsConfig().set(p.getName() + ".status", Boolean.valueOf(true));
      this.plugin.getAccountsConfig().set(p.getName() + ".money", Double.valueOf(this.plugin.getConfig().getDouble("start-balance")));
      this.plugin.getAccountsConfig().set(p.getName() + ".revived", Boolean.valueOf(true));
      this.plugin.getAccountsConfig().set(p.getName() + ".spleefrating", Double.valueOf(1000.0d));
      this.plugin.getAccountsConfig().set(p.getName() + ".spleefwins", Integer.valueOf(0));
      this.plugin.getAccountsConfig().set(p.getName() + ".spleeflosses", Integer.valueOf(0));
      this.plugin.getAccountsConfig().set(p.getName() + ".jobs.job1", String.valueOf("None"));
      this.plugin.getAccountsConfig().set(p.getName() + ".jobs.job1lv", Integer.valueOf(0));
      this.plugin.getAccountsConfig().set(p.getName() + ".jobs.job1exp", Double.valueOf(0.0d));
      this.plugin.getAccountsConfig().set(p.getName() + ".jobs.job2", String.valueOf("None"));
      this.plugin.getAccountsConfig().set(p.getName() + ".jobs.job2lv", Integer.valueOf(0));
      this.plugin.getAccountsConfig().set(p.getName() + ".jobs.job2exp", Double.valueOf(0.0d));
      this.plugin.getAccountsConfig().set(p.getName() + ".jobs.job3", String.valueOf("None"));
      this.plugin.getAccountsConfig().set(p.getName() + ".jobs.job3lv", Integer.valueOf(0));
      this.plugin.getAccountsConfig().set(p.getName() + ".jobs.job3exp", Double.valueOf(0.0d));
      this.plugin.getAccountsConfig().set(p.getName() + ".jobs.ultimate", String.valueOf("None"));
	  this.plugin.getAccountsConfig().set(p.getName() + ".jobs.ultimatesealed", Boolean.valueOf(false));
      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat1", Integer.valueOf(0));
      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat2", Integer.valueOf(0));
      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat3", Integer.valueOf(0));
      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat4", Integer.valueOf(0));
      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat5", Integer.valueOf(0));
      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat6", Integer.valueOf(0));
      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat7", Integer.valueOf(0));
      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat8", Integer.valueOf(0));
      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat9", Integer.valueOf(0));
      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat10", Integer.valueOf(0));
      this.plugin.getAccountsConfig().set(p.getName() + ".settings.notify1", Boolean.valueOf(true));
      this.plugin.getAccountsConfig().set(p.getName() + ".settings.notify2", Boolean.valueOf(false));
      this.plugin.getAccountsConfig().set(p.getName() + ".settings.notify3", Boolean.valueOf(true));
      this.plugin.getAccountsConfig().set(p.getName() + ".settings.notify4", Boolean.valueOf(false));
      this.plugin.getAccountsConfig().set(p.getName() + ".settings.notify5", Boolean.valueOf(false));
      this.plugin.getAccountsConfig().set(p.getName() + ".settings.notify6", Boolean.valueOf(false));
      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest1", Boolean.valueOf(false));
      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest2", Boolean.valueOf(false));
      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest3", Boolean.valueOf(false));
      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest4", Boolean.valueOf(false));
      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest5", Boolean.valueOf(false));
      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest6", Boolean.valueOf(false));
      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest7", Boolean.valueOf(false));
      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest8", Boolean.valueOf(false));
      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest9", Boolean.valueOf(false));
      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest10", Boolean.valueOf(false));
      this.plugin.saveAccountsConfig();
      System.out.println("[BankEconomy] Bank account created for " + p.getName() + ".");
      if (playerwhitelisted) {
      	Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE+"New player "+ChatColor.ITALIC+ChatColor.GOLD+p.getName()+ChatColor.RESET+ChatColor.LIGHT_PURPLE+" has joined the game.");
      	//Give a tutorial book and starting items to this user.
      	p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
      	p.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE));
      	p.getInventory().addItem(new ItemStack(Material.COOKED_CHICKEN,16));
      	p.getInventory().addItem(new ItemStack(Material.TORCH,32));
      	p.getInventory().addItem(new ItemStack(Material.LEATHER_HELMET));
      	p.getInventory().addItem(new ItemStack(Material.LEATHER_CHESTPLATE));
      	p.getInventory().addItem(new ItemStack(Material.LEATHER_LEGGINGS));
      	p.getInventory().addItem(new ItemStack(Material.LEATHER_BOOTS));
      	p.getInventory().addItem(new ItemStack(Material.MINECART));
      }
    } else {
        DecimalFormat df = new DecimalFormat("#0.00");
    	p.sendMessage(ChatColor.DARK_AQUA+"For a list of all changes made to this server, visit: http://z-gamers.net/changelog.html");
    	p.sendMessage("----------------------------");
    	p.sendMessage(ChatColor.YELLOW+"Current Money Balance: $ "+df.format(Main.economy.bankBalance(p.getName()).balance)+", Bank Balance: $"+df.format(this.plugin.getAccountsConfig().getDouble(p.getName()+".money")));
    	//Update account information for the stat point update.
    	if (!this.plugin.getAccountsConfig().contains(p.getName() + ".stats.stat1")) {
    	      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat1", Integer.valueOf(0));
    	      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat2", Integer.valueOf(0));
    	      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat3", Integer.valueOf(0));
    	      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat4", Integer.valueOf(0));
    	      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat5", Integer.valueOf(0));
    	      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat6", Integer.valueOf(0));
    	      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat7", Integer.valueOf(0));
    	      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat8", Integer.valueOf(0));
    	      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat9", Integer.valueOf(0));
    	      this.plugin.getAccountsConfig().set(p.getName() + ".stats.stat10", Integer.valueOf(0));
    	      this.plugin.saveAccountsConfig();
    	      System.out.println("Updated " + p.getName() + "'s data with stat point update.");
    	}
    	//Update account information for notification settings.
    	if (!this.plugin.getAccountsConfig().contains(p.getName() + ".settings.notify1")) {
    	      this.plugin.getAccountsConfig().set(p.getName() + ".settings.notify1", Boolean.valueOf(true));
    	      this.plugin.getAccountsConfig().set(p.getName() + ".settings.notify2", Boolean.valueOf(false));
    	      this.plugin.getAccountsConfig().set(p.getName() + ".settings.notify3", Boolean.valueOf(true));
    	      this.plugin.getAccountsConfig().set(p.getName() + ".settings.notify4", Boolean.valueOf(false));
    	      this.plugin.getAccountsConfig().set(p.getName() + ".settings.notify5", Boolean.valueOf(false));
    	      this.plugin.getAccountsConfig().set(p.getName() + ".settings.notify6", Boolean.valueOf(false));
    	      this.plugin.saveAccountsConfig();
    	      System.out.println("Updated " + p.getName() + "'s data with nofitications update.");
    	}
    	if (this.plugin.getConfig().getBoolean("halloween-enabled")) {
	    	//Update account information for Halloween book update.
	    	PlayerInventory pi = p.getInventory();
	    	boolean full=true;
	    	for (int i=0;i<pi.getSize();i++) {
	    		if (pi.getItem(i)==null) {
	    			full=false;
	    			break;
	    		}
	    	}
	    	if (!full) {
		    	if (!this.plugin.getAccountsConfig().contains(p.getName() + ".join.halloween_book")) {
		    	      this.plugin.getAccountsConfig().set(p.getName() + ".join.halloween_book", Boolean.valueOf(true));
		    	      this.plugin.saveAccountsConfig();
		    	      System.out.println("Updated " + p.getName() + "'s data with a Halloween Book.");
			    	ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
			        BookMeta bookdata = (BookMeta)book.getItemMeta();
			        bookdata.setAuthor("sigonasr2");
			        bookdata.setTitle("Halloween City Clues");
			        bookdata.addPage("This book contains hints for the 10 chests scatterred throughout the city that contains magical pumpkin pies.",
			        		"1) Overlooking the Sea. Baaaaah~\n\n2)I'm located in a place that never runs out of things. I'm higher than that though.",
			        		"3) Traveling is tiring, I need a place to rest.\n\n4) Exploit the glitch, and climb.",
			        		"5) Yoshiii~! Magikoopa knows you can't fly.\n\n6) The Lake that no one seems to treasure.",
			        		"7) This is the way of the future.\n\n8) Treehouses are not good enough for OrniNoobs.",
			        		"9) When does this happen again?\n\n10) That disco would not be possible without power.",
			        		"Good luck! And find as many magical pumpkin pies as you can!");
			        book.setItemMeta(bookdata);
			        p.getInventory().addItem(book);
		    	}
	    	}
	    	if (!this.plugin.getAccountsConfig().contains(p.getName() + ".halloween.chest1")) {
	    	      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest1", Boolean.valueOf(false));
	    	      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest2", Boolean.valueOf(false));
	    	      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest3", Boolean.valueOf(false));
	    	      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest4", Boolean.valueOf(false));
	    	      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest5", Boolean.valueOf(false));
	    	      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest6", Boolean.valueOf(false));
	    	      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest7", Boolean.valueOf(false));
	    	      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest8", Boolean.valueOf(false));
	    	      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest9", Boolean.valueOf(false));
	    	      this.plugin.getAccountsConfig().set(p.getName() + ".halloween.chest10", Boolean.valueOf(false));
	    	}
	    	if (!this.plugin.getAccountsConfig().contains(p.getName() + ".jobs.ultimate")) {
	    		this.plugin.getAccountsConfig().set(p.getName() + ".jobs.ultimate", String.valueOf("None"));
	    		this.plugin.getAccountsConfig().set(p.getName() + ".jobs.ultimatesealed", Boolean.valueOf(false));
	    	}
    	}
    	//Check if this player has unallocated stat points.
    	if (this.plugin.getStatPointTotal(p)<this.plugin.getJobTotalLvs(p)/5+1) {
    		p.sendMessage(ChatColor.GOLD+"");
    		p.sendMessage(ChatColor.GOLD+""+ChatColor.ITALIC+"You have "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" unused stat points! "+ChatColor.AQUA+"Type "+ChatColor.BOLD+"/sp"+ChatColor.RESET+ChatColor.AQUA+" to use them.");
    		p.sendMessage(ChatColor.GOLD+"");
    	}
    	//Set Stat Point specific stuff here.
    	if (this.plugin.getAccountsConfig().getInt(p.getName() + ".stats.stat10")>0) {
    		p.setMaximumAir(300+this.plugin.getStatBonus(9, this.plugin.getAccountsConfig().getInt(p.getName() + ".stats.stat10"))*20);
    	}
    	if (p.getLocation().getY()>78.0d && p.getLocation().getZ()>53.0d && p.getLocation().getZ()<64.0d && p.getLocation().getX()<1627.0d && p.getLocation().getX()>1616.0d) {
    		//In a spleef zone. Kick this player out.
    		Location newloc = p.getLocation();
    		newloc.setX(1622.5d);
    		newloc.setY(87.0d);
    		newloc.setZ(51.65d);
    		p.teleport(newloc);
    		this.plugin.getConfig().set("spleefinsession", Boolean.valueOf(false));
    	}
    }
    boolean found=false;
    for (int i=0;i<this.plugin.playerdata_list.size();i++) {
    	if (this.plugin.playerdata_list.get(i).data.getName().compareToIgnoreCase(p.getName())==0) {
    		found=true;
    		break;
    	}
    }
    if (!found) {
    	this.plugin.playerdata_list.add(new PlayerData(p));
    }
    if (this.plugin.PlayerinJob(p, "Hunter")) {
    	//Add to explorer array.
    	this.plugin.hunterplayers.add(p);
    }
    if (this.plugin.PlayerinJob(p, "Explorer")) {
    	//Add to explorer array.
    	this.plugin.explorerlist.add(new ExplorerData(p.getName(), p.getLocation().getX(), p.getLocation().getZ()));
    }
	this.plugin.hitmoblist.add(new EntityHitData(p));
    if (this.plugin.PlayerinJob(p, "Support")) {
    	//Add to support array.
    	this.plugin.supportmoblist.add(new SupportEntity(p));
    	this.plugin.supportplayers.add(new SupportPlayer(p));
    	//Bukkit.getPlayer("sigonasr2").sendMessage("Added to support list.");
    }
	try {
		Iterator<PotionEffect> effects = p.getActivePotionEffects().iterator();
			//Figure out potion effects when player joins.
			while (effects.hasNext()) {
				PotionEffect nexteffect = effects.next();
				//Bukkit.getLogger().info(p.getName()+" w/buff "+nexteffect.getType().getName()+" for "+nexteffect.getDuration()/20+" sec.");
				/*if (nexteffect.getType().getName().compareTo(PotionEffectType.JUMP.getName())==0) {
					p.removePotionEffect(PotionEffectType.JUMP);
					p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 360000, nexteffect.getAmplifier()+2, true));
				}*/
				effects.remove();
			}

	  } catch (ConcurrentModificationException ex_e) {
		  Bukkit.getLogger().warning("Potion Effect Collection not accessible while trying to slow down player.");
	  }
	updateTopSPLEEFSigns();
   }
  
  /*
  @EventHandler
  public void onPortalEnter(PlayerTeleportEvent e) {
	  final Player p = e.getPlayer();
	  if (e.getFrom().getWorld()==Bukkit.getWorld("world")) {
		  if (e.getFrom().distanceSquared(new Location(Bukkit.getWorld("world"),1606d,66d,-365d))<900) {
			  //This is a player trying to enter a portal. Verify if they have selected their ultimate.
			  if (this.plugin.getAccountsConfig().contains(e.getPlayer().getName()+".jobs.ultimate")) {
				  //Check if this job's ultimate level is high enough.
				  if (this.plugin.getJobLv(this.plugin.getAccountsConfig().getString(e.getPlayer().getName()+".jobs.ultimate"), e.getPlayer())>=40) {
					  //Allow this teleport.
					  //e.setTo(new Location(Bukkit.getWorld("world"),-8990,68,-4));
					  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					      @Override
					      public void run() {
					    	  p.getPlayer().teleport(new Location(Bukkit.getWorld("world"),-8990,68,-4));
					      }
					  	},5);
				  } else {
					  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					      @Override
					      public void run() {
					    	  p.getPlayer().teleport(new Location(Bukkit.getWorld("world"),1606d,66d,-365d));
					      }
					  	},5);
				  }
			  }
		  }
	  }
  }*/

  @EventHandler
  public void onPlayerInteract(PlayerInteractEntityEvent ev) {
      Entity theAnimal = ev.getRightClicked();
      if (theAnimal.getType() == EntityType.WOLF) {
        Wolf dog = (Wolf)theAnimal;
        DyeColor dogcolor = dog.getCollarColor();
        Player p = ev.getPlayer();
        if (dog.getOwner() == null) {
          return;
        }
        if (p != dog.getOwner()) {
          return;
        }
        if (!dog.isAngry()) {
          //Switch state of wolf.
          //dog.setSitting(!dog.isSitting());
          return;
        }
        ev.setCancelled(true);
        double oldhealth = dog.getHealth();
        dog.setSitting(true);
        dog.remove();
        Location wolfloc = dog.getLocation();
        World world = Bukkit.getWorld("world");
        Entity newAnimal = world.spawnEntity(wolfloc, EntityType.WOLF);
        Wolf newdog = (Wolf)newAnimal;
        newdog.setOwner(p);
        newdog.setHealth(oldhealth);
        newdog.setSitting(true);
        newdog.setCollarColor(dogcolor);
        p.sendMessage(ChatColor.GREEN + "This dog is now happy!");
      }
  }
  
  @EventHandler
  public void onBlockGrow(BlockGrowEvent e) {
	  int x1,y1,z1,x2=0,y2=0,z2=0;
	  x1=e.getBlock().getX();
	  y1=e.getBlock().getY();
	  z1=e.getBlock().getZ();
	  Player[] plist= Bukkit.getOnlinePlayers();
	  for (int i=0;i<plist.length;i++) {
		  x2=plist[i].getLocation().getBlockX();
		  y2=plist[i].getLocation().getBlockY();
		  z2=plist[i].getLocation().getBlockZ();
		  if (Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2))<=50) {
			  if (this.plugin.PlayerinJob(plist[i], "Farmer")) {
				  if (this.plugin.getJobLv("Farmer", plist[i])>=20) {
					  if (Math.random()<=0.30) {
						  if (e.getBlock().getType()==Material.POTATO || e.getBlock().getType()==Material.CARROT || e.getBlock().getType()==Material.CROPS || e.getBlock().getType()==Material.MELON_STEM || e.getBlock().getType()==Material.PUMPKIN_STEM) {
							  if (e.getBlock().getData()<7) {
								  e.getBlock().setData((byte) (e.getBlock().getData()+1));
							  }
						  }
						  if (e.getBlock().getType()==Material.COCOA) {
							  if (e.getBlock().getData()<8) {
								  e.getBlock().setData((byte) (e.getBlock().getData()+4));
							  }
						  }
						  if (e.getBlock().getType()==Material.NETHER_WARTS) {
							  if (e.getBlock().getData()<3) {
								  e.getBlock().setData((byte) (e.getBlock().getData()+1));
							  }
						  }
					  }
				  }
			  }
		  }
	  }
  }
  

  @EventHandler
  public void onCreatureSpawn(CreatureSpawnEvent e) {
	  Entity entity = e.getEntity();
	  if (entity.getWorld().getName().compareTo("world")==0) {
		  boolean despawn=true;
		  if (entity instanceof Monster) {
			  LivingEntity test = (LivingEntity)entity;
			  boolean block=false;
			  if (test.getCustomName()!=null && test.getCustomName().contains(ChatColor.DARK_PURPLE+"")) {
				  for (int i=-2;i<3;i++) {
					  for (int j=-2;j<3;j++) {
						  for (int k=-2;k<3;k++) {
							  if (Bukkit.getWorld("world").getBlockAt(test.getLocation().add(i,j,k)).getType()==Material.COMMAND) {
								  block=true;
								  Bukkit.getWorld("world").getBlockAt(test.getLocation().add(i,j,k)).setType(Material.COBBLESTONE);
								  despawn=false;
							  }
						  }
					  }
				  }
			  }
			  List<Entity> entities = Bukkit.getWorld("world").getEntities();
			  for (int i=0;i<entities.size();i++) {
				  if (entities.get(i) instanceof LivingEntity) {
					  LivingEntity l = (LivingEntity)entities.get(i);
					  if (l.getCustomName()!=null && l.getCustomName().contains(ChatColor.DARK_PURPLE+"") && l.getLocation().distance(test.getLocation())<10) {
						  despawn=false; //Allow it to spawn. It's next to a boss.
					  }
				  }
			  }
			  if (block || (test.getCustomName()!=null && (test.getCustomName().contains(ChatColor.DARK_PURPLE+"") || test.getType()==EntityType.ENDER_DRAGON))) {
				  despawn=false;  //This is an epic boss and its healthbar. WE can't just despawn it.
			  }
		  }
		  if (despawn) {
			  if (this.plugin.getConfig().getBoolean("halloween-enabled") && Math.random()<=0.75 && entity instanceof Monster) {
				  //Just despawn it right now.
				  entity.remove();
				  e.setCancelled(true);
			  }
			  double distancefromcity = Math.abs(1627-entity.getLocation().getX())+Math.abs((67-entity.getLocation().getY()))+Math.abs(-267-entity.getLocation().getZ());
			  int maxgroup=0; //The maximum number of mobs that may be near each other and together when spawning.
			  double chancer=1.0d; //The percent chance a duplicated mob will form.
			  double despawnchancer=0.0d; //The percent chance the mob will be forced to despawn. Decreasing natural spawning.
			  EntityType allowedtypes[] = {EntityType.BAT,EntityType.BLAZE,EntityType.CAVE_SPIDER,EntityType.ENDERMAN,EntityType.GHAST,EntityType.MAGMA_CUBE,EntityType.PIG_ZOMBIE,EntityType.SILVERFISH,EntityType.SLIME,EntityType.SPIDER,EntityType.ZOMBIE,EntityType.SKELETON,EntityType.CREEPER};
			  boolean contains=entity instanceof Monster;
			  //Mobs have more health when they are farther away, to make the mobs harder in general.
			  float groupmult=0.25f; //Change this to modify the global grouping multiplier.
			  /*
			  if (distancefromcity>50000) {
				  maxgroup=(int)(20*groupmult); //Groups of up to 20 mobs.
				  chancer=0.25d;
				  despawnchancer=0.0625d;
				  LivingEntity l = (LivingEntity)entity;
				  //l.setMaxHealth(l.getMaxHealth()+(l.getMaxHealth()*1.0d));
				  if (Math.random()<=0.25) {
					  //l.setMaxHealth(l.getMaxHealth()+(l.getMaxHealth()*0.5d));
				  }
				  l.setHealth(l.getMaxHealth());
			  } else
			  if (distancefromcity>20000) {
				  maxgroup=(int)(15*groupmult); //Groups of up to 15 mobs.
				  chancer=0.175d;
				  despawnchancer=0.1250d;
				  LivingEntity l = (LivingEntity)entity;
				  //l.setMaxHealth(l.getMaxHealth()+(l.getMaxHealth()*0.75d));
				  if (Math.random()<=0.25) {
					  //l.setMaxHealth(l.getMaxHealth()+(l.getMaxHealth()*0.5d));
				  }
				  l.setHealth(l.getMaxHealth());
			  } else
			  if (distancefromcity>10000) {
				  maxgroup=(int)(12*groupmult); //Groups of up to 12 mobs.
				  chancer=0.125d;
				  despawnchancer=0.15d;
				  LivingEntity l = (LivingEntity)entity;
				  //l.setMaxHealth(l.getMaxHealth()+(l.getMaxHealth()*0.5d));
				  if (Math.random()<=0.25) {
					  //l.setMaxHealth(l.getMaxHealth()+(l.getMaxHealth()*0.25d));
				  }
				  l.setHealth(l.getMaxHealth());
			  } else*/
			 maxgroup=(int)(10*groupmult);
			 chancer=0.10d;
			  despawnchancer=0.25d;
			  if (this.plugin.getConfig().getBoolean("halloween-enabled")) {
				  groupmult=0.0625f;
				  chancer=0.025f;
				  despawnchancer=0.4375d;
			  }
			  /*
			  if (distancefromcity>4000) {
				  maxgroup=(int)(10*groupmult); //Groups of up to 10 mobs.
				  chancer=0.10d;
				  despawnchancer=0.25d;
				  LivingEntity l = (LivingEntity)entity;
				  //l.setMaxHealth(l.getMaxHealth()+(l.getMaxHealth()*0.5d));
				  if (Math.random()<=0.25) {
					  //l.setMaxHealth(l.getMaxHealth()+(l.getMaxHealth()*0.25d));
				  }
				  l.setHealth(l.getMaxHealth());
			  } else
			  if (distancefromcity>2000) {
				  maxgroup=(int)(7*groupmult); //Groups of up to 7 mobs.
				  chancer=0.075d;
				  despawnchancer=0.35d;
				  LivingEntity l = (LivingEntity)entity;
				  //l.setMaxHealth(l.getMaxHealth()+(l.getMaxHealth()*0.25d));
				  if (Math.random()<=0.25) {
					  //l.setMaxHealth(l.getMaxHealth()+(l.getMaxHealth()*0.25d));
				  }
				  l.setHealth(l.getMaxHealth());
			  } else
			  if (distancefromcity>1000) {
				  maxgroup=(int)(5*groupmult); //Groups of up to 5 mobs.
				  chancer=0.05d;
				  despawnchancer=0.50d;
				  LivingEntity l = (LivingEntity)entity;
				  //l.setMaxHealth(l.getMaxHealth()+(l.getMaxHealth()*0.25d));
				  if (Math.random()<=0.25) {
					  //l.setMaxHealth(l.getMaxHealth()+(l.getMaxHealth()*0.25d));
				  }
				  l.setHealth(l.getMaxHealth());
			  } else
			  if (distancefromcity>400) {
				  maxgroup=(int)(3*groupmult); //Groups of up to 3 mobs.
				  chancer=0.025d;
				  despawnchancer=0.75d;
			  } else {
				  maxgroup=(int)(3*groupmult); //Groups of up to 3 mobs.
				  chancer=0.005d;
				  despawnchancer=0.95d;
			  }*/
			  if (entity.getType()==EntityType.ZOMBIE || entity.getType()==EntityType.PIG_ZOMBIE || entity.getType()==EntityType.SKELETON) {
				  LivingEntity l = (LivingEntity)entity;
				  EntityEquipment inven = l.getEquipment();
				  if (l.getCustomName()!=null && l.getCustomName().equals(ChatColor.GOLD+"Charge Zombie II")) {
					  despawnchancer/=4;
					  //Destroy a huge amount around it when it spawns.
					  for (int k=-4;k<5;k++) {
						  for (int j=-4;j<5;j++) {
							  for (int m=-1;m<5;m++) {
								  Location checkloc = l.getLocation().add(k,m,j);
								  Block bl = Bukkit.getWorld("world").getBlockAt(checkloc);
								  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER || bl.getType()!=Material.COMMAND || bl.getType()!=Material.MOSSY_COBBLESTONE) {
									  bl.breakNaturally();
								  }
							  }
						  }
					  }
				  }
				  if (inven!=null) {
					  inven.setBootsDropChance(0.02f);
					  inven.setChestplateDropChance(0.02f);
					  inven.setLeggingsDropChance(0.02f);
					  inven.setHelmetDropChance(0.02f);
					  inven.setItemInHandDropChance(0.02f);
					  if (entity.getType()==EntityType.SKELETON) {
						  inven.setItemInHand(new ItemStack(Material.BOW));
					  }
					  if (distancefromcity<2000) {
						  if (entity.getType()==EntityType.ZOMBIE) {
							  Zombie zomb = (Zombie)l;
							  if (zomb.isBaby()) {
								  zomb.setBaby(false);
							  }
						  }
						  if (inven.getItemInHand()!=null && inven.getItemInHand().getType()==Material.DIAMOND_SWORD ||
								  inven.getItemInHand().getType()==Material.GOLD_SWORD ||
								  inven.getItemInHand().getType()==Material.IRON_SWORD) {
							  inven.setItemInHand(new ItemStack(Material.WOOD_SWORD));
						  }
						  if (inven.getChestplate()!=null && inven.getChestplate().getType()==Material.DIAMOND_CHESTPLATE ||
								  inven.getChestplate().getType()==Material.GOLD_CHESTPLATE ||
								  inven.getChestplate().getType()==Material.IRON_CHESTPLATE ||
								  inven.getChestplate().getType()==Material.CHAINMAIL_CHESTPLATE) {
							  inven.setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
						  }
						  if (inven.getLeggings()!=null && inven.getLeggings().getType()==Material.DIAMOND_LEGGINGS ||
								  inven.getLeggings().getType()==Material.GOLD_LEGGINGS ||
								  inven.getLeggings().getType()==Material.IRON_LEGGINGS ||
								  inven.getLeggings().getType()==Material.CHAINMAIL_LEGGINGS) {
							  inven.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
						  }
						  if (inven.getBoots()!=null && inven.getBoots().getType()==Material.DIAMOND_BOOTS ||
								  inven.getBoots().getType()==Material.GOLD_BOOTS ||
								  inven.getBoots().getType()==Material.IRON_BOOTS ||
								  inven.getBoots().getType()==Material.CHAINMAIL_BOOTS) {
							  inven.setBoots(new ItemStack(Material.LEATHER_BOOTS));
						  }
						  if (inven.getHelmet()!=null && inven.getHelmet().getType()==Material.DIAMOND_HELMET ||
								  inven.getHelmet().getType()==Material.GOLD_HELMET ||
								  inven.getHelmet().getType()==Material.IRON_HELMET ||
								  inven.getHelmet().getType()==Material.CHAINMAIL_HELMET) {
							  inven.setHelmet(new ItemStack(Material.LEATHER_HELMET));
						  }
					  }
					  else if (distancefromcity<8000) {
						  if (entity.getType()==EntityType.ZOMBIE) {
							  Zombie zomb = (Zombie)l;
							  if (zomb.isBaby()) {
								  zomb.setBaby(false);
							  }
						  }
						  if (inven.getItemInHand()!=null && inven.getItemInHand().getType()==Material.DIAMOND_SWORD ||
								  inven.getItemInHand().getType()==Material.GOLD_SWORD) {
							  inven.setItemInHand(new ItemStack(Material.IRON_SWORD));
						  }
						  if (inven.getChestplate()!=null && inven.getChestplate().getType()==Material.DIAMOND_CHESTPLATE) {
							  inven.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
						  }
						  if (inven.getLeggings()!=null && inven.getLeggings().getType()==Material.DIAMOND_LEGGINGS) {
							  inven.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
						  }
						  if (inven.getBoots()!=null && inven.getBoots().getType()==Material.DIAMOND_BOOTS) {
							  inven.setBoots(new ItemStack(Material.IRON_BOOTS));
						  }
						  if (inven.getHelmet()!=null && inven.getHelmet().getType()==Material.DIAMOND_HELMET) {
							  inven.setHelmet(new ItemStack(Material.IRON_HELMET));
						  }
					  }
				  }
			  }
			  //Get the torches/glowstone/mob spawners around this entity.
			  int torches=0,glowstone=0,spawners=0;
			  for (int x=-5;x<5;x++) {
				  for (int y=-5;y<5;y++) {
					  for (int z=-5;z<5;z++) {
						  Block test = entity.getWorld().getBlockAt(entity.getLocation().add(x,y,z));
						  if (test.getType()==Material.TORCH) {
							  torches++;
						  } else
						  if (test.getType()==Material.GLOWSTONE) {
							  glowstone++;
						  } else
						  if (test.getType()==Material.MOB_SPAWNER) {
							  spawners++;
						  }
					  }
				  }
			  }
			  if (Bukkit.getWorld("world").getHighestBlockYAt(entity.getLocation())>=96) {
				  //This is a tall world.
				  if (entity.getLocation().getBlockY()>104) {
					  despawnchancer*=(Math.random()*3.0d)+1;
				  } else {
					  for (int i=104-entity.getLocation().getBlockY();i>0;i--) {
						  despawnchancer/=1.0175d;
					  }
				  }
			  } else {
				  //This is a short world.
				  if (entity.getLocation().getBlockY()>52) {
					  despawnchancer*=(Math.random()*3.0d)+1;
				  } else {
					  for (int i=52-entity.getLocation().getBlockY();i>0;i--) {
						  despawnchancer/=1.025d;
					  }
				  }
			  }
			  //if (e.getSpawnReason()!=SpawnReason.NATURAL) { //If it's a natural spawn, we gotta do it. Ignore our checking stuff.
			  if (contains && spawners==0) { //We only do this despawn/extra spawn chance stuff when we have an actual mob AND when there's not a spawner nearby.
				  if ((Math.random()<=despawnchancer || (torches+glowstone>=3))/* && entity.getNearbyEntities(5, 5, 5).size()>50*/) {
					  //if (e.getSpawnReason()!=SpawnReason.CUSTOM && e.getLocation().getBlockY()!=Bukkit.getPlayer("AaMay").getLocation().getBlockY()) {
					  entity.remove();
					  e.setCancelled(true);
					  //}
					  //Bukkit.getPlayer("AaMay").sendMessage(ChatColor.BLUE+entity.getType().getName()+": Removed mob due to despawn chancer / special case.");
				  }
				  else {
					  int totallvs=0;
					  List<Entity> nearbylist = entity.getNearbyEntities(30, 30, 30);
					  //Filter out all unrelated entity types.
					  for (int k=0;k<nearbylist.size();k++) {
						  //See if human players are near. If so, factor that in for determining how many mobs may exist.
						  if (nearbylist.get(k).getType()==EntityType.PLAYER) {
							  //This is a player.
							  Player g = (Player)nearbylist.get(k);
							  maxgroup+=this.plugin.getJobTotalLvs(g)/20;
							  totallvs+=this.plugin.getJobTotalLvs(g);
				  			////Bukkit.getLogger().info("Mob maxgroup increased to "+maxgroup+" down here.");
						  }
						  if (nearbylist.get(k).getType()!=EntityType.SKELETON &&
								  nearbylist.get(k).getType()!=EntityType.ZOMBIE &&
								  nearbylist.get(k).getType()!=EntityType.CREEPER &&
								  nearbylist.get(k).getType()!=EntityType.SPIDER &&
								  nearbylist.get(k).getType()!=EntityType.ENDERMAN) {
							  nearbylist.remove(k);
							  k--;
						  }
					  }
					  maxgroup/=groupmult;
					  int currentnearby = nearbylist.size();
					  boolean keep=false;
					  if (entity.getType()==EntityType.ZOMBIE || entity.getType()==EntityType.PIG_ZOMBIE || entity.getType()==EntityType.SKELETON) {
						  LivingEntity l = (LivingEntity)entity;
						  if (l.getCustomName()!=null && l.getCustomName().equals(ChatColor.GOLD+"Charge Zombie II")) {
							  keep=false;
						  }
					  }
					  if (currentnearby-maxgroup>1 && !keep) {
						  entity.remove();
						  e.setCancelled(true);
						  //Bukkit.getPlayer("AaMay").sendMessage(ChatColor.GREEN+entity.getType().getName()+": Removed mob due to too many mobs near it.");
					  } else {
						  //We then attempt to see if despawn chancer occurs.
						  if (Math.random()<=despawnchancer) {
							  entity.remove();
							  e.setCancelled(true);
							  //Bukkit.getPlayer("AaMay").sendMessage(ChatColor.YELLOW+entity.getType().getName()+": Removed mob due to despawner chance.");
						  } else {
							  //Now we attempt to spawn more things.
							  int k = currentnearby;
							  while (k<maxgroup-currentnearby+1) {
								  if (Bukkit.getWorld("world").getFullTime()-this.plugin.last_mob_random_time>10 && Math.random()<=chancer) {
									  Location testloc = entity.getLocation().add(Math.random()*4.0d-Math.random()*4.0d,Math.random()*4.0d,Math.random()*4.0d-Math.random()*4.0d);
									  if (Bukkit.getWorld("world").getBlockAt(testloc).getType()==Material.AIR) {
										  Bukkit.getWorld("world").spawnEntity(testloc, entity.getType());
										  this.plugin.last_mob_random_time=Bukkit.getWorld("world").getFullTime();
										  //Bukkit.getPlayer("AaMay").sendMessage(ChatColor.RED+entity.getType().getName()+": Spawned extra mob.");
										  /*int j=0;
										  while (j<10) {
											  Bukkit.getWorld("world").spawnEntity(testloc, entity.getType());
											  j++;
										  }*/
									  }
								  }
								  k++;
							  }
						  }
					  }
					  double levelsmult=1.5;
					  if (totallvs>20*levelsmult) {
						  if (totallvs<40*levelsmult) {
							  //Sometimes wear leather armor. Only for Skeletons and Zombies.
							  if (entity.getType()==EntityType.SKELETON || entity.getType()==EntityType.ZOMBIE) {
								  LivingEntity l = (LivingEntity) entity;
								  if (Math.random()>=0.15) {
									  l.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
									  if (Math.random()>=0.25) {
										  l.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
										  if (Math.random()>=0.5) {
											  l.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
											  if (Math.random()>=0.8) {
												  l.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
											  }
										  }
									  }
								  }
							  }
						  } else
						  if (totallvs<60*levelsmult) {
							  //Wear leather armor a bit more often. Sometimes a chain piece here or there. Include a Wooden sword usually.
							  if (entity.getType()==EntityType.SKELETON || entity.getType()==EntityType.ZOMBIE) {
								  LivingEntity l = (LivingEntity) entity;
								  if (entity.getType()==EntityType.ZOMBIE) {
									  if (Math.random()<=0.65) {
										  l.getEquipment().setItemInHand(new ItemStack(Material.WOOD_SWORD));
									  }
								  }
								  if (Math.random()>=0.25) {
									  if (Math.random()<=0.75) {
										  l.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
									  } else {
										  l.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
									  }
									  if (Math.random()>=0.45) {
										  if (Math.random()<=0.75) {
										  l.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
										  } else {
											  l.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
										  }
										  if (Math.random()>=0.65) {
											  if (Math.random()<=0.75) {
											  l.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
											  } else {
												  l.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
											  }
											  if (Math.random()>=0.95) {
												  if (Math.random()<=0.75) {
												  l.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
												  } else {
													  l.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
												  }
											  }
										  }
									  }
								  }
							  }
						  } else
						  if (totallvs<80*levelsmult) {
							  //Wear chainmail armor a bit more often. Sometimes an iron piece here or there. Include an Iron sword sometimes, a wooden one usually.
							  if (entity.getType()==EntityType.SKELETON || entity.getType()==EntityType.ZOMBIE) {
								  LivingEntity l = (LivingEntity) entity;
								  if (entity.getType()==EntityType.ZOMBIE) {
									  if (Math.random()<=0.65) {
										  if (Math.random()<=0.75) {
											  l.getEquipment().setItemInHand(new ItemStack(Material.WOOD_SWORD));
										  } else {
											  l.getEquipment().setItemInHand(new ItemStack(Material.IRON_SWORD));
										  }
									  }
								  }
								  if (Math.random()>=0.25) {
									  if (Math.random()<=0.75) {
										  l.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
									  } else {
										  l.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
									  }
									  if (Math.random()>=0.45) {
										  if (Math.random()<=0.75) {
										  l.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
										  } else {
											  l.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
										  }
										  if (Math.random()>=0.65) {
											  if (Math.random()<=0.75) {
											  l.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
											  } else {
												  l.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
											  }
											  if (Math.random()>=0.95) {
												  if (Math.random()<=0.75) {
												  l.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
												  } else {
													  l.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
												  }
											  }
										  }
									  }
								  }
							  }
						  } else
						  if (totallvs<100*levelsmult) {
							  //Wear iron armor a bit more often. Sometimes a diamond piece here or there. Include a Diamond sword sometimes, an iron one usually.
							  if (entity.getType()==EntityType.SKELETON || entity.getType()==EntityType.ZOMBIE) {
								  LivingEntity l = (LivingEntity) entity;
								  if (entity.getType()==EntityType.ZOMBIE) {
									  if (Math.random()<=0.65) {
										  if (Math.random()<=0.75) {
											  l.getEquipment().setItemInHand(new ItemStack(Material.IRON_SWORD));
										  } else {
											  l.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
										  }
									  }
								  }
								  if (Math.random()>=0.25) {
									  if (Math.random()<=0.75) {
										  l.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
									  } else {
										  l.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
									  }
									  if (Math.random()>=0.45) {
										  if (Math.random()<=0.75) {
										  l.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
										  } else {
											  l.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
										  }
										  if (Math.random()>=0.65) {
											  if (Math.random()<=0.75) {
											  l.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
											  } else {
												  l.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
											  }
											  if (Math.random()>=0.95) {
												  if (Math.random()<=0.75) {
												  l.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
												  } else {
													  l.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
												  }
											  }
										  }
									  }
								  }
							  }
						  } else
						  if (totallvs<120*levelsmult) {
							  //Wear diamond armor a bit more often. Sometimes an enchanted diamond piece here or there. Include a Golden sword sometimes, a diamond one usually.
							  if (entity.getType()==EntityType.SKELETON || entity.getType()==EntityType.ZOMBIE) {
								  LivingEntity l = (LivingEntity) entity;
								  if (entity.getType()==EntityType.ZOMBIE) {
									  if (Math.random()<=0.65) {
										  if (Math.random()<=0.75) {
											  l.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
										  } else {
											  l.getEquipment().setItemInHand(new ItemStack(Material.GOLD_SWORD));
										  }
									  }
								  }
								  if (Math.random()>=0.25) {
									  if (Math.random()<=0.75) {
										  l.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
									  } else {
										  ItemStack enchanted = new ItemStack(Material.DIAMOND_CHESTPLATE);
										  enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*4.0d)+1);
										  l.getEquipment().setChestplate(enchanted);
									  }
									  if (Math.random()>=0.45) {
										  if (Math.random()<=0.75) {
										  l.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
										  } else {
											  ItemStack enchanted = new ItemStack(Material.DIAMOND_LEGGINGS);
											  enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*4.0d)+1);
											  l.getEquipment().setLeggings(enchanted);
										  }
										  if (Math.random()>=0.65) {
											  if (Math.random()<=0.75) {
											  l.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
											  } else {
												  ItemStack enchanted = new ItemStack(Material.DIAMOND_HELMET);
												  enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*4.0d)+1);
												  l.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
											  }
											  if (Math.random()>=0.95) {
												  if (Math.random()<=0.75) {
												  l.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
												  } else {
													  ItemStack enchanted = new ItemStack(Material.DIAMOND_BOOTS);
													  enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*4.0d)+1);
													  l.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
												  }
											  }
										  }
									  }
								  }
							  }
						  } else {
							  //Well dang, your party's huge and OP.
							//Wear diamond armor almost always. Enchanted diamond pieces here and there.
							  if (entity.getType()==EntityType.SKELETON || entity.getType()==EntityType.ZOMBIE) {
								  LivingEntity l = (LivingEntity) entity;
								  if (entity.getType()==EntityType.ZOMBIE) {
									  if (Math.random()<=0.80) {
										  if (Math.random()<=0.75) {
											  ItemStack enchanted = new ItemStack(Material.DIAMOND_SWORD);
											  enchanted.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, (int)(Math.random()*4.0d)+1);
											  if (Math.random()<=0.5) {
												  enchanted.addUnsafeEnchantment(Enchantment.KNOCKBACK, (int)(Math.random()*2.0d)+1);
											  } else {
												  enchanted.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, (int)(Math.random()*5.0d)+1);
											  }
											  l.getEquipment().setItemInHand(enchanted);
										  } else {
											  ItemStack enchanted = new ItemStack(Material.GOLD_SWORD);
											  enchanted.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, (int)(Math.random()*4.0d)+1);
											  if (Math.random()<=0.5) {
												  enchanted.addUnsafeEnchantment(Enchantment.KNOCKBACK, (int)(Math.random()*2.0d)+1);
											  } else {
												  enchanted.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, (int)(Math.random()*5.0d)+1);
											  }
											  l.getEquipment().setItemInHand(enchanted);
										  }
									  }
								  }
								  if (Math.random()>=0.25) {
									  if (Math.random()<=0.75) {
										  l.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
									  } else {
										  ItemStack enchanted = new ItemStack(Material.DIAMOND_CHESTPLATE);
										  enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*6.0d)+1);
										  if (Math.random()<=0.5) {
											  enchanted.addUnsafeEnchantment(Enchantment.THORNS, (int)(Math.random()*4.0d)+1);
										  }
										  l.getEquipment().setChestplate(enchanted);
									  }
									  if (Math.random()>=0.45) {
										  if (Math.random()<=0.75) {
										  l.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
										  } else {
											  ItemStack enchanted = new ItemStack(Material.DIAMOND_LEGGINGS);
											  enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*6.0d)+1);
											  if (Math.random()<=0.5) {
												  enchanted.addUnsafeEnchantment(Enchantment.THORNS, (int)(Math.random()*4.0d)+1);
											  }
											  l.getEquipment().setLeggings(enchanted);
										  }
										  if (Math.random()>=0.65) {
											  if (Math.random()<=0.75) {
											  l.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
											  } else {
												  ItemStack enchanted = new ItemStack(Material.DIAMOND_HELMET);
												  enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*6.0d)+1);
												  if (Math.random()<=0.5) {
													  enchanted.addUnsafeEnchantment(Enchantment.THORNS, (int)(Math.random()*4.0d)+1);
												  }
												  l.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
											  }
											  if (Math.random()>=0.95) {
												  if (Math.random()<=0.75) {
												  l.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
												  } else {
													  ItemStack enchanted = new ItemStack(Material.DIAMOND_BOOTS);
													  enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*6.0d)+1);
													  if (Math.random()<=0.5) {
														  enchanted.addUnsafeEnchantment(Enchantment.THORNS, (int)(Math.random()*4.0d)+1);
													  }
													  l.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
												  }
											  }
										  }
									  }
								  }
							  }
						  }
					  }
				  }
			  }
			  //}
			  /*
			  double distancefromcity = Math.abs(1627-entity.getLocation().getX())+Math.abs((67-entity.getLocation().getY()))+Math.abs(-267-entity.getLocation().getZ());
			  double chancer=1.0d, increasechancer = 0.5d, despawnchancer = 32.0d;
			  if (distancefromcity>50000) {
				  chancer = 0.5d;
				  increasechancer=0.25d;
				  despawnchancer = 16.0d;
			  } else 
			  if (distancefromcity>20000) {
				  chancer = 0.5d;
				  increasechancer=0.5d;
				  despawnchancer = 16.0d;
			  } else 
			  if (distancefromcity>10000) {
				  chancer = 0.5d;
				  increasechancer=1.0d;
				  despawnchancer = 4.0d;
			  } else 
			  if (distancefromcity>4000) {
				  chancer = 1.0d;
				  increasechancer=4.0d;
				  despawnchancer = 2.0d;
			  } else 
			  if (distancefromcity>2000) {
				  chancer = 2.0d;
				  increasechancer=8.0d;
				  despawnchancer = 1.25d;
			  } else 
			  if (distancefromcity>1000) {
				  chancer = 2.0d;
				  increasechancer=16.0d;
				  despawnchancer = 1.25d;
			  } else 
			  if (distancefromcity>400) {
				  chancer = 16.0d;
				  increasechancer = 32.0d;
				  despawnchancer = 1.125d;
			  } else {
				  chancer = 32.0d;
				  increasechancer = 64.0d;
				  despawnchancer = 1.025d;
			  }
			  if (entity.getLocation().getY()>62) {
				  despawnchancer/=Math.random()*16.0d+1.0d;
			  }
			  if (entity.getLocation().getY()<50) {
				  chancer/=1.5d;
				  if (chancer<0.5d) {
					  chancer=0.5d;
				  }
				  for (int i=50;i>entity.getLocation().getY();i--) {
					  increasechancer/=1.03d;
					  despawnchancer*=1.03d;
				  }
				  if (increasechancer<0.01d) {
					  increasechancer=0.01d;
				  }
			  }
			  EntityType allowedtypes[] = {EntityType.BAT,EntityType.BLAZE,EntityType.CAVE_SPIDER,EntityType.ENDERMAN,EntityType.GHAST,EntityType.MAGMA_CUBE,EntityType.PIG_ZOMBIE,EntityType.SILVERFISH,EntityType.SLIME,EntityType.SPIDER,EntityType.ZOMBIE,EntityType.SKELETON,EntityType.CREEPER};
			  boolean contains=entity instanceof Monster
			  for (int i=0;i<allowedtypes.length;i++) {
				  if (entity.getType()==allowedtypes[i]) {
					  contains=true;
					  break;
				  }
			  }
			  if (entity.getType()==EntityType.ZOMBIE || entity.getType()==EntityType.PIG_ZOMBIE || entity.getType()==EntityType.SKELETON) {
				  LivingEntity l = (LivingEntity)entity;
				  EntityEquipment inven = l.getEquipment();
				  if (inven!=null) {
					  if (distancefromcity<2000) {
						  if (entity.getType()==EntityType.ZOMBIE) {
							  Zombie zomb = (Zombie)l;
							  if (zomb.isBaby()) {
								  zomb.setBaby(false);
							  }
						  }
						  if (inven.getItemInHand()!=null && inven.getItemInHand().getType()==Material.DIAMOND_SWORD ||
								  inven.getItemInHand().getType()==Material.GOLD_SWORD ||
								  inven.getItemInHand().getType()==Material.IRON_SWORD) {
							  inven.setItemInHand(new ItemStack(Material.WOOD_SWORD));
						  }
						  if (inven.getChestplate()!=null && inven.getChestplate().getType()==Material.DIAMOND_CHESTPLATE ||
								  inven.getChestplate().getType()==Material.GOLD_CHESTPLATE ||
								  inven.getChestplate().getType()==Material.IRON_CHESTPLATE ||
								  inven.getChestplate().getType()==Material.CHAINMAIL_CHESTPLATE) {
							  inven.setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
						  }
						  if (inven.getLeggings()!=null && inven.getLeggings().getType()==Material.DIAMOND_LEGGINGS ||
								  inven.getLeggings().getType()==Material.GOLD_LEGGINGS ||
								  inven.getLeggings().getType()==Material.IRON_LEGGINGS ||
								  inven.getLeggings().getType()==Material.CHAINMAIL_LEGGINGS) {
							  inven.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
						  }
						  if (inven.getBoots()!=null && inven.getBoots().getType()==Material.DIAMOND_BOOTS ||
								  inven.getBoots().getType()==Material.GOLD_BOOTS ||
								  inven.getBoots().getType()==Material.IRON_BOOTS ||
								  inven.getBoots().getType()==Material.CHAINMAIL_BOOTS) {
							  inven.setBoots(new ItemStack(Material.LEATHER_BOOTS));
						  }
						  if (inven.getHelmet()!=null && inven.getHelmet().getType()==Material.DIAMOND_HELMET ||
								  inven.getHelmet().getType()==Material.GOLD_HELMET ||
								  inven.getHelmet().getType()==Material.IRON_HELMET ||
								  inven.getHelmet().getType()==Material.CHAINMAIL_HELMET) {
							  inven.setHelmet(new ItemStack(Material.LEATHER_HELMET));
						  }
					  }
					  else if (distancefromcity<8000) {
						  if (entity.getType()==EntityType.ZOMBIE) {
							  Zombie zomb = (Zombie)l;
							  if (zomb.isBaby()) {
								  zomb.setBaby(false);
							  }
						  }
						  if (inven.getItemInHand()!=null && inven.getItemInHand().getType()==Material.DIAMOND_SWORD ||
								  inven.getItemInHand().getType()==Material.GOLD_SWORD) {
							  inven.setItemInHand(new ItemStack(Material.IRON_SWORD));
						  }
						  if (inven.getChestplate()!=null && inven.getChestplate().getType()==Material.DIAMOND_CHESTPLATE) {
							  inven.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
						  }
						  if (inven.getLeggings()!=null && inven.getLeggings().getType()==Material.DIAMOND_LEGGINGS) {
							  inven.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
						  }
						  if (inven.getBoots()!=null && inven.getBoots().getType()==Material.DIAMOND_BOOTS) {
							  inven.setBoots(new ItemStack(Material.IRON_BOOTS));
						  }
						  if (inven.getHelmet()!=null && inven.getHelmet().getType()==Material.DIAMOND_HELMET) {
							  inven.setHelmet(new ItemStack(Material.IRON_HELMET));
						  }
					  }
				  }
			  }
			  //Get the torches/glowstone/mob spawners around this entity.
			  int torches=0,glowstone=0,spawners=0;
			  for (int x=-5;x<5;x++) {
				  for (int y=-5;y<5;y++) {
					  for (int z=-5;z<5;z++) {
						  Block test = entity.getWorld().getBlockAt(entity.getLocation().add(x,y,z));
						  if (test.getType()==Material.TORCH) {
							  torches++;
						  } else
						  if (test.getType()==Material.GLOWSTONE) {
							  glowstone++;
						  } else
						  if (test.getType()==Material.MOB_SPAWNER) {
							  spawners++;
						  }
					  }
				  }
			  }
			  //Bukkit.getPlayer("sigonasr2").sendMessage(entity.getType()+": Found "+torches+" torches, "+glowstone+" glowstone, "+spawners+" spawners around me.");
			  if (contains && (Math.random()*despawnchancer<1.0d || (torches+glowstone>=3)) && spawners==0 && entity.getNearbyEntities(5, 5, 5).size()<50) {
				  //if (e.getSpawnReason()!=SpawnReason.CUSTOM && e.getLocation().getBlockY()!=Bukkit.getPlayer("AaMay").getLocation().getBlockY()) {
				  entity.remove();
				  e.setCancelled(true);
				  //}
				  //Bukkit.getPlayer("sigonasr2").sendMessage(entity.getType()+" prevented from spawning.");
			  }
			  if (contains && (Bukkit.getWorld("world").getFullTime()-this.plugin.last_mob_random_time>10 || this.plugin.last_mob_random_time==0) && Math.random()*chancer<1.0d) {
				  this.plugin.last_mob_random_time=Bukkit.getWorld("world").getFullTime();
				  Location testloc = entity.getLocation().add(Math.random()*4.0d-Math.random()*4.0d,Math.random()*4.0d,Math.random()*4.0d-Math.random()*4.0d);
				  if (Bukkit.getWorld("world").getBlockAt(testloc).getType()==Material.AIR) {
					  Bukkit.getWorld("world").spawnEntity(testloc, entity.getType());
					  /*int j=0;
					  while (j<10) {
						  Bukkit.getWorld("world").spawnEntity(testloc, entity.getType());
						  j++;
					  }*/
			  /*
				  }
				  while (Math.random()*chancer<1.0d) {
					  chancer+=increasechancer;
					  testloc = entity.getLocation().add(Math.random()*4.0d-Math.random()*4.0d,Math.random()*4.0d,Math.random()*4.0d-Math.random()*4.0d);
					  if (Bukkit.getWorld("world").getBlockAt(testloc).getType()==Material.AIR && Bukkit.getWorld("world").getBlockAt(testloc.add(0,1,0)).getType()==Material.AIR) {
						  Bukkit.getWorld("world").spawnEntity(testloc, entity.getType());
						  /*int j=0;
						  while (j<10) {
							  Bukkit.getWorld("world").spawnEntity(entity.getLocation().add(Math.random()*4.0d-Math.random()*4.0d,Math.random()*4.0d-Math.random()*4.0d,Math.random()*4.0d-Math.random()*4.0d), entity.getType());
							  j++;
						  }*/
					/*  }
				  }
			  }
	  		*/
			  
		  }
	  }
	  if (entity.getWorld().getName().compareTo("world_nether")==0) {
		  if (entity.getType()==EntityType.PIG_ZOMBIE) {
			  if (Math.random()<=0.005) {
				  //0.5% chance of a magma cube spawning.
				  Bukkit.getWorld("world_nether").spawnEntity(entity.getLocation(), EntityType.MAGMA_CUBE);
			  }
			  if (Math.random()<=0.0003125) {
				  //0.03125% chance of a ghast spawning.
				  Bukkit.getWorld("world_nether").spawnEntity(entity.getLocation(), EntityType.GHAST);
			  }
		  }
	  }
	  if (entity.getWorld().getName().compareTo("world_the_end")==0) {
		  if (entity.getType()==EntityType.ENDER_DRAGON) {
			  LivingEntity l = (LivingEntity)entity;
			  l.setMaxHealth(l.getMaxHealth()*4);
			  l.setHealth(l.getMaxHealth());
		  }
	  }
	  if (entity.getType()==EntityType.EXPERIENCE_ORB) {
		  Bukkit.getWorld("world").spawnEntity(entity.getLocation(),entity.getType());
	  }
	  if (e.getSpawnReason()==SpawnReason.BREEDING) {
		  //Spawn reason for later spawning.
		  //Check for this entity in list of animals that have been interacted with.
		  int slot=-1;
		  Player p=null;
		  String owner1="",owner2="";
		  List<Entity> checklist = e.getEntity().getNearbyEntities(3, 3, 3);
		  for (int i=0;i<checklist.size();i++) {
			  for (int j=0;j<this.plugin.animallist.size();j++) {
				  if (this.plugin.animallist.get(j).getID()==checklist.get(i).getUniqueId()) {
					  if (owner1.compareTo("")==0) {
						  owner1=this.plugin.animallist.get(j).getOwner();
					  } else {
						  if (owner2.compareTo("")==0) {
							  owner2=this.plugin.animallist.get(j).getOwner();
						  } else {
							  break;
						  }
					  }	
					  break;
				  }
			  }
		  }
		  if (owner1.compareTo(owner2)==0) {
			  //This is the player!
			  p = Bukkit.getPlayer(owner1);
			  if (this.plugin.PlayerinJob(p, "Breeder")) {
				  int mult=1;
				  List<Entity>nearby=e.getEntity().getNearbyEntities(25, 25, 25);
				  int countamount=0;
				  for (int i=0;i<nearby.size();i++) {
					  if (nearby.get(i).getType()==e.getEntity().getType()) {
						  countamount++;
					  }
				  }
				  //p.sendMessage("There were "+countamount+" "+e.getEntity().getType());
				  if (countamount<4) {
					  mult=20;
				  } else {
					  mult=1;
				  }
				  if (mult==10) {
					  p.sendMessage("You started a new "+ChatColor.GREEN+e.getEntity().getType()+ChatColor.WHITE+" family out here!");
				  }
				  if (e.getEntity().getType()==EntityType.CHICKEN) {
					  this.plugin.gainMoneyExp(p,"Breeder",0.01*mult,2*mult);
					  if (this.plugin.getJobLv("Breeder", p)>=10) {
						  if (Math.random()<=0.25 && countamount<50) {
						  Chicken newent = (Chicken)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.CHICKEN);
						  newent.setBaby();
						  } else
						  if (Math.random()<=0.25 && countamount<50) {
						  Chicken newent = (Chicken)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.CHICKEN);
						  newent.setBaby();
						  newent = (Chicken)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.CHICKEN);
						  newent.setBaby();
						  }
					  }
				  }
				  if (e.getEntity().getType()==EntityType.PIG) {
					  this.plugin.gainMoneyExp(p,"Breeder",0.02*mult,4*mult);
					  if (this.plugin.getJobLv("Breeder", p)>=10) {
						  if (Math.random()<=0.25 && countamount<50) {
						  Pig newent = (Pig)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.PIG);
						  newent.setBaby();
						  } else
						  if (Math.random()<=0.25 && countamount<50) {
						  Pig newent = (Pig)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.PIG);
						  newent.setBaby();
						  newent = (Pig)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.PIG);
						  newent.setBaby();
						  }
					  }
				  }
				  if (e.getEntity().getType()==EntityType.SHEEP) {
					  this.plugin.gainMoneyExp(p,"Breeder",0.02*mult,4*mult);
					  if (this.plugin.getJobLv("Breeder", p)>=10) {
						  if (Math.random()<=0.25 && countamount<50) {
						  Sheep newent = (Sheep)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.SHEEP);
						  newent.setBaby();
						  newent.setColor(((Sheep)e.getEntity()).getColor());
						  } else
						  if (Math.random()<=0.25 && countamount<50) {
						  Sheep newent = (Sheep)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.SHEEP);
						  newent.setBaby();
						  newent.setColor(((Sheep)e.getEntity()).getColor());
						  newent = (Sheep)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.SHEEP);
						  newent.setBaby();
						  newent.setColor(((Sheep)e.getEntity()).getColor());
						  }
					  }
				  }
				  if (e.getEntity().getType()==EntityType.COW) {
					  this.plugin.gainMoneyExp(p,"Breeder",0.03*mult,4*mult);
					  if (this.plugin.getJobLv("Breeder", p)>=10) {
						  if (Math.random()<=0.25 && countamount<50) {
						  Cow newent = (Cow)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.COW);
						  newent.setBaby();
						  } else
						  if (Math.random()<=0.25 && countamount<50) {
						  Cow newent = (Cow)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.COW);
						  newent.setBaby();
						  newent = (Cow)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.COW);
						  newent.setBaby();
						  }
					  }
				  }
				  if (e.getEntity().getType()==EntityType.OCELOT) {
					  this.plugin.gainMoneyExp(p,"Breeder",0.04*mult,8*mult);
					  if (this.plugin.getJobLv("Breeder", p)>=10) {
						  if (Math.random()<=0.25 && countamount<50) {
						  Ocelot newent = (Ocelot)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.OCELOT);
						  newent.setBaby();
						  newent.setOwner(((Ocelot)e.getEntity()).getOwner());
						  newent.setCatType(((Ocelot)e.getEntity()).getCatType());
						  } else
						  if (Math.random()<=0.25 && countamount<50) {
						  Ocelot newent = (Ocelot)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.OCELOT);
						  newent.setBaby();
						  newent.setOwner(((Ocelot)e.getEntity()).getOwner());
						  newent.setCatType(((Ocelot)e.getEntity()).getCatType());
						  newent = (Ocelot)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.OCELOT);
						  newent.setBaby();
						  newent.setOwner(((Ocelot)e.getEntity()).getOwner());
						  newent.setCatType(((Ocelot)e.getEntity()).getCatType());
						  }
					  }
				  }
				  if (e.getEntity().getType()==EntityType.WOLF) {
					  this.plugin.gainMoneyExp(p,"Breeder",0.06*mult,10*mult);
					  if (this.plugin.getJobLv("Breeder", p)>=10) {
						  if (Math.random()<=0.25 && countamount<50) {
						  Wolf newent = (Wolf)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.WOLF);
						  newent.setBaby();
						  newent.setOwner(((Wolf)e).getOwner());
						  newent.setCollarColor(((Wolf)e.getEntity()).getCollarColor());
						  } else
						  if (Math.random()<=0.25 && countamount<50) {
						  Wolf newent = (Wolf)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.WOLF);
						  newent.setBaby();
						  newent.setOwner(((Wolf)e).getOwner());
						  newent.setCollarColor(((Wolf)e.getEntity()).getCollarColor());
						  newent = (Wolf)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.WOLF);
						  newent.setBaby();
						  newent.setOwner(((Wolf)e).getOwner());
						  newent.setCollarColor(((Wolf)e.getEntity()).getCollarColor());
						  }
					  }
				  }
				  if (e.getEntity().getType()==EntityType.MUSHROOM_COW) {
					  this.plugin.gainMoneyExp(p,"Breeder",0.20*mult,16*mult);
					  if (this.plugin.getJobLv("Breeder", p)>=10) {
						  if (Math.random()<=0.25 && countamount<50) {
						  MushroomCow newent = (MushroomCow)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.MUSHROOM_COW);
						  newent.setBaby();
						  } else
						  if (Math.random()<=0.25 && countamount<50) {
						  MushroomCow newent = (MushroomCow)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.MUSHROOM_COW);
						  newent.setBaby();
						  newent = (MushroomCow)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.MUSHROOM_COW);
						  newent.setBaby();
						  }
					  }
				  }
				  if (e.getEntity().getType()==EntityType.HORSE) {
					  this.plugin.gainMoneyExp(p,"Breeder",0.30*mult,30*mult);
					  if (this.plugin.getJobLv("Breeder", p)>=10) {
						  if (Math.random()<=0.25 && countamount<50) {
						  Horse newent = (Horse)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.HORSE);
						  newent.setBaby();
						  } else
						  if (Math.random()<=0.25 && countamount<50) {
						  Horse newent = (Horse)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.HORSE);
						  newent.setBaby();
						  newent = (Horse)Bukkit.getWorld("world").spawnEntity(e.getLocation(), EntityType.HORSE);
						  newent.setBaby();
						  }
					  }
				  }
			  }
		  }
	  }
  }

  @EventHandler
  public void onBlockBreak(BlockBreakEvent e) {
	  Player p = e.getPlayer();
	  //p.sendMessage("Block broke.");
	  //p.sendMessage("Has name: "+p.getItemInHand().getItemMeta().hasDisplayName());
	  //p.sendMessage("Name is: "+p.getItemInHand().getItemMeta().getDisplayName());
	  int myData=this.plugin.getPlayerDataSlot(p);
	  if (p!=null) {
		  if (e.getBlock().getType()==Material.COMMAND) {
			  e.setCancelled(true);
			  return;
		  }
		  if (e.getBlock().getType()==Material.STONE && p.getLocation().getY()<=50) {
			  //We are mining underground.
			  //Check if we need to spawn Charge Zombie II's.
			  //Find our player data.
			  int pdata_slot=0;
			  for (int i=0;i<this.plugin.playerdata_list.size();i++) {
				  if (this.plugin.playerdata_list.get(i).getPlayer()==p) {
					  pdata_slot=i;
					  break;
				  }
			  }
			  if (this.plugin.playerdata_list.get(pdata_slot).CheckMineStreak()) {
				  //Bukkit.getLogger().info("Spawned Charge Zombie II for a potential strip miner: "+p.getName());
				//Spawn 4 Charge Zombie II's in 4 corners farther off.
					int spread = (int)(Math.random()*10);
					Entity e1=null,e2=null,e3=null,e4=null;
					boolean torch1=false,torch2=false,torch3=false,torch4=false;
					for (int j=5;j>-6;j--) {
	  				for (int k=2;k>-1;k--) {
	      				for (int l=5;l>-6;l--) {
	      					Block b =Bukkit.getWorld("world").getBlockAt(p.getLocation().add(20+j,k,spread+l));
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
	          					Block b =Bukkit.getWorld("world").getBlockAt(p.getLocation().add(10+j,k,spread+l));
	          					if (b.getType()!=Material.BEDROCK && b.getType()!=Material.MOB_SPAWNER && b.getType()!=Material.ENDER_PORTAL && b.getType()!=Material.ENDER_PORTAL_FRAME) {
	          						b.setType(Material.AIR);
	          					}
	          				}
	      				}
	  				}
	  				e1 = Bukkit.getWorld("world").spawnEntity(p.getLocation().add(10,0,spread), EntityType.ZOMBIE);
					}
					torch2=false;
					spread = (int)(Math.random()*10);
					for (int j=5;j>-6;j--) {
	  				for (int k=2;k>-1;k--) {
	      				for (int l=5;l>-6;l--) {
	      					Block b =Bukkit.getWorld("world").getBlockAt(p.getLocation().add(-10+j,k,spread+l));
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
	          					Block b =Bukkit.getWorld("world").getBlockAt(p.getLocation().add(-10+j,k,spread+l));
	          					if (b.getType()!=Material.BEDROCK && b.getType()!=Material.MOB_SPAWNER && b.getType()!=Material.ENDER_PORTAL && b.getType()!=Material.ENDER_PORTAL_FRAME) {
	          						b.setType(Material.AIR);
	          					}
	          				}
	      				}
	  				}
	  				e2 = Bukkit.getWorld("world").spawnEntity(p.getLocation().add(-10,0,spread), EntityType.ZOMBIE);
					}
					spread = (int)(Math.random()*10);
					for (int j=5;j>-6;j--) {
	  				for (int k=2;k>-1;k--) {
	      				for (int l=5;l>-6;l--) {
	      					Block b =Bukkit.getWorld("world").getBlockAt(p.getLocation().add(spread+j,k,10+l));
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
		        					Block b =Bukkit.getWorld("world").getBlockAt(p.getLocation().add(spread+j,k,10+l));
		        					if (b.getType()!=Material.BEDROCK && b.getType()!=Material.MOB_SPAWNER && b.getType()!=Material.ENDER_PORTAL && b.getType()!=Material.ENDER_PORTAL_FRAME) {
		        						b.setType(Material.AIR);
		        					}
		        				}
		    				}
						}
						e3 = Bukkit.getWorld("world").spawnEntity(p.getLocation().add(spread,0,10), EntityType.ZOMBIE);
					}
					spread = (int)(Math.random()*10);
					for (int j=5;j>-6;j--) {
	  				for (int k=2;k>-1;k--) {
	      				for (int l=5;l>-6;l--) {
	      					Block b =Bukkit.getWorld("world").getBlockAt(p.getLocation().add(spread+j,k,-10+l));
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
	          					Block b =Bukkit.getWorld("world").getBlockAt(p.getLocation().add(spread+j,k,-10+l));
	          					if (b.getType()!=Material.BEDROCK && b.getType()!=Material.MOB_SPAWNER && b.getType()!=Material.ENDER_PORTAL && b.getType()!=Material.ENDER_PORTAL_FRAME) {
	          						b.setType(Material.AIR);
	          					}
	          				}
	      				}
	  				}
	  				e4 = Bukkit.getWorld("world").spawnEntity(p.getLocation().add(spread,0,-20), EntityType.ZOMBIE);
					}
					if (!torch1) {
	  				Zombie z1 = (Zombie)e1;
	  				z1.setCustomName(ChatColor.GOLD+"Charge Zombie II");
	  				z1.setCustomNameVisible(false);
	  				z1.setTarget(p);
					}
					if (!torch2) {
	  				Zombie z2 = (Zombie)e2;
	  				z2.setCustomName(ChatColor.GOLD+"Charge Zombie II");
	  				z2.setCustomNameVisible(false);
	  				z2.setTarget(p);
					}
					if (!torch3) {
	  				Zombie z3 = (Zombie)e3;
	  				z3.setCustomName(ChatColor.GOLD+"Charge Zombie II");
	  				z3.setCustomNameVisible(false);
	  				z3.setTarget(p);
					}
					if (!torch4) {
	  				Zombie z4 = (Zombie)e4;
	  				z4.setCustomName(ChatColor.GOLD+"Charge Zombie II");
	  				z4.setCustomNameVisible(false);
	  				z4.setTarget(p);
					}
			  }
		  }
		  if (e.getBlock().getType()==Material.EMERALD_ORE ||
				  e.getBlock().getType()==Material.DIAMOND_ORE ||
				  e.getBlock().getType()==Material.GOLD_ORE ||
				  e.getBlock().getType()==Material.IRON_ORE) {
			  /*
			  if (Math.random()<=0.01) {
				//1% chance of getting a book.
				  ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
				    BookMeta bookdata = (BookMeta)book.getItemMeta();
				    int choosebook = (int)(Math.random()*9.0d);
				    switch (choosebook) {
					    case 0:{
						    bookdata.setAuthor("Steve");
						    bookdata.setTitle("Dangers of the Nether");
						    bookdata.addPage("Dangers of the Nether\n"+ChatColor.ITALIC+"  by Steve\n======\n"+ChatColor.RESET+"It didn't take me long to realize where we were. It was dangerous, very hot, and lots of torturous screams could be heard everywhere. I barely had time","to take it all in before a huge fireball was shot in my direction. I quickly looked to my side to find a convenient safe passage and hid there for a few minutes. I guess I was in there longer than I thought, I ended","up falling asleep and waking up to notice there was something scary on the wall.\n\n"+ChatColor.ITALIC+"\"TURN AND LEAVE NOW. DANGEROUS TO STAY. REAL WORLD HAS WHAT YOU ARE LOOKING FOR. I ONLY REMEMBER THE 1ST X POSITION...",ChatColor.ITALIC+"...IT WAS 7! I AM *POSITIVE*\""+ChatColor.RESET+"\n\nI did not know what to think. The 1st X position? I quickly remembered the 7 and sprinted out of the nether portal. And to think that was *THE END* of my adventures...");
					    }break;
					    case 1:{
					    	bookdata.setAuthor("Lacey");
					    	bookdata.setTitle("A Hole in the Flower Garden");
					    	bookdata.addPage("A Hole in the Flower Garden\n"+ChatColor.ITALIC+"  by Lacey\n======\n"+ChatColor.RESET+"It was a lovely day to pick flowers in the garden, they just finished blooming fully. I was so excited to pick them, but I didn't do so until","after I've taken in all the wonderful scents! Smelling all the flowers and wonderful smells of plants and trees and nature and grass. It was perfect. I was mindlessly walking along this prairie when I stumbled.","I fell, and fell, and fell. I hit the bottom of a ravine. It didn't even occur to me I would just walk into one. I took some minor damage, but when I got up, I noticed something strange.","There were two or three zombies gathered around a wall, etching something into it. I went over to read it once the zombies walked away. I saw on the wall:\n\n"+ChatColor.ITALIC+"X-2:6 <--END","It looked cryptic to me, but why would they write that on the wall? I quickly scribbled it down on a notepad I had in my pocket and started climbing out of the ravine to tend to my lovely flowers. What a day!");
					    }break;
					    case 2:{
					    	bookdata.setAuthor("Jimmy");
					    	bookdata.setTitle("Messages in Music");
					    	bookdata.addPage("Messages in Music\n"+ChatColor.ITALIC+"  by Jim"+"\n======"+ChatColor.RESET+"\nI popped out the disk from my Jukebox to put in another, I could jam to these all day! As I was looking through my collection for something to listen to","I found a really bent up disk. 'No way this could still play', I thought to myself. I put it in, and it crackled and snarled, but it was indeed playing! At first I heard some faint resemblence of music, but then suddenly,","a hiss, an explosion, and then 'CREEEEEEEEE----- 7X XSSSSSSSSSS 3RD EEEEEEE' mental images appeared in my head, but the 7X and 3RD stood out the most. It's like I was seeing them in my head while hearing something else!","I couldn't stand up anymore, or think. I forcibly reached up with my weak hand to find the eject button on the player and when I found the familiar nub in the button, pressed down on it and out popped the disk, hitting my face,","but putting me back into reality. Something was telling me that the 3RD and 7X was important. But I couldn't quite put my tongue on it.");
					    }break;
					    case 3:{
					    	bookdata.setAuthor("Creeper");
					    	bookdata.setTitle("HISS");
					    	bookdata.addPage("Y do i exisssst. nobody knowssss. i just want a hugssssss, HUGSSSSSSS. but i don't know Y i exist. there's no Y in the first position. it'sssss jusssst two digitssssss.... SSSSSSSSS. *THE END*");
					    }break;
					    case 4:{
					    	bookdata.setAuthor("Marco");
					    	bookdata.setTitle("The Hunt for a Dragon");
					    	bookdata.addPage("The Hunt for a Dragon\n"+ChatColor.ITALIC+"  by Marco"+"\n======"+ChatColor.RESET+"\nThere exists a rumor that a mythical dragon could be found in the depths of our world. It is even said he doesn't exist in OUR world, but ANOTHER world altogether!","That my friends already boggles me, but where the heck would I go to find it then? I have been told he exists, and I know he is. I believe deep in my heart. I searched day and night under and over ground.","One day I found something strange in the ground. It was pink wool, in the middle of a cave on the ground. It even said something, but I couldn't tell from so close up. So I literally dug all the way to the surface, keeping the boundaries","of that word uncovered the whole way up. When I got to the top and looked down, I was relieved to find it was made out of markings I could discern. It said: 'Y: X3?' It was definitely a weird group of symbols, but I have a strong feeling"," that it is directly linked with that dragon I am trying to hunt down. Maybe I can gather more clues and try to decipher the location of this thing.");
					    }break;
					    case 5:{
					    	bookdata.setAuthor("Steve");
					    	bookdata.setTitle("Cooking Food");
					    	bookdata.addPage("Cooking Food\n"+ChatColor.ITALIC+"  by Steve"+"\n======"+ChatColor.RESET+"\nIt was a bright and rather typical sunny day in the Minecraft world. I don't actually think it was very hot either. I just managed to catch a few fish and was cooking them up.","It wasn't long before I got distracted and heard a funny noise. It was an ocelote. Lucky me, an ocelote has smelled the scent of my fish! I grab a few and hold it out for the ocelote. It slowly creeps over, and then takes it and runs from me.","I thought it was full and finished cooking the rest of the fish. However, the ocelote returned a few minutes later with a neatly-folded piece of paper in its mouth. It came up to me and set it down, like it was some message just for me.","I opened it up and it read:\n\n"+ChatColor.ITALIC+"Don't let the fish get to your tongue! If you know what's wise, you will investigate further. The 3rd position of Y being the number 5."+ChatColor.RESET+"\n\n","I didn't notice the ocelote run away, but I knew something FISHY was going on. That message seemed important for some reason, I've seen similar cryptic messages before... Perhaps I'll hold onto this in case I need it in the future.");
					    }break;
					    case 6:{
					    	bookdata.setAuthor("Fredric");
					    	bookdata.setTitle("Math Behind the Void");
					    	bookdata.addPage("Math Behind the Void\n"+ChatColor.ITALIC+"  by Fredric"+"\n======"+ChatColor.RESET+"\nThis book describes a few principles that the void in this world follows. While no one has actually seen the void, we have found a few theories and rules regarding them.","1. The Void has a Light Level of -14. The Void actually absorbs light coming from light sources and thus, if The Void is ever opened to the real world, would suck up the light from it.","2. The Void always has a volume of 50,000m, being 50m x 20m x 50m. This means that The Void, regardless of location is always the same exact size. This would conclude to us that The Void is co-existing and multiple instaces of it may exist in the same realm.","3. Any Entity entering The Void will not be able to escape The Void as time passes much more quickly inside The Void. This means Entities that enter The Void feel accelerated processes and cannot combat it, since the time outside is behind them.","4. A point of connection between The Void and other dimensions has to exist, for The Void to exist. Speculation has it that one of these points has been leaked into the world, and is accessible by us directly. After further research,","we have learned that one of these points is located on the 1st respective numeral along our Z axis with the number 4. It has also been proven that this number has to be negative as the other two sources interacting with The Void are positive.");
					    }break;
					    case 7:{
					    	bookdata.setAuthor("Robert");
					    	bookdata.setTitle("TNT");
					    	bookdata.addPage("TNT\n"+ChatColor.ITALIC+"  by Robert"+"\n======"+ChatColor.RESET+"\nYou know, the easiest way to clear a tunnel is using an item called TNT. It is a rather small block, but it is loaded with gunpowder. When lit by an external force, it ignites","with the force of 5 Creeper explosions to clear whole caves out. Well lo and behold one day I discovered a rather strange abandoned mineshaft. It wasn't normal for sure, because there were green vines everywhere and lots of strange doors.","It was like somebody lived here ages ago, and I am discovering the ruins of such a place. Inoperable levers, a few mobs I have to kill here and there that have made this area their designated home. It was a mess. But I did discover that","someone was trying to find what we would call 'The End'. It's a magical place, and I believe with the right amount of effort, we can find it someday too. He had scribbled the coordinates of the location he was trying to reach.","However, most of it is faded out and I can only tell faintly the remains of it: \n\n"+ChatColor.ITALIC+"X:---\nY:---\nZ:--7-"+ChatColor.RESET+"\n\nYep, that's about it.","Hopefully by me recording this data, someone else can fill in the remaining numbers and we can all find The End together. Someday...");
					    }break;
					    case 8:{
					    	bookdata.setAuthor("Joshua");
					    	bookdata.setTitle("Fourside");
					    	bookdata.addPage("Fourside\n"+ChatColor.ITALIC+"  by Joshua"+"\n======"+ChatColor.RESET+"\n"+ChatColor.DARK_BLUE+"ABANDONED PROJECT"+ChatColor.RESET+". A city that would be developed with the best technology and the highest standards. It would","succeed every single Minecraft city that has ever been built. Casinos, diamond-lined walkways, towering skyscrapers as far as the eye can see. Museums, Libraries, Educational Institutions. This mega-city would be able to hold","and sustain every single Minecrafter in existence. But no, something went terribly wrong. Our engineering team finally developed the perfect transportation system and we were wiring it up to our fusion power plant.","Something went horribly wrong. The Fusion power plant started self-combusting itself, leaving behind hyper-cold atoms. This caused nucleic waste to interact with the environment around itself and freezing the whole world as we knew it.","The city idea as we knew it was scrapped, and we would wait 2000 years before we could attempt this again. We wrote plans for a much more portable solution and have named it 'Twoside' and archived it appropriately.","Maybe someone will pick up that book and be able to make the future bright with a mini version of Fourside. That being said, we left the 3rd slot of the Z position of our city at 7. This should give you enough clue as to where NOT to build.");
					    }break;
				    }
				    book.setItemMeta(bookdata);
				    //p.setItemInHand(book);
				    p.getInventory().addItem(book);
				    p.updateInventory();
				    p.sendMessage(ChatColor.LIGHT_PURPLE+"You feel a magical presence get inserted into your inventory.");
			  }*/
		  }
		  if (this.plugin.PlayerinJob(p, "Builder")) {
			  this.plugin.playerdata_list.get(myData).BadInteract(e.getBlock().getType());
		  }
		  if (this.plugin.PlayerinJob(p, "Woodcutter")) {
			  if (e.getBlock().getType()==Material.LOG) {
				  if (p.getItemInHand().getType()==Material.WOOD_AXE || p.getItemInHand().getType()==Material.STONE_AXE || p.getItemInHand().getType()==Material.IRON_AXE || p.getItemInHand().getType()==Material.GOLD_AXE || p.getItemInHand().getType()==Material.DIAMOND_AXE) {
					  //p.sendMessage("Cut down wood w/axe.");
					  this.plugin.gainMoneyExp(p,"Woodcutter",0.025,2);
				  } else {
					  //p.sendMessage("Cut down wood.");
					  this.plugin.gainMoneyExp(p,"Woodcutter",0.01,1);
				  }
			  }
		  }
		  if (this.plugin.PlayerinJob(p, "Miner")) {
			  if (this.plugin.getJobLv("Miner", p)>=10) {
				  //Half chance to set the durability back by one.
				  if (p.getItemInHand().getType()==Material.WOOD_PICKAXE ||
						  p.getItemInHand().getType()==Material.STONE_PICKAXE ||
						  p.getItemInHand().getType()==Material.GOLD_PICKAXE ||
						  p.getItemInHand().getType()==Material.IRON_PICKAXE ||
						  p.getItemInHand().getType()==Material.DIAMOND_PICKAXE) {
					  if (p.getItemInHand().getDurability()>0) {
						  if (Math.random()>=0.5) {
							  p.getItemInHand().setDurability((short)(p.getItemInHand().getDurability()-1));
							  p.updateInventory();
						  }
					  }
				  }
			  }
			  boolean has_silktouch=false;
			  if (!p.getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
				  has_silktouch=false;
			  } else {
				  has_silktouch=true;
			  }
			  if (this.plugin.playerdata_list.get(myData).GoodInteract()) {
				  if (e.getBlock().getType()==Material.STONE) {
					  this.plugin.gainMoneyExp(p,"Miner",0.0025,1);
				  } else
				  if (e.getBlock().getType()==Material.NETHERRACK) {
					  this.plugin.gainMoneyExp(p,"Miner",0.005,1);
				  } else
				  if (e.getBlock().getType()==Material.COAL_ORE && !has_silktouch) {
					  this.plugin.gainMoneyExp(p,"Miner",0.0125,3);
				  } else
				  if (e.getBlock().getType()==Material.GLOWSTONE && !has_silktouch) {
					  this.plugin.gainMoneyExp(p,"Miner",0.015,3);
				  } else
				  if (e.getBlock().getType()==Material.SANDSTONE) {
					  this.plugin.gainMoneyExp(p,"Miner",0.015,4);
				  } else
				  if (e.getBlock().getType()==Material.NETHER_BRICK) {
					  this.plugin.gainMoneyExp(p,"Miner",0.02,3);
				  } else
				  if (e.getBlock().getType()==Material.QUARTZ_ORE && !has_silktouch) {
					  this.plugin.gainMoneyExp(p,"Miner",0.025,4);
				  } else
				  if (e.getBlock().getType()==Material.LAPIS_ORE && !has_silktouch) {
					  this.plugin.gainMoneyExp(p,"Miner",0.03,5);
				  } else
				  if (e.getBlock().getType()==Material.MOSSY_COBBLESTONE) {
					  this.plugin.gainMoneyExp(p,"Miner",0.0375,8);
				  } else
				  if (e.getBlock().getType()==Material.IRON_ORE && !has_silktouch) {
					  this.plugin.gainMoneyExp(p,"Miner",0.0375,6);
				  } else
				  if ((e.getBlock().getType()==Material.REDSTONE_ORE || e.getBlock().getType()==Material.GLOWING_REDSTONE_ORE) && !has_silktouch) {
					  this.plugin.gainMoneyExp(p,"Miner",0.05,9);
				  } else
				  if (e.getBlock().getType()==Material.OBSIDIAN) {
					  this.plugin.gainMoneyExp(p,"Miner",0.0625,10);
				  } else
				  if (e.getBlock().getType()==Material.GOLD_ORE && !has_silktouch) {
					  this.plugin.gainMoneyExp(p,"Miner",0.0975,12);
				  } else
				  if (e.getBlock().getType()==Material.DIAMOND_ORE && !has_silktouch) {
					  this.plugin.gainMoneyExp(p,"Miner",0.3125,60);
				  } else
				  if (e.getBlock().getType()==Material.EMERALD_ORE && !has_silktouch) {
					  this.plugin.gainMoneyExp(p,"Miner",0.7625,160);
				  }
			  }
		  }
		  if (this.plugin.PlayerinJob(p, "Digger")) {
			  if (this.plugin.getJobLv("Digger", p)>=20) {
				  //Half chance to set the durability back by one.
				  if (p.getItemInHand().getType()==Material.WOOD_SPADE ||
						  p.getItemInHand().getType()==Material.STONE_SPADE ||
						  p.getItemInHand().getType()==Material.GOLD_SPADE ||
						  p.getItemInHand().getType()==Material.IRON_SPADE ||
						  p.getItemInHand().getType()==Material.DIAMOND_SPADE) {
					  if (p.getItemInHand().getDurability()>0) {
						  if (Math.random()>=0.66) {
							  p.getItemInHand().setDurability((short)(p.getItemInHand().getDurability()-1));
							  p.updateInventory();
						  }
					  }
				  }
			  } else
			  if (this.plugin.getJobLv("Digger", p)>=10) {
				  //Half chance to set the durability back by one.
				  if (p.getItemInHand().getType()==Material.WOOD_SPADE ||
						  p.getItemInHand().getType()==Material.STONE_SPADE ||
						  p.getItemInHand().getType()==Material.GOLD_SPADE ||
						  p.getItemInHand().getType()==Material.IRON_SPADE ||
						  p.getItemInHand().getType()==Material.DIAMOND_SPADE) {
					  if (p.getItemInHand().getDurability()>0) {
						  if (Math.random()>=0.5) {
							  p.getItemInHand().setDurability((short)(p.getItemInHand().getDurability()-1));
							  p.updateInventory();
						  }
					  }
				  }
			  }
			  if (this.plugin.playerdata_list.get(myData).GoodInteract()) {
				  if (e.getBlock().getType()==Material.DIRT) {
					  this.plugin.gainMoneyExp(p,"Digger",0.005,1);
				  }
				  if (e.getBlock().getType()==Material.GRASS) {
					  this.plugin.gainMoneyExp(p,"Digger",0.005,2);
				  }
				  if (e.getBlock().getType()==Material.SAND) {
					  this.plugin.gainMoneyExp(p,"Digger",0.01,2);
				  }
				  if (e.getBlock().getType()==Material.GRAVEL) {
					  this.plugin.gainMoneyExp(p,"Digger",0.02,5);
				  }
				  if (e.getBlock().getType()==Material.SOUL_SAND) {
					  this.plugin.gainMoneyExp(p,"Digger",0.04,8);
				  }
				  if (e.getBlock().getType()==Material.CLAY) {
					  this.plugin.gainMoneyExp(p,"Digger",0.05,10);
				  }
			  }
		  }
		  //p.sendMessage("You broke the "+e.getBlock().getType()+", Data: "+e.getBlock().getData());
		  if (this.plugin.PlayerinJob(p, "Farmer")) {
			  if (e.getBlock().getType()==Material.SUGAR_CANE_BLOCK) {
				  this.plugin.gainMoneyExp(p,"Farmer",0.00,1);
			  }
			  if (e.getBlock().getType()==Material.CROPS && e.getBlock().getData()==7) {
				  this.plugin.gainMoneyExp(p,"Farmer",0.01,2);
			  }
			  if (e.getBlock().getType()==Material.CARROT && e.getBlock().getData()==7) {
				  this.plugin.gainMoneyExp(p,"Farmer",0.01,2);
			  }
			  if (e.getBlock().getType()==Material.CACTUS) {
				  this.plugin.gainMoneyExp(p,"Farmer",0.00,3);
			  }
			  if (e.getBlock().getType()==Material.POTATO && e.getBlock().getData()==7) {
				  this.plugin.gainMoneyExp(p,"Farmer",0.03,3);
			  }
			  if (e.getBlock().getType()==Material.BROWN_MUSHROOM) {
				  this.plugin.gainMoneyExp(p,"Farmer",0.00,3);
			  }
			  if (e.getBlock().getType()==Material.RED_MUSHROOM) {
				  this.plugin.gainMoneyExp(p,"Farmer",0.00,3);
			  }
			  if (e.getBlock().getType()==Material.NETHER_WARTS && e.getBlock().getData()==3) {
				  this.plugin.gainMoneyExp(p,"Farmer",0.03,3);
			  }
			  /*if (e.getBlock().getType()==Material.PUMPKIN) {
				  this.plugin.gainMoneyExp(p,"Farmer",0.00,1);
			  }*/
			  if (e.getBlock().getType()==Material.MELON_BLOCK) {
				  this.plugin.gainMoneyExp(p,"Farmer",0.10,10);
			  }
		  }
		  boolean hasfortune;
		  hasfortune = (p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS)>0)?true:false;
		  //Check blocks around it. If it's a spawner, it's protected until the spawner is destroyed.
		  for (int x=-4;x<4;x++) {
			  for (int y=0;y<2;y++) {
				  for (int z=-4;z<4;z++) {
					  if ((x!=0 || y!=0 || z!=0) && p.getWorld().getBlockAt(e.getBlock().getLocation().add(x,y,z)).getType()==Material.MOB_SPAWNER && e.getBlock().getType()!=Material.MOB_SPAWNER) {
						  e.setCancelled(true);
						  p.sendMessage("A Mob Spawner force field protects this block from being destroyed.");
					  }
				  }
			  }
		  }
		  if (e.getBlock().getType()==Material.IRON_ORE) {
			  e.setExpToDrop(1);
		  }
		  if (e.getBlock().getType()==Material.GOLD_ORE) {
			  e.setExpToDrop(1);
		  }
		  if (e.getBlock().getType()==Material.REDSTONE_ORE) {
			  e.setExpToDrop(3);
		  }
		  if (e.getBlock().getType()==Material.LAPIS_ORE) {
			  e.setExpToDrop(3);
		  }
		  if (e.getBlock().getType()==Material.DIAMOND_ORE) {
			  e.setExpToDrop(12);
		  }
		  if (e.getBlock().getType()==Material.EMERALD_ORE) {
			  e.setExpToDrop(28);
		  }
		  if (e.getBlock().getType()==Material.MOB_SPAWNER) {
			  p.setLevel(p.getLevel()+30);
			try {
				Iterator<PotionEffect> effects = p.getActivePotionEffects().iterator();
					//Figure out potion effects when player joins.
					while (effects.hasNext()) {
						PotionEffect nexteffect = effects.next();
						if (nexteffect.getType().getName().compareTo(PotionEffectType.SPEED.getName())==0) {
							p.removePotionEffect(PotionEffectType.SPEED);
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 360000, nexteffect.getAmplifier()+2, true));
						}
						if (nexteffect.getType().getName().compareTo(PotionEffectType.HEALTH_BOOST.getName())==0) {
							p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
							p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 360000, nexteffect.getAmplifier()+1, true));
						}
						/*if (nexteffect.getType().getName().compareTo(PotionEffectType.JUMP.getName())==0) {
							p.removePotionEffect(PotionEffectType.JUMP);
							p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 360000, nexteffect.getAmplifier()+2, true));
						}*/
						effects.remove();
					}

			  } catch (ConcurrentModificationException ex_e) {
				  Bukkit.getLogger().warning("Potion Effect Collection not accessible while initializing player speed.");
			  }
			p.removePotionEffect(PotionEffectType.WATER_BREATHING);
			p.removePotionEffect(PotionEffectType.FAST_DIGGING);
			p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
			//p.removePotionEffect(PotionEffectType.NIGHT_VISION);
			  p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 360000, 1, true));
			  p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 360000, 0, true));
			  p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 360000, 0, true));
			  p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 360000, 0, true));
			  //p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 360000, 0, true));
			  //p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 360000, 1, true));
			  p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 360000, 1, true));
		  }
		  if ((e.getBlock().getX()==1616 && e.getBlock().getZ()>=53 && e.getBlock().getZ()<=64) || (e.getBlock().getX()==1627 && e.getBlock().getZ()>=53 && e.getBlock().getZ()<=64) || (e.getBlock().getZ()==53 && e.getBlock().getX()>=1616 && e.getBlock().getX()<=1627) || (e.getBlock().getZ()==64 && e.getBlock().getX()>=1616 && e.getBlock().getX()<=1627)) {
			  e.setCancelled(true);
		  }
		  if ((e.getBlock().getX()==1585 && e.getBlock().getZ()>=24 && e.getBlock().getZ()<=39) || (e.getBlock().getX()==1600 && e.getBlock().getZ()>=24 && e.getBlock().getZ()<=39) || (e.getBlock().getZ()==24 && e.getBlock().getX()>=1585 && e.getBlock().getX()<=1600) || (e.getBlock().getZ()==39 && e.getBlock().getX()>=1585 && e.getBlock().getX()<=1600)) {
			  e.setCancelled(true);
		  }
		  if (this.plugin.getConfig().getBoolean("spleefinsession")==true && (this.plugin.getConfig().getString("spleefrequestaplayer").compareTo(p.getName())==0 || this.plugin.getConfig().getString("spleefrequestbplayer").compareTo(p.getName())==0)) {
			  this.plugin.spleef_last_broken_block=p.getPlayerTime();
		  }
		  if (this.plugin.getConfig().getBoolean("spleef4insession")==true && (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName())==0 || this.plugin.getConfig().getString("spleefrequestb4player").compareTo(p.getName())==0 || this.plugin.getConfig().getString("spleefrequestc4player").compareTo(p.getName())==0 || this.plugin.getConfig().getString("spleefrequestd4player").compareTo(p.getName())==0)) {
			  this.plugin.spleef4_last_broken_block=p.getPlayerTime();
		  }
		  if (p.getItemInHand()!=null && p.getItemInHand().getItemMeta()!=null && p.getItemInHand().getItemMeta().hasDisplayName()==true && p.getItemInHand().getItemMeta().getDisplayName().compareTo("Spleef Wooden Shovel")==0) {
			  p.getItemInHand().setDurability((short)0);
			  //p.sendMessage("Got in.");
			  p.updateInventory();
		  }
		  if (p.getItemInHand()!=null && p.getItemInHand().getItemMeta()!=null && p.getItemInHand().getItemMeta().hasDisplayName()==true && p.getItemInHand().getItemMeta().getDisplayName().compareTo("Spleef Stone Shovel")==0) {
			  p.getItemInHand().setDurability((short)0);
			  //p.sendMessage("Got in.");
			  p.updateInventory();
		  }
	  }
	  return;
  }
  
  @EventHandler
  public void onItemDrop(PlayerDropItemEvent e) {
	  //If the player is a support, drop it with only 1 second of wait time.
	  Player p = e.getPlayer();
	  if (this.plugin.PlayerinJob(p, "Support")) {
		  //This item drops with half the pickup speed of normal items.
		  e.getItemDrop().setPickupDelay(20);
		  this.plugin.supportstackslist.add(e.getItemDrop());
	  }
  }
  
  @EventHandler
  public void onItemPickup(PlayerPickupItemEvent e) {
	  Player p = e.getPlayer();
	  if (this.plugin.supportstackslist.contains(e.getItem())) {
		  boolean alreadyhas=false;
		  for (int i=0;i<p.getInventory().getSize();i++) {
			  if (p.getInventory().getContents()[i]!=null) {
				  if (p.getInventory().getContents()[i].getType()==this.plugin.supportstackslist.get(this.plugin.supportstackslist.indexOf(e.getItem())).getItemStack().getType()) {
					  //Bukkit.getPlayer("sigonasr2").sendMessage("Player had this item.");
					  alreadyhas=true;
				  }
				  //Bukkit.getPlayer("sigonasr2").sendMessage("Item "+p.getInventory().getContents()[i].getType());
			  }
		  }
		  //p.sendMessage("This was from a support.");
		  //Make sure we're not a support.
		  if (!this.plugin.PlayerinJob(p, "Support")) {
			  //Give credit to the nearest support to this player who did this.
			  Player support = this.plugin.getClosestSupport(p.getLocation());
			  if (support!=null) {
				  if (!alreadyhas) {
					  this.plugin.gainMoneyExp(support,"Support",1.05,90);
				  } else {
					  this.plugin.gainMoneyExp(support,"Support",0.01,1);
				  }
			  }
		  }
		  this.plugin.supportstackslist.remove(e.getItem());
	  }
  }
  
  @EventHandler
  public void onPotionConsume(PlayerItemConsumeEvent e) {
	  final Player p = e.getPlayer();
	  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
	      @Override
	      public void run() {
	    	  p.getScoreboard().getTeam(p.getName()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth()));
	      }
	  	},5);
	  if (e.getItem().getType()==Material.POTION) {
		  //p.sendMessage("This is the data: "+e.getItem().getData());
		  Potion pot = Potion.fromDamage(e.getItem().getData().getData());
		  if (pot.getType()==PotionType.SPEED) {
			  //p.sendMessage("This is a speed "+pot.getLevel()+" potion.");
			  for (int i=0;i<this.plugin.SPEED_CONTROL.size();i++) {
				  if (this.plugin.SPEED_CONTROL.get(i).p.getName().compareTo(p.getName())==0) {
					  this.plugin.SPEED_CONTROL.get(i).potion_spdlv=pot.getLevel();
					  if (pot.hasExtendedDuration()) {
						  this.plugin.SPEED_CONTROL.get(i).potion_time=Bukkit.getWorld("world").getFullTime()+4800;
					  } else {
						  if (pot.getLevel()==1) {
							  this.plugin.SPEED_CONTROL.get(i).potion_time=Bukkit.getWorld("world").getFullTime()+2400;
						  } else {
							  this.plugin.SPEED_CONTROL.get(i).potion_time=Bukkit.getWorld("world").getFullTime()+1200;
						  }
					  }
					  this.plugin.SPEED_CONTROL.get(i).updatePlayerSpd();
					  break;
				  }
			  }
		  }

		  if (pot.getType()==PotionType.INSTANT_HEAL) {
			  if (!p.isDead()) {
				  if (p.getHealth()+24>p.getMaxHealth()) {
					  p.setHealth(p.getMaxHealth());
				  } else {
					  p.setHealth(p.getHealth()+24);
				  }
			  }
		  }
	  }
  }
  
  @EventHandler
  public void onPotionSplash(PotionSplashEvent e) {
	  try {
		  Iterator<LivingEntity> entities = e.getAffectedEntities().iterator();
		  Player shooter;
		  if (e.getPotion().getShooter().getType() == EntityType.PLAYER) {
			  shooter=(Player)e.getPotion().getShooter();
			  if (this.plugin.PlayerinJob(shooter,"Support")) {
				  //Bukkit.getPlayer("sigonasr2").sendMessage("Shooter is "+shooter.getName());
				  while (entities.hasNext()) {
					  LivingEntity next = entities.next();
					  if (next.getType() == EntityType.PLAYER) {
						  final Player p = (Player)next;
						  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
						      @Override
						      public void run() {
						    	  p.getScoreboard().getTeam(p.getName()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth()));
						      }
						  	},5);
						  if (p!=shooter) {
							  //Award the support.
							  //Bukkit.getPlayer("sigonasr2").sendMessage(p.getName()+" got hit by your potion!");
							  //Iterator<PotionEffect> effects = e.getPotion().getEffects().iterator();
							  try {
								  Collection<PotionEffect> effects = e.getPotion().getEffects();
								  for (PotionEffect nextpotioneffect : effects) {
									  //shooter.sendMessage(nextpotioneffect.getType().getName()+" is the potion effect.");
									  if (nextpotioneffect.getType().getName().compareTo("NIGHT_VISION")==0) {
										  //this.plugin.gainMoneyExp(shooter,"Support",0.10,5);
									  }
									  if (nextpotioneffect.getType().getName().compareTo("SPEED")==0) {
										  this.plugin.gainMoneyExp(shooter,"Support",0.15,6);
										  for (int i=0;i<this.plugin.SPEED_CONTROL.size();i++) {
											  if (this.plugin.SPEED_CONTROL.get(i).p.getName().compareTo(p.getName())==0) {
												  this.plugin.SPEED_CONTROL.get(i).potion_spdlv=nextpotioneffect.getAmplifier();
												  this.plugin.SPEED_CONTROL.get(i).potion_time=Bukkit.getWorld("world").getFullTime()+nextpotioneffect.getDuration();
												  this.plugin.SPEED_CONTROL.get(i).updatePlayerSpd();
											  }
										  }
									  }
									  if (nextpotioneffect.getType().getName().compareTo("INCREASE_DAMAGE")==0) {
										  //this.plugin.gainMoneyExp(shooter,"Support",0.20,9);
									  }
									  if (nextpotioneffect.getType().getName().compareTo("FIRE_RESISTANCE")==0) {
										  if (p.getFireTicks()>0) {
											  this.plugin.gainMoneyExp(shooter,"Support",4.80,240);
										  }
										  //this.plugin.gainMoneyExp(shooter,"Support",0.25,12);
									  }
									  if (nextpotioneffect.getType().getName().compareTo("HEAL")==0) {
										  if (!p.isDead()) {
											  if (p.getHealth()/p.getMaxHealth()<=0.30) {
												  this.plugin.gainMoneyExp(shooter,"Support",2.40,120);
												  //shooter.sendMessage("This is a big heal.");
												  p.getScoreboard().getTeam(p.getName()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth()));
											  }
											  //this.plugin.gainMoneyExp(shooter,"Support",0.30,14);
											  if (p.getHealth()+12>p.getMaxHealth()) {
												  p.setHealth(p.getMaxHealth());
											  } else {
												  p.setHealth(p.getHealth()+12);
											  }
											  //shooter.sendMessage("This is a heal.");
										  }
									  }
									  if (nextpotioneffect.getType().getName().compareTo("REGENERATION")==0) {
										  if (p.getHealth()/p.getMaxHealth()<=0.30) {
											  //this.plugin.gainMoneyExp(shooter,"Support",0.60,30);
										  }
										  //this.plugin.gainMoneyExp(shooter,"Support",0.30,14);
										  //shooter.sendMessage("This is a heal.");
									  }
								  }
							  } catch (ConcurrentModificationException ex_e) {
								  Bukkit.getLogger().warning("Potion Effect Collection not accessible for a support while attempting a splash potion.");
							  }
							  /*while (effects.hasNext()) {
								  PotionEffect nextpotioneffect = effects.next();
								  shooter.sendMessage(nextpotioneffect.getType().getName()+" is the potion effect.");
								  if (nextpotioneffect.getType().getName().compareTo("NIGHT_VISION")==0) {
									  this.plugin.gainMoneyExp(shooter,"Support",0.10,5);
								  }
								  if (nextpotioneffect.getType().getName().compareTo("SPEED")==0) {
									  this.plugin.gainMoneyExp(shooter,"Support",0.15,6);
									  for (int i=0;i<this.plugin.SPEED_CONTROL.size();i++) {
										  if (this.plugin.SPEED_CONTROL.get(i).p.getName().compareTo(p.getName())==0) {
											  this.plugin.SPEED_CONTROL.get(i).potion_spdlv=nextpotioneffect.getAmplifier();
											  this.plugin.SPEED_CONTROL.get(i).potion_time=Bukkit.getWorld("world").getFullTime()+nextpotioneffect.getDuration();
											  this.plugin.SPEED_CONTROL.get(i).updatePlayerSpd();
										  }
									  }
								  }
								  if (nextpotioneffect.getType().getName().compareTo("INCREASE_DAMAGE")==0) {
									  this.plugin.gainMoneyExp(shooter,"Support",0.20,9);
								  }
								  if (nextpotioneffect.getType().getName().compareTo("FIRE_RESISTANCE")==0) {
									  if (p.getFireTicks()>0) {
										  this.plugin.gainMoneyExp(shooter,"Support",0.60,30);
									  }
									  this.plugin.gainMoneyExp(shooter,"Support",0.25,12);
								  }
								  if (nextpotioneffect.getType().getName().compareTo("HEAL")==0) {
									  if (p.getHealth()<=8) {
										  this.plugin.gainMoneyExp(shooter,"Support",0.60,30);
										  shooter.sendMessage("This is a big heal.");
									  }
									  this.plugin.gainMoneyExp(shooter,"Support",0.30,14);
									  shooter.sendMessage("This is a heal.");
								  }
								  if (nextpotioneffect.getType().getName().compareTo("REGENERATION")==0) {
									  if (p.getHealth()<=8) {
										  this.plugin.gainMoneyExp(shooter,"Support",0.60,30);
									  }
									  this.plugin.gainMoneyExp(shooter,"Support",0.30,14);
									  //shooter.sendMessage("This is a heal.");
								  }
								  effects.remove();
							  }
							  */
						  } else {
							  try {
								  Collection<PotionEffect> effects = e.getPotion().getEffects();
								  for (PotionEffect nextpotioneffect : effects) {
									  //shooter.sendMessage(nextpotioneffect.getType().getName()+" is the potion effect.");
									  if (nextpotioneffect.getType().getName().compareTo("SPEED")==0) {
										  //this.plugin.gainMoneyExp(shooter,"Support",0.15,6);
										  //Apply this potion effect to our player buff data. 
										  for (int i=0;i<this.plugin.SPEED_CONTROL.size();i++) {
											  if (this.plugin.SPEED_CONTROL.get(i).p.getName().compareTo(p.getName())==0) {
												  this.plugin.SPEED_CONTROL.get(i).potion_spdlv=nextpotioneffect.getAmplifier();
												  this.plugin.SPEED_CONTROL.get(i).potion_time=Bukkit.getWorld("world").getFullTime()+nextpotioneffect.getDuration();
												  this.plugin.SPEED_CONTROL.get(i).updatePlayerSpd();
											  }
										  }
									  }
									  if (nextpotioneffect.getType().getName().compareTo("HEAL")==0) {
										  if (!p.isDead()) {
											  if (p.getHealth()+12>p.getMaxHealth()) {
												  p.setHealth(p.getMaxHealth());
											  } else {
												  p.setHealth(p.getHealth()+12);
											  }
											  //shooter.sendMessage("This is a heal.");
											  p.getScoreboard().getTeam(p.getName()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth()));
										  }
									  }
								  }
							  } catch (ConcurrentModificationException ex_e) {
								  Bukkit.getLogger().warning("Potion Effect Collection not accessible for a player while modifying speed amount.");
							  }
						  }
					  }
					  entities.remove();
				  }
			  } else {
				  while (entities.hasNext()) {
					  LivingEntity next = entities.next();
					  if (next.getType() == EntityType.PLAYER) {
						  final Player p = (Player)next;
						  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
						      @Override
						      public void run() {
						    	  p.getScoreboard().getTeam(p.getName()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth()));
						      }
						  	},5);
						  try {
							  Iterator<PotionEffect> effects = e.getPotion().getEffects().iterator();
							  while (effects.hasNext()) {
								  PotionEffect nextpotioneffect = effects.next();
								  //shooter.sendMessage(nextpotioneffect.getType().getName()+" is the potion effect.");
								  if (this.plugin.PlayerinJob(shooter, "Brewer") && this.plugin.getJobLv("Brewer", shooter)>=20) {
									  next.removePotionEffect(nextpotioneffect.getType());
									  next.addPotionEffect(new PotionEffect(nextpotioneffect.getType(),nextpotioneffect.getDuration()*2,nextpotioneffect.getAmplifier(),false));
									  nextpotioneffect.getDuration();
								  }
								  if (nextpotioneffect.getType().getName().compareTo("SPEED")==0) {
									  //this.plugin.gainMoneyExp(shooter,"Support",0.15,6);
									  //Apply this potion effect to our player buff data. 
									  for (int i=0;i<this.plugin.SPEED_CONTROL.size();i++) {
										  if (this.plugin.SPEED_CONTROL.get(i).p.getName().compareTo(p.getName())==0) {
											  this.plugin.SPEED_CONTROL.get(i).potion_spdlv=nextpotioneffect.getAmplifier();
											  this.plugin.SPEED_CONTROL.get(i).potion_time=Bukkit.getWorld("world").getFullTime()+nextpotioneffect.getDuration();
											  this.plugin.SPEED_CONTROL.get(i).updatePlayerSpd();
										  }
									  }
								  }
								  if (nextpotioneffect.getType().getName().compareTo("HEAL")==0) {
									  if (!p.isDead()) {
										  if (p.getHealth()+12>p.getMaxHealth()) {
											  p.setHealth(p.getMaxHealth());
										  } else {
											  p.setHealth(p.getHealth()+12);
										  }
										  //shooter.sendMessage("This is a heal.");
									  }
								  }
								  effects.remove();
							  }
						  } catch (ConcurrentModificationException ex_e) {
							  Bukkit.getLogger().warning("Potion Effect Collection not accessible for a player during a splash potion speed update.");
						  }
					  }
					  entities.remove();
				  }
			  }
		  }
	  } catch (ConcurrentModificationException ex_e) {
		  Bukkit.getLogger().warning("Entity Collection not accessible during splash potion effect.");
	  }
  }

  @EventHandler
  public void onItemPrepareCraft(PrepareItemCraftEvent e) {
	  CraftingInventory result = e.getInventory();
	  if (result.getResult().getType()==Material.IRON_HELMET ||
			  result.getResult().getType()==Material.IRON_CHESTPLATE ||
			  result.getResult().getType()==Material.IRON_LEGGINGS ||
			  result.getResult().getType()==Material.IRON_BOOTS) {
		  ItemStack[] craftwith = result.getMatrix();
		  boolean ingots=true;
		  for (int i=0;i<craftwith.length;i++) {
			  if (craftwith[i]!=null) {
				  if (craftwith[i].getType()==Material.IRON_BLOCK) {
					  ingots=false;
				  }
			  }
		  }
		  if (ingots) {
			  ItemStack newarmor = new ItemStack(result.getResult());
			  ItemMeta newarmor_meta = result.getResult().getItemMeta();
			  String temp = ChatColor.DARK_AQUA+"Weak "+newarmor.getType().name().replace("_", " ");
			  char[] mod = temp.toCharArray();
			  boolean first=false;
			  for (int i=0;i<mod.length;i++) {
				  if (!first) {
					  if (mod[i]>='a'&&mod[i]<='z') {
						  mod[i]-=32;
						  first=true;
					  } else 
						  if (i==0) {
							  if (mod[i]>='A'&&mod[i]<='Z') {
								  first=true;
							  }
						  } else {
							  if (mod[i]>='A'&&mod[i]<='Z'&&(mod[i-1]<'A'||mod[i-1]>'Z')) {
								  first=true;
							  }
						  }
				  } else {
					  if (mod[i-1]!=' ') {
						  if (mod[i]>='A'&&mod[i]<='Z') {
							  mod[i]+=32;
						  }
					  }
				  }
			  }
			  newarmor_meta.setDisplayName(String.copyValueOf(mod));
			  List<String> NewLore = new ArrayList<String>();
			  NewLore.add(ChatColor.RED+"-400% Durability");
			  newarmor_meta.setLore(NewLore);
			  newarmor.setItemMeta(newarmor_meta);
			  result.setResult(newarmor);
		  }
	  } else
	if (result.getResult().getType()==Material.GOLD_HELMET ||
			  result.getResult().getType()==Material.GOLD_CHESTPLATE ||
			  result.getResult().getType()==Material.GOLD_LEGGINGS ||
			  result.getResult().getType()==Material.GOLD_BOOTS) {
		  ItemStack[] craftwith = result.getMatrix();
		  boolean ingots=true;
		  for (int i=0;i<craftwith.length;i++) {
			  if (craftwith[i]!=null) {
				  if (craftwith[i].getType()==Material.GOLD_BLOCK) {
					  ingots=false;
				  }
			  }
		  }
		  if (ingots) {
			  ItemStack newarmor = new ItemStack(result.getResult());
			  ItemMeta newarmor_meta = result.getResult().getItemMeta();
			  String temp = ChatColor.DARK_AQUA+"Weak "+newarmor.getType().name().replace("_", " ");
			  char[] mod = temp.toCharArray();
			  boolean first=false;
			  for (int i=0;i<mod.length;i++) {
				  if (!first) {
					  if (mod[i]>='a'&&mod[i]<='z') {
						  mod[i]-=32;
						  first=true;
					  } else 
						  if (i==0) {
							  if (mod[i]>='A'&&mod[i]<='Z') {
								  first=true;
							  }
						  } else {
							  if (mod[i]>='A'&&mod[i]<='Z'&&(mod[i-1]<'A'||mod[i-1]>'Z')) {
								  first=true;
							  }
						  }
				  } else {
					  if (mod[i-1]!=' ') {
						  if (mod[i]>='A'&&mod[i]<='Z') {
							  mod[i]+=32;
						  }
					  }
				  }
			  }
			  newarmor_meta.setDisplayName(String.copyValueOf(mod));
			  List<String> NewLore = new ArrayList<String>();
			  NewLore.add(ChatColor.RED+"-400% Durability");
			  newarmor_meta.setLore(NewLore);
			  newarmor.setItemMeta(newarmor_meta);
			  result.setResult(newarmor);
		  }
	  } else
	if (result.getResult().getType()==Material.DIAMOND_HELMET ||
		  result.getResult().getType()==Material.DIAMOND_CHESTPLATE ||
		  result.getResult().getType()==Material.DIAMOND_LEGGINGS ||
		  result.getResult().getType()==Material.DIAMOND_BOOTS) {
	  ItemStack[] craftwith = result.getMatrix();
	  boolean ingots=true;
	  for (int i=0;i<craftwith.length;i++) {
		  if (craftwith[i]!=null) {
			  if (craftwith[i].getType()==Material.DIAMOND_BLOCK) {
				  ingots=false;
			  }
		  }
	  }
	  if (ingots) {
		  ItemStack newarmor = new ItemStack(result.getResult());
		  ItemMeta newarmor_meta = result.getResult().getItemMeta();
		  String temp = ChatColor.DARK_AQUA+"Weak "+newarmor.getType().name().replace("_", " ");
		  char[] mod = temp.toCharArray();
		  boolean first=false;
		  for (int i=0;i<mod.length;i++) {
			  if (!first) {
				  if (mod[i]>='a'&&mod[i]<='z') {
					  mod[i]-=32;
					  first=true;
				  } else 
					  if (i==0) {
						  if (mod[i]>='A'&&mod[i]<='Z') {
							  first=true;
						  }
					  } else {
						  if (mod[i]>='A'&&mod[i]<='Z'&&(mod[i-1]<'A'||mod[i-1]>'Z')) {
							  first=true;
						  }
					  }
			  } else {
				  if (mod[i-1]!=' ') {
					  if (mod[i]>='A'&&mod[i]<='Z') {
						  mod[i]+=32;
					  }
				  }
			  }
		  }
		  newarmor_meta.setDisplayName(String.copyValueOf(mod));
		  List<String> NewLore = new ArrayList<String>();
		  NewLore.add(ChatColor.RED+"-400% Durability");
		  newarmor_meta.setLore(NewLore);
		  newarmor.setItemMeta(newarmor_meta);
		  result.setResult(newarmor);
	  }
	}
		//It could be with iron, gold, or diamond blocks. Try them out.
	  /*
	  boolean iron=false,gold=false,diamond=false;
	  boolean helmet=false,chestplate=false,leggings=false,boots=false;
	  ItemStack[] craftwith = result.getMatrix();
	  if (craftwith[0].getType()==Material.IRON_BLOCK &&
			  craftwith[1].getType()==Material.IRON_BLOCK &&
			  craftwith[2].getType()==Material.IRON_BLOCK &&
			  craftwith[3].getType()==Material.IRON_BLOCK &&
			  craftwith[4].getType()==Material.AIR &&
			  craftwith[5].getType()==Material.IRON_BLOCK &&
			  craftwith[6].getType()==Material.IRON_BLOCK &&
			  craftwith[7].getType()==Material.AIR &&
			  craftwith[8].getType()==Material.IRON_BLOCK) {
		  ItemStack newarmor = new ItemStack(Material.IRON_LEGGINGS);
		  result.setResult(newarmor);
	  } else
	  if (craftwith[0].getType()==Material.IRON_BLOCK &&
			  craftwith[1].getType()==Material.AIR &&
			  craftwith[2].getType()==Material.IRON_BLOCK &&
			  craftwith[3].getType()==Material.IRON_BLOCK &&
			  craftwith[4].getType()==Material.IRON_BLOCK &&
			  craftwith[5].getType()==Material.IRON_BLOCK &&
			  craftwith[6].getType()==Material.IRON_BLOCK &&
			  craftwith[7].getType()==Material.IRON_BLOCK &&
			  craftwith[8].getType()==Material.IRON_BLOCK) {
		  ItemStack newarmor = new ItemStack(Material.IRON_CHESTPLATE);
		  result.setResult(newarmor);
	  } else
		  if ((craftwith[0].getType()==Material.IRON_BLOCK &&
		  craftwith[1].getType()==Material.IRON_BLOCK &&
		  craftwith[2].getType()==Material.IRON_BLOCK &&
		  craftwith[3].getType()==Material.IRON_BLOCK &&
		  craftwith[4].getType()==Material.AIR &&
		  craftwith[5].getType()==Material.IRON_BLOCK &&
		  craftwith[6].getType()==Material.AIR &&
		  craftwith[7].getType()==Material.AIR &&
		  craftwith[8].getType()==Material.AIR) || (craftwith[3].getType()==Material.IRON_BLOCK &&
			  craftwith[4].getType()==Material.IRON_BLOCK &&
			  craftwith[5].getType()==Material.IRON_BLOCK &&
			  craftwith[6].getType()==Material.IRON_BLOCK &&
			  craftwith[7].getType()==Material.AIR &&
			  craftwith[8].getType()==Material.IRON_BLOCK &&
			  craftwith[0].getType()==Material.AIR &&
			  craftwith[1].getType()==Material.AIR &&
			  craftwith[2].getType()==Material.AIR)) {
	  ItemStack newarmor = new ItemStack(Material.IRON_HELMET);
	  result.setResult(newarmor);
	  } else
		  if ((craftwith[0].getType()==Material.IRON_BLOCK &&
		  craftwith[1].getType()==Material.AIR &&
		  craftwith[2].getType()==Material.IRON_BLOCK &&
		  craftwith[3].getType()==Material.IRON_BLOCK &&
		  craftwith[4].getType()==Material.AIR &&
		  craftwith[5].getType()==Material.IRON_BLOCK &&
		  craftwith[6].getType()==Material.AIR &&
		  craftwith[7].getType()==Material.AIR &&
		  craftwith[8].getType()==Material.AIR) || (craftwith[3].getType()==Material.IRON_BLOCK &&
			  craftwith[4].getType()==Material.AIR &&
			  craftwith[5].getType()==Material.IRON_BLOCK &&
			  craftwith[6].getType()==Material.IRON_BLOCK &&
			  craftwith[7].getType()==Material.AIR &&
			  craftwith[8].getType()==Material.IRON_BLOCK &&
			  craftwith[0].getType()==Material.AIR &&
			  craftwith[1].getType()==Material.AIR &&
			  craftwith[2].getType()==Material.AIR)) {
	  ItemStack newarmor = new ItemStack(Material.IRON_BOOTS);
	  result.setResult(newarmor);
	  }
	  if (craftwith[0].getType()==Material.GOLD_BLOCK &&
			  craftwith[1].getType()==Material.GOLD_BLOCK &&
			  craftwith[2].getType()==Material.GOLD_BLOCK &&
			  craftwith[3].getType()==Material.GOLD_BLOCK &&
			  craftwith[4].getType()==Material.AIR &&
			  craftwith[5].getType()==Material.GOLD_BLOCK &&
			  craftwith[6].getType()==Material.GOLD_BLOCK &&
			  craftwith[7].getType()==Material.AIR &&
			  craftwith[8].getType()==Material.GOLD_BLOCK) {
		  ItemStack newarmor = new ItemStack(Material.GOLD_LEGGINGS);
		  result.setResult(newarmor);
	  } else
	  if (craftwith[0].getType()==Material.GOLD_BLOCK &&
			  craftwith[1].getType()==Material.AIR &&
			  craftwith[2].getType()==Material.GOLD_BLOCK &&
			  craftwith[3].getType()==Material.GOLD_BLOCK &&
			  craftwith[4].getType()==Material.GOLD_BLOCK &&
			  craftwith[5].getType()==Material.GOLD_BLOCK &&
			  craftwith[6].getType()==Material.GOLD_BLOCK &&
			  craftwith[7].getType()==Material.GOLD_BLOCK &&
			  craftwith[8].getType()==Material.GOLD_BLOCK) {
		  ItemStack newarmor = new ItemStack(Material.GOLD_CHESTPLATE);
		  result.setResult(newarmor);
	  } else
		  if ((craftwith[0].getType()==Material.GOLD_BLOCK &&
		  craftwith[1].getType()==Material.GOLD_BLOCK &&
		  craftwith[2].getType()==Material.GOLD_BLOCK &&
		  craftwith[3].getType()==Material.GOLD_BLOCK &&
		  craftwith[4].getType()==Material.AIR &&
		  craftwith[5].getType()==Material.GOLD_BLOCK &&
		  craftwith[6].getType()==Material.AIR &&
		  craftwith[7].getType()==Material.AIR &&
		  craftwith[8].getType()==Material.AIR) || (craftwith[3].getType()==Material.GOLD_BLOCK &&
			  craftwith[4].getType()==Material.GOLD_BLOCK &&
			  craftwith[5].getType()==Material.GOLD_BLOCK &&
			  craftwith[6].getType()==Material.GOLD_BLOCK &&
			  craftwith[7].getType()==Material.AIR &&
			  craftwith[8].getType()==Material.GOLD_BLOCK &&
			  craftwith[0].getType()==Material.AIR &&
			  craftwith[1].getType()==Material.AIR &&
			  craftwith[2].getType()==Material.AIR)) {
	  ItemStack newarmor = new ItemStack(Material.GOLD_HELMET);
	  result.setResult(newarmor);
	  } else
		  if ((craftwith[0].getType()==Material.GOLD_BLOCK &&
		  craftwith[1].getType()==Material.AIR &&
		  craftwith[2].getType()==Material.GOLD_BLOCK &&
		  craftwith[3].getType()==Material.GOLD_BLOCK &&
		  craftwith[4].getType()==Material.AIR &&
		  craftwith[5].getType()==Material.GOLD_BLOCK &&
		  craftwith[6].getType()==Material.AIR &&
		  craftwith[7].getType()==Material.AIR &&
		  craftwith[8].getType()==Material.AIR) || (craftwith[3].getType()==Material.GOLD_BLOCK &&
			  craftwith[4].getType()==Material.AIR &&
			  craftwith[5].getType()==Material.GOLD_BLOCK &&
			  craftwith[6].getType()==Material.GOLD_BLOCK &&
			  craftwith[7].getType()==Material.AIR &&
			  craftwith[8].getType()==Material.GOLD_BLOCK &&
			  craftwith[0].getType()==Material.AIR &&
			  craftwith[1].getType()==Material.AIR &&
			  craftwith[2].getType()==Material.AIR)) {
	  ItemStack newarmor = new ItemStack(Material.GOLD_BOOTS);
	  result.setResult(newarmor);
	  }
	  if (craftwith[0].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[1].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[2].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[3].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[4].getType()==Material.AIR &&
			  craftwith[5].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[6].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[7].getType()==Material.AIR &&
			  craftwith[8].getType()==Material.DIAMOND_BLOCK) {
		  ItemStack newarmor = new ItemStack(Material.DIAMOND_LEGGINGS);
		  result.setResult(newarmor);
	  } else
	  if (craftwith[0].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[1].getType()==Material.AIR &&
			  craftwith[2].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[3].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[4].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[5].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[6].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[7].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[8].getType()==Material.DIAMOND_BLOCK) {
		  ItemStack newarmor = new ItemStack(Material.DIAMOND_CHESTPLATE);
		  result.setResult(newarmor);
	  } else
		  if ((craftwith[0].getType()==Material.DIAMOND_BLOCK &&
		  craftwith[1].getType()==Material.DIAMOND_BLOCK &&
		  craftwith[2].getType()==Material.DIAMOND_BLOCK &&
		  craftwith[3].getType()==Material.DIAMOND_BLOCK &&
		  craftwith[4].getType()==Material.AIR &&
		  craftwith[5].getType()==Material.DIAMOND_BLOCK &&
		  craftwith[6].getType()==Material.AIR &&
		  craftwith[7].getType()==Material.AIR &&
		  craftwith[8].getType()==Material.AIR) || (craftwith[3].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[4].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[5].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[6].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[7].getType()==Material.AIR &&
			  craftwith[8].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[0].getType()==Material.AIR &&
			  craftwith[1].getType()==Material.AIR &&
			  craftwith[2].getType()==Material.AIR)) {
	  ItemStack newarmor = new ItemStack(Material.DIAMOND_HELMET);
	  result.setResult(newarmor);
	  } else
		  if ((craftwith[0].getType()==Material.DIAMOND_BLOCK &&
		  craftwith[1].getType()==Material.AIR &&
		  craftwith[2].getType()==Material.DIAMOND_BLOCK &&
		  craftwith[3].getType()==Material.DIAMOND_BLOCK &&
		  craftwith[4].getType()==Material.AIR &&
		  craftwith[5].getType()==Material.DIAMOND_BLOCK &&
		  craftwith[6].getType()==Material.AIR &&
		  craftwith[7].getType()==Material.AIR &&
		  craftwith[8].getType()==Material.AIR) || (craftwith[3].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[4].getType()==Material.AIR &&
			  craftwith[5].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[6].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[7].getType()==Material.AIR &&
			  craftwith[8].getType()==Material.DIAMOND_BLOCK &&
			  craftwith[0].getType()==Material.AIR &&
			  craftwith[1].getType()==Material.AIR &&
			  craftwith[2].getType()==Material.AIR)) {
	  ItemStack newarmor = new ItemStack(Material.DIAMOND_BOOTS);
	  result.setResult(newarmor);
	  }
	  */
  }
  
  @EventHandler
  public void onItemCraft(CraftItemEvent e) {
	//This is something we just crafted.
	  //Bukkit.getPlayer("sigonasr2").sendMessage("Resulting item is "+result.getResult().getAmount()+" "+result.getResult().getType());
	  CraftingInventory result = e.getInventory();
	  //Bukkit.getPlayer("sigonasr2").sendMessage("Resulting item is "+result.getResult().getAmount()+" "+result.getResult().getType());
	  Player p = Bukkit.getPlayer(e.getWhoClicked().getName());
	  if (this.plugin.PlayerinJob(p,"Weaponsmith")) {
		  boolean crafteditem=false;
		  if (result.getResult().getType()==Material.ARROW) {
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.WOOD_SWORD) {
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.FLINT_AND_STEEL) {
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.BOW) {
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_SWORD) {
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLD_SWORD) {
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_SWORD) {
			  crafteditem=true;
		  }
		  if (this.plugin.getJobLv("Weaponsmith", p)>=20 && crafteditem) {
			  ItemStack[] crafteditems = result.getMatrix();
			  if (e.getClick()==ClickType.SHIFT_RIGHT || e.getClick()==ClickType.SHIFT_LEFT) {
				  int lowestamt=9999;
				  for (int i=0;i<crafteditems.length;i++) {
					  if (crafteditems[i]!=null && crafteditems[i].getType()!=Material.AIR) {
						  if (crafteditems[i].getAmount()<lowestamt) {
							  lowestamt=crafteditems[i].getAmount();
						  }
					  }
				  }
				  for (int i=0;i<crafteditems.length;i++) {
					  if (crafteditems[i]!=null && crafteditems[i].getType()!=Material.AIR) {
						  for (int j=0;j<lowestamt;j++) {
							  if (Math.random()<=0.25) {
								  //p.sendMessage("Restored an item.");
								  ItemStack replenishitem = crafteditems[i].clone();
								  replenishitem.setAmount(1);
								  p.getInventory().addItem(replenishitem);
							  }
						  }
					  }
				  }
			  } else {
				  for (int i=0;i<crafteditems.length;i++) {
					  if (crafteditems[i]!=null && crafteditems[i].getType()!=Material.AIR) {
						  if (Math.random()<=0.25) {
							  //p.sendMessage("Restored an item.");
							  ItemStack replenishitem = crafteditems[i].clone();
							  replenishitem.setAmount(1);
							  p.getInventory().addItem(replenishitem);
						  }
					  }
				  }
			  }
		  } else
		  if (this.plugin.getJobLv("Weaponsmith", p)>=5 && crafteditem) {
			  ItemStack[] crafteditems = result.getMatrix();
			  if (e.getClick()==ClickType.SHIFT_RIGHT || e.getClick()==ClickType.SHIFT_LEFT) {
				  int lowestamt=9999;
				  for (int i=0;i<crafteditems.length;i++) {
					  if (crafteditems[i]!=null && crafteditems[i].getType()!=Material.AIR) {
						  if (crafteditems[i].getAmount()<lowestamt) {
							  lowestamt=crafteditems[i].getAmount();
						  }
					  }
				  }
				  for (int i=0;i<crafteditems.length;i++) {
					  if (crafteditems[i]!=null && crafteditems[i].getType()!=Material.AIR) {
						  for (int j=0;j<lowestamt;j++) {
							  if (Math.random()<=0.10) {
								  //p.sendMessage("Restored an item.");
								  ItemStack replenishitem = crafteditems[i].clone();
								  replenishitem.setAmount(1);
								  p.getInventory().addItem(replenishitem);
							  }
						  }
					  }
				  }
			  } else {
				  for (int i=0;i<crafteditems.length;i++) {
					  if (crafteditems[i]!=null && crafteditems[i].getType()!=Material.AIR) {
						  if (Math.random()<=0.10) {
							  //p.sendMessage("Restored an item.");
							  ItemStack replenishitem = crafteditems[i].clone();
							  replenishitem.setAmount(1);
							  p.getInventory().addItem(replenishitem);
						  }
					  }
				  }
			  }
		  }
		  if (this.plugin.getJobLv("Weaponsmith", p)>=10 && crafteditem) {
			  //Bukkit.getPlayer("sigonasr2").sendMessage("Valid item. Going to attempt to enchant.");
			  if (e.getClick()!=ClickType.SHIFT_RIGHT && e.getClick()!=ClickType.SHIFT_LEFT) {
				  ItemStack resulting = this.plugin.EnchantItem(result.getResult(),5,p);
				  result.setResult(resulting);
			  }
		  }
	  }
	  if (this.plugin.PlayerinJob(p,"Blacksmith")) {
		  boolean crafteditem=false;
		  /*
		  if (result.getResult().getType()==Material.STONE_HOE) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.04,7);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.STONE_SPADE) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.05,8);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.STONE_PICKAXE) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.075,15);
			  crafteditem=true;
		  }*/
		  if (result.getResult().getType()==Material.LEATHER_BOOTS) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.125,8);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.LEATHER_HELMET) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.15,14);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.LEATHER_LEGGINGS) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.175,15);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.LEATHER_CHESTPLATE) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.20,18);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_SPADE) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.25,18);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_AXE) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.25,18);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_HOE) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.325,24);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_BOOTS) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.375*mult,27*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_PICKAXE) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.40,30);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_HELMET) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.50*mult,45*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLD_SPADE) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.625,55);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLD_AXE) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.625,55);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLD_HOE) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.65,60);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_LEGGINGS) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.725*mult,60*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_SPADE) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.75,65);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_AXE) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.75,65);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_HOE) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.80,70);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLD_BOOTS) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.825*mult,50*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_CHESTPLATE) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.875*mult,70*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLD_HELMET) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.925*mult,80*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_PICKAXE) {
			  //this.plugin.gainMoneyExp(p,"Blacksmith",0.925,80);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_BOOTS) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  //this.plugin.gainMoneyExp(p,"Blacksmith",1.00*mult,85*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLD_LEGGINGS) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  //this.plugin.gainMoneyExp(p,"Blacksmith",1.025*mult,100*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLD_CHESTPLATE) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  //this.plugin.gainMoneyExp(p,"Blacksmith",1.15*mult,130*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_HELMET) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  //this.plugin.gainMoneyExp(p,"Blacksmith",1.15*mult,125*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_LEGGINGS) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  //this.plugin.gainMoneyExp(p,"Blacksmith",1.325*mult,145*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_CHESTPLATE) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  //this.plugin.gainMoneyExp(p,"Blacksmith",1.50*mult,175*mult);
			  crafteditem=true;
		  }
		  if (this.plugin.getJobLv("Blacksmith", p)>=5 && crafteditem) {
			  //Bukkit.getPlayer("sigonasr2").sendMessage("Valid item. Going to attempt to enchant.");
			  if (e.getClick()!=ClickType.SHIFT_RIGHT && e.getClick()!=ClickType.SHIFT_LEFT) {
				  ItemStack resulting = this.plugin.EnchantItem(result.getResult(),5,p);
				  result.setResult(resulting);
			  }
		  }
		  if (this.plugin.getJobLv("Blacksmith", p)>=10 && crafteditem) {
			  //Bukkit.getPlayer("sigonasr2").sendMessage("Valid item. Going to attempt to enchant.");
			  if (e.getClick()!=ClickType.SHIFT_RIGHT && e.getClick()!=ClickType.SHIFT_LEFT) {
				  ItemStack resulting = this.plugin.EnchantItem(result.getResult(),10,p);
				  result.setResult(resulting);
			  }
		  }
		  if (this.plugin.getJobLv("Blacksmith", p)>=20 && crafteditem) {
			  ItemStack[] crafteditems = result.getMatrix();
			  if (e.getClick()==ClickType.SHIFT_RIGHT || e.getClick()==ClickType.SHIFT_LEFT) {
				  int lowestamt=9999;
				  for (int i=0;i<crafteditems.length;i++) {
					  if (crafteditems[i]!=null && crafteditems[i].getType()!=Material.AIR) {
						  if (crafteditems[i].getAmount()<lowestamt) {
							  lowestamt=crafteditems[i].getAmount();
						  }
					  }
				  }
				  for (int i=0;i<crafteditems.length;i++) {
					  if (crafteditems[i]!=null && crafteditems[i].getType()!=Material.AIR) {
						  for (int j=0;j<lowestamt;j++) {
							  if (Math.random()<=0.30) {
								  ItemStack replenishitem = crafteditems[i].clone();
								  replenishitem.setAmount(1);
								  p.getInventory().addItem(replenishitem);
							  }
						  }
					  }
				  }
			  } else {
				  for (int i=0;i<crafteditems.length;i++) {
					  if (crafteditems[i]!=null && crafteditems[i].getType()!=Material.AIR) {
						  if (Math.random()<=0.30) {
							  ItemStack replenishitem = crafteditems[i].clone();
							  replenishitem.setAmount(1);
							  p.getInventory().addItem(replenishitem);
						  }
					  }
				  }
			  }
		  }
	  }
	  /*
	  //this.plugin.tempinventory = Bukkit.getPlayer(e.getWhoClicked().getName()).getInventory().getContents();
	  CraftingInventory result = e.getInventory();
	  //Bukkit.getPlayer("sigonasr2").sendMessage("Resulting item is "+result.getResult().getAmount()+" "+result.getResult().getType());
	  Player p = Bukkit.getPlayer(e.getWhoClicked().getName());
	  if (this.plugin.PlayerinJob(p,"Digger")) {
		  if (result.getResult().getType()==Material.SANDSTONE) {
			  this.plugin.gainMoneyExp(p,"Digger",0.02,6);
		  }
		  if (result.getResult().getType()==Material.BRICK) {
			  this.plugin.gainMoneyExp(p,"Digger",0.04,8);
		  }
	  }
	  if (this.plugin.PlayerinJob(p,"Weaponsmith")) {
		  boolean crafteditem=false;
		  if (result.getResult().getType()==Material.ARROW) {
			  this.plugin.gainMoneyExp(p,"Weaponsmith",0.025,4);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.WOOD_SWORD) {
			  this.plugin.gainMoneyExp(p,"Weaponsmith",0.05,10);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.FLINT_AND_STEEL) {
			  this.plugin.gainMoneyExp(p,"Weaponsmith",0.06,12);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.BOW) {
			  this.plugin.gainMoneyExp(p,"Weaponsmith",0.075,12);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_SWORD) {
			  this.plugin.gainMoneyExp(p,"Weaponsmith",0.375,75);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLD_SWORD) {
			  this.plugin.gainMoneyExp(p,"Weaponsmith",0.50,100);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_SWORD) {
			  this.plugin.gainMoneyExp(p,"Weaponsmith",0.975,175);
			  crafteditem=true;
		  }
		  if (this.plugin.getJobLv("Weaponsmith", p)>=20) {
			  ItemStack[] crafteditems = result.getMatrix();
			  for (int i=0;i<crafteditems.length;i++) {
				  if (crafteditems[i]!=null) {
					  if (Math.random()<=0.25) {
						  ItemStack replenishitem = crafteditems[i].clone();
						  replenishitem.setAmount(1);
						  p.getInventory().addItem(replenishitem);
					  }
				  }
			  }
		  } else
		  if (this.plugin.getJobLv("Weaponsmith", p)>=5) {
			  ItemStack[] crafteditems = result.getMatrix();
			  for (int i=0;i<crafteditems.length;i++) {
				  if (crafteditems[i]!=null) {
					  if (Math.random()<=0.10) {
						  ItemStack replenishitem = crafteditems[i].clone();
						  replenishitem.setAmount(1);
						  p.getInventory().addItem(replenishitem);
					  }
				  }
			  }
		  }
		  if (this.plugin.getJobLv("Weaponsmith", p)>=10 && crafteditem) {
			  //Bukkit.getPlayer("sigonasr2").sendMessage("Valid item. Going to attempt to enchant.");
			  ItemStack resulting = this.plugin.EnchantItem(result.getResult(),10);
			  result.setResult(resulting);
		  }
	  }
	  if (this.plugin.PlayerinJob(p,"Blacksmith")) {
		  boolean crafteditem=false;
		  if (result.getResult().getType()==Material.STONE_HOE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.04,7);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.STONE_SPADE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.05,8);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.STONE_PICKAXE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.075,15);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.LEATHER_BOOTS) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.125,8);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.LEATHER_HELMET) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.15,14);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.LEATHER_LEGGINGS) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.175,15);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.LEATHER_CHESTPLATE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.20,18);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_SPADE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.25,18);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_HOE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.325,24);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_BOOTS) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.375*mult,27*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_PICKAXE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.40,30);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_HELMET) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.50*mult,45*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLD_SPADE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.625,55);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLD_HOE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.65,60);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_LEGGINGS) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.725*mult,60*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_SPADE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.75,65);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_HOE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.80,70);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLD_BOOTS) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.825*mult,50*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.IRON_CHESTPLATE) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.875*mult,70*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLD_HELMET) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.925*mult,80*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_PICKAXE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.925,80);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_BOOTS) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",1.00*mult,85*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLD_LEGGINGS) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",1.025*mult,100*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLD_CHESTPLATE) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",1.15*mult,130*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_HELMET) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",1.15*mult,125*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_LEGGINGS) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",1.325*mult,145*mult);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.DIAMOND_CHESTPLATE) {
			  int mult=1;
			  if ((result.getResult().getItemMeta().getDisplayName()!=null && !result.getResult().getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getResult().getItemMeta().getDisplayName()==null) {
				  mult=8;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",1.50*mult,175*mult);
			  crafteditem=true;
		  }
		  if (this.plugin.getJobLv("Blacksmith", p)>=5 && crafteditem) {
			  //Bukkit.getPlayer("sigonasr2").sendMessage("Valid item. Going to attempt to enchant.");
			  ItemStack resulting = this.plugin.EnchantItem(result.getResult(),5);
			  result.setResult(resulting);
		  }
		  if (this.plugin.getJobLv("Blacksmith", p)>=10 && crafteditem) {
			  //Bukkit.getPlayer("sigonasr2").sendMessage("Valid item. Going to attempt to enchant.");
			  ItemStack resulting = this.plugin.EnchantItem(result.getResult(),10);
			  result.setResult(resulting);
		  }
		  if (this.plugin.getJobLv("Blacksmith", p)>=20) {
			  ItemStack[] crafteditems = result.getMatrix();
			  for (int i=0;i<crafteditems.length;i++) {
				  if (crafteditems[i]!=null) {
					  if (Math.random()<=0.30) {
						  ItemStack replenishitem = crafteditems[i].clone();
						  replenishitem.setAmount(1);
						  p.getInventory().addItem(replenishitem);
					  }
				  }
			  }
		  }
	  }
	  if (this.plugin.PlayerinJob(p,"Cook")) {
		  boolean crafteditem=false;
		  if (result.getResult().getType()==Material.BREAD) {
			  this.plugin.gainMoneyExp(p,"Cook",0.0125,5);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.MUSHROOM_SOUP) {
			  this.plugin.gainMoneyExp(p,"Cook",0.0375,15);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.COOKIE) {
			  this.plugin.gainMoneyExp(p,"Cook",0.0675,25);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLDEN_CARROT) {
			  this.plugin.gainMoneyExp(p,"Cook",0.0875,35);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.GOLDEN_APPLE) {
			  this.plugin.gainMoneyExp(p,"Cook",0.1125,45);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.PUMPKIN_PIE) {
			  this.plugin.gainMoneyExp(p,"Cook",0.15,60);
			  crafteditem=true;
		  }
		  if (result.getResult().getType()==Material.CAKE) {
			  this.plugin.gainMoneyExp(p,"Cook",0.2125,85);
			  crafteditem=true;
		  }
		  if (this.plugin.getJobLv("Cook", p)>=10 && crafteditem==true) {
			  ItemStack resultingitem = result.getResult();
			  resultingitem.setAmount(resultingitem.getAmount()*2);
		  }
	  }
	  if (this.plugin.PlayerinJob(p,"Support")) {
		  if (result.getResult().getType()==Material.BREAD) {
			  this.plugin.gainMoneyExp(p,"Support",0.015,2);
		  }
		  if (result.getResult().getType()==Material.MUSHROOM_SOUP) {
			  this.plugin.gainMoneyExp(p,"Support",0.015,2);
		  }
		  if (result.getResult().getType()==Material.COOKIE) {
			  this.plugin.gainMoneyExp(p,"Support",0.015,2);
		  }
		  if (result.getResult().getType()==Material.GOLDEN_CARROT) {
			  this.plugin.gainMoneyExp(p,"Support",0.015,2);
		  }
		  if (result.getResult().getType()==Material.GOLDEN_APPLE) {
			  this.plugin.gainMoneyExp(p,"Support",0.015,2);
		  }
		  if (result.getResult().getType()==Material.PUMPKIN_PIE) {
			  this.plugin.gainMoneyExp(p,"Support",0.015,2);
		  }
		  if (result.getResult().getType()==Material.CAKE) {
			  this.plugin.gainMoneyExp(p,"Support",0.015,2);
		  }
		  if (result.getResult().getType()==Material.IRON_SWORD) {
			  this.plugin.gainMoneyExp(p,"Support",0.015,3);
		  }
		  if (result.getResult().getType()==Material.IRON_CHESTPLATE || result.getResult().getType()==Material.IRON_HELMET || result.getResult().getType()==Material.IRON_BOOTS || result.getResult().getType()==Material.IRON_LEGGINGS) {
			  this.plugin.gainMoneyExp(p,"Support",0.025,5);
		  }
		  if (result.getResult().getType()==Material.DIAMOND_SWORD) {
			  this.plugin.gainMoneyExp(p,"Support",0.075,8);
		  }
		  if (result.getResult().getType()==Material.DIAMOND_CHESTPLATE || result.getResult().getType()==Material.DIAMOND_HELMET || result.getResult().getType()==Material.DIAMOND_BOOTS || result.getResult().getType()==Material.DIAMOND_LEGGINGS) {
			  this.plugin.gainMoneyExp(p,"Support",0.20,20);
		  }
		  if (result.getResult().getType()==Material.CAKE) {
			  this.plugin.gainMoneyExp(p,"Support",0.03,2);
		  }
	  }
	  */
  }

  /*@EventHandler
  public void onFurnaceGet(FurnaceExtractEvent e) {
	  Player p = e.getPlayer();
	  Bukkit.getPlayer("sigonasr2").sendMessage("Extacting "+e.getItemAmount()+" "+e.getItemType());
  }*/
  @EventHandler
  public void onLeafDecay(LeavesDecayEvent e) {
	  Player[] list = Bukkit.getOnlinePlayers();
	  for (int i=0;i<list.length;i++) {
		  double distance=Math.abs(list[i].getLocation().getX()-e.getBlock().getX())+Math.abs(list[i].getLocation().getY()-e.getBlock().getY())+Math.abs(list[i].getLocation().getZ()-e.getBlock().getZ());
		  if (distance<50) {
			  if (this.plugin.PlayerinJob(list[i], "Woodcutter") && this.plugin.getJobLv("Woodcutter", list[i])>=20) {
				  //Increase sapling drops by 64%.
				  if (e.getBlock().getData()!=3) {
					  //This is not a jungle leaf block.
					  if (Math.random()*100<=25) {
						  //Produce a sapling.
						  Bukkit.getWorld("world").dropItem(e.getBlock().getLocation(), new ItemStack(Material.SAPLING,1,e.getBlock().getData()));
						  //list[i].sendMessage("You got an extra spawned sapling.");
					  }
				  } else {
					  if (Math.random()*100<=12.5) {
						  //Produce a sapling.
						  Bukkit.getWorld("world").dropItem(e.getBlock().getLocation(), new ItemStack(Material.SAPLING,1,e.getBlock().getData()));
					  }
				  }
			  } else
			  if (this.plugin.PlayerinJob(list[i], "Woodcutter") && this.plugin.getJobLv("Woodcutter", list[i])>=5) {
				  //Increase sapling drops by 40%.
				  if (e.getBlock().getData()!=3) {
					  //This is not a jungle leaf block.
					  if (Math.random()*100<=12) {
						  //Produce a sapling.
						  Bukkit.getWorld("world").dropItem(e.getBlock().getLocation(), new ItemStack(Material.SAPLING,1,e.getBlock().getData()));
						  //list[i].sendMessage("You got an extra spawned sapling.");
					  }
				  } else {
					  if (Math.random()*100<=6) {
						  //Produce a sapling.
						  Bukkit.getWorld("world").dropItem(e.getBlock().getLocation(), new ItemStack(Material.SAPLING,1,e.getBlock().getData()));
					  }
				  }
			  }
		  }
	  }
  }
  
  @EventHandler
  public void onItemChange(PlayerItemHeldEvent e) {
	  Player p = e.getPlayer();
	  if (this.plugin.PlayerinJob(p, "Miner") && this.plugin.getJobLv("Miner", p)>=20) {
		  if (p.getInventory().getContents()[e.getNewSlot()]!=null && 
				  (p.getInventory().getContents()[e.getNewSlot()].getType()==Material.WOOD_PICKAXE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.IRON_PICKAXE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.GOLD_PICKAXE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.DIAMOND_PICKAXE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.STONE_PICKAXE)) {
			  ItemStack currentitem = p.getInventory().getContents()[e.getNewSlot()];
			  if (!currentitem.containsEnchantment(Enchantment.getByName("DIG_SPEED"))) {
				  currentitem.addEnchantment(Enchantment.getByName("DIG_SPEED"), 2);
			  } else {
				  //if (currentitem.getEnchantmentLevel())
			  }
		  }
	  } else
	  if (this.plugin.PlayerinJob(p, "Miner") && this.plugin.getJobLv("Miner", p)>=5) {
		  if (p.getInventory().getContents()[e.getNewSlot()]!=null && 
				  (p.getInventory().getContents()[e.getNewSlot()].getType()==Material.WOOD_PICKAXE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.IRON_PICKAXE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.GOLD_PICKAXE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.DIAMOND_PICKAXE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.STONE_PICKAXE)) {
			  ItemStack currentitem = p.getInventory().getContents()[e.getNewSlot()];
			  if (!currentitem.containsEnchantment(Enchantment.getByName("DIG_SPEED"))) {
				  currentitem.addEnchantment(Enchantment.getByName("DIG_SPEED"), 1);
			  }
		  }
	  }
	  if (this.plugin.PlayerinJob(p, "Digger") && this.plugin.getJobLv("Digger", p)>=5) {
		  if (p.getInventory().getContents()[e.getNewSlot()]!=null && 
				  (p.getInventory().getContents()[e.getNewSlot()].getType()==Material.WOOD_SPADE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.IRON_SPADE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.GOLD_SPADE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.DIAMOND_SPADE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.STONE_SPADE)) {
			  ItemStack currentitem = p.getInventory().getContents()[e.getNewSlot()];
			  if (!currentitem.containsEnchantment(Enchantment.getByName("DIG_SPEED"))) {
				  currentitem.addEnchantment(Enchantment.getByName("DIG_SPEED"), 1);
			  }
		  }
	  } else
	  if (this.plugin.PlayerinJob(p, "Digger") && this.plugin.getJobLv("Digger", p)>=20) {
		  if (p.getInventory().getContents()[e.getNewSlot()]!=null && 
				  (p.getInventory().getContents()[e.getNewSlot()].getType()==Material.WOOD_SPADE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.IRON_SPADE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.GOLD_SPADE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.DIAMOND_SPADE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.STONE_SPADE)) {
			  ItemStack currentitem = p.getInventory().getContents()[e.getNewSlot()];
			  if (!currentitem.containsEnchantment(Enchantment.getByName("DIG_SPEED"))) {
				  currentitem.addEnchantment(Enchantment.getByName("DIG_SPEED"), 2);
			  }
		  }
	  }
	  if (this.plugin.PlayerinJob(p, "Hunter") && this.plugin.getJobLv("Hunter", p)>=20) {
		  if (p.getInventory().getContents()[e.getNewSlot()]!=null && 
				  (p.getInventory().getContents()[e.getNewSlot()].getType()==Material.WOOD_SWORD ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.IRON_SWORD ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.GOLD_SWORD ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.DIAMOND_SWORD ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.STONE_SWORD)) {
			  ItemStack currentitem = p.getInventory().getContents()[e.getNewSlot()];
			  if (!currentitem.containsEnchantment(Enchantment.getByName("FIRE_ASPECT"))) { 
				  currentitem.addEnchantment(Enchantment.getByName("FIRE_ASPECT"), 2);
			  }
		  }
	  }
	  if (this.plugin.PlayerinJob(p, "Woodcutter") && this.plugin.getJobLv("Woodcutter", p)>=10) {
		  if (p.getInventory().getContents()[e.getNewSlot()]!=null && 
				  (p.getInventory().getContents()[e.getNewSlot()].getType()==Material.WOOD_AXE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.IRON_AXE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.GOLD_AXE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.DIAMOND_AXE ||
				  p.getInventory().getContents()[e.getNewSlot()].getType()==Material.STONE_AXE)) {
			  ItemStack currentitem = p.getInventory().getContents()[e.getNewSlot()];
			  if (!currentitem.containsEnchantment(Enchantment.getByName("DIG_SPEED"))) {
				  currentitem.addEnchantment(Enchantment.getByName("DIG_SPEED"), 1);
			  }
		  }
	  }
  }
  
public ItemStack getGoodie() {
	ItemStack item = null;
	if (Math.random()<0.33) {
		  //Add a weapon/armor piece.
		  int rand = (int)(Math.random()*5);
		  String type = "";
		  String type2 = "";
		  switch (rand) {
			  case 0: {
				  type = "LEATHER";
			  }break;
			  case 1: {
				  type = "IRON";
			  }break;
			  case 2: {
				  type = "GOLD";
			  }break;
			  case 3: {
				  type = "CHAINMAIL";
			  }break;
			  case 4: {
				  type = "DIAMOND";
			  }break;
		  }
		  if (rand!=0 && rand!=3) {
			  rand = (int)(Math.random()*9);
			  type2 = "";
			  switch (rand) {
				  case 0: {
					  type2 = "HELMET";
				  }break;
				  case 1: {
					  type2 = "CHESTPLATE";
				  }break;
				  case 2: {
					  type2 = "LEGGINGS";
				  }break;
				  case 3: {
					  type2 = "BOOTS";
				  }break;
				  case 4: {
					  type2 = "SWORD";
				  }break;
				  case 5: {
					  type2 = "PICKAXE";
				  }break;
				  case 6: {
					  type2 = "SPADE";
				  }break;
				  case 7: {
					  type2 = "HOE";
				  }break;
				  case 8: {
					  type2 = "AXE";
				  }break;
			  }  
		  } else {
			  rand = (int)(Math.random()*5);
			  type2 = "";
			  switch (rand) {
				  case 0: {
					  type2 = "HELMET";
				  }break;
				  case 1: {
					  type2 = "CHESTPLATE";
				  }break;
				  case 2: {
					  type2 = "LEGGINGS";
				  }break;
				  case 3: {
					  type2 = "BOOTS";
				  }break;
				  case 4: {
					  type2 = "BOW";
				  }break;
			  }  
		  }
		  if (type2.equalsIgnoreCase("BOW")) {
			  item = new ItemStack(Material.BOW);
			  int enchants[] = {48,49,50,51};
			  for (int j=0;j<enchants.length;j++) {
				  if (Math.random()<1.0d/enchants.length) {
					  item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
				  }
			  }
			  List<String> ourLore = new ArrayList<String>();
			  if (Math.random()<=0.2) {
				  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Critical Chance");
			  }
			  if (Math.random()<=0.2) {
				  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*3)+1)+" "+ChatColor.BLUE+"Armor Penetration");
			  }
			  if (Math.random()<=0.2) {
				  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Life Steal");
			  }
			  if (Math.random()<=0.2) {
				  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*30)+1)+"% "+ChatColor.BLUE+"Attack Speed");
			  }
			  if (Math.random()<=0.2) {
				  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*5)+1)+" "+ChatColor.BLUE+"Damage");
			  }
			  ItemMeta meta = item.getItemMeta();
			  meta.setLore(ourLore);
			  item.setItemMeta(meta);
		  } else {
			  item = new ItemStack(Material.getMaterial(type+"_"+type2));
			  if (type2.equalsIgnoreCase("SWORD")) {
				  int enchants[] = {16,17,18,19,20,21,34};
				  for (int j=0;j<enchants.length;j++) {
					  if (Math.random()<1.0d/enchants.length) {
						  item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
					  }
				  }
				  List<String> ourLore = new ArrayList<String>();
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Critical Chance");
				  }
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*3)+1)+" "+ChatColor.BLUE+"Armor Penetration");
				  }
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Life Steal");
				  }
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*30)+1)+"% "+ChatColor.BLUE+"Attack Speed");
				  }
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*5)+1)+" "+ChatColor.BLUE+"Damage");
				  }
				  ItemMeta meta = item.getItemMeta();
				  meta.setLore(ourLore);
				  item.setItemMeta(meta);
			  } else if (type2.equalsIgnoreCase("SPADE") || type2.equalsIgnoreCase("PICKAXE") || type2.equalsIgnoreCase("HOE") || type2.equalsIgnoreCase("AXE")) {
				  int enchants[] = {32,33,34,35};
				  for (int j=0;j<enchants.length;j++) {
					  if (Math.random()<1.0d/enchants.length) {
						  item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
					  }
				  }
				  List<String> ourLore = new ArrayList<String>();
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Critical Chance");
				  }
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*3)+1)+" "+ChatColor.BLUE+"Armor Penetration");
				  }
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Life Steal");
				  }
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*30)+1)+"% "+ChatColor.BLUE+"Attack Speed");
				  }
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*5)+1)+" "+ChatColor.BLUE+"Damage");
				  }
				  ItemMeta meta = item.getItemMeta();
				  meta.setLore(ourLore);
				  item.setItemMeta(meta);
			  } else {
				  int enchants[] = {0,1,2,3,4,5,6,7,34};
				  for (int j=0;j<enchants.length;j++) {
					  if (Math.random()<1.0d/enchants.length) {
						  item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
					  }
				  }
				  List<String> ourLore = new ArrayList<String>();
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*4)+1)+" "+ChatColor.BLUE+"Health");
				  }
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Damage Reduction");
				  }
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+(((int)(Math.random()*50)+1)*10)+"% "+ChatColor.BLUE+"Durability");
				  }
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Block Chance");
				  }
				  if (Math.random()<=0.2) {
					  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*10)+1)+"% "+ChatColor.BLUE+"Speed Boost Chance");
				  }
				  ItemMeta meta = item.getItemMeta();
				  meta.setLore(ourLore);
				  item.setItemMeta(meta);
			  }
		  }
	  } else {
		  //Add minerals.
		  int rand = (int)(Math.random()*9);
		  switch (rand) {
			  case 0 :{
				  item = new ItemStack(Material.IRON_INGOT,(int)(Math.random()*40)+20);
			  }break;
			  case 1 :{
				  item = new ItemStack(Material.IRON_BLOCK,(int)(Math.random()*4)+2);
			  }break;
			  case 2 :{
				  item = new ItemStack(Material.GOLD_INGOT,(int)(Math.random()*20)+10);
			  }break;
			  case 3 :{
				  item = new ItemStack(Material.GOLD_BLOCK,(int)(Math.random()*2)+1);
			  }break;
			  case 4 :{
				  item = new ItemStack(Material.LAPIS_BLOCK,(int)(Math.random()*40)+20);
			  }break;
			  case 5 :{
				  item = new ItemStack(Material.REDSTONE_BLOCK,(int)(Math.random()*25)+5);
			  }break;
			  case 6 :{
				  item = new ItemStack(Material.DIAMOND,(int)(Math.random()*4)+1);
			  }break;
			  case 7 :{
				  item = new ItemStack(Material.DIAMOND_BLOCK,(int)(Math.random()*2)+1);
			  }break;
			  case 8 :{
				  item = new ItemStack(Material.EMERALD,(int)(Math.random()*2)+1);
			  }break;
		  }
	  }
	return item;
}

  @EventHandler
  public void onEnemyKill(EntityDeathEvent e) {
	  if (e.getEntity().getType()==EntityType.SQUID || e.getEntity().getType()==EntityType.SLIME || e.getEntity().getType()==EntityType.ZOMBIE || e.getEntity().getType()==EntityType.SPIDER || e.getEntity().getType()==EntityType.SKELETON || e.getEntity().getType()==EntityType.CREEPER
		|| e.getEntity().getType()==EntityType.PIG_ZOMBIE || e.getEntity().getType()==EntityType.GHAST || e.getEntity().getType()==EntityType.ENDERMAN || e.getEntity().getType()==EntityType.BLAZE
		|| e.getEntity().getType()==EntityType.ENDER_DRAGON || e.getEntity().getType()==EntityType.WITHER || e.getEntity().getType()==EntityType.CHICKEN || e.getEntity().getType()==EntityType.SHEEP
		 || e.getEntity().getType()==EntityType.PIG || e.getEntity().getType()==EntityType.COW || e.getEntity().getType()==EntityType.OCELOT || e.getEntity().getType()==EntityType.WOLF
		  || e.getEntity().getType()==EntityType.MUSHROOM_COW) {
		  LivingEntity f = e.getEntity();
		  if (f.getType()==EntityType.ZOMBIE || 
				  f.getType()==EntityType.SKELETON || 
				  f.getType()==EntityType.PIG_ZOMBIE || 
				  f.getType()==EntityType.SPIDER || 
				  f.getType()==EntityType.CREEPER || 
				  f.getType()==EntityType.ENDERMAN) {
			  //if (Math.random()<=0.005) {
			  /*
			  if (Math.random()<=0.005) {
				  //0.5% chance of a mystical book dropping.
				  if (f.getKiller()!=null) {
				    ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
				    BookMeta bookdata = (BookMeta)book.getItemMeta();
				    int choosebook = (int)(Math.random()*9.0d);
				    switch (choosebook) {
					    case 0:{
						    bookdata.setAuthor("Steve");
						    bookdata.setTitle("Dangers of the Nether");
						    bookdata.addPage("Dangers of the Nether\n"+ChatColor.ITALIC+"  by Steve\n======\n"+ChatColor.RESET+"It didn't take me long to realize where we were. It was dangerous, very hot, and lots of torturous screams could be heard everywhere. I barely had time","to take it all in before a huge fireball was shot in my direction. I quickly looked to my side to find a convenient safe passage and hid there for a few minutes. I guess I was in there longer than I thought, I ended","up falling asleep and waking up to notice there was something scary on the wall.\n\n"+ChatColor.ITALIC+"\"TURN AND LEAVE NOW. DANGEROUS TO STAY. REAL WORLD HAS WHAT YOU ARE LOOKING FOR. I ONLY REMEMBER THE 1ST X POSITION...",ChatColor.ITALIC+"...IT WAS 7! I AM *POSITIVE*\""+ChatColor.RESET+"\n\nI did not know what to think. The 1st X position? I quickly remembered the 7 and sprinted out of the nether portal. And to think that was *THE END* of my adventures...");
					    }break;
					    case 1:{
					    	bookdata.setAuthor("Lacey");
					    	bookdata.setTitle("A Hole in the Flower Garden");
					    	bookdata.addPage("A Hole in the Flower Garden\n"+ChatColor.ITALIC+"  by Lacey\n======\n"+ChatColor.RESET+"It was a lovely day to pick flowers in the garden, they just finished blooming fully. I was so excited to pick them, but I didn't do so until","after I've taken in all the wonderful scents! Smelling all the flowers and wonderful smells of plants and trees and nature and grass. It was perfect. I was mindlessly walking along this prairie when I stumbled.","I fell, and fell, and fell. I hit the bottom of a ravine. It didn't even occur to me I would just walk into one. I took some minor damage, but when I got up, I noticed something strange.","There were two or three zombies gathered around a wall, etching something into it. I went over to read it once the zombies walked away. I saw on the wall:\n\n"+ChatColor.ITALIC+"X-2:6 <--END","It looked cryptic to me, but why would they write that on the wall? I quickly scribbled it down on a notepad I had in my pocket and started climbing out of the ravine to tend to my lovely flowers. What a day!");
					    }break;
					    case 2:{
					    	bookdata.setAuthor("Jimmy");
					    	bookdata.setTitle("Messages in Music");
					    	bookdata.addPage("Messages in Music\n"+ChatColor.ITALIC+"  by Jim"+"\n======"+ChatColor.RESET+"\nI popped out the disk from my Jukebox to put in another, I could jam to these all day! As I was looking through my collection for something to listen to","I found a really bent up disk. 'No way this could still play', I thought to myself. I put it in, and it crackled and snarled, but it was indeed playing! At first I heard some faint resemblence of music, but then suddenly,","a hiss, an explosion, and then 'CREEEEEEEEE----- 7X XSSSSSSSSSS 3RD EEEEEEE' mental images appeared in my head, but the 7X and 3RD stood out the most. It's like I was seeing them in my head while hearing something else!","I couldn't stand up anymore, or think. I forcibly reached up with my weak hand to find the eject button on the player and when I found the familiar nub in the button, pressed down on it and out popped the disk, hitting my face,","but putting me back into reality. Something was telling me that the 3RD and 7X was important. But I couldn't quite put my tongue on it.");
					    }break;
					    case 3:{
					    	bookdata.setAuthor("Creeper");
					    	bookdata.setTitle("HISS");
					    	bookdata.addPage("Y do i exisssst. nobody knowssss. i just want a hugssssss, HUGSSSSSSS. but i don't know Y i exist. there's no Y in the first position. it'sssss jusssst two digitssssss.... SSSSSSSSS. *THE END*");
					    }break;
					    case 4:{
					    	bookdata.setAuthor("Marco");
					    	bookdata.setTitle("The Hunt for a Dragon");
					    	bookdata.addPage("The Hunt for a Dragon\n"+ChatColor.ITALIC+"  by Marco"+"\n======"+ChatColor.RESET+"\nThere exists a rumor that a mythical dragon could be found in the depths of our world. It is even said he doesn't exist in OUR world, but ANOTHER world altogether!","That my friends already boggles me, but where the heck would I go to find it then? I have been told he exists, and I know he is. I believe deep in my heart. I searched day and night under and over ground.","One day I found something strange in the ground. It was pink wool, in the middle of a cave on the ground. It even said something, but I couldn't tell from so close up. So I literally dug all the way to the surface, keeping the boundaries","of that word uncovered the whole way up. When I got to the top and looked down, I was relieved to find it was made out of markings I could discern. It said: 'Y: X3?' It was definitely a weird group of symbols, but I have a strong feeling"," that it is directly linked with that dragon I am trying to hunt down. Maybe I can gather more clues and try to decipher the location of this thing.");
					    }break;
					    case 5:{
					    	bookdata.setAuthor("Steve");
					    	bookdata.setTitle("Cooking Food");
					    	bookdata.addPage("Cooking Food\n"+ChatColor.ITALIC+"  by Steve"+"\n======"+ChatColor.RESET+"\nIt was a bright and rather typical sunny day in the Minecraft world. I don't actually think it was very hot either. I just managed to catch a few fish and was cooking them up.","It wasn't long before I got distracted and heard a funny noise. It was an ocelote. Lucky me, an ocelote has smelled the scent of my fish! I grab a few and hold it out for the ocelote. It slowly creeps over, and then takes it and runs from me.","I thought it was full and finished cooking the rest of the fish. However, the ocelote returned a few minutes later with a neatly-folded piece of paper in its mouth. It came up to me and set it down, like it was some message just for me.","I opened it up and it read:\n\n"+ChatColor.ITALIC+"Don't let the fish get to your tongue! If you know what's wise, you will investigate further. The 3rd position of Y being the number 5."+ChatColor.RESET+"\n\n","I didn't notice the ocelote run away, but I knew something FISHY was going on. That message seemed important for some reason, I've seen similar cryptic messages before... Perhaps I'll hold onto this in case I need it in the future.");
					    }break;
					    case 6:{
					    	bookdata.setAuthor("Fredric");
					    	bookdata.setTitle("Math Behind the Void");
					    	bookdata.addPage("Math Behind the Void\n"+ChatColor.ITALIC+"  by Fredric"+"\n======"+ChatColor.RESET+"\nThis book describes a few principles that the void in this world follows. While no one has actually seen the void, we have found a few theories and rules regarding them.","1. The Void has a Light Level of -14. The Void actually absorbs light coming from light sources and thus, if The Void is ever opened to the real world, would suck up the light from it.","2. The Void always has a volume of 50,000m, being 50m x 20m x 50m. This means that The Void, regardless of location is always the same exact size. This would conclude to us that The Void is co-existing and multiple instaces of it may exist in the same realm.","3. Any Entity entering The Void will not be able to escape The Void as time passes much more quickly inside The Void. This means Entities that enter The Void feel accelerated processes and cannot combat it, since the time outside is behind them.","4. A point of connection between The Void and other dimensions has to exist, for The Void to exist. Speculation has it that one of these points has been leaked into the world, and is accessible by us directly. After further research,","we have learned that one of these points is located on the 1st respective numeral along our Z axis with the number 4. It has also been proven that this number has to be negative as the other two sources interacting with The Void are positive.");
					    }break;
					    case 7:{
					    	bookdata.setAuthor("Robert");
					    	bookdata.setTitle("TNT");
					    	bookdata.addPage("TNT\n"+ChatColor.ITALIC+"  by Robert"+"\n======"+ChatColor.RESET+"\nYou know, the easiest way to clear a tunnel is using an item called TNT. It is a rather small block, but it is loaded with gunpowder. When lit by an external force, it ignites","with the force of 5 Creeper explosions to clear whole caves out. Well lo and behold one day I discovered a rather strange abandoned mineshaft. It wasn't normal for sure, because there were green vines everywhere and lots of strange doors.","It was like somebody lived here ages ago, and I am discovering the ruins of such a place. Inoperable levers, a few mobs I have to kill here and there that have made this area their designated home. It was a mess. But I did discover that","someone was trying to find what we would call 'The End'. It's a magical place, and I believe with the right amount of effort, we can find it someday too. He had scribbled the coordinates of the location he was trying to reach.","However, most of it is faded out and I can only tell faintly the remains of it: \n\n"+ChatColor.ITALIC+"X:---\nY:---\nZ:--7-"+ChatColor.RESET+"\n\nYep, that's about it.","Hopefully by me recording this data, someone else can fill in the remaining numbers and we can all find The End together. Someday...");
					    }break;
					    case 8:{
					    	bookdata.setAuthor("Joshua");
					    	bookdata.setTitle("Fourside");
					    	bookdata.addPage("Fourside\n"+ChatColor.ITALIC+"  by Joshua"+"\n======"+ChatColor.RESET+"\n"+ChatColor.DARK_BLUE+"ABANDONED PROJECT"+ChatColor.RESET+". A city that would be developed with the best technology and the highest standards. It would","succeed every single Minecraft city that has ever been built. Casinos, diamond-lined walkways, towering skyscrapers as far as the eye can see. Museums, Libraries, Educational Institutions. This mega-city would be able to hold","and sustain every single Minecrafter in existence. But no, something went terribly wrong. Our engineering team finally developed the perfect transportation system and we were wiring it up to our fusion power plant.","Something went horribly wrong. The Fusion power plant started self-combusting itself, leaving behind hyper-cold atoms. This caused nucleic waste to interact with the environment around itself and freezing the whole world as we knew it.","The city idea as we knew it was scrapped, and we would wait 2000 years before we could attempt this again. We wrote plans for a much more portable solution and have named it 'Twoside' and archived it appropriately.","Maybe someone will pick up that book and be able to make the future bright with a mini version of Fourside. That being said, we left the 3rd slot of the Z position of our city at 7. This should give you enough clue as to where NOT to build.");
					    }break;
				    }
				    book.setItemMeta(bookdata);
				    //p.setItemInHand(book);
				    f.getKiller().getInventory().addItem(book);
				    f.getKiller().updateInventory();
				    f.getKiller().sendMessage(ChatColor.LIGHT_PURPLE+"You feel a magical presence get inserted into your inventory.");
				  }
			  }*/
		  }
		  if (f.getCustomName()!=null) {
			  if (f.getCustomName().contains("Strong")) {
				  e.setDroppedExp(e.getDroppedExp()*2);
			  }
			  if (f.getCustomName().contains("II")) {
				  e.setDroppedExp(e.getDroppedExp()*2);
			  }
			  if (f.getCustomName().contains("Venomous")) {
				  e.setDroppedExp(e.getDroppedExp()*2);
			  }
			  if (f.getCustomName().contains("Snaring")) {
				  e.setDroppedExp(e.getDroppedExp()*2);
			  }
			  if (f.getCustomName().contains("Charge")) {
				  e.setDroppedExp(e.getDroppedExp()*2);
			  }
			  if (f.getCustomName().contains("Explosive")) {
				  e.setDroppedExp(e.getDroppedExp()*2);
			  }
			  if (f.getCustomName().contains("Destructive")) {
				  e.setDroppedExp(e.getDroppedExp()*2);
			  }
			  if (f.getCustomName().contains("Sniper")) {
				  e.setDroppedExp(e.getDroppedExp()*2);
			  }
			  if (f.getCustomName().contains(ChatColor.DARK_PURPLE+"")) {
				  e.setDroppedExp(e.getDroppedExp()*20);
				  f.setHealth(0);
				  this.plugin.BOSS_DEFEAT=100;
				  this.plugin.BOSS_DEFEAT_LOC=f.getLocation();
				  //Create a chest at the death spot.
				  Bukkit.getWorld("world").getBlockAt(f.getLocation()).setType(Material.CHEST);
				  Chest c=(Chest)Bukkit.getWorld("world").getBlockAt(f.getLocation()).getState();
				  for (int i=0;i<27;i++) {
					  ItemStack item = null;
					  if (Math.random()<=0.3) {
						  item = getGoodie();
						  c.getBlockInventory().setItem(i, item);
					  }
				  }
			  }
		  }
		  if (this.plugin.getAccountsConfig().getBoolean("halloween-enabled")) {
			  e.setDroppedExp(e.getDroppedExp()*2);
		  }
		  Player p = null;
		  for (int i=0;i<this.plugin.hitmoblist.size();i++) {
			  for (int j=0;j<this.plugin.hitmoblist.get(i).id.size();j++) {
				  if (this.plugin.hitmoblist.get(i).id.contains(e.getEntity().getUniqueId())) {
					  //This is the player that killed. Also identify them.
					  p = this.plugin.hitmoblist.get(i).p;
					  //Bukkit.getPlayer("sigonasr2").sendMessage("Found: "+e.getEntity().getUniqueId().toString());
					  //this.plugin.gainMoneyExp(this.plugin.hitmoblist.get(i).p,"Support",0.025,3);
					  this.plugin.hitmoblist.get(i).id.remove(e.getEntity().getUniqueId());
					  this.plugin.hitmoblist.get(i).p.giveExp(e.getDroppedExp());
					  if (e.getDroppedExp()!=0) {
						  p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.9f, 1f);
					  }
					  break;
				  }
			  }
		  }
		  if (p!=null) {
			  for (int x=-10;x<10;x++) {
				  for (int y=-3;y<3;y++) {
					  for (int z=-10;z<10;z++) {
						  if (f.getWorld().getBlockAt(f.getLocation().add(x,y,z)).getType()==Material.MOB_SPAWNER) {
							  //This is near a spawner. Do not drop exp orbs or items.
							  List<ItemStack> drops = e.getDrops();
							  for (int i=0;i<drops.size();i++) {
								  drops.remove(i);
								  i--;
							  }
							  e.setDroppedExp(0);
						  }
					  }
				  }
			  }
			  if (this.plugin.PlayerinJob(p, "Enchanter") && this.plugin.getJobLv("Enchanter", p)>=5) {
				  e.setDroppedExp(e.getDroppedExp()*2);
			  }
			  p.giveExp(e.getDroppedExp());
			  if (e.getDroppedExp()!=0) {
				  p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.9f, 1);
			  }
			  //p.sendMessage(f.getType()+" is mad at you.");
			  if (!this.plugin.PlayerinJob(p, "Support")) {
				  //Make sure a support did not kill it.
				  for (int i=0;i<this.plugin.supportmoblist.size();i++) {
					  for (int j=0;j<this.plugin.supportmoblist.get(i).id.size();j++) {
						  if (this.plugin.supportmoblist.get(i).id.contains(e.getEntity().getUniqueId())) {
							  //Award the support player.
							  //Bukkit.getPlayer("sigonasr2").sendMessage("Found: "+e.getEntity().getUniqueId().toString());
							  this.plugin.gainMoneyExp(this.plugin.supportmoblist.get(i).p,"Support",0.05,6);
							  this.plugin.supportmoblist.get(i).id.remove(e.getEntity().getUniqueId());
							  this.plugin.supportmoblist.get(i).p.giveExp(e.getDroppedExp()/2);
							  if (e.getDroppedExp()/2!=0) {
								  p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.4f, 0.6f);
							  }
							  break;
						  }
					  }
				  }
			  }
			  for (int i=0;i<this.plugin.hitmoblist.size();i++) {
				  for (int j=0;j<this.plugin.hitmoblist.get(i).id.size();j++) {
					  if (this.plugin.hitmoblist.get(i).p!=p && this.plugin.hitmoblist.get(i).id.contains(e.getEntity().getUniqueId())) {
						  //Award the support player.
						  //Bukkit.getPlayer("sigonasr2").sendMessage("Found: "+e.getEntity().getUniqueId().toString());
						  //this.plugin.gainMoneyExp(this.plugin.hitmoblist.get(i).p,"Support",0.025,3);
						  this.plugin.hitmoblist.get(i).id.remove(e.getEntity().getUniqueId());
						  this.plugin.hitmoblist.get(i).p.giveExp(e.getDroppedExp()/4);
						  if (e.getDroppedExp()/4!=0) {
							  p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.4f, 0.6f);
						  }
						  break;
					  }
				  }
			  }
			  if (this.plugin.PlayerinJob(p, "Farmer")) {
				  if (this.plugin.getJobLv("Farmer", p)>=10) {
					  List<ItemStack> drops = e.getDrops();
					  for (int i=0;i<drops.size();i++) {
						  if (drops.get(i).getType()==Material.BONE) {
							  drops.get(i).setAmount(drops.get(i).getAmount()*3);
						  }
					  }
				  }
			  }
			  if (this.plugin.PlayerinJob(p, "Hunter")) {
				  if (e.getEntity().getType()==EntityType.SQUID) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.00,0);
				  }
				  if (e.getEntity().getType()==EntityType.SLIME) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.000,0);
				  }
				  if (e.getEntity().getType()==EntityType.ZOMBIE) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.025,5);
					  //p.sendMessage("You killed this.");
				  }
				  if (e.getEntity().getType()==EntityType.SPIDER) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.02,4);
					  //p.sendMessage("You killed this.");
				  }
				  if (e.getEntity().getType()==EntityType.SKELETON) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.035,7);
					  //p.sendMessage("You killed this.");
				  }
				  if (e.getEntity().getType()==EntityType.CREEPER) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.05,10);
				  }
				  if (e.getEntity().getType()==EntityType.PIG_ZOMBIE) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.08,16);
				  }
				  if (e.getEntity().getType()==EntityType.GHAST) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.10,12);
				  }
				  if (e.getEntity().getType()==EntityType.ENDERMAN) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.125,16);
				  }
				  if (e.getEntity().getType()==EntityType.BLAZE) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.15,20);
				  }
				  if (e.getEntity().getType()==EntityType.ENDER_DRAGON) {
					  this.plugin.gainMoneyExp(p,"Hunter",100.00,3000);
				  }
				  if (e.getEntity().getType()==EntityType.WITHER) {
					  this.plugin.gainMoneyExp(p,"Hunter",275.00,7800);
				  }
			  }
			  if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify3")) {
				  p.sendMessage(ChatColor.DARK_GREEN+""+ChatColor.ITALIC+"Gained "+e.getDroppedExp()+" exp.");
			  }
			  if (this.plugin.getConfig().getBoolean("halloween-enabled") && p.getWorld().getName().equalsIgnoreCase("world") && (e.getEntity() instanceof Sheep)) {
				  Sheep s = (Sheep)e.getEntity();
				  if (s.getColor()==DyeColor.BLUE) {
					  //Drop something special or two.
					  int times=(int)(Math.random()*3)+1;
					  while (times>0) {
						  ItemStack reward = getGoodie();
						  Bukkit.getWorld("world").dropItemNaturally(s.getLocation(), reward);
						  times--;
					  }
				  }
			  }
		  } else {
			  //We're going to see if a player killed it themselves then.
			  Player pp = null;
			  for (int i=0;i<this.plugin.hitmoblist.size();i++) {
				  for (int j=0;j<this.plugin.hitmoblist.get(i).id.size();j++) {
					  if (this.plugin.hitmoblist.get(i).id.contains(e.getEntity().getUniqueId())) {
						  //This is the player that killed. Also identify them.
						  pp = this.plugin.hitmoblist.get(i).p;
						  //Bukkit.getPlayer("sigonasr2").sendMessage("Found: "+e.getEntity().getUniqueId().toString());
						  //this.plugin.gainMoneyExp(this.plugin.hitmoblist.get(i).p,"Support",0.025,3);
						  this.plugin.hitmoblist.get(i).id.remove(e.getEntity().getUniqueId());
						  this.plugin.hitmoblist.get(i).p.giveExp(e.getDroppedExp());
						  if (e.getDroppedExp()!=0) {
							  pp.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.9f, 1f);
						  }
						  break;
					  }
				  }
			  }
			  
			  //Check other players and give them assist experience.

			  for (int i=0;i<this.plugin.hitmoblist.size();i++) {
				  for (int j=0;j<this.plugin.hitmoblist.get(i).id.size();j++) {
					  if (this.plugin.hitmoblist.get(i).id.contains(e.getEntity().getUniqueId()) && this.plugin.hitmoblist.get(i).p!=pp) {
						  //This is the player that killed. Also identify them.
						  Player tempp = this.plugin.hitmoblist.get(i).p;
						  if (this.plugin.PlayerinJob(tempp, "Support")) {
						  //Bukkit.getPlayer("sigonasr2").sendMessage("Found: "+e.getEntity().getUniqueId().toString());
						  //this.plugin.gainMoneyExp(this.plugin.hitmoblist.get(i).p,"Support",0.025,3);
							  this.plugin.hitmoblist.get(i).id.remove(e.getEntity().getUniqueId());
							  this.plugin.hitmoblist.get(i).p.giveExp(e.getDroppedExp()/4);
							  if (e.getDroppedExp()/4!=0) {
								  tempp.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.4f, 0.6f);
							  }
						  } else {
							  this.plugin.hitmoblist.get(i).id.remove(e.getEntity().getUniqueId());
							  this.plugin.hitmoblist.get(i).p.giveExp(e.getDroppedExp()/2);
							  if (e.getDroppedExp()/2!=0) {
								  tempp.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.4f, 0.6f);
							  }
						  }
						  break;
					  }
				  }
			  }
			  
		  }
		  e.setDroppedExp(0);
		  /*
		  if (f.getType()==EntityType.PLAYER) {
			  Player p = (Player)f;
			  Bukkit.getPlayer("sigonasr2").sendMessage("EXP Lost: "+p.get);
			  if (this.plugin.PlayerinJob(p, "Explorer")) {
				  if (this.plugin.getJobLv("Explorer", p)>=10) {
					  //Don't lose levels.
					  
				  }
			  }
		  }*/
	  }
  }
  
  @EventHandler
  public void onFoodLevelChange(FoodLevelChangeEvent e) {
	  //Check for nearby support.
	  if (e.getEntity().getType()==EntityType.PLAYER) {
		  HumanEntity p = (HumanEntity)e.getEntity();
		  if (this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat9")>0) {
			  if (Math.random()<=this.plugin.getStatBonus(8, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat9"))/100.0d) {
				  e.setFoodLevel(e.getFoodLevel()+1);
			  }
		  }
		  List<Entity> nearby = p.getNearbyEntities(10, 10, 10);
		  for (int i=0;i<nearby.size();i++) {
			  if (nearby.get(i).getType()==EntityType.PLAYER && this.plugin.PlayerinJob((Player)nearby.get(i), "Support") && this.plugin.getJobLv("Support", (Player)nearby.get(i))>=20) {
				  if (Math.random()<=0.50) {
					  e.setFoodLevel(e.getFoodLevel()+1);
				  }
			  }
		  }
	  }
  }
  
  @EventHandler
  public void onBucketEmpty(PlayerBucketEmptyEvent e) {
	  Player p = e.getPlayer();
	  if (e.getBucket()==Material.WATER_BUCKET) {
		  if (this.plugin.PlayerinJob(p, "Support")) {
			  //Check if someone's with us. If not, we don't get awarded for supporting.
			  List<Entity> nearby = p.getNearbyEntities(10, 20, 10);
			  boolean playernearby=false;
			  boolean onfire=false;
			  for (int i=0;i<nearby.size();i++) {
				  if (nearby.get(i).getType()==EntityType.PLAYER) {
					  playernearby=true;
					  if (((Player)nearby.get(i)).getFireTicks()>0 && ((Player)nearby.get(i)).getHealth()<=8) {
						  //They are on fire, you intend to douse them.
						  this.plugin.gainMoneyExp(p,"Support",4.80,240);
					  }
				  }
			  }
			  if (playernearby) {
				  //Check for lava below. If we find some, award some money and experience.
				  boolean foundlava=false;
				  for (int x=-10;x<10;x++) {
					  for (int y=-20;y<0;y++) {
						  for (int z=-10;z<10;z++) {
							  if (Bukkit.getWorld("world").getBlockAt(p.getLocation().getBlockX()+x,p.getLocation().getBlockY()+y,p.getLocation().getBlockZ()+z).getType()==Material.LAVA) {
								  foundlava=true;
								  break;
							  }
						  }
						  if (foundlava) {
							  break;
						  }
					  }
					  if (foundlava) {
						  break;
					  }
				  }
				  if (foundlava) {
					  this.plugin.gainMoneyExp(p,"Support",0.15,60);
				  }
			  }
		  }
	  }
  }
  
  
  @EventHandler
  public void onLightningStrike(LightningStrikeEvent e) {
	  if (this.plugin.last_lightning_random_time<Bukkit.getWorld("world").getFullTime()) {
		  this.plugin.last_lightning_random_time=Bukkit.getWorld("world").getFullTime()+60;
		  if (Math.random()<=0.125) {
			  LightningStrike strike = e.getLightning();
			  int i=(int)(Math.random()*4);
			  for (int j=0;j<i;j++) {
				  double newx=Math.random()*20-Math.random()*20;
				  double newz=Math.random()*20-Math.random()*20;
				  Location newloc = strike.getLocation().add(newx,0,newz);
				  newloc.setY(Bukkit.getWorld("world").getHighestBlockYAt(newloc));
				  Bukkit.getWorld("world").strikeLightning(newloc);
			  }
		  }
		  //There is also a random chance lightning will be created at each player's location.
		  Player[] plist = Bukkit.getOnlinePlayers();
		  for (int i=0;i<plist.length;i++) {
			  if (Math.random()<=0.125) {
				  LightningStrike strike = e.getLightning();
				  int k=(int)(Math.random()*4);
				  for (int j=0;j<k;j++) {
					  double newx=Math.random()*20-Math.random()*20;
					  double newz=Math.random()*20-Math.random()*20;
					  Location newloc = plist[i].getLocation().add(newx,0,newz);
					  newloc.setY(Bukkit.getWorld("world").getHighestBlockYAt(newloc));
					  Bukkit.getWorld("world").strikeLightning(newloc);
				  }
			  }
		  }
	  }
  }
  
  @EventHandler
  public void onFishCatch(PlayerFishEvent e) {
	  if (e.getState()==State.CAUGHT_FISH) {
		  Player p = e.getPlayer();
		  if (this.plugin.PlayerinJob(p, "Fisherman")) {
			  this.plugin.gainMoneyExp(p,"Fisherman",0.175,3);
			  if (this.plugin.getJobLv("Fisherman", p)>=5) {
				  //Half chance to set the durability back by one.
				  if (p.getItemInHand().getType()==Material.FISHING_ROD) {
					  if (p.getItemInHand().getDurability()>0) {
						  if (Math.random()>=0.5) {
							  p.getItemInHand().setDurability((short)(p.getItemInHand().getDurability()-1));
						  }
					  }
				  }
			  }
			  if (this.plugin.getJobLv("Fisherman", p)>=20) {
				  e.setExpToDrop(e.getExpToDrop()*2);
				  int i=4;
				  while (i>0) {
					  if (Math.random()<=0.25) {
						  this.plugin.gainMoneyExp(p,"Fisherman",0.175,3);
						  if (Math.random()<=0.50) {
							  p.getInventory().addItem(new ItemStack(Material.COOKED_FISH));
							  this.plugin.gainMoneyExp(p,"Fisherman",0.125,2);
						  } else {
							  p.getInventory().addItem(new ItemStack(Material.RAW_FISH));
						  }
					  }
					  i--;
				  }
			  } else
			  if (this.plugin.getJobLv("Fisherman", p)>=10) {
				  e.setExpToDrop(e.getExpToDrop()*2);
				  if (Math.random()<=0.25) {
					  p.getInventory().addItem(new ItemStack(Material.RAW_FISH));
					  this.plugin.gainMoneyExp(p,"Fisherman",0.175,3);
				  }
			  }
			  
		  }
	  }
  }
  
  @EventHandler
  public void onWorldLoad(WorldLoadEvent e) {
	  /*for (int i=0;i<e.getWorld().getEntities().size();i++) {
		Entity f = e.getWorld().getEntities().get(i);
		if (f.getType()==EntityType.LIGHTNING) {
			//Bukkit.getLogger().info("Found a LIGHTNING entity. Trying to remove.");
			e.getWorld().getEntities().get(i).remove();
			i--;
		}
	  }*/
  }
  
  @EventHandler
  public void onChunkStart(ChunkLoadEvent e) {
	    /*for (int i=0;i<Bukkit.getWorld("world").getEntities().size();i++) {
	    	Entity f = Bukkit.getWorld("world").getEntities().get(i);
	    	//Bukkit.getLogger().info("This is a "+f.getType()+" entity.");
	    	if (f.getType()==EntityType.LIGHTNING) {
				//Bukkit.getLogger().info("Found a LIGHTNING entity. Trying to remove.");
				Bukkit.getWorld("world").getEntities().get(i).remove();
				i--;
	    	}
	    }*/
		if (!this.plugin.cleaned) {
		    int arrows=0;
		    for (int i=0;i<Bukkit.getWorld("world").getEntities().size();i++) {
		    	Entity f = Bukkit.getWorld("world").getEntities().get(i);
		    	if (f.getType()==EntityType.ARROW) {
		    		//Bukkit.getLogger().info("Remove arrow "+arrows+" @ <"+f.getLocation().getX()+"> <"+f.getLocation().getY()+"> <"+f.getLocation().getZ()+">");
		    		f.remove();
		    		arrows++;
		    	}
		    }
		    this.plugin.cleaned=true;
		}
		  if (!e.isNewChunk()) { //Make sure this chunk is an existing one.
			//Attempt to load up the custom chunk.
			List<String> debugmessages = new ArrayList<String>();
			FileConfiguration customchunk = this.plugin.reloadChunksConfig(e.getChunk().getX(), e.getChunk().getZ());
			if (!customchunk.contains("animal-reset2")) {
				customchunk.set("animal-reset2", Long.valueOf(Bukkit.getWorld("world").getFullTime()+17280000));
				Chunk c = e.getChunk();
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
				if (Bukkit.getWorld("world").getFullTime()>customchunk.getLong("animal-reset2")) {
					customchunk.set("animal-reset2", Long.valueOf(Bukkit.getWorld("world").getFullTime()+17280000));
					Chunk c = e.getChunk();
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
				Chunk c = e.getChunk();
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
				Chunk c = e.getChunk();
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
			this.plugin.saveChunksConfig(customchunk, e.getChunk().getX(), e.getChunk().getZ());
			  if (debugmessages.size()>0) {
				  for (int i=0;i<debugmessages.size();i++) {
					  //Bukkit.getLogger().info(debugmessages.get(i));
				  }
				  //Bukkit.getLogger().info(new String(new char[("Chunk "+e.getChunk().getX()+","+e.getChunk().getZ()+" ("+e.getChunk().getX()*16+","+e.getChunk().getZ()*16+")").length()]).replace("\0", "="));
				  //Bukkit.getLogger().info("Chunk "+e.getChunk().getX()+","+e.getChunk().getZ()+" ("+e.getChunk().getX()*16+","+e.getChunk().getZ()*16+")");
			  }
		  }
	  }
  
  @EventHandler
  public void onChunkLoad(ChunkPopulateEvent e) {
	  Chunk c = e.getChunk();
	  if (e.getWorld().getName().equalsIgnoreCase("world")) {
	  int removeddiamonds=0,keptdiamonds=0,removediron=0,keptiron=0;
	  for (int x=0;x<16;x++) {
		  for (int y=5;y<100;y++) {
			  for (int z=0;z<16;z++) {
				  Block b = c.getBlock(x, y, z);
				  if (b.getType()==Material.DIAMOND_ORE) {
					  if (Math.random()<=0.4) {
						  removeddiamonds++;
						  ////Bukkit.getLogger().info("A diamond has been removed from this chunk.");
						  b.setType(Material.STONE);
					  } else {
						  keptdiamonds++;
					  }
				  } else 
				  if (b.getType()==Material.IRON_ORE) {
					  if (Math.random()<=0.6) {
						  removediron++;
						  ////Bukkit.getLogger().info("A diamond has been removed from this chunk.");
						  b.setType(Material.STONE);
					  } else {
						  keptiron++;
					  }
				  }
			  }
		  }
	  }
	  //Bukkit.getLogger().info(keptdiamonds+"/"+(removeddiamonds+keptdiamonds)+" diamonds, "+keptiron+"/"+(removediron+keptiron)+" iron kept for this new chunk.");
	  }
	  
	  Player[] playerlist = Bukkit.getOnlinePlayers();
	  //Whichever player is closest gets the credit.
	  Player closestplayer=null;
	  double closestdistance=99999999;
	  for (int i=0;i<playerlist.length;i++) {
		  double distance=Math.abs(playerlist[i].getLocation().getX()-c.getX()*16)+Math.abs(playerlist[i].getLocation().getZ()-c.getZ()*16);
		  if (distance<closestdistance) {
			  closestplayer = playerlist[i];
			  distance=closestdistance;
		  }
	  }
	  if (closestplayer!=null && this.plugin.PlayerinJob(closestplayer, "Explorer")) {
		  //closestplayer.sendMessage("You generated a new chunk!");
		  this.plugin.gainMoneyExp(closestplayer,"Explorer",0.00,0.09);
	  }
  }
  

  @EventHandler
  public void onInventoryOpen(InventoryOpenEvent e) {
	  // █ ▌((Player)e.getPlayer()).sendMessage(((Player)e.getPlayer()).getScoreboard().getPlayerTeam((OfflinePlayer)e.getPlayer()).getName());
	  Player p = (Player)e.getPlayer();
	  p.getScoreboard().getTeam(p.getName()).setPrefix(ChatColor.DARK_GRAY+"");
	  if (p.hasPermission("group.moderator")) {
		  p.getScoreboard().getTeam(p.getName()).setPrefix(ChatColor.DARK_GREEN+"");
	  }
	  if (p.hasPermission("group.administrators")) {
		  p.getScoreboard().getTeam(p.getName()).setPrefix(ChatColor.DARK_PURPLE+"");
	  }
	  if (this.plugin.getConfig().getBoolean("halloween-enabled")) {
		  for (int m=0;m<e.getInventory().getSize();m++) {
			  if (e.getInventory().getContents()[m]!=null && e.getInventory().getContents()[m].getType()==Material.PUMPKIN_PIE) { 
				  if (e.getInventory().getContents()[m].getItemMeta().getDisplayName()!=null && e.getInventory().getContents()[m].getItemMeta().getDisplayName().contains("Pie ")) {
					  int numb = Integer.valueOf(e.getInventory().getContents()[m].getItemMeta().getDisplayName().replace("Pie ",""));
					  if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".halloween.chest"+numb)) {
						  p.closeInventory();
						  p.sendMessage("You already got this magic pie!");
						  e.setCancelled(true);
					  } else {
						  //Show the user a fake inventory containing the magic pie.
						  this.plugin.getAccountsConfig().set(p.getName()+".halloween.chest"+numb, Boolean.valueOf(true));
						  this.plugin.saveAccountsConfig();
						  p.closeInventory();
						  e.setCancelled(true);
						  Inventory a = Bukkit.createInventory(p, 9);
	    				 ItemStack pump = new ItemStack(Material.PUMPKIN_PIE);
	    				 ItemMeta meta = pump.getItemMeta();
	    				 List<String> newlore = new ArrayList<String>();
	    				 newlore.add("Requires "+((int)(Math.random()*1000)+100)+" Pumpkin Pie in inventory");
	    				 newlore.add("to convert to a legendary equipment item.");
	    				 meta.setLore(newlore);
	    				 meta.setDisplayName(ChatColor.GREEN+"Magical Pumpkin Pie");
	    				 pump.setItemMeta(meta);
						 a.addItem(pump);
						 p.openInventory(a);
					  }
				  }
			  }
		  }
		  for (int m=0;m<p.getInventory().getContents().length;m++) {
			  if (p.getInventory().getContents()[m]!=null && p.getInventory().getContents()[m].getType()==Material.PUMPKIN_PIE) { 
				  //First see if it's a magical pumpkin pie.
				  if (p.getInventory().getContents()[m].getItemMeta().getLore()!=null) {
					  //It has lore! See if we can get the number of pumpkin pies from it.
					  int pies=0;
					  List<String> data = p.getInventory().getContents()[m].getItemMeta().getLore();
					  //newlore.add("Requires "+((int)(Math.random()*1000)+100)+" Pumpkin Pie in inventory");
					  ItemStack magic_pie = null;
					  for (int i=0;i<data.size();i++) {
						  if (data.get(i).contains("Requires ") && data.get(i).contains(" Pumpkin Pie in inventory")) {
							  pies = Integer.valueOf((data.get(i).replace("Requires ", "")).replace(" Pumpkin Pie in inventory", ""));
							  Bukkit.getLogger().info("Found the magic pie. Amount required is "+pies);
							  magic_pie=p.getInventory().getContents()[m].clone();
							  break;
						  }
					  }
					  //Now count all pumpkin pies in inventory. If they are greater than the amount in the inventory (and are not special pies), remove them.
					  int piecount=0;
					  ItemStack ideal_pie = null;
					  for (int i=0;i<p.getInventory().getContents().length;i++) {
						  if (p.getInventory().getContents()[i]!=null && p.getInventory().getContents()[i].getType()==Material.PUMPKIN_PIE && p.getInventory().getContents()[i].getItemMeta().getLore()==null) {
							 piecount+=p.getInventory().getContents()[i].getAmount(); 
							 ideal_pie = p.getInventory().getContents()[i].clone();
						  }
					  }
					  Bukkit.getLogger().info("We have "+piecount+" pies.");
					  if (ideal_pie!=null && magic_pie!=null && piecount>=pies) {
						  p.getInventory().remove(magic_pie);
						  //Check to see if there are any pies we need to keep for later.
						  List<ItemStack> items = new ArrayList<ItemStack>();
						  for (int i=0;i<p.getInventory().getContents().length;i++) {
							  if (p.getInventory().getContents()[i]!=null) {
								  if (p.getInventory().getContents()[i].getType()==Material.PUMPKIN_PIE &&
										  p.getInventory().getContents()[i].hasItemMeta() &&
										  p.getInventory().getContents()[i].getItemMeta().getLore()!=null) {
									  //This is a special pie. Must keep.
									  items.add(p.getInventory().getContents()[i]);
								  }
							  }
						  }
						  for (int i=0;i<pies;i++) {
							  p.getInventory().remove(Material.PUMPKIN_PIE);
							  //Remove the pies. Remove the magic pie.
						  }
						  
						  int amountleft = piecount-pies;
						  while (amountleft>0) {
							  if (amountleft>=64) {
								  p.getInventory().addItem(new ItemStack(Material.PUMPKIN_PIE,64));
								  amountleft-=64;
							  } else {
								  p.getInventory().addItem(new ItemStack(Material.PUMPKIN_PIE,1));
								  amountleft--;
							  }
						  }
						  for (int i=0;i<items.size();i++) {
							  p.getInventory().addItem(items.get(i));
						  }
						  //Give a legendary armor/weapon here.
						  //Bukkit.getLogger().info("LEGENDARY!");
						  giveLegendaryItem(p);
						  p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION,1728000,0));
						  p.updateInventory();
					  }
				  }
			  }
		  }
	  }
  }
  
  @EventHandler
  public void onHurt(EntityDamageEvent e) {
	  if (e.getEntity().getType()==EntityType.PLAYER) {
		  final Player p = (Player)e.getEntity();
		  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
		      @Override
		      public void run() {
		    	  p.getScoreboard().getTeam(p.getName()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth()));
		      }
		  	},5);
		  //p.sendMessage("Your Health: "+p.getHealth()+", Damage: "+e.getDamage()+", Actual: "+this.plugin.DMGCALC.getDamage(p, e.getDamage(), DamageCause.ENTITY_ATTACK));
		  double actualdmg = this.plugin.DMGCALC.getDamage(p, e.getDamage(), e.getCause());
		  List<Entity> nearby = p.getNearbyEntities(10, 10, 10);
		  for (int i=0;i<nearby.size();i++) {
			  if (nearby.get(i).getType()==EntityType.PLAYER && this.plugin.PlayerinJob((Player)nearby.get(i), "Support") && this.plugin.getJobLv("Support", (Player)nearby.get(i))>=20) {
				  //A support with the Lv20 buff is detected. If health is less than 8, take half damage.
				  if (p.getHealth()<=8) {
					  e.setDamage(e.getDamage()/2.0d);
				  }
			  }
		  }
		  if (this.plugin.PlayerinJob(p, "Explorer")) {
			  if (this.plugin.getJobLv("Explorer", p)>=10) {
				  //Check to see if our "fatal s	urvivor" effect is available.
				  boolean survivor=false;
				  for (int i=0;i<this.plugin.explorers.size();i++) {
					  if (this.plugin.explorers.get(i).event==0 && this.plugin.explorers.get(i).name.compareTo(p.getName())==0) {
						  survivor=true;
						  break;
					  }
				  }
				  PersistentExplorerList eve = new PersistentExplorerList(p.getName());
				  eve.event=1;
				  eve.data=p.getExp();
				  eve.data2=p.getLevel();
				  eve.expiretime=Bukkit.getWorld("world").getFullTime()+1200;
				  this.plugin.explorers.add(eve);
				  if (!survivor && p.getHealth()-actualdmg<=0) {
					  e.setDamage(0);
					  p.setHealth(p.getMaxHealth());
					  p.sendMessage("You used your "+ChatColor.YELLOW+"Lv10 Fatal Survivor"+ChatColor.WHITE+" buff. Your health has been restored."+ChatColor.AQUA+" It will be recharged in one hour.");
					  Bukkit.broadcastMessage(ChatColor.YELLOW+p.getName()+ChatColor.WHITE+" has died...and revived through sheer willpower!");
					  p.setFireTicks(0);
					  p.setFoodLevel(20);
					  p.setRemainingAir(p.getMaximumAir());
					  this.plugin.REVIVE_EFFECT=90;
					  this.plugin.REVIVE_EFFECT_LOC = p.getLocation();
					  PersistentExplorerList ev = new PersistentExplorerList(p.getName());
					  ev.event=0;
					  this.plugin.explorers.add(ev);
				  } else {
					  /*if (p.getHealth()-actualdmg<=0) {
						  PersistentExplorerList ev = new PersistentExplorerList(p.getName());
						  ev.event=1;
						  ev.data=p.getExp();
						  ev.data2=p.getLevel();
						  this.plugin.explorers.add(ev);
					  }*/
				  }
			  }
		  }
		  if (p.getNoDamageTicks()<p.getMaximumNoDamageTicks()/2.0f && this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify5") && e.getCause()!=DamageCause.ENTITY_EXPLOSION && e.getDamage()!=0) {
			  p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"You were hurt for "+Math.round((this.plugin.DMGCALC.getDamage(p.getEquipment().getHelmet(), p.getEquipment().getChestplate(), p.getEquipment().getLeggings(), p.getEquipment().getBoots(), e.getDamage(), e.getCause(), p.isBlocking()))*10)/10+" damage from "+convertToItemName(e.getCause().name())+".");
		  }
	  }
	  EntityType allowedtypes[] = {EntityType.BAT,EntityType.BLAZE,EntityType.CAVE_SPIDER,EntityType.ENDERMAN,EntityType.GHAST,EntityType.MAGMA_CUBE,EntityType.PIG_ZOMBIE,EntityType.SILVERFISH,EntityType.SLIME,EntityType.SPIDER,EntityType.ZOMBIE,EntityType.SKELETON,EntityType.CREEPER};
	  boolean contains=e.getEntity() instanceof Monster;
	  if (contains) {
		  LivingEntity l = (LivingEntity)e.getEntity();
		  if ((l.getCustomName()==null || !l.getCustomName().contains(""+ChatColor.DARK_PURPLE)) && l.getType()!=EntityType.ENDER_DRAGON) {
			  if ((l.getTicksLived()<120 && e.getCause()==DamageCause.SUFFOCATION)) {
				  l.remove();
				  e.setCancelled(true);
			  }
		  }
	  }
  }
  
  @EventHandler
  public void onPlayerPickup(PlayerPickupItemEvent e) {
	  if (this.plugin.getAccountsConfig().getBoolean(e.getPlayer().getName()+".settings.notify1")) {
		  Player p = e.getPlayer();
		  String temp = e.getItem().getItemStack().getType().name().replace("_", " ");
		  char[] mod = temp.toCharArray();
		  boolean first=false;
		  for (int i=0;i<mod.length;i++) {
			  if (!first) {
				  if (mod[i]>='a'&&mod[i]<='z') {
					  mod[i]-=32;
					  first=true;
				  } else 
					  if (i==0) {
						  if (mod[i]>='A'&&mod[i]<='Z') {
							  first=true;
						  }
					  } else {
						  if (mod[i]>='A'&&mod[i]<='Z'&&(mod[i-1]<'A'||mod[i-1]>'Z')) {
							  first=true;
						  }
					  }
			  } else {
				  if (mod[i-1]!=' ') {
					  if (mod[i]>='A'&&mod[i]<='Z') {
						  mod[i]+=32;
					  }
				  }
			  }
		  }
		  p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"Picked up "+e.getItem().getItemStack().getAmount()+" "+String.valueOf(mod)+".");
	  }
  }
  
  @EventHandler
  public void onPlayerOnFire(EntityCombustEvent e) {
	  if (e.getEntity().getType()==EntityType.PLAYER) {
		  Player p = (Player)e.getEntity();
		  if (this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat6")>0) {
			  p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, (this.plugin.getStatBonus(5, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat6"))/3)*20, 0));
		  }
	  }
  }
  
  @EventHandler
  public void onRegainHealth(EntityRegainHealthEvent e) {
	  if (e.getEntity().getType()==EntityType.PLAYER) {
		  Player p = (Player)e.getEntity();
		  p.getScoreboard().getTeam(p.getName()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth()));
		  	try {
				Iterator<PotionEffect> effects = p.getActivePotionEffects().iterator();
					//Figure out potion effects when player joins.
					while (effects.hasNext()) {
						PotionEffect nexteffect = effects.next();
						if (nexteffect.getType().getName().compareTo(PotionEffectType.REGENERATION.getName())==0) {
							e.setAmount(e.getAmount()+1);
						}
						/*if (nexteffect.getType().getName().compareTo(PotionEffectType.JUMP.getName())==0) {
							p.removePotionEffect(PotionEffectType.JUMP);
							p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 360000, nexteffect.getAmplifier()+2, true));
						}*/
						effects.remove();
					}
			  } catch (ConcurrentModificationException ex_e) {
				  Bukkit.getLogger().warning("Potion Effect Collection not accessible while trying to regenerate player.");
			  }
			if (this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat1")>0) {
				e.setAmount(e.getAmount()+this.plugin.getStatBonus(0, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat1")/6));
			}
	  }
  }
  
  @EventHandler
  public void onEnemyHit(EntityDamageByEntityEvent e) {
	  if (e.getEntity() instanceof LivingEntity) {
		  final LivingEntity l = (LivingEntity)e.getEntity();
		  if (l.getCustomName()!=null && l.getCustomName().contains(ChatColor.DARK_PURPLE+"")) {
			  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
	                @Override
	                public void run() {
	                    //Multiplying by a number lower than 1 will reduce knockback
	                    //Multiplying by a number greater than 1 will increase knockback
	                    Vector knockback = l.getVelocity().multiply(0.1f);
	                    l.setVelocity(knockback);
	                }
	            }, 1L);
			  if (l.getHealth()>=1) {
				  LivingEntity enderdragon = (LivingEntity)Bukkit.getWorld("world").spawnEntity(new Location(l.getWorld(),l.getLocation().getBlockX(),-250,l.getLocation().getBlockZ()),EntityType.ENDER_DRAGON);
				  enderdragon.setCustomName(ChatColor.DARK_PURPLE+"Charge Zombie III");
				  enderdragon.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,127,999999));
				  enderdragon.setMaxHealth(200);
				  enderdragon.setHealth(l.getHealth()/l.getMaxHealth()*200);
				  enderdragon.setNoDamageTicks(999999);
				  enderdragon.setRemoveWhenFarAway(false);
			  }
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
			boolean clear_torches=false;
		  	try {
				Iterator<PotionEffect> effects = l.getActivePotionEffects().iterator();
					//Figure out potion effects when player joins.
					while (effects.hasNext()) {
						PotionEffect nexteffect = effects.next();
						if (nexteffect.getType().getName().compareTo(PotionEffectType.SLOW.getName())==0 && nexteffect.getDuration()>99999) {
							l.removePotionEffect(PotionEffectType.SLOW);
							//Make lightning strikes in random places.
							for (int i=0;i<8;i++) {
								Bukkit.getWorld("world").strikeLightningEffect(l.getLocation().add(Math.random()*10-Math.random()*10,0,Math.random()*10-Math.random()*10));
								this.plugin.last_lightning_random_time=Bukkit.getWorld("world").getFullTime()+60;
							}
							int extramobs=0;
							List<Entity> nearbylist = e.getEntity().getNearbyEntities(30, 30, 30);
							  //Filter out all unrelated entity types.
							  for (int k=0;k<nearbylist.size();k++) {
								  //See if human players are near. If so, factor that in for determining how many mobs may exist.
								  if (nearbylist.get(k).getType()==EntityType.PLAYER) {
									  //This is a player.
									  Player g = (Player)nearbylist.get(k);
									  extramobs+=this.plugin.getJobTotalLvs(g)/20;
						  			////Bukkit.getLogger().info("Mob maxgroup increased to "+maxgroup+" down here.");
								  }
							  }
							for (int i=0;i<4+extramobs;i++) {
								LivingEntity g = (LivingEntity)Bukkit.getWorld("world").spawnEntity(l.getLocation().add(Math.random()/2-Math.random()/2,0,Math.random()/2-Math.random()/2), EntityType.ZOMBIE);
								g.setCustomName(ChatColor.GOLD+"Charge Zombie II");
								g.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,999999,0));
							}
							clear_torches=true;
							break;
						}
						if (nexteffect.getType().getName().compareTo(PotionEffectType.NIGHT_VISION.getName())==0 && l.getHealth()<l.getMaxHealth()/2) {
							l.removePotionEffect(PotionEffectType.NIGHT_VISION);
							l.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,999999,1));
							clear_torches=true;
							int extramobs=0;
							List<Entity> nearbylist = e.getEntity().getNearbyEntities(30, 30, 30);
							  //Filter out all unrelated entity types.
							  for (int k=0;k<nearbylist.size();k++) {
								  //See if human players are near. If so, factor that in for determining how many mobs may exist.
								  if (nearbylist.get(k).getType()==EntityType.PLAYER) {
									  //This is a player.
									  Player g = (Player)nearbylist.get(k);
									  extramobs+=this.plugin.getJobTotalLvs(g)/20;
						  			////Bukkit.getLogger().info("Mob maxgroup increased to "+maxgroup+" down here.");
								  }
								  if (nearbylist.get(k).getType()!=EntityType.SKELETON &&
										  nearbylist.get(k).getType()!=EntityType.ZOMBIE &&
										  nearbylist.get(k).getType()!=EntityType.CREEPER &&
										  nearbylist.get(k).getType()!=EntityType.SPIDER &&
										  nearbylist.get(k).getType()!=EntityType.ENDERMAN) {
									  nearbylist.remove(k);
									  k--;
								  }
							  }
							for (int i=0;i<4+extramobs;i++) {
								LivingEntity g = (LivingEntity)Bukkit.getWorld("world").spawnEntity(l.getLocation().add(Math.random()/2-Math.random()/2,0,Math.random()/2-Math.random()/2), EntityType.ZOMBIE);
								g.setCustomName(ChatColor.GOLD+"Charge Zombie II");
								g.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,999999,0));
							}
							break;
						}
						/*if (nexteffect.getType().getName().compareTo(PotionEffectType.JUMP.getName())==0) {
							p.removePotionEffect(PotionEffectType.JUMP);
							p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 360000, nexteffect.getAmplifier()+2, true));
						}*/
						effects.remove();
					}
			  } catch (ConcurrentModificationException ex_e) {
				  Bukkit.getLogger().warning("Potion Effect Collection not accessible while trying to hurt entity.");
			  }
		  	if (clear_torches) {
				for (int i=-20;i<21;i++) {
					for (int j=-20;j<21;j++) {
						for (int k=-20;k<21;k++) {
							if (Bukkit.getWorld("world").getBlockAt(l.getLocation().add(i,j,k)).getType()==Material.COMMAND) {
								Bukkit.getWorld("world").getBlockAt(l.getLocation().add(i,j,k)).setType(Material.COBBLESTONE);
							}
							if (Bukkit.getWorld("world").getBlockAt(l.getLocation().add(i,j,k)).getType()==Material.TORCH || Bukkit.getWorld("world").getBlockAt(l.getLocation().add(i,j,k)).getType()==Material.GLOWSTONE) {
								Bukkit.getWorld("world").getBlockAt(l.getLocation().add(i,j,k)).breakNaturally();
							}
						}
					}
				}
		  	} else {
				for (int i=-20;i<21;i++) {
					for (int j=-20;j<21;j++) {
						for (int k=-20;k<21;k++) {
							if (Bukkit.getWorld("world").getBlockAt(l.getLocation().add(i,j,k)).getType()==Material.COMMAND) {
								Bukkit.getWorld("world").getBlockAt(l.getLocation().add(i,j,k)).setType(Material.COBBLESTONE);
							}
							if (Bukkit.getWorld("world").getBlockAt(l.getLocation().add(i,j,k)).getType()==Material.SAND && Math.random()<=0.1) {
								Bukkit.getWorld("world").getBlockAt(l.getLocation().add(i,j,k)).breakNaturally();
							}
						}
					}
				}
		  	}
		  }
	  }
	  ////Bukkit.getLogger().info("Made it through 1.");
	  if (e.getEntity().getType()==EntityType.PLAYER) {
		  Player p = (Player)e.getEntity();
		  p.getScoreboard().getTeam(p.getName()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth()));
		  int slot=0;
		  for (int i=0;i<this.plugin.SPEED_CONTROL.size();i++) {
			  if (this.plugin.SPEED_CONTROL.get(i).p.getName().equals(p.getName())) {
				  slot=i;
				  break;
			  }
		  }
		  ////Bukkit.getLogger().info("Made it through 2.");
		  //Found the slot. Check armor values.
		  double block_chance=0,speed_boost_chance=0;
		  if (p.getEquipment().getBoots()!=null) {
			  ItemStack item = p.getEquipment().getBoots();
			  if (item.getItemMeta()!=null && item.getItemMeta().getLore()!=null && item.getItemMeta().getLore().size()!=0) {
				  for (int i=0;i<item.getItemMeta().getLore().size();i++) {
					  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Block Chance")) {
						  if (block_chance==0) {
							  block_chance+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
						  } else {
							  block_chance+=block_chance*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/100d);
						  }
					  }
					  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Speed Boost Chance")) {
						  if (speed_boost_chance==0) {
							  speed_boost_chance+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
						  } else {
							  speed_boost_chance+=speed_boost_chance*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i)));
						  }
					  }
				  }
			  }
			  //Bukkit.getLogger().info("Made it through 2.1.1.");
			  //p.sendMessage(item.getItemMeta().getDisplayName());
			  if (item.getItemMeta().getDisplayName()!=null && item.getItemMeta()!=null && item.getItemMeta().getLore()!=null && item.getItemMeta().getLore().size()!=0 && item.getItemMeta().getLore().contains(ChatColor.RED+"-400% Durability")) {
				  //p.sendMessage("Weak Boots");
				  item.setDurability((short)(item.getDurability()+3));
			  } else {
				  //Bukkit.getLogger().info("Made it through 2.1.2.");
				  if (this.plugin.SPEED_CONTROL.get(slot).boots_durability==-1) {
					  this.plugin.SPEED_CONTROL.get(slot).boots_durability=item.getDurability();
				  }
				  //Bukkit.getLogger().info("Made it through 2.1.3.");
				  ////Bukkit.getLogger().info("Durability went from "+this.plugin.SPEED_CONTROL.get(slot).boots_durability+" to "+item.getDurability()+". Attempting to save the armor.");
				  if (this.plugin.SPEED_CONTROL.get(slot).boots_durability<item.getDurability()) {
					  //Bukkit.getLogger().info("Made it through 2.1.4.");
					  double extradurability=0;
					  //See if we can increase the chances of keeping this item's durability.
					  if (item.getItemMeta()!=null && item.getItemMeta().getLore()!=null && item.getItemMeta().getLore().size()!=0) {
						  //Bukkit.getLogger().info("Made it through 2.1.5.");
						  for (int i=0;i<item.getItemMeta().getLore().size();i++) {
							  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Durability")) {
								  if (this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))>100) {
									  extradurability=(0.24*((this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/500.0d)));
								  } else {
									  extradurability=-(0.76*(1-(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/500.0d)));
								  }
							  }
						  }
						  //Bukkit.getLogger().info("Made it through 2.1.6.");
					  }
					  if (Math.random()<=0.76+extradurability) {
						  item.setDurability((short)(item.getDurability()-1));
						  ////Bukkit.getLogger().info("Armor durability now "+item.getDurability());
					  }
					  //Bukkit.getLogger().info("Made it through 2.1.7.");
					  this.plugin.SPEED_CONTROL.get(slot).boots_durability=item.getDurability();
					  //Bukkit.getLogger().info("Made it through 2.1.8.");
				  }
			  }
		  } else {
			  this.plugin.SPEED_CONTROL.get(slot).boots_durability=-1;
			  //Bukkit.getLogger().info("Made it through 2.1.9.");
		  }
		  //Bukkit.getLogger().info("Made it through 2.1.");
		  if (p.getEquipment().getChestplate()!=null) {
			  ItemStack item = p.getEquipment().getChestplate();
			  if (item.getItemMeta()!=null && item.getItemMeta().getLore()!=null && item.getItemMeta().getLore().size()!=0) {
				  for (int i=0;i<item.getItemMeta().getLore().size();i++) {
					  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Block Chance")) {
						  if (block_chance==0) {
							  block_chance+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
						  } else {
							  block_chance+=block_chance*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/100d);
						  }
					  }
					  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Speed Boost Chance")) {
						  if (speed_boost_chance==0) {
							  speed_boost_chance+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
						  } else {
							  speed_boost_chance+=speed_boost_chance*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i)));
						  }
					  }
				  }
			  }
			  //p.sendMessage(item.getItemMeta().getDisplayName());
			  if (item.getItemMeta().getDisplayName()!=null && item.getItemMeta()!=null && item.getItemMeta().getLore()!=null && item.getItemMeta().getLore().size()!=0 && item.getItemMeta().getLore().contains(ChatColor.RED+"-400% Durability")) {
				  //p.sendMessage("Weak Chestplate");
				  item.setDurability((short)(item.getDurability()+3));
			  } else {
				  if (this.plugin.SPEED_CONTROL.get(slot).chestplate_durability==-1) {
					  this.plugin.SPEED_CONTROL.get(slot).chestplate_durability=item.getDurability();
				  }
				  ////Bukkit.getLogger().info("Durability went from "+this.plugin.SPEED_CONTROL.get(slot).chestplate_durability+" to "+item.getDurability()+". Attempting to save the armor.");
				  if (this.plugin.SPEED_CONTROL.get(slot).chestplate_durability<item.getDurability()) {
					  double extradurability=0;
					  //See if we can increase the chances of keeping this item's durability.
					  if (item.getItemMeta()!=null && item.getItemMeta().getLore()!=null && item.getItemMeta().getLore().size()!=0) {
						  for (int i=0;i<item.getItemMeta().getLore().size();i++) {
							  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Durability")) {
								  if (this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))>100) {
									  extradurability=(0.24*((this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/500.0d)));
								  } else {
									  extradurability=-(0.76*(1-(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/500.0d)));
								  }
							  }
						  }	
					  }
					  if (Math.random()<=0.76+extradurability) {
						  item.setDurability((short)(item.getDurability()-1));
						  ////Bukkit.getLogger().info("Armor durability now "+item.getDurability());
					  }
					  this.plugin.SPEED_CONTROL.get(slot).chestplate_durability=item.getDurability();
				  }
			  }
		  } else {
			  this.plugin.SPEED_CONTROL.get(slot).chestplate_durability=-1;
		  }
		  //Bukkit.getLogger().info("Made it through 2.2.");
		  if (p.getEquipment().getLeggings()!=null) {
			  ItemStack item = p.getEquipment().getLeggings();
			  if (item.getItemMeta()!=null && item.getItemMeta().getLore()!=null && item.getItemMeta().getLore().size()!=0) {
				  for (int i=0;i<item.getItemMeta().getLore().size();i++) {
					  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Block Chance")) {
						  if (block_chance==0) {
							  block_chance+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
						  } else {
							  block_chance+=block_chance*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/100d);
						  }
					  }
					  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Speed Boost Chance")) {
						  if (speed_boost_chance==0) {
							  speed_boost_chance+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
						  } else {
							  speed_boost_chance+=speed_boost_chance*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i)));
						  }
					  }
				  }
			  }
			  //p.sendMessage(item.getItemMeta().getDisplayName());
			  if (item.getItemMeta().getDisplayName()!=null && item.getItemMeta()!=null && item.getItemMeta().getLore()!=null && item.getItemMeta().getLore().size()!=0 && item.getItemMeta().getLore().contains(ChatColor.RED+"-400% Durability")) {
				  //p.sendMessage("Weak Leggings");
				  item.setDurability((short)(item.getDurability()+3));
			  } else {
				  if (this.plugin.SPEED_CONTROL.get(slot).leggings_durability==-1) {
					  this.plugin.SPEED_CONTROL.get(slot).leggings_durability=item.getDurability();
				  }
				  ////Bukkit.getLogger().info("Durability went from "+this.plugin.SPEED_CONTROL.get(slot).leggings_durability+" to "+item.getDurability()+". Attempting to save the armor.");
				  if (this.plugin.SPEED_CONTROL.get(slot).leggings_durability<item.getDurability()) {
					  double extradurability=0;
					  //See if we can increase the chances of keeping this item's durability.
					  if (item.getItemMeta()!=null && item.getItemMeta().getLore()!=null && item.getItemMeta().getLore().size()!=0) {
						  for (int i=0;i<item.getItemMeta().getLore().size();i++) {
							  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Durability")) {
								  if (this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))>100) {
									  extradurability=(0.24*((this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/500.0d)));
								  } else {
									  extradurability=-(0.76*(1-(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/500.0d)));
								  }
							  }
						  }
					  }
					  if (Math.random()<=0.76+extradurability) {
						  item.setDurability((short)(item.getDurability()-1));
						  ////Bukkit.getLogger().info("Armor durability now "+item.getDurability());
					  }
					  this.plugin.SPEED_CONTROL.get(slot).leggings_durability=item.getDurability();
				  }
			  }
		  } else {
			  this.plugin.SPEED_CONTROL.get(slot).leggings_durability=-1;
		  }
		  //Bukkit.getLogger().info("Made it through 2.3");
		  if (p.getEquipment().getHelmet()!=null) {
			  ItemStack item = p.getEquipment().getHelmet();
			  if (item.getItemMeta()!=null && item.getItemMeta().getLore()!=null && item.getItemMeta().getLore().size()!=0) {
				  for (int i=0;i<item.getItemMeta().getLore().size();i++) {
					  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Block Chance")) {
						  if (block_chance==0) {
							  block_chance+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
						  } else {
							  block_chance+=block_chance*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/100d);
						  }
					  }
					  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Speed Boost Chance")) {
						  if (speed_boost_chance==0) {
							  speed_boost_chance+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
						  } else {
							  speed_boost_chance+=speed_boost_chance*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i)));
						  }
					  }
				  }
			  }
			  //p.sendMessage(item.getItemMeta().getDisplayName());
			  if (item.getItemMeta().getDisplayName()!=null && item.getItemMeta()!=null && item.getItemMeta().getLore()!=null && item.getItemMeta().getLore().size()!=0 && item.getItemMeta().getLore().contains(ChatColor.RED+"-400% Durability")) {
				  //p.sendMessage("Weak Helmet");
				  item.setDurability((short)(item.getDurability()+3));
			  } else {
				  if (this.plugin.SPEED_CONTROL.get(slot).helmet_durability==-1) {
					  this.plugin.SPEED_CONTROL.get(slot).helmet_durability=item.getDurability();
				  }
				  ////Bukkit.getLogger().info("Durability went from "+this.plugin.SPEED_CONTROL.get(slot).helmet_durability+" to "+item.getDurability()+". Attempting to save the armor.");
				  if (this.plugin.SPEED_CONTROL.get(slot).helmet_durability<item.getDurability()) {
					  double extradurability=0;
					  //See if we can increase the chances of keeping this item's durability.
					  if (item.getItemMeta()!=null && item.getItemMeta().getLore()!=null && item.getItemMeta().getLore().size()!=0) {
						  for (int i=0;i<item.getItemMeta().getLore().size();i++) {
							  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Durability")) {
								  if (this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))>100) {
									  extradurability=(0.24*((this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/500.0d)));
								  } else {
									  extradurability=-(0.76*(1-(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/500.0d)));
								  }
							  }
						  }
					  }
					  if (Math.random()<=0.76+extradurability) {
						  item.setDurability((short)(item.getDurability()-1));
						  ////Bukkit.getLogger().info("Armor durability now "+item.getDurability());
					  }
					  this.plugin.SPEED_CONTROL.get(slot).helmet_durability=item.getDurability();
				  }
			  }
		  } else {
			  this.plugin.SPEED_CONTROL.get(slot).helmet_durability=-1;
		  }
		  //Bukkit.getLogger().info("Made it through 3.");
		  //This is the player getting hit.
			for (int i=0;i<p.getEquipment().getArmorContents().length;i++) {
				if (p.getEquipment().getArmorContents()[i]!=null && p.getEquipment().getArmorContents()[i].getItemMeta()!=null && p.getEquipment().getArmorContents()[i].getItemMeta().getLore()!=null) {
					for (int j=0;j<p.getEquipment().getArmorContents()[i].getItemMeta().getLore().size();j++) {
						if (this.plugin.containsEnchantment(p.getEquipment().getArmorContents()[i].getItemMeta().getLore().get(j), "Damage Reduction")) {
							e.setDamage(e.getDamage()*(1-(this.plugin.getEnchantmentNumb(p.getEquipment().getArmorContents()[i].getItemMeta().getLore().get(j))/100.0d)));
						}
					}
				}
			}
			if (Math.random()<=speed_boost_chance/100.0d) {
				try {
					Iterator<PotionEffect> effects = p.getActivePotionEffects().iterator();
					//Figure out potion effects when player joins.
					while (effects.hasNext()) {
						PotionEffect nexteffect = effects.next();
						if (nexteffect.getType().getName().compareTo(PotionEffectType.SPEED.getName())==0) {
							p.removePotionEffect(PotionEffectType.SPEED);
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,1200,nexteffect.getAmplifier()));
						}
						effects.remove();
					}
					
				  } catch (ConcurrentModificationException ex_e) {
					  Bukkit.getLogger().warning("Potion Effect Collection not accessible while finalizing player speed.");
				  }
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,1200,1));
			}
			if (Math.random()<=block_chance/100.0d) {
				e.setDamage(0);
				e.setCancelled(true);
			}
			  //Bukkit.getLogger().info("Made it through 4.");
		  p.updateInventory();
		if (this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat3")>0) {
			double olddmg=e.getDamage();
			e.setDamage(e.getDamage()*(((100-this.plugin.getStatBonus(2, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat3")/4))/100.0d)));
			//p.sendMessage("Damage set from "+olddmg+" to "+e.getDamage());
		}
	  }
	  //Bukkit.getLogger().info("Made it through 5.");
	  if (e.getEntity().getType()==EntityType.PLAYER && e.getDamager().getType()==EntityType.SPIDER) {
		  LivingEntity enemy = (LivingEntity)e.getDamager();
		  if (enemy.getCustomName()!=null && (enemy.getCustomName().compareTo(ChatColor.YELLOW+"Venomous Spider")==0)) {
			  LivingEntity p = (LivingEntity)e.getEntity();
			  p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1, false));
		  } else 
		  if (enemy.getCustomName()!=null && (enemy.getCustomName().compareTo(ChatColor.GOLD+"Venomous Spider II")==0)) {
			  LivingEntity p = (LivingEntity)e.getEntity();
			  p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 2, false));
		  } else 
		  if (enemy.getCustomName()!=null && (enemy.getCustomName().compareTo(ChatColor.YELLOW+"Snaring Spider")==0)) {
			  LivingEntity p = (LivingEntity)e.getEntity();
			  p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2, false));
			  //Create web at the position of the player.
			  /*
			  for (int x=-1;x<2;x++) {
				  for (int y=-1;y<2;y++) {
					  for (int z=-1;z<2;z++) {
						  Block b = Bukkit.getWorld("world").getBlockAt(p.getLocation().add(x,y,z));
						  if (b.getType()==Material.AIR) {
							  b.setType(Material.WEB);
							  this.plugin.TEMP_WEBS.add(new TempWeb(p.getLocation().add(x,y,z), 90));
						  }
					  }
				  }
			  }*/
		  } else 
			  if (enemy.getCustomName()!=null && (enemy.getCustomName().compareTo(ChatColor.GOLD+"Snaring Spider II")==0)) {
				  LivingEntity p = (LivingEntity)e.getEntity();
					try {
						Iterator<PotionEffect> effects = p.getActivePotionEffects().iterator();
							//Figure out potion effects when player joins.
							while (effects.hasNext()) {
								PotionEffect nexteffect = effects.next();
								if (nexteffect.getType().getName().compareTo(PotionEffectType.SLOW.getName())==0) {
									p.removePotionEffect(PotionEffectType.SLOW);
									p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 150, nexteffect.getAmplifier()+1, true));
								}
								/*if (nexteffect.getType().getName().compareTo(PotionEffectType.JUMP.getName())==0) {
									p.removePotionEffect(PotionEffectType.JUMP);
									p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 360000, nexteffect.getAmplifier()+2, true));
								}*/
								effects.remove();
							}

					  } catch (ConcurrentModificationException ex_e) {
						  Bukkit.getLogger().warning("Potion Effect Collection not accessible while trying to slow down player.");
					  }
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 150, 1, true));
				  //Create web at the position of the player.
				  /*for (int x=-2;x<3;x++) {
					  for (int y=-2;y<3;y++) {
						  for (int z=-2;z<3;z++) {
							  Block b = Bukkit.getWorld("world").getBlockAt(p.getLocation().add(x,y,z));
							  if (b.getType()==Material.AIR) {
								  b.setType(Material.WEB);
								  this.plugin.TEMP_WEBS.add(new TempWeb(p.getLocation().add(x,y,z), 150));
							  }
						  }
					  }
				  }*/
			  }
	  }
	  //Bukkit.getLogger().info("Made it through 6.");
	  if (e.getEntity().getType()==EntityType.PLAYER && e.getDamager().getType()==EntityType.ZOMBIE) {
		  LivingEntity enemy = (LivingEntity)e.getDamager();
		  Player p = (Player)e.getEntity();
		  p.getScoreboard().getTeam(p.getName()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth()));
		  double throughdmg=0;
		  double maxdmg=0;
		  if (enemy.getCustomName()!=null && (enemy.getCustomName().compareTo(ChatColor.YELLOW+"Charge Zombie")==0 || enemy.getCustomName().compareTo(ChatColor.DARK_PURPLE+"Charge Zombie III")==0)) {
			  throughdmg=(this.plugin.DMGCALC.getDamage(new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), e.getDamage(), DamageCause.ENTITY_ATTACK, false))/2;
			  if (throughdmg>e.getDamage()/2) {
				  if (p.getHealth()-throughdmg>0) {
					  p.setHealth(p.getHealth()-throughdmg);
					  if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify5") && e.getDamage()!=0) {
						  p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"You were hurt for "+Math.round(throughdmg*10)/10+" damage from "+convertToItemName(e.getCause().name())+".");
					  }
				  } else {
					  p.setHealth(0);
				  }
			  } else {
				  if (p.getHealth()-e.getDamage()/2>0) {
					  p.setHealth(p.getHealth()-e.getDamage()/2);
					  if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify5") && e.getDamage()!=0) {
						  p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"You were hurt for "+Math.round(e.getDamage()/2*10)/10+" damage from "+convertToItemName(e.getCause().name())+".");
					  }
				  } else {
					  p.setHealth(0);
				  }
			  }
			  e.setDamage(0);
			  for (int k=-1;k<2;k++) {
				  for (int j=-1;j<2;j++) {
					  Location checkloc = enemy.getLocation().add(k,1,j);
					  Block bl = Bukkit.getWorld("world").getBlockAt(checkloc);
					  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
						  bl.breakNaturally();
					  }
					  bl = Bukkit.getWorld("world").getBlockAt(checkloc);
					  checkloc = enemy.getLocation().add(k,2,j);
					  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
						  bl.breakNaturally();
					  }
					  bl = Bukkit.getWorld("world").getBlockAt(checkloc);
					  checkloc = enemy.getLocation().add(k,0,j);
					  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
						  bl.breakNaturally();
					  }
				  }
			  }
		  } else
		  if (enemy.getCustomName()!=null && (enemy.getCustomName().compareTo(ChatColor.GOLD+"Charge Zombie II")==0)) {
			  throughdmg=(this.plugin.DMGCALC.getDamage(new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), e.getDamage(), DamageCause.ENTITY_ATTACK, false))/1.25d;
			  if (throughdmg>e.getDamage()) {
				  if (p.getHealth()-throughdmg>0) {
					  p.setHealth(p.getHealth()-throughdmg);
					  if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify5") && e.getDamage()!=0) {
						  p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"You were hurt for "+Math.round(throughdmg*10)/10+" damage from "+convertToItemName(e.getCause().name())+".");
					  }
				  } else {
					  p.setHealth(0);
				  }
			  } else {
				  if (p.getHealth()-e.getDamage()>0) {
					  p.setHealth(p.getHealth()-e.getDamage());
					  if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify5") && e.getDamage()!=0) {
						  p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"You were hurt for "+Math.round(e.getDamage()*10)/10+" damage from "+convertToItemName(e.getCause().name())+".");
					  }
				  } else {
					  p.setHealth(0);
				  }
			  }
			  for (int k=-2;k<3;k++) {
				  for (int j=-2;j<3;j++) {
					  Location checkloc = enemy.getLocation().add(k,1,j);
					  Block bl = Bukkit.getWorld("world").getBlockAt(checkloc);
					  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
						  bl.breakNaturally();
					  }
					  bl = Bukkit.getWorld("world").getBlockAt(checkloc);
					  checkloc = enemy.getLocation().add(k,2,j);
					  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
						  bl.breakNaturally();
					  }
					  bl = Bukkit.getWorld("world").getBlockAt(checkloc);
					  checkloc = enemy.getLocation().add(k,0,j);
					  if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER) {
						  bl.breakNaturally();
					  }
				  }
			  }
			  e.setDamage(0);
		  } else
		  if (enemy.getCustomName()!=null && (enemy.getCustomName().compareTo(ChatColor.GRAY+"Zombie Ninja")==0)) {
			  enemy.removePotionEffect(PotionEffectType.INVISIBILITY);
			  this.plugin.ninjavisible_list.add(new InvisibilityData(enemy.getUniqueId(), Bukkit.getWorld("world").getFullTime()+10));
		  }
	  }
	  //Bukkit.getLogger().info("Made it through 7.");
	  if (e.getEntity() instanceof LivingEntity) {
		  LivingEntity f = (LivingEntity) e.getEntity();
		  if (e.getDamager().getType()==EntityType.PLAYER || e.getDamager().getType()==EntityType.ARROW) {
			  if (e.getDamager().getType()==EntityType.PLAYER) {
				  if (e.getEntity() instanceof LivingEntity) {
					  LivingEntity enemy = (LivingEntity)e.getEntity();
					  if (enemy.getCustomName()!=null && (enemy.getCustomName().compareTo(ChatColor.GRAY+"Zombie Ninja")==0)) {
						  boolean found=false;
						  for (int i=0;i<this.plugin.ninjavisible_list.size();i++) {
							  if (this.plugin.ninjavisible_list.get(i).val.equals(enemy.getUniqueId())) {
								  found=true;
								  enemy.removePotionEffect(PotionEffectType.INVISIBILITY);
								  	this.plugin.ninjavisible_list.get(i).resettime=Bukkit.getWorld("world").getFullTime()+20;
								  break;
							  }
						  }
						  if (!found) {
							  enemy.removePotionEffect(PotionEffectType.INVISIBILITY);
						  	this.plugin.ninjavisible_list.add(new InvisibilityData(enemy.getUniqueId(), Bukkit.getWorld("world").getFullTime()+10));
						  }
					  }
				  }
				  Player p = (Player) e.getDamager();
				  if (p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().getDisplayName()!=null && p.getItemInHand().getItemMeta().getDisplayName().contains(ChatColor.DARK_GRAY+"[BROKEN]")) {
					  e.setDamage(0);
					  e.setCancelled(true);
					  return;
				  }
				  p.getScoreboard().getTeam(p.getName()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth()));
				  //p.sendMessage("No Damage Ticks: "+f.getNoDamageTicks());
				  ItemStack item = p.getItemInHand();
				  double critical_chance=0,armor_pen=0,life_steal=0,attack_speed=0,dmg=0;
				  if (item.getType()!=Material.BOW && item.getItemMeta()!=null && item.getItemMeta().getLore()!=null && item.getItemMeta().getLore().size()!=0) { //Make sure this isn't a ranged weapon.
					  for (int i=0;i<item.getItemMeta().getLore().size();i++) {
						  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Critical Chance")) {
							  if (critical_chance==0) {
								  critical_chance+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
							  } else {
								  critical_chance+=critical_chance*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/100d);
							  }
						  }
						  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Armor Penetration")) {
							  armor_pen+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
						  }
						  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Life Steal")) {
							  if (life_steal==0) {
								  life_steal+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
							  } else {
								  life_steal+=life_steal*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/100d);
							  }
						  }
						  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Attack Speed")) {
							  if (attack_speed==0) {
								  attack_speed+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
							  } else {
								  attack_speed+=attack_speed*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/100d);
							  }
						  }
						  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Damage")) {
							  dmg+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
						  }
					  }
				  }
				  if (critical_chance>0) {
					  if (Math.random()<=critical_chance/100.0d) {
						  e.setDamage(e.getDamage()*2);
					  }
				  }
				  if (f.getNoDamageTicks()<f.getMaximumNoDamageTicks()/2.0f && armor_pen>0) {
					double normaldmg=(this.plugin.DMGCALC.getDamage(f.getEquipment().getHelmet(), f.getEquipment().getChestplate(), f.getEquipment().getLeggings(), f.getEquipment().getBoots(), e.getDamage(), DamageCause.ENTITY_ATTACK, false));
					double throughdmg=(this.plugin.DMGCALC.getDamage(new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), e.getDamage(), DamageCause.ENTITY_ATTACK, false));
					if (throughdmg>normaldmg+armor_pen) {
						//This means some piercing can be done.
						//e.setDamage(normaldmg+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4));
						if (f.getHealth()-(normaldmg+armor_pen)>0) {
							f.setHealth(f.getHealth()-(normaldmg+armor_pen));
							if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify4")) {
								if (f.getCustomName()!=null) {
									p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(normaldmg+armor_pen)*10)/10+" damage to "+convertToItemName(f.getCustomName())+".");
								} else {
									p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(normaldmg+armor_pen)*10)/10+" damage to "+convertToItemName(f.getType().getName())+".");
								}
							}
						} else {
							f.setHealth(0);
						}
					} else {
						//This means piercing would do extra damage. Just subtract throughdmg.
						if (f.getHealth()-throughdmg>0) {
							f.setHealth(f.getHealth()-throughdmg);
							if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify4")) {
								if (f.getCustomName()!=null) {
									p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(throughdmg)*10)/10+" damage to "+convertToItemName(f.getCustomName())+".");
								} else {
									p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(throughdmg)*10)/10+" damage to "+convertToItemName(f.getType().getName())+".");
								}
							}
						} else {
							f.setHealth(0);
						}
					}
					e.setDamage(0);
				  }
				  if (f.getNoDamageTicks()<f.getMaximumNoDamageTicks()/2.0f && life_steal>0) {
					  if (p.getHealth()+e.getDamage()*(life_steal/100.0d)<p.getMaxHealth()) {
						  p.setHealth(p.getHealth()+e.getDamage()*(life_steal/100.0d));
					  } else {
						  p.setHealth(p.getMaxHealth());
					  }
				  }
				  if (attack_speed>0) {
					  f.setNoDamageTicks(f.getNoDamageTicks()-(int)(f.getNoDamageTicks()*(attack_speed/100.0d)));
				  }
				  if (dmg>0) {
					  e.setDamage(e.getDamage()+dmg);
				  }
				  if (this.plugin.PlayerinJob((Player)e.getDamager(), "Support")) {
					  for (int i=0;i<this.plugin.supportmoblist.size();i++) {
						  if (this.plugin.supportmoblist.get(i).p.getName().compareTo(((Player)e.getDamager()).getName())==0) {
							  if (!this.plugin.supportmoblist.get(i).id.contains(((Entity)f).getUniqueId())) {
								  this.plugin.supportmoblist.get(i).id.add(((Entity)f).getUniqueId());
								  //Bukkit.getPlayer("sigonasr2").sendMessage("Added to list: "+((Entity)f).getUniqueId().toString());
								  this.plugin.supportmoblist.get(i).registeredtime=Bukkit.getWorld("world").getFullTime()+1200;
							  }
						  }
					  }
				  } else {
					  for (int i=0;i<this.plugin.hitmoblist.size();i++) {
						  if (this.plugin.hitmoblist.get(i).p.getName().compareTo(((Player)e.getDamager()).getName())==0) {
							  if (!this.plugin.hitmoblist.get(i).id.contains(((Entity)f).getUniqueId())) {
								  this.plugin.hitmoblist.get(i).id.add(((Entity)f).getUniqueId());
								  //p.sendMessage("Added to list: "+((Entity)f).getUniqueId().toString());
								  this.plugin.hitmoblist.get(i).registeredtime=Bukkit.getWorld("world").getFullTime()+1200;
							  }
						  }
					  }
				  }
				  if (this.plugin.PlayerinJob((Player)e.getDamager(), "Hunter") && this.plugin.getJobLv("Hunter", (Player)e.getDamager())>=5) {
					  //Deal 2 extra damage.
					  e.setDamage(e.getDamage()+2);
				  }
				if (this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat7")>0) {
					  e.setDamage(e.getDamage()+(this.plugin.getStatBonus(6, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat7"))/2));
				}
				if (f.getNoDamageTicks()<f.getMaximumNoDamageTicks()/2.0f && this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")>0) {
					  //e.setDamage(e.getDamage()+(this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5"))/4));
					double normaldmg=(this.plugin.DMGCALC.getDamage(f.getEquipment().getHelmet(), f.getEquipment().getChestplate(), f.getEquipment().getLeggings(), f.getEquipment().getBoots(), e.getDamage(), DamageCause.ENTITY_ATTACK, false));
					double throughdmg=(this.plugin.DMGCALC.getDamage(new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), e.getDamage(), DamageCause.ENTITY_ATTACK, false));
					if (throughdmg>normaldmg+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4)) {
						//This means some piercing can be done.
						//e.setDamage(normaldmg+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4));
						if (f.getHealth()-(normaldmg+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4))>0) {
							f.setHealth(f.getHealth()-(normaldmg+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4)));
							if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify4")) {
								if (f.getCustomName()!=null) {
									p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(normaldmg+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4))+" damage to "+convertToItemName(f.getCustomName())+".");
								} else {
									p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(normaldmg+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4))+" damage to "+convertToItemName(f.getType().getName())+".");
								}
							}
						} else {
							f.setHealth(0);
						}
					} else {
						//This means piercing would do extra damage. Just subtract throughdmg.
						if (f.getHealth()-throughdmg>0) {
							f.setHealth(f.getHealth()-throughdmg);
							if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify4")) {
								if (f.getCustomName()!=null) {
									p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(throughdmg)*10)/10+" damage to "+convertToItemName(f.getCustomName())+".");
								} else {
									p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(throughdmg)*10)/10+" damage to "+convertToItemName(f.getType().getName())+".");
								}
							}
						} else {
							f.setHealth(0);
						}
					}
					e.setDamage(0);
				}
				if (f.getNoDamageTicks()<f.getMaximumNoDamageTicks()/2.0f && e.getDamage()!=0) {
					if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify4")) {
						if (f.getCustomName()!=null) {
							p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round((this.plugin.DMGCALC.getDamage(f.getEquipment().getHelmet(), f.getEquipment().getChestplate(), f.getEquipment().getLeggings(), f.getEquipment().getBoots(), e.getDamage(), DamageCause.ENTITY_ATTACK, false)))*10)/10+" damage to "+convertToItemName(f.getCustomName())+".");
						} else {
							p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round((this.plugin.DMGCALC.getDamage(f.getEquipment().getHelmet(), f.getEquipment().getChestplate(), f.getEquipment().getLeggings(), f.getEquipment().getBoots(), e.getDamage(), DamageCause.ENTITY_ATTACK, false)))*10)/10+" damage to "+convertToItemName(f.getType().getName())+".");
						}
					}
				}
			  } else {
				  if (((Projectile)e.getDamager()).getShooter()!=null && ((Projectile)e.getDamager()).getShooter().getType()==EntityType.PLAYER) {
					  Player p = (Player)((Projectile)e.getDamager()).getShooter();
					  p.getScoreboard().getTeam(p.getName()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth()));
					  ItemStack item = p.getItemInHand();
					  double critical_chance=0,armor_pen=0,life_steal=0,attack_speed=0,dmg=0;
					  if (item.getType()==Material.BOW && item.getItemMeta()!=null && item.getItemMeta().getLore()!=null && item.getItemMeta().getLore().size()!=0) { //Make sure we are using a ranged weapon.
						  for (int i=0;i<item.getItemMeta().getLore().size();i++) {
							  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Critical Chance")) {
								  if (critical_chance==0) {
									  critical_chance+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
								  } else {
									  critical_chance+=critical_chance*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/100d);
								  }
							  }
							  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Armor Penetration")) {
								  armor_pen+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
							  }
							  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Life Steal")) {
								  if (life_steal==0) {
									  life_steal+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
								  } else {
									  life_steal+=life_steal*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/100d);
								  }
							  }
							  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Attack Speed")) {
								  if (attack_speed==0) {
									  attack_speed+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
								  } else {
									  attack_speed+=attack_speed*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/100d);
								  }
							  }
							  if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Damage")) {
								  dmg+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
							  }
						  }
					  }
					  if (critical_chance>0) {
						  if (Math.random()<=critical_chance/100.0d) {
							  e.setDamage(e.getDamage()*2);
						  }
					  }
					  if (f.getNoDamageTicks()<f.getMaximumNoDamageTicks()/2.0f && armor_pen>0) {
						double normaldmg=(this.plugin.DMGCALC.getDamage(f.getEquipment().getHelmet(), f.getEquipment().getChestplate(), f.getEquipment().getLeggings(), f.getEquipment().getBoots(), e.getDamage(), DamageCause.ENTITY_ATTACK, false));
						double throughdmg=(this.plugin.DMGCALC.getDamage(new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), e.getDamage(), DamageCause.ENTITY_ATTACK, false));
						if (throughdmg>normaldmg+armor_pen) {
							//This means some piercing can be done.
							//e.setDamage(normaldmg+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4));
							if (f.getHealth()-(normaldmg+armor_pen)>0) {
								f.setHealth(f.getHealth()-(normaldmg+armor_pen));
								if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify4")) {
									if (f.getCustomName()!=null) {
										p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(normaldmg+armor_pen)*10)/10+" damage to "+convertToItemName(f.getCustomName())+".");
									} else {
										p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(normaldmg+armor_pen)*10)/10+" damage to "+convertToItemName(f.getType().getName())+".");
									}
								}
							} else {
								f.setHealth(0);
							}
						} else {
							//This means piercing would do extra damage. Just subtract throughdmg.
							if (f.getHealth()-throughdmg>0) {
								f.setHealth(f.getHealth()-throughdmg);
								if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify4")) {
									if (f.getCustomName()!=null) {
										p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(throughdmg)*10)/10+" damage to "+convertToItemName(f.getCustomName())+".");
									} else {
										p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(throughdmg)*10)/10+" damage to "+convertToItemName(f.getType().getName())+".");
									}
								}
							} else {
								f.setHealth(0);
							}
						}
						e.setDamage(0);
					  }
					  if (f.getNoDamageTicks()<f.getMaximumNoDamageTicks()/2.0f && life_steal>0) {
						  if (p.getHealth()+e.getDamage()*(life_steal/100.0d)<p.getMaxHealth()) {
							  p.setHealth(p.getHealth()+e.getDamage()*(life_steal/100.0d));
						  } else {
							  p.setHealth(p.getMaxHealth());
						  }
					  }
					  if (attack_speed>0) {
						  f.setNoDamageTicks(f.getNoDamageTicks()-(int)(f.getNoDamageTicks()*(attack_speed/100.0d)));
					  }
					  if (dmg>0) {
						  e.setDamage(e.getDamage()+dmg);
					  }
					  if (e.getEntity() instanceof LivingEntity) {
						  LivingEntity enemy = (LivingEntity)e.getEntity();
						  if (enemy.getCustomName()!=null && (enemy.getCustomName().compareTo(ChatColor.GRAY+"Zombie Ninja")==0)) {
							  boolean found=false;
							  for (int i=0;i<this.plugin.ninjavisible_list.size();i++) {
								  if (this.plugin.ninjavisible_list.get(i).val.equals(enemy.getUniqueId())) {
									  found=true;
									  enemy.removePotionEffect(PotionEffectType.INVISIBILITY);
									  	this.plugin.ninjavisible_list.get(i).resettime=Bukkit.getWorld("world").getFullTime()+20;
									  break;
								  }
							  }
							  if (!found) {
								  enemy.removePotionEffect(PotionEffectType.INVISIBILITY);
							  	this.plugin.ninjavisible_list.add(new InvisibilityData(enemy.getUniqueId(), Bukkit.getWorld("world").getFullTime()+10));
							  }
						  }
					  }
					  if (this.plugin.PlayerinJob((Player)((Projectile)e.getDamager()).getShooter(), "Support")) {
						  for (int i=0;i<this.plugin.supportmoblist.size();i++) {
							  if (this.plugin.supportmoblist.get(i).p.getName().compareTo(((Player)((Projectile)e.getDamager()).getShooter()).getName())==0) {
								  if (!this.plugin.supportmoblist.get(i).id.contains(((Entity)f).getUniqueId())) {
									  this.plugin.supportmoblist.get(i).id.add(((Entity)f).getUniqueId());
									  //Bukkit.getPlayer("sigonasr2").sendMessage("Added to list: "+((Entity)f).getUniqueId().toString());
									  this.plugin.supportmoblist.get(i).registeredtime=Bukkit.getWorld("world").getFullTime()+1200;
								  }
							  }
						  }
					  } else {
						  for (int i=0;i<this.plugin.hitmoblist.size();i++) {
							  if (this.plugin.hitmoblist.get(i).p.getName().compareTo(((Player)((Projectile)e.getDamager()).getShooter()).getName())==0) {
								  if (!this.plugin.hitmoblist.get(i).id.contains(((Entity)f).getUniqueId())) {
									  this.plugin.hitmoblist.get(i).id.add(((Entity)f).getUniqueId());
									  //Bukkit.getPlayer("sigonasr2").sendMessage("Added to list: "+((Entity)f).getUniqueId().toString());
									  this.plugin.hitmoblist.get(i).registeredtime=Bukkit.getWorld("world").getFullTime()+1200;
								  }
							  }
						  }
					  }
					  if (this.plugin.PlayerinJob((Player)((Projectile)e.getDamager()).getShooter(), "Hunter") && this.plugin.getJobLv("Hunter", (Player)((Projectile)e.getDamager()).getShooter())>=5) {
						//Deal 2 extra damage.
						  e.setDamage(e.getDamage()+2);
					  }
					if (this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat7")>0) {
						  e.setDamage(e.getDamage()+(this.plugin.getStatBonus(6, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat7"))/2));
					}
					if (f.getNoDamageTicks()<f.getMaximumNoDamageTicks()/2.0f && this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")>0) {
						  //e.setDamage(e.getDamage()+(this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5"))/4));
						double normaldmg=(this.plugin.DMGCALC.getDamage(f.getEquipment().getHelmet(), f.getEquipment().getChestplate(), f.getEquipment().getLeggings(), f.getEquipment().getBoots(), e.getDamage(), DamageCause.ENTITY_ATTACK, false));
						double throughdmg=(this.plugin.DMGCALC.getDamage(new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), e.getDamage(), DamageCause.ENTITY_ATTACK, false));
						if (throughdmg>normaldmg+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4)) {
							//This means some piercing can be done.
							//e.setDamage(normaldmg+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4));
							if (f.getHealth()-(normaldmg+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4))>0) {
								f.setHealth(f.getHealth()-(normaldmg+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4)));
								if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify4")) {
									if (f.getCustomName()!=null) {
										p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(normaldmg+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4))+" damage to "+convertToItemName(f.getCustomName())+".");
									} else {
										p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(normaldmg+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4))+" damage to "+convertToItemName(f.getType().getName())+".");
									}
								}
							} else {
								f.setHealth(0);
							}
						} else {
							//This means piercing would do extra damage. Just subtract throughdmg.
							if (f.getHealth()-throughdmg>0) {
								f.setHealth(f.getHealth()-throughdmg);
								if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify4")) {
									if (f.getCustomName()!=null) {
										p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(throughdmg)*10)/10+" damage to "+convertToItemName(f.getCustomName())+".");
									} else {
										p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(throughdmg)*10)/10+" damage to "+convertToItemName(f.getType().getName())+".");
									}
								}
							} else {
								f.setHealth(0);
							}
						}
						e.setDamage(0);
					}
					if (f.getNoDamageTicks()<f.getMaximumNoDamageTicks()/2.0f && e.getDamage()!=0) {
						if (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify4")) {
							if (f.getCustomName()!=null) {
								p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round((this.plugin.DMGCALC.getDamage(f.getEquipment().getHelmet(), f.getEquipment().getChestplate(), f.getEquipment().getLeggings(), f.getEquipment().getBoots(), e.getDamage(), DamageCause.ENTITY_ATTACK, false)))*10)/10+" damage to "+convertToItemName(f.getCustomName())+".");
							} else {
								p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round((this.plugin.DMGCALC.getDamage(f.getEquipment().getHelmet(), f.getEquipment().getChestplate(), f.getEquipment().getLeggings(), f.getEquipment().getBoots(), e.getDamage(), DamageCause.ENTITY_ATTACK, false)))*10)/10+" damage to "+convertToItemName(f.getType().getName())+".");
							}
						}
					}
				  }
			  }
		  }
		  if (f.getKiller()!=null && f.getKiller().getType()==EntityType.PLAYER) {
			  Player p = f.getKiller();
			  p.getScoreboard().getTeam(p.getName()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth()));
			  //p.sendMessage(f.getType()+" is mad at you.");
			  //if (p.getName().equalsIgnoreCase("sigonasr2")) {p.sendMessage("You are the killer of "+f.getCustomName()+".");}
			  if (this.plugin.PlayerinJob(p, "Hunter")) {
				  if (e.getEntity().getType()==EntityType.SQUID) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.00,1);
				  }
				  if (e.getEntity().getType()==EntityType.SLIME) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.005,1);
				  }
				  if (e.getEntity().getType()==EntityType.ZOMBIE) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.01,2);
				  }
				  if (e.getEntity().getType()==EntityType.SPIDER) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.01,2);
				  }
				  if (e.getEntity().getType()==EntityType.SKELETON) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.015,3);
				  }
				  if (e.getEntity().getType()==EntityType.CREEPER) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.025,5);
				  }
				  if (e.getEntity().getType()==EntityType.PIG_ZOMBIE) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.03,6);
				  }
				  if (e.getEntity().getType()==EntityType.GHAST) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.04,8);
				  }
				  if (e.getEntity().getType()==EntityType.ENDERMAN) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.04,8);
				  }
				  if (e.getEntity().getType()==EntityType.BLAZE) {
					  this.plugin.gainMoneyExp(p,"Hunter",0.10,10);
				  }
				  if (e.getEntity().getType()==EntityType.ENDER_DRAGON) {
					  this.plugin.gainMoneyExp(p,"Hunter",25.00,250);
				  }
				  if (e.getEntity().getType()==EntityType.WITHER) {
					  this.plugin.gainMoneyExp(p,"Hunter",45.00,450);
				  }
				  if (e.getEntity().getType()==EntityType.CHICKEN) {
					  this.plugin.gainMoneyExp(p,"Hunter",0,-2);
				  }
				  if (e.getEntity().getType()==EntityType.SHEEP) {
					  this.plugin.gainMoneyExp(p,"Hunter",0,-3);
				  }
				  if (e.getEntity().getType()==EntityType.PIG) {
					  this.plugin.gainMoneyExp(p,"Hunter",0,-4);
				  }
				  if (e.getEntity().getType()==EntityType.COW) {
					  this.plugin.gainMoneyExp(p,"Hunter",0,-6);
				  }
				  if (e.getEntity().getType()==EntityType.OCELOT) {
					  this.plugin.gainMoneyExp(p,"Hunter",0,-9);
				  }
				  if (e.getEntity().getType()==EntityType.WOLF) {
					  this.plugin.gainMoneyExp(p,"Hunter",0,-12);
				  }
				  if (e.getEntity().getType()==EntityType.MUSHROOM_COW) {
					  this.plugin.gainMoneyExp(p,"Hunter",0,-20);
				  }
			  }
		  }
	  }
  }

  @EventHandler
  public void onBlockPlace(BlockPlaceEvent e) {
	  Player p = e.getPlayer();
	  if (this.plugin.getConfig().getBoolean("halloween-enabled")) {
		  if (e.getItemInHand().getType()==Material.PUMPKIN) {
			  //Check the lore to see if it's a giant pumpkin.
			  if (e.getItemInHand().hasItemMeta() && e.getItemInHand().getItemMeta().getLore()!=null) {
				  boolean is_giant=false;
				  for (int i=0;i<e.getItemInHand().getItemMeta().getLore().size();i++) {
					  if (e.getItemInHand().getItemMeta().getLore().get(i).equalsIgnoreCase("Place the Giant Pumpkin on an Orange")) {
						  is_giant=true;
						  break;
					  }
				  }
				  if (is_giant) {
					  if (p.getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-1,0)).getType()==Material.WOOL) {
					  e.getBlockPlaced().setType(Material.AIR);
					  p.getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-1,0)).setType(Material.GRASS);
					  //CREATE THE GIANT PUMPKIN
						File file = new File("plugins/WorldEdit/schematics/Pumpkin.schematic");
					    if (file.exists()) {
					        try {
					        	//Pumpkin is 18x18.
					            com.sk89q.worldedit.Vector v = new com.sk89q.worldedit.Vector(e.getBlockPlaced().getLocation().getX(), e.getBlockPlaced().getLocation().getY(), e.getBlockPlaced().getLocation().getZ());
					            World worldf = Bukkit.getWorld("world");
					            BukkitWorld BWf = new BukkitWorld(worldf);
					            EditSession es = new EditSession(BWf, 2000000);
					            CuboidClipboard c1 = SchematicFormat.MCEDIT.load(file);
					            c1.place(es, v, true);
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
					    for (int x=0;x<18;x++) {
					    	for (int y=0;y<50;y++) {
					    		for (int z=0;z<18;z++) {
					    			Block b = p.getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(x,y,z));
					    			if (b.getType()==Material.WOOL && b.getData()!=4) {
						    			if (Math.random()<=0.01) {
						    				b.setType(Material.DIAMOND_ORE);
						    			}
						    			if (Math.random()<=0.001) {
						    				b.setType(Material.DIAMOND_BLOCK);
						    			}
						    			//REWARD!
						    			if (Math.random()<=0.0005) {
										  Bukkit.getWorld("world").getBlockAt(b.getLocation()).setType(Material.CHEST);
										  Chest c=(Chest)Bukkit.getWorld("world").getBlockAt(b.getLocation()).getState();
										  for (int i=0;i<27;i++) {
											  ItemStack item = null;
											  if (Math.random()<=0.3) {
												  item = getGoodie();
												  c.getBlockInventory().setItem(i, item);
											  }
										  }
						    			}
					    			}
					    		}
					    	}
					    }
					    return;
					  } else {
						  e.setCancelled(true);
						  return;
					  }
				  }
			  }
		  }
	  }
	  int myData=this.plugin.getPlayerDataSlot(p);
	  if (e.getItemInHand().hasItemMeta() && e.getItemInHand().getItemMeta().getLore()!=null) {
		  //Check the Lore.
		  for (int i=0;i<e.getItemInHand().getItemMeta().getLore().size();i++) {
			  if (e.getItemInHand().getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 9 item slots.") || e.getItemInHand().getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 54 item slots.")) {
				  e.setCancelled(true);
				  p.updateInventory();
				  //The intent is to open the inventory.
				  
				  return;
			  }
		  }
	  }
	  if (this.plugin.PlayerinJob(p, "Woodcutter")) {
		  if (e.getBlockPlaced().getType()==Material.SAPLING) {
			  //p.sendMessage("Place Sapling.");
			  this.plugin.gainMoneyExp(p,"Woodcutter",0.03,1);
		  }
		  if (e.getBlockPlaced().getType()==Material.LOG) {
			  //p.sendMessage("Place Log.");
			  this.plugin.gainMoneyExp(p,"Woodcutter",0.02,0.25);
		  }
		  if (e.getBlockPlaced().getType()==Material.WOOD) {
			  //p.sendMessage("Place Wood.");
			  this.plugin.gainMoneyExp(p,"Woodcutter",0.00,0.10);
		  }
	  }
	  if (this.plugin.PlayerinJob(p, "Builder")) {
		  if (this.plugin.playerdata_list.get(myData).GoodInteract()) {
			  if (this.plugin.getJobLv("Builder", p)>=20) {
				  if (Math.random()<=0.05) {
					  ItemStack replenishitem = e.getItemInHand().clone();
					  replenishitem.setAmount(1);
					  p.getInventory().addItem(replenishitem);
					  p.updateInventory();
				  }
			  } else
			  if (this.plugin.getJobLv("Builder", p)>=10) {
				  if (Math.random()<=0.01) {
					  ItemStack replenishitem = e.getItemInHand().clone();
					  replenishitem.setAmount(1);
					  p.getInventory().addItem(replenishitem);
					  p.updateInventory();
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.COBBLESTONE) {
					  this.plugin.gainMoneyExp(p,"Builder",0.005,1);
					  if (this.plugin.getJobLv("Builder", p)>=5 && (int)this.plugin.getcurrentJobExp("Builder", p)%5==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
			  }
			  if (e.getBlockPlaced().getType()==Material.WOOD) {
				  this.plugin.gainMoneyExp(p,"Builder",0.005,2);
				  for (int i=0;i<2;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.LOG) {
				  this.plugin.gainMoneyExp(p,"Builder",0.01,3);
				  for (int i=0;i<3;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.WOOD_STEP) {
				  this.plugin.gainMoneyExp(p,"Builder",0.015,3);
				  for (int i=0;i<2;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.COBBLESTONE_STAIRS) {
				  this.plugin.gainMoneyExp(p,"Builder",0.015,3);
				  for (int i=0;i<2;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.STONE) {
				  this.plugin.gainMoneyExp(p,"Builder",0.015,4);
				  for (int i=0;i<4;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.FENCE) {
				  this.plugin.gainMoneyExp(p,"Builder",0.015,3);
				  for (int i=0;i<3;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.STEP) {
				  switch (e.getBlockPlaced().getData()) {
					  case 0:{
						  this.plugin.gainMoneyExp(p,"Builder",0.02,4);
						  for (int i=0;i<4;i++) {
							  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
								  //Give a torch to the player.
								  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
							  }
						  }
					  }break;
					  case 1:{
						  this.plugin.gainMoneyExp(p,"Builder",0.025,4);
						  for (int i=0;i<4;i++) {
							  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
								  //Give a torch to the player.
								  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
							  }
						  }
					  }break;
					  case 3:{
						  this.plugin.gainMoneyExp(p,"Builder",0.015,3);
						  for (int i=0;i<3;i++) {
							  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
								  //Give a torch to the player.
								  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
							  }
						  }
					  }break;
					  case 4:{
						  this.plugin.gainMoneyExp(p,"Builder",0.05,9);
						  for (int i=0;i<9;i++) {
							  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
								  //Give a torch to the player.
								  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
							  }
						  }
					  }break;
					  case 5:{
						  this.plugin.gainMoneyExp(p,"Builder",0.03,5);
						  for (int i=0;i<5;i++) {
							  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
								  //Give a torch to the player.
								  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
							  }
						  }
					  }break;
					  case 6:{
						  this.plugin.gainMoneyExp(p,"Builder",0.03,5);
						  for (int i=0;i<5;i++) {
							  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
								  //Give a torch to the player.
								  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
							  }
						  }
					  }break;
					  case 7:{
						  this.plugin.gainMoneyExp(p,"Builder",0.06,12);
						  for (int i=0;i<12;i++) {
							  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
								  //Give a torch to the player.
								  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
							  }
						  }
					  }break;
					  case 8:{
						  this.plugin.gainMoneyExp(p,"Builder",0.02,4);
						  for (int i=0;i<4;i++) {
							  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
								  //Give a torch to the player.
								  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
							  }
						  }
					  }break;
					  case 9:{
						  this.plugin.gainMoneyExp(p,"Builder",0.025,4);
						  for (int i=0;i<4;i++) {
							  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
								  //Give a torch to the player.
								  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
							  }
						  }
					  }break;
					  case 10:{
						  this.plugin.gainMoneyExp(p,"Builder",0.015,3);
						  for (int i=0;i<3;i++) {
							  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
								  //Give a torch to the player.
								  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
							  }
						  }
					  }break;
					  case 11:{
						  this.plugin.gainMoneyExp(p,"Builder",0.015,3);
						  for (int i=0;i<3;i++) {
							  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
								  //Give a torch to the player.
								  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
							  }
						  }
					  }break;
					  case 12:{
						  this.plugin.gainMoneyExp(p,"Builder",0.05,9);
						  for (int i=0;i<9;i++) {
							  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
								  //Give a torch to the player.
								  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
							  }
						  }
					  }break;
					  case 13:{
						  this.plugin.gainMoneyExp(p,"Builder",0.03,5);
						  for (int i=0;i<5;i++) {
							  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
								  //Give a torch to the player.
								  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
							  }
						  }
					  }break;
					  case 14:{
						  this.plugin.gainMoneyExp(p,"Builder",0.03,5);
						  for (int i=0;i<5;i++) {
							  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
								  //Give a torch to the player.
								  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
							  }
						  }
					  }break;
					  case 15:{
						  this.plugin.gainMoneyExp(p,"Builder",0.06,12);
						  for (int i=0;i<12;i++) {
							  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
								  //Give a torch to the player.
								  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
							  }
						  }
					  }break;
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.WOOD_STAIRS) {
				  this.plugin.gainMoneyExp(p,"Builder",0.02,4);
				  for (int i=0;i<4;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.LAPIS_BLOCK) {
				  this.plugin.gainMoneyExp(p,"Builder",0.02,3);
				  for (int i=0;i<3;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.COBBLE_WALL) {
				  this.plugin.gainMoneyExp(p,"Builder",0.025,5);
				  for (int i=0;i<5;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.NETHER_BRICK_STAIRS) {
				  this.plugin.gainMoneyExp(p,"Builder",0.025,5);
				  for (int i=0;i<5;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.NETHER_BRICK) {
				  this.plugin.gainMoneyExp(p,"Builder",0.03,5);
				  for (int i=0;i<5;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.NETHER_FENCE) {
				  this.plugin.gainMoneyExp(p,"Builder",0.03,6);
				  for (int i=0;i<6;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.WOOL) {
				  this.plugin.gainMoneyExp(p,"Builder",0.035,7);
				  for (int i=0;i<7;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.getMaterial(109)) {
				  this.plugin.gainMoneyExp(p,"Builder",0.04,8);
				  for (int i=0;i<8;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.getMaterial(98)) {
				  this.plugin.gainMoneyExp(p,"Builder",0.04,8);
				  for (int i=0;i<8;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.GLASS) {
				  this.plugin.gainMoneyExp(p,"Builder",0.04,8);
				  for (int i=0;i<8;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.GLOWSTONE) {
				  this.plugin.gainMoneyExp(p,"Builder",0.05,10);
				  for (int i=0;i<10;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.HARD_CLAY) {
				  this.plugin.gainMoneyExp(p,"Builder",0.05,10);
				  for (int i=0;i<10;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.STAINED_CLAY) {
				  this.plugin.gainMoneyExp(p,"Builder",0.05,10);
				  for (int i=0;i<10;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.SANDSTONE_STAIRS) {
				  this.plugin.gainMoneyExp(p,"Builder",0.05,10);
				  for (int i=0;i<10;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.SANDSTONE) {
				  this.plugin.gainMoneyExp(p,"Builder",0.06,10);
				  for (int i=0;i<10;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.QUARTZ_STAIRS) {
				  this.plugin.gainMoneyExp(p,"Builder",0.06,12);
				  for (int i=0;i<12;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.IRON_FENCE) {
				  this.plugin.gainMoneyExp(p,"Builder",0.06,12);
				  for (int i=0;i<12;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.BRICK_STAIRS) {
				  this.plugin.gainMoneyExp(p,"Builder",0.065,9);
				  for (int i=0;i<9;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.QUARTZ_BLOCK) {
				  this.plugin.gainMoneyExp(p,"Builder",0.07,14);
				  for (int i=0;i<14;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
			  if (e.getBlockPlaced().getType()==Material.BRICK) {
				  this.plugin.gainMoneyExp(p,"Builder",0.075,11);
				  for (int i=0;i<11;i++) {
					  if (this.plugin.getJobLv("Builder", p)>=5 && ((((int)this.plugin.getcurrentJobExp("Builder", p))%5)-i)==0) {
						  //Give a torch to the player.
						  p.getInventory().addItem(new ItemStack(Material.TORCH,1)); p.updateInventory();
					  }
				  }
			  }
		  }
	  }
	  if (this.plugin.PlayerinJob(p, "Miner")) {
		  this.plugin.playerdata_list.get(myData).BadInteract(e.getBlockPlaced().getType());
	  }
	  if (this.plugin.PlayerinJob(p, "Digger")) {
		  this.plugin.playerdata_list.get(myData).BadInteract(e.getBlockPlaced().getType());
	  }
	  if (this.plugin.PlayerinJob(p, "Farmer")) {
		  if (e.getBlockPlaced().getType()==Material.CROPS) {
			  this.plugin.gainMoneyExp(p,"Farmer",0.005,1);
		  }
		  //p.sendMessage("Placing down "+e.getBlockPlaced().getType()+" ("+e.getBlockPlaced().getTypeId()+"), "+e.getBlockPlaced().getData());
		  if (e.getBlockPlaced().getType()==Material.PUMPKIN_STEM) {
			  this.plugin.gainMoneyExp(p,"Farmer",0.01,2);
		  }
		  if (e.getBlockPlaced().getType()==Material.MELON_STEM) {
			  this.plugin.gainMoneyExp(p,"Farmer",0.01,2);
		  }
	  }
	  if (this.plugin.PlayerinJob(p, "Support")) {
		  if (e.getBlockPlaced().getType()==Material.TORCH) {
			  //Make sure there are no other torches or Glowstone nearby.
			  boolean found=false;
			  for (int x=-5;x<5;x++) {
				  for (int y=-3;y<3;y++) {
					  for (int z=-5;z<5;z++) {
						  if (Bukkit.getWorld(p.getWorld().getName()).getBlockAt(p.getLocation().add(x,0,z)).getType()==Material.TORCH || Bukkit.getWorld(p.getWorld().getName()).getBlockAt(p.getLocation().add(x,0,z)).getType()==Material.GLOWSTONE) {
							  found=true;
							  break;
						  }
						  if (found) {
							  break;
						  }
					  }
					  if (found) {
						  break;
					  }
				  }
			  }
			  if (!found) {
				  this.plugin.gainMoneyExp(p,"Support",0.01,2);
			  }
		  } else
		  if (e.getBlockPlaced().getType()==Material.GLOWSTONE) {
			  //Make sure there are no other torches or Glowstone nearby.
			  boolean found=false;
			  for (int x=-5;x<5;x++) {
				  for (int y=-3;y<3;y++) {
					  for (int z=-5;z<5;z++) {
						  if (Bukkit.getWorld(p.getWorld().getName()).getBlockAt(p.getLocation().add(x,0,z)).getType()==Material.TORCH || Bukkit.getWorld(p.getWorld().getName()).getBlockAt(p.getLocation().add(x,0,z)).getType()==Material.GLOWSTONE) {
							  found=true;
							  break;
						  }
						  if (found) {
							  break;
						  }
					  }
					  if (found) {
						  break;
					  }
				  }
			  }
			  if (!found) {
				  this.plugin.gainMoneyExp(p,"Support",0.00,1);
			  }
		  }
	  }
	  if (this.plugin.getConfig().getBoolean("spleefinsession")==true && (this.plugin.getConfig().getString("spleefrequestaplayer").compareTo(p.getName())==0 || this.plugin.getConfig().getString("spleefrequestbplayer").compareTo(p.getName())==0)) {
		  e.setCancelled(true);
	  }
	  if (this.plugin.getConfig().getBoolean("spleef4insession")==true && (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName())==0 || this.plugin.getConfig().getString("spleefrequestb4player").compareTo(p.getName())==0 || this.plugin.getConfig().getString("spleefrequestc4player").compareTo(p.getName())==0 || this.plugin.getConfig().getString("spleefrequestd4player").compareTo(p.getName())==0)) {
		  e.setCancelled(true);
	  }
	  return;
  }

  @EventHandler
  public void onItemBreak(PlayerItemBreakEvent e) {
	  Player p = e.getPlayer();
	  ItemStack i = e.getBrokenItem();
	  if (i.getItemMeta()!=null && i.getItemMeta().hasDisplayName() && i.getItemMeta().getDisplayName().compareTo("Spleef Wooden Shovel")==0) {
		  i.setDurability((short)0);
		  p.getInventory().addItem(i);
	  }
	  if (i.hasItemMeta() && i.getItemMeta().getLore()!=null) {
		  boolean is_halloween=false;
		  List<String> finallore = new ArrayList<String>();
		  for (int j=0;j<i.getItemMeta().getLore().size();j++) {
			  if (i.getItemMeta().getLore().get(j).contains(ChatColor.YELLOW+"[Halloween]")) {
				  is_halloween=true;
			  }
			  finallore.add(i.getItemMeta().getLore().get(j));
		  }
		  if (is_halloween) {
			  e.getBrokenItem().setType(Material.SULPHUR);
			  
			  ItemMeta meta = e.getBrokenItem().getItemMeta();
			  meta.setDisplayName(ChatColor.DARK_GRAY+"[BROKEN] "+meta.getDisplayName());
			  finallore.add("");
			  finallore.add("Will be repaired @"+(Bukkit.getWorld("world").getFullTime()+12096000));
			  meta.setLore(finallore);
			  e.getBrokenItem().setItemMeta(meta);
			  p.getInventory().addItem(e.getBrokenItem());
		  }
		  return;
	  }
  }
  
  /*
  @EventHandler
  public void onInventoryMove(InventoryClickEvent e) {
	  if (e.getView().getPlayer()!=null) {
		  Player p = (Player)e.getView().getPlayer();
		  if ((e.getView().getPlayer().getOpenInventory().getType()==InventoryType.WORKBENCH || e.getView().getPlayer().getOpenInventory().getType()==InventoryType.CRAFTING) && e.getSlotType()==SlotType.RESULT) {
			  //This is something we just crafted.
			  //Bukkit.getPlayer("sigonasr2").sendMessage("Inventory Type: "+e.getView().getPlayer().getOpenInventory().getType()+" Action:"+e.getAction().name());

			  //this.plugin.tempinventory = Bukkit.getPlayer(e.getWhoClicked().getName()).getInventory().getContents();
			  ItemStack result = e.getCurrentItem();
			  int craftamt = e.getCurrentItem().getAmount();
			  //Bukkit.getPlayer("sigonasr2").sendMessage("Resulting item is "+result.getResult().getAmount()+" "+result.getResult().getType());
			  if (this.plugin.PlayerinJob(p,"Digger")) {
				  if (result.getType()==Material.SANDSTONE) {
					  this.plugin.gainMoneyExp(p,"Digger",0.02*craftamt,6*craftamt);
				  }
				  if (result.getType()==Material.BRICK) {
					  this.plugin.gainMoneyExp(p,"Digger",0.04*craftamt,8*craftamt);
				  }
			  }
			  if (this.plugin.PlayerinJob(p,"Weaponsmith")) {
				  boolean crafteditem=false;
				  if (result.getType()==Material.ARROW) {
					  this.plugin.gainMoneyExp(p,"Weaponsmith",0.025*craftamt,4*craftamt);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.WOOD_SWORD) {
					  this.plugin.gainMoneyExp(p,"Weaponsmith",0.05*craftamt,10*craftamt);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.FLINT_AND_STEEL) {
					  this.plugin.gainMoneyExp(p,"Weaponsmith",0.06*craftamt,12*craftamt);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.BOW) {
					  this.plugin.gainMoneyExp(p,"Weaponsmith",0.075*craftamt,12*craftamt);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.IRON_SWORD) {
					  this.plugin.gainMoneyExp(p,"Weaponsmith",0.375*craftamt,75*craftamt);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.GOLD_SWORD) {
					  this.plugin.gainMoneyExp(p,"Weaponsmith",0.50*craftamt,100*craftamt);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.DIAMOND_SWORD) {
					  this.plugin.gainMoneyExp(p,"Weaponsmith",0.975*craftamt,175*craftamt);
					  crafteditem=true;
				  }
			  }
			  if (this.plugin.PlayerinJob(p,"Blacksmith")) {
				  boolean crafteditem=false;
				  if (result.getType()==Material.STONE_HOE) {
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.04*craftamt,7*craftamt);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.STONE_SPADE) {
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.05,8);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.STONE_PICKAXE) {
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.075,15);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.LEATHER_BOOTS) {
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.125,8);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.LEATHER_HELMET) {
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.15,14);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.LEATHER_LEGGINGS) {
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.175,15);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.LEATHER_CHESTPLATE) {
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.20,18);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.IRON_SPADE) {
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.25,18);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.IRON_HOE) {
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.325,24);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.IRON_BOOTS) {
					  int mult=1;
					  if ((result.getItemMeta().getDisplayName()!=null && !result.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getItemMeta().getDisplayName()==null) {
						  mult=8;
					  }
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.375*mult,27*mult);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.IRON_PICKAXE) {
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.40,30);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.IRON_HELMET) {
					  int mult=1;
					  if ((result.getItemMeta().getDisplayName()!=null && !result.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getItemMeta().getDisplayName()==null) {
						  mult=8;
					  }
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.50*mult,45*mult);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.GOLD_SPADE) {
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.625,55);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.GOLD_HOE) {
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.65,60);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.IRON_LEGGINGS) {
					  int mult=1;
					  if ((result.getItemMeta().getDisplayName()!=null && !result.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getItemMeta().getDisplayName()==null) {
						  mult=8;
					  }
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.725*mult,60*mult);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.DIAMOND_SPADE) {
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.75,65);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.DIAMOND_HOE) {
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.80,70);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.GOLD_BOOTS) {
					  int mult=1;
					  if ((result.getItemMeta().getDisplayName()!=null && !result.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getItemMeta().getDisplayName()==null) {
						  mult=8;
					  }
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.825*mult,50*mult);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.IRON_CHESTPLATE) {
					  int mult=1;
					  if ((result.getItemMeta().getDisplayName()!=null && !result.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getItemMeta().getDisplayName()==null) {
						  mult=8;
					  }
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.875*mult,70*mult);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.GOLD_HELMET) {
					  int mult=1;
					  if ((result.getItemMeta().getDisplayName()!=null && !result.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getItemMeta().getDisplayName()==null) {
						  mult=8;
					  }
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.925*mult,80*mult);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.DIAMOND_PICKAXE) {
					  this.plugin.gainMoneyExp(p,"Blacksmith",0.925,80);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.DIAMOND_BOOTS) {
					  int mult=1;
					  if ((result.getItemMeta().getDisplayName()!=null && !result.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getItemMeta().getDisplayName()==null) {
						  mult=8;
					  }
					  this.plugin.gainMoneyExp(p,"Blacksmith",1.00*mult,85*mult);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.GOLD_LEGGINGS) {
					  int mult=1;
					  if ((result.getItemMeta().getDisplayName()!=null && !result.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getItemMeta().getDisplayName()==null) {
						  mult=8;
					  }
					  this.plugin.gainMoneyExp(p,"Blacksmith",1.025*mult,100*mult);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.GOLD_CHESTPLATE) {
					  int mult=1;
					  if ((result.getItemMeta().getDisplayName()!=null && !result.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getItemMeta().getDisplayName()==null) {
						  mult=8;
					  }
					  this.plugin.gainMoneyExp(p,"Blacksmith",1.15*mult,130*mult);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.DIAMOND_HELMET) {
					  int mult=1;
					  if ((result.getItemMeta().getDisplayName()!=null && !result.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getItemMeta().getDisplayName()==null) {
						  mult=8;
					  }
					  this.plugin.gainMoneyExp(p,"Blacksmith",1.15*mult,125*mult);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.DIAMOND_LEGGINGS) {
					  int mult=1;
					  if ((result.getItemMeta().getDisplayName()!=null && !result.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getItemMeta().getDisplayName()==null) {
						  mult=8;
					  }
					  this.plugin.gainMoneyExp(p,"Blacksmith",1.325*mult,145*mult);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.DIAMOND_CHESTPLATE) {
					  int mult=1;
					  if ((result.getItemMeta().getDisplayName()!=null && !result.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || result.getItemMeta().getDisplayName()==null) {
						  mult=8;
					  }
					  this.plugin.gainMoneyExp(p,"Blacksmith",1.50*mult,175*mult);
					  crafteditem=true;
				  }
			  }
			  if (this.plugin.PlayerinJob(p,"Cook")) {
				  boolean crafteditem=false;
				  if (result.getType()==Material.BREAD) {
					  this.plugin.gainMoneyExp(p,"Cook",0.0125,5);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.MUSHROOM_SOUP) {
					  this.plugin.gainMoneyExp(p,"Cook",0.0375,15);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.COOKIE) {
					  this.plugin.gainMoneyExp(p,"Cook",0.0675,25);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.GOLDEN_CARROT) {
					  this.plugin.gainMoneyExp(p,"Cook",0.0875,35);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.GOLDEN_APPLE) {
					  this.plugin.gainMoneyExp(p,"Cook",0.1125,45);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.PUMPKIN_PIE) {
					  this.plugin.gainMoneyExp(p,"Cook",0.15,60);
					  crafteditem=true;
				  }
				  if (result.getType()==Material.CAKE) {
					  this.plugin.gainMoneyExp(p,"Cook",0.2125,85);
					  crafteditem=true;
				  }
				  if (this.plugin.getJobLv("Cook", p)>=10 && crafteditem==true) {
					  ItemStack resultingitem = result;
					  resultingitem.setAmount(resultingitem.getAmount()*2);
				  }
			  }
			  if (this.plugin.PlayerinJob(p,"Support")) {
				  if (result.getType()==Material.BREAD) {
					  this.plugin.gainMoneyExp(p,"Support",0.015,2);
				  }
				  if (result.getType()==Material.MUSHROOM_SOUP) {
					  this.plugin.gainMoneyExp(p,"Support",0.015,2);
				  }
				  if (result.getType()==Material.COOKIE) {
					  this.plugin.gainMoneyExp(p,"Support",0.015,2);
				  }
				  if (result.getType()==Material.GOLDEN_CARROT) {
					  this.plugin.gainMoneyExp(p,"Support",0.015,2);
				  }
				  if (result.getType()==Material.GOLDEN_APPLE) {
					  this.plugin.gainMoneyExp(p,"Support",0.015,2);
				  }
				  if (result.getType()==Material.PUMPKIN_PIE) {
					  this.plugin.gainMoneyExp(p,"Support",0.015,2);
				  }
				  if (result.getType()==Material.CAKE) {
					  this.plugin.gainMoneyExp(p,"Support",0.015,2);
				  }
				  if (result.getType()==Material.IRON_SWORD) {
					  this.plugin.gainMoneyExp(p,"Support",0.015,3);
				  }
				  if (result.getType()==Material.IRON_CHESTPLATE || result.getType()==Material.IRON_HELMET || result.getType()==Material.IRON_BOOTS || result.getType()==Material.IRON_LEGGINGS) {
					  this.plugin.gainMoneyExp(p,"Support",0.025,5);
				  }
				  if (result.getType()==Material.DIAMOND_SWORD) {
					  this.plugin.gainMoneyExp(p,"Support",0.075,8);
				  }
				  if (result.getType()==Material.DIAMOND_CHESTPLATE || result.getType()==Material.DIAMOND_HELMET || result.getType()==Material.DIAMOND_BOOTS || result.getType()==Material.DIAMOND_LEGGINGS) {
					  this.plugin.gainMoneyExp(p,"Support",0.20,20);
				  }
				  if (result.getType()==Material.CAKE) {
					  this.plugin.gainMoneyExp(p,"Support",0.03,2);
				  }
			  }
		  }
	  }
  }*/

  @EventHandler
  public void onInventoryCloseEvent(InventoryCloseEvent e) {
	  Player p = (Player)e.getPlayer();
	  p.getScoreboard().getTeam(p.getName()).setPrefix(ChatColor.WHITE+"");
	  if (p.hasPermission("group.moderator")) {
		  p.getScoreboard().getTeam(p.getName()).setPrefix(ChatColor.GREEN+"");
	  }
	  if (p.hasPermission("group.administrators")) {
		  p.getScoreboard().getTeam(p.getName()).setPrefix(ChatColor.LIGHT_PURPLE+"");
	  }
	  if (e.getInventory().getName().contains("Item Cube")) {
		  int identifier=-1;
		  //Get idenfitier.
		  String ident_string=e.getInventory().getTitle().substring(e.getInventory().getTitle().indexOf("#")).replace("#", "");
		  identifier=Integer.valueOf(ident_string);
		  if (identifier==-1) {
			  Bukkit.getLogger().severe("SEVERE error when saving Item Cube contents! Could not get ID!");
			  return;
		  }
		  //We are going to save the contents of this inventory appropriately.
		  FileConfiguration f = this.plugin.reloadItemCubeConfig(identifier);
		  for (int i=0;i<e.getInventory().getContents().length;i++) {
			  f.set("item-"+i, e.getInventory().getItem(i));
		  }
		  this.plugin.saveItemCubeConfig(f, identifier);
	  }	else 
	  if (e.getInventory().getTitle().equalsIgnoreCase("Notification Options")) {
		  //We have to save the notification settings for this player.
		  FileConfiguration savefile = this.plugin.getAccountsConfig();
		  savefile.set(p.getName()+".settings.notify1", Boolean.valueOf(e.getInventory().getItem(2).getType()==Material.REDSTONE_TORCH_ON));
		  savefile.set(p.getName()+".settings.notify2", Boolean.valueOf(e.getInventory().getItem(6).getType()==Material.REDSTONE_TORCH_ON));
		  savefile.set(p.getName()+".settings.notify3", Boolean.valueOf(e.getInventory().getItem(11).getType()==Material.REDSTONE_TORCH_ON));
		  savefile.set(p.getName()+".settings.notify4", Boolean.valueOf(e.getInventory().getItem(15).getType()==Material.REDSTONE_TORCH_ON));
		  savefile.set(p.getName()+".settings.notify5", Boolean.valueOf(e.getInventory().getItem(20).getType()==Material.REDSTONE_TORCH_ON));
		  savefile.set(p.getName()+".settings.notify6", Boolean.valueOf(e.getInventory().getItem(24).getType()==Material.REDSTONE_TORCH_ON));
		  this.plugin.saveAccountsConfig();
	  }
  }
  

	/**
	 * Compares two items to each other. Returns true if they match.
	 * @param stack1 The first item stack
	 * @param stack2 The second item stack
	 * @return true if the itemstacks match. (Material, durability, enchants)
	 */
	public static boolean matches(ItemStack stack1, ItemStack stack2){
		if(stack1 == stack2) return true; //Referring to the same thing, or both are null.
		if(stack1 == null || stack2 == null) return false; //One of them is null (Can't be both, see above)
		
		if(stack1.getType() != stack2.getType()) return false; //Not the same material
		if(stack1.getDurability() != stack2.getDurability()) return false; //Not the same durability
		if(!stack1.getEnchantments().equals(stack2.getEnchantments())) return false; //They have the same enchants
		
		try{
			Class.forName("org.bukkit.inventory.meta.EnchantmentStorageMeta");
			boolean book1 = stack1.getItemMeta() instanceof EnchantmentStorageMeta;
			boolean book2 = stack2.getItemMeta() instanceof EnchantmentStorageMeta;
			if(book1 != book2) return false;//One has enchantment meta, the other does not.
			if(book1 == true){ //They are the same here (both true or both false).  So if one is true, the other is true.
				Map<Enchantment, Integer> ench1 = ((EnchantmentStorageMeta) stack1.getItemMeta()).getStoredEnchants();
				Map<Enchantment, Integer> ench2 = ((EnchantmentStorageMeta) stack2.getItemMeta()).getStoredEnchants();
				if(!ench1.equals(ench2)) return false; //Enchants aren't the same.
			}
		}
		catch(ClassNotFoundException e){
			//Nothing. They dont have a build high enough to support this.
		}
		
		return true;
	}
  
  /**
	 * Returns the number of items that can be given to the inventory safely.
	 * @param inv The inventory to count
	 * @param item The item prototype.  Material, durabiltiy and enchants must match for 'stackability' to occur.
	 * @return The number of items that can be given to the inventory safely.
	 */
	public static int countSpace(Inventory inv, ItemStack item){
		int space = 0;
		for(ItemStack iStack : inv.getContents()){
			if(iStack == null || iStack.getType() == Material.AIR){
				space += item.getMaxStackSize();
			}
			else if(matches(item, iStack)){
				space += item.getMaxStackSize() - iStack.getAmount();
			}
		}
		return space;
	}
	
  public void giveLegendaryItem(Player p) {
	  String prefix = "";
	  String suffix = "";
	  int type=(int)(Math.random()*6);
	  //int type=5; //TESTING.
	  List<String> enchants1 = new ArrayList<String>();
	  List<String> enchants2 = new ArrayList<String>();
	  ItemStack finalitem = null;
	  if (type==0) {
		  finalitem=new ItemStack(Material.DIAMOND_HELMET);
		  enchants1.add("Protective");
		  enchants1.add("Fire-Proof");
		  enchants1.add("Blast Resistant");
		  enchants1.add("Untouchable");
		  enchants1.add("Breathing");
		  enchants1.add("Working");
		  enchants1.add("Unbreaking");
		  enchants1.add("Thorny");
		  enchants2.add("Life");
		  enchants2.add("Resistance");
		  enchants2.add("Durability");
		  enchants2.add("Protection");
	  }
	  if (type==1) {
		  finalitem=new ItemStack(Material.DIAMOND_CHESTPLATE);
		  enchants1.add("Protective");
		  enchants1.add("Fire-Proof");
		  enchants1.add("Blast Resistant");
		  enchants1.add("Untouchable");
		  enchants1.add("Unbreaking");
		  enchants1.add("Thorny");
		  enchants2.add("Life");
		  enchants2.add("Resistance");
		  enchants2.add("Durability");
		  enchants2.add("Protection");
	  }
	  if (type==2) {
		  finalitem=new ItemStack(Material.DIAMOND_LEGGINGS);
		  enchants1.add("Protective");
		  enchants1.add("Fire-Proof");
		  enchants1.add("Blast Resistant");
		  enchants1.add("Untouchable");
		  enchants1.add("Unbreaking");
		  enchants1.add("Thorny");
		  enchants2.add("Life");
		  enchants2.add("Resistance");
		  enchants2.add("Durability");
		  enchants2.add("Protection");
	  }
	  if (type==3) {
		  finalitem=new ItemStack(Material.DIAMOND_BOOTS);
		  enchants1.add("Protective");
		  enchants1.add("Fire-Proof");
		  enchants1.add("Blast Resistant");
		  enchants1.add("Untouchable");
		  enchants1.add("Lightweight");
		  enchants1.add("Unbreaking");
		  enchants1.add("Thorny");
		  enchants2.add("Life");
		  enchants2.add("Resistance");
		  enchants2.add("Durability");
		  enchants2.add("Protection");
	  }
	  if (type==4) {
		  finalitem=new ItemStack(Material.BOW);
		  enchants1.add("Power");
		  enchants1.add("Punch");
		  enchants1.add("Flaming");
		  enchants1.add("Infinite");
		  enchants1.add("Unbreaking");
		  enchants2.add("Smiting");
		  enchants2.add("Penetration");
		  enchants2.add("Draining");
		  enchants2.add("Fury");
		  enchants2.add("Power");
	  }
	  if (type==5) {
		  finalitem=new ItemStack(Material.DIAMOND_SWORD);
		  enchants1.add("Damaging");
		  enchants1.add("Knockback");
		  enchants1.add("Undead");
		  enchants1.add("Baning");
		  enchants1.add("Fiery");
		  enchants1.add("Greedy");
		  enchants1.add("Unbreaking");
		  enchants2.add("Smiting");
		  enchants2.add("Penetration");
		  enchants2.add("Draining");
		  enchants2.add("Fury");
		  enchants2.add("Power");
	  }
	  prefix = enchants1.get((int)(Math.random()*enchants1.size()));
	  suffix = enchants2.get((int)(Math.random()*enchants2.size()));
	  if (prefix.equalsIgnoreCase("Protective")) {
		  finalitem.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
	  }
	  if (prefix.equalsIgnoreCase("Fire-Proof")) {
		  finalitem.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 10);
	  }
	  if (prefix.equalsIgnoreCase("Blast Resistant")) {
		  finalitem.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 10);
	  }
	  if (prefix.equalsIgnoreCase("Untouchable")) {
		  finalitem.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 10);
	  }
	  if (prefix.equalsIgnoreCase("Breathing")) {
		  finalitem.addUnsafeEnchantment(Enchantment.OXYGEN, 10);
	  }
	  if (prefix.equalsIgnoreCase("Working")) {
		  finalitem.addUnsafeEnchantment(Enchantment.WATER_WORKER, 10);
	  }
	  if (prefix.equalsIgnoreCase("Unbreaking")) {
		  finalitem.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
	  }
	  if (prefix.equalsIgnoreCase("Thorny")) {
		  finalitem.addUnsafeEnchantment(Enchantment.THORNS, 10);
	  }
	  if (prefix.equalsIgnoreCase("Untouchable")) {
		  finalitem.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 10);
	  }
	  if (prefix.equalsIgnoreCase("Lightweight")) {
		  finalitem.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 10);
	  }
	  if (prefix.equalsIgnoreCase("Power")) {
		  finalitem.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 10);
	  }
	  if (prefix.equalsIgnoreCase("Damaging")) {
		  finalitem.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
	  }
	  if (prefix.equalsIgnoreCase("Knockback")) {
		  finalitem.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
	  }
	  if (prefix.equalsIgnoreCase("Punch")) {
		  finalitem.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 10);
	  }
	  if (prefix.equalsIgnoreCase("Flaming")) {
		  finalitem.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 10);
	  }
	  if (prefix.equalsIgnoreCase("Infinite")) {
		  finalitem.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 10);
	  }
	  if (prefix.equalsIgnoreCase("Undead")) {
		  finalitem.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 10);
	  }
	  if (prefix.equalsIgnoreCase("Baning")) {
		  finalitem.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 10);
	  }
	  if (prefix.equalsIgnoreCase("Fiery")) {
		  finalitem.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10);
	  }
	  if (prefix.equalsIgnoreCase("Greedy")) {
		  finalitem.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
	  }
	  ItemMeta meta = finalitem.getItemMeta();
	  meta.setDisplayName(ChatColor.GOLD+""+ChatColor.BOLD+prefix+" "+convertToItemName(finalitem.getType().name())+" of "+suffix);
	  List<String> setLore = new ArrayList<String>();
	  if (suffix.equalsIgnoreCase("Life")) {
		  setLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*30)+10)+" "+ChatColor.BLUE+"Health");
	  }
	  if (suffix.equalsIgnoreCase("Resistance")) {
		  setLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*70)+20)+"% "+ChatColor.BLUE+"Damage Reduction");
	  }
	  if (suffix.equalsIgnoreCase("Durability")) {
		  setLore.add(ChatColor.YELLOW+"+"+(((int)(Math.random()*200)+50)*10)+"% "+ChatColor.BLUE+"Durability");
	  }
	  if (suffix.equalsIgnoreCase("Protection")) {
		  setLore.add(ChatColor.YELLOW+"+"+(((int)(Math.random()*50)+10))+"% "+ChatColor.BLUE+"Block Chance");
	  }
	  if (suffix.equalsIgnoreCase("Smiting")) {
		  setLore.add(ChatColor.YELLOW+"+"+(((int)(Math.random()*50)+10))+"% "+ChatColor.BLUE+"Critical Chance");
	  }
	  if (suffix.equalsIgnoreCase("Penetration")) {
		  setLore.add(ChatColor.YELLOW+"+"+(((int)(Math.random()*20)+5))+" "+ChatColor.BLUE+"Armor Penetration");
	  }
	  if (suffix.equalsIgnoreCase("Draining")) {
		  setLore.add(ChatColor.YELLOW+"+"+(((int)(Math.random()*30)+20))+"% "+ChatColor.BLUE+"Life Steal");
	  }
	  if (suffix.equalsIgnoreCase("Fury")) {
		  setLore.add(ChatColor.YELLOW+"+"+(((int)(Math.random()*50)+10))+"% "+ChatColor.BLUE+"Attack Speed");
	  }
	  if (suffix.equalsIgnoreCase("Power")) {
		  setLore.add(ChatColor.YELLOW+"+"+(((int)(Math.random()*10)+5))+" "+ChatColor.BLUE+"Damage");
	  }
	  setLore.add("");
	  setLore.add(ChatColor.YELLOW+"[Halloween]");
	  setLore.add("This item was created during the Halloween");
	  setLore.add("event. When this item breaks, it simply turns");
	  setLore.add("into a \"broken\" state and has a recharge time");
	  setLore.add("of 1 week. The item will be fully restored after");
	  setLore.add("a week of cooldown.");
	  meta.setLore(setLore);
	  finalitem.setItemMeta(meta);
	  //finalitem.setDurability((short)1560); //TESTING.
	  boolean full=true;
	  for (int i=0;i<p.getInventory().getContents().length;i++) {
		  if (p.getInventory().getContents()[i]==null) {
			  full=false;
			  break;
		  }
	  }
	  if (!full) {
		  p.getInventory().addItem(finalitem);
	  } else {
		  p.getWorld().dropItemNaturally(p.getLocation(), finalitem); //Drop item on the ground if our inventory is full. That way we don't lose it.
	  }
  }
  
  @EventHandler
  public void onInventoryClickEvent(InventoryClickEvent event) {
	  Player p = (Player)event.getWhoClicked();
	  p.getScoreboard().getTeam(p.getName()).setPrefix(ChatColor.DARK_GRAY+"");
	  if (p.hasPermission("group.moderator")) {
		  p.getScoreboard().getTeam(p.getName()).setPrefix(ChatColor.DARK_GREEN+"");
	  }
	  if (p.hasPermission("group.administrators")) {
		  p.getScoreboard().getTeam(p.getName()).setPrefix(ChatColor.DARK_PURPLE+"");
	  }
	  if (event.getCursor()!=null) {
		  //Regardless of the inventory, if we try to put it inside a chest, got to try to insert it in there.
  		  if (event.getCurrentItem()!=null) {
			  if (event.getCursor()!=null && event.getCursor().getType()!=Material.AIR && (event.getCurrentItem().getType()==Material.CHEST || event.getCurrentItem().getType()==Material.TRAPPED_CHEST) && event.getClick()==ClickType.LEFT) {
				  //We have to attempt to insert the item in the Item Cube.
				boolean largechest=false;
				boolean smallchest=false;
				int identifier=-1;
				  if (event.getCurrentItem().getItemMeta().getLore()!=null) {
					//Check to see if the Lore contains anything.
					for (int i=0;i<event.getCurrentItem().getItemMeta().getLore().size();i++) {
						if (event.getCurrentItem().getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 9 item slots.")) {
							smallchest=true;
						}
						if (event.getCurrentItem().getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 54 item slots.")) {
							largechest=true;
						}
						if (event.getCurrentItem().getItemMeta().getLore().get(i).contains("ID#")) {
							identifier=Integer.valueOf(event.getCurrentItem().getItemMeta().getLore().get(i).replace("ID#", ""));
						}
					}
					if (identifier==-1) {
						//This doesn't have an identifier yet. Create a new one.
						identifier=this.plugin.getConfig().getInt("item-cube-numb");
						this.plugin.getConfig().set("item-cube-numb", Integer.valueOf(identifier+1));
						this.plugin.saveConfig();
						//See if this chest is stacked. If so, set the amount to 1, and drop a side inventory of Item Cubes.
						if (event.getCurrentItem().getAmount()>1) {
							ItemStack newitem = event.getCurrentItem().clone();
							newitem.setAmount(event.getCurrentItem().getAmount()-1);
							event.getCurrentItem().setAmount(1);
							//Drop the rest on the ground.
							p.getWorld().dropItemNaturally(p.getLocation(), newitem);
						}
						ItemMeta meta = event.getCurrentItem().getItemMeta();
						List<String> newlore = meta.getLore();
						newlore.add("ID#"+identifier);
						meta.setLore(newlore);
						event.getCurrentItem().setItemMeta(meta);
					}
					if (smallchest) {
						FileConfiguration f = this.plugin.reloadItemCubeConfig(identifier);
						if (!f.contains("created")) {
							for (int i=0;i<9;i++) {
								f.set("item-"+i, new ItemStack(Material.AIR));
							}
							f.set("item-0", event.getCursor());
							event.getCursor().setType(Material.AIR);
							f.set("created", Boolean.valueOf(true));
						} else {
							
							//We need to see if we have the inventory opened already...If so we have to add it to THAT one.
							Inventory thisinven=Bukkit.createInventory(event.getWhoClicked(), 9, "Item Cube #"+identifier);
							boolean changeinven=false;
							if (event.getInventory().getTitle().contains("Item Cube") && event.getInventory().getTitle().length()>0) {
								if (Integer.valueOf(event.getInventory().getTitle().substring(event.getInventory().getTitle().indexOf("#")).replace("#", ""))==identifier) {
									thisinven=event.getInventory();
									changeinven=true;
								}
							} 
							if (!changeinven) {
								for (int i=0;i<9;i++) {
									//items.add(f.getItemStack("item-"+i));
									if (f.contains("item-"+i)) {
										thisinven.addItem(f.getItemStack("item-"+i));
									}
								}
							}
							int countinven = countSpace(thisinven,event.getCursor());
							if (countinven>=event.getCursor().getAmount()) {
								//We can simply add it in no problem.
								thisinven.addItem(event.getCursor());
								  for (int i=0;i<thisinven.getContents().length;i++) {
									  f.set("item-"+i, thisinven.getItem(i));
								  }
								  event.setCursor(new ItemStack(Material.AIR));
									this.plugin.saveItemCubeConfig(f, identifier);
									//Cancel the event here too.
									event.setCancelled(true);
									return;
							} else 
							if (countinven>0) {
								//We can at least fit a few.
								int fit = event.getCursor().getAmount()-countinven;
								//Leave behind this many.
								ItemStack thisitem = event.getCursor(), thisitem2 = event.getCursor();
								thisitem.setAmount(fit);
								event.setCursor(thisitem);
								//Bukkit.getPlayer("sigonasr2").sendMessage("Cursor gets "+thisitem.getAmount());
								thisitem2.setAmount(countinven);
								thisinven.addItem(thisitem2);
								//Bukkit.getPlayer("sigonasr2").sendMessage("Item Cube gets "+thisitem2.getAmount());
								  for (int i=0;i<thisinven.getContents().length;i++) {
									  f.set("item-"+i, thisinven.getItem(i));
								  }
									this.plugin.saveItemCubeConfig(f, identifier);
									p.updateInventory();
							}
							else {
								//Well, we can't do anything, just treat it as an item swap.
								this.plugin.saveItemCubeConfig(f, identifier);
							}
						}
					}
					if (largechest) {
						FileConfiguration f = this.plugin.reloadItemCubeConfig(identifier);
						if (!f.contains("created")) {
							for (int i=0;i<54;i++) {
								f.set("item-"+i, new ItemStack(Material.AIR));
							}
							f.set("item-0", event.getCursor());
							event.getCursor().setType(Material.AIR);
							f.set("created", Boolean.valueOf(true));
						} else {
							//If it does exist already, we need to add it to that inventory.
							//Try to find a blank slot in there.
							//List<ItemStack> items = new ArrayList<ItemStack>();
							//We need to see if we have the inventory opened already...If so we have to add it to THAT one.
							Inventory thisinven=Bukkit.createInventory(event.getWhoClicked(), 54, "Item Cube #"+identifier);
							boolean changeinven=false;
							if (event.getInventory().getTitle().contains("Item Cube") && event.getInventory().getTitle().length()>0) {
								if (Integer.valueOf(event.getInventory().getTitle().substring(event.getInventory().getTitle().indexOf("#")).replace("#", ""))==identifier) {
									thisinven=event.getInventory();
									changeinven=true;
								}
							}
							if (!changeinven) {
								for (int i=0;i<54;i++) {
									//items.add(f.getItemStack("item-"+i));
									if (f.contains("item-"+i)) {
										thisinven.addItem(f.getItemStack("item-"+i));
									}
								}
							}
							int countinven = countSpace(thisinven,event.getCursor());
							if (countinven>=event.getCursor().getAmount()) {
								//We can simply add it in no problem.
								thisinven.addItem(event.getCursor());
								  for (int i=0;i<thisinven.getContents().length;i++) {
									  f.set("item-"+i, thisinven.getItem(i));
								  }
								  event.setCursor(new ItemStack(Material.AIR));
									this.plugin.saveItemCubeConfig(f, identifier);
									//Cancel the event here too.
									event.setCancelled(true);
									return;
							} else 
							if (countinven>0) {
								//We can at least fit a few.
								int fit = event.getCursor().getAmount()-countinven;
								//Leave behind this many.
								ItemStack thisitem = event.getCursor(), thisitem2 = event.getCursor();
								thisitem.setAmount(fit);
								event.setCursor(thisitem);
								//Bukkit.getPlayer("sigonasr2").sendMessage("Cursor gets "+thisitem.getAmount());
								thisitem2.setAmount(countinven);
								thisinven.addItem(thisitem2);
								//Bukkit.getPlayer("sigonasr2").sendMessage("Item Cube gets "+thisitem2.getAmount());
								  for (int i=0;i<thisinven.getContents().length;i++) {
									  f.set("item-"+i, thisinven.getItem(i));
								  }
									this.plugin.saveItemCubeConfig(f, identifier);
									p.updateInventory();
							}
							else {
								//Well, we can't do anything, just treat it as an item swap.
								this.plugin.saveItemCubeConfig(f, identifier);
							}
						}
						this.plugin.saveItemCubeConfig(f, identifier);
					}
				  }
			  }
		  }
	  }
	  if (event.getInventory().getType()==InventoryType.CRAFTING /*|| event.getInventory().getType()==InventoryType.CHEST*//*Buggy for some reason. We can't open chests in chests.*/) {
		  if (event.getCurrentItem()!=null) {
			  if ((event.getCurrentItem().getType()==Material.CHEST || event.getCurrentItem().getType()==Material.TRAPPED_CHEST) && event.getClick()==ClickType.RIGHT) {
				boolean largechest=false;
				boolean smallchest=false;
				int identifier=-1;
				  if (event.getCurrentItem().getItemMeta().getLore()!=null) {
					//Check to see if the Lore contains anything.
					for (int i=0;i<event.getCurrentItem().getItemMeta().getLore().size();i++) {
						if (event.getCurrentItem().getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 9 item slots.")) {
							smallchest=true;
						}
						if (event.getCurrentItem().getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 54 item slots.")) {
							largechest=true;
						}
						if (event.getCurrentItem().getItemMeta().getLore().get(i).contains("ID#")) {
							identifier=Integer.valueOf(event.getCurrentItem().getItemMeta().getLore().get(i).replace("ID#", ""));
						}
					}
					if (identifier==-1) {
						//This doesn't have an identifier yet. Create a new one.
						identifier=this.plugin.getConfig().getInt("item-cube-numb");
						this.plugin.getConfig().set("item-cube-numb", Integer.valueOf(identifier+1));
						this.plugin.saveConfig();
						//See if this chest is stacked. If so, set the amount to 1, and drop a side inventory of Item Cubes.
						if (event.getCurrentItem().getAmount()>1) {
							ItemStack newitem = event.getCurrentItem().clone();
							newitem.setAmount(event.getCurrentItem().getAmount()-1);
							event.getCurrentItem().setAmount(1);
							//Drop the rest on the ground.
							p.getWorld().dropItemNaturally(p.getLocation(), newitem);
						}
						ItemMeta meta = event.getCurrentItem().getItemMeta();
						List<String> newlore = meta.getLore();
						newlore.add("ID#"+identifier);
						meta.setLore(newlore);
						event.getCurrentItem().setItemMeta(meta);
					}
					Inventory screen = null;
					if (smallchest) {
						FileConfiguration f = this.plugin.reloadItemCubeConfig(identifier);
						if (!f.contains("created")) {
							for (int i=0;i<9;i++) {
								f.set("item-"+i, new ItemStack(Material.AIR));
							}
							f.set("created", Boolean.valueOf(true));
						}
						//List<ItemStack> items = new ArrayList<ItemStack>();
						screen=Bukkit.createInventory(event.getWhoClicked(), 9, "Item Cube #"+identifier);
						for (int i=0;i<9;i++) {
							//items.add(f.getItemStack("item-"+i));
							screen.setItem(i, f.getItemStack("item-"+i));
						}
						this.plugin.saveItemCubeConfig(f, identifier);
					}
					if (largechest) {
						FileConfiguration f = this.plugin.reloadItemCubeConfig(identifier);
						if (!f.contains("created")) {
							for (int i=0;i<54;i++) {
								f.set("item-"+i, new ItemStack(Material.AIR));
							}
							f.set("created", Boolean.valueOf(true));
						}
						//List<ItemStack> items = new ArrayList<ItemStack>();
						screen=Bukkit.createInventory(event.getWhoClicked(), 54, "Large Item Cube #"+identifier);
						for (int i=0;i<54;i++) {
							//items.add(f.getItemStack("item-"+i));
							screen.setItem(i, f.getItemStack("item-"+i));
						}
						this.plugin.saveItemCubeConfig(f, identifier);
					}
					if (screen!=null) {
						event.getWhoClicked().closeInventory();
						event.getWhoClicked().openInventory(screen);
						event.setCancelled(true);
						//return;
					}
				  }
			  }
		  }
	  }else
	  if (event.getInventory().getType()==InventoryType.CHEST && !event.getInventory().getName().equalsIgnoreCase("Notification Options")) {
		  //If we click a chest, make sure it's not the same ID chest.
		  if (event.getCurrentItem()!=null) {
			  if ((event.getCurrentItem().getType()==Material.CHEST || event.getCurrentItem().getType()==Material.TRAPPED_CHEST)) {
					int identifier=-1;
				  if (event.getCurrentItem().getItemMeta().getLore()!=null) {
					//Check to see if the Lore contains anything.
					for (int i=0;i<event.getCurrentItem().getItemMeta().getLore().size();i++) {
						if (event.getCurrentItem().getItemMeta().getLore().get(i).contains("ID#")) {
							identifier=Integer.valueOf(event.getCurrentItem().getItemMeta().getLore().get(i).replace("ID#", ""));
						}
					}
					if (identifier!=-1) {
						//Get the ID of this item cube.
						int ider=-2;
					  String ident_string=event.getInventory().getTitle().substring(event.getInventory().getTitle().indexOf("#")).replace("#", "");
					  ider=Integer.valueOf(ident_string);
					  if (identifier==ider) {
							event.setCancelled(true);
							return;
					  }
					}
				  }
			  }
		  }
	  } else
	  if (event.getInventory().getType()==InventoryType.BREWING) {
		  //Bukkit.getPlayer("sigonasr2").sendMessage("Item 1:"+event.getCurrentItem()+", Item 2:"+event.getClick());
		  if (this.plugin.getJobLv("Brewer", p)>=10) {
			  if (event.getCurrentItem()!=null && event.getCurrentItem().getType()==Material.POTION) {
				  if (event.getCurrentItem().getItemMeta()!=null && event.getCurrentItem().getItemMeta().getLore()!=null) {
					  List<String> loredata = event.getCurrentItem().getItemMeta().getLore();
					  boolean found=false;
					  for (int i=0;i<loredata.size();i++) {
						  if (loredata.get(i).contains(ChatColor.RED+"Duplicated")) {
							  found=true;
							  break;
						  }
					  }
					  if (!found) {
						  //We will duplicate it.
						  event.getCurrentItem().setAmount(2);
						  loredata.add(ChatColor.RED+"Duplicated");
						  ItemMeta meta = event.getCurrentItem().getItemMeta();
						  meta.setLore(loredata);
						  event.getCurrentItem().setItemMeta(meta);
					  }
				  } else {
					  if (event.getCurrentItem().getItemMeta()!=null) {
						  //No lore at all. So at this point we just add it ourselves.
						  event.getCurrentItem().setAmount(2);
						  List<String> loredata = new ArrayList<String>();
						  loredata.add(ChatColor.RED+"Duplicated");
						  ItemMeta meta = event.getCurrentItem().getItemMeta();
						  meta.setLore(loredata);
						  event.getCurrentItem().setItemMeta(meta);
					  }
				  }
			  }
		  }
	  } else
	  if (event.getInventory().getName().equalsIgnoreCase("Notification Options")) {
		  if (event.getSlotType()==SlotType.CONTAINER && (event.getSlot()==2 || event.getSlot()==6 ||
				  event.getSlot()==11 || event.getSlot()==15 ||
				  event.getSlot()==20 || event.getSlot()==24)) {
			  if (event.getInventory().getContents()[event.getSlot()].getType()==Material.REDSTONE_TORCH_OFF) {
				  event.getInventory().getContents()[event.getSlot()].setType(Material.REDSTONE_TORCH_ON);
			  } else {
				  event.getInventory().getContents()[event.getSlot()].setType(Material.REDSTONE_TORCH_OFF);
			  }
		  }
		  if (event.getSlotType()==SlotType.CONTAINER && (event.getSlot()==1 || event.getSlot()==5 ||
				  event.getSlot()==10 || event.getSlot()==14 ||
				  event.getSlot()==19 || event.getSlot()==23)) {
			  if (event.getInventory().getContents()[event.getSlot()+1].getType()==Material.REDSTONE_TORCH_OFF) {
				  event.getInventory().getContents()[event.getSlot()+1].setType(Material.REDSTONE_TORCH_ON);
			  } else {
				  event.getInventory().getContents()[event.getSlot()+1].setType(Material.REDSTONE_TORCH_OFF);
			  }
		  }
		  event.setCancelled(true);
	  }
	    if (event.getInventory() != null &&
	        event.getSlotType() == SlotType.RESULT) {
	       
	        switch (event.getInventory().getType()) {
	        case CRAFTING:
	            handleCrafting(event);
	            break;
	        case WORKBENCH:
	            handleCrafting(event);
	            break;
	        }

	}
  }
  
  private void rewardCraft(ItemStack item, int amount, HumanEntity pl) {
	  Player p = (Player)pl;
	  if (this.plugin.PlayerinJob(p,"Digger")) {
		  if (item.getType()==Material.SANDSTONE) {
			  this.plugin.gainMoneyExp(p,"Digger",0.02*amount,6*amount);
		  }
		  if (item.getType()==Material.BRICK) {
			  this.plugin.gainMoneyExp(p,"Digger",0.04*amount,8*amount);
		  }
	  }
	  if (this.plugin.PlayerinJob(p,"Weaponsmith")) {
		  boolean crafteditem=false;
		  if (item.getType()==Material.ARROW) {
			  this.plugin.gainMoneyExp(p,"Weaponsmith",0.025*amount,4*amount);
			  crafteditem=true;
		  }
		  /*
		  if (item.getType()==Material.WOOD_SWORD) {
			  this.plugin.gainMoneyExp(p,"Weaponsmith",0.05*amount,10*amount);
			  crafteditem=true;
		  }*/
		  if (item.getType()==Material.FLINT_AND_STEEL) {
			  this.plugin.gainMoneyExp(p,"Weaponsmith",0.06*amount,12*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.BOW) {
			  this.plugin.gainMoneyExp(p,"Weaponsmith",0.075*amount,12*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.IRON_SWORD) {
			  this.plugin.gainMoneyExp(p,"Weaponsmith",0.375*amount,75*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.GOLD_SWORD) {
			  this.plugin.gainMoneyExp(p,"Weaponsmith",0.50*amount,100*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.DIAMOND_SWORD) {
			  this.plugin.gainMoneyExp(p,"Weaponsmith",3.60*amount,280*amount);
			  crafteditem=true;
		  }
	  }
	  if (this.plugin.PlayerinJob(p,"Blacksmith")) {
		  boolean crafteditem=false;
		  /*
		  if (item.getType()==Material.STONE_HOE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.04*amount,7*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.STONE_SPADE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.05*amount,8*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.STONE_PICKAXE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.075*amount,15*amount);
			  crafteditem=true;
		  }*/
		  if (item.getType()==Material.LEATHER_BOOTS) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.125*amount,8*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.LEATHER_HELMET) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.15*amount,14*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.LEATHER_LEGGINGS) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.175*amount,15*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.LEATHER_CHESTPLATE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.20*amount,18*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.IRON_SPADE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.25*amount,18*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.IRON_HOE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.325*amount,38*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.IRON_AXE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.35*amount,40*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.IRON_BOOTS) {
			  int mult=1;
			  if ((item.getItemMeta().getDisplayName()!=null && !item.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || item.getItemMeta().getDisplayName()==null) {
				  mult=10;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.375*mult*amount,80*mult*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.IRON_PICKAXE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.40*amount,58*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.IRON_HELMET) {
			  int mult=1;
			  if ((item.getItemMeta().getDisplayName()!=null && !item.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || item.getItemMeta().getDisplayName()==null) {
				  mult=10;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.50*mult*amount,100*mult*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.GOLD_SPADE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.625*amount,23*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.GOLD_HOE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.65*amount,65*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.GOLD_AXE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.70*amount,70*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.IRON_LEGGINGS) {
			  int mult=1;
			  if ((item.getItemMeta().getDisplayName()!=null && !item.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || item.getItemMeta().getDisplayName()==null) {
				  mult=10;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.725*mult*amount,140*mult*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.DIAMOND_SPADE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.75*amount,90*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.DIAMOND_HOE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.80*amount,188*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.DIAMOND_AXE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.81*amount,196*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.GOLD_BOOTS) {
			  int mult=1;
			  if ((item.getItemMeta().getDisplayName()!=null && !item.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || item.getItemMeta().getDisplayName()==null) {
				  mult=10;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.825*mult*amount,120*mult*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.IRON_CHESTPLATE) {
			  int mult=1;
			  if ((item.getItemMeta().getDisplayName()!=null && !item.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || item.getItemMeta().getDisplayName()==null) {
				  mult=10;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.875*mult*amount,175*mult*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.GOLD_HELMET) {
			  int mult=1;
			  if ((item.getItemMeta().getDisplayName()!=null && !item.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || item.getItemMeta().getDisplayName()==null) {
				  mult=10;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.925*mult*amount,150*mult*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.DIAMOND_PICKAXE) {
			  this.plugin.gainMoneyExp(p,"Blacksmith",0.925*amount,290*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.DIAMOND_BOOTS) {
			  int mult=1;
			  if ((item.getItemMeta().getDisplayName()!=null && !item.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || item.getItemMeta().getDisplayName()==null) {
				  mult=10;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",1.00*mult*amount,390*mult*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.GOLD_LEGGINGS) {
			  int mult=1;
			  if ((item.getItemMeta().getDisplayName()!=null && !item.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || item.getItemMeta().getDisplayName()==null) {
				  mult=10;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",1.025*mult*amount,170*mult*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.GOLD_CHESTPLATE) {
			  int mult=1;
			  if ((item.getItemMeta().getDisplayName()!=null && !item.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || item.getItemMeta().getDisplayName()==null) {
				  mult=10;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",1.15*mult*amount,192*mult*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.DIAMOND_HELMET) {
			  int mult=1;
			  if ((item.getItemMeta().getDisplayName()!=null && !item.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || item.getItemMeta().getDisplayName()==null) {
				  mult=10;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",1.15*mult*amount,480*mult*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.DIAMOND_LEGGINGS) {
			  int mult=1;
			  if ((item.getItemMeta().getDisplayName()!=null && !item.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || item.getItemMeta().getDisplayName()==null) {
				  mult=10;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",1.325*mult*amount,660*mult*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.DIAMOND_CHESTPLATE) {
			  int mult=1;
			  if ((item.getItemMeta().getDisplayName()!=null && !item.getItemMeta().getDisplayName().contains(ChatColor.DARK_AQUA+"Weak ")) || item.getItemMeta().getDisplayName()==null) {
				  mult=10;
			  }
			  this.plugin.gainMoneyExp(p,"Blacksmith",1.50*mult*amount,750*mult*amount);
			  crafteditem=true;
		  }
	  }
	  if (this.plugin.PlayerinJob(p,"Cook")) {
		  boolean crafteditem=false;
		  if (item.getType()==Material.BREAD) {
			  this.plugin.gainMoneyExp(p,"Cook",0.003125*amount,1.25*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.COOKIE) {
			  this.plugin.gainMoneyExp(p,"Cook",0.016875*amount,1.50*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.MUSHROOM_SOUP) {
			  this.plugin.gainMoneyExp(p,"Cook",0.009375*amount,3.75*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.PUMPKIN_PIE) {
			  this.plugin.gainMoneyExp(p,"Cook",0.0375*amount,15*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.GOLDEN_CARROT) {
			  this.plugin.gainMoneyExp(p,"Cook",0.0875*amount,35*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.CAKE) {
			  this.plugin.gainMoneyExp(p,"Cook",0.10625*amount,21.25*amount);
			  crafteditem=true;
		  }
		  if (item.getType()==Material.GOLDEN_APPLE) {
			  this.plugin.gainMoneyExp(p,"Cook",0.1125*amount,45*amount);
			  crafteditem=true;
		  }
		  if (this.plugin.getJobLv("Cook", p)>=10 && crafteditem==true) {
			  //This is an ugly fix for the problem...But it works somehow.
			  //Player newp = Bukkit.getPlayer(p.getName());
			  p.getInventory().addItem(new ItemStack(item.getType(),amount,item.getDurability(),item.getData().getData()));
		  }
	  }
	  /*
	  if (this.plugin.PlayerinJob(p,"Support")) {
		  if (item.getType()==Material.BREAD) {
			  this.plugin.gainMoneyExp(p,"Support",0.015*amount,2*amount);
		  }
		  if (item.getType()==Material.MUSHROOM_SOUP) {
			  this.plugin.gainMoneyExp(p,"Support",0.015*amount,2*amount);
		  }
		  if (item.getType()==Material.COOKIE) {
			  this.plugin.gainMoneyExp(p,"Support",0.015*amount,2*amount);
		  }
		  if (item.getType()==Material.GOLDEN_CARROT) {
			  this.plugin.gainMoneyExp(p,"Support",0.015*amount,2*amount);
		  }
		  if (item.getType()==Material.GOLDEN_APPLE) {
			  this.plugin.gainMoneyExp(p,"Support",0.015*amount,2*amount);
		  }
		  if (item.getType()==Material.PUMPKIN_PIE) {
			  this.plugin.gainMoneyExp(p,"Support",0.015*amount,2*amount);
		  }
		  if (item.getType()==Material.CAKE) {
			  this.plugin.gainMoneyExp(p,"Support",0.015*amount,2*amount);
		  }
		  if (item.getType()==Material.IRON_SWORD) {
			  this.plugin.gainMoneyExp(p,"Support",0.015*amount,3*amount);
		  }
		  if (item.getType()==Material.IRON_CHESTPLATE || item.getType()==Material.IRON_HELMET || item.getType()==Material.IRON_BOOTS || item.getType()==Material.IRON_LEGGINGS) {
			  this.plugin.gainMoneyExp(p,"Support",0.025*amount,5*amount);
		  }
		  if (item.getType()==Material.DIAMOND_SWORD) {
			  this.plugin.gainMoneyExp(p,"Support",0.075*amount,8*amount);
		  }
		  if (item.getType()==Material.DIAMOND_CHESTPLATE || item.getType()==Material.DIAMOND_HELMET || item.getType()==Material.DIAMOND_BOOTS || item.getType()==Material.DIAMOND_LEGGINGS) {
			  this.plugin.gainMoneyExp(p,"Support",0.20*amount,20*amount);
		  }
		  if (item.getType()==Material.CAKE) {
			  this.plugin.gainMoneyExp(p,"Support",0.03*amount,2*amount);
		  }
	  }*/
  }
	 
	private void handleCrafting(InventoryClickEvent event) {
	   
	    HumanEntity player = event.getWhoClicked();
	    ItemStack toCraft = event.getCurrentItem();
	    ItemStack toStore = event.getCursor();
	 
	    // Make sure we are actually crafting anything
	    if (player != null && hasItems(toCraft)) {
	 
	        if (event.isShiftClick()) {
	            // Hack ahoy
	            schedulePostDetection(player, toCraft);
	        } else {
	            // The items are stored in the cursor. Make sure there's enough space.
	            if (isStackSumLegal(toCraft, toStore)) {
	                int newItemsCount = toCraft.getAmount();

	            	rewardCraft(toCraft,newItemsCount,player);
	            }
	        }
	    }
	}
	
	public String[] getJobs(Player p) {
		return this.plugin.getJobs(p);
	}
	
	public String[] getJobs(String p) {
		return this.plugin.getJobs(p);
	}
	
	public boolean PlayerinJob(String p,String job) {
		return this.plugin.PlayerinJob(p, job);
	}
	
	public boolean PlayerinJob(Player p,String job) {
		return this.plugin.PlayerinJob(p, job);
	}
	

	public int getJobLv(String job, String p) {
		return this.plugin.getJobLv(job, p);
	}
	
	public boolean validItem_Weaponsmith(ItemStack i) {
		if (i.getType()==Material.ARROW ||
			//i.getType()==Material.WOODEN_SWORD ||
			i.getType()==Material.FLINT_AND_STEEL ||
			i.getType()==Material.BOW ||
			i.getType()==Material.IRON_SWORD ||
			i.getType()==Material.GOLD_SWORD ||
			i.getType()==Material.DIAMOND_SWORD) {
			return true;
		}
		 else {
			return false;
		 }
	}
	
	public boolean validItem_Blacksmith(ItemStack i) {
		if (i.getType()==Material.LEATHER_BOOTS ||
			//i.getType()==Material.WOODEN_SWORD ||
			i.getType()==Material.LEATHER_HELMET ||
			i.getType()==Material.LEATHER_LEGGINGS ||
			i.getType()==Material.LEATHER_CHESTPLATE ||
			i.getType()==Material.IRON_SPADE ||
			i.getType()==Material.IRON_HOE ||
			i.getType()==Material.IRON_BOOTS ||
			i.getType()==Material.IRON_PICKAXE ||
			i.getType()==Material.IRON_LEGGINGS ||
			i.getType()==Material.IRON_CHESTPLATE ||
			i.getType()==Material.IRON_HELMET ||
			i.getType()==Material.GOLD_SPADE ||
			i.getType()==Material.GOLD_HOE ||
			i.getType()==Material.GOLD_BOOTS ||
			i.getType()==Material.GOLD_CHESTPLATE ||
			i.getType()==Material.GOLD_LEGGINGS ||
			i.getType()==Material.GOLD_HELMET ||
			i.getType()==Material.DIAMOND_PICKAXE ||
			i.getType()==Material.DIAMOND_HOE ||
			i.getType()==Material.DIAMOND_SPADE ||
			i.getType()==Material.DIAMOND_HELMET ||
			i.getType()==Material.DIAMOND_CHESTPLATE ||
			i.getType()==Material.DIAMOND_LEGGINGS ||
			i.getType()==Material.DIAMOND_BOOTS) {
			return true;
		}
		 else {
			return false;
		 }
	}
	
	
	public ItemStack EnchantItem(ItemStack item,int lv, Player p) {
		return this.plugin.EnchantItem(item, lv, p);
	}
	 
	// HACK! The API doesn't allow us to easily determine the resulting number of
	// crafted items, so we're forced to compare the inventory before and after.
	private void schedulePostDetection(final HumanEntity player, final ItemStack compareItem) {
	    final ItemStack[] preInv = player.getInventory().getContents();
	    final int ticks = 1;
	    
	   
	    // Clone the array. The content may (was for me) be mutable.
	    for (int i = 0; i < preInv.length; i++) {
	        preInv[i] = preInv[i] != null ? preInv[i].clone() : null;
	    }
	    Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
	        @Override
	        public void run() {
	            final ItemStack[] postInv = player.getInventory().getContents();
	            int newItemsCount = 0;
	           
	            for (int i = 0; i < preInv.length; i++) {
	            	ItemStack pre = preInv[i];
	            	ItemStack post = postInv[i];
	            	if (pre!=null && post!=null) {
	            		//See if they are the same item.
	            		if (pre.getTypeId()==post.getTypeId() && pre.getDurability()==post.getDurability() &&
	            				pre.getItemMeta().equals(post.getItemMeta()) && pre.getEnchantments().equals(post.getEnchantments()) &&
	            				compareItem.getTypeId()==post.getTypeId() && compareItem.getDurability()==post.getDurability() &&
	            				compareItem.getItemMeta().equals(post.getItemMeta()) && compareItem.getEnchantments().equals(post.getEnchantments())) {
	            			//See if the quantities differ.
	            			newItemsCount += post.getAmount()-pre.getAmount();
	            			//Bukkit.getPlayer("sigonasr2").sendMessage("Item amounts differ. New count: "+newItemsCount);
	            		}
	            	} else {
	            		if (post!=null) {
	            			//pre is null, so we just add the amount.
            				if (compareItem.getTypeId()==post.getTypeId() && compareItem.getDurability()==post.getDurability() &&
            				compareItem.getItemMeta().equals(post.getItemMeta()) && compareItem.getEnchantments().equals(post.getEnchantments())) {
            					newItemsCount += post.getAmount();
            					//Do any enchants we need to do here.
            					if (PlayerinJob((Player)player,"Weaponsmith")) {
            					  if (getJobLv("Weaponsmith", player.getName())>=10 && validItem_Weaponsmith(post)) {
            						  //Bukkit.getPlayer("sigonasr2").sendMessage("Valid item. Going to attempt to enchant.");
            						  ItemStack clone = post.clone();
            						  ItemStack resulting = EnchantItem(clone,5,(Player)player);
            						  player.getInventory().setItem(i, resulting);
            					  }
            					}	
            					if (PlayerinJob((Player)player,"Blacksmith")) {
              					  if (getJobLv("Blacksmith", player.getName())>=10 && validItem_Blacksmith(post)) {
              						  //Bukkit.getPlayer("sigonasr2").sendMessage("Valid item. Going to attempt to enchant.");
            						  ItemStack clone = post.clone();
            						  ItemStack resulting = EnchantItem(clone,10,(Player)player);
              						  player.getInventory().setItem(i, resulting);
              					  } else
              					  if (getJobLv("Blacksmith", player.getName())>=5 && validItem_Blacksmith(post)) {
              						  //Bukkit.getPlayer("sigonasr2").sendMessage("Valid item. Going to attempt to enchant.");
            						  ItemStack clone = post.clone();
            						  ItemStack resulting = EnchantItem(clone,5,(Player)player);
              						  player.getInventory().setItem(i, resulting);
              					  }
              					}
            				}
	            			//Bukkit.getPlayer("sigonasr2").sendMessage("Item amounts differ. New count: "+newItemsCount);
	            		}
	            	}
                }
	           
	            if (newItemsCount > 0) {
	                //Bukkit.getPlayer("AaMay").sendMessage(newItemsCount+" New Items have been detected.");
	            	if (plugin.getAccountsConfig().getBoolean(player.getName()+".settings.notify2")) {
	            		Bukkit.getPlayer(player.getName()).sendMessage(ChatColor.DARK_AQUA+""+ChatColor.ITALIC+"Crafted "+newItemsCount+" "+convertToItemName(compareItem.getType().name())+".");
	            	}
	            	rewardCraft(compareItem,newItemsCount,player);
	            }
	        }
	    }, ticks);
	}
	 
	private boolean hasSameItem(ItemStack a, ItemStack b) {
	    if (a == null)
	        return b == null;
	    else if (b == null)
	        return a == null;
	    return a.getTypeId() == b.getTypeId() &&
	    		a.getDurability() == b.getDurability() &&
	           ((a.getItemMeta()!=null && b.getItemMeta()!=null)?Objects.equal(a.getItemMeta(), b.getItemMeta()):true) &&
	           ((a.getEnchantments()!=null && b.getEnchantments()!=null)?Objects.equal(a.getEnchantments(), b.getEnchantments()):true);
	}
	
	private boolean hasItems(ItemStack stack) {
        return stack != null && stack.getAmount() > 0;
    }
	 
	private boolean isStackSumLegal(ItemStack a, ItemStack b) {
	    // See if we can create a new item stack with the combined elements of a and b
	    if (a == null || b == null)
	        return true; // Treat null as an empty stack
	    else
	        return a.getAmount() + b.getAmount() <= a.getType().getMaxStackSize();
	}

  @EventHandler
  public void onItemSpawn(ItemSpawnEvent e) {
	  if (e.getEntity().getType()==EntityType.DROPPED_ITEM) {
		  if (e.getEntity().getItemStack().getType()==Material.IRON_ORE) {
			  e.getEntity().getItemStack().setType(Material.IRON_INGOT);
		  } else if (e.getEntity().getItemStack().getType()==Material.GOLD_ORE) {
			  e.getEntity().getItemStack().setType(Material.GOLD_INGOT);
		  }
		  return;
	  }
  }
  
  @EventHandler
  public void onItemDespawn(ItemDespawnEvent e) {
	  Item i = e.getEntity();
	  Player p = Bukkit.getPlayer("sigonasr2");
	  boolean allow=true;
	  if (this.plugin.getConfig().getBoolean("halloween-enabled") && (
			  i.getItemStack().getType()==Material.PUMPKIN_PIE ||
			  i.getItemStack().getType()==Material.SUGAR ||
			  i.getItemStack().getType()==Material.PUMPKIN ||
			  i.getItemStack().getType()==Material.EGG
			  )) {
		  allow=false;
	  }
	  //p.sendMessage("Item "+i.getItemStack().getItemMeta().getDisplayName()+" despawned.");// <-- CHECK THIS FOR NULL TO DETERMINE IF IT'S A REAL ITEM.
	  //String metastring = "Has name: "+i.getItemStack().getItemMeta().hasDisplayName();
	  //p.sendMessage(metastring);
	  if (allow) {
		  Location l1 = new Location(Bukkit.getWorld("world"), 1617, 67, -351);
		  Location l2 = new Location(Bukkit.getWorld("world"), 1618, 67, -351);
		  Location k1 = new Location(Bukkit.getWorld("world"), 1617, 67, -355);
		  Location k2 = new Location(Bukkit.getWorld("world"), 1618, 67, -355);
		  Location j1 = new Location(Bukkit.getWorld("world"), 1622, 67, -355);
		  Location j2 = new Location(Bukkit.getWorld("world"), 1623, 67, -355);
		  Location i1 = new Location(Bukkit.getWorld("world"), 1622, 67, -351);
		  Location i2 = new Location(Bukkit.getWorld("world"), 1623, 67, -351);
		  Chest c=(Chest)Bukkit.getWorld("world").getBlockAt(l1).getState();
		  int selection=0;
		  //Choose a chest randomly.
		  switch ((int)(Math.random()*8)) {
			  case 0:{
				  c=(Chest)Bukkit.getWorld("world").getBlockAt(l1).getState();
				  selection=1;
			  }break;
			  case 1:{
				  c=(Chest)Bukkit.getWorld("world").getBlockAt(l2).getState();
				  selection=2;
			  }break;
			  case 2:{
				  c=(Chest)Bukkit.getWorld("world").getBlockAt(k1).getState();
				  selection=3;
			  }break;
			  case 3:{
				  c=(Chest)Bukkit.getWorld("world").getBlockAt(k2).getState();
				  selection=4;
			  }break;
			  case 4:{
				  c=(Chest)Bukkit.getWorld("world").getBlockAt(j1).getState();
				  selection=5;
			  }break;
			  case 5:{
				  c=(Chest)Bukkit.getWorld("world").getBlockAt(j2).getState();
				  selection=6;
			  }break;
			  case 6:{
				  c=(Chest)Bukkit.getWorld("world").getBlockAt(i1).getState();
				  selection=7;
			  }break;
			  case 7:{
				  c=(Chest)Bukkit.getWorld("world").getBlockAt(i2).getState();
				  selection=8;
			  }break;
		  }
		  //Get data about this slot.
		  int itemslot=this.plugin.getConfig().getInt("chest"+selection+"item");
		  double chance=this.plugin.getConfig().getDouble("chest"+selection+"i");
		  //First determine if we can even allow this item in.
		  if (i.getItemStack().getItemMeta().hasDisplayName()==false) {
			  //p.sendMessage("Item is being checked.");
			  //Now see if the chance should be reduced, based on its material name.
			  for (int y=0;y<27;y++) {
				  if (c.getBlockInventory().getItem(y)!=null && c.getBlockInventory().getItem(y).getType()==i.getItemStack().getType()) {
					  chance*=2.0d;
					  //p.sendMessage("Block inventory chance went up. "+c.getBlockInventory().getItem(y).getType()+"="+i.getItemStack().getType());
				  }
			  }
			  //p.sendMessage("Past for loop.");
			  //Now check for chance to deposit it.
			  if (Math.random()*chance<1.0d) {
				  //Deposit item. Set chance higher.
				  //p.sendMessage("Going inside...");
				  if (c.getBlockInventory().getItem(itemslot)!=null) {
					  c.getBlockInventory().remove(itemslot);
				  }
				  //p.sendMessage("Removed...");
				  c.getBlockInventory().setItem(itemslot,i.getItemStack());
				  //Clone the item.
				  //ItemStack tempitem = i.getItemStack(); 
				  //tempitem.setType(Material.STONE_SPADE);
				  //ItemMeta tempmeta = tempitem.getItemMeta();
				  //tempmeta.setDisplayName("Spleef Stone Shovel");
				  //tempitem.setItemMeta(tempmeta);
				  //tempitem.setDurability((short)0);
				  //p.sendMessage("This item has "+tempitem.getDurability()+" uses.");
				  //p.getInventory().setItemInHand(tempitem);
				  //p.sendMessage("Added...");
				  this.plugin.getConfig().set("chest"+selection+"item", Integer.valueOf((itemslot+1)%27));
				  this.plugin.getConfig().set("chest"+selection+"i", Double.valueOf(this.plugin.getConfig().getDouble("chest"+selection+"i")+this.plugin.getConfig().getDouble("chestchanceincrease")));
				  if (this.plugin.getConfig().getDouble("randomitemchance")>8.0d) {
					  this.plugin.getConfig().set("randomitemchance", Double.valueOf(this.plugin.getConfig().getDouble("randomitemchance")-1.0d));
				  }
				  //////////////p.sendMessage(ChatColor.GRAY+"A new item has been deposited.");
			  } else {
				  //p.sendMessage("Failed. Trying this method.");
				  if (Math.random()*this.plugin.getConfig().getDouble("randomitemchance")<1.0d) {
					  //p.sendMessage("Made it in.");
					  int[] items = {1,3,4,5,6,1,13,14,15,17,18,20,22,23,24,25,27,28,39,31,32,33,35,37,38,39,40,41,42,44,45,46,47,48,49,50,53,54,57,58,61,65,66,67,69,70,72,76,77,78,80,81,82,84,85,86,87,88,89,91,96,98,101,102,103,106,107,108,109,111,112,113,114,116,121,122,123,126,128,130,131,133,134,135,136,138,139,143,145,146,147,148,151,152,154,155,156,157,158,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355,356,357,358,359,360,361,362,363,364,365,366,367,368,369,370,371,372,373,374,375,376,377,378,379,380,381,382,385,386,387,388,389,390,391,392,393,394,395,396,397,398,399,400,401,402,403,404,405,406,407,408,2256,2257,2258,2259,2260,2261,2262,2263,2264,2265,2266,2267};
					  int[] rareitems = {41,46,57,116,122,133,130,146,151,264,266,276,277,278,279,293,310,311,312,313,368,381,406};
					  int item = items[(int)(Math.random()*items.length)];
					  ItemStack newitem = i.getItemStack();
					  newitem.setTypeId(item);
					  boolean contains=false;
					  for (int k=0;k<rareitems.length;k++) {
						  if (item==rareitems[k]) {
							  contains=true;
							  break;
						  }
					  }
					  if (contains) {
						  newitem.setAmount(1);
						  this.plugin.getConfig().set("randomitemchance", Double.valueOf(this.plugin.getConfig().getDouble("randomitemchance")+400.0d));
					  }
					  if (c.getBlockInventory().getItem(itemslot)!=null) {
						  c.getBlockInventory().remove(itemslot);
					  }
					  c.getBlockInventory().setItem(itemslot,newitem);
					  ///////////////////////p.sendMessage(ChatColor.BLUE+"A new (random) item has been deposited.");
					  this.plugin.getConfig().set("randomitemchance", Double.valueOf(this.plugin.getConfig().getDouble("randomitemchance")+100.0d));
				  } else {
					  if (this.plugin.getConfig().getDouble("randomitemchance")>8.0d) {
						  this.plugin.getConfig().set("randomitemchance", Double.valueOf(this.plugin.getConfig().getDouble("randomitemchance")-1.0d));
					  }
				  }
				  if (this.plugin.getConfig().getDouble("chest"+selection+"i")>=this.plugin.getConfig().getDouble("chestdecrease")) {
					this.plugin.getConfig().set("chest"+selection+"i", Double.valueOf(this.plugin.getConfig().getDouble("chest"+selection+"i")-this.plugin.getConfig().getDouble("chestdecrease")));
				  }
				  this.plugin.getConfig().set("chest"+selection+"item", Integer.valueOf((itemslot+1)%27));
			  }
			  this.plugin.saveConfig();
		  }
	  }
	  return;
	}
	  //c.getBlockInventory().getSize();
	  /*
	  if (Bukkit.getWorld("world").getBlockAt(l).getType()==Material.CHEST) {
		  p.sendMessage("Added item "+i.getItemStack().getTypeId()+" to chest.");
		  Chest c = (Chest)Bukkit.getWorld("world").getBlockAt(l1).getState();
		  c.getBlockInventory().
		  c.getBlockInventory().addItem(i.getItemStack());
	  }*/
	  /*// WORKING ITEM CODE.
	  Location l = new Location(Bukkit.getWorld("world"), 1617, 67, -351);
	  if (Bukkit.getWorld("world").getBlockAt(l).getType()==Material.CHEST) {
		  p.sendMessage("Added item to chest.");
		  Chest c = (Chest)Bukkit.getWorld("world").getBlockAt(l).getState();
		  c.getBlockInventory().addItem(i.getItemStack());
	  }
	  */

  /*
  @EventHandler
  public void onDamage(EntityDamageEvent e) {
	  if (e.getEntity().getType() == EntityType.PLAYER) {
		  Player p = (Player) e.getEntity();
		  TagAPI.refreshPlayer(p);
	  } else {
		  return;
	  }
	  //Player p = e.getPlayer();
	  //Player p = Bukkit.getPlayer("sigonasr2");
	  //p.setDisplayName(ChatColor.RED+"TEST");
	  //p.setPlayerListName(ChatColor.RED+"TEST");
  }

  @EventHandler
  public void onHeal(EntityRegainHealthEvent e) {
	  if (e.getEntity().getType() == EntityType.PLAYER) {
		  Player p = (Player) e.getEntity();
		  TagAPI.refreshPlayer(p);
	  } else {
		  return;
	  }
	  //Player p = e.getPlayer();
	  //Player p = Bukkit.getPlayer("sigonasr2");
	  //p.setDisplayName(ChatColor.RED+"TEST");
	  //p.setPlayerListName(ChatColor.RED+"TEST");
  }
  */
  @EventHandler
 public void onRedstoneChange(BlockRedstoneEvent e) {
	  if (e.getBlock().getType()==Material.REDSTONE_LAMP_ON || e.getBlock().getType()==Material.REDSTONE_LAMP_OFF) {
		  if (e.getBlock().getX()>=1562 && e.getBlock().getX()<=1644 && e.getBlock().getY()>=64 && e.getBlock().getY()<=79 && e.getBlock().getZ()>=-357 && e.getBlock().getZ()<=-211) {
			  e.setNewCurrent(15);
		  }
	  }
  }

  @EventHandler
public void onMinecartExit(VehicleExitEvent e) {
	  if (e.getVehicle().getType()==EntityType.MINECART) {
		  Bukkit.getWorld("world").dropItemNaturally(e.getVehicle().getLocation(),new ItemStack(Material.MINECART));
		  e.getVehicle().remove();
	  }
  }
  
  @EventHandler
public void onMinecartEnter(VehicleEnterEvent e) {
	  /*if (e.getEntered().getType()==EntityType.PLAYER) {
		  if (e.getVehicle().getType()==EntityType.MINECART) {
			  Minecart m = (Minecart)e.getVehicle();
			  if (e.getEntered().getLocation().getBlockZ()==-328 || e.getEntered().getLocation().getBlockZ()==-316) {
				  m.setMaxSpeed(8.0);
			  } else {
				  m.setMaxSpeed(4.0);
			  }
		  }
	  }*/
  }
  /*
  @EventHandler
  public void onEntityEvent(EntityEvent e) {
	  return;
	  if (e.getEntity().getType()==EntityType.ZOMBIE) {
		  LivingEntity f = (LivingEntity)e.getEntity();
		  if (f.getCustomName()!=null && (f.getCustomName().compareTo("&eCharge Zombie")==0 || f.getCustomName().compareTo("&6Charge Zombie II")==0)) {
			  //Destroy blocks around it.
			  
			  boolean doit=true;
			  if (f.getKiller()!=null && f.getKiller().getLocation().getY()>f.getLocation().getY()) {
				  doit=false;
			  }
			  if (doit) {
				  Bukkit.getPlayer("sigonasr2").sendMessage("Charge Zombie!");
				  for (int i=-1;i<2;i++) {
					  for (int j=-1;j<2;j++) {
						  Location checkloc = f.getLocation().add(i,f.getLocation().getY()+1,j);
						  Bukkit.getWorld("world").getBlockAt(checkloc).breakNaturally();
						  checkloc = f.getLocation().add(i,f.getLocation().getY()+2,j);
						  Bukkit.getWorld("world").getBlockAt(checkloc).breakNaturally();
					  }
				  }
			  }
		  } else {
			  if (f.getCustomName()!=null) {
				  Bukkit.getPlayer("sigonasr2").sendMessage(f.getCustomName());
			  }
		  }
	  }
  }*/
  
@EventHandler
public void onShootArrow(ProjectileHitEvent e) {
	LivingEntity l = e.getEntity().getShooter();
	if (l!=null && l.getType()==EntityType.SKELETON && l.getCustomName()!=null) {
		if ((l.getCustomName().compareTo(ChatColor.YELLOW+"Sniper")==0)) {
			boolean found=false;
			if (!found) {
				//Create a new shooter from this skeleton only if they are not shooting already.
				this.plugin.ARROW_SHOOTERS.add(new ArrowShooter(e.getEntity().getVelocity(), e.getEntity().getLocation(),50,10,l));
			}
		} else 
		if (l.getCustomName().compareTo(ChatColor.GOLD+"Sniper II")==0) {
			boolean found=false;
			if (!found) {
				//Create a new shooter from this skeleton only if they are not shooting already.
				for (int i=-2;i<3;i+=2) {
					this.plugin.ARROW_SHOOTERS.add(new ArrowShooter(e.getEntity().getVelocity(), e.getEntity().getLocation().add(0,i,0),50,5,l));
					this.plugin.ARROW_SHOOTERS.add(new ArrowShooter(e.getEntity().getVelocity(), e.getEntity().getLocation().add(0,i,0),50,5,l));
				}
			}
		}
	}
}

@EventHandler
public void onEntityExpode(ExplosionPrimeEvent e) {
	//Bukkit.getPlayer("AaMay").sendMessage("Entity Type: "+e.getEntity().getType().getName());
	if (e.getEntity().getType()==EntityType.CREEPER) {
		LivingEntity c = (LivingEntity)e.getEntity();
		//Bukkit.getPlayer("AaMay").sendMessage("A Creeper exploded.");
		if (c.getCustomName()!=null) {
			//Bukkit.getPlayer("AaMay").sendMessage("Detected a name.");
			if (c.getCustomName().compareTo(ChatColor.YELLOW+"Explosive Creeper")==0) {
				Bukkit.getWorld("world").createExplosion(c.getLocation().getX(),c.getLocation().getY(),c.getLocation().getZ(),3f,false,true);
				//Bukkit.getPlayer("AaMay").sendMessage("Sent explosion");
				e.setCancelled(true);
			} else 
			if (c.getCustomName().compareTo(ChatColor.GOLD+"Explosive Creeper II")==0) {
				Bukkit.getWorld("world").createExplosion(c.getLocation().getX(),c.getLocation().getY(),c.getLocation().getZ(),4f,false,true);
				//Bukkit.getPlayer("AaMay").sendMessage("Sent explosion");
				e.setCancelled(true);
			} else 
			if (c.getCustomName().compareTo(ChatColor.YELLOW+"Destructive Creeper")==0) {
				Bukkit.getWorld("world").createExplosion(c.getLocation().getX(),c.getLocation().getY(),c.getLocation().getZ(),2f,true,true);
				//Bukkit.getPlayer("AaMay").sendMessage("Sent explosion");
				e.setCancelled(true);
			} else 
			if (c.getCustomName().compareTo(ChatColor.GOLD+"Destructive Creeper II")==0) {
				Bukkit.getWorld("world").createExplosion(c.getLocation().getX(),c.getLocation().getY(),c.getLocation().getZ(),3f,true,true);
				//Bukkit.getPlayer("AaMay").sendMessage("Sent explosion");
				e.setCancelled(true);
			}
		}
	}
	//Bukkit.broadcastMessage("Explosion occurs.");
}
  
/*
  @SuppressWarnings("deprecation")
@EventHandler
  public void onPlayerMove(PlayerMoveEvent e) {
	  Player p = e.getPlayer();
	  if (this.plugin.getConfig().getBoolean("spleef4insession")) {
		  //Check to see if we fall off.
		  if ((p.getLocation().getX()<1585 || p.getLocation().getX()>1600 || p.getLocation().getZ()<24 || p.getLocation().getZ()>39 || p.getLocation().getY()<86.5d) && (
				  (p.getName().compareTo(this.plugin.getConfig().getString("spleefrequesta4player"))==0 || p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestb4player"))==0
				  || p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestc4player"))==0 || p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestd4player"))==0))) {
			  //You lose.
			  //See if we're the winner.
			  int countdead=0; //We're looking for 3.
			  
			  
			  Player winningplayer = p,losingplayer = p;
			  if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo("none")==0) {
				  countdead++;
			  } else {
				  if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName())==0) {
					  losingplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequesta4player"));
				  } else {
					  winningplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequesta4player"));
				  }
			  }
			  if (this.plugin.getConfig().getString("spleefrequestb4player").compareTo("none")==0) {
				  countdead++;
			  } else {
				  if (this.plugin.getConfig().getString("spleefrequestb4player").compareTo(p.getName())==0) {
					  losingplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestb4player"));
				  } else {
					  winningplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestb4player"));
				  }
			  }
			  if (this.plugin.getConfig().getString("spleefrequestc4player").compareTo("none")==0) {
				  countdead++;
			  } else {
				  if (this.plugin.getConfig().getString("spleefrequestc4player").compareTo(p.getName())==0) {
					  losingplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestc4player"));
				  } else {
					  winningplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestc4player"));
				  }
			  }
			  if (this.plugin.getConfig().getString("spleefrequestd4player").compareTo("none")==0) {
				  countdead++;
			  } else {
				  if (this.plugin.getConfig().getString("spleefrequestd4player").compareTo(p.getName())==0) {
					  losingplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestd4player"));
				  } else {
					  winningplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestd4player"));
				  }
			  }
			  if (countdead==2) {
	        		this.plugin.getConfig().set("spleef4insession", Boolean.valueOf(false));
	        		
	        		
	        		
	        		

	        		//Stand someplace else when you win.
	        		
	        		
	        		//Losing player has losing player stuff happen.
	        		//This was a player that lost.
					  //Move them out, give them back their stuff.
					  Location newloc = p.getLocation();
					  //Look for the special shovel for the sake of storing it.
					  p.getInventory().clear();
					  p.getInventory().clear(p.getInventory().getHeldItemSlot());
					  //Give inventories back.
					  if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName())==0) {
						  for (int i=0;i<this.plugin.spleef4_inventory_a.length;i++) {
							  if (this.plugin.spleef4_inventory_a[i]!=null) {
							  p.getInventory().addItem(this.plugin.spleef4_inventory_a[i]);
							  }
						  }
						  this.plugin.getConfig().set("spleefrequesta4player",String.valueOf("none"));
					  } else
					  if (this.plugin.getConfig().getString("spleefrequestb4player").compareTo(p.getName())==0) {
						  for (int i=0;i<this.plugin.spleef4_inventory_b.length;i++) {
							  if (this.plugin.spleef4_inventory_b[i]!=null) {
							  p.getInventory().addItem(this.plugin.spleef4_inventory_b[i]);
							  }
						  }
						  this.plugin.getConfig().set("spleefrequestb4player",String.valueOf("none"));
					  } else
					  if (this.plugin.getConfig().getString("spleefrequestc4player").compareTo(p.getName())==0) {
						  for (int i=0;i<this.plugin.spleef4_inventory_c.length;i++) {
							  if (this.plugin.spleef4_inventory_c[i]!=null) {
							  p.getInventory().addItem(this.plugin.spleef4_inventory_c[i]);
							  }
						  }
						  this.plugin.getConfig().set("spleefrequestc4player",String.valueOf("none"));
					  } else
					  if (this.plugin.getConfig().getString("spleefrequestd4player").compareTo(p.getName())==0) {
						  for (int i=0;i<this.plugin.spleef4_inventory_d.length;i++) {
							  if (this.plugin.spleef4_inventory_d[i]!=null) {
							  p.getInventory().addItem(this.plugin.spleef4_inventory_d[i]);
							  }
						  }
						  this.plugin.getConfig().set("spleefrequestd4player",String.valueOf("none"));
					  }
					  Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+p.getName()+" fell out of the arena and is out of the match!");
					  

					  newloc = winningplayer.getLocation();
					  newloc.setX(1583);
					  newloc.setY(91);
					  newloc.setZ(31.5);
					  winningplayer.teleport(newloc);
					  //Look for the special shovel for the sake of storing it.
					  winningplayer.getInventory().clear();
					  winningplayer.getInventory().clear(winningplayer.getInventory().getHeldItemSlot());
					  //Give inventories back.
					  if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(winningplayer.getName())==0) {
						  for (int i=0;i<this.plugin.spleef4_inventory_a.length;i++) {
							  if (this.plugin.spleef4_inventory_a[i]!=null) {
								  winningplayer.getInventory().addItem(this.plugin.spleef4_inventory_a[i]);
							  }
						  }
						  this.plugin.getConfig().set("spleefrequesta4player",String.valueOf("none"));
					  } else
					  if (this.plugin.getConfig().getString("spleefrequestb4player").compareTo(winningplayer.getName())==0) {
						  for (int i=0;i<this.plugin.spleef4_inventory_b.length;i++) {
							  if (this.plugin.spleef4_inventory_b[i]!=null) {
								  winningplayer.getInventory().addItem(this.plugin.spleef4_inventory_b[i]);
							  }
						  }
						  this.plugin.getConfig().set("spleefrequestb4player",String.valueOf("none"));
					  } else
					  if (this.plugin.getConfig().getString("spleefrequestc4player").compareTo(winningplayer.getName())==0) {
						  for (int i=0;i<this.plugin.spleef4_inventory_c.length;i++) {
							  if (this.plugin.spleef4_inventory_c[i]!=null) {
								  winningplayer.getInventory().addItem(this.plugin.spleef4_inventory_c[i]);
							  }
						  }
						  this.plugin.getConfig().set("spleefrequestc4player",String.valueOf("none"));
					  } else
					  if (this.plugin.getConfig().getString("spleefrequestd4player").compareTo(winningplayer.getName())==0) {
						  for (int i=0;i<this.plugin.spleef4_inventory_d.length;i++) {
							  if (this.plugin.spleef4_inventory_d[i]!=null) {
								  winningplayer.getInventory().addItem(this.plugin.spleef4_inventory_d[i]);
							  }
						  }
						  this.plugin.getConfig().set("spleefrequestd4player",String.valueOf("none"));
					  }
					  Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+winningplayer.getName()+"["+(int)this.plugin.getAccountsConfig().getDouble(winningplayer.getName()+".spleefrating")/10+"] is the winner of this 4-player spleef game!");
					  this.plugin.getConfig().set("spleeflastrequesttime",Double.valueOf(0.0d));
	        		this.plugin.getConfig().set("spleefrequesta4player", String.valueOf("none"));
	        		this.plugin.getConfig().set("spleefrequestb4player", String.valueOf("none"));
	        		this.plugin.getConfig().set("spleefrequestc4player", String.valueOf("none"));
	        		this.plugin.getConfig().set("spleefrequestd4player", String.valueOf("none"));
			  } else
			  {
				  //This was a player that lost.
				  //Move them out, give them back their stuff.
				  Location newloc = p.getLocation();
				  newloc.setX(1583);
				  newloc.setY(91);
				  newloc.setZ(31.5);
				  p.teleport(newloc);
				  p.getInventory().clear();
				  p.getInventory().clear(p.getInventory().getHeldItemSlot());
				  //Give inventories back.
				  if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName())==0) {
					  for (int i=0;i<this.plugin.spleef4_inventory_a.length;i++) {
						  if (this.plugin.spleef4_inventory_a[i]!=null) {
						  p.getInventory().addItem(this.plugin.spleef4_inventory_a[i]);
						  }
					  }
					  this.plugin.getConfig().set("spleefrequesta4player",String.valueOf("none"));
				  } else
				  if (this.plugin.getConfig().getString("spleefrequestb4player").compareTo(p.getName())==0) {
					  for (int i=0;i<this.plugin.spleef4_inventory_b.length;i++) {
						  if (this.plugin.spleef4_inventory_b[i]!=null) {
						  p.getInventory().addItem(this.plugin.spleef4_inventory_b[i]);
						  }
					  }
					  this.plugin.getConfig().set("spleefrequestb4player",String.valueOf("none"));
				  } else
				  if (this.plugin.getConfig().getString("spleefrequestc4player").compareTo(p.getName())==0) {
					  for (int i=0;i<this.plugin.spleef4_inventory_c.length;i++) {
						  if (this.plugin.spleef4_inventory_c[i]!=null) {
						  p.getInventory().addItem(this.plugin.spleef4_inventory_c[i]);
						  }
					  }
					  this.plugin.getConfig().set("spleefrequestc4player",String.valueOf("none"));
				  } else
				  if (this.plugin.getConfig().getString("spleefrequestd4player").compareTo(p.getName())==0) {
					  for (int i=0;i<this.plugin.spleef4_inventory_d.length;i++) {
						  if (this.plugin.spleef4_inventory_d[i]!=null) {
						  p.getInventory().addItem(this.plugin.spleef4_inventory_d[i]);
						  }
					  }
					  this.plugin.getConfig().set("spleefrequestd4player",String.valueOf("none"));
				  }
				  Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+p.getName()+" fell out of the arena and is out of the match!");
				  
			  }
		  }
		  //Check to see if we are a player in spleef.
		  if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName())==0 ||
				  this.plugin.getConfig().getString("spleefrequestb4player").compareTo(p.getName())==0 ||
				  this.plugin.getConfig().getString("spleefrequestc4player").compareTo(p.getName())==0 ||
				  this.plugin.getConfig().getString("spleefrequestd4player").compareTo(p.getName())==0) {
			  //If they are holding something, remove it.
			  if (p.getItemInHand()!=null) {
				  p.getInventory().remove(p.getInventory().getHeldItemSlot());
			  }
		  }
	  }
	  
	  if (this.plugin.getConfig().getBoolean("spleefinsession") && (p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestaplayer"))==0 || p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestbplayer"))==0)) {
		  //Determine if we're still playing.
		  int blockwinner=0;
		  if (this.plugin.getConfig().getString("spleefrequestaplayer").compareTo(p.getName())==0 ||
				  this.plugin.getConfig().getString("spleefrequestbplayer").compareTo(p.getName())==0) {
			  //If they are holding something, remove it.
			  if (p.getItemInHand()!=null) {
				  p.getInventory().remove(p.getInventory().getHeldItemSlot());
			  }
		  }
		  if (p.getPlayerTime()-this.plugin.spleef_last_broken_block>=400) {
			  //WE have come to a standstill. Pick winner based on who has more blocks.
			  int player_a_blocks=0,player_b_blocks=0;
			  for (int i=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getLocation().getBlockX()-4;i<Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getLocation().getBlockX()+4;i++) {
				  for (int j=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getLocation().getBlockZ()-4;j<Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getLocation().getBlockZ()+4;j++) {
					  if (Bukkit.getWorld("world").getBlockAt(i,86,j).getType()==Material.DIRT) {
						  player_a_blocks+=1;
					  }
				  }
			  }
			  for (int i=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getLocation().getBlockX()-4;i<Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getLocation().getBlockX()+4;i++) {
				  for (int j=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getLocation().getBlockZ()-4;j<Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getLocation().getBlockZ()+4;j++) {
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
			  this.plugin.getConfig().set("spleefinsession", Boolean.valueOf(false));
			  //Find out if we're player A, or player B.
			  Player winningplayer,losingplayer;
			  if (p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestaplayer"))==0 || blockwinner==2) {
				  //We're player A.
				  //Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+this.plugin.getConfig().getString("spleefrequestbplayer")+" is the winner of this spleef game! "+this.plugin.getConfig().getString("spleefrequestaplayer")+" loses.");
				  losingplayer=p;
				  winningplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer"));

				  double val1,val2,value,newval1,newval2;
				  if (this.plugin.getAccountsConfig().contains(winningplayer.getName()+".spleefrating")) {
					  val1 = this.plugin.getAccountsConfig().getDouble(winningplayer.getName()+".spleefrating");
				  } else {
					  val1 = 1000.0d;
				  }
				  if (this.plugin.getAccountsConfig().contains(losingplayer.getName()+".spleefrating")) {
					  val2 = this.plugin.getAccountsConfig().getDouble(losingplayer.getName()+".spleefrating");
				  } else {
					  val2 = 1000.0d;
				  }
				  value = 1.0d/(1.0d+Math.pow(10.0d, ((val2-val1)/400.0d)));
				  if (this.plugin.getAccountsConfig().contains(winningplayer.getName()+".spleefwins")) {
					  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleefwins", Integer.valueOf(this.plugin.getAccountsConfig().getInt(winningplayer.getName()+".spleefwins")+1));
				  } else {
					  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleefwins", Integer.valueOf(1));
				  }
				  if (this.plugin.getAccountsConfig().contains(winningplayer.getName()+".spleeflosses")) {
					  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleeflosses", Integer.valueOf(this.plugin.getAccountsConfig().getInt(winningplayer.getName()+".spleeflosses")));
				  } else {
					  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleeflosses", Integer.valueOf(0));
				  }
				  if (this.plugin.getAccountsConfig().contains(losingplayer.getName()+".spleefwins")) {
					  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleefwins", Integer.valueOf(this.plugin.getAccountsConfig().getInt(losingplayer.getName()+".spleefwins")));
				  } else {
					  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleefwins", Integer.valueOf(0));
				  }
				  if (this.plugin.getAccountsConfig().contains(losingplayer.getName()+".spleeflosses")) {
					  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleeflosses", Integer.valueOf(this.plugin.getAccountsConfig().getInt(losingplayer.getName()+".spleeflosses")+1));
				  } else {
					  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleeflosses", Integer.valueOf(1));
				  }
				  newval1 = (val1+Math.round(((50.0d/((this.plugin.getAccountsConfig().getDouble(winningplayer.getName()+".spleefwins")+this.plugin.getAccountsConfig().getDouble(winningplayer.getName()+".spleeflosses"))/20.0d))*(1.0d-value))));
				  newval2 = (val2+Math.round(((50.0d/((this.plugin.getAccountsConfig().getDouble(losingplayer.getName()+".spleefwins")+this.plugin.getAccountsConfig().getDouble(losingplayer.getName()+".spleeflosses"))/20.0d))*(0.0d-value))));
				  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleefrating",Double.valueOf(newval1));
				  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleefrating",Double.valueOf(newval2));
				  Location newloc = winningplayer.getLocation();

				  Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+this.plugin.getConfig().getString("spleefrequestbplayer")+"["+(int)newval1/10+"] is the winner of this spleef game! "+this.plugin.getConfig().getString("spleefrequestaplayer")+"["+(int)newval2/10+"] loses.");
				  newloc.setX(1622.5d);
				  newloc.setY(87.0d);
				  newloc.setZ(51.65d);
				  winningplayer.teleport(newloc);
				  updateTopSPLEEFSigns();
				  this.plugin.saveAccountsConfig();
			  } else {
				  //We're player B.
				  //Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+this.plugin.getConfig().getString("spleefrequestaplayer")+" is the winner of this spleef game! "+this.plugin.getConfig().getString("spleefrequestbplayer")+" loses.");
				  losingplayer=p;
				  winningplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer"));
				  double val1,val2,value,newval1,newval2;
				  if (this.plugin.getAccountsConfig().contains(winningplayer.getName()+".spleefrating")) {
					  val1 = this.plugin.getAccountsConfig().getDouble(winningplayer.getName()+".spleefrating");
				  } else {
					  val1 = 1000.0d;
				  }
				  if (this.plugin.getAccountsConfig().contains(losingplayer.getName()+".spleefrating")) {
					  val2 = this.plugin.getAccountsConfig().getDouble(losingplayer.getName()+".spleefrating");
				  } else {
					  val2 = 1000.0d;
				  }
				  value = 1.0d/(1.0d+Math.pow(10.0d, ((val2-val1)/400.0d)));
				  if (this.plugin.getAccountsConfig().contains(winningplayer.getName()+".spleefwins")) {
					  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleefwins", Integer.valueOf(this.plugin.getAccountsConfig().getInt(winningplayer.getName()+".spleefwins")+1));
				  } else {
					  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleefwins", Integer.valueOf(1));
				  }
				  if (this.plugin.getAccountsConfig().contains(winningplayer.getName()+".spleeflosses")) {
					  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleeflosses", Integer.valueOf(this.plugin.getAccountsConfig().getInt(winningplayer.getName()+".spleeflosses")));
				  } else {
					  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleeflosses", Integer.valueOf(0));
				  }
				  if (this.plugin.getAccountsConfig().contains(losingplayer.getName()+".spleefwins")) {
					  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleefwins", Integer.valueOf(this.plugin.getAccountsConfig().getInt(losingplayer.getName()+".spleefwins")));
				  } else {
					  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleefwins", Integer.valueOf(0));
				  }
				  if (this.plugin.getAccountsConfig().contains(losingplayer.getName()+".spleeflosses")) {
					  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleeflosses", Integer.valueOf(this.plugin.getAccountsConfig().getInt(losingplayer.getName()+".spleeflosses")+1));
				  } else {
					  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleeflosses", Integer.valueOf(1));
				  }
				  newval1 = ((val1+Math.round((50.0d/((this.plugin.getAccountsConfig().getDouble(winningplayer.getName()+".spleefwins")+this.plugin.getAccountsConfig().getDouble(winningplayer.getName()+".spleeflosses"))/20.0d))*(1.0d-value))));
				  newval2 = ((val2+Math.round((50.0d/((this.plugin.getAccountsConfig().getDouble(losingplayer.getName()+".spleefwins")+this.plugin.getAccountsConfig().getDouble(losingplayer.getName()+".spleeflosses"))/20.0d))*(0.0d-value))));
				  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleefrating",Double.valueOf(newval1));
				  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleefrating",Double.valueOf(newval2));
				  Location newloc = winningplayer.getLocation();

				  Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+this.plugin.getConfig().getString("spleefrequestaplayer")+"["+(int)newval1/10+"] is the winner of this spleef game! "+this.plugin.getConfig().getString("spleefrequestbplayer")+"["+(int)newval2/10+"] loses.");
				  newloc.setX(1622.5d);
				  newloc.setY(87.0d);
				  newloc.setZ(51.65d);
				  winningplayer.teleport(newloc);
				  updateTopSPLEEFSigns();
				  this.plugin.saveAccountsConfig();
			  }
			  //Look for the special shovel.
			  Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().clear();
			  Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().clear();
				Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().clear(Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().getHeldItemSlot());
				Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().clear(Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().getHeldItemSlot());
			  //Give inventories back.
			  for (int i=0;i<this.plugin.spleef_inventory_a.length;i++) {
				  if (this.plugin.spleef_inventory_a[i]!=null) {
				  Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().addItem(this.plugin.spleef_inventory_a[i]);
				  }
			  }
			  for (int i=0;i<this.plugin.spleef_inventory_b.length;i++) {
				  if (this.plugin.spleef_inventory_b[i]!=null) {
				  Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().addItem(this.plugin.spleef_inventory_b[i]);
				  }
			  }
				//Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).updateInventory();
				//Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).updateInventory();
		  }
	  } else {
		  if (this.plugin.getConfig().getBoolean("spleefinsession") && (p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestaplayer"))!=0 && p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestbplayer"))!=0)) {
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
  */
  
  /*
  @EventHandler
  public void onNameTag(PlayerReceiveNameTagEvent event) {
	  //String event.getNamedPlayer().getName()
	  String name = event.getNamedPlayer().getName();
	  //Divide name into two sections based on health.
	  double healthratio = (double)event.getNamedPlayer().getHealth() / (double)event.getNamedPlayer().getMaxHealth();
	  String firstpart=name.substring(0,(int)(name.length() * healthratio));
	  String secondpart=name.substring(firstpart.length(),name.length()-firstpart.length());
	  event.setTag(ChatColor.GREEN + firstpart + ChatColor.DARK_RED + secondpart);
}
*/
  
  @EventHandler
  public void onPlayerLeave(PlayerQuitEvent e) {
    Player p = e.getPlayer();
    for (int i=0;i<this.plugin.SPEED_CONTROL.size();i++) {
    	if (this.plugin.SPEED_CONTROL.get(i).p.getName().compareTo(p.getName())==0) {
    	    p.removePotionEffect(PotionEffectType.SPEED);
    	    //If they have a "speed" potion, give it back.
    	    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (int) ((this.plugin.SPEED_CONTROL.get(i).potion_time-Bukkit.getWorld("world").getFullTime())*2), this.plugin.SPEED_CONTROL.get(i).potion_spdlv, true));
    		this.plugin.SPEED_CONTROL.remove(i);
    		break;
    	}
    }
    Player[] list = Bukkit.getOnlinePlayers();
    for (int i=0;i<list.length;i++) {
    	if (list[i]!=p) {
    	    list[i].playSound(list[i].getLocation(), Sound.NOTE_PLING, 8, 0.7f);
    	}
    }
    if (!this.plugin.getAccountsConfig().getBoolean(p.getName()+".revived")) {
      this.plugin.getAccountsConfig().set(p.getName() + ".revived", Boolean.valueOf(true));
      this.plugin.saveAccountsConfig();
    }
    if (this.plugin.getConfig().getBoolean("spleefinsession") && (p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestaplayer"))==0 || p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestbplayer"))==0)) {
    	//This player was in spleef. End the spleef session as if this player lost.
    		//We lose. Other player wins.
		  this.plugin.getConfig().set("spleefinsession", Boolean.valueOf(false));
		  //Find out if we're player A, or player B.
		  Player winningplayer,losingplayer;
		  if (p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestaplayer"))==0) {
			  //We're player A.
			  losingplayer=p;
			  winningplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer"));
			  double val1,val2,value,newval1,newval2;
			  if (this.plugin.getAccountsConfig().contains(winningplayer.getName()+".spleefrating")) {
				  val1 = this.plugin.getAccountsConfig().getDouble(winningplayer.getName()+".spleefrating");
			  } else {
				  val1 = 1000.0d;
			  }
			  if (this.plugin.getAccountsConfig().contains(losingplayer.getName()+".spleefrating")) {
				  val2 = this.plugin.getAccountsConfig().getDouble(losingplayer.getName()+".spleefrating");
			  } else {
				  val2 = 1000.0d;
			  }
			  value = 1.0d/(1.0d+Math.pow(10.0d, ((val2-val1)/400.0d)));
			  if (this.plugin.getAccountsConfig().contains(winningplayer.getName()+".spleefwins")) {
				  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleefwins", Integer.valueOf(this.plugin.getAccountsConfig().getInt(winningplayer.getName()+".spleefwins")+1));
			  } else {
				  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleefwins", Integer.valueOf(1));
			  }
			  if (this.plugin.getAccountsConfig().contains(winningplayer.getName()+".spleeflosses")) {
				  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleeflosses", Integer.valueOf(this.plugin.getAccountsConfig().getInt(winningplayer.getName()+".spleeflosses")));
			  } else {
				  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleeflosses", Integer.valueOf(0));
			  }
			  if (this.plugin.getAccountsConfig().contains(losingplayer.getName()+".spleefwins")) {
				  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleefwins", Integer.valueOf(this.plugin.getAccountsConfig().getInt(losingplayer.getName()+".spleefwins")));
			  } else {
				  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleefwins", Integer.valueOf(0));
			  }
			  if (this.plugin.getAccountsConfig().contains(losingplayer.getName()+".spleeflosses")) {
				  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleeflosses", Integer.valueOf(this.plugin.getAccountsConfig().getInt(losingplayer.getName()+".spleeflosses")+1));
			  } else {
				  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleeflosses", Integer.valueOf(1));
			  }
			  newval1 = ((val1+Math.round((50.0d/((this.plugin.getAccountsConfig().getDouble(winningplayer.getName()+".spleefwins")+this.plugin.getAccountsConfig().getDouble(winningplayer.getName()+".spleeflosses"))/20.0d))*(1.0d-value))));
			  newval2 = ((val2+Math.round((50.0d/((this.plugin.getAccountsConfig().getDouble(losingplayer.getName()+".spleefwins")+this.plugin.getAccountsConfig().getDouble(losingplayer.getName()+".spleeflosses"))/20.0d))*(0.0d-value))));
			  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleefrating",Double.valueOf(newval1));
			  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleefrating",Double.valueOf(newval2));
			  Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+this.plugin.getConfig().getString("spleefrequestbplayer")+"["+(int)newval1/10+"] is the winner of this spleef game! "+this.plugin.getConfig().getString("spleefrequestaplayer")+"["+(int)newval2/10+"] loses.");
			  Location newloc = winningplayer.getLocation();
			  newloc.setX(1622.5d);
			  newloc.setY(87.0d);
			  newloc.setZ(51.65d);
			  winningplayer.teleport(newloc);
			  updateTopSPLEEFSigns();
			  this.plugin.saveAccountsConfig();
		  } else {
			  //We're player B.
			  winningplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer"));
			  losingplayer=p;
			  double val1,val2,value,newval1,newval2;
			  if (this.plugin.getAccountsConfig().contains(winningplayer.getName()+".spleefrating")) {
				  val1 = this.plugin.getAccountsConfig().getDouble(winningplayer.getName()+".spleefrating");
			  } else {
				  val1 = 1000.0d;
			  }
			  if (this.plugin.getAccountsConfig().contains(losingplayer.getName()+".spleefrating")) {
				  val2 = this.plugin.getAccountsConfig().getDouble(losingplayer.getName()+".spleefrating");
			  } else {
				  val2 = 1000.0d;
			  }
			  value = 1.0d/(1.0d+Math.pow(10.0d, ((val2-val1)/400.0d)));
			  if (this.plugin.getAccountsConfig().contains(winningplayer.getName()+".spleefwins")) {
				  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleefwins", Integer.valueOf(this.plugin.getAccountsConfig().getInt(winningplayer.getName()+".spleefwins")+1));
			  } else {
				  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleefwins", Integer.valueOf(1));
			  }
			  if (this.plugin.getAccountsConfig().contains(winningplayer.getName()+".spleeflosses")) {
				  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleeflosses", Integer.valueOf(this.plugin.getAccountsConfig().getInt(winningplayer.getName()+".spleeflosses")));
			  } else {
				  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleeflosses", Integer.valueOf(0));
			  }
			  if (this.plugin.getAccountsConfig().contains(losingplayer.getName()+".spleefwins")) {
				  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleefwins", Integer.valueOf(this.plugin.getAccountsConfig().getInt(losingplayer.getName()+".spleefwins")));
			  } else {
				  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleefwins", Integer.valueOf(0));
			  }
			  if (this.plugin.getAccountsConfig().contains(losingplayer.getName()+".spleeflosses")) {
				  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleeflosses", Integer.valueOf(this.plugin.getAccountsConfig().getInt(losingplayer.getName()+".spleeflosses")+1));
			  } else {
				  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleeflosses", Integer.valueOf(1));
			  }
			  newval1 = ((val1+Math.round((50.0d/((this.plugin.getAccountsConfig().getDouble(winningplayer.getName()+".spleefwins")+this.plugin.getAccountsConfig().getDouble(winningplayer.getName()+".spleeflosses"))/20.0d))*(1.0d-value))));
			  newval2 = ((val2+Math.round((50.0d/((this.plugin.getAccountsConfig().getDouble(losingplayer.getName()+".spleefwins")+this.plugin.getAccountsConfig().getDouble(losingplayer.getName()+".spleeflosses"))/20.0d))*(0.0d-value))));
			  this.plugin.getAccountsConfig().set(winningplayer.getName()+".spleefrating",Double.valueOf(newval1));
			  this.plugin.getAccountsConfig().set(losingplayer.getName()+".spleefrating",Double.valueOf(newval2));
			  Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+this.plugin.getConfig().getString("spleefrequestaplayer")+"["+(int)newval1/10+"] is the winner of this spleef game! "+this.plugin.getConfig().getString("spleefrequestbplayer")+"["+(int)newval2/10+"] loses.");
			  Location newloc = winningplayer.getLocation();
			  newloc.setX(1622.5d);
			  newloc.setY(87.0d);
			  newloc.setZ(51.65d);
			  winningplayer.teleport(newloc);
			  updateTopSPLEEFSigns();
			  this.plugin.saveAccountsConfig();
		  }
		  
		  //Look for the special shovel.
		  /*
		  ItemStack[] shovelstack = Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().getContents();
		  boolean shovelfound=false;
		  ItemStack shovel = shovelstack[0];
		  for (int i=0;i<shovelstack.length;i++) {
			  if (shovelstack[i]!=null && shovelstack[i].getItemMeta().hasDisplayName()==true && shovelstack[i].getItemMeta().getDisplayName().compareTo("Spleef Wooden Shovel")==0) {
				  //We found the shovel!
				  shovelfound=true;
				  shovel=shovelstack[i];
				  break;
			  }
		  }
		  shovelstack = Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().getContents();
		  if (!shovelfound) {
			  for (int i=0;i<shovelstack.length;i++) {
				  if (shovelstack[i]!=null && shovelstack[i].getItemMeta().hasDisplayName()==true && shovelstack[i].getItemMeta().getDisplayName().compareTo("Spleef Wooden Shovel")==0) {
					  //We found the shovel!
					  shovelfound=true;
					  shovel=shovelstack[i];
					  break;
				  }
			  }
		  }
		  if (shovelfound) {
			  Location l1 = new Location(Bukkit.getWorld("world"), 1622, 85, 58);
			  Chest c=(Chest)Bukkit.getWorld("world").getBlockAt(l1).getState();
			  c.getBlockInventory().setItem((int)(Math.random()*27.0d), shovel);
		  }*/
		  Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().clear();
		  Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().clear();
			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().clear(Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().getHeldItemSlot());
			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().clear(Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().getHeldItemSlot());
		  //Give inventories back.
		  for (int i=0;i<this.plugin.spleef_inventory_a.length;i++) {
			  if (this.plugin.spleef_inventory_a[i]!=null) {
			  Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().addItem(this.plugin.spleef_inventory_a[i]);
			  }
		  }
		  for (int i=0;i<this.plugin.spleef_inventory_b.length;i++) {
			  if (this.plugin.spleef_inventory_b[i]!=null) {
			  Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().addItem(this.plugin.spleef_inventory_b[i]);
			  }
		  }
			//Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).updateInventory();
			//Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).updateInventory();
    }

    if (this.plugin.PlayerinJob(p, "Hunter")) {
    	//Add to explorer array.
    	for (int i=0;i<this.plugin.hunterplayers.size();i++) {
    		if (this.plugin.hunterplayers.get(i).getName().compareTo(p.getName())==0) {
    			//This is us.
    			this.plugin.hunterplayers.remove(i);
    			i--;
    			break;
    		}
    	}
    }
    if (this.plugin.PlayerinJob(p, "Support")) {
    	//Add to explorer array.
    	for (int i=0;i<this.plugin.supportplayers.size();i++) {
    		if (this.plugin.supportplayers.get(i).p.getName().compareTo(p.getName())==0) {
    			//This is us.
    			this.plugin.supportplayers.remove(i);
    			i--;
    			break;
    		}
    	}
    }
    if (this.plugin.PlayerinJob(p, "Explorer")) {
    	//Add to explorer array.
    	for (int i=0;i<this.plugin.explorerlist.size();i++) {
    		if (this.plugin.explorerlist.get(i).player.compareTo(p.getName())==0) {
    			//This is us.
    			this.plugin.explorerlist.remove(i);
    			i--;
    			break;
    		}
    	}
    }
  }
  

  @EventHandler
  public void onPlayerRespawn(PlayerRespawnEvent e) {
	  final Player p = e.getPlayer();
	  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
      @Override
      public void run() {
    	  p.getScoreboard().getTeam(p.getName()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth()));
      }
  	},20);
  }
  
  @EventHandler
  public void onPlayerDeath(PlayerDeathEvent e) {
	  Player p = e.getEntity();
	  e.setDeathMessage(e.getDeathMessage().replace(p.getScoreboard().getTeam(p.getName()).getPrefix()+p.getName()+p.getScoreboard().getTeam(p.getName()).getSuffix(),p.getName()));
	  p.getScoreboard().getTeam(p.getName()).setSuffix("");
	  for (int i=0;i<this.plugin.explorerlist.size();i++) {
		  if (Bukkit.getPlayer(this.plugin.explorerlist.get(i).player)!=null) {
			  Player p2 =Bukkit.getPlayer(this.plugin.explorerlist.get(i).player);
			  if (p.equals(p2)) {
				  //This is an explorer in the explorer data.
				  this.plugin.explorerlist.get(i).wedied=true;
			  }
		  }
	  }
	  List<Entity> nearby = p.getNearbyEntities(30, 30, 30);
	  for (int i=0;i<nearby.size();i++) {
		  if (nearby.get(i).getType()==EntityType.ZOMBIE ||
				  nearby.get(i).getType()==EntityType.SPIDER ||
				  nearby.get(i).getType()==EntityType.SKELETON ||
				  nearby.get(i).getType()==EntityType.CREEPER ||
				  nearby.get(i).getType()==EntityType.PIG_ZOMBIE ||
				  nearby.get(i).getType()==EntityType.ENDERMAN ||
				  nearby.get(i).getType()==EntityType.GHAST ||
				  nearby.get(i).getType()==EntityType.MAGMA_CUBE) {
			  LivingEntity l = (LivingEntity)nearby.get(i);
			  if (l.getCustomName()!=null && l.getCustomName().contains(ChatColor.DARK_PURPLE+"")) {
				  
			  } else {
				  nearby.get(i).remove();
			  }
			  //Delete it from existence.
		  }
	  }
	  if (!this.plugin.PlayerinJob(p, "Explorer") || (this.plugin.PlayerinJob(p, "Explorer") && this.plugin.getJobLv("Explorer", p)<20)) {
		  double balance = Main.economy.getBalance(p.getName());
		  double lose = this.plugin.getConfig().getDouble("losemoney.LoseAmount");
		  double loseAmount = Main.economy.getBalance(p.getName()) / 100.0D * lose;
		  String message = "You lost $%amount because you died.";
	      DecimalFormat df = new DecimalFormat("#0.00");
	      loseAmount = Double.parseDouble(df.format(loseAmount));
	      if (Main.economy.has(p.getName(), loseAmount)) {
	        this.plugin.getLogger().info("Player " + p.getName() + "'s getting withdrawed with " + loseAmount + "$");
	        Main.economy.withdrawPlayer(p.getName(), loseAmount);
	        message = message.replaceAll("%amount", String.valueOf(loseAmount));
	      } else {
	        this.plugin.getLogger().info("Player " + p.getName() + "'s getting withdrawed with " + balance + "$");
	        Main.economy.withdrawPlayer(p.getName(), balance);
	        message = message.replaceAll("%amount", String.valueOf(balance));
	      }
	      p.sendMessage(message);
	  }
	  if (this.plugin.PlayerinJob(p,"Explorer")) {
		  PersistentExplorerList eve = new PersistentExplorerList(p.getName());
		  eve.event=2;
		  eve.expiretime=Bukkit.getWorld("world").getFullTime()+3600;
		  this.plugin.explorers.add(eve);
	  }
      DecimalFormat df = new DecimalFormat("#0.00");
      double deathX = p.getLocation().getX();
      double deathY = p.getLocation().getY();
      double deathZ = p.getLocation().getZ();
      String deathWorld = p.getLocation().getWorld().getName();
	  this.plugin.getAccountsConfig().set(p.getName() + ".deathpointX",Double.valueOf(deathX));
	  this.plugin.getAccountsConfig().set(p.getName() + ".deathpointY",Double.valueOf(deathY));
	  this.plugin.getAccountsConfig().set(p.getName() + ".deathpointZ",Double.valueOf(deathZ));
	  this.plugin.getAccountsConfig().set(p.getName() + ".deathworld",String.valueOf(deathWorld));
	  this.plugin.getAccountsConfig().set(p.getName() + ".revived",Boolean.valueOf(false));
	  this.plugin.getAccountsConfig().set(p.getName() + ".revivetime",Double.valueOf(p.getPlayerTime()));
      this.plugin.saveAccountsConfig();
      double mincost = this.plugin.getConfig().getDouble("revive-cost-rate");
      mincost *= Math.abs(p.getBedSpawnLocation().getX()-deathX)+Math.abs(p.getBedSpawnLocation().getY()-deathY)+Math.abs(p.getBedSpawnLocation().getZ()-deathZ);
      double mymoney = this.plugin.getAccountsConfig().getDouble(p.getName() + ".money");
      double finalcost = (mincost*this.plugin.getConfig().getDouble("revive-cost-rate")) + (mymoney*this.plugin.getConfig().getDouble("revive-cost-tax"));
      if (this.plugin.PlayerinJob(p, "Explorer") && this.plugin.getJobLv("Explorer", p)>=20) {
    	  finalcost*=0.25;
      }
      if (mymoney>=mincost) {
    	  p.sendMessage("You died. It will cost you $"+df.format(finalcost)+" to revive. To revive, type /revive me.");
      } else {
    	  p.sendMessage("You died. You do not have enough money in your bank to revive.");
    	  p.sendMessage("Cost: $"+df.format(finalcost)+". If you want to revive, type "+ChatColor.AQUA+"/revive me"+ChatColor.WHITE+" when you have enough.");
      }
  }

  @EventHandler
  public void onSignPlace(SignChangeEvent e)
  {
    Player p = e.getPlayer();
    String[] lines = e.getLines();
    updateTopSPLEEFSigns();
    if (p.hasPermission("bankeconomy.sign.create")) {
        if ((lines[0].equalsIgnoreCase("[Bank]")) && (lines[1].equalsIgnoreCase("Deposit"))) {
        	e.setLine(0, ChatColor.DARK_GREEN + "[Bank]");
        	e.setLine(1, ChatColor.DARK_RED + "Deposit");
        	e.setLine(2, "Right-Click");
        	e.setLine(3, "to use");
        } else
        if ((lines[0].equalsIgnoreCase("[Bank]")) && (lines[1].equalsIgnoreCase("Withdraw"))) {
        	e.setLine(0, ChatColor.DARK_GREEN + "[Bank]");
        	e.setLine(1, ChatColor.DARK_BLUE + "Withdraw");
        	e.setLine(2, "Right-Click");
        	e.setLine(3, "to use");
        } else
        if ((lines[0].equalsIgnoreCase("[Bank]")) && (lines[1].equalsIgnoreCase("Check Balance"))) {
        	e.setLine(0, ChatColor.DARK_GREEN + "[Bank]");
        	e.setLine(1, ChatColor.DARK_GRAY + "Check Balance");
        	e.setLine(2, "Right-Click");
        	e.setLine(3, "to use");
        } else {
        	if ((lines[0].equalsIgnoreCase("[Bank]"))) {
    	      e.setCancelled(true);
    	      p.sendMessage("ｧcYou do not have permission to create [Bank] signs.");
        	}
        }
    }
    /*
    if (p.hasPermission("bankeconomy.sign.create")) {
      if ((lines[0].equalsIgnoreCase("[BankEconomy]")) && (lines[1].equalsIgnoreCase("deposit"))) {
        e.setLine(0, ChatColor.DARK_GREEN + "[BankEconomy]");
        if (!lines[2].matches("^[0-9]+$")) {
          e.setLine(1, ChatColor.DARK_RED + "Error");
          e.setLine(2, " ");
          p.sendMessage("ｧ2[BankEconomy]" + ChatColor.AQUA + " The amount of money is invalid. (line 3)");
        } else if (!lines[3].isEmpty()) {
          e.setLine(1, ChatColor.DARK_RED + "Error");
          e.setLine(2, " ");
          e.setLine(3, " ");
          p.sendMessage("ｧ2[BankEconomy]" + ChatColor.AQUA + " The line 4 must be empty.");
        } else {
          e.setLine(1, ChatColor.YELLOW + "deposit");
          p.sendMessage("ｧ2[BankEconomy]" + ChatColor.AQUA + " Sign created successfully!");
        }
      } else if ((lines[0].equalsIgnoreCase("[BankEconomy]")) && (lines[1].equalsIgnoreCase("withdraw"))) {
        e.setLine(0, ChatColor.DARK_GREEN + "[BankEconomy]");
        if (!lines[3].isEmpty()) {
          e.setLine(1, ChatColor.DARK_RED + "Error");
          e.setLine(2, " ");
          e.setLine(3, " ");
          p.sendMessage("ｧ2[BankEconomy]" + ChatColor.AQUA + " The line 4 must be empty.");
        } else if (!lines[2].matches("^[0-9]+$")) {
          e.setLine(1, ChatColor.DARK_RED + "Error");
          e.setLine(2, " ");
          p.sendMessage("ｧ2[BankEconomy]" + ChatColor.AQUA + " The amount of money is invalid. (line 3)");
        } else {
          e.setLine(1, ChatColor.YELLOW + "withdraw");
          p.sendMessage("ｧ2[BankEconomy]" + ChatColor.AQUA + " Sign created successfully!");
        }
      } else if ((lines[0].equalsIgnoreCase("[BankEconomy]")) && (lines[1].equalsIgnoreCase("information"))) {
        e.setLine(0, ChatColor.DARK_GREEN + "[BankEconomy]");
        if ((!lines[2].isEmpty()) || (!lines[3].isEmpty())) {
          e.setLine(1, ChatColor.DARK_RED + "Error");
          e.setLine(2, " ");
          e.setLine(3, " ");
          p.sendMessage("ｧ2[BankEconomy]" + ChatColor.AQUA + " Lines 3 and 4 must be empty.");
        } else {
          e.setLine(0, ChatColor.DARK_GREEN + "[BankEconomy]");
          e.setLine(1, ChatColor.YELLOW + "information");
        }
      } else if (lines[0].equalsIgnoreCase("[BankEconomy]")) {
        e.setLine(0, ChatColor.DARK_GREEN + "[BankEconomy]");
        e.setLine(1, ChatColor.DARK_RED + "Error");
        e.setLine(2, " ");
        e.setLine(3, " ");
        p.sendMessage("ｧ2[BankEconomy]" + ChatColor.AQUA + " Invalid action.");
      }
    } else {
    	if ((lines[0].equalsIgnoreCase("[BankEconomy]"))) {
	      e.setCancelled(true);
	      p.sendMessage("ｧcYou do not have permission.");
    	}
    }*/
  }
  
  public int getSongDuration(Material record) {
	  int padding=20;
	  if (record==Material.RECORD_3) {
		  return 345/2+5+padding;
	  } else
	  if (record==Material.RECORD_4) {
		  return 185/2+5+padding;
	  } else
	  if (record==Material.RECORD_5) {
		  return 174/2+5+padding;
	  } else
	  if (record==Material.RECORD_6) {
		  return 197/2+5+padding;
	  } else
	  if (record==Material.RECORD_7) {
		  return 96/2+5+padding;
	  } else
	  if (record==Material.RECORD_8) {
		  return 150/2+5+padding;
	  } else
	  if (record==Material.RECORD_9) {
		  return 188/2+5+padding;
	  } else
	  if (record==Material.RECORD_10) {
		  return 251/2+5+padding;
	  } else
	  if (record==Material.RECORD_11) {
		  return 71/2+5+padding;
	  } else
	  if (record==Material.RECORD_12) {
		  return 238/2+5+padding;
	  } else
	  if (record==Material.GOLD_RECORD) {
		  return 178/2+5+padding;
	  } else
	  if (record==Material.GREEN_RECORD) {
		  return 185/2+5+padding;
	  } else
	  return 0;
  }
  
  @EventHandler
  public void onPlayerChat(PlayerChatEvent e) {
	  //Check if they are withdrawing or depositing money.
      DecimalFormat df = new DecimalFormat("#0.00");
	  if (e.getPlayer().getName().equalsIgnoreCase(this.plugin.last_bank_deposit_user) && this.plugin.last_bank_deposit_use_time+200>Bukkit.getWorld("world").getFullTime()) {
		  //Parse the amount.
		  double val=0;
		  if (e.getMessage().equalsIgnoreCase("all")) {
			  //Deposit all the money into their account.
			  val = this.plugin.economy.getBalance(e.getPlayer().getName());
			  this.plugin.economy.withdrawPlayer(e.getPlayer().getName(), val);
	          double mymoney = this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName() + ".money");
			  this.plugin.getAccountsConfig().set(e.getPlayer().getName() + ".money", Double.valueOf(mymoney+val));
			  this.plugin.saveAccountsConfig();
			  e.getPlayer().sendMessage(ChatColor.GREEN+"Deposited $" + df.format(val) + " into your account. " + ChatColor.YELLOW + "New Bank Balance: $" + ChatColor.AQUA + df.format(this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName() + ".money")));
			  this.plugin.last_bank_deposit_use_time=0;
		  } else {
			  try {
				  val = Double.parseDouble(e.getMessage());
				  //Make sure the user is holding at least that much money.
				  if (this.plugin.economy.getBalance(e.getPlayer().getName())>=val && val>0) {
					  //Deposit the money into their account.
					  //this.plugin.economy.bankDeposit(e.getPlayer().getName(), val);
					  this.plugin.economy.withdrawPlayer(e.getPlayer().getName(), val);
			          double mymoney = this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName() + ".money");
					  this.plugin.getAccountsConfig().set(e.getPlayer().getName() + ".money", Double.valueOf(mymoney+val));
					  this.plugin.saveAccountsConfig();
					  e.getPlayer().sendMessage(ChatColor.GREEN+"Deposited $" + df.format(val) + " into your account. " + ChatColor.YELLOW + "New Bank Balance: $" + ChatColor.AQUA + df.format(this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName() + ".money")));
					  this.plugin.last_bank_deposit_use_time=0;
				  } else {
					  e.getPlayer().sendMessage(ChatColor.RED+"You are not holding that much! " + ChatColor.YELLOW +"Enter a value equal to or lower than $" + ChatColor.GREEN+ df.format(this.plugin.economy.getBalance(e.getPlayer().getName())) + "" + ChatColor.GRAY + ChatColor.ITALIC + " (Remember you can also use the word all)");
					  this.plugin.last_bank_deposit_use_time=Bukkit.getWorld("world").getFullTime();
				  }
			  } catch (NumberFormatException ex_e) {
				  e.getPlayer().sendMessage(ChatColor.RED+"That is not a valid amount! Please try again.");
				  this.plugin.last_bank_deposit_use_time=Bukkit.getWorld("world").getFullTime();
			  }
		  }
		  e.setCancelled(true);
	  } else 
	  if (e.getPlayer().getName().equalsIgnoreCase(this.plugin.last_bank_withdraw_user) && this.plugin.last_bank_withdraw_use_time+200>Bukkit.getWorld("world").getFullTime()) {
		  //Parse the amount.
		  double val=0;
		  if (e.getMessage().equalsIgnoreCase("all")) {
			  //Withdraw all the money in their account.
			  val = this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName() + ".money");
			  this.plugin.getAccountsConfig().set(e.getPlayer().getName() + ".money", Double.valueOf(0));
			  this.plugin.saveAccountsConfig();
			  this.plugin.economy.depositPlayer(e.getPlayer().getName(), val);
			  e.getPlayer().sendMessage(ChatColor.GREEN+"Withdrawed $" + df.format(val) + " from your account. " + ChatColor.YELLOW + "New Bank Balance: $" + ChatColor.AQUA + df.format(this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName() + ".money")));
			  this.plugin.last_bank_withdraw_use_time=0;
		  } else {
			  try {
				  val = Double.parseDouble(e.getMessage());
				  //Make sure the user is holding at least that much money.
				  if (this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName() + ".money")>=val && val>0) {
					  //Deposit the money into their account.
					  //this.plugin.economy.bankDeposit(e.getPlayer().getName(), val);
					  this.plugin.economy.depositPlayer(e.getPlayer().getName(), val);
			          double mymoney = this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName() + ".money");
					  this.plugin.getAccountsConfig().set(e.getPlayer().getName() + ".money", Double.valueOf(mymoney-val));
					  this.plugin.saveAccountsConfig();
					  e.getPlayer().sendMessage(ChatColor.GREEN+"Withdrawed $" + df.format(val) + " from your account. " + ChatColor.YELLOW + "New Bank Balance: $" + ChatColor.AQUA + df.format(this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName() + ".money")));
					  this.plugin.last_bank_withdraw_use_time=0;
				  } else {
					  e.getPlayer().sendMessage(ChatColor.RED+"You do not have that much! " + ChatColor.YELLOW +"Enter a value equal to or lower than $" + ChatColor.GREEN+ df.format(this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName() + ".money")) + "" + ChatColor.GRAY + ChatColor.ITALIC + " (Remember you can also use the word all)");
					  this.plugin.last_bank_withdraw_use_time=Bukkit.getWorld("world").getFullTime();
				  }
			  } catch (NumberFormatException ex_e) {
				  e.getPlayer().sendMessage(ChatColor.RED+"That is not a valid amount! Please try again.");
				  this.plugin.last_bank_withdraw_use_time=Bukkit.getWorld("world").getFullTime();
			  }
		  }
		  e.setCancelled(true);
	  } else 
	  {
		  if (e.getMessage().replaceAll("[0-9.]","").length()>0) {
			  Player[] playerlist = Bukkit.getOnlinePlayers();
			  for (int i=0;i<playerlist.length;i++) {
				  if (playerlist[i]!=e.getPlayer()) {
					  playerlist[i].playSound(playerlist[i].getLocation(), Sound.NOTE_STICKS, 0.6f, 0.85f);
				  }
			  }
		  }
		  String f="";
		  if (e.getPlayer().hasPermission("group.moderator")) {
			  f=ChatColor.GREEN+"";
		  }
		  if (e.getPlayer().hasPermission("group.administrators")) {
			  f=ChatColor.BOLD+""+ChatColor.LIGHT_PURPLE+"";
		  }
		  e.getPlayer().setDisplayName(ChatColor.ITALIC+""+ChatColor.GRAY+"Lv"+this.plugin.getJobTotalLvs(e.getPlayer())+" "+ChatColor.RESET+f+e.getPlayer().getName()+ChatColor.RESET);
		  //e.getPlayer().sendMessage(e.getMessage());
	  }
  }

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    Action blockAction = e.getAction();
    String currencySG = Main.economy.currencyNameSingular();
    String currencyPL = Main.economy.currencyNamePlural();
    boolean stats = this.plugin.getAccountsConfig().getBoolean(p.getName() + ".status");
    double actMon = this.plugin.getAccountsConfig().getDouble(p.getName() + ".money");
    int actHand = (int)Main.economy.getBalance(p.getName());
    if (this.plugin.PlayerinJob(p, "Explorer")) {
    	for (int i=0;i<this.plugin.explorerlist.size();i++) {
    		if (this.plugin.explorerlist.get(i).player.compareTo(p.getName())==0) {
    			this.plugin.explorerlist.get(i).lastinteract=e.getMaterial();
    		}
    	}
    }
    /*Was for rotating halloween pumpkins.
    if (e.getAction()==Action.LEFT_CLICK_BLOCK) {
    	if (e.getClickedBlock().getType()==Material.PUMPKIN) {
    		e.getClickedBlock().setData((byte) ((e.getClickedBlock().getData()+2 % 4)));
    	}
    }*/
    if (e.getAction()==Action.RIGHT_CLICK_AIR || e.getAction()==Action.RIGHT_CLICK_BLOCK) {
    	if (p.getItemInHand()!=null && (p.getItemInHand().getType()==Material.FLINT_AND_STEEL || p.getItemInHand().getType()==Material.LAVA_BUCKET)) {
    		if (this.plugin.PlayerinJob(p, "Support")) {
    			this.plugin.setMoneyExp(p, "Support", 0, 0);
    		}
    	}
    }
    if (e.getAction()==Action.RIGHT_CLICK_AIR || e.getAction()==Action.RIGHT_CLICK_BLOCK) {
    	boolean largechest=false;
		boolean smallchest=false;
		int identifier=-1;
		if (p.getItemInHand()!=null && (p.getItemInHand().getType()==Material.CHEST || p.getItemInHand().getType()==Material.TRAPPED_CHEST)) {
		  if (p.getItemInHand().getItemMeta().getLore()!=null) {
			//Check to see if the Lore contains anything.
			for (int i=0;i<p.getItemInHand().getItemMeta().getLore().size();i++) {
				if (p.getItemInHand().getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 9 item slots.")) {
					smallchest=true;
				}
				if (p.getItemInHand().getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 54 item slots.")) {
					largechest=true;
				}
				if (p.getItemInHand().getItemMeta().getLore().get(i).contains("ID#")) {
					identifier=Integer.valueOf(p.getItemInHand().getItemMeta().getLore().get(i).replace("ID#", ""));
				}
			}
			if (identifier==-1) {
				//This doesn't have an identifier yet. Create a new one.
				identifier=this.plugin.getConfig().getInt("item-cube-numb");
				this.plugin.getConfig().set("item-cube-numb", Integer.valueOf(identifier+1));
				this.plugin.saveConfig();
				//See if this chest is stacked. If so, set the amount to 1, and drop a side inventory of Item Cubes.
				if (p.getItemInHand().getAmount()>1) {
					ItemStack newitem = p.getItemInHand().clone();
					newitem.setAmount(p.getItemInHand().getAmount()-1);
					p.getItemInHand().setAmount(1);
					//Drop the rest on the ground.
					p.getWorld().dropItemNaturally(p.getLocation(), newitem);
				}
				ItemMeta meta = p.getItemInHand().getItemMeta();
				List<String> newlore = meta.getLore();
				newlore.add("ID#"+identifier);
				meta.setLore(newlore);
				p.getItemInHand().setItemMeta(meta);
			}
			Inventory screen = null;
			if (smallchest) {
				FileConfiguration f = this.plugin.reloadItemCubeConfig(identifier);
				if (!f.contains("created")) {
					for (int i=0;i<9;i++) {
						f.set("item-"+i, new ItemStack(Material.AIR));
					}
					f.set("created", Boolean.valueOf(true));
				}
				//List<ItemStack> items = new ArrayList<ItemStack>();
				screen=Bukkit.createInventory(p, 9, "Item Cube #"+identifier);
				for (int i=0;i<9;i++) {
					//items.add(f.getItemStack("item-"+i));
					screen.setItem(i, f.getItemStack("item-"+i));
				}
				this.plugin.saveItemCubeConfig(f, identifier);
			}
			if (largechest) {
				FileConfiguration f = this.plugin.reloadItemCubeConfig(identifier);
				if (!f.contains("created")) {
					for (int i=0;i<54;i++) {
						f.set("item-"+i, new ItemStack(Material.AIR));
					}
					f.set("created", Boolean.valueOf(true));
				}
				//List<ItemStack> items = new ArrayList<ItemStack>();
				screen=Bukkit.createInventory(p, 54, "Large Item Cube #"+identifier);
				for (int i=0;i<54;i++) {
					//items.add(f.getItemStack("item-"+i));
					screen.setItem(i, f.getItemStack("item-"+i));
				}
				this.plugin.saveItemCubeConfig(f, identifier);
			}
			if (screen!=null) {
				p.closeInventory();
				p.openInventory(screen);
				e.setCancelled(true);
				return;
			}
		  }
		}
    }
    if (blockAction == Action.RIGHT_CLICK_BLOCK) {
    	/*//CREATE THE GIANT PUMPKIN
		File file = new File("plugins/WorldEdit/schematics/Pumpkin.schematic");
	    if (file.exists()) {
	        try {
	        	//Pumpkin is 18x18.
	            com.sk89q.worldedit.Vector v = new com.sk89q.worldedit.Vector(e.getClickedBlock().getLocation().getX(), e.getClickedBlock().getLocation().getY()+1, e.getClickedBlock().getLocation().getZ());
	            World worldf = Bukkit.getWorld("world");
	            BukkitWorld BWf = new BukkitWorld(worldf);
	            EditSession es = new EditSession(BWf, 2000000);
	            CuboidClipboard c1 = SchematicFormat.MCEDIT.load(file);
	            c1.place(es, v, true);
	        } catch (DataException ex) {
	            Bukkit.getLogger().warning("DataException while trying to create structure.");
	        } catch (IOException ex) {
	        	Bukkit.getLogger().warning("IOException while trying to create structure.");
	        } catch (MaxChangedBlocksException ex) {
	        	Bukkit.getLogger().warning("MaxChangedBlocksException while trying to create structure.");
	        }
	    } else {
	    	Bukkit.getLogger().warning(("File does not exist."));
	    }*/
    	//Bukkit.getWorld("world").createExplosion(p.getLocation().getX(),p.getLocation().getY(),p.getLocation().getZ(),3f,false,true);
    	/*
    	if (p.getName().compareToIgnoreCase("AaMay")==0) {
    		LivingEntity f = (LivingEntity)Bukkit.getWorld("world").spawnEntity(p.getLocation(), EntityType.CREEPER);
    		f.setCustomName(ChatColor.GOLD+"Destructive Creeper II");
    		f.setCustomNameVisible(true);
    	}*/
     if ((e.getClickedBlock().getType()==Material.GRASS || e.getClickedBlock().getType()==Material.DIRT) && (
    		 p.getItemInHand().getType()==Material.WOOD_HOE ||
    		 p.getItemInHand().getType()==Material.STONE_HOE ||
    		 p.getItemInHand().getType()==Material.IRON_HOE ||
    		 p.getItemInHand().getType()==Material.GOLD_HOE ||
    		 p.getItemInHand().getType()==Material.DIAMOND_HOE) && this.plugin.PlayerinJob(p, "Farmer") && this.plugin.getJobLv("Farmer", p)>=5) {
    	 p.getItemInHand().setDurability((short)0);
    	 p.updateInventory();
     }
     if (e.getClickedBlock().getType() == Material.JUKEBOX && e.getItem()!=null && (e.getItem().getType()==Material.RECORD_3 ||
    		 e.getItem().getType()==Material.RECORD_4 || e.getItem().getType()==Material.RECORD_5 ||
    		 e.getItem().getType()==Material.RECORD_6 || e.getItem().getType()==Material.RECORD_7 ||
    		 e.getItem().getType()==Material.RECORD_8 || e.getItem().getType()==Material.RECORD_9 ||
    		 e.getItem().getType()==Material.RECORD_10 || e.getItem().getType()==Material.RECORD_11 ||
    		 e.getItem().getType()==Material.RECORD_12 || e.getItem().getType()==Material.GOLD_RECORD ||
    		 e.getItem().getType()==Material.GREEN_RECORD)) {
    	 //if (p.getName().compareTo("sigonasr2")==0) {p.sendMessage("This is a jukebox.");}
    	 //if (p.getName().compareTo("sigonasr2")==0) {p.sendMessage("Item in hand: "+e.getItem().getType().toString());}
    	 boolean contains=false;
    	 for (int i=0;i<this.plugin.jukeboxlist.size();i++){
    		 if (this.plugin.jukeboxlist.get(i).getJukebox().equals(e.getClickedBlock())) {
    			 contains=true;
    			 break;
    		 }
    	 }
    	 if (!contains) {
    		 this.plugin.jukeboxlist.add(new JukeboxData(e.getClickedBlock(), e.getItem().getType(), 100, getSongDuration(e.getItem().getType()), Bukkit.getWorld("world").getFullTime()));
			 if (p.getName().compareTo("sigonasr2")==0) {p.sendMessage("Added this jukebox to the list.");}
    	 }
     }
	  if (this.plugin.getConfig().getBoolean("halloween-enabled") && this.plugin.getConfig().getBoolean("maintenance-mode") && p.hasPermission("maintenance-mode-admin")) {
	     if ((e.getClickedBlock().getState() instanceof Chest) && e.getClickedBlock().getType()==Material.TRAPPED_CHEST) {
	    	 Chest c = (Chest)e.getClickedBlock().getState();
	    	 for (int i=0;i<c.getInventory().getContents().length;i++) {
	    		 if (c.getInventory().getContents()[i]!=null) {
	    			 if (c.getInventory().getContents()[i].getType()==Material.PUMPKIN_PIE && c.getInventory().getContents()[i].getItemMeta().getLore()==null) {
	    				 ItemStack pump = c.getInventory().getContents()[i].clone();
	    				 ItemMeta meta = c.getInventory().getContents()[i].getItemMeta();
	    				 List<String> newlore = new ArrayList<String>();
	    				 newlore.add("Requires "+((int)(Math.random()*1000)+100)+" Pumpkin Pie in inventory");
	    				 newlore.add("to convert to a legendary equipment item.");
	    				 meta.setLore(newlore);
	    				 meta.setDisplayName(ChatColor.GREEN+"Magical Pumpkin Pie");
	    				 pump.setItemMeta(meta);
	    				 c.getInventory().setItem(i, pump);
	    				 break;
	    			 }
	    		 }
	    	 }
	     }
	  }
     /*
     if (p.getName().compareTo("sigonasr2")==0) {
    	 int v=2;
    	 final Vector direction = p.getEyeLocation().getDirection().multiply(v);
    	 Bukkit.getWorld("world").spawnEntity(p.getEyeLocation().add(direction.getX(), direction.getY(), direction.getZ()), EntityType.SILVERFISH);
     }*/
     //if (p.getName().compareTo("sigonasr2")==0) {Bukkit.getPlayer("sigonasr2").sendMessage("This block is at "+e.getClickedBlock().getX()+" "+e.getClickedBlock().getY()+" "+e.getClickedBlock().getZ()+" Data value:"+e.getClickedBlock().getData());}
     if ((e.getClickedBlock().getState() instanceof BrewingStand)) {
         BrewingStand brewingstand = (BrewingStand)e.getClickedBlock().getState();
         //Bukkit.getPlayer("sigonasr2").sendMessage("This is a furnace "+furnace.getBurnTime()+","+furnace.getCookTime());
    	 boolean contains=false;
    	 //This furnace becomes owned. Add it to list if it doesn't exist.
    	 for (int i=0;i<this.plugin.brewingstandlist.size();i++) {
    		 if (this.plugin.brewingstandlist.get(i).getLoc().getX()==e.getClickedBlock().getLocation().getX() && this.plugin.brewingstandlist.get(i).getLoc().getY()==e.getClickedBlock().getLocation().getY() && this.plugin.brewingstandlist.get(i).getLoc().getZ()==e.getClickedBlock().getLocation().getZ()) {
    			 //Add this furnace to the list. You're the new owner as well.
    			 contains=true;
    			 //If it exists, just set the new owner.
    	         if (brewingstand.getBrewingTime()==0) {
    	        	 this.plugin.brewingstandlist.get(i).setOwner(p.getName());
    				 //Bukkit.getPlayer("sigonasr2").sendMessage(p.getName()+" is the new owner of furnace.");
    	        	 this.plugin.brewingstandlist.get(i).resetTime();
    	         }
    			 break;
    		 }
    	 }
    	 if (!contains) {
			 this.plugin.brewingstandlist.add(new BrewingStandData(e.getClickedBlock().getLocation(), p.getName()));
			 //Bukkit.getPlayer("sigonasr2").sendMessage(p.getName()+" is the new owner of brewingstand. (Added to list)");
    	 }
     } else
	 if ((e.getClickedBlock().getState() instanceof Furnace)) {
         Furnace furnace = (Furnace)e.getClickedBlock().getState();
         //Bukkit.getPlayer("sigonasr2").sendMessage("This is a furnace "+furnace.getBurnTime()+","+furnace.getCookTime());
    	 boolean contains=false;
    	 //This furnace becomes owned. Add it to list if it doesn't exist.
    	 for (int i=0;i<this.plugin.furnacelist.size();i++) {
    		 if (this.plugin.furnacelist.get(i).getLoc().getX()==e.getClickedBlock().getLocation().getX() && this.plugin.furnacelist.get(i).getLoc().getY()==e.getClickedBlock().getLocation().getY() && this.plugin.furnacelist.get(i).getLoc().getZ()==e.getClickedBlock().getLocation().getZ()) {
    			 //Add this furnace to the list. You're the new owner as well.
    			 contains=true;
    			 //If it exists, just set the new owner.
    	         if (furnace.getBurnTime()==0) {
    	        	 this.plugin.furnacelist.get(i).setOwner(p.getName());
    				 //Bukkit.getPlayer("sigonasr2").sendMessage(p.getName()+" is the new owner of furnace.");
    	        	 this.plugin.furnacelist.get(i).resetTime();
    	         }
    			 break;
    		 }
    	 }
    	 if (!contains) {
			 this.plugin.furnacelist.add(new FurnaceData(e.getClickedBlock().getLocation(), p.getName()));
			 //Bukkit.getPlayer("sigonasr2").sendMessage(p.getName()+" is the new owner of furnace. (Added to list)");
    	 }
     } else
     if ((e.getClickedBlock().getState() instanceof Sign)) {
        Sign sign = (Sign)e.getClickedBlock().getState();
        //p.sendMessage("This sign is at "+sign.getBlock().getX()+" "+sign.getBlock().getY()+" "+sign.getBlock().getZ());
        if (sign.getBlock().getX()==1608 && sign.getBlock().getY()==83 && sign.getBlock().getZ()==34) {
        	if (!this.plugin.getConfig().getBoolean("spleef4insession")) {
	        	if (p.getPlayerTime()-this.plugin.getConfig().getDouble("spleeflastrequesttime")<400) {
	        		if (this.plugin.getConfig().getString("spleefrequestb4player").compareTo("none")==0) {
	        			if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName())!=0) {
		        			this.plugin.getConfig().set("spleefrequestb4player", String.valueOf(p.getName()));
			        		this.plugin.getConfig().set("spleeflastrequesttime", Double.valueOf(p.getPlayerTime()));
			        		Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+"Spleef Player "+p.getName()+" joined the 4-player spleef game. 2 more players need to join within 20 seconds.");
			        		this.plugin.saveConfig();
	        			}
	        		} else 
	        		if (this.plugin.getConfig().getString("spleefrequestc4player").compareTo("none")==0) {
	        			if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName())!=0 &&
	        					this.plugin.getConfig().getString("spleefrequestb4player").compareTo(p.getName())!=0) {
		        			this.plugin.getConfig().set("spleefrequestc4player", String.valueOf(p.getName()));
			        		this.plugin.getConfig().set("spleeflastrequesttime", Double.valueOf(p.getPlayerTime()));
			        		Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+"Spleef Player "+p.getName()+" joined the 4-player spleef game. 1 more player needs to join within 20 seconds.");
			        		this.plugin.saveConfig();
	        			}
	        		} else 
	        		if (this.plugin.getConfig().getString("spleefrequestd4player").compareTo("none")==0) {
	        			if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName())!=0 &&
	        					this.plugin.getConfig().getString("spleefrequestb4player").compareTo(p.getName())!=0 &&
	        					this.plugin.getConfig().getString("spleefrequestc4player").compareTo(p.getName())!=0) {
		        			this.plugin.getConfig().set("spleefrequestd4player", String.valueOf(p.getName()));
			        		this.plugin.getConfig().set("spleeflastrequesttime", Double.valueOf(p.getPlayerTime()));
			        		Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+"Spleef Player "+p.getName()+" joined the 4-player spleef game.");
			        		this.plugin.saveConfig();
			        		//Match is ready to start!
			        		int arank,brank,crank,drank;
			        		arank=(this.plugin.getAccountsConfig().contains("spleefrequesta4player"+".spleefrating"))?(int)this.plugin.getAccountsConfig().getDouble(this.plugin.getConfig().getString("spleefrequesta4player")+".spleefrating")/10:100;
			        		brank=(this.plugin.getAccountsConfig().contains("spleefrequestb4player"+".spleefrating"))?(int)this.plugin.getAccountsConfig().getDouble(this.plugin.getConfig().getString("spleefrequestb4player")+".spleefrating")/10:100;
			        		crank=(this.plugin.getAccountsConfig().contains("spleefrequestc4player"+".spleefrating"))?(int)this.plugin.getAccountsConfig().getDouble(this.plugin.getConfig().getString("spleefrequestc4player")+".spleefrating")/10:100;
			        		drank=(this.plugin.getAccountsConfig().contains("spleefrequestd4player"+".spleefrating"))?(int)this.plugin.getAccountsConfig().getDouble(this.plugin.getConfig().getString("spleefrequestd4player")+".spleefrating")/10:100;
			        		this.plugin.getConfig().set("spleef4insession", Boolean.valueOf(true));
    	        			this.plugin.spleef4_inventory_a = Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequesta4player")).getInventory().getContents();
    	        			this.plugin.spleef4_inventory_b = Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestb4player")).getInventory().getContents();
    	        			this.plugin.spleef4_inventory_c = Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestc4player")).getInventory().getContents();
    	        			this.plugin.spleef4_inventory_d = Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestd4player")).getInventory().getContents();
    	        			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequesta4player")).getInventory().clear();
    	        			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequesta4player")).getInventory().clear(Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequesta4player")).getInventory().getHeldItemSlot());
    	        			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestb4player")).getInventory().clear();
    	        			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestb4player")).getInventory().clear(Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestb4player")).getInventory().getHeldItemSlot());
    	        			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestc4player")).getInventory().clear();
    	        			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestc4player")).getInventory().clear(Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestc4player")).getInventory().getHeldItemSlot());
    	        			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestd4player")).getInventory().clear();
    	        			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestd4player")).getInventory().clear(Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestd4player")).getInventory().getHeldItemSlot());
    	        			//Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).updateInventory();
    	        			//Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).updateInventory();
    	        			for (int i=1586;i<1600;i++) {
    	        				for (int j=25;j<39;j++) {
    	        						Bukkit.getWorld("world").getBlockAt(i,86,j).setType(Material.DIRT);
    	        				}
    	        			}
    	        			Bukkit.getWorld("world").getBlockAt(1593,86,34).setType(Material.WOOD);
    	        			Bukkit.getWorld("world").getBlockAt(1593,86,29).setType(Material.WOOD);
    	        			Player playera,playerb,playerc,playerd;
    	        			Location theshovel = new Location(Bukkit.getWorld("world"), 1627, 50, 27);
    	        			Chest shovelchest = (Chest)Bukkit.getWorld("world").getBlockAt(theshovel).getState();
    	        			for (int i=0;i<27;i++) {
    	        				if (shovelchest.getBlockInventory().getContents()[i]!=null && shovelchest.getBlockInventory().getContents()[i].getType()==Material.WOOD_SPADE) {
    	        					this.plugin.store_shovel=shovelchest.getBlockInventory().getContents()[i];
    	        					break;
    	        				}
    	        			}
    	        			
    	      			  Location l1 = new Location(Bukkit.getWorld("world"), 1593, 85, 29);
    	    			  Chest c=(Chest)Bukkit.getWorld("world").getBlockAt(l1).getState();
    	    			  if (!c.getBlockInventory().contains(this.plugin.store_shovel)) {
    	    				  c.getBlockInventory().setItem((int)(Math.random()*27.0d), this.plugin.store_shovel);
    	    			  }
    	        			l1 = new Location(Bukkit.getWorld("world"), 1593, 85, 34);
      	    			  c=(Chest)Bukkit.getWorld("world").getBlockAt(l1).getState();
    	    			  if (!c.getBlockInventory().contains(this.plugin.store_shovel)) {
    	    				  c.getBlockInventory().setItem((int)(Math.random()*27.0d), this.plugin.store_shovel);
    	    			  }
      	    			  
      	    			  
    	        			playera=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequesta4player"));
    	        			playerb=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestb4player"));
    	        			playerc=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestc4player"));
    	        			playerd=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestd4player"));
    	        			Location newloc=playera.getLocation();
    	        			newloc.setX(1587);
    	        			newloc.setY(87);
    	        			newloc.setZ(26);
    	        			playera.teleport(newloc);
    	        			newloc.setX(1587);
    	        			newloc.setY(87);
    	        			newloc.setZ(37);
    	        			playerb.teleport(newloc);
    	        			newloc.setX(1598);
    	        			newloc.setY(87);
    	        			newloc.setZ(37);
    	        			playerc.teleport(newloc);
    	        			newloc.setX(1598);
    	        			newloc.setY(87);
    	        			newloc.setZ(26);
    	        			playerd.teleport(newloc);
			        		Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+"Spleef Players "+this.plugin.getConfig().getString("spleefrequesta4player")+"["+(int)this.plugin.getAccountsConfig().getDouble(this.plugin.getConfig().getString("spleefrequesta4player")+".spleefrating")/10+"] vs "+this.plugin.getConfig().getString("spleefrequestb4player")+"["+(int)this.plugin.getAccountsConfig().getDouble(this.plugin.getConfig().getString("spleefrequestb4player")+".spleefrating")/10+"] vs "+this.plugin.getConfig().getString("spleefrequestc4player")+"["+(int)this.plugin.getAccountsConfig().getDouble(this.plugin.getConfig().getString("spleefrequestc4player")+".spleefrating")/10+"] vs "+this.plugin.getConfig().getString("spleefrequestd4player")+"["+drank+"]");
	        			}
	        		}
	        	} else {
	        		//First request.
	        		//Reset all previous requests.	
	        		this.plugin.getConfig().set("spleefrequesta4player", String.valueOf(p.getName()));
	        		this.plugin.getConfig().set("spleefrequestb4player", String.valueOf("none"));
	        		this.plugin.getConfig().set("spleefrequestc4player", String.valueOf("none"));
	        		this.plugin.getConfig().set("spleefrequestd4player", String.valueOf("none"));
	        		this.plugin.getConfig().set("spleeflastrequesttime", Double.valueOf(p.getPlayerTime()));
	        		Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+"Spleef Player "+p.getName()+" requested a 4-player spleef game. Next player join within 20 seconds.");
	        		this.plugin.saveConfig();
	        	}
        	}
        }
        else
        if (sign.getBlock().getX()==1624 && sign.getBlock().getY()==83 && sign.getBlock().getZ()==45) { //Side A Request.
        	//If not requested already.
        	if (!this.plugin.getConfig().getBoolean("spleefinsession")) {
	        	if (p.getPlayerTime()-this.plugin.getConfig().getDouble("spleefrequestbtime")>400) {
		        	if (p.getPlayerTime()-this.plugin.getConfig().getDouble("spleefrequestatime")>400 && (p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestbplayer"))!=0 || p.getPlayerTime()-this.plugin.getConfig().getDouble("spleefrequestbtime")>400)) {
		        		Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+"Spleef Player "+p.getName()+" requested a game in slot A. Join within 20 seconds.");
		        		this.plugin.getConfig().set("spleefrequestatime", Double.valueOf(p.getPlayerTime()));
		        		this.plugin.getConfig().set("spleefrequestaplayer", String.valueOf(p.getName()));
		        	}
	        	} else {
	        		if (p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestbplayer"))!=0) {
	        			//This is a confirmed Spleef game.
	        			int playerarating,playerbrating;
	        			Player playera,playerb;
	        			playera=p;
	        			this.plugin.getConfig().set("spleefrequestatime", Double.valueOf(p.getPlayerTime()));
		        		this.plugin.getConfig().set("spleefrequestaplayer", String.valueOf(p.getName()));
	        			playerb=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer"));
	        			if (this.plugin.getAccountsConfig().contains(this.plugin.getConfig().getString("spleefrequestaplayer")+".spleefrating")) {
	        				playerarating=(int)this.plugin.getAccountsConfig().getDouble(this.plugin.getConfig().getString("spleefrequestaplayer")+".spleefrating")/10;
	        			} else {
	        				playerarating=1000;
	        			}
	        			if (this.plugin.getAccountsConfig().contains(this.plugin.getConfig().getString("spleefrequestbplayer")+".spleefrating")) {
	        				playerbrating=(int)this.plugin.getAccountsConfig().getDouble(this.plugin.getConfig().getString("spleefrequestbplayer")+".spleefrating")/10;
	        			} else {
	        				playerbrating=1000;
	        			}
	        			Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.GREEN+"Spleef Game Started: "+ChatColor.YELLOW+this.plugin.getConfig().getString("spleefrequestaplayer")+"["+playerarating+"] vs. "+this.plugin.getConfig().getString("spleefrequestbplayer")+"["+playerbrating+"]");
	        			this.plugin.getConfig().set("spleefinsession", Boolean.valueOf(true));
	        			this.plugin.spleef_inventory_a = Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().getContents();
	        			this.plugin.spleef_inventory_b = Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().getContents();
	        			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().clear();
	        			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().clear(Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().getHeldItemSlot());
	        			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().clear();
	        			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().clear(Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().getHeldItemSlot());
	        			//Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).updateInventory();
	        			//Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).updateInventory();
	        			for (int i=1617;i<1627;i++) {
	        				for (int j=54;j<64;j++) {
	        						Bukkit.getWorld("world").getBlockAt(i,86,j).setType(Material.DIRT);
	        				}
	        			}
	        			Location theshovel = new Location(Bukkit.getWorld("world"), 1627, 50, 27);
	        			Chest shovelchest = (Chest)Bukkit.getWorld("world").getBlockAt(theshovel).getState();
	        			for (int i=0;i<27;i++) {
	        				if (shovelchest.getBlockInventory().getContents()[i]!=null && shovelchest.getBlockInventory().getContents()[i].getType()==Material.WOOD_SPADE) {
	        					this.plugin.store_shovel=shovelchest.getBlockInventory().getContents()[i];
	        					break;
	        				}
	        			}
	      			  Location l1 = new Location(Bukkit.getWorld("world"), 1622, 85, 58);
	    			  Chest c=(Chest)Bukkit.getWorld("world").getBlockAt(l1).getState();
	    			  if (!c.getBlockInventory().contains(this.plugin.store_shovel)) {
	    				  c.getBlockInventory().setItem((int)(Math.random()*27.0d), this.plugin.store_shovel);
	    			  }
	        			for (int i=1617;i<1627;i++) {
	        				for (int j=54;j<64;j++) {
	        						Bukkit.getWorld("world").getBlockAt(i,86,j).setType(Material.DIRT);
	        				}
	        			}
	        			Bukkit.getWorld("world").getBlockAt(1622,86,58).setType(Material.WOOD);
	        			Location newloc=playera.getLocation();
	        			newloc.setX(1622.49d);
	        			newloc.setY(87.0d);
	        			newloc.setZ(54.53d);
	        			playera.teleport(newloc);
	        			newloc.setZ(63.5d);
	        			playerb.teleport(newloc);
	        			this.plugin.spleef_last_broken_block=p.getPlayerTime();
	        		}
	        	}
	        	this.plugin.saveConfig();
	        	this.plugin.saveAccountsConfig();
        	}
        } else
            if (sign.getBlock().getX()==1620 && sign.getBlock().getY()==83 && sign.getBlock().getZ()==45) { //Side B Request.
            	//If not requested already.
            	if (!this.plugin.getConfig().getBoolean("spleefinsession")) {
    	        	if (p.getPlayerTime()-this.plugin.getConfig().getDouble("spleefrequestatime")>400) {
    		        	if (p.getPlayerTime()-this.plugin.getConfig().getDouble("spleefrequestbtime")>400 && (p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestaplayer"))!=0 || p.getPlayerTime()-this.plugin.getConfig().getDouble("spleefrequestatime")>400)) {
    		        		Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+"Spleef Player "+p.getName()+" requested a game in slot B. Join within 20 seconds.");
    		        		this.plugin.getConfig().set("spleefrequestbtime", Double.valueOf(p.getPlayerTime()));
    		        		this.plugin.getConfig().set("spleefrequestbplayer", String.valueOf(p.getName()));
    		        	}
    	        	} else {
    	        		if (p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestaplayer"))!=0) {
    	        			//This is a confirmed Spleef game.
    	        			int playerarating,playerbrating;
    	        			Player playera,playerb;
    	        			this.plugin.getConfig().set("spleefrequestbtime", Double.valueOf(p.getPlayerTime()));
    		        		this.plugin.getConfig().set("spleefrequestbplayer", String.valueOf(p.getName()));
    	        			playera=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer"));
    	        			playerb=p;
    	        			if (this.plugin.getAccountsConfig().contains(this.plugin.getConfig().getString("spleefrequestaplayer")+".spleefrating")) {
    	        				playerarating=(int)this.plugin.getAccountsConfig().getDouble(this.plugin.getConfig().getString("spleefrequestaplayer")+".spleefrating")/10;
    	        			} else {
    	        				playerarating=100;
    	        			}
    	        			if (this.plugin.getAccountsConfig().contains(this.plugin.getConfig().getString("spleefrequestbplayer")+".spleefrating")) {
    	        				playerbrating=(int)this.plugin.getAccountsConfig().getDouble(this.plugin.getConfig().getString("spleefrequestbplayer")+".spleefrating")/10;
    	        			} else {
    	        				playerbrating=100;
    	        			}
    	        			Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.GREEN+"Spleef Game Started: "+ChatColor.YELLOW+this.plugin.getConfig().getString("spleefrequestaplayer")+"["+playerarating+"] vs. "+this.plugin.getConfig().getString("spleefrequestbplayer")+"["+playerbrating+"]");
    	        			this.plugin.getConfig().set("spleefinsession", Boolean.valueOf(true));
    	        			this.plugin.spleef_inventory_a = Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().getContents();
    	        			this.plugin.spleef_inventory_b = Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().getContents();
    	        			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().clear();
    	        			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().clear(Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).getInventory().getHeldItemSlot());
    	        			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().clear();
    	        			Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().clear(Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).getInventory().getHeldItemSlot());
    	        			//Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestaplayer")).updateInventory();
    	        			//Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestbplayer")).updateInventory();
    	        			Location theshovel = new Location(Bukkit.getWorld("world"), 1627, 50, 27);
    	        			Chest shovelchest = (Chest)Bukkit.getWorld("world").getBlockAt(theshovel).getState();
    	        			for (int i=0;i<27;i++) {
    	        				if (shovelchest.getBlockInventory().getContents()[i]!=null && shovelchest.getBlockInventory().getContents()[i].getType()==Material.WOOD_SPADE) {
    	        					this.plugin.store_shovel=shovelchest.getBlockInventory().getContents()[i];
    	        					break;
    	        				}
    	        			}
    	      			  Location l1 = new Location(Bukkit.getWorld("world"), 1622, 85, 58);
    	    			  Chest c=(Chest)Bukkit.getWorld("world").getBlockAt(l1).getState();
    	    			  if (!c.getBlockInventory().contains(this.plugin.store_shovel)) {
    	    				  c.getBlockInventory().setItem((int)(Math.random()*27.0d), this.plugin.store_shovel);
    	    			  }
    	        			for (int i=1617;i<1627;i++) {
    	        				for (int j=54;j<64;j++) {
    	        						Bukkit.getWorld("world").getBlockAt(i,86,j).setType(Material.DIRT);
    	        				}
    	        			}
    	        			Bukkit.getWorld("world").getBlockAt(1622,86,58).setType(Material.WOOD);
    	        			Location newloc=playera.getLocation();
    	        			newloc.setX(1622.49d);
    	        			newloc.setY(87.0d);
    	        			newloc.setZ(54.53d);
    	        			playera.teleport(newloc);
    	        			newloc.setZ(63.5d);
    	        			playerb.teleport(newloc);
    	        			this.plugin.spleef_last_broken_block=p.getPlayerTime();
    	        		}
    	        	}
    	        	this.plugin.saveConfig();
    	        	this.plugin.saveAccountsConfig();
            	}
            }
        if (stats) {
          if (p.hasPermission("bankeconomy.sign.use")) {
            if ((sign.getLine(0).equalsIgnoreCase(ChatColor.DARK_GREEN + "[Bank]")) && (sign.getLine(1).equalsIgnoreCase(ChatColor.DARK_RED + "Deposit"))) {
              /*double value = Double.parseDouble(arg0);
              double total = actMon + value;
              if (value <= actHand) {
                this.plugin.getAccountsConfig().set(p.getName() + ".money", Double.valueOf(total));
                this.plugin.saveAccountsConfig();
                if (value <= 1)
                  p.sendMessage("ｧ2[BankEconomy]" + ChatColor.AQUA + " You added " + value + " " + currencySG + " to your bank account.");
                else {
                  p.sendMessage("ｧ2[BankEconomy]" + ChatColor.AQUA + " You added " + value + " " + currencyPL + " to your bank account.");
                }
                Main.economy.withdrawPlayer(p.getName(), value);
              } else {
                p.sendMessage("ｧ2[BankEconomy]" + ChatColor.AQUA + " Sorry, you can't deposit that amount of money.");
              }*/
            	//If they were using the withdraw bank before, clear them from it.
        		if (this.plugin.last_bank_withdraw_user.equalsIgnoreCase(p.getName())) {
        			this.plugin.last_bank_withdraw_user="";
        		}
            	if (this.plugin.last_bank_deposit_use_time+200<Bukkit.getWorld("world").getFullTime() || this.plugin.last_bank_deposit_user.equalsIgnoreCase(p.getName())) {
            		this.plugin.last_bank_deposit_user=p.getName();
            		this.plugin.last_bank_deposit_use_time=Bukkit.getWorld("world").getFullTime();
            		p.sendMessage(ChatColor.DARK_GREEN+"[Bank]" + ChatColor.AQUA +" Please enter the amount of money in chat that you would like to deposit. " + ChatColor.YELLOW + "(Type all to deposit every dollar you are holding.)");
            	} else {
            		p.sendMessage(ChatColor.DARK_GREEN+"[Bank]" + ChatColor.RED +" Someone else is using the deposit bank at the moment. Please wait until they are finished.");
            	}
            } else if ((sign.getLine(0).equalsIgnoreCase(ChatColor.DARK_GREEN + "[Bank]")) && (sign.getLine(1).equalsIgnoreCase(ChatColor.DARK_BLUE + "Withdraw"))) {
              /*int value = Integer.parseInt(sign.getLine(2));
              double total = actMon - value;
              if (value <= actMon) {
                this.plugin.getAccountsConfig().set(p.getName() + ".money", Double.valueOf(total));
                this.plugin.saveAccountsConfig();
                if (value <= 1)
                  p.sendMessage("ｧ2[BankEconomy]" + ChatColor.AQUA + " You withdrawn " + value + " " + currencySG + " from your bank account.");
                else {
                  p.sendMessage("ｧ2[BankEconomy]" + ChatColor.AQUA + " You withdrawn " + value + " " + currencyPL + " from your bank account.");
                }
                Main.economy.depositPlayer(p.getName(), value);
              } else {
                p.sendMessage("ｧ2[BankEconomy]" + ChatColor.AQUA + " Sorry, you can't withdraw that amount of money.");
              }*/
            	if (this.plugin.last_bank_withdraw_use_time+200<Bukkit.getWorld("world").getFullTime() || this.plugin.last_bank_withdraw_user.equalsIgnoreCase(p.getName())) {
            		//If they were using the deposit bank before, clear them from it.
            		if (this.plugin.last_bank_deposit_user.equalsIgnoreCase(p.getName())) {
            			this.plugin.last_bank_deposit_user="";
            		}
            		this.plugin.last_bank_withdraw_user=p.getName();
            		this.plugin.last_bank_withdraw_use_time=Bukkit.getWorld("world").getFullTime();
            		p.sendMessage(ChatColor.DARK_GREEN+"[Bank]" + ChatColor.AQUA +" Please enter the amount of money in chat that you would like to withdraw. " + ChatColor.YELLOW + "(Type all to withdraw every dollar you have in the bank.)");
            	} else {
            		p.sendMessage(ChatColor.DARK_GREEN+"[Bank]" + ChatColor.RED +" Someone else is using the withdraw bank at the moment. Please wait until they are finished.");
            	}
            } else if ((sign.getLine(0).equalsIgnoreCase(ChatColor.DARK_GREEN + "[Bank]")) && (sign.getLine(1).equalsIgnoreCase(ChatColor.DARK_GRAY + "Check Balance"))) {
              p.sendMessage(ChatColor.GRAY + "===========[ " + ChatColor.LIGHT_PURPLE + "Current Balance" + ChatColor.GRAY + " ]===========");
              DecimalFormat df = new DecimalFormat("#0.00");
              if (actMon <= 1)
                p.sendMessage(ChatColor.DARK_GREEN + "Balance: $" + ChatColor.BOLD + ChatColor.AQUA + df.format(actMon));
              else {
                p.sendMessage(ChatColor.DARK_GREEN + "Balance: $" + ChatColor.BOLD + ChatColor.AQUA + df.format(actMon));
              }
              /*
              if (stats)
                p.sendMessage(ChatColor.DARK_GREEN + "Status: " + ChatColor.AQUA + "enabled");
              else if (!stats) {
                p.sendMessage(ChatColor.DARK_GREEN + "Status: " + ChatColor.AQUA + "disabled");
              }*/
              p.sendMessage(ChatColor.GRAY + "======================================");
            }
          }
          else
          {
            p.sendMessage(ChatColor.RED+"You do not have permission.");
          }
        }
        else p.sendMessage(ChatColor.DARK_GREEN+"[BankEconomy]" + ChatColor.RED + " Your account is disabled.");
      }
    }
    else;
  }
  
public String convertToItemName(String val) {
	val=val.replace('_', ' ');
	char[] mod = val.toCharArray();
	  boolean first=false;
	  for (int i=0;i<mod.length;i++) {
		  if (!first) {
			  if (mod[i]>='a'&&mod[i]<='z') {
				  mod[i]-=32;
				  first=true;
			  } else 
				  if (i==0) {
					  if (mod[i]>='A'&&mod[i]<='Z') {
						  first=true;
					  }
				  } else {
					  if (mod[i]>='A'&&mod[i]<='Z'&&(mod[i-1]<'A'||mod[i-1]>'Z')) {
						  first=true;
					  }
				  }
		  } else {
			  if (mod[i-1]!=' ') {
				  if (mod[i]>='A'&&mod[i]<='Z') {
					  mod[i]+=32;
				  }
			  }
		  }
	  }
	  return String.valueOf(mod);
}
/*
	@EventHandler
	public void onLightningStrike(LightningStrikeEvent e) {
		Bukkit.getWorld("world").strikeLightning(new Location("world", Bukkit.getOnlinePlayers()[(int)(Math.random()*Bukkit.getOnlinePlayers().length)].getLocation().getX(), 0d, 0d));
	}*/

}

