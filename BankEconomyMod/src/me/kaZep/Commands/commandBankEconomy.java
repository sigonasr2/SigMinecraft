package me.kaZep.Commands;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.kaZep.Base.Dungeon;
import me.kaZep.Base.Main;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.meta.ItemMeta;


public class commandBankEconomy
  implements CommandExecutor
{
  public Main plugin;
  String prefix = "Åò2[BankEconomy]";
  String usage = "ÅòbUsage:";
  String invARG = "ÅòcInvalid argument. Please use Åò2/bankeconomyÅòc to see a full list of commands.";
  String invARGT2 = "ÅòcInvalid argument or insufficient permissions.";
  String offlinePlayer = "ÅòcPlayer not found.";
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
  String cmdTransferToPlayer1 = "ÅòaYou have transferedÅòb";
  String cmdTransferToPlayer2 = "ÅòatoÅòb";
  String cmdTransferToTarget1 = "Åòahas transfered to youÅòb";
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

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((sender instanceof Player)) {
      Player p = (Player)sender;

      boolean status = this.plugin.getAccountsConfig().getBoolean(p.getName() + ".status");
      int playerBankBalance = this.plugin.getAccountsConfig().getInt(p.getName() + ".money");

      String currencySingular = Main.economy.currencyNameSingular();
      String currencyPlural = Main.economy.currencyNamePlural();

      if (!status)
        p.sendMessage(this.prefix + " " + this.accountDisabled);
      else if (status) {
        if ((args.length == 0)) {
	        if (cmd.getName().equalsIgnoreCase("sp")) {
			  //Show a list of all stat points and what you have currently allocated.
	        	p.sendMessage("");
	        	p.sendMessage("Stat Listing shown as: "+ChatColor.AQUA+"Cost, "+ChatColor.YELLOW+"Current Buff, "+ChatColor.RED+"Next Level, "+ChatColor.GREEN+" Description");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#10 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat1")/6+" - "+ChatColor.AQUA+" 6 pts: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat1")<24 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat1")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(0, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat1")/6)+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(0, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat1")/6+1):ChatColor.RED+"+"+this.plugin.getStatBonus(0, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat1")/6+1)):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(0, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat1")/6))))+ChatColor.GREEN+" Health Regeneration.");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#9 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat2")/5+" - "+ChatColor.AQUA+" 5 pts: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat2")<24 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat2")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(1, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat2")/5)+"%"+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(1, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat2")/5+1)+"%":ChatColor.RED+"+"+this.plugin.getStatBonus(1, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat2")/5+1)+"%"):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(1, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat2")/5)+"%")))+ChatColor.GREEN+" block destroying speed.");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#8 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat3")/4+" - "+ChatColor.AQUA+" 4 pts: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat3")<24 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat3")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(2, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat3")/4)+"%"+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(2, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat3")/4+1)+"%":ChatColor.RED+"+"+this.plugin.getStatBonus(2, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat3")/4+1)+"%"):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(2, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat3")/4)+"%")))+ChatColor.GREEN+" damage reduction.");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#7 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4+" - "+ChatColor.AQUA+" 4 pts: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")<24 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4)+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4+1):ChatColor.RED+"+"+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4+1)):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4))))+ChatColor.GREEN+" armor penetration.");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#6 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat4")/3+" - "+ChatColor.AQUA+" 3 pts: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat4")<24 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat4")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(3, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat4")/3)+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(3, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat4")/3+1):ChatColor.RED+"+"+this.plugin.getStatBonus(3, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat4")/3+1)):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(3, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat4")/3))))+ChatColor.GREEN+" temporary health. (Regenerates every 3 minutes)");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#5 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat6")/3+" - "+ChatColor.AQUA+" 3 pts: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat6")<24 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat6")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(5, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat6")/3)+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(5, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat6")/3+1):ChatColor.RED+"+"+this.plugin.getStatBonus(5, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat6")/3+1)):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(5, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat6")/3))))+ChatColor.GREEN+" seconds of fire resistance when caught on fire.");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#4 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat7")/2+" - "+ChatColor.AQUA+" 2 pts: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat7")<24 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat7")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(6, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat7")/2)+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(6, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat7")/2+1):ChatColor.RED+"+"+this.plugin.getStatBonus(6, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat7")/2+1)):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(6, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat7")/2))))+ChatColor.GREEN+" base damage.");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#3 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat8")/2+" - "+ChatColor.AQUA+" 2 pts: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat8")<24 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat8")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(7, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat8")/2)+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(7, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat8")/2+1):ChatColor.RED+"+"+this.plugin.getStatBonus(7, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat8")/2+1)):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(7, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat8")/2))))+ChatColor.GREEN+" health.");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#2 "+ChatColor.RESET+ChatColor.WHITE+"-"+this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat9")/1+" - "+ChatColor.AQUA+" 1 pt: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat9")<25 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat9")>0/*Has a point in it.*/?ChatColor.YELLOW+"-"+this.plugin.getStatBonus(8, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat9")/1)+"%"+"/"+ChatColor.RED+"-"+this.plugin.getStatBonus(8, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat9")/1+1)+"%":ChatColor.RED+"-"+this.plugin.getStatBonus(8, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat9")/1+1)+"%"):(ChatColor.YELLOW+"-"+this.plugin.getStatBonus(8, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat9")/1)+"%")))+ChatColor.GREEN+" hunger decay.");
	        	p.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"#1 "+ChatColor.RESET+ChatColor.WHITE+"+"+this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat10")/1+" - "+ChatColor.AQUA+" 1 pt: "+ChatColor.YELLOW+((this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat10")<25 /*Not maxed.*/?(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat10")>0/*Has a point in it.*/?ChatColor.YELLOW+"+"+this.plugin.getStatBonus(9, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat10")/1)+"/"+ChatColor.RED+"+"+this.plugin.getStatBonus(9, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat10")/1+1):ChatColor.RED+"+"+this.plugin.getStatBonus(9, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat10")/1+1)):(ChatColor.YELLOW+"+"+this.plugin.getStatBonus(9, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat10")/1))))+ChatColor.GREEN+" seconds of water breathing.");
	        	p.sendMessage(ChatColor.ITALIC+""+ChatColor.DARK_AQUA+"Remember that 1 Health / Damage point is half a heart.");
	        	if (this.plugin.getStatPointTotal(p)<this.plugin.getJobTotalLvs(p)/5+1) {
	        		//Check if we have extra stat points.
	        		p.sendMessage(ChatColor.GOLD+"Type "+ChatColor.BLUE+ChatColor.BOLD+"/sp #"+ChatColor.RESET+ChatColor.GOLD+" with the number of the buff you want to add a point to. (You have "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+".)");
	        	}
	        } else
          if (cmd.getName().equalsIgnoreCase("tele")) {
			  p.sendMessage("Usage: "+ChatColor.RED+"/tele to "+ChatColor.GREEN+" <player>"+ChatColor.WHITE+" - Teleport to a player for a cost.");
          } else
          if (cmd.getName().equalsIgnoreCase("settings")) {
			  Inventory i = Bukkit.createInventory(p, 27, "Notification Options");
			  int count=-1;
			  ItemStack temp,on,off;
			  temp=new ItemStack(Material.DIRT);
			  ItemMeta temp_meta=temp.getItemMeta();temp_meta.setDisplayName(ChatColor.YELLOW+"Pick Up Items");List<String> temp_meta_lore = new ArrayList<String>();temp_meta_lore.add(ChatColor.ITALIC+"Get notified whenever you pick up items.");temp_meta_lore.add(ChatColor.ITALIC+"");temp_meta_lore.add(ChatColor.ITALIC+""+ChatColor.GRAY+"Click to toggle this option on or off.");temp_meta.setLore(temp_meta_lore);temp.setItemMeta(temp_meta);
			  on=new ItemStack(Material.REDSTONE_TORCH_ON);
			  off=new ItemStack(Material.REDSTONE_TORCH_OFF);
			  i.setItem(count+=2, temp);on.setItemMeta(temp_meta);off.setItemMeta(temp_meta); i.setItem(count+=1, (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify1")?on:off));
			  temp_meta.setDisplayName(ChatColor.YELLOW+"Craft Items");temp_meta_lore = new ArrayList<String>();temp_meta_lore.add(ChatColor.ITALIC+"Get notified whenever you craft an item.");temp_meta_lore.add(ChatColor.ITALIC+"");temp_meta_lore.add(ChatColor.ITALIC+""+ChatColor.GRAY+"Click to toggle this option on or off.");temp_meta.setLore(temp_meta_lore);
			  temp=new ItemStack(Material.WORKBENCH);
			  temp.setItemMeta(temp_meta);i.setItem(count+=3, temp);on.setItemMeta(temp_meta);off.setItemMeta(temp_meta); i.setItem(count+=1, (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify2")?on:off));
			  temp_meta.setDisplayName(ChatColor.YELLOW+"Experience Points");temp_meta_lore = new ArrayList<String>();temp_meta_lore.add(ChatColor.ITALIC+"Get notified whenever you gain");temp_meta_lore.add(ChatColor.ITALIC+"experience points.");temp_meta_lore.add(ChatColor.ITALIC+"");temp_meta_lore.add(ChatColor.ITALIC+""+ChatColor.GRAY+"Click to toggle this option on or off.");temp_meta.setLore(temp_meta_lore);
			  temp=new ItemStack(Material.SLIME_BALL);
			  temp.setItemMeta(temp_meta);i.setItem(count+=4, temp);on.setItemMeta(temp_meta);off.setItemMeta(temp_meta); i.setItem(count+=1, (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify3")?on:off));
			  temp_meta.setDisplayName(ChatColor.YELLOW+"Damage Dealt");temp_meta_lore = new ArrayList<String>();temp_meta_lore.add(ChatColor.ITALIC+"Get notified whenever you deal");temp_meta_lore.add(ChatColor.ITALIC+"damage to enemies.");temp_meta_lore.add(ChatColor.ITALIC+"");temp_meta_lore.add(ChatColor.ITALIC+""+ChatColor.GRAY+"Click to toggle this option on or off.");temp_meta.setLore(temp_meta_lore);
			  temp=new ItemStack(Material.IRON_SWORD);
			  temp.setItemMeta(temp_meta);i.setItem(count+=3, temp);on.setItemMeta(temp_meta);off.setItemMeta(temp_meta); i.setItem(count+=1, (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify4")?on:off));
			  temp_meta.setDisplayName(ChatColor.YELLOW+"Damage Received");temp_meta_lore = new ArrayList<String>();temp_meta_lore.add(ChatColor.ITALIC+"Get notified whenever you take damage");temp_meta_lore.add(ChatColor.ITALIC+" from enemies and other sources of damage.");temp_meta_lore.add(ChatColor.ITALIC+"");temp_meta_lore.add(ChatColor.ITALIC+""+ChatColor.GRAY+"Click to toggle this option on or off.");temp_meta.setLore(temp_meta_lore);
			  temp=new ItemStack(Material.IRON_CHESTPLATE);
			  temp.setItemMeta(temp_meta); i.setItem(count+=4, temp);on.setItemMeta(temp_meta);off.setItemMeta(temp_meta); i.setItem(count+=1, (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify5")?on:off));
			  temp_meta.setDisplayName(ChatColor.YELLOW+"Money Gained");temp_meta_lore = new ArrayList<String>();temp_meta_lore.add(ChatColor.ITALIC+"Get notified of how much money you made");temp_meta_lore.add(ChatColor.ITALIC+" from your jobs in the past hour.");temp_meta_lore.add(ChatColor.ITALIC+"");temp_meta_lore.add(ChatColor.ITALIC+""+ChatColor.GRAY+"Click to toggle this option on or off.");temp_meta.setLore(temp_meta_lore);
			  temp=new ItemStack(Material.GOLD_INGOT);
			  temp.setItemMeta(temp_meta);i.setItem(count+=3, temp);on.setItemMeta(temp_meta);off.setItemMeta(temp_meta); i.setItem(count+=1, (this.plugin.getAccountsConfig().getBoolean(p.getName()+".settings.notify6")?on:off));
			  p.openInventory(i);
          } else
          if (cmd.getName().equalsIgnoreCase("event")) {
			  if (p.hasPermission("maintenance-mode-admin")) {
				  p.sendMessage("Events available: halloween. Use: /event <eventname>");
			  }
          } else
          if (cmd.getName().equalsIgnoreCase("maintenance")) {
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
          if (cmd.getName().equalsIgnoreCase("transfer")) {
			  p.sendMessage("Usage: "+ChatColor.RED+"/transfer name money"+ChatColor.WHITE+" - Transfer money to a player.");
          } else
          if (cmd.getName().equalsIgnoreCase("revive")) {
			  p.sendMessage("Usage: "+ChatColor.RED+"/revive me "+ChatColor.WHITE+" - Revive to the last location you died at.");
          } else
          if (cmd.getName().equalsIgnoreCase("unenchant")) {
        	  Map<Enchantment,Integer> map  = p.getItemInHand().getEnchantments();
    		  for (Map.Entry<Enchantment,Integer> entry : map.entrySet()) {
    			  p.getItemInHand().removeEnchantment(entry.getKey());
    		  }
    		  p.sendMessage("Enchantments removed on this item.");
          }
          else
          if (cmd.getName().equalsIgnoreCase("jobs")) {
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
			  p.sendMessage(ChatColor.BLUE+" Farmer ("+config.getInt("jobs.Farmer")+"/"+MAXJOBS+")");
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
            if (cmd.getName().equalsIgnoreCase("event") && args.length==1 && p.hasPermission("maintenance-mode-admin")) {
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
            } else
            if (cmd.getName().equalsIgnoreCase("event") && args.length==2 && p.hasPermission("maintenance-mode-admin")) {
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
            } else
            if (cmd.getName().equalsIgnoreCase("dungeon") && p.hasPermission("maintenance-mode-admin") && args.length==1) {
          	  Dungeon x = new Dungeon(new Location(Bukkit.getWorld("world"),-8990,0,-4),new Location(Bukkit.getWorld("world"),50,255,50),Integer.valueOf(args[0]));
            } else
        	if (cmd.getName().equalsIgnoreCase("transfer") && args.length==1) {
  			  p.sendMessage("Usage: "+ChatColor.RED+"/transfer name money"+ChatColor.WHITE+" - Transfer money to a player.");
        	}
        	else
        	if (cmd.getName().equalsIgnoreCase("transfer") && args.length==2) {
                double amount = Double.parseDouble(args[1].replaceAll("[^0-9\\.]", ""));
                Player target = p.getServer().getPlayer(args[0]);
                if (target == null) {
                  p.sendMessage(this.prefix + " " + this.offlinePlayer);
                }
                else if (target.getName() == p.getName()) {
                  p.sendMessage(this.prefix + " " + this.cmdTransferSameNick);
                }
                else if (amount > playerBankBalance) {
                  p.sendMessage(this.prefix + " " + this.notEnoughMoney);
                } else if (amount <= playerBankBalance) {
                  double totalWithdraw = playerBankBalance - amount;
                  double totalDeposit = amount + this.plugin.getAccountsConfig().getInt(target.getName() + ".money");

                  this.plugin.getAccountsConfig().set(p.getName() + ".money", Double.valueOf(totalWithdraw));
                  this.plugin.getAccountsConfig().set(target.getName() + ".money", Double.valueOf(totalDeposit));
                  this.plugin.saveAccountsConfig();

                  if (amount > 1.0D) {
                    p.sendMessage(this.prefix + " " + this.cmdTransferToPlayer1 + " " + amount + currencyPlural + " " + this.cmdTransferToPlayer2 + " " + target.getName() + "Åòa.");
                    target.sendMessage(this.prefix + " Åòb" + p.getName() + " " + this.cmdTransferToTarget1 + " " + amount + currencyPlural + "Åòa.");
                  } else if (amount <= 1.0D) {
                    p.sendMessage(this.prefix + " " + this.cmdTransferToPlayer1 + " " + amount + currencySingular + " " + this.cmdTransferToPlayer2 + " " + target.getName() + "Åòa.");
                    target.sendMessage(this.prefix + " Åòb" + p.getName() + " " + this.cmdTransferToTarget1 + " " + amount + currencySingular + "Åòa.");
                  }
                }
                  
        	}
        	else
        	if (cmd.getName().equalsIgnoreCase("sp") && args.length==1) {
  			  try {
        		int readvalue = Integer.valueOf(args[0]);
                if (readvalue<=10 && readvalue>=1) {
                	int statpoints = (this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p);
                	if (readvalue==10) {
                		if (statpoints>=6) {
                			this.plugin.getAccountsConfig().set(p.getName()+".stats.stat1", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat1")+6));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to Health Regeneration! "+ChatColor.BLUE+"You now have "+this.plugin.getStatBonus(0, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat1")/6)+" of extra health regeneration! (Every time you regenerate health, you get "+this.plugin.getStatBonus(0, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat1"))+" extra hearts!) "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
            				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 6.)");
                		}
                	} else
                	if (readvalue==9) {
                		if (statpoints>=5) {
                			this.plugin.getAccountsConfig().set(p.getName()+".stats.stat2", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat2")+5));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to block destroying speed! "+ChatColor.BLUE+"You now have "+this.plugin.getStatBonus(1, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat2")/5)+"% block destruction speed! "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 5.)");
                		}
                	} else
                	if (readvalue==8) {
                		if (statpoints>=4) {
                			this.plugin.getAccountsConfig().set(p.getName()+".stats.stat3", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat3")+4));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to block damage reduction! "+ChatColor.BLUE+"You now have "+this.plugin.getStatBonus(2, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat3")/4)+"% of damage taken reduced! "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 4.)");
                		}
                	} else
                	if (readvalue==6) {
                		if (statpoints>=3) {
                			this.plugin.getAccountsConfig().set(p.getName()+".stats.stat4", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat4")+3));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to temporary health! "+ChatColor.BLUE+"You now have "+this.plugin.getStatBonus(3, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat4")/4)+" extra temporary health. (Regenerates every 3 minutes.) "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 3.)");
              			}
                	} else
                	if (readvalue==7) {
                		if (statpoints>=4) {
                			this.plugin.getAccountsConfig().set(p.getName()+".stats.stat5", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")+4));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to armor penetration! "+ChatColor.BLUE+"You now have "+this.plugin.getStatBonus(4, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat5")/4)+" damage of armor penetration. Armor-Wearers will be more afraid of you! "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 4.)");
                		}
                	} else
                	if (readvalue==5) {
                		if (statpoints>=3) {
                			this.plugin.getAccountsConfig().set(p.getName()+".stats.stat6", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat6")+3));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to fire resistance! "+ChatColor.BLUE+"You now have "+this.plugin.getStatBonus(5, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat6")/3)+" seconds of fire resistance when you catch on fire. (Resets when you stop burning) "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 3.)");
                		}
                	} else
                	if (readvalue==4) {
                		if (statpoints>=2) {
                			this.plugin.getAccountsConfig().set(p.getName()+".stats.stat7", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat7")+2));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to base damage! "+ChatColor.BLUE+"You now have +"+this.plugin.getStatBonus(6, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat7")/2)+" base damage. "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 2.)");
                		}
                	} else
                	if (readvalue==3) {
                		if (statpoints>=2) {
                			this.plugin.getAccountsConfig().set(p.getName()+".stats.stat8", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat8")+2));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to base health! "+ChatColor.BLUE+"You now have +"+this.plugin.getStatBonus(7, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat8")/2)+" base health. "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 2.)");
                		}
                	} else
                	if (readvalue==2) {
                		if (statpoints>=1) {
                			this.plugin.getAccountsConfig().set(p.getName()+".stats.stat9", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat9")+1));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to hunger decay! "+ChatColor.BLUE+"You now have "+this.plugin.getStatBonus(8, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat9"))+"% less hunger decay "+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                		} else {
          				  p.sendMessage(ChatColor.RED+"You do not have enough stat points to get that stat! (You need 1.)");
                		}
                	} else
                	if (readvalue==1) {
                		if (statpoints>=1) {
                			this.plugin.getAccountsConfig().set(p.getName()+".stats.stat10", Integer.valueOf(this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat10")+1));
                			this.plugin.saveAccountsConfig();
                			p.sendMessage("You added 1 stat point to water breathing! "+ChatColor.BLUE+"You now have "+this.plugin.getStatBonus(9, this.plugin.getAccountsConfig().getInt(p.getName()+".stats.stat10"))+" seconds of water breathing. "+ChatColor.WHITE+((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))+" stat point"+(((this.plugin.getJobTotalLvs(p)/5+1)-this.plugin.getStatPointTotal(p))==1?"":"s")+" left.");
                			//Increase maximum air by 200 ticks.
                    		p.setMaximumAir(300+this.plugin.getStatBonus(9, this.plugin.getAccountsConfig().getInt(p.getName() + ".stats.stat10"))*20);
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
        else if (cmd.getName().equalsIgnoreCase("bankeconomy") && (args[0].equalsIgnoreCase("info")) && (p.hasPermission("bankeconomy.info"))) {
          if (args.length == 1) {
            if (playerBankBalance <= 1)
              p.sendMessage(this.prefix + " " + this.cmdInfo + " " + playerBankBalance + currencySingular + "Åòa.");
            else if (playerBankBalance > 1)
              p.sendMessage(this.prefix + " " + this.cmdInfo + " " + playerBankBalance + currencyPlural + "Åòa.");
          }
          else
            p.sendMessage(this.invARG);
        }
        else if (cmd.getName().equalsIgnoreCase("bankeconomy") && (args[0].equalsIgnoreCase("check")) && (p.hasPermission("bankeconomy.check"))) {
          if (args.length == 1) {
            p.sendMessage(this.prefix + " " + this.usage + " " + this.cmdCheckARG1);
          } else if (args.length == 2) {
            Player target = p.getServer().getPlayer(args[1]);

            if (target == null) {
              p.sendMessage(this.prefix + " " + this.offlinePlayer);
            } else {
              int targetBalance = this.plugin.getAccountsConfig().getInt(target.getName() + ".money");

              if (targetBalance <= 1)
                p.sendMessage(this.prefix + "Åòa " + target.getName() + this.cmdCheckReponsePlayer + " " + targetBalance + currencySingular);
              else if (targetBalance > 1)
                p.sendMessage(this.prefix + "Åòa " + target.getName() + this.cmdCheckReponsePlayer + " " + targetBalance + currencyPlural);
            }
          }
          else {
            p.sendMessage(this.invARG);
          }
        } else if (cmd.getName().equalsIgnoreCase("bankeconomy") && (args[0].equalsIgnoreCase("reset")) && (p.hasPermission("bankeconomy.reset"))) {
          if (args.length == 1) {
            p.sendMessage(this.prefix + " " + this.usage + " " + this.cmdResetARG1);
          } else if (args.length == 2) {
            Player target = p.getServer().getPlayer(args[1]);

            if (target == null) {
              p.sendMessage(this.prefix + " " + this.offlinePlayer);
            } else {
              this.plugin.getAccountsConfig().set(target.getName() + ".money", Integer.valueOf(0));
              this.plugin.saveAccountsConfig();

              p.sendMessage(this.prefix + " " + this.cmdResetToPlayer1 + " " + target.getName() + this.cmdResetToPlayer2);
              target.sendMessage(this.prefix + " Åòa" + p.getName() + " " + this.cmdResetToTarget);
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
        else if (cmd.getName().equalsIgnoreCase("bankeconomy") && (args[0].equalsIgnoreCase("transfer")) && (p.hasPermission("bankeconomy.transfer"))) {
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
            else if (target.getName() == p.getName()) {
              p.sendMessage(this.prefix + " " + this.cmdTransferSameNick);
            }
            else if (amount > playerBankBalance) {
              p.sendMessage(this.prefix + " " + this.notEnoughMoney);
            } else if (amount <= playerBankBalance) {
              double totalWithdraw = playerBankBalance - amount;
              double totalDeposit = amount + this.plugin.getAccountsConfig().getInt(target.getName() + ".money");

              this.plugin.getAccountsConfig().set(p.getName() + ".money", Double.valueOf(totalWithdraw));
              this.plugin.getAccountsConfig().set(target.getName() + ".money", Double.valueOf(totalDeposit));
              this.plugin.saveAccountsConfig();

              if (amount > 1.0D) {
                p.sendMessage(this.prefix + " " + this.cmdTransferToPlayer1 + " " + amount + currencyPlural + " " + this.cmdTransferToPlayer2 + " " + target.getName() + "Åòa.");
                target.sendMessage(this.prefix + " Åòb" + p.getName() + " " + this.cmdTransferToTarget1 + " " + amount + currencyPlural + "Åòa.");
              } else if (amount <= 1.0D) {
                p.sendMessage(this.prefix + " " + this.cmdTransferToPlayer1 + " " + amount + currencySingular + " " + this.cmdTransferToPlayer2 + " " + target.getName() + "Åòa.");
                target.sendMessage(this.prefix + " Åòb" + p.getName() + " " + this.cmdTransferToTarget1 + " " + amount + currencySingular + "Åòa.");
              }
            }
          }
          else
          {
            p.sendMessage(this.invARG);
          }
        } else if (cmd.getName().equalsIgnoreCase("bankeconomy") && (args[0].equalsIgnoreCase("edit")) && (p.hasPermission("bankeconomy.edit"))) {
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
                this.plugin.getAccountsConfig().set(target.getName() + ".status", Boolean.valueOf(true));
                this.plugin.saveAccountsConfig();

                p.sendMessage(this.prefix + " " + this.cmdEditEnableToPlayer1 + " " + p.getName() + this.cmdEditEnableToPlayer2);
              } else if (amount == 0.0D) {
                this.plugin.getAccountsConfig().set(target.getName() + ".status", Boolean.valueOf(false));
                this.plugin.saveAccountsConfig();

                p.sendMessage(this.prefix + " " + this.cmdEditDisabledToPlayer1 + " " + p.getName() + this.cmdEditDisabledToPlayer2);
              }
            } else if (args[1].equalsIgnoreCase("balance")) {
              this.plugin.getAccountsConfig().set(target.getName() + ".money", Double.valueOf(amount));
              this.plugin.saveAccountsConfig();

              if (amount > 1.0D)
                p.sendMessage(this.prefix + " " + this.cmdEditAmountSetPlayer1 + " Åòb" + amount + currencyPlural + " " + this.cmdEditAmountSetPlayer2 + " " + target.getName() + this.cmdEditAmountSetPlayer3);
              else if (amount <= 1.0D)
                p.sendMessage(this.prefix + " " + this.cmdEditAmountSetPlayer1 + " Åòb" + amount + currencySingular + " " + this.cmdEditAmountSetPlayer2 + " " + target.getName() + this.cmdEditAmountSetPlayer3);
            }
            else {
              p.sendMessage(this.prefix + " " + this.cmdEditAvaibleActions);
            }
          }
          else {
            p.sendMessage(this.invARG);
          }
        } 
      else if (cmd.getName().equalsIgnoreCase("revive") &&  args[0].equalsIgnoreCase("me")) {
          DecimalFormat df = new DecimalFormat("#0.00");
          double deathX = this.plugin.getAccountsConfig().getDouble(p.getName() + ".deathpointX");
          double deathY = this.plugin.getAccountsConfig().getDouble(p.getName() + ".deathpointY");
          double deathZ = this.plugin.getAccountsConfig().getDouble(p.getName() + ".deathpointZ");
          String deathWorld = this.plugin.getAccountsConfig().getString(p.getName() + ".deathworld");
    	  //p.sendMessage("Got 1.");
          if (this.plugin.getAccountsConfig().getBoolean(p.getName() + ".revived")==false && p.getPlayerTime()-this.plugin.getAccountsConfig().getDouble(p.getName() + ".revivetime")<12000) {
        	  double mincost = this.plugin.getConfig().getDouble("revive-cost-rate");
        	  //p.sendMessage("Got 2.");
        	  if (p.getBedSpawnLocation()!=null) {
        		  mincost *= Math.abs(p.getBedSpawnLocation().getX()-deathX)+Math.abs(p.getBedSpawnLocation().getY()-deathY)+Math.abs(p.getBedSpawnLocation().getZ()-deathZ);
        	  } else {
        		  mincost *= Math.abs(p.getWorld().getSpawnLocation().getX()-deathX)+Math.abs(p.getWorld().getSpawnLocation().getY()-deathY)+Math.abs(p.getWorld().getSpawnLocation().getZ()-deathZ);
        	  }
	          double mymoney = this.plugin.getAccountsConfig().getDouble(p.getName() + ".money");
	          double finalcost = (mincost*this.plugin.getConfig().getDouble("revive-cost-rate")) + (mymoney*this.plugin.getConfig().getDouble("revive-cost-tax"));
	          if (this.plugin.PlayerinJob(p, "Explorer") && this.plugin.getJobLv("Explorer", p)>=20) {
	        	  finalcost*=0.25;
	          }
	    	  //p.sendMessage("Got 3.");
	          if (mymoney>=finalcost) {
	        	  this.plugin.getAccountsConfig().set(p.getName() + ".revived", Boolean.valueOf(true));
	        	  this.plugin.getAccountsConfig().set(p.getName() + ".money", mymoney-finalcost);
	        	  this.plugin.getAccountsConfig().set(p.getName() + ".revivetime", Double.valueOf(0.0d));
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
	        	  teleportloc.setY(deathY);
	        	  teleportloc.setZ(deathZ);
	        	  teleportloc.setWorld(Bukkit.getWorld(deathWorld));
	        	  //p.sendMessage("Got 6.");
	        	  p.teleport(teleportloc);
	        	  //p.sendMessage("Got 7.");
	        	  Bukkit.broadcastMessage(ChatColor.GREEN+p.getName()+ChatColor.WHITE+" decided to revive to their death location.");
	          } else {
	        	  p.sendMessage("You cannot revive. You need to have $"+df.format(finalcost)+" to do so.");
	          }
          } else {
        	  p.sendMessage("You haven't died. So you cannot revive.");
          }
          this.plugin.saveAccountsConfig();
          return true;
      } 
      else if (cmd.getName().equalsIgnoreCase("revive") && (args[0].equalsIgnoreCase("amount"))) {
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
          double mymoney = this.plugin.getAccountsConfig().getDouble(p.getName() + ".money");
          double finalcost = (mincost*this.plugin.getConfig().getDouble("revive-cost-rate")) + (mymoney*this.plugin.getConfig().getDouble("revive-cost-tax"));
          if (this.plugin.PlayerinJob(p, "Explorer") && this.plugin.getJobLv("Explorer", p)>=20) {
        	  finalcost*=0.25;
          }
    	  p.sendMessage("You need to have $"+df.format(finalcost)+" to revive.");
          return true;
      }
      else if (cmd.getName().equalsIgnoreCase("tele") && (args[0].equalsIgnoreCase("to"))) {
          DecimalFormat df = new DecimalFormat("#0.00");
    	  if (p.getPlayerTime()-this.plugin.getAccountsConfig().getDouble(p.getName() + ".teletime")<400) {
    		  if (args.length==1) {
        		  p.sendMessage("Usage: "+ChatColor.RED+"/tele to "+ChatColor.GREEN+" <player>"+ChatColor.WHITE+" - Teleport to a player for a cost.");
    		  } else if (args.length==2) {
        		  //Teleport.
		            Player target = p.getServer().getPlayer(args[1]);
		            if (target == null) {
		              p.sendMessage(this.prefix + " " + this.offlinePlayer);
		            } else {
		            	if (target.getName() == this.plugin.getAccountsConfig().getString(p.getName() + ".teleplayer")) {
			            	//Determine distance of player to other player.
			            	double otherx = target.getLocation().getX();
			            	double othery = target.getLocation().getY();
			            	double otherz = target.getLocation().getZ();
			            	double mymoney = this.plugin.getAccountsConfig().getDouble(p.getName() + ".money");
			            	double finalcost = Math.abs(p.getLocation().getX()-otherx)+Math.abs(p.getLocation().getY()-othery)+Math.abs(p.getLocation().getZ()-otherz);
			            	finalcost *= this.plugin.getConfig().getDouble("teleport-cost-rate");
			            	finalcost += mymoney*this.plugin.getConfig().getDouble("teleport-cost-tax");
			            	if (mymoney>=finalcost) {
			            		//Allow teleport to occur.
			  	        	  this.plugin.getAccountsConfig().set(p.getName() + ".money", mymoney-finalcost);
			  	        	  this.plugin.getAccountsConfig().set(p.getName() + ".teletime", Double.valueOf(0.0d));
				        	  this.plugin.saveAccountsConfig();
				        	  if (this.plugin.PlayerinJob(p, "Support")) {
				        		  //Give exp for doing so.
				        		  this.plugin.gainMoneyExp(p,"Support",0,100);
				        	  }
				        	  p.sendMessage("Teleported to "+ChatColor.GREEN+target.getName()+ChatColor.WHITE+" for $"+ChatColor.YELLOW+df.format(finalcost)+ChatColor.WHITE+". New Account balance: $"+df.format(mymoney-finalcost));
				        	  target.sendMessage(ChatColor.GREEN+p.getName()+ChatColor.WHITE+" teleported to your location.");
				        	  p.teleport(target);
			            	} else {
					          p.sendMessage("You need $"+ChatColor.YELLOW+df.format(finalcost)+" in the bank to teleport to "+ChatColor.GREEN+target.getName()+ChatColor.WHITE+"!");
			            	}
		            	} else {
		            		//Setup another player.
			            	//Determine distance of player to other player.
			            	double otherx = target.getLocation().getX();
			            	double othery = target.getLocation().getY();
			            	double otherz = target.getLocation().getZ();
			            	double mymoney = this.plugin.getAccountsConfig().getDouble(p.getName() + ".money");
			            	double finalcost = Math.abs(p.getLocation().getX()-otherx)+Math.abs(p.getLocation().getY()-othery)+Math.abs(p.getLocation().getZ()-otherz);
			            	finalcost *= this.plugin.getConfig().getDouble("teleport-cost-rate");
			            	finalcost += mymoney*this.plugin.getConfig().getDouble("teleport-cost-tax");
			            	if (mymoney>=finalcost) {
			            		//Allow teleport to occur.
						        p.sendMessage("Teleporting to "+ChatColor.GREEN+target.getName()+ChatColor.WHITE+" costs $"+ChatColor.YELLOW+df.format(finalcost)+". Type the command again to teleport.");
				  	        	this.plugin.getAccountsConfig().set(p.getName() + ".teletime", Double.valueOf(p.getPlayerTime()));
				  	        	this.plugin.getAccountsConfig().set(p.getName() + ".teleplayer", String.valueOf(target.getName()));
			            	} else {
						        p.sendMessage("Teleporting to "+ChatColor.GREEN+target.getName()+ChatColor.WHITE+" costs $"+ChatColor.YELLOW+df.format(finalcost)+". You do not have enough in the bank for that.");
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
		              p.sendMessage(this.prefix + " " + this.offlinePlayer);
		            } else {
		            	//Determine distance of player to other player.
		            	double otherx = target.getLocation().getX();
		            	double othery = target.getLocation().getY();
		            	double otherz = target.getLocation().getZ();
		            	double mymoney = this.plugin.getAccountsConfig().getDouble(p.getName() + ".money");
		            	double finalcost = Math.abs(p.getLocation().getX()-otherx)+Math.abs(p.getLocation().getY()-othery)+Math.abs(p.getLocation().getZ()-otherz);
		            	finalcost *= this.plugin.getConfig().getDouble("teleport-cost-rate");
		            	finalcost += mymoney*this.plugin.getConfig().getDouble("teleport-cost-tax");
		            	if (mymoney>=finalcost) {
		            		//Allow teleport to occur.
					        p.sendMessage("Teleporting to "+ChatColor.GREEN+target.getName()+ChatColor.WHITE+" costs $"+ChatColor.YELLOW+df.format(finalcost)+". Type the command again to teleport.");
			  	        	this.plugin.getAccountsConfig().set(p.getName() + ".teletime", Double.valueOf(p.getPlayerTime()));
			  	        	this.plugin.getAccountsConfig().set(p.getName() + ".teleplayer", String.valueOf(target.getName()));
		            	} else {
					        p.sendMessage("Teleporting to "+ChatColor.GREEN+target.getName()+ChatColor.WHITE+" costs $"+ChatColor.YELLOW+df.format(finalcost)+". You do not have enough in the bank for that.");
		            	}
		            }
			  }
    	  }
          return true;
      } else
      if (cmd.getName().equalsIgnoreCase("jobs") && args.length == 1 && args[0].equalsIgnoreCase("info")) {
		  p.sendMessage("Usage: "+ChatColor.GREEN+"/jobs info [JobName]"+ChatColor.WHITE+" - Get information about a job.");
		  p.sendMessage("Usage: "+ChatColor.GREEN+"/jobs info [JobName] "+ChatColor.LIGHT_PURPLE+"[lv]"+ChatColor.WHITE+" - Get information about a job at a certain job level.");
		  p.sendMessage("     Type /jobs to see the jobs.");
      } else
      if (cmd.getName().equalsIgnoreCase("jobs") && args.length == 1 && args[0].equalsIgnoreCase("join")) {
		  p.sendMessage("Usage: "+ChatColor.GREEN+"/jobs join [JobName]"+ChatColor.WHITE+" - Join a job. Type /jobs to see the jobs.");
      } else
      if (cmd.getName().equalsIgnoreCase("jobs") && args.length == 1 && args[0].equalsIgnoreCase("leave")) {
		  p.sendMessage("Usage: "+ChatColor.GREEN+"/jobs leave [JobName]"+ChatColor.WHITE+" - Leave a job. Type /jobs stats to see your jobs.");
      } else
          if (cmd.getName().equalsIgnoreCase("jobs") && args.length == 1 && args[0].equalsIgnoreCase("buffs")) {
    		  p.sendMessage("Usage: "+ChatColor.GREEN+"/jobs buffs [JobName]"+ChatColor.WHITE+" - Get buffs information about a job. Type /jobs to see the jobs.");
          } else
      if (cmd.getName().equalsIgnoreCase("jobs") && args.length == 2 && args[0].equalsIgnoreCase("ultimate")) {
		  //Attempt to join the job.
    	  this.plugin.setUltimate(p,args[1]);
      } else
      if (cmd.getName().equalsIgnoreCase("jobs") && args.length == 2 && args[0].equalsIgnoreCase("join")) {
		  //Attempt to join the job.
    	  this.plugin.joinJob(p,args[1]);
      } else
      if (cmd.getName().equalsIgnoreCase("jobs") && args.length == 2 && args[0].equalsIgnoreCase("leave")) {
		  //Attempt to join the job.
    	  this.plugin.leaveJob(p,args[1]);
      } else
      if (cmd.getName().equalsIgnoreCase("jobs") && (args.length == 2 || args.length==3) && args[0].equalsIgnoreCase("info")) {
    	  JobsDataInfo[] Jobsinfo = {this.plugin.Woodcutter_job,this.plugin.Miner_job,this.plugin.Builder_job,this.plugin.Digger_job,this.plugin.Farmer_job,this.plugin.Hunter_job,this.plugin.Fisherman_job,this.plugin.Weaponsmith_job,this.plugin.Blacksmith_job,this.plugin.Cook_job,this.plugin.Brewer_job,this.plugin.Enchanter_job,this.plugin.Breeder_job,this.plugin.Explorer_job,this.plugin.Support_job};
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
    					  Jobsinfo[i].sendOutput(p,this.plugin.getAccountsConfig().getInt(p.getName()+".jobs.job"+(slot+1)+"lv"));
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
      if (cmd.getName().equalsIgnoreCase("jobs") && (args.length == 2) && args[0].equalsIgnoreCase("buffs")) {
    	  JobsDataInfo[] Jobsinfo = {this.plugin.Woodcutter_job,this.plugin.Miner_job,this.plugin.Builder_job,this.plugin.Digger_job,this.plugin.Farmer_job,this.plugin.Hunter_job,this.plugin.Fisherman_job,this.plugin.Weaponsmith_job,this.plugin.Blacksmith_job,this.plugin.Cook_job,this.plugin.Brewer_job,this.plugin.Enchanter_job,this.plugin.Breeder_job,this.plugin.Explorer_job,this.plugin.Support_job};
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
    		  p.sendMessage(ChatColor.RED+"Lv40 ULTI: "+ChatColor.WHITE+Jobsinfo[slot].lv40buff);
    		  p.sendMessage("");
    		  p.sendMessage(ChatColor.ITALIC+"Note that only one ultimate buff can be chosen. And CANNOT BE CHANGED.");
    	  }
      } else
      if (cmd.getName().equalsIgnoreCase("jobs") && (args.length == 1 || args.length==2) && args[0].equalsIgnoreCase("stats")) {
    	  if (args.length==1) {
    		  //Show your stats.
    		  p.sendMessage("");
    		  p.sendMessage("Your jobs:");
    		  String[] joblist=this.plugin.getJobs(p);
    		  for (int i=0;i<joblist.length;i++) {
    			  if (!joblist[i].equalsIgnoreCase("None")) {
    				  int mylv=this.plugin.getAccountsConfig().getInt(p.getName()+".jobs.job"+(i+1)+"lv");
    				  p.sendMessage("Lv"+mylv+" "+this.plugin.getJobColor(joblist[i])+joblist[i]+ChatColor.WHITE+": "+Math.round(this.plugin.getAccountsConfig().getInt(p.getName()+".jobs.job"+(i+1)+"exp"))+"/"+Math.round(this.plugin.getJobExp(joblist[i], this.plugin.getAccountsConfig().getInt(p.getName()+".jobs.job"+(i+1)+"lv")))+"xp   "+ChatColor.BLUE+(mylv>=5?"+Lv5 Buff":"")+ChatColor.GREEN+(mylv>=10?" +Lv10 Buff":"")+ChatColor.GOLD+(mylv>=20?" +Lv20 Buff":""));if (joblist[i].equalsIgnoreCase("Explorer") && this.plugin.getJobLv(joblist[i], p)>=10) {
    					  //Check to see if the buff is on cooldown for this player or not.
    					  boolean discovered=false;
    					  long timeleft=0;
    					  for (int j=0;j<this.plugin.explorers.size();j++) {
    						  if (this.plugin.explorers.get(j).name.compareToIgnoreCase(p.getName())==0 && this.plugin.explorers.get(j).event==0) {
    							  discovered=true;
    							  timeleft=this.plugin.explorers.get(j).expiretime-Bukkit.getWorld("world").getFullTime();
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
    		  if (p.getServer().getPlayer(args[1])!=null) {
				  //This is the player. Show job stats.
	    		  p.sendMessage("");
	    		  p.sendMessage(p.getServer().getPlayer(args[1]).getName()+"'s jobs:");
	    		  String[] joblist=this.plugin.getJobs(p.getServer().getPlayer(args[1]));
	    		  for (int i=0;i<joblist.length;i++) {
	    			  if (!joblist[i].equalsIgnoreCase("None")) {
	    				  int mylv=this.plugin.getAccountsConfig().getInt(p.getServer().getPlayer(args[1]).getName()+".jobs.job"+(i+1)+"lv");
    					  p.sendMessage("Lv"+mylv+" "+this.plugin.getJobColor(joblist[i])+joblist[i]+ChatColor.WHITE+": "+Math.round(this.plugin.getAccountsConfig().getInt(p.getServer().getPlayer(args[1]).getName()+".jobs.job"+(i+1)+"exp"))+"/"+Math.round(this.plugin.getJobExp(joblist[i], this.plugin.getAccountsConfig().getInt(p.getServer().getPlayer(args[1]).getName()+".jobs.job"+(i+1)+"lv")))+"xp   "+ChatColor.BLUE+(mylv>=5?"+Lv5 Buff":"")+ChatColor.GREEN+(mylv>=10?" +Lv10 Buff":"")+ChatColor.GOLD+(mylv>=20?" +Lv20 Buff":""));
	    				  if (joblist[i].equalsIgnoreCase("Explorer") && this.plugin.getJobLv(joblist[i], p.getServer().getPlayer(args[1]))>=10) {
	    					  //Check to see if the buff is on cooldown for this player or not.
	    					  boolean discovered=false;
	    					  long timeleft=0;
	    					  for (int j=0;j<this.plugin.explorers.size();j++) {
	    						  if (this.plugin.explorers.get(j).name.compareToIgnoreCase(p.getServer().getPlayer(args[1]).getName())==0 && this.plugin.explorers.get(j).event==0) {
	    							  discovered=true;
	    							  timeleft=this.plugin.explorers.get(j).expiretime-Bukkit.getWorld("world").getFullTime();
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
	    		  if (this.plugin.getAccountsConfig().contains(q.getName())) {
	    			  //This player seems to exist. Check out their stats.
		    		  p.sendMessage("");
		    		  p.sendMessage(q.getName()+"'s jobs:");
		    		  String[] joblist=this.plugin.getJobs(q.getName());
		    		  for (int i=0;i<joblist.length;i++) {
		    			  if (!joblist[i].equalsIgnoreCase("None")) {
		    				  int mylv=this.plugin.getAccountsConfig().getInt(q.getName()+".jobs.job"+(i+1)+"lv");
		    				  p.sendMessage("Lv"+mylv+" "+this.plugin.getJobColor(joblist[i])+joblist[i]+ChatColor.WHITE+": "+Math.round(this.plugin.getAccountsConfig().getInt(q.getName()+".jobs.job"+(i+1)+"exp"))+"/"+Math.round(this.plugin.getJobExp(joblist[i], this.plugin.getAccountsConfig().getInt(q.getName()+".jobs.job"+(i+1)+"lv")))+"xp   "+ChatColor.BLUE+(mylv>=5?"+Lv5 Buff":"")+ChatColor.GREEN+(mylv>=10?" +Lv10 Buff":"")+ChatColor.GOLD+(mylv>=20?" +Lv20 Buff":""));
		    			  }
		    			  if (joblist[i].equalsIgnoreCase("Explorer") && this.plugin.getJobLv(joblist[i], q.getName())>=10) {
	    					  //Check to see if the buff is on cooldown for this player or not.
	    					  boolean discovered=false;
	    					  long timeleft=0;
	    					  for (int j=0;j<this.plugin.explorers.size();j++) {
	    						  if (this.plugin.explorers.get(j).name.compareToIgnoreCase(q.getName())==0 && this.plugin.explorers.get(j).event==0) {
	    							  discovered=true;
	    							  timeleft=this.plugin.explorers.get(j).expiretime-Bukkit.getWorld("world").getFullTime();
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
      }
      else {
          p.sendMessage(this.invARGT2);
        }
      }

    }

    return false;
  }
}