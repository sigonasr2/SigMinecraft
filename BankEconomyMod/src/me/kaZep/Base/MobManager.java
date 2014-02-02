package me.kaZep.Base;

import java.util.UUID;

/**
 * The MobManager class handles a certain mob in the game.
 * It will allow you to define new properties for mobs
 * to keep track of. This is similar to the PlayerData
 * class for players.
 */
public class MobManager {
	UUID id;
	long poison_time;
	/**
	 * Adds a new mob to be tracked.
	 * @param id The UUID of the mob.
	 */
	public MobManager(UUID id) {
		this.id=id;
		this.poison_time=Main.SERVER_TICK_TIME;
	}
	/**
	 * If there are already poison ticks on this mob,
	 * adds to the duration in ticks for the poison
	 * to last. Otherwise works just like setPoison().
	 * @param ticks
	 */
	public void addPoison(long ticks) {
		if (poison_time>=Main.SERVER_TICK_TIME) {
			poison_time+=ticks;
		} else {
			setPoison(ticks);
		}
	}
	/**
	 * Sets the poison ticks directly, overwriting
	 * any previous poison tick data.
	 * @param ticks
	 */
	public void setPoison(long ticks) {
		poison_time=Main.SERVER_TICK_TIME+ticks;
	}
	/**
	 * Removes the poison ticks from this mob.
	 */
	public void removePoison() {
		poison_time=Main.SERVER_TICK_TIME;
	}
	/**
	 * Returns the number of ticks of poison
	 * left on this mob.
	 * @return
	 */
	public long getPoisonTicks() {
		if (poison_time>=Main.SERVER_TICK_TIME) {
			return poison_time-Main.SERVER_TICK_TIME;
		} else {
			return 0; //0 ticks, since the stored time is smaller.
		}
	}
}
