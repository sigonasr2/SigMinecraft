package me.kaZep.Commands;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import me.kaZep.Base.Main;
import me.kaZep.Base.MobHead;
import me.kaZep.Base.MobHead.MobHeadRareType;
import me.kaZep.Base.MobHead.MobHeadType;
import me.kaZep.Commands.JobsDataInfo.Job;
import net.jmhertlein.mctowns.MCTowns;
import net.jmhertlein.mctowns.MCTownsPlugin;
import net.jmhertlein.mctowns.database.TownManager;
import net.jmhertlein.mctowns.structure.Town;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.SkullType;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Skull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Wolf;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import sig.ItemSets.DiabloDropsHook;
import sig.ItemSets.DiabloDropsHook.Tier;
import sig.ItemSets.DiabloDropsHook;
import sig.ItemSets.DiabloDropsHook.Tier;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.schematic.SchematicFormat;


public class commandBankEconomy
  implements CommandExecutor
{
  public Main plugin;
  String prefix = "Åò2[BankEconomy]";
  String usage = "ÅòbUsage:";
  String invARG = "ÅòcInvalid argument. Please use Åò2/bankeconomyÅòc to see a full list of commands.";
  String invARGT2 = "ÅòcInvalid argument or insufficient permissions.";
  String offlinePlayer = "ÅòcPlayer / Town not found.";
  String accountDisabled = "ÅòcYour account is disabled.";

  String cmdInfo = "ÅòaYour bank balance isÅòb";
  String cmdCheckARG1 = "Åòa/bankeconomy check <player>";
  String cmdResetARG1 = "Åòa/bankeconomy reset <player>";
  String cmdDepositARG1 = "Åòa";
  String cmdWithdrawARG1 = "Åòa";
  String cmdTransferARG1 = "Åòa/transfer <player> <amount>";
  String cmdTransferARG2 = "ÅòaPlease precise the name of the player.";
  String cmdEditARG1 = "Åòa/bankeconomy edit <action> <player> <value>";
  String cmdEditARG2 = "ÅòaPlease precise the value.";

  String cmdCheckReponsePlayer = "Åòa's bank balance isÅòb";
  String cmdResetToPlayer1 = "ÅòaYou have reset";
  String cmdResetToPlayer2 = "'s bank account.";
  String cmdResetToTarget = "has reset your bank account.";
  String cmdReload = "ÅòaAll the configs have been reloaded succesfully.";
  String notEnoughMoney = "ÅòaYou do not own that amount of money.";
  String succesfullDeposited = "ÅòaYou have depositedÅòb";
  String succesfullWithdraw = "ÅòaYou have withdrawnÅòb";
  String cmdTransferToPlayer1 = "ÅòaYou have transferredÅòb";
  String cmdTransferToPlayer2 = "ÅòatoÅòb";
  String cmdTransferToTarget1 = "Åòahas transferred to youÅòb";
  String cmdTransferSameNick = "ÅòaYou can't transfer money to yourself.";
  String cmdEditAvaibleActions = "ÅòaAvaible actions: status, balance";
  String cmdEditDisabledToPlayer1 = "ÅòaYou have disabled";
  String cmdEditDisabledToPlayer2 = "'s bank account.";
  String cmdEditEnableToPlayer1 = "ÅòaYou have enabled";
  String cmdEditEnableToPlayer2 = "'s bank account.";
  String cmdEditAmountSetPlayer1 = "ÅòaYou have set";
  String cmdEditAmountSetPlayer2 = "ÅòatoÅòb";
  String cmdEditAmountSetPlayer3 = "Åòa's account.";

  public commandBankEconomy(Main plugin)
  {
    this.plugin = plugin;
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
  
  

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((sender instanceof Player)) {
      Player p = (Player)sender;

      boolean status = this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase() + ".status");
      double playerBankBalance = this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase() + ".money");
	  playerBankBalance = this.plugin.compoundInterest(p);

      String currencySingular = Main.economy.currencyNameSingular();
      String currencyPlural = Main.economy.currencyNamePlural();

      if (!status)
        p.sendMessage(this.prefix + " " + this.accountDisabled);
      else if (status) {
        if ((args.length == 0)) {
	        if (cmd.getName().toLowerCase().equalsIgnoreCase("sp")) {
			  //Show a list of all stat points and what you have currently allocated.
	        	p.sendMessage("");
	        	p.sendMessage("Stat Listing shown as: "+ChatColor.AQUA+"Cost, "+ChatColor.YELLOW+"Current Buff, "+ChatColor.RED+"Next Level, "+ChatColor.GREEN+" Description");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#10 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat1")/6+" - "+ChatColor.AQUA+" 6 pts: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat1")<24 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat1")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(0, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat1")/6)+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(0, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat1")/6+1):ChatColor.RED+"+"+this.plugin.getStatBonus(0, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat1")/6+1)):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(0, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat1")/6))))+ChatColor.GREEN+" Health Regeneration.");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#9 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat2")/5+" - "+ChatColor.AQUA+" 5 pts: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat2")<24 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat2")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(1, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat2")/5)+"%"+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(1, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat2")/5+1)+"%":ChatColor.RED+"+"+this.plugin.getStatBonus(1, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat2")/5+1)+"%"):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(1, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat2")/5)+"%")))+ChatColor.GREEN+" block destroying speed.");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#8 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat3")/4+" - "+ChatColor.AQUA+" 4 pts: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat3")<24 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat3")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(2, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat3")/4)+"%"+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(2, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat3")/4+1)+"%":ChatColor.RED+"+"+this.plugin.getStatBonus(2, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat3")/4+1)+"%"):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(2, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat3")/4)+"%")))+ChatColor.GREEN+" damage reduction.");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#7 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat5")/4+" - "+ChatColor.AQUA+" 4 pts: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat5")<24 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat5")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat5")/4)+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat5")/4+1):ChatColor.RED+"+"+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat5")/4+1)):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat5")/4))))+ChatColor.GREEN+" armor penetration.");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#6 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat4")/3+" - "+ChatColor.AQUA+" 3 pts: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat4")<24 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat4")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(3, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat4")/3)+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(3, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat4")/3+1):ChatColor.RED+"+"+this.plugin.getStatBonus(3, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat4")/3+1)):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(3, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat4")/3))))+ChatColor.GREEN+" temporary health. (Regenerates every 3 minutes)");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#5 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat6")/3+" - "+ChatColor.AQUA+" 3 pts: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat6")<24 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat6")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(5, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat6")/3)+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(5, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat6")/3+1):ChatColor.RED+"+"+this.plugin.getStatBonus(5, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat6")/3+1)):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(5, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat6")/3))))+ChatColor.GREEN+" seconds of fire resistance when caught on fire.");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#4 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat7")/2+" - "+ChatColor.AQUA+" 2 pts: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat7")<24 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat7")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(6, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat7")/2)+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(6, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat7")/2+1):ChatColor.RED+"+"+this.plugin.getStatBonus(6, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat7")/2+1)):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(6, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat7")/2))))+ChatColor.GREEN+" base damage.");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#3 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat8")/2+" - "+ChatColor.AQUA+" 2 pts: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat8")<24 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat8")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(7, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat8")/2)+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(7, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat8")/2+1):ChatColor.RED+"+"+this.plugin.getStatBonus(7, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat8")/2+1)):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(7, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat8")/2))))+ChatColor.GREEN+" health.");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#2 "+ChatColor.RESET+ChatColor.WHITE+"-"+this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat9")/1+" - "+ChatColor.AQUA+" 1 pt: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat9")<25 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat9")>0/*Has a point in it.*/?ChatColor.YELLOW+"-"+this.plugin.getStatBonus(8, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat9")/1)+"%"+"/"+ChatColor.RED+"-"+this.plugin.getStatBonus(8, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat9")/1+1)+"%":ChatColor.RED+"-"+this.plugin.getStatBonus(8, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat9")/1+1)+"%"):(ChatColor.YELLOW+"-"+this.plugin.getStatBonus(8, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat9")/1)+"%")))+ChatColor.GREEN+" hunger decay.");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#1 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat10")/1+" - "+ChatColor.AQUA+" 1 pt: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat10")<25 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat10")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(9, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat10")/1)+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(9, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat10")/1+1):ChatColor.RED+"+"+this.plugin.getStatBonus(9, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat10")/1+1)):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(9, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat10")/1))))+ChatColor.GREEN+" seconds of water breathing.");
	        	p.sendMessage(ChatColor.ITALIC+""+ChatColor.DARK_AQUA+"Remember that 1 Health / Damage point is half a heart.");
	        	if (this.plugin.getStatPointTotal(p)<this.plugin.getJobTotalLvs(p)/5+1) {
	        		//Check if we have extra stat points.
	        		p.sendMessage(ChatColor.GOLD+"Type "+ChatColor.BLUE+ChatColor.BOLD+"/sp #"+ChatColor.RESET+ChatColor.GOLD+" with the number of the buff you want to add a point to. (You have "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+".)");
	        	}
	        } else
          if (cmd.getName().toLowerCase().equalsIgnoreCase("tele")) {
			  p.sendMessage("Usage: "+ChatColor.RED+"/tele to "+ChatColor.GREEN+" <player/town>"+ChatColor.WHITE+" - Teleport to a player/town for a cost.");
          } else
          if (cmd.getName().toLowerCase().equalsIgnoreCase("settings")) {
			  Inventory i = Bukkit.createInventory(p, 27, "Notification Options");
			  int count=-1;
			  ItemStack temp,on,off;
			  temp=new ItemStack(Material.DIRT);
			  ItemMeta temp_meta=temp.getItemMeta();temp_meta.setDisplayName(ChatColor.YELLOW+"Pick Up Items");List<String> temp_meta_lore = new ArrayList<String>();temp_meta_lore.add(ChatColor.ITALIC+"Get notified whenever you pick up items.");temp_meta_lore.add(ChatColor.ITALIC+"");temp_meta_lore.add(ChatColor.ITALIC+""+ChatColor.GRAY+"Click to toggle this option on or off.");temp_meta.setLore(temp_meta_lore);temp.setItemMeta(temp_meta);
			  on=new ItemStack(Material.REDSTONE_TORCH_ON);
			  off=new ItemStack(Material.REDSTONE_TORCH_OFF);
			  i.setItem(count+=2, temp);on.setItemMeta(temp_meta);off.setItemMeta(temp_meta); i.setItem(count+=1, (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify1")?on:off));
			  temp_meta.setDisplayName(ChatColor.YELLOW+"Craft Items");temp_meta_lore = new ArrayList<String>();temp_meta_lore.add(ChatColor.ITALIC+"Get notified whenever you craft an item.");temp_meta_lore.add(ChatColor.ITALIC+"");temp_meta_lore.add(ChatColor.ITALIC+""+ChatColor.GRAY+"Click to toggle this option on or off.");temp_meta.setLore(temp_meta_lore);
			  temp=new ItemStack(Material.WORKBENCH);
			  temp.setItemMeta(temp_meta);i.setItem(count+=3, temp);on.setItemMeta(temp_meta);off.setItemMeta(temp_meta); i.setItem(count+=1, (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify2")?on:off));
			  temp_meta.setDisplayName(ChatColor.YELLOW+"Experience Points");temp_meta_lore = new ArrayList<String>();temp_meta_lore.add(ChatColor.ITALIC+"Get notified whenever you gain");temp_meta_lore.add(ChatColor.ITALIC+"experience points.");temp_meta_lore.add(ChatColor.ITALIC+"");temp_meta_lore.add(ChatColor.ITALIC+""+ChatColor.GRAY+"Click to toggle this option on or off.");temp_meta.setLore(temp_meta_lore);
			  temp=new ItemStack(Material.SLIME_BALL);
			  temp.setItemMeta(temp_meta);i.setItem(count+=4, temp);on.setItemMeta(temp_meta);off.setItemMeta(temp_meta); i.setItem(count+=1, (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify3")?on:off));
			  temp_meta.setDisplayName(ChatColor.YELLOW+"Damage Dealt");temp_meta_lore = new ArrayList<String>();temp_meta_lore.add(ChatColor.ITALIC+"Get notified whenever you deal");temp_meta_lore.add(ChatColor.ITALIC+"damage to enemies.");temp_meta_lore.add(ChatColor.ITALIC+"");temp_meta_lore.add(ChatColor.ITALIC+""+ChatColor.GRAY+"Click to toggle this option on or off.");temp_meta.setLore(temp_meta_lore);
			  temp=new ItemStack(Material.IRON_SWORD);
			  temp.setItemMeta(temp_meta);i.setItem(count+=3, temp);on.setItemMeta(temp_meta);off.setItemMeta(temp_meta); i.setItem(count+=1, (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify4")?on:off));
			  temp_meta.setDisplayName(ChatColor.YELLOW+"Damage Received");temp_meta_lore = new ArrayList<String>();temp_meta_lore.add(ChatColor.ITALIC+"Get notified whenever you take damage");temp_meta_lore.add(ChatColor.ITALIC+" from enemies and other sources of damage.");temp_meta_lore.add(ChatColor.ITALIC+"");temp_meta_lore.add(ChatColor.ITALIC+""+ChatColor.GRAY+"Click to toggle this option on or off.");temp_meta.setLore(temp_meta_lore);
			  temp=new ItemStack(Material.IRON_CHESTPLATE);
			  temp.setItemMeta(temp_meta); i.setItem(count+=4, temp);on.setItemMeta(temp_meta);off.setItemMeta(temp_meta); i.setItem(count+=1, (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify5")?on:off));
			  temp_meta.setDisplayName(ChatColor.YELLOW+"Money Gained");temp_meta_lore = new ArrayList<String>();temp_meta_lore.add(ChatColor.ITALIC+"Get notified of how much money you made");temp_meta_lore.add(ChatColor.ITALIC+" from your jobs in the past hour.");temp_meta_lore.add(ChatColor.ITALIC+"");temp_meta_lore.add(ChatColor.ITALIC+""+ChatColor.GRAY+"Click to toggle this option on or off.");temp_meta.setLore(temp_meta_lore);
			  temp=new ItemStack(Material.GOLD_INGOT);
			  temp.setItemMeta(temp_meta);i.setItem(count+=3, temp);on.setItemMeta(temp_meta);off.setItemMeta(temp_meta); i.setItem(count+=1, (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify6")?on:off));
			  p.openInventory(i);
          } else
          if (cmd.getName().toLowerCase().equalsIgnoreCase("event")) {
			  if (p.hasPermission("maintenance-mode-admin")) {
				  p.sendMessage("Events available: halloween, thanksgiving. Use: /event <eventname>");
			  }
          } else
          if (cmd.getName().toLowerCase().equalsIgnoreCase("maintenance")) {
			  if (p.hasPermission("maintenance-mode-admin")) {
				  if (this.plugin.getConfig().getBoolean("maintenance-mode")) {
					  this.plugin.getConfig().set("maintenance-mode", Boolean.valueOf(false));
					  Bukkit.broadcastMessage("Maintenance mode is now "+ChatColor.BLUE+" OFF"+ChatColor.RESET+".");
				  } else {
					  this.plugin.getConfig().set("maintenance-mode", Boolean.valueOf(true));
					  Bukkit.broadcastMessage("Maintenance mode is now "+ChatColor.RED+" ON"+ChatColor.RESET+".");
				  }
				  this.plugin.saveConfig();
			  }
          } else
          if (cmd.getName().toLowerCase().equalsIgnoreCase("transfer")) {
			  p.sendMessage("Usage: "+ChatColor.RED+"/transfer name money"+ChatColor.WHITE+" - Transfer money to a player.");
          } else
          if (cmd.getName().toLowerCase().equalsIgnoreCase("revive")) {
			  p.sendMessage("Usage: "+ChatColor.RED+"/revive me "+ChatColor.WHITE+" - Revive to the last location you died at.");
          } else
          if (cmd.getName().toLowerCase().equalsIgnoreCase("unenchant")) {
        	  Map<Enchantment,Integer> map  = p.getItemInHand().getEnchantments();
    		  for (Map.Entry<Enchantment,Integer> entry : map.entrySet()) {
    			  p.getItemInHand().removeEnchantment(entry.getKey());
    		  }
    		  if (p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasLore()) {
        		  List<String> newlore = new ArrayList<String>();
    			  for (int i=0;i<p.getItemInHand().getItemMeta().getLore().size();i++) {
    				  //Remove all lore when unenchanting.
    				  //Do not remove -400% durability.
					  if (this.plugin.is_PermanentProperty(p.getItemInHand().getItemMeta().getLore().get(i))) {
						  newlore.add(p.getItemInHand().getItemMeta().getLore().get(i));
					  }
    			  }
    			  ItemMeta meta = p.getItemInHand().getItemMeta();
    			  meta.setLore(newlore);
    			  p.getItemInHand().setItemMeta(meta);
    		  }
    		  p.sendMessage("Enchantments and bonuses removed on this item.");
          }
          else
          if (cmd.getName().equalsIgnoreCase("line")) {
        	  if (this.plugin.hasJobBuff("Builder", p, Job.JOB5)) {
        		  p.sendMessage("You have received a line builder tool.");
        		  ItemStack i = new ItemStack(Material.getMaterial(141));
        		  ItemMeta meta = i.getItemMeta();
        		  meta.setDisplayName(ChatColor.GRAY+"Line Builder Tool");
        		  List<String> newlore = new ArrayList<String>();
        		  newlore.add(ChatColor.YELLOW+"Can only be used by Lv5+ Builders.");
        		  newlore.add(ChatColor.YELLOW+"");
        		  newlore.add("Left-click one block and another");
        		  newlore.add("of the same type to create a line");
        		  newlore.add("of blocks. "+ChatColor.BLUE+"(Max Range: 500 blocks)");
        		  meta.setLore(newlore);
        		  i.setItemMeta(meta);
        		  p.getInventory().addItem(i);
        	  } else {
        		  p.sendMessage(ChatColor.RED+"You do not have the Lv5 Builder Buff!");
        	  }
          }
          else
          if (cmd.getName().equalsIgnoreCase("rectangle")) {
        	  if (this.plugin.hasJobBuff("Builder", p, Job.JOB10)) {
        		  p.sendMessage("You have received a rectangle builder tool.");
        		  ItemStack i = new ItemStack(Material.getMaterial(142));
        		  ItemMeta meta = i.getItemMeta();
        		  meta.setDisplayName(ChatColor.GRAY+"Rectangle Builder Tool");
        		  List<String> newlore = new ArrayList<String>();
        		  newlore.add(ChatColor.YELLOW+"Can only be used by Lv10+ Builders.");
        		  newlore.add(ChatColor.YELLOW+"");
        		  newlore.add("Left-click one block and another");
        		  newlore.add("of the same type to fill a");
        		  newlore.add("rectangle of blocks.");
        		  newlore.add(ChatColor.BLUE+" (Max Range: 500 blocks)");
        		  meta.setLore(newlore);
        		  i.setItemMeta(meta);
        		  p.getInventory().addItem(i);
        	  } else {
        		  p.sendMessage(ChatColor.RED+"You do not have the Lv10 Builder Buff!");
        	  }
          }
          else
          if (cmd.getName().toLowerCase().equalsIgnoreCase("ticktime")) {
    		  p.sendMessage("Current Server Time: "+ChatColor.GRAY+""+ChatColor.ITALIC+Main.SERVER_TICK_TIME);
          }
          else
          if (cmd.getName().toLowerCase().equalsIgnoreCase("jobs")) {
        	  FileConfiguration config = this.plugin.getConfig();
        	  int MAXJOBS = config.getInt("jobs.MAX_JOBS");
			  p.sendMessage(ChatColor.GOLD+" Blacksmith ("+config.getInt("jobs.Blacksmith")+"/"+MAXJOBS+")");
			  p.sendMessage(ChatColor.DARK_GREEN+" Breeder ("+config.getInt("jobs.Breeder")+"/"+MAXJOBS+")");
			  p.sendMessage(ChatColor.LIGHT_PURPLE+" Brewer ("+config.getInt("jobs.Brewer")+"/"+MAXJOBS+")");
			  p.sendMessage(ChatColor.WHITE+" Builder ("+config.getInt("jobs.Builder")+"/"+MAXJOBS+")");
			  p.sendMessage(ChatColor.YELLOW+" Cook ("+config.getInt("jobs.Cook")+"/"+MAXJOBS+")");
			  p.sendMessage(ChatColor.GOLD+" Digger ("+config.getInt("jobs.Digger")+"/"+MAXJOBS+")");
			  p.sendMessage(ChatColor.DARK_BLUE+" Enchanter ("+config.getInt("jobs.Enchanter")+"/"+MAXJOBS+")");
			  p.sendMessage(ChatColor.WHITE+" Explorer ("+config.getInt("jobs.Explorer")+"/"+MAXJOBS+")");
			  p.sendMessage(ChatColor.AQUA+" Fisherman ("+config.getInt("jobs.Fisherman")+"/"+MAXJOBS+")");
			  p.sendMessage(ChatColor.RED+" Hunter ("+config.getInt("jobs.Hunter")+"/"+MAXJOBS+")");
			  p.sendMessage(ChatColor.GRAY+" Miner ("+config.getInt("jobs.Miner")+"/"+MAXJOBS+")");
			  p.sendMessage(ChatColor.DARK_RED+" Support ("+config.getInt("jobs.Support")+"/"+MAXJOBS+")");
			  p.sendMessage(ChatColor.DARK_PURPLE+" Weaponsmith ("+config.getInt("jobs.Weaponsmith")+"/"+MAXJOBS+")");
			  p.sendMessage(ChatColor.GREEN+" Woodcutter ("+config.getInt("jobs.Woodcutter")+"/"+MAXJOBS+")");
			  p.sendMessage("For more information, type "+ChatColor.GREEN+"/jobs info [JobName]");			  
          } else
          if (!p.hasPermission("bankeconomy.main.admin")) {
            p.sendMessage(ChatColor.GOLD + "---===" + this.prefix + 
              ChatColor.GOLD + "===---");
            p.sendMessage(ChatColor.RED + "/bankeconomy transfer " + 
              ChatColor.AQUA + 
              "- Transfer some money to other player.");
            p.sendMessage(ChatColor.RED + "/bankeconomy info " + 
              ChatColor.AQUA + "- See your bank informations.");
            p.sendMessage(ChatColor.RED + "/revive me" + 
                    ChatColor.AQUA + "- Revive after a death.");
            p.sendMessage(ChatColor.RED + "/revive amount " + 
                    ChatColor.AQUA + "- Check cost to revive at current location.");
          } else {
            p.sendMessage(ChatColor.GOLD + "---===" + this.prefix + 
              ChatColor.GOLD + "===---");
            p.sendMessage(ChatColor.RED + "/bankeconomy transfer " + 
              ChatColor.AQUA + 
              "- Transfer some money to other player.");
            p.sendMessage(ChatColor.RED + "/bankeconomy info " + 
              ChatColor.AQUA + "- See your bank informations.");
            p.sendMessage(ChatColor.DARK_RED + "/bankeconomy edit " + 
              ChatColor.DARK_AQUA + "- Edit a player bank account.");
            p.sendMessage(ChatColor.RED + "/revive me" + 
                    ChatColor.AQUA + "- Revive after a death.");
            p.sendMessage(ChatColor.RED + "/revive amount " + 
                    ChatColor.AQUA + "- Check cost to revive at current location.");
            p.sendMessage(ChatColor.DARK_RED + "/bankeconomy check " + 
              ChatColor.DARK_AQUA + 
              "- Check a player bank account.");
            p.sendMessage(ChatColor.DARK_RED + "/bankeconomy reset " + 
              ChatColor.DARK_AQUA + 
              "- Delete a player bank account.");
            p.sendMessage(ChatColor.DARK_RED + "/bankeconomy reload " + 
              ChatColor.DARK_AQUA + 
              "- Reloads config and accounts.");
          }
        } else 
            if (cmd.getName().toLowerCase().equalsIgnoreCase("rename") && args.length>=1) {
            	if (p.getItemInHand().getType()==Material.NAME_TAG) {
            		ItemMeta meta = p.getItemInHand().getItemMeta();
            		if (meta.getDisplayName()==null) {
            			meta.setDisplayName(ChatColor.RESET+"");
            		}
	            		for (int i=0;i<args.length;i++) {
	                		if (meta.getDisplayName().equals(ChatColor.RESET+"")) {
	                			meta.setDisplayName(args[i]);
	                		} else {
	                			meta.setDisplayName(meta.getDisplayName()+" "+args[i]);
	                		}
	            		}
            		p.getItemInHand().setItemMeta(meta);
            		p.sendMessage("Changed name tag's title to "+p.getItemInHand().getItemMeta().getDisplayName()+".");
            	}
            } else
            if (cmd.getName().toLowerCase().equalsIgnoreCase("event") && args.length==1 && p.hasPermission("maintenance-mode-admin")) {
  			  if (args[0].equalsIgnoreCase("halloween")) {
  				  if (this.plugin.getConfig().getBoolean("halloween-enabled")) {
  					  this.plugin.getConfig().set("halloween-enabled", Boolean.valueOf(false));
  					  p.sendMessage("Halloween event disabled.");
  				  } else {
  					  this.plugin.getConfig().set("halloween-enabled", Boolean.valueOf(true));
  					  p.sendMessage("Halloween event enabled.");
  				  }
  				  this.plugin.saveConfig();
  			  }
  			  if (args[0].equalsIgnoreCase("thanksgiving")) {
  				  if (this.plugin.getConfig().getBoolean("thanksgiving-enabled")) {
  					  this.plugin.getConfig().set("thanksgiving-enabled", Boolean.valueOf(false));
  					  p.sendMessage("Thanksgiving event disabled.");
  				  } else {
  					  this.plugin.getConfig().set("thanksgiving-enabled", Boolean.valueOf(true));
  					  p.sendMessage("Thanksgiving event enabled.");
  				  }
  				  this.plugin.saveConfig();
  			  }
			if (args[0].equalsIgnoreCase("cheatheads")) {
	  			  if (p.hasPermission("maintenance-mode-admin")) {
	  				  Inventory i = Bukkit.createInventory(p, 63, "Mob Head Inventory");
	  				  
	  				  ItemStack temp = null;
	  				  
	  				  int count = -1;
	  				  for (int k=0;k<MobHeadType.values().length;k++) {
	  					  temp = new MobHead(MobHeadType.values()[k]).getItemStack();
	  					  temp.setAmount(3);
	  					  i.setItem(count+=1, temp);
	  				  }
	  				  for (int k=0;k<MobHeadType.values().length;k++) {
		  				  for (int l=0;l<MobHeadRareType.values().length;l++) {
		  					  temp = new MobHead(MobHeadType.values()[k],true,MobHeadRareType.values()[l]).getItemStack();
		  					  temp.setAmount(3);
		  					  i.setItem(count+=1, temp);
		  				  }
	  				  }
	  				  for (int k=0;k<MobHeadType.values().length;k++) {
	  					  temp = new MobHead(MobHeadType.values()[k],false,true).getItemStack();
	  					  temp.setAmount(3);
	  					  i.setItem(count+=1, temp);
	  				  }
	  				  for (int k=0;k<MobHeadType.values().length;k++) {
	  					  temp = new MobHead(MobHeadType.values()[k],true,true).getItemStack();
	  					  temp.setAmount(3);
	  					  i.setItem(count+=1, temp);
	  				  }
	  				  
	  				  p.openInventory(i);
	  			  }
			}
  			if (args[0].equalsIgnoreCase("cheat")) {
  			  if (p.hasPermission("maintenance-mode-admin")) {
  				  p.sendMessage("Permission granted. Now loading Aperture Science Laboratory Equipment.");
  				  // Heals player
  				  p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 10000), true);
  				  
  				  
  				  // Opens an inventory with powerful armor. 
  				  Inventory i = Bukkit.createInventory(p, 27, "Nanoscience Repository");
  				  
  				  int count = -1;
  				  
  				  ItemStack temp;
  				  ItemMeta temp_meta;
  				  List<String> temp_meta_lore;
  				  
  				  // Helm
  				  temp = new ItemStack(Material.DIAMOND_HELMET);
  				  temp_meta=temp.getItemMeta();
  				  temp_meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Nanotech Helmet");
  				  temp_meta_lore = new ArrayList<String>();
  				  temp_meta_lore.add(ChatColor.YELLOW+"+100% "+ChatColor.BLUE+"Damage Reduction");
  				  temp_meta_lore.add(ChatColor.AQUA+"Food replenish");
  				  temp_meta.setLore(temp_meta_lore);
  				  temp.setItemMeta(temp_meta);
  				  temp.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
  				  temp.addUnsafeEnchantment(Enchantment.OXYGEN, 4);
  				  temp.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1);
  				  i.setItem(count+=1, temp);

  				  // Chestplate
  				  temp = new ItemStack(Material.DIAMOND_CHESTPLATE);
  				  temp_meta=temp.getItemMeta();
  				  temp_meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Nanotech Breastplate");
  				  temp_meta_lore = new ArrayList<String>();
  				  temp_meta_lore.add(ChatColor.YELLOW+"+190 "+ChatColor.BLUE+"Health");
  				  temp_meta_lore.add(ChatColor.AQUA+"Fire resistance");
  				  temp_meta.setLore(temp_meta_lore);
  				  temp.setItemMeta(temp_meta);
  				  temp.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 10);
  				  i.setItem(count+=1, temp);

  				  // Leggings
  				  temp = new ItemStack(Material.DIAMOND_LEGGINGS);
  				  temp_meta=temp.getItemMeta();
  				  temp_meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Nanotech Leggings");
  				  temp_meta_lore = new ArrayList<String>();
  				  temp_meta_lore.add(ChatColor.YELLOW+"+100% "+ChatColor.BLUE+"Block Chance");
  				  temp_meta_lore.add(ChatColor.AQUA+"Hyper sprint");
  				  temp_meta.setLore(temp_meta_lore);
  				  temp.setItemMeta(temp_meta);
  				  temp.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 10);
  				  i.setItem(count+=1, temp);

  				  // Boots
  				  temp = new ItemStack(Material.DIAMOND_BOOTS);
  				  temp_meta=temp.getItemMeta();
  				  temp_meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Nanotech Boots");
  				  temp_meta_lore = new ArrayList<String>();
  				  temp_meta_lore.add(ChatColor.YELLOW+"+100% "+ChatColor.BLUE+"Speed Boost Chance");
  				  temp_meta_lore.add(ChatColor.AQUA+"Hyper jump");
  				  temp_meta.setLore(temp_meta_lore);
  				  temp.setItemMeta(temp_meta);
  				  temp.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 10);
  				  i.setItem(count+=1, temp);

  				  // Sword
  				  temp = new ItemStack(Material.DIAMOND_SWORD);
  				  temp_meta=temp.getItemMeta();
  				  temp_meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Nanotech Saber");
  				  temp_meta_lore = new ArrayList<String>();
  				  temp_meta_lore.add(ChatColor.YELLOW+"+100% "+ChatColor.BLUE+"Life Steal");
  				  temp_meta_lore.add(ChatColor.YELLOW+"+100% "+ChatColor.BLUE+"Attack Speed");
  				  temp_meta_lore.add(ChatColor.YELLOW+"+100% "+ChatColor.BLUE+"Critical Chance");
  				  temp_meta_lore.add(ChatColor.YELLOW+"+20 "+ChatColor.BLUE+"Armor Penetration");
  				  temp_meta_lore.add(ChatColor.YELLOW+"+100 "+ChatColor.BLUE+"Damage");
  				  temp_meta.setLore(temp_meta_lore);
  				  temp.setItemMeta(temp_meta);
  				  temp.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
  				  i.setItem(count+=1, temp);

  				  // Bow
  				  temp = new ItemStack(Material.BOW);
  				  temp_meta=temp.getItemMeta();
  				  temp_meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Nanotech Longbow");
  				  temp_meta_lore = new ArrayList<String>();
  				  temp_meta_lore.add(ChatColor.YELLOW+"+100% "+ChatColor.BLUE+"Life Steal");
  				  temp_meta_lore.add(ChatColor.YELLOW+"+100% "+ChatColor.BLUE+"Attack Speed");
  				  temp_meta_lore.add(ChatColor.YELLOW+"+100% "+ChatColor.BLUE+"Critical Chance");
  				  temp_meta_lore.add(ChatColor.YELLOW+"+20 "+ChatColor.BLUE+"Armor Penetration");
  				  temp_meta_lore.add(ChatColor.YELLOW+"+100 "+ChatColor.BLUE+"Damage");
  				  temp_meta.setLore(temp_meta_lore);
  				  temp.setItemMeta(temp_meta);
  				  temp.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
  				  temp.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 10);
  				  i.setItem(count+=1, temp);

  				  // Pickaxe
  				  temp = new ItemStack(Material.DIAMOND_PICKAXE);
  				  temp.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
  				  temp.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
  				  temp.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
  				  i.setItem(count+=1, temp);

  				  // Shovel
  				  temp = new ItemStack(Material.DIAMOND_SPADE);
  				  temp.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
  				  temp.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
  				  temp.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 10);
  				  i.setItem(count+=1, temp);

  				  // Axe
  				  temp = new ItemStack(Material.DIAMOND_AXE);
  				  temp.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
  				  temp.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
  				  temp.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 10);
  				  i.setItem(count+=1, temp);

  				  // Helm
  				  temp = new ItemStack(Material.DIAMOND_HELMET);
  				  temp_meta=temp.getItemMeta();
  				  temp_meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Adamantium Helmet");
  				  temp_meta_lore = new ArrayList<String>();
  				  temp_meta_lore.add(ChatColor.YELLOW+"+60% "+ChatColor.BLUE+"Damage Reduction");
  				  temp_meta_lore.add(ChatColor.AQUA+"Food replenish");
  				  temp_meta.setLore(temp_meta_lore);
  				  temp.setItemMeta(temp_meta);
  				  temp.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
  				  temp.addUnsafeEnchantment(Enchantment.OXYGEN, 4);
  				  temp.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1);
  				  i.setItem(count+=1, temp);

  				  // Chestplate
  				  temp = new ItemStack(Material.DIAMOND_CHESTPLATE);
  				  temp_meta=temp.getItemMeta();
  				  temp_meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Adamantium Breastplate");
  				  temp_meta_lore = new ArrayList<String>();
  				  temp_meta_lore.add(ChatColor.YELLOW+"+40 "+ChatColor.BLUE+"Health");
  				  temp_meta_lore.add(ChatColor.AQUA+"Fire resistance");
  				  temp_meta.setLore(temp_meta_lore);
  				  temp.setItemMeta(temp_meta);
  				  temp.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
  				  i.setItem(count+=1, temp);

  				  // Leggings
  				  temp = new ItemStack(Material.DIAMOND_LEGGINGS);
  				  temp_meta=temp.getItemMeta();
  				  temp_meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Adamantium Leggings");
  				  temp_meta_lore = new ArrayList<String>();
  				  temp_meta_lore.add(ChatColor.YELLOW+"+50% "+ChatColor.BLUE+"Block Chance");
  				  temp_meta_lore.add(ChatColor.AQUA+"Hyper sprint");
  				  temp_meta.setLore(temp_meta_lore);
  				  temp.setItemMeta(temp_meta);
  				  temp.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5);
  				  i.setItem(count+=1, temp);

  				  // Boots
  				  temp = new ItemStack(Material.DIAMOND_BOOTS);
  				  temp_meta=temp.getItemMeta();
  				  temp_meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Adamantium Boots");
  				  temp_meta_lore = new ArrayList<String>();
  				  temp_meta_lore.add(ChatColor.YELLOW+"+100% "+ChatColor.BLUE+"Speed Boost Chance");
  				  temp_meta_lore.add(ChatColor.AQUA+"Hyper jump");
  				  temp_meta.setLore(temp_meta_lore);
  				  temp.setItemMeta(temp_meta);
  				  temp.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 5);
  				  i.setItem(count+=1, temp);

  				  // Sword
  				  temp = new ItemStack(Material.DIAMOND_SWORD);
  				  temp_meta=temp.getItemMeta();
  				  temp_meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Adamantium Saber");
  				  temp_meta_lore = new ArrayList<String>();
  				  temp_meta_lore.add(ChatColor.YELLOW+"+20% "+ChatColor.BLUE+"Life Steal");
  				  temp_meta_lore.add(ChatColor.YELLOW+"+50% "+ChatColor.BLUE+"Attack Speed");
  				  temp_meta_lore.add(ChatColor.YELLOW+"+6 "+ChatColor.BLUE+"Armor Penetration");
  				  temp_meta_lore.add(ChatColor.YELLOW+"+10 "+ChatColor.BLUE+"Damage");
  				  temp_meta.setLore(temp_meta_lore);
  				  temp.setItemMeta(temp_meta);
  				  temp.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 4);
  				  temp.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
  				  temp.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 5);
  				  temp.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 5);
  				  i.setItem(count+=1, temp);

  				  // Bow
  				  temp = new ItemStack(Material.BOW);
  				  temp_meta=temp.getItemMeta();
  				  temp_meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Adamantium Longbow");
  				  temp_meta_lore = new ArrayList<String>();
  				  temp_meta_lore.add(ChatColor.YELLOW+"+20% "+ChatColor.BLUE+"Life Steal");
  				  temp_meta_lore.add(ChatColor.YELLOW+"+100% "+ChatColor.BLUE+"Attack Speed");
  				  temp_meta_lore.add(ChatColor.YELLOW+"+8 "+ChatColor.BLUE+"Armor Penetration");
  				  temp_meta_lore.add(ChatColor.YELLOW+"+15 "+ChatColor.BLUE+"Damage");
  				  temp_meta.setLore(temp_meta_lore);
  				  temp.setItemMeta(temp_meta);
  				  temp.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 6);
  				  temp.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 4);
  				  temp.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
  				  temp.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
  				  i.setItem(count+=1, temp);
  				  
  				  // Pocket Crafting Table
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
  				  i.setItem(count+=1, table);
  				  
  				  // Witherless Rose
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
  				  rose.setAmount(64);
  				  i.setItem(count+=1, rose);

  				  // Arrows
  				  i.setItem(count+=1, new ItemStack(Material.ARROW, 64));
  				  
  				  //Food
  				  i.setItem(count+=1, new ItemStack(Material.COOKED_CHICKEN,64));
  				  
				  temp = new ItemStack(Material.SIGN,64);
				  ItemMeta meta = temp.getItemMeta();
				  meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Job Boost Card");
				  List<String> lore = new ArrayList<String>();
				  lore.add("Use /jobs boost <jobname> to instantly level up");
				  lore.add("that job with this card!");
				  meta.setLore(lore);
				  temp.setItemMeta(meta);
				  i.setItem(count+=1, temp);
  				  
  				  p.openInventory(i);
  			  }
            }
  			  if (args[0].equalsIgnoreCase("newmobs")) {
  				  p.sendMessage("/event newmobs <type>. <type> can be COUNTER_SLIME, VIRAL_SPIDER, SILENCER, HOUND_CALLER, FISH_CALLER, SUICIDAL_CREEPER, POWER_SURGE_ZOMBIE, LIGHTNING_MAGE");
  			  }
  			  if (args[0].equalsIgnoreCase("diablodrops")) {
  				  //Generates a random diablodrops item. Just like if you did /diablodrops
  				  p.getWorld().dropItemNaturally(p.getLocation(), DiabloDropsHook.getRandomItem());
  			  }
  			  if (args[0].equalsIgnoreCase("diablodrops_mat")) {
  				  //Generates diamond swords that have random diablodrops attributes.
  				  p.getWorld().dropItemNaturally(p.getLocation(), DiabloDropsHook.getRandomItem(Material.DIAMOND_SWORD));
  			  }
  			  if (args[0].equalsIgnoreCase("diablodrops_tier")) {
  				  //Only drops legendary tier diablodrops items. (Orange lettering, high stats.)
  				  p.getWorld().dropItemNaturally(p.getLocation(), DiabloDropsHook.getTierItem(Tier.Legendary));
  			  }
  			  if (args[0].equalsIgnoreCase("diablodrops_mat+tier")) {
  				  //Only drops diamond chestplates that are unidentified.
  				  p.getWorld().dropItemNaturally(p.getLocation(), DiabloDropsHook.getTierItem(Material.DIAMOND_CHESTPLATE, Tier.Unidentified));
  			  }
  			  if (args[0].equalsIgnoreCase("diablodrops_item")) {
  				  //Only drops Iron Axes. Basically the same as the material version, but accepts an ItemStack (Which may have additional properties, or may be unidentified!)
  				  p.getWorld().dropItemNaturally(p.getLocation(), DiabloDropsHook.getItem(new ItemStack(Material.IRON_AXE)));
  			  }
  			  if (args[0].equalsIgnoreCase("diablodrops_chestloot")) {
  				  if (p.getTargetBlock(null, 5).getType()==Material.CHEST) {
  					  //Fills a chest you look at with 20 random diablodrops items.
  					  DiabloDropsHook.fillChest(p.getTargetBlock(null, 5), 20);
  				  }
  			  }
  			  if (args[0].equalsIgnoreCase("loot")) {
  				p.getWorld().dropItemNaturally(p.getLocation(), this.plugin.generate_LootChest());  			  
  			  }
  			  if (args[0].equalsIgnoreCase("loot")) {
					ItemStack chest = new ItemStack(Material.CHEST);
				    ItemMeta chest_name = chest.getItemMeta();
				    chest_name.setDisplayName(ChatColor.YELLOW+"Closed Chest");
				   
				    List<String> chestlore = new ArrayList<String>();
				    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"A mysterious chest!");
				    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"");
				    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"It feels heavy; there");
				    chestlore.add(ChatColor.GRAY+""+ChatColor.ITALIC+"might be items inside.");
				    chest_name.setLore(chestlore);

				    chest.setItemMeta(chest_name);
				    
				    p.getWorld().dropItemNaturally(p.getLocation(), chest);
  			  }
            } else
            if (cmd.getName().toLowerCase().equalsIgnoreCase("event") && args.length==2 && p.hasPermission("maintenance-mode-admin")) {
  			  if (args[0].equalsIgnoreCase("job_max")) {
  				  this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job1", String.valueOf(args[1]));
  				  this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job1lv", Integer.valueOf(40));
  				  this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".jobs.ultimate", String.valueOf(args[1]));
  				  this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".jobs.ultimatesealed", Boolean.valueOf(true));
  				  p.sendMessage("Set job slot 1 to "+args[1]+" @ Lv40, set ultimate and sealed it as well.");
  			  }
  			  if (args[0].equalsIgnoreCase("job_30")) {
  				  this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".jobs.job1_30", Integer.valueOf(args[1]));
  				  p.sendMessage("Set job slot 1 LV30 buff to Type "+args[1]);
  			  }
			  if (args[0].equalsIgnoreCase("loot")) {
	  				p.getWorld().dropItemNaturally(p.getLocation(), this.plugin.generate_LootChest(Integer.valueOf(args[1])));  			  
  			  }
  			  if (args[0].equalsIgnoreCase("head")) {
  				  ItemStack m = new ItemStack(Material.SKULL_ITEM, 64, (short)SkullType.PLAYER.ordinal());
      				SkullMeta skullMeta = (SkullMeta) m.getItemMeta();
      		        skullMeta.setOwner(args[1]);
      		        skullMeta.setDisplayName(ChatColor.RESET + args[1]+"'s Head");
      		        m.setItemMeta(skullMeta);
      		        p.getInventory().addItem(m);
  			  }
			  if (args[0].equalsIgnoreCase("halloween_reward")) {
				  Bukkit.broadcastMessage(args[1]+" has won the Pumpkin Patch contest due to popular vote! "+ChatColor.BOLD+"Congratulations!");
				  Player f = Bukkit.getPlayer(args[1]);
				  f.sendMessage("You have received $800 in holding money, and 5 Job Boost cards!");
				  this.plugin.economy.depositPlayer(args[1], 800);
				  ItemStack i = new ItemStack(Material.getMaterial(34),5);
				  ItemMeta meta = i.getItemMeta();
				  meta.setDisplayName(ChatColor.LIGHT_PURPLE+"Job Boost Card");
				  List<String> lore = new ArrayList<String>();
				  lore.add("Use /jobs boost <jobname> to instantly level up");
				  lore.add("that job with this card!");
				  meta.setLore(lore);
				  i.setItemMeta(meta);
				  f.getInventory().addItem(i);
			  }
  			  if (args[0].equalsIgnoreCase("halloween") && args[1].equalsIgnoreCase("end")) {
  				  p.sendMessage(ChatColor.GRAY+"Ending Harrowing night... Did you make sure it was night time? If not, type this command again after /time night instead.");
  				  this.plugin.harrowing_night=true;
				  this.plugin.getConfig().set("halloween-enabled", Boolean.valueOf(false));
				  p.sendMessage("Halloween event disabled.");
				  Bukkit.broadcastMessage(ChatColor.GRAY+"Ending 'The Harrowing' Event...");
				  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				      @Override
				      public void run() {
				    	  Bukkit.broadcastMessage(" Thanks for playing and sticking with us through this event!");
				      }
				  	},20);
				  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				      @Override
				      public void run() {
				    	  Bukkit.broadcastMessage(ChatColor.GOLD+" Please make 3 slots of room in your inventory now if you do not have room. We are giving prizes....");
				      }
				  	},100);
				  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				      @Override
				      public void run() {
				    	  Bukkit.broadcastMessage(ChatColor.GREEN+" You each have received an extra Harrowing item, a bonus extra item, and a special Polymorph Wand for participating in this event! I have also given you appropriate buffs.");
				    	  for (int i=0;i<Bukkit.getOnlinePlayers().length;i++) {
				    		  Player p = Bukkit.getOnlinePlayers()[i];
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
				    			  for (int j=0;j<p.getInventory().getContents().length;j++) {
				    				  if (p.getInventory().getContents()[j]==null) {
				    					  full=false;
				    					  break;
				    				  }
				    			  }
				    			  if (!full) {
				    				  p.getInventory().addItem(finalitem);
				    			  } else {
				    				  p.getWorld().dropItemNaturally(p.getLocation(), finalitem); //Drop item on the ground if our inventory is full. That way we don't lose it.
				    			  }
				    			  ItemStack item = null;
				    					  //Add a weapon/armor piece.
				    					  int rand = (int)(Math.random()*5);
				    					  String type1 = "DIAMOND";
				    					  String type2 = "";
				    					  int rarity=2; //0 = Normal, 1 = Rare, 2 = Legendary
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
				    								  type2 = "BOOTS";
				    							  }break;
				    							  case 6: {
				    								  type2 = "LEGGINGS";
				    							  }break;
				    							  case 7: {
				    								  type2 = "CHESTPLATE";
				    							  }break;
				    							  case 8: {
				    								  type2 = "HELMET";
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
				    								  type2 = "SWORD";
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
				    								  if (rarity==2) {
				    									  item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
				    								  } else {
				    									  item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*6)+1);
				    								  }
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
				    						  ItemMeta meta1 = item.getItemMeta();
				    						  meta1.setLore(ourLore);
				    						  item.setItemMeta(meta1);
				    					  } else {
				    						  item = new ItemStack(Material.getMaterial(type1+"_"+type2));
				    						  if (type2.equalsIgnoreCase("SWORD")) {
				    							  int enchants[] = {16,17,18,19,20,21,34};
				    							  for (int j=0;j<enchants.length;j++) {
				    								  if (Math.random()*chance_increase<1.0d/enchants.length) {
				    									  if (rarity==2) {
				    										  item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
				    									  } else {
				    										  item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*6)+1);
				    									  }
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
				    							  ItemMeta meta1 = item.getItemMeta();
				    							  meta1.setLore(ourLore);
				    							  if (rarity==1) {
				    								  meta.setDisplayName(ChatColor.BLUE+"Rare "+convertToItemName(item.getType().name().replace("_", " ")));
				    							  }
				    							  if (rarity==2) {
				    								  meta.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"Legendary "+convertToItemName(item.getType().name().replace("_", " ")));
				    							  }
				    							  item.setItemMeta(meta1);
				    						  } else if (type2.equalsIgnoreCase("SPADE") || type2.equalsIgnoreCase("PICKAXE") || type2.equalsIgnoreCase("HOE") || type2.equalsIgnoreCase("AXE")) {
				    							  int enchants[] = {32,33,34,35};
				    							  for (int j=0;j<enchants.length;j++) {
				    								  if (Math.random()<1.0d/enchants.length) {
				    									  if (Math.random()<1.0d/enchants.length) {
				    										  if (Math.random()*chance_increase<1.0d/enchants.length) {
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
				    							  ItemMeta meta1 = item.getItemMeta();
				    							  meta1.setLore(ourLore);
				    							  if (rarity==1) {
				    								  meta.setDisplayName(ChatColor.BLUE+"Rare "+convertToItemName(item.getType().name().replace("_", " ")));
				    							  }
				    							  if (rarity==2) {
				    								  meta.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"Legendary "+convertToItemName(item.getType().name().replace("_", " ")));
				    							  }
				    							  item.setItemMeta(meta1);
				    						  } else {
				    							  int enchants[] = {0,1,2,3,4,5,6,7,34};
				    							  for (int j=0;j<enchants.length;j++) {
				    								  if (Math.random()<1.0d/enchants.length) {
				    									  if (rarity==2) {
				    										  item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*10)+1);
				    									  } else {
				    										  item.addUnsafeEnchantment(Enchantment.getById(enchants[j]), (int)(Math.random()*6)+1);
				    									  }
				    								  }
				    							  }
				    							  List<String> ourLore = new ArrayList<String>();
				    							  if (rarity==2) { 
				    								  if (Math.random()<=0.2) {
				    									  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*16)+1)+" "+ChatColor.BLUE+"Health");
				    								  } else
				    								  if (Math.random()<=0.2) {
				    									  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*40)+1)+"% "+ChatColor.BLUE+"Damage Reduction");
				    								  } else
				    								  if (Math.random()<=0.2) {
				    									  ourLore.add(ChatColor.YELLOW+"+"+(((int)(Math.random()*200)+1)*10)+"% "+ChatColor.BLUE+"Durability");
				    								  } else
				    								  if (Math.random()<=0.2) {
				    									  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*40)+1)+"% "+ChatColor.BLUE+"Block Chance");
				    								  } else
				    								  {
				    									  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*40)+1)+"% "+ChatColor.BLUE+"Speed Boost Chance");
				    								  }
				    							  } else 
				    							  if (rarity==1) {
				    								  if (Math.random()<=0.2) {
				    									  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*8)+1)+" "+ChatColor.BLUE+"Health");
				    								  } else
				    								  if (Math.random()<=0.2) {
				    									  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*20)+1)+"% "+ChatColor.BLUE+"Damage Reduction");
				    								  } else
				    								  if (Math.random()<=0.2) {
				    									  ourLore.add(ChatColor.YELLOW+"+"+(((int)(Math.random()*100)+1)*10)+"% "+ChatColor.BLUE+"Durability");
				    								  } else
				    								  if (Math.random()<=0.2) {
				    									  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*20)+1)+"% "+ChatColor.BLUE+"Block Chance");
				    								  } else
				    								  {
				    									  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*20)+1)+"% "+ChatColor.BLUE+"Speed Boost Chance");
				    								  }
				    								  if (Math.random()<=0.2) {
				    									  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*8)+1)+" "+ChatColor.BLUE+"Health");
				    								  } else
				    								  if (Math.random()<=0.2) {
				    									  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*20)+1)+"% "+ChatColor.BLUE+"Damage Reduction");
				    								  } else
				    								  if (Math.random()<=0.2) {
				    									  ourLore.add(ChatColor.YELLOW+"+"+(((int)(Math.random()*100)+1)*10)+"% "+ChatColor.BLUE+"Durability");
				    								  } else
				    								  if (Math.random()<=0.2) {
				    									  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*20)+1)+"% "+ChatColor.BLUE+"Block Chance");
				    								  } else
				    								  {
				    									  ourLore.add(ChatColor.YELLOW+"+"+((int)(Math.random()*20)+1)+"% "+ChatColor.BLUE+"Speed Boost Chance");
				    								  }
				    							  } else {
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
				    							  }
				    							  ItemMeta meta1 = item.getItemMeta();
				    							  meta1.setLore(ourLore);
				    							  if (rarity==1) {
				    								  meta.setDisplayName(ChatColor.BLUE+"Rare "+convertToItemName(item.getType().name().replace("_", " ")));
				    							  }
				    							  if (rarity==2) {
				    								  meta.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"Legendary "+convertToItemName(item.getType().name().replace("_", " ")));
				    							  }
				    							  item.setItemMeta(meta1);
				    						  }
				    					  }
				    				  
				    				p.getInventory().addItem(item);
				    				ItemStack wand = new ItemStack(Material.getMaterial(127));
				    				ItemMeta wand_meta = wand.getItemMeta();
				    				wand_meta.setDisplayName(ChatColor.RED+"P"+
				    						ChatColor.GOLD+"o"+ChatColor.YELLOW+"l"+
				    						ChatColor.GREEN+"y"+ChatColor.BLUE+"m"+
				    						ChatColor.LIGHT_PURPLE+"o"+ChatColor.DARK_RED+"r"
				    						+ChatColor.DARK_GREEN+"p"+ChatColor.DARK_PURPLE+"h"+ChatColor.RESET+" Wand");
				    				List<String> newLore = new ArrayList<String>();
				    				newLore.add("A "+ChatColor.YELLOW+"[Halloween]"+ChatColor.DARK_PURPLE+""+ChatColor.ITALIC+" item received as a reward");
				    				newLore.add("for participating in the event. This item can");
				    				newLore.add("turn a creature into another creature.");
				    				newLore.add("Can be used once a minute.");
				    				wand_meta.setLore(newLore);
				    				wand.setItemMeta(wand_meta);
				    				p.getInventory().addItem(wand);
				    				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,1728000,1));
				    				p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,1728000,1));
				    				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,1728000,0));
				    	  }
				      }
				  	},400);
				  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				      @Override
				      public void run() {
				    	  Bukkit.broadcastMessage(ChatColor.GOLD+""+ChatColor.BOLD+"");
				    	  Bukkit.broadcastMessage(ChatColor.GOLD+""+ChatColor.BOLD+"Again, thank you for participating, and everyone have a great night!");
				      }
				  	},600);
				  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				      @Override
				      public void run() {
				    	  Bukkit.broadcastMessage(ChatColor.DARK_GRAY+""+ChatColor.ITALIC+"  And so the Harrowing ends....");
				      }
				  	},700);
				  Bukkit.getWorld("world").setDifficulty(Difficulty.HARD);
				  this.plugin.harrowing_night=true;
  				  this.plugin.saveConfig();
  			  }

  			  if (args[0].equalsIgnoreCase("newmobs") && args.length>1) {
  				//Try to spawn a counter slime.
					if (args[1].equalsIgnoreCase("COUNTER_SLIME")) {
						Entity entity = p.getWorld().spawnEntity(p.getLocation(), EntityType.SLIME);
						Slime s = (Slime)entity;
						//Bukkit.getLogger().info("Counter Slime spawned at "+s.getLocation().toString());
						s.setSize((int)(Math.random()*3)+2);
						LivingEntity l = (LivingEntity)entity;
						l.setCustomName(ChatColor.RED+"Counter Slime");
						l.setCustomNameVisible(false);
					}
					//Try to spawn a Viral Spider.
					if (args[1].equalsIgnoreCase("VIRAL_SPIDER")) {
						Entity entity = p.getWorld().spawnEntity(p.getLocation(), EntityType.SPIDER);
						LivingEntity l = (LivingEntity)entity;
						l.setCustomName(ChatColor.RED+"Viral Spider");
						l.setCustomNameVisible(false);
						//Bukkit.getLogger().info("Viral Spider spawned at "+l.getLocation().toString());
						l.setMaxHealth(85);
						l.setHealth(85);
						l.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 3));
					}
					//Try to spawn a Silencer.
					if (args[1].equalsIgnoreCase("SILENCER")) {
						Entity entity = p.getWorld().spawnEntity(p.getLocation(), EntityType.SKELETON);
						LivingEntity l = (LivingEntity)entity;
						l.setCustomName(ChatColor.RED+"Silencer");
						l.setCustomNameVisible(false);
						//Bukkit.getLogger().info("Silencer spawned at "+l.getLocation().toString());
						l.setMaxHealth(45);
						l.setHealth(45);
						ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
						helm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 24);
						l.getEquipment().setHelmet(helm);
						l.getEquipment().setHelmetDropChance(0.002f);
						l.getEquipment().setItemInHand(new ItemStack(Material.BOW));
						l.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 3));
					}
					//Try to spawn a Hound Caller.
					if (args[1].equalsIgnoreCase("HOUND_CALLER")) {
						Entity entity = p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
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
					//Try to spawn a Fish Caller.
					if (args[1].equalsIgnoreCase("FISH_CALLER")) {
						Entity entity = p.getWorld().spawnEntity(p.getLocation(), EntityType.ENDERMAN);
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
						l.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 4));
						l.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 1));
						l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999, 1));
					}
					//Try to spawn a Suicidal Creeper.
					if (args[1].equalsIgnoreCase("SUICIDAL_CREEPER")) {
						Location ent = p.getLocation();
						Entity entity = p.getWorld().spawnEntity(p.getLocation(), EntityType.CREEPER);
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
					//Try to spawn a Powersurge Zombie.
					if (args[1].equalsIgnoreCase("POWER_SURGE_ZOMBIE")) {
						Location ent = p.getLocation();
						Entity entity = p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE);
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
					//Try to spawn a Lightning Mage.
					if (args[1].equalsIgnoreCase("LIGHTNING_MAGE")) {
						Location ent = p.getLocation();
						Entity entity = p.getWorld().spawnEntity(p.getLocation(), EntityType.ENDERMAN);
						LivingEntity l = (LivingEntity)entity;
						l.setCustomName(ChatColor.RED+"Lightning Mage");
						l.setCustomNameVisible(false);
						//Bukkit.getLogger().info("Suicidal Creeper spawned at "+l.getLocation().toString());
						l.setMaxHealth(105);
						l.setHealth(105);
						l.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 4));
						l.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999, 1));
					}
  			  }
			  if (args[0].equalsIgnoreCase("spawn_dungeon") && args[1].equalsIgnoreCase("boss")) {
				//Empty the whole area.
	  				double xoffset = Math.random()*10+15;
	  				double zoffset = Math.random()*10+15;
	  				if (Math.random()<=0.5) {
	  					xoffset*=-1;
	  				}
	  				if (Math.random()<=0.5) {
	  					zoffset*=-1;
	  				}
	  				for (int j=-15;j<16;j++) {
	  					for (int y=0;y<10;y++) {
		    					for (int k=-15;k<16;k++) {
		    						Bukkit.getWorld("world").getBlockAt(p.getLocation().add(xoffset+j,y,zoffset+k)).setType(Material.AIR);	
		    					}
	  					}
	  				}
						Bukkit.getLogger().info("Spawned a new boss area.");
						File file = new File("plugins/WorldEdit/schematics/boss.schematic");
					    if (file.exists()) {
					        try {
					            com.sk89q.worldedit.Vector v = new com.sk89q.worldedit.Vector(p.getLocation().getX()+xoffset-8, p.getLocation().getY(), p.getLocation().getZ()+zoffset-8);
					            World worldf = Bukkit.getWorld("world");
					            BukkitWorld BWf = new BukkitWorld(worldf);
					            EditSession es = new EditSession(BWf, 2000000);
					            CuboidClipboard c1 = SchematicFormat.MCEDIT.load(file);
					            c1.place(es, v, true);
					            Bukkit.getWorld("world").getBlockAt(new Location(p.getWorld(),p.getLocation().getX()+xoffset, p.getLocation().getY()+2, p.getLocation().getZ()+zoffset)).setType(Material.COMMAND);
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
					    this.plugin.last_boss_dungeon_time=this.plugin.SERVER_TICK_TIME+12000;
				  }
			  if (args[0].equalsIgnoreCase("fatal_survivor") && args[1].equalsIgnoreCase("reset")) {
				  boolean survivor=false;
				  this.plugin.explorers.clear();
			  }
  			  if (args[0].equalsIgnoreCase("halloween") && args[1].equalsIgnoreCase("giant_pumpkin")) {
  				  if (this.plugin.getConfig().getBoolean("halloween-enabled")) {
  					  ItemStack item = new ItemStack(Material.PUMPKIN);
  					  ItemMeta meta = item.getItemMeta();
  					  meta.setDisplayName(ChatColor.GREEN+"Giant Pumpkin");
  					  List<String> lore = new ArrayList<String>();
  					  lore.add("Place the Giant Pumpkin on an Orange");
  					  lore.add("Block to start carving your pumpkin!");
  					  meta.setLore(lore);
  					  item.setItemMeta(meta);
  					  p.getInventory().addItem(item);
  				  }
  				  this.plugin.saveConfig();
  			  }
  			  if (args[0].equalsIgnoreCase("halloween") && args[1].equalsIgnoreCase("pie_label")) {
  				  if (this.plugin.getConfig().getBoolean("halloween-enabled")) {
  					  for (int i=1;i<11;i++) {
	  					  ItemStack item = new ItemStack(Material.PUMPKIN_PIE);
	  					  ItemMeta meta = item.getItemMeta();
	  					  meta.setDisplayName("Pie "+i);
	  					  item.setItemMeta(meta);
	  					  p.getInventory().addItem(item);
  					  }
  				  }
  				  this.plugin.saveConfig();
  			  }
  			  if (args[0].equalsIgnoreCase("halloween") && args[1].equalsIgnoreCase("legendary_item")) {
  				  if (this.plugin.getConfig().getBoolean("halloween-enabled")) {
					  giveLegendaryItem(p);
  				  }
  				  this.plugin.saveConfig();
  			  }
  			  if (args[0].equalsIgnoreCase("halloween") && args[1].equalsIgnoreCase("break")) {
  				  if (this.plugin.getConfig().getBoolean("halloween-enabled")) {
					  if (p.getItemInHand()!=null) {
						  p.getItemInHand().setDurability((short)9000);
					  }
  				  }
  				  this.plugin.saveConfig();
  			  }
            } else
            if (cmd.getName().toLowerCase().equalsIgnoreCase("dungeon") && p.hasPermission("maintenance-mode-admin") && args.length==1) {
          	  //Dungeon x = new Dungeon(new Location(Bukkit.getWorld("world"),-8990,0,-4),new Location(Bukkit.getWorld("world"),50,255,50),Integer.valueOf(args[0]));
            } else
        	if (cmd.getName().toLowerCase().equalsIgnoreCase("transfer") && args.length==1) {
  			  p.sendMessage("Usage: "+ChatColor.RED+"/transfer name money"+ChatColor.WHITE+" - Transfer money to a player.");
        	}
        	else
        	if (cmd.getName().toLowerCase().equalsIgnoreCase("transfer") && args.length==2) {
                double amount = Double.parseDouble(args[1].replaceAll("[^0-9\\.]", ""));
                Player target = p.getServer().getPlayer(args[0]);
                if (target == null) {
                  p.sendMessage(this.prefix + " " + this.offlinePlayer);
                }
                else if (target.getName().toLowerCase() == p.getName().toLowerCase()) {
                  p.sendMessage(this.prefix + " " + this.cmdTransferSameNick);
                }
                else if (amount > playerBankBalance) {
                  p.sendMessage(this.prefix + " " + this.notEnoughMoney);
                } else if (amount <= playerBankBalance) {
                  double totalWithdraw = playerBankBalance - amount;
                  double totalDeposit = amount + this.plugin.getAccountsConfig().getInt(target.getName().toLowerCase() + ".money");

                  this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".money", Double.valueOf(totalWithdraw));
                  this.plugin.getAccountsConfig().set(target.getName() + ".money", Double.valueOf(totalDeposit));
                  this.plugin.saveAccountsConfig();

                  if (amount > 1.0D) {
                    p.sendMessage(this.prefix + " " + this.cmdTransferToPlayer1 + " " + amount + currencyPlural + " " + this.cmdTransferToPlayer2 + " " + target.getName().toLowerCase() + "Åòa.");
                    target.sendMessage(this.prefix + " Åòb" + p.getName().toLowerCase() + " " + this.cmdTransferToTarget1 + " " + amount + currencyPlural + "Åòa.");
                  } else if (amount <= 1.0D) {
                    p.sendMessage(this.prefix + " " + this.cmdTransferToPlayer1 + " " + amount + currencySingular + " " + this.cmdTransferToPlayer2 + " " + target.getName().toLowerCase() + "Åòa.");
                    target.sendMessage(this.prefix + " Åòb" + p.getName().toLowerCase() + " " + this.cmdTransferToTarget1 + " " + amount + currencySingular + "Åòa.");
                  }
                }
                  
        	}
        	else
        	if (cmd.getName().toLowerCase().equalsIgnoreCase("sp") && args.length==1) {
  			  try {
        		int readvalue = Integer.valueOf(args[0]);
                if (readvalue<=10 && readvalue>=1) {
                	int statpoints = (this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p);
                	if (readvalue==10) {
                		if (statpoints>=6) {
                			this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".stats.stat1", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat1")+6));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to Health Regeneration! "+ChatColor.BLUE+"You now have "+this.plugin.getStatBonus(0, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat1")/6)+" of extra health regeneration! (Every time you regenerate health, you get "+this.plugin.getStatBonus(0, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat1"))+" extra hearts!) "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
            				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 6.)");
                		}
                	} else
                	if (readvalue==9) {
                		if (statpoints>=5) {
                			this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".stats.stat2", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat2")+5));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to block destroying speed! "+ChatColor.BLUE+"You now have "+this.plugin.getStatBonus(1, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat2")/5)+"% block destruction speed! "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 5.)");
                		}
                	} else
                	if (readvalue==8) {
                		if (statpoints>=4) {
                			this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".stats.stat3", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat3")+4));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to block damage reduction! "+ChatColor.BLUE+"You now have "+this.plugin.getStatBonus(2, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat3")/4)+"% of damage taken reduced! "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 4.)");
                		}
                	} else
                	if (readvalue==6) {
                		if (statpoints>=3) {
                			this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".stats.stat4", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat4")+3));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to temporary health! "+ChatColor.BLUE+"You now have "+this.plugin.getStatBonus(3, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat4")/4)+" extra temporary health. (Regenerates every 3 minutes.) "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 3.)");
              			}
                	} else
                	if (readvalue==7) {
                		if (statpoints>=4) {
                			this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".stats.stat5", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat5")+4));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to armor penetration! "+ChatColor.BLUE+"You now have "+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat5")/4)+" damage of armor penetration. Armor-Wearers will be more afraid of you! "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 4.)");
                		}
                	} else
                	if (readvalue==5) {
                		if (statpoints>=3) {
                			this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".stats.stat6", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat6")+3));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to fire resistance! "+ChatColor.BLUE+"You now have "+this.plugin.getStatBonus(5, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat6")/3)+" seconds of fire resistance when you catch on fire. (Resets when you stop burning) "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 3.)");
                		}
                	} else
                	if (readvalue==4) {
                		if (statpoints>=2) {
                			this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".stats.stat7", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat7")+2));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to base damage! "+ChatColor.BLUE+"You now have +"+this.plugin.getStatBonus(6, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat7")/2)+" base damage. "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 2.)");
                		}
                	} else
                	if (readvalue==3) {
                		if (statpoints>=2) {
                			this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".stats.stat8", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat8")+2));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to base health! "+ChatColor.BLUE+"You now have +"+this.plugin.getStatBonus(7, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat8")/2)+" base health. "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 2.)");
                		}
                	} else
                	if (readvalue==2) {
                		if (statpoints>=1) {
                			this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".stats.stat9", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat9")+1));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to hunger decay! "+ChatColor.BLUE+"You now have "+this.plugin.getStatBonus(8, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat9"))+"% less hunger decay "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 1.)");
                		}
                	} else
                	if (readvalue==1) {
                		if (statpoints>=1) {
                			this.plugin.getAccountsConfig().set(p.getName().toLowerCase()+".stats.stat10", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat10")+1));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to water breathing! "+ChatColor.BLUE+"You now have "+this.plugin.getStatBonus(9, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat10"))+" seconds of water breathing. "+ChatColor.WHITE+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                			//Increase maximum air by 200 ticks.
                    		p.setMaximumAir(300+this.plugin.getStatBonus(9, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase() + ".stats.stat10"))*20);
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 1.)");
                		}
                	}
                } else {
  				  p.sendMessage(ChatColor.RED+"Please choose an appropriate stat point slot (1-10).");
                }
			  } catch (NumberFormatException ex_e) {
				  p.sendMessage(ChatColor.RED+"The inputted slot is not a valid number.");
			  }
            }
        else if (cmd.getName().toLowerCase().equalsIgnoreCase("bankeconomy") && (args[0].equalsIgnoreCase("info")) && (p.hasPermission("bankeconomy.info"))) {
          if (args.length == 1) {
        	  p.sendMessage(ChatColor.GRAY + "===========[ " + ChatColor.LIGHT_PURPLE + "Current Balance" + ChatColor.GRAY + " ]===========");
        	  DecimalFormat df = new DecimalFormat("#0.00");
        	  p.sendMessage(ChatColor.DARK_GREEN + "Balance: $" + ChatColor.BOLD + ChatColor.AQUA + df.format(playerBankBalance));
          }
          else
            p.sendMessage(this.invARG);
        }
        else if (cmd.getName().toLowerCase().equalsIgnoreCase("bankeconomy") && (args[0].equalsIgnoreCase("check")) && (p.hasPermission("bankeconomy.check"))) {
          if (args.length == 1) {
            p.sendMessage(this.prefix + " " + this.usage + " " + this.cmdCheckARG1);
          } else if (args.length == 2) {
            Player target = p.getServer().getPlayer(args[1]);

            if (target == null) {
              p.sendMessage(this.prefix + " " + this.offlinePlayer);
            } else {
              int targetBalance = this.plugin.getAccountsConfig().getInt(target.getName().toLowerCase() + ".money");

              if (targetBalance <= 1)
                p.sendMessage(this.prefix + "Åòa " + target.getName().toLowerCase() + this.cmdCheckReponsePlayer + " " + targetBalance + currencySingular);
              else if (targetBalance > 1)
                p.sendMessage(this.prefix + "Åòa " + target.getName().toLowerCase() + this.cmdCheckReponsePlayer + " " + targetBalance + currencyPlural);
            }
          }
          else {
            p.sendMessage(this.invARG);
          }
        } else if (cmd.getName().toLowerCase().equalsIgnoreCase("bankeconomy") && (args[0].equalsIgnoreCase("reset")) && (p.hasPermission("bankeconomy.reset"))) {
          if (args.length == 1) {
            p.sendMessage(this.prefix + " " + this.usage + " " + this.cmdResetARG1);
          } else if (args.length == 2) {
            Player target = p.getServer().getPlayer(args[1]);

            if (target == null) {
              p.sendMessage(this.prefix + " " + this.offlinePlayer);
            } else {
              this.plugin.getAccountsConfig().set(target.getName().toLowerCase() + ".money", Integer.valueOf(0));
              //this.plugin.saveAccountsConfig();

              p.sendMessage(this.prefix + " " + this.cmdResetToPlayer1 + " " + target.getName().toLowerCase() + this.cmdResetToPlayer2);
              target.sendMessage(this.prefix + " Åòa" + p.getName().toLowerCase() + " " + this.cmdResetToTarget);
            }
          } else {
            p.sendMessage(this.invARG);
          }
        } else if ((args[0].equalsIgnoreCase("reload")) && (p.hasPermission("bankeconomy.reload"))) {
          if (args.length == 1) {
            p.sendMessage(this.prefix + " " + this.cmdReload);

            FileConfiguration conf = this.plugin.getConfig();
            this.plugin.reloadConfig();
            return conf == this.plugin.getConfig();
          }
          p.sendMessage(this.invARG);
        }
        else if (cmd.getName().toLowerCase().equalsIgnoreCase("bankeconomy") && (args[0].equalsIgnoreCase("transfer")) && (p.hasPermission("bankeconomy.transfer"))) {
          if (args.length == 1) {
            p.sendMessage(this.prefix + " " + this.usage + " " + this.cmdTransferARG1);
          } else if (args.length == 2) {
            p.sendMessage(this.prefix + " " + this.cmdTransferARG2);
          } else if (args.length == 3) {
            double amount = Double.parseDouble(args[1].replaceAll("[^0-9\\.]", ""));
            Player target = p.getServer().getPlayer(args[2]);

            if (target == null) {
              p.sendMessage(this.prefix + " " + this.offlinePlayer);
            }
            else if (target.getName().toLowerCase() == p.getName().toLowerCase()) {
              p.sendMessage(this.prefix + " " + this.cmdTransferSameNick);
            }
            else if (amount > playerBankBalance) {
              p.sendMessage(this.prefix + " " + this.notEnoughMoney);
            } else if (amount <= playerBankBalance) {
              double totalWithdraw = playerBankBalance - amount;
              double totalDeposit = amount + this.plugin.getAccountsConfig().getInt(target.getName().toLowerCase() + ".money");

              this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".money", Double.valueOf(totalWithdraw));
              this.plugin.getAccountsConfig().set(target.getName() + ".money", Double.valueOf(totalDeposit));
              this.plugin.saveAccountsConfig();

              if (amount > 1.0D) {
                p.sendMessage(this.prefix + " " + this.cmdTransferToPlayer1 + " " + amount + currencyPlural + " " + this.cmdTransferToPlayer2 + " " + target.getName().toLowerCase() + "Åòa.");
                target.sendMessage(this.prefix + " Åòb" + p.getName().toLowerCase() + " " + this.cmdTransferToTarget1 + " " + amount + currencyPlural + "Åòa.");
              } else if (amount <= 1.0D) {
                p.sendMessage(this.prefix + " " + this.cmdTransferToPlayer1 + " " + amount + currencySingular + " " + this.cmdTransferToPlayer2 + " " + target.getName().toLowerCase() + "Åòa.");
                target.sendMessage(this.prefix + " Åòb" + p.getName().toLowerCase() + " " + this.cmdTransferToTarget1 + " " + amount + currencySingular + "Åòa.");
              }
            }
          }
          else
          {
            p.sendMessage(this.invARG);
          }
        } else if (cmd.getName().toLowerCase().equalsIgnoreCase("bankeconomy") && (args[0].equalsIgnoreCase("edit")) && (p.hasPermission("bankeconomy.edit"))) {
          if (args.length == 1) {
            p.sendMessage(this.prefix + " " + this.usage + " " + this.cmdEditARG1);
            p.sendMessage(this.prefix + " " + this.cmdEditAvaibleActions);
          } else if (args.length == 2) {
            p.sendMessage(this.prefix + " " + this.cmdTransferARG2);
          } else if (args.length == 3) {
            p.sendMessage(this.prefix + " " + this.cmdEditARG2);
          } else if (args.length == 4) {
            double amount = Double.parseDouble(args[3].replaceAll("[^0-9\\.]", ""));
            Player target = p.getServer().getPlayer(args[2]);

            if (target == null) {
              p.sendMessage(this.prefix + " " + this.offlinePlayer);
            }
            else if (args[1].equalsIgnoreCase("status")) {
              if (amount == 1.0D) {
                this.plugin.getAccountsConfig().set(target.getName().toLowerCase() + ".status", Boolean.valueOf(true));
                //this.plugin.saveAccountsConfig();

                p.sendMessage(this.prefix + " " + this.cmdEditEnableToPlayer1 + " " + p.getName().toLowerCase() + this.cmdEditEnableToPlayer2);
              } else if (amount == 0.0D) {
                this.plugin.getAccountsConfig().set(target.getName().toLowerCase() + ".status", Boolean.valueOf(false));
                //this.plugin.saveAccountsConfig();

                p.sendMessage(this.prefix + " " + this.cmdEditDisabledToPlayer1 + " " + p.getName().toLowerCase() + this.cmdEditDisabledToPlayer2);
              }
            } else if (args[1].equalsIgnoreCase("balance")) {
              this.plugin.getAccountsConfig().set(target.getName().toLowerCase() + ".money", Double.valueOf(amount));
              //this.plugin.saveAccountsConfig();

              if (amount > 1.0D)
                p.sendMessage(this.prefix + " " + this.cmdEditAmountSetPlayer1 + " Åòb" + amount + currencyPlural + " " + this.cmdEditAmountSetPlayer2 + " " + target.getName().toLowerCase() + this.cmdEditAmountSetPlayer3);
              else if (amount <= 1.0D)
                p.sendMessage(this.prefix + " " + this.cmdEditAmountSetPlayer1 + " Åòb" + amount + currencySingular + " " + this.cmdEditAmountSetPlayer2 + " " + target.getName().toLowerCase() + this.cmdEditAmountSetPlayer3);
            }
            else {
              p.sendMessage(this.prefix + " " + this.cmdEditAvaibleActions);
            }
          }
          else {
            p.sendMessage(this.invARG);
          }
        } 
      else if (cmd.getName().toLowerCase().equalsIgnoreCase("revive") &&  args[0].equalsIgnoreCase("me")) {
          DecimalFormat df = new DecimalFormat("#0.00");
          double deathX = this.plugin.getAccountsConfig().getDouble(p.getName().toLowerCase() + ".deathpointX");
          double deathY = this.plugin.getAccountsConfig().getDouble(p.getName().toLowerCase() + ".deathpointY");
          double deathZ = this.plugin.getAccountsConfig().getDouble(p.getName().toLowerCase() + ".deathpointZ");
          String deathWorld = this.plugin.getAccountsConfig().getString(p.getName().toLowerCase() + ".deathworld");
    	  //p.sendMessage("Got 1.");
          if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase() + ".revived")==false && this.plugin.SERVER_TICK_TIME-this.plugin.getAccountsConfig().getLong(p.getName().toLowerCase() + ".revivetime")<12000) {
        	  double mincost = this.plugin.getConfig().getDouble("revive-cost-rate");
        	  //p.sendMessage("Got 2.");
        	  if (p.getBedSpawnLocation()!=null) {
        		  mincost *= Math.abs(p.getBedSpawnLocation().getX()-deathX)+Math.abs(p.getBedSpawnLocation().getY()-deathY)+Math.abs(p.getBedSpawnLocation().getZ()-deathZ);
        	  } else {
        		  mincost *= Math.abs(p.getWorld().getSpawnLocation().getX()-deathX)+Math.abs(p.getWorld().getSpawnLocation().getY()-deathY)+Math.abs(p.getWorld().getSpawnLocation().getZ()-deathZ);
        	  }
	          double mymoney = this.plugin.getAccountsConfig().getDouble(p.getName().toLowerCase() + ".money");
	          double finalcost = (mincost*this.plugin.getConfig().getDouble("revive-cost-rate")) + (mymoney*this.plugin.getConfig().getDouble("revive-cost-tax"));
	          if (this.plugin.PlayerinJob(p, "Explorer") && this.plugin.getJobLv("Explorer", p)>=20) {
	        	  finalcost*=0.25;
	          }
	    	  //p.sendMessage("Got 3.");
	          if (mymoney>=finalcost) {
	        	  this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".revived", Boolean.valueOf(true));
	        	  this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".money", mymoney-finalcost);
	        	  this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".revivetime", Long.valueOf(0));
	        	  this.plugin.saveAccountsConfig();
	        	  //p.sendMessage("Got 4.");
	        	  p.sendMessage("You spent $"+df.format(finalcost)+" to revive. New Bank Balance: $"+ChatColor.YELLOW+df.format(mymoney-finalcost));
	        	  //p.sendMessage("Got 5.");
	        	  org.bukkit.Location teleportloc = p.getLocation();
	        	  if (p.getBedSpawnLocation()!=null) {
	        		  teleportloc = p.getBedSpawnLocation();
	        	  } else {
	        		  //Use world spawn point.
	        		  teleportloc = p.getWorld().getSpawnLocation();
	        	  }
	        	  teleportloc.setX(deathX);
	        	  teleportloc.setY(deathY+1);
	        	  teleportloc.setZ(deathZ);
	        	  teleportloc.setWorld(Bukkit.getWorld(deathWorld));
	        	  //p.sendMessage("Got 6.");
	        	  p.teleport(teleportloc);
	        	  List<Entity> nearby = p.getNearbyEntities(30, 30, 30);
	        	  for (int i=0;i<nearby.size();i++) {
	        		  if (nearby.get(i) instanceof Monster) {
	        			  LivingEntity l = (LivingEntity)nearby.get(i);
	        			  if (l.getCustomName()!=null && (l.getCustomName().contains(ChatColor.GOLD+""+ChatColor.BOLD+"") || l.getCustomName().contains(ChatColor.DARK_PURPLE+"") || l.getCustomName().contains(ChatColor.DARK_AQUA+""))) {
	        				  
	        			  } else {
	        				  nearby.get(i).remove();
	        			  }
	        			  //Delete it from existence.
	        		  }
	        	  }
	        	  //p.sendMessage("Got 7.");
	        	  final Player p2 = p;
		      		p.setMaximumNoDamageTicks(100);
		    		p.setNoDamageTicks(100);
		    		Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
		    			@Override
		    			public void run() { //After 5 seconds, set the no Damage Ticks back to normal.
		    				p2.setMaximumNoDamageTicks(20);
		    			}
		    		},100);
	        	  Bukkit.broadcastMessage(ChatColor.GREEN+p.getName().toLowerCase()+ChatColor.WHITE+" decided to revive.");
	          } else {
	        	  p.sendMessage("You cannot revive. You need to have $"+df.format(finalcost)+" to do so.");
	          }
          } else {
        	  p.sendMessage("You haven't died. So you cannot revive.");
          }
          //this.plugin.saveAccountsConfig();
          return true;
      } 
      else if (cmd.getName().toLowerCase().equalsIgnoreCase("revive") && (args[0].equalsIgnoreCase("amount"))) {
          DecimalFormat df = new DecimalFormat("#0.00");
          double deathX = p.getLocation().getX();
          double deathY = p.getLocation().getY();
          double deathZ = p.getLocation().getZ();
    	  double mincost = this.plugin.getConfig().getDouble("revive-cost-rate");
    	  if (p.getBedSpawnLocation()!=null) {
    		  mincost *= Math.abs(p.getBedSpawnLocation().getX()-deathX)+Math.abs(p.getBedSpawnLocation().getY()-deathY)+Math.abs(p.getBedSpawnLocation().getZ()-deathZ);
    	  } else {
    		  mincost *= Math.abs(p.getWorld().getSpawnLocation().getX()-deathX)+Math.abs(p.getWorld().getSpawnLocation().getY()-deathY)+Math.abs(p.getWorld().getSpawnLocation().getZ()-deathZ);
    	  }
          double mymoney = this.plugin.getAccountsConfig().getDouble(p.getName().toLowerCase() + ".money");
          double finalcost = (mincost*this.plugin.getConfig().getDouble("revive-cost-rate")) + (mymoney*this.plugin.getConfig().getDouble("revive-cost-tax"));
          if (this.plugin.PlayerinJob(p, "Explorer") && this.plugin.getJobLv("Explorer", p)>=20) {
        	  finalcost*=0.25;
          }
    	  p.sendMessage("You need to have $"+df.format(finalcost)+" to revive.");
          return true;
      }
      else if (cmd.getName().toLowerCase().equalsIgnoreCase("tele") && (args[0].equalsIgnoreCase("to"))) {
          DecimalFormat df = new DecimalFormat("#0.00");
    	  if (p.getPlayerTime()-this.plugin.getAccountsConfig().getDouble(p.getName().toLowerCase() + ".teletime")<400) {
    		  if (args.length==1) {
        		  p.sendMessage("Usage: "+ChatColor.RED+"/tele to "+ChatColor.GREEN+" <player>"+ChatColor.WHITE+" - Teleport to a player for a cost.");
    		  } else if (args.length==2) {
        		  //Teleport.
		            Player target = p.getServer().getPlayer(args[1]);
		            if (target == null) {
		            	//It could be a town name. Check
		            	TownManager t = MCTownsPlugin.getPlugin().getTownManager();
            			Bukkit.getLogger().info("Town Manager started:"+ t.toString());
		            	Town teleport_town = null;
		            	Collection<Town> towns = t.getTownsCollection();
		            	for (Town towny : towns) {
		            		if (towny!=null) {
			            		if (towny.getTownName().equalsIgnoreCase(args[1])) {
			            			teleport_town = towny;
			            			break;
			            		} else {
			            			Bukkit.getLogger().info("This was town "+towny.getTownName());
			            		}
		            		}
		            	}
		            	//Iterate through collection, seeing if we can find the town.
		            	if (teleport_town == null) {
		            		p.sendMessage(this.prefix + " " + this.offlinePlayer);
		            	} else {
			            	boolean is_in_vehicle = false;
			            	Entity vehicle = null;
			            	if (p.isInsideVehicle()) {
			            		is_in_vehicle=true;
			            		vehicle = p.getVehicle();
			            	}
			            	if (teleport_town.getTownName().equalsIgnoreCase(this.plugin.getAccountsConfig().getString(p.getName().toLowerCase() + ".teleplayer"))) {
				            	//Determine distance of player to other player.
				            	double otherx = teleport_town.getSpawn(Bukkit.getServer()).getX();
				            	double othery = teleport_town.getSpawn(Bukkit.getServer()).getY();
				            	double otherz = teleport_town.getSpawn(Bukkit.getServer()).getZ();
				            	double mymoney = this.plugin.getAccountsConfig().getDouble(p.getName().toLowerCase().toLowerCase() + ".money");
				            	double finalcost = Math.abs(p.getLocation().getX()-otherx)+Math.abs(p.getLocation().getY()-othery)+Math.abs(p.getLocation().getZ()-otherz);
				            	//Bukkit.getLogger().info("finalcost1:"+finalcost);
				            	finalcost *= this.plugin.getConfig().getDouble("teleport-cost-rate");
				            	//Bukkit.getLogger().info("finalcost2:"+finalcost);
				            	finalcost += finalcost * 15 * ((p.getMaxHealth()-p.getHealth())/p.getMaxHealth());
				            	//Bukkit.getLogger().info("finalcost3:"+finalcost);
				            	//finalcost += mymoney*this.plugin.getConfig().getDouble("teleport-cost-tax");
				            	if (mymoney>=finalcost) {
				            		//Allow teleport to occur.
				  	        	  this.plugin.getAccountsConfig().set(p.getName().toLowerCase().toLowerCase() + ".money", mymoney-finalcost);
				  	        	  this.plugin.getAccountsConfig().set(p.getName().toLowerCase().toLowerCase() + ".teletime", Double.valueOf(0.0d));
					        	  //this.plugin.saveAccountsConfig();
					        	  if (this.plugin.PlayerinJob(p, "Support")) {
					        		  //Give exp for doing so.
					        		  //this.plugin.gainMoneyExp(p,"Support",0,100);
					        	  }
					        	  p.sendMessage("Teleported to "+ChatColor.GREEN+teleport_town.getTownName()+ChatColor.WHITE+" for $"+ChatColor.YELLOW+df.format(finalcost)+ChatColor.WHITE+". New Account balance: $"+df.format(mymoney-finalcost));
					        	  Bukkit.broadcastMessage(ChatColor.GREEN+p.getName()+ChatColor.WHITE+" teleported to "+ChatColor.YELLOW+teleport_town.getTownName()+".");
					        	  if (is_in_vehicle) {
					        		  vehicle.eject();
					        		  p.eject();
					        		  final Player p2 = p;
					        		  final Town target2 = teleport_town;
					        		  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					        		      @Override
					        		      public void run() {
					        		    		  p2.teleport(target2.getSpawn(Bukkit.getServer()));
					        		      }
					        		  	},5);
					        	  } else {
				        			  p.teleport(teleport_town.getSpawn(Bukkit.getServer()));
					        	  }
				            	} else {
						          p.sendMessage("You need $"+ChatColor.YELLOW+df.format(finalcost)+" in the bank to teleport to "+ChatColor.GREEN+teleport_town.getTownName()+ChatColor.WHITE+"!");
				            	}
			            	} else {
			            		//Setup another town.
				            	//Determine distance of player to new town.
				            	double otherx = teleport_town.getSpawn(Bukkit.getServer()).getX();
				            	double othery = teleport_town.getSpawn(Bukkit.getServer()).getY();
				            	double otherz = teleport_town.getSpawn(Bukkit.getServer()).getZ();
				            	double mymoney = this.plugin.getAccountsConfig().getDouble(p.getName().toLowerCase().toLowerCase() + ".money");
				            	double finalcost = Math.abs(p.getLocation().getX()-otherx)+Math.abs(p.getLocation().getY()-othery)+Math.abs(p.getLocation().getZ()-otherz);
				            	Bukkit.getLogger().info("finalcost1:"+finalcost);
				            	finalcost *= this.plugin.getConfig().getDouble("teleport-cost-rate");
				            	Bukkit.getLogger().info("finalcost2:"+finalcost);
				            	finalcost += finalcost * 15 * ((p.getMaxHealth()-p.getHealth())/p.getMaxHealth());
				            	Bukkit.getLogger().info("finalcost3:"+finalcost);
				            	//finalcost += mymoney*this.plugin.getConfig().getDouble("teleport-cost-tax");
				            	if (mymoney>=finalcost) {
				            		//Allow teleport to occur.
							        p.sendMessage("Teleporting to "+ChatColor.GREEN+teleport_town.getTownName()+ChatColor.WHITE+" costs $"+ChatColor.YELLOW+df.format(finalcost)+". Type the command again to teleport.");
					  	        	this.plugin.getAccountsConfig().set(p.getName().toLowerCase().toLowerCase() + ".teletime", Double.valueOf(p.getPlayerTime()));
					  	        	this.plugin.getAccountsConfig().set(p.getName().toLowerCase().toLowerCase() + ".teleplayer", String.valueOf(teleport_town.getTownName()));
				            	} else {
							        p.sendMessage("Teleporting to "+ChatColor.GREEN+teleport_town.getTownName()+ChatColor.WHITE+" costs $"+ChatColor.YELLOW+df.format(finalcost)+". You do not have enough in the bank for that.");
				            	}
			            	}
		            	}
		            } else {
		            	boolean is_in_vehicle = false;
		            	Entity vehicle = null;
		            	if (p.isInsideVehicle()) {
		            		is_in_vehicle=true;
		            		vehicle = p.getVehicle();
		            	}
		            	if (this.plugin.hasDistortionOrb(target)) {
		            		p.getWorld().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.9f, 1);
		            		p.sendMessage(ChatColor.YELLOW + "A strange force prevents you from teleporting!");
		            	} else if (target.getName().equalsIgnoreCase(this.plugin.getAccountsConfig().getString(p.getName().toLowerCase() + ".teleplayer"))) {
			            	//Determine distance of player to other player.
			            	double otherx = target.getLocation().getX();
			            	double othery = target.getLocation().getY();
			            	double otherz = target.getLocation().getZ();
			            	double mymoney = this.plugin.getAccountsConfig().getDouble(p.getName().toLowerCase() + ".money");
			            	double finalcost = Math.abs(p.getLocation().getX()-otherx)+Math.abs(p.getLocation().getY()-othery)+Math.abs(p.getLocation().getZ()-otherz);
			            	//Bukkit.getLogger().info("finalcost1:"+finalcost);
			            	finalcost *= this.plugin.getConfig().getDouble("teleport-cost-rate");
			            	//Bukkit.getLogger().info("finalcost2:"+finalcost);
			            	finalcost += finalcost * 15 * ((p.getMaxHealth()-p.getHealth())/p.getMaxHealth());
			            	//Bukkit.getLogger().info("finalcost3:"+finalcost);
			            	//finalcost += mymoney*this.plugin.getConfig().getDouble("teleport-cost-tax");
			            	if (mymoney>=finalcost) {
			            		//Allow teleport to occur.
			  	        	  this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".money", mymoney-finalcost);
			  	        	  this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".teletime", Double.valueOf(0.0d));
				        	  this.plugin.saveAccountsConfig();
				        	  if (this.plugin.PlayerinJob(p, "Support")) {
				        		  //Give exp for doing so.
				        		  //this.plugin.gainMoneyExp(p,"Support",0,100);
				        	  }
				        	  p.sendMessage("Teleported to "+ChatColor.GREEN+target.getName()+ChatColor.WHITE+" for $"+ChatColor.YELLOW+df.format(finalcost)+ChatColor.WHITE+". New Account balance: $"+df.format(mymoney-finalcost));
				        	  target.sendMessage(ChatColor.GREEN+p.getName()+ChatColor.WHITE+" teleported to your location.");
				        	  if (is_in_vehicle) {
				        		  vehicle.eject();
				        		  p.eject();
				        		  final Player p2 = p;
				        		  final Player target2 = target;
				        		  Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				        		      @Override
				        		      public void run() {
				        		    	  if (target2.isInsideVehicle()) {
				        		    		  p2.teleport(target2.getLocation().add(0,1,0));
				        		    	  } else {
				        		    		  p2.teleport(target2);
				        		    	  }
				        		      }
				        		  	},5);
				        	  } else {
				        		  if (target.isInsideVehicle()) {
				        			  p.teleport(target.getLocation().add(0,1,0));
				        		  } else {
				        			  p.teleport(target);
				        		  }
				        	  }
			            	} else {
					          p.sendMessage("You need $"+ChatColor.YELLOW+df.format(finalcost)+" in the bank to teleport to "+ChatColor.GREEN+target.getName()+ChatColor.WHITE+"!");
			            	}
		            	} else {
		            		//Setup another player.
			            	//Determine distance of player to other player.
			            	double otherx = target.getLocation().getX();
			            	double othery = target.getLocation().getY();
			            	double otherz = target.getLocation().getZ();
			            	double mymoney = this.plugin.getAccountsConfig().getDouble(p.getName().toLowerCase() + ".money");
			            	double finalcost = Math.abs(p.getLocation().getX()-otherx)+Math.abs(p.getLocation().getY()-othery)+Math.abs(p.getLocation().getZ()-otherz);
			            	Bukkit.getLogger().info("finalcost1:"+finalcost);
			            	finalcost *= this.plugin.getConfig().getDouble("teleport-cost-rate");
			            	Bukkit.getLogger().info("finalcost2:"+finalcost);
			            	finalcost += finalcost * 15 * ((p.getMaxHealth()-p.getHealth())/p.getMaxHealth());
			            	Bukkit.getLogger().info("finalcost3:"+finalcost);
			            	//finalcost += mymoney*this.plugin.getConfig().getDouble("teleport-cost-tax");
			            	if (mymoney>=finalcost) {
			            		//Allow teleport to occur.
						        p.sendMessage("Teleporting to "+ChatColor.GREEN+target.getName()+ChatColor.WHITE+" costs $"+ChatColor.YELLOW+df.format(finalcost)+". Type the command again to teleport.");
				  	        	this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".teletime", Double.valueOf(p.getPlayerTime()));
				  	        	this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".teleplayer", String.valueOf(target.getName()));
			            	} else {
						        p.sendMessage("Teleporting to "+ChatColor.GREEN+target.getName().toLowerCase()+ChatColor.WHITE+" costs $"+ChatColor.YELLOW+df.format(finalcost)+". You do not have enough in the bank for that.");
			            	}
		            	}
		            }
    		  }
    	  } else {
    		  //Say how much it costs. If the player is found. =
    		  if (args.length==1) {
    			  p.sendMessage("Usage: "+ChatColor.RED+"/tele to "+ChatColor.GREEN+" <player>"+ChatColor.WHITE+" - Teleport to a player for a cost.");
			  } else if (args.length==2) {
	    		  //Teleport.
		            Player target = p.getServer().getPlayer(args[1]);
		            if (target == null) {
		            	//It could be a town name. Check
		            	TownManager t = MCTownsPlugin.getPlugin().getTownManager();
            			Bukkit.getLogger().info("Town Manager started:"+ t.toString());
		            	Town teleport_town = null;
		            	Collection<Town> towns = t.getTownsCollection();
		            	for (Town towny : towns) {
		            		if (towny!=null) {
			            		if (towny.getTownName().equalsIgnoreCase(args[1])) {
			            			teleport_town = towny;
			            			break;
			            		} else {
			            			Bukkit.getLogger().info("This was town "+towny.getTownName());
			            		}
		            		}
		            	}
		            	if (teleport_town == null) {
		            		p.sendMessage(this.prefix + " " + this.offlinePlayer);
		            	} else {
		            		//We can attempt to teleport to this town's spawn point. Find out the point and how much it costs.
		            		Location spawn_point = teleport_town.getSpawn(Bukkit.getServer());
			            	//Determine distance of player to town..
			            	double otherx = spawn_point.getX();
			            	double othery = spawn_point.getY();
			            	double otherz = spawn_point.getZ();
			            	double mymoney = this.plugin.getAccountsConfig().getDouble(p.getName().toLowerCase().toLowerCase() + ".money");
			            	double finalcost = Math.abs(p.getLocation().getX()-otherx)+Math.abs(p.getLocation().getY()-othery)+Math.abs(p.getLocation().getZ()-otherz);
			            	//Bukkit.getLogger().info("finalcost1:"+finalcost);
			            	finalcost *= this.plugin.getConfig().getDouble("teleport-cost-rate");
			            	//Bukkit.getLogger().info("finalcost2:"+finalcost);
			            	finalcost += finalcost * 15 * ((p.getMaxHealth()-p.getHealth())/p.getMaxHealth());
			            	//Bukkit.getLogger().info("finalcost3:"+finalcost);
			            	//finalcost += mymoney*this.plugin.getConfig().getDouble("teleport-cost-tax");
			            	if (mymoney>=finalcost) {
			            		//Allow teleport to occur.
						        p.sendMessage("Teleporting to "+ChatColor.GREEN+teleport_town.getTownName()+ChatColor.WHITE+" costs $"+ChatColor.YELLOW+df.format(finalcost)+". Type the command again to teleport.");
				  	        	this.plugin.getAccountsConfig().set(p.getName().toLowerCase().toLowerCase() + ".teletime", Double.valueOf(p.getPlayerTime()));
				  	        	this.plugin.getAccountsConfig().set(p.getName().toLowerCase().toLowerCase() + ".teleplayer", String.valueOf(teleport_town.getTownName().toLowerCase()));
			            	} else {
						        p.sendMessage("Teleporting to "+ChatColor.GREEN+teleport_town.getTownName()+ChatColor.WHITE+" costs $"+ChatColor.YELLOW+df.format(finalcost)+". You do not have enough in the bank for that.");
			            	}
		            	}
		            } else {
		            	//Determine distance of player to other player.
		            	double otherx = target.getLocation().getX();
		            	double othery = target.getLocation().getY();
		            	double otherz = target.getLocation().getZ();
		            	double mymoney = this.plugin.getAccountsConfig().getDouble(p.getName().toLowerCase() + ".money");
		            	double finalcost = Math.abs(p.getLocation().getX()-otherx)+Math.abs(p.getLocation().getY()-othery)+Math.abs(p.getLocation().getZ()-otherz);
		            	//Bukkit.getLogger().info("finalcost1:"+finalcost);
		            	finalcost *= this.plugin.getConfig().getDouble("teleport-cost-rate");
		            	//Bukkit.getLogger().info("finalcost2:"+finalcost);
		            	finalcost += finalcost * 15 * ((p.getMaxHealth()-p.getHealth())/p.getMaxHealth());
		            	//Bukkit.getLogger().info("finalcost3:"+finalcost);
		            	//finalcost += mymoney*this.plugin.getConfig().getDouble("teleport-cost-tax");
		            	if (mymoney>=finalcost) {
		            		//Allow teleport to occur.
					        p.sendMessage("Teleporting to "+ChatColor.GREEN+target.getName()+ChatColor.WHITE+" costs $"+ChatColor.YELLOW+df.format(finalcost)+". Type the command again to teleport.");
			  	        	this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".teletime", Double.valueOf(p.getPlayerTime()));
			  	        	this.plugin.getAccountsConfig().set(p.getName().toLowerCase() + ".teleplayer", String.valueOf(target.getName()));
		            	} else {
					        p.sendMessage("Teleporting to "+ChatColor.GREEN+target.getName().toLowerCase()+ChatColor.WHITE+" costs $"+ChatColor.YELLOW+df.format(finalcost)+". You do not have enough in the bank for that.");
		            	}
		            }
			  }
    	  }
          return true;
      } else
      if (cmd.getName().toLowerCase().equalsIgnoreCase("jobs") && args.length == 1 && args[0].equalsIgnoreCase("info")) {
		  p.sendMessage("Usage: "+ChatColor.GREEN+"/jobs info [JobName]"+ChatColor.WHITE+" - Get information about a job.");
		  p.sendMessage("Usage: "+ChatColor.GREEN+"/jobs info [JobName] "+ChatColor.LIGHT_PURPLE+"[lv]"+ChatColor.WHITE+" - Get information about a job at a certain job level.");
		  p.sendMessage("     Type /jobs to see the jobs.");
      } else
      if (cmd.getName().toLowerCase().equalsIgnoreCase("jobs") && args.length == 1 && args[0].equalsIgnoreCase("join")) {
		  p.sendMessage("Usage: "+ChatColor.GREEN+"/jobs join [JobName]"+ChatColor.WHITE+" - Join a job. Type /jobs to see the jobs.");
      } else
      if (cmd.getName().equalsIgnoreCase("jobs") && args.length == 1 && args[0].equalsIgnoreCase("members")) {
		  p.sendMessage("Usage: "+ChatColor.GREEN+"/jobs members [JobName]"+ChatColor.WHITE+" - Check all members in a job.");
      } else
      if (cmd.getName().equalsIgnoreCase("jobs") && args.length == 1 && args[0].equalsIgnoreCase("members")) {
		  p.sendMessage("Usage: "+ChatColor.GREEN+"/jobs members [JobName]"+ChatColor.WHITE+" - Check all members in a job.");
      } else
      if (cmd.getName().toLowerCase().equalsIgnoreCase("jobs") && args.length == 1 && args[0].equalsIgnoreCase("leave")) {
		  p.sendMessage("Usage: "+ChatColor.GREEN+"/jobs leave [JobName]"+ChatColor.WHITE+" - Leave a job. Type /jobs stats to see your jobs.");
      } else
      if (cmd.getName().equalsIgnoreCase("jobs") && args.length == 1 && args[0].equalsIgnoreCase("buffs")) {
		  p.sendMessage("Usage: "+ChatColor.GREEN+"/jobs buffs [JobName]"+ChatColor.WHITE+" - Get buffs information about a job. Type /jobs to see the jobs.");
      } else
      if (cmd.getName().toLowerCase().equalsIgnoreCase("jobs") && args.length == 2 && args[0].equalsIgnoreCase("ultimate")) {
		  //Attempt to join the job.
    	  this.plugin.setUltimate(p,args[1]);
      } else
      if (cmd.getName().equalsIgnoreCase("jobs") && args.length == 2 && args[0].equalsIgnoreCase("boost")) {
		  //Attempt to level up the job.
    	  this.plugin.levelUpJob(p,args[1]);
      } else
      if (cmd.getName().toLowerCase().equalsIgnoreCase("jobs") && args.length == 2 && args[0].equalsIgnoreCase("join")) {
		  //Attempt to join the job.
    	  this.plugin.joinJob(p,args[1]);
      } else
      if (cmd.getName().toLowerCase().equalsIgnoreCase("jobs") && args.length == 2 && args[0].equalsIgnoreCase("leave")) {
		  //Attempt to join the job.
    	  this.plugin.leaveJob(p,args[1]);
      } else
      if (cmd.getName().equalsIgnoreCase("jobs") && args.length == 2 && args[0].equalsIgnoreCase("members")) {
    	  JobsDataInfo[] Jobsinfo = {this.plugin.Woodcutter_job,this.plugin.Miner_job,this.plugin.Builder_job,this.plugin.Digger_job,this.plugin.Farmer_job,this.plugin.Hunter_job,this.plugin.Fisherman_job,this.plugin.Weaponsmith_job,this.plugin.Blacksmith_job,this.plugin.Cook_job,this.plugin.Brewer_job,this.plugin.Enchanter_job,this.plugin.Breeder_job,this.plugin.Explorer_job,this.plugin.Support_job};
    	  boolean found=false;
    	  String job = "";
    	  ChatColor job_color = null;
    	  for (int i=0;i<this.plugin.ValidJobs.length;i++) {
    		  if (this.plugin.ValidJobs[i].toLowerCase().equalsIgnoreCase(args[1])) {
    			  found=true;
    			  job = this.plugin.ValidJobs[i];
    			  job_color = this.plugin.getJobColor(this.plugin.ValidJobs[i]);
    			  break;
    		  }
    	  }
    	  if (found) {
    		  if (this.plugin.getConfig().contains("jobs."+job+"_members")) {
    			  p.sendMessage("Players in the "+job_color+job+" job:");
    			  String[] players = this.plugin.getConfig().getString("jobs."+job+"_members").split(", ");
    			  int lowest = 999999;
    			  List<String> sorted_players = new ArrayList<String>();
    			  for (int i=0;i<players.length;i++) {
    				  sorted_players.add(players[i]); //Add everyone to the list.
    				  Bukkit.getLogger().info("Add player "+players[i]);
    			  }
    			  //Sort them.
    			  List<String> sorted_list_players = new ArrayList<String>();
    			  int lowest_slot = -1;
    			  while (sorted_players.size()>0) {
    				  for (int i=0;i<sorted_players.size();i++) {
    					  if (sorted_players.get(i).length()>0) { //If it's 0, for some reason it didn't read this name right....Skip it.
	    					  if (this.plugin.getJobLv(job, sorted_players.get(i))<lowest) {
	    						  lowest=this.plugin.getJobLv(job, sorted_players.get(i));
	    						  lowest_slot=i;
	    					  }
    					  }
    				  }
    				  if (lowest_slot!=-1) {
	    				  sorted_list_players.add(sorted_players.get(lowest_slot));
	    				  sorted_players.remove(lowest_slot);
	    				  lowest_slot=-1;
	    				  lowest=999999;
    				  } else {
    	        		  p.sendMessage(ChatColor.GOLD+"Sorry, something bad happened! Please report this to an administrator. (EC1)");
    					  break; //Something bad happened.
    				  }
    			  }
    			  if (sorted_list_players.size()>0) {
	    			  for (int i=0;i<sorted_list_players.size();i++) {
	    				  OfflinePlayer q = Bukkit.getOfflinePlayer(sorted_list_players.get(i));
	    				  p.sendMessage("  "+q.getName()+ChatColor.GRAY+ChatColor.ITALIC+" (Lv"+this.plugin.getJobLv(job, q.getName().toLowerCase())+")");
	    			  }
    			  } else {
    				  p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"- No one in this job yet. -");
    			  }
    		  } else {
        		  p.sendMessage(ChatColor.GOLD+"Sorry, something bad happened! Please report this to an administrator. (EC0)");
    		  }
    	  } else {
    		  p.sendMessage(ChatColor.RED+"Sorry, that is not a valid job!");
    	  }
      } else
      if (cmd.getName().toLowerCase().equalsIgnoreCase("jobs") && (args.length == 2 || args.length==3) && args[0].equalsIgnoreCase("info")) {
    	  JobsDataInfo[] Jobsinfo = {this.plugin.Woodcutter_job,this.plugin.Miner_job,this.plugin.Builder_job,this.plugin.Digger_job,this.plugin.Hunter_job,this.plugin.Fisherman_job,this.plugin.Weaponsmith_job,this.plugin.Blacksmith_job,this.plugin.Cook_job,this.plugin.Brewer_job,this.plugin.Enchanter_job,this.plugin.Breeder_job,this.plugin.Explorer_job,this.plugin.Support_job};
    	  boolean found=false;
    	  int matchedjob=0;
    	  boolean error=false;
    	  for (int i=0;i<this.plugin.ValidJobs.length;i++) {
    		  if (this.plugin.ValidJobs[i].equalsIgnoreCase(args[1])) {
    			  //Found the job, display that data.
    			  if (args.length==2) {
    				  //Get slot this job is in for this player.
    				  String[] joblist = this.plugin.getJobs(p);
    				  int slot=0;
    				  for (int j=0;j<joblist.length;j++) {
    					  if (args[1].equalsIgnoreCase(joblist[j])) {
    						  slot=j;
    						  break;
    					  }
    				  }
    				  if (this.plugin.PlayerinJob(p, args[1])) {
    					  Jobsinfo[i].sendOutput(p,this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job"+(slot+1)+"lv"));
    				  } else {
    					  Jobsinfo[i].sendOutput(p);
    				  }
    			  } else {
    				  Jobsinfo[i].sendOutput(p,(int)Double.parseDouble(args[2].replaceAll("[^0-9\\.]", "")));
    				  error=true;
    			  }
    			  found=true;
    			  matchedjob=i;
    			  break;
    		  }
    	  }
    	  if (!error)
    	  {
    		  p.sendMessage(ChatColor.GOLD+"Job $$ Growth Rate: "+ChatColor.WHITE+Math.round(Jobsinfo[matchedjob].moneymult*100)+"% per level");
			  p.sendMessage("");
			  p.sendMessage(ChatColor.BLUE+"To see the buffs this job gives, type "+ChatColor.GREEN+" /jobs buffs "+args[1]+ChatColor.WHITE+".");
    	  }
    	  if (!found) {
    	   p.sendMessage(ChatColor.GOLD+"That is not a valid job name.");
		   p.sendMessage("Usage: "+ChatColor.GREEN+"/jobs info [JobName]"+ChatColor.WHITE+" - Get information about a job. Type /jobs to see the jobs.");
    	  } else {
    		  if (!this.plugin.PlayerinJob(p, args[1]) && this.plugin.getPlayerJobCount(p)<3) {
    			  p.sendMessage("");
    			  p.sendMessage("To join this job, type "+ChatColor.GREEN+" /jobs join "+args[1]+ChatColor.WHITE+".");
    		  } else {
    			  if (!this.plugin.PlayerinJob(p, args[1]) && this.plugin.getPlayerJobCount(p)==3) {
    				  p.sendMessage("");
        			  p.sendMessage("You can't join this job until you leave a job with "+ChatColor.GREEN+" /jobs leave"+ChatColor.WHITE+".");
    			  }
    		  }
    	  }
		  p.sendMessage("");
      } else
      if (cmd.getName().toLowerCase().equalsIgnoreCase("jobs") && (args.length == 2) && args[0].equalsIgnoreCase("buffs")) {
    	  JobsDataInfo[] Jobsinfo = {this.plugin.Woodcutter_job,this.plugin.Miner_job,this.plugin.Builder_job,this.plugin.Digger_job,this.plugin.Hunter_job,this.plugin.Fisherman_job,this.plugin.Weaponsmith_job,this.plugin.Blacksmith_job,this.plugin.Cook_job,this.plugin.Brewer_job,this.plugin.Enchanter_job,this.plugin.Breeder_job,this.plugin.Explorer_job,this.plugin.Support_job};
    	  boolean found=false;
    	  int slot=0;
    	  for (int i=0;i<this.plugin.ValidJobs.length;i++) {
    		  if (this.plugin.ValidJobs[i].equalsIgnoreCase(args[1])) {
    			  //This is a valid job.
    			  found=true;
    			  slot=i;
    			  break;
    		  }
    	  }
    	  if (!found) {
       	   p.sendMessage(ChatColor.GOLD+"That is not a valid job name.");
   		   p.sendMessage("Usage: "+ChatColor.GREEN+"/jobs buffs [JobName]"+ChatColor.WHITE+" - Get buffs information about a job. Type /jobs to see the jobs.");
    	  } else {
    		  p.sendMessage("");
    		  p.sendMessage("Buffs for the "+args[1]+" job:");
    		  p.sendMessage("");
    		  p.sendMessage(ChatColor.BLUE+"Lv5 BUFF: "+ChatColor.WHITE+Jobsinfo[slot].lv5buff);
    		  p.sendMessage("");
    		  p.sendMessage(ChatColor.GREEN+"Lv10 BUFF: "+ChatColor.WHITE+Jobsinfo[slot].lv10buff);
    		  p.sendMessage("");
    		  p.sendMessage(ChatColor.GOLD+"Lv20 BUFF: "+ChatColor.WHITE+Jobsinfo[slot].lv20buff);
    		  p.sendMessage("");
    		  p.sendMessage(ChatColor.LIGHT_PURPLE+"Lv30 BUFF A: "+ChatColor.WHITE+Jobsinfo[slot].lv30_1buff);
    		  p.sendMessage(ChatColor.YELLOW+""+ChatColor.BOLD+"  - OR -");
    		  p.sendMessage(ChatColor.LIGHT_PURPLE+"Lv30 BUFF B: "+ChatColor.WHITE+Jobsinfo[slot].lv30_2buff);
    		  p.sendMessage("");
    		  p.sendMessage(ChatColor.RED+"Lv40 ULTI: "+ChatColor.WHITE+Jobsinfo[slot].lv40buff);
    		  p.sendMessage("");
    		  p.sendMessage(ChatColor.ITALIC+"Note that only one ultimate buff can be chosen. And CANNOT BE CHANGED.");
    	  }
      } else
      if (cmd.getName().toLowerCase().equalsIgnoreCase("jobs") && (args.length == 1 || args.length==2) && args[0].equalsIgnoreCase("stats")) {
    	  if (args.length==1) {
    		  //Show your stats.
    		  p.sendMessage("");
    		  p.sendMessage("Your jobs:");
    		  String[] joblist=this.plugin.getJobs(p);
    		  for (int i=0;i<joblist.length;i++) {
    			  if (!joblist[i].equalsIgnoreCase("None")) {
    				  int mylv=this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job"+(i+1)+"lv");

    				  if (mylv==40) {
    					  p.sendMessage("Lv"+mylv+" "+this.plugin.getJobColor(joblist[i])+joblist[i]+ChatColor.WHITE+": "+Math.round(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job"+(i+1)+"exp"))+"xp   "+ChatColor.BLUE+(mylv>=5?"+Lv5 Buff":"")+ChatColor.GREEN+(mylv>=10?" +Lv10 Buff":"")+ChatColor.GOLD+(mylv>=20?" +Lv20 Buff":""));
    				  } else {
    					  p.sendMessage("Lv"+mylv+" "+this.plugin.getJobColor(joblist[i])+joblist[i]+ChatColor.WHITE+": "+Math.round(this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job"+(i+1)+"exp"))+"/"+Math.round(this.plugin.getJobExp(joblist[i], this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".jobs.job"+(i+1)+"lv")))+"xp   "+ChatColor.BLUE+(mylv>=5?"+Lv5 Buff":"")+ChatColor.GREEN+(mylv>=10?" +Lv10 Buff":"")+ChatColor.GOLD+(mylv>=20?" +Lv20 Buff":""));
    				  }
    				  
    				  if (joblist[i].equalsIgnoreCase("Explorer") && this.plugin.getJobLv(joblist[i], p)>=10) {
    					  //Check to see if the buff is on cooldown for this player or not.
    					  boolean discovered=false;
    					  long timeleft=0;
    					  for (int j=0;j<this.plugin.explorers.size();j++) {
    						  if (this.plugin.explorers.get(j).name.compareToIgnoreCase(p.getName().toLowerCase().toLowerCase())==0 && this.plugin.explorers.get(j).event==0) {
    							  discovered=true;
    							  timeleft=this.plugin.explorers.get(j).expiretime-this.plugin.SERVER_TICK_TIME;
    						  }
    					  }
    					  //Add-on message for explorer buff cooldown.
    				      DecimalFormat df = new DecimalFormat("00");
    					  p.sendMessage("    "+ChatColor.ITALIC+ChatColor.GOLD+"Fatal Survivor Buff: "+ChatColor.RESET+((discovered)?((timeleft<=0)?ChatColor.GREEN+"Available":ChatColor.RED+"Unavailable"+ChatColor.ITALIC+ChatColor.WHITE+" Cooldown: "+df.format(timeleft/36000)+":"+df.format((timeleft/600)%60)+":"+df.format((timeleft/10)%60)):ChatColor.GREEN+"Available"));
    				  }  
    			  }
    		  }
    	  } else {
    		  //Look for that player. First just see if they are online.
    		  boolean found=false;
    		  if (Bukkit.getPlayer(args[1])!=null) {
				  //This is the player. Show job stats.
	    		  p.sendMessage("");
	    		  p.sendMessage(Bukkit.getPlayer(args[1]).getName().toLowerCase()+"'s jobs:");
	    		  String[] joblist=this.plugin.getJobs(Bukkit.getPlayer(args[1]));
	    		  for (int i=0;i<joblist.length;i++) {
	    			  if (!joblist[i].equalsIgnoreCase("None")) {
	    				  int mylv=this.plugin.getAccountsConfig().getInt(Bukkit.getPlayer(args[1]).getName().toLowerCase()+".jobs.job"+(i+1)+"lv");

	    				  if (mylv==40) {
	    					  p.sendMessage("Lv"+mylv+" "+this.plugin.getJobColor(joblist[i])+joblist[i]+ChatColor.WHITE+": "+Math.round(this.plugin.getAccountsConfig().getInt(Bukkit.getPlayer(args[1]).getName().toLowerCase()+".jobs.job"+(i+1)+"exp"))+"xp   "+ChatColor.BLUE+(mylv>=5?"+Lv5 Buff":"")+ChatColor.GREEN+(mylv>=10?" +Lv10 Buff":"")+ChatColor.GOLD+(mylv>=20?" +Lv20 Buff":""));
	    				  } else {
	    					  p.sendMessage("Lv"+mylv+" "+this.plugin.getJobColor(joblist[i])+joblist[i]+ChatColor.WHITE+": "+Math.round(this.plugin.getAccountsConfig().getInt(Bukkit.getPlayer(args[1]).getName().toLowerCase()+".jobs.job"+(i+1)+"exp"))+"/"+Math.round(this.plugin.getJobExp(joblist[i], this.plugin.getAccountsConfig().getInt(Bukkit.getPlayer(args[1]).getName().toLowerCase()+".jobs.job"+(i+1)+"lv")))+"xp   "+ChatColor.BLUE+(mylv>=5?"+Lv5 Buff":"")+ChatColor.GREEN+(mylv>=10?" +Lv10 Buff":"")+ChatColor.GOLD+(mylv>=20?" +Lv20 Buff":""));
	    				  }
    					  
	    				  if (joblist[i].equalsIgnoreCase("Explorer") && this.plugin.getJobLv(joblist[i], Bukkit.getPlayer(args[1]))>=10) {
	    					  //Check to see if the buff is on cooldown for this player or not.
	    					  boolean discovered=false;
	    					  long timeleft=0;
	    					  for (int j=0;j<this.plugin.explorers.size();j++) {
	    						  if (this.plugin.explorers.get(j).name.compareToIgnoreCase(Bukkit.getPlayer(args[1]).getName().toLowerCase())==0 && this.plugin.explorers.get(j).event==0) {
	    							  discovered=true;
	    							  timeleft=this.plugin.explorers.get(j).expiretime-this.plugin.SERVER_TICK_TIME;
	    						  }
	    					  }
	    					  //Add-on message for explorer buff cooldown.
	    				      DecimalFormat df = new DecimalFormat("00");
	    					  p.sendMessage("    "+ChatColor.ITALIC+ChatColor.GOLD+"Fatal Survivor Buff: "+ChatColor.RESET+((discovered)?((timeleft<=0)?ChatColor.GREEN+"Available":ChatColor.RED+"Unavailable"+ChatColor.ITALIC+ChatColor.WHITE+" Cooldown: "+df.format(timeleft/36000)+":"+df.format((timeleft/600)%60)+":"+df.format((timeleft/10)%60)):ChatColor.GREEN+"Available"));
	    				  }  
	    			  }
	    		  }
	    		  found=true;
    		  }
    		  if (!found) {
	    		  OfflinePlayer q = Bukkit.getOfflinePlayer(args[1]);
	    		  //Try a search in the config directly.
	    		  if (this.plugin.getAccountsConfig().contains(q.getName().toLowerCase())) {
	    			  //This player seems to exist. Check out their stats.
		    		  p.sendMessage("");
		    		  p.sendMessage(q.getName().toLowerCase()+"'s jobs:");
		    		  String[] joblist=this.plugin.getJobs(q.getName().toLowerCase());
		    		  for (int i=0;i<joblist.length;i++) {
		    			  if (joblist[i]!=null) {
		    				  Bukkit.getLogger().info("JobList "+i+": "+joblist[i]);
		    			  }
		    			  if (!joblist[i].equalsIgnoreCase("None")) {
		    				  int mylv=this.plugin.getAccountsConfig().getInt(q.getName().toLowerCase()+".jobs.job"+(i+1)+"lv");
		    				  if (mylv==40) {
		    					  p.sendMessage("Lv"+mylv+" "+this.plugin.getJobColor(joblist[i])+joblist[i]+ChatColor.WHITE+": "+Math.round(this.plugin.getAccountsConfig().getInt(q.getName().toLowerCase()+".jobs.job"+(i+1)+"exp"))+"xp   "+ChatColor.BLUE+(mylv>=5?"+Lv5 Buff":"")+ChatColor.GREEN+(mylv>=10?" +Lv10 Buff":"")+ChatColor.GOLD+(mylv>=20?" +Lv20 Buff":""));
		    				  } else {
		    					  p.sendMessage("Lv"+mylv+" "+this.plugin.getJobColor(joblist[i])+joblist[i]+ChatColor.WHITE+": "+Math.round(this.plugin.getAccountsConfig().getInt(q.getName().toLowerCase()+".jobs.job"+(i+1)+"exp"))+"/"+Math.round(this.plugin.getJobExp(joblist[i], this.plugin.getAccountsConfig().getInt(q.getName().toLowerCase()+".jobs.job"+(i+1)+"lv")))+"xp   "+ChatColor.BLUE+(mylv>=5?"+Lv5 Buff":"")+ChatColor.GREEN+(mylv>=10?" +Lv10 Buff":"")+ChatColor.GOLD+(mylv>=20?" +Lv20 Buff":""));
		    				  }
		    			  }
		    			  if (joblist[i].equalsIgnoreCase("Explorer") && this.plugin.getJobLv(joblist[i], q.getName().toLowerCase())>=10) {
	    					  //Check to see if the buff is on cooldown for this player or not.
	    					  boolean discovered=false;
	    					  long timeleft=0;
	    					  for (int j=0;j<this.plugin.explorers.size();j++) {
	    						  if (this.plugin.explorers.get(j).name.compareToIgnoreCase(q.getName().toLowerCase())==0 && this.plugin.explorers.get(j).event==0) {
	    							  discovered=true;
	    							  timeleft=this.plugin.explorers.get(j).expiretime-this.plugin.SERVER_TICK_TIME;
	    						  }
	    					  }
	    					  //Add-on message for explorer buff cooldown.
	    				      DecimalFormat df = new DecimalFormat("00");
	    					  p.sendMessage("    "+ChatColor.ITALIC+ChatColor.GOLD+"Fatal Survivor Buff: "+ChatColor.RESET+((discovered)?((timeleft<=0)?ChatColor.GREEN+"Available":ChatColor.RED+"Unavailable"+ChatColor.ITALIC+ChatColor.WHITE+" Cooldown: "+df.format(timeleft/36000)+":"+df.format((timeleft/600)%60)+":"+df.format((timeleft/10)%60)):ChatColor.GREEN+"Available"));
	    				  }  
		    		  }
		    		  found=true;
		    		  
	    		  }
    		  }
    		  if (!found) {
    			  p.sendMessage(ChatColor.GOLD+"Could not find player!");
    		  }
    	  }
      } else
	    if (cmd.getName().equalsIgnoreCase("jobs") && args.length == 2) {
		  //Attempt to set the level 30 aspect of the job.
	  	  this.plugin.setLv30Choice(p,args[0],args[1]);
	    } 
      else {
          p.sendMessage(this.invARGT2);
        }
      }

    }

    return false;
  }
}
