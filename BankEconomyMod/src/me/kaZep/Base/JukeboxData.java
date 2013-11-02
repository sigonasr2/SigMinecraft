package me.kaZep.Base;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Jukebox;
import org.bukkit.entity.Player;

public class JukeboxData {
	Block jukebox;
	Material disk;
	int repeat;
	int songduration;
	long songtickstart;
	double closestplayer=0;
	public JukeboxData(Block box, Material disk, int loopamount, int duration, long currenttime) {
		this.jukebox=box;
		this.disk=disk;
		this.repeat=loopamount;
		this.songduration=duration;
		this.songtickstart=currenttime;
	}
	public boolean Restart() {
		this.songtickstart=Bukkit.getWorld("world").getFullTime();
		if (jukebox!=null) {
			((Jukebox)jukebox.getState()).setPlaying(disk);
		} else {
			this.repeat=0;
		}
		this.repeat--;
		if (this.repeat<=0) {
			return false;
		} else {
			return true;
		}
	}
	public void updateClosestPlayer() {
      closestplayer=999999999;
	  List<Player> onlineplayers = Bukkit.getWorld("world").getPlayers();
	  for (int k=0;k<onlineplayers.size();k++) {
		  double distance=Math.abs(jukebox.getX()-onlineplayers.get(k).getLocation().getX())+Math.abs(jukebox.getY()-onlineplayers.get(k).getLocation().getY())+Math.abs(jukebox.getZ()-onlineplayers.get(k).getLocation().getZ());
		  if (distance<closestplayer) {
			  closestplayer=distance;
		  }
	  }
	}
	public void setDisk(Material newdisk) {
		this.disk=newdisk;
		this.repeat=100;
	}
	public Material getDisk() {
		return disk;
	}
	public double getClosestPlayer() {
		return closestplayer;
	}
	public long getSongStart() {
		return songtickstart;
	}
	public int getSongDuration() {
		return songduration;
	}
	public int getRepeatsRemaining() {
		return this.repeat;
	}
	public Block getJukebox() {
		if (jukebox!=null) {
			return jukebox;
		} else {
			return null;
		}
	}
}
