package me.kaZep.Base;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class ArrowShooter {
	public int timer=0;
	public int frequency=0;
	public Vector spd;
	public Location loc;
	public LivingEntity shooter;
	public ArrowShooter(Vector spd, Location loc, int duration, int frequency, LivingEntity shooter) {
		this.spd=spd;
		this.loc=loc;
		this.frequency=frequency;
		this.timer=duration;
		this.shooter=shooter;
	}
}
