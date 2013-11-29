package me.kaZep.Base;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class ArrowShooter {
	public int timer=0;
	public int frequency=0;
	public Vector dir;
	public Location loc;
	public LivingEntity shooter;
	public float spd = 0.6f;
	public float spread = 12f;
	public ArrowShooter(Vector dir, Location loc, int duration, int frequency, LivingEntity shooter) {
		this(dir, loc, duration, frequency, shooter, 0.6f, 12f);
	}
	public ArrowShooter(Vector dir, Location loc, int duration, int frequency, LivingEntity shooter, float spd, float spread) {
		this.dir=dir;
		this.loc=loc;
		this.frequency=frequency;
		this.timer=duration;
		this.shooter=shooter;
		this.spd=spd;
		this.spread=spread;
	}
}
