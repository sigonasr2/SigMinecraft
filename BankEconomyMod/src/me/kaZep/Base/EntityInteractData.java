package me.kaZep.Base;

import java.util.UUID;

import org.bukkit.Bukkit;

public class EntityInteractData {
	UUID entityid;
	String entityowner;
	long removetime;
	public EntityInteractData(UUID id, String owner) {
		this.entityid=id;
		this.entityowner=owner;
		removetime=Main.SERVER_TICK_TIME+3000;
	}
	public long getTime() {
		return removetime;
	}
	public String getOwner() {
		return entityowner;
	}
	public UUID getID() {
		return entityid;
	}
	public void setOwner(String owner) {
		this.entityowner=owner;
		removetime=Main.SERVER_TICK_TIME+3000;
	}
}
