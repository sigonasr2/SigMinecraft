package me.kaZep.Base;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
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
//import net.minecraft.server.v1_7_R1.WorldData;
//import net.minecraft.server.v1_4_R1.EntityWolf;






import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Difficulty;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Biome;
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
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creature;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Golem;
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
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Slime;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.entity.Wither;
import org.bukkit.entity.WitherSkull;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Event.Result;
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
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.entity.SheepDyeWoolEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingBreakEvent.RemoveCause;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
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
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
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
import org.bukkit.inventory.InventoryView.Property;
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

import sig.ItemSets.DiabloDropsHook;

import com.google.common.base.Objects;
import com.modcrafting.diablodrops.DiabloDrops;
import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.EmptyClipboardException;
import com.sk89q.worldedit.FilenameException;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.schematic.SchematicFormat;
import com.sk89q.worldedit.util.TreeGenerator.TreeType;

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
import me.kaZep.Base.MobHead.MobHeadRareType;
import me.kaZep.Base.MobHead.MobHeadType;
import me.kaZep.Commands.JobsDataInfo.Job;

public class PlayerListener
implements Listener
{
	public Main plugin;

	public PlayerListener(Main plugin)
	{
		this.plugin = plugin;
	}

	enum Cube { SMALL, LARGE, ENDER }
	enum SpecialMob { COUNTER_SLIME, VIRAL_SPIDER, SILENCER,
		HOUND_CALLER, FISH_CALLER, EXPLOSIVE_BOMBER, SUICIDAL_CREEPER,
		CHILLING_GOLEM, POWERSURGE_ZOMBIE, LIGHTNING_MAGE }

	public boolean naturalBlock(Material mat) {
		return Main.naturalBlock(mat);
	}

	public void updateTopSPLEEFSigns() {
		String name[] = {"","",""};
		int rating[] = {-9999,-9999,-9999}, wins[] = {0,0,0}, losses[] = {0,0,0};
		//Get list of all players on the server.
		OfflinePlayer playerlist[] = Bukkit.getOfflinePlayers();
		for (int i=0;i<playerlist.length;i++) {
			if (this.plugin.getAccountsConfig().contains(playerlist[i].getName().toLowerCase())) {
				if (this.plugin.getAccountsConfig().contains(playerlist[i].getName().toLowerCase()+".spleefrating") && this.plugin.getAccountsConfig().getInt(playerlist[i].getName().toLowerCase()+".spleefwins")+this.plugin.getAccountsConfig().getInt(playerlist[i].getName().toLowerCase()+".spleeflosses")>=20) {
					if (this.plugin.getAccountsConfig().getDouble(playerlist[i].getName().toLowerCase()+".spleefrating")>rating[0]) {
						//This beats the top record, move everything down.
						name[2]=name[1];rating[2]=rating[1];wins[2]=wins[1];losses[2]=losses[1];
						name[1]=name[0];rating[1]=rating[0];wins[1]=wins[0];losses[1]=losses[0];
						name[0]=playerlist[i].getName();
						rating[0]=(int)this.plugin.getAccountsConfig().getDouble(playerlist[i].getName().toLowerCase()+".spleefrating");
						wins[0]=this.plugin.getAccountsConfig().getInt(playerlist[i].getName().toLowerCase()+".spleefwins");
						losses[0]=this.plugin.getAccountsConfig().getInt(playerlist[i].getName().toLowerCase()+".spleeflosses");
					} else
						if (this.plugin.getAccountsConfig().getDouble(playerlist[i].getName().toLowerCase()+".spleefrating")>rating[1]) {
							//This beats the 2nd record, move everything down.
							name[2]=name[1];rating[2]=rating[1];wins[2]=wins[1];losses[2]=losses[1];
							name[1]=playerlist[i].getName();
							rating[1]=(int)this.plugin.getAccountsConfig().getDouble(playerlist[i].getName().toLowerCase()+".spleefrating");
							wins[1]=this.plugin.getAccountsConfig().getInt(playerlist[i].getName().toLowerCase()+".spleefwins");
							losses[1]=this.plugin.getAccountsConfig().getInt(playerlist[i].getName().toLowerCase()+".spleeflosses");
						} else
							if (this.plugin.getAccountsConfig().getDouble(playerlist[i].getName().toLowerCase()+".spleefrating")>rating[2]) {
								//This beats the 3rd record, move everything down.
								name[2]=playerlist[i].getName();
								rating[2]=(int)this.plugin.getAccountsConfig().getDouble(playerlist[i].getName().toLowerCase()+".spleefrating");
								wins[2]=this.plugin.getAccountsConfig().getInt(playerlist[i].getName().toLowerCase()+".spleefwins");
								losses[2]=this.plugin.getAccountsConfig().getInt(playerlist[i].getName().toLowerCase()+".spleeflosses");
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
		e.setMaxPlayers(16);
		if (this.plugin.getConfig().getBoolean("maintenance-mode")) {
			e.setMotd(ChatColor.AQUA+"Sig's Minecraft!\n"+ChatColor.RED+" Currently in Maintenance Mode.");
		} else {
			e.setMotd(ChatColor.AQUA+"Sig's Minecraft!\n"+ChatColor.BLUE+" Currently Online.");
		}
		return;
	}

	@EventHandler
	public void onPlayerGainEXP(PlayerExpChangeEvent e) {
		Player p = e.getPlayer();
		if (this.plugin.PlayerinJob(p, "Enchanter") && this.plugin.getJobLv("Enchanter", p)>=5) {
			e.setAmount(e.getAmount()*2);
		}
		if (this.plugin.getAccountsConfig().getBoolean("halloween-enabled") || this.plugin.getConfig().getBoolean("thanksgiving-enabled")) {
			e.setAmount(e.getAmount()*2);
		}
		if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify3")) {
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
			if (this.plugin.hasJobBuff("Brewer", owner, Job.JOB30A)) {
				ItemStack[] items = e.getContents().getContents();
				for (int i=0;i<items.length;i++) {
					if (items[i]!=null) {
						if (e.getContents().getIngredient().getType()==Material.BLAZE_POWDER ||
								items[i].getDurability()==8201 ||
								items[i].getDurability()==8233 ||
								items[i].getDurability()==8265 ||
								items[i].getDurability()==16393 ||
								items[i].getDurability()==16425 ||
								items[i].getDurability()==16457) {
							ItemMeta meta = items[i].getItemMeta();
							List<String> lore = new ArrayList<String>();
							lore.add(ChatColor.GOLD+"");
							lore.add(ChatColor.GOLD+"Custom Effects:");
							lore.add(ChatColor.GOLD+"Applies "+ChatColor.GRAY+"Strength IV"+ChatColor.GOLD+".");
							meta.setLore(lore);
							items[i].setItemMeta(meta);
						}
						if (e.getContents().getIngredient().getType()==Material.SPECKLED_MELON ||
								items[i].getDurability()==8197 ||
								items[i].getDurability()==8229 ||
								items[i].getDurability()==8261 ||
								items[i].getDurability()==16389 ||
								items[i].getDurability()==16421 ||
								items[i].getDurability()==16453) {
							ItemMeta meta = items[i].getItemMeta();
							List<String> lore = new ArrayList<String>();
							lore.add(ChatColor.GOLD+"");
							lore.add(ChatColor.GOLD+"Custom Effects:");
							lore.add(ChatColor.GOLD+"Heals 4x more Health.");
							meta.setLore(lore);
							items[i].setItemMeta(meta);
						}
					}
				}
			}
		}
	}

	/**
	 * Opens the bonus inventory for Enchanters who have
	 * the Level 30 A buff.
	 * @param input The input item that determines what bonuses exist.
	 * @return The Inventory containing all the appropriate bonuses.
	 */
	private Inventory openBonusInventory(Player p, ItemStack input, int lvs) {
		//Determine what the bonus sets are via the input.
		Inventory inv = Bukkit.createInventory(p, 18, "Choose an additional bonus:");
		if (input.getType().name().toLowerCase().contains("helmet")) {
			ItemStack base = input.clone();base.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, base.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, base.getEnchantmentLevel(Enchantment.PROTECTION_FIRE)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, base.getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, base.getEnchantmentLevel(Enchantment.PROTECTION_PROJECTILE)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.OXYGEN, base.getEnchantmentLevel(Enchantment.OXYGEN)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.WATER_WORKER, base.getEnchantmentLevel(Enchantment.WATER_WORKER)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.THORNS, base.getEnchantmentLevel(Enchantment.THORNS)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.DURABILITY, base.getEnchantmentLevel(Enchantment.DURABILITY)+lvs/10+1);inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_HEALTH, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_DAMAGE_REDUCTION, 3*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_DURABILITY, 200*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_BLOCK_CHANCE, 5*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_SPEED_BOOST_CHANCE, 20*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_STURDY, lvs/10+1);inv.addItem(base);
			if (lvs==30) {base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_REPAIR, 1);inv.addItem(base);}
		} else
		if (input.getType().name().toLowerCase().contains("chestplate") || input.getType().name().toLowerCase().contains("leggings")) {
			ItemStack base = input.clone();base.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, base.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, base.getEnchantmentLevel(Enchantment.PROTECTION_FIRE)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, base.getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, base.getEnchantmentLevel(Enchantment.PROTECTION_PROJECTILE)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.THORNS, base.getEnchantmentLevel(Enchantment.THORNS)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.DURABILITY, base.getEnchantmentLevel(Enchantment.DURABILITY)+lvs/10+1);inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_HEALTH, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_DAMAGE_REDUCTION, 3*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_DURABILITY, 200*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_BLOCK_CHANCE, 5*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_SPEED_BOOST_CHANCE, 20*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_STURDY, lvs/10+1);inv.addItem(base);
			if (lvs==30) {base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_REPAIR, 1);inv.addItem(base);}
		} else
		if (input.getType().name().toLowerCase().contains("boots")) {
			ItemStack base = input.clone();base.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, base.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, base.getEnchantmentLevel(Enchantment.PROTECTION_FIRE)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, base.getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, base.getEnchantmentLevel(Enchantment.PROTECTION_PROJECTILE)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.THORNS, base.getEnchantmentLevel(Enchantment.THORNS)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, base.getEnchantmentLevel(Enchantment.PROTECTION_FALL)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.DURABILITY, base.getEnchantmentLevel(Enchantment.DURABILITY)+lvs/10+1);inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_HEALTH, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_DAMAGE_REDUCTION, 3*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_DURABILITY, 200*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_BLOCK_CHANCE, 5*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_SPEED_BOOST_CHANCE, 20*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_STURDY, lvs/10+1);inv.addItem(base);
			if (lvs==30) {base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_REPAIR, 1);inv.addItem(base);}
		} else
		if (input.getType().name().toLowerCase().contains("sword")) {
			ItemStack base = input.clone();base.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, base.getEnchantmentLevel(Enchantment.DAMAGE_ALL)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, base.getEnchantmentLevel(Enchantment.DAMAGE_UNDEAD)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, base.getEnchantmentLevel(Enchantment.DAMAGE_ARTHROPODS)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.KNOCKBACK, base.getEnchantmentLevel(Enchantment.KNOCKBACK)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, base.getEnchantmentLevel(Enchantment.FIRE_ASPECT)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, base.getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.DURABILITY, base.getEnchantmentLevel(Enchantment.DURABILITY)+lvs/10+1);inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_CRITICAL_CHANCE, 5*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_ARMOR_PENETRATION, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_LIFE_STEAL, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_ATTACK_SPEED, 10*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_DAMAGE, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_EXECUTE, lvs/10+1);inv.addItem(base);
		} else
		if (input.getType().name().toLowerCase().contains("axe") && !input.getType().name().toLowerCase().contains("pickaxe")) {
			ItemStack base = input.clone();base.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, base.getEnchantmentLevel(Enchantment.DAMAGE_ALL)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, base.getEnchantmentLevel(Enchantment.DAMAGE_UNDEAD)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, base.getEnchantmentLevel(Enchantment.DAMAGE_ARTHROPODS)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.DIG_SPEED, base.getEnchantmentLevel(Enchantment.DIG_SPEED)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.SILK_TOUCH, base.getEnchantmentLevel(Enchantment.SILK_TOUCH)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, base.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS)+lvs/10+1);inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_CRITICAL_CHANCE, 5*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_ARMOR_PENETRATION, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_LIFE_STEAL, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_ATTACK_SPEED, 10*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_DAMAGE, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_EXECUTE, lvs/10+1);inv.addItem(base);
		} else
		if (input.getType().name().toLowerCase().contains("spade") || input.getType().name().toLowerCase().contains("pickaxe")) {
			ItemStack base = input.clone();base.addUnsafeEnchantment(Enchantment.DIG_SPEED, base.getEnchantmentLevel(Enchantment.DIG_SPEED)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.SILK_TOUCH, base.getEnchantmentLevel(Enchantment.SILK_TOUCH)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, base.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.DURABILITY, base.getEnchantmentLevel(Enchantment.DURABILITY)+lvs/10+1);inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_CRITICAL_CHANCE, 5*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_ARMOR_PENETRATION, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_LIFE_STEAL, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_ATTACK_SPEED, 10*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_DAMAGE, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_EXECUTE, lvs/10+1);inv.addItem(base);
		} else
		if (input.getType().name().toLowerCase().contains("bow")) {
			ItemStack base = input.clone();base.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, base.getEnchantmentLevel(Enchantment.ARROW_DAMAGE)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, base.getEnchantmentLevel(Enchantment.ARROW_KNOCKBACK)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.ARROW_FIRE, base.getEnchantmentLevel(Enchantment.ARROW_FIRE)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, base.getEnchantmentLevel(Enchantment.ARROW_INFINITE)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.DURABILITY, base.getEnchantmentLevel(Enchantment.DURABILITY)+lvs/10+1);inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_CRITICAL_CHANCE, 5*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_ARMOR_PENETRATION, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_LIFE_STEAL, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_ATTACK_SPEED, 10*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_DAMAGE, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_EXECUTE, lvs/10+1);inv.addItem(base);
		} else
		if (input.getType().name().toLowerCase().contains("hoe")) {
			ItemStack base = input.clone();base.addUnsafeEnchantment(Enchantment.DURABILITY, base.getEnchantmentLevel(Enchantment.DURABILITY)+lvs/10+1);inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_CRITICAL_CHANCE, 5*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_ARMOR_PENETRATION, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_LIFE_STEAL, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_ATTACK_SPEED, 10*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_DAMAGE, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_EXECUTE, lvs/10+1);inv.addItem(base);
		} else
		if (input.getType().name().toLowerCase().contains("shears")) {
			ItemStack base = input.clone();base.addUnsafeEnchantment(Enchantment.DIG_SPEED, base.getEnchantmentLevel(Enchantment.DIG_SPEED)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.SILK_TOUCH, base.getEnchantmentLevel(Enchantment.SILK_TOUCH)+lvs/10+1);inv.addItem(base);
			base = input.clone();base.addUnsafeEnchantment(Enchantment.DURABILITY, base.getEnchantmentLevel(Enchantment.DURABILITY)+lvs/10+1);inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_CRITICAL_CHANCE, 5*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_ARMOR_PENETRATION, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_LIFE_STEAL, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_ATTACK_SPEED, 10*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_DAMAGE, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_EXECUTE, lvs/10+1);inv.addItem(base);
		} else
		if (input.getType().name().toLowerCase().contains("flint")) {
			ItemStack base = input.clone();base.addUnsafeEnchantment(Enchantment.DURABILITY, base.getEnchantmentLevel(Enchantment.DURABILITY)+lvs/10+1);inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_CRITICAL_CHANCE, 5*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_ARMOR_PENETRATION, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_LIFE_STEAL, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_ATTACK_SPEED, 10*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_DAMAGE, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_EXECUTE, lvs/10+1);inv.addItem(base);
		} else
		if (input.getType().name().toLowerCase().contains("carrot")) {
			ItemStack base = input.clone();base.addUnsafeEnchantment(Enchantment.DURABILITY, base.getEnchantmentLevel(Enchantment.DURABILITY)+lvs/10+1);inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_CRITICAL_CHANCE, 5*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_ARMOR_PENETRATION, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_LIFE_STEAL, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_ATTACK_SPEED, 10*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_DAMAGE, 2*(lvs/10+1));inv.addItem(base);
			base = input.clone();this.plugin.addBonusEnchantment(base, Main.ENCHANT_EXECUTE, lvs/10+1);inv.addItem(base);
		} else {
			return null;
		}
		return inv;
	}

	/**
	 * DO NOT use e.getItem() to get the final results! It gets
	 * manually handled and will not return what you want in terms
	 * of enchantments! The variable "finalitem" stores the correct
	 * resulting ItemStack after all adjustments are made.
	 */
	@EventHandler
	public void onEnchantItem(EnchantItemEvent e) {
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

		ItemStack finalitem=e.getItem().clone();

		if (this.plugin.PlayerinJob(p, "Enchanter")) {
			if (this.plugin.getJobLv("Enchanter", p)>=10) {
				if (e.getItem().getType()==Material.BOW) {
					int enchants[] = {48,49,50,51};
					for (int j=0;j<enchants.length;j++) {
						if (Math.random()<1.0d/enchants.length) {
							//e.getItem().addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
						}
					}
					List<String> ourLore = new ArrayList<String>();
					if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getLore()!=null) { //Check the lore for any weak item conflicts.
						List<String> thelore = e.getItem().getItemMeta().getLore();
						for (int i=0;i<thelore.size();i++) {
							if (this.plugin.is_PermanentProperty(thelore.get(i))) {
								ourLore.add(thelore.get(i));
							}
						}
					}
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
					finalitem.setItemMeta(meta);
				} else {
					if (e.getItem().getType().toString().toLowerCase().contains("sword")) {
						int enchants[] = {16,17,18,19,20,21,34};
						for (int j=0;j<enchants.length;j++) {
							if (Math.random()<1.0d/enchants.length) {
								//e.getItem().addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
							}
						}
						List<String> ourLore = new ArrayList<String>();
						if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getLore()!=null) { //Check the lore for any weak item conflicts.
							List<String> thelore = e.getItem().getItemMeta().getLore();
							for (int i=0;i<thelore.size();i++) {
								if (this.plugin.is_PermanentProperty(thelore.get(i))) {
									ourLore.add(thelore.get(i));
								}
							}
						}
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
						finalitem.setItemMeta(meta);
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
						if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getLore()!=null) { //Check the lore for any weak item conflicts.
							List<String> thelore = e.getItem().getItemMeta().getLore();
							for (int i=0;i<thelore.size();i++) {
								if (this.plugin.is_PermanentProperty(thelore.get(i))) {
									ourLore.add(thelore.get(i));
								}
							}
						}
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
						finalitem.setItemMeta(meta);
					} else {
						int enchants[] = {0,1,2,3,4,5,6,7,34};
						for (int j=0;j<enchants.length;j++) {
							if (Math.random()<1.0d/enchants.length) {
								//e.getItem().addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
							}
						}
						List<String> ourLore = new ArrayList<String>();
						if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getLore()!=null) { //Check the lore for any weak item conflicts.
							List<String> thelore = e.getItem().getItemMeta().getLore();
							for (int i=0;i<thelore.size();i++) {
								if (this.plugin.is_PermanentProperty(thelore.get(i))) {
									ourLore.add(thelore.get(i));
								}
							}
						}
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
						finalitem.setItemMeta(meta);
					}
				}
			}
			if (e.getItem().getType()==Material.BOW) {
				int enchants[] = {48,49,50,51};
				for (int j=0;j<enchants.length;j++) {
					if (Math.random()<1.0d/enchants.length) {
						e.getItem().addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*5)+1);
						finalitem.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*5)+1);
					}
				}
				List<String> ourLore = new ArrayList<String>();
				if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getLore()!=null) { //Check the lore for any weak item conflicts.
					List<String> thelore = e.getItem().getItemMeta().getLore();
					for (int i=0;i<thelore.size();i++) {
						if (this.plugin.is_PermanentProperty(thelore.get(i))) {
							ourLore.add(thelore.get(i));
						}
					}
				}
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
				finalitem.setItemMeta(meta);
			} else {
				if (e.getItem().getType().toString().toLowerCase().contains("sword")) {
					int enchants[] = {16,17,18,19,20,21,34};
					for (int j=0;j<enchants.length;j++) {
						if (Math.random()<1.0d/enchants.length) {
							e.getItem().addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*5)+1);
							finalitem.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*5)+1);
						}
					}
					List<String> ourLore = new ArrayList<String>();
					if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getLore()!=null) { //Check the lore for any weak item conflicts.
						List<String> thelore = e.getItem().getItemMeta().getLore();
						for (int i=0;i<thelore.size();i++) {
							if (this.plugin.is_PermanentProperty(thelore.get(i))) {
								ourLore.add(thelore.get(i));
							}
						}
					}
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
					finalitem.setItemMeta(meta);
				} else if (e.getItem().getType().toString().toLowerCase().contains("spade") ||
						e.getItem().getType().toString().toLowerCase().contains("axe") ||
						e.getItem().getType().toString().toLowerCase().contains("hoe") ||
						e.getItem().getType().toString().toLowerCase().contains("pickaxe")) {
					int enchants[] = {32,33,34,35};
					for (int j=0;j<enchants.length;j++) {
						if (Math.random()<1.0d/enchants.length) {
							if (enchants[j]==33) {
								if (e.getItem().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS)==0) {
									e.getItem().addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*5)+1);
									finalitem.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*5)+1);
								}
							}
							if (enchants[j]==35) {
								if (e.getItem().getEnchantmentLevel(Enchantment.SILK_TOUCH)==0) {
									e.getItem().addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*5)+1);
									finalitem.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*5)+1);
								}
							}
						}
					}
					List<String> ourLore = new ArrayList<String>();
					if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getLore()!=null) { //Check the lore for any weak item conflicts.
						List<String> thelore = e.getItem().getItemMeta().getLore();
						for (int i=0;i<thelore.size();i++) {
							if (this.plugin.is_PermanentProperty(thelore.get(i))) {
								ourLore.add(thelore.get(i));
							}
						}
					}
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
					finalitem.setItemMeta(meta);
				} else {
					int enchants[] = {0,1,2,3,4,5,6,7,34};
					for (int j=0;j<enchants.length;j++) {
						if (Math.random()<1.0d/enchants.length) {
							e.getItem().addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*5)+1);
							finalitem.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*5)+1);
						}
					}
					List<String> ourLore = new ArrayList<String>();
					if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getLore()!=null) { //Check the lore for any weak item conflicts.
						List<String> thelore = e.getItem().getItemMeta().getLore();
						for (int i=0;i<thelore.size();i++) {
							if (this.plugin.is_PermanentProperty(thelore.get(i))) {
								ourLore.add(thelore.get(i));
							}
						}
					}
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
					finalitem.setItemMeta(meta);
				}
			}
			Map<Enchantment,Integer> map = finalitem.getEnchantments();
			for (Map.Entry<Enchantment,Integer> entry : map.entrySet()) {
				if (this.plugin.getJobLv("Enchanter", p)>=20) {
					if (entry.getKey().getMaxLevel()<entry.getValue()) {
						try {
							entry.setValue(entry.getValue()+((int)(Math.random()*2)+1));
						}
						catch (UnsupportedOperationException except) {
							Bukkit.getLogger().warning("Could not handle this particular enchantment.");
						}
					}
				}
				Bukkit.getLogger().info("Enchantment "+entry.getKey().toString()+" at level "+entry.getValue());
				if (entry.getKey().getName()==Enchantment.PROTECTION_ENVIRONMENTAL.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.08*entry.getValue(),4*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.DAMAGE_UNDEAD.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.10*entry.getValue(),8*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.PROTECTION_FIRE.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.10*entry.getValue(),6*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.DAMAGE_ARTHROPODS.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.12*entry.getValue(),8*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.PROTECTION_FALL.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.14*entry.getValue(),10*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.DAMAGE_ALL.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.15*entry.getValue(),14*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.DIG_SPEED.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.15*entry.getValue(),14*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.PROTECTION_EXPLOSIONS.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.20*entry.getValue(),16*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.THORNS.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.20*entry.getValue(),16*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.KNOCKBACK.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.20*entry.getValue(),18*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.ARROW_KNOCKBACK.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.20*entry.getValue(),18*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.FIRE_ASPECT.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.22*entry.getValue(),20*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.ARROW_FIRE.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.22*entry.getValue(),20*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.WATER_WORKER.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.25*entry.getValue(),16*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.OXYGEN.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.30*entry.getValue(),20*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.DURABILITY.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.35*entry.getValue(),24*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.ARROW_INFINITE.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.40*entry.getValue(),40*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.LOOT_BONUS_MOBS.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.40*entry.getValue(),30*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.LOOT_BONUS_BLOCKS.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.50*entry.getValue(),40*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.SILK_TOUCH.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.50*entry.getValue(),40*Math.pow(entry.getValue(),2));
				}
			}
			Map<Enchantment,Integer> map2 = e.getEnchantsToAdd();
			for (Map.Entry<Enchantment,Integer> entry : map2.entrySet()) {
				if (this.plugin.getJobLv("Enchanter", p)>=20) {
					if (entry.getKey().getMaxLevel()<entry.getValue()) {
						entry.setValue(entry.getValue()+((int)(Math.random()*2)+1));
					}
				}
				finalitem.addUnsafeEnchantment(entry.getKey(), entry.getValue());
				Bukkit.getLogger().info("Enchantment "+entry.getKey().toString()+" at level "+entry.getValue());
				if (entry.getKey().getName()==Enchantment.PROTECTION_ENVIRONMENTAL.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.08*entry.getValue(),4*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.DAMAGE_UNDEAD.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.10*entry.getValue(),8*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.PROTECTION_FIRE.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.10*entry.getValue(),6*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.DAMAGE_ARTHROPODS.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.12*entry.getValue(),8*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.PROTECTION_FALL.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.14*entry.getValue(),10*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.DAMAGE_ALL.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.15*entry.getValue(),14*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.DIG_SPEED.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.15*entry.getValue(),14*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.PROTECTION_EXPLOSIONS.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.20*entry.getValue(),16*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.THORNS.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.20*entry.getValue(),16*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.KNOCKBACK.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.20*entry.getValue(),18*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.ARROW_KNOCKBACK.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.20*entry.getValue(),18*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.FIRE_ASPECT.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.22*entry.getValue(),20*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.ARROW_FIRE.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.22*entry.getValue(),20*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.WATER_WORKER.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.25*entry.getValue(),16*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.OXYGEN.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.30*entry.getValue(),20*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.DURABILITY.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.35*entry.getValue(),24*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.ARROW_INFINITE.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.40*entry.getValue(),40*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.LOOT_BONUS_MOBS.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.40*entry.getValue(),30*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.LOOT_BONUS_BLOCKS.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.50*entry.getValue(),40*Math.pow(entry.getValue(),2));
				}
				if (entry.getKey().getName()==Enchantment.SILK_TOUCH.getName()) {
					this.plugin.gainMoneyExp(p,"Enchanter",0.50*entry.getValue(),40*Math.pow(entry.getValue(),2));
				}
			}
		}
		
		/////////////////////////////////////////////finalitem contains the item with ALL enchantments that were added on.
		//Perform all maintenance operations below.
		
		
		if (this.plugin.hasJobBuff("Enchanter", p, Job.JOB30A)) {
			//Open up another inventory giving you the ability to choose an upgrade as well.
			//p.closeInventory();
			//Bukkit.getLogger().info("Final item: "+finalitem.toString());
			Inventory open = openBonusInventory(p, finalitem, e.getExpLevelCost());
			ItemMeta meta = e.getItem().getItemMeta();
			meta.setDisplayName(ChatColor.DARK_GRAY+""+ChatColor.ITALIC+"[Temporary Item]");
			e.getItem().setItemMeta(meta);
			if (open!=null) {
				p.openInventory(open);
			}
		}
		if (this.plugin.hasJobBuff("Enchanter", p, Job.JOB10)) {
			e.setExpLevelCost((int)(e.getExpLevelCost()*0.75));
		}
	}

    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent e) {
    	Player p = e.getPlayer();
    	if (e.getItem().getType() == Material.COOKED_CHICKEN && this.plugin.getConfig().getBoolean("thanksgiving-enabled")) {
    		p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 18000, 0), true);
    		p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 18000, 4), true);
    		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 18000, 2), true);
    		p.playSound(p.getLocation(), Sound.CHICKEN_IDLE, 0.9f, 1);
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
		
		//*************************//Job Buffies here.
		if (this.plugin.hasJobBuff("Builder", owner, Job.JOB20)) {
			if (e.getResult().getType()==Material.NETHER_BRICK_ITEM ||
					e.getResult().getType()==Material.GLASS ||
					e.getResult().getType()==Material.HARD_CLAY ||
					e.getResult().getType()==Material.BRICK) {
				ItemStack result = e.getResult();
				result.setAmount(result.getAmount()+1);
				e.setResult(result);
			}
		}
		if (this.plugin.hasJobBuff("Cook", owner, Job.JOB10)) {
			if (e.getResult().getType()==Material.COOKED_FISH ||
					e.getResult().getType()==Material.BAKED_POTATO ||
					e.getResult().getType()==Material.COOKED_CHICKEN ||
					e.getResult().getType()==Material.GRILLED_PORK ||
					e.getResult().getType()==Material.COOKED_BEEF) {
				List<String> lore = new ArrayList<String>();
				if (e.getResult().getItemMeta().hasLore()) {
					lore = e.getResult().getItemMeta().getLore();
				} else {
					lore.add("This food item was fabulously");
					lore.add("created by cook "+ChatColor.YELLOW+owner+",");
					lore.add("restoring more hunger and");
					lore.add("saturation than normal, and");
					lore.add("healing 1 Heart of health.");
				}
				ItemMeta meta = e.getResult().getItemMeta();
				meta.setLore(lore);
				ItemStack newstack = e.getResult();
				newstack.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
				newstack.setItemMeta(meta);
				e.setResult(newstack);
			}
		}
		if (hasJobBuff("Cook", owner, Job.JOB40)) {
			if (hasJobBuff("Cook", owner, Job.JOB30A)) {
				e.setResult(modifyFoodItem(e.getResult(),1,0,true));
			} else 
			if (hasJobBuff("Cook", owner, Job.JOB30B)) {
				e.setResult(modifyFoodItem(e.getResult(),0,3,true));
			}
			ItemStack oldamt = e.getResult();
			oldamt.setAmount(oldamt.getAmount()+1);
			e.setResult(oldamt);
		}
		else
		if (hasJobBuff("Cook", owner, Job.JOB30A) || hasJobBuff("Cook", owner, Job.JOB30B)) {
			if (hasJobBuff("Cook", owner, Job.JOB30A)) {
				e.setResult(modifyFoodItem(e.getResult(),1));
			} else {
				e.setResult(modifyFoodItem(e.getResult(),0,3));
			}
		} else
		if (hasJobBuff("Cook", owner, Job.JOB20)) {
			e.setResult(modifyFoodItem(e.getResult()));
		}
		//*************************//Not Job Buffies below.
		
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
			/*
			if (this.plugin.getJobLv("Cook", owner)>=20 && crafteditem) {
				ItemStack result = e.getResult();
				result.setAmount(result.getAmount()+1);
				e.setResult(result);
			}*/
		}
	}

	@EventHandler
	public void onCreatureInteract(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		//When right-clicked on, check if it already exists in the entity list.
		boolean contains=false;
		int slot=0;
		/*
		if (Math.random()<=0.5) {
			p.sendMessage("Using entity tele.");
			e.getRightClicked().teleport(p);
		} else {
			p.sendMessage("Using location tele.");
			e.getRightClicked().teleport(p.getLocation());
		}*/
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
			this.plugin.animallist.get(slot).setOwner(p.getName().toLowerCase());
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
							mobslist[i+1]=String.valueOf(Main.SERVER_TICK_TIME+5184000);
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
						this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+e.getRightClicked().getUniqueId()+","+(Main.SERVER_TICK_TIME+5184000)));
					} else {
						this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+","+e.getRightClicked().getUniqueId()+","+(Main.SERVER_TICK_TIME+5184000)));
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
							mobslist[i+1]=String.valueOf(Main.SERVER_TICK_TIME+5184000);
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
						this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+e.getRightClicked().getUniqueId()+","+(Main.SERVER_TICK_TIME+5184000)));
					} else {
						this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+","+e.getRightClicked().getUniqueId()+","+(Main.SERVER_TICK_TIME+5184000)));
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
							mobslist[i+1]=String.valueOf(Main.SERVER_TICK_TIME+5184000);
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
						this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+e.getRightClicked().getUniqueId()+","+(Main.SERVER_TICK_TIME+5184000)));
					} else {
						this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+","+e.getRightClicked().getUniqueId()+","+(Main.SERVER_TICK_TIME+5184000)));
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
							mobslist[i+1]=String.valueOf(Main.SERVER_TICK_TIME+5184000);
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
						this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+e.getRightClicked().getUniqueId()+","+(Main.SERVER_TICK_TIME+5184000)));
					} else {
						this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+","+e.getRightClicked().getUniqueId()+","+(Main.SERVER_TICK_TIME+5184000)));
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
							mobslist[i+1]=String.valueOf(Main.SERVER_TICK_TIME+5184000);
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
						this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+e.getRightClicked().getUniqueId()+","+(Main.SERVER_TICK_TIME+5184000)));
					} else {
						this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+","+e.getRightClicked().getUniqueId()+","+(Main.SERVER_TICK_TIME+5184000)));
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
							mobslist[i+1]=String.valueOf(Main.SERVER_TICK_TIME+5184000);
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
						this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+e.getRightClicked().getUniqueId()+","+(Main.SERVER_TICK_TIME+5184000)));
					} else {
						this.plugin.getConfig().set("fed.mobs", String.valueOf(this.plugin.getConfig().getString("fed.mobs")+","+e.getRightClicked().getUniqueId()+","+(Main.SERVER_TICK_TIME+5184000)));
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
	public void onEnemyTarget(EntityTargetLivingEntityEvent e) {
		if (e.getTarget() instanceof Player) {
			Player p = (Player)e.getTarget();
			if (Main.SERVER_TICK_TIME-this.plugin.getPlayerData(((Player)(e.getTarget()))).lastsneaktime<=60) {
				//Disallow it, since they are sneaking.
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onPlayerSneak(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		if (e.isSneaking()) {
			if (p.getInventory().getBoots() != null && p.getInventory().getBoots().hasItemMeta() && p.getInventory().getBoots().getItemMeta().getLore() != null) { // Screw null pointer exceptions
				for(String s : p.getInventory().getBoots().getItemMeta().getLore()) {
					// Check for hyper jump modifier (admins). If it exists, give Jump Boost X to player.
					if (s.contains(ChatColor.AQUA+"Hyper jump")) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 10));
					}
				}
			}
			if (this.plugin.hasJobBuff("Hunter", p, Job.JOB10)) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 9999999, 0, true));
				if (Main.SERVER_TICK_TIME-this.plugin.getPlayerData(p).lastsneaktime>60) {
					this.plugin.getPlayerData(p).lastsneaktime=Main.SERVER_TICK_TIME;
					  List<Entity> nearby = p.getNearbyEntities(20, 12, 20);
					  //List<Entity> nearby2 = p.getNearbyEntities(10, 6, 10);
					  for (int i=0;i<nearby.size();i++) {
						  //EntityType allowedtypes[] = {EntityType.BAT,EntityType.BLAZE,EntityType.CAVE_SPIDER,EntityType.ENDERMAN,EntityType.GHAST,EntityType.MAGMA_CUBE,EntityType.PIG_ZOMBIE,EntityType.SILVERFISH,EntityType.SLIME,EntityType.SPIDER,EntityType.ZOMBIE,EntityType.SKELETON,EntityType.CREEPER};
						  if (nearby.get(i) instanceof Monster) {
							  Monster m = (Monster)nearby.get(i);
							  if (m.getTarget() instanceof Player) {
								  if (this.plugin.hasJobBuff("Hunter",(Player)(m.getTarget()),Job.JOB10) && ((Player)(m.getTarget())).hasPotionEffect(PotionEffectType.INVISIBILITY)) {
									  //Respawn the mob.
									  m.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,60,6));
								  }
							  }
						  }
					  }
				}
			}
		} else {
			if (this.plugin.hasJobBuff("Hunter", p, Job.JOB10)) {
				if (p.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
					try {
						Collection<PotionEffect> effects = p.getActivePotionEffects();
						for (PotionEffect nextpotioneffect : effects) {
							if (nextpotioneffect.getType().getName().compareTo("INVISIBILITY")==0 && nextpotioneffect.getDuration()>24000) {
								//This is definitely not a potion given to you.
								p.removePotionEffect(PotionEffectType.INVISIBILITY);
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

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Team tempteam;
		//p.sendMessage("Roman numeral version of 64 is "+this.plugin.toRomanNumeral(64)+" and 193 is "+this.plugin.toRomanNumeral(193));
		//p.sendMessage("Numeric version of XXVII and DLXIX are "+this.plugin.toNumber("XXVII")+" and "+this.plugin.toNumber("DLXIX"));
		if (this.plugin.getConfig().getBoolean("halloween-enabled")) {
			Bukkit.getWorld("world").setDifficulty(Difficulty.EASY);
		} else {
			Bukkit.getWorld("world").setDifficulty(Difficulty.HARD);
		}
		if (p.getScoreboard().getTeam(p.getName().toLowerCase())!=null) {
			tempteam=p.getScoreboard().getTeam(p.getName().toLowerCase());
			tempteam.unregister();
		}
		tempteam=p.getScoreboard().registerNewTeam(p.getName().toLowerCase());
		if (p.hasPermission("group.moderator")) {
			tempteam.setPrefix(ChatColor.GREEN+"");
		}
		if (p.hasPermission("group.administrators")) {
			tempteam.setPrefix(ChatColor.LIGHT_PURPLE+"");
		}
		tempteam.setSuffix(healthbar(p.getHealth(),p.getMaxHealth(),p.getFoodLevel()));
		tempteam.addPlayer(p.getPlayer());
		/*
		if (this.plugin.getConfig().getBoolean("maintenance-mode") && !p.hasPermission("maintenance-mode")) {
			p.kickPlayer("Sorry, the server is currently under "+ChatColor.GREEN+" Maintenance Mode.");
			return;
		}*/
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
		/*if (p.getName().toLowerCase().equalsIgnoreCase("AaMay")) {
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
    bookdata.setAuthor("sigonasr2");f
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
			newplayer.setBaseSpd(newplayer.base_spdlv+1);
		}
		if (this.plugin.hasJobBuff("Hunter", p, Job.JOB20)) {
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
			if (name.compareToIgnoreCase(p.getName().toLowerCase())==0) {
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
		if (!this.plugin.getAccountsConfig().contains(p.getName().toLowerCase())) {
			//This is a brand new player.
			Main.economy.withdrawPlayer(p.getName().toLowerCase(), Main.economy.getBalance(p.getName().toLowerCase()));
			Main.economy.depositPlayer(p.getName().toLowerCase(), 70);
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".status", Boolean.valueOf(true));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".money", Double.valueOf(this.plugin.getConfig().getDouble("start-balance")));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".interestdistributedtime", Long.valueOf(Main.SERVER_TICK_TIME));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".revived", Boolean.valueOf(true));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".spleefrating", Double.valueOf(1000.0d));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".spleefwins", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".spleeflosses", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".jobs.job1", String.valueOf("None"));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".jobs.job1_30", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".jobs.job1lv", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".jobs.job1exp", Double.valueOf(0.0d));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".jobs.job2", String.valueOf("None"));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".jobs.job2_30", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".jobs.job2lv", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".jobs.job2exp", Double.valueOf(0.0d));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".jobs.job3", String.valueOf("None"));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".jobs.job3_30", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".jobs.job3lv", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".jobs.job3exp", Double.valueOf(0.0d));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".jobs.ultimate", String.valueOf("None"));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".jobs.ultimatesealed", Boolean.valueOf(false));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat1", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat2", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat3", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat4", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat5", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat6", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat7", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat8", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat9", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat10", Integer.valueOf(0));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".settings.notify1", Boolean.valueOf(true));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".settings.notify2", Boolean.valueOf(false));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".settings.notify3", Boolean.valueOf(true));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".settings.notify4", Boolean.valueOf(false));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".settings.notify5", Boolean.valueOf(false));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".settings.notify6", Boolean.valueOf(false));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest1", Boolean.valueOf(false));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest2", Boolean.valueOf(false));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest3", Boolean.valueOf(false));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest4", Boolean.valueOf(false));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest5", Boolean.valueOf(false));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest6", Boolean.valueOf(false));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest7", Boolean.valueOf(false));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest8", Boolean.valueOf(false));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest9", Boolean.valueOf(false));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest10", Boolean.valueOf(false));
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".bonus.witherskeleton", Integer.valueOf(0));
			//this.plugin.saveAccountsConfig();
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
			p.sendMessage(ChatColor.YELLOW+"Current Money Balance: $ "+df.format(Main.economy.bankBalance(p.getName().toLowerCase()).balance)+", Bank Balance: $"+df.format(this.plugin.getAccountsConfig().getDouble(p.getName().toLowerCase()+".money")));
			if (!this.plugin.getAccountsConfig().contains(p.getName().toLowerCase() + ".interestdistributedtime")) {
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".interestdistributedtime", Long.valueOf(Main.SERVER_TICK_TIME));
				//this.plugin.saveAccountsConfig();
			}
			//Update account information for the stat point update.
			if (!this.plugin.getAccountsConfig().contains(p.getName().toLowerCase() + ".jobs.job1_30")) {
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job1_30", Integer.valueOf(0));
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job2_30", Integer.valueOf(0));
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job3_30", Integer.valueOf(0));
				//this.plugin.saveAccountsConfig();
			}
			if (!this.plugin.getAccountsConfig().contains(p.getName().toLowerCase() + ".bonus.witherskeleton")) {
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".bonus.witherskeleton", Integer.valueOf(0));
				//this.plugin.saveAccountsConfig();
			}
			if (!this.plugin.getAccountsConfig().contains(p.getName().toLowerCase() + ".stats.stat1")) {
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat1", Integer.valueOf(0));
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat2", Integer.valueOf(0));
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat3", Integer.valueOf(0));
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat4", Integer.valueOf(0));
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat5", Integer.valueOf(0));
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat6", Integer.valueOf(0));
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat7", Integer.valueOf(0));
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat8", Integer.valueOf(0));
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat9", Integer.valueOf(0));
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".stats.stat10", Integer.valueOf(0));
				//this.plugin.saveAccountsConfig();
				System.out.println("Updated " + p.getName() + "'s data with stat point update.");
			}
			//Update account information for notification settings.
			if (!this.plugin.getAccountsConfig().contains(p.getName().toLowerCase() + ".settings.notify1")) {
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".settings.notify1", Boolean.valueOf(true));
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".settings.notify2", Boolean.valueOf(false));
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".settings.notify3", Boolean.valueOf(true));
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".settings.notify4", Boolean.valueOf(false));
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".settings.notify5", Boolean.valueOf(false));
				this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".settings.notify6", Boolean.valueOf(false));
				//this.plugin.saveAccountsConfig();
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
					if (!this.plugin.getAccountsConfig().contains(p.getName().toLowerCase() + ".join.halloween_book")) {
						this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".join.halloween_book", Boolean.valueOf(true));
						//this.plugin.saveAccountsConfig();
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
					if (!this.plugin.getAccountsConfig().contains(p.getName().toLowerCase() + ".join.halloween_vote_signs")) {
						this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".join.halloween_vote_signs", Boolean.valueOf(true));
						//this.plugin.saveAccountsConfig();
						ItemStack sign = new ItemStack(Material.SIGN,2);
						ItemMeta meta = sign.getItemMeta();
						meta.setDisplayName(ChatColor.BLUE+p.getName());
						sign.setItemMeta(meta);
						p.getInventory().addItem(sign);
						p.sendMessage("You have received 2 vote signs. Go vote at the Pumpkin Patch for the best pumpkin! (Note that voting for yourself does not count. Please vote the best of the others' pumpkins.)");
					}
				} else {
					if (!this.plugin.getAccountsConfig().contains(p.getName().toLowerCase() + ".join.halloween_vote_signs")) {
						p.sendMessage("You do not have enough room in your inventory to receive Pumpkin vote signs. Clear some of your inventory and then rejoin.");
					}
				}
				if (!this.plugin.getAccountsConfig().contains(p.getName().toLowerCase() + ".halloween.chest1")) {
					this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest1", Boolean.valueOf(false));
					this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest2", Boolean.valueOf(false));
					this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest3", Boolean.valueOf(false));
					this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest4", Boolean.valueOf(false));
					this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest5", Boolean.valueOf(false));
					this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest6", Boolean.valueOf(false));
					this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest7", Boolean.valueOf(false));
					this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest8", Boolean.valueOf(false));
					this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest9", Boolean.valueOf(false));
					this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.chest10", Boolean.valueOf(false));
					//this.plugin.saveAccountsConfig();
				}
				if (!this.plugin.getAccountsConfig().contains(p.getName().toLowerCase() + ".jobs.ultimate")) {
					this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".jobs.ultimate", String.valueOf("None"));
					this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".jobs.ultimatesealed", Boolean.valueOf(false));
					//this.plugin.saveAccountsConfig();
				}
				if (!this.plugin.getAccountsConfig().contains(p.getName().toLowerCase() + ".halloween.wand")) {
					this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".halloween.wand", Long.valueOf(Main.SERVER_TICK_TIME));
					//this.plugin.saveAccountsConfig();
				}
			}
			//Check if this player has unallocated stat points.
			if (this.plugin.getStatPointTotal(p)<this.plugin.getJobTotalLvs(p)/5+1) {
				p.sendMessage(ChatColor.GOLD+"");
				p.sendMessage(ChatColor.GOLD+""+ChatColor.ITALIC+"You have "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" unused stat points! "+ChatColor.AQUA+"Type "+ChatColor.BOLD+"/sp"+ChatColor.RESET+ChatColor.AQUA+" to use them.");
				p.sendMessage(ChatColor.GOLD+"");
			}
			//Set Stat Point specific stuff here.
			if (this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase() + ".stats.stat10")>0) {
				p.setMaximumAir(300+this.plugin.getStatBonus(9, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase() + ".stats.stat10"))*20);
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
		this.plugin.notifyBuffMessages(p);
		boolean found=false;
		for (int i=0;i<this.plugin.playerdata_list.size();i++) {
			if (this.plugin.playerdata_list.get(i).data.getName().compareToIgnoreCase(p.getName().toLowerCase())==0) {
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
			this.plugin.explorerlist.add(new ExplorerData(p.getName().toLowerCase(), p.getLocation().getX(), p.getLocation().getZ()));
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
				//Bukkit.getLogger().info(p.getName().toLowerCase()+" w/buff "+nexteffect.getType().getName()+" for "+nexteffect.getDuration()/20+" sec.");
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
		if (ev.getPlayer().getItemInHand().getType()==Material.getMaterial(127)) {
			if (this.plugin.getAccountsConfig().getLong(ev.getPlayer().getName()+".halloween.wand")<Main.SERVER_TICK_TIME)
				if (theAnimal.getType()!=EntityType.PLAYER) {
					if (theAnimal instanceof LivingEntity) {
						LivingEntity l = (LivingEntity)theAnimal;
						if (l.getType()!=EntityType.ENDER_DRAGON && l.getType()!=EntityType.WITHER) {
							if (l.getCustomName()==null) {
								//This is not a boss. Convert it to something else.
								Location oldloc = theAnimal.getLocation();
								EntityType newtype = null;
								theAnimal.remove();
								EntityType types[] = {EntityType.ZOMBIE,
										EntityType.CHICKEN,
										EntityType.COW,
										EntityType.CREEPER,
										EntityType.ENDERMAN,
										EntityType.GIANT,
										EntityType.HORSE,
										EntityType.IRON_GOLEM,
										EntityType.MUSHROOM_COW,
										EntityType.OCELOT,
										EntityType.PIG,
										EntityType.PIG_ZOMBIE,
										EntityType.SHEEP,
										EntityType.SILVERFISH,
										EntityType.SKELETON,
										EntityType.SPIDER,
										EntityType.SNOWMAN,
										EntityType.SQUID,
										EntityType.VILLAGER,
										EntityType.WITCH,
										EntityType.WOLF};
								World world = Bukkit.getWorld("world");
								Entity newAnimal = world.spawnEntity(oldloc, types[(int)(Math.random()*types.length)]);
								if (newAnimal instanceof LivingEntity) {
									LivingEntity l2 = (LivingEntity)newAnimal;
									l2.setRemoveWhenFarAway(false);
									l2.setCustomName(ChatColor.DARK_AQUA+"Polymorphed Creature");
									this.plugin.POLYMORPH=10;
									this.plugin.POLYMORPH_LOC=l2.getLocation();
								}
								this.plugin.getAccountsConfig().set(ev.getPlayer().getName()+".halloween.wand",Long.valueOf(Main.SERVER_TICK_TIME+1200));
							} else {
								if (!l.getCustomName().contains(ChatColor.DARK_PURPLE+"")) {
									//This is not a boss. Convert it to something else.
									Location oldloc = theAnimal.getLocation();
									EntityType newtype = null;
									theAnimal.remove();
									EntityType types[] = {EntityType.ZOMBIE,
											EntityType.CHICKEN,
											EntityType.COW,
											EntityType.CREEPER,
											EntityType.ENDERMAN,
											EntityType.GIANT,
											EntityType.HORSE,
											EntityType.IRON_GOLEM,
											EntityType.MUSHROOM_COW,
											EntityType.OCELOT,
											EntityType.PIG,
											EntityType.PIG_ZOMBIE,
											EntityType.SHEEP,
											EntityType.SILVERFISH,
											EntityType.SKELETON,
											EntityType.SPIDER,
											EntityType.SNOWMAN,
											EntityType.SQUID,
											EntityType.VILLAGER,
											EntityType.WITCH,
											EntityType.WOLF};
									World world = Bukkit.getWorld("world");
									Entity newAnimal = world.spawnEntity(oldloc, types[(int)(Math.random()*types.length)]);
									if (newAnimal instanceof LivingEntity) {
										LivingEntity l2 = (LivingEntity)newAnimal;
										l2.setRemoveWhenFarAway(false);
										l2.setCustomName(ChatColor.DARK_AQUA+"Polymorphed Creature");
										this.plugin.POLYMORPH=10;
										this.plugin.POLYMORPH_LOC=l2.getLocation();
									}
									this.plugin.getAccountsConfig().set(ev.getPlayer().getName()+".halloween.wand",Long.valueOf(Main.SERVER_TICK_TIME+1200));
								}
							}
						}
					}
				}
		} else {
			//Make sure we're not polymorphing, otherwise do other things in here.
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
				newdog.setHealth(Warning(oldhealth,21));
				newdog.setSitting(true);
				newdog.setCollarColor(dogcolor);
				p.sendMessage(ChatColor.GREEN + "This dog is now happy!");
			}
		}
	}

	public double Warning(LivingEntity l,int id) {
		return this.plugin.Warning(l, id);
	}

	public double Warning(double hp,int id) {
		if (hp>65) {
			//Bukkit.broadcastMessage("PlayerListener: HP too high for ID "+id+". HP was "+hp);
		}
		return hp;
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

	public boolean isPermanentSpawn(CreatureSpawnEvent e, LivingEntity l) {
		//Will return true if it's something that is not allowed to despawn. False if we are allowed to get rid of it.
		//Basically this is the control that will determine if the mob stays or goes, before further processing is done.
		//If the mob is identified as a special mob...
		EntityType type = l.getType();

		//heightmodifier determines if it's a super tall chunk or a normal sized one.
		int heightmodifier=0;
		if (Bukkit.getWorld("world").getHighestBlockYAt(l.getLocation())>=96) {
			heightmodifier=126;
		} else {
			heightmodifier=63;
		}

		//Handle every special entity's spawning properties in here.
		switch (type) {
		case CREEPER:{
			if (l.getLocation().getY()<=40 && Math.random()<=0.08+((heightmodifier-l.getLocation().getY())*0.01d)) {
				if (Math.random()<=0.35) {
					l.setCustomName(ChatColor.YELLOW+"Explosive Creeper");
					l.setCustomNameVisible(false);
					//l.setCustomNameVisible(true);
					l.setMaxHealth(l.getMaxHealth()*1.25d);
					l.setHealth(l.getMaxHealth());
				} else
					if (Math.random()<=0.15) {
						l.setCustomName(ChatColor.GOLD+"Explosive Creeper II");
						l.setCustomNameVisible(false);
						//l.setCustomNameVisible(true);
						l.setMaxHealth(l.getMaxHealth()*1.75d);
						l.setHealth(l.getMaxHealth());
					} else
						if (Math.random()<=0.35) {
							l.setCustomName(ChatColor.YELLOW+"Destructive Creeper");
							l.setCustomNameVisible(false);
							//l.setCustomNameVisible(true);
							l.setMaxHealth(l.getMaxHealth()*1.25d);
							l.setHealth(l.getMaxHealth());
						} else {
							l.setCustomName(ChatColor.GOLD+"Destructive Creeper II");
							l.setCustomNameVisible(false);
							//l.setCustomNameVisible(true);
							l.setMaxHealth(l.getMaxHealth()*1.75d);
							l.setHealth(l.getMaxHealth());
						}
			}
		}break;
		case ARROW: {
		}break;
		case BAT: {
		}break;
		case BLAZE: {
		}break;
		case BOAT: {
		}break;
		case CAVE_SPIDER: {
		}break;
		case CHICKEN: {
		}break;
		case COMPLEX_PART: {
		}break;
		case COW: {
		}break;
		case DROPPED_ITEM: {
		}break;
		case EGG: {
		}break;
		case ENDERMAN: {
		}break;
		case ENDER_CRYSTAL: {
		}break;
		case ENDER_DRAGON: {
		}break;
		case ENDER_PEARL: {
		}break;
		case ENDER_SIGNAL: {
		}break;
		case EXPERIENCE_ORB: {
		}break;
		case FALLING_BLOCK: {
		}break;
		case FIREBALL: {
		}break;
		case FIREWORK: {
		}break;
		case FISHING_HOOK: {
		}break;
		case GHAST: {
		}break;
		case GIANT: {
		}break;
		case HORSE: {
		}break;
		case IRON_GOLEM: {
		}break;
		case ITEM_FRAME: {
		}break;
		case LEASH_HITCH: {
		}break;
		case LIGHTNING: {
		}break;
		case MAGMA_CUBE: {
		}break;
		case MINECART: {
		}break;
		case MINECART_CHEST: {
		}break;
		case MINECART_FURNACE: {
		}break;
		case MINECART_HOPPER: {
		}break;
		case MINECART_MOB_SPAWNER: {
		}break;
		case MINECART_TNT: {
		}break;
		case MUSHROOM_COW: {
		}break;
		case OCELOT: {
		}break;
		case PAINTING: {
		}break;
		case PIG: {
		}break;
		case PIG_ZOMBIE: {
		}break;
		case PLAYER: {
		}break;
		case PRIMED_TNT: {
		}break;
		case SHEEP: {
		}break;
		case SILVERFISH: {
		}break;
		case SKELETON: {
			if (Math.random()<=0.10+((heightmodifier-l.getLocation().getY())*0.01d)) {
				if (Math.random()<=0.85) {
					l.setCustomName(ChatColor.YELLOW+"Sniper");
					l.setCustomNameVisible(false);
					//l.setCustomNameVisible(true);
					l.setMaxHealth(l.getMaxHealth()/2);
					l.setHealth(l.getMaxHealth());
				} else {
					l.setCustomName(ChatColor.GOLD+"Sniper II");
					l.setCustomNameVisible(false);
					//l.setCustomNameVisible(true);
					l.setMaxHealth(l.getMaxHealth()/4);
					l.setHealth(l.getMaxHealth());
				}
			}
			if (Math.random()<=0.003 && l.getLocation().getY()>=60) {
				Skeleton s = (Skeleton)l;
				s.setSkeletonType(SkeletonType.WITHER);
				s.setMaxHealth(150);
				s.setHealth(s.getMaxHealth());

				ItemStack sword = new ItemStack(Material.STONE_SWORD);
				  sword.addEnchantment(Enchantment.DAMAGE_ALL, (int)(Math.random() * 3) + 2);
				  sword.addEnchantment(Enchantment.KNOCKBACK, (int)(Math.random()) + 1);
				  sword.addEnchantment(Enchantment.FIRE_ASPECT, (int)(Math.random()) + 1);

				s.getEquipment().setItemInHand(sword);
			}
		}break;
		case SLIME: {
		}break;
		case SMALL_FIREBALL: {
		}break;
		case SNOWBALL: {
		}break;
		case SNOWMAN: {
		}break;
		case SPIDER: {
			if (Math.random()<=0.08+((heightmodifier-l.getLocation().getY())*0.01d)) {
				if (Math.random()<=0.35) {
					l.setCustomName(ChatColor.YELLOW+"Venomous Spider");
					l.setCustomNameVisible(false);
					//l.setCustomNameVisible(true);
					l.setMaxHealth(l.getMaxHealth());
					l.setHealth(l.getMaxHealth());
				} else
					if (Math.random()<=0.15) {
						l.setCustomName(ChatColor.GOLD+"Venomous Spider II");
						l.setCustomNameVisible(false);
						//l.setCustomNameVisible(true);
						l.setMaxHealth(l.getMaxHealth()*1.5);
						l.setHealth(l.getMaxHealth());
					} else
						if (Math.random()<=0.35) {
							l.setCustomName(ChatColor.YELLOW+"Snaring Spider");
							l.setCustomNameVisible(false);
							//l.setCustomNameVisible(true);
							l.setMaxHealth(l.getMaxHealth()*1.5);
							l.setHealth(l.getMaxHealth());
						} else {
							l.setCustomName(ChatColor.GOLD+"Snaring Spider II");
							l.setCustomNameVisible(false);
							//l.setCustomNameVisible(true);
							l.setMaxHealth(l.getMaxHealth()*2);
							l.setHealth(l.getMaxHealth());
						}
			}
		}break;
		case SPLASH_POTION: {
		}break;
		case SQUID: {
		}break;
		case THROWN_EXP_BOTTLE: {
		}break;
		case UNKNOWN: {
		}break;
		case VILLAGER: {
		}break;
		case WEATHER: {
		}break;
		case WITCH: {
		}break;
		case WITHER: {
		}break;
		case WITHER_SKULL: {
		}break;
		case WOLF: {
		}break;
		case ZOMBIE: {
			if (l.getHealth()<65) {
				if (l.getLocation().getY()<=35 && Math.random()<=0.15) {
					if (Math.random()<=0.85) {
						l.setCustomName(ChatColor.YELLOW+"Charge Zombie");
						l.setCustomNameVisible(false);
						//l.setCustomNameVisible(true);
						l.setMaxHealth(l.getMaxHealth()+5);
						l.setHealth(l.getMaxHealth());
					} else {
						l.setCustomName(ChatColor.GOLD+"Charge Zombie II");
						l.setCustomNameVisible(false);
						//l.setCustomNameVisible(true);
						l.setMaxHealth(l.getMaxHealth()+20);
						l.setHealth(l.getMaxHealth());
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
							l.setMaxHealth(l.getMaxHealth()*0.65d);
							l.setHealth(l.getMaxHealth());
						}
					}
				}
			} else {
				if (l.getCustomName()!=null && !l.getCustomName().contains(ChatColor.DARK_PURPLE+"")) { //Make sure it's not a boss.
					return false;
				}
			}
			//If it's a super zombie, we're going to despawn it now.
		}break;
		default: {
		}
		}

		//This allows bosses to spawn.
		if (e.getEntity().getType()==EntityType.ENDER_DRAGON || e.getEntity().getType()==EntityType.WITHER ||
				e.getEntity() instanceof Golem || e.getEntity() instanceof Animals) {
			return true;
		}

		//Custom bosses
		if (l.getCustomName()!=null && (l.getCustomName().contains(ChatColor.DARK_PURPLE+"") || l.getCustomName().contains(ChatColor.DARK_AQUA+"Polymorphed Creature"))) {
			return true;
		}

		//Special reasons that should always happen.
		if (e.getSpawnReason()==SpawnReason.SPAWNER || e.getSpawnReason()==SpawnReason.BUILD_IRONGOLEM || e.getSpawnReason()==SpawnReason.BREEDING ||
				e.getSpawnReason()==SpawnReason.BUILD_SNOWMAN || e.getSpawnReason()==SpawnReason.BUILD_WITHER || e.getSpawnReason()==SpawnReason.LIGHTNING ||
				e.getSpawnReason()==SpawnReason.SPAWNER_EGG || e.getSpawnReason()==SpawnReason.VILLAGE_DEFENSE || e.getSpawnReason()==SpawnReason.VILLAGE_INVASION ||
				e.getSpawnReason()==SpawnReason.CUSTOM) {
			return true;
		}

		return false; //If we got down to here, allow this particular mob to spawn.

	}

	@EventHandler
	public void onCreatureTeleport(final EntityTeleportEvent e) {
		if (e.getEntity() instanceof Enderman) {
			LivingEntity l = (LivingEntity)e.getEntity();
			if (l.getCustomName()!=null && l.getCustomName().equalsIgnoreCase(ChatColor.RED+"Fish Caller")) {
				//Spawn Silverfish in the vicinity of where it teleported from.
				int trials=9;
				boolean playernearby=false;
				for (int i=0;i<Bukkit.getOnlinePlayers().length;i++) {
					Player p = Bukkit.getOnlinePlayers()[i];
					if (p.getLocation().distanceSquared(e.getFrom())<400) {
						playernearby=true;
						break;
					}
				}
				//Bukkit.getLogger().info("Teleport from "+e.getFrom().toString()+", to "+e.getTo().toString());
				final Location randloc = e.getFrom();
				randloc.setX(randloc.getX()+Math.random()*3-Math.random()*3);
				randloc.setY(randloc.getY()+Math.random()*6+2);
				randloc.setZ(randloc.getZ()+Math.random()*3-Math.random()*3);
				//Bukkit.getLogger().info("Set a new teleport area: "+randloc);
				while (playernearby && trials>0) {
					if (randloc.getBlock().getType()==Material.AIR) {
						e.getEntity().getWorld().spawnEntity(randloc, EntityType.SILVERFISH);
					}
					trials--;
				}
			}
		}
	}

	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e) {
		if (isPermanentSpawn(e, e.getEntity())) {
			e.getEntity().setRemoveWhenFarAway(false);
			//If this is a boss that spawns from a command block, make sure the command blocks are removed.
			if (e.getEntity().getCustomName()!=null && (e.getEntity().getCustomName().contains(ChatColor.DARK_PURPLE+"") || e.getEntity().getCustomName().contains(ChatColor.DARK_AQUA+"Polymorphed Creature"))) {
				for (int i=-2;i<3;i++) {
					for (int j=-2;j<3;j++) {
						for (int k=-2;k<3;k++) {
							if (Bukkit.getWorld("world").getBlockAt(e.getEntity().getLocation().add(i,j,k)).getType()==Material.COMMAND) {
								Bukkit.getWorld("world").getBlockAt(e.getEntity().getLocation().add(i,j,k)).setType(Material.COBBLESTONE);
							}
						}
					}
				}
			}

			//Give the wither bonuses.
			if (e.getEntity() instanceof Wither) {
				Wither w = (Wither)e.getEntity();
				if (Math.random()<=0.05) {
					w.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,999999,3));
					w.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,999999,3));
					w.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,999999,3));
					w.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,999999,40));
					w.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,999999,2));
					w.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,999999,1));
					w.setCustomName(ChatColor.GOLD+""+ChatColor.LIGHT_PURPLE+"Mythical Wither");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule mobGriefing true");
				} else {
					w.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,999999,3));
					w.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,999999,3));
					w.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,999999,3));
					w.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,999999,40));
					w.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,999999,2));
					w.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,999999,1));
					w.setCustomName(ChatColor.GOLD+""+ChatColor.BOLD+"Mega Wither");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule mobGriefing true");
				}
			}

		} else {
			float groupmult=1.0f; //Change this to modify the global grouping multiplier.
			int maxgroup=(int)(10*groupmult);
			double chancer=0.10d;
			double despawnchancer=0.25d;

			if (e.getEntity().getHealth()>65 /*Meaning it's not a special mob.*/) {
				e.getEntity().remove(); //Too much HP. Nothing should have this much.
				return;
			}

			boolean allow=false; //If this is set to true, it will not be marked for removal.

			//We will now determine if it is allowed to spawn due to being next to a boss or mob spawner.
			List<Entity> entities = e.getEntity().getWorld().getEntities();
			for (int i=0;i<entities.size();i++) {
				if (entities.get(i) instanceof LivingEntity) {
					LivingEntity l = (LivingEntity)entities.get(i);
					if (l.getCustomName()!=null && l.getCustomName().contains(ChatColor.DARK_PURPLE+"") && l.getLocation().distance(e.getEntity().getLocation())<10) {
						//Allow it to spawn. It's next to a boss.
						allow=true;
					}
				}
			}

			//Get the torches/glowstone/mob spawners around this e.getEntity().
			int torches=0,glowstone=0,spawners=0;
			for (int x=-5;x<5;x++) {
				for (int y=-5;y<5;y++) {
					for (int z=-5;z<5;z++) {
						Block test = e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation().add(x,y,z));
						if (test!=null) {
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
			}

			//Decrease spawn rate the higher up we are in our world.
			if (Bukkit.getWorld("world").getHighestBlockYAt(e.getEntity().getLocation())>=96) {
				//This is a tall world.
				if (e.getEntity().getLocation().getBlockY()<=104) {
					for (int i=104-e.getEntity().getLocation().getBlockY();i>0;i--) {
						despawnchancer/=1.0175d;
					}
				}
			} else {
				//This is a short world.
				if (e.getEntity().getLocation().getBlockY()<=52) {
					for (int i=52-e.getEntity().getLocation().getBlockY();i>0;i--) {
						despawnchancer/=1.025d;
					}
				}
			}

			if (spawners==0 && (Math.random()<=despawnchancer || (torches+glowstone>=3))) {
				allow=false;
			} else {
				allow=true;
			}


			int totallvs=0;
			List<Entity> nearbylist = e.getEntity().getNearbyEntities(30, 30, 30);
			//Filter out all unrelated e.getEntity() types.
			for (int k=0;k<nearbylist.size();k++) {
				//See if human players are near. If so, factor that in for determining how many mobs may exist.
				if (nearbylist.get(k).getType()==EntityType.PLAYER) {
					//This is a player.
					Player g = (Player)nearbylist.get(k);
					maxgroup+=plugin.getJobTotalLvs(g)/10;
					totallvs+=plugin.getJobTotalLvs(g);
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
			if (currentnearby>maxgroup) {
				allow=false; //Too many mobs, can't have more.
			}

			if (!allow) {
				//This is our chance to despawn it if we must.
				e.getEntity().remove();
			} else {
				//They will be allowed to spawn. Increase their base HP.
				e.getEntity().setMaxHealth(e.getEntity().getMaxHealth()*1.15d);
				e.getEntity().setHealth(e.getEntity().getMaxHealth());


				if (e.getEntity().getCustomName()!=null && e.getEntity().getCustomName().equals(ChatColor.GOLD+"Charge Zombie II")) {
					//Destroy an area around itself.
					//Check air density. Please.
	    			int airmeasure=0;
	    			//Get the underground chunk density of this chunk.
	    			//Max chunk density is 12800.
	    			Chunk c = e.getEntity().getWorld().getChunkAt(e.getEntity().getLocation());
	    			for (int x=0;x<16;x++) {
	        			for (int y=0;y<50;y++) {
	            			for (int z=0;z<16;z++) {
	            				if (c.getBlock(x, y, z).getType()==Material.AIR) {
	            					airmeasure++;
	            				}
	            			}
	        			}
	    			}
	    			if (((double)airmeasure/12800)*100.0d<=6.5) {
						int size=((int)(Math.random()*5))+1;
						for (int k=-size;k<size;k++) {
							for (int j=-size;j<size;j++) {
								for (int m=-1;m<size/2;m++) {
									if (Math.random()<=1.00-((m+4)*0.05d)) {
										Location checkloc = e.getEntity().getLocation().add(k,m,j);
										Block bl = Bukkit.getWorld("world").getBlockAt(checkloc);
										if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER && bl.getType()!=Material.COMMAND && bl.getType()!=Material.MOSSY_COBBLESTONE && naturalBlock(bl.getType())) {
											//bl.setType(Material.AIR);
										}
									}
								}
							}
						}
	    			}
				}


				if (e.getEntity().getType()==EntityType.ZOMBIE || e.getEntity().getType()==EntityType.PIG_ZOMBIE || e.getEntity().getType()==EntityType.SKELETON) {
					//Modify the difficulty of the mobs based on who is around.
					EntityEquipment inven = e.getEntity().getEquipment();
					if (inven!=null) {
						inven.setBootsDropChance(0.08f);
						inven.setChestplateDropChance(0.08f);
						inven.setLeggingsDropChance(0.08f);
						inven.setHelmetDropChance(0.08f);
						inven.setItemInHandDropChance(0.002f);
						if (e.getEntity().getType()==EntityType.SKELETON) {
							Skeleton sk = (Skeleton)e.getEntity();
							if (sk.getSkeletonType()==SkeletonType.WITHER && Math.random()<=0.8) {
								e.getEntity().setMaxHealth(80);
								e.getEntity().setHealth(sk.getMaxHealth());
								inven.setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
							} else {
								if (Math.random()<=0.8) {
									inven.setItemInHand(new ItemStack(Material.BOW));
								} else {
									inven.setItemInHand(new ItemStack(Material.STONE_SWORD));
								}
							}
						}
					}

					double levelsmult=1.0;
					
					/*double COUNTER_SLIME_SPAWN_RATE = 0.04,
							VIRAL_SPIDER_SPAWN_RATE = 0.02,
							SILENCER_SPAWN_RATE = 0.02,
							HOUND_CALLER_SPAWN_RATE = 0.01,
							FISH_CALLER_SPAWN_RATE = 0.04,
							SUICIDAL_CREEPER_SPAWN_RATE = 0.05,
							POWER_SURGE_ZOMBIE_SPAWN_RATE = 0.02,
							LIGHTNING_MAGE_SPAWN_RATE = 0.04;*/
					
					double COUNTER_SLIME_SPAWN_RATE = 0,
							VIRAL_SPIDER_SPAWN_RATE = 0,
							SILENCER_SPAWN_RATE = 0,
							HOUND_CALLER_SPAWN_RATE = 0,
							FISH_CALLER_SPAWN_RATE = 0,
							SUICIDAL_CREEPER_SPAWN_RATE = 0,
							POWER_SURGE_ZOMBIE_SPAWN_RATE = 0,
							LIGHTNING_MAGE_SPAWN_RATE = 0;
					
					if (totallvs>60*levelsmult && e.getEntity().getLocation().getY()<50 && e.getEntity().getWorld().getName().equalsIgnoreCase("world")) {
						//Try to spawn a counter slime.
						if (Math.random()<=COUNTER_SLIME_SPAWN_RATE) {
							Entity entity = e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.SLIME);
							Slime s = (Slime)entity;
							//Bukkit.getLogger().info("Counter Slime spawned at "+s.getLocation().toString());
							s.setSize((int)(Math.random()*3)+2);
							LivingEntity l = (LivingEntity)entity;
							l.setCustomName(ChatColor.RED+"Counter Slime");
							l.setCustomNameVisible(false);
							l.setMaxHealth(35);
							l.setHealth(35);
							l.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 3));
						}
					}
					if (totallvs>120*levelsmult && e.getEntity().getWorld().getName().equalsIgnoreCase("world")) {
						//Try to spawn a Viral Spider.
						if (Math.random()<=VIRAL_SPIDER_SPAWN_RATE) {
							Entity entity = e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.SPIDER);
							LivingEntity l = (LivingEntity)entity;
							l.setCustomName(ChatColor.RED+"Viral Spider");
							l.setCustomNameVisible(false);
							//Bukkit.getLogger().info("Viral Spider spawned at "+l.getLocation().toString());
							l.setMaxHealth(85);
							l.setHealth(85);
							l.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 3));
						}
					}
					if (totallvs>120*levelsmult && e.getEntity().getWorld().getName().equalsIgnoreCase("world")) {
						//Try to spawn a Silencer.
						if (Math.random()<=SILENCER_SPAWN_RATE) {
							Entity entity = e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.SKELETON);
							LivingEntity l = (LivingEntity)entity;
							l.setCustomName(ChatColor.RED+"Silencer");
							l.setCustomNameVisible(false);
							//Bukkit.getLogger().info("Silencer spawned at "+l.getLocation().toString());
							l.setMaxHealth(45);
							l.setHealth(45);
							ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
							helm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 32);
							l.getEquipment().setHelmet(helm);
							l.getEquipment().setHelmetDropChance(0.002f);
							l.getEquipment().setItemInHand(new ItemStack(Material.BOW));
							l.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 3));
						}
					}
					/*
					if (totallvs>120*levelsmult && e.getEntity().getLocation().getY()>=63) {
						//Try to spawn a Hound Caller.
						if (Math.random()<=HOUND_CALLER_SPAWN_RATE) {
							Entity entity = e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.WOLF);
							LivingEntity l = (LivingEntity)entity;
							l.setCustomName(ChatColor.RED+"Hound Caller");
							l.setCustomNameVisible(false);
							//Bukkit.getLogger().info("Hound Caller spawned at "+l.getLocation().toString());
							l.setMaxHealth(65);
							l.setHealth(65);
							Wolf w = (Wolf)l;
							//helm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 32);
							//l.getEquipment().setHelmet(helm);
							//l.getEquipment().setHelmetDropChance(0.002f);
							//l.getEquipment().setItemInHand(new ItemStack(Material.BOW));
							//w.setAngry(true);
							w.setAdult();
							l.setRemoveWhenFarAway(true);
							l.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 3));
							l.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 1));
							l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999, 2));
							l.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0));
						}
					}*/
					if (totallvs>60*levelsmult && e.getEntity().getWorld().getName().equalsIgnoreCase("world")) {
						//Try to spawn a Fish Caller.
						if (Math.random()<=FISH_CALLER_SPAWN_RATE) {
							Entity entity = e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ENDERMAN);
							LivingEntity l = (LivingEntity)entity;
							l.setCustomName(ChatColor.RED+"Fish Caller");
							l.setCustomNameVisible(false);
							//Bukkit.getLogger().info("Hound Caller spawned at "+l.getLocation().toString());
							l.setMaxHealth(50);
							l.setHealth(50);
							Enderman end = (Enderman)l;
							//helm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 32);
							//l.getEquipment().setHelmet(helm);
							//l.getEquipment().setHelmetDropChance(0.002f);
							//l.getEquipment().setItemInHand(new ItemStack(Material.BOW));
							//w.setAngry(true);
							l.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 5));
							l.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 1));
							l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999, 1));
						}
					}
					boolean haslineofsight=false;
					for (int i=0;i<Bukkit.getOnlinePlayers().length;i++) {
						if (e.getEntity().hasLineOfSight(Bukkit.getOnlinePlayers()[i])) {
							haslineofsight=true;
							break;
						}
					}
					if (totallvs>90*levelsmult && !haslineofsight && e.getEntity().getWorld().getName().equalsIgnoreCase("world")) {
						//Try to spawn a Suicidal Creeper.
						if (Math.random()<=SUICIDAL_CREEPER_SPAWN_RATE) {
							Location ent = e.getEntity().getLocation();
							Entity entity = e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.CREEPER);
							LivingEntity l = (LivingEntity)entity;
							l.setCustomName(ChatColor.RED+"Suicidal Creeper");
							l.setCustomNameVisible(false);
							//Bukkit.getLogger().info("Suicidal Creeper spawned at "+l.getLocation().toString());
							l.setMaxHealth(5);
							l.setHealth(5);
							Creeper creep = (Creeper)l;
							creep.setPowered(true);
							l.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 3));
							l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999, 2));
							l.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 4));
							l.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 0));
						}
					}
					if (totallvs>180*levelsmult && e.getEntity().getWorld().getName().equalsIgnoreCase("world")) {
						//Try to spawn a Powersurge Zombie.
						if (Math.random()<=POWER_SURGE_ZOMBIE_SPAWN_RATE) {
							Location ent = e.getEntity().getLocation();
							Entity entity = e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ZOMBIE);
							LivingEntity l = (LivingEntity)entity;
							l.setCustomName(ChatColor.RED+"Powersurge Zombie");
							l.setCustomNameVisible(false);
							//Bukkit.getLogger().info("Suicidal Creeper spawned at "+l.getLocation().toString());
							l.setMaxHealth(60);
							l.setHealth(60);
							l.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 3));
							l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999, 2));
							l.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0));
						}
					}
					if (totallvs>60*levelsmult && e.getEntity().getWorld().getName().equalsIgnoreCase("world")) {
						//Try to spawn a Lightning Mage.
						if (Math.random()<=LIGHTNING_MAGE_SPAWN_RATE) {
							Location ent = e.getEntity().getLocation();
							Entity entity = e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ENDERMAN);
							LivingEntity l = (LivingEntity)entity;
							l.setCustomName(ChatColor.RED+"Lightning Mage");
							l.setCustomNameVisible(false);
							//Bukkit.getLogger().info("Suicidal Creeper spawned at "+l.getLocation().toString());
							l.setMaxHealth(105);
							l.setHealth(105);
							l.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 4));
							l.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 5));
							l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999, 1));
						}
					}
					
					
					
					if (totallvs>20*levelsmult) {
						if (totallvs<40*levelsmult) {
							//Can't have baby zombies at this level.
							if (e.getEntity().getType()==EntityType.ZOMBIE) {
								Zombie z = (Zombie)e.getEntity();
								if (z.isBaby() && e.getEntity().getCustomName()==null) {
									z.setBaby(false);
								}
							}
							//Sometimes wear leather armor. Only for Skeletons and Zombies.
							if (e.getEntity().getType()==EntityType.SKELETON || e.getEntity().getType()==EntityType.ZOMBIE) {
								LivingEntity l = (LivingEntity) e.getEntity();
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
								//Can't have baby zombies at this level.
								if (e.getEntity().getType()==EntityType.ZOMBIE) {
									Zombie z = (Zombie)e.getEntity();
									if (z.isBaby() && e.getEntity().getCustomName()==null) {
										z.setBaby(false);
									}
								}
								//Wear leather armor a bit more often. Sometimes a chain piece here or there. Include a Wooden sword usually.
								if (e.getEntity().getType()==EntityType.SKELETON || e.getEntity().getType()==EntityType.ZOMBIE) {
									LivingEntity l = (LivingEntity) e.getEntity();
									if (e.getEntity().getType()==EntityType.ZOMBIE) {
										if (Math.random()<=0.65) {
											l.getEquipment().setItemInHand(new ItemStack(Material.WOOD_SWORD));
										}
									}
									if (e.getEntity().getType()==EntityType.SKELETON) {
										if (Math.random()<=0.65) {
											ItemStack new_bow = new ItemStack(Material.BOW);
											new_bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
											l.getEquipment().setItemInHand(new_bow);
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
									if (e.getEntity().getType()==EntityType.SKELETON || e.getEntity().getType()==EntityType.ZOMBIE) {
										LivingEntity l = (LivingEntity) e.getEntity();
										if (e.getEntity().getType()==EntityType.ZOMBIE) {
											if (Math.random()<=0.65) {
												if (Math.random()<=0.75) {
													l.getEquipment().setItemInHand(new ItemStack(Material.WOOD_SWORD));
												} else {
													l.getEquipment().setItemInHand(new ItemStack(Material.IRON_SWORD));
												}
											}
										} else
											if (e.getEntity().getType()==EntityType.SKELETON) {
												if (Math.random()<=0.65) {
													if (Math.random()<=0.75) {
														ItemStack new_bow = new ItemStack(Material.BOW);
														new_bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
														l.getEquipment().setItemInHand(new_bow);
													} else {
														ItemStack new_bow = new ItemStack(Material.BOW);
														new_bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
														new_bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
														l.getEquipment().setItemInHand(new_bow);
													}
												}
											} else {
												////l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,999999,0));
											}
										if (Math.random()>=0.25) {
											if (Math.random()<=0.75) {
												l.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
											} else {
												ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
												ItemMeta meta = item.getItemMeta();
												meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
												List<String> newlore = new ArrayList<String>();
												newlore.add(ChatColor.RED+"-400% Durability");
												meta.setLore(newlore);
												item.setItemMeta(meta);
												l.getEquipment().setChestplate(item);
											}
											if (Math.random()>=0.45) {
												if (Math.random()<=0.75) {
													l.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
												} else {
													ItemStack item = new ItemStack(Material.IRON_LEGGINGS);
													ItemMeta meta = item.getItemMeta();
													meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
													List<String> newlore = new ArrayList<String>();
													newlore.add(ChatColor.RED+"-400% Durability");
													meta.setLore(newlore);
													item.setItemMeta(meta);
													l.getEquipment().setLeggings(item);
												}
												if (Math.random()>=0.65) {
													if (Math.random()<=0.75) {
														l.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
													} else {
														ItemStack item = new ItemStack(Material.IRON_HELMET);
														ItemMeta meta = item.getItemMeta();
														meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
														List<String> newlore = new ArrayList<String>();
														newlore.add(ChatColor.RED+"-400% Durability");
														meta.setLore(newlore);
														item.setItemMeta(meta);
														l.getEquipment().setHelmet(item);
													}
													if (Math.random()>=0.95) {
														if (Math.random()<=0.75) {
															l.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
														} else {
															ItemStack item = new ItemStack(Material.IRON_BOOTS);
															ItemMeta meta = item.getItemMeta();
															meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
															List<String> newlore = new ArrayList<String>();
															newlore.add(ChatColor.RED+"-400% Durability");
															meta.setLore(newlore);
															item.setItemMeta(meta);
															l.getEquipment().setBoots(item);
														}
													}
												}
											}
										}
									}
								} else
									if (totallvs<100*levelsmult) {
										//Wear iron armor a bit more often. Sometimes a diamond piece here or there. Include a Diamond sword sometimes, an iron one usually.
										if (e.getEntity().getType()==EntityType.SKELETON || e.getEntity().getType()==EntityType.ZOMBIE) {
											LivingEntity l = (LivingEntity) e.getEntity();
											if (e.getEntity().getType()==EntityType.ZOMBIE) {
												if (Math.random()<=0.65) {
													if (Math.random()<=0.75) {
														l.getEquipment().setItemInHand(new ItemStack(Material.IRON_SWORD));
													} else {
														l.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
													}
												}
											} else
												if (e.getEntity().getType()==EntityType.SKELETON) {
													if (Math.random()<=0.65) {
														if (Math.random()<=0.75) {
															ItemStack new_bow = new ItemStack(Material.BOW);
															new_bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
															new_bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
															l.getEquipment().setItemInHand(new_bow);
														} else {
															ItemStack new_bow = new ItemStack(Material.BOW);
															new_bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 3);
															new_bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
															l.getEquipment().setItemInHand(new_bow);
														}
													}
												} else {
													if (Math.random()<=0.65) {
														if (Math.random()<=0.75) {
															////l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,999999,1));
														} else {
															////l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,999999,1));
															//l.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,999999,0));
														}
													}
												}
											if (Math.random()>=0.25) {
												if (Math.random()<=0.75) {
													ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
													ItemMeta meta = item.getItemMeta();
													meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
													List<String> newlore = new ArrayList<String>();
													newlore.add(ChatColor.RED+"-400% Durability");
													meta.setLore(newlore);
													item.setItemMeta(meta);
													l.getEquipment().setChestplate(item);
												} else {
													ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
													ItemMeta meta = item.getItemMeta();
													meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
													List<String> newlore = new ArrayList<String>();
													newlore.add(ChatColor.RED+"-400% Durability");
													meta.setLore(newlore);
													item.setItemMeta(meta);
													l.getEquipment().setChestplate(item);
												}
												if (Math.random()>=0.45) {
													if (Math.random()<=0.75) {
														ItemStack item = new ItemStack(Material.IRON_LEGGINGS);
														ItemMeta meta = item.getItemMeta();
														meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
														List<String> newlore = new ArrayList<String>();
														newlore.add(ChatColor.RED+"-400% Durability");
														meta.setLore(newlore);
														item.setItemMeta(meta);
														l.getEquipment().setLeggings(item);
													} else {
														ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
														ItemMeta meta = item.getItemMeta();
														meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
														List<String> newlore = new ArrayList<String>();
														newlore.add(ChatColor.RED+"-400% Durability");
														meta.setLore(newlore);
														item.setItemMeta(meta);
														l.getEquipment().setLeggings(item);
													}
													if (Math.random()>=0.65) {
														if (Math.random()<=0.75) {
															ItemStack item = new ItemStack(Material.IRON_HELMET);
															ItemMeta meta = item.getItemMeta();
															meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
															List<String> newlore = new ArrayList<String>();
															newlore.add(ChatColor.RED+"-400% Durability");
															meta.setLore(newlore);
															item.setItemMeta(meta);
															l.getEquipment().setHelmet(item);
														} else {
															ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
															ItemMeta meta = item.getItemMeta();
															meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
															List<String> newlore = new ArrayList<String>();
															newlore.add(ChatColor.RED+"-400% Durability");
															meta.setLore(newlore);
															item.setItemMeta(meta);
															l.getEquipment().setHelmet(item);
														}
														if (Math.random()>=0.95) {
															if (Math.random()<=0.75) {
																ItemStack item = new ItemStack(Material.IRON_BOOTS);
																ItemMeta meta = item.getItemMeta();
																meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
																List<String> newlore = new ArrayList<String>();
																newlore.add(ChatColor.RED+"-400% Durability");
																meta.setLore(newlore);
																item.setItemMeta(meta);
																l.getEquipment().setBoots(item);
															} else {
																ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
																ItemMeta meta = item.getItemMeta();
																meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
																List<String> newlore = new ArrayList<String>();
																newlore.add(ChatColor.RED+"-400% Durability");
																meta.setLore(newlore);
																item.setItemMeta(meta);
																l.getEquipment().setBoots(item);
															}
														}
													}
												}
											}
										}
									} else
										if (totallvs<120*levelsmult) {
											//Wear diamond armor a bit more often. Sometimes an enchanted diamond piece here or there. Include a Golden sword sometimes, a diamond one usually.
											if (e.getEntity().getType()==EntityType.SKELETON || e.getEntity().getType()==EntityType.ZOMBIE) {
												LivingEntity l = (LivingEntity) e.getEntity();
												if (e.getEntity().getType()==EntityType.ZOMBIE) {
													if (Math.random()<=0.65) {
														if (Math.random()<=0.75) {
															l.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
														} else {
															l.getEquipment().setItemInHand(new ItemStack(Material.GOLD_SWORD));
														}
													}
												} else
													if (e.getEntity().getType()==EntityType.SKELETON) {
														if (Math.random()<=0.65) {
															if (Math.random()<=0.75) {
																ItemStack new_bow = new ItemStack(Material.BOW);
																new_bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 3);
																new_bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
																l.getEquipment().setItemInHand(new_bow);
															} else {
																ItemStack new_bow = new ItemStack(Material.BOW);
																new_bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 4);
																new_bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
																new_bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
																l.getEquipment().setItemInHand(new_bow);
															}
														}
													} else {
														if (Math.random()<=0.65) {
															if (Math.random()<=0.75) {
																////l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,999999,2));
															} else {
																////l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,999999,2));
																//l.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,999999,0));
															}
														}
													}
												if (Math.random()>=0.25) {
													if (Math.random()<=0.75) {
														ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
														ItemMeta meta = item.getItemMeta();
														meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
														List<String> newlore = new ArrayList<String>();
														newlore.add(ChatColor.RED+"-400% Durability");
														meta.setLore(newlore);
														item.setItemMeta(meta);
														l.getEquipment().setChestplate(item);
													} else {
														ItemStack enchanted = new ItemStack(Material.DIAMOND_CHESTPLATE);
														enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*1.0d)+1);
														ItemMeta meta = enchanted.getItemMeta();
														meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(enchanted.getType().name()));
														List<String> newlore = new ArrayList<String>();
														newlore.add(ChatColor.RED+"-400% Durability");
														meta.setLore(newlore);
														enchanted.setItemMeta(meta);
														l.getEquipment().setChestplate(enchanted);
													}
													if (Math.random()>=0.45) {
														if (Math.random()<=0.75) {
															ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
															ItemMeta meta = item.getItemMeta();
															meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
															List<String> newlore = new ArrayList<String>();
															newlore.add(ChatColor.RED+"-400% Durability");
															meta.setLore(newlore);
															item.setItemMeta(meta);
															l.getEquipment().setLeggings(item);
														} else {
															ItemStack enchanted = new ItemStack(Material.DIAMOND_LEGGINGS);
															enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*1.0d)+1);
															ItemMeta meta = enchanted.getItemMeta();
															meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(enchanted.getType().name()));
															List<String> newlore = new ArrayList<String>();
															newlore.add(ChatColor.RED+"-400% Durability");
															meta.setLore(newlore);
															enchanted.setItemMeta(meta);
															l.getEquipment().setLeggings(enchanted);
														}
														if (Math.random()>=0.65) {
															if (Math.random()<=0.75) {
																ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
																ItemMeta meta = item.getItemMeta();
																meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
																List<String> newlore = new ArrayList<String>();
																newlore.add(ChatColor.RED+"-400% Durability");
																meta.setLore(newlore);
																item.setItemMeta(meta);
																l.getEquipment().setHelmet(item);
															} else {
																ItemStack enchanted = new ItemStack(Material.DIAMOND_HELMET);
																enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*1.0d)+1);
																ItemMeta meta = enchanted.getItemMeta();
																meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(enchanted.getType().name()));
																List<String> newlore = new ArrayList<String>();
																newlore.add(ChatColor.RED+"-400% Durability");
																meta.setLore(newlore);
																enchanted.setItemMeta(meta);
																l.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
															}
															if (Math.random()>=0.95) {
																if (Math.random()<=0.75) {
																	ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
																	ItemMeta meta = item.getItemMeta();
																	meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
																	List<String> newlore = new ArrayList<String>();
																	newlore.add(ChatColor.RED+"-400% Durability");
																	meta.setLore(newlore);
																	item.setItemMeta(meta);
																	l.getEquipment().setBoots(item);
																} else {
																	ItemStack enchanted = new ItemStack(Material.DIAMOND_BOOTS);
																	enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*1.0d)+1);
																	ItemMeta meta = enchanted.getItemMeta();
																	meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(enchanted.getType().name()));
																	List<String> newlore = new ArrayList<String>();
																	newlore.add(ChatColor.RED+"-400% Durability");
																	meta.setLore(newlore);
																	enchanted.setItemMeta(meta);
																	l.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
																}
															}
														}
													}
												}
											}
										} else
											if (totallvs<140*levelsmult) {
												//Well dang, your party's huge and OP.
												//Wear diamond armor almost always. Enchanted diamond pieces here and there.
												if (e.getEntity().getType()==EntityType.SKELETON || e.getEntity().getType()==EntityType.ZOMBIE) {
													LivingEntity l = (LivingEntity) e.getEntity();
													if (e.getEntity().getType()==EntityType.ZOMBIE) {
														if (Math.random()<=0.80) {
															if (Math.random()<=0.75) {
																ItemStack enchanted = new ItemStack(Material.DIAMOND_SWORD);
																//enchanted.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, (int)(Math.random()*2.0d)+1);
																if (Math.random()<=0.5) {
																	enchanted.addUnsafeEnchantment(Enchantment.KNOCKBACK, (int)(Math.random()*2.0d)+1);
																} else {
																	enchanted.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, (int)(Math.random()*2.0d)+1);
																}
																l.getEquipment().setItemInHand(enchanted);
															} else {
																ItemStack enchanted = new ItemStack(Material.GOLD_SWORD);
																//enchanted.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, (int)(Math.random()*2.0d)+1);
																if (Math.random()<=0.5) {
																	enchanted.addUnsafeEnchantment(Enchantment.KNOCKBACK, (int)(Math.random()*2.0d)+1);
																} else {
																	enchanted.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, (int)(Math.random()*4.0d)+1);
																}
																l.getEquipment().setItemInHand(enchanted);
															}
														}
													} else
														if (e.getEntity().getType()==EntityType.SKELETON) {
															if (Math.random()<=0.65) {
																if (Math.random()<=0.75) {
																	ItemStack new_bow = new ItemStack(Material.BOW);
																	new_bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 5);
																	new_bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
																	new_bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
																	l.getEquipment().setItemInHand(new_bow);
																} else {
																	ItemStack new_bow = new ItemStack(Material.BOW);
																	new_bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 4);
																	new_bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
																	new_bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 2);
																	l.getEquipment().setItemInHand(new_bow);
																}
															}
														} else {
															if (Math.random()<=0.65) {
																if (Math.random()<=0.75) {
																	////l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,999999,2));
																	l.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,999999,0));
																} else {
																	////l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,999999,2));
																	//l.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,999999,1));
																	l.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,999999,0));
																}
															}
														}
													if (Math.random()>=0.25) {
														if (Math.random()<=0.75) {
															ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
															ItemMeta meta = item.getItemMeta();
															meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
															List<String> newlore = new ArrayList<String>();
															newlore.add(ChatColor.RED+"-400% Durability");
															meta.setLore(newlore);
															item.setItemMeta(meta);
															l.getEquipment().setChestplate(item);
														} else {
															ItemStack enchanted = new ItemStack(Material.DIAMOND_CHESTPLATE);
															enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*2.0d)+1);
															if (Math.random()<=0.5) {
																enchanted.addUnsafeEnchantment(Enchantment.THORNS, (int)(Math.random()*1.0d)+1);
															}
															ItemMeta meta = enchanted.getItemMeta();
															meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(enchanted.getType().name()));
															List<String> newlore = new ArrayList<String>();
															newlore.add(ChatColor.RED+"-400% Durability");
															meta.setLore(newlore);
															enchanted.setItemMeta(meta);
															l.getEquipment().setChestplate(enchanted);
														}
														if (Math.random()>=0.45) {
															if (Math.random()<=0.75) {
																ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
																ItemMeta meta = item.getItemMeta();
																meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
																List<String> newlore = new ArrayList<String>();
																newlore.add(ChatColor.RED+"-400% Durability");
																meta.setLore(newlore);
																item.setItemMeta(meta);
																l.getEquipment().setLeggings(item);
															} else {
																ItemStack enchanted = new ItemStack(Material.DIAMOND_LEGGINGS);
																enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*2.0d)+1);
																if (Math.random()<=0.5) {
																	enchanted.addUnsafeEnchantment(Enchantment.THORNS, (int)(Math.random()*2.0d)+1);
																}
																ItemMeta meta = enchanted.getItemMeta();
																meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(enchanted.getType().name()));
																List<String> newlore = new ArrayList<String>();
																newlore.add(ChatColor.RED+"-400% Durability");
																meta.setLore(newlore);
																enchanted.setItemMeta(meta);
																l.getEquipment().setLeggings(enchanted);
															}
															if (Math.random()>=0.65) {
																if (Math.random()<=0.75) {
																	ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
																	ItemMeta meta = item.getItemMeta();
																	meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
																	List<String> newlore = new ArrayList<String>();
																	newlore.add(ChatColor.RED+"-400% Durability");
																	meta.setLore(newlore);
																	item.setItemMeta(meta);
																	l.getEquipment().setHelmet(item);
																} else {
																	ItemStack enchanted = new ItemStack(Material.DIAMOND_HELMET);
																	enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*2.0d)+1);
																	if (Math.random()<=0.5) {
																		enchanted.addUnsafeEnchantment(Enchantment.THORNS, (int)(Math.random()*2.0d)+1);
																	}
																	ItemMeta meta = enchanted.getItemMeta();
																	meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(enchanted.getType().name()));
																	List<String> newlore = new ArrayList<String>();
																	newlore.add(ChatColor.RED+"-400% Durability");
																	meta.setLore(newlore);
																	enchanted.setItemMeta(meta);
																	l.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
																}
																if (Math.random()>=0.95) {
																	if (Math.random()<=0.75) {
																		ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
																		ItemMeta meta = item.getItemMeta();
																		meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
																		List<String> newlore = new ArrayList<String>();
																		newlore.add(ChatColor.RED+"-400% Durability");
																		meta.setLore(newlore);
																		item.setItemMeta(meta);
																		l.getEquipment().setBoots(item);
																	} else {
																		ItemStack enchanted = new ItemStack(Material.DIAMOND_BOOTS);
																		enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*2.0d)+1);
																		if (Math.random()<=0.5) {
																			enchanted.addUnsafeEnchantment(Enchantment.THORNS, (int)(Math.random()*2.0d)+1);
																		}
																		ItemMeta meta = enchanted.getItemMeta();
																		meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(enchanted.getType().name()));
																		List<String> newlore = new ArrayList<String>();
																		newlore.add(ChatColor.RED+"-400% Durability");
																		meta.setLore(newlore);
																		enchanted.setItemMeta(meta);
																		l.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
																	}
																}
															}
														}
													}
												}
											} else
												if (totallvs<200*levelsmult) {
													//Well dang, your party's huge and OP.
													//Wear diamond armor almost always. Enchanted diamond pieces here and there.
													if (e.getEntity().getType()==EntityType.SKELETON || e.getEntity().getType()==EntityType.ZOMBIE) {
														LivingEntity l = (LivingEntity) e.getEntity();
														if (e.getEntity().getType()==EntityType.ZOMBIE) {
															if (Math.random()<=0.80) {
																if (Math.random()<=0.75) {
																	ItemStack enchanted = new ItemStack(Material.DIAMOND_SWORD);
																	//enchanted.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, (int)(Math.random()*4.0d)+1);
																	if (Math.random()<=0.5) {
																		enchanted.addUnsafeEnchantment(Enchantment.KNOCKBACK, (int)(Math.random()*3.0d)+1);
																	} else {
																		enchanted.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, (int)(Math.random()*2.0d)+1);
																	}
																	l.getEquipment().setItemInHand(enchanted);
																} else {
																	ItemStack enchanted = new ItemStack(Material.GOLD_SWORD);
																	//enchanted.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, (int)(Math.random()*4.0d)+1);
																	if (Math.random()<=0.5) {
																		enchanted.addUnsafeEnchantment(Enchantment.KNOCKBACK, (int)(Math.random()*3.0d)+1);
																	} else {
																		enchanted.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, (int)(Math.random()*2.0d)+1);
																	}
																	l.getEquipment().setItemInHand(enchanted);
																}
															}
														} else
															if (e.getEntity().getType()==EntityType.SKELETON) {
																if (Math.random()<=0.65) {
																	if (Math.random()<=0.75) {
																		ItemStack new_bow = new ItemStack(Material.BOW);
																		new_bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 5);
																		new_bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
																		new_bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 2);
																		l.getEquipment().setItemInHand(new_bow);
																	} else {
																		ItemStack new_bow = new ItemStack(Material.BOW);
																		new_bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 6);
																		new_bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
																		new_bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 3);
																		l.getEquipment().setItemInHand(new_bow);
																	}
																}
															} else {
																if (Math.random()<=0.65) {
																	if (Math.random()<=0.75) {
																		////l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,999999,3));
																		//l.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,999999,2));
																		l.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,999999,1));
																	} else {
																		////l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,999999,4));
																		//l.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,999999,2));
																		l.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,999999,1));
																	}
																}
															}
														if (Math.random()>=0.25) {
															if (Math.random()<=0.75) {
																ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
																ItemMeta meta = item.getItemMeta();
																meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
																List<String> newlore = new ArrayList<String>();
																newlore.add(ChatColor.RED+"-400% Durability");
																meta.setLore(newlore);
																item.setItemMeta(meta);
																l.getEquipment().setChestplate(item);
															} else {
																ItemStack enchanted = new ItemStack(Material.DIAMOND_CHESTPLATE);
																enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*3.0d)+1);
																enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, (int)(Math.random()*3.0d)+1);
																enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, (int)(Math.random()*3.0d)+1);
																enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, (int)(Math.random()*2.0d)+1);
																if (Math.random()<=0.5) {
																	enchanted.addUnsafeEnchantment(Enchantment.THORNS, (int)(Math.random()*2.0d)+1);
																}
																ItemMeta meta = enchanted.getItemMeta();
																meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(enchanted.getType().name()));
																List<String> newlore = new ArrayList<String>();
																newlore.add(ChatColor.RED+"-400% Durability");
																meta.setLore(newlore);
																enchanted.setItemMeta(meta);
																l.getEquipment().setChestplate(enchanted);
															}
															if (Math.random()>=0.45) {
																if (Math.random()<=0.75) {
																	ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
																	ItemMeta meta = item.getItemMeta();
																	meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
																	List<String> newlore = new ArrayList<String>();
																	newlore.add(ChatColor.RED+"-400% Durability");
																	meta.setLore(newlore);
																	item.setItemMeta(meta);
																	l.getEquipment().setLeggings(item);
																} else {
																	ItemStack enchanted = new ItemStack(Material.DIAMOND_LEGGINGS);
																	enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*2.0d)+1);
																	enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, (int)(Math.random()*2.0d)+1);
																	enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, (int)(Math.random()*2.0d)+1);
																	enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, (int)(Math.random()*2.0d)+1);
																	if (Math.random()<=0.5) {
																		enchanted.addUnsafeEnchantment(Enchantment.THORNS, (int)(Math.random()*2.0d)+1);
																	}
																	ItemMeta meta = enchanted.getItemMeta();
																	meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(enchanted.getType().name()));
																	List<String> newlore = new ArrayList<String>();
																	newlore.add(ChatColor.RED+"-400% Durability");
																	meta.setLore(newlore);
																	enchanted.setItemMeta(meta);
																	l.getEquipment().setLeggings(enchanted);
																}
																if (Math.random()>=0.65) {
																	if (Math.random()<=0.75) {
																		ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
																		ItemMeta meta = item.getItemMeta();
																		meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
																		List<String> newlore = new ArrayList<String>();
																		newlore.add(ChatColor.RED+"-400% Durability");
																		meta.setLore(newlore);
																		item.setItemMeta(meta);
																		l.getEquipment().setHelmet(item);
																	} else {
																		ItemStack enchanted = new ItemStack(Material.DIAMOND_HELMET);
																		enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*4.0d)+1);
																		enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, (int)(Math.random()*2.0d)+1);
																		enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, (int)(Math.random()*2.0d)+1);
																		enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, (int)(Math.random()*2.0d)+1);
																		if (Math.random()<=0.5) {
																			enchanted.addUnsafeEnchantment(Enchantment.THORNS, (int)(Math.random()*2.0d)+1);
																		}
																		ItemMeta meta = enchanted.getItemMeta();
																		meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(enchanted.getType().name()));
																		List<String> newlore = new ArrayList<String>();
																		newlore.add(ChatColor.RED+"-400% Durability");
																		meta.setLore(newlore);
																		enchanted.setItemMeta(meta);
																		l.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
																	}
																	if (Math.random()>=0.95) {
																		if (Math.random()<=0.75) {
																			ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
																			ItemMeta meta = item.getItemMeta();
																			meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
																			List<String> newlore = new ArrayList<String>();
																			newlore.add(ChatColor.RED+"-400% Durability");
																			meta.setLore(newlore);
																			item.setItemMeta(meta);
																			l.getEquipment().setBoots(item);
																		} else {
																			ItemStack enchanted = new ItemStack(Material.DIAMOND_BOOTS);
																			enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*4.0d)+1);
																			enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, (int)(Math.random()*4.0d)+1);
																			enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, (int)(Math.random()*2.0d)+1);
																			enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, (int)(Math.random()*2.0d)+1);
																			if (Math.random()<=0.5) {
																				enchanted.addUnsafeEnchantment(Enchantment.THORNS, (int)(Math.random()*4.0d)+1);
																			}
																			ItemMeta meta = enchanted.getItemMeta();
																			meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(enchanted.getType().name()));
																			List<String> newlore = new ArrayList<String>();
																			newlore.add(ChatColor.RED+"-400% Durability");
																			meta.setLore(newlore);
																			enchanted.setItemMeta(meta);
																			l.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
																		}
																	}
																}
															}
														}
													}
												}
												else {
													//Time to give it our all.
													//Well dang, your party's huge and OP.
													//Wear diamond armor almost always. Enchanted diamond pieces here and there.
													if (e.getEntity().getType()==EntityType.SKELETON || e.getEntity().getType()==EntityType.ZOMBIE) {
														LivingEntity l = (LivingEntity) e.getEntity();
														//l.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,999999,1));
														l.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,999999,1));
														l.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,999999,0));
														l.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,999999,0));
														//l.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,999999,0));
														//l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,999999,1));
														if (e.getEntity().getType()==EntityType.ZOMBIE) {
															if (Math.random()<=0.80) {
																if (Math.random()<=0.75) {
																	ItemStack enchanted = new ItemStack(Material.DIAMOND_SWORD);
																	//enchanted.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, (int)(Math.random()*4.0d)+1);
																	if (Math.random()<=0.5) {
																		enchanted.addUnsafeEnchantment(Enchantment.KNOCKBACK, (int)(Math.random()*2.0d)+1);
																	} else {
																		enchanted.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, (int)(Math.random()*3.0d)+1);
																	}
																	l.getEquipment().setItemInHand(enchanted);
																} else {
																	ItemStack enchanted = new ItemStack(Material.GOLD_SWORD);
																	//enchanted.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, (int)(Math.random()*4.0d)+1);
																	if (Math.random()<=0.5) {
																		enchanted.addUnsafeEnchantment(Enchantment.KNOCKBACK, (int)(Math.random()*2.0d)+1);
																	} else {
																		enchanted.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, (int)(Math.random()*3.0d)+1);
																	}
																	l.getEquipment().setItemInHand(enchanted);
																}
															}
														}
														if (Math.random()>=0.25) {
															if (Math.random()<=0.75) {
																ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
																ItemMeta meta = item.getItemMeta();
																meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
																List<String> newlore = new ArrayList<String>();
																newlore.add(ChatColor.RED+"-400% Durability");
																meta.setLore(newlore);
																item.setItemMeta(meta);
																l.getEquipment().setChestplate(item);
															} else {
																ItemStack enchanted = new ItemStack(Material.DIAMOND_CHESTPLATE);
																enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*4.0d)+1);
																enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, (int)(Math.random()*4.0d)+1);
																enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, (int)(Math.random()*4.0d)+1);
																enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, (int)(Math.random()*3.0d)+1);
																if (Math.random()<=0.5) {
																	enchanted.addUnsafeEnchantment(Enchantment.THORNS, (int)(Math.random()*4.0d)+1);
																}
																ItemMeta meta = enchanted.getItemMeta();
																meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(enchanted.getType().name()));
																List<String> newlore = new ArrayList<String>();
																newlore.add(ChatColor.RED+"-400% Durability");
																meta.setLore(newlore);
																enchanted.setItemMeta(meta);
																l.getEquipment().setChestplate(enchanted);
															}
															if (Math.random()>=0.45) {
																if (Math.random()<=0.75) {
																	ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
																	ItemMeta meta = item.getItemMeta();
																	meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
																	List<String> newlore = new ArrayList<String>();
																	newlore.add(ChatColor.RED+"-400% Durability");
																	meta.setLore(newlore);
																	item.setItemMeta(meta);
																	l.getEquipment().setLeggings(item);
																} else {
																	ItemStack enchanted = new ItemStack(Material.DIAMOND_LEGGINGS);
																	enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*4.0d)+1);
																	enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, (int)(Math.random()*4.0d)+1);
																	enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, (int)(Math.random()*3.0d)+1);
																	enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, (int)(Math.random()*2.0d)+1);
																	if (Math.random()<=0.5) {
																		enchanted.addUnsafeEnchantment(Enchantment.THORNS, (int)(Math.random()*4.0d)+1);
																	}
																	ItemMeta meta = enchanted.getItemMeta();
																	meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(enchanted.getType().name()));
																	List<String> newlore = new ArrayList<String>();
																	newlore.add(ChatColor.RED+"-400% Durability");
																	meta.setLore(newlore);
																	enchanted.setItemMeta(meta);
																	l.getEquipment().setLeggings(enchanted);
																}
																if (Math.random()>=0.65) {
																	if (Math.random()<=0.75) {
																		ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
																		ItemMeta meta = item.getItemMeta();
																		meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
																		List<String> newlore = new ArrayList<String>();
																		newlore.add(ChatColor.RED+"-400% Durability");
																		meta.setLore(newlore);
																		item.setItemMeta(meta);
																		l.getEquipment().setHelmet(item);
																	} else {
																		ItemStack enchanted = new ItemStack(Material.DIAMOND_HELMET);
																		enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*4.0d)+1);
																		enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, (int)(Math.random()*4.0d)+1);
																		enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, (int)(Math.random()*2.0d)+1);
																		enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, (int)(Math.random()*2.0d)+1);
																		if (Math.random()<=0.5) {
																			enchanted.addUnsafeEnchantment(Enchantment.THORNS, (int)(Math.random()*4.0d)+1);
																		}
																		ItemMeta meta = enchanted.getItemMeta();
																		meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(enchanted.getType().name()));
																		List<String> newlore = new ArrayList<String>();
																		newlore.add(ChatColor.RED+"-400% Durability");
																		meta.setLore(newlore);
																		enchanted.setItemMeta(meta);
																		l.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
																	}
																	if (Math.random()>=0.95) {
																		if (Math.random()<=0.75) {
																			ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
																			ItemMeta meta = item.getItemMeta();
																			meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(item.getType().name()));
																			List<String> newlore = new ArrayList<String>();
																			newlore.add(ChatColor.RED+"-400% Durability");
																			meta.setLore(newlore);
																			item.setItemMeta(meta);
																			l.getEquipment().setBoots(item);
																		} else {
																			ItemStack enchanted = new ItemStack(Material.DIAMOND_BOOTS);
																			enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, (int)(Math.random()*4.0d)+1);
																			enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, (int)(Math.random()*4.0d)+1);
																			enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, (int)(Math.random()*4.0d)+1);
																			enchanted.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, (int)(Math.random()*4.0d)+1);
																			if (Math.random()<=0.5) {
																				enchanted.addUnsafeEnchantment(Enchantment.THORNS, (int)(Math.random()*2.0d)+1);
																			}
																			ItemMeta meta = enchanted.getItemMeta();
																			meta.setDisplayName(ChatColor.DARK_AQUA+"Weak "+convertToItemName(enchanted.getType().name()));
																			List<String> newlore = new ArrayList<String>();
																			newlore.add(ChatColor.RED+"-400% Durability");
																			meta.setLore(newlore);
																			enchanted.setItemMeta(meta);
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
		}
		
		if (e.getEntity() instanceof Zombie) {
			Zombie z = (Zombie)e.getEntity();
			if (z.isBaby() && z.getCustomName()!=null && !z.getCustomName().contains("Ninja")) {
				//Can't have weird special baby zombies.
				z.setBaby(false);
			}
		}
		
		if (e.getEntity().getType()==EntityType.EXPERIENCE_ORB) {
			Bukkit.getWorld("world").spawnEntity(e.getEntity().getLocation(),e.getEntity().getType());
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

	private void breakOreBlock(Player p, Block b) {
		breakOreBlock(p, b, false);
	}

	private void breakOreBlock(Player p, Block b, boolean silk_touch) {
		breakOreBlock(p, b, false, 1);
	}

	private void breakOreBlock(Player p, Block b, boolean silk_touch, double xp_mult) {
		if (this.plugin.PlayerinJob(p, "Miner")) {
			//Bukkit.getLogger().info("This player is a miner.");
			int myData=this.plugin.getPlayerDataSlot(p);
			if (this.plugin.playerdata_list.get(myData).GoodInteract()) {
				//Bukkit.getLogger().info("Good interact.");
				if (b.getType()==Material.STONE) {
					this.plugin.gainMoneyExp(p,"Miner",0.0025,1);
				} else
					if (b.getType()==Material.NETHERRACK) {
						this.plugin.gainMoneyExp(p,"Miner",0.005,1);
					} else
						if (b.getType()==Material.COAL_ORE && !silk_touch) {
							this.plugin.gainMoneyExp(p,"Miner",0.0125,3);
							//Bukkit.getLogger().info("Coal Ore.");
						} else
							if (b.getType()==Material.GLOWSTONE && !silk_touch) {
								this.plugin.gainMoneyExp(p,"Miner",0.015,3);
							} else
								if (b.getType()==Material.SANDSTONE) {
									this.plugin.gainMoneyExp(p,"Miner",0.015,4);
								} else
									if (b.getType()==Material.NETHER_BRICK) {
										this.plugin.gainMoneyExp(p,"Miner",0.02,3);
									} else
										if (b.getType()==Material.QUARTZ_ORE && !silk_touch) {
											this.plugin.gainMoneyExp(p,"Miner",0.025,4);
										} else
											if (b.getType()==Material.LAPIS_ORE && !silk_touch) {
												this.plugin.gainMoneyExp(p,"Miner",0.03,5);
											} else
												if (b.getType()==Material.MOSSY_COBBLESTONE) {
													this.plugin.gainMoneyExp(p,"Miner",0.0375,8);
												} else
													if (b.getType()==Material.IRON_ORE && !silk_touch) {
														this.plugin.gainMoneyExp(p,"Miner",0.0375,6);
													} else
														if ((b.getType()==Material.REDSTONE_ORE || b.getType()==Material.GLOWING_REDSTONE_ORE) && !silk_touch) {
															this.plugin.gainMoneyExp(p,"Miner",0.05,9);
														} else
															if (b.getType()==Material.OBSIDIAN) {
																this.plugin.gainMoneyExp(p,"Miner",0.0625,10);
															} else
																if (b.getType()==Material.GOLD_ORE && !silk_touch) {
																	this.plugin.gainMoneyExp(p,"Miner",0.0975,12);
																} else
																	if (b.getType()==Material.DIAMOND_ORE && !silk_touch) {
																		this.plugin.gainMoneyExp(p,"Miner",0.3125,60);
																	} else
																		if (b.getType()==Material.EMERALD_ORE && !silk_touch) {
																			this.plugin.gainMoneyExp(p,"Miner",0.7625,160);
																		}
			}
		}
		Material[] fortune_materials = {Material.EMERALD_ORE,Material.COAL_ORE,Material.DIAMOND_ORE,Material.REDSTONE_ORE,Material.GLOWING_REDSTONE_ORE,Material.LAPIS_ORE,Material.QUARTZ_ORE}; //An array of all blocks that multiply via fortune.
		Material[] result_materials = {Material.EMERALD,Material.COAL,Material.DIAMOND,Material.REDSTONE,Material.REDSTONE,Material.INK_SACK,Material.QUARTZ}; //The resulting materials corresponding to the fortune blocks being broken.
		boolean fortune_material=false;
		int fortune_material_slot=0;
		int mult = 1;
		short WOOD_PICKAXE = 0, STONE_PICKAXE = 1, GOLD_PICKAXE = 2, IRON_PICKAXE = 3, DIAMOND_PICKAXE = 4; //Constants that define the pickaxe strength.

		short[] material_pickaxe_requirements = {IRON_PICKAXE,WOOD_PICKAXE,IRON_PICKAXE,IRON_PICKAXE,IRON_PICKAXE,STONE_PICKAXE,WOOD_PICKAXE};

		short my_pickaxe_strength=-1; //-1 is some other random item / your hand.
		switch (p.getItemInHand().getType()) {
		case WOOD_PICKAXE:{my_pickaxe_strength = WOOD_PICKAXE;}break;
		case STONE_PICKAXE:{my_pickaxe_strength = STONE_PICKAXE;}break;
		case GOLD_PICKAXE:{my_pickaxe_strength = GOLD_PICKAXE;}break;
		case IRON_PICKAXE:{my_pickaxe_strength = IRON_PICKAXE;}break;
		case DIAMOND_PICKAXE:{my_pickaxe_strength = DIAMOND_PICKAXE;}break;
		}
		for (int i=0;i<fortune_materials.length;i++) {
			if (fortune_materials[i].equals(b.getType())) {
				fortune_material=true;
				fortune_material_slot=i;
				break;
			}
		}
		if (!silk_touch) {
			if (b.getType()==Material.COAL_ORE && my_pickaxe_strength>=WOOD_PICKAXE) {
				ExperienceOrb exp = (ExperienceOrb)p.getWorld().spawnEntity(b.getLocation(), EntityType.EXPERIENCE_ORB);
				exp.setExperience((int)(1*xp_mult));
			}
			if (b.getType()==Material.IRON_ORE && my_pickaxe_strength>=STONE_PICKAXE) {
				ExperienceOrb exp = (ExperienceOrb)p.getWorld().spawnEntity(b.getLocation(), EntityType.EXPERIENCE_ORB);
				exp.setExperience((int)(1*xp_mult));
			}
			if (b.getType()==Material.GOLD_ORE && my_pickaxe_strength>=IRON_PICKAXE) {
				ExperienceOrb exp = (ExperienceOrb)p.getWorld().spawnEntity(b.getLocation(), EntityType.EXPERIENCE_ORB);
				exp.setExperience((int)(1*xp_mult));
			}
			if ((b.getType()==Material.REDSTONE_ORE || b.getType()==Material.GLOWING_REDSTONE_ORE) && my_pickaxe_strength>=IRON_PICKAXE) {
				ExperienceOrb exp = (ExperienceOrb)p.getWorld().spawnEntity(b.getLocation(), EntityType.EXPERIENCE_ORB);
				exp.setExperience((int)(3*xp_mult));
			}
			if (b.getType()==Material.LAPIS_ORE && my_pickaxe_strength>=STONE_PICKAXE) {
				ExperienceOrb exp = (ExperienceOrb)p.getWorld().spawnEntity(b.getLocation(), EntityType.EXPERIENCE_ORB);
				exp.setExperience((int)(3*xp_mult));
			}
			if (b.getType()==Material.DIAMOND_ORE && my_pickaxe_strength>=IRON_PICKAXE) {
				ExperienceOrb exp = (ExperienceOrb)p.getWorld().spawnEntity(b.getLocation(), EntityType.EXPERIENCE_ORB);
				exp.setExperience((int)(12*xp_mult));
			}
			if (b.getType()==Material.EMERALD_ORE && my_pickaxe_strength>=IRON_PICKAXE) {
				ExperienceOrb exp = (ExperienceOrb)p.getWorld().spawnEntity(b.getLocation(), EntityType.EXPERIENCE_ORB);
				exp.setExperience((int)(28*xp_mult));
			}
			if (b.getType()==Material.QUARTZ_ORE && my_pickaxe_strength>=WOOD_PICKAXE) {
				ExperienceOrb exp = (ExperienceOrb)p.getWorld().spawnEntity(b.getLocation(), EntityType.EXPERIENCE_ORB);
				exp.setExperience((int)(4*xp_mult));
			}
		}
		if (this.plugin.hasJobBuff("Miner", p, Job.JOB40)) {
			mult=2;
		}
		if (p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS)>0) { //Check if the player has fortune.
			if (fortune_material && my_pickaxe_strength>=material_pickaxe_requirements[fortune_material_slot]) { //If this is a fortune material, we have to account for the new fortune enchantment algorithm. Make sure we have a good enough pickaxe too.
				//e.setCancelled(true);
				p.getWorld().getBlockAt(b.getLocation()).setType(Material.AIR);
				int fortune_level = p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
				int drop_chance=50;
				for (int i=1;i<fortune_level;i++) {
					drop_chance += (100-drop_chance)/2;
				}
				boolean drop_extra=false;
				if (Math.random()*100d<=drop_chance) {
					drop_extra=true;
				}
				if (result_materials[fortune_material_slot]!=Material.REDSTONE &&
						result_materials[fortune_material_slot]!=Material.INK_SACK) {
					//This is an item that actually just drops one of per ore. Drop normally.
					p.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(result_materials[fortune_material_slot],((drop_extra)?2:1)*mult));
				} else {
					if (result_materials[fortune_material_slot]==Material.REDSTONE) { //Drop redstone
						p.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(result_materials[fortune_material_slot],((drop_extra)?(((int)(Math.random()*2))+4)*2:((int)(Math.random()*2))+4)*mult));
					} else {//Drop Lapis.
						Item lapis = p.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(result_materials[fortune_material_slot],((drop_extra)?(((int)(Math.random()*5))+4)*2:((int)(Math.random()*5))+4)*mult,(byte)4));
					}
				}
			}
		} else {
			if (fortune_material && my_pickaxe_strength>=material_pickaxe_requirements[fortune_material_slot]) {
				//Bukkit.getLogger().info("No fortune, drop "+result_materials[fortune_material_slot].name()+" manually.");
				p.getWorld().getBlockAt(b.getLocation()).setType(Material.AIR);
				boolean drop_extra=false;
				if (result_materials[fortune_material_slot]!=Material.REDSTONE &&
						result_materials[fortune_material_slot]!=Material.INK_SACK) {
					//This is an item that actually just drops one of per ore. Drop normally.
					p.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(result_materials[fortune_material_slot],((drop_extra)?2:1)*mult));
				} else {
					if (result_materials[fortune_material_slot]==Material.REDSTONE) { //Drop redstone
						p.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(result_materials[fortune_material_slot],((drop_extra)?(((int)(Math.random()*2))+4)*2:((int)(Math.random()*2))+4)*mult));
					} else {//Drop Lapis.
						Item lapis = p.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(result_materials[fortune_material_slot],((drop_extra)?(((int)(Math.random()*5))+4)*2:((int)(Math.random()*5))+4)*mult,(byte)4));
					}
				}
			}
		}
		if (b.getType()==Material.IRON_ORE && !silk_touch) {
			//e.setCancelled(true);
			p.getWorld().getBlockAt(b.getLocation()).setType(Material.AIR);
			if (my_pickaxe_strength>=STONE_PICKAXE) {
				p.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.IRON_INGOT));
			}
		}
		if (b.getType()==Material.GOLD_ORE && !silk_touch) {
			//e.setCancelled(true);
			p.getWorld().getBlockAt(b.getLocation()).setType(Material.AIR);
			if (my_pickaxe_strength>=IRON_PICKAXE) {
				p.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.GOLD_INGOT));
			}
		}
	}

	private void destroyNearbyOres(World w, Player p, Location currentloc) {
		destroyNearbyOres(w, p, currentloc, false, 1);
	}

	private void destroyNearbyOres(World w, Player p, Location currentloc, boolean silk_touch, double xp_mult) {
		//Check surrounding ores.
		if (w.getBlockAt(currentloc).getType().name().toLowerCase().contains("ore")) {
			breakOreBlock(p, w.getBlockAt(currentloc), silk_touch, xp_mult);
		}
		Location newloc = null;
		for (int x=-1;x<2;x++) {
			for (int y=-1;y<2;y++) {
				for (int z=-1;z<2;z++) {
					if (x!=0 || y!=0 || z!=0) {
						//Bukkit.getLogger().info("Destroy block.");
						newloc = currentloc.clone().add(x,y,z);
						if (w.getBlockAt(newloc).getType().name().toLowerCase().contains("ore")) {
							//Bukkit.getLogger().info("New ore, set block break.");
							breakOreBlock(p, w.getBlockAt(newloc), silk_touch, xp_mult);
							destroyNearbyOres(w, p, newloc, silk_touch, xp_mult);
						}
					}
				}
			}
		}
	}

	private void destroyNearbyTree(World w, Location treeNode, Location checkloc, byte type, boolean silk_touch) {
		//treeNode is where the original tree is located. checkloc is the current checking location.
		//Code for destroying a tree. This iterates on itself. Using a base point to determine how far out it can go.
		if (treeNode.distance(checkloc)<3) {
			//Loop around and find all leaves/logs.
			Location newloc = null;
			for (int i=-1;i<2;i++) {
				for (int j=-1;j<2;j++) {
					for (int k=-1;k<2;k++) {
						newloc = checkloc.clone().add(i,j,k);
						if (w.getBlockAt(newloc).getType()==Material.LOG && w.getBlockAt(newloc).getData()%4==type) {
							//logs.add(newloc.getBlock());
							w.dropItemNaturally(newloc, new ItemStack(w.getBlockAt(newloc).getType(),1,(short)(w.getBlockAt(newloc).getData()%4)));
							newloc.getBlock().setType(Material.AIR);
							destroyNearbyTree(w, newloc, newloc, type, silk_touch);
						} else
							if (w.getBlockAt(newloc).getType()==Material.LEAVES && w.getBlockAt(newloc).getData()%4==type) {
								//leaves.add(newloc.getBlock());
								//Emulate apples / saplings dropping.
								if (w.getBlockAt(newloc).getData()==3) {
									//Jungle sapling.
									if (silk_touch) {
										w.dropItemNaturally(newloc, new ItemStack(Material.LEAVES,1,(short)(w.getBlockAt(newloc).getData()%4)));
									} else 
										if (Math.random()<=0.025) {
											ItemStack item = new ItemStack(Material.SAPLING,1);
											item.setDurability((short)(w.getBlockAt(newloc).getData()%4));
											w.dropItemNaturally(newloc, item);
										}
								} else {
									if (w.getBlockAt(newloc).getData()%4==0) {
										//Chance to drop an apple.
										if (Math.random()<=0.02) {
											w.dropItemNaturally(newloc, new ItemStack(Material.APPLE,1));
										}
									}
									if (silk_touch) {
										w.dropItemNaturally(newloc, new ItemStack(Material.LEAVES,1,(short)(w.getBlockAt(newloc).getData()%4)));
									} else 
										if (Math.random()<=0.05) {
											ItemStack item = new ItemStack(Material.SAPLING,1);
											item.setDurability((short)(w.getBlockAt(newloc).getData()%4));
											w.dropItemNaturally(newloc, item);
										}
								}
								newloc.getBlock().setType(Material.AIR);
								destroyNearbyTree(w, treeNode, newloc, type, silk_touch);
							}
					}
				}
			}
		}
	}
	
	public void getDiggerCredit(Player p, Block b) {
		if (this.plugin.getPlayerData(p).GoodInteract()) {
			if (b.getType()==Material.DIRT) {
				this.plugin.gainMoneyExp(p,"Miner",0.01,1);
			}
			if (b.getType()==Material.GRASS) {
				this.plugin.gainMoneyExp(p,"Miner",0.01,2);
			}
			if (b.getType()==Material.SAND) {
				this.plugin.gainMoneyExp(p,"Miner",0.02,2);
			}
			if (b.getType()==Material.GRAVEL) {
				this.plugin.gainMoneyExp(p,"Miner",0.04,5);
			}
			if (b.getType()==Material.SOUL_SAND) {
				this.plugin.gainMoneyExp(p,"Miner",0.08,8);
			}
			if (b.getType()==Material.CLAY) {
				this.plugin.gainMoneyExp(p,"Miner",0.10,10);
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
		boolean has_silktouch=p.getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH);
		
		this.plugin.getPlayerData(p).gameinteractions+=50;

		//*******************************//Job Buffs Begin here!
		if (this.plugin.hasJobBuff("Builder", p, Job.JOB40) && p.getAllowFlight()) {
			if (p.getGameMode()!=GameMode.CREATIVE) {
				p.setAllowFlight(false);
			}
			p.sendMessage(ChatColor.DARK_RED+""+ChatColor.ITALIC+"Flight disabled...");
		}
		if (this.plugin.hasJobBuff("Woodcutter", p, Job.JOB20)) {
			if (p.getItemInHand().getType().name().toLowerCase().contains("axe") && !p.getItemInHand().getType().name().toLowerCase().contains("pickaxe")) {
				//Make sure it's not a pickaxe before reducing durability.
				if (this.plugin.hasJobBuff("Woodcutter", p, Job.JOB30A)) {
					p.getItemInHand().setDurability((short)0);
				} else {
					if (Math.random()<=0.5) {
						p.getItemInHand().setDurability((short)(p.getItemInHand().getDurability()>=1?p.getItemInHand().getDurability()-1:0));
					}
				}
			}
			if ((e.getBlock().getType()==Material.LOG || e.getBlock().getType()==Material.WOOD)) {
				p.removePotionEffect(PotionEffectType.JUMP);
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,200,10));
			}
		}
		if (e.getBlock().getType()==Material.LOG && this.plugin.hasJobBuff("Woodcutter", p, Job.JOB40)) {
			//Cut down the whole tree if you hit a log. Make sure it's a tree.
			boolean findleaves=false;
			boolean findground=false;
			Location currentpos = e.getBlock().getLocation();
			//Look straight up, look on the sides for leaves.
			while (!findleaves && currentpos.getWorld().getBlockAt(currentpos).getType()==Material.LOG) {
				Location checktemp = currentpos.clone().add(0,1,0);
				if (e.getBlock().getWorld().getBlockAt(checktemp).getType()==Material.LEAVES ||
						e.getBlock().getWorld().getBlockAt(checktemp).getType()==Material.LEAVES ||
						e.getBlock().getWorld().getBlockAt(checktemp).getType()==Material.LEAVES ||
						e.getBlock().getWorld().getBlockAt(checktemp).getType()==Material.LEAVES ||
						e.getBlock().getWorld().getBlockAt(checktemp).getType()==Material.LEAVES ||
						e.getBlock().getWorld().getBlockAt(checktemp).getType()==Material.LEAVES) {
					findleaves=true; //This is considered a tree. Make sure the ground below it is dirt.
					//Bukkit.getLogger().info("Found leaves.");
				}
				currentpos=currentpos.add(0,1,0);
			}
			if (findleaves) {
				//This is definitely a tree we can chop down. Destroy it then.
				//Bukkit.getLogger().info("Identified as tree. Start Destroying.");
				try {
					Iterator<PotionEffect> effects = p.getActivePotionEffects().iterator();
					//Figure out potion effects when player joins.
					while (effects.hasNext()) {
						PotionEffect nexteffect = effects.next();
						if (nexteffect.getType().getName().compareTo(PotionEffectType.HEALTH_BOOST.getName())==0) {
							double myhealth = p.getHealth();
							p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
							p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,1200,nexteffect.getAmplifier()+1));
							p.setHealth(myhealth);
						}
						effects.remove();
					}
				} catch (ConcurrentModificationException ex_e) {
					Bukkit.getLogger().warning("Potion Effect Collection not accessible while initializing player speed.");
				}
				p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,1200,0));
				destroyNearbyTree(e.getBlock().getWorld() ,e.getBlock().getLocation(), e.getBlock().getLocation(), (byte)(e.getBlock().getData()%4), p.getItemInHand().getEnchantmentLevel(Enchantment.SILK_TOUCH)>0);
			}
		}


		if (this.plugin.hasJobBuff("Miner", p, Job.JOB5)) {
			if (e.getBlock().getType().name().toLowerCase().contains("ore")) {
				//Break all consecutive ores next to this ore. 
				//Bukkit.getLogger().info("Destroy nearby");
				e.setCancelled(true);
				if (this.plugin.hasJobBuff("Miner", p, Job.JOB10)) {
					destroyNearbyOres(e.getBlock().getWorld(), p, e.getBlock().getLocation(), has_silktouch, 4);
				} else {
					destroyNearbyOres(e.getBlock().getWorld(), p, e.getBlock().getLocation(), has_silktouch, 1);
				}
				if (this.plugin.hasJobBuff("Miner", p, Job.JOB30B)) {
					try {
						Iterator<PotionEffect> effects = p.getActivePotionEffects().iterator();
						//Figure out potion effects when player joins.
						while (effects.hasNext()) {
							PotionEffect nexteffect = effects.next();
							if (nexteffect.getType().getName().compareTo(PotionEffectType.FAST_DIGGING.getName())==0 && nexteffect.getAmplifier()<4) {
								p.removePotionEffect(PotionEffectType.FAST_DIGGING);
								p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 200, nexteffect.getAmplifier()+1, true));
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
					p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 200, 0, true));
				}
			} else {
				if (e.getBlock().getType()==Material.STONE || e.getBlock().getType()==Material.COBBLESTONE) {
					if (this.plugin.hasJobBuff("Miner", p, Job.JOB30B)) {
						try {
							Iterator<PotionEffect> effects = p.getActivePotionEffects().iterator();
							//Figure out potion effects when player joins.
							while (effects.hasNext()) {
								PotionEffect nexteffect = effects.next();
								if (nexteffect.getType().getName().compareTo(PotionEffectType.FAST_DIGGING.getName())==0 && nexteffect.getAmplifier()<4) {
									p.removePotionEffect(PotionEffectType.FAST_DIGGING);
									p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 200, nexteffect.getAmplifier()+1, true));
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
						p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 200, 0, true));
					}
				}
				
				if (this.plugin.hasJobBuff("Miner", p, Job.JOB20) && false) { // Disabled atm
					 if (p.getItemInHand().getType()==Material.DIAMOND_PICKAXE && (e.getBlock().getType()==Material.STONE || e.getBlock().getType()==Material.COBBLESTONE)) {
						for (int i=-1;i<2;i++) {
							for (int j=-1;j<2;j++) {
								for (int k=-1;k<2;k++) {
									if (e.getBlock().getLocation().add(i,j,k).getBlock().getType().name().toLowerCase().contains("ore")) {
										destroyNearbyOres(e.getBlock().getWorld(), p, e.getBlock().getLocation(), has_silktouch, 4);
									} else {
										if (this.plugin.PlayerinJob(p, "Miner")) {
											myData=this.plugin.getPlayerDataSlot(p);
											if (this.plugin.playerdata_list.get(myData).GoodInteract()) {
												if (e.getBlock().getType()==Material.STONE) {
													this.plugin.gainMoneyExp(p,"Miner",0.0025,1);
												}
											}
										}
										if (e.getBlock().getLocation().add(i,j,k).getBlock().getType()==Material.STONE || e.getBlock().getLocation().add(i,j,k).getBlock().getType()==Material.COBBLESTONE) {
											
											if (has_silktouch) {
												e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(i,j,k), new ItemStack(e.getBlock().getLocation().add(i,j,k).getBlock().getType()));
											} else {
												e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(i,j,k), new ItemStack(Material.COBBLESTONE));
											}
											
											e.getBlock().breakNaturally(p.getItemInHand());
											e.getBlock().getLocation().add(i,j,k).getBlock().setType(Material.AIR);
										}
									}
								}
							}
						}
					}
				}
			}
		} else {
			if (e.getBlock().getType().name().toLowerCase().contains("ore")) {
				//Mine it out normally for other players.
				e.setCancelled(true);
				breakOreBlock(p, e.getBlock(), has_silktouch);
			}
		}
		if (this.plugin.hasJobBuff("Digger", p, Job.JOB5)) {
			//Applies to dirt, sand, and gravel blocks. A small chance that a nearby block drops an artifact piece (clay with enchantment to glow)
			double findrate = 0.0025; /*0.25% chance*/
			if (this.plugin.hasJobBuff("Digger", p, Job.JOB20)) {
				findrate=0.003125; /*0.31% chance*/
			}
			if ((e.getBlock().getType()==Material.DIRT ||
					e.getBlock().getType()==Material.SOUL_SAND ||
					e.getBlock().getType()==Material.CLAY ||
					e.getBlock().getType()==Material.GRASS ||
					e.getBlock().getType()==Material.SAND ||
					e.getBlock().getType()==Material.GRAVEL) && Math.random()<=findrate) {
				ItemStack artifact = new ItemStack(Material.CLAY_BALL);
				ItemMeta meta = artifact.getItemMeta();
				List<String> lore = new ArrayList<String>();
				lore.add("This clump of material seems to");
				lore.add("be part of something ancient.");
				lore.add("");
				lore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"Combine this piece with Eyes of Ender");
				lore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"to perhaps restore its true potential.");
				meta.setLore(lore);
				artifact.setItemMeta(meta);
				e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), artifact);
			}
		}
		if (p.getItemInHand().getType()==Material.WOOD_SPADE && this.plugin.hasJobBuff("Digger", p, Job.JOB20)) {
			if (this.plugin.getPlayerData(p).GoodInteract()) {
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
			if (e.getBlock().getType()==Material.SAND ||
					e.getBlock().getType()==Material.GRAVEL) {
				double findrate = 0.0025; /*0.25% chance*/
				if (this.plugin.hasJobBuff("Digger", p, Job.JOB20)) {
					findrate=0.003125; /*0.31% chance*/
				}
				//Check above blocks and destroy them if possible.
				//If it's gravel, drop flint sometimes instead. Check if there is silk touch and fortune too to modify the result.
				int y = 1;
				while ((e.getBlock().getWorld().getBlockAt(e.getBlock().getLocation().add(0,y,0)).getType()==Material.SAND ||
						e.getBlock().getWorld().getBlockAt(e.getBlock().getLocation().add(0,y,0)).getType()==Material.GRAVEL) &&
						e.getBlock().getLocation().getBlockY()+y<=256) {
					if (e.getBlock().getWorld().getBlockAt(e.getBlock().getLocation().add(0,y,0)).getType()==Material.SAND) {
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0,y,0), new ItemStack(Material.SAND));
					} else {
						//This is gravel.
						if (p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS)>0) {
							//Multiply chance of getting flint instead of gravel.
							if (Math.random()<=0.25*p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS)) {
								e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0,y,0), new ItemStack(Material.FLINT));
							} else {
								e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0,y,0), new ItemStack(Material.GRAVEL));
							}
						} else
						if (p.getItemInHand().getEnchantmentLevel(Enchantment.SILK_TOUCH)>0) {
							//Always drop gravel.
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0,y,0), new ItemStack(Material.GRAVEL));
						} else {
							//Drop flint sometimes.
							if (Math.random()<=0.10) {
								e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0,y,0), new ItemStack(Material.FLINT));
							} else {
								e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0,y,0), new ItemStack(Material.GRAVEL));
							}
						}
					}
					getDiggerCredit(p, e.getBlock().getWorld().getBlockAt(e.getBlock().getLocation().add(0,y,0)));
					e.getBlock().getWorld().getBlockAt(e.getBlock().getLocation().add(0,y,0)).setType(Material.AIR);
					if (Math.random()<=findrate) {
						ItemStack artifact = new ItemStack(Material.CLAY_BALL);
						ItemMeta meta = artifact.getItemMeta();
						List<String> lore = new ArrayList<String>();
						lore.add("This clump of material seems to");
						lore.add("be part of something ancient.");
						lore.add("");
						lore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"Combine this piece with Eyes of Ender");
						lore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"to perhaps restore its true potential.");
						meta.setLore(lore);
						artifact.setItemMeta(meta);
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), artifact);
					}
					y++;
				}
			}
		}
		if (p.getItemInHand().getType()==Material.WOOD_SPADE && this.plugin.hasJobBuff("Digger", p, Job.JOB30B)) {
			boolean is_battleShovel=false;
			if (p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasLore()) {
				for (int i=0;i<p.getItemInHand().getItemMeta().getLore().size();i++) {
					if (p.getItemInHand().getItemMeta().getLore().get(i).contains(ChatColor.GOLD+"Whenever this shovel destroys")) {
						is_battleShovel=true;
					}
				}
			}
			if (is_battleShovel) {
				//Bukkit.getLogger().info("Facing vector: "+p.getLocation().getDirection().toString());
				this.plugin.ARROW_SHOOTERS.add(new ArrowShooter(p.getLocation().getDirection(), e.getBlock().getLocation().add(0.5,0.5,-0.5), 80, 4, p, 4.0f, 8f));
			}
		}
		if (p.getItemInHand().getType().name().toLowerCase().contains("spade") && this.plugin.hasJobBuff("Digger", p, Job.JOB30A)) {
			p.getItemInHand().setDurability((short)0);
		}
		//*******************************//Job Buffs end here!

		myData=this.plugin.getPlayerDataSlot(p);
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
					boolean clearair=false;
					//Check air density. Please.
	    			int airmeasure=0;
	    			//Get the underground chunk density of this chunk.
	    			//Max chunk density is 12800.
	    			Chunk c = p.getWorld().getChunkAt(p.getLocation());
	    			for (int x=0;x<16;x++) {
	        			for (int y=0;y<50;y++) {
	            			for (int z=0;z<16;z++) {
	            				if (c.getBlock(x, y, z).getType()==Material.AIR) {
	            					airmeasure++;
	            				}
	            			}
	        			}
	    			}
	    			if (((double)airmeasure/12800)*100.0d<=6.5) {
	    				clearair=true;
	    			}
					if (!torch1) {
						if (clearair) {
	 						int lb1=(int)(Math.random()*5)+1,lb2=(int)(Math.random()*5)+1,ub1=-(int)(Math.random()*6)+1,ub2=-(int)(Math.random()*6)+1;
							for (int j=lb1;j>ub1;j--) {
								for (int k=2;k>-1;k--) {
									for (int l=lb2;l>-ub2;l--) {
										Block b =Bukkit.getWorld("world").getBlockAt(p.getLocation().add(10+j,k,spread+l));
										if (b.getType()!=Material.BEDROCK && b.getType()!=Material.MOB_SPAWNER && b.getType()!=Material.ENDER_PORTAL && b.getType()!=Material.ENDER_PORTAL_FRAME && naturalBlock(b.getType())) {
											//b.setType(Material.AIR);
										}
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
						if (clearair) {
							int lb1=(int)(Math.random()*5)+1,lb2=(int)(Math.random()*5)+1,ub1=-(int)(Math.random()*6)+1,ub2=-(int)(Math.random()*6)+1;
							for (int j=lb1;j>ub1;j--) {
								for (int k=2;k>-1;k--) {
									for (int l=lb2;l>-ub2;l--) {
										Block b =Bukkit.getWorld("world").getBlockAt(p.getLocation().add(-10+j,k,spread+l));
										if (b.getType()!=Material.BEDROCK && b.getType()!=Material.MOB_SPAWNER && b.getType()!=Material.ENDER_PORTAL && b.getType()!=Material.ENDER_PORTAL_FRAME && naturalBlock(b.getType())) {
											//b.setType(Material.AIR);
										}
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
						if (clearair) {
							int lb1=(int)(Math.random()*5)+1,lb2=(int)(Math.random()*5)+1,ub1=-(int)(Math.random()*6)+1,ub2=-(int)(Math.random()*6)+1;
							for (int j=lb1;j>ub1;j--) {
								for (int k=2;k>-1;k--) {
									for (int l=lb2;l>-ub2;l--) {
										Block b =Bukkit.getWorld("world").getBlockAt(p.getLocation().add(spread+j,k,10+l));
										if (b.getType()!=Material.BEDROCK && b.getType()!=Material.MOB_SPAWNER && b.getType()!=Material.ENDER_PORTAL && b.getType()!=Material.ENDER_PORTAL_FRAME && naturalBlock(b.getType())) {
											//b.setType(Material.AIR);
										}
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
						if (clearair) {
							int lb1=(int)(Math.random()*5)+1,lb2=(int)(Math.random()*5)+1,ub1=-(int)(Math.random()*6)+1,ub2=-(int)(Math.random()*6)+1;
							for (int j=lb1;j>ub1;j--) {
								for (int k=2;k>-1;k--) {
									for (int l=lb2;l>-ub2;l--) {
										Block b =Bukkit.getWorld("world").getBlockAt(p.getLocation().add(spread+j,k,-10+l));
										if (b.getType()!=Material.BEDROCK && b.getType()!=Material.MOB_SPAWNER && b.getType()!=Material.ENDER_PORTAL && b.getType()!=Material.ENDER_PORTAL_FRAME && naturalBlock(b.getType())) {
											//b.setType(Material.AIR);
										}
									}
								}
							}
						}
						e4 = Bukkit.getWorld("world").spawnEntity(p.getLocation().add(spread,0,-10), EntityType.ZOMBIE);
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
			if (this.plugin.PlayerinJob(p, "Digger")) {
				getDiggerCredit(p, e.getBlock());
			}
			if (this.plugin.PlayerinJob(p, "Woodcutter")) {
				if (this.plugin.playerdata_list.get(myData).GoodInteract()) {
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
			}
			if (this.plugin.PlayerinJob(p, "Miner")) {
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
			  }
			  if (e.getBlock().getType()==Material.MELON_BLOCK) {
				  this.plugin.gainMoneyExp(p,"Farmer",0.10,10);
			  }*/
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
			if (e.getBlock().getType()==Material.MOB_SPAWNER) {
				p.setLevel(p.getLevel()+30);
				try {
					Iterator<PotionEffect> effects = p.getActivePotionEffects().iterator();
					//Figure out potion effects when player joins.
					while (effects.hasNext()) {
						PotionEffect nexteffect = effects.next();
						if (nexteffect.getType().getName().compareTo(PotionEffectType.SPEED.getName())==0 && nexteffect.getAmplifier()<4) {
							p.removePotionEffect(PotionEffectType.SPEED);
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 360000, nexteffect.getAmplifier()+2, true));
						}
						if (nexteffect.getType().getName().compareTo(PotionEffectType.HEALTH_BOOST.getName())==0) {
							double myhealth = p.getHealth();
							p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 360000, nexteffect.getAmplifier()+1, true));
							p.setHealth(myhealth);
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
			if (this.plugin.getConfig().getBoolean("spleefinsession")==true && (this.plugin.getConfig().getString("spleefrequestaplayer").compareTo(p.getName().toLowerCase())==0 || this.plugin.getConfig().getString("spleefrequestbplayer").compareTo(p.getName().toLowerCase())==0)) {
				this.plugin.spleef_last_broken_block=p.getPlayerTime();
			}
			if (this.plugin.getConfig().getBoolean("spleef4insession")==true && (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName().toLowerCase())==0 || this.plugin.getConfig().getString("spleefrequestb4player").compareTo(p.getName().toLowerCase())==0 || this.plugin.getConfig().getString("spleefrequestc4player").compareTo(p.getName().toLowerCase())==0 || this.plugin.getConfig().getString("spleefrequestd4player").compareTo(p.getName().toLowerCase())==0)) {
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
		if (e.getBlock().getType()==Material.MELON_BLOCK) {
			e.setCancelled(true);
			e.getPlayer().getWorld().getBlockAt(e.getBlock().getLocation()).setType(Material.AIR);
			e.getPlayer().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.MELON_BLOCK));
		}
		if (e.getBlock().getType()==Material.STEP && e.getBlock().getData()==2) {
			e.setCancelled(true);
			e.getPlayer().getWorld().getBlockAt(e.getBlock().getLocation()).setType(Material.AIR);
			ItemStack fireproof_slab = new ItemStack(Material.STEP,1,(short)2);
			ItemMeta meta = fireproof_slab.getItemMeta();
			meta.setDisplayName(ChatColor.RESET+"Fireproof Wood Slab");
			fireproof_slab.setItemMeta(meta);
			e.getPlayer().getWorld().dropItemNaturally(e.getBlock().getLocation(), fireproof_slab);
		} else
			if (e.getBlock().getType()==Material.DOUBLE_STEP && e.getBlock().getData()==2) { //Drop 2 instead.
				e.setCancelled(true);
				e.getPlayer().getWorld().getBlockAt(e.getBlock().getLocation()).setType(Material.AIR);
				ItemStack fireproof_slab = new ItemStack(Material.STEP,2,(short)2);
				ItemMeta meta = fireproof_slab.getItemMeta();
				meta.setDisplayName(ChatColor.RESET+"Fireproof Wood Slab");
				fireproof_slab.setItemMeta(meta);
				e.getPlayer().getWorld().dropItemNaturally(e.getBlock().getLocation(), fireproof_slab);
			}
		return;
	}

	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {
		//If the player is a support, drop it with only 1 second of wait time.
		Player p = e.getPlayer();
		if (e.getItemDrop().getItemStack().hasItemMeta() && e.getItemDrop().getItemStack().getItemMeta().hasDisplayName()) {
			if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE+""+ChatColor.ITALIC+"Rename Item")) {
				e.getItemDrop().setPickupDelay(0);
				e.getItemDrop().teleport(p);
				this.plugin.getPlayerData(p).is_renaming_item=true;
				p.sendMessage(ChatColor.GREEN+"Please type in chat the new name of your "+convertToItemName(e.getItemDrop().getItemStack().getType().name())+".");
			}
			if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GRAY+""+ChatColor.ITALIC+"[Temporary Item]")) {
				//Bukkit.getLogger().info("This is a temporary item.");
				e.getItemDrop().setPickupDelay(0);
				//p.getInventory().addItem(e.getItemDrop().getItemStack());
				//e.getItemDrop().getItemStack().getItemMeta(
				//e.getItemDrop().remove();
			}
		}
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
	public void onItemConsume(PlayerItemConsumeEvent e) {
		final Player p = e.getPlayer();
		Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
			@Override
			public void run() {
				p.getScoreboard().getTeam(p.getName().toLowerCase()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth(),p.getFoodLevel()));
			}
		},5);
		if (isFood(e.getItem()) && e.getItem().hasItemMeta() && e.getItem().getItemMeta().hasLore()) {
			//We need to parse the lore for any additional effects to give.
			List<String> itemlore = e.getItem().getItemMeta().getLore();
			if (itemlore.contains("This food item was fabulously")) {
				int hungerincrease=0;
				float saturationincrease=0;
				switch (e.getItem().getType()) {
					case POTATO:{hungerincrease=1;}break;
					case COOKIE:
					case MELON:
					case POISONOUS_POTATO:
					case RAW_CHICKEN:
					case SPIDER_EYE:
					case RAW_FISH:{hungerincrease=2;}break;
					case PORK:
					case RAW_BEEF:{hungerincrease=3;}break;
					case ROTTEN_FLESH:
					case CARROT_ITEM:
					case GOLDEN_APPLE:
					case APPLE:{hungerincrease=4;}break;
					case BREAD:
					case COOKED_FISH:{hungerincrease=5;}break;
					case MUSHROOM_SOUP:
					case BAKED_POTATO:
					case COOKED_CHICKEN:
					case GOLDEN_CARROT:{hungerincrease=6;}break;
					case PUMPKIN_PIE:
					case COOKED_BEEF:
					case GRILLED_PORK:{hungerincrease=8;}break;
				}
				switch (e.getItem().getType()) {
					case COOKIE:
					case RAW_FISH:{saturationincrease=0.4f;}break;
					case POTATO:{saturationincrease=0.6f;}break;
					case ROTTEN_FLESH:{saturationincrease=0.8f;}break;
					case MELON:
					case RAW_CHICKEN:
					case POISONOUS_POTATO:{saturationincrease=1.2f;}break;
					case PORK:
					case RAW_BEEF:{saturationincrease=1.8f;}break;
					case APPLE:{saturationincrease=2.4f;}break;
					case SPIDER_EYE:{saturationincrease=3.2f;}break;
					case CARROT:{saturationincrease=4.8f;}break;
					case PUMPKIN_PIE:
					case BREAD:{saturationincrease=6f;}break;
					case BAKED_POTATO:
					case COOKED_CHICKEN:
					case MUSHROOM_SOUP:{saturationincrease=7.2f;}break;
					case GOLDEN_APPLE:{saturationincrease=9.6f;}break;
					case COOKED_BEEF:
					case GRILLED_PORK:{saturationincrease=12.8f;}break;
					case GOLDEN_CARROT:{saturationincrease=14.4f;}break;
				}
				p.setFoodLevel(p.getFoodLevel()+hungerincrease);
				p.setSaturation(p.getSaturation()+saturationincrease);
				if (p.getSaturation()>30f) {
					p.setSaturation(30f);
				}
				if (p.getHealth()+2<p.getMaxHealth()) {
					p.setHealth(p.getHealth()+2);
				} else {
					p.setHealth(p.getMaxHealth());
				}
			}
			if (itemlore.contains(" "+ChatColor.GRAY+"Night Vision (1:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,1200,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Night Vision (4:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,4800,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Night Vision (16:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,19200,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Regeneration I (1:00)")) {Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {@Override public void run() {p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,1200,0),true);}},5);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Regeneration II (1:00)")) {Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {@Override public void run() {p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,1200,1),true);}},5);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Regeneration I (4:00)")) {Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {@Override public void run() {p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,4800,0),true);}},5);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Regeneration III (4:00)")) {Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {@Override public void run() {p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,4800,2),true);}},5);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Regeneration II (16:00)")) {Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {@Override public void run() {p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,19200,1),true);}},5);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Strength I (1:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,1200,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Strength II (1:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,1200,1),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Strength I (4:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,4800,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Strength III (4:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,4800,2),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Strength II (16:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,19200,1),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Water Breathing (1:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,1200,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Water Breathing (4:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,4800,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Water Breathing (16:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,19200,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Fire Resistance (1:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,1200,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Fire Resistance (4:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,4800,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Fire Resistance (16:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,19200,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Haste I (1:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,1200,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Haste II (1:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,1200,1),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Haste I (4:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,4800,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Haste III (4:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,4800,2),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Haste II (16:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,19200,1),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Jump Boost I (1:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,1200,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Jump Boost II (1:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,1200,1),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Jump Boost I (4:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,4800,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Jump Boost III (4:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,4800,2),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Jump Boost II (16:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,19200,1),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Speed I (1:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,1200,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Speed II (1:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,1200,1),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Speed I (4:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,4800,0),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Speed III (4:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,4800,2),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Speed II (16:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,19200,1),true);}
			if (itemlore.contains(" "+ChatColor.GRAY+"Saturation (2:00)")) {p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION,2400,1),true);}
			if (itemlore.contains(" "+ChatColor.BLUE+"Heals 6 HP "+Character.toString((char)0x2665)+Character.toString((char)0x2665)+Character.toString((char)0x2665))) {if (p.getHealth()+6<p.getMaxHealth()) {p.setHealth(p.getHealth()+6);} else {p.setHealth(p.getMaxHealth());}}
		}
		if (e.getItem().getType()==Material.MILK_BUCKET) {
			for (int i=0;i<this.plugin.SPEED_CONTROL.size();i++) {
				if (this.plugin.SPEED_CONTROL.get(i).p.getName().equalsIgnoreCase(p.getName().toLowerCase())) {
					this.plugin.SPEED_CONTROL.get(i).potion_time=Main.SERVER_TICK_TIME;
					this.plugin.SPEED_CONTROL.get(i).potion_spdlv=0;
					break;
				}
			}
		} else
			if (e.getItem().getType()==Material.POTION) {
				if (e.getItem().getDurability()!=0) {
					Potion pot = Potion.fromItemStack(e.getItem());
					//Bukkit.getLogger().info("Potion type is "+pot.getType()+", Level is "+pot.getLevel());
					PotionEffectType typeset = null;
					if (pot.getType()!=null) {
						switch (pot.getType()) {
							case FIRE_RESISTANCE: {
								typeset = PotionEffectType.FIRE_RESISTANCE;
							}break;
							case SPEED: {
								typeset = PotionEffectType.SPEED;
							}break;
							case POISON: {
								typeset = PotionEffectType.POISON;
							}break;
							case NIGHT_VISION: {
								typeset = PotionEffectType.NIGHT_VISION;
							}break;
							case REGEN: {
								typeset = PotionEffectType.REGENERATION;
							}break;
							case WEAKNESS: {
								typeset = PotionEffectType.WEAKNESS;
							}break;
							case STRENGTH: {
								typeset = PotionEffectType.INCREASE_DAMAGE;
							}break;
							case SLOWNESS: {
								typeset = PotionEffectType.SLOW;
							}break;
							case INVISIBILITY: {
								typeset = PotionEffectType.INVISIBILITY;
							}break;
						}
					}
					/*
					if (e.getItem().getItemMeta().hasLore() &&
						e.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"30 Minute Duration")) {
							if (typeset!=null) {
								//Apply a 30 minute buff on it.
								p.addPotionEffect(new PotionEffect(typeset, 36000, pot.getLevel()-1),true);
							}
						}*/
				}
				//p.sendMessage("This is the data: "+e.getItem().getData());
				if (e.getItem().getDurability()==11 && e.getItem().getItemMeta().hasLore() &&
						e.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"+50% Attack Speed (1:30)")) {
					int duration = 1800;
					if (this.plugin.hasJobBuff("Brewer", p, Job.JOB20)) {
						//duration*=2;
					}
					p.sendMessage(ChatColor.YELLOW+"Increased Attack speed by 50% for "+((duration==1800)?"1:30":"3:00")+".");
					this.plugin.getPlayerData(p).furytime=Main.SERVER_TICK_TIME+duration;
					this.plugin.getPlayerData(p).furyamt=50;
				}
				if (e.getItem().getDurability()==15 && e.getItem().getItemMeta().hasLore() &&
						e.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"+150% Attack Speed (0:45)")) {
					int duration = 900;
					if (this.plugin.hasJobBuff("Brewer", p, Job.JOB20)) {
						//duration*=2;
					}
					p.sendMessage(ChatColor.YELLOW+"Increased Attack speed by 150% for "+((duration==900)?"0:45":"1:30")+".");
					this.plugin.getPlayerData(p).furytime=Main.SERVER_TICK_TIME+duration;
					this.plugin.getPlayerData(p).furyamt=150;
				}
				if (e.getItem().getDurability()==23 && e.getItem().getItemMeta().hasLore() &&
						e.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"+50% Attack Speed (3:15)")) {
					int duration = 3900;
					if (this.plugin.hasJobBuff("Brewer", p, Job.JOB20)) {
						//duration*=2;
					}
					p.sendMessage(ChatColor.YELLOW+"Increased Attack speed by 50% for "+((duration==3900)?"3:15":"6:30")+".");
					this.plugin.getPlayerData(p).furytime=Main.SERVER_TICK_TIME+duration;
					this.plugin.getPlayerData(p).furyamt=50;
				}
				if (e.getItem().getDurability()==27 && e.getItem().getItemMeta().hasLore() &&
						e.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"+20% Damage Resistance (2:00)")) {
					int duration = 2400;
					if (this.plugin.hasJobBuff("Brewer", p, Job.JOB20)) {
						//duration*=2;
					}
					p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,duration,0),true);
				}
				if (e.getItem().getDurability()==31 && e.getItem().getItemMeta().hasLore() &&
						e.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"+40% Damage Resistance (1:20)")) {
					int duration = 1200;
					if (this.plugin.hasJobBuff("Brewer", p, Job.JOB20)) {
						//duration*=2;
					}
					p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,duration,1),true);
				}
				if (e.getItem().getDurability()==39 && e.getItem().getItemMeta().hasLore() &&
						e.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"+20% Damage Resistance (3:50)")) {
					int duration = 4600;
					if (this.plugin.hasJobBuff("Brewer", p, Job.JOB20)) {
						//duration*=2;
					}
					p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,duration,0),true);
				}
				if (e.getItem().getDurability()==39 && e.getItem().getItemMeta().hasLore() &&
						e.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"sources. (1:20)")) {
					int duration = 1600;
					if (this.plugin.hasJobBuff("Brewer", p, Job.JOB20)) {
						//duration*=2;
					}
					//p.addPotionEffect(new PotionEffect(PotionEffectType.DA,duration,0),true);
					p.sendMessage(ChatColor.YELLOW+"Gained Invulnerability buff for "+((duration==1600)?"1:20":"2:40")+".");
					this.plugin.getPlayerData(p).invulntime=Main.SERVER_TICK_TIME+duration;
				}
				if (e.getItem().getItemMeta().hasLore() &&
						e.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"Applies "+ChatColor.GRAY+"Strength IV"+ChatColor.GOLD+".")) {
					int duration = 1600;
					switch (e.getItem().getDurability()) {
						case 8201:{duration=3600;}break;
						case 8233:{duration=1800;}break;
						case 8265:{duration=9600;}break;
					}
					
					if (this.plugin.hasJobBuff("Brewer", p, Job.JOB20)) {
						//duration*=2;
					}
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,duration,3),true);
					//p.sendMessage(ChatColor.YELLOW+"Gained Invulnerability buff for "+((duration==1600)?"1:20":"2:40")+".");
					//this.plugin.getPlayerData(p).invulntime=Main.SERVER_TICK_TIME+duration;
				}
				if (e.getItem().getItemMeta().hasLore() &&
						e.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"Heals 4x more Health.")) {
					int duration = 1600;
					switch (e.getItem().getDurability()) {
						case 8201:{duration=3600;}break;
						case 8233:{duration=1800;}break;
						case 8265:{duration=9600;}break;
					}
					
					if (this.plugin.hasJobBuff("Brewer", p, Job.JOB20)) {
						//duration*=2;
					}
					//p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,duration,3),true);
					if (e.getItem().getDurability()==8197 ||
							e.getItem().getDurability()==8261) {
						if (p.getHealth()+16>=p.getMaxHealth()) {
							p.setHealth(p.getMaxHealth());
						} else {
							p.setHealth(p.getHealth()+16);
						}
					} else {
						if (p.getHealth()+32>=p.getMaxHealth()) {
							p.setHealth(p.getMaxHealth());
						} else {
							p.setHealth(p.getHealth()+32);
						}
					}
					//p.sendMessage(ChatColor.YELLOW+"Gained Invulnerability buff for "+((duration==1600)?"1:20":"2:40")+".");
					//this.plugin.getPlayerData(p).invulntime=Main.SERVER_TICK_TIME+duration;
				}
				if (e.getItem().getDurability()==7 && e.getItem().getItemMeta().hasLore() &&
						e.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"Drink to reveal nearby mob tags.")) {
					//Now go ahead and reveal all nearby nametags.
					List<Entity> nearby = p.getNearbyEntities(30, 20, 30);
					for (int i=0;i<nearby.size();i++) {
						if (nearby.get(i) instanceof LivingEntity) {
							LivingEntity l = (LivingEntity)nearby.get(i);
							if (l.getCustomName()==null) {
								l.setCustomName(ChatColor.WHITE+l.getType().name());
								l.setCustomNameVisible(true);
							}
							l.setCustomNameVisible(true);
						}
					}
					if (this.plugin.hasJobBuff("Brewer", p, Job.JOB20)) {
						this.plugin.last_sight_check_time = Main.SERVER_TICK_TIME-200;
					} else {
						this.plugin.last_sight_check_time = Main.SERVER_TICK_TIME;
					}
				}
			}
	}
	
	/**
	 * Converts a number of ticks to a timestamp.
	 * @param ticks The number of game ticks to convert.
	 * @return A string containing the timestamp in format: (XX:XX:XX).
	 *  If it's just seconds, it returns X seconds.
	 */
	private String convertTime(int ticks) {
		boolean hours=false,minutes=false,secs=false;
		Bukkit.getLogger().info("Convert "+ticks+" ticks.");
		if (ticks>0) {
			secs=true;
		}
		if (ticks>=1200) {
			minutes=true;
		}
		if (ticks>=72000) {
			hours=true;
		}
		if (hours) {
			return ((ticks/72000)%24)+":"+((((ticks/1200)%60)<10)?"0"+((ticks/1200)%60):((ticks/1200)%60))+":"+((((ticks/20)%60)<10)?"0"+((ticks/20)%60):((ticks/20)%60));
		}
		if (minutes) {
			return ((ticks/1200)%60)+":"+((((ticks/20)%60)<10)?"0"+((ticks/20)%60):((ticks/20)%60));
		}
		if (secs) {
			return ""+((ticks/20)%60)+" seconds";
		}
		return "";
	}

	@EventHandler
	public void onPotionSplash(PotionSplashEvent e) {
		ThrownPotion pot = e.getEntity();
		LivingEntity theshooter = (LivingEntity)pot.getShooter();
		if (pot.getItem().getItemMeta().hasLore() &&
				pot.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"+50% Attack Speed (1:20)")) {
			int duration = 1600;
			if (theshooter instanceof Player) {
				Player pshooter = (Player)theshooter;
				if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB20)) {
					duration*=2;
				}
				if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB40)) {
					duration=36000;
				}
			}
			Collection<LivingEntity> splashed = e.getAffectedEntities();
			for (LivingEntity l : splashed) {
				duration = (int)(e.getIntensity(l)*duration);
				if (l instanceof Player) {
					Player p = (Player)l;
					if (theshooter instanceof Player) {
						p.sendMessage(ChatColor.YELLOW+"Gained +50% Attack Speed buff for "+(convertTime(duration))+" from "+((Player)theshooter).getName()+".");
					}
					this.plugin.getPlayerData(p).furytime=Main.SERVER_TICK_TIME+duration;
					this.plugin.getPlayerData(p).furyamt=50;
				}
			}
		} else
		if (pot.getItem().getItemMeta().hasLore() &&
				pot.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"+50% Attack Speed (2:30)")) {
			int duration = 3000;
			if (theshooter instanceof Player) {
				Player pshooter = (Player)theshooter;
				if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB20)) {
					duration*=2;
				}
				if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB40)) {
					duration=36000;
				}
			}
			Collection<LivingEntity> splashed = e.getAffectedEntities();
			for (LivingEntity l : splashed) {
				duration = (int)(e.getIntensity(l)*duration);
				if (l instanceof Player) {
					Player p = (Player)l;
					if (theshooter instanceof Player) {
						p.sendMessage(ChatColor.YELLOW+"Gained +50% Attack Speed buff for "+(convertTime(duration))+" from "+((Player)theshooter).getName()+".");
					}
					this.plugin.getPlayerData(p).furytime=Main.SERVER_TICK_TIME+duration;
					this.plugin.getPlayerData(p).furyamt=50;
				}
			}
		} else
		if (pot.getItem().getItemMeta().hasLore() &&
				pot.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"+150% Attack Speed (0:30)")) {
			int duration = 600;
			if (theshooter instanceof Player) {
				Player pshooter = (Player)theshooter;
				if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB20)) {
					duration*=2;
				}
				if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB40)) {
					duration=36000;
				}
			}
			Collection<LivingEntity> splashed = e.getAffectedEntities();
			for (LivingEntity l : splashed) {
				duration = (int)(e.getIntensity(l)*duration);
				if (l instanceof Player) {
					Player p = (Player)l;
					if (theshooter instanceof Player) {
						p.sendMessage(ChatColor.YELLOW+"Gained +150% Attack Speed buff for "+(convertTime(duration))+" from "+((Player)theshooter).getName()+".");
					}
					this.plugin.getPlayerData(p).furytime=Main.SERVER_TICK_TIME+duration;
					this.plugin.getPlayerData(p).furyamt=150;
				}
			}
		} else
		if (pot.getItem().getItemMeta().hasLore() &&
				pot.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"+20% Damage Resistance (1:45)")) {
			int duration = 2100;
			if (theshooter instanceof Player) {
				Player pshooter = (Player)theshooter;
				if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB20)) {
					duration*=2;
				}
				if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB40)) {
					duration=36000;
				}
			}
			Collection<LivingEntity> splashed = e.getAffectedEntities();
			for (LivingEntity l : splashed) {
				duration = (int)(e.getIntensity(l)*duration);
				if (l instanceof Player) {
					Player p = (Player)l;
					p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, 0),true);
				}
			}
		} else
		if (pot.getItem().getItemMeta().hasLore() &&
				pot.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"+40% Damage Resistance (1:00)")) {
			int duration = 1200;
			if (theshooter instanceof Player) {
				Player pshooter = (Player)theshooter;
				if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB20)) {
					duration*=2;
				}
				if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB40)) {
					duration=36000;
				}
			}
			Collection<LivingEntity> splashed = e.getAffectedEntities();
			for (LivingEntity l : splashed) {
				duration = (int)(e.getIntensity(l)*duration);
				if (l instanceof Player) {
					Player p = (Player)l;
					p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, 1),true);
				}
			}
		} else
		if (pot.getItem().getItemMeta().hasLore() &&
				pot.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"+20% Damage Resistance (2:45)")) {
			int duration = 3300;
			if (theshooter instanceof Player) {
				Player pshooter = (Player)theshooter;
				if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB20)) {
					duration*=2;
				}
				if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB40)) {
					duration=36000;
				}
			}
			Collection<LivingEntity> splashed = e.getAffectedEntities();
			for (LivingEntity l : splashed) {
				duration = (int)(e.getIntensity(l)*duration);
				if (l instanceof Player) {
					Player p = (Player)l;
					p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, 0),true);
				}
			}
		} else
			if (pot.getItem().getItemMeta().hasLore() &&
					pot.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"Heals 4x more Health.")) {
				int duration = 3300;
				if (theshooter instanceof Player) {
					Player pshooter = (Player)theshooter;
					if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB20)) {
						duration*=2;
					}
					if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB40)) {
						duration=36000;
					}
				}
				Collection<LivingEntity> splashed = e.getAffectedEntities();
				for (LivingEntity l : splashed) {
					duration = (int)(e.getIntensity(l)*duration);
					if (l instanceof Player) {
						Player p = (Player)l;
						//p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, 0),true);
						if (pot.getItem().getDurability()==8197 || pot.getItem().getDurability()==8261 ||
								 pot.getItem().getDurability()==16389 || pot.getItem().getDurability()==16453) {
							//This is a weak heal.
							if (p.getHealth()+((int)(16*e.getIntensity(l)))>=p.getMaxHealth()) {
								p.setHealth(p.getMaxHealth());
							} else {
								p.setHealth(p.getHealth()+((int)(16*e.getIntensity(l))));
							}
						} else {
							//Strong heals all day here.
							if (p.getHealth()+((int)(32*e.getIntensity(l)))>=p.getMaxHealth()) {
								p.setHealth(p.getMaxHealth());
							} else {
								p.setHealth(p.getHealth()+((int)(32*e.getIntensity(l))));
							}
						}
					}
				}
			} else
		if (pot.getItem().getItemMeta().hasLore() &&
				pot.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"sources. (0:55)")) {
			int duration = 1100;
			if (theshooter instanceof Player) {
				Player pshooter = (Player)theshooter;
				if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB20)) {
					//duration*=2;
				}
			}
			Collection<LivingEntity> splashed = e.getAffectedEntities();
			for (LivingEntity l : splashed) {
				duration = (int)(e.getIntensity(l)*duration);
				if (l instanceof Player) {
					Player p = (Player)l;
					//p.addPotionEffect(new PotionEffect(PotionEffectType., duration, 0),true);
					if (theshooter instanceof Player) {
						p.sendMessage(ChatColor.YELLOW+"Gained Invulnerability buff for "+(convertTime(duration))+" from "+((Player)theshooter).getName()+".");
					}
					this.plugin.getPlayerData(p).invulntime = Main.SERVER_TICK_TIME + duration;
				}
			}
		} else
		if (theshooter instanceof Player) {
			boolean strengthbuff = false;
			if (pot.getItem().getItemMeta().hasLore() &&
					pot.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"Applies "+ChatColor.GRAY+"Strength IV"+ChatColor.GOLD+".")) {
				strengthbuff=true;
			}
			Player pshooter = (Player)theshooter;
			if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB20)) {
				Collection<PotionEffect> poteffects = pot.getEffects();
				final List<PotionEffect> activeeffects = new ArrayList<PotionEffect>();
				for (PotionEffect p : poteffects) {
					activeeffects.add(p);
				}
				Collection<LivingEntity> splashed = e.getAffectedEntities();
				for (LivingEntity l : splashed) {
					//Now we just have to double the duration of all types for the affected players.
					if (l instanceof Player) {
						final Player p = (Player)l;
						final boolean strength = strengthbuff;
						Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
							@Override
							public void run() {
								for (int i=0;i<activeeffects.size();i++) {
									if (activeeffects.get(i).getType()==PotionEffectType.INCREASE_DAMAGE && strength) {
										p.addPotionEffect(new PotionEffect(activeeffects.get(i).getType(), activeeffects.get(i).getDuration()*2, 3),true);
									} else {
										p.addPotionEffect(new PotionEffect(activeeffects.get(i).getType(), activeeffects.get(i).getDuration()*2, activeeffects.get(i).getAmplifier()),true);
									}
								}
							}
						},5);
					}
				}
			}
			if (this.plugin.hasJobBuff("Brewer", pshooter, Job.JOB40)) {
				Collection<PotionEffect> poteffects = pot.getEffects();
				final List<PotionEffect> activeeffects = new ArrayList<PotionEffect>();
				for (PotionEffect p : poteffects) {
					activeeffects.add(p);
				}
				Collection<LivingEntity> splashed = e.getAffectedEntities();
				for (LivingEntity l : splashed) {
					//Now we just have to double the duration of all types for the affected players.
					if (l instanceof Player) {
						final Player p = (Player)l;
						final boolean strength = strengthbuff;
						Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
							@Override
							public void run() {
								for (int i=0;i<activeeffects.size();i++) {
									if (activeeffects.get(i).getType()==PotionEffectType.INCREASE_DAMAGE && strength) {
										p.addPotionEffect(new PotionEffect(activeeffects.get(i).getType(), 36000, 3),true);
									} else {
										p.addPotionEffect(new PotionEffect(activeeffects.get(i).getType(), 36000, activeeffects.get(i).getAmplifier()),true);
									}
								}
							}
						},5);
					}
				}
			}
		}
		try {
			Iterator<LivingEntity> entities = e.getAffectedEntities().iterator();
			Player shooter;
			if (((LivingEntity)e.getPotion().getShooter()).getType() == EntityType.PLAYER) {
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
									p.getScoreboard().getTeam(p.getName().toLowerCase()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth(),p.getFoodLevel()));
								}
							},5);
							if (p!=shooter) {
								//Award the support.
								//Bukkit.getPlayer("sigonasr2").sendMessage(p.getName().toLowerCase()+" got hit by your potion!");
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
												if (this.plugin.SPEED_CONTROL.get(i).p.getName().compareTo(p.getName().toLowerCase())==0) {
													this.plugin.SPEED_CONTROL.get(i).potion_spdlv=nextpotioneffect.getAmplifier();
													this.plugin.SPEED_CONTROL.get(i).potion_time=Main.SERVER_TICK_TIME+nextpotioneffect.getDuration();
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
													p.getScoreboard().getTeam(p.getName().toLowerCase()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth(),p.getFoodLevel()));
												}
												//this.plugin.gainMoneyExp(shooter,"Support",0.30,14);
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
										  if (this.plugin.SPEED_CONTROL.get(i).p.getName().compareTo(p.getName().toLowerCase())==0) {
											  this.plugin.SPEED_CONTROL.get(i).potion_spdlv=nextpotioneffect.getAmplifier();
											  this.plugin.SPEED_CONTROL.get(i).potion_time=Main.SERVER_TICK_TIME+nextpotioneffect.getDuration();
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
												if (this.plugin.SPEED_CONTROL.get(i).p.getName().compareTo(p.getName().toLowerCase())==0) {
													this.plugin.SPEED_CONTROL.get(i).potion_spdlv=nextpotioneffect.getAmplifier();
													this.plugin.SPEED_CONTROL.get(i).potion_time=Main.SERVER_TICK_TIME+nextpotioneffect.getDuration();
													this.plugin.SPEED_CONTROL.get(i).updatePlayerSpd();
												}
											}
										}
										if (nextpotioneffect.getType().getName().compareTo("HEAL")==0) {
											if (!p.isDead()) {
												//shooter.sendMessage("This is a heal.");
												p.getScoreboard().getTeam(p.getName().toLowerCase()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth(),p.getFoodLevel()));
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
									p.getScoreboard().getTeam(p.getName().toLowerCase()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth(),p.getFoodLevel()));
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
											if (this.plugin.SPEED_CONTROL.get(i).p.getName().compareTo(p.getName().toLowerCase())==0) {
												this.plugin.SPEED_CONTROL.get(i).potion_spdlv=nextpotioneffect.getAmplifier();
												this.plugin.SPEED_CONTROL.get(i).potion_time=Main.SERVER_TICK_TIME+nextpotioneffect.getDuration();
												this.plugin.SPEED_CONTROL.get(i).updatePlayerSpd();
											}
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
	
	/**
	 * Adds in a special power-up, based on the type of item.
	 * @param i The item to add a powerup to.
	 * @return The powered food item.
	 */
	private ItemStack modifyFoodItem(ItemStack i) {
		return modifyFoodItem(i, 0, 0, false);
	}
	
	/**
	 * Adds in a special power-up, based on the type of item.
	 * @param i The item to add a powerup to.
	 * @param power_increase The amount of levels to add onto this item.
	 * @return The powered food item.
	 */
	private ItemStack modifyFoodItem(ItemStack i, int power_increase) {
		return modifyFoodItem(i, power_increase, 0, false);
	}
	
	/**
	 * Adds in a special power-up, based on the type of item.
	 * @param i The item to add a powerup to.
	 * @param power_increase The amount of levels to add onto this item.
	 * @param duration_increase The amount of time (in ticks) to add onto this item.
	 * @return The powered food item.
	 */
	private ItemStack modifyFoodItem(ItemStack i, int power_increase, int duration_increase) {
		return modifyFoodItem(i, power_increase, duration_increase, false);
	}

	/**
	 * Adds in a special power-up, based on the type of item.
	 * @param i The item to add a powerup to.
	 * @param power_increase The amount of levels to add onto this item.
	 * @param duration_increase The amount of time (in ticks) to add onto this item.
	 * @param ult Whether or not to give the food the Ultimate-infused version.
	 * @return The powered food item.
	 */
	private ItemStack modifyFoodItem(ItemStack i, int power_increase, int duration_increase, boolean ult) {
		//Assumes the user is allowed to do this. Buffs a food item in a certain way.
		i.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
		int power_level = power_increase + 1;
		int duration_level = duration_increase + 1;
		List<String> lore = null,altlore = null;
		if (i.hasItemMeta() && i.getItemMeta().hasLore()) {
			lore = i.getItemMeta().getLore();
			altlore = i.getItemMeta().getLore();
		} else {
			lore = new ArrayList<String>();
			lore = new ArrayList<String>();
		}
		lore.add("");
		lore.add(ChatColor.AQUA+"Additional Effects:");
		if (ult) {
			lore.add(" "+ChatColor.BLUE+"Heals 6 HP "+Character.toString((char)0x2665)+Character.toString((char)0x2665)+Character.toString((char)0x2665));
			lore.add(" "+ChatColor.GRAY+"Saturation (2:00)");
			if (duration_level==4) {duration_level=16;} else {duration_level=4;}
			power_level++;
			altlore.add("");
			altlore.add(ChatColor.AQUA+"Additional Effects:");
			altlore.add(" "+ChatColor.BLUE+"Heals 6 HP "+Character.toString((char)0x2665)+Character.toString((char)0x2665)+Character.toString((char)0x2665));
			altlore.add(" "+ChatColor.GRAY+"Saturation (2:00)");
		}
		String duration = "";
		boolean no_effect=false;
		switch (duration_level) {
			case 1:{
				duration = "1:00";
			}break;
			case 4:{
				duration = "4:00";
			}break;
			case 16:{
				duration = "16:00";
			}break;
		}
		switch (i.getType()) {
			case GOLDEN_CARROT:{lore.add(" "+ChatColor.GRAY+"Night Vision ("+duration+")");}break;
			case GOLDEN_APPLE:{lore.add(" "+ChatColor.GRAY+"Regeneration "+this.plugin.toRomanNumeral(power_level)+" ("+duration+")");}break;
			case COOKED_BEEF:
			case GRILLED_PORK:{lore.add(" "+ChatColor.GRAY+"Strength "+this.plugin.toRomanNumeral(power_level)+" ("+duration+")");}break;
			case COOKED_FISH:{lore.add(" "+ChatColor.GRAY+"Water Breathing ("+duration+")");}break;
			case BREAD:{lore.add(" "+ChatColor.GRAY+"Fire Resistance ("+duration+")");}break;
			case MUSHROOM_SOUP:{lore.add(" "+ChatColor.GRAY+"Haste "+this.plugin.toRomanNumeral(power_level)+" ("+duration+")");}break;
			case COOKED_CHICKEN:{lore.add(" "+ChatColor.GRAY+"Jump Boost "+this.plugin.toRomanNumeral(power_level)+" ("+duration+")");}break;
			case BAKED_POTATO:{lore.add(" "+ChatColor.GRAY+"Speed "+this.plugin.toRomanNumeral(power_level)+" ("+duration+")");}break;
			default: {no_effect=true;}
		}
		if (no_effect) {
			ItemMeta meta = i.getItemMeta();
			meta.setLore(altlore);
			i.setItemMeta(meta);
			return i;
		} else {
			ItemMeta meta = i.getItemMeta();
			meta.setLore(lore);
			i.setItemMeta(meta);
			return i;
		}
	}

	@EventHandler
	public void onItemPrepareCraft(PrepareItemCraftEvent e) {
		CraftingInventory result = e.getInventory();
		
		//Bukkit.getLogger().info("Triggered PrepareItemCraftEvent.");
		
		//****************************// Job Boofs poof here.

		if (result.getResult().getType()==Material.WOOD) {
			if (this.plugin.hasJobBuff("Woodcutter", e.getView().getPlayer().getName(), Job.JOB40)) {
				result.setResult(new ItemStack(Material.WOOD,20,result.getResult().getData().getData()));
			} else
			if (this.plugin.hasJobBuff("Woodcutter", e.getView().getPlayer().getName(), Job.JOB30B)) {
				result.setResult(new ItemStack(Material.WOOD,10,result.getResult().getData().getData()));
			} else
			if (this.plugin.hasJobBuff("Woodcutter", e.getView().getPlayer().getName(), Job.JOB10)) {
				result.setResult(new ItemStack(Material.WOOD,6,result.getResult().getData().getData()));
			}
		}
		if (result.getResult().getType()==Material.CLAY_BALL) {
			//Check to see if there is an artifact in the crafting grid.
			boolean artifact=false, ender_eye=false;
			for (int i=0;i<result.getMatrix().length;i++) {
				if (result.getMatrix()[i]!=null) {
					if (result.getMatrix()[i].getType()==Material.CLAY_BALL) {
						//See if it's an artifact.
						if (result.getMatrix()[i].hasItemMeta() && result.getMatrix()[i].getItemMeta().hasLore()) {
							for (int j=0;j<result.getMatrix()[i].getItemMeta().getLore().size();j++) {
								if (result.getMatrix()[i].getItemMeta().getLore().get(j).contains("This clump of material seems to")) {
									Bukkit.getLogger().info("Found the lore line.");
									artifact=true;
								}
							}
						}
					}
					if (result.getMatrix()[i].getType()==Material.EYE_OF_ENDER) {
						Bukkit.getLogger().info("Found the eye of ender.");
						ender_eye=true;
					} //DERP
				}
			}
			if (artifact && ender_eye) {
				ItemStack artifact_result = new ItemStack(Material.CLAY_BALL);
				ItemMeta meta = artifact_result.getItemMeta();
				List<String> lore = new ArrayList<String>();
				lore.add("This clump of material seems to");
				lore.add("be part of something ancient.");
				lore.add("");
				lore.add(ChatColor.LIGHT_PURPLE+""+ChatColor.ITALIC+"This piece has a chance to be restored");
				lore.add(ChatColor.LIGHT_PURPLE+""+ChatColor.ITALIC+"to its true potential.");
				meta.setLore(lore);
				artifact_result.setItemMeta(meta);
				artifact_result.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
				result.setResult(artifact_result);
			} else {
				result.setResult(new ItemStack(Material.AIR));
				return; //Don't allow it to continue.
			}
		}
		
		if (result.getResult().getType()==Material.SKULL_ITEM) {
			//This could potentially be a mob head.
			//Find the mob head.
			boolean found=false;
			for (int i=0;i<result.getMatrix().length;i++) {
				if (result.getMatrix()[i]!=null &&
						result.getMatrix()[i].getType()==Material.SKULL_ITEM) {
					//Bukkit.getLogger().info("Detected a skull item here.");
					int gold_blocks=0;
					int beacons=0;
					for (int j=0;j<result.getMatrix().length;j++) {
						if (result.getMatrix()[j]!=null &&
								result.getMatrix()[j].getType()==Material.GOLD_BLOCK) {
							gold_blocks++;
						}
						if (result.getMatrix()[j]!=null &&
								result.getMatrix()[j].getType()==Material.BEACON) {
							beacons++;
						}
					}
					//Bukkit.getLogger().info("Found "+gold_blocks+" gold blocks and "+beacons+" beacons.");
					if (this.plugin.getMobHead(result.getMatrix()[i])!=null) {
							//Bukkit.getLogger().info("Mob head is "+this.plugin.getMobHead(result.getMatrix()[i]).toString());
							if (this.plugin.isUnpoweredHead(this.plugin.getMobHead(result.getMatrix()[i]))) {
								//Bukkit.getLogger().info("Mob head is considered unpowered, convert.");
								//Allow this conversion to occur.
								if (this.plugin.isRareHead(this.plugin.getMobHead(result.getMatrix()[i])) && beacons==4) {
									short numb = result.getMatrix()[i].clone().getDurability();
									ItemStack poweredhead = this.plugin.convertToPoweredHead(result.getMatrix()[i].clone());
									poweredhead.setData(result.getMatrix()[i].getData());
									found=true;
									//Bukkit.getLogger().info("Converted head item is "+this.plugin.convertToPoweredHead(result.getMatrix()[i]).toString());
									poweredhead.setDurability(numb);
									result.setResult(poweredhead);
									break;
								}
								else
								if (!this.plugin.isRareHead(this.plugin.getMobHead(result.getMatrix()[i])) && gold_blocks==4) {
									short numb = result.getMatrix()[i].clone().getDurability();
									ItemStack poweredhead = this.plugin.convertToPoweredHead(result.getMatrix()[i].clone());
									found=true;
									//Bukkit.getLogger().info("Converted head item is "+this.plugin.convertToPoweredHead(result.getMatrix()[i]).toString());
									poweredhead.setDurability(numb);
									result.setResult(poweredhead);
									break;
								}
							}
						}
					}
				}
			if (!found) {
				result.setResult(new ItemStack(Material.AIR));
				return;
			}
		}

		boolean is_battleShovel=false;
		if (result.getResult().getType()==Material.WOOD_SPADE) {
			//See if we're trying to make the battle shovel.
			if (result.getResult().hasItemMeta() && result.getResult().getItemMeta().hasLore()) {
				for (int i=0;i<result.getResult().getItemMeta().getLore().size();i++) {
					if (result.getResult().getItemMeta().getLore().get(i).contains(ChatColor.GOLD+"Whenever this shovel destroys")) {
						is_battleShovel=true;
						break;
					}
				}
			}
		}
		boolean allowed=false;
		if (is_battleShovel) {
			for (int i=0;i<e.getInventory().getViewers().size();i++) {
				if (this.plugin.hasJobBuff("Digger", e.getInventory().getViewers().get(i).getName(), Job.JOB30B)) {
					allowed=true;
				}
			}
			if (!allowed) {
				result.setResult(new ItemStack(Material.AIR));
				return;
			}
		}

		//Find out if there is only 1 item in the crafting matrix. It also have to be an armor/tool.
		boolean check=false;
		int count=0;
		for (int i=0;i<result.getMatrix().length;i++) {
			if (result.getMatrix()[i]!=null) {
				//Bukkit.getLogger().info("Checking item "+result.getMatrix()[i].getType().name());
				if (result.getMatrix()[i].getType().name().toLowerCase().contains("helmet") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("chestplate") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("leggings") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("boots") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("pickaxe") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("spade") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("axe") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("hoe")) {
					check=true;
					count++;
				}
			}
		}
		if (check && count==1) {
			//Bukkit.getLogger().info("Found only 1 piece inside.");
			for (int i=0;i<e.getInventory().getViewers().size();i++) {
				if (this.plugin.hasJobBuff("Blacksmith", e.getInventory().getViewers().get(i).getName(), Job.JOB30B)) {
					allowed=true;
				}
			}
			if (!allowed) {
				//Bukkit.getLogger().info("Not allowed!");
				result.setResult(new ItemStack(Material.AIR));
				return;
			} else {
				//Bukkit.getLogger().info("Allowed.");
				ItemStack myitem = null;

				for (int i=0;i<result.getMatrix().length;i++) {
					if (result.getMatrix()[i]!=null && result.getMatrix()[i].getType()!=Material.AIR) {
						myitem=result.getMatrix()[i];
						Bukkit.getLogger().info("set item: "+i);
						break;
					}
				}
				
				boolean weak=false;
				
				//Check if it's a weak piece.
				if (myitem.hasItemMeta() && myitem.getItemMeta().hasLore()) {
					if (myitem.getItemMeta().getLore().contains(ChatColor.RED+"-400% Durability")) {
						weak=true;
						Bukkit.getLogger().info("It's a weak piece");
					}
				}
				
				ItemStack offering = null;
				int itemcount=0;
				
				String myname = myitem.getType().name().toLowerCase();
				
				if (myname.contains("helmet")) {itemcount=5; if (myname.contains("chainmail")) {itemcount=3;} if (!weak) {itemcount*=9;}}
				if (myname.contains("chestplate")) {itemcount=8; if (myname.contains("chainmail")) {itemcount=5;} if (!weak) {itemcount*=9;}}
				if (myname.contains("leggings")) {itemcount=7; if (myname.contains("chainmail")) {itemcount=4;} if (!weak) {itemcount*=9;}}
				if (myname.contains("boots")) {itemcount=4; if (myname.contains("chainmail")) {itemcount=2;} if (!weak) {itemcount*=9;}}
				if (myname.contains("pickaxe")) {itemcount=3;}
				if (myname.contains("spade")) {itemcount=1;}
				if (myname.contains("axe")) {itemcount=3;}
				if (myname.contains("hoe")) {itemcount=2;}
				//Bukkit.getLogger().info("Offering itemcount is "+itemcount);
				
				//We now have myitem. Check type.
				if (myname.contains("diamond")) {offering = new ItemStack(Material.DIAMOND,(int)(itemcount*0.07)+1);}
				if (myname.contains("iron")) {offering = new ItemStack(Material.IRON_INGOT,(int)(itemcount*0.07)+1);}
				if (myname.contains("wood")) {offering = new ItemStack(Material.WOOD,(int)(itemcount*0.07)+1);}
				if (myname.contains("gold")) {offering = new ItemStack(Material.GOLD_INGOT,(int)(itemcount*0.07)+1);}
				if (myname.contains("chainmail")) {offering = new ItemStack(Material.IRON_INGOT,(int)(itemcount*0.07)+1);}
				if (myname.contains("stone")) {offering = new ItemStack(Material.COBBLESTONE,(int)(itemcount*0.07)+1);}
				//Bukkit.getLogger().info("Offering is "+offering.toString());
				result.setResult(offering);
			}
		}
		
		Player p = null;
		for (int i=0;i<e.getInventory().getViewers().size();i++) {
			if (this.plugin.hasJobBuff("Cook", e.getInventory().getViewers().get(i).getName(), Job.JOB10)) {
				allowed=true;
				p=(Player)e.getInventory().getViewers().get(i);
			}
		}
		if (allowed) {
			ItemStack resulting = new ItemStack(result.getResult().getType(),result.getResult().getAmount());
			if (hasJobBuff("Cook", p, Job.JOB10)) {
				resulting.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
				List<String> lore = new ArrayList<String>();
				if (resulting.getItemMeta().hasLore()) {
					lore = resulting.getItemMeta().getLore();
				} else {
					lore.add("This food item was fabulously");
					lore.add("created by cook "+ChatColor.YELLOW+p.getName()+",");
					lore.add("restoring more hunger and");
					lore.add("saturation than normal, and");
					lore.add("healing 1 Heart of health.");
				}
				ItemMeta meta = resulting.getItemMeta();
				meta.setLore(lore);
				resulting.setItemMeta(meta);
				result.setResult(resulting);
			}
			if (hasJobBuff("Cook", p, Job.JOB40)) {
				if (hasJobBuff("Cook", p, Job.JOB30A)) {
					result.setResult(modifyFoodItem(result.getResult(),1,0,true));
				} else 
				if (hasJobBuff("Cook", p, Job.JOB30B)) {
					result.setResult(modifyFoodItem(result.getResult(),0,3,true));
				}
				ItemStack final_result = result.getResult();
				final_result.setAmount(final_result.getAmount()*2);
				result.setResult(final_result);
			} else
			if (hasJobBuff("Cook", p, Job.JOB30A) || hasJobBuff("Cook", p, Job.JOB30B)) {
				if (hasJobBuff("Cook", p, Job.JOB30A)) {
					result.setResult(modifyFoodItem(result.getResult(),1));
				} else {
					result.setResult(modifyFoodItem(result.getResult(),0,3));
				}
			} else
			if (hasJobBuff("Cook", p, Job.JOB20)) {
				result.setResult(modifyFoodItem(result.getResult()));
			}
		}
		
		//****************************//Job Non-Boofs go below.
		
		if (result.getResult().getType()==Material.NAME_TAG) {
			ItemStack dye = null;
			ItemStack name_tag = null;
			for (int i=0;i<result.getMatrix().length;i++) {
				if (result.getMatrix()[i]!=null &&
						result.getMatrix()[i].getType()==Material.NAME_TAG) {
					name_tag = result.getMatrix()[i].clone();
				}
				if (result.getMatrix()[i]!=null &&
						result.getMatrix()[i].getType()==Material.INK_SACK) {
					dye = result.getMatrix()[i];
					if (dye.getData().getData()==(byte)3 ||
							dye.getData().getData()==(byte)13) {
						result.setResult(new ItemStack(Material.AIR));
						return;
					}
					//Bukkit.getLogger().info("Dye is valid.");
				}
			}
			ChatColor color = null;
			if (dye!=null) {
				//Bukkit.getLogger().info("Dye is not null, converting color. Data is "+dye.getData().getData());
				switch (dye.getData().getData()) {
					case (byte)0:{color = ChatColor.BLACK;}break;
					case (byte)1:{color = ChatColor.RED;}break;
					case (byte)2:{color = ChatColor.DARK_GREEN;}break;
					case (byte)4:{color = ChatColor.BLUE;}break;
					case (byte)5:{color = ChatColor.DARK_PURPLE;}break;
					case (byte)6:{color = ChatColor.DARK_AQUA;}break;
					case (byte)7:{color = ChatColor.GRAY;}break;
					case (byte)8:{color = ChatColor.DARK_GRAY;}break;
					case (byte)9:{color = ChatColor.LIGHT_PURPLE;}break;
					case (byte)10:{color = ChatColor.GREEN;}break;
					case (byte)11:{color = ChatColor.YELLOW;}break;
					case (byte)12:{color = ChatColor.AQUA;}break;
					case (byte)14:{color = ChatColor.GOLD;}break;
					case (byte)15:{color = ChatColor.WHITE;}break;
				}
				//Bukkit.getLogger().info("color resolved to "+color.toString());
			}
			//Bukkit.getLogger().info("Display name is "+result.getResult().getItemMeta().getDisplayName()+". Item is "+result.getResult().toString());
			if (color!=null && name_tag!=null && name_tag.getItemMeta().getDisplayName()!=null) {
				//Bukkit.getLogger().info("Dye color is "+color);
				ItemStack newresult = name_tag;
				ItemMeta meta = name_tag.getItemMeta();
				meta.setDisplayName(color+""+ChatColor.stripColor(meta.getDisplayName()));
				newresult.setItemMeta(meta);
				newresult.setAmount(1);
				result.setResult(newresult);
			} else {
				result.setResult(new ItemStack(Material.AIR));
				return;
			}
		}

		ItemStack armor1 = null;
		for (int i=0;i<result.getMatrix().length;i++) {
			//Disable crafting if two pieces of the same armor are in the slots.
			if (armor1 != null && result.getMatrix()[i]!=null) {
				if (result.getMatrix()[i].getType().name().toLowerCase().contains("helmet") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("chestplate") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("leggings") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("boots") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("pickaxe") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("bow") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("sword") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("spade") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("axe") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("hoe") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("fishing_rod") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("shears")) {
					if (armor1.getType()==result.getMatrix()[i].getType()) {
						//Two pieces with the same type. Disable merge crafting.
						result.setResult(new ItemStack(Material.AIR));
						return;
					} else {
						//Although at this point it really doesn't matter, since we had two or more armor pieces inside.
						break;
					}
				}
			} else
			if (armor1 == null && result.getMatrix()[i]!=null && 
				(result.getMatrix()[i].getType().name().toLowerCase().contains("helmet") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("chestplate") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("leggings") ||
					result.getMatrix()[i].getType().name().toLowerCase().contains("boots"))) {
				armor1 = result.getMatrix()[i];
			}
		}

		// Disable melon crafting recipe
		if (result.getResult().getType()==Material.MELON_BLOCK) {
			result.setResult(new ItemStack(Material.AIR));
		}

		if (result.getResult().getType()==Material.WOOL && result.getResult().getAmount() == 1) {
			//Make sure the crafting matrix only contains three string.
			int stringcount=0;
			for (int i=0;i<result.getMatrix().length;i++) {
				if (result.getMatrix()[i]!=null && result.getMatrix()[i].getType()==Material.STRING) {
					stringcount++;
				}
			}
			if (stringcount!=4) {
				result.setResult(new ItemStack(Material.AIR));
				return;
			}
		}
		
		// Increase stairs recipe efficiency
		if (result.getResult().getType()==Material.WOOD_STAIRS) {
			result.setResult(new ItemStack(Material.WOOD_STAIRS, 8));
		}
		if (result.getResult().getType()==Material.COBBLESTONE_STAIRS) {
			result.setResult(new ItemStack(Material.COBBLESTONE_STAIRS, 8));
		}
		if (result.getResult().getType()==Material.BIRCH_WOOD_STAIRS) {
			result.setResult(new ItemStack(Material.BIRCH_WOOD_STAIRS, 8));
		}
		if (result.getResult().getType()==Material.SPRUCE_WOOD_STAIRS) {
			result.setResult(new ItemStack(Material.SPRUCE_WOOD_STAIRS, 8));
		}
		if (result.getResult().getType()==Material.JUNGLE_WOOD_STAIRS) {
			result.setResult(new ItemStack(Material.JUNGLE_WOOD_STAIRS, 8));
		}
		if (result.getResult().getType()==Material.BRICK_STAIRS) {
			result.setResult(new ItemStack(Material.BRICK_STAIRS, 8));
		}
		if (result.getResult().getType()==Material.NETHER_BRICK_STAIRS) {
			result.setResult(new ItemStack(Material.NETHER_BRICK_STAIRS, 8));
		}
		if (result.getResult().getType()==Material.QUARTZ_STAIRS) {
			result.setResult(new ItemStack(Material.QUARTZ_STAIRS, 8));
		}
		if (result.getResult().getType()==Material.SANDSTONE_STAIRS) {
			result.setResult(new ItemStack(Material.SANDSTONE_STAIRS, 8));
		}
		if (result.getResult().getType()==Material.SMOOTH_STAIRS) {
			result.setResult(new ItemStack(Material.SMOOTH_STAIRS, 8));
		}	  

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
	}
	
	private void restoreItems(CraftingInventory craft, ClickType click, Player p, double restore_chance) {
		ItemStack[] crafteditems = craft.getMatrix();
		if (click==ClickType.SHIFT_RIGHT || click==ClickType.SHIFT_LEFT) {
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
						if (Math.random()<=restore_chance) {
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
					if (Math.random()<=restore_chance) {
						//p.sendMessage("Restored an item.");
						ItemStack replenishitem = crafteditems[i].clone();
						replenishitem.setAmount(1);
						p.getInventory().addItem(replenishitem);
					}
				}
			}
		}
	}

	@EventHandler
	public void onItemCraft(CraftItemEvent e) {
		//This is something we just crafted.
		//Bukkit.getPlayer("sigonasr2").sendMessage("Resulting item is "+result.getResult().getAmount()+" "+result.getResult().getType());
		CraftingInventory result = e.getInventory();
		if (result==null) {return;} //No point in checking here if the resulting inventory is blank.
		//Bukkit.getPlayer("sigonasr2").sendMessage("Resulting item is "+result.getResult().getAmount()+" "+result.getResult().getType());
		Player p = Bukkit.getPlayer(e.getWhoClicked().getName());
		
		//***********************************//Job buff stuff
		if (this.plugin.hasJobBuff("Builder", p, Job.JOB20)) {
			if (result.getResult().getType()==Material.WOOD ||
					result.getResult().getType().name().toLowerCase().contains("stairs") ||
					result.getResult().getType()==Material.FENCE ||
					result.getResult().getType()==Material.NETHER_BRICK ||
					result.getResult().getType()==Material.NETHER_FENCE ||
					result.getResult().getType()==Material.WOOL ||
					result.getResult().getType()==Material.BRICK ||
					result.getResult().getType()==Material.SMOOTH_BRICK ||
					result.getResult().getType()==Material.STAINED_CLAY ||
					result.getResult().getType()==Material.SANDSTONE ||
					result.getResult().getType()==Material.QUARTZ_BLOCK) {
				restoreItems(e.getInventory(), e.getClick(), p, 0.75);
			}
		}
		
		if (this.plugin.PlayerinJob(p,"Weaponsmith") || this.plugin.hasJobBuff("Weaponsmith", p, Job.JOB40)) {
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
			if (this.plugin.hasJobBuff("Weaponsmith", p, Job.JOB40) && crafteditem) {
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
								if (Math.random()<=0.5) {
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
							if (Math.random()<=0.5) {
								//p.sendMessage("Restored an item.");
								ItemStack replenishitem = crafteditems[i].clone();
								replenishitem.setAmount(1);
								p.getInventory().addItem(replenishitem);
							}
						}
					}
				}
			} else
			if (this.plugin.hasJobBuff("Weaponsmith", p, Job.JOB20) && crafteditem) {
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
				if (this.plugin.hasJobBuff("Weaponsmith", p, Job.JOB5) && crafteditem) {
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
			if (this.plugin.hasJobBuff("Weaponsmith", p, Job.JOB10) && crafteditem) {
				//Bukkit.getPlayer("sigonasr2").sendMessage("Valid item. Going to attempt to enchant.");
				if (e.getClick()!=ClickType.SHIFT_RIGHT && e.getClick()!=ClickType.SHIFT_LEFT) {
					ItemStack resulting = result.getResult();
					if (hasJobBuff("Weaponsmith", p.getName(), Job.JOB40)) {
						resulting = EnchantItem(resulting,25,(Player)p);
						int finalstack=1;
						while (Math.random()<=0.3) {
							finalstack++;
						}
						resulting.setAmount(finalstack);
					} else {
						resulting = EnchantItem(result.getResult(),5,p);
					}
					if (hasJobBuff("Weaponsmith", p.getName(), Job.JOB30A)) {
						ItemMeta meta = resulting.getItemMeta();
						List<String> lore = new ArrayList<String>();
						if (meta.hasLore()) {
							lore = meta.getLore();
						}
						lore.add(ChatColor.YELLOW+"+"+(getJobLv("Weaponsmith", p.getName())-29)+" "+ChatColor.BLUE+"Damage");
						meta.setLore(lore);
						resulting.setItemMeta(meta);
					}
					if (hasJobBuff("Weaponsmith", p.getName(), Job.JOB30B)) {
						ItemMeta meta = resulting.getItemMeta();
						List<String> lore = new ArrayList<String>();
						if (meta.hasLore()) {
							lore = meta.getLore();
						}
						lore.add(ChatColor.YELLOW+"+"+((getJobLv("Weaponsmith", p.getName())-29)*2)+"% "+ChatColor.BLUE+"Lifesteal");
						meta.setLore(lore);
						resulting.setItemMeta(meta);
					}
					result.setResult(resulting);
				}
			}
		}
		if (this.plugin.PlayerinJob(p,"Blacksmith") || this.plugin.hasJobBuff("Blacksmith", p, Job.JOB40)) {
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
			ItemStack resulting = result.getResult();
			if (e.getClick()!=ClickType.SHIFT_RIGHT && e.getClick()!=ClickType.SHIFT_LEFT) {
				if (this.plugin.hasJobBuff("Blacksmith", p, Job.JOB30A) && crafteditem) {
					ItemMeta meta = resulting.getItemMeta();
					List<String> lore = new ArrayList<String>();
					if (meta.hasLore()) {
						lore = meta.getLore();
					}
					lore.add(ChatColor.YELLOW+"+"+((getJobLv("Blacksmith", p.getName())-29)*2)+" "+ChatColor.BLUE+"Health");
					meta.setLore(lore);
					resulting.setItemMeta(meta);
				}
				if (this.plugin.hasJobBuff("Blacksmith", p, Job.JOB5) && crafteditem) {
					//Bukkit.getPlayer("sigonasr2").sendMessage("Valid item. Going to attempt to enchant.");
					if (e.getClick()!=ClickType.SHIFT_RIGHT && e.getClick()!=ClickType.SHIFT_LEFT) {
						resulting = EnchantItem(result.getResult(),5,p);
						result.setResult(resulting);
					}
				}
				if (this.plugin.hasJobBuff("Blacksmith", p, Job.JOB10) && crafteditem) {
					//Bukkit.getPlayer("sigonasr2").sendMessage("Valid item. Going to attempt to enchant.");
					if (e.getClick()!=ClickType.SHIFT_RIGHT && e.getClick()!=ClickType.SHIFT_LEFT) {
						resulting = EnchantItem(result.getResult(),10,p);
						result.setResult(resulting);
					}
				}
				if (this.plugin.hasJobBuff("Blacksmith", p, Job.JOB20) && crafteditem) {
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
				if (this.plugin.hasJobBuff("Blacksmith", p, Job.JOB40) && crafteditem) {
					if (Math.random()<=0.5) {
						resulting = EnchantItem(result.getResult(), 30, p);
					} else {
						resulting = EnchantItem(result.getResult(), 20, p);
					}
					resulting.setAmount((int)(Math.random()*4)+2);
					result.setResult(resulting);
				}
			}
		}

		/*
		ItemStack resulting = new ItemStack(result.getResult().getType(),result.getResult().getAmount());
		if (hasJobBuff("Cook", p, Job.JOB10)) {
			if (e.getClick()!=ClickType.SHIFT_RIGHT && e.getClick()!=ClickType.SHIFT_LEFT) {
				resulting.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
				List<String> lore = new ArrayList<String>();
				if (resulting.getItemMeta().hasLore()) {
					lore = resulting.getItemMeta().getLore();
				} else {
					lore.add("This food item was fabulously");
					lore.add("created by cook "+ChatColor.YELLOW+p.getName()+",");
					lore.add("restoring more hunger and");
					lore.add("saturation than normal, and");
					lore.add("healing 1 Heart of health.");
				}
				ItemMeta meta = resulting.getItemMeta();
				meta.setLore(lore);
				resulting.setItemMeta(meta);
				result.setResult(resulting);
			}
		}	
		if (hasJobBuff("Cook", p, Job.JOB20)) {
			result.setResult(modifyFoodItem(result.getResult()));
		}*/
		
		ItemStack item = result.getResult();
		int amount=1;
		if (this.plugin.PlayerinJob(p,"Digger")) {
			if (e.getClick()!=ClickType.SHIFT_RIGHT && e.getClick()!=ClickType.SHIFT_LEFT) {
				if (item.getType()==Material.SANDSTONE) {
					this.plugin.gainMoneyExp(p,"Digger",0.02*amount,6*amount);
				}
				if (item.getType()==Material.BRICK) {
					this.plugin.gainMoneyExp(p,"Digger",0.04*amount,8*amount);
				}
			}
		}
		if (this.plugin.PlayerinJob(p,"Cook")) {
			if (e.getClick()!=ClickType.SHIFT_RIGHT && e.getClick()!=ClickType.SHIFT_LEFT) {
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
			}
			if (this.plugin.hasJobBuff("Cook", p, Job.JOB40)) {
				if (e.getClick()!=ClickType.SHIFT_LEFT && e.getClick()!=ClickType.SHIFT_RIGHT) {
					ItemStack replenishitem = item.clone();
					replenishitem.setAmount(1);
					p.getInventory().addItem(replenishitem);
				}
			}
			/*
			if (this.plugin.getJobLv("Cook", p)>=10 && crafteditem==true) {
				//This is an ugly fix for the problem...But it works somehow.
				//Player newp = Bukkit.getPlayer(p.getName().toLowerCase());
				p.getInventory().addItem(new ItemStack(item.getType(),amount,item.getDurability(),item.getData().getData()));
			}*/
		}
		//***********************************//End job buff stuff
		
		
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
	public void onLeavesDecay(LeavesDecayEvent e) {
		if (e.getBlock().getData()==0/*Has to be oak.*/) {
			//We will check for nearby players.
			for (int i=0;i<Bukkit.getOnlinePlayers().length;i++) {
				Player p = Bukkit.getOnlinePlayers()[i];
				if (this.plugin.hasJobBuff("Woodcutter", p, Job.JOB20) && p.getLocation().distanceSquared(e.getBlock().getLocation())<=900) {
					//There is a chance to drop an apple!
					if (Math.random()<=0.02) { //Reduced from 1/200 to 1/50 chance.
						p.getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.APPLE));
					}
				}
			}
		}
	}

	@EventHandler
	public void onItemChange(PlayerItemHeldEvent e) {
		Player p = e.getPlayer();
		//**************************//Job Buffs begin here.
		if (p.getInventory().getContents()[e.getNewSlot()]!=null) {
			if (p.getInventory().getContents()[e.getNewSlot()].getType().name().toLowerCase().contains("pickaxe") && this.plugin.hasJobBuff("Miner", p, Job.JOB10)) {
				ItemStack currentitem = p.getInventory().getContents()[e.getNewSlot()];
				if (currentitem.getEnchantmentLevel(Enchantment.getByName("DIG_SPEED"))<3) {
					currentitem.addUnsafeEnchantment(Enchantment.getByName("DIG_SPEED"), 3);
				}
			}
			if (p.getInventory().getContents()[e.getNewSlot()].getType().name().toLowerCase().contains("pickaxe") && this.plugin.hasJobBuff("Miner", p, Job.JOB20)) {
				ItemStack currentitem = p.getInventory().getContents()[e.getNewSlot()];
				if (currentitem.getEnchantmentLevel(Enchantment.getByName("DIG_SPEED"))<6) {
					currentitem.addUnsafeEnchantment(Enchantment.getByName("DIG_SPEED"), 6);
				}
				if (currentitem.getEnchantmentLevel(Enchantment.getByName("DURABILITY"))<4) {
					currentitem.addUnsafeEnchantment(Enchantment.getByName("DURABILITY"), 4);
				}
			}
			if (p.getInventory().getContents()[e.getNewSlot()].getType().name().toLowerCase().contains("spade") && this.plugin.hasJobBuff("Digger", p, Job.JOB10)) {
				ItemStack currentitem = p.getInventory().getContents()[e.getNewSlot()];
				if (currentitem.getEnchantmentLevel(Enchantment.getByName("DURABILITY"))<5) {
					currentitem.addUnsafeEnchantment(Enchantment.getByName("DURABILITY"), 5);
				}
				if (currentitem.getEnchantmentLevel(Enchantment.getByName("DIG_SPEED"))<4) {
					currentitem.addUnsafeEnchantment(Enchantment.getByName("DIG_SPEED"), 4);
				}
			}
			if (p.getInventory().getContents()[e.getNewSlot()].getType()==Material.FISHING_ROD && this.plugin.hasJobBuff("Fisherman", p, Job.JOB40) && !p.getAllowFlight() && p.isOnGround()) {
				p.setAllowFlight(true);
				p.sendMessage(ChatColor.DARK_GRAY+""+ChatColor.ITALIC+"Flight enabled...");
				this.plugin.getPlayerData(p).lastflighttime=Main.SERVER_TICK_TIME;
			} else {
				if (p.getAllowFlight()) {
					if (p.getGameMode()!=GameMode.CREATIVE) {
    					p.setAllowFlight(false);
						p.setFlying(false);
						p.sendMessage(ChatColor.DARK_RED+""+ChatColor.ITALIC+"Flight disabled...");
    				}
				}
			}
		}
		//**************************//Job Buffs end here.
	}
	
    public void open_LootChest(int tier, Location loc) {
    	
    	// 1 = single item
    	// 2 = mythic item
    	// 3 = plentiful items
    	// 4 = multiple items
    	// 5 = chaos items (diablodrops items)
    	// 6 = boss items
    	// 7 = mythic boss items
    	// 8 = boss assist items
    	// 999 = Survivor's kit
		switch (tier) {
			case 1: {
				loc.getWorld().dropItemNaturally(loc, getGoodie(0));
			}break;
			case 2: {
				loc.getWorld().dropItemNaturally(loc, getGoodie(1));
			}break;
			case 3: {
				if (Math.random() < 0.1) {
					loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.NETHER_BRICK, (int)(Math.random() * 64) + 1));
				} else 
				if (Math.random() < 0.1) {
					loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.RAW_FISH, (int)(Math.random() * 64) + 1));
				} else 
				if (Math.random() < 0.1) {
					loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.HAY_BLOCK, (int)(Math.random() * 64) + 1));
				} else 
				if (Math.random() < 0.1) {
					loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.CLAY, (int)(Math.random() * 64) + 1));
				} else 
				if (Math.random() < 0.1) {
					loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.EXP_BOTTLE, (int)(Math.random() * 64) + 1));
				} else 
				if (Math.random() < 0.1) {
					loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.NOTE_BLOCK, (int)(Math.random() * 64) + 1));
				} else 
				if (Math.random() < 0.1) {
					loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.MOSSY_COBBLESTONE, (int)(Math.random() * 64) + 1));
				} else 
				if (Math.random() < 0.1) {
					loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.BOOKSHELF, (int)(Math.random() * 64) + 1));
				} else 
				if (Math.random() < 0.1) {
					loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.QUARTZ_BLOCK, (int)(Math.random() * 64) + 1));
				} else 
				if (Math.random() < 0.1) {
					loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.OBSIDIAN, (int)(Math.random() * 64) + 1));
				} else
				if (Math.random() < 0.1) {
					loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.REDSTONE_LAMP_OFF, (int)(Math.random() * 64) + 1));
				} else {
					// Damn you got unlucky, better try next time
					loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.WOOL, (int)(Math.random() * 64) + 1));
				}
			}break;
			case 4: {
				// Drop at least two stacks, and four rolls for a 20% chance at an extra stack.
				loc.getWorld().dropItemNaturally(loc, getGoodie(0));
				loc.getWorld().dropItemNaturally(loc, getGoodie(0));
				for (int i = 0; i < 4; i++) {
					// Averages one extra drop. Can be up to 4. 
					if (Math.random() < 0.2) {
						loc.getWorld().dropItemNaturally(loc, getGoodie(0));
					}
				}
			}break;
			case 5: {
				loc.getWorld().dropItemNaturally(loc, DiabloDropsHook.getRandomItem());
				for (int i = 0; i < 30 && Math.random() < 0.8; i++) {
					// Averages 5 drops, anywhere from 1 to 31 can be generated.  
					loc.getWorld().dropItemNaturally(loc, DiabloDropsHook.getRandomItem());
				}
			}break;
			case 6: {
				for (int i=0;i<27;i++) {
					if (Math.random()<=0.3) {
						ItemStack dropitem = null;
						if ((dropitem=getGoodie())!=null) {
							loc.getWorld().dropItemNaturally(loc, dropitem);
						}
					}
				}
			}break;
			case 7: {
				boolean dropMythical=false;
				boolean dropMythical2=false;
				for (int i=0;i<27;i++) {
					if (Math.random()<=0.1 && !dropMythical) {
						dropMythical=true;
						ItemStack dropitem = null;
						if ((dropitem=getGoodie(1))!=null) {
							loc.getWorld().dropItemNaturally(loc, dropitem);
						}
					} else
					if (Math.random()<=0.03 && !dropMythical2) {
						dropMythical2=true;
						ItemStack dropitem = null;
						if ((dropitem=getGoodie(1))!=null) {
							loc.getWorld().dropItemNaturally(loc, dropitem);
						}
					}
					if (Math.random()<=0.2) {
						ItemStack dropitem = null;
						if ((dropitem=getGoodie())!=null) {
							loc.getWorld().dropItemNaturally(loc, dropitem);
						}
					}
				}
			}break;
			case 8: {
				for (int i=0;i<8;i++) {
					if (Math.random()<=0.75) {
						ItemStack dropitem = null;
						if ((dropitem=getGoodie())!=null) {
							loc.getWorld().dropItemNaturally(loc, dropitem);
						}
					}
				}
			}break;
			case 999: {
				// Not yet obtainable
				loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.WORKBENCH));
				loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.FURNACE));
				loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.WOOD, 16));
				loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.COBBLESTONE, 16));
				loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.TORCH, 16));
				loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.BREAD, 16));
			}break;
		}
	}

	public ItemStack getGoodie() {
		return getGoodie(0);
	}

	public ItemStack getGoodie(int rar /*1=Mythical 0=Normal -1=Only an equipment*/) {
		ItemStack item = null;
		if (Math.random()<0.33 || rar==-1 || rar==1) {
			//Add a weapon/armor piece.
			int rand = (int)(Math.random()*5);
			String type = "";
			String type2 = "";
			int rarity=0; //0 = Normal, 1 = Rare, 2 = Legendary, 3 = Mythical, 4 = Set
			switch ((int)(Math.random()*22)) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 10:
			case 11:
			case 7:
			case 8:
			case 9:
			case 12:
			case 13:
			case 18:{
				rarity=0;
			}break;
			case 5:
			case 14:
			case 15:{
				rarity=1;
			}break;
			case 6:
			case 16:
			case 17:{
				rarity=2;
			}break;
			case 19:
			case 20:{
				rarity=4;
			}break;
			case 21:{
				rarity=3;
			}break;
			}
			if (rar==1) {
				rarity=3;
			}
			if (rar==-1) {
				if (Math.random()<=0.05) {
					rarity=4;
				} else {
					rarity=(int)(Math.random()*3);
				}
			}
			if (rarity==4) {
				//Drop a leather piece / diamond sword that's mysterious. It will have 0 durability, so cannot be used until identified.
				ItemStack i = null;
				switch ((int)(Math.random()*10)) {
					case 0:{
						i = new ItemStack(Material.DIAMOND_SWORD);
					}break;
					case 1:{
						i = new ItemStack(Material.LEATHER_CHESTPLATE);
					}break;
					case 2:{
						i = new ItemStack(Material.LEATHER_BOOTS);
					}break;
					case 3:{
						i = new ItemStack(Material.LEATHER_HELMET);
					}break;
					case 4:{
						i = new ItemStack(Material.LEATHER_LEGGINGS);
					}break;
					default:{
						i = new ItemStack(Material.LEATHER);
					}
				}
				if (i.getType()==Material.LEATHER) {
					//We will drop a leather piece that builds a set item.
					
				}
			}
			if (rar==-1) {
				if (Math.random()<=0.05) {
					rarity=4;
				} else {
					rarity=(int)(Math.random()*3);
				}
			}
			if (rarity==4) {
				//Drop a leather piece / diamond sword that's mysterious. It will have 0 durability, so cannot be used until identified.
				ItemStack i = null;
				switch ((int)(Math.random()*10)) {
					case 0:{
						i = new ItemStack(Material.DIAMOND_SWORD);
					}break;
					case 1:{
						i = new ItemStack(Material.LEATHER_CHESTPLATE);
					}break;
					case 2:{
						i = new ItemStack(Material.LEATHER_BOOTS);
					}break;
					case 3:{
						i = new ItemStack(Material.LEATHER_HELMET);
					}break;
					case 4:{
						i = new ItemStack(Material.LEATHER_LEGGINGS);
					}break;
					default:{
						i = new ItemStack(Material.LEATHER);
					}
				}
				if (i.getType()==Material.LEATHER) {
					//We will drop a leather piece that builds a set item.
					
				}
			}
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
			double chance_increase=0;
			if (rarity>0) {
				chance_increase=1.5d;
			}
			if (type2.equalsIgnoreCase("BOW")) {
				item = new ItemStack(Material.BOW);
				int enchants[] = {48,49,50,51};
				for (int j=0;j<enchants.length;j++) {
					if (Math.random()*chance_increase<1.0d/enchants.length) {
						if (rarity==3) {
							if (Math.random()<=0.5) {
								item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*20)+10+1);
							}
						} else
							if (rarity==2) {
								item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
							} else {
								item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*6)+1);
							}
					}
				}
				List<String> ourLore = new ArrayList<String>();
				if (rarity==3) {
					int choice1=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
					//Select a random enchantment.
					//This is a mythical. Random amount is 70% guaranteed + 30% random.
					item = this.plugin.addBonusEnchantment(item, Main.getBonusWeaponEnchantments().get(choice1), (int)((Math.random()*(Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.3))+Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.7), true);
					if (item.getItemMeta().hasLore()) {ourLore = item.getItemMeta().getLore();} 
				} else
					if (rarity==2) {
						//This is a legendary. Random amount is 30% guaranteed + 60% random.
						int choice1=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
						item = this.plugin.addBonusEnchantment(item, Main.getBonusWeaponEnchantments().get(choice1), (int)((Math.random()*(Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.6))+Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.3), true);
						if (item.getItemMeta().hasLore()) {ourLore = item.getItemMeta().getLore();} 
					} else
						if (rarity==1) {
							//This is a rare. Random amount is 20% guaranteed + 40% random.
							int choice1=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
							item = this.plugin.addBonusEnchantment(item, Main.getBonusWeaponEnchantments().get(choice1), (int)((Math.random()*(Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.4))+Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.2), true);
							int choice2=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
							while (choice2==choice1) {
								choice2=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
							}
							item = this.plugin.addBonusEnchantment(item, Main.getBonusWeaponEnchantments().get(choice2), (int)((Math.random()*(Main.getBonusWeaponEnchantments().get(choice2).value_range.getMaximumInteger()*0.4))+Main.getBonusWeaponEnchantments().get(choice2).value_range.getMaximumInteger()*0.2), true);
							if (item.getItemMeta().hasLore()) {ourLore = item.getItemMeta().getLore();} 
						}
						else {
							//This is a normal item. Random amount is 5% guaranteed + 20% random.
							//It is also irrepairable.
							int choice1=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
							item = this.plugin.addBonusEnchantment(item, Main.getBonusWeaponEnchantments().get(choice1), (int)((Math.random()*(Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.2))+Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.05), true);
							if (item.getItemMeta().hasLore()) {ourLore = item.getItemMeta().getLore();} 
							ourLore.add(ChatColor.RED+"Irrepairable");
						}
				ItemMeta meta = item.getItemMeta();
				meta.setLore(ourLore);
				if (rarity==1) {
					meta.setDisplayName(ChatColor.BLUE+"Rare "+convertToItemName(item.getType().name().replace("_", " ")));
				}
				if (rarity==2) {
					meta.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"Legendary "+convertToItemName(item.getType().name().replace("_", " ")));
				}
				if (rarity==3) {
					meta.setDisplayName(ChatColor.LIGHT_PURPLE+""+"Mythical "+convertToItemName(item.getType().name().replace("_", " ")));
				}
				item.setItemMeta(meta);
			} else {
				item = new ItemStack(Material.getMaterial(type+"_"+type2));
				if (type2.equalsIgnoreCase("SWORD")) {
					int enchants[] = {16,17,18,19,20,21,34};
					for (int j=0;j<enchants.length;j++) {
						if (Math.random()*chance_increase<1.0d/enchants.length) {
							if (rarity==3) {
								if (Math.random()<=0.5) {
									item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*20)+10+1);
								}
							} else
								if (rarity==2) {
									item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
								} else {
									item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*6)+1);
								}
						}
					}
					List<String> ourLore = new ArrayList<String>();
					if (rarity==3) {
						int choice1=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
						//Select a random enchantment.
						//This is a mythical. Random amount is 70% guaranteed + 30% random.
						item = this.plugin.addBonusEnchantment(item, Main.getBonusWeaponEnchantments().get(choice1), (int)((Math.random()*(Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.3))+Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.7), true);
						if (item.getItemMeta().hasLore()) {ourLore = item.getItemMeta().getLore();} 
					} else
						if (rarity==2) {
							//This is a legendary. Random amount is 30% guaranteed + 60% random.
							int choice1=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
							item = this.plugin.addBonusEnchantment(item, Main.getBonusWeaponEnchantments().get(choice1), (int)((Math.random()*(Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.6))+Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.3), true);
							if (item.getItemMeta().hasLore()) {ourLore = item.getItemMeta().getLore();} 
						} else
							if (rarity==1) {
								//This is a rare. Random amount is 20% guaranteed + 40% random.
								int choice1=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
								item = this.plugin.addBonusEnchantment(item, Main.getBonusWeaponEnchantments().get(choice1), (int)((Math.random()*(Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.4))+Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.2), true);
								int choice2=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
								while (choice2==choice1) {
									choice2=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
								}
								item = this.plugin.addBonusEnchantment(item, Main.getBonusWeaponEnchantments().get(choice2), (int)((Math.random()*(Main.getBonusWeaponEnchantments().get(choice2).value_range.getMaximumInteger()*0.4))+Main.getBonusWeaponEnchantments().get(choice2).value_range.getMaximumInteger()*0.2), true);
								if (item.getItemMeta().hasLore()) {ourLore = item.getItemMeta().getLore();} 
							}
							else {
								//This is a normal item. Random amount is 5% guaranteed + 20% random.
								//It is also irrepairable.
								int choice1=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
								item = this.plugin.addBonusEnchantment(item, Main.getBonusWeaponEnchantments().get(choice1), (int)((Math.random()*(Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.2))+Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.05), true);
								if (item.getItemMeta().hasLore()) {ourLore = item.getItemMeta().getLore();} 
								ourLore.add(ChatColor.RED+"Irrepairable");
							}
					ItemMeta meta = item.getItemMeta();
					meta.setLore(ourLore);
					if (rarity==1) {
						meta.setDisplayName(ChatColor.BLUE+"Rare "+convertToItemName(item.getType().name().replace("_", " ")));
					}
					if (rarity==2) {
						meta.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"Legendary "+convertToItemName(item.getType().name().replace("_", " ")));
					}
					if (rarity==3) {
						meta.setDisplayName(ChatColor.LIGHT_PURPLE+""+"Mythical "+convertToItemName(item.getType().name().replace("_", " ")));
					}
					item.setItemMeta(meta);
				} else if (type2.equalsIgnoreCase("SPADE") || type2.equalsIgnoreCase("PICKAXE") || type2.equalsIgnoreCase("HOE") || type2.equalsIgnoreCase("AXE")) {
					int enchants[] = {32,33,34,35};
					for (int j=0;j<enchants.length;j++) {
						if (Math.random()<1.0d/enchants.length) {
							if (Math.random()<1.0d/enchants.length) {
								if (Math.random()*chance_increase<1.0d/enchants.length) {
									if (rarity==3) {
										if (Math.random()<=0.5) {
											item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*20)+10+1);
										}
									} else
										if (rarity==2) {
											if (enchants[j]==33) {
												if (item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS)==0) {
													item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
												}
											}
											if (enchants[j]==35) {
												if (item.getEnchantmentLevel(Enchantment.SILK_TOUCH)==0) {
													item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
												}
											}
										} else {
											if (enchants[j]==33) {
												if (item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS)==0) {
													item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*6)+1);
												}
											}
											if (enchants[j]==35) {
												if (item.getEnchantmentLevel(Enchantment.SILK_TOUCH)==0) {
													item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*6)+1);
												}
											}
										}
								}
							}
						}
					}
					List<String> ourLore = new ArrayList<String>();
					if (rarity==3) {
						int choice1=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
						//Select a random enchantment.
						//This is a mythical. Random amount is 70% guaranteed + 30% random.
						item = this.plugin.addBonusEnchantment(item, Main.getBonusWeaponEnchantments().get(choice1), (int)((Math.random()*(Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.3))+Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.7), true);
						if (item.getItemMeta().hasLore()) {ourLore = item.getItemMeta().getLore();} 
					} else
						if (rarity==2) {
							//This is a legendary. Random amount is 30% guaranteed + 60% random.
							int choice1=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
							item = this.plugin.addBonusEnchantment(item, Main.getBonusWeaponEnchantments().get(choice1), (int)((Math.random()*(Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.6))+Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.3), true);
							if (item.getItemMeta().hasLore()) {ourLore = item.getItemMeta().getLore();} 
						} else
							if (rarity==1) {
								//This is a rare. Random amount is 20% guaranteed + 40% random.
								int choice1=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
								item = this.plugin.addBonusEnchantment(item, Main.getBonusWeaponEnchantments().get(choice1), (int)((Math.random()*(Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.4))+Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.2), true);
								int choice2=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
								while (choice2==choice1) {
									choice2=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
								}
								item = this.plugin.addBonusEnchantment(item, Main.getBonusWeaponEnchantments().get(choice2), (int)((Math.random()*(Main.getBonusWeaponEnchantments().get(choice2).value_range.getMaximumInteger()*0.4))+Main.getBonusWeaponEnchantments().get(choice2).value_range.getMaximumInteger()*0.2), true);
								if (item.getItemMeta().hasLore()) {ourLore = item.getItemMeta().getLore();} 
							}
							else {
								//This is a normal item. Random amount is 5% guaranteed + 20% random.
								//It is also irrepairable.
								int choice1=(int)(Math.random()*Main.getBonusWeaponEnchantments().size());
								item = this.plugin.addBonusEnchantment(item, Main.getBonusWeaponEnchantments().get(choice1), (int)((Math.random()*(Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.2))+Main.getBonusWeaponEnchantments().get(choice1).value_range.getMaximumInteger()*0.05), true);
								if (item.getItemMeta().hasLore()) {ourLore = item.getItemMeta().getLore();} 
								ourLore.add(ChatColor.RED+"Irrepairable");
							}
					ItemMeta meta = item.getItemMeta();
					meta.setLore(ourLore);
					if (rarity==1) {
						meta.setDisplayName(ChatColor.BLUE+"Rare "+convertToItemName(item.getType().name().replace("_", " ")));
					}
					if (rarity==2) {
						meta.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"Legendary "+convertToItemName(item.getType().name().replace("_", " ")));
					}
					if (rarity==3) {
						meta.setDisplayName(ChatColor.LIGHT_PURPLE+""+"Mythical "+convertToItemName(item.getType().name().replace("_", " ")));
					}
					item.setItemMeta(meta);
				} else {
					int enchants[] = {0,1,2,3,4,5,6,7,34};
					for (int j=0;j<enchants.length;j++) {
						if (Math.random()<1.0d/enchants.length) {
							if (rarity==3) {
								if (Math.random()<=0.5) {
									item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*20)+10+1);
								}
							} else
								if (rarity==2) {
									item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
								} else {
									item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*6)+1);
								}
						}
					}
					List<String> ourLore = new ArrayList<String>();
					if (rarity==3) {
						int choice1=(int)(Math.random()*Main.getBonusArmorEnchantments().size());
						//Select a random enchantment.
						//This is a mythical. Random amount is 70% guaranteed + 30% random.
						item = this.plugin.addBonusEnchantment(item, Main.getBonusArmorEnchantments().get(choice1), (int)((Math.random()*(Main.getBonusArmorEnchantments().get(choice1).value_range.getMaximumInteger()*0.3))+Main.getBonusArmorEnchantments().get(choice1).value_range.getMaximumInteger()*0.7), true);
						if (item.getItemMeta().hasLore()) {ourLore = item.getItemMeta().getLore();} 
					} else
						if (rarity==2) {
							//This is a legendary. Random amount is 30% guaranteed + 60% random.
							int choice1=(int)(Math.random()*Main.getBonusArmorEnchantments().size());
							item = this.plugin.addBonusEnchantment(item, Main.getBonusArmorEnchantments().get(choice1), (int)((Math.random()*(Main.getBonusArmorEnchantments().get(choice1).value_range.getMaximumInteger()*0.6))+Main.getBonusArmorEnchantments().get(choice1).value_range.getMaximumInteger()*0.3), true);
							if (item.getItemMeta().hasLore()) {ourLore = item.getItemMeta().getLore();} 
						} else
							if (rarity==1) {
								//This is a rare. Random amount is 20% guaranteed + 40% random.
								int choice1=(int)(Math.random()*Main.getBonusArmorEnchantments().size());
								item = this.plugin.addBonusEnchantment(item, Main.getBonusArmorEnchantments().get(choice1), (int)((Math.random()*(Main.getBonusArmorEnchantments().get(choice1).value_range.getMaximumInteger()*0.4))+Main.getBonusArmorEnchantments().get(choice1).value_range.getMaximumInteger()*0.2), true);
								int choice2=(int)(Math.random()*Main.getBonusArmorEnchantments().size());
								while (choice2==choice1) {
									choice2=(int)(Math.random()*Main.getBonusArmorEnchantments().size());
								}
								item = this.plugin.addBonusEnchantment(item, Main.getBonusArmorEnchantments().get(choice2), (int)((Math.random()*(Main.getBonusArmorEnchantments().get(choice2).value_range.getMaximumInteger()*0.4))+Main.getBonusArmorEnchantments().get(choice2).value_range.getMaximumInteger()*0.2), true);
								if (item.getItemMeta().hasLore()) {ourLore = item.getItemMeta().getLore();} 
							}
							else {
								//This is a normal item. Random amount is 5% guaranteed + 20% random.
								//It is also irrepairable.
								int choice1=(int)(Math.random()*Main.getBonusArmorEnchantments().size());
								item = this.plugin.addBonusEnchantment(item, Main.getBonusArmorEnchantments().get(choice1), (int)((Math.random()*(Main.getBonusArmorEnchantments().get(choice1).value_range.getMaximumInteger()*0.2))+Main.getBonusArmorEnchantments().get(choice1).value_range.getMaximumInteger()*0.05), true);
								if (item.getItemMeta().hasLore()) {ourLore = item.getItemMeta().getLore();} 
								ourLore.add(ChatColor.RED+"Irrepairable");
							}
					ItemMeta meta = item.getItemMeta();
					meta.setLore(ourLore);
					if (rarity==1) {
						meta.setDisplayName(ChatColor.BLUE+"Rare "+convertToItemName(item.getType().name().replace("_", " ")));
					}
					if (rarity==2) {
						meta.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"Legendary "+convertToItemName(item.getType().name().replace("_", " ")));
					}
					if (rarity==3) {
						meta.setDisplayName(ChatColor.LIGHT_PURPLE+""+"Mythical "+convertToItemName(item.getType().name().replace("_", " ")));
					}
					item.setItemMeta(meta);
				}
			}
		} else {
			//Add minerals.
			int rand = (int)(Math.random()*18);
			switch (rand) {
			case 0 :
			case 9:
			case 10:
			case 11:{
				item = new ItemStack(Material.IRON_INGOT,(int)(Math.random()*10)+5);
			}break;
			case 1 :{
				item = new ItemStack(Material.IRON_BLOCK,(int)(Math.random()*2)+1);
			}break;
			case 2 :
			case 12:
			case 13:
			case 14:{
				item = new ItemStack(Material.GOLD_INGOT,(int)(Math.random()*5)+2);
			}break;
			case 3 :{
				item = new ItemStack(Material.GOLD_BLOCK,(int)(Math.random()*2)+1);
			}break;
			case 4 :
			case 15:
			case 16:
			case 17: {
				item = new ItemStack(Material.LAPIS_BLOCK,(int)(Math.random()*10)+5);
			}break;
			case 5 :{
				item = new ItemStack(Material.REDSTONE_BLOCK,(int)(Math.random()*6)+1);
			}break;
			case 6 :{
				item = new ItemStack(Material.DIAMOND,(int)(Math.random()*2)+1);
			}break;
			case 7 :{
				if (Math.random()<=0.5) {
					item = new ItemStack(Material.DIAMOND_BLOCK,1);
				}
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
		if (e.getEntity() instanceof Monster) {
			double chance_increase=0;
			if (e.getEntity().getKiller()!=null && ((Player)e.getEntity().getKiller()).getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS)>0) {
				chance_increase=((Player)e.getEntity().getKiller()).getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS)/2;
			}
			int magicfind = 0;
			
			Player p = null;
			if (e.getEntity().getKiller()!=null) {
				p = e.getEntity().getKiller();
			}
			if (p!=null) {
				List<MobHead> playerheads = this.plugin.getMobHeads(p);
				int endermanrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ENDERMAN,true,MobHeadRareType.RARE_TYPE_B), playerheads);
				int endermanpoweredheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ENDERMAN,false,true), playerheads);
				int endermanpoweredrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ENDERMAN,true,true), playerheads);
				
				magicfind+=endermanrareheads;
				magicfind+=endermanpoweredheads;
				magicfind+=endermanpoweredrareheads*3;
			}
			
			for (int i=0;i<e.getDrops().size();i++) {
				if (Math.random()*100<=magicfind) {
					if (e.getDrops().get(i).getMaxStackSize()>=e.getDrops().get(i).getAmount()+1) {
						e.getDrops().get(i).setAmount(e.getDrops().get(i).getAmount()+1);
					}
				}
				if (e.getDrops().get(i).getType()==Material.SKULL_ITEM) {
					if (Math.random()>0.085*chance_increase) {
						e.getDrops().remove(i);
					}
				}
				if (e.getDrops().get(i).getAmount()>1) {
					//Every stack only has half a chance of the previous one to still exist.
					int newamt=1;
					for (int j=0;j<e.getDrops().get(i).getAmount()-1 && Math.random()<=0.5;j++) {
						newamt++;
					}
					e.getDrops().get(i).setAmount(newamt);
				}
			}
			if (Math.random()<=0.00390625) {e.getDrops().add(getGoodie(2));}
			if (Math.random()<=0.00390625/4.0d) {e.getDrops().add(getGoodie(3));}
			if (Math.random()<=Main.HEAD_DROP_CHANCE*chance_increase) {
				switch (e.getEntity().getType()) {
					case SKELETON:{
						if (((Skeleton)e.getEntity()).getSkeletonType()==SkeletonType.WITHER) {
							e.getDrops().add(new MobHead(MobHeadType.CREEPER).getItemStack());
						} else {
							e.getDrops().add(new MobHead(MobHeadType.SKELETON).getItemStack());
						}
					}break;
					case ZOMBIE:{
						e.getDrops().add(new MobHead(MobHeadType.ZOMBIE).getItemStack());
					}break;
					case CREEPER:{
						e.getDrops().add(new MobHead(MobHeadType.CREEPER).getItemStack());
					}break;
					case SPIDER:{
						e.getDrops().add(new MobHead(MobHeadType.SPIDER).getItemStack());
					}break;
					case ENDERMAN:{
						e.getDrops().add(new MobHead(MobHeadType.ENDERMAN).getItemStack());
					}break;
					case CAVE_SPIDER:{
						e.getDrops().add(new MobHead(MobHeadType.CAVE_SPIDER).getItemStack());
					}break;
					case BLAZE:{
						e.getDrops().add(new MobHead(MobHeadType.BLAZE).getItemStack());
					}break;
					case GHAST:{
						e.getDrops().add(new MobHead(MobHeadType.GHAST).getItemStack());
					}break;
					case PIG_ZOMBIE:{
						e.getDrops().add(new MobHead(MobHeadType.ZOMBIE_PIGMAN).getItemStack());
					}break;
					case MAGMA_CUBE:{
						e.getDrops().add(new MobHead(MobHeadType.MAGMA_CUBE).getItemStack());
					}break;
				}
			}
			if (Math.random()<=Main.RARE_HEAD_DROP_CHANCE*chance_increase) {
					switch (e.getEntity().getType()) {
					case SKELETON:{
						if (((Skeleton)e.getEntity()).getSkeletonType()==SkeletonType.WITHER) {
							e.getDrops().add(new MobHead(MobHeadType.WITHER_SKELETON,true).getItemStack());
						} else {
							if (Math.random()<=0.5) {
								e.getDrops().add(new MobHead(MobHeadType.SKELETON,true,MobHeadRareType.RARE_TYPE_A).getItemStack());
							} else {
								e.getDrops().add(new MobHead(MobHeadType.SKELETON,true,MobHeadRareType.RARE_TYPE_B).getItemStack());
							}
						}
					}break;
					case ZOMBIE:{
						if (Math.random()<=0.5) {
							e.getDrops().add(new MobHead(MobHeadType.ZOMBIE,true,MobHeadRareType.RARE_TYPE_A).getItemStack());
						} else {
							e.getDrops().add(new MobHead(MobHeadType.ZOMBIE,true,MobHeadRareType.RARE_TYPE_B).getItemStack());
						}
					}break;
					case CREEPER:{
						if (Math.random()<=0.5) {
							e.getDrops().add(new MobHead(MobHeadType.CREEPER,true,MobHeadRareType.RARE_TYPE_A).getItemStack());
						} else {
							e.getDrops().add(new MobHead(MobHeadType.CREEPER,true,MobHeadRareType.RARE_TYPE_B).getItemStack());
						}
					}break;
					case SPIDER:{
						if (Math.random()<=0.5) {
							e.getDrops().add(new MobHead(MobHeadType.SPIDER,true,MobHeadRareType.RARE_TYPE_A).getItemStack());
						} else {
							e.getDrops().add(new MobHead(MobHeadType.SPIDER,true,MobHeadRareType.RARE_TYPE_B).getItemStack());
						}
					}break;
					case ENDERMAN:{
						if (Math.random()<=0.5) {
							e.getDrops().add(new MobHead(MobHeadType.ENDERMAN,true,MobHeadRareType.RARE_TYPE_A).getItemStack());
						} else {
							e.getDrops().add(new MobHead(MobHeadType.ENDERMAN,true,MobHeadRareType.RARE_TYPE_B).getItemStack());
						}
					}break;
					case CAVE_SPIDER:{
						if (Math.random()<=0.5) {
							e.getDrops().add(new MobHead(MobHeadType.CAVE_SPIDER,true,MobHeadRareType.RARE_TYPE_A).getItemStack());
						} else {
							e.getDrops().add(new MobHead(MobHeadType.CAVE_SPIDER,true,MobHeadRareType.RARE_TYPE_B).getItemStack());
						}
					}break;
					case BLAZE:{
						if (Math.random()<=0.5) {
							e.getDrops().add(new MobHead(MobHeadType.BLAZE,true,MobHeadRareType.RARE_TYPE_A).getItemStack());
						} else {
							e.getDrops().add(new MobHead(MobHeadType.BLAZE,true,MobHeadRareType.RARE_TYPE_B).getItemStack());
						}
					}break;
					case GHAST:{
						if (Math.random()<=0.5) {
							e.getDrops().add(new MobHead(MobHeadType.GHAST,true,MobHeadRareType.RARE_TYPE_A).getItemStack());
						} else {
							e.getDrops().add(new MobHead(MobHeadType.GHAST,true,MobHeadRareType.RARE_TYPE_B).getItemStack());
						}
					}break;
					case PIG_ZOMBIE:{
						if (Math.random()<=0.5) {
							e.getDrops().add(new MobHead(MobHeadType.ZOMBIE_PIGMAN,true,MobHeadRareType.RARE_TYPE_A).getItemStack());
						} else {
							e.getDrops().add(new MobHead(MobHeadType.ZOMBIE_PIGMAN,true,MobHeadRareType.RARE_TYPE_B).getItemStack());
						}
					}break;
					case MAGMA_CUBE:{
						if (Math.random()<=0.5) {
							e.getDrops().add(new MobHead(MobHeadType.MAGMA_CUBE,true,MobHeadRareType.RARE_TYPE_A).getItemStack());
						} else {
							e.getDrops().add(new MobHead(MobHeadType.MAGMA_CUBE,true,MobHeadRareType.RARE_TYPE_B).getItemStack());
						}
					}break;
				}
			}
			if (Math.random()<=0.00390625*chance_increase) {
				ItemStack rename_token = new ItemStack(Material.NAME_TAG);
				e.getDrops().add(rename_token);
			}
		}
		if (e.getEntity() instanceof LivingEntity) {
			LivingEntity f = e.getEntity();
			if (f instanceof Monster) {
				if (this.plugin.getConfig().getBoolean("thanksgiving-enabled") && Math.random()<=0.01) {
					//1% chance of loot chest dropping
				    f.getWorld().dropItemNaturally(f.getLocation(), this.plugin.generate_LootChest());
				}
				if (f.getCustomName()!=null && f.getCustomName().contains(ChatColor.RED+"Counter Slime")) {
					if (f.getLastDamageCause().getEntity() instanceof Player) {
						Player p = (Player)f.getLastDamageCause().getEntity();
						p.damage(f.getLastDamage()*2);
						DecimalFormat df = new DecimalFormat("#0.0");
						DecimalFormat df2 = new DecimalFormat("#0");
						if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify5")) {
							p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"Took "+df.format(f.getLastDamage()*2)+" damage from "+ChatColor.RED+"COUNTER SLIME"+ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+" (-"+df2.format(((f.getLastDamage()*2)/p.getMaxHealth())*100)+"%)");
						}
					}
				}
				if (f.getCustomName()!=null && f.getCustomName().contains(ChatColor.RED+"Viral Spider")) {
					List<Entity> nearents = f.getNearbyEntities(20, 20, 20);
					for (int i=0;i<nearents.size();i++) {
						if (nearents.get(i) instanceof Player) {
							Player p = (Player)(nearents.get(i));
							if (p.hasPotionEffect(PotionEffectType.POISON)) {
								int poisonlevel=0;
								Collection<PotionEffect> pots = p.getActivePotionEffects();
								for (PotionEffect effect : pots) {
									if (effect.getType().getName().equalsIgnoreCase("poison")) {
										poisonlevel = effect.getAmplifier();
										break;
									}
								}
								if (poisonlevel>0) {
									if (p.getHealth()-(poisonlevel/1.15d)>0) {
										p.setHealth(p.getHealth()-(poisonlevel/1.15d));
									} else {
										p.setHealth(0);
									}
									DecimalFormat df = new DecimalFormat("#0.0");
									DecimalFormat df2 = new DecimalFormat("#0");
									double dmg = poisonlevel/1.5d;
									if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify5")) {
										p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"Took "+df.format(dmg)+" damage from "+ChatColor.WHITE+"POISON EXPUNGE"+ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+" (-"+df2.format(((dmg)/p.getMaxHealth())*100)+"%)");
									}
									p.playSound(p.getLocation(), Sound.ZOMBIE_WOODBREAK, 1.0f, 0.8f);
								}
							}
						}
					}
				}
				if (f instanceof Zombie) {
					Zombie z = (Zombie)f;
					if (z.isBaby()) {
						//Randomly drop a loot chest sometimes. (10.5% of the time.)
						if (Math.random() <= 0.105) {
							z.getWorld().dropItemNaturally(z.getLocation(), this.plugin.generate_LootChest());
						}
					}
				}
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
				if (f.getCustomName().contains("Mega Wither")) {
					e.setDroppedExp(e.getDroppedExp()*500);
					if (f.getKiller()!=null) {
						Item id = f.getKiller().getWorld().dropItemNaturally(f.getKiller().getLocation(), this.plugin.generate_LootChest(6));id.setPickupDelay(0);
						id = f.getKiller().getWorld().dropItemNaturally(f.getKiller().getLocation(), this.plugin.generate_LootChest(6));id.setPickupDelay(0);
						id = f.getKiller().getWorld().dropItemNaturally(f.getKiller().getLocation(), this.plugin.generate_LootChest(6));id.setPickupDelay(0);
					}
					for (int i=0;i<this.plugin.hitmoblist.size();i++) {
						for (int j=0;j<this.plugin.hitmoblist.get(i).id.size();j++) {
							if (!this.plugin.hitmoblist.get(i).p.equals(f.getKiller()) && this.plugin.hitmoblist.get(i).id.contains(e.getEntity().getUniqueId())) {
								//Award the assisting player.
								Item id = this.plugin.hitmoblist.get(i).p.getWorld().dropItemNaturally(this.plugin.hitmoblist.get(i).p.getLocation(), this.plugin.generate_LootChest(8));id.setPickupDelay(0);
								id = this.plugin.hitmoblist.get(i).p.getWorld().dropItemNaturally(this.plugin.hitmoblist.get(i).p.getLocation(), this.plugin.generate_LootChest(8));id.setPickupDelay(0);
								id = this.plugin.hitmoblist.get(i).p.getWorld().dropItemNaturally(this.plugin.hitmoblist.get(i).p.getLocation(), this.plugin.generate_LootChest(8));id.setPickupDelay(0);
								break;
							}
						}
					}
					for (int i=0;i<this.plugin.supportmoblist.size();i++) {
						for (int j=0;j<this.plugin.supportmoblist.get(i).id.size();j++) {
							if (!this.plugin.supportmoblist.get(i).p.equals(f.getKiller()) && this.plugin.supportmoblist.get(i).id.contains(e.getEntity().getUniqueId())) {
								//Award the supporting assisting player.
								Item id = this.plugin.hitmoblist.get(i).p.getWorld().dropItemNaturally(this.plugin.hitmoblist.get(i).p.getLocation(), this.plugin.generate_LootChest(8));id.setPickupDelay(0);
								id = this.plugin.hitmoblist.get(i).p.getWorld().dropItemNaturally(this.plugin.hitmoblist.get(i).p.getLocation(), this.plugin.generate_LootChest(8));id.setPickupDelay(0);
								id = this.plugin.hitmoblist.get(i).p.getWorld().dropItemNaturally(this.plugin.hitmoblist.get(i).p.getLocation(), this.plugin.generate_LootChest(8));id.setPickupDelay(0);
								break;
							}
						}
					}
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule mobGriefing false");
				}
				if (f.getCustomName().contains("Mythical Wither")) {
					e.setDroppedExp(e.getDroppedExp()*4000);
					boolean dropMythical=false;
					boolean dropMythical2=false;
					if (f.getKiller()!=null) {
						Item id = f.getKiller().getWorld().dropItemNaturally(f.getKiller().getLocation(), this.plugin.generate_LootChest(7));id.setPickupDelay(0);
						id = f.getKiller().getWorld().dropItemNaturally(f.getKiller().getLocation(), this.plugin.generate_LootChest(6));id.setPickupDelay(0);
						id = f.getKiller().getWorld().dropItemNaturally(f.getKiller().getLocation(), this.plugin.generate_LootChest(6));id.setPickupDelay(0);
					}
					for (int i=0;i<this.plugin.hitmoblist.size();i++) {
						for (int j=0;j<this.plugin.hitmoblist.get(i).id.size();j++) {
							if (!this.plugin.hitmoblist.get(i).p.equals(f.getKiller()) && this.plugin.hitmoblist.get(i).id.contains(e.getEntity().getUniqueId())) {
								//Award the assisting player.
								Item id = this.plugin.hitmoblist.get(i).p.getWorld().dropItemNaturally(this.plugin.hitmoblist.get(i).p.getLocation(), this.plugin.generate_LootChest(8));id.setPickupDelay(0);
								id = this.plugin.hitmoblist.get(i).p.getWorld().dropItemNaturally(this.plugin.hitmoblist.get(i).p.getLocation(), this.plugin.generate_LootChest(8));id.setPickupDelay(0);
								id = this.plugin.hitmoblist.get(i).p.getWorld().dropItemNaturally(this.plugin.hitmoblist.get(i).p.getLocation(), this.plugin.generate_LootChest(8));id.setPickupDelay(0);
								break;
							}
						}
					}
					for (int i=0;i<this.plugin.supportmoblist.size();i++) {
						for (int j=0;j<this.plugin.supportmoblist.get(i).id.size();j++) {
							if (!this.plugin.supportmoblist.get(i).p.equals(f.getKiller()) && this.plugin.supportmoblist.get(i).id.contains(e.getEntity().getUniqueId())) {
								//Award the supporting assisting player.
								Item id = this.plugin.hitmoblist.get(i).p.getWorld().dropItemNaturally(this.plugin.hitmoblist.get(i).p.getLocation(), this.plugin.generate_LootChest(8));id.setPickupDelay(0);
								id = this.plugin.hitmoblist.get(i).p.getWorld().dropItemNaturally(this.plugin.hitmoblist.get(i).p.getLocation(), this.plugin.generate_LootChest(8));id.setPickupDelay(0);
								id = this.plugin.hitmoblist.get(i).p.getWorld().dropItemNaturally(this.plugin.hitmoblist.get(i).p.getLocation(), this.plugin.generate_LootChest(8));id.setPickupDelay(0);
								break;
							}
						}
					}
					//Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule mobGriefing false");
				}
				if (f.getCustomName().contains(ChatColor.DARK_PURPLE+"")) {
					e.setDroppedExp(e.getDroppedExp()*20);
					f.setHealth(0);
					this.plugin.BOSS_DEFEAT=100;
					this.plugin.BOSS_DEFEAT_LOC=f.getLocation();
					if (f.getKiller()!=null) {
						Item id = f.getKiller().getWorld().dropItemNaturally(f.getKiller().getLocation(), this.plugin.generate_LootChest(6));id.setPickupDelay(0);
					}
					for (int i=0;i<this.plugin.hitmoblist.size();i++) {
						for (int j=0;j<this.plugin.hitmoblist.get(i).id.size();j++) {
							if (!this.plugin.hitmoblist.get(i).p.equals(f.getKiller()) && this.plugin.hitmoblist.get(i).id.contains(e.getEntity().getUniqueId())) {
								//Award the assisting player.
								Item id = this.plugin.hitmoblist.get(i).p.getWorld().dropItemNaturally(this.plugin.hitmoblist.get(i).p.getLocation(), this.plugin.generate_LootChest(8));id.setPickupDelay(0);
								break;
							}
						}
					}
					for (int i=0;i<this.plugin.supportmoblist.size();i++) {
						for (int j=0;j<this.plugin.supportmoblist.get(i).id.size();j++) {
							if (!this.plugin.supportmoblist.get(i).p.equals(f.getKiller()) && this.plugin.supportmoblist.get(i).id.contains(e.getEntity().getUniqueId())) {
								//Award the supporting assisting player.
								Item id = this.plugin.hitmoblist.get(i).p.getWorld().dropItemNaturally(this.plugin.hitmoblist.get(i).p.getLocation(), this.plugin.generate_LootChest(8));id.setPickupDelay(0);
								break;
							}
						}
					}
				}
			}
			if (this.plugin.getAccountsConfig().getBoolean("halloween-enabled") || this.plugin.getConfig().getBoolean("thanksgiving-enabled")) {
				e.setDroppedExp(e.getDroppedExp()*2);
			}
			if (f.getKiller()!=null && f.getKiller().getType()==EntityType.PLAYER) {
				Player p = f.getKiller();
				if (f.getType()==EntityType.SKELETON && ((Skeleton)f).getSkeletonType()==SkeletonType.WITHER) {
					this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".bonus.witherskeleton", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".bonus.witherskeleton"))+1);
				}
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
								this.plugin.gainMoneyExp(this.plugin.supportmoblist.get(i).p,"Support",0.025,3);
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
				if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify3")) {
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
			final Player p = (Player)e.getEntity();
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				@Override
				public void run() {
					p.getScoreboard().getTeam(p.getName().toLowerCase()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth(),p.getFoodLevel()));
				}
			},5);
			if (this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat9")>0) {
				if (Math.random()<=this.plugin.getStatBonus(8, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat9"))/100.0d) {
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
			if (p.getInventory().getHelmet() != null && p.getInventory().getHelmet().hasItemMeta() && p.getInventory().getHelmet().getItemMeta().getLore() != null) { // Screw null pointer exceptions
				for(String s : p.getInventory().getHelmet().getItemMeta().getLore()) {
					// Check for food replenish.
					if (s.contains(ChatColor.AQUA+"Food replenish")) {
						e.setFoodLevel(20);
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
		if (this.plugin.last_lightning_random_time<Main.SERVER_TICK_TIME) {
			this.plugin.last_lightning_random_time=Main.SERVER_TICK_TIME+60;
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
		Player p = e.getPlayer();
		if (e.getState()==State.FISHING) {
			PlayerData pd = this.plugin.getPlayerData(p);
			if (Main.SERVER_TICK_TIME-pd.fishingroduse<40+pd.fishingrodfails*10) { /*We're lenient at first, but make it worse if we keep doing it fast.*/
				pd.fishingrodfails++;
				if (pd.fishingrodfails>4) {
					if (p.getItemInHand().getType()==Material.FISHING_ROD) {
						p.getItemInHand().setDurability((short)(p.getItemInHand().getDurability()+10+pd.fishingrodfails));
					}
				}
			}
			pd.fishingroduse = Main.SERVER_TICK_TIME; 
			if (this.plugin.hasJobBuff("Fisherman", p, Job.JOB30A)) {
				//Bukkit.getLogger().info("Fishing chance is "+e.getHook().getBiteChance()+".");
				e.getHook().setBiteChance(e.getHook().getBiteChance()+(e.getHook().getBiteChance()*0.3));
				//Bukkit.getLogger().info("Increasing fishing chance to "+e.getHook().getBiteChance()+".");
			}
			if (this.plugin.hasJobBuff("Fisherman", p, Job.JOB30B)) {
				//Bukkit.getLogger().info("Fishing chance is "+e.getHook().getBiteChance()+".");
				e.getHook().setBiteChance(pd.fishingrodcatchrate+(pd.fishingrodcatchrate*0.05));
				//Bukkit.getLogger().info("Increasing fishing chance to "+e.getHook().getBiteChance()+".");
			}
			if (this.plugin.hasJobBuff("Fisherman", p, Job.JOB40)) {
				if (p.getItemInHand().getType()==Material.FISHING_ROD) {
					p.getItemInHand().setDurability((short)0);
				}
				e.getHook().setBiteChance(e.getHook().getBiteChance()+(e.getHook().getBiteChance()*0.5));
			}
		}
		if (e.getState()==State.FAILED_ATTEMPT) {
			PlayerData pd = this.plugin.getPlayerData(p);
			//Bukkit.getLogger().info("Fishing chance is reset.");
			pd.fishingrodcatchrate=0.002;
			pd.fishingstreak=0;
			if (this.plugin.hasJobBuff("Fisherman", p, Job.JOB30B)) {
				p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"Fishing streak reset...");
			}
		}
		if (e.getState()==State.CAUGHT_FISH) {
			if (this.plugin.getConfig().getBoolean("thanksgiving-enabled")) {
				if (Math.random() < 0.50) {
					// 50% chance of fishing up a chicken plus feathers
					e.setExpToDrop(e.getExpToDrop() * 2);
					e.getPlayer().getWorld().dropItemNaturally(e.getPlayer().getLocation(), new ItemStack(Material.RAW_CHICKEN));
					e.getPlayer().getWorld().dropItemNaturally(e.getPlayer().getLocation(), new ItemStack(Material.FEATHER, 1 + (int)(Math.random() * 4)));
				}
				for (int c = 0; c < 5 && Math.random() < 0.20; c++) {
					// 20% chance each of catching additional fish
					e.setExpToDrop(e.getExpToDrop() + (int)(Math.random() * 6) + 1);
					e.getPlayer().getWorld().dropItemNaturally(e.getPlayer().getLocation(), new ItemStack(Material.RAW_FISH));
				}
				if (Math.random() < 0.10) {
					// 10% chance of fishing up a loot chest
					e.setExpToDrop(e.getExpToDrop() + (int)(Math.random() * 6) + 1);
					e.getPlayer().getWorld().dropItemNaturally(e.getPlayer().getLocation(), this.plugin.generate_LootChest());
				}
			}
			if (this.plugin.hasJobBuff("Fisherman", p, Job.JOB30A)) {
				e.setExpToDrop(e.getExpToDrop()*2);
				p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.RAW_FISH));
				this.plugin.gainMoneyExp(p,"Fisherman",0.175,3);
				this.plugin.gainMoneyExp(p,"Fisherman",0.175,3);
				if (p.getItemInHand().getType()==Material.FISHING_ROD) {
					if (p.getItemInHand().getDurability()>0) {
						if (Math.random()>=0.25) {
							p.getItemInHand().setDurability((short)(p.getItemInHand().getDurability()-1));
						}
					}
				}
			}
			if (this.plugin.hasJobBuff("Fisherman", p, Job.JOB30B)) {
				this.plugin.getPlayerData(p).fishingstreak++;
				this.plugin.getPlayerData(p).fishingrodcatchrate+=this.plugin.getPlayerData(p).fishingrodcatchrate*0.05;
				DecimalFormat df = new DecimalFormat("#0.0");
				if (this.plugin.getPlayerData(p).fishingstreak%5==0) {
					p.sendMessage(ChatColor.GREEN+""+this.plugin.getPlayerData(p).fishingstreak+" in a row! "+ChatColor.GRAY+""+ChatColor.ITALIC+"Current Fish Catch Rate: "+(df.format((this.plugin.getPlayerData(p).fishingrodcatchrate/0.002)*100))+"%");
				}
			}
			if (this.plugin.PlayerinJob(p, "Fisherman")) {
				this.plugin.gainMoneyExp(p,"Fisherman",0.175,3);
				if (this.plugin.hasJobBuff("Fisherman", p, Job.JOB5)) {
					//Half chance to set the durability back by one.
					if (p.getItemInHand().getType()==Material.FISHING_ROD) {
						if (p.getItemInHand().getDurability()>0) {
							if (Math.random()>=0.5) {
								p.getItemInHand().setDurability((short)(p.getItemInHand().getDurability()-1));
							}
						}
					}
				}
				if (this.plugin.hasJobBuff("Fisherman", p, Job.JOB20)) {
					e.setExpToDrop(e.getExpToDrop()*2);
					int i=4;
					while (i>0) {
						if (Math.random()<=0.25) {
							this.plugin.gainMoneyExp(p,"Fisherman",0.175,3);
							if (Math.random()<=0.50) {
								p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.COOKED_FISH));
								//p.getInventory().addItem(new ItemStack(Material.COOKED_FISH));
								this.plugin.gainMoneyExp(p,"Fisherman",0.125,2);
							} else {
								p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.RAW_FISH));
								//p.getInventory().addItem(new ItemStack(Material.RAW_FISH));
							}
						}
						i--;
					}
				} else
					if (this.plugin.hasJobBuff("Fisherman", p, Job.JOB10)) {
						e.setExpToDrop(e.getExpToDrop()*2);
						if (Math.random()<=0.25) {
							p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.RAW_FISH));
							//p.getInventory().addItem(new ItemStack(Material.RAW_FISH));
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
		if (this.plugin.chunk_queue_list!=null && e.getChunk()!=null && e.getChunk().isLoaded()) {
			this.plugin.chunk_queue_list.add(e.getChunk());
			if (this.plugin.chunk_queue_list.size()>640) {
				this.plugin.chunk_queue_list.remove(0);
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
		boolean disabled = false; // set to true to disable custom anvils

		// Inventory override if anvil.
		if (e.getInventory().getType() == InventoryType.ANVIL && !disabled) {
			// Bukkit.getLogger().info("If triggered.");

			Inventory i = Bukkit.createInventory(e.getPlayer(), 27, "Repair and Enchant");
			ItemStack filler, temp;
			int count = -1;

			temp = new ItemStack(Material.COBBLESTONE);

			ItemMeta temp_meta = temp.getItemMeta();
			temp_meta.setDisplayName(ChatColor.YELLOW + "Item Input");
			List<String> temp_meta_lore = new ArrayList<String>();
			temp_meta_lore.add(ChatColor.ITALIC
					+ "Place the item to be repaired or enchanted here.");
			temp_meta.setLore(temp_meta_lore);
			temp.setItemMeta(temp_meta);
			temp.setType(Material.IRON_AXE);
			i.setItem(count += 2, temp);

			temp_meta.setDisplayName(ChatColor.YELLOW + "Item Tributes");
			temp_meta_lore = new ArrayList<String>();
			temp_meta_lore.add(ChatColor.ITALIC
					+ "Place applicable item tributes here.");
			temp_meta_lore.add(ChatColor.ITALIC + "");
			temp_meta_lore.add(ChatColor.ITALIC + "" + ChatColor.GRAY
					+ "Chainmail repairs with iron ingots.");
			temp_meta.setLore(temp_meta_lore);
			temp.setItemMeta(temp_meta);
			temp.setType(Material.IRON_INGOT);
			i.setItem(count += 2, temp);

			temp_meta.setDisplayName(ChatColor.YELLOW + "Magical Artifacts");
			temp_meta_lore = new ArrayList<String>();
			temp_meta_lore.add(ChatColor.ITALIC
					+ "Place applicable magic artifacts here.");
			temp_meta_lore.add(ChatColor.ITALIC + "");
			temp_meta_lore.add(ChatColor.ITALIC + "" + ChatColor.GRAY
					+ "Includes enchanted boots and repair shards.");
			temp_meta.setLore(temp_meta_lore);
			temp.setItemMeta(temp_meta);
			temp.setType(Material.WRITTEN_BOOK);
			i.setItem(count += 2, temp);

			temp_meta.setDisplayName(ChatColor.YELLOW + "Output");
			temp_meta_lore = new ArrayList<String>();
			temp_meta_lore.add(ChatColor.ITALIC
					+ "Grab your finished item here!");
			temp_meta.setLore(temp_meta_lore);
			temp.setItemMeta(temp_meta);
			temp.setType(Material.CHEST);
			i.setItem(count += 2, temp);

			temp_meta.setDisplayName(ChatColor.YELLOW + "Experience Cost");
			temp_meta_lore = new ArrayList<String>();
			temp_meta_lore.add(ChatColor.ITALIC
					+ "Experience Cost of Enchanting.");
			temp_meta.setLore(temp_meta_lore);
			temp.setItemMeta(temp_meta);
			temp.setType(Material.SLIME_BALL);
			i.setItem(count += 15, temp);

			temp_meta.setDisplayName(ChatColor.RESET + "Anvil Interface");
			temp_meta_lore = new ArrayList<String>();
			temp_meta_lore.add(ChatColor.GRAY + "Nothing to see here. Shoo!");
			temp_meta.setLore(temp_meta_lore);
			temp.setItemMeta(temp_meta);
			temp.setType(Material.COBBLESTONE);
			for (int c = 0; c < 27; c++) {
				if (i.getItem(c) == null) {
					i.setItem(c, temp);
				}
			}
			i.setItem(10, new ItemStack(Material.AIR));
			i.setItem(12, new ItemStack(Material.AIR));
			i.setItem(14, new ItemStack(Material.AIR));
			i.setItem(16, new ItemStack(Material.AIR));

			e.setCancelled(true);

			e.getPlayer().closeInventory();
			e.getPlayer().openInventory(i);

		}
		// 笆�笆�(Player)e.getPlayer()).sendMessage(((Player)e.getPlayer()).getScoreboard().getPlayerTeam((OfflinePlayer)e.getPlayer()).getName());
		Player p = (Player)e.getPlayer();
		p.getScoreboard().getTeam(p.getName().toLowerCase()).setPrefix(ChatColor.DARK_GRAY+"");
		if (p.hasPermission("group.moderator")) {
			p.getScoreboard().getTeam(p.getName().toLowerCase()).setPrefix(ChatColor.DARK_GREEN+"");
		}
		if (p.hasPermission("group.administrators")) {
			p.getScoreboard().getTeam(p.getName().toLowerCase()).setPrefix(ChatColor.DARK_PURPLE+"");
		}
		if (this.plugin.getConfig().getBoolean("halloween-enabled")) {
			for (int m=0;m<e.getInventory().getSize();m++) {
				if (e.getInventory().getContents()[m]!=null && e.getInventory().getContents()[m].getType()==Material.PUMPKIN_PIE) { 
					if (e.getInventory().getContents()[m].getItemMeta().getDisplayName()!=null && e.getInventory().getContents()[m].getItemMeta().getDisplayName().contains("Pie ")) {
						int numb = Integer.valueOf(e.getInventory().getContents()[m].getItemMeta().getDisplayName().replace("Pie ",""));
						if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".halloween.chest"+numb)) {
							p.closeInventory();
							p.sendMessage("You already got this magic pie!");
							e.setCancelled(true);
						} else {
							//Show the user a fake inventory containing the magic pie.
							this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".halloween.chest"+numb, Boolean.valueOf(true));
							//this.plugin.saveAccountsConfig();
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
			if (this.plugin.getConfig().getBoolean("halloween-enabled")) {
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
	}

	final public void FatalSurvivor(final Player p) {
		p.setHealth(p.getMaxHealth());
		p.setMaximumNoDamageTicks(100);
		p.setNoDamageTicks(100);
		Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
			@Override
			public void run() { //After 5 seconds, set the no Damage Ticks back to normal.
				p.setMaximumNoDamageTicks(20);
			}
		},100);
		p.sendMessage("You used your "+ChatColor.YELLOW+"Lv10 Fatal Survivor"+ChatColor.WHITE+" buff. Your health has been restored."+ChatColor.AQUA+" It will be recharged in one hour.");
		Bukkit.broadcastMessage(ChatColor.YELLOW+p.getName()+ChatColor.WHITE+" has died...and revived through sheer willpower!");
		p.setFireTicks(0);
		p.setFoodLevel(20);
		p.setRemainingAir(p.getMaximumAir());
		this.plugin.REVIVE_EFFECT=90;
		this.plugin.REVIVE_EFFECT_LOC = p.getLocation();
		PersistentExplorerList ev = new PersistentExplorerList(p.getName().toLowerCase());
		ev.event=0;
		this.plugin.explorers.add(ev);
	}
	

	final public void doFireAspectDamage(final LivingEntity l, final Main plug) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
			@Override
			public void run() {
				if (l.getHealth()!=0 && l.getFireTicks()>60 && !l.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
					double firedmg=1;
					double oldfireticks=l.getFireTicks();
					DecimalFormat df = new DecimalFormat("#0.0");
					DecimalFormat df2 = new DecimalFormat("#0");
					//Bukkit.getLogger().info(l.getType().name()+" health: "+l.getHealth()+", Fire ticks:"+l.getFireTicks());
					//Get all fire protection values.
					if (l.getEquipment().getBoots()!=null) {
						for (int i=0;i<l.getEquipment().getBoots().getEnchantmentLevel(Enchantment.PROTECTION_FIRE);i++) {
							firedmg*=0.92;
							oldfireticks*=0.92;
						}
					}
					if (l.getEquipment().getLeggings()!=null) {
						for (int i=0;i<l.getEquipment().getLeggings().getEnchantmentLevel(Enchantment.PROTECTION_FIRE);i++) {
							firedmg*=0.92;
							oldfireticks*=0.92;
						}
					}
					if (l.getEquipment().getChestplate()!=null) {
						for (int i=0;i<l.getEquipment().getChestplate().getEnchantmentLevel(Enchantment.PROTECTION_FIRE);i++) {
							firedmg*=0.92;
							oldfireticks*=0.92;
						}
					}
					if (l.getEquipment().getHelmet()!=null) {
						for (int i=0;i<l.getEquipment().getHelmet().getEnchantmentLevel(Enchantment.PROTECTION_FIRE);i++) {
							firedmg*=0.92;
							oldfireticks*=0.92;
						}
					}
					l.setFireTicks((int)oldfireticks);
					l.getWorld().playSound(l.getLocation(), Sound.FIZZ, 0.2f, 1);
					if (l.getHealth()-firedmg>0) {
						l.setHealth(l.getHealth()-firedmg);
					} else {
						l.setHealth(0);
					}
					if (l instanceof Player) {
						if (plug.getAccountsConfig().getBoolean(((Player)l).getName()+".settings.notify5")) {
							((Player)l).sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"Took "+df.format(firedmg)+" damage from "+ChatColor.WHITE+"FIRE_TICK"+ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+" (-"+df2.format(((firedmg)/l.getMaxHealth())*100)+"%)");
						}
					}
					doFireAspectDamage(l, plug);
				}
			}
		},(int)(20/((double)l.getFireTicks()/60))+1);
	}

	@EventHandler
	public void onHurt(EntityDamageEvent e) {
		final EntityDamageEvent f = e;
		if (e.getEntity() instanceof Monster && e.getCause()==DamageCause.SUFFOCATION) {
			LivingEntity l = (LivingEntity)e.getEntity();
			if (l.getTicksLived()<60) {
				//Check around itself for other mobs. Teleport it there possibly. Higher chance
				//of teleporting to mobs of the same type.
				boolean mobfound=false;
				List<Entity> nearby = l.getNearbyEntities(20, 20, 20);
				for (int i=0;i<nearby.size();i++) {
					if (!(nearby.get(i) instanceof Monster)) {
						nearby.remove(i);
						i--;
					}
				}
				for (int i=0;i<nearby.size();i++) {
					double chancer=0;
					if (nearby.get(i).getType()==l.getType()) {
						chancer=0.5;
					}
					final Entity teleport_entity = e.getEntity();
					final Entity teleport_to = nearby.get(i);
					if (Math.random()<=chancer+0.25 && nearby.get(i).getTicksLived()>60 && (nearby.get(i).getLastDamageCause()==null || nearby.get(i).getLastDamageCause().getCause()!=DamageCause.SUFFOCATION)) {
						Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
							@Override
							public void run() {
								teleport_entity.teleport(teleport_to);
							}
						},1);
						mobfound=true;
						break;
					}
				}
				if (mobfound) {
					e.setDamage(0);
					e.setCancelled(true);
				} else {
					e.getEntity().remove();
					e.setDamage(0);
					e.setCancelled(true);
				}
			}
		}
		if (e.getEntity().getType()==EntityType.PLAYER) {
			final Player p = (Player)e.getEntity();
			if (this.plugin.getPlayerData(p).invulntime!=0) {
				//Bukkit.getLogger().info("Invuln time");
				e.setDamage(0);
			}
			if (this.plugin.hasJobBuff("Hunter", p, Job.JOB40)) {
				e.setDamage(e.getDamage()*0.70d);
			}
			if (e.getCause()==DamageCause.ENTITY_EXPLOSION || e.getCause()==DamageCause.BLOCK_EXPLOSION) {
				e.setDamage(e.getDamage()*2);
			}
			if (e.getCause()==DamageCause.WITHER) {
				// For each Witherless Rose, add a multiplicative 25% chance to negate this tick of wither damage.
				if (p.hasPotionEffect(PotionEffectType.WITHER)) {
					Collection<PotionEffect> pots = p.getActivePotionEffects();
					int witherlevel=0;
					for (PotionEffect effect : pots) {
						if (effect.getType().getName().equalsIgnoreCase("wither")) {
							witherlevel = effect.getAmplifier();
							break;
						}
					}
					e.setDamage(witherlevel*e.getDamage());
				}
				if (Math.random() > Math.pow(0.75, this.plugin.getWitherlessRoseCount(p))) {
					e.setCancelled(true);
				}
			}
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				@Override
				public void run() {
					p.getScoreboard().getTeam(p.getName().toLowerCase()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth(),p.getFoodLevel()));
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
						if (this.plugin.explorers.get(i).event==0 && this.plugin.explorers.get(i).name.compareTo(p.getName().toLowerCase())==0) {
							survivor=true;
							break;
						}
					}
					PersistentExplorerList eve = new PersistentExplorerList(p.getName().toLowerCase());
					eve.event=1;
					eve.data=p.getExp();
					eve.data2=p.getLevel();
					eve.expiretime=Main.SERVER_TICK_TIME+1200;
					this.plugin.explorers.add(eve);
					if (!survivor) {
						Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
							@Override
							public void run() {
								if (p.getHealth()<=0) {
									FatalSurvivor(p);
								}
							}
						},1);
					}
				}
			}
			final double player_starthp = p.getHealth();
			if (p.getNoDamageTicks()<p.getMaximumNoDamageTicks()/2.0f && this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify5") && e.getCause()!=DamageCause.ENTITY_ATTACK && e.getCause()!=DamageCause.ENTITY_EXPLOSION && e.getDamage()!=0) {
				final Main plugin = this.plugin;
				Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					@Override
					public void run() {
						DecimalFormat df = new DecimalFormat("#0.0");
						DecimalFormat df2 = new DecimalFormat("#0");
						if (player_starthp-p.getHealth()>=0.5) {
							p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"Took "+df.format(player_starthp-p.getHealth())+" damage from "+ChatColor.WHITE+f.getCause().toString()+ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+" (-"+df2.format(((player_starthp-p.getHealth())/p.getMaxHealth())*100)+"%)");
						}
						if (plugin.PlayerinJob(p, "Explorer")) {
							if (plugin.getJobLv("Explorer", p)>=10) {
								//Check to see if our "fatal s	urvivor" effect is available.
								boolean survivor=false;
								for (int i=0;i<plugin.explorers.size();i++) {
									if (plugin.explorers.get(i).event==0 && plugin.explorers.get(i).name.compareTo(p.getName().toLowerCase())==0) {
										survivor=true;
										break;
									}
								}
								PersistentExplorerList eve = new PersistentExplorerList(p.getName().toLowerCase());
								eve.event=1;
								eve.data=p.getExp();
								eve.data2=p.getLevel();
								eve.expiretime=Main.SERVER_TICK_TIME+1200;
								plugin.explorers.add(eve);
								if (!survivor) {
									if (p.getHealth()<=0) {
										FatalSurvivor(p);
									}
								}
							}
						}
					}
				},1);
			}
		}
		EntityType allowedtypes[] = {EntityType.BAT,EntityType.BLAZE,EntityType.CAVE_SPIDER,EntityType.ENDERMAN,EntityType.GHAST,EntityType.MAGMA_CUBE,EntityType.PIG_ZOMBIE,EntityType.SILVERFISH,EntityType.SLIME,EntityType.SPIDER,EntityType.ZOMBIE,EntityType.SKELETON,EntityType.CREEPER};
		boolean contains=e.getEntity() instanceof LivingEntity;
		if (contains) {
			LivingEntity l = (LivingEntity)e.getEntity();
			if (l.getFireTicks()>60 && e.getCause()==DamageCause.LAVA && !l.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
				l.setFireTicks(l.getFireTicks()+20);
			}
		}
	}

	@EventHandler
	public void onPlayerPickup(PlayerPickupItemEvent e) {
		if (this.plugin.getAccountsConfig().getBoolean(e.getPlayer().getName().toLowerCase()+".settings.notify1")) {
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
			boolean same=false;
			for (int i=0;i<e.getPlayer().getInventory().getContents().length;i++) {
				if (hasSameItem(e.getItem().getItemStack(),e.getPlayer().getInventory().getContents()[i])) {
					same=true;
					break;
				}
			}
			if (this.plugin.inventoryFull(e.getPlayer())) {
				if (e.getItem().getItemStack().hasItemMeta() && e.getItem().getItemStack().getItemMeta().hasDisplayName()) {
					if (e.getRemaining()==0 && same) {
						p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"Picked up "+e.getItem().getItemStack().getAmount()+" "+e.getItem().getItemStack().getItemMeta().getDisplayName()+".");
					}
				} else {
					if (e.getRemaining()==0 && same) {
						if (special_convert(e.getItem().getItemStack().getType())) {
							p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"Picked up "+e.getItem().getItemStack().getAmount()+" "+convertToItemName(e.getItem().getType().getName(),e.getItem().getItemStack().getData().getData(),e.getItem().getItemStack().getType())+".");
						} else {
							p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"Picked up "+e.getItem().getItemStack().getAmount()+" "+String.valueOf(mod)+".");
						}
					}  
				}
			} else {
				if (e.getItem().getItemStack().hasItemMeta() && e.getItem().getItemStack().getItemMeta().hasDisplayName()) {
					if (e.getRemaining()==0) {
						p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"Picked up "+e.getItem().getItemStack().getAmount()+" "+e.getItem().getItemStack().getItemMeta().getDisplayName()+".");
					}
				} else {
					if (e.getRemaining()==0) {
						if (special_convert(e.getItem().getItemStack().getType())) {
							p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"Picked up "+e.getItem().getItemStack().getAmount()+" "+convertToItemName(e.getItem().getType().getName(),e.getItem().getItemStack().getData().getData(),e.getItem().getItemStack().getType())+".");
						} else {
							p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"Picked up "+e.getItem().getItemStack().getAmount()+" "+String.valueOf(mod)+".");
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onPlayerOnFire(EntityCombustEvent e) {
		boolean fireResist = false;
		if (e.getEntity().getType()==EntityType.PLAYER) {
			Player p = (Player)e.getEntity();
			if (this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat6")>0) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, (this.plugin.getStatBonus(5, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat6"))/3)*20, 0));
			}
			if (p.getInventory().getChestplate() != null && p.getInventory().getChestplate().hasItemMeta() && p.getInventory().getChestplate().getItemMeta().getLore() != null) { // Screw null pointer exceptions
				for(String s : p.getInventory().getChestplate().getItemMeta().getLore()) {
					// Check for fire resist
					if (s.contains(ChatColor.AQUA+"Fire resistance")) {
						e.setCancelled(true);
						fireResist = true;
					}
				}
			}
		}
		if (e.getEntity() instanceof LivingEntity && !fireResist) {
			if (!((LivingEntity)(e.getEntity())).hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
				doFireAspectDamage(((LivingEntity)e.getEntity()), this.plugin);
			}
		}

	}

	@EventHandler
	public void onRegainHealth(EntityRegainHealthEvent e) {
		if (e.getEntity().getType()==EntityType.PLAYER) {
			final Player p = (Player)e.getEntity();
			p.getScoreboard().getTeam(p.getName().toLowerCase()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth(),p.getFoodLevel()));
			boolean regen_high=false;
			int duration=0;
			if (e.getRegainReason()==RegainReason.MAGIC_REGEN) {
				try {
					Iterator<PotionEffect> effects = p.getActivePotionEffects().iterator();
					//Figure out potion effects when player joins.
					while (effects.hasNext()) {
						PotionEffect nexteffect = effects.next();
						if (nexteffect.getType().getName().compareTo(PotionEffectType.REGENERATION.getName())==0) {
							e.setAmount(e.getAmount()/1.25d);
							if (nexteffect.getAmplifier()>2) {
								regen_high=true;
								duration=nexteffect.getDuration();
							}
						}
						/*if (nexteffect.getType().getName().compareTo(PotionEffectType.JUMP.getName())==0) {
							p.removePotionEffect(PotionEffectType.JUMP);
							p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 360000, nexteffect.getAmplifier()+2, true));
						}*/
					}
				} catch (ConcurrentModificationException ex_e) {
					Bukkit.getLogger().warning("Potion Effect Collection not accessible while trying to regenerate player.");
				}
				final int mod_duration=duration;
				if (regen_high) {
					Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
						@Override
						public void run() {
							p.removePotionEffect(PotionEffectType.REGENERATION);
							p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,mod_duration,2));
						}
					}, 1L);
				}
			}
			if (this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat1")>0) {
				e.setAmount(e.getAmount()+this.plugin.getStatBonus(0, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat1")/6));
			}
		}
	}

	@EventHandler
	public void onEnemyHit(EntityDamageByEntityEvent e) {
		
		boolean blocked_attack=false; //Whether or not this attack was blocked. A flag used to detect durability reduction.
		boolean blocked_hunter_buff=false; //Whether or not the block occurred due to the hunter buff.

		//**********************************//Player buffs begin
		if (e.getDamager() instanceof LightningStrike) {
			if (e.getEntity() instanceof Enderman) {
				LivingEntity l = (LivingEntity)e.getEntity();
				if (l.getCustomName()!=null && l.getCustomName().contains(ChatColor.RED+"Lightning Mage")) {
					e.setDamage(0);
					e.setCancelled(true);
					return;
				}
			}
		}
		if (e.getDamager() instanceof Player) {
			Player p = (Player)e.getDamager();
			if (p.hasPotionEffect(PotionEffectType.BLINDNESS)) {
				e.setDamage(0);
				e.setCancelled(true);
				return;
			}
			if (p.getItemInHand()!=null) {
				if (p.getItemInHand().getType().toString().toLowerCase().contains("sword")) {
					//Divide damage by 2.4.
					e.setDamage(e.getDamage()/2.4d);
					//Increase damage based on power level of weapon.
					double dmg_ratio = 0;
					if (p.getItemInHand().getType()==Material.WOOD_SWORD) {
						//Damage increases by 0.5 per Power level.
						dmg_ratio = 0.5;
					}
					if (p.getItemInHand().getType()==Material.STONE_SWORD) {
						//Damage increases by 1.0 per Power level.
						dmg_ratio = 1;
					}
					if (p.getItemInHand().getType()==Material.IRON_SWORD) {
						//Damage increases by 1.5 per Power level.
						dmg_ratio = 1.5;
					}
					if (p.getItemInHand().getType()==Material.DIAMOND_SWORD) {
						//Damage increases by 2.0 per Power level.
						dmg_ratio = 2;
					}
					if (p.getItemInHand().getType()==Material.GOLD_SWORD) {
						//Damage increases by 8.0 per Power level.
						dmg_ratio = 8;
					}
					if (p.getItemInHand().containsEnchantment(Enchantment.ARROW_DAMAGE)) {
						e.setDamage(e.getDamage()+(p.getItemInHand().getEnchantmentLevel(Enchantment.ARROW_DAMAGE)*dmg_ratio));
					}
				}
			}
			if (p.getItemInHand()!=null && this.plugin.hasBonusEnchantment(p.getItemInHand(), this.plugin.ENCHANT_EXECUTE)) {
				if (e.getEntity() instanceof LivingEntity) {
					LivingEntity l = (LivingEntity)e.getEntity();
					e.setDamage(e.getDamage()+(5-((l.getHealth()/l.getMaxHealth())*100/20))*(0.5*this.plugin.getBonusEnchantmentLevel(p.getItemInHand(), this.plugin.ENCHANT_EXECUTE)));
					Bukkit.getLogger().info("Dealt "+((5-((l.getHealth()/l.getMaxHealth())*100/20))*(0.5*this.plugin.getBonusEnchantmentLevel(p.getItemInHand(), this.plugin.ENCHANT_EXECUTE)))+" extra damage to target.");
				}
			}
			if (p.getItemInHand()!=null && p.getItemInHand().getType().name().toLowerCase().contains("axe") && !p.getItemInHand().getType().name().toLowerCase().contains("pickaxe") && this.plugin.hasJobBuff("Woodcutter", p, Job.JOB30A)) {
				p.getItemInHand().setDurability((short)0);
			}
			Collection<PotionEffect> effects = p.getActivePotionEffects();
			for (PotionEffect pe : effects) {
				if (pe.getType()==PotionEffectType.INCREASE_DAMAGE) {
					//We have to first lower damage to what it should be without the amplification.
					e.setDamage(e.getDamage()/(pe.getAmplifier()*1.3));
					//Now apply only 30% increase per level.
					e.setDamage(e.getDamage()+(e.getDamage()*(pe.getAmplifier()*0.3)));
				}
			}
		}
		if (e.getEntity() instanceof Player) {
			Player p = (Player)e.getEntity();
			if (this.plugin.hasJobBuff("Builder", p, Job.JOB40) && p.getAllowFlight()) {
				if (p.getGameMode()!=GameMode.CREATIVE) {
					p.setAllowFlight(false);
					p.setFlying(false);
				}
				p.sendMessage(ChatColor.DARK_RED+""+ChatColor.ITALIC+"Flight disabled...");
			}
		}
		//**********************************//Player buffs end
		boolean hitByPoweredMob=false;
		if ((e.getDamager() instanceof WitherSkull) || (e.getDamager() instanceof Wither)) {
			if (e.getEntity() instanceof Player) {
				final Player p = (Player)e.getEntity();
				final Collection<PotionEffect> pots = p.getActivePotionEffects();
				Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					@Override
					public void run() {
					int witherlevel=0, witherduration=0;
					for (PotionEffect effect : pots) {
						if (effect.getType().getName().equalsIgnoreCase("wither")) {
							witherlevel = effect.getAmplifier();
							witherduration = effect.getDuration();
							break;
						}
					}
					//Bukkit.getLogger().info("Wither level adjusted from "+witherlevel+" to "+(++witherlevel)+".");
					p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, witherduration, witherlevel++),true);
					}
				},1);
			}
		}
		if (e.getDamager() instanceof Skeleton || ((e.getDamager() instanceof Projectile) && ((Projectile)e.getDamager()).getShooter() instanceof Skeleton)) {
			Skeleton s = null;
			if (e.getDamager() instanceof Projectile) {
				s = (Skeleton)((Projectile)e.getDamager()).getShooter();
			} else {
				s = (Skeleton)e.getDamager();
			}
			if (s.getSkeletonType()==SkeletonType.WITHER) {
				if (e.getEntity() instanceof Player) {
					final Player p = (Player)e.getEntity();
					final Collection<PotionEffect> pots = p.getActivePotionEffects();
					Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
						@Override
						public void run() {
						int witherlevel=0, witherduration=0;
						for (PotionEffect effect : pots) {
							if (effect.getType().getName().equalsIgnoreCase("wither")) {
								witherlevel = effect.getAmplifier();
								witherduration = effect.getDuration();
								break;
							}
						}
						//Bukkit.getLogger().info("Wither level adjusted from "+witherlevel+" to "+(++witherlevel)+".");
						p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, witherduration, witherlevel++),true);
						}
					},1);
				}
			}
		}
		if (e.getEntity() instanceof LivingEntity) {
			final LivingEntity l = (LivingEntity)e.getEntity();
			if (e.getDamager() instanceof Monster) {
				e.getDamager().teleport(e.getDamager());
			}
			if (e.getDamager() instanceof Projectile) {
				if (((Projectile)e.getDamager()).getShooter() instanceof LivingEntity) {
					LivingEntity l2 = (LivingEntity)(((Projectile)e.getDamager()).getShooter());
					if (l2.hasPotionEffect(PotionEffectType.INVISIBILITY)) {l2.removePotionEffect(PotionEffectType.INVISIBILITY);}
					for (int i=0;i<this.plugin.powered_mob_list.size();i++) {
						if (this.plugin.powered_mob_list.get(i).power_time+40<=Main.SERVER_TICK_TIME && this.plugin.powered_mob_list.get(i).id.equals(l2.getUniqueId())) {
							//This mob will damage you if you are not blocking.
							if (l instanceof Player) {
								Player p = (Player)l;
								if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify5")) {
									if (l2.getCustomName()!=null) {
										DecimalFormat df = new DecimalFormat("#0.0");
										DecimalFormat df2 = new DecimalFormat("#0");
										p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"Took "+df.format(e.getDamage()*2)+" damage from "+l2.getCustomName()+ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+" (-"+df2.format(((e.getDamage()*2)/p.getMaxHealth())*100)+"%)");
									} else {
										DecimalFormat df = new DecimalFormat("#0.0");
										DecimalFormat df2 = new DecimalFormat("#0");
										p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"Took "+df.format(e.getDamage()*2)+" damage from "+ChatColor.WHITE+""+l2.getType().name()+ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+" (-"+df2.format(((e.getDamage()*2)/p.getMaxHealth())*100)+"%)");
									}
								}
								if (!p.isBlocking()) {
									hitByPoweredMob=true;
									if (p.getHealth()-e.getDamage()*4<0) {
										p.setHealth(0);
									} else {
										p.setHealth(p.getHealth()-e.getDamage()*4);
									}
									Main.playFirework(p.getLocation());
									Main.playFirework(p.getLocation());
									Main.playFirework(p.getLocation());
								} else {
									p.playSound(p.getLocation(), Sound.ANVIL_LAND, 0.1f, 3.6f);
									e.setDamage(e.getDamage()/8);
								}
							}
							this.plugin.powered_mob_list.remove(i);
							i--;
							break;
						}
					}
				}
			}
			if (e.getDamager() instanceof LivingEntity) {
				LivingEntity l2 = (LivingEntity)e.getDamager();
				if (l2.hasPotionEffect(PotionEffectType.INVISIBILITY)) {l2.removePotionEffect(PotionEffectType.INVISIBILITY);}
				for (int i=0;i<this.plugin.powered_mob_list.size();i++) {
					if (this.plugin.powered_mob_list.get(i).power_time+40<=Main.SERVER_TICK_TIME && this.plugin.powered_mob_list.get(i).id.equals(l2.getUniqueId())) {
						//This mob will damage you if you are not blocking.
						if (l instanceof Player) {
							Player p = (Player)l;
							if (!p.isBlocking()) {
								hitByPoweredMob=true;
								if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify5")) {
									if (l2.getCustomName()!=null) {
										DecimalFormat df = new DecimalFormat("#0.0");
										DecimalFormat df2 = new DecimalFormat("#0");
										p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"Took "+df.format(e.getDamage()*2)+" damage from "+l2.getCustomName()+ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+" (-"+df2.format(((e.getDamage()*2)/p.getMaxHealth())*100)+"%)");
									} else {
										DecimalFormat df = new DecimalFormat("#0.0");
										DecimalFormat df2 = new DecimalFormat("#0");
										p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"Took "+df.format(e.getDamage()*2)+" damage from "+ChatColor.WHITE+""+l2.getType().name()+ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+" (-"+df2.format(((e.getDamage()*2)/p.getMaxHealth())*100)+"%)");
									}
								}
								if (p.getHealth()-e.getDamage()*2<0) {
									p.setHealth(0);
								} else {
									p.setHealth(p.getHealth()-e.getDamage()*2);
								}
								Main.playFirework(p.getLocation());
								Main.playFirework(p.getLocation());
								Main.playFirework(p.getLocation());
							} else {
								p.playSound(p.getLocation(), Sound.ANVIL_LAND, 0.1f, 3.6f);
								e.setDamage(e.getDamage()/8);
							}
						}
						this.plugin.powered_mob_list.remove(i);
						i--;
						break;
					}
				}
				if (l2.getCustomName()!=null && l2.getCustomName().contains(ChatColor.RED+"Powersurge Zombie")) {
					int dmgamt = 0; //How much the bonus damage rating to do.
					double dmgamt1=0,dmgamt2=0,dmgamt3=0,dmgamt4=0;
					ItemStack item = l.getEquipment().getHelmet();
					if (item!=null) {
						Map<Enchantment,Integer> map = item.getEnchantments();
						  for (Map.Entry<Enchantment,Integer> entry : map.entrySet()) {
							dmgamt1+=entry.getValue();
						  }	
							if (item.getType().name().toLowerCase().contains("diamond")) {
								dmgamt1+=5;
								if (l instanceof Player) {
									Player p = (Player)l;
									p.playSound(p.getLocation(), Sound.EXPLODE, 0.5f, 1.8f);
								}
							}
							if (item.getType().name().toLowerCase().contains("iron")) {
								dmgamt1+=3;
							}
							if (item.getType().name().toLowerCase().contains("leather")) {
								dmgamt1+=1;
							}
							if (item.getType().name().toLowerCase().contains("gold") || item.getType().name().toLowerCase().contains("chain")) {
								dmgamt1+=2;
							}
							if (item.getType().name().toLowerCase().contains("iron")) {
								dmgamt1/=1.5;
								dmgamt+=1.5;
							}
							if (item.getType().name().toLowerCase().contains("leather")) {
								dmgamt1/=8;
								dmgamt+=8;
							}
							if (item.getType().name().toLowerCase().contains("gold") || item.getType().name().toLowerCase().contains("chain")) {
								dmgamt1/=4;
								dmgamt+=4;
							}
					}
					item = l.getEquipment().getChestplate();
					if (item!=null) {
						Map<Enchantment,Integer> map = item.getEnchantments();
						  for (Map.Entry<Enchantment,Integer> entry : map.entrySet()) {
							dmgamt2+=entry.getValue();
						  }	
							if (item.getType().name().toLowerCase().contains("diamond")) {
								dmgamt2+=7;
								if (l instanceof Player) {
									Player p = (Player)l;
									p.playSound(p.getLocation(), Sound.EXPLODE, 0.5f, 1.8f);
								}
							}
							if (item.getType().name().toLowerCase().contains("iron")) {
								dmgamt2+=5;
							}
							if (item.getType().name().toLowerCase().contains("leather")) {
								dmgamt2+=2;
							}
							if (item.getType().name().toLowerCase().contains("gold") || item.getType().name().toLowerCase().contains("chain")) {
								dmgamt2+=4;
							}
							if (item.getType().name().toLowerCase().contains("iron")) {
								dmgamt2/=1.5;
								dmgamt+=1.5;
							}
							if (item.getType().name().toLowerCase().contains("leather")) {
								dmgamt2/=8;
								dmgamt+=8;
							}
							if (item.getType().name().toLowerCase().contains("gold") || item.getType().name().toLowerCase().contains("chain")) {
								dmgamt2/=4;
								dmgamt+=4;
							}
					}
					item = l.getEquipment().getLeggings();
					if (item!=null) {
						Map<Enchantment,Integer> map = item.getEnchantments();
						  for (Map.Entry<Enchantment,Integer> entry : map.entrySet()) {
							dmgamt3+=entry.getValue();
						  }	
							if (item.getType().name().toLowerCase().contains("diamond")) {
								dmgamt3+=4;
								if (l instanceof Player) {
									Player p = (Player)l;
									p.playSound(p.getLocation(), Sound.EXPLODE, 0.5f, 1.8f);
								}
							}
							if (item.getType().name().toLowerCase().contains("iron")) {
								dmgamt3+=2;
							}
							if (item.getType().name().toLowerCase().contains("leather")) {
								dmgamt3+=1;
							}
							if (item.getType().name().toLowerCase().contains("gold") || item.getType().name().toLowerCase().contains("chain")) {
								dmgamt3+=1;
							}
							if (item.getType().name().toLowerCase().contains("iron")) {
								dmgamt3/=1.5;
								dmgamt+=1.5;
							}
							if (item.getType().name().toLowerCase().contains("leather")) {
								dmgamt3/=8;
								dmgamt+=8;
							}
							if (item.getType().name().toLowerCase().contains("gold") || item.getType().name().toLowerCase().contains("chain")) {
								dmgamt3/=4;
								dmgamt+=4;
							}
					}
					item = l.getEquipment().getBoots();
					if (item!=null) {
						Map<Enchantment,Integer> map = item.getEnchantments();
						  for (Map.Entry<Enchantment,Integer> entry : map.entrySet()) {
							dmgamt4+=entry.getValue();
						  }	
							if (item.getType().name().toLowerCase().contains("diamond")) {
								dmgamt4+=2;
								if (l instanceof Player) {
									Player p = (Player)l;
									p.playSound(p.getLocation(), Sound.EXPLODE, 0.5f, 1.8f);
								}
							}
							if (item.getType().name().toLowerCase().contains("iron")) {
								dmgamt4+=1;
							}
							if (item.getType().name().toLowerCase().contains("leather")) {
								dmgamt4+=0;
							}
							if (item.getType().name().toLowerCase().contains("gold") || item.getType().name().toLowerCase().contains("chain")) {
								dmgamt4+=1;
							}
							if (item.getType().name().toLowerCase().contains("iron")) {
								dmgamt4/=1.5;
								dmgamt+=1.5;
							}
							if (item.getType().name().toLowerCase().contains("leather")) {
								dmgamt4/=8;
								dmgamt+=8;
							}
							if (item.getType().name().toLowerCase().contains("gold") || item.getType().name().toLowerCase().contains("chain")) {
								dmgamt4/=4;
								dmgamt+=4;
							}
					}
					e.setDamage((e.getDamage()+dmgamt1+dmgamt2+dmgamt3+dmgamt4)/dmgamt);
					e.setDamage(e.getDamage()+Math.pow(dmgamt,1.65));
				}
			}
			if (l.getCustomName()!=null && l.getCustomName().contains(ChatColor.RED+"Wolf Minion")) {
				e.setDamage(e.getDamage()*1.5);
			}
			if (l.getCustomName()!=null && l.getCustomName().contains(ChatColor.RED+"Hound Caller")) {
				e.setDamage(e.getDamage()*2.5);
				if (Math.random()<=0.33) {
					l.getLocation().getWorld().playSound(l.getLocation(), Sound.WOLF_HOWL, 0.2f, 0.9f);
					Entity entity = l.getWorld().spawnEntity(l.getLocation().add(Math.random(),0,Math.random()), EntityType.WOLF);
					LivingEntity l2 = (LivingEntity)entity;
					Creature c = (Creature)l2;
					l.setCustomName(ChatColor.RED+"Wolf Minion");
					l.setCustomNameVisible(true);
					if (e.getDamager() instanceof LivingEntity) {
						c.setTarget((LivingEntity)e.getDamager());
					}
					Wolf w = (Wolf)l2;
					w.setAngry(true);
					w.setBaby();
					//l.setLastDamageCause(new EntityDamageEvent(p, DamageCause.ENTITY_ATTACK, 0.01));
				}
			}
			if (l.getCustomName()!=null && l.getCustomName().contains(ChatColor.RED+"Viral Spider")) {
				if (e.getDamager() instanceof LivingEntity) {
					LivingEntity l2 = (LivingEntity)e.getDamager();
					int poisonlevel=-1;
					Collection<PotionEffect> effects = l2.getActivePotionEffects();
					for (PotionEffect pot : effects) {
						if (pot.getType().getName().equalsIgnoreCase("poison")) {
							poisonlevel = pot.getAmplifier();
							//Bukkit.getLogger().info("Poison level is "+poisonlevel);
							break;
						}
					}
					poisonlevel+=2;
					l2.addPotionEffect(new PotionEffect(PotionEffectType.POISON, poisonlevel*20+60, poisonlevel),true);
				}
				if (e.getDamager() instanceof Projectile) {
					Projectile proj = (Projectile)e.getDamager();
					if (proj.getShooter() instanceof LivingEntity) {
						LivingEntity l2 = (LivingEntity)proj.getShooter();
						int poisonlevel=-1;
						Collection<PotionEffect> effects = l2.getActivePotionEffects();
						for (PotionEffect pot : effects) {
							if (pot.getType()==PotionEffectType.POISON) {
								poisonlevel = pot.getAmplifier();
								break;
							}
						}
						poisonlevel+=2;
						l2.addPotionEffect(new PotionEffect(PotionEffectType.POISON, poisonlevel*20+60, poisonlevel),true);
					}
				}
			}
			if (l.getCustomName()!=null && l.getCustomName().contains(ChatColor.RED+"Counter Slime")) {
				if (e.getDamager() instanceof LivingEntity) {
					LivingEntity l2 = (LivingEntity)e.getDamager();
					double dmg = this.plugin.DMGCALC.getDamage(l2.getEquipment().getHelmet(), l2.getEquipment().getChestplate(), l2.getEquipment().getLeggings(), l2.getEquipment().getBoots(), e.getDamage()*2, e.getCause(), false);
					if (l2.getHealth()-dmg*2>0) {
						l2.setHealth(l2.getHealth()-dmg*2);
						if (l2 instanceof Player) {
							Player p = (Player)l2;
							p.playSound(p.getLocation(), Sound.HURT_FLESH, 0.5f, 1.0f);
							DecimalFormat df = new DecimalFormat("#0.0");
							DecimalFormat df2 = new DecimalFormat("#0");
							if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify5")) {
								hitByPoweredMob=true;
								p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"Took "+df.format(dmg)+" damage from "+ChatColor.RED+"COUNTER SLIME"+ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+" (-"+df2.format(((dmg)/p.getMaxHealth())*100)+"%)");
							}
						}
					} else {
						if (l2 instanceof Player) {
							Player p = (Player)l2;
							p.setLastDamage(dmg);
							p.setLastDamageCause(new EntityDamageEvent(l, e.getCause().ENTITY_ATTACK, dmg));
							DecimalFormat df = new DecimalFormat("#0.0");
							DecimalFormat df2 = new DecimalFormat("#0");
							if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify5")) {
								hitByPoweredMob=true;
								p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"Took "+df.format(dmg)+" damage from "+ChatColor.RED+"COUNTER SLIME"+ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+" (-"+df2.format(((dmg)/p.getMaxHealth())*100)+"%)");
							}
						}
						l2.setHealth(0);
					}
				}
				if (e.getDamager() instanceof Projectile) {
					Projectile proj = (Projectile)e.getDamager();
					if (proj.getShooter() instanceof LivingEntity) {
						LivingEntity l2 = (LivingEntity)proj.getShooter();
						double dmg = this.plugin.DMGCALC.getDamage(l2.getEquipment().getHelmet(), l2.getEquipment().getChestplate(), l2.getEquipment().getLeggings(), l2.getEquipment().getBoots(), e.getDamage()*2, e.getCause(), false);
						if (l2.getHealth()-dmg>0) {
							l2.setHealth(l2.getHealth()-dmg);
							if (l2 instanceof Player) {
								Player p = (Player)l2;
								p.playSound(p.getLocation(), Sound.HURT_FLESH, 0.5f, 1.0f);
								DecimalFormat df = new DecimalFormat("#0.0");
								DecimalFormat df2 = new DecimalFormat("#0");
								if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify5")) {
									p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"Took "+df.format(dmg)+" damage from "+ChatColor.RED+"COUNTER SLIME"+ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+" (-"+df2.format(((dmg)/p.getMaxHealth())*100)+"%)");
								}
							}
						} else {
							if (l2 instanceof Player) {
								Player p = (Player)l2;
								p.setLastDamage(dmg);
								p.setLastDamageCause(new EntityDamageEvent(l, e.getCause().ENTITY_ATTACK, dmg));
							}
							l2.setHealth(0);
						}
					}
				}
			}
			if (e.getDamager().getType()==EntityType.FISHING_HOOK) {
				//See if any nearby players are casting lines.
				List<Entity> nearbyents = l.getNearbyEntities(20, 20, 20);
				List<Player> nearbyplayers = new ArrayList<Player>();
				for (int i=0;i<nearbyents.size();i++) {
					if (nearbyents.get(i) instanceof Player) {
						nearbyplayers.add((Player)(nearbyents.get(i)));
					}
				}
				for (int j=0;j<nearbyplayers.size();j++) {
					if (nearbyplayers.get(j).getItemInHand().getType()==Material.FISHING_ROD && this.plugin.hasJobBuff("Fisherman", nearbyplayers.get(j), Job.JOB40)) {
						nearbyplayers.get(j).getItemInHand().setDurability((short)0);
						e.setDamage(e.getDamage()+10);
						break;
					}
				}
			}
			if (l instanceof Player) {
				e.setDamage(e.getDamage()*1.45d);
				if (e.getDamager() instanceof Wither) {
					e.setDamage(e.getDamage()*3d);
					if (Math.random()<=0.75) {
						l.getWorld().spawnEntity(l.getLocation(), EntityType.CREEPER);
						l.getWorld().spawnEntity(l.getLocation(), EntityType.ZOMBIE);
					}
				}
			}
			if (e.getEntity() instanceof Wither) {
				if (l.getCustomName()!=null && l.getCustomName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE+"Mythical Wither")) {
					e.setDamage(e.getDamage()*0.015d);
					if (Math.random()<=0.45) {
						l.setHealth(l.getHealth()+10);
					}
				} else {
					e.setDamage(e.getDamage()*0.035d);
					if (Math.random()<=0.35) {
						l.setHealth(l.getHealth()+5);
					}
				}
				try {
					Iterator<PotionEffect> effects = l.getActivePotionEffects().iterator();
					//Figure out potion effects when player joins.
					while (effects.hasNext()) {
						PotionEffect nexteffect = effects.next();
						if (nexteffect.getType().getName().compareTo(PotionEffectType.NIGHT_VISION.getName())==0 && l.getHealth()<l.getMaxHealth()/2) {
							l.removePotionEffect(PotionEffectType.NIGHT_VISION);
							l.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,999999,2));
							LivingEntity zombie = (LivingEntity)Bukkit.getWorld("world").spawnEntity(e.getEntity().getLocation(),EntityType.ZOMBIE);
							LivingEntity enderdragon = (LivingEntity)Bukkit.getWorld("world").spawnEntity(e.getEntity().getLocation(),EntityType.ENDER_DRAGON);
							//Bukkit.getWorld("world").spawn(e.getEntity().getLocation(), enderdragon.getClass());
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
							zombie.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,999999,0));
							zombie.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,999999,0));
							zombie.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,999999,0));
							zombie.setTicksLived(1);
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
			}
			if (e.getEntity().getType()==EntityType.ZOMBIE) {
				Zombie z = (Zombie)e.getEntity();
				if ((z.getCustomName()==null || (
						z.getCustomName()!=null && !z.getCustomName().contains(ChatColor.DARK_PURPLE+"") && ((!z.getCustomName().contains(ChatColor.DARK_PURPLE+"") && z.getCustomName().contains("II")) ||
								z.getCustomName().contains("Ninja")))) && z.getHealth()>65) {
					//If it's a normal zombie with too much HP, something's wrong. Lower it.
					z.setHealth(z.getHealth()/2);
				}
			}
			if (e.getDamager() instanceof Projectile) {
				Projectile pp = (Projectile)(e.getDamager());			  
				if (pp.getShooter() instanceof Player && l instanceof Wither) {
					Player p = (Player)(pp.getShooter());
					if (Math.random()<=0.75) {
						l.getWorld().spawnEntity(pp.getLocation(), EntityType.CREEPER);
						l.getWorld().spawnEntity(l.getLocation(), EntityType.ZOMBIE);
					}
				}
			}
			if (l.getCustomName()!=null && l.getCustomName().contains(ChatColor.DARK_PURPLE+"")) {
				//Bukkit.getPlayer("sigonasr2").sendMessage("Entered Boss Entity hit loop.");
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
					enderdragon.setHealth(Warning(l.getHealth()/l.getMaxHealth()*200,7));
					enderdragon.remove();
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
								this.plugin.last_lightning_random_time=Main.SERVER_TICK_TIME+60;
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
									l.setMaxHealth(Warning(l.getMaxHealth()+this.plugin.getJobTotalLvs(g)+50,8));
									l.setHealth(Warning(l.getMaxHealth(),9));
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
								if (l.getLocation().add(i,j,k).getY()>0 && l.getLocation().add(i,j,k).getY()<50) {
									if (Bukkit.getWorld("world").getBlockAt(l.getLocation().add(i,j,k)).getType()==Material.COMMAND) {
										Bukkit.getWorld("world").getBlockAt(l.getLocation().add(i,j,k)).setType(Material.COBBLESTONE);
									}
									if (Bukkit.getWorld("world").getBlockAt(l.getLocation().add(i,j,k)).getType()==Material.TORCH || Bukkit.getWorld("world").getBlockAt(l.getLocation().add(i,j,k)).getType()==Material.GLOWSTONE) {
										Bukkit.getWorld("world").getBlockAt(l.getLocation().add(i,j,k)).breakNaturally();
									}
								}
							}
						}
					}
				} else {
					for (int i=-20;i<21;i++) {
						for (int j=0;j<10;j++) {
							for (int k=-20;k<21;k++) {
								if (l.getLocation().add(i,j,k).getY()>0 && l.getLocation().add(i,j,k).getY()<50) {
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
		}
		////Bukkit.getLogger().info("Made it through 1.");
		/*if (e.getDamager().getType()==EntityType.CREEPER) {
		  e.setDamage(e.getDamage()/2.0d);
	  }*/
		if (e.getEntity().getType()==EntityType.PLAYER) {
			final Player p = (Player)e.getEntity();
			if (e.getDamager() instanceof Silverfish && p.getNoDamageTicks()<p.getMaximumNoDamageTicks()/2.0f) {
				final LivingEntity ss = (LivingEntity)e.getDamager();
				e.setDamage(e.getDamage()*3);
				p.setNoDamageTicks((int)(p.getNoDamageTicks()/8));
				Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					@Override
					public void run() {
						ss.remove();
					}
				},10);
			}
			if (e.getDamager() instanceof Wolf) {
				LivingEntity l = (LivingEntity)e.getDamager();
				if (l.getCustomName()!=null && l.getCustomName().contains(ChatColor.RED+"Hound Caller")) {
					//e.setDamage(e.getDamage()*2.5);
					if (Math.random()<=0.2) {
						l.getLocation().getWorld().playSound(l.getLocation(), Sound.WOLF_HOWL, 0.2f, 0.9f);
						Entity entity = l.getWorld().spawnEntity(l.getLocation().add(Math.random(),0,Math.random()), EntityType.WOLF);
						LivingEntity l2 = (LivingEntity)entity;
						Creature c = (Creature)l2;
						l.setCustomName(ChatColor.RED+"Wolf Minion");
						l.setCustomNameVisible(true);
						if (e.getDamager() instanceof LivingEntity) {
							c.setTarget((LivingEntity)e.getDamager());
						}
						Wolf w = (Wolf)l2;
						w.setAngry(true);
						w.setBaby();
						//l.setLastDamageCause(new EntityDamageEvent(p, DamageCause.ENTITY_ATTACK, 0.01));
					}
				}
			}
			if (e.getDamager() instanceof Projectile) {
				if (((Projectile)e.getDamager()).getShooter() instanceof LivingEntity) {
					LivingEntity l = (LivingEntity)(((Projectile)e.getDamager()).getShooter());
					if (l.getCustomName()!=null && l.getCustomName().contains(ChatColor.RED+"Silencer")) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 64));
					}
				}
			}
			if (p.getNoDamageTicks()<p.getMaximumNoDamageTicks()/2.0f && this.plugin.hasJobBuff("Hunter", p, Job.JOB30A)) {
				this.plugin.getPlayerData(p).blockstack+=1;
			}
			List<Entity> nearby = p.getNearbyEntities(10, 10, 10);
			for (int i=0;i<nearby.size();i++) {
				if (nearby.get(i).getType()==EntityType.PLAYER && this.plugin.PlayerinJob((Player)nearby.get(i), "Support") && this.plugin.getJobLv("Support", (Player)nearby.get(i))>=20) {
					//A support with the Lv20 buff is detected. If health is less than 8, take half damage.
					if (p.getHealth()<=8) {
						e.setDamage(e.getDamage()/2.0d);
					}
				}
			}
			if (e.getDamager() instanceof LivingEntity) {
				final double player_starthp = p.getHealth();
				final LivingEntity l = (LivingEntity)e.getDamager();
				if (p.getNoDamageTicks()<p.getMaximumNoDamageTicks()/2.0f && this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify5")) {
					final Main plug = this.plugin;
					if (!hitByPoweredMob) {
						Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
							@Override
							public void run() {
								DecimalFormat df = new DecimalFormat("#0.0");
								DecimalFormat df2 = new DecimalFormat("#0");
								if (l.getCustomName()!=null) {
									p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"Took "+df.format(player_starthp-p.getHealth())+" damage from "+l.getCustomName()+ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+" (-"+df2.format(((player_starthp-p.getHealth())/p.getMaxHealth())*100)+"%)");
								} else {
									p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"Took "+df.format(player_starthp-p.getHealth())+" damage from "+ChatColor.WHITE+l.getType()+ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+" (-"+df2.format(((player_starthp-p.getHealth())/p.getMaxHealth())*100)+"%)");
								}
								if (plugin.PlayerinJob(p, "Explorer")) {
									if (plugin.getJobLv("Explorer", p)>=10) {
										//Check to see if our "fatal s	urvivor" effect is available.
										boolean survivor=false;
										for (int i=0;i<plugin.explorers.size();i++) {
											if (plugin.explorers.get(i).event==0 && plugin.explorers.get(i).name.compareTo(p.getName().toLowerCase())==0) {
												survivor=true;
												break;
											}
										}
										PersistentExplorerList eve = new PersistentExplorerList(p.getName().toLowerCase());
										eve.event=1;
										eve.data=p.getExp();
										eve.data2=p.getLevel();
										eve.expiretime=Main.SERVER_TICK_TIME+1200;
										plugin.explorers.add(eve);
										if (!survivor) {
											if (p.getHealth()<=0) {
												FatalSurvivor(p);
											}
										}
									}
								}
							}
	
						},1);
					}
				}
			}
			int knockbacklevels = 0;
			if (p.getInventory().getBoots()!=null && this.plugin.hasBonusEnchantment(p.getInventory().getBoots(), this.plugin.ENCHANT_STURDY)) {knockbacklevels+=this.plugin.getBonusEnchantmentLevel(p.getInventory().getBoots(), this.plugin.ENCHANT_STURDY);}
			if (p.getInventory().getChestplate()!=null && this.plugin.hasBonusEnchantment(p.getInventory().getChestplate(), this.plugin.ENCHANT_STURDY)) {knockbacklevels+=this.plugin.getBonusEnchantmentLevel(p.getInventory().getChestplate(), this.plugin.ENCHANT_STURDY);}
			if (p.getInventory().getLeggings()!=null && this.plugin.hasBonusEnchantment(p.getInventory().getLeggings(), this.plugin.ENCHANT_STURDY)) {knockbacklevels+=this.plugin.getBonusEnchantmentLevel(p.getInventory().getLeggings(), this.plugin.ENCHANT_STURDY);}
			if (p.getInventory().getHelmet()!=null && this.plugin.hasBonusEnchantment(p.getInventory().getHelmet(), this.plugin.ENCHANT_STURDY)) {knockbacklevels+=this.plugin.getBonusEnchantmentLevel(p.getInventory().getHelmet(), this.plugin.ENCHANT_STURDY);}
			if (p.isBlocking()) {
				knockbacklevels+=8;
				e.setDamage(e.getDamage()/2.0d);}
			if (knockbacklevels>0) {
				final Player p2 = p;
				Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					@Override
					public void run() {
						//Multiplying by a number lower than 1 will reduce knockback
						//Multiplying by a number greater than 1 will increase knockback
						Vector knockback = p2.getVelocity().multiply(0.4f);
						p2.setVelocity(knockback);
					}
				}, 1L);
			}
			p.getScoreboard().getTeam(p.getName().toLowerCase()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth(),p.getFoodLevel()));
			int slot=0;
			for (int i=0;i<this.plugin.SPEED_CONTROL.size();i++) {
				if (this.plugin.SPEED_CONTROL.get(i).p.getName().equals(p.getName().toLowerCase())) {
					slot=i;
					break;
				}
			}
			//Found the slot. Check armor values.
			double block_chance=0,speed_boost_chance=0;
			if (this.plugin.hasJobBuff("Hunter", p, Job.JOB30A)) {
				block_chance+=(double)10*this.plugin.getPlayerData(p).blockstack;
				if (Math.random()*100<=block_chance) {
					blocked_hunter_buff=true;
				}
			}
			//Bukkit.getLogger().info("Made it through 3.");
			//This is the player getting hit.
			for (int i=0;i<p.getEquipment().getArmorContents().length;i++) {
				if (p.getEquipment().getArmorContents()[i]!=null && !this.plugin.isBroken(p.getEquipment().getArmorContents()[i]) && p.getEquipment().getArmorContents()[i].getItemMeta()!=null && p.getEquipment().getArmorContents()[i].getItemMeta().getLore()!=null) {
					for (int j=0;j<p.getEquipment().getArmorContents()[i].getItemMeta().getLore().size();j++) {
						if (this.plugin.containsEnchantment(p.getEquipment().getArmorContents()[i].getItemMeta().getLore().get(j), "Block Chance")) {
							Bukkit.getLogger().info("Block chance check is "+this.plugin.getEnchantmentNumb(p.getEquipment().getArmorContents()[i].getItemMeta().getLore().get(j)));
							if (block_chance==0) {
								block_chance+=this.plugin.getEnchantmentNumb(p.getEquipment().getArmorContents()[i].getItemMeta().getLore().get(j));
							} else {
								block_chance+=(100-block_chance)*(this.plugin.getEnchantmentNumb(p.getEquipment().getArmorContents()[i].getItemMeta().getLore().get(j))/100.0d);
							}
						}
						if (this.plugin.containsEnchantment(p.getEquipment().getArmorContents()[i].getItemMeta().getLore().get(j), "Damage Reduction")) {
							e.setDamage(e.getDamage()*(1-(this.plugin.getEnchantmentNumb(p.getEquipment().getArmorContents()[i].getItemMeta().getLore().get(j))/100.0d)));
						}
					}
				}
			}
			if (Math.random()<=speed_boost_chance/100.0d) {
				int data=-1;
				for (int i=0;i<this.plugin.SPEED_CONTROL.size();i++) {
					if (this.plugin.SPEED_CONTROL.get(i).p.getName().equalsIgnoreCase(p.getName().toLowerCase())) {
						data=i;
						break;
					}
				}
				try {
					Iterator<PotionEffect> effects = p.getActivePotionEffects().iterator();
					//Figure out potion effects when player joins.
					while (effects.hasNext()) {
						PotionEffect nexteffect = effects.next();
						if (nexteffect.getType().getName().compareTo(PotionEffectType.SPEED.getName())==0) {
							if (nexteffect.getAmplifier()<2) {
								p.removePotionEffect(PotionEffectType.SPEED);
								if (data!=-1) {
									this.plugin.SPEED_CONTROL.get(data).potion_spdlv=0;
								}
							}
						}
						effects.remove();
					}

				} catch (ConcurrentModificationException ex_e) {
					Bukkit.getLogger().warning("Potion Effect Collection not accessible while finalizing player speed.");
				}
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,200,2));
			}
			if (Math.random()<=(block_chance/100.0d)/2) {
				e.setDamage(0);
				//Choose a random set to mark off.
				blocked_attack=true;
				//Reduce all armor by one as if it was a normal hit.
				if (p.getInventory().getHelmet()!=null && this.plugin.hasBonusEnchantment(p.getInventory().getHelmet(), Main.ENCHANT_BLOCK_CHANCE)) {p.getInventory().getHelmet().setDurability((short)(p.getInventory().getHelmet().getDurability()+3));}
				if (p.getInventory().getChestplate()!=null && this.plugin.hasBonusEnchantment(p.getInventory().getChestplate(), Main.ENCHANT_BLOCK_CHANCE)) {p.getInventory().getChestplate().setDurability((short)(p.getInventory().getChestplate().getDurability()+3));}
				if (p.getInventory().getLeggings()!=null && this.plugin.hasBonusEnchantment(p.getInventory().getLeggings(), Main.ENCHANT_BLOCK_CHANCE)) {p.getInventory().getLeggings().setDurability((short)(p.getInventory().getLeggings().getDurability()+3));}
				if (p.getInventory().getBoots()!=null && this.plugin.hasBonusEnchantment(p.getInventory().getBoots(), Main.ENCHANT_BLOCK_CHANCE)) {p.getInventory().getBoots().setDurability((short)(p.getInventory().getBoots().getDurability()+3));}
				/*
				if (blocks.size()>0) {
					int armor = blocks.get((int)(Math.random()*blocks.size()));
					switch (armor) {
					case 0:{
						p.getInventory().getHelmet().setDurability((short)(p.getInventory().getHelmet().getDurability()+1));
					}break;
					case 1:{
						p.getInventory().getChestplate().setDurability((short)(p.getInventory().getChestplate().getDurability()+1));
					}break;
					case 2:{
						p.getInventory().getLeggings().setDurability((short)(p.getInventory().getLeggings().getDurability()+1));
					}break;
					case 3:{
						p.getInventory().getBoots().setDurability((short)(p.getInventory().getBoots().getDurability()+1));
					}break;
					}
				}*/
				p.playSound(p.getLocation(), Sound.ANVIL_LAND, 0.1f, 3.6f);
				e.setDamage(0);
				e.setCancelled(true);
				return;
			}
			//Bukkit.getLogger().info("Made it through 4.");
			//p.updateInventory();
			if (this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat3")>0) {
				double olddmg=e.getDamage();
				e.setDamage(e.getDamage()*(((100-this.plugin.getStatBonus(2, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat3")/4))/100.0d)));
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
			p.getScoreboard().getTeam(p.getName().toLowerCase()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth(),p.getFoodLevel()));
			double throughdmg=0;
			double maxdmg=0;
			if (enemy.getCustomName()!=null && (enemy.getCustomName().compareTo(ChatColor.YELLOW+"Charge Zombie")==0 || enemy.getCustomName().compareTo(ChatColor.DARK_PURPLE+"Charge Zombie III")==0)) {
				throughdmg=(this.plugin.DMGCALC.getDamage(new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), e.getDamage(), DamageCause.ENTITY_ATTACK, false))/2;
				if (throughdmg>e.getDamage()/2) {
					if (p.getHealth()-throughdmg>0) {
						p.setHealth(p.getHealth()-throughdmg);
						if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify5") && e.getDamage()!=0) {
							//p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"You were hurt for "+Math.round(throughdmg*10)/10+" damage from "+convertToItemName(e.getCause().name())+".");
						}
					} else {
						e.setDamage(0);
						final Player p2 = p;
						if (plugin.PlayerinJob(p, "Explorer")) {
							if (plugin.getJobLv("Explorer", p)>=10) {
								//Check to see if our "fatal s	urvivor" effect is available.
								boolean survivor=false;
								for (int i=0;i<plugin.explorers.size();i++) {
									if (plugin.explorers.get(i).event==0 && plugin.explorers.get(i).name.compareTo(p.getName().toLowerCase())==0) {
										survivor=true;
										break;
									}
								}
								PersistentExplorerList eve = new PersistentExplorerList(p.getName().toLowerCase());
								eve.event=1;
								eve.data=p.getExp();
								eve.data2=p.getLevel();
								eve.expiretime=Main.SERVER_TICK_TIME+1200;
								plugin.explorers.add(eve);
								if (!survivor) {
									if (p2.getHealth()<=0) {
										FatalSurvivor(p2);
									}
								}
							}
						}
					}
				} else {
					if (p.getHealth()-e.getDamage()/2>0) {
						p.setHealth(p.getHealth()-e.getDamage()/2);
						if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify5") && e.getDamage()!=0) {
							//p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"You were hurt for "+Math.round(e.getDamage()/2*10)/10+" damage from "+convertToItemName(e.getCause().name())+".");
						}
					} else {
						e.setDamage(0);
						final Player p2 = p;
						if (plugin.PlayerinJob(p, "Explorer")) {
							if (plugin.getJobLv("Explorer", p)>=10) {
								//Check to see if our "fatal s	urvivor" effect is available.
								boolean survivor=false;
								for (int i=0;i<plugin.explorers.size();i++) {
									if (plugin.explorers.get(i).event==0 && plugin.explorers.get(i).name.compareTo(p.getName().toLowerCase())==0) {
										survivor=true;
										break;
									}
								}
								PersistentExplorerList eve = new PersistentExplorerList(p.getName().toLowerCase());
								eve.event=1;
								eve.data=p.getExp();
								eve.data2=p.getLevel();
								eve.expiretime=Main.SERVER_TICK_TIME+1200;
								plugin.explorers.add(eve);
								if (!survivor) {
									Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
										@Override
										public void run() {
											if (p2.getHealth()<=0) {
												FatalSurvivor(p2);
											}
										}
									},1);
								}
							}
						}
					}
				}
				e.setDamage(0);
				if (!enemy.isDead()) {
					for (int k=-1;k<2;k++) {
						for (int j=-1;j<2;j++) {
							Location checkloc = new Location(enemy.getLocation().getWorld(),enemy.getLocation().getX()+k,enemy.getLocation().getY()+1,enemy.getLocation().getZ()+j);
							Block bl = Bukkit.getWorld("world").getBlockAt(checkloc);
							if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER && naturalBlock(bl.getType())) {
								bl.breakNaturally();
							}
							bl = Bukkit.getWorld("world").getBlockAt(checkloc);
							checkloc = new Location(enemy.getLocation().getWorld(),enemy.getLocation().getX()+k,enemy.getLocation().getY()+2,enemy.getLocation().getZ()+j);
							if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER && naturalBlock(bl.getType())) {
								bl.breakNaturally();
							}
							bl = Bukkit.getWorld("world").getBlockAt(checkloc);
							checkloc = new Location(enemy.getLocation().getWorld(),enemy.getLocation().getX()+k,enemy.getLocation().getY(),enemy.getLocation().getZ()+j);
							if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER && naturalBlock(bl.getType())) {
								bl.breakNaturally();
							}
						}
					}
				}
			} else
				if (enemy.getCustomName()!=null && (enemy.getCustomName().compareTo(ChatColor.GOLD+"Charge Zombie II")==0)) {
					throughdmg=(this.plugin.DMGCALC.getDamage(new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), e.getDamage(), DamageCause.ENTITY_ATTACK, false))/1.25d;
					if (throughdmg>e.getDamage()) {
						if (p.getHealth()-throughdmg>0) {
							p.setHealth(p.getHealth()-throughdmg);
							if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify5") && e.getDamage()!=0) {
								//p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"You were hurt for "+Math.round(throughdmg*10)/10+" damage from "+convertToItemName(e.getCause().name())+".");
							}
						} else {
							e.setDamage(0);
							final Player p2 = p;
							if (plugin.PlayerinJob(p, "Explorer")) {
								if (plugin.getJobLv("Explorer", p)>=10) {
									//Check to see if our "fatal s	urvivor" effect is available.
									boolean survivor=false;
									for (int i=0;i<plugin.explorers.size();i++) {
										if (plugin.explorers.get(i).event==0 && plugin.explorers.get(i).name.compareTo(p.getName().toLowerCase())==0) {
											survivor=true;
											break;
										}
									}
									PersistentExplorerList eve = new PersistentExplorerList(p.getName().toLowerCase());
									eve.event=1;
									eve.data=p.getExp();
									eve.data2=p.getLevel();
									eve.expiretime=Main.SERVER_TICK_TIME+1200;
									plugin.explorers.add(eve);
									if (!survivor) {
										Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
											@Override
											public void run() {
												if (p2.getHealth()<=0) {
													FatalSurvivor(p2);
												}
											}
										},1);
									}
								}
							}
						}
					} else {
						if (p.getHealth()-e.getDamage()>0) {
							p.setHealth(p.getHealth()-e.getDamage());
							if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify5") && e.getDamage()!=0) {
								//p.sendMessage(ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+"You were hurt for "+Math.round(e.getDamage()*10)/10+" damage from "+convertToItemName(e.getCause().name())+".");
							}
						} else {
							e.setDamage(0);
							final Player p2 = p;
							if (plugin.PlayerinJob(p, "Explorer")) {
								if (plugin.getJobLv("Explorer", p)>=10) {
									//Check to see if our "fatal s	urvivor" effect is available.
									boolean survivor=false;
									for (int i=0;i<plugin.explorers.size();i++) {
										if (plugin.explorers.get(i).event==0 && plugin.explorers.get(i).name.compareTo(p.getName().toLowerCase())==0) {
											survivor=true;
											break;
										}
									}
									PersistentExplorerList eve = new PersistentExplorerList(p.getName().toLowerCase());
									eve.event=1;
									eve.data=p.getExp();
									eve.data2=p.getLevel();
									eve.expiretime=Main.SERVER_TICK_TIME+1200;
									plugin.explorers.add(eve);
									if (!survivor) {
										Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
											@Override
											public void run() {
												if (p2.getHealth()<=0) {
													FatalSurvivor(p2);
												}
											}
										},1);
									}
								}
							}
						}
					}
					if (!enemy.isDead()) {
						for (int k=-2;k<3;k++) {
							for (int j=-2;j<3;j++) {
								Location checkloc = new Location(enemy.getLocation().getWorld(),enemy.getLocation().getX()+k,enemy.getLocation().getY()+1,enemy.getLocation().getZ()+j);
								Block bl = Bukkit.getWorld("world").getBlockAt(checkloc);
								if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER && naturalBlock(bl.getType())) {
									bl.breakNaturally();
								}
								bl = Bukkit.getWorld("world").getBlockAt(checkloc);
								checkloc = new Location(enemy.getLocation().getWorld(),enemy.getLocation().getX()+k,enemy.getLocation().getY()+2,enemy.getLocation().getZ()+j);
								if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER && naturalBlock(bl.getType())) {
									bl.breakNaturally();
								}
								bl = Bukkit.getWorld("world").getBlockAt(checkloc);
								checkloc = new Location(enemy.getLocation().getWorld(),enemy.getLocation().getX()+k,enemy.getLocation().getY(),enemy.getLocation().getZ()+j);
								if (bl.getType()!=Material.BEDROCK && bl.getType()!=Material.ENDER_PORTAL_FRAME && bl.getType()!=Material.ENDER_PORTAL && bl.getType()!=Material.MOB_SPAWNER && naturalBlock(bl.getType())) {
									bl.breakNaturally();
								}
							}
						}
					}
					e.setDamage(0);
				} else
					if (enemy.getCustomName()!=null && (enemy.getCustomName().compareTo(ChatColor.GRAY+"Zombie Ninja")==0)) {
						enemy.removePotionEffect(PotionEffectType.INVISIBILITY);
						this.plugin.ninjavisible_list.add(new InvisibilityData(enemy.getUniqueId(), Main.SERVER_TICK_TIME+10));
					}
		}
		//Bukkit.getLogger().info("Made it through 7.");
		if (e.getEntity() instanceof LivingEntity) {
			final LivingEntity f = (LivingEntity) e.getEntity();
			final double enemy_starthp = f.getHealth();
			if (e.getDamager().getType()==EntityType.PLAYER || (e.getDamager() instanceof Projectile)) {
				if (e.getEntity() instanceof LivingEntity) {
					LivingEntity enemy = (LivingEntity)e.getEntity();
					if (enemy.getCustomName()!=null) {
						//Bukkit.getPlayer("sigonasr2").sendMessage(enemy.getCustomName()+" Health: "+enemy.getHealth()+"/"+enemy.getMaxHealth());
					} else {
						//Bukkit.getPlayer("sigonasr2").sendMessage(enemy.getType()+" Health: "+enemy.getHealth()+"/"+enemy.getMaxHealth());
					}
				}
				if (e.getDamager().getType()==EntityType.PLAYER) {
					if (e.getEntity() instanceof LivingEntity) {
						LivingEntity enemy = (LivingEntity)e.getEntity();
						if (enemy.getCustomName()!=null && (enemy.getCustomName().compareTo(ChatColor.GRAY+"Zombie Ninja")==0)) {
							boolean found=false;
							for (int i=0;i<this.plugin.ninjavisible_list.size();i++) {
								if (this.plugin.ninjavisible_list.get(i).val.equals(enemy.getUniqueId())) {
									found=true;
									enemy.removePotionEffect(PotionEffectType.INVISIBILITY);
									this.plugin.ninjavisible_list.get(i).resettime=Main.SERVER_TICK_TIME+20;
									break;
								}
							}
							if (!found) {
								enemy.removePotionEffect(PotionEffectType.INVISIBILITY);
								this.plugin.ninjavisible_list.add(new InvisibilityData(enemy.getUniqueId(), Main.SERVER_TICK_TIME+10));
							}
						}
					}
					final Player p = (Player) e.getDamager();
					if (e.getEntity() instanceof Monster) {
						Monster m = (Monster)e.getEntity();

						List<MobHead> playerheads = this.plugin.getMobHeads(p);
						int creeperheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CREEPER), playerheads);
						int creeperrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CREEPER,true), playerheads);
						int creeperpoweredheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CREEPER,false,true), playerheads);
						int creeperpoweredrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CREEPER,true,true), playerheads);
						int aoedmg = 0;
						
						aoedmg+=creeperheads*5;
						aoedmg+=creeperrareheads*20;
						aoedmg+=creeperpoweredheads*5;
						aoedmg+=creeperpoweredrareheads*30;
						

						int spiderheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SPIDER), playerheads);
						int spiderrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SPIDER,true), playerheads);
						int spiderpoweredheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SPIDER,false,true), playerheads);
						int spiderpoweredrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SPIDER,true,true), playerheads);
						int slowdownpct = 0;
						
						slowdownpct+=spiderheads*5;
						slowdownpct+=spiderrareheads*15;
						slowdownpct+=spiderpoweredheads*5;
						slowdownpct+=spiderpoweredrareheads*30;
						
						spiderrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SPIDER,true,MobHeadRareType.RARE_TYPE_B), playerheads);
						int poisondur = 0; //Amount of poison duration (seconds) to add to the current poison amount.
						
						poisondur+=spiderrareheads*2;
						poisondur+=spiderpoweredheads*1;
						poisondur+=spiderpoweredrareheads*5;

						int endermanheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ENDERMAN), playerheads);
						int endermanrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ENDERMAN,true), playerheads);
						int endermanpoweredheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ENDERMAN,false,true), playerheads);
						int endermanpoweredrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ENDERMAN,true,true), playerheads);
						int critchance = 0;
						
						critchance+=endermanheads;
						critchance+=endermanrareheads*5;
						critchance+=endermanpoweredheads;
						critchance+=endermanpoweredrareheads*10;

						int cavespiderheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CAVE_SPIDER), playerheads);
						int cavespiderrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CAVE_SPIDER,true), playerheads);
						int cavespiderpoweredheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CAVE_SPIDER,false,true), playerheads);
						int cavespiderpoweredrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CAVE_SPIDER,true,true), playerheads);
						
						poisondur+=cavespiderheads;
						poisondur+=cavespiderrareheads*3;
						poisondur+=cavespiderpoweredheads*2;
						poisondur+=cavespiderpoweredrareheads*5;

						cavespiderrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CAVE_SPIDER,true,MobHeadRareType.RARE_TYPE_B), playerheads);
						int snarechance=0;
						
						snarechance+=cavespiderrareheads*5;
						snarechance+=cavespiderpoweredheads*3;
						snarechance+=cavespiderpoweredrareheads*8;
						
						int blazeheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.BLAZE), playerheads);
						int blazerareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.BLAZE,true), playerheads);
						int blazepoweredheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.BLAZE,false,true), playerheads);
						int blazepoweredrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.BLAZE,true,true), playerheads);
						int ignitedur = 0;
						ignitedur+=blazeheads;
						ignitedur+=blazerareheads*3;
						ignitedur+=blazepoweredheads;
						ignitedur+=blazepoweredrareheads*5;
						
						blazerareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.BLAZE,true,MobHeadRareType.RARE_TYPE_B), playerheads);
						int airbornechance=0;

						airbornechance+=blazerareheads*3;
						airbornechance+=blazepoweredheads;
						airbornechance+=blazepoweredrareheads*10;
								
						if (Math.random()*100<=critchance) {
							e.setDamage(e.getDamage()*2);
						}		
						if (Math.random()*100<=snarechance) {
							m.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,100,7,true));
						}		
						if (Math.random()*100<=airbornechance) {
							//m.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,100,7,true));
							
							final LivingEntity l = (LivingEntity)e.getEntity();
							
							Location airborne_loc = l.getLocation();
							//Check upwards. Stop if we hit a solid block.
							int starty=l.getLocation().getBlockY();
							int checky=l.getLocation().getBlockY();
							/*16 is max height that a mob will be set to.*/
							while (checky-starty<19 && l.getWorld().getBlockAt(l.getLocation().getBlockX(),checky,l.getLocation().getBlockZ()).getType()==Material.AIR) {
								checky++;
							}
							
							if (checky-starty>3) {
								checky-=3;
							} else {
								checky=starty;
							}
							
							final Location teleport_to = new Location(l.getWorld(),l.getLocation().getBlockX(),checky,l.getLocation().getBlockZ());
							
							Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
								@Override
								public void run() {
									l.teleport(teleport_to);
								}
							},1);
						}
						
						if (ignitedur>0) {
							m.setFireTicks(m.getFireTicks()+(ignitedur*20));
						}
						
						m.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,60,slowdownpct/15,true));
						
						int poisonduration=0;
						//First see if the mob is already a poisoned mob.
						boolean found=false;
						for (int i=0;i<this.plugin.mob_list.size();i++) {
							if (this.plugin.mob_list.get(i).id.compareTo(m.getUniqueId())==0) {
								//We found it. Add onto current poison duration.
								this.plugin.mob_list.get(i).addPoison(poisondur*20);
								found=true;
								break;
							}
						}
						if (!found) {
							//We didn't find it, so add a new entry to the poison list.
							MobManager newm = new MobManager(m.getUniqueId());
							newm.addPoison(poisondur*20);
							this.plugin.mob_list.add(newm);
						}
						
						List<Entity> nearby_mobs = m.getNearbyEntities(2, 2, 2);
						for (int i=0;i<nearby_mobs.size();i++) {
							if (!(nearby_mobs.get(i) instanceof Monster)) {
								nearby_mobs.remove(i);
								i--;
							}
						}
						if (aoedmg>0) {
							for (int i=0;i<nearby_mobs.size();i++) {
								if (!nearby_mobs.get(i).getUniqueId().equals(m)) {
									LivingEntity m2 = (LivingEntity)nearby_mobs.get(i);
									m2.damage(e.getDamage()*(aoedmg/100.0d));
								}
							}
						}
						/*if (m.hasPotionEffect(PotionEffectType.SLOW) && Main.SERVER_TICK_TIME-this.plugin.getPlayerData(p).lastsneaktime<=60) {
							m.removePotionEffect(PotionEffectType.SLOW);
						}*/
						int witherskeletonheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.WITHER_SKELETON), playerheads);
						int witherskeletonrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.WITHER_SKELETON,true), playerheads);
						int witherskeletonpoweredheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.WITHER_SKELETON,false,true), playerheads);
						int witherskeletonpoweredrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.WITHER_SKELETON,true,true), playerheads);
						int witherduration = 0, witheramplifier = 0;
						try {
							Iterator<PotionEffect> effects = m.getActivePotionEffects().iterator();
							//Figure out potion effects when player joins.
							while (effects.hasNext()) {
								PotionEffect nexteffect = effects.next();
								//Bukkit.getLogger().info("Effect Type is "+nexteffect.getType().getName()+", amplifier is "+nexteffect.getAmplifier()+", duration is "+nexteffect.getDuration());
								if (witherskeletonheads+witherskeletonrareheads+witherskeletonpoweredheads+witherskeletonpoweredrareheads>0 && nexteffect.getType().getName().compareTo(PotionEffectType.WITHER.getName())==0) {
									witherduration=nexteffect.getDuration();
									witheramplifier=nexteffect.getAmplifier();
								}
								if (nexteffect.getType().getName().compareTo(PotionEffectType.SLOW.getName())==0 && nexteffect.getAmplifier()==6 && nexteffect.getDuration()<=60) {
									m.removePotionEffect(PotionEffectType.SLOW);
									//Bukkit.getLogger().info("Removed slow.");
									//p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, nexteffect.getAmplifier()+1, true));
									break;
								}
								/*if (nexteffect.getType().getName().compareTo(PotionEffectType.JUMP.getName())==0) {
									p.removePotionEffect(PotionEffectType.JUMP);
									p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 360000, nexteffect.getAmplifier()+2, true));
								}*/
								effects.remove();
							}
						} catch (ConcurrentModificationException ex_e) {
							Bukkit.getLogger().warning("Potion Effect Collection not accessible while trying to remove slow debuff.");
						}
						if (witherskeletonpoweredrareheads>0) {
							if (witherduration==0) {witherduration=400;}
							Bukkit.getLogger().info("Adding potion effect WITHER with amplifier "+(witheramplifier+2*witherskeletonpoweredrareheads)+" + duration "+witherduration);
							m.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,witherduration,witheramplifier+2*witherskeletonpoweredrareheads),true);
						} else if (witherskeletonpoweredheads>0) {
							if (witherduration==0) {witherduration=100;}
							Bukkit.getLogger().info("Adding potion effect WITHER with amplifier "+(witheramplifier+1*witherskeletonpoweredrareheads)+" + duration "+witherduration);
							m.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,witherduration,witheramplifier+1*witherskeletonpoweredrareheads),true);
						} else if (witherskeletonrareheads>0) {
							Bukkit.getLogger().info("Adding potion effect WITHER with amplifier 2 + duration "+(witherduration+300*witherskeletonrareheads));
							m.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,witherduration+300*witherskeletonrareheads,2),true);
						} else if (witherskeletonheads>0) {
							Bukkit.getLogger().info("Adding potion effect WITHER with amplifier 0 + duration "+(witherduration+100*witherskeletonrareheads));
							m.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,witherduration+100*witherskeletonrareheads,0),true);
						}
					}
					if (this.plugin.hasJobBuff("Hunter", p, Job.JOB20) && p.getItemInHand().getType().name().toLowerCase().contains("sword")) {
						if (e.getEntity() instanceof Monster) {
							Monster m = (Monster)e.getEntity();
							m.addPotionEffect(new PotionEffect(PotionEffectType.POISON,120,1));
						}
					}
					this.plugin.getPlayerData(p).lastsneaktime=0;
					if (p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().getDisplayName()!=null && p.getItemInHand().getItemMeta().getDisplayName().contains(ChatColor.DARK_GRAY+"[BROKEN]")) {
						e.setDamage(0);
						e.setCancelled(true);
						return;
					}
					p.getScoreboard().getTeam(p.getName().toLowerCase()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth(),p.getFoodLevel()));
					//p.sendMessage("No Damage Ticks: "+f.getNoDamageTicks());
					ItemStack item = p.getItemInHand();
					double critical_chance=0,armor_pen=0,life_steal=0,attack_speed=0,dmg=0,armor_pen_dmg=0;
					if (this.plugin.hasJobBuff("Hunter", p, Job.JOB30B)) {
						armor_pen+=10;
					}
					if (item.getType()!=Material.BOW && item.getItemMeta()!=null && item.getItemMeta().getLore()!=null && item.getItemMeta().getLore().size()!=0) { //Make sure this isn't a ranged weapon.
						for (int i=0;i<item.getItemMeta().getLore().size();i++) {
							if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Critical Chance")) {
								if (critical_chance==0) {
									critical_chance+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
								} else {
									critical_chance+=(100-critical_chance)*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/100d);
								}
							}
							if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Armor Penetration")) {
								armor_pen+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
							}
							if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Life Steal")) {
								if (life_steal==0) {
									life_steal+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
								} else {
									life_steal+=(100-life_steal)*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/100d);
								}
							}
							if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Attack Speed")) {
								if (attack_speed==0) {
									attack_speed+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
								} else {
									attack_speed+=(100-attack_speed)*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/100d);
								}
							}
							if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Damage")) {
								dmg+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
							}
						}
					}
					List<MobHead> playerheads = this.plugin.getMobHeads(p);
					int zombieheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ZOMBIE), playerheads);
					int zombierareaheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ZOMBIE,true,MobHeadRareType.RARE_TYPE_A), playerheads);
					//int zombierarebheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ZOMBIE,true,MobHeadRareType.RARE_TYPE_B), playerheads);
					int zombiepoweredheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ZOMBIE,false,true), playerheads);
					int zombiepoweredrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ZOMBIE,true,true), playerheads);
					//Bukkit.getLogger().info("Head counts are "+zombieheads+", "+zombierareaheads+", "+zombiepoweredheads+", "+zombiepoweredrareheads);
					//Bukkit.getLogger().info("Life Steal is "+life_steal+"%");
					life_steal+=zombieheads;
					life_steal+=zombiepoweredheads;
					life_steal+=zombierareaheads*3;
					life_steal+=zombiepoweredrareheads*5;
					//Bukkit.getLogger().info("Life Steal is "+life_steal+"%");
					if (this.plugin.getPlayerData(p).furytime!=0) {
						attack_speed+=this.plugin.getPlayerData(p).furyamt;
					}
					if (critical_chance>0) {
						if (Math.random()<=critical_chance/100.0d) {
							e.setDamage(e.getDamage()*2);
						}
					}
					if (f.getNoDamageTicks()<f.getMaximumNoDamageTicks()/2.0f && life_steal>0) {
						if (p.getHealth()+e.getDamage()*(life_steal/100.0d)<p.getMaxHealth()) {
							p.setHealth(p.getHealth()+e.getDamage()*(life_steal/100.0d));
						} else {
							p.setHealth(p.getMaxHealth());
						}
					}
					if (attack_speed>0) {
						f.setNoDamageTicks(f.getNoDamageTicks()-(int)(f.getNoDamageTicks()*(attack_speed/100.0d/4)));
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
									this.plugin.supportmoblist.get(i).registeredtime=Main.SERVER_TICK_TIME+1200;
								}
							}
						}
					} else {
						for (int i=0;i<this.plugin.hitmoblist.size();i++) {
							if (this.plugin.hitmoblist.get(i).p.getName().compareTo(((Player)e.getDamager()).getName())==0) {
								if (!this.plugin.hitmoblist.get(i).id.contains(((Entity)f).getUniqueId())) {
									this.plugin.hitmoblist.get(i).id.add(((Entity)f).getUniqueId());
									//p.sendMessage("Added to list: "+((Entity)f).getUniqueId().toString());
									this.plugin.hitmoblist.get(i).registeredtime=Main.SERVER_TICK_TIME+1200;
								}
							}
						}
					}
					if (this.plugin.hasJobBuff("Hunter", (Player)e.getDamager(), Job.JOB40)) {
						//Deal 4 extra damage.
						e.setDamage(e.getDamage()+4);
					}
					if (this.plugin.hasJobBuff("Hunter", (Player)e.getDamager(), Job.JOB5)) {
						//Deal 4 extra damage.
						e.setDamage(e.getDamage()+4);
					}
					if (this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat7")>0) {
						e.setDamage(e.getDamage()+(this.plugin.getStatBonus(6, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat7"))/2));
					}
					//Add Armor penetration from the stat point, if any.
					if (this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat5")/4)>0) {
						armor_pen+=this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat5")/4);
					}
					if (f.getNoDamageTicks()<f.getMaximumNoDamageTicks()/2.0f && armor_pen>0) {
						double normaldmg=(this.plugin.DMGCALC.getDamage(f.getEquipment().getHelmet(), f.getEquipment().getChestplate(), f.getEquipment().getLeggings(), f.getEquipment().getBoots(), e.getDamage(), DamageCause.ENTITY_ATTACK, false));
						double throughdmg=(this.plugin.DMGCALC.getDamage(new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), e.getDamage(), DamageCause.ENTITY_ATTACK, false));
						if (throughdmg>normaldmg+armor_pen) {
							//This means some piercing can be done.
							//e.setDamage(normaldmg+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat5")/4));
							if (f.getHealth()-(normaldmg+armor_pen)>0) {
								f.setHealth(f.getHealth()-(normaldmg+armor_pen));
								armor_pen_dmg=(normaldmg+armor_pen);
								if (f!=null) {
									if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify4")) {
										if (f.getCustomName()!=null) {
											//p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(normaldmg+armor_pen)*10)/10+" damage to "+convertToItemName(f.getCustomName())+".");
										} else {
											//p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(normaldmg+armor_pen)*10)/10+" damage to "+convertToItemName(f.getType().getName())+".");
										}
									}
								}
							} else {
								f.setHealth(0);
							}
						} else {
							//This means piercing would do extra damage. Just subtract throughdmg.
							if (f.getHealth()-throughdmg>0) {
								f.setHealth(f.getHealth()-throughdmg);
								//armor_pen_dmg=throughdmg;
								if (f!=null) {
									if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify4")) {
										if (f.getCustomName()!=null) {
											//p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(throughdmg)*10)/10+" damage to "+convertToItemName(f.getCustomName())+".");
										} else {
											//p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(throughdmg)*10)/10+" damage to "+convertToItemName(f.getType().getName())+".");
										}
									}
								}
							} else {
								f.setHealth(0);
							}
						}
						e.setDamage(0);
					}
					if (f.getNoDamageTicks()<f.getMaximumNoDamageTicks()/2.0f && e.getDamage()!=0) {
						if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify4")) {
							if (f.getCustomName()!=null) {
								//p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round((this.plugin.DMGCALC.getDamage(f.getEquipment().getHelmet(), f.getEquipment().getChestplate(), f.getEquipment().getLeggings(), f.getEquipment().getBoots(), e.getDamage(), DamageCause.ENTITY_ATTACK, false)))*10)/10+" damage to "+convertToItemName(f.getCustomName())+".");
							} else {
								//p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round((this.plugin.DMGCALC.getDamage(f.getEquipment().getHelmet(), f.getEquipment().getChestplate(), f.getEquipment().getLeggings(), f.getEquipment().getBoots(), e.getDamage(), DamageCause.ENTITY_ATTACK, false)))*10)/10+" damage to "+convertToItemName(f.getType().getName())+".");
							}
						}
					}
					if (e.getCause()!=DamageCause.CUSTOM && f.getNoDamageTicks()<f.getMaximumNoDamageTicks()/2.0f && this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify4")) {
						final double armor_dmg = armor_pen_dmg;
						Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
							@Override
							public void run() {
								DecimalFormat df = new DecimalFormat("#0.0");
								DecimalFormat df2 = new DecimalFormat("#0");
								if (enemy_starthp-f.getHealth()+armor_dmg>0.1) {
									if (f.getCustomName()!=null) {
										p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+"Dealt "+df.format(enemy_starthp-f.getHealth()+armor_dmg)+" damage to "+f.getCustomName()+ChatColor.RED+""+ChatColor.ITALIC+" (-"+df2.format(((enemy_starthp-f.getHealth())/f.getMaxHealth())*100)+"%)");
									} else {
										p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+"Dealt "+df.format(enemy_starthp-f.getHealth()+armor_dmg)+" damage to "+ChatColor.WHITE+f.getType()+ChatColor.RED+""+ChatColor.ITALIC+" (-"+df2.format(((enemy_starthp-f.getHealth())/f.getMaxHealth())*100)+"%)");
									}
								}
							}
						},1);
					}
				} else {
					if (((Projectile)e.getDamager()).getShooter()!=null && ((LivingEntity)((Projectile)e.getDamager()).getShooter()).getType()==EntityType.PLAYER) {
						final Player p = (Player)((Projectile)e.getDamager()).getShooter();
						this.plugin.getPlayerData(p).lastsneaktime=0;
						p.getScoreboard().getTeam(p.getName().toLowerCase()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth(),p.getFoodLevel()));
						ItemStack item = p.getItemInHand();
						double critical_chance=0,armor_pen=0,life_steal=0,attack_speed=0,dmg=0,armor_pen_dmg=0;

						List<MobHead> playerheads = this.plugin.getMobHeads(p);
						if (e.getEntity() instanceof Monster) {
							Monster m = (Monster)e.getEntity();
							int creeperheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CREEPER), playerheads);
							int creeperrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CREEPER,true), playerheads);
							int creeperpoweredheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CREEPER,false,true), playerheads);
							int creeperpoweredrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CREEPER,true,true), playerheads);
							int aoedmg = 0;
							
							aoedmg+=creeperheads*5;
							aoedmg+=creeperrareheads*20;
							aoedmg+=creeperpoweredheads*5;
							aoedmg+=creeperpoweredrareheads*30;
							

							int spiderheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SPIDER), playerheads);
							int spiderrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SPIDER,true), playerheads);
							int spiderpoweredheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SPIDER,false,true), playerheads);
							int spiderpoweredrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SPIDER,true,true), playerheads);
							int slowdownpct = 0;
							
							slowdownpct+=spiderheads*5;
							slowdownpct+=spiderrareheads*15;
							slowdownpct+=spiderpoweredheads*5;
							slowdownpct+=spiderpoweredrareheads*30;
							
							spiderrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SPIDER,true,MobHeadRareType.RARE_TYPE_B), playerheads);
							int poisondur = 0; //Amount of poison duration (seconds) to add to the current poison amount.
							
							poisondur+=spiderrareheads*2;
							poisondur+=spiderpoweredheads*1;
							poisondur+=spiderpoweredrareheads*5;
							
							int endermanheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ENDERMAN), playerheads);
							int endermanrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ENDERMAN,true), playerheads);
							int endermanpoweredheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ENDERMAN,false,true), playerheads);
							int endermanpoweredrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ENDERMAN,true,true), playerheads);
							int critchance = 0;
							
							critchance+=endermanheads;
							critchance+=endermanrareheads*5;
							critchance+=endermanpoweredheads;
							critchance+=endermanpoweredrareheads*10;

							int cavespiderheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CAVE_SPIDER), playerheads);
							int cavespiderrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CAVE_SPIDER,true), playerheads);
							int cavespiderpoweredheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CAVE_SPIDER,false,true), playerheads);
							int cavespiderpoweredrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CAVE_SPIDER,true,true), playerheads);
							
							poisondur+=cavespiderheads;
							poisondur+=cavespiderrareheads*3;
							poisondur+=cavespiderpoweredheads*2;
							poisondur+=cavespiderpoweredrareheads*5;

							cavespiderrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.CAVE_SPIDER,true,MobHeadRareType.RARE_TYPE_B), playerheads);
							int snarechance=0;
							
							snarechance+=cavespiderrareheads*5;
							snarechance+=cavespiderpoweredheads*3;
							snarechance+=cavespiderpoweredrareheads*8;
							
							int blazeheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.BLAZE), playerheads);
							int blazerareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.BLAZE,true), playerheads);
							int blazepoweredheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.BLAZE,false,true), playerheads);
							int blazepoweredrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.BLAZE,true,true), playerheads);
							int ignitedur = 0;
							ignitedur+=blazeheads;
							ignitedur+=blazerareheads*3;
							ignitedur+=blazepoweredheads;
							ignitedur+=blazepoweredrareheads*5;
							
							blazerareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.BLAZE,true,MobHeadRareType.RARE_TYPE_B), playerheads);
							int airbornechance=0;

							airbornechance+=blazerareheads*3;
							airbornechance+=blazepoweredheads;
							airbornechance+=blazepoweredrareheads*10;
									
							if (Math.random()*100<=critchance) {
								e.setDamage(e.getDamage()*2);
							}		
							if (Math.random()*100<=snarechance) {
								m.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,100,7,true));
							}		
							if (Math.random()*100<=airbornechance) {
								//m.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,100,7,true));
								
								final LivingEntity l = (LivingEntity)e.getEntity();
								
								Location airborne_loc = l.getLocation();
								//Check upwards. Stop if we hit a solid block.
								int starty=l.getLocation().getBlockY();
								int checky=l.getLocation().getBlockY();
								/*16 is max height that a mob will be set to.*/
								while (checky-starty<19 && l.getWorld().getBlockAt(l.getLocation().getBlockX(),checky,l.getLocation().getBlockZ()).getType()==Material.AIR) {
									checky++;
								}
								
								if (checky-starty>3) {
									checky-=3;
								} else {
									checky=starty;
								}
								
								final Location teleport_to = new Location(l.getWorld(),l.getLocation().getBlockX(),checky,l.getLocation().getBlockZ());
								
								Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
									@Override
									public void run() {
										l.teleport(teleport_to);
									}
								},1);
							}
							
							if (ignitedur>0) {
								m.setFireTicks(m.getFireTicks()+(ignitedur*20));
							}
							
							m.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,60,slowdownpct/15,true));
							

							int poisonduration=0;
							//First see if the mob is already a poisoned mob.
							boolean found=false;
							for (int i=0;i<this.plugin.mob_list.size();i++) {
								if (this.plugin.mob_list.get(i).id.compareTo(m.getUniqueId())==0) {
									//We found it. Add onto current poison duration.
									this.plugin.mob_list.get(i).addPoison(poisondur*20);
									found=true;
									break;
								}
							}
							if (!found) {
								//We didn't find it, so add a new entry to the poison list.
								MobManager newm = new MobManager(m.getUniqueId());
								newm.addPoison(poisondur*20);
								this.plugin.mob_list.add(newm);
							}
														
							List<Entity> nearby_mobs = m.getNearbyEntities(2, 2, 2);
							for (int i=0;i<nearby_mobs.size();i++) {
								if (!(nearby_mobs.get(i) instanceof Monster)) {
									nearby_mobs.remove(i);
									i--;
								}
							}
							if (aoedmg>0) {
								for (int i=0;i<nearby_mobs.size();i++) {
									if (!nearby_mobs.get(i).getUniqueId().equals(m)) {
										LivingEntity m2 = (LivingEntity)nearby_mobs.get(i);
										m2.damage(e.getDamage()*(aoedmg/100.0d));
									}
								}
							}
							int witherskeletonheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.WITHER_SKELETON), playerheads);
							int witherskeletonrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.WITHER_SKELETON,true), playerheads);
							int witherskeletonpoweredheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.WITHER_SKELETON,false,true), playerheads);
							int witherskeletonpoweredrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.WITHER_SKELETON,true,true), playerheads);
							int witherduration = 0, witheramplifier = 0;
							try {
								Iterator<PotionEffect> effects = m.getActivePotionEffects().iterator();
								//Figure out potion effects when player joins.
								while (effects.hasNext()) {
									PotionEffect nexteffect = effects.next();
									//Bukkit.getLogger().info("Effect Type is "+nexteffect.getType().getName()+", amplifier is "+nexteffect.getAmplifier()+", duration is "+nexteffect.getDuration());
									if (witherskeletonheads+witherskeletonrareheads+witherskeletonpoweredheads+witherskeletonpoweredrareheads>0 && nexteffect.getType().getName().compareTo(PotionEffectType.WITHER.getName())==0) {
										witherduration=nexteffect.getDuration();
										witheramplifier=nexteffect.getAmplifier();
									}
									if (nexteffect.getType().getName().compareTo(PotionEffectType.SLOW.getName())==0 && nexteffect.getAmplifier()==6 && nexteffect.getDuration()<=60) {
										m.removePotionEffect(PotionEffectType.SLOW);
										//Bukkit.getLogger().info("Removed slow.");
										//p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, nexteffect.getAmplifier()+1, true));
										break;
									}
									/*if (nexteffect.getType().getName().compareTo(PotionEffectType.JUMP.getName())==0) {
										p.removePotionEffect(PotionEffectType.JUMP);
										p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 360000, nexteffect.getAmplifier()+2, true));
									}*/
									effects.remove();
								}
							} catch (ConcurrentModificationException ex_e) {
								Bukkit.getLogger().warning("Potion Effect Collection not accessible while trying to remove slow debuff.");
							}
							if (witherskeletonpoweredrareheads>0) {
								if (witherduration==0) {witherduration=400;}
								Bukkit.getLogger().info("Adding potion effect WITHER with amplifier "+(witheramplifier+2*witherskeletonpoweredrareheads)+" + duration "+witherduration);
								m.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,witherduration,witheramplifier+2*witherskeletonpoweredrareheads),true);
							} else if (witherskeletonpoweredheads>0) {
								if (witherduration==0) {witherduration=100;}
								Bukkit.getLogger().info("Adding potion effect WITHER with amplifier "+(witheramplifier+1*witherskeletonpoweredrareheads)+" + duration "+witherduration);
								m.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,witherduration,witheramplifier+1*witherskeletonpoweredrareheads),true);
							} else if (witherskeletonrareheads>0) {
								Bukkit.getLogger().info("Adding potion effect WITHER with amplifier 2 + duration "+(witherduration+300*witherskeletonrareheads));
								m.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,witherduration+300*witherskeletonrareheads,2),true);
							} else if (witherskeletonheads>0) {
								Bukkit.getLogger().info("Adding potion effect WITHER with amplifier 0 + duration "+(witherduration+100*witherskeletonrareheads));
								m.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,witherduration+100*witherskeletonrareheads,0),true);
							}
						}
						int skeleton_heads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SKELETON), playerheads);
						int powered_skeleton_heads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SKELETON, false, true), playerheads);
						int rare_skeleton_heads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SKELETON, true, MobHeadRareType.RARE_TYPE_A), playerheads);
						int powered_rare_skeleton_heads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SKELETON, true, MobHeadRareType.RARE_TYPE_A, true), playerheads);
						/*if (skeleton_heads>0) {
							Bukkit.getLogger().info("Found "+skeleton_heads+" skeleton mob heads.");
						}
						if (powered_skeleton_heads>0) {
							Bukkit.getLogger().info("Found "+powered_skeleton_heads+" powered skeleton mob heads.");
						}
						if (rare_skeleton_heads>0) {
							Bukkit.getLogger().info("Found "+rare_skeleton_heads+" rare skeleton mob heads.");
						}
						if (powered_rare_skeleton_heads>0) {
							Bukkit.getLogger().info("Found "+powered_rare_skeleton_heads+" powered rare skeleton "s.");
						}*/
						if (skeleton_heads+powered_skeleton_heads+rare_skeleton_heads+powered_rare_skeleton_heads>0) {
							//Bukkit.getLogger().info("Old damage was "+e.getDamage());
							e.setDamage(e.getDamage()+(e.getDamage()*(0.01*skeleton_heads)));
							e.setDamage(e.getDamage()+(e.getDamage()*(0.01*powered_skeleton_heads)));
							e.setDamage(e.getDamage()+(e.getDamage()*(0.03*rare_skeleton_heads)));
							e.setDamage(e.getDamage()+(e.getDamage()*(0.05*powered_rare_skeleton_heads)));
							//Bukkit.getLogger().info("New damage is "+e.getDamage());
						}
						if (this.plugin.hasJobBuff("Hunter", p, Job.JOB30B)) {
							armor_pen+=10;
						}
						if (item.getType()==Material.BOW && item.getItemMeta()!=null && item.getItemMeta().getLore()!=null && item.getItemMeta().getLore().size()!=0) { //Make sure we are using a ranged weapon.
							for (int i=0;i<item.getItemMeta().getLore().size();i++) {
								if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Critical Chance")) {
									if (critical_chance==0) {
										critical_chance+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
									} else {
										critical_chance+=(100-critical_chance)*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/100d);
									}
								}
								if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Armor Penetration")) {
									armor_pen+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
								}
								if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Life Steal")) {
									if (life_steal==0) {
										life_steal+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
									} else {
										life_steal+=(100-life_steal)*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/100d);
									}
								}
								if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Attack Speed")) {
									if (attack_speed==0) {
										attack_speed+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
									} else {
										attack_speed+=(100-attack_speed)*(this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i))/100d);
									}
								}
								if (this.plugin.containsEnchantment(item.getItemMeta().getLore().get(i), "Damage")) {
									dmg+=this.plugin.getEnchantmentNumb(item.getItemMeta().getLore().get(i));
								}
							}
						}
						if (this.plugin.getPlayerData(p).furytime!=0) {
							attack_speed+=this.plugin.getPlayerData(p).furyamt;
						}
						if (critical_chance>0) {
							if (Math.random()<=critical_chance/100.0d) {
								e.setDamage(e.getDamage()*2);
							}
						}
						if (f.getNoDamageTicks()<f.getMaximumNoDamageTicks()/2.0f && life_steal>0) {
							if (p.getHealth()+e.getDamage()*(life_steal/100.0d)<p.getMaxHealth()) {
								p.setHealth(p.getHealth()+e.getDamage()*(life_steal/100.0d));
							} else {
								p.setHealth(p.getMaxHealth());
							}
						}
						if (attack_speed>0) {
							f.setNoDamageTicks(f.getNoDamageTicks()-(int)(f.getNoDamageTicks()*(attack_speed/100.0d/4)));
						}
						if (dmg>0) {
							e.setDamage(e.getDamage()+dmg);
						}
						//Add Armor penetration from the stat point, if any.
						if (this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat5")/4)>0) {
							armor_pen+=this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat5")/4);
						}
						if (e.getEntity() instanceof LivingEntity) {
							LivingEntity enemy = (LivingEntity)e.getEntity();
							if (enemy.getCustomName()!=null && (enemy.getCustomName().compareTo(ChatColor.GRAY+"Zombie Ninja")==0)) {
								boolean found=false;
								for (int i=0;i<this.plugin.ninjavisible_list.size();i++) {
									if (this.plugin.ninjavisible_list.get(i).val.equals(enemy.getUniqueId())) {
										found=true;
										enemy.removePotionEffect(PotionEffectType.INVISIBILITY);
										this.plugin.ninjavisible_list.get(i).resettime=Main.SERVER_TICK_TIME+20;
										break;
									}
								}
								if (!found) {
									enemy.removePotionEffect(PotionEffectType.INVISIBILITY);
									this.plugin.ninjavisible_list.add(new InvisibilityData(enemy.getUniqueId(), Main.SERVER_TICK_TIME+10));
								}
							}
						}
						if (this.plugin.PlayerinJob((Player)((Projectile)e.getDamager()).getShooter(), "Support")) {
							for (int i=0;i<this.plugin.supportmoblist.size();i++) {
								if (this.plugin.supportmoblist.get(i).p.getName().compareTo(((Player)((Projectile)e.getDamager()).getShooter()).getName())==0) {
									if (!this.plugin.supportmoblist.get(i).id.contains(((Entity)f).getUniqueId())) {
										this.plugin.supportmoblist.get(i).id.add(((Entity)f).getUniqueId());
										//Bukkit.getPlayer("sigonasr2").sendMessage("Added to list: "+((Entity)f).getUniqueId().toString());
										this.plugin.supportmoblist.get(i).registeredtime=Main.SERVER_TICK_TIME+1200;
									}
								}
							}
						} else {
							for (int i=0;i<this.plugin.hitmoblist.size();i++) {
								if (this.plugin.hitmoblist.get(i).p.getName().compareTo(((Player)((Projectile)e.getDamager()).getShooter()).getName())==0) {
									if (!this.plugin.hitmoblist.get(i).id.contains(((Entity)f).getUniqueId())) {
										this.plugin.hitmoblist.get(i).id.add(((Entity)f).getUniqueId());
										//Bukkit.getPlayer("sigonasr2").sendMessage("Added to list: "+((Entity)f).getUniqueId().toString());
										this.plugin.hitmoblist.get(i).registeredtime=Main.SERVER_TICK_TIME+1200;
									}
								}
							}
						}
						if (this.plugin.hasJobBuff("Hunter", (Player)((Projectile)e.getDamager()).getShooter(), Job.JOB40)) {
							//Deal 4 extra damage.
							e.setDamage(e.getDamage()+4);
						}
						if (this.plugin.hasJobBuff("Hunter", (Player)((Projectile)e.getDamager()).getShooter(), Job.JOB5)) {
							//Deal 4 extra damage.
							e.setDamage(e.getDamage()+4);
						}
						if (this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat7")>0) {
							e.setDamage(e.getDamage()+(this.plugin.getStatBonus(6, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat7"))/2));
						}
						if (f.getNoDamageTicks()<f.getMaximumNoDamageTicks()/2.0f && armor_pen>0) {
							double normaldmg=(this.plugin.DMGCALC.getDamage(f.getEquipment().getHelmet(), f.getEquipment().getChestplate(), f.getEquipment().getLeggings(), f.getEquipment().getBoots(), e.getDamage(), DamageCause.ENTITY_ATTACK, false));
							double throughdmg=(this.plugin.DMGCALC.getDamage(new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR), e.getDamage(), DamageCause.ENTITY_ATTACK, false));


							if (throughdmg>normaldmg+armor_pen) {
								//This means some piercing can be done.
								//e.setDamage(normaldmg+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat5")/4));
								if (f.getHealth()-(normaldmg+armor_pen)>0) {
									f.setHealth(f.getHealth()-(normaldmg+armor_pen));
									armor_pen_dmg=(normaldmg+armor_pen);
									if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify4")) {
										if (f.getCustomName()!=null) {
											//p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(normaldmg+armor_pen)*10)/10+" damage to "+convertToItemName(f.getCustomName())+".");
										} else {
											//p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(normaldmg+armor_pen)*10)/10+" damage to "+convertToItemName(f.getType().getName())+".");
										}
									}
								} else {
									f.setHealth(0);
								}
							} else {
								//This means piercing would do extra damage. Just subtract throughdmg.
								if (f.getHealth()-throughdmg>0) {
									f.setHealth(f.getHealth()-throughdmg);
									////armor_pen_dmg=throughdmg;
									if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify4")) {
										if (f.getCustomName()!=null) {
											//p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(throughdmg)*10)/10+" damage to "+convertToItemName(f.getCustomName())+".");
										} else {
											//p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round(throughdmg)*10)/10+" damage to "+convertToItemName(f.getType().getName())+".");
										}
									}
								} else {
									f.setHealth(0);
								}
							}
							e.setDamage(0);
						}
						if (f.getNoDamageTicks()<f.getMaximumNoDamageTicks()/2.0f && e.getDamage()!=0) {
							if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify4")) {
								if (f.getCustomName()!=null) {
									//p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round((this.plugin.DMGCALC.getDamage(f.getEquipment().getHelmet(), f.getEquipment().getChestplate(), f.getEquipment().getLeggings(), f.getEquipment().getBoots(), e.getDamage(), DamageCause.ENTITY_ATTACK, false)))*10)/10+" damage to "+convertToItemName(f.getCustomName())+".");
								} else {
									//p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+" Dealt "+(Math.round((this.plugin.DMGCALC.getDamage(f.getEquipment().getHelmet(), f.getEquipment().getChestplate(), f.getEquipment().getLeggings(), f.getEquipment().getBoots(), e.getDamage(), DamageCause.ENTITY_ATTACK, false)))*10)/10+" damage to "+convertToItemName(f.getType().getName())+".");
								}
							}
						}
						if (e.getCause()!=DamageCause.CUSTOM && f.getNoDamageTicks()<f.getMaximumNoDamageTicks()/2.0f && this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify4")) {
							final double armor_dmg = armor_pen_dmg;
							Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
								@Override
								public void run() {
									DecimalFormat df = new DecimalFormat("#0.0");
									DecimalFormat df2 = new DecimalFormat("#0");
									if (f.getCustomName()!=null) {
										if (enemy_starthp-f.getHealth()+armor_dmg>0.1) {
											p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+"Dealt "+df.format(enemy_starthp-f.getHealth()+armor_dmg)+" damage to "+f.getCustomName()+ChatColor.RED+""+ChatColor.ITALIC+" (-"+df2.format(((enemy_starthp-f.getHealth())/f.getMaxHealth())*100)+"%)");
										}
									} else {
										if (enemy_starthp-f.getHealth()+armor_dmg>0.1) {
											p.sendMessage(ChatColor.RED+""+ChatColor.ITALIC+"Dealt "+df.format(enemy_starthp-f.getHealth()+armor_dmg)+" damage to "+ChatColor.WHITE+f.getType().name()+ChatColor.RED+""+ChatColor.ITALIC+" (-"+df2.format(((enemy_starthp-f.getHealth())/f.getMaxHealth())*100)+"%)");
										}
									}
								}
							},1);
						}
					}
				}
			}
			if (f.getKiller()!=null && f.getKiller().getType()==EntityType.PLAYER) {
				Player p = f.getKiller();
				p.getScoreboard().getTeam(p.getName().toLowerCase()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth(),p.getFoodLevel()));
				//p.sendMessage(f.getType()+" is mad at you.");
				//if (p.getName().toLowerCase().equalsIgnoreCase("sigonasr2")) {p.sendMessage("You are the killer of "+f.getCustomName()+".");}
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
		if (e.getEntity().getType()==EntityType.PLAYER) {
			final Player p = (Player)e.getEntity();
			final boolean blocked = blocked_attack;
			final boolean blocked_hunter = blocked_hunter_buff;
			final Main plug = this.plugin;
			int helm_dura=-1,chest_dura=-1,legs_dura=-1,boots_dura=-1;
			if (p.getEquipment().getHelmet()!=null) {helm_dura=p.getEquipment().getHelmet().getDurability();}
			if (p.getEquipment().getChestplate()!=null) {chest_dura=p.getEquipment().getChestplate().getDurability();}
			if (p.getEquipment().getLeggings()!=null) {legs_dura=p.getEquipment().getLeggings().getDurability();}
			if (p.getEquipment().getBoots()!=null) {boots_dura=p.getEquipment().getBoots().getDurability();}
			final int prev_helm_dura=helm_dura,prev_chest_dura=chest_dura,prev_legs_dura=legs_dura,prev_boots_dura=boots_dura;
			//if (p.getNoDamageTicks()<p.getMaximumNoDamageTicks()/2.0f) {
			p.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				@Override
				public void run() {
					//This player lost durability, we will attempt to give it back based on certain conditions.
					//CASE 1: The player actually loses more durability if it's weak armor.
					//CASE 2: The player gains back -1 durability if they have +X% Durability. The chance of it occuring is Math.random()*X<=100
					//CASE 3: The amount lost by the blocking stat has the possibility to be gained back.
					int helm_dura=-1,chest_dura=-1,legs_dura=-1,boots_dura=-1;
					boolean weak_helm=false,weak_chest=false,weak_legs=false,weak_boots=false;
					if (p.getEquipment().getHelmet()!=null) {helm_dura=p.getEquipment().getHelmet().getDurability();}
					if (p.getEquipment().getChestplate()!=null ) {chest_dura=p.getEquipment().getChestplate().getDurability();}
					if (p.getEquipment().getLeggings()!=null) {legs_dura=p.getEquipment().getLeggings().getDurability();}
					if (p.getEquipment().getBoots()!=null) {boots_dura=p.getEquipment().getBoots().getDurability();}
					if (helm_dura<=prev_helm_dura) {helm_dura=-1;}
					if (chest_dura<=prev_chest_dura) {chest_dura=-1;}
					if (legs_dura<=prev_legs_dura) {legs_dura=-1;}
					if (boots_dura<=prev_boots_dura) {boots_dura=-1;}
					Bukkit.getLogger().info("Durability of items are: "+helm_dura+","+chest_dura+","+legs_dura+","+boots_dura);
					int gained_back=0;
					if (p.getEquipment().getHelmet()!=null && helm_dura!=-1 && p.getEquipment().getHelmet().hasItemMeta() &&
							p.getEquipment().getHelmet().getItemMeta().hasLore()) {
						List<String> lore = p.getEquipment().getHelmet().getItemMeta().getLore();
						for (int i=0;i<lore.size();i++) {
							if (lore.get(i).contains(ChatColor.RED+"-400% Durability")) {
								helm_dura+=3;
								weak_helm=true;
							}
							if (!blocked_hunter && blocked && plug.containsEnchantment(lore.get(i), "Block Chance")) {
								helm_dura+=3;
							}
						}
					}
					if (p.getEquipment().getChestplate()!=null && chest_dura!=-1 && p.getEquipment().getChestplate().hasItemMeta() &&
							p.getEquipment().getChestplate().getItemMeta().hasLore()) {
						List<String> lore = p.getEquipment().getChestplate().getItemMeta().getLore();
						for (int i=0;i<lore.size();i++) {
							if (lore.get(i).contains(ChatColor.RED+"-400% Durability")) {
								chest_dura+=3;
								weak_chest=true;
							}
							if (!blocked_hunter && blocked && plug.containsEnchantment(lore.get(i), "Block Chance")) {
								chest_dura+=3;
							}
						}
					}
					if (p.getEquipment().getLeggings()!=null && legs_dura!=-1 && p.getEquipment().getLeggings().hasItemMeta() &&
							p.getEquipment().getLeggings().getItemMeta().hasLore()) {
						List<String> lore = p.getEquipment().getLeggings().getItemMeta().getLore();
						for (int i=0;i<lore.size();i++) {
							if (lore.get(i).contains(ChatColor.RED+"-400% Durability")) {
								legs_dura+=3;
								weak_legs=true;
							}
							if (!blocked_hunter && blocked && plug.containsEnchantment(lore.get(i), "Block Chance")) {
								Bukkit.getLogger().info("Leggings Block Chance.");
								legs_dura+=3;
							}
						}
					}
					if (p.getEquipment().getBoots()!=null && boots_dura!=-1 && p.getEquipment().getBoots().hasItemMeta() &&
							p.getEquipment().getBoots().getItemMeta().hasLore()) {
						List<String> lore = p.getEquipment().getBoots().getItemMeta().getLore();
						for (int i=0;i<lore.size();i++) {
							if (lore.get(i).contains(ChatColor.RED+"-400% Durability")) {
								boots_dura+=3;
								weak_boots=true;
							}
							if (!blocked_hunter && blocked && plug.containsEnchantment(lore.get(i), "Block Chance")) {
								boots_dura+=3;
							}
						}
					}
					if (p.getEquipment().getHelmet()!=null && helm_dura!=-1 && p.getEquipment().getHelmet().hasItemMeta() &&
							p.getEquipment().getHelmet().getItemMeta().hasLore()) {
						List<String> lore = p.getEquipment().getHelmet().getItemMeta().getLore();
						double dura_numb=0;
						for (int i=0;i<lore.size();i++) {
							if (plug.containsEnchantment(lore.get(i), "Durability")) {
								dura_numb+=plug.getEnchantmentNumb(lore.get(i));
							}
						}
						if (!weak_helm) {dura_numb+=300; /*Bukkit.getLogger().info("1 not weak.");*/}
						if (Math.random()*dura_numb>100) {
							helm_dura-=1;
						}
					}
					if (p.getEquipment().getChestplate()!=null && chest_dura!=-1 && p.getEquipment().getChestplate().hasItemMeta() &&
							p.getEquipment().getChestplate().getItemMeta().hasLore()) {
						List<String> lore = p.getEquipment().getChestplate().getItemMeta().getLore();
						double dura_numb=0;
						for (int i=0;i<lore.size();i++) {
							if (plug.containsEnchantment(lore.get(i), "Durability")) {
								dura_numb+=plug.getEnchantmentNumb(lore.get(i));
							}
						}
						if (!weak_chest) {dura_numb+=300; /*Bukkit.getLogger().info("2 not weak.");*/}
						if (Math.random()*dura_numb>100) {
							chest_dura-=1;
						}
					}
					if (p.getEquipment().getLeggings()!=null && legs_dura!=-1 && p.getEquipment().getLeggings().hasItemMeta() &&
							p.getEquipment().getLeggings().getItemMeta().hasLore()) {
						List<String> lore = p.getEquipment().getLeggings().getItemMeta().getLore();
						double dura_numb=0;
						for (int i=0;i<lore.size();i++) {
							if (plug.containsEnchantment(lore.get(i), "Durability")) {
								dura_numb+=plug.getEnchantmentNumb(lore.get(i));
							}
						}
						if (!weak_legs) {dura_numb+=300; /*Bukkit.getLogger().info("3 not weak.");*/}
						if (Math.random()*dura_numb>100) {
							legs_dura-=1;
						}
					}
					if (p.getEquipment().getBoots()!=null && boots_dura!=-1 && p.getEquipment().getBoots().hasItemMeta() &&
							p.getEquipment().getBoots().getItemMeta().hasLore()) {
						List<String> lore = p.getEquipment().getBoots().getItemMeta().getLore();
						double dura_numb=0;
						for (int i=0;i<lore.size();i++) {
							if (plug.containsEnchantment(lore.get(i), "Durability")) {
								dura_numb+=plug.getEnchantmentNumb(lore.get(i));
							}
						}
						if (!weak_boots) {dura_numb+=300; /*Bukkit.getLogger().info("4 not weak.");*/}
						if (Math.random()*dura_numb>100) {
							boots_dura-=1;
						}
					}
					if (p.getEquipment().getBoots()!=null && boots_dura!=-1) {ItemStack i = p.getEquipment().getBoots(); i.setDurability((short)boots_dura); p.getEquipment().setBoots(i);}
					if (p.getEquipment().getLeggings()!=null && legs_dura!=-1) {ItemStack i = p.getEquipment().getLeggings(); i.setDurability((short)legs_dura); p.getEquipment().setLeggings(i);}
					if (p.getEquipment().getChestplate()!=null && chest_dura!=-1) {ItemStack i = p.getEquipment().getChestplate(); i.setDurability((short)chest_dura); p.getEquipment().setChestplate(i);}
					if (p.getEquipment().getHelmet()!=null && helm_dura!=-1) {ItemStack i = p.getEquipment().getHelmet(); i.setDurability((short)helm_dura); p.getEquipment().setHelmet(i);}
					Bukkit.getLogger().info("Durability of items now are: "+helm_dura+","+chest_dura+","+legs_dura+","+boots_dura);
				}
			},1);
		}
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		this.plugin.getPlayerData(p).gameinteractions+=50;
		//***********************************//JOB BUFFFS!!! HYPE
		if (this.plugin.PlayerinJob(p, "Builder")) {
			if (this.plugin.hasJobBuff("Builder", p, Job.JOB40) && !p.getAllowFlight()) {
				p.setAllowFlight(true);
				p.sendMessage(ChatColor.DARK_GRAY+""+ChatColor.ITALIC+"Flight enabled...");
				this.plugin.getPlayerData(p).lastflighttime=Main.SERVER_TICK_TIME;
			} else {
				if (this.plugin.hasJobBuff("Builder", p, Job.JOB40)) {
					this.plugin.getPlayerData(p).lastflighttime=Main.SERVER_TICK_TIME;
				}
			}
			if (this.plugin.hasJobBuff("Builder", p, Job.JOB30B)) {
				try {
					Iterator<PotionEffect> effects = p.getActivePotionEffects().iterator();
					//Figure out potion effects when player joins.
					while (effects.hasNext()) {
						PotionEffect nexteffect = effects.next();
						if (nexteffect.getType().getName().compareTo(PotionEffectType.JUMP.getName())==0 && nexteffect.getAmplifier()<9) {
							p.removePotionEffect(PotionEffectType.JUMP);
							p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, nexteffect.getAmplifier()+1, true));
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
			}
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,200,0));
			int expbefore = (int)this.plugin.getPlayerCurrentJobExp(p, "Builder");
			getBuilderCredit(e.getBlockPlaced(), p);
			if ((int)this.plugin.getPlayerCurrentJobExp(p, "Builder")-expbefore>0 && this.plugin.hasJobBuff("Builder", p, Job.JOB30A)) {
				ExperienceOrb orb = (ExperienceOrb)p.getWorld().spawnEntity(e.getBlockPlaced().getLocation().add(0,1,0), EntityType.EXPERIENCE_ORB);
				orb.setExperience((int)this.plugin.getPlayerCurrentJobExp(p, "Builder")-expbefore);
			}
		}
		//***********************************//No Job Buff Hype :(
		if (e.getItemInHand().getType()==Material.HOPPER) {
			//Check surrounding blocks to verify it's not a chest.
			for (int i=-1;i<2;i++) {
				for (int j=0;j<2;j++) {
					for (int k=-1;k<2;k++) {
						if (p.getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(i,j,k)).getType()==Material.CHEST) {
							//Check to see if it's a recycling center chest.
							for (int l=0;l<this.plugin.recycling_center_list.size();l++) {
								for (int m=0;m<this.plugin.recycling_center_list.get(l).locations.size();m++) {
									if (this.plugin.recycling_center_list.get(l).locations.get(m).getBlock().equals(p.getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(i,j,k)))) {
										e.setCancelled(true);
										p.updateInventory();
										return;
									}
								}
							}
						}
					}
				}
			}
		}
		if (e.getItemInHand().getType()==Material.PUMPKIN) {
			if (e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-1,0)).getType()==Material.SNOW_BLOCK &&
					e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-2,0)).getType()==Material.SNOW_BLOCK) {
				//Create a snowman.
				e.getBlockPlaced().setType(Material.AIR);
				e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-1,0)).setType(Material.AIR);
				e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-2,0)).setType(Material.AIR);
				e.getBlockPlaced().getWorld().spawnEntity(e.getBlockPlaced().getLocation(), EntityType.SNOWMAN);
			}
			if (e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-1,0)).getType()==Material.IRON_BLOCK &&
					e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-2,0)).getType()==Material.IRON_BLOCK &&
					e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(1,-1,0)).getType()==Material.IRON_BLOCK &&
					e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(-1,-1,0)).getType()==Material.IRON_BLOCK) {
				//Create a snowman.
				e.getBlockPlaced().setType(Material.AIR);
				e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-1,0)).setType(Material.AIR);
				e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-2,0)).setType(Material.AIR);
				e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(1,-1,0)).setType(Material.AIR);
				e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(-1,-1,0)).setType(Material.AIR);
				e.getBlockPlaced().getWorld().spawnEntity(e.getBlockPlaced().getLocation(), EntityType.IRON_GOLEM);
			}
			if (e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-1,0)).getType()==Material.IRON_BLOCK &&
					e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-2,0)).getType()==Material.IRON_BLOCK &&
					e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-1,1)).getType()==Material.IRON_BLOCK &&
					e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-1,-1)).getType()==Material.IRON_BLOCK) {
				//Create a snowman.
				e.getBlockPlaced().setType(Material.AIR);
				e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-1,0)).setType(Material.AIR);
				e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-2,0)).setType(Material.AIR);
				e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-1,1)).setType(Material.AIR);
				e.getBlockPlaced().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-1,-1)).setType(Material.AIR);
				e.getBlockPlaced().getWorld().spawnEntity(e.getBlockPlaced().getLocation(), EntityType.IRON_GOLEM);
			}
		}
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
				if (e.getItemInHand().getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 9 item slots.") || e.getItemInHand().getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 54 item slots.") || e.getItemInHand().getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 27 item slots.")) {
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
		if (this.plugin.getConfig().getBoolean("spleefinsession")==true && (this.plugin.getConfig().getString("spleefrequestaplayer").compareTo(p.getName().toLowerCase())==0 || this.plugin.getConfig().getString("spleefrequestbplayer").compareTo(p.getName().toLowerCase())==0)) {
			e.setCancelled(true);
		}
		if (this.plugin.getConfig().getBoolean("spleef4insession")==true && (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName().toLowerCase())==0 || this.plugin.getConfig().getString("spleefrequestb4player").compareTo(p.getName().toLowerCase())==0 || this.plugin.getConfig().getString("spleefrequestc4player").compareTo(p.getName().toLowerCase())==0 || this.plugin.getConfig().getString("spleefrequestd4player").compareTo(p.getName().toLowerCase())==0)) {
			e.setCancelled(true);
		}
		if (e.getItemInHand().getType()==Material.getMaterial(127)) {
			p.updateInventory();
			e.setCancelled(true);
		}
		if (this.plugin.is_ItemCube(e.getItemInHand())) {
			p.updateInventory();
			e.setCancelled(true);
		}
		if (this.plugin.is_PocketWorkbench(e.getItemInHand())) {
			p.updateInventory();
			e.setCancelled(true);
			return;
		}
		if (this.plugin.is_LootChest(e.getItemInHand())) {
			int tier = -1;
			open_LootChest(tier = this.plugin.get_LootChestTier(e.getItemInHand()), e.getBlockPlaced().getLocation());

			
			e.setCancelled(true);
			if (e.getItemInHand().getAmount() > 1) {
				e.getItemInHand().setAmount(e.getItemInHand().getAmount() - 1);
			} else {
				e.getPlayer().setItemInHand(null);
			}
			// e.getPlayer().getWorld().dropItemNaturally(e.getBlockPlaced().getLocation(), getGoodie());
			
			if (tier<=5) {
				p.sendMessage(ChatColor.GREEN+"You open the chest and find treasure inside!");
			}
			p.playSound(p.getLocation(), Sound.ORB_PICKUP, 10, 1);
			p.updateInventory();
			return;
		}
		return;
	}

	@EventHandler
	public void onItemBreak(PlayerItemBreakEvent e) {
		final Player p = e.getPlayer();
		final ItemStack i = e.getBrokenItem();
		if (i.getItemMeta()!=null && i.getItemMeta().hasDisplayName() && i.getItemMeta().getDisplayName().compareTo("Spleef Wooden Shovel")==0) {
			i.setDurability((short)0);
			p.getInventory().addItem(i);
		}
		if (i.hasItemMeta() && i.getItemMeta().hasLore()) {
			boolean is_halloween=false;
			List<String> finallore = new ArrayList<String>();
			for (int j=0;j<i.getItemMeta().getLore().size();j++) {
				if (i.getItemMeta().getLore().get(j).contains(ChatColor.YELLOW+"[Halloween]")) {
					is_halloween=true;
					//p.sendMessage("Is a halloween item.");
				}
				finallore.add(i.getItemMeta().getLore().get(j));
			}
			if (is_halloween) {
				i.setDurability((short)0);
				i.setType(Material.SULPHUR);
				ItemMeta meta = i.getItemMeta();
				meta.setDisplayName(ChatColor.DARK_GRAY+"[BROKEN] "+meta.getDisplayName());
				finallore.add("");
				finallore.add("Will be repaired @ "+(Main.SERVER_TICK_TIME+12096000));
				meta.setLore(finallore);
				//p.sendMessage("Meta is set.");
				i.setItemMeta(meta);
				i.setAmount(1);
				p.updateInventory();
			}
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
	public void onInventoryDragEvent(InventoryDragEvent e) {
		Player p = (Player)e.getWhoClicked();
		if (isViewingBookshelf(p)) {
			if (this.plugin.book_shelf_active) {
				final Player p2 = p;
				this.plugin.book_shelf_active=false;
				int inven_amount=0;
				int item_count=0;
				for (int i=0;i<9;i++) {
					if (e.getInventory().getContents()[i]!=null) {
						inven_amount+=e.getInventory().getContents()[i].getAmount();
						item_count++;
						//Bukkit.getLogger().info("Check at "+e.getInventory().getContents()[i].toString());
					}
				}
				//Bukkit.getLogger().info("Marked at "+inven_amount+".");
				Bookshelf_attemptUpdate(inven_amount,item_count,p2);
			} else {
				//Bukkit.getLogger().info("Cannot perform! We are waiting on an update.");
				e.setCancelled(true);
				e.setResult(Result.DENY);
			}
		}
		if (isViewingEnderCube(p)) {
			if (this.plugin.ender_cube_active) {
				final Player p2 = p;
				this.plugin.ender_cube_active=false;
				int inven_amount=0;
				int item_count=0;
				for (int i=0;i<27;i++) {
					if (e.getInventory().getContents()[i]!=null) {
						inven_amount+=e.getInventory().getContents()[i].getAmount();
						item_count++;
						//Bukkit.getLogger().info("Check at "+e.getInventory().getContents()[i].toString());
					}
				}
				//Bukkit.getLogger().info("Marked at "+inven_amount+".");
				ItemCube_attemptUpdate(inven_amount,item_count,p2);
			} else {
				//Bukkit.getLogger().info("Cannot perform! We are waiting on an update.");
				e.setCancelled(true);
				e.setResult(Result.DENY);
			}
		}
	}

	@EventHandler
	public void onInventoryCloseEvent(InventoryCloseEvent e) {
		final Player p = (Player)e.getPlayer();
		final Inventory inv = e.getInventory();
		//Bukkit.getLogger().info("GEt close inventory event.");
		p.getScoreboard().getTeam(p.getName().toLowerCase()).setPrefix(ChatColor.WHITE+"");
		if (p.hasPermission("group.moderator")) {
			p.getScoreboard().getTeam(p.getName().toLowerCase()).setPrefix(ChatColor.GREEN+"");
		}
		if (p.hasPermission("group.administrators")) {
			p.getScoreboard().getTeam(p.getName().toLowerCase()).setPrefix(ChatColor.LIGHT_PURPLE+"");
		}
		if (e.getInventory().getName().contains("Choose an additional bonus:")) {
			//If we still have the temporary item, we will re-open the window soon after.
			for (int i=0;i<p.getInventory().getContents().length;i++) {
				if (p.getInventory().getContents()[i]!=null && p.getInventory().getContents()[i].hasItemMeta() &&
						p.getInventory().getContents()[i].getItemMeta().hasDisplayName() && 
						p.getInventory().getContents()[i].getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GRAY+""+ChatColor.ITALIC+"[Temporary Item]")) {
					p.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
						@Override
						public void run() {
							p.openInventory(inv);
						}
					}, 1);
				}
			}
		} else
		if (e.getInventory().getName().contains("Bookshelf")) {
			int identifier=-1;
			//Get idenfitier.
			String[] ident_string=e.getInventory().getTitle().substring(e.getInventory().getTitle().indexOf("#")).replace("#", "").split("_");
			//We are going to save the contents of this inventory appropriately.
			FileConfiguration f = this.plugin.reloadBookshelfConfig(Integer.valueOf(ident_string[0]),Integer.valueOf(ident_string[1]),Integer.valueOf(ident_string[2]));
			for (int i=0;i<e.getInventory().getContents().length;i++) {
				f.set("item-"+i, e.getInventory().getItem(i));
			}
			this.plugin.saveBookshelfConfig(f, Integer.valueOf(ident_string[0]),Integer.valueOf(ident_string[1]),Integer.valueOf(ident_string[2]));
		} else 
		if (e.getInventory().getName().contains("Item Cube")) {
			int identifier=-1;
			//Get idenfitier.
			String ident_string=e.getInventory().getTitle().substring(e.getInventory().getTitle().indexOf("#")).replace("#", "");
			identifier=Integer.valueOf(ident_string);
			if (identifier==-1) {
				Bukkit.getLogger().severe("SEVERE error when saving Item Cube contents! Could not get ID!");
				return;
			}
			//Do an item cube load, just to be safe.
			//ItemCube_load(p, identifier, Cube.LARGE);
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
				savefile.set(p.getName().toLowerCase()+".settings.notify1", Boolean.valueOf(e.getInventory().getItem(2).getType()==Material.REDSTONE_TORCH_ON));
				savefile.set(p.getName().toLowerCase()+".settings.notify2", Boolean.valueOf(e.getInventory().getItem(6).getType()==Material.REDSTONE_TORCH_ON));
				savefile.set(p.getName().toLowerCase()+".settings.notify3", Boolean.valueOf(e.getInventory().getItem(11).getType()==Material.REDSTONE_TORCH_ON));
				savefile.set(p.getName().toLowerCase()+".settings.notify4", Boolean.valueOf(e.getInventory().getItem(15).getType()==Material.REDSTONE_TORCH_ON));
				savefile.set(p.getName().toLowerCase()+".settings.notify5", Boolean.valueOf(e.getInventory().getItem(20).getType()==Material.REDSTONE_TORCH_ON));
				savefile.set(p.getName().toLowerCase()+".settings.notify6", Boolean.valueOf(e.getInventory().getItem(24).getType()==Material.REDSTONE_TORCH_ON));
				//this.plugin.saveAccountsConfig();
			}
		if (e.getInventory().getTitle().equalsIgnoreCase("Repair and Enchant")) {
			// We have to return the items the player placed inside the anvil
			// interface.
			for (int i = 10; i < 16; i += 2) {
				if (e.getInventory().getItem(i) != null
						&& e.getInventory().getItem(i).getType() != Material.AIR) {
					p.getWorld().dropItemNaturally(p.getLocation(),
							e.getInventory().getItem(i));
				}
			}
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
	public void onSprintToggle(PlayerToggleSprintEvent event) {
		Player p = event.getPlayer();
		
		if (p.getInventory().getLeggings() != null && p.getInventory().getLeggings().hasItemMeta() && p.getInventory().getLeggings().getItemMeta().getLore() != null) { // Screw null pointer exceptions
			for(String s : p.getInventory().getLeggings().getItemMeta().getLore()) {
				// Check for hyper sprint modifier (admins). If it exists, give Speed V to player.
				if (s.contains(ChatColor.AQUA+"Hyper sprint")) {
					if (event.isSprinting()) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 10));
					}
				}
			}
		}
	}

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent event) {
		Player p = (Player)event.getWhoClicked();
		p.getScoreboard().getTeam(p.getName().toLowerCase()).setPrefix(ChatColor.DARK_GRAY+"");
		if (p.hasPermission("group.moderator")) {
			p.getScoreboard().getTeam(p.getName().toLowerCase()).setPrefix(ChatColor.DARK_GREEN+"");
		}
		if (p.hasPermission("group.administrators")) {
			p.getScoreboard().getTeam(p.getName().toLowerCase()).setPrefix(ChatColor.DARK_PURPLE+"");
		}
		
		//*****************************// Job buffs here
		if (event.getInventory().getType()==InventoryType.BREWING && event.getSlot()==3) {
			//Check if the brewing stand can start up.
			ItemStack pot1 = null;
			ItemStack pot2 = null;
			ItemStack pot3 = null;
			if (event.getCursor()!=null && ((event.getCursor().getType()==Material.INK_SACK && event.getCursor().getData().getData()==4) ||
					event.getCursor().getType()==Material.EYE_OF_ENDER ||
					event.getCursor().getType()==Material.SULPHUR ||
					event.getCursor().getType()==Material.REDSTONE ||
					event.getCursor().getType()==Material.GLOWSTONE_DUST ||
					event.getCursor().getType()==Material.BLAZE_ROD ||
					event.getCursor().getType()==Material.OBSIDIAN ||
					event.getCursor().getType()==Material.WATER)) {
					event.setResult(Result.ALLOW);
					//p.updateInventory();
					//Subtract 1 from cursor.
					//If the item matches or it's blank.
					if (event.getInventory().getItem(3)!=null) {
						if (event.getClick()==ClickType.LEFT && event.getAction()!=InventoryAction.COLLECT_TO_CURSOR) {
							if (event.getInventory().getItem(3).getType()==event.getCursor().getType() || event.getInventory().getItem(3).getType()==Material.AIR) {
								int amt = event.getInventory().getItem(3).getAmount();
								if (amt+event.getCursor().getAmount()>event.getInventory().getItem(3).getMaxStackSize()) {
									//We have to split it, and put some back on the cursor.
									int leftover = amt+event.getCursor().getAmount()-event.getInventory().getItem(3).getMaxStackSize();
									ItemStack newamt = event.getInventory().getItem(3).clone();
									ItemStack newamt2 = event.getInventory().getItem(3).clone(); newamt2.setAmount(event.getInventory().getItem(3).getMaxStackSize());
									newamt.setAmount(leftover);
									event.getInventory().setItem(3, newamt2);
									event.setCursor(newamt);
									event.setResult(Result.ALLOW);
								} else {
									//Just transfer it all.
									event.getInventory().setItem(3, event.getCursor());
									event.setCursor(new ItemStack(Material.AIR));
									event.setResult(Result.ALLOW);
								}
							} else {
								//Swap them.
								ItemStack swap = event.getInventory().getItem(3).clone();
								event.getInventory().setItem(3, event.getCursor());
								event.setCursor(swap);
								event.setResult(Result.ALLOW);
							}
						} else 
						if (event.getClick()==ClickType.RIGHT) {
							if (event.getInventory().getItem(3).getType()==event.getCursor().getType() || event.getInventory().getItem(3).getType()==Material.AIR) {
								int amt = event.getInventory().getItem(3).getAmount();
								if (amt+1>event.getInventory().getItem(3).getMaxStackSize()) {
									//We have to split it, and put some back on the cursor.
									int leftover = amt+1-event.getInventory().getItem(3).getMaxStackSize();
									ItemStack newamt = event.getInventory().getItem(3).clone();
									ItemStack newamt2 = event.getInventory().getItem(3).clone(); newamt2.setAmount(event.getInventory().getItem(3).getMaxStackSize());
									newamt.setAmount(leftover);
									event.getInventory().setItem(3, newamt2);
									event.setCursor(newamt);
									event.setResult(Result.ALLOW);
								} else {
									//Just transfer 1.
									ItemStack curs = event.getCursor().clone();
									ItemStack inven = event.getInventory().getItem(3).clone();
									curs.setAmount(curs.getAmount()-1);
									inven.setAmount(inven.getAmount()+1);
									event.getInventory().setItem(3, inven);
									event.setCursor(curs);
									event.setResult(Result.ALLOW);
								}
							} else {
								//Swap them.
								ItemStack swap = event.getInventory().getItem(3).clone();
								event.getInventory().setItem(3, event.getCursor());
								event.setCursor(swap);
								event.setResult(Result.ALLOW);
							}
						}
					} else {
						if (event.getClick()==ClickType.LEFT) {
							event.getInventory().setItem(3, event.getCursor());
							event.setCursor(new ItemStack(Material.AIR));
							event.setResult(Result.ALLOW);
						} else 
						if (event.getClick()==ClickType.RIGHT) {
							if (event.getCursor().getAmount()==1) {
								event.getInventory().setItem(3, event.getCursor());
								event.setCursor(new ItemStack(Material.AIR));
								event.setResult(Result.ALLOW);
							} else {
								ItemStack curs = event.getCursor().clone(); curs.setAmount(curs.getAmount()-1);
								ItemStack curs2 = event.getCursor().clone(); curs2.setAmount(1);
								event.getInventory().setItem(3, curs2);
								event.setCursor(curs);
								event.setResult(Result.ALLOW);
							}
						}
					}
					p.updateInventory();
					event.setCancelled(true);
			}
			if (event.getInventory().getItem(3)!=null) {
				if ((event.getInventory().getItem(0)!=null && event.getInventory().getItem(0).getType()==Material.POTION)) {
					pot1 = event.getInventory().getItem(0);
				}
				if ((event.getInventory().getItem(1)!=null && event.getInventory().getItem(1).getType()==Material.POTION)) {
					pot2 = event.getInventory().getItem(1);
				}
				if ((event.getInventory().getItem(2)!=null && event.getInventory().getItem(2).getType()==Material.POTION)) {
					pot3 = event.getInventory().getItem(2);
				}
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB5) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 0; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"Teleports shooter to target"; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==0) {brew=true;}
				if (pot2!=null && pot2.getDurability()==0) {brew=true;}
				if (pot3!=null && pot3.getDurability()==0) {brew=true;}
				Bukkit.getLogger().info("Checking in slot 3: "+event.getInventory().getItem(3).toString());
				if (event.getInventory().getItem(3).getType()==Material.INK_SACK && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)16391);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Potion of Teleporting");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"Teleports shooter to target");
					lore.add(ChatColor.GOLD+"location.");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.updateInventory();
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					return;
				}
				//Brewing stand get.
				InventoryView brewing_stand = p.getOpenInventory();
				brewing_stand.setProperty(Property.BREW_TIME, 1);
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB10) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 16391; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"Teleports shooter to target"; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==(short)checkpot && pot1.getItemMeta().hasLore() && pot1.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot2!=null && pot2.getDurability()==(short)checkpot && pot2.getItemMeta().hasLore() && pot2.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot3!=null && pot3.getDurability()==(short)checkpot && pot3.getItemMeta().hasLore() && pot3.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (event.getInventory().getItem(3).getType()==Material.EYE_OF_ENDER && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)7);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Wondering Eye Potion");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"Drink to reveal nearby mob tags.");
					lore.add(ChatColor.GOLD+"Splash to reveal stone areas.");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					p.updateInventory();
					return;
				}
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB10) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 7; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"Drink to reveal nearby mob tags."; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==(short)checkpot && pot1.getItemMeta().hasLore() && pot1.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot2!=null && pot2.getDurability()==(short)checkpot && pot2.getItemMeta().hasLore() && pot2.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot3!=null && pot3.getDurability()==(short)checkpot && pot3.getItemMeta().hasLore() && pot3.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (event.getInventory().getItem(3).getType()==Material.SULPHUR && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)16395);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Splash Potion of Wondering Eye");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"Drink to reveal nearby mob tags.");
					lore.add(ChatColor.GOLD+"Splash to reveal stone areas.");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					p.updateInventory();
					return;
				}
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB30B) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 8201; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"Drink to reveal nearby mob tags."; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==(short)checkpot) {brew=true;}
				if (pot2!=null && pot2.getDurability()==(short)checkpot) {brew=true;}
				if (pot3!=null && pot3.getDurability()==(short)checkpot) {brew=true;}
				if (event.getInventory().getItem(3).getType()==Material.BLAZE_ROD && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)11);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Potion of Fury");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"+50% Attack Speed (1:30)");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					p.updateInventory();
					return;
				}
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB30B) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 11; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"+50% Attack Speed (1:30)"; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==(short)checkpot && pot1.getItemMeta().hasLore() && pot1.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot2!=null && pot2.getDurability()==(short)checkpot && pot2.getItemMeta().hasLore() && pot2.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot3!=null && pot3.getDurability()==(short)checkpot && pot3.getItemMeta().hasLore() && pot3.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (event.getInventory().getItem(3).getType()==Material.SULPHUR && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)16399);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Splash Potion of Fury");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"+50% Attack Speed (1:20)");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					p.updateInventory();
					return;
				}
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB30B) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 11; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"+50% Attack Speed (1:30)"; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==(short)checkpot && pot1.getItemMeta().hasLore() && pot1.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot2!=null && pot2.getDurability()==(short)checkpot && pot2.getItemMeta().hasLore() && pot2.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot3!=null && pot3.getDurability()==(short)checkpot && pot3.getItemMeta().hasLore() && pot3.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (event.getInventory().getItem(3).getType()==Material.GLOWSTONE_DUST && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)15);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Potion of Fury");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"+150% Attack Speed (0:45)");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					p.updateInventory();
					return;
				}
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB30B) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 11; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"+50% Attack Speed (1:30)"; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==(short)checkpot && pot1.getItemMeta().hasLore() && pot1.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot2!=null && pot2.getDurability()==(short)checkpot && pot2.getItemMeta().hasLore() && pot2.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot3!=null && pot3.getDurability()==(short)checkpot && pot3.getItemMeta().hasLore() && pot3.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (event.getInventory().getItem(3).getType()==Material.REDSTONE && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)23);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Potion of Fury");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"+50% Attack Speed (3:15)");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					p.updateInventory();
					return;
				}
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB30B) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 23; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"+50% Attack Speed (3:15)"; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==(short)checkpot && pot1.getItemMeta().hasLore() && pot1.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot2!=null && pot2.getDurability()==(short)checkpot && pot2.getItemMeta().hasLore() && pot2.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot3!=null && pot3.getDurability()==(short)checkpot && pot3.getItemMeta().hasLore() && pot3.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (event.getInventory().getItem(3).getType()==Material.SULPHUR && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)23);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Splash Potion of Fury");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"+50% Attack Speed (2:30)");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					p.updateInventory();
					return;
				}
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB30B) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 15; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"+150% Attack Speed (0:45)"; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==(short)checkpot && pot1.getItemMeta().hasLore() && pot1.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot2!=null && pot2.getDurability()==(short)checkpot && pot2.getItemMeta().hasLore() && pot2.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot3!=null && pot3.getDurability()==(short)checkpot && pot3.getItemMeta().hasLore() && pot3.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (event.getInventory().getItem(3).getType()==Material.SULPHUR && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)16403);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Splash Potion of Fury");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"+150% Attack Speed (0:30)");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					p.updateInventory();
					return;
				}
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB30B) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 8197; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"+150% Attack Speed (0:45)"; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==(short)checkpot) {brew=true;}
				if (pot2!=null && pot2.getDurability()==(short)checkpot) {brew=true;}
				if (pot3!=null && pot3.getDurability()==(short)checkpot) {brew=true;}
				if (event.getInventory().getItem(3).getType()==Material.OBSIDIAN && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)27);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Potion of Resistance");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"+20% Damage Resistance (2:00)");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					p.updateInventory();
					return;
				}
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB30B) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 27; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"+20% Damage Resistance (2:00)"; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==(short)checkpot && pot1.getItemMeta().hasLore() && pot1.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot2!=null && pot2.getDurability()==(short)checkpot && pot2.getItemMeta().hasLore() && pot2.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot3!=null && pot3.getDurability()==(short)checkpot && pot3.getItemMeta().hasLore() && pot3.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (event.getInventory().getItem(3).getType()==Material.SULPHUR && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)16411);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Splash Potion of Resistance");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"+20% Damage Resistance (1:45)");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					p.updateInventory();
					return;
				}
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB30B) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 27; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"+20% Damage Resistance (2:00)"; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==(short)checkpot && pot1.getItemMeta().hasLore() && pot1.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot2!=null && pot2.getDurability()==(short)checkpot && pot2.getItemMeta().hasLore() && pot2.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot3!=null && pot3.getDurability()==(short)checkpot && pot3.getItemMeta().hasLore() && pot3.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (event.getInventory().getItem(3).getType()==Material.GLOWSTONE_DUST && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)31);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Potion of Resistance");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"+40% Damage Resistance (1:20)");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					p.updateInventory();
					return;
				}
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB30B) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 31; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"+40% Damage Resistance (1:20)"; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==(short)checkpot && pot1.getItemMeta().hasLore() && pot1.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot2!=null && pot2.getDurability()==(short)checkpot && pot2.getItemMeta().hasLore() && pot2.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot3!=null && pot3.getDurability()==(short)checkpot && pot3.getItemMeta().hasLore() && pot3.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (event.getInventory().getItem(3).getType()==Material.SULPHUR && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)16415);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Splash Potion of Resistance");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"+40% Damage Resistance (1:00)");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					p.updateInventory();
					return;
				}
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB30B) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 27; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"+20% Damage Resistance (2:00)"; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==(short)checkpot && pot1.getItemMeta().hasLore() && pot1.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot2!=null && pot2.getDurability()==(short)checkpot && pot2.getItemMeta().hasLore() && pot2.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot3!=null && pot3.getDurability()==(short)checkpot && pot3.getItemMeta().hasLore() && pot3.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (event.getInventory().getItem(3).getType()==Material.REDSTONE && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)39);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Potion of Resistance");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"+20% Damage Resistance (3:50)");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					p.updateInventory();
					return;
				}
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB30B) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 39; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"+20% Damage Resistance (3:50)"; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==(short)checkpot && pot1.getItemMeta().hasLore() && pot1.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot2!=null && pot2.getDurability()==(short)checkpot && pot2.getItemMeta().hasLore() && pot2.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot3!=null && pot3.getDurability()==(short)checkpot && pot3.getItemMeta().hasLore() && pot3.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (event.getInventory().getItem(3).getType()==Material.SULPHUR && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)16423);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Splash Potion of Resistance");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"+20% Damage Resistance (2:45)");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					p.updateInventory();
					return;
				}
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB40) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 0; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"+20% Damage Resistance (3:50)"; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==(short)checkpot) {brew=true;}
				if (pot2!=null && pot2.getDurability()==(short)checkpot) {brew=true;}
				if (pot3!=null && pot3.getDurability()==(short)checkpot) {brew=true;}
				if (event.getInventory().getItem(3).getType()==Material.WATER && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)43);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Potion of Invulnerability");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"Protected from all damage");
					lore.add(ChatColor.GOLD+"sources. (1:20)");
					lore.add(ChatColor.DARK_GRAY+"Potion duration cannot be modified.");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					p.updateInventory();
					return;
				}
			}
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB40) &&
					(pot1!=null ||
					pot2!=null ||
					pot3!=null)) {
				//There is potentially a brew that will happen.
				//Try to brew a Teleport Potion.
				boolean brew=false;
				short checkpot = 43; //The number of the potion to check for conversion.
				String checkstring = ChatColor.GOLD+"sources. (1:20)"; //The string to look for to check for the potion.
				if (pot1!=null && pot1.getDurability()==(short)checkpot && pot1.getItemMeta().hasLore() && pot1.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot2!=null && pot2.getDurability()==(short)checkpot && pot1.getItemMeta().hasLore() && pot1.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (pot3!=null && pot3.getDurability()==(short)checkpot && pot1.getItemMeta().hasLore() && pot1.getItemMeta().getLore().contains(checkstring)) {brew=true;}
				if (event.getInventory().getItem(3).getType()==Material.SULPHUR && brew) {
					ItemStack pot = new ItemStack(Material.POTION);
					pot.setDurability((short)16427);
					List<String> lore = new ArrayList<String>();
					ItemMeta meta=pot.getItemMeta();
					meta.setDisplayName("Splash Potion of Invulnerability");
					pot.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1);
					lore.add("");
					lore.add("Custom Effects: ");
					lore.add(ChatColor.GOLD+"Protected from all damage");
					lore.add(ChatColor.GOLD+"sources. (0:55)");
					lore.add(ChatColor.DARK_GRAY+"Potion duration cannot be modified.");
					meta.setLore(lore);
					pot.setItemMeta(meta);
					if (pot1!=null && pot1.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot1.getAmount());event.getInventory().setItem(0, t);
					}
					if (pot2!=null && pot2.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot2.getAmount());event.getInventory().setItem(1, t);
					}
					if (pot3!=null && pot3.getDurability()==checkpot) {
						ItemStack t = pot.clone();t.setAmount(pot3.getAmount());event.getInventory().setItem(2, t);
					}
					if (event.getInventory().getItem(3).getAmount()==1) {
						event.getInventory().setItem(3, new ItemStack(Material.AIR));
					} else {
						ItemStack newstack = event.getInventory().getItem(3);
						newstack.setAmount(newstack.getAmount()-1);
						event.getInventory().setItem(3, newstack);
					}
					p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 0.6f, 1.0f);
					p.updateInventory();
					return;
				}
			}
				//Brewing stand get.
				InventoryView brewing_stand = p.getOpenInventory();
				brewing_stand.setProperty(Property.BREW_TIME, 1);
			}
		//Bukkit.getLogger().info("Click type is "+event.getClick().name());
		if (event.getSlotType()==SlotType.RESULT && (event.getInventory().getType()==InventoryType.CRAFTING || event.getInventory().getType()==InventoryType.PLAYER || event.getInventory().getType()==InventoryType.WORKBENCH)) {
			//Check if level 5 digger.
			if ((this.plugin.hasJobBuff("Digger", p, Job.JOB5) || this.plugin.hasJobBuff("Digger", p, Job.JOB40)) && event.getCurrentItem().getType()==Material.CLAY_BALL) {
				//This could potentially be an artifact. Check the lore.
				ItemStack result = event.getInventory().getItem(event.getSlot());
				if (result.hasItemMeta() && result.getItemMeta().hasLore()) {
					if (result.getItemMeta().getLore().contains("This clump of material seems to")) {
						//This is an artifact. There is a 7.5% chance of it turning into an equipment.
						double identifychance = 0.075;
						if (this.plugin.hasJobBuff("Digger", p, Job.JOB40)) {
							identifychance = 1.0;
						}
						if (Math.random()<=identifychance) {
							p.sendMessage(ChatColor.LIGHT_PURPLE+"You feel a magical presence convert before you.");
							event.setCurrentItem(this.plugin.convertArtifact(result.clone()));
						} else {
							p.sendMessage(ChatColor.DARK_GRAY+"The air remains unstirred.");
						}
					}
				}
			}
		}
		//****************************//End job buffs.
		
		if (event.getCursor()!=null || event.getCurrentItem()!=null) {
			if (event.getCursor().getType()==Material.SULPHUR) {
				//This is a broken Halloween item...Maybe. Let's find out.
				boolean is_halloween=false;
				String storename="";
				long time=0;
				int repairline=0;
				ItemStack store = new ItemStack(Material.SULPHUR);
				if (event.getCursor()!=null) {
					store = event.getCursor();
				} else {
					store = event.getCurrentItem();
				}
				if (store.hasItemMeta() && store.getItemMeta().hasLore()) {
					storename=store.getItemMeta().getDisplayName();
					List<String> storelore = store.getItemMeta().getLore();
					for (int i=0;i<storelore.size();i++) {
						if (storelore.get(i).contains(ChatColor.YELLOW+"[Halloween]")) {
							is_halloween=true;
						}
						if (storelore.get(i).contains("Will be repaired @ ")) {
							time = Long.valueOf(storelore.get(i).replace("Will be repaired @ ", ""));
							repairline=i;
						}
					}
				}
				if (time<Main.SERVER_TICK_TIME && is_halloween && repairline>0) {
					if (storename.contains("Diamond Chestplate")) {
						store.setType(Material.DIAMOND_CHESTPLATE);
						ItemMeta meta = store.getItemMeta();
						meta.setDisplayName(meta.getDisplayName().replace(ChatColor.DARK_GRAY+"[BROKEN] ",""));
						List<String> lore = store.getItemMeta().getLore();
						lore.remove(repairline);
						lore.remove(repairline-1);
						meta.setLore(lore);
						store.setItemMeta(meta);
						p.sendMessage("Your "+meta.getDisplayName()+ChatColor.RESET+" has been repaired!");
					}
					if (storename.contains("Diamond Leggings")) {
						store.setType(Material.DIAMOND_LEGGINGS);
						ItemMeta meta = store.getItemMeta();
						meta.setDisplayName(meta.getDisplayName().replace(ChatColor.DARK_GRAY+"[BROKEN] ",""));
						List<String> lore = store.getItemMeta().getLore();
						lore.remove(repairline);
						lore.remove(repairline-1);
						meta.setLore(lore);
						store.setItemMeta(meta);
						p.sendMessage("Your "+meta.getDisplayName()+ChatColor.RESET+" has been repaired!");
					}
					if (storename.contains("Diamond Helmet")) {
						store.setType(Material.DIAMOND_HELMET);
						ItemMeta meta = store.getItemMeta();
						meta.setDisplayName(meta.getDisplayName().replace(ChatColor.DARK_GRAY+"[BROKEN] ",""));
						List<String> lore = store.getItemMeta().getLore();
						lore.remove(repairline);
						lore.remove(repairline-1);
						meta.setLore(lore);
						store.setItemMeta(meta);
						p.sendMessage("Your "+meta.getDisplayName()+ChatColor.RESET+" has been repaired!");
					}
					if (storename.contains("Diamond Boots")) {
						store.setType(Material.DIAMOND_BOOTS);
						ItemMeta meta = store.getItemMeta();
						meta.setDisplayName(meta.getDisplayName().replace(ChatColor.DARK_GRAY+"[BROKEN] ",""));
						List<String> lore = store.getItemMeta().getLore();
						lore.remove(repairline);
						lore.remove(repairline-1);
						meta.setLore(lore);
						store.setItemMeta(meta);
						p.sendMessage("Your "+meta.getDisplayName()+ChatColor.RESET+" has been repaired!");
					}
					if (storename.contains("Diamond Sword")) {
						store.setType(Material.DIAMOND_SWORD);
						ItemMeta meta = store.getItemMeta();
						meta.setDisplayName(meta.getDisplayName().replace(ChatColor.DARK_GRAY+"[BROKEN] ",""));
						List<String> lore = store.getItemMeta().getLore();
						lore.remove(repairline);
						lore.remove(repairline-1);
						meta.setLore(lore);
						store.setItemMeta(meta);
						p.sendMessage("Your "+meta.getDisplayName()+ChatColor.RESET+" has been repaired!");
					}
					if (storename.contains("Bow")) {
						store.setType(Material.BOW);
						ItemMeta meta = store.getItemMeta();
						meta.setDisplayName(meta.getDisplayName().replace(ChatColor.DARK_GRAY+"[BROKEN] ",""));
						List<String> lore = store.getItemMeta().getLore();
						lore.remove(repairline);
						lore.remove(repairline-1);
						meta.setLore(lore);
						store.setItemMeta(meta);
						p.sendMessage("Your "+meta.getDisplayName()+ChatColor.RESET+" has been repaired!");
					}
				}
			}
		}
		if ((event.getClick()==ClickType.LEFT || event.getClick()==ClickType.RIGHT)) {
			if (this.plugin.hasJobBuff("Brewer", p, Job.JOB20) || this.plugin.hasJobBuff("Brewer", p, Job.JOB40)) {
				if (event.getCursor()!=null && event.getCurrentItem()!=null && event.getCursor().getDurability()==event.getCurrentItem().getDurability() && event.getCursor().getType().equals(event.getCurrentItem().getType()) && event.getCursor().getType()==Material.POTION) {
					if (this.plugin.hasJobBuff("Brewer", p, Job.JOB40) && event.getCursor().getAmount()+event.getCurrentItem().getAmount()<=64/*Make sure their amounts check out.*/) {
						ItemStack i = event.getCurrentItem();
						i.setAmount(event.getCursor().getAmount()+event.getCurrentItem().getAmount());
						event.setCurrentItem(new ItemStack(Material.AIR));
						event.setCursor(i);
						p.updateInventory();
					} else
					if (this.plugin.hasJobBuff("Brewer", p, Job.JOB20) && event.getCursor().getAmount()+event.getCurrentItem().getAmount()<=this.plugin.getJobLv("Brewer", p)+4-20/*Make sure their amounts check out.*/) {
						ItemStack i = event.getCurrentItem();
						i.setAmount(event.getCursor().getAmount()+event.getCurrentItem().getAmount());
						event.setCurrentItem(new ItemStack(Material.AIR));
						event.setCursor(i);
						p.updateInventory();
					} else {
						if (this.plugin.hasJobBuff("Brewer", p, Job.JOB40)) {
							//At least put what we can together.
							int leftover = event.getCursor().getAmount()+event.getCurrentItem().getAmount()-(64);
							//Bukkit.getLogger().info((event.getCursor().getAmount()+event.getCurrentItem().getAmount())+" is too high. Exceeds "+(this.plugin.getJobLv("Brewer", p)+4-20)+". LEftover is "+leftover+".");
							ItemStack temp = event.getCursor();
							temp.setAmount(64);
							event.setCursor(temp);
							ItemStack temp2 = event.getCursor().clone();
							temp2.setAmount(leftover);
							event.setCurrentItem(temp2);
							p.updateInventory();
							event.setCancelled(true);
						} else 
						if (this.plugin.hasJobBuff("Brewer", p, Job.JOB20)) {
							//At least put what we can together.
							int leftover = event.getCursor().getAmount()+event.getCurrentItem().getAmount()-(this.plugin.getJobLv("Brewer", p)+4-20);
							//Bukkit.getLogger().info((event.getCursor().getAmount()+event.getCurrentItem().getAmount())+" is too high. Exceeds "+(this.plugin.getJobLv("Brewer", p)+4-20)+". LEftover is "+leftover+".");
							ItemStack temp = event.getCursor();
							temp.setAmount(this.plugin.getJobLv("Brewer", p)+4-20);
							event.setCursor(temp);
							ItemStack temp2 = event.getCursor().clone();
							temp2.setAmount(leftover);
							event.setCurrentItem(temp2);
							p.updateInventory();
							event.setCancelled(true);
						}
					}
				}
				else
				if (this.plugin.hasJobBuff("Brewer", p, Job.JOB20) && event.getCursor()!=null && event.getCurrentItem()!=null && event.getCursor().getType().equals(event.getCurrentItem().getType()) && event.getCursor().getType()==Material.POTION) {
					//Literally swap them and cancel.
					ItemStack temp = event.getCursor();
					event.setCursor(event.getCurrentItem());
					event.setCurrentItem(temp);
					event.setCancelled(true);
				}
			} else {
				if (event.getCursor()!=null && event.getCurrentItem()!=null && event.getCursor().getDurability()==event.getCurrentItem().getDurability() && event.getCursor().getType().equals(event.getCurrentItem().getType()) && event.getCursor().getDurability()==event.getCurrentItem().getDurability() && event.getCursor().getType()==Material.POTION && event.getCurrentItem().getAmount()==1 && event.getCursor().getAmount()==1 && this.plugin.hasJobBuff("Brewer", p, Job.JOB10)) {
					//Combine them together.
					ItemStack i = event.getCurrentItem();
					i.setAmount(2);
					event.setCurrentItem(new ItemStack(Material.AIR));
					event.setCursor(i);
					p.updateInventory();
				}
				else
				if (event.getCursor()!=null && event.getCurrentItem()!=null && event.getCursor().getType().equals(event.getCurrentItem().getType()) && event.getCursor().getType()==Material.POTION) {
					//Literally swap them and cancel.
					ItemStack temp = event.getCursor();
					event.setCursor(event.getCurrentItem());
					event.setCurrentItem(temp);
					event.setCancelled(true);
				}
			}
		}
		if ((event.getClick()==ClickType.SHIFT_RIGHT || event.getClick()==ClickType.SHIFT_LEFT) && (event.getInventory().getType()==InventoryType.WORKBENCH || event.getInventory().getType()==InventoryType.CRAFTING || event.getInventory().getType()==InventoryType.PLAYER) && event.getSlotType()==SlotType.RESULT) {
			//Always refresh your inventory after a delay, just in case. This is a temporary fix for bugs with crafting multiple amounts of a crafting recipe.
			final Player p2 = p;
			p.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				@Override
				public void run() {
					p2.updateInventory();
				}
			}, 1);
		}
		//Bukkit.getLogger().info("Click type is "+event.getClick().toString());
		if (isViewingBookshelf(p) && (event.getClick()==ClickType.NUMBER_KEY || ((event.getClick()==ClickType.SHIFT_LEFT || event.getClick()==ClickType.SHIFT_RIGHT) && event.getCurrentItem()!=null && event.getCurrentItem().getType()!=Material.AIR) || ((event.getClick()==ClickType.LEFT || event.getClick()==ClickType.RIGHT) && event.getRawSlot()<9 && ((event.getCursor()!=null && event.getCursor().getType()!=Material.AIR) || (event.getCurrentItem()!=null && event.getCurrentItem().getType()!=Material.AIR)))) ) {
			boolean item_cube=false;
			//Bukkit.getLogger().info("Got to 1.");
			if ((event.getClick()==ClickType.LEFT || event.getClick()==ClickType.RIGHT) && (event.getCurrentItem().getType()==Material.CHEST || event.getCurrentItem().getType()==Material.TRAPPED_CHEST || event.getCurrentItem().getType()==Material.ENDER_CHEST)) {
				int identifier=-1;
				//Bukkit.getLogger().info("Got to 2.");
				if (event.getCurrentItem().getItemMeta().getLore()!=null) {
					//Check to see if the Lore contains anything.
					for (int i=0;i<event.getCurrentItem().getItemMeta().getLore().size();i++) {
						if (event.getCurrentItem().getItemMeta().getLore().get(i).contains("ID#")) {
							identifier=Integer.valueOf(event.getCurrentItem().getItemMeta().getLore().get(i).replace("ID#", ""));
						}
					}
					if (identifier!=-1) {
						//Bukkit.getLogger().info("Got to 2.5.");
						//This is an item cube. We will not continue.
						item_cube=true;
					}
				}
			}
			if (!item_cube || (item_cube && (event.getClick()!=ClickType.RIGHT && (event.getCursor()==null || event.getCursor().getType()==Material.AIR)))) {
				//Bukkit.getLogger().info("Got to 3.");
				if (this.plugin.book_shelf_active) {
					final Player p2 = p;
					this.plugin.book_shelf_active=false;
					int inven_amount=0, inven_items=0;
					for (int i=0;i<9;i++) {
						if (event.getInventory().getContents()[i]!=null) {
							inven_amount+=event.getInventory().getContents()[i].getAmount();
							inven_items++;
							//Bukkit.getLogger().info("Check at "+event.getInventory().getContents()[i].toString());
						}
					}
					//Bukkit.getLogger().info("Marked at "+inven_amount+".");
					Bookshelf_attemptUpdate(inven_amount,inven_items,p2);
				} else {
					//Bukkit.getLogger().info("Cannot perform! We are waiting on an update.");
					event.setCancelled(true);
					event.setResult(Result.DENY);
				}
			}
		}
		if (isViewingEnderCube(p) && (event.getClick()==ClickType.NUMBER_KEY || ((event.getClick()==ClickType.SHIFT_LEFT || event.getClick()==ClickType.SHIFT_RIGHT) && event.getCurrentItem()!=null && event.getCurrentItem().getType()!=Material.AIR) || ((event.getClick()==ClickType.LEFT || event.getClick()==ClickType.RIGHT) && event.getRawSlot()<27 && ((event.getCursor()!=null && event.getCursor().getType()!=Material.AIR) || (event.getCurrentItem()!=null && event.getCurrentItem().getType()!=Material.AIR)))) ) {
			boolean item_cube=false;
			//Bukkit.getLogger().info("Got to 1.");
			if (event.getClick()==ClickType.LEFT && (event.getCurrentItem().getType()==Material.CHEST || event.getCurrentItem().getType()==Material.TRAPPED_CHEST || event.getCurrentItem().getType()==Material.ENDER_CHEST)) {
				int identifier=-1;
				//Bukkit.getLogger().info("Got to 2.");
				if (event.getCurrentItem().getItemMeta().getLore()!=null) {
					//Check to see if the Lore contains anything.
					for (int i=0;i<event.getCurrentItem().getItemMeta().getLore().size();i++) {
						if (event.getCurrentItem().getItemMeta().getLore().get(i).contains("ID#")) {
							identifier=Integer.valueOf(event.getCurrentItem().getItemMeta().getLore().get(i).replace("ID#", ""));
						}
					}
					if (identifier!=-1) {
						//Bukkit.getLogger().info("Got to 2.5.");
						//This is an item cube. We will not continue.
						item_cube=true;
					}
				}
			}
			if (!item_cube || (item_cube && (event.getClick()!=ClickType.RIGHT && (event.getCursor()==null || event.getCursor().getType()==Material.AIR)))) {
				//Bukkit.getLogger().info("Got to 3.");
				if (this.plugin.ender_cube_active) {
					final Player p2 = p;
					this.plugin.ender_cube_active=false;
					int inven_amount=0, inven_items=0;
					for (int i=0;i<27;i++) {
						if (event.getInventory().getContents()[i]!=null) {
							inven_amount+=event.getInventory().getContents()[i].getAmount();
							inven_items++;
							//Bukkit.getLogger().info("Check at "+event.getInventory().getContents()[i].toString());
						}
					}
					//Bukkit.getLogger().info("Marked at "+inven_amount+".");
					ItemCube_attemptUpdate(inven_amount,inven_items,p2);
				} else {
					//Bukkit.getLogger().info("Cannot perform! We are waiting on an update.");
					event.setCancelled(true);
					event.setResult(Result.DENY);
				}
			}
		}
		if (event.getCursor()!=null) {
			//Regardless of the inventory, if we try to put it inside a chest, got to try to insert it in there.
			if (event.getCurrentItem()!=null) {
				if (event.getCursor()!=null && event.getSlotType()!=SlotType.RESULT && event.getCursor().getType()!=Material.AIR && (event.getCurrentItem().getType()==Material.CHEST || event.getCurrentItem().getType()==Material.TRAPPED_CHEST || event.getCurrentItem().getType()==Material.ENDER_CHEST) && event.getClick()==ClickType.LEFT) {
					ItemStack extra_item = insertIntoItemCube(p, event.getCurrentItem(), event.getCursor());
					if (!extra_item.equals(event.getCursor())) {
						//If the items don't match, it means something happened to the items, so some got inserted into the Item Cube.
						//If they are the same, instead we will simply swap them. Normal functionality.
						event.setCursor(extra_item);
						p.updateInventory();
						event.setCancelled(true);
						return;
					}
				}
			}
		}
		if (event.getInventory().getType()==InventoryType.CRAFTING || event.getInventory().getType()==InventoryType.CHEST/*Buggy for some reason. We can't open chests in chests.*/) {
			if (event.getCurrentItem()!=null) {
				if (isItemCube(event.getCurrentItem()) && event.getClick()==ClickType.RIGHT && event.getCurrentItem().hasItemMeta()) {
					if (isItemCube(event.getCurrentItem())) {
						//Only cancel the event and view the Item Cube if it actually is one.
						viewItemCube(p, event.getCurrentItem());
						event.setCancelled(true);
						return;
					}
				}
				if (this.plugin.is_PocketWorkbench(event.getCurrentItem()) && event.getClick()==ClickType.RIGHT) {
					p.openWorkbench(null, true);
					event.setCancelled(true);
					return;
				}
				if (this.plugin.is_PocketWorkbench(event.getCurrentItem()) && event.getClick()==ClickType.RIGHT) {
					p.openWorkbench(null, true);
					event.setCancelled(true);
					return;
				}
			}
		}else
			if (event.getInventory().getType()==InventoryType.CHEST && event.getInventory().getName().contains("Item Cube")) {
				//If we click a chest, make sure it's not the same ID chest.
				if (event.getCurrentItem()!=null) {
					if ((event.getCurrentItem().getType()==Material.CHEST || event.getCurrentItem().getType()==Material.TRAPPED_CHEST || event.getCurrentItem().getType()==Material.ENDER_CHEST)) {
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
									event.setResult(Result.DENY);
									return;
								}
							}
						}
					}
				}
			} else
				if (event.getInventory().getTitle().equalsIgnoreCase("Choose an additional bonus:")) {
					if (event.getClick()==ClickType.LEFT) {
						//Select this one. Drop it on the ground.
						//Bukkit.getLogger().info("Raw slot is "+event.getRawSlot());
						if (event.getRawSlot()<18) {
							ItemStack itemselected = event.getCurrentItem();
							if (itemselected!=null && itemselected.getType()!=Material.AIR) {
								Item it = p.getWorld().dropItemNaturally(p.getLocation(), itemselected);
								it.setPickupDelay(0);
								for (int i=0;i<p.getInventory().getContents().length;i++) {
									if (p.getInventory().getContents()[i]!=null && p.getInventory().getContents()[i].hasItemMeta() &&
											p.getInventory().getContents()[i].getItemMeta().hasDisplayName() && 
											p.getInventory().getContents()[i].getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GRAY+""+ChatColor.ITALIC+"[Temporary Item]")) {
										p.getInventory().removeItem(p.getInventory().getContents()[i]);
									}
								}
								event.setCancelled(true);
								p.updateInventory();
								p.closeInventory();
							}
						} else {
							event.setCancelled(true);
							p.updateInventory();
						}
					}
				}
				if (event.getInventory().getTitle().equalsIgnoreCase("Repair and Enchant")) {
					final int INPUT = 10;
					final int MATERIALS = 12;
					final int MAGIC = 14;
					final int OUTPUT = 16;
					final int LEVELS = 22;
					boolean anvilClicked = false;

					// Bukkit.getLogger().info("Anvil interface CLICK at slot #" + event.getRawSlot());

					if (event.getRawSlot() == -999) {
						anvilClicked = false;
						// Bukkit.getLogger().info("Window exterior clicked.");
					} else if (event.getRawSlot() < 27) {
						anvilClicked = true;
						// Bukkit.getLogger().info("Anvil clicked.");
					} else {
						// Bukkit.getLogger().info("Inventory clicked.");
					}
					if (!anvilClicked) {
						// Clicked the inventory. Leave the operation alone UNLESS it's a shift-click operation.
						if (event.isShiftClick()) {
							// Call the scheduled task to validate and update the inventory
							int task=-1, tries=100;
							do {
								task = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new updateInventoryTask(event.getWhoClicked().getName()));
								tries--;
								Bukkit.getLogger().info("Trying updateInventoryTask(). tries="+tries);
							} while (task==-1 && tries>0);
							if (tries<0) {
								Bukkit.getLogger().severe("Could not updateInventoryTask() for whatever reason. Stop trying.");
								//Failed for some reason. Cancel the click instead.
								event.setCancelled(true);
								event.getWhoClicked().getInventory().setContents(event.getWhoClicked().getInventory().getContents());
								event.getInventory().setContents(event.getInventory().getContents());
								p.updateInventory();
							}
						}
					} else { 
						// Clicked the anvil. If GUI items are clicked or an invalid operation happens, cancel the operation. 
						if (event.getSlot() == INPUT || event.getSlot() == MATERIALS
								|| event.getSlot() == MAGIC || event.getSlot() == OUTPUT)
						{
							/* 
							 * OUTPUT Block
							 */

							if (event.getSlot() == OUTPUT && event.getCursor() != null && event.getCursor().getType() != Material.AIR && !matches(event.getCursor(), event.getCurrentItem())){
								// Bukkit.getLogger().info("Anvil OUTPUT click.");
								event.setCancelled(true); // Cancel the event if trying to put items into the output slot
							}

							// If click on output and it's not null, take the item and clear anvil inventory
							if (event.getInventory().getContents()[OUTPUT] != null
									&& event.getSlot() == OUTPUT) {

								// Bukkit.getLogger().info("Anvil OUTPUT click with output populated.");

								if (event.getInventory().getContents()[LEVELS].getAmount() > Bukkit.getPlayer(event.getWhoClicked().getName()).getLevel()) {
									// Player doesn't have enough XP, abort
									// Bukkit.getLogger().info("Player has insufficient XP.");
									p.sendMessage(ChatColor.RED+"You don't have enough experience to do that!");
									event.setCancelled(true);
								} else {
									// Bukkit.getLogger().info("Player has sufficient XP.");
									if (event.getCursor() != null && event.getCursor().getType() != Material.AIR) {

										// Bukkit.getLogger().info("Anvil OUTPUT click with non-null mouse. Mouse has: " + event.getCursor());

										event.setCancelled(true); // Cancel event if cursor is not empty

										if (event.isShiftClick()) {
											// Attempts to store the item in the player's inventory.
											// If it succeeds, remove the item from the anvil
											// interface.
											// Bukkit.getLogger().info("Shift-click");
											if (event
													.getWhoClicked()
													.getInventory()
													.addItem(
															event.getInventory().getContents()[OUTPUT])
															.isEmpty()) {

												// Bukkit.getLogger().info("Can place into inventory.");

												if (event.getCurrentItem().getType() == Material.ENCHANTED_BOOK && event.getInventory().getItem(MAGIC).getType() == Material.BOOK) {
													// Halve its durability
													event.getInventory().getItem(INPUT).setDurability((short)(event.getInventory().getItem(INPUT).getDurability() + (event.getInventory().getItem(INPUT).getType().getMaxDurability() - event.getInventory().getItem(INPUT).getDurability()) / 2));
													
													// DISENCHANT BEGIN
										        	  Map<Enchantment,Integer> map  = event.getInventory().getItem(INPUT).getEnchantments();
										    		  for (Map.Entry<Enchantment,Integer> entry : map.entrySet()) {
										    			  event.getInventory().getItem(INPUT).removeEnchantment(entry.getKey());
										    		  }
										    		  if (event.getInventory().getItem(INPUT).hasItemMeta() && event.getInventory().getItem(INPUT).getItemMeta().hasLore()) {
										        		  List<String> newlore = new ArrayList<String>();
										    			  for (int i=0;i<event.getInventory().getItem(INPUT).getItemMeta().getLore().size();i++) {
										    				  //Remove all lore when unenchanting.
										    				  //Do not remove -400% durability.
															  if (this.plugin.is_PermanentProperty(event.getInventory().getItem(INPUT).getItemMeta().getLore().get(i))) {
																  newlore.add(event.getInventory().getItem(INPUT).getItemMeta().getLore().get(i));
															  }
										    			  }
										    			  ItemMeta meta = event.getInventory().getItem(INPUT).getItemMeta();
										    			  meta.setLore(newlore);
										    			  event.getInventory().getItem(INPUT).setItemMeta(meta);
										    		  }
													// DISENCHANT END

													// Destroy the item if random() exceeds %remaining durability
													if (Math.random() < (double)(event.getInventory().getItem(INPUT).getType().getMaxDurability() - event.getInventory().getItem(INPUT).getDurability()) / (double)event.getInventory().getItem(INPUT).getType().getMaxDurability()) {
														event.getInventory().setItem(INPUT, new ItemStack(Material.AIR));
													}
													
												} else {
													event.getInventory().setItem(INPUT, new ItemStack(Material.AIR));
												}
												
												event.getInventory().setItem(MATERIALS, new ItemStack(Material.AIR));
												event.getInventory().setItem(MAGIC, new ItemStack(Material.AIR));

												// Set XP
												Bukkit.getPlayer(event.getWhoClicked().getName()).setLevel(Bukkit.getPlayer(event.getWhoClicked().getName()).getLevel() - event.getInventory().getContents()[LEVELS].getAmount());

												// Bukkit.getLogger().info("Item is: " + event.getInventory().getItem(OUTPUT));												

												// Play anvil sound
												if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("IRON") || 
														event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("GOLD") ||
														event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("DIAMOND") ||
														event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("CHAINMAIL")) {
													Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.BLAZE_HIT, 10, 1);
												} else if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("WOOD")) {
													Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.DIG_WOOD, 20, 1);
												} else if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("STONE")) {
													Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.DIG_STONE, 20, 1);
												} else if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("LEATHER")) {
													Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.DIG_WOOL, 20, 1);
												} else if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("BOW") || 
														event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("FISHING")) {
													Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.ARROW_HIT, 10, 1);
												} else if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("ENCHANTED")) {
													Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.LEVEL_UP, 10, 1);
												}

												event.getInventory().setItem(OUTPUT, new ItemStack(Material.AIR));
												int task=-1, tries=100;
												do {
													task = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new updateInventoryTask(event.getWhoClicked().getName()));
													tries--;
													Bukkit.getLogger().info("Trying updateInventoryTask(). tries="+tries);
												} while (task==-1 && tries>0);
												if (tries<0) {
													Bukkit.getLogger().severe("Could not updateInventoryTask() for whatever reason. Stop trying.");
													//Failed for some reason. Cancel the click instead.
													event.setCancelled(true);
													event.getWhoClicked().getInventory().setContents(event.getWhoClicked().getInventory().getContents());
													event.getInventory().setContents(event.getInventory().getContents());
													p.updateInventory();
												}
											}
										}
									} else {

										// Bukkit.getLogger().info("Anvil OUTPUT click with null mouse.");


										if (event.isShiftClick()) {
											event.setCancelled(true); // Cancel event if Shift-Click, run checks

											// Attempts to store the item in the player's inventory.
											// If it succeeds, remove the item from the anvil
											// interface.
											// Bukkit.getLogger().info("Shift-click");
											if (event
													.getWhoClicked()
													.getInventory()
													.addItem(
															event.getInventory().getContents()[OUTPUT])
															.isEmpty()) {

												// Bukkit.getLogger().info("Can place into inventory.");

												if (event.getCurrentItem().getType() == Material.ENCHANTED_BOOK && event.getInventory().getItem(MAGIC).getType() == Material.BOOK) {
													// Halve its durability and remove enchantments
													event.getInventory().getItem(INPUT).setDurability((short)(event.getInventory().getItem(INPUT).getDurability() + (event.getInventory().getItem(INPUT).getType().getMaxDurability() - event.getInventory().getItem(INPUT).getDurability()) / 2));

													// DISENCHANT BEGIN
										        	  Map<Enchantment,Integer> map  = event.getInventory().getItem(INPUT).getEnchantments();
										    		  for (Map.Entry<Enchantment,Integer> entry : map.entrySet()) {
										    			  event.getInventory().getItem(INPUT).removeEnchantment(entry.getKey());
										    		  }
										    		  if (event.getInventory().getItem(INPUT).hasItemMeta() && event.getInventory().getItem(INPUT).getItemMeta().hasLore()) {
										        		  List<String> newlore = new ArrayList<String>();
										    			  for (int i=0;i<event.getInventory().getItem(INPUT).getItemMeta().getLore().size();i++) {
										    				  //Remove all lore when unenchanting.
										    				  //Do not remove -400% durability.
															  if (this.plugin.is_PermanentProperty(event.getInventory().getItem(INPUT).getItemMeta().getLore().get(i))) {
																  newlore.add(event.getInventory().getItem(INPUT).getItemMeta().getLore().get(i));
															  }
										    			  }
										    			  ItemMeta meta = event.getInventory().getItem(INPUT).getItemMeta();
										    			  meta.setLore(newlore);
										    			  event.getInventory().getItem(INPUT).setItemMeta(meta);
										    		  }
													// DISENCHANT END

													
													// Destroy the item if random() exceeds %remaining durability
													if (Math.random() < (double)(event.getInventory().getItem(INPUT).getType().getMaxDurability() - event.getInventory().getItem(INPUT).getDurability()) / (double)event.getInventory().getItem(INPUT).getType().getMaxDurability()) {
														event.getInventory().setItem(INPUT, new ItemStack(Material.AIR));
													}
													
												} else {
													event.getInventory().setItem(INPUT, new ItemStack(Material.AIR));
												}
												event.getInventory().setItem(MATERIALS, new ItemStack(Material.AIR));
												event.getInventory().setItem(MAGIC, new ItemStack(Material.AIR));

												// Set XP
												Bukkit.getPlayer(event.getWhoClicked().getName()).setLevel(Bukkit.getPlayer(event.getWhoClicked().getName()).getLevel() - event.getInventory().getContents()[LEVELS].getAmount());

												// Play anvil sound
												if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("IRON") || 
														event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("GOLD") ||
														event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("DIAMOND") ||
														event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("CHAINMAIL")) {
													Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.BLAZE_HIT, 10, 1);
												} else if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("WOOD")) {
													Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.DIG_WOOD, 20, 1);
												} else if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("STONE")) {
													Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.DIG_STONE, 20, 1);
												} else if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("LEATHER")) {
													Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.DIG_WOOL, 20, 1);
												} else if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("BOW") || 
														event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("FISHING")) {
													Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.ARROW_HIT, 10, 1);
												} else if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("ENCHANTED")) {
													Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.LEVEL_UP, 10, 1);
												}
												

												event.getInventory().setItem(OUTPUT, new ItemStack(Material.AIR));
												int task=-1, tries=100;
												do {
													task = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new updateInventoryTask(event.getWhoClicked().getName()));
													tries--;
													Bukkit.getLogger().info("Trying updateInventoryTask(). tries="+tries);
												} while (task==-1 && tries>0);
												if (tries<0) {
													Bukkit.getLogger().severe("Could not updateInventoryTask() for whatever reason. Stop trying.");
													//Failed for some reason. Cancel the click instead.
													event.setCancelled(true);
													event.getWhoClicked().getInventory().setContents(event.getWhoClicked().getInventory().getContents());
													event.getInventory().setContents(event.getInventory().getContents());
													p.updateInventory();
												}
											}
										} else {
											// Bukkit.getLogger().info("Normal click");

											// Cursor is empty, item picked up. Subtract XP levels and remove ingredients.
											if (event.getCurrentItem().getType() == Material.ENCHANTED_BOOK && event.getInventory().getItem(MAGIC).getType() == Material.BOOK) {
												// Halve its durability
												event.getInventory().getItem(INPUT).setDurability((short)(event.getInventory().getItem(INPUT).getDurability() + (event.getInventory().getItem(INPUT).getType().getMaxDurability() - event.getInventory().getItem(INPUT).getDurability()) / 2));
												
												// DISENCHANT BEGIN
									        	  Map<Enchantment,Integer> map  = event.getInventory().getItem(INPUT).getEnchantments();
									    		  for (Map.Entry<Enchantment,Integer> entry : map.entrySet()) {
									    			  event.getInventory().getItem(INPUT).removeEnchantment(entry.getKey());
									    		  }
									    		  if (event.getInventory().getItem(INPUT).hasItemMeta() && event.getInventory().getItem(INPUT).getItemMeta().hasLore()) {
									        		  List<String> newlore = new ArrayList<String>();
									    			  for (int i=0;i<event.getInventory().getItem(INPUT).getItemMeta().getLore().size();i++) {
									    				  //Remove all lore when unenchanting.
									    				  //Do not remove -400% durability.
														  if (this.plugin.is_PermanentProperty(event.getInventory().getItem(INPUT).getItemMeta().getLore().get(i))) {
															  newlore.add(event.getInventory().getItem(INPUT).getItemMeta().getLore().get(i));
														  }
									    			  }
									    			  ItemMeta meta = event.getInventory().getItem(INPUT).getItemMeta();
									    			  meta.setLore(newlore);
									    			  event.getInventory().getItem(INPUT).setItemMeta(meta);
									    		  }
												// DISENCHANT END

									    		  // Destroy the item if random() exceeds %remaining durability
												if (Math.random() < (double)(event.getInventory().getItem(INPUT).getType().getMaxDurability() - event.getInventory().getItem(INPUT).getDurability()) / (double)event.getInventory().getItem(INPUT).getType().getMaxDurability()) {
													event.getInventory().setItem(INPUT, new ItemStack(Material.AIR));
												}
												
											} else {
												event.getInventory().setItem(INPUT, new ItemStack(Material.AIR));
											}
											event.getInventory().setItem(MATERIALS, new ItemStack(Material.AIR));
											event.getInventory().setItem(MAGIC, new ItemStack(Material.AIR));
											// event.getInventory().setItem(OUTPUT, new ItemStack(Material.AIR));

											// Set XP
											Bukkit.getPlayer(event.getWhoClicked().getName()).setLevel(Bukkit.getPlayer(event.getWhoClicked().getName()).getLevel() - event.getInventory().getContents()[LEVELS].getAmount());

											// Play anvil sound
											if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("IRON") || 
													event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("GOLD") ||
													event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("DIAMOND") ||
													event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("CHAINMAIL")) {
												Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.BLAZE_HIT, 10, 1);
											} else if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("WOOD")) {
												Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.DIG_WOOD, 20, 1);
											} else if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("STONE")) {
												Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.DIG_STONE, 20, 1);
											} else if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("LEATHER")) {
												Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.DIG_WOOL, 20, 1);
											} else if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("BOW") || 
													event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("FISHING")) {
												Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.ARROW_HIT, 10, 1);
											} else if (event.getInventory().getItem(OUTPUT).getType().toString().toUpperCase().contains("ENCHANTED")) {
												Bukkit.getPlayer(event.getWhoClicked().getName()).getWorld().playSound(Bukkit.getPlayer(event.getWhoClicked().getName()).getLocation(), Sound.LEVEL_UP, 10, 1);
											}

											int task=-1, tries=100;
											do {
												task = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new updateInventoryTask(event.getWhoClicked().getName()));
												tries--;
												Bukkit.getLogger().info("Trying updateInventoryTask(). tries="+tries);
											} while (task==-1 && tries>0);
											if (tries<0) {
												Bukkit.getLogger().severe("Could not updateInventoryTask() for whatever reason. Stop trying.");
												//Failed for some reason. Cancel the click instead.
												event.setCancelled(true);
												event.getWhoClicked().getInventory().setContents(event.getWhoClicked().getInventory().getContents());
												event.getInventory().setContents(event.getInventory().getContents());
												p.updateInventory();
											}
										}
									}

								}
							}

							boolean valid = false;

							if (event.isShiftClick() && event.getRawSlot() != OUTPUT) {
								valid = true; // always valid if shift clicking an anvil slot that isn't the output. 
							}

							if (event.getCursor() == null || event.getCursor().getType() == Material.AIR) {
								valid = true; // always valid if cursor carries nothing
							} else if (event.getSlotType() == SlotType.CONTAINER && event.getSlot() == INPUT) {

								/* 
								 * INPUT Block
								 * All tools and armor types, as well as fishing rods and bows.
								 */

								// Bukkit.getLogger().info("Anvil INPUT click with this item on mouse: " + event.getCursor().getType().toString());

								/*
								if (event.getCursor().getType().toString().toUpperCase().contains("HELMET") || event.getCursor().getType().toString().toUpperCase().contains("CHESTPLATE") || 
										event.getCursor().getType().toString().toUpperCase().contains("LEGGINGS") || event.getCursor().getType().toString().toUpperCase().contains("BOOTS") ||
										event.getCursor().getType().toString().toUpperCase().contains("PICKAXE") || event.getCursor().getType().toString().toUpperCase().contains("SPADE") || 
										event.getCursor().getType().toString().toUpperCase().contains("HOE") || event.getCursor().getType().toString().toUpperCase().contains("AXE") ||
										event.getCursor().getType().toString().toUpperCase().contains("SWORD") || event.getCursor().getType().toString().toUpperCase().contains("FISHING") || 
										event.getCursor().getType().toString().toUpperCase().contentEquals("BOW")) {
									valid = true;
								}

								if (event.getCursor().getDurability() == 0)
								{
									// Can't put fully repaired item into input slot. 
									valid = false;
								}
								 */
							} else if (event.getSlotType() == SlotType.CONTAINER && event.getSlot() == MATERIALS) {

								/* 
								 * MATERIALS Block
								 * Leather, string, wood, cobble, iron, gold, and diamond allowed.
								 */

								// Bukkit.getLogger().info("Anvil MATERIALS click with this item on mouse: " + event.getCursor().getType().toString());

								/*
								if (event.getCursor().getType() == Material.LEATHER || event.getCursor().getType() == Material.IRON_INGOT || 
										event.getCursor().getType() == Material.GOLD_INGOT || event.getCursor().getType() == Material.IRON_BLOCK || 
										event.getCursor().getType() == Material.DIAMOND_BLOCK || event.getCursor().getType() == Material.DIAMOND ||
										event.getCursor().getType() == Material.WOOD || event.getCursor().getType() == Material.COBBLESTONE || 
										event.getCursor().getType() == Material.LOG || event.getCursor().getType() == Material.STONE || 
										event.getCursor().getType() == Material.STRING) {
									valid = true;
								}
								 */
							} else if (event.getSlotType() == SlotType.CONTAINER && event.getSlot() == MAGIC) {

								/* 
								 * MAGIC Block
								 * Shards and Enchanted Books allowed.
								 * Not implemented yet, so nothing is allowed at the moment. 
								 */

								// Bukkit.getLogger().info("Anvil MAGIC click with this item on mouse: " + event.getCursor().getType().toString());

								/*
					if (event.getCursor().getType() == Material.FLINT || event.getCursor().getType() == Material.QUARTZ || 
							event.getCursor().getType() == Material.NETHER_STAR || event.getCursor().getType() == Material.ENCHANTED_BOOK) {
						valid = true;
					}
								 */
							}

							/*
							if (!valid) {
								event.setCancelled(true);
							} else {
								// Update the inventory if it is valid
								// Set up anvil inventory update scheduler
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new updateInventoryTask(event.getWhoClicked().getName()));
							}
							 */
							int task=-1, tries=100;
							do {
								task = Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new updateInventoryTask(event.getWhoClicked().getName()));
								tries--;
								Bukkit.getLogger().info("Trying updateInventoryTask(). tries="+tries);
							} while (task==-1 && tries>0);
							if (tries<0) {
								Bukkit.getLogger().severe("Could not updateInventoryTask() for whatever reason. Stop trying.");
								//Failed for some reason. Cancel the click instead.
								event.setCancelled(true);
								event.getWhoClicked().getInventory().setContents(event.getWhoClicked().getInventory().getContents());
								event.getInventory().setContents(event.getInventory().getContents());
								p.updateInventory();
							}
						} else {
							event.setCancelled(true);
						}
					}

				}  else if (event.getInventory().getName().equalsIgnoreCase("Notification Options")) {
					boolean optionsClicked;
					if (event.getRawSlot() < 27) {
						optionsClicked = true;
						// Bukkit.getLogger().info("Options clicked.");
					} else {
						optionsClicked = false;
						// Bukkit.getLogger().info("Inventory clicked.");
					}

					if (optionsClicked && (event.getSlot() % 9 == 2 || event.getSlot() % 9 == 6)) {
						if (event.getInventory().getContents()[event.getSlot()].getType()==Material.REDSTONE_TORCH_OFF) {
							event.getInventory().getContents()[event.getSlot()].setType(Material.REDSTONE_TORCH_ON);
						} else {
							event.getInventory().getContents()[event.getSlot()].setType(Material.REDSTONE_TORCH_OFF);
						}
					}
					if (optionsClicked && (event.getSlot() % 9 == 1 || event.getSlot() % 9 == 5)) {
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
		if (event.isCancelled()) {
			final Player p2 = p;
			final InventoryClickEvent e2 = event;
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new
					Runnable() {
				@Override
				public void run() {
					e2.getInventory().setContents(e2.getInventory().getContents());
					p2.getInventory().setContents(p2.getInventory().getContents());
					p2.updateInventory();
				}
			}, 1);
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
			/*
			if (this.plugin.getJobLv("Cook", p)>=10 && crafteditem==true) {
				//This is an ugly fix for the problem...But it works somehow.
				//Player newp = Bukkit.getPlayer(p.getName().toLowerCase());
				p.getInventory().addItem(new ItemStack(item.getType(),amount,item.getDurability(),item.getData().getData()));
			}*/
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
			if (item.getType()==Material.CHAINMAIL_BOOTS) {
				this.plugin.gainMoneyExp(p,"Blacksmith",0.375*0.5*amount,80*0.5*amount);
				crafteditem=true;
			}
			if (item.getType()==Material.CHAINMAIL_HELMET) {
				this.plugin.gainMoneyExp(p,"Blacksmith",0.50*0.5*amount,100*0.5*amount);
				crafteditem=true;
			}
			if (item.getType()==Material.CHAINMAIL_LEGGINGS) {
				this.plugin.gainMoneyExp(p,"Blacksmith",0.725*0.5*amount,140*0.5*amount);
				crafteditem=true;
			}
			if (item.getType()==Material.CHAINMAIL_CHESTPLATE) {
				this.plugin.gainMoneyExp(p,"Blacksmith",0.875*0.5*amount,175*0.5*amount);
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
	

	public boolean hasJobBuff(String job, String p, Job j) {
		return this.plugin.hasJobBuff(job, p, j);
	}
	
	public boolean hasJobBuff(String job, Player p, Job j) {
		return this.plugin.hasJobBuff(job, p, j);
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
				i.getType()==Material.IRON_AXE ||
				i.getType()==Material.GOLD_SPADE ||
				i.getType()==Material.GOLD_HOE ||
				i.getType()==Material.GOLD_BOOTS ||
				i.getType()==Material.GOLD_CHESTPLATE ||
				i.getType()==Material.GOLD_LEGGINGS ||
				i.getType()==Material.GOLD_HELMET ||
				i.getType()==Material.GOLD_AXE ||
				i.getType()==Material.DIAMOND_PICKAXE ||
				i.getType()==Material.DIAMOND_HOE ||
				i.getType()==Material.DIAMOND_SPADE ||
				i.getType()==Material.DIAMOND_AXE ||
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
		return this.plugin.EnchantItem(item, lv, p, true);
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
								ItemStack clone = post.clone();
								if (hasJobBuff("Weaponsmith", player.getName(), Job.JOB40) && validItem_Weaponsmith(post)) {
									ItemStack resulting = clone;
									resulting = EnchantItem(clone,25,(Player)player);
									int finalstack=1;
									while (Math.random()<=0.3) {
										finalstack++;
									}
									resulting.setAmount(finalstack);
									player.getInventory().setItem(i, resulting);
								}
								if (PlayerinJob((Player)player,"Weaponsmith")) {
									if (getJobLv("Weaponsmith", player.getName())>=10 && validItem_Weaponsmith(post)) {
										//Bukkit.getPlayer("sigonasr2").sendMessage("Valid item. Going to attempt to enchant.");
										ItemStack resulting = clone;
										if (!hasJobBuff("Weaponsmith", player.getName(), Job.JOB40)) {
											resulting = EnchantItem(clone,5,(Player)player);
										}
										if (hasJobBuff("Weaponsmith", player.getName(), Job.JOB30A)) {
											ItemMeta meta = resulting.getItemMeta();
											List<String> lore = new ArrayList<String>();
											if (meta.hasLore()) {
												lore = meta.getLore();
											}
											lore.add(ChatColor.YELLOW+"+"+(getJobLv("Weaponsmith", player.getName())-29)+" "+ChatColor.BLUE+"Damage");
											meta.setLore(lore);
											resulting.setItemMeta(meta);
										}
										if (hasJobBuff("Weaponsmith", player.getName(), Job.JOB30B)) {
											ItemMeta meta = resulting.getItemMeta();
											List<String> lore = new ArrayList<String>();
											if (meta.hasLore()) {
												lore = meta.getLore();
											}
											lore.add(ChatColor.YELLOW+"+"+((getJobLv("Weaponsmith", player.getName())-29)*2)+"% "+ChatColor.BLUE+"Lifesteal");
											meta.setLore(lore);
											resulting.setItemMeta(meta);
										}
										player.getInventory().setItem(i, resulting);
									}
								}	
								if (PlayerinJob((Player)player,"Blacksmith") || hasJobBuff("Blacksmith", (Player)player, Job.JOB40)) {
									ItemStack resulting = clone;
									if (hasJobBuff("Blacksmith", player.getName(), Job.JOB30A) && validItem_Blacksmith(post)) {
										ItemMeta meta = resulting.getItemMeta();
										List<String> lore = new ArrayList<String>();
										if (meta.hasLore()) {
											lore = meta.getLore();
										}
										lore.add(ChatColor.YELLOW+"+"+((getJobLv("Blacksmith", player.getName())-29)*2)+" "+ChatColor.BLUE+"Health");
										meta.setLore(lore);
										resulting.setItemMeta(meta);
									}
									if (hasJobBuff("Blacksmith", player.getName(), Job.JOB10) && validItem_Blacksmith(post)) {
										//Bukkit.getPlayer("sigonasr2").sendMessage("Valid item. Going to attempt to enchant.");
										resulting = EnchantItem(clone,10,(Player)player);
									} else
									if (hasJobBuff("Blacksmith", player.getName(), Job.JOB5) && validItem_Blacksmith(post)) {
										//Bukkit.getPlayer("sigonasr2").sendMessage("Valid item. Going to attempt to enchant.");
										resulting = EnchantItem(clone,5,(Player)player);
									}
									if (hasJobBuff("Blacksmith", (Player)player, Job.JOB40) && validItem_Blacksmith(post)) {
										if (Math.random()<=0.5) {
											resulting = EnchantItem(clone, 30, (Player)player);
										} else {
											resulting = EnchantItem(clone, 20, (Player)player);
										}
										resulting.setAmount((int)(Math.random()*4)+2);
									}
									player.getInventory().setItem(i, resulting);
								}
							}
							//Bukkit.getPlayer("sigonasr2").sendMessage("Item amounts differ. New count: "+newItemsCount);
						}
					}
				}

				if (newItemsCount > 0) {
					//Bukkit.getPlayer("AaMay").sendMessage(newItemsCount+" New Items have been detected.");
					if (plugin.getAccountsConfig().getBoolean(player.getName()+".settings.notify2")) {
						if (special_convert(compareItem.getType())) {
							Bukkit.getPlayer(player.getName()).sendMessage(ChatColor.DARK_AQUA+""+ChatColor.ITALIC+"Crafted "+newItemsCount+" "+convertToItemName(compareItem.getType().name(), compareItem.getData().getData(), compareItem.getType())+".");
						} else {
							Bukkit.getPlayer(player.getName()).sendMessage(ChatColor.DARK_AQUA+""+ChatColor.ITALIC+"Crafted "+newItemsCount+" "+convertToItemName(compareItem.getType().name())+".");
						}
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

	/*@EventHandler
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
	 */
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
		if (this.plugin.getConfig().getBoolean("thanksgiving-enabled") && i.getItemStack().getType()==Material.EGG) {
			allow=false;
		}
		if (i.getItemStack().getType()==Material.BEDROCK) { //Add a hard check.
			allow=false;
		}
		//p.sendMessage("Item "+i.getItemStack().getItemMeta().getDisplayName()+" despawned.");// <-- CHECK THIS FOR NULL TO DETERMINE IF IT'S A REAL ITEM.
		//String metastring = "Has name: "+i.getItemStack().getItemMeta().hasDisplayName();
		//p.sendMessage(metastring);
		if (allow) {
			//Find the nearest recycling center to dump to...usually.
			RecyclingCenterNode center = null;
			double distance = 99999999d;
			for (int j=0;j<this.plugin.recycling_center_list.size();j++) {
				if (this.plugin.recycling_center_list.get(j).locations.size()>0) {
					if (i.getWorld()==this.plugin.recycling_center_list.get(j).locations.get(0).getWorld() && i.getLocation().distanceSquared(this.plugin.recycling_center_list.get(j).locations.get(0))<distance) { //Check if the first location in that node is close enough.
						if (Math.random()<=0.95) {
							distance = i.getLocation().distanceSquared(this.plugin.recycling_center_list.get(j).locations.get(0));
							center = this.plugin.recycling_center_list.get(j);
						}
					}
				} else {
					Bukkit.getLogger().warning("Found a Recycling center that has no nodes! Skipping...");
				}
			}
			if (center!=null) {
				//Add the item to the center!
				center.recycleItem(i.getItemStack());
			}

			//There is a small chance we can swap items between two centers.
			if (Math.random()<=0.15) {
				//Get the first center. It's randomly picked.
				if (this.plugin.recycling_center_list.size()<=2) {
					//If there are only two centers in the list, it has to be those two...
					RecyclingCenterNode center1 = null;
					RecyclingCenterNode center2 = null;
					center1 = this.plugin.recycling_center_list.get(0);
					center2 = this.plugin.recycling_center_list.get(1);
				} else {
					//Run a loop until two are selected.
					RecyclingCenterNode center1 = null;
					RecyclingCenterNode center2 = null;
					int maxiterator=1000;
					while ((center1==null || center2==null) && maxiterator>0) {
						if (center1==null) {
							//Choose one randomly, if it's not equal to center2.
							int randomnumb = (int)(Math.random()*this.plugin.recycling_center_list.size());
							if (center2==null) {
								center1=this.plugin.recycling_center_list.get(randomnumb);
							} else {
								if (!center2.equals(this.plugin.recycling_center_list.get(randomnumb))) {
									center1=this.plugin.recycling_center_list.get(randomnumb);
								}
							}
						}
						if (center2==null) {
							//Choose one randomly, if it's not equal to center2.
							int randomnumb = (int)(Math.random()*this.plugin.recycling_center_list.size());
							if (center1==null) {
								center2=this.plugin.recycling_center_list.get(randomnumb);
							} else {
								if (!center1.equals(this.plugin.recycling_center_list.get(randomnumb))) {
									center2=this.plugin.recycling_center_list.get(randomnumb);
								}
							}
						}
						if (center1==null || center2==null) {
							maxiterator--;
						} else {
							maxiterator=0;
						}
					}
					if (center1!=null && center2!=null) {
						//Do a swap.
						center1.swapItem(center2);
					}
				}
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
		if (e.getVehicle().getType()==EntityType.MINECART && e.getVehicle().getPassenger().getType()==EntityType.PLAYER) {
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
		LivingEntity l = (LivingEntity)(e.getEntity().getShooter());
		//Bukkit.getLogger().info("Arrow vector is: "+e.getEntity().getVelocity().toString());
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
	public void onProjectileLaunch(ProjectileLaunchEvent e) {
		Projectile thrown_obj = e.getEntity();
		if (thrown_obj instanceof Arrow) {
			if (thrown_obj.getShooter()!=null && (thrown_obj.getShooter() instanceof Player)) {
				Player p = (Player)thrown_obj.getShooter();
				List<MobHead> mobheads = this.plugin.getMobHeads(p);
				int skeleton_mob_head = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SKELETON, true, MobHeadRareType.RARE_TYPE_B), mobheads);
				int powered_skeleton_mob_head = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SKELETON, false, true), mobheads);
				int powered_rare_skeleton_mob_head = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.SKELETON, true, MobHeadRareType.RARE_TYPE_A, true), mobheads);
				if (skeleton_mob_head+powered_skeleton_mob_head+powered_rare_skeleton_mob_head>0) {
					//Bukkit.getLogger().info("Old Projectile speed: "+thrown_obj.getVelocity().toString());
					for (int i=0;i<skeleton_mob_head;i++) {
						thrown_obj.setVelocity(thrown_obj.getVelocity().add(thrown_obj.getVelocity().multiply((double)1/thrown_obj.getVelocity().length())));
					}
					for (int i=0;i<powered_skeleton_mob_head;i++) {
						thrown_obj.setVelocity(thrown_obj.getVelocity().add(thrown_obj.getVelocity().multiply((double)1/thrown_obj.getVelocity().length())));
					}
					for (int i=0;i<powered_rare_skeleton_mob_head*3;i++) {
						thrown_obj.setVelocity(thrown_obj.getVelocity().add(thrown_obj.getVelocity().multiply((double)1/thrown_obj.getVelocity().length())));
					}
					//Bukkit.getLogger().info("New Projectile speed: "+thrown_obj.getVelocity().toString());
				}
			}
		}
		if (thrown_obj instanceof ThrownPotion) {
			ThrownPotion thrownpot = (ThrownPotion)thrown_obj;
			thrownpot.setVelocity(thrownpot.getVelocity().setX(thrownpot.getVelocity().getX()*4).setZ(thrownpot.getVelocity().getZ()*4).setY(thrownpot.getVelocity().getY()*3-0.375));
		}
	}
	@EventHandler
	public void onEggThrow(ProjectileHitEvent e) {
		LivingEntity l = (LivingEntity)(e.getEntity().getShooter());
		if (e.getEntity() instanceof ThrownPotion) {
			ThrownPotion thrownpot = (ThrownPotion)e.getEntity();
			if (thrownpot.getShooter() instanceof Player) {
				Player p = (Player)thrownpot.getShooter();
				if (thrownpot.getItem().hasItemMeta() && thrownpot.getItem().getItemMeta().hasLore()) {
					if (thrownpot.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"Teleports shooter to target")) {
						//Activate its effect.
						//Get pitch and yaw of player.
						float pitch = p.getLocation().getPitch(), yaw = p.getLocation().getYaw();
						Location loc = thrownpot.getLocation();
						loc.setPitch(pitch);
						loc.setYaw(yaw);
						p.teleport(loc);
					}
					if (thrownpot.getItem().getItemMeta().getLore().contains(ChatColor.GOLD+"Drink to reveal nearby mob tags.")) {
						//Reveal nearby area.
						int size = 5;
						for (int x=-size;x<=size;x++) {
							for (int y=-size;y<=size;y++) {
								for (int z=-size;z<=size;z++) {
									if (thrownpot.getWorld().getBlockAt(thrownpot.getLocation().add(x,y,z)).getType()==Material.STONE) {
										thrownpot.getWorld().getBlockAt(thrownpot.getLocation().add(x,y,z)).setType(Material.GLASS);
										if (Math.abs(x)==size && Math.abs(y)==size && Math.abs(z)==size) {
											thrownpot.getWorld().getBlockAt(thrownpot.getLocation().add(x,y,z)).setType(Material.JACK_O_LANTERN);
										}
										if (this.plugin.hasJobBuff("Brewer", p, Job.JOB20)) {
											this.plugin.TEMP_BLOCKS.add(new TempBlock(thrownpot.getLocation().add(x,y,z),100));
										} else {
											this.plugin.TEMP_BLOCKS.add(new TempBlock(thrownpot.getLocation().add(x,y,z),200));
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if (l!=null && l.getType()==EntityType.PLAYER && e.getEntity().getType() == EntityType.EGG && this.plugin.getConfig().getBoolean("thanksgiving-enabled")) {
			// Threw an egg during thanksgiving. Generate loot. 
			Location loc = e.getEntity().getLocation(); 
			ItemStack item = null;
			
			switch ((int)(Math.random()*111.01)) {
				case 0:{
					item = new ItemStack(Material.WOOD_HOE);
				}break;
				case 1:{
					item = new ItemStack(Material.WOOD_AXE);
				}break;
				case 2:{
					item = new ItemStack(Material.WOOD_SWORD);
				}break;
				case 3:{
					item = new ItemStack(Material.WOOD_SPADE);
				}break;
				case 4:{
					item = new ItemStack(Material.WOOD_PICKAXE);
				}break;
				case 5:{
					item = new ItemStack(Material.SIGN);
				}break;
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:{
					item = new ItemStack(Material.STICK);
				}break;
				case 11:
				case 12:
				case 13:
				case 14:
				case 15:
				case 16:{
					item = new ItemStack(Material.DIRT);
				}break;
				case 17:
				case 18:
				case 19:{
					item = new ItemStack(Material.GRASS);
				}break;
				case 20:
				case 21:
				case 22:{
					item = new ItemStack(Material.GRAVEL);
				}break;
				case 23:{
					item = new ItemStack(Material.PUMPKIN);
				}break;
				case 24:{
					item = new ItemStack(Material.SOUL_SAND);
				}break;
				case 25:
				case 26:{
					item = new ItemStack(Material.NETHERRACK);
				}break;
				case 27:{
					item = new ItemStack(Material.BONE);
				}break;
				case 28:
				case 29:{
					item = new ItemStack(Material.ROTTEN_FLESH);
				}break;
				case 30:{
					item = new ItemStack(Material.GRILLED_PORK);
				}break;
				case 31:{
					item = new ItemStack(Material.COOKED_BEEF);
				}break;
				case 32:{
					item = new ItemStack(Material.COOKED_FISH);
				}break;
				case 33:
				case 34:{
					item = new ItemStack(Material.APPLE);
				}break;
				case 35:
				case 36:{
					item = new ItemStack(Material.BREAD);
				}break;
				case 37:{
					item = new ItemStack(Material.CAKE);
				}break;
				case 38:{
					item = new ItemStack(Material.PAPER);
				}break;
				case 39:
				case 40:{
					item = new ItemStack(Material.SUGAR_CANE);
				}break;
				case 41:{
					item = new ItemStack(Material.SUGAR);
				}break;
				case 42:{
					item = new ItemStack(Material.FEATHER);
				}break;
				case 43:{
					item = new ItemStack(Material.WOOD);
				}break;
				case 44:{
					item = new ItemStack(Material.LOG);
				}break;
				case 45:
				case 46:{
					item = new ItemStack(Material.CLAY_BALL);
				}break;
				case 47:{
					item = new ItemStack(Material.CLAY);
				}break;
				case 48:{
					item = new ItemStack(Material.SLIME_BALL);
				}break;
				case 49:{
					item = new ItemStack(Material.REDSTONE);
				}break;
				case 50:{
					item = new ItemStack(Material.GLOWSTONE_DUST);
				}break;
				case 51:{
					item = new ItemStack(Material.COAL);
				}break;
				case 52:{
					item = new ItemStack(Material.FERMENTED_SPIDER_EYE);
				}break;
				case 53:{
					item = new ItemStack(Material.IRON_INGOT);
				}break;
				case 54:{
					item = new ItemStack(Material.GOLD_NUGGET);
				}break;
				case 55:{
					item = new ItemStack(Material.FLINT);
				}break;
				case 56:{
					item = new ItemStack(Material.ARROW);
				}break;
				case 57:{
					item = new ItemStack(Material.SAPLING);
				}break;
				case 58:{
					item = new ItemStack(Material.POTATO_ITEM);
				}break;
				case 59:{
					item = new ItemStack(Material.CARROT_ITEM);
				}break;
				case 60:{
					item = new ItemStack(Material.PORK);
				}break;
				case 61:{
					item = new ItemStack(Material.FLOWER_POT_ITEM);
				}break;
				case 62:{
					item = new ItemStack(Material.RAW_BEEF);
				}break;
				case 63:{
					item = new ItemStack(Material.RAW_FISH);
				}break;
				case 64:{
					item = new ItemStack(Material.MELON);
				}break;
				case 65:{
					item = new ItemStack(Material.CACTUS);
				}break;
				case 66:{
					item = new ItemStack(Material.LEATHER);
				}break;
				case 67:{
					item = new ItemStack(Material.STRING);
				}break;
				case 68:{
					item = new ItemStack(Material.WOOL);
				}break;
				case 69:{
					item = new ItemStack(Material.QUARTZ);
				}break;
				case 70:
				case 71:
				case 72:
				case 73:
				case 74:
				case 75:
				case 76:
				case 77:
				case 78:
				case 79:{
					item = new ItemStack(Material.TORCH);
				}break;
				case 80:
				case 81:
				case 82:{
					item = new ItemStack(Material.SAND);
				}break;
				case 83:{
					item = new ItemStack(Material.SANDSTONE);
				}break;
				case 84:{
					item = new ItemStack(Material.GLASS);
				}break;
				case 85:{
					item = new ItemStack(Material.GLASS_BOTTLE);
				}break;
				case 86:{
					item = new ItemStack(Material.SULPHUR);
				}break;
				case 87:{
					item = new ItemStack(Material.INK_SACK);
				}break;
				case 88:{
					item = new ItemStack(Material.BRICK);
				}break;
				case 89:{
					item = new ItemStack(Material.BOOK);
				}break;
				case 90:{
					item = new ItemStack(Material.RED_MUSHROOM);
				}break;
				case 91:{
					item = new ItemStack(Material.BROWN_MUSHROOM);
				}break;
				case 92:{
					item = new ItemStack(Material.SNOW_BALL, 1 + (int)(Math.random() * 16));
				}break;
				case 93:{
					item = new ItemStack(Material.FENCE);
				}break;
				case 94:{
					item = new ItemStack(Material.NETHER_BRICK_ITEM);
				}break;
				case 95:{
					item = new ItemStack(Material.WATER_LILY);
				}break;
				case 96:{
					item = new ItemStack(Material.COBBLESTONE);
				}break;
				case 97:{
					item = new ItemStack(Material.STONE);
				}break;
				case 98:{
					item = new ItemStack(Material.VINE);
				}break;
				case 99:{
					item = new ItemStack(Material.WHEAT);
				}break;
				case 100:
				case 101:
				case 102:
				case 103:
				case 104:{
					// Uncommon items here
					switch((int)(Math.random() * 40)){
						case 0:{
							item = new ItemStack(Material.WATCH);
						}break;
						case 1:{
							item = new ItemStack(Material.WORKBENCH);
						}break;
						case 2:{
							item = new ItemStack(Material.FURNACE);
						}break;
						case 3:{
							item = new ItemStack(Material.REDSTONE_ORE);
						}break;
						case 4:{
							item = new ItemStack(Material.ANVIL);
						}break;
						case 5:{
							item = new ItemStack(Material.CAULDRON);
						}break;
						case 6:{
							item = new ItemStack(Material.ENDER_CHEST);
						}break;
						case 7:{
							item = new ItemStack(Material.GLOWSTONE);
						}break;
						case 8:{
							item = new ItemStack(Material.LAVA_BUCKET);
						}break;
						case 9:{
							item = new ItemStack(Material.QUARTZ_BLOCK);
						}break;
						case 10:{
							item = new ItemStack(Material.LAPIS_ORE);
						}break;
						case 11:{
							item = new ItemStack(Material.CHEST);
						}break;
						case 12:{
							item = new ItemStack(Material.TRAPPED_CHEST);
						}break;
						case 13:{
							item = new ItemStack(Material.NETHER_STALK);
						}break;
						case 14:{
							item = new ItemStack(Material.COMPASS);
						}break;
						case 15:{
							item = new ItemStack(Material.IRON_DOOR);
						}break;
						case 16:{
							item = new ItemStack(Material.COAL_ORE);
						}break;
						case 17:{
							item = new ItemStack(Material.JUKEBOX);
						}break;
						case 18:{
							item = new ItemStack(Material.ENCHANTMENT_TABLE);
						}break;
						case 19:{
							item = new ItemStack(Material.BOOKSHELF);
						}break;
						case 20:{
							item = new ItemStack(Material.DISPENSER);
						}break;
						case 21:{
							item = new ItemStack(Material.DIODE);
						}break;
						case 22:{
							item = new ItemStack(Material.MINECART);
						}break;
						case 23:{
							item = new ItemStack(Material.ITEM_FRAME);
						}break;
						case 24:{
							item = new ItemStack(Material.BREWING_STAND_ITEM);
						}break;
						case 25:{
							item = new ItemStack(Material.HOPPER);
						}break;
						case 26:{
							item = new ItemStack(Material.DAYLIGHT_DETECTOR);
						}break;
						case 27:{
							item = new ItemStack(Material.PISTON_BASE);
						}break;
						case 28:{
							item = new ItemStack(Material.RAILS);
						}break;
						case 29:{
							item = new ItemStack(Material.POWERED_RAIL);
						}break;
						case 30:{
							item = new ItemStack(Material.DETECTOR_RAIL);
						}break;
						case 31:{
							item = new ItemStack(Material.ICE);
						}break;
						case 32:{
							item = new ItemStack(Material.TNT);
						}break;
						case 33:{
							item = new ItemStack(Material.LADDER);
						}break;
						case 34:{
							item = new ItemStack(Material.MAGMA_CREAM);
						}break;
						case 35:{
							item = new ItemStack(Material.FIREBALL);
						}break;
						case 36:{
							item = new ItemStack(Material.FLINT_AND_STEEL);
						}break;
						case 37:{
							item = new ItemStack(Material.FENCE_GATE);
						}break;
						case 38:{
							item = new ItemStack(Material.FISHING_ROD);
						}break;
						case 39:{
							item = new ItemStack(Material.BED);
						}break;
					}
				}break;
				case 105:{
					item = new ItemStack(Material.OBSIDIAN);
				}break;
				case 106:{
					// Rare items here
					switch((int)(Math.random() * 20)){
						case 0:{
							item = new ItemStack(Material.MYCEL);
						}break;
						case 1:{
							item = new ItemStack(Material.EMERALD);
						}break;
						case 2:{
							item = new ItemStack(Material.DIAMOND);
						}break;
						case 3:{
							item = new ItemStack(Material.GOLD_INGOT, 1 + (int)(Math.random() * 2));
						}break;
						case 4:{
							item = new ItemStack(Material.GOLDEN_APPLE);
						}break;
						case 5:{
							item = new ItemStack(Material.GOLDEN_CARROT);
						}break;
						case 6:{
							item = new ItemStack(Material.IRON_BARDING);
						}break;
						case 7:{
							item = new ItemStack(Material.IRON_AXE);
						}break;
						case 8:{
							item = new ItemStack(Material.IRON_PICKAXE);
						}break;
						case 9:{
							item = new ItemStack(Material.IRON_SPADE);
						}break;
						case 10:{
							item = new ItemStack(Material.IRON_SWORD);
						}break;
						case 11:{
							item = new ItemStack(Material.ENDER_STONE);
						}break;
						case 12:{
							item = new ItemStack(Material.NAME_TAG);
						}break;
						case 13:{
							item = new ItemStack(Material.REDSTONE_COMPARATOR);
						}break;
						case 14:{
							item = new ItemStack(Material.GHAST_TEAR);
						}break;
						case 15:{
							item = new ItemStack(Material.EMPTY_MAP);
						}break;
						case 16:{
							item = new ItemStack(Material.GOLD_BARDING);
						}break;
						case 17:{
							item = new ItemStack(Material.DIAMOND_SWORD);
						}break;
						case 18:{
							item = new ItemStack(Material.DIAMOND_SPADE);
						}break;
						case 19:{
							item = new ItemStack(Material.DIAMOND_PICKAXE);
						}break;
						case 20:{
							// ULTRA RARES WHOO
							switch((int)(Math.random() * 25)){
								case 0:{
									item = new ItemStack(Material.DIAMOND_BARDING);
								}break;
								case 1:
								case 2:
								case 3:{
									item = new ItemStack(Material.SKULL_ITEM, 1 + (int)(Math.random() * 6));
									item.setData(new MaterialData(Material.SKULL_ITEM, (byte) 1));
								}break;
								case 4:{
									item = new ItemStack(Material.BEACON);
								}break;
								case 5:{
									item = new ItemStack(Material.DRAGON_EGG);
								}break;
								default:{
									// Roll failed; generate standard item
									item = new ItemStack(Material.BOAT);
								}
							}
						}break;
					}
				}break;
				case 107:{
					item = new ItemStack(Material.COOKIE, 1 + (int)(Math.random() * 8));
				}break;
				case 108:{
					item = new ItemStack(Material.SEEDS, 1 + (int)(Math.random() * 64));
				}break;
				case 109:{
					item = new ItemStack(Material.PAINTING, 1 + (int)(Math.random() * 32));
				}break;
				case 110:{
					item = getGoodie(0);
				}break;
				default: {
					item = getGoodie(1);
				}
			}
			e.getEntity().getWorld().dropItemNaturally(loc, item);

			ExperienceOrb exp = (ExperienceOrb)l.getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.EXPERIENCE_ORB);
			exp.setExperience((int)(Math.random() * 5) + 1);
			
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
					//e.setRadius(3f);
					//e.setFire(false);
				} else 
					if (c.getCustomName().compareTo(ChatColor.GOLD+"Explosive Creeper II")==0) {
						Bukkit.getWorld("world").createExplosion(c.getLocation().getX(),c.getLocation().getY(),c.getLocation().getZ(),5f,false,true);
						//Bukkit.getPlayer("AaMay").sendMessage("Sent explosion");
						e.setCancelled(true);
						//e.setRadius(5f);
						//e.setFire(false);
					} else 
						if (c.getCustomName().compareTo(ChatColor.YELLOW+"Destructive Creeper")==0) {
							Bukkit.getWorld("world").createExplosion(c.getLocation().getX(),c.getLocation().getY(),c.getLocation().getZ(),2f,true,true);
							//Bukkit.getPlayer("AaMay").sendMessage("Sent explosion");
							e.setCancelled(true);
							//e.setRadius(2f);
							//e.setFire(true);
						} else 
							if (c.getCustomName().compareTo(ChatColor.GOLD+"Destructive Creeper II")==0) {
								Bukkit.getWorld("world").createExplosion(c.getLocation().getX(),c.getLocation().getY(),c.getLocation().getZ(),4f,true,true);
								//Bukkit.getPlayer("AaMay").sendMessage("Sent explosion");
								e.setCancelled(true);
								//e.setRadius(4f);
								//e.setFire(true);
							}
			}
		}
		//Bukkit.broadcastMessage("Explosion occurs.");
	}

	@EventHandler
  	public void onPlayerMove(PlayerMoveEvent e) {
		if (e.getPlayer().isOnGround() && this.plugin.hasJobBuff("Fisherman", e.getPlayer(), Job.JOB40) && e.getPlayer().getItemInHand().getType()==Material.FISHING_ROD && !e.getPlayer().getAllowFlight()) {
			this.plugin.getPlayerData(e.getPlayer()).haslanded=true;
			this.plugin.getPlayerData(e.getPlayer()).gameinteractions+=1;
			e.getPlayer().setAllowFlight(true);
			e.getPlayer().sendMessage(ChatColor.DARK_GRAY+""+ChatColor.ITALIC+"Flight enabled...");
		}
	}
	/*
  @SuppressWarnings("deprecation")
@EventHandler
  public void onPlayerMove(PlayerMoveEvent e) {
	  Player p = e.getPlayer();
	  if (this.plugin.getConfig().getBoolean("spleef4insession")) {
		  //Check to see if we fall off.
		  if ((p.getLocation().getX()<1585 || p.getLocation().getX()>1600 || p.getLocation().getZ()<24 || p.getLocation().getZ()>39 || p.getLocation().getY()<86.5d) && (
				  (p.getName().toLowerCase().compareTo(this.plugin.getConfig().getString("spleefrequesta4player"))==0 || p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestb4player"))==0
				  || p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestc4player"))==0 || p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestd4player"))==0))) {
			  //You lose.
			  //See if we're the winner.
			  int countdead=0; //We're looking for 3.


			  Player winningplayer = p,losingplayer = p;
			  if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo("none")==0) {
				  countdead++;
			  } else {
				  if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName().toLowerCase())==0) {
					  losingplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequesta4player"));
				  } else {
					  winningplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequesta4player"));
				  }
			  }
			  if (this.plugin.getConfig().getString("spleefrequestb4player").compareTo("none")==0) {
				  countdead++;
			  } else {
				  if (this.plugin.getConfig().getString("spleefrequestb4player").compareTo(p.getName().toLowerCase())==0) {
					  losingplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestb4player"));
				  } else {
					  winningplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestb4player"));
				  }
			  }
			  if (this.plugin.getConfig().getString("spleefrequestc4player").compareTo("none")==0) {
				  countdead++;
			  } else {
				  if (this.plugin.getConfig().getString("spleefrequestc4player").compareTo(p.getName().toLowerCase())==0) {
					  losingplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestc4player"));
				  } else {
					  winningplayer=Bukkit.getPlayer(this.plugin.getConfig().getString("spleefrequestc4player"));
				  }
			  }
			  if (this.plugin.getConfig().getString("spleefrequestd4player").compareTo("none")==0) {
				  countdead++;
			  } else {
				  if (this.plugin.getConfig().getString("spleefrequestd4player").compareTo(p.getName().toLowerCase())==0) {
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
					  if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName().toLowerCase())==0) {
						  for (int i=0;i<this.plugin.spleef4_inventory_a.length;i++) {
							  if (this.plugin.spleef4_inventory_a[i]!=null) {
							  p.getInventory().addItem(this.plugin.spleef4_inventory_a[i]);
							  }
						  }
						  this.plugin.getConfig().set("spleefrequesta4player",String.valueOf("none"));
					  } else
					  if (this.plugin.getConfig().getString("spleefrequestb4player").compareTo(p.getName().toLowerCase())==0) {
						  for (int i=0;i<this.plugin.spleef4_inventory_b.length;i++) {
							  if (this.plugin.spleef4_inventory_b[i]!=null) {
							  p.getInventory().addItem(this.plugin.spleef4_inventory_b[i]);
							  }
						  }
						  this.plugin.getConfig().set("spleefrequestb4player",String.valueOf("none"));
					  } else
					  if (this.plugin.getConfig().getString("spleefrequestc4player").compareTo(p.getName().toLowerCase())==0) {
						  for (int i=0;i<this.plugin.spleef4_inventory_c.length;i++) {
							  if (this.plugin.spleef4_inventory_c[i]!=null) {
							  p.getInventory().addItem(this.plugin.spleef4_inventory_c[i]);
							  }
						  }
						  this.plugin.getConfig().set("spleefrequestc4player",String.valueOf("none"));
					  } else
					  if (this.plugin.getConfig().getString("spleefrequestd4player").compareTo(p.getName().toLowerCase())==0) {
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
				  if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName().toLowerCase())==0) {
					  for (int i=0;i<this.plugin.spleef4_inventory_a.length;i++) {
						  if (this.plugin.spleef4_inventory_a[i]!=null) {
						  p.getInventory().addItem(this.plugin.spleef4_inventory_a[i]);
						  }
					  }
					  this.plugin.getConfig().set("spleefrequesta4player",String.valueOf("none"));
				  } else
				  if (this.plugin.getConfig().getString("spleefrequestb4player").compareTo(p.getName().toLowerCase())==0) {
					  for (int i=0;i<this.plugin.spleef4_inventory_b.length;i++) {
						  if (this.plugin.spleef4_inventory_b[i]!=null) {
						  p.getInventory().addItem(this.plugin.spleef4_inventory_b[i]);
						  }
					  }
					  this.plugin.getConfig().set("spleefrequestb4player",String.valueOf("none"));
				  } else
				  if (this.plugin.getConfig().getString("spleefrequestc4player").compareTo(p.getName().toLowerCase())==0) {
					  for (int i=0;i<this.plugin.spleef4_inventory_c.length;i++) {
						  if (this.plugin.spleef4_inventory_c[i]!=null) {
						  p.getInventory().addItem(this.plugin.spleef4_inventory_c[i]);
						  }
					  }
					  this.plugin.getConfig().set("spleefrequestc4player",String.valueOf("none"));
				  } else
				  if (this.plugin.getConfig().getString("spleefrequestd4player").compareTo(p.getName().toLowerCase())==0) {
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
		  if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName().toLowerCase())==0 ||
				  this.plugin.getConfig().getString("spleefrequestb4player").compareTo(p.getName().toLowerCase())==0 ||
				  this.plugin.getConfig().getString("spleefrequestc4player").compareTo(p.getName().toLowerCase())==0 ||
				  this.plugin.getConfig().getString("spleefrequestd4player").compareTo(p.getName().toLowerCase())==0) {
			  //If they are holding something, remove it.
			  if (p.getItemInHand()!=null) {
				  p.getInventory().remove(p.getInventory().getHeldItemSlot());
			  }
		  }
	  }

	  if (this.plugin.getConfig().getBoolean("spleefinsession") && (p.getName().toLowerCase().compareTo(this.plugin.getConfig().getString("spleefrequestaplayer"))==0 || p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestbplayer"))==0)) {
		  //Determine if we're still playing.
		  int blockwinner=0;
		  if (this.plugin.getConfig().getString("spleefrequestaplayer").compareTo(p.getName().toLowerCase())==0 ||
				  this.plugin.getConfig().getString("spleefrequestbplayer").compareTo(p.getName().toLowerCase())==0) {
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
			  if (p.getName().toLowerCase().compareTo(this.plugin.getConfig().getString("spleefrequestaplayer"))==0 || blockwinner==2) {
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
		  if (this.plugin.getConfig().getBoolean("spleefinsession") && (p.getName().toLowerCase().compareTo(this.plugin.getConfig().getString("spleefrequestaplayer"))!=0 && p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestbplayer"))!=0)) {
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
		if (p.isInsideVehicle()) {
			p.leaveVehicle();
		}
		if (p.getOpenInventory()!=null) {
			p.closeInventory();
		}
		for (int i=0;i<this.plugin.SPEED_CONTROL.size();i++) {
			if (this.plugin.SPEED_CONTROL.get(i).p.getName().toLowerCase().compareTo(p.getName().toLowerCase())==0) {
				p.removePotionEffect(PotionEffectType.SPEED);
				//If they have a "speed" potion, give it back.
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (int) ((this.plugin.SPEED_CONTROL.get(i).potion_time-Main.SERVER_TICK_TIME)*2), this.plugin.SPEED_CONTROL.get(i).potion_spdlv, true));
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
		/*Makes no sense as to why this is here.
		if (!this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".revived")) {
			this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".revived", Boolean.valueOf(true));
			//this.plugin.saveAccountsConfig();
		}*/
		if (this.plugin.getConfig().getBoolean("spleefinsession") && (p.getName().toLowerCase().compareTo(this.plugin.getConfig().getString("spleefrequestaplayer"))==0 || p.getName().compareTo(this.plugin.getConfig().getString("spleefrequestbplayer"))==0)) {
			//This player was in spleef. End the spleef session as if this player lost.
			//We lose. Other player wins.
			this.plugin.getConfig().set("spleefinsession", Boolean.valueOf(false));
			//Find out if we're player A, or player B.
			Player winningplayer,losingplayer;
			if (p.getName().toLowerCase().compareTo(this.plugin.getConfig().getString("spleefrequestaplayer"))==0) {
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
				//this.plugin.saveAccountsConfig();
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
				//this.plugin.saveAccountsConfig();
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
				if (this.plugin.hunterplayers.get(i).getName().compareTo(p.getName().toLowerCase())==0) {
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
				if (this.plugin.supportplayers.get(i).p.getName().compareTo(p.getName().toLowerCase())==0) {
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
				if (this.plugin.explorerlist.get(i).player.compareTo(p.getName().toLowerCase())==0) {
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
				p.getScoreboard().getTeam(p.getName().toLowerCase()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth(),p.getFoodLevel()));
			}
		},20);
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		//Delay this for 5 ticks. See if Fatal Survivor kicked in in time. (Or you got healed).
		//Bukkit.broadcastMessage("Player Death: "+e.getEntity().getHealth()+" HP, Last Damage: -"+e.getEntity().getLastDamage()+" from "+e.getEntity().getLastDamageCause());
		//If we have Fatal Survivor, use the force! Otherwise, uh, you're dead.

		final Player p = e.getEntity();
		this.plugin.last_player_death_time = Main.SERVER_TICK_TIME;
		e.setDeathMessage(e.getDeathMessage().replace(p.getScoreboard().getTeam(p.getName().toLowerCase()).getPrefix()+p.getName()+p.getScoreboard().getTeam(p.getName().toLowerCase()).getSuffix(),p.getName()));
		p.getScoreboard().getTeam(p.getName().toLowerCase()).setSuffix("");
		boolean survivor=false;
		if (this.plugin.PlayerinJob(p, "Explorer")) {
			if (this.plugin.getJobLv("Explorer", p)>=10) {
				//Check to see if our "fatal s	urvivor" effect is available.
				for (int i=0;i<this.plugin.explorers.size();i++) {
					if (this.plugin.explorers.get(i).event==0 && this.plugin.explorers.get(i).name.compareTo(p.getName().toLowerCase())==0) {
						survivor=true;
						break;
					}
				}
				PersistentExplorerList eve = new PersistentExplorerList(p.getName().toLowerCase());
				eve.event=1;
				eve.data=p.getExp();
				eve.data2=p.getLevel();
				eve.expiretime=Main.SERVER_TICK_TIME+1200;
				this.plugin.explorers.add(eve);
				if (!survivor) {
					final List<ItemStack> drops = new ArrayList<ItemStack>();
					for (int i=0;i<e.getDrops().size();i++) {
						drops.add(e.getDrops().get(i));  
					}
					final ItemStack helmet_slot = p.getEquipment().getHelmet();
					final ItemStack chestplate_slot = p.getEquipment().getChestplate();
					final ItemStack leggings_slot = p.getEquipment().getLeggings();
					final ItemStack boots_slot = p.getEquipment().getBoots();
					//Remove them from the drops list, since they will be placed on the player's equipment slots.
					if (drops.contains(helmet_slot)) {
						drops.remove(helmet_slot);
					}
					if (drops.contains(chestplate_slot)) {
						drops.remove(chestplate_slot);
					}
					if (drops.contains(leggings_slot)) {
						drops.remove(leggings_slot);
					}
					if (drops.contains(boots_slot)) {
						drops.remove(boots_slot);
					}
					//Bukkit.broadcastMessage("Added in "+drops.size()+" drops.");
					Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
						@Override
						public void run() {
							for (int i=0;i<drops.size();i++) {
								//Bukkit.broadcastMessage("Giving back "+drops.get(i).getType()+"x"+drops.get(i).getAmount());
								p.getInventory().addItem(drops.get(i));
								p.getEquipment().setBoots(boots_slot);
								p.getEquipment().setChestplate(chestplate_slot);
								p.getEquipment().setLeggings(leggings_slot);
								p.getEquipment().setHelmet(helmet_slot);
							}
						}
					},5);
					e.getDrops().clear();
					FatalSurvivor(p);
				}
			}
		}
		if (survivor || !this.plugin.PlayerinJob(p, "Explorer"))  {
			//You are dead buddy.
			for (int i=0;i<plugin.explorerlist.size();i++) {
				if (Bukkit.getPlayer(plugin.explorerlist.get(i).player)!=null) {
					Player p2 =Bukkit.getPlayer(plugin.explorerlist.get(i).player);
					if (p.equals(p2)) {
						//This is an explorer in the explorer data.
						plugin.explorerlist.get(i).wedied=true;
					}
				}
			}
			if (!plugin.PlayerinJob(p, "Explorer") || (plugin.PlayerinJob(p, "Explorer") && plugin.getJobLv("Explorer", p)<20)) {
				double balance = Main.economy.getBalance(p.getName());
				double lose = plugin.getConfig().getDouble("losemoney.LoseAmount");
				double loseAmount = Main.economy.getBalance(p.getName()) / 100.0D * lose;
				String message = "You lost $%amount because you died.";
				DecimalFormat df = new DecimalFormat("#0.00");
				loseAmount = Double.parseDouble(df.format(loseAmount));
				if (Main.economy.has(p.getName().toLowerCase(), loseAmount)) {
					plugin.getLogger().info("Player " + p.getName() + "'s getting withdrawed with " + loseAmount + "$");
					Main.economy.withdrawPlayer(p.getName(), loseAmount);
					message = message.replaceAll("%amount", String.valueOf(loseAmount));
				} else {
					plugin.getLogger().info("Player " + p.getName() + "'s getting withdrawed with " + balance + "$");
					Main.economy.withdrawPlayer(p.getName(), balance);
					message = message.replaceAll("%amount", String.valueOf(balance));
				}
				p.sendMessage(message);
			}
			if (plugin.PlayerinJob(p,"Explorer")) {
				PersistentExplorerList eve = new PersistentExplorerList(p.getName().toLowerCase());
				eve.event=2;
				eve.expiretime=Main.SERVER_TICK_TIME+3600;
				plugin.explorers.add(eve);
			}
			DecimalFormat df = new DecimalFormat("#0.00");
			double deathX = p.getLocation().getX();
			double deathY = p.getLocation().getY();
			double deathZ = p.getLocation().getZ();
			String deathWorld = p.getLocation().getWorld().getName();
			plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".deathpointX",Double.valueOf(deathX));
			plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".deathpointY",Double.valueOf(deathY));
			plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".deathpointZ",Double.valueOf(deathZ));
			plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".deathworld",String.valueOf(deathWorld));
			plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".revived",Boolean.valueOf(false));
			plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".revivetime",Long.valueOf(Main.SERVER_TICK_TIME));
			//plugin.saveAccountsConfig();
			double mincost = plugin.getConfig().getDouble("revive-cost-rate");
			if (p.getBedSpawnLocation()!=null) {
				mincost *= Math.abs(p.getBedSpawnLocation().getX()-deathX)+Math.abs(p.getBedSpawnLocation().getY()-deathY)+Math.abs(p.getBedSpawnLocation().getZ()-deathZ);
			} else {
				mincost *= Math.abs(Bukkit.getWorld("world").getSpawnLocation().getX()-deathX)+Math.abs(Bukkit.getWorld("world").getSpawnLocation().getY()-deathY)+Math.abs(Bukkit.getWorld("world").getSpawnLocation().getZ()-deathZ);
			}
			double mymoney = plugin.getAccountsConfig().getDouble(p.getName().toLowerCase() + ".money");
			double finalcost = (mincost*plugin.getConfig().getDouble("revive-cost-rate")) + (mymoney*plugin.getConfig().getDouble("revive-cost-tax"));
			if (plugin.PlayerinJob(p, "Explorer") && plugin.getJobLv("Explorer", p)>=20) {
				finalcost*=0.25;
			}
			if (mymoney>=mincost) {
				p.sendMessage("You died. It will cost you $"+df.format(finalcost)+" to revive. To revive, type /revive me.");
			} else {
				p.sendMessage("You died. You do not have enough money in your bank to revive.");
				p.sendMessage("Cost: $"+df.format(finalcost)+". If you want to revive, type "+ChatColor.AQUA+"/revive me"+ChatColor.WHITE+" when you have enough.");
			}
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
							p.sendMessage("�ｧcYou do not have permission to create [Bank] signs.");
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
          p.sendMessage("�ｧ2[BankEconomy]" + ChatColor.AQUA + " The amount of money is invalid. (line 3)");
        } else if (!lines[3].isEmpty()) {
          e.setLine(1, ChatColor.DARK_RED + "Error");
          e.setLine(2, " ");
          e.setLine(3, " ");
          p.sendMessage("�ｧ2[BankEconomy]" + ChatColor.AQUA + " The line 4 must be empty.");
        } else {
          e.setLine(1, ChatColor.YELLOW + "deposit");
          p.sendMessage("�ｧ2[BankEconomy]" + ChatColor.AQUA + " Sign created successfully!");
        }
      } else if ((lines[0].equalsIgnoreCase("[BankEconomy]")) && (lines[1].equalsIgnoreCase("withdraw"))) {
        e.setLine(0, ChatColor.DARK_GREEN + "[BankEconomy]");
        if (!lines[3].isEmpty()) {
          e.setLine(1, ChatColor.DARK_RED + "Error");
          e.setLine(2, " ");
          e.setLine(3, " ");
          p.sendMessage("�ｧ2[BankEconomy]" + ChatColor.AQUA + " The line 4 must be empty.");
        } else if (!lines[2].matches("^[0-9]+$")) {
          e.setLine(1, ChatColor.DARK_RED + "Error");
          e.setLine(2, " ");
          p.sendMessage("�ｧ2[BankEconomy]" + ChatColor.AQUA + " The amount of money is invalid. (line 3)");
        } else {
          e.setLine(1, ChatColor.YELLOW + "withdraw");
          p.sendMessage("�ｧ2[BankEconomy]" + ChatColor.AQUA + " Sign created successfully!");
        }
      } else if ((lines[0].equalsIgnoreCase("[BankEconomy]")) && (lines[1].equalsIgnoreCase("information"))) {
        e.setLine(0, ChatColor.DARK_GREEN + "[BankEconomy]");
        if ((!lines[2].isEmpty()) || (!lines[3].isEmpty())) {
          e.setLine(1, ChatColor.DARK_RED + "Error");
          e.setLine(2, " ");
          e.setLine(3, " ");
          p.sendMessage("�ｧ2[BankEconomy]" + ChatColor.AQUA + " Lines 3 and 4 must be empty.");
        } else {
          e.setLine(0, ChatColor.DARK_GREEN + "[BankEconomy]");
          e.setLine(1, ChatColor.YELLOW + "information");
        }
      } else if (lines[0].equalsIgnoreCase("[BankEconomy]")) {
        e.setLine(0, ChatColor.DARK_GREEN + "[BankEconomy]");
        e.setLine(1, ChatColor.DARK_RED + "Error");
        e.setLine(2, " ");
        e.setLine(3, " ");
        p.sendMessage("�ｧ2[BankEconomy]" + ChatColor.AQUA + " Invalid action.");
      }
    } else {
    	if ((lines[0].equalsIgnoreCase("[BankEconomy]"))) {
	      e.setCancelled(true);
	      p.sendMessage("�ｧcYou do not have permission.");
    	}
    }*/
	}

	public int getSongDuration(Material record) {
		int padding=20;
		if (record==Material.RECORD_3) {
			return 345+5+padding;
		} else
			if (record==Material.RECORD_4) {
				return 185+5+padding;
			} else
				if (record==Material.RECORD_5) {
					return 174+5+padding;
				} else
					if (record==Material.RECORD_6) {
						return 197+5+padding;
					} else
						if (record==Material.RECORD_7) {
							return 96+5+padding;
						} else
							if (record==Material.RECORD_8) {
								return 150+5+padding;
							} else
								if (record==Material.RECORD_9) {
									return 188+5+padding;
								} else
									if (record==Material.RECORD_10) {
										return 251+5+padding;
									} else
										if (record==Material.RECORD_11) {
											return 71+5+padding;
										} else
											if (record==Material.RECORD_12) {
												return 238+5+padding;
											} else
												if (record==Material.GOLD_RECORD) {
													return 178+5+padding;
												} else
													if (record==Material.GREEN_RECORD) {
														return 185+5+padding;
													} else
														return 0;
	}

	@EventHandler
	public void onPlayerChat(PlayerChatEvent e) {
		//Check if they are withdrawing or depositing money.
		Bukkit.getLogger().info(e.getMessage());
		DecimalFormat df = new DecimalFormat("#0.00");
		//e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.SPIDER_DEATH, 5.0f, 0.04f);
		/*
		if (this.plugin.getPlayerData(e.getPlayer()).is_renaming_item) {
			boolean found=false;
			for (int i=0;i<e.getPlayer().getInventory().getContents().length;i++) {
				if (e.getPlayer().getInventory().getContents()[i]!=null &&
						e.getPlayer().getInventory().getContents()[i].hasItemMeta() &&
						e.getPlayer().getInventory().getContents()[i].getItemMeta().hasDisplayName() &&
						e.getPlayer().getInventory().getContents()[i].getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_BLUE+""+ChatColor.ITALIC+"Rename Item")) {
					found=true;
					ItemMeta meta = e.getPlayer().getInventory().getContents()[i].getItemMeta();
					meta.setDisplayName(e.getMessage());
					e.getPlayer().getInventory().getContents()[i].setItemMeta(meta);
					e.getPlayer().sendMessage("The Item name has been changed to: "+ChatColor.YELLOW+e.getPlayer().getInventory().getContents()[i].getItemMeta().getDisplayName());
					this.plugin.getPlayerData(e.getPlayer()).is_renaming_item=false;
					break;
				}
			}
			if (!found) {
				e.getPlayer().sendMessage(ChatColor.RED+"Something bad happened! Please let the administrator know about this event. Your name change did not go through.");
			}
		}*/
		if (e.getPlayer().getName().equalsIgnoreCase(this.plugin.last_bank_deposit_user) && this.plugin.last_bank_deposit_use_time+200>Main.SERVER_TICK_TIME) {
			//Parse the amount.
			double val=0;
			if (e.getMessage().equalsIgnoreCase("all")) {
				//Deposit all the money into their account.
				val = this.plugin.economy.getBalance(e.getPlayer().getName());
				this.plugin.economy.withdrawPlayer(e.getPlayer().getName(), val);
				double mymoney = this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName().toLowerCase() + ".money");
				this.plugin.getAccountsConfig().set(e.getPlayer().getName().toLowerCase() + ".money", Double.valueOf(mymoney+val));
				this.plugin.compoundInterest(e.getPlayer());
				//this.plugin.saveAccountsConfig();
				e.getPlayer().sendMessage(ChatColor.GREEN+"Deposited $" + df.format(val) + " into your account. " + ChatColor.YELLOW + "New Bank Balance: $" + ChatColor.AQUA + df.format(this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName().toLowerCase() + ".money")));
				this.plugin.last_bank_deposit_use_time=0;
			} else {
				try {
					val = Double.parseDouble(e.getMessage());
					//Make sure the user is holding at least that much money.
					if (this.plugin.economy.getBalance(e.getPlayer().getName())>=val && val>0) {
						//Deposit the money into their account.
						//this.plugin.economy.bankDeposit(e.getPlayer().getName(), val);
						this.plugin.economy.withdrawPlayer(e.getPlayer().getName(), val);
						double mymoney = this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName().toLowerCase() + ".money");
						this.plugin.getAccountsConfig().set(e.getPlayer().getName().toLowerCase() + ".money", Double.valueOf(mymoney+val));
						this.plugin.compoundInterest(e.getPlayer());
						//this.plugin.saveAccountsConfig();
						e.getPlayer().sendMessage(ChatColor.GREEN+"Deposited $" + df.format(val) + " into your account. " + ChatColor.YELLOW + "New Bank Balance: $" + ChatColor.AQUA + df.format(this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName().toLowerCase() + ".money")));
						this.plugin.last_bank_deposit_use_time=0;
					} else {
						e.getPlayer().sendMessage(ChatColor.RED+"You are not holding that much! " + ChatColor.YELLOW +"Enter a value equal to or lower than $" + ChatColor.GREEN+ df.format(this.plugin.economy.getBalance(e.getPlayer().getName())) + "" + ChatColor.GRAY + ChatColor.ITALIC + " (Remember you can also use the word all)");
						this.plugin.last_bank_deposit_use_time=Main.SERVER_TICK_TIME;
					}
				} catch (NumberFormatException ex_e) {
					e.getPlayer().sendMessage(ChatColor.RED+"That is not a valid amount! Please try again.");
					this.plugin.last_bank_deposit_use_time=Main.SERVER_TICK_TIME;
				}
			}
			e.setCancelled(true);
		} else 
			if (e.getPlayer().getName().equalsIgnoreCase(this.plugin.last_bank_withdraw_user) && this.plugin.last_bank_withdraw_use_time+200>Main.SERVER_TICK_TIME) {
				//Parse the amount.
				double val=0;
				if (e.getMessage().equalsIgnoreCase("all")) {
					//Withdraw all the money in their account.
					this.plugin.compoundInterest(e.getPlayer());
					val = this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName().toLowerCase() + ".money");
					this.plugin.getAccountsConfig().set(e.getPlayer().getName().toLowerCase() + ".money", Double.valueOf(0));
					//this.plugin.saveAccountsConfig();
					this.plugin.economy.depositPlayer(e.getPlayer().getName(), val);
					e.getPlayer().sendMessage(ChatColor.GREEN+"Withdrawed $" + df.format(val) + " from your account. " + ChatColor.YELLOW + "New Bank Balance: $" + ChatColor.AQUA + df.format(this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName().toLowerCase() + ".money")));
					this.plugin.last_bank_withdraw_use_time=0;
				} else {
					try {
						val = Double.parseDouble(e.getMessage());
						//Make sure the user is holding at least that much money.
						this.plugin.compoundInterest(e.getPlayer());
						if (this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName().toLowerCase() + ".money")>=val && val>0) {
							//Deposit the money into their account.
							//this.plugin.economy.bankDeposit(e.getPlayer().getName(), val);
							this.plugin.economy.depositPlayer(e.getPlayer().getName(), val);
							double mymoney = this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName().toLowerCase() + ".money");
							this.plugin.getAccountsConfig().set(e.getPlayer().getName().toLowerCase() + ".money", Double.valueOf(mymoney-val));
							//this.plugin.saveAccountsConfig();
							e.getPlayer().sendMessage(ChatColor.GREEN+"Withdrawed $" + df.format(val) + " from your account. " + ChatColor.YELLOW + "New Bank Balance: $" + ChatColor.AQUA + df.format(this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName().toLowerCase() + ".money")));
							this.plugin.last_bank_withdraw_use_time=0;
						} else {
							e.getPlayer().sendMessage(ChatColor.RED+"You do not have that much! " + ChatColor.YELLOW +"Enter a value equal to or lower than $" + ChatColor.GREEN+ df.format(this.plugin.getAccountsConfig().getDouble(e.getPlayer().getName().toLowerCase() + ".money")) + "" + ChatColor.GRAY + ChatColor.ITALIC + " (Remember you can also use the word all)");
							this.plugin.last_bank_withdraw_use_time=Main.SERVER_TICK_TIME;
						}
					} catch (NumberFormatException ex_e) {
						e.getPlayer().sendMessage(ChatColor.RED+"That is not a valid amount! Please try again.");
						this.plugin.last_bank_withdraw_use_time=Main.SERVER_TICK_TIME;
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

	public boolean isItemCube(ItemStack item_cube) {
		return this.plugin.is_ItemCube(item_cube);
	}

	public void viewBookshelf(Player p, Location bookshelf_loc) {
		Inventory screen=Bukkit.createInventory(p, 9, "Bookshelf #"+bookshelf_loc.getBlockX()+"_"+bookshelf_loc.getBlockY()+"_"+bookshelf_loc.getBlockZ());
		FileConfiguration f = this.plugin.reloadBookshelfConfig(bookshelf_loc.getBlockX(),bookshelf_loc.getBlockY(),bookshelf_loc.getBlockZ());
		for (int i=0;i<9;i++) {
			if (f.contains("item-"+i)) {
				screen.setItem(i,f.getItemStack("item-"+i));
			}
		}
		final Player p2 = p;
		final Inventory screen2 = screen;
		  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
		      @Override
		      public void run() {
					p2.closeInventory();
					p2.openInventory(screen2);
		      }
		  	},1);
	}
	
	public void viewItemCube(Player p, ItemStack item_cube) {
		//This function will figure out what type of Item Cube this item is and then display the correct inventory on-screen, also setting up the identifier.
		Cube cube_type = null;
		int identifier=-1;
		if (isItemCube(item_cube)) {
			identifier = this.plugin.get_ItemCubeID(item_cube);
			cube_type = this.plugin.get_ItemCubeType(item_cube);
			if (identifier==-1) {
				//This doesn't have an identifier yet. Create a new one.
				identifier=this.plugin.getConfig().getInt("item-cube-numb");
				this.plugin.getConfig().set("item-cube-numb", Integer.valueOf(identifier+1));
				this.plugin.saveConfig();
				//See if this chest is stacked. If so, set the amount to 1, and drop a side inventory of Item Cubes.
				if (item_cube.getAmount()>1) {
					ItemStack newitem = item_cube.clone();
					newitem.setAmount(item_cube.getAmount()-1);
					item_cube.setAmount(1);
					//Drop the rest on the ground.
					p.getWorld().dropItemNaturally(p.getLocation(), newitem);
				}
				ItemMeta meta = item_cube.getItemMeta();
				List<String> newlore = meta.getLore();
				newlore.add("ID#"+identifier);
				meta.setLore(newlore);
				item_cube.setItemMeta(meta);

				if (cube_type == Cube.ENDER) {
					item_cube.setAmount(2);
				}
			}
			Inventory screen = null;
			switch (cube_type) {
			case SMALL: {
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
			}break;
			case LARGE: {
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
			}break;
			case ENDER: {
				FileConfiguration f = this.plugin.reloadItemCubeConfig(identifier);
				if (!f.contains("created")) {
					for (int i=0;i<27;i++) {
						f.set("item-"+i, new ItemStack(Material.AIR));
					}
					f.set("created", Boolean.valueOf(true));
				}
				//List<ItemStack> items = new ArrayList<ItemStack>();
				screen=Bukkit.createInventory(p, 27, "Ender Item Cube #"+identifier);
				for (int i=0;i<27;i++) {
					//items.add(f.getItemStack("item-"+i));
					screen.setItem(i, f.getItemStack("item-"+i));
				}
				this.plugin.saveItemCubeConfig(f, identifier);
			}break;
			}
			if (screen!=null) {
				final Player p2 = p;
				final Inventory screen2 = screen;
			  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
			      @Override
			      public void run() {
						p2.closeInventory();
						p2.openInventory(screen2);
			      }
			  	},1);
			}
		}
	}

	public void Bookshelf_attemptUpdate(final int amt,final int count,final Player p) {
		Bookshelf_attemptUpdate(amt,count,p,0);
	}
	
	public void Bookshelf_attemptUpdate(final int amt,final int count,final Player p,int tracking_amt) {
		int cur_amt=0;
		int cur_count=0;
		p.updateInventory();
		for (int i=0;i<p.getOpenInventory().getTopInventory().getContents().length;i++) {
			if (p.getOpenInventory().getTopInventory().getContents()[i]!=null) {
				cur_amt+=p.getOpenInventory().getTopInventory().getContents()[i].getAmount();
				cur_count++;
			}
		}
		//Bukkit.getLogger().info("Compare "+cur_amt+" to "+amt+".");
		if (cur_amt!=amt || cur_count!=count) {
			Bookshelf_save(p, getViewingBookshelfID(p));
			Bookshelf_updateSameBookshelf(getViewingBookshelfID(p),p);
			Main.book_shelf_active=true;
		} else {
			final int new_amt = cur_amt;
			final int new_count = cur_count;
			final int new_track = tracking_amt++;
		  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
		      @Override
		      public void run() {
		    	  Bookshelf_attemptUpdate(new_amt,new_count,p,new_track);
		      }
		  	},1);
		}
	}
	
	public void ItemCube_attemptUpdate(final int amt,final int count,final Player p) {
		ItemCube_attemptUpdate(amt,count,p,0);
	}
	
	public void ItemCube_attemptUpdate(final int amt,final int count,final Player p,int tracking_amt) {
		int cur_amt=0;
		int cur_count=0;
		p.updateInventory();
		for (int i=0;i<p.getOpenInventory().getTopInventory().getContents().length;i++) {
			if (p.getOpenInventory().getTopInventory().getContents()[i]!=null) {
				cur_amt+=p.getOpenInventory().getTopInventory().getContents()[i].getAmount();
				cur_count++;
			}
		}
		//Bukkit.getLogger().info("Compare "+cur_amt+" to "+amt+".");
		if (cur_amt!=amt || cur_count!=count) {
			ItemCube_save(p, getViewingEnderCubeID(p), Cube.ENDER);
			ItemCube_updateSameEnderCube(getViewingEnderCubeID(p),p);
			Main.ender_cube_active=true;
		} else {
			final int new_amt = cur_amt;
			final int new_count = cur_count;
			final int new_track = tracking_amt++;
		  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
		      @Override
		      public void run() {
		    	  ItemCube_attemptUpdate(new_amt,new_count,p,new_track);
		      }
		  	},1);
		}
	}

	public boolean isViewingBookshelf(Player p) {
		//Returns whether or not this player is viewing a bookshelf.
		//This is useful for determining if you have to update the bookshelf for other viewers.
		if (p.getOpenInventory().getTopInventory()!=null && p.getOpenInventory().getTopInventory().getTitle().contains("Bookshelf")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isViewingEnderCube(Player p) {
		//Returns whether or not this player is viewing an ender cube.
		//This is useful for determining if you have to update the ender cube for other viewers.
		if (p.getOpenInventory().getTopInventory()!=null && p.getOpenInventory().getTopInventory().getTitle().contains("Ender Item Cube")) {
			return true;
		} else {
			return false;
		}
	}

	public Location getViewingBookshelfID(Player p) {
		if (p.getOpenInventory().getTopInventory()!=null && p.getOpenInventory().getTopInventory().getTitle().contains("Bookshelf")) {
			String[] newloc = p.getOpenInventory().getTopInventory().getTitle().substring(p.getOpenInventory().getTopInventory().getTitle().indexOf("#")).replace("#", "").split("_");
			return new Location(Bukkit.getWorld("world"),Integer.valueOf(newloc[0]),Integer.valueOf(newloc[1]),Integer.valueOf(newloc[2]));
		} else {
			return null; //Invalid use.
		}
	}
	
	public int getViewingEnderCubeID(Player p) {
		//Returns whether or not this player is viewing an ender cube.
		//This is useful for determining if you have to update the ender cube for other viewers.
		if (p.getOpenInventory().getTopInventory()!=null && p.getOpenInventory().getTopInventory().getTitle().contains("Ender Item Cube")) {
			return Integer.valueOf(p.getOpenInventory().getTopInventory().getTitle().substring(p.getOpenInventory().getTopInventory().getTitle().indexOf("#")).replace("#", ""));
		} else {
			return -1; //Invalid use.
		}
	}

	public void ItemCube_updateSameEnderCube(int cube_id, Player player) {
		//If a player attempts to do something in an Ender Cube, update the Ender Cube for all other viewers that is not player. (The player argument is the player making modifications to the inventory.)
		for (int i=0;i<Bukkit.getOnlinePlayers().length;i++) {
			if (!Bukkit.getOnlinePlayers()[i].getName().equals(player.getName())) {
				if (Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory()!=null) {
					//Check if it's the same ID.
					if (Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory().getTitle().contains("Ender Item Cube") && Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory().getTitle().length()>0) {
						if (Integer.valueOf(Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory().getTitle().substring(Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory().getTitle().indexOf("#")).replace("#", ""))==cube_id) {
							//It is! We need to close it out and re-open with the updated properties of the cube.							
							final int i2 = i;
							final int cube_id2 = cube_id;
							ItemCube_load(Bukkit.getOnlinePlayers()[i2], cube_id2, Cube.ENDER);
							//Bukkit.getLogger().info("Re-loading Item Cube for "+Bukkit.getOnlinePlayers()[i].getName());
						}
					}
				}
			}
		}
	}
	
	public void Bookshelf_updateSameBookshelf(Location bookshelf_id, Player player) {
		//If a player attempts to do something in a Bookshelf, update the Bookshelf for all other viewers that is not player. (The player argument is the player making modifications to the inventory.)
		for (int i=0;i<Bukkit.getOnlinePlayers().length;i++) {
			if (!Bukkit.getOnlinePlayers()[i].getName().equals(player.getName())) {
				if (Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory()!=null) {
					//Check if it's the same ID.
					if (Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory().getTitle().contains("Bookshelf") && Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory().getTitle().length()>0) {
						//Bukkit.getLogger().info("Check inventory title: "+Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory().getTitle().substring(Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory().getTitle().indexOf("#")).replace("#", ""));
						if (Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory().getTitle().substring(Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory().getTitle().indexOf("#")).replace("#", "").equalsIgnoreCase(bookshelf_id.getBlockX()+"_"+bookshelf_id.getBlockY()+"_"+bookshelf_id.getBlockZ())) {
							//It is! We need to close it out and re-open with the updated properties of the cube.							
							final int i2 = i;
							final Location bookshelf_id2 = bookshelf_id;
							Bookshelf_load(Bukkit.getOnlinePlayers()[i2], bookshelf_id2);
							//Bukkit.getLogger().info("Re-loading Item Cube for "+Bukkit.getOnlinePlayers()[i].getName());
						}
					}
				}
			}
		}
	}

	private void ItemCube_addSameEnderCube(ItemStack add_item, int cube_id, Player player) {
		//Helper function for ItemCube_add.
		//Checks for any players that are viewing the same Ender Item Cube as player, and updating it accordingly so the changes are reflected.
		for (int i=0;i<Bukkit.getOnlinePlayers().length;i++) {
			if (!Bukkit.getOnlinePlayers()[i].equals(player)) {
				if (Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory()!=null) {
					//Check if it's the same ID.
					if (Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory().getTitle().contains("Ender Item Cube") && Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory().getTitle().length()>0) {
						if (Integer.valueOf(Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory().getTitle().substring(Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory().getTitle().indexOf("#")).replace("#", ""))==cube_id) {
							//It is! "Add" it to that inventory list too.
							Bukkit.getOnlinePlayers()[i].getOpenInventory().getTopInventory().addItem(add_item);
						}
					}
				}
			}
		}
	}

	private void Bookshelf_save(Player p, Location loc) {
		FileConfiguration f = this.plugin.reloadBookshelfConfig(loc.getBlockX(),loc.getBlockY(),loc.getBlockZ());
		int slots = -1;
		String heading = "";
		for (int i=0;i<p.getOpenInventory().getTopInventory().getContents().length;i++) {
			f.set("item-"+i, p.getOpenInventory().getTopInventory().getItem(i));
		}
		this.plugin.saveBookshelfConfig(f, loc.getBlockX(),loc.getBlockY(),loc.getBlockZ());
	}
	
	private void ItemCube_save(Player p, int identifier, Cube size) {
		FileConfiguration f = this.plugin.reloadItemCubeConfig(identifier);
		int slots = -1;
		String heading = "";
		switch (size) {
			case SMALL: {
				slots = 9;
				heading = "";
			}break;
			case LARGE: {
				slots = 54;
				heading = "Large";
			}break;
			case ENDER: {
				slots = 27;
				heading = "Ender";
			}break;
		}
		for (int i=0;i<p.getOpenInventory().getTopInventory().getContents().length;i++) {
			f.set("item-"+i, p.getOpenInventory().getTopInventory().getItem(i));
		}
		this.plugin.saveItemCubeConfig(f, identifier);
	}

	private void Bookshelf_load(Player p, Location loc) {
		FileConfiguration f = this.plugin.reloadBookshelfConfig(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
		int slots = -1;
		String heading = "";
		p.getOpenInventory().getTopInventory().clear();
		for (int i=0;i<9;i++) {
			//items.add(f.getItemStack("item-"+i));
			if (f.contains("item-"+i)) {
				p.getOpenInventory().getTopInventory().addItem(f.getItemStack("item-"+i));
				//Bukkit.getLogger().info("Reloading item "+f.getItemStack("item-"+i).toString());
			}
		}
		p.updateInventory();
	}
	
	private void ItemCube_load(Player p, int identifier, Cube size) {
		FileConfiguration f = this.plugin.reloadItemCubeConfig(identifier);
		int slots = -1;
		String heading = "";
		switch (size) {
			case SMALL: {
				slots = 9;
				heading = "";
			}break;
			case LARGE: {
				slots = 54;
				heading = "Large";
			}break;
			case ENDER: {
				slots = 27;
				heading = "Ender";
			}break;
		}
		p.getOpenInventory().getTopInventory().clear();
		for (int i=0;i<slots;i++) {
			//items.add(f.getItemStack("item-"+i));
			if (f.contains("item-"+i)) {
				p.getOpenInventory().getTopInventory().addItem(f.getItemStack("item-"+i));
				//Bukkit.getLogger().info("Reloading item "+f.getItemStack("item-"+i).toString());
			}
		}
		p.updateInventory();
	}

	private ItemStack ItemCube_add(Player p, int identifier, Cube size, ItemStack insert_item) {
		//Helper function for InsertIntoItemCube(). Inserts the item into the correct cube.
		//If this is an Ender Item Cube, also attempts to refresh the inventories of any players viewing it.

		int slots = 0;

		String heading = "";

		switch (size) {
		case SMALL: {
			slots = 9;
			heading = "";
		}break;
		case LARGE: {
			slots = 54;
			heading = "Large";
		}break;
		case ENDER: {
			slots = 27;
			heading = "Ender";
		}break;
		}

		if (!heading.equalsIgnoreCase("")) {
			heading+=" "; //Add a space to separate the heading from "Item Cube".
		}

		FileConfiguration f = this.plugin.reloadItemCubeConfig(identifier);
		if (!f.contains("created")) {
			for (int i=0;i<slots;i++) {
				f.set("item-"+i, new ItemStack(Material.AIR));
			}
			//f.set("item-0", insert_item);
			f.set("created", Boolean.valueOf(true));
			//return insert_item;
		}
		//We need to see if we have the inventory opened already...If so we have to add it to THAT one.
		Inventory thisinven=Bukkit.createInventory(p, slots, heading+"Item Cube #"+identifier);
		boolean changeinven=false;
		if (p.getOpenInventory().getTopInventory().getTitle().contains(heading+"Item Cube") && p.getOpenInventory().getTopInventory().getTitle().length()>0) {
			if (Integer.valueOf(p.getOpenInventory().getTopInventory().getTitle().substring(p.getOpenInventory().getTopInventory().getTitle().indexOf("#")).replace("#", ""))==identifier) {
				thisinven=p.getOpenInventory().getTopInventory();
				changeinven=true;
			}
		} 
		if (!changeinven) {
			for (int i=0;i<slots;i++) {
				//items.add(f.getItemStack("item-"+i));
				if (f.contains("item-"+i)) {
					thisinven.addItem(f.getItemStack("item-"+i));
				}
			}
		}
		int countinven = countSpace(thisinven,insert_item);
		if (countinven>=insert_item.getAmount()) {
			//We can simply add it in no problem.
			thisinven.addItem(insert_item);
			for (int i=0;i<thisinven.getContents().length;i++) {
				f.set("item-"+i, thisinven.getItem(i));
			}
			this.plugin.saveItemCubeConfig(f, identifier);
			if (size == Cube.ENDER) {
				//This is an Ender Item Cube. We have to check if any other players are looking at the correspnding Ender Item Cube inventory.
				ItemCube_addSameEnderCube(insert_item, identifier, p);
			}
			return new ItemStack(Material.AIR);
		} else 
			if (countinven>0) {
				//We can at least fit a few.
				int fit = insert_item.getAmount()-countinven;
				//Leave behind this many.
				ItemStack thisitem = insert_item, thisitem2 = insert_item;
				thisitem.setAmount(fit);
				//Bukkit.getPlayer("sigonasr2").sendMessage("Cursor gets "+thisitem.getAmount());
				thisitem2.setAmount(countinven);
				thisinven.addItem(thisitem2);
				if (size == Cube.ENDER) {
					//This is an Ender Item Cube. We have to check if any other players are looking at the correspnding Ender Item Cube inventory.
					ItemCube_addSameEnderCube(thisitem2, identifier, p);
				}
				//Bukkit.getPlayer("sigonasr2").sendMessage("Item Cube gets "+thisitem2.getAmount());
				for (int i=0;i<thisinven.getContents().length;i++) {
					f.set("item-"+i, thisinven.getItem(i));
				}
				this.plugin.saveItemCubeConfig(f, identifier);
				p.updateInventory();
				return thisitem;
			}
			else {
				//Well, we can't do anything, just treat it as an item swap.
				this.plugin.saveItemCubeConfig(f, identifier);
				return new ItemStack(insert_item);
			}
	}

	public ItemStack insertIntoItemCube(Player p, ItemStack item_cube, ItemStack insert_item) {
		//This function will attmempt to insert an item into an item cube. It actually returns whatever cannot fit into the
		//item cube after attempting to insert it.

		//We have to attempt to insert the item in the Item Cube.
		Cube cube_type = null;
		int identifier=-1;
		if (item_cube.getItemMeta().getLore()!=null && isItemCube(item_cube)) {
			//Check to see if the Lore contains anything.
			for (int i=0;i<item_cube.getItemMeta().getLore().size();i++) {
				if (item_cube.getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 9 item slots.")) {
					cube_type = Cube.SMALL;
				}
				if (item_cube.getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 54 item slots.")) {
					cube_type = Cube.LARGE;
				}
				if (item_cube.getItemMeta().getLore().get(i).equalsIgnoreCase(ChatColor.AQUA+"Contains 27 item slots.")) {
					cube_type = Cube.ENDER;
				}
				if (item_cube.getItemMeta().getLore().get(i).contains("ID#")) {
					identifier=Integer.valueOf(item_cube.getItemMeta().getLore().get(i).replace("ID#", ""));
				}
			}
			if (identifier==-1) {
				//This doesn't have an identifier yet. Create a new one.
				identifier=this.plugin.getConfig().getInt("item-cube-numb");
				this.plugin.getConfig().set("item-cube-numb", Integer.valueOf(identifier+1));
				this.plugin.saveConfig();
				//See if this chest is stacked. If so, set the amount to 1, and drop a side inventory of Item Cubes.
				if (item_cube.getAmount()>1) {
					ItemStack newitem = item_cube.clone();
					newitem.setAmount(item_cube.getAmount()-1);
					item_cube.setAmount(1);
					//Drop the rest on the ground.
					p.getWorld().dropItemNaturally(p.getLocation(), newitem);
				}
				ItemMeta meta = item_cube.getItemMeta();
				List<String> newlore = meta.getLore();
				newlore.add("ID#"+identifier);
				meta.setLore(newlore);
				item_cube.setItemMeta(meta);
				if (cube_type == Cube.ENDER) {
					item_cube.setAmount(2);
				}
			}
			return ItemCube_add(p, identifier, cube_type, insert_item);
		}
		return new ItemStack(insert_item); //Something went wrong. Just return the item itself so it's back to the player. So we don't get rid of it.
	}
	
	void getBuilderCredit(Block b, Player p) {
		int myData = this.plugin.getPlayerDataSlot(p);
		if (this.plugin.PlayerinJob(p, "Builder")) {
			int beforeexp = (int)this.plugin.getPlayerCurrentJobExp(p, "Builder");
			if (this.plugin.playerdata_list.get(myData).GoodInteract()) {
				if (b.getType()==Material.COBBLESTONE) {
					this.plugin.gainMoneyExp(p,"Builder",0.005,1);
				}
				if (b.getType()==Material.WOOD) {
					this.plugin.gainMoneyExp(p,"Builder",0.005,2);
				}
				if (b.getType()==Material.LOG) {
					this.plugin.gainMoneyExp(p,"Builder",0.01,3);
				}
				if (b.getType()==Material.WOOD_STEP) {
					this.plugin.gainMoneyExp(p,"Builder",0.015,3);
				}
				if (b.getType()==Material.COBBLESTONE_STAIRS) {
					this.plugin.gainMoneyExp(p,"Builder",0.015,3);
				}
				if (b.getType()==Material.STONE) {
					this.plugin.gainMoneyExp(p,"Builder",0.015,4);
				}
				if (b.getType()==Material.FENCE) {
					this.plugin.gainMoneyExp(p,"Builder",0.015,3);
				}
				if (b.getType()==Material.STEP) {
					switch (b.getData()) {
					case 0:{
						this.plugin.gainMoneyExp(p,"Builder",0.02,4);
					}break;
					case 1:{
						this.plugin.gainMoneyExp(p,"Builder",0.025,4);
					}break;
					case 3:{
						this.plugin.gainMoneyExp(p,"Builder",0.015,3);
					}break;
					case 4:{
						this.plugin.gainMoneyExp(p,"Builder",0.05,9);
					}break;
					case 5:{
						this.plugin.gainMoneyExp(p,"Builder",0.03,5);
					}break;
					case 6:{
						this.plugin.gainMoneyExp(p,"Builder",0.03,5);
					}break;
					case 7:{
						this.plugin.gainMoneyExp(p,"Builder",0.06,12);
					}break;
					case 8:{
						this.plugin.gainMoneyExp(p,"Builder",0.02,4);
					}break;
					case 9:{
						this.plugin.gainMoneyExp(p,"Builder",0.025,4);
					}break;
					case 10:{
						this.plugin.gainMoneyExp(p,"Builder",0.015,3);
					}break;
					case 11:{
						this.plugin.gainMoneyExp(p,"Builder",0.015,3);
					}break;
					case 12:{
						this.plugin.gainMoneyExp(p,"Builder",0.05,9);
					}break;
					case 13:{
						this.plugin.gainMoneyExp(p,"Builder",0.03,5);
					}break;
					case 14:{
						this.plugin.gainMoneyExp(p,"Builder",0.03,5);
					}break;
					case 15:{
						this.plugin.gainMoneyExp(p,"Builder",0.06,12);
					}break;
					}
				}
				if (b.getType()==Material.WOOD_STAIRS) {
					this.plugin.gainMoneyExp(p,"Builder",0.02,4);
				}
				if (b.getType()==Material.LAPIS_BLOCK) {
					this.plugin.gainMoneyExp(p,"Builder",0.02,3);
				}
				if (b.getType()==Material.COBBLE_WALL) {
					this.plugin.gainMoneyExp(p,"Builder",0.025,5);
				}
				if (b.getType()==Material.NETHER_BRICK_STAIRS) {
					this.plugin.gainMoneyExp(p,"Builder",0.025,5);
				}
				if (b.getType()==Material.NETHER_BRICK) {
					this.plugin.gainMoneyExp(p,"Builder",0.03,5);
				}
				if (b.getType()==Material.NETHER_FENCE) {
					this.plugin.gainMoneyExp(p,"Builder",0.03,6);
				}
				if (b.getType()==Material.WOOL) {
					this.plugin.gainMoneyExp(p,"Builder",0.035,7);
				}
				if (b.getType()==Material.getMaterial(109)) {
					this.plugin.gainMoneyExp(p,"Builder",0.04,8);
				}
				if (b.getType()==Material.getMaterial(98)) {
					this.plugin.gainMoneyExp(p,"Builder",0.04,8);
				}
				if (b.getType()==Material.GLASS) {
					this.plugin.gainMoneyExp(p,"Builder",0.04,8);
				}
				if (b.getType()==Material.GLOWSTONE) {
					this.plugin.gainMoneyExp(p,"Builder",0.05,10);
				}
				if (b.getType()==Material.HARD_CLAY) {
					this.plugin.gainMoneyExp(p,"Builder",0.05,10);
				}
				if (b.getType()==Material.STAINED_CLAY) {
					this.plugin.gainMoneyExp(p,"Builder",0.05,10);
				}
				if (b.getType()==Material.SANDSTONE_STAIRS) {
					this.plugin.gainMoneyExp(p,"Builder",0.05,10);
				}
				if (b.getType()==Material.SANDSTONE) {
					this.plugin.gainMoneyExp(p,"Builder",0.06,10);
				}
				if (b.getType()==Material.QUARTZ_STAIRS) {
					this.plugin.gainMoneyExp(p,"Builder",0.06,12);
				}
				if (b.getType()==Material.IRON_FENCE) {
					this.plugin.gainMoneyExp(p,"Builder",0.06,12);
				}
				if (b.getType()==Material.BRICK_STAIRS) {
					this.plugin.gainMoneyExp(p,"Builder",0.065,9);
				}
				if (b.getType()==Material.QUARTZ_BLOCK) {
					this.plugin.gainMoneyExp(p,"Builder",0.07,14);
				}
				if (b.getType()==Material.BRICK) {
					this.plugin.gainMoneyExp(p,"Builder",0.075,11);
				}
			}
			if (this.plugin.hasJobBuff("Builder", p, Job.JOB40)) {
				for (int i=beforeexp;i<(int)this.plugin.getPlayerCurrentJobExp(p, "Builder");i++) {
					if (i%100==0) {
						//Give the player 5 glowstone + 64 torches.
						p.getInventory().addItem(new ItemStack(Material.GLOWSTONE,5),new ItemStack(Material.TORCH,64));
					}
				}
			}
		}
	}
	
	public boolean isFood(ItemStack i) {
		if (i.getType()==Material.RAW_FISH ||
				i.getType()==Material.ROTTEN_FLESH ||
				i.getType()==Material.COOKIE ||
				i.getType()==Material.CAKE ||
				i.getType()==Material.POTATO ||
				i.getType()==Material.MELON ||
				i.getType()==Material.POISONOUS_POTATO ||
				i.getType()==Material.RAW_CHICKEN ||
				i.getType()==Material.RAW_BEEF ||
				i.getType()==Material.PORK ||
				i.getType()==Material.APPLE ||
				i.getType()==Material.PUMPKIN_PIE ||
				i.getType()==Material.CARROT_ITEM ||
				i.getType()==Material.COOKED_FISH ||
				i.getType()==Material.BREAD ||
				i.getType()==Material.MUSHROOM_SOUP ||
				i.getType()==Material.COOKED_CHICKEN ||
				i.getType()==Material.BAKED_POTATO ||
				i.getType()==Material.SPIDER_EYE ||
				i.getType()==Material.COOKED_BEEF ||
				i.getType()==Material.GRILLED_PORK ||
				i.getType()==Material.GOLDEN_APPLE ||
				i.getType()==Material.GOLDEN_CARROT) {
			return true;
		} else {
			return false;
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
		
		/* WORKS!!! Now INTEGRATE! */
		/*if (e.getAction()==Action.LEFT_CLICK_AIR) {
			//Save the region around ourself.
			 WorldEditPlugin wep = (WorldEditPlugin)Bukkit.getPluginManager().getPlugin("WorldEdit");
			 final TerrainManager tm = new TerrainManager(wep, p);
			  final Location loc1 = new Location(p.getWorld(),p.getLocation().getBlockX()-32,0,p.getLocation().getBlockZ()-32);
			  final Location loc2 = new Location(p.getWorld(),p.getLocation().getBlockX()+32,128,p.getLocation().getBlockZ()+32);
			  final File saveFile = new File("plugins/WorldEdit/schematics/world_save");
			  try {
				  tm.saveTerrain(saveFile, loc1, loc2);
				} catch (FilenameException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (DataException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
		}
		if (e.getAction()==Action.RIGHT_CLICK_AIR) {
			File file = new File("plugins/WorldEdit/schematics/world_save.schematic");
		    if (file.exists()) {
		        try {
		            com.sk89q.worldedit.Vector v = new com.sk89q.worldedit.Vector(p.getLocation().getX()+8, p.getLocation().getY(), p.getLocation().getZ()+8);
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
		}*/
		
		if (p.hasPotionEffect(PotionEffectType.BLINDNESS)) {
			e.setCancelled(true);
			return;
		}
		
		//******************************//All Job Buff related items go in here.
		if (e.getAction()==Action.RIGHT_CLICK_BLOCK && this.plugin.hasJobBuff("Miner", p, Job.JOB20)) {
			// Right click miner buff
			int myData=this.plugin.getPlayerDataSlot(p);
			
			if (p.getItemInHand().getType()==Material.DIAMOND_PICKAXE && (e.getClickedBlock().getType()==Material.STONE || e.getClickedBlock().getType()==Material.COBBLESTONE)) {
				boolean has_silktouch = p.getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH);
				for (int i=-1;i<2;i++) {
					for (int j=-1;j<2;j++) {
						for (int k=-1;k<2;k++) {
							if (e.getClickedBlock().getLocation().add(i,j,k).getBlock().getType().name().toLowerCase().contains("ore")) {
								destroyNearbyOres(e.getClickedBlock().getWorld(), p, e.getClickedBlock().getLocation(), has_silktouch, 4);
							} else {
								if (this.plugin.PlayerinJob(p, "Miner")) {
									myData=this.plugin.getPlayerDataSlot(p);
									if (this.plugin.playerdata_list.get(myData).GoodInteract()) {
										if (e.getClickedBlock().getType()==Material.STONE) {
											this.plugin.gainMoneyExp(p,"Miner",0.0025,1);
										}
									}
								}
								if (e.getClickedBlock().getLocation().add(i,j,k).getBlock().getType()==Material.STONE || e.getClickedBlock().getLocation().add(i,j,k).getBlock().getType()==Material.COBBLESTONE) {
									
									if (has_silktouch) {
										e.getClickedBlock().getWorld().dropItemNaturally(e.getClickedBlock().getLocation().add(i,j,k), new ItemStack(e.getClickedBlock().getLocation().add(i,j,k).getBlock().getType()));
									} else {
										e.getClickedBlock().getWorld().dropItemNaturally(e.getClickedBlock().getLocation().add(i,j,k), new ItemStack(Material.COBBLESTONE));
									}
									
									e.getClickedBlock().breakNaturally(p.getItemInHand());
									e.getClickedBlock().getLocation().add(i,j,k).getBlock().setType(Material.AIR);
								}
							}
						}
					}
				}
			}
		}
		
		if (e.getAction()==Action.LEFT_CLICK_BLOCK && this.plugin.hasJobBuff("Woodcutter", p, Job.JOB5)) {
			if (e.getClickedBlock().getType()==Material.LEAVES) {
				if ((e.getClickedBlock().getData()<4 || e.getClickedBlock().getData()>7) && e.getClickedBlock().getData()%4==0) {
					//This is Oak Leaves that were NOT placed by a player.
					//Bukkit.getLogger().info("A Valid oak leaf! Apple!");
					if (this.plugin.hasJobBuff("Woodcutter", p, Job.JOB20)) {
						if (Math.random()<=0.02) {
							p.getWorld().dropItemNaturally(e.getClickedBlock().getLocation(), new ItemStack(Material.APPLE));
						}
					}
				}
				e.getClickedBlock().setType(Material.AIR);
				p.playSound(e.getClickedBlock().getLocation(), Sound.DIG_GRASS, 1, 1);
				p.getWorld().playEffect(e.getClickedBlock().getLocation(), Effect.STEP_SOUND, Material.LEAVES.getId());
				//Randomly drop a sapling based on type.
				if (e.getClickedBlock().getData()%4==3) {
					//This is a jungle leaf.
					if (Math.random()<=0.025) {
						e.getClickedBlock().getWorld().dropItemNaturally(e.getClickedBlock().getLocation(), new ItemStack(Material.SAPLING,1,(short)(e.getClickedBlock().getData()%4)));
					}
				} else {
					if (Math.random()<=0.05) {
						e.getClickedBlock().getWorld().dropItemNaturally(e.getClickedBlock().getLocation(), new ItemStack(Material.SAPLING,1,(short)(e.getClickedBlock().getData()%4)));
					}
				}
			}
		}
		if (e.getAction()==Action.RIGHT_CLICK_BLOCK && p.getItemInHand().getType()==Material.SAPLING && (e.getClickedBlock().getType()==Material.GRASS || e.getClickedBlock().getType()==Material.DIRT) && this.plugin.hasJobBuff("Woodcutter", p, Job.JOB30B)) {
			//Instantly grow the tree!
			//Check out the data value of the sapling.
			Byte data = p.getItemInHand().getData().getData();
			//Bukkit.getLogger().info("Data value for this sapling: "+data.toString());
			int tries=0;
            BukkitWorld BWf = new BukkitWorld(p.getWorld());
            EditSession es = new EditSession(BWf, 1000); //STart a new editing session to create trees.
			switch (data) {
				case (byte)0: {
					//This is a normal sapling. see if we're in a swamp biome.
					//Bukkit.getLogger().info("This is a normal sapling!");
					if (e.getClickedBlock().getWorld().getBiome(e.getClickedBlock().getLocation().getBlockX(), e.getClickedBlock().getLocation().getBlockZ())==Biome.SWAMPLAND) {
						if (Math.random()<=0.90) {
							while (tries<100) {
								//e.getClickedBlock().getWorld().generateTree(e.getClickedBlock().getLocation().add(0,1,0), TreeType.SWAMP);
								BWf.generateTree(TreeType.SWAMP, es, new com.sk89q.worldedit.Vector(e.getClickedBlock().getLocation().add(0,1,0).getX(),e.getClickedBlock().getLocation().add(0,1,0).getY(),e.getClickedBlock().getLocation().add(0,1,0).getZ()));
								tries++;
							}
						} else {
							while (tries<100) {
								BWf.generateTree(TreeType.TREE, es, new com.sk89q.worldedit.Vector(e.getClickedBlock().getLocation().add(0,1,0).getX(),e.getClickedBlock().getLocation().add(0,1,0).getY(),e.getClickedBlock().getLocation().add(0,1,0).getZ()));
								tries++;
							}
						}
					} else {
						if (Math.random()<=0.90) {
							while (tries<100) {
								BWf.generateTree(TreeType.TREE, es, new com.sk89q.worldedit.Vector(e.getClickedBlock().getLocation().add(0,1,0).getX(),e.getClickedBlock().getLocation().add(0,1,0).getY(),e.getClickedBlock().getLocation().add(0,1,0).getZ()));
								tries++;
							}
						} else {
							while (tries<100) {
								BWf.generateTree(TreeType.BIG_TREE, es, new com.sk89q.worldedit.Vector(e.getClickedBlock().getLocation().add(0,1,0).getX(),e.getClickedBlock().getLocation().add(0,1,0).getY(),e.getClickedBlock().getLocation().add(0,1,0).getZ()));
								tries++;
							}
						}
					}
				}break;
				case (byte)1: {
					while (tries<100) {
						/*
						e.getClickedBlock().getWorld().generateTree(e.getClickedBlock().getLocation().add(0,1,0), TreeType.REDWOOD);
						e.getClickedBlock().getWorld().generateTree(e.getClickedBlock().getLocation().add(0,1,0), com.sk89q.worldedit.blocks.tr);*/
						BWf.generateTree(TreeType.PINE, es, new com.sk89q.worldedit.Vector(e.getClickedBlock().getLocation().add(0,1,0).getX(),e.getClickedBlock().getLocation().add(0,1,0).getY(),e.getClickedBlock().getLocation().add(0,1,0).getZ()));
						BWf.generateTree(TreeType.REDWOOD, es, new com.sk89q.worldedit.Vector(e.getClickedBlock().getLocation().add(0,1,0).getX(),e.getClickedBlock().getLocation().add(0,1,0).getY(),e.getClickedBlock().getLocation().add(0,1,0).getZ()));
						BWf.generateTree(TreeType.TALL_REDWOOD, es, new com.sk89q.worldedit.Vector(e.getClickedBlock().getLocation().add(0,1,0).getX(),e.getClickedBlock().getLocation().add(0,1,0).getY(),e.getClickedBlock().getLocation().add(0,1,0).getZ()));
						tries++;
					}
				}break;
				case (byte)2: {
					while (tries<100) {
						BWf.generateTree(TreeType.BIRCH, es, new com.sk89q.worldedit.Vector(e.getClickedBlock().getLocation().add(0,1,0).getX(),e.getClickedBlock().getLocation().add(0,1,0).getY(),e.getClickedBlock().getLocation().add(0,1,0).getZ()));
						tries++;
					}
				}break;
				case (byte)3: {
					if (Math.random()<=0.90) {
						while (tries<100) {
							BWf.generateTree(TreeType.SHORT_JUNGLE, es, new com.sk89q.worldedit.Vector(e.getClickedBlock().getLocation().add(0,1,0).getX(),e.getClickedBlock().getLocation().add(0,1,0).getY(),e.getClickedBlock().getLocation().add(0,1,0).getZ()));
							tries++;
						}
					} else {
						while (tries<100) {
							BWf.generateTree(TreeType.JUNGLE, es, new com.sk89q.worldedit.Vector(e.getClickedBlock().getLocation().add(0,1,0).getX(),e.getClickedBlock().getLocation().add(0,1,0).getY(),e.getClickedBlock().getLocation().add(0,1,0).getZ()));
							tries++;
						}
					}
				}break;
			}
		}
		if (e.getAction()==Action.LEFT_CLICK_BLOCK || e.getAction()==Action.RIGHT_CLICK_AIR) {
			if (this.plugin.hasJobBuff("Builder", p, Job.JOB10)) {
				//See if they are holding a line tool.
				if (p.getItemInHand().getType()==Material.getMaterial(142)) {
					//Check to see if this is the first block they clicked.
					Block checkblock = null;
					if (e.getAction()==Action.RIGHT_CLICK_AIR) {
						checkblock = p.getTargetBlock(null, 10);
					} else {
						checkblock=e.getClickedBlock();
					}
					PlayerData pd = this.plugin.getPlayerData(p);
					if (pd.GetClickedBlock()==null) {
						p.sendMessage("Set first block. Left-click another block of the same type to build an outlined rectangle of that block between them.");
						p.sendMessage("Right-click another block of the same type to build a filled rectangle of that block between them. "+ChatColor.GRAY+ChatColor.ITALIC+"If you wish to cancel, swap items.");
						pd.SetClickedBlock(checkblock.getLocation());
					} else {
						if (pd.GetClickedBlock().distance(checkblock.getLocation())<=500) {//Make sure the range is small enough.
							if (this.plugin.hasJobBuff("Builder", p, Job.JOB30B)) {
								p.removePotionEffect(PotionEffectType.JUMP);
								p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,200,9));
							}
							if (this.plugin.hasJobBuff("Builder", p, Job.JOB40) && !p.getAllowFlight()) {
								p.setAllowFlight(true);
								p.sendMessage(ChatColor.DARK_GRAY+""+ChatColor.ITALIC+"Flight enabled...");
								this.plugin.getPlayerData(p).lastflighttime=Main.SERVER_TICK_TIME;
							} else {
								if (this.plugin.hasJobBuff("Builder", p, Job.JOB40)) {
									this.plugin.getPlayerData(p).lastflighttime=Main.SERVER_TICK_TIME;
								}
							}
							//Compare the blocks and see if they are the same.
							boolean successful=true;
							int expbefore = (int)this.plugin.getPlayerCurrentJobExp(p, "Builder");
							if (pd.GetClickedBlock().getBlock().getType().getId()==checkblock.getType().getId() &&
									pd.GetClickedBlock().getBlock().getData()==checkblock.getData()) {
								boolean ranOutOfBlocks=false;
								Location pt1 = pd.GetClickedBlock();
								Location pt2 = checkblock.getLocation();
								if (e.getAction()==Action.LEFT_CLICK_BLOCK) {
									//This is an outlined rectangle.
									int xdiff=pt2.getBlockX()-pt1.getBlockX();
									int ydiff=pt2.getBlockY()-pt1.getBlockY();
									int zdiff=pt2.getBlockZ()-pt1.getBlockZ();
									//Bukkit.getLogger().info("xdiff:"+xdiff+", ydiff:"+ydiff+", zdiff:"+zdiff);
									for (int x=0;x<Math.abs(xdiff)+1;x++) {
										for (int y=0;y<Math.abs(ydiff)+1;y++) {
											for (int z=0;z<Math.abs(zdiff)+1;z++) {
												//Iterate through all blocks, making sure we are on an outline.
												//Bukkit.getLogger().info("Check Loc: "+pt1.clone().add(x*Math.signum(xdiff),y*Math.signum(ydiff),z*Math.signum(zdiff)).toString());
												if (((x==0 || x==Math.abs(xdiff)) &&
														(y==0 || y==Math.abs(ydiff))) ||
													((x==0 || x==Math.abs(xdiff)) &&
															(z==0 || z==Math.abs(zdiff))) ||
													((y==0 || y==Math.abs(ydiff)) &&
															(z==0 || z==Math.abs(zdiff)))) {
													if (e.getPlayer().getWorld().getBlockAt(pt1.clone().add(x*Math.signum(xdiff),y*Math.signum(ydiff),z*Math.signum(zdiff))).getType()==Material.AIR) {
														if (e.getPlayer().getInventory().containsAtLeast(new ItemStack(pd.GetClickedBlock().getBlock().getType(),1,(short)pd.GetClickedBlock().getBlock().getData()), 1) || (
																pd.GetClickedBlock().getBlock().getType()==Material.DOUBLE_STEP && e.getPlayer().getInventory().containsAtLeast(new ItemStack(Material.STEP,1,(short)pd.GetClickedBlock().getBlock().getData()), 2))) {
															//Bukkit.getLogger().info("    Was AIR. Block has been changed.");
															//Get the amount holding. Then remove it and add one back for the player.
															ItemStack[] items = e.getPlayer().getInventory().getContents();
															//Loop through items until we find the right type.
															for (int i=0;i<items.length;i++) {
																if (items[i]!=null) {
																	if (items[i].getType().getId()==pd.GetClickedBlock().getBlock().getType().getId() &&
																			items[i].getData().getData()==pd.GetClickedBlock().getBlock().getData() || (
																					pd.GetClickedBlock().getBlock().getType()==Material.DOUBLE_STEP && items[i].getType()==Material.STEP && items[i].getData().getData()==pd.GetClickedBlock().getBlock().getData())) {
																		items[i].setAmount(items[i].getAmount()-1);
																		break;
																	}
																}
															}
															e.getPlayer().getInventory().setContents(items);
															e.getPlayer().getWorld().getBlockAt(pt1.clone().add(x*Math.signum(xdiff),y*Math.signum(ydiff),z*Math.signum(zdiff))).setType(pd.GetClickedBlock().getBlock().getType());
															e.getPlayer().getWorld().getBlockAt(pt1.clone().add(x*Math.signum(xdiff),y*Math.signum(ydiff),z*Math.signum(zdiff))).setData(pd.GetClickedBlock().getBlock().getData());
															getBuilderCredit(pd.GetClickedBlock().getBlock(),p);
														} else {
															//Bukkit.getLogger().info("====Cannot continue. Ran out of blocks. Exiting.");
															ranOutOfBlocks=true;
															successful=false;
														}
													} else {
														//Bukkit.getLogger().info("    Was "+e.getPlayer().getWorld().getBlockAt(pt1.clone().add(x*Math.signum(xdiff),y*Math.signum(ydiff),z*Math.signum(zdiff))).getType().name()+". Skipping...");
													}
												}
											}
										}
									}
								} else {
									//This is a filled rectangle.
									int xdiff=pt2.getBlockX()-pt1.getBlockX();
									int ydiff=pt2.getBlockY()-pt1.getBlockY();
									int zdiff=pt2.getBlockZ()-pt1.getBlockZ();
									for (int x=0;x<Math.abs(xdiff)+1;x++) {
										for (int y=0;y<Math.abs(ydiff)+1;y++) {
											for (int z=0;z<Math.abs(zdiff)+1;z++) {
												//Iterate through all blocks.
												//Bukkit.getLogger().info("Check Loc: "+pt1.clone().add(x*Math.signum(xdiff),y*Math.signum(ydiff),z*Math.signum(zdiff)).toString());
												if (e.getPlayer().getWorld().getBlockAt(pt1.clone().add(x*Math.signum(xdiff),y*Math.signum(ydiff),z*Math.signum(zdiff))).getType()==Material.AIR) {
													if (e.getPlayer().getInventory().containsAtLeast(new ItemStack(pd.GetClickedBlock().getBlock().getType(),1,(short)pd.GetClickedBlock().getBlock().getData()), 1) || (
															pd.GetClickedBlock().getBlock().getType()==Material.DOUBLE_STEP && e.getPlayer().getInventory().containsAtLeast(new ItemStack(Material.STEP,1,(short)pd.GetClickedBlock().getBlock().getData()), 2))) {
														//Bukkit.getLogger().info("    Was AIR. Block has been changed.");
														//Get the amount holding. Then remove it and add one back for the player.
														ItemStack[] items = e.getPlayer().getInventory().getContents();
														//Loop through items until we find the right type.
														for (int i=0;i<items.length;i++) {
															if (items[i]!=null) {
																if (items[i].getType().getId()==pd.GetClickedBlock().getBlock().getType().getId() &&
																		items[i].getData().getData()==pd.GetClickedBlock().getBlock().getData() || (
																				pd.GetClickedBlock().getBlock().getType()==Material.DOUBLE_STEP && items[i].getType()==Material.STEP && items[i].getData().getData()==pd.GetClickedBlock().getBlock().getData())) {
																	items[i].setAmount(items[i].getAmount()-1);
																	break;
																}
															}
														}
														e.getPlayer().getInventory().setContents(items);
														e.getPlayer().getWorld().getBlockAt(pt1.clone().add(x*Math.signum(xdiff),y*Math.signum(ydiff),z*Math.signum(zdiff))).setType(pd.GetClickedBlock().getBlock().getType());
														e.getPlayer().getWorld().getBlockAt(pt1.clone().add(x*Math.signum(xdiff),y*Math.signum(ydiff),z*Math.signum(zdiff))).setData(pd.GetClickedBlock().getBlock().getData());
														getBuilderCredit(pd.GetClickedBlock().getBlock(),p);
													} else {
														//Bukkit.getLogger().info("====Cannot continue. Ran out of blocks. Exiting.");
														ranOutOfBlocks=true;
														successful=false;
													}
												} else {
													//Bukkit.getLogger().info("    Was "+e.getPlayer().getWorld().getBlockAt(pt1.clone().add(x*Math.signum(xdiff),y*Math.signum(ydiff),z*Math.signum(zdiff))).getType().name()+". Skipping...");
												}
											}
										}
									}
								}
								pd.SetClickedBlock(null);
								if (successful) {
									p.sendMessage(ChatColor.YELLOW+"Rectangle Build completed successfully!");
									p.updateInventory();
								} else {
									if (ranOutOfBlocks) {
										p.sendMessage(ChatColor.GOLD+"You ran out of blocks! Stopped mid-way through building.");
										p.updateInventory();
									}
								}
								
								//Check exp
								if ((int)this.plugin.getPlayerCurrentJobExp(p, "Builder")-expbefore>0 && this.plugin.hasJobBuff("Builder", p, Job.JOB30A)) {
									ExperienceOrb orb = (ExperienceOrb)p.getWorld().spawnEntity(e.getClickedBlock().getLocation().add(0,1,0), EntityType.EXPERIENCE_ORB);
									orb.setExperience((int)this.plugin.getPlayerCurrentJobExp(p, "Builder")-expbefore);
								}
							} else {
								//If they are not, set it as the new target block.
								p.sendMessage("Set first block. Left-click another block of the same type to build an outlined rectangle of that block between them.");
								p.sendMessage("Right-click another block of the same type to build a filled rectangle of that block between them. "+ChatColor.GRAY+ChatColor.ITALIC+"If you wish to cancel, swap items.");
								pd.SetClickedBlock(checkblock.getLocation());
							}
						} else {
							p.sendMessage(ChatColor.RED+"The distance of building is larger than 500 blocks! You cannot build that far.");
						}
					}
					e.setCancelled(true);
					return;
				}
			}
			if (e.getAction()==Action.LEFT_CLICK_BLOCK && this.plugin.hasJobBuff("Builder", p, Job.JOB5)) {
				//See if they are holding a line tool.
				if (p.getItemInHand().getType()==Material.getMaterial(141)) {
					//Check to see if this is the first block they clicked.
					PlayerData pd = this.plugin.getPlayerData(p);
					if (pd.GetClickedBlock()==null) {
						p.sendMessage("Set first block. Left-click another block of the same type to build a line of that block between them. "+ChatColor.GRAY+ChatColor.ITALIC+"If you wish to cancel, right-click or swap items.");
						pd.SetClickedBlock(e.getClickedBlock().getLocation());
					} else {
						if (pd.GetClickedBlock().distance(e.getClickedBlock().getLocation())<=500) {//Make sure the range is small enough.
							if (this.plugin.hasJobBuff("Builder", p, Job.JOB30B)) {
								p.removePotionEffect(PotionEffectType.JUMP);
								p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,200,9));
							}
							if (this.plugin.hasJobBuff("Builder", p, Job.JOB40) && !p.getAllowFlight()) {
								p.setAllowFlight(true);
								p.sendMessage(ChatColor.DARK_GRAY+""+ChatColor.ITALIC+"Flight enabled...");
								this.plugin.getPlayerData(p).lastflighttime=Main.SERVER_TICK_TIME;
							} else {
								if (this.plugin.hasJobBuff("Builder", p, Job.JOB40)) {
									this.plugin.getPlayerData(p).lastflighttime=Main.SERVER_TICK_TIME;
								}
							}
							int expbefore = (int)this.plugin.getPlayerCurrentJobExp(p, "Builder");
							//Compare the blocks and see if they are the same.
							boolean successful=true;
							if (pd.GetClickedBlock().getBlock().getType().getId()==e.getClickedBlock().getType().getId() &&
									pd.GetClickedBlock().getBlock().getData()==e.getClickedBlock().getData()) {
								int xdiff=0;int ydiff=0;int zdiff=0; //Difference between these two locations.
								double xstep=1;double ystep=1;double zstep=1; //The amount of travel we can make for each direction, as we fully step in one direction.
								double xcur=0.5;double ycur=0.5;double zcur=0.5; //The current amount of travel we've made before shifting over on another axis.
								Location pt1 = pd.GetClickedBlock();
								Location pt2 = e.getClickedBlock().getLocation();
								xdiff=pt2.getBlockX()-pt1.getBlockX(); ydiff=pt2.getBlockY()-pt1.getBlockY(); zdiff=pt2.getBlockZ()-pt1.getBlockZ();
								
								//Find the maximum one that we have to move. The other axes are divided among that.
								int mode = 0; //0 = X, 1 = Y, 2 = Z
								int maxdiff = 0;
								if (Math.abs(xdiff)>maxdiff) {maxdiff=Math.abs(xdiff); mode=0;}
								if (Math.abs(ydiff)>maxdiff) {maxdiff=Math.abs(ydiff); mode=1;}
								if (Math.abs(zdiff)>maxdiff) {maxdiff=Math.abs(zdiff); mode=2;}
								
								if (mode==0) {
									ystep = (double)ydiff/xdiff;
									zstep = (double)zdiff/xdiff;
								}
								if (mode==1) {
									xstep = (double)xdiff/ydiff;
									zstep = (double)zdiff/ydiff;
								}
								if (mode==2) {
									xstep = (double)xdiff/zdiff;
									ystep = (double)ydiff/zdiff;
								}
								if ((int)Math.signum(xstep)!=(int)Math.signum(xdiff)) {xstep*=-1;}
								if ((int)Math.signum(ystep)!=(int)Math.signum(ydiff)) {ystep*=-1;}
								if ((int)Math.signum(zstep)!=(int)Math.signum(zdiff)) {zstep*=-1;}
		
								//Bukkit.getLogger().info("Line Drawer: Initialized mode "+mode+". xstep="+xstep+", ystep="+ystep+", zstep="+zstep+" | xdiff="+xdiff+", ydiff="+ydiff+", zdiff="+zdiff+".");
								//Bukkit.getLogger().info("Going from: "+pt1+" to "+pt2);
								
								boolean ranOutOfBlocks = false; //Turns true if the player runs out of building blocks.
								
								//Now that we know which direction we always step in, start moving coords.
								while ((pt1.clone().add(xcur,ycur,zcur).getBlockX()!=pt2.getBlockX() ||
										pt1.clone().add(xcur,ycur,zcur).getBlockY()!=pt2.getBlockY() ||
										pt1.clone().add(xcur,ycur,zcur).getBlockZ()!=pt2.getBlockZ()) && !ranOutOfBlocks) {
									//Bukkit.getLogger().info("  Location: ("+pt1.clone().add(xcur,ycur,zcur).toString()+")");
									//Get the block at this location. Make sure it's AIR, and then see if the block is in the player's inventory.
									//If it is, we can place one down and subtract one from the inventory.
									if (e.getPlayer().getWorld().getBlockAt(pt1.clone().add(xcur,ycur,zcur)).getType()==Material.AIR) {
										if (e.getPlayer().getInventory().containsAtLeast(new ItemStack(pd.GetClickedBlock().getBlock().getType(),1,(short)pd.GetClickedBlock().getBlock().getData()), 1) || (
												pd.GetClickedBlock().getBlock().getType()==Material.DOUBLE_STEP && e.getPlayer().getInventory().containsAtLeast(new ItemStack(Material.STEP,1,(short)pd.GetClickedBlock().getBlock().getData()), 2))) {
											//Bukkit.getLogger().info("    Was AIR. Block has been changed.");
											//Get the amount holding. Then remove it and add one back for the player.
											ItemStack[] items = e.getPlayer().getInventory().getContents();
											//Loop through items until we find the right type.
											for (int i=0;i<items.length;i++) {
												if (items[i]!=null) {
													if (items[i].getType().getId()==pd.GetClickedBlock().getBlock().getType().getId() &&
															items[i].getData().getData()==pd.GetClickedBlock().getBlock().getData() || (
																	pd.GetClickedBlock().getBlock().getType()==Material.DOUBLE_STEP && items[i].getType()==Material.STEP && items[i].getData().getData()==pd.GetClickedBlock().getBlock().getData())) {
														items[i].setAmount(items[i].getAmount()-1);
														break;
													}
												}
											}
											e.getPlayer().getInventory().setContents(items);
											e.getPlayer().getWorld().getBlockAt(pt1.clone().add(xcur,ycur,zcur)).setType(pd.GetClickedBlock().getBlock().getType());
											e.getPlayer().getWorld().getBlockAt(pt1.clone().add(xcur,ycur,zcur)).setData(pd.GetClickedBlock().getBlock().getData());
											getBuilderCredit(pd.GetClickedBlock().getBlock(),p);
										} else {
											//Bukkit.getLogger().info("====Cannot continue. Ran out of blocks. Exiting.");
											ranOutOfBlocks=true;
											successful=false;
										}
									} else {
										Bukkit.getLogger().info("    Was "+e.getPlayer().getWorld().getBlockAt(pt1.clone().add(xcur,ycur,zcur)).getType().name()+". Skipping...");
									}
									xcur+=xstep;
									ycur+=ystep;
									zcur+=zstep;
								}
								//Bukkit.getLogger().info("====Operation completed. Resetting clicked block.");
								pd.SetClickedBlock(null);
								if (successful) {
									p.sendMessage(ChatColor.YELLOW+"Line Build completed successfully!");
									p.updateInventory();
								} else {
									if (ranOutOfBlocks) {
										p.sendMessage(ChatColor.GOLD+"You ran out of blocks! Stopped mid-way through building.");
										p.updateInventory();
									}
								}
							} else {
								//If they are not, set it as the new target block.
								p.sendMessage("Set first block. Left-click another block of the same type to build a line of that block between them. "+ChatColor.GRAY+ChatColor.ITALIC+"If you wish to cancel, right-click or swap items.");
								pd.SetClickedBlock(e.getClickedBlock().getLocation());
							}

							//Check exp
							if ((int)this.plugin.getPlayerCurrentJobExp(p, "Builder")-expbefore>0 && this.plugin.hasJobBuff("Builder", p, Job.JOB30A)) {
								ExperienceOrb orb = (ExperienceOrb)p.getWorld().spawnEntity(e.getClickedBlock().getLocation().add(0,1,0), EntityType.EXPERIENCE_ORB);
								orb.setExperience((int)this.plugin.getPlayerCurrentJobExp(p, "Builder")-expbefore);
							}
						} else {
							p.sendMessage(ChatColor.RED+"The distance of building is larger than 500 blocks! You cannot build that far.");
						}
					}
					e.setCancelled(true);
					return;
				}
			}
		}

		if ((e.getAction()==Action.RIGHT_CLICK_AIR || (e.getAction()==Action.RIGHT_CLICK_BLOCK && p.isSneaking())) && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasLore()) {
			if (isFood(p.getItemInHand()) && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasLore()) {
				//This is a special food. Even if we are full, take action.
				if (p.getFoodLevel()>=20 && Main.SERVER_TICK_TIME-this.plugin.getPlayerData(p).lasteattime>100) {
					p.setFoodLevel(19);
					p.playSound(p.getLocation(), Sound.EAT, 1.0f, 1.0f);
					this.plugin.getPlayerData(p).lasteattime=Main.SERVER_TICK_TIME;
				}
			}
		}
		
		//******************************//End Job related buffs.
		
		/* DISABLED FOR NOW. GLITCHY.
		if (e.getAction()==Action.RIGHT_CLICK_BLOCK && !p.isSneaking() && e.getClickedBlock().getType()==Material.BOOKSHELF) {
			viewBookshelf(p, e.getClickedBlock().getLocation());
			e.setCancelled(true);
		}*/
		
		if (this.plugin.PlayerinJob(p, "Explorer")) {
			for (int i=0;i<this.plugin.explorerlist.size();i++) {
				if (this.plugin.explorerlist.get(i).player.compareTo(p.getName().toLowerCase())==0) {
					this.plugin.explorerlist.get(i).lastinteract=e.getMaterial();
				}
			}
		}
		/*
		/*
		if (e.getAction()==Action.RIGHT_CLICK_AIR || e.getAction()==Action.RIGHT_CLICK_BLOCK) {
			if (p.getItemInHand()!=null && (p.getItemInHand().getType()==Material.FLINT_AND_STEEL || p.getItemInHand().getType()==Material.LAVA_BUCKET)) {
				if (this.plugin.PlayerinJob(p, "Support")) {
					this.plugin.setMoneyExp(p, "Support", 0, 0);
				}
			}
		}*/
		if (e.getAction()==Action.RIGHT_CLICK_AIR || (e.getAction()==Action.RIGHT_CLICK_BLOCK && p.isSneaking())) {
			boolean largechest=false;
			boolean smallchest=false;
			boolean enderchest=false;
			int identifier=-1;
			if (p.getItemInHand()!=null && (p.getItemInHand().getType()==Material.getMaterial(127))) {
				p.updateInventory();
				e.setCancelled(true);
				return;
			}
			if (p.getItemInHand()!=null && isItemCube(p.getItemInHand())) {
				viewItemCube(p, p.getItemInHand());
				e.setCancelled(true);
				return;
			}
			if (p.getItemInHand()!=null && this.plugin.is_PocketWorkbench(p.getItemInHand())) {
				p.openWorkbench(null, true);
				e.setCancelled(true);
				return;
			}
			if (this.plugin.is_LootChest(p.getItemInHand())) {
				open_LootChest(this.plugin.get_LootChestTier(p.getItemInHand()), p.getLocation());
				
				e.setCancelled(true);
				if (p.getItemInHand().getAmount() > 1) {
					p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
				} else {
					p.setItemInHand(null);
				}
				
				p.sendMessage(ChatColor.GREEN+"You open the chest and find treasure inside!");
				p.playSound(p.getLocation(), Sound.ORB_PICKUP, 10, 1);
				p.updateInventory();
				return;
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
    	if (p.getName().toLowerCase().compareToIgnoreCase("AaMay")==0) {
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
				//if (p.getName().toLowerCase().compareTo("sigonasr2")==0) {p.sendMessage("This is a jukebox.");}
				//if (p.getName().toLowerCase().compareTo("sigonasr2")==0) {p.sendMessage("Item in hand: "+e.getItem().getType().toString());}
				boolean contains=false;
				for (int i=0;i<this.plugin.jukeboxlist.size();i++){
					if (this.plugin.jukeboxlist.get(i).getJukebox().equals(e.getClickedBlock())) {
						contains=true;
						break;
					}
				}
				if (!contains) {
					this.plugin.jukeboxlist.add(new JukeboxData(e.getClickedBlock(), e.getItem().getType(), 100, getSongDuration(e.getItem().getType()), Main.SERVER_TICK_TIME));
					if (p.getName().toLowerCase().compareTo("sigonasr2")==0) {p.sendMessage("Added this jukebox to the list.");}
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
     if (p.getName().toLowerCase().compareTo("sigonasr2")==0) {
    	 int v=2;
    	 final Vector direction = p.getEyeLocation().getDirection().multiply(v);
    	 Bukkit.getWorld("world").spawnEntity(p.getEyeLocation().add(direction.getX(), direction.getY(), direction.getZ()), EntityType.SILVERFISH);
     }*/
			//if (p.getName().toLowerCase().compareTo("sigonasr2")==0) {Bukkit.getPlayer("sigonasr2").sendMessage("This block is at "+e.getClickedBlock().getX()+" "+e.getClickedBlock().getY()+" "+e.getClickedBlock().getZ()+" Data value:"+e.getClickedBlock().getData());}
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
							this.plugin.brewingstandlist.get(i).setOwner(p.getName().toLowerCase());
							//Bukkit.getPlayer("sigonasr2").sendMessage(p.getName().toLowerCase()+" is the new owner of furnace.");
							this.plugin.brewingstandlist.get(i).resetTime();
						}
						break;
					}
				}
				if (!contains) {
					this.plugin.brewingstandlist.add(new BrewingStandData(e.getClickedBlock().getLocation(), p.getName()));
					//Bukkit.getPlayer("sigonasr2").sendMessage(p.getName().toLowerCase()+" is the new owner of brewingstand. (Added to list)");
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
								this.plugin.furnacelist.get(i).setOwner(p.getName().toLowerCase());
								//Bukkit.getPlayer("sigonasr2").sendMessage(p.getName().toLowerCase()+" is the new owner of furnace.");
								this.plugin.furnacelist.get(i).resetTime();
							}
							break;
						}
					}
					if (!contains) {
						this.plugin.furnacelist.add(new FurnaceData(e.getClickedBlock().getLocation(), p.getName()));
						//Bukkit.getPlayer("sigonasr2").sendMessage(p.getName().toLowerCase()+" is the new owner of furnace. (Added to list)");
					}
				} else
					if ((e.getClickedBlock().getState() instanceof Sign)) {
						Sign sign = (Sign)e.getClickedBlock().getState();
						//p.sendMessage("This sign is at "+sign.getBlock().getX()+" "+sign.getBlock().getY()+" "+sign.getBlock().getZ());
						if (sign.getBlock().getX()==1608 && sign.getBlock().getY()==83 && sign.getBlock().getZ()==34) {
							if (!this.plugin.getConfig().getBoolean("spleef4insession")) {
								if (p.getPlayerTime()-this.plugin.getConfig().getDouble("spleeflastrequesttime")<400) {
									if (this.plugin.getConfig().getString("spleefrequestb4player").compareTo("none")==0) {
										if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName().toLowerCase())!=0) {
											this.plugin.getConfig().set("spleefrequestb4player", String.valueOf(p.getName().toLowerCase()));
											this.plugin.getConfig().set("spleeflastrequesttime", Double.valueOf(p.getPlayerTime()));
											Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+"Spleef Player "+p.getName()+" joined the 4-player spleef game. 2 more players need to join within 20 seconds.");
											this.plugin.saveConfig();
										}
									} else 
										if (this.plugin.getConfig().getString("spleefrequestc4player").compareTo("none")==0) {
											if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName().toLowerCase())!=0 &&
													this.plugin.getConfig().getString("spleefrequestb4player").compareTo(p.getName().toLowerCase())!=0) {
												this.plugin.getConfig().set("spleefrequestc4player", String.valueOf(p.getName().toLowerCase()));
												this.plugin.getConfig().set("spleeflastrequesttime", Double.valueOf(p.getPlayerTime()));
												Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+"Spleef Player "+p.getName()+" joined the 4-player spleef game. 1 more player needs to join within 20 seconds.");
												this.plugin.saveConfig();
											}
										} else 
											if (this.plugin.getConfig().getString("spleefrequestd4player").compareTo("none")==0) {
												if (this.plugin.getConfig().getString("spleefrequesta4player").compareTo(p.getName().toLowerCase())!=0 &&
														this.plugin.getConfig().getString("spleefrequestb4player").compareTo(p.getName().toLowerCase())!=0 &&
														this.plugin.getConfig().getString("spleefrequestc4player").compareTo(p.getName().toLowerCase())!=0) {
													this.plugin.getConfig().set("spleefrequestd4player", String.valueOf(p.getName().toLowerCase()));
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
									this.plugin.getConfig().set("spleefrequesta4player", String.valueOf(p.getName().toLowerCase()));
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
										if (p.getPlayerTime()-this.plugin.getConfig().getDouble("spleefrequestatime")>400 && (p.getName().toLowerCase().compareTo(this.plugin.getConfig().getString("spleefrequestbplayer"))!=0 || p.getPlayerTime()-this.plugin.getConfig().getDouble("spleefrequestbtime")>400)) {
											Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+"Spleef Player "+p.getName()+" requested a game in slot A. Join within 20 seconds.");
											this.plugin.getConfig().set("spleefrequestatime", Double.valueOf(p.getPlayerTime()));
											this.plugin.getConfig().set("spleefrequestaplayer", String.valueOf(p.getName().toLowerCase()));
										}
									} else {
										if (p.getName().toLowerCase().compareTo(this.plugin.getConfig().getString("spleefrequestbplayer"))!=0) {
											//This is a confirmed Spleef game.
											int playerarating,playerbrating;
											Player playera,playerb;
											playera=p;
											this.plugin.getConfig().set("spleefrequestatime", Double.valueOf(p.getPlayerTime()));
											this.plugin.getConfig().set("spleefrequestaplayer", String.valueOf(p.getName().toLowerCase()));
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
									//this.plugin.saveAccountsConfig();
								}
							} else
								if (sign.getBlock().getX()==1620 && sign.getBlock().getY()==83 && sign.getBlock().getZ()==45) { //Side B Request.
									//If not requested already.
									if (!this.plugin.getConfig().getBoolean("spleefinsession")) {
										if (p.getPlayerTime()-this.plugin.getConfig().getDouble("spleefrequestatime")>400) {
											if (p.getPlayerTime()-this.plugin.getConfig().getDouble("spleefrequestbtime")>400 && (p.getName().toLowerCase().compareTo(this.plugin.getConfig().getString("spleefrequestaplayer"))!=0 || p.getPlayerTime()-this.plugin.getConfig().getDouble("spleefrequestatime")>400)) {
												Bukkit.broadcastMessage(ChatColor.RED+"[SPLEEF] "+ChatColor.YELLOW+"Spleef Player "+p.getName()+" requested a game in slot B. Join within 20 seconds.");
												this.plugin.getConfig().set("spleefrequestbtime", Double.valueOf(p.getPlayerTime()));
												this.plugin.getConfig().set("spleefrequestbplayer", String.valueOf(p.getName().toLowerCase()));
											}
										} else {
											if (p.getName().toLowerCase().compareTo(this.plugin.getConfig().getString("spleefrequestaplayer"))!=0) {
												//This is a confirmed Spleef game.
												int playerarating,playerbrating;
												Player playera,playerb;
												this.plugin.getConfig().set("spleefrequestbtime", Double.valueOf(p.getPlayerTime()));
												this.plugin.getConfig().set("spleefrequestbplayer", String.valueOf(p.getName().toLowerCase()));
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
										//this.plugin.saveAccountsConfig();
									}
								}
						if (stats) {
							if (p.hasPermission("bankeconomy.sign.use")) {
								if ((sign.getLine(0).equalsIgnoreCase(ChatColor.DARK_GREEN + "[Bank]")) && (sign.getLine(1).equalsIgnoreCase(ChatColor.DARK_RED + "Deposit"))) {
									/*double value = Double.parseDouble(arg0);
              double total = actMon + value;
              if (value <= actHand) {
                this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".money", Double.valueOf(total));
                this.plugin.saveAccountsConfig();
                if (value <= 1)
                  p.sendMessage("�ｧ2[BankEconomy]" + ChatColor.AQUA + " You added " + value + " " + currencySG + " to your bank account.");
                else {
                  p.sendMessage("�ｧ2[BankEconomy]" + ChatColor.AQUA + " You added " + value + " " + currencyPL + " to your bank account.");
                }
                Main.economy.withdrawPlayer(p.getName().toLowerCase(), value);
              } else {
                p.sendMessage("�ｧ2[BankEconomy]" + ChatColor.AQUA + " Sorry, you can't deposit that amount of money.");
              }*/
									//If they were using the withdraw bank before, clear them from it.
									if (this.plugin.last_bank_withdraw_user.equalsIgnoreCase(p.getName().toLowerCase())) {
										this.plugin.last_bank_withdraw_user="";
									}
									if (this.plugin.last_bank_deposit_use_time+200<Main.SERVER_TICK_TIME || this.plugin.last_bank_deposit_user.equalsIgnoreCase(p.getName().toLowerCase())) {
										this.plugin.last_bank_deposit_user=p.getName();
										this.plugin.last_bank_deposit_use_time=Main.SERVER_TICK_TIME;
										p.sendMessage(ChatColor.DARK_GREEN+"[Bank]" + ChatColor.AQUA +" Please enter the amount of money in chat that you would like to deposit. " + ChatColor.YELLOW + "(Type all to deposit every dollar you are holding.)");
									} else {
										p.sendMessage(ChatColor.DARK_GREEN+"[Bank]" + ChatColor.RED +" Someone else is using the deposit bank at the moment. Please wait until they are finished.");
									}
								} else if ((sign.getLine(0).equalsIgnoreCase(ChatColor.DARK_GREEN + "[Bank]")) && (sign.getLine(1).equalsIgnoreCase(ChatColor.DARK_BLUE + "Withdraw"))) {
									/*int value = Integer.parseInt(sign.getLine(2));
              double total = actMon - value;
              if (value <= actMon) {
                this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".money", Double.valueOf(total));
                this.plugin.saveAccountsConfig();
                if (value <= 1)
                  p.sendMessage("�ｧ2[BankEconomy]" + ChatColor.AQUA + " You withdrawn " + value + " " + currencySG + " from your bank account.");
                else {
                  p.sendMessage("�ｧ2[BankEconomy]" + ChatColor.AQUA + " You withdrawn " + value + " " + currencyPL + " from your bank account.");
                }
                Main.economy.depositPlayer(p.getName().toLowerCase(), value);
              } else {
                p.sendMessage("�ｧ2[BankEconomy]" + ChatColor.AQUA + " Sorry, you can't withdraw that amount of money.");
              }*/
									if (this.plugin.last_bank_withdraw_use_time+200<Main.SERVER_TICK_TIME || this.plugin.last_bank_withdraw_user.equalsIgnoreCase(p.getName().toLowerCase())) {
										//If they were using the deposit bank before, clear them from it.
										if (this.plugin.last_bank_deposit_user.equalsIgnoreCase(p.getName().toLowerCase())) {
											this.plugin.last_bank_deposit_user="";
										}
										this.plugin.last_bank_withdraw_user=p.getName();
										this.plugin.last_bank_withdraw_use_time=Main.SERVER_TICK_TIME;
										p.sendMessage(ChatColor.DARK_GREEN+"[Bank]" + ChatColor.AQUA +" Please enter the amount of money in chat that you would like to withdraw. " + ChatColor.YELLOW + "(Type all to withdraw every dollar you have in the bank.)");
									} else {
										p.sendMessage(ChatColor.DARK_GREEN+"[Bank]" + ChatColor.RED +" Someone else is using the withdraw bank at the moment. Please wait until they are finished.");
									}
								} else if ((sign.getLine(0).equalsIgnoreCase(ChatColor.DARK_GREEN + "[Bank]")) && (sign.getLine(1).equalsIgnoreCase(ChatColor.DARK_GRAY + "Check Balance"))) {
									p.sendMessage(ChatColor.GRAY + "===========[ " + ChatColor.LIGHT_PURPLE + "Current Balance" + ChatColor.GRAY + " ]===========");
									DecimalFormat df = new DecimalFormat("#0.00");
									//Update money with interest.
									actMon=this.plugin.compoundInterest(p);
									p.sendMessage(ChatColor.DARK_GREEN + "Balance: $" + ChatColor.BOLD + ChatColor.AQUA + df.format(actMon));
									/*
              if (stats)
                p.sendMessage(ChatColor.DARK_GREEN + "Status: " + ChatColor.AQUA + "enabled");
              else if (!stats) {
                p.sendMessage(ChatColor.DARK_GREEN + "Status: " + ChatColor.AQUA + "disabled");
              }*/
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

	public boolean special_convert(Material mat) {
		if (mat==Material.WOOL || mat==Material.INK_SACK || mat==Material.CARPET) {
			return true;
		} else {
			return false;
		}
	}

	public static String convertToItemName(String val) {
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

	public String convertToItemName(String val, short data, Material material_id) {
		String color = "";
		String name = "";
		switch (material_id) {
		case WOOL:{
			name = "Wool";
		}break;
		case INK_SACK:{
			name = "Dye";
		}break;
		case CARPET:{
			name = "Carpet";
		}break;
		}
		if (name.equalsIgnoreCase("Dye")) {
			color = DyeColor.getByDyeData((byte)data).name();
		} else {
			color = DyeColor.getByWoolData((byte)data).name();
		}
		return String.valueOf(convertToItemName(color+" "+name));
	}

	@EventHandler
	public void onHangingBreak(HangingBreakEvent e) {
		//Bukkit.broadcastMessage(""+e.getCause());
		if (e.getCause().name().equalsIgnoreCase(RemoveCause.DEFAULT.name()) || e.getCause().name().equalsIgnoreCase(RemoveCause.EXPLOSION.name())) {
			//Prevent this from happening here.
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onHangingBreakEntity(HangingBreakByEntityEvent e) {
		//Bukkit.broadcastMessage(""+e.getRemover().getType());
		if (e.getRemover().getType()==EntityType.LIGHTNING || (e.getRemover() instanceof Monster)) {
			//Prevent this from happening here.
			e.setCancelled(true);
		}
	}

	/*
	@EventHandler
	public void onLightningStrike(LightningStrikeEvent e) {
		Bukkit.getWorld("world").strikeLightning(new Location("world", Bukkit.getOnlinePlayers()[(int)(Math.random()*Bukkit.getOnlinePlayers().length)].getLocation().getX(), 0d, 0d));
	}*/

}

class updateInventoryTask implements Runnable {
	String playerName;
	double repairMultiplier, experienceMultiplier;

	public updateInventoryTask(String pl){
		playerName = pl;
	}

	@Override
	public void run() {
		// Bukkit.getLogger().info("Runnable task run() called; player name: " + playerName);

		Player player = Bukkit.getPlayer(playerName);
		Inventory anvilInv = player.getOpenInventory().getTopInventory();

		final int INPUT = 10;
		final int MATERIALS = 12;
		final int MAGIC = 14;
		final int OUTPUT = 16;
		final int LEVELS = 22;

		// Apply cost reductions for specialists
		repairMultiplier = 0.2; // Set to 0.25 if Blacksmith/Weaponsmith
		experienceMultiplier = 1; // Halve for enchanters (maybe? balance issue), reduce substantially for tinkerers


		// Redundant validation code for verification

		if (anvilInv.getItem(INPUT) != null) {
			if (!(anvilInv.getItem(INPUT).getType().toString().toUpperCase().contains("HELMET") || anvilInv.getItem(INPUT).getType().toString().toUpperCase().contains("CHESTPLATE") ||
					anvilInv.getItem(INPUT).getType().toString().toUpperCase().contains("LEGGINGS") || anvilInv.getItem(INPUT).getType().toString().toUpperCase().contains("BOOTS") ||
					anvilInv.getItem(INPUT).getType().toString().toUpperCase().contains("PICKAXE") || anvilInv.getItem(INPUT).getType().toString().toUpperCase().contains("SPADE") ||
					anvilInv.getItem(INPUT).getType().toString().toUpperCase().contains("HOE") || anvilInv.getItem(INPUT).getType().toString().toUpperCase().contains("AXE") ||
					anvilInv.getItem(INPUT).getType().toString().toUpperCase().contains("SWORD") || anvilInv.getItem(INPUT).getType().toString().toUpperCase().contentEquals("FISHING") ||
					anvilInv.getItem(INPUT).getType().toString().toUpperCase().contentEquals("BOW") || anvilInv.getItem(INPUT).getType().toString().toUpperCase().contentEquals("ENCHANTED_BOOK"))) {

				sendToInventory(INPUT, anvilInv.getItem(INPUT).getAmount(), player);
				// Bukkit.getLogger().info("Invalid input!");
			} else {
				// Bukkit.getLogger().info("Valid input, " + anvilInv.getItem(INPUT).toString().toUpperCase() + " with durability " + anvilInv.getItem(INPUT).getDurability());
			}
		}

		if (anvilInv.getItem(MATERIALS) != null) {
			if (!(anvilInv.getItem(MATERIALS).getType() == Material.LEATHER || anvilInv.getItem(MATERIALS).getType() == Material.IRON_INGOT ||
					anvilInv.getItem(MATERIALS).getType() == Material.GOLD_INGOT || anvilInv.getItem(MATERIALS).getType() == Material.IRON_BLOCK ||
					anvilInv.getItem(MATERIALS).getType() == Material.DIAMOND_BLOCK || anvilInv.getItem(MATERIALS).getType() == Material.DIAMOND ||
					anvilInv.getItem(MATERIALS).getType() == Material.WOOD || anvilInv.getItem(MATERIALS).getType() == Material.COBBLESTONE ||
					anvilInv.getItem(MATERIALS).getType() == Material.LOG || anvilInv.getItem(MATERIALS).getType() == Material.STONE ||
					anvilInv.getItem(MATERIALS).getType() == Material.STRING || anvilInv.getItem(MATERIALS).getType() == Material.EMERALD ||
					anvilInv.getItem(MATERIALS).getType() == Material.EMERALD_BLOCK || anvilInv.getItem(MATERIALS).getType() == Material.ENCHANTED_BOOK)) {

				sendToInventory(MATERIALS, anvilInv.getItem(MATERIALS).getAmount(), player);

				// Bukkit.getLogger().info("Invalid materials!");
			} else if ((anvilInv.getItem(MATERIALS).getType() == Material.ENCHANTED_BOOK || anvilInv.getItem(MATERIALS).getType() == Material.BOOK) && anvilInv.getItem(MAGIC) == null) {
				anvilInv.setItem(MAGIC, anvilInv.getItem(MATERIALS).clone());
				anvilInv.setItem(MATERIALS, new ItemStack(Material.AIR));
				// Bukkit.getLogger().info("Valid materials, " + anvilInv.getItem(MATERIALS).toString().toUpperCase() + " with durability " + anvilInv.getItem(MATERIALS).getDurability());
			}
		}

		if (anvilInv.getItem(MAGIC) != null) {
			if (!(anvilInv.getItem(MAGIC).getType() == Material.ENCHANTED_BOOK || anvilInv.getItem(MAGIC).getType() == Material.BOOK)) {

				sendToInventory(MAGIC, anvilInv.getItem(MAGIC).getAmount(), player);

				// Bukkit.getLogger().info("Invalid magic!");
			} else {
				// Bukkit.getLogger().info("Valid magic, " + anvilInv.getItem(MAGIC).toString().toUpperCase());
			}
		}

		if ((anvilInv.getItem(INPUT) == null) || // No input, or material/magic both empty, or all three filled, or input and materials filled but item full
				(anvilInv.getItem(MAGIC) == null && anvilInv.getItem(MATERIALS) == null) ||
				(anvilInv.getItem(MAGIC) != null && anvilInv.getItem(MATERIALS) != null && anvilInv.getItem(INPUT) != null) ||
				(anvilInv.getItem(INPUT) != null && anvilInv.getItem(MATERIALS) != null && anvilInv.getItem(INPUT).getDurability() == 0)) {
			// No valid combo, set XP orb to stack size 1 and remove output.
			anvilInv.setItem(OUTPUT, new ItemStack(Material.AIR));
			ItemStack orbs = new ItemStack(Material.SLIME_BALL);
			ItemMeta temp_meta = orbs.getItemMeta();
			temp_meta.setDisplayName(ChatColor.YELLOW + "Experience Cost");
			List<String> temp_meta_lore = new ArrayList<String>();
			temp_meta_lore.add(ChatColor.ITALIC + "Experience Cost of Enchanting.");
			temp_meta.setLore(temp_meta_lore);
			orbs.setItemMeta(temp_meta);
			anvilInv.setItem(LEVELS, orbs);

			// TRY EVERYTHING
			player.getInventory().setContents(player.getInventory().getContents());
			anvilInv.setContents(anvilInv.getContents());
			player.updateInventory();
		} else if (anvilInv.getItem(INPUT) != null && anvilInv.getItem(MATERIALS) != null && anvilInv.getItem(INPUT).getDurability() != 0) {
			// Both repair slots are populated, and the item is damaged.
			// Verify the right material is combined with the source item.
			boolean validCombo = false;
			double multiplier = 0;
			boolean isHalloweenItem = false;

			List<String> lore = anvilInv.getItem(INPUT).getItemMeta().getLore();
			if (lore != null) {
				for (int i=0;i<lore.size();i++) {
					if (lore.get(i).contains(ChatColor.YELLOW+"[Halloween]")) {
						isHalloweenItem = true;
					}
				}
			}

			if (anvilInv.getItem(MATERIALS).getType() == Material.WOOD && (anvilInv.getItem(INPUT).getType() == Material.WOOD_AXE ||
					anvilInv.getItem(INPUT).getType() == Material.WOOD_SWORD || anvilInv.getItem(INPUT).getType() == Material.WOOD_HOE ||
					anvilInv.getItem(INPUT).getType() == Material.WOOD_PICKAXE || anvilInv.getItem(INPUT).getType() == Material.WOOD_SPADE)) {

				validCombo = true;
				multiplier = 0.1;
			}

			if (anvilInv.getItem(MATERIALS).getType() == Material.LOG && (anvilInv.getItem(INPUT).getType() == Material.WOOD_AXE ||
					anvilInv.getItem(INPUT).getType() == Material.WOOD_SWORD || anvilInv.getItem(INPUT).getType() == Material.WOOD_HOE ||
					anvilInv.getItem(INPUT).getType() == Material.WOOD_PICKAXE || anvilInv.getItem(INPUT).getType() == Material.WOOD_SPADE)) {

				validCombo = true;
				multiplier = 0;
			}

			if (anvilInv.getItem(MATERIALS).getType() == Material.STRING && (anvilInv.getItem(INPUT).getType() == Material.FISHING_ROD ||
					anvilInv.getItem(INPUT).getType() == Material.BOW)) {

				validCombo = true;
				multiplier = 1;
			}

			if (anvilInv.getItem(MATERIALS).getType() == Material.COBBLESTONE && (anvilInv.getItem(INPUT).getType() == Material.STONE_AXE ||
					anvilInv.getItem(INPUT).getType() == Material.STONE_SWORD || anvilInv.getItem(INPUT).getType() == Material.STONE_HOE ||
					anvilInv.getItem(INPUT).getType() == Material.STONE_PICKAXE || anvilInv.getItem(INPUT).getType() == Material.STONE_SPADE)) {

				validCombo = true;
				multiplier = 0.2;
			}

			if (anvilInv.getItem(MATERIALS).getType() == Material.STONE && (anvilInv.getItem(INPUT).getType() == Material.STONE_AXE ||
					anvilInv.getItem(INPUT).getType() == Material.STONE_SWORD || anvilInv.getItem(INPUT).getType() == Material.STONE_HOE ||
					anvilInv.getItem(INPUT).getType() == Material.STONE_PICKAXE || anvilInv.getItem(INPUT).getType() == Material.STONE_SPADE)) {

				validCombo = true;
				multiplier = 0;
			}

			if (anvilInv.getItem(MATERIALS).getType() == Material.LEATHER && (anvilInv.getItem(INPUT).getType() == Material.LEATHER_BOOTS ||
					anvilInv.getItem(INPUT).getType() == Material.LEATHER_CHESTPLATE || anvilInv.getItem(INPUT).getType() == Material.LEATHER_HELMET ||
					anvilInv.getItem(INPUT).getType() == Material.LEATHER_LEGGINGS)) {

				validCombo = true;
				multiplier = 0.15;
			}

			if (anvilInv.getItem(MATERIALS).getType() == Material.IRON_INGOT && (anvilInv.getItem(INPUT).getType() == Material.IRON_BOOTS ||
					anvilInv.getItem(INPUT).getType() == Material.IRON_CHESTPLATE || anvilInv.getItem(INPUT).getType() == Material.IRON_HELMET ||
					anvilInv.getItem(INPUT).getType() == Material.IRON_LEGGINGS || anvilInv.getItem(INPUT).getType() == Material.IRON_AXE ||
					anvilInv.getItem(INPUT).getType() == Material.IRON_SWORD || anvilInv.getItem(INPUT).getType() == Material.IRON_HOE ||
					anvilInv.getItem(INPUT).getType() == Material.IRON_PICKAXE || anvilInv.getItem(INPUT).getType() == Material.IRON_SPADE)) {

				validCombo = true;
				multiplier = 0.8;
			}

			if (anvilInv.getItem(MATERIALS).getType() == Material.IRON_BLOCK && (anvilInv.getItem(INPUT).getType() == Material.IRON_BOOTS ||
					anvilInv.getItem(INPUT).getType() == Material.IRON_CHESTPLATE || anvilInv.getItem(INPUT).getType() == Material.IRON_HELMET ||
					anvilInv.getItem(INPUT).getType() == Material.IRON_LEGGINGS || anvilInv.getItem(INPUT).getType() == Material.IRON_AXE ||
					anvilInv.getItem(INPUT).getType() == Material.IRON_SWORD || anvilInv.getItem(INPUT).getType() == Material.IRON_HOE ||
					anvilInv.getItem(INPUT).getType() == Material.IRON_PICKAXE || anvilInv.getItem(INPUT).getType() == Material.IRON_SPADE)) {

				validCombo = true;
				multiplier = 0.08;
			}

			if (anvilInv.getItem(MATERIALS).getType() == Material.IRON_INGOT && (anvilInv.getItem(INPUT).getType() == Material.CHAINMAIL_BOOTS ||
					anvilInv.getItem(INPUT).getType() == Material.CHAINMAIL_CHESTPLATE || anvilInv.getItem(INPUT).getType() == Material.CHAINMAIL_HELMET ||
					anvilInv.getItem(INPUT).getType() == Material.CHAINMAIL_LEGGINGS)) {

				validCombo = true;
				multiplier = 0.65;
			}

			if (anvilInv.getItem(MATERIALS).getType() == Material.GOLD_INGOT && (anvilInv.getItem(INPUT).getType() == Material.GOLD_BOOTS ||
					anvilInv.getItem(INPUT).getType() == Material.GOLD_CHESTPLATE || anvilInv.getItem(INPUT).getType() == Material.GOLD_HELMET ||
					anvilInv.getItem(INPUT).getType() == Material.GOLD_LEGGINGS || anvilInv.getItem(INPUT).getType() == Material.GOLD_AXE ||
					anvilInv.getItem(INPUT).getType() == Material.GOLD_SWORD || anvilInv.getItem(INPUT).getType() == Material.GOLD_HOE ||
					anvilInv.getItem(INPUT).getType() == Material.GOLD_PICKAXE || anvilInv.getItem(INPUT).getType() == Material.GOLD_SPADE)) {

				validCombo = true;
				multiplier = 0.3;
			}

			if ((anvilInv.getItem(MATERIALS).getType() == Material.DIAMOND && (anvilInv.getItem(INPUT).getType() == Material.DIAMOND_BOOTS ||
					anvilInv.getItem(INPUT).getType() == Material.DIAMOND_CHESTPLATE || anvilInv.getItem(INPUT).getType() == Material.DIAMOND_HELMET ||
					anvilInv.getItem(INPUT).getType() == Material.DIAMOND_LEGGINGS || anvilInv.getItem(INPUT).getType() == Material.DIAMOND_AXE ||
					anvilInv.getItem(INPUT).getType() == Material.DIAMOND_SWORD || anvilInv.getItem(INPUT).getType() == Material.DIAMOND_HOE ||
					anvilInv.getItem(INPUT).getType() == Material.DIAMOND_PICKAXE || anvilInv.getItem(INPUT).getType() == Material.DIAMOND_SPADE) &&
					!isHalloweenItem)) {

				validCombo = true;
				multiplier = 1.2;
			}

			if (anvilInv.getItem(MATERIALS).getType() == Material.DIAMOND_BLOCK && (anvilInv.getItem(INPUT).getType() == Material.DIAMOND_BOOTS ||
					anvilInv.getItem(INPUT).getType() == Material.DIAMOND_CHESTPLATE || anvilInv.getItem(INPUT).getType() == Material.DIAMOND_HELMET ||
					anvilInv.getItem(INPUT).getType() == Material.DIAMOND_LEGGINGS || anvilInv.getItem(INPUT).getType() == Material.DIAMOND_AXE ||
					anvilInv.getItem(INPUT).getType() == Material.DIAMOND_SWORD || anvilInv.getItem(INPUT).getType() == Material.DIAMOND_HOE ||
					anvilInv.getItem(INPUT).getType() == Material.DIAMOND_PICKAXE || anvilInv.getItem(INPUT).getType() == Material.DIAMOND_SPADE)) {

				validCombo = true;
				multiplier = 0.12;

				if (isHalloweenItem) {
					multiplier = 1.2;
				}
			}

			if (anvilInv.getItem(MATERIALS).getType() == Material.EMERALD) {
				validCombo = true;
				multiplier = 0.5;
			}

			if (anvilInv.getItem(MATERIALS).getType() == Material.EMERALD_BLOCK) {
				validCombo = true;
				multiplier = 0.05;
			}

			if (validCombo) {
				// If materials stacked past number needed to full repair, reduce stack size and drop the rest
				// in the player's inventory, or if that fails, drop it on the ground.
				// Limit to 5 just in case math doesn't work.
				int maxPossible = (int)Math.round(1 / repairMultiplier);
				int maxItemsNeeded = Math.min(maxPossible, 1 + (maxPossible * anvilInv.getItem(INPUT).getDurability() / anvilInv.getItem(INPUT).getType().getMaxDurability()));

				if (anvilInv.getItem(MATERIALS).getAmount() > maxItemsNeeded) {
					// // Bukkit.getLogger().info("Materials exceed " + maxItemsNeeded + " stack. Dropping " + (anvilInv.getItem(MATERIALS).getAmount() - maxItemsNeeded) + " of " + anvilInv.getItem(MATERIALS).getType());

					sendToInventory(MATERIALS, anvilInv.getItem(MATERIALS).getAmount() - maxItemsNeeded, player);

					// anvilInv.getItem(MATERIALS).setAmount(maxItemsNeeded);
				}

				int cost = anvilInv.getContents()[MATERIALS].getAmount() * 2;
				int bonus_cost = 0;
				ItemStack item = anvilInv.getContents()[INPUT];

				// Bukkit.getLogger().warning("Repair cost calculation valid");
				Map<Enchantment, Integer> enchantments = item.getEnchantments();

				// Bukkit.getLogger().warning(enchantments.keySet().toString());
				for (Enchantment e : enchantments.keySet()) {
					// Bukkit.getLogger().warning("BC: " + bonus_cost + " | INCR: " + 2 + enchantments.get(e));
					bonus_cost += (2 + enchantments.get(e));
				}

				cost += bonus_cost;

				// Bukkit.getLogger().info("Raw cost: " + cost);

				cost = (short) Math.floor(cost * multiplier);
				cost = Math.min(cost, 60); // Cap cost at 60 in case some egregiously enchanted item exists
				cost = Math.max(cost, 1); // Make sure it's at least one level

				// Bukkit.getLogger().info("Cost: " + cost);

				ItemStack orbs = new ItemStack(Material.SLIME_BALL);

				ItemMeta temp_meta = orbs.getItemMeta();
				temp_meta.setDisplayName(ChatColor.YELLOW + "Experience Cost");
				List<String> temp_meta_lore = new ArrayList<String>();
				temp_meta_lore.add(ChatColor.ITALIC + "This operation costs " + cost + " levels.");
				temp_meta_lore.add(ChatColor.ITALIC + "You currently have " + player.getLevel() + " levels.");

				if (cost > player.getLevel()) {
					orbs.setType(Material.MAGMA_CREAM);
					temp_meta_lore.add("");
					temp_meta_lore.add(ChatColor.RED + "You can't afford this!");
				} else {
					temp_meta_lore.add("");
					temp_meta_lore.add(ChatColor.GREEN + "Completing the operation will");
					temp_meta_lore.add(ChatColor.GREEN + "bring you to " + (player.getLevel() - cost) + " levels.");
				}

				temp_meta.setLore(temp_meta_lore);
				orbs.setItemMeta(temp_meta);

				orbs.setAmount(cost);
				anvilInv.setItem(LEVELS, orbs);

				// anvilInv.getContents()[OUTPUT].setType(item.getType());
				// anvilInv.getContents()[OUTPUT].setData(item.getData());

				anvilInv.setItem(OUTPUT, item.clone());
				anvilInv.getContents()[OUTPUT].setDurability((short) (item.getDurability() - item.getType().getMaxDurability() * repairMultiplier * anvilInv.getContents()[MATERIALS].getAmount()));
			}


			// TRY EVERYTHING
			player.getInventory().setContents(player.getInventory().getContents());
			anvilInv.setContents(anvilInv.getContents());
			player.updateInventory();
		} else if (anvilInv.getItem(INPUT) != null && anvilInv.getItem(MAGIC) != null) {
			if (anvilInv.getItem(MAGIC).getType() == Material.ENCHANTED_BOOK) {
				// Both Magic slots are populated, enchanted book is detected.
				// Get the list of enchantments from both items.
				Map<Enchantment, Integer> itemEnchantments = anvilInv.getItem(INPUT).getEnchantments();
				Map<Enchantment, Integer> bookEnchantments = new java.util.HashMap<Enchantment, Integer>();

				// Get enchanted book "enchantment" and enchantments.
				bookEnchantments.putAll(anvilInv.getItem(MAGIC).getEnchantments());
				bookEnchantments.putAll(((EnchantmentStorageMeta)(anvilInv.getItem(MAGIC).getItemMeta())).getStoredEnchants());

				// Get the list of bonuses from both items.
				Map<String, Double> itemBonuses = new java.util.HashMap<String, Double>();
				Map<String, Double> bookBonuses = new java.util.HashMap<String, Double>();

				if (anvilInv.getItem(INPUT).getItemMeta().hasLore()) {
					for (int i = 0; i < anvilInv.getItem(INPUT).getItemMeta().getLore().size(); i++) {
						// Put enchantments together for the input. Also stacks identical enchantments.
						// Bukkit.getLogger().info("Iterating bonus: " + anvilInv.getItem(INPUT).getItemMeta().getLore().get(i));

						if (getEnchantmentName(anvilInv.getItem(INPUT).getItemMeta().getLore().get(i)) != null) {
							if (itemBonuses.get(getEnchantmentName(anvilInv.getItem(INPUT).getItemMeta().getLore().get(i))) == null) {

								// Bukkit.getLogger().info("New bonus: " + getEnchantmentName(anvilInv.getItem(INPUT).getItemMeta().getLore().get(i)));
								itemBonuses.put(getEnchantmentName(anvilInv.getItem(INPUT).getItemMeta().getLore().get(i)), getEnchantmentNumb(anvilInv.getItem(INPUT).getItemMeta().getLore().get(i)));
							} else {

								// Bukkit.getLogger().info("Stacking bonus: " + itemBonuses.get(getEnchantmentName(anvilInv.getItem(INPUT).getItemMeta().getLore().get(i))) + " + " + getEnchantmentNumb(anvilInv.getItem(INPUT).getItemMeta().getLore().get(i)));
								itemBonuses.put(getEnchantmentName(anvilInv.getItem(INPUT).getItemMeta().getLore().get(i)), itemBonuses.get(getEnchantmentName(anvilInv.getItem(INPUT).getItemMeta().getLore().get(i))) + getEnchantmentNumb(anvilInv.getItem(INPUT).getItemMeta().getLore().get(i)));
							}
						}
					}
				}

				if (anvilInv.getItem(MAGIC).getItemMeta().hasLore()) {
					for (int i = 0; i < anvilInv.getItem(MAGIC).getItemMeta().getLore().size(); i++) {
						// Put enchantments together for the MAGIC. Also stacks identical enchantments.
						// Bukkit.getLogger().info("Iterating bonus: " + anvilInv.getItem(MAGIC).getItemMeta().getLore().get(i));
						if (bookBonuses.get(getEnchantmentName(anvilInv.getItem(MAGIC).getItemMeta().getLore().get(i))) == null) {

							// Bukkit.getLogger().info("New bonus: " + getEnchantmentName(anvilInv.getItem(MAGIC).getItemMeta().getLore().get(i)));
							bookBonuses.put(getEnchantmentName(anvilInv.getItem(MAGIC).getItemMeta().getLore().get(i)), getEnchantmentNumb(anvilInv.getItem(MAGIC).getItemMeta().getLore().get(i)));
						} else {

							// Bukkit.getLogger().info("Stacking bonus: " + bookBonuses.get(getEnchantmentName(anvilInv.getItem(MAGIC).getItemMeta().getLore().get(i))) + " + " + getEnchantmentNumb(anvilInv.getItem(MAGIC).getItemMeta().getLore().get(i)));
							bookBonuses.put(getEnchantmentName(anvilInv.getItem(MAGIC).getItemMeta().getLore().get(i)), bookBonuses.get(getEnchantmentName(anvilInv.getItem(MAGIC).getItemMeta().getLore().get(i))) + getEnchantmentNumb(anvilInv.getItem(MAGIC).getItemMeta().getLore().get(i)));
						}
					}
				}

				// Generate appropriate possible enchantments
				Map<Enchantment, Integer> probableEnchantments = new java.util.HashMap<Enchantment, Integer>();

				for (Enchantment e : bookEnchantments.keySet()) {
					// Bukkit.getLogger().info("Iterating enchantment: " + e);

					if (itemEnchantments.get(e) == null || bookEnchantments.get(e) > itemEnchantments.get(e)) {
						// Book enchantment is larger in magnitude. Assign it as a possible outcome.
						probableEnchantments.put(e, bookEnchantments.get(e));
					} else if (bookEnchantments.get(e) == itemEnchantments.get(e) && bookEnchantments.get(e) < 10) {
						// Book enchantment is same in magnitude. Upgrade by one level.
						probableEnchantments.put(e, bookEnchantments.get(e) + 1);
					}
				}

				// Generate appropriate possible bonuses
				Map<String, Integer> probableBonuses = new java.util.HashMap<String, Integer>();

				for (String e : bookBonuses.keySet()) {
					// Bukkit.getLogger().info("Iterating bonus: " + e);

					if (itemBonuses.get(e) == null) {
						// Book enchantment is new. Assign it as a possible outcome.
						probableBonuses.put(e, (int)Math.round(bookBonuses.get(e) * 0.2));
						// The int cast appears to be needed to make it display integers and not stuff like "+5.0 Health"
						// Don't remove unless workaround can be found.
					} else if (bookBonuses.get(e) >= itemBonuses.get(e) * 0.2) {
						// Book enchantment is large enough in magnitude to stack. Assign it as a possible outcome.
						probableBonuses.put(e, (int)Math.round(itemBonuses.get(e) + bookBonuses.get(e) * 0.2));
					}
				}

				if (probableEnchantments.size() == 0 && probableBonuses.size() == 0) {
					// No possible valid enchantments. Output nothing
				} else {
					if (probableEnchantments.size() != 0) {
						// Randomly select an enchantment to add.
						int random = (int)(Math.random() * probableEnchantments.size());
						// Bukkit.getLogger().info("Randomized to # " + (random + 1) + " out of " + probableEnchantments.size());

						int i = 0;

						Enchantment appliedEnchant = null;
						int magnitude = 0;
						for (Enchantment e : probableEnchantments.keySet()) {

							if (i == random) {
								// Rolled this one
								appliedEnchant = e;
								magnitude = probableEnchantments.get(e);
							}
							i++;
						}

						int cost = 0;

						if (itemEnchantments.get(appliedEnchant) == null) {
							// This enchantment doesn't exist. Calculate full cost.

							cost = Math.min(60, magnitude * magnitude);
							cost = Math.max(cost, 1); // Make sure it's at least one level

							ItemStack orbs = new ItemStack(Material.SLIME_BALL);

							ItemMeta temp_meta = orbs.getItemMeta();
							temp_meta.setDisplayName(ChatColor.YELLOW + "Experience Cost");
							List<String> temp_meta_lore = new ArrayList<String>();
							temp_meta_lore.add(ChatColor.ITALIC + "This operation costs " + cost + " levels.");
							temp_meta_lore.add(ChatColor.ITALIC + "You currently have " + player.getLevel() + " levels.");

							if (cost > player.getLevel()) {
								orbs.setType(Material.MAGMA_CREAM);
								temp_meta_lore.add("");
								temp_meta_lore.add(ChatColor.RED + "You can't afford this!");
							} else {
								temp_meta_lore.add("");
								temp_meta_lore.add(ChatColor.GREEN + "Completing the operation will");
								temp_meta_lore.add(ChatColor.GREEN + "bring you to " + (player.getLevel() - cost) + " levels.");
							}

							temp_meta.setLore(temp_meta_lore);
							orbs.setItemMeta(temp_meta);

							orbs.setAmount(cost);
							anvilInv.setItem(LEVELS, orbs);
							anvilInv.setItem(OUTPUT, anvilInv.getItem(INPUT).clone());
							anvilInv.getItem(OUTPUT).addUnsafeEnchantment(appliedEnchant, magnitude);

						} else {
							// This enchantment exists. Calculate incremental cost.

							cost = Math.min(60, magnitude * magnitude - itemEnchantments.get(appliedEnchant) * itemEnchantments.get(appliedEnchant));
							cost = Math.max(cost, 1); // Make sure it's at least one level

							ItemStack orbs = new ItemStack(Material.SLIME_BALL);

							ItemMeta temp_meta = orbs.getItemMeta();
							temp_meta.setDisplayName(ChatColor.YELLOW + "Experience Cost");
							List<String> temp_meta_lore = new ArrayList<String>();
							temp_meta_lore.add(ChatColor.ITALIC + "This operation costs " + cost + " levels.");
							temp_meta_lore.add(ChatColor.ITALIC + "You currently have " + player.getLevel() + " levels.");

							if (cost > player.getLevel()) {
								orbs.setType(Material.MAGMA_CREAM);
								temp_meta_lore.add("");
								temp_meta_lore.add(ChatColor.RED + "You can't afford this!");
							} else {
								temp_meta_lore.add("");
								temp_meta_lore.add(ChatColor.GREEN + "Completing the operation will");
								temp_meta_lore.add(ChatColor.GREEN + "bring you to " + (player.getLevel() - cost) + " levels.");
							}

							temp_meta.setLore(temp_meta_lore);
							orbs.setItemMeta(temp_meta);

							orbs.setAmount(cost);
							anvilInv.setItem(LEVELS, orbs);

							anvilInv.setItem(OUTPUT, anvilInv.getItem(INPUT).clone());
							anvilInv.getItem(OUTPUT).removeEnchantment(appliedEnchant);
							anvilInv.getItem(OUTPUT).addUnsafeEnchantment(appliedEnchant, magnitude);
						}
					} else {
						// Can't add enchant, but can add bonus. Prepare output for bonus.
						anvilInv.setItem(OUTPUT, anvilInv.getItem(INPUT).clone());
					}

					boolean isTinkerer = true; // Change this to a playerInJob() call later.

					if (probableBonuses.size() != 0 && isTinkerer) {
						// Randomly select a bonus to add.
						int random = (int)(Math.random() * probableBonuses.size());
						Bukkit.getLogger().info("Randomized to # " + (random + 1) + " out of " + probableBonuses.size());

						int i = 0;

						String appliedEnchant = null;
						int magnitude = 0;
						for (String e : probableBonuses.keySet()) {

							if (i == random) {
								// Rolled this one
								appliedEnchant = e;
								magnitude = probableBonuses.get(e);
							}
							i++;
						}

						int cost = anvilInv.getItem(LEVELS).getAmount();

						if (itemBonuses.get(appliedEnchant) == null) {
							// This bonus doesn't exist. Calculate full cost.
							Bukkit.getLogger().info("Bonus doesn't exist.");
							Bukkit.getLogger().info("Bonus is: " + appliedEnchant + " at magnitude " + magnitude);

							cost += 12;
							cost = Math.min(60, cost);
							cost = Math.max(1, cost);

							ItemStack orbs = new ItemStack(Material.SLIME_BALL);

							ItemMeta temp_meta = orbs.getItemMeta();
							temp_meta.setDisplayName(ChatColor.YELLOW + "Experience Cost");
							List<String> temp_meta_lore = new ArrayList<String>();
							temp_meta_lore.add(ChatColor.ITALIC + "This operation costs " + cost + " levels.");
							temp_meta_lore.add(ChatColor.ITALIC + "You currently have " + player.getLevel() + " levels.");

							if (cost > player.getLevel()) {
								orbs.setType(Material.MAGMA_CREAM);
								temp_meta_lore.add("");
								temp_meta_lore.add(ChatColor.RED + "You can't afford this!");
							} else {
								temp_meta_lore.add("");
								temp_meta_lore.add(ChatColor.GREEN + "Completing the operation will");
								temp_meta_lore.add(ChatColor.GREEN + "bring you to " + (player.getLevel() - cost) + " levels.");
							}

							temp_meta.setLore(temp_meta_lore);
							orbs.setItemMeta(temp_meta);

							orbs.setAmount(cost);
							anvilInv.setItem(LEVELS, orbs);

							// Change entry matching modified lore
							ItemMeta bonusesMeta = anvilInv.getItem(OUTPUT).getItemMeta();
							List<String> bonusesLore = bonusesMeta.getLore();
							if (bonusesLore == null)
							{
								bonusesLore = new ArrayList<String>();
							}

							// Bukkit.getLogger().info("Bonus enchantment string: " + appliedEnchant);
							if (appliedEnchant.equalsIgnoreCase("Critical Chance")) {
								bonusesLore.add(0, ChatColor.YELLOW+"+"+magnitude+"% "+ChatColor.BLUE+"Critical Chance");
							}
							if (appliedEnchant.equalsIgnoreCase("Armor Penetration")) {
								bonusesLore.add(0, ChatColor.YELLOW+"+"+magnitude+" "+ChatColor.BLUE+"Armor Penetration");
							}
							if (appliedEnchant.equalsIgnoreCase("Life Steal")) {
								bonusesLore.add(0, ChatColor.YELLOW+"+"+magnitude+"% "+ChatColor.BLUE+"Life Steal");
							}
							if (appliedEnchant.equalsIgnoreCase("Attack Speed")) {
								bonusesLore.add(0, ChatColor.YELLOW+"+"+magnitude+"% "+ChatColor.BLUE+"Attack Speed");
							}
							if (appliedEnchant.equalsIgnoreCase("Damage")) {
								bonusesLore.add(0, ChatColor.YELLOW+"+"+magnitude+" "+ChatColor.BLUE+"Damage");
							}
							if (appliedEnchant.equalsIgnoreCase("Health")) {
								bonusesLore.add(0, ChatColor.YELLOW+"+"+magnitude+" "+ChatColor.BLUE+"Health");
							}
							if (appliedEnchant.equalsIgnoreCase("Damage Reduction")) {
								bonusesLore.add(0, ChatColor.YELLOW+"+"+magnitude+"% "+ChatColor.BLUE+"Damage Reduction");
							}
							if (appliedEnchant.equalsIgnoreCase("Durability")) {
								bonusesLore.add(0, ChatColor.YELLOW+"+"+magnitude+"% "+ChatColor.BLUE+"Durability");
							}
							if (appliedEnchant.equalsIgnoreCase("Block Chance")) {
								bonusesLore.add(0, ChatColor.YELLOW+"+"+magnitude+"% "+ChatColor.BLUE+"Block Chance");
							}
							if (appliedEnchant.equalsIgnoreCase("Speed Boost Chance")) {
								bonusesLore.add(0, ChatColor.YELLOW+"+"+magnitude+"% "+ChatColor.BLUE+"Speed Boost Chance");
							}

							bonusesMeta.setLore(bonusesLore);
							anvilInv.getItem(OUTPUT).setItemMeta(bonusesMeta);

						} else {
							// This enchantment exists. Calculate incremental cost.

							cost += (int)(12d * itemBonuses.get(appliedEnchant) / probableBonuses.get(appliedEnchant)); // Make sure it's at least one level
							cost = Math.min(60, cost);
							cost = Math.max(1, cost);

							ItemStack orbs = new ItemStack(Material.SLIME_BALL);

							ItemMeta temp_meta = orbs.getItemMeta();
							temp_meta.setDisplayName(ChatColor.YELLOW + "Experience Cost");
							List<String> temp_meta_lore = new ArrayList<String>();
							temp_meta_lore.add(ChatColor.ITALIC + "This operation costs " + cost + " levels.");
							temp_meta_lore.add(ChatColor.ITALIC + "You currently have " + player.getLevel() + " levels.");

							if (cost > player.getLevel()) {
								orbs.setType(Material.MAGMA_CREAM);
								temp_meta_lore.add("");
								temp_meta_lore.add(ChatColor.RED + "You can't afford this!");
							} else {
								temp_meta_lore.add("");
								temp_meta_lore.add(ChatColor.GREEN + "Completing the operation will");
								temp_meta_lore.add(ChatColor.GREEN + "bring you to " + (player.getLevel() - cost) + " levels.");
							}

							temp_meta.setLore(temp_meta_lore);
							orbs.setItemMeta(temp_meta);

							orbs.setAmount(cost);
							anvilInv.setItem(LEVELS, orbs);

							// Change entry matching modified lore
							ItemMeta bonusesMeta = anvilInv.getItem(OUTPUT).getItemMeta();
							List<String> bonusesLore = bonusesMeta.getLore();

							for (int i1 = 0; i1 < bonusesLore.size(); i1++) {
								String e = bonusesLore.get(i1);

								if (containsEnchantment(e, appliedEnchant)) {
									// Bukkit.getLogger().info("Success! Found enchantment: " + e);
									// Bukkit.getLogger().info("Bonus enchantment: " + appliedEnchant);

									if (appliedEnchant.equalsIgnoreCase("Critical Chance")) {
										bonusesLore.set(i1, ChatColor.YELLOW+"+"+magnitude+"% "+ChatColor.BLUE+"Critical Chance");
									}
									if (appliedEnchant.equalsIgnoreCase("Armor Penetration")) {
										bonusesLore.set(i1, ChatColor.YELLOW+"+"+magnitude+" "+ChatColor.BLUE+"Armor Penetration");
									}
									if (appliedEnchant.equalsIgnoreCase("Life Steal")) {
										bonusesLore.set(i1, ChatColor.YELLOW+"+"+magnitude+"% "+ChatColor.BLUE+"Life Steal");
									}
									if (appliedEnchant.equalsIgnoreCase("Attack Speed")) {
										bonusesLore.set(i1, ChatColor.YELLOW+"+"+magnitude+"% "+ChatColor.BLUE+"Attack Speed");
									}
									if (appliedEnchant.equalsIgnoreCase("Damage")) {
										bonusesLore.set(i1, ChatColor.YELLOW+"+"+magnitude+" "+ChatColor.BLUE+"Damage");
									}
									if (appliedEnchant.equalsIgnoreCase("Health")) {
										bonusesLore.set(i1, ChatColor.YELLOW+"+"+magnitude+" "+ChatColor.BLUE+"Health");
									}
									if (appliedEnchant.equalsIgnoreCase("Damage Reduction")) {
										bonusesLore.set(i1, ChatColor.YELLOW+"+"+magnitude+"% "+ChatColor.BLUE+"Damage Reduction");
									}
									if (appliedEnchant.equalsIgnoreCase("Durability")) {
										bonusesLore.set(i1, ChatColor.YELLOW+"+"+magnitude+"% "+ChatColor.BLUE+"Durability");
									}
									if (appliedEnchant.equalsIgnoreCase("Block Chance")) {
										bonusesLore.set(i1, ChatColor.YELLOW+"+"+magnitude+"% "+ChatColor.BLUE+"Block Chance");
									}
									if (appliedEnchant.equalsIgnoreCase("Speed Boost Chance")) {
										bonusesLore.set(i1, ChatColor.YELLOW+"+"+magnitude+"% "+ChatColor.BLUE+"Speed Boost Chance");
									}
								}
							}

							bonusesMeta.setLore(bonusesLore);
							anvilInv.getItem(OUTPUT).setItemMeta(bonusesMeta);
						}
					}

				}
				// TRY EVERYTHING
				player.getInventory().setContents(player.getInventory().getContents());
				anvilInv.setContents(anvilInv.getContents());
				player.updateInventory();
			} else if (anvilInv.getItem(MAGIC).getType() == Material.BOOK && anvilInv.getItem(INPUT).getType() != Material.ENCHANTED_BOOK) {
				// Magic slot is a book. Unenchanting logic goes here.
				anvilInv.setItem(OUTPUT, new ItemStack(Material.ENCHANTED_BOOK));
				// anvilInv.getItem(OUTPUT).setType(Material.ENCHANTED_BOOK);

				ItemMeta bookMeta = anvilInv.getItem(OUTPUT).getItemMeta();
				
				// Grab enchantments and lore. This is necessary due to leather armor meta being a different class.
				Map<Enchantment, Integer> itemEnchantments = anvilInv.getItem(INPUT).getItemMeta().getEnchants(); 
				
				for (Enchantment e : itemEnchantments.keySet()) {
					bookMeta.addEnchant(e, itemEnchantments.get(e), true); // force-add all enchants
				}
				
				List<String> bookLore = anvilInv.getItem(INPUT).getItemMeta().getLore(); // add more filtering code after this later
				bookMeta.setLore(bookLore);
				
				bookMeta.setDisplayName(null);
				anvilInv.getItem(OUTPUT).setItemMeta(bookMeta);

				// If books stacked past 1, return all but 1 book to player inventory.

				if (anvilInv.getItem(MAGIC).getAmount() > 1) {
					sendToInventory(MAGIC, anvilInv.getItem(MAGIC).getAmount() - 1, player);
				}

				int cost = 12;

				Map<Enchantment, Integer> enchantments = anvilInv.getItem(INPUT).getEnchantments();

				for (Enchantment e : enchantments.keySet()) {
					cost += (1 + enchantments.get(e));
				}
				
				cost = Math.min(60, cost);

				ItemStack orbs = new ItemStack(Material.SLIME_BALL);

				ItemMeta temp_meta = orbs.getItemMeta();
				temp_meta.setDisplayName(ChatColor.YELLOW + "Experience Cost");
				List<String> temp_meta_lore = new ArrayList<String>();
				temp_meta_lore.add(ChatColor.ITALIC + "This operation costs " + cost + " levels.");
				temp_meta_lore.add(ChatColor.ITALIC + "You currently have " + player.getLevel() + " levels.");

				if (cost > player.getLevel()) {
					orbs.setType(Material.MAGMA_CREAM);
					temp_meta_lore.add("");
					temp_meta_lore.add(ChatColor.RED + "You can't afford this!");
				} else {
					temp_meta_lore.add("");
					temp_meta_lore.add(ChatColor.GREEN + "Completing the operation will");
					temp_meta_lore.add(ChatColor.GREEN + "bring you to " + (player.getLevel() - cost) + " levels.");
				}

				temp_meta.setLore(temp_meta_lore);
				orbs.setItemMeta(temp_meta);

				orbs.setAmount(cost);
				anvilInv.setItem(LEVELS, orbs);

				// TRY EVERYTHING
				player.getInventory().setContents(player.getInventory().getContents());
				anvilInv.setContents(anvilInv.getContents());
				player.updateInventory();

			}
		}
	}

	public void sendToInventory(int slot, int itemCount, Player player) {
		// Bukkit.getLogger().info("Slot: " + slot);
		// Bukkit.getLogger().info("Item Count: " + itemCount);
		// Bukkit.getLogger().info("Player: " + player.getDisplayName());

		// Get inventories
		Inventory anvilInventory = player.getOpenInventory().getTopInventory();
		Inventory playerInventory = player.getOpenInventory().getBottomInventory();

		// Get a temporary item stack to transfer
		ItemStack temp = anvilInventory.getItem(slot).clone();
		temp.setAmount(itemCount);

		// Attempt to add to the player inventory. Store leftovers in itemstack to be dropped.
		ItemStack leftovers = playerInventory.addItem(temp).get(0);

		if (leftovers != null) {
			player.getWorld().dropItemNaturally(player.getLocation(), leftovers);
		}


		// Bukkit.getLogger().info("Slot stack size is " + anvilInventory.getItem(slot).getAmount());


		if (anvilInventory.getItem(slot).getAmount() - itemCount == 0) {
			// Should reduce stack count to zero, meaning item needs to be removed.
			// Bukkit.getLogger().info("Item stack size reduced to 0, " + anvilInventory.getItem(slot).getType().toString() + " removed.");
			anvilInventory.setItem(slot, new ItemStack(Material.AIR));
		} else {
			// Should set stack size.
			// Bukkit.getLogger().info("Reduced stack size from " + anvilInventory.getItem(slot).getAmount() + " by " + itemCount);
			anvilInventory.getItem(slot).setAmount(anvilInventory.getItem(slot).getAmount() - itemCount);
		}
		// player.getWorld().dropItemNaturally(player.getLocation(), new ItemStack(anvilInv.getItem(MATERIALS).getType(), anvilInv.getItem(MATERIALS).getAmount() - maxItemsNeeded));

	}

	public double getEnchantmentNumb(String s) {
		//Parse the string for spaces.
		String[] enchant = s.split(" ");
		if (enchant[0].contains(ChatColor.YELLOW+"") && (enchant.length > 1)) {
			String newstring = ((enchant[0].replace(ChatColor.YELLOW.getChar(), ' ')).replace('%', ' ')).replace(Character.toString((char)0x00A7), Character.toString((char)0x0020));
			// Bukkit.getLogger().info("Enchant number is "+Double.valueOf(newstring));
			return Double.valueOf(newstring);
		} else {
			return 0;
		}
	}

	public String getEnchantmentName(String s) {
		//Parse the string for spaces.
		String[] enchant = s.split(ChatColor.BLUE+"");
		if (enchant.length > 1) {
			return enchant[1];
		} else {
			return null;
		}
	}


	public boolean containsEnchantment(String s, String enchant) {
		if (s.contains(enchant)) {
			return true;
		}
		return false;
	}

} 
