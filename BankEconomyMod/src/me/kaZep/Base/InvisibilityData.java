package me.kaZep.Base;

import java.util.UUID;

public class InvisibilityData {
	public UUID val = null;
	public long resettime = 0;
	public InvisibilityData(UUID id, long resettime) {
		this.val=id;
		this.resettime=resettime;
	}
}
