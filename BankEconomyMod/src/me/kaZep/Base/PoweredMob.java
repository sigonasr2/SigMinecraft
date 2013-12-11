package me.kaZep.Base;

import java.util.UUID;

public class PoweredMob {
	UUID id;
	long power_time;
	public PoweredMob(UUID id, long power_time) {
		this.id=id;
		this.power_time=power_time;
	}
}
