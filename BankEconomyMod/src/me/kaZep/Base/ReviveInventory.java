package me.kaZep.Base;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ReviveInventory {
	public ItemStack[] mainInventory;
	public ItemStack[] armorInventory;
	public float expamt;
	public float explv;
	public long dropTime;
	public Player p;
	public Location deathLocation;
	public ReviveInventory(Player p) {
		mainInventory = p.getInventory().getContents();
		armorInventory = p.getInventory().getArmorContents();
		expamt = p.getExp();
		explv = p.getLevel();
		dropTime = Main.SERVER_TICK_TIME+12000;
		deathLocation = p.getLocation();
	}
}
