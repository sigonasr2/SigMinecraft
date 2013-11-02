package me.kaZep.Base;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BrewingStand;
import org.bukkit.block.Furnace;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class BrewingStandData {
	
	Location pos;
	String owner;
	long time;
	boolean setnewtime;
	public BrewingStandData(Location pos, String owner) {
		this.pos=pos;
		this.owner=owner;
		this.time=Bukkit.getWorld("world").getFullTime()+9000;
		this.setnewtime=false;
	}
	
	public void setOwner(String owner) {
		this.owner=owner;
	}
	
	public void setBrewingTime(int newval) {
		if ((BrewingStand)Bukkit.getWorld("world").getBlockAt(pos).getState()!=null) {
			BrewingStand brewingstand = (BrewingStand)Bukkit.getWorld("world").getBlockAt(pos).getState();
			brewingstand.setBrewingTime(newval);
		}
	}
	
	public int getBrewingTime() {
		if ((BrewingStand)Bukkit.getWorld("world").getBlockAt(pos).getState()!=null) {
			BrewingStand brewingstand = (BrewingStand)Bukkit.getWorld("world").getBlockAt(pos).getState();
			return brewingstand.getBrewingTime();
		} else {
			return 0;
		}
	}
	
	public int getBrewingPotions() {
		if ((BrewingStand)Bukkit.getWorld("world").getBlockAt(pos).getState()!=null) {
			BrewingStand brewingstand = (BrewingStand)Bukkit.getWorld("world").getBlockAt(pos).getState();
			ItemStack[] b = brewingstand.getInventory().getContents();
			int potioncount=0;
			for (int i=0;i<b.length;i++) {
				if (b[i]!=null &&
						b[i].getType()!=Material.SUGAR &&
						b[i].getType()!=Material.SPIDER_EYE &&
						b[i].getType()!=Material.REDSTONE &&
						b[i].getType()!=Material.GLOWSTONE_DUST &&
						b[i].getType()!=Material.SULPHUR &&
						b[i].getType()!=Material.FERMENTED_SPIDER_EYE &&
						b[i].getType()!=Material.SPECKLED_MELON &&
						b[i].getType()!=Material.NETHER_WARTS &&
						b[i].getType()!=Material.GOLDEN_CARROT &&
						b[i].getType()!=Material.BLAZE_POWDER &&
						b[i].getType()!=Material.MAGMA_CREAM &&
						b[i].getType()!=Material.GHAST_TEAR) {
					potioncount++;
				}
			}
			return potioncount;
		} else {
			return 0;
		}
	}
	
	public boolean arePotionsValid() {
		//We are not allowed to brew Potions of Night Vision or Invisibility. If we have one of those in the slot, we have to cancel it.
		if ((BrewingStand)Bukkit.getWorld("world").getBlockAt(pos).getState()!=null) {
			BrewingStand brewingstand = (BrewingStand)Bukkit.getWorld("world").getBlockAt(pos).getState();
			if (brewingstand.getInventory().getIngredient().getType()==Material.GOLDEN_CARROT) {
				return false;
			}
		}
		return true; 
	}
	
	public Location getLoc() {
		return pos;
	}
	
	public boolean is_newTimeSet() {
		return setnewtime;
	}
	
	public void set_newTime(boolean set) {
		this.setnewtime=set;
	}
	
	public long getTime() {
		return time;
	}
	public void resetTime() {
		this.time=Bukkit.getWorld("world").getFullTime()+9000;
	}
	
}
