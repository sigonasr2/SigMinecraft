package me.kaZep.Base;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class PlayerData {
	int buildamt=10;
	Material lastblocktype=null;
	long lastinteracttime=0;
	long lastminetime=0;
	long lastsneaktime=0;
	int minestreak=0;
	boolean haslanded=true;
	int blockstack=0; //The amount of times you've gotten hit (The amount of "blocking" stacks you now have)
	int fishingstreak=0;
	int fishingrodfails=0; //The amount of times in a row you've failed to catch fish.
	long fishingroduse=Main.SERVER_TICK_TIME; //The last time you threw the fishing rod in the water.
	double fishingrodcatchrate = 0.002; //The current chance of catching a fish.
	Location clickedblock1=null; //Stores the location of a clicked block.
	Player data=null;
	long lastflighttime=0;
	public PlayerData(Player p) {
		this.data=p;
		this.lastblocktype=Material.DIRT;
		lastinteracttime=
				lastminetime=
				lastflighttime=Main.SERVER_TICK_TIME;
		minestreak=0;
	}
	public boolean CheckMineStreak() {
		//Increases mining streak by one if the miner hasn't stopped mining for more than 10 seconds.
		//Resets when the miner hasn't mined for 10 seconds.
		//If it reaches 10 blocks, we assume the miner is mining, and we need to do something about it.
		//Attempt to spawn Charge Zombie II's in rooms that are unlit.
		if (Main.SERVER_TICK_TIME>lastminetime+200) {
			//Reset. Too much time has passed.
			lastminetime=Main.SERVER_TICK_TIME;
			minestreak=0;
		} else {
			minestreak++;
			lastminetime=Main.SERVER_TICK_TIME;
			if (minestreak>10) {
				minestreak=0;
				return true;
			}
		}
		return false;
	}
	public boolean GoodInteract() {
		//A good interact is doing their part of the job.
		buildamt--;
		if (buildamt<=0) {
			buildamt=0;
			return true;
		} else {
			if (buildamt>100) {
				buildamt=100; //This is the upper bound of this value.
			}
			return false;
		}
		//Use this whenever you do a good interaction. Check the return value to see if we are allowed to gain exp from it.
	}
	public void BadInteract(Material blockType) {
		//This method will add to the list of blocks created/destroyed, in an attempt to detect any further attempts to not be allowed to destroy things.
		//This event should be called whenever a bad interaction happens.
		if (blockType!=this.lastblocktype) {
			//We are interacting with a different type of block. Give more lee-way for this block.
			buildamt+=1;
			this.lastblocktype=blockType;
		} else {
			//This is a block type we are dealing with from beforehand. We will need to add more to buildamt to  make sure we are not cheating the system.
			buildamt+=2;
		}
	}
	public void SetClickedBlock(Location l) {
		clickedblock1 = l;
	}
	public Location GetClickedBlock() {
		return clickedblock1;
	}
	public Player getPlayer() {
		return data;
	}
}
