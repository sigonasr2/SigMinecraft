package me.kaZep.Base;

import org.bukkit.Location;

public class TempBlock {
	public Location loc;
	public int timer;
	public TempBlock(Location loc, int timer) {
		this.loc=loc;
		this.timer=timer;
	}
}
