package me.kaZep.Base;

import org.bukkit.Bukkit;

public class PersistentExplorerList {
	public String name;
	public long expiretime;
	public int event;
	public float data;
	public float data2;
	//Event 0: Player used up their "second chance" life. 1 hour wait time.
	//Event 1: Stores the EXP value of a player who died. 
	//Event 2: Simply says if this player has died recently or not.
	public PersistentExplorerList(String name) {
		this.name=name;
		this.expiretime=Bukkit.getWorld("world").getFullTime()+36000;
	}
}
