package me.kaZep.Base;

import java.text.DecimalFormat;  

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import me.kaZep.Base.MobHead.MobHeadRareType;
import me.kaZep.Base.MobHead.MobHeadType;
import me.kaZep.Commands.JobsDataInfo.Job;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerBuffData {
	Player p;
	int base_spdlv;
	int base_armorlv;
	List<Player> armorbufflist;
	double base_hplv;
	List<Player> hpbufflist;
	int potion_spdlv;
	long potion_time;
	long hpbuff_time;
	double extra_hp=0;
	double money_gained=0;
	long last_money_report_time=0;
	long last_sneak_time=0;
	public Main plugin;
	
	public String toString() {
		//A method that outputs this class as a string.
		return "PlayerBuffData@{p = "+((p!=null)?p.toString():"null")+", base_spdlv = "+base_spdlv+", base_armorlv = "+base_armorlv+", armorbufflist = "+
		((armorbufflist!=null)?armorbufflist.toString():"null")+", base_hplv = "+base_hplv+", hpbufflist = "+((hpbufflist!=null)?hpbufflist.toString():"null")+
				", potion_spdlv = "+potion_spdlv+", potion_time = "+potion_time+", hpbuff_time = "+
				hpbuff_time+", extra_hp = "+extra_hp+", money_gained = "+money_gained+", last_money_report_time = "+last_money_report_time+"," +
				"plugin = "+((plugin!=null)?plugin.toString():"null")+"}";
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
	
	public PlayerBuffData(Player p, Main thisplugin) {
		this.p=p;
		this.base_spdlv=0;
		this.base_armorlv=0;
		this.hpbuff_time=0;
		this.armorbufflist=new ArrayList<Player>();
		this.hpbufflist=new ArrayList<Player>();
		this.last_money_report_time=Main.SERVER_TICK_TIME;
		this.money_gained=0;
		this.plugin=thisplugin;
		try {
		Iterator<PotionEffect> effects = p.getActivePotionEffects().iterator();
			//Figure out potion effects when player joins.
			while (effects.hasNext()) {
				PotionEffect nexteffect = effects.next();
				if (nexteffect.getType().getName().compareTo(PotionEffectType.SPEED.getName())==0) {
					potion_spdlv = nexteffect.getAmplifier();
					//Bukkit.getLogger().info("Speed level is "+nexteffect.getAmplifier()+" and lasts for "+nexteffect.getDuration()+" ticks.");
					potion_time = Main.SERVER_TICK_TIME+nexteffect.getDuration();
				}
				effects.remove();
			}

	  } catch (ConcurrentModificationException ex_e) {
		  Bukkit.getLogger().warning("Potion Effect Collection not accessible while initializing player speed.");
	  }
	p.removePotionEffect(PotionEffectType.SPEED);
	}
	public void setBaseSpd(int spd) {
		this.base_spdlv=spd;
	}
	public void updateBaseArmor() {


	}
	public void updatePlayerSpd() {
		if (!p.isDead()) { //Don't even try to set things if we're dead.
			base_hplv=20;
			base_hplv+=hpbufflist.size()*10;
			if (this.plugin.hasJobBuff("Hunter", p, Job.JOB40)) {
				base_hplv+=20;
			}
			if (this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat8")>0) {
				base_hplv+=this.plugin.getStatBonus(7, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat8")/2);
			}
			//Check player equipment to see if an item could possibly have a health buff.
			for (int i=0;i<p.getEquipment().getArmorContents().length;i++) {
				//Bukkit.getLogger().info("Got to 1.");
				if (p.getEquipment().getArmorContents()[i]!=null && !this.plugin.isBroken(p.getEquipment().getArmorContents()[i]) && p.getEquipment().getArmorContents()[i].getItemMeta()!=null && p.getEquipment().getArmorContents()[i].getItemMeta().getLore()!=null) {
					//Bukkit.getLogger().info("Got to 2.");
					for (int j=0;j<p.getEquipment().getArmorContents()[i].getItemMeta().getLore().size();j++) {
						//Bukkit.getLogger().info("Got to 3.");
						if (this.plugin.containsEnchantment(p.getEquipment().getArmorContents()[i].getItemMeta().getLore().get(j), "Health")) {
							//Bukkit.getLogger().info("Got to 4.");
							base_hplv+=this.plugin.getEnchantmentNumb(p.getEquipment().getArmorContents()[i].getItemMeta().getLore().get(j));
						}
					}
				}
			}
			if (p.getInventory()!=null) {
				List<MobHead> playerheads = this.plugin.getMobHeads(p);
				int zombierarebheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ZOMBIE,true,MobHeadRareType.RARE_TYPE_B), playerheads);
				int zombiepoweredheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ZOMBIE,false,true), playerheads);
				int zombiepoweredrareheads = this.plugin.getMobHeadAmt(new MobHead(MobHeadType.ZOMBIE,true,true), playerheads);
				//Bukkit.getLogger().info("Base Health is "+base_hplv+".");
				base_hplv+=zombierarebheads;
				base_hplv+=zombiepoweredheads;
				base_hplv+=zombiepoweredrareheads*4;
				//Bukkit.getLogger().info("Base Health is "+base_hplv+".");
			}
			extra_hp=0;
			//p.setMaxHealth(base_hplv);
			boolean hasabsorption=false;
			try {
				Iterator<PotionEffect> effects = p.getActivePotionEffects().iterator();
				//Figure out potion effects when player joins.
				while (effects.hasNext()) {
					PotionEffect nexteffect = effects.next();
					if (nexteffect.getType().getName().compareTo(PotionEffectType.HEALTH_BOOST.getName())==0) {
						base_hplv+=(nexteffect.getAmplifier()+1)*4;
						extra_hp=(nexteffect.getAmplifier()+1)*4;
					}
					if (nexteffect.getType().getName().compareTo(PotionEffectType.ABSORPTION.getName())==0) {
						hasabsorption=true;
					}
					effects.remove();
				}
				
			  } catch (ConcurrentModificationException ex_e) {
				  Bukkit.getLogger().warning("Potion Effect Collection not accessible while finalizing player speed.");
			  }
			if (!hasabsorption && this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat4")>0) {
				p.removePotionEffect(PotionEffectType.ABSORPTION);
				p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION,3600,this.plugin.getStatBonus(3, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat4")/3)/4-1),true);
				//p.sendMessage("Absorption level is "+(this.plugin.getStatBonus(3, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat4")/4)/4-1));
			}
			if (this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat2")>0) {
				p.removePotionEffect(PotionEffectType.FAST_DIGGING);
				p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,399,this.plugin.getStatBonus(1, this.plugin.getAccountsConfig().getInt(p.getName().toLowerCase()+".stats.stat2")/5)/20-1));
			}
			if (p.getHealth()>p.getMaxHealth()) {
				p.setHealth(p.getMaxHealth());
			}
			
			//Bukkit.getLogger().info("Base hp level: "+base_hplv+" Max Health: "+p.getMaxHealth());
			if (base_hplv!=p.getMaxHealth()) {
				double temphp=0;
				temphp = p.getHealth();
				p.setMaxHealth(base_hplv-extra_hp);
				if (temphp>p.getMaxHealth()) {
					p.setHealth(p.getMaxHealth());
				} else {
					p.setHealth(temphp);
				}
			}
			
			//Send new speed totals so the player's speed can be manually adjusted.
			if (potion_spdlv>0 && potion_time<Main.SERVER_TICK_TIME) {
				//Remove the potion speed buff.
				potion_spdlv=0;
			}
			try {
				Iterator<PotionEffect> effects = p.getActivePotionEffects().iterator();
				//Figure out potion effects when player joins.
				while (effects.hasNext()) {
					PotionEffect nexteffect = effects.next();
					/*
					if (nexteffect.getType().getName().compareTo(PotionEffectType.INCREASE_DAMAGE.getName())==0) {
						if (nexteffect.getAmplifier()>0) {
							p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
							p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,nexteffect.getDuration()*4,0));
						}
					}*/
					if (nexteffect.getType().getName().compareTo(PotionEffectType.SPEED.getName())==0) {
						if (nexteffect.getDuration()<47479999) {
							//This is not a buff we applied via our plugin.
							potion_spdlv+=nexteffect.getAmplifier()+1;
							//p.sendMessage("Store speed "+nexteffect.getAmplifier()+" for "+nexteffect.getDuration()+" ticks.");
							potion_time = Main.SERVER_TICK_TIME+nexteffect.getDuration();
						}
					}
					effects.remove();
				}
				if (hpbuff_time<Main.SERVER_TICK_TIME) {
					while (hpbufflist.size()>0) {
						hpbufflist.remove(0);
					}
				}
				
			  } catch (ConcurrentModificationException ex_e) {
				  Bukkit.getLogger().warning("Potion Effect Collection not accessible while finalizing player speed.");
			  }
	
			p.removePotionEffect(PotionEffectType.SPEED);
			if ((base_spdlv+potion_spdlv)>0) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2147479999, base_spdlv-1+potion_spdlv, true));
			}
			if (last_money_report_time+72000<Main.SERVER_TICK_TIME) {
				last_money_report_time=Main.SERVER_TICK_TIME;
				if (this.plugin.getAccountsConfig().getBoolean(p.getName().toLowerCase()+".settings.notify6")) {
				    DecimalFormat df = new DecimalFormat("#0.00");
					//p.sendMessage(ChatColor.YELLOW+""+ChatColor.ITALIC+"You have earned $"+df.format(money_gained)+" from your jobs in the past hour.");
				}
				money_gained=0;
			}
			p.getScoreboard().getTeam(p.getName().toLowerCase()).setSuffix(healthbar(p.getHealth(),p.getMaxHealth(),p.getFoodLevel()));
		} else {
			base_hplv=20;
			p.setMaxHealth(base_hplv);
		}
	}
}
