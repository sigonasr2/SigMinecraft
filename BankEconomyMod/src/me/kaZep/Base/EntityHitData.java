package me.kaZep.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class EntityHitData {
	public List<UUID> id;
	Player p;
	public long registeredtime;
	public EntityHitData(Player p) {
		this.p=p;
		id = new ArrayList<UUID>();
		registeredtime = Main.SERVER_TICK_TIME+1200;
	}
	public List<UUID> getEntities() {
		return id;
	}
	public Player getPlayer() {
		return p;
	}
}
