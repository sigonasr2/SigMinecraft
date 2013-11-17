package me.kaZep.Base;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Furnace;

public class FurnaceData {
	
	Location pos;
	String owner;
	long time;
	public FurnaceData(Location pos, String owner) {
		this.pos=pos;
		this.owner=owner;
		this.time=Main.SERVER_TICK_TIME+9000;
	}
	
	public void setOwner(String owner) {
		this.owner=owner;
	}
	
	public short getBurnTime() {
		if ((Furnace)Bukkit.getWorld("world").getBlockAt(pos)!=null) {
			Furnace furnace = (Furnace)Bukkit.getWorld("world").getBlockAt(pos).getState();
			return furnace.getBurnTime();
		} else {
			return 0;
		}
	}
	
	public Location getLoc() {
		return pos;
	}
	
	public long getTime() {
		return time;
	}
	public void resetTime() {
		this.time=Main.SERVER_TICK_TIME+9000;
	}
	
}
