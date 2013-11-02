package me.kaZep.Base;

import org.bukkit.Bukkit;
import org.bukkit.Material;

public class ExplorerData {
	String player;
	double xprevious,zprevious;
	double xlookprevious,zlookprevious;
	Material lasttype;
	Material lastinteract, awardinteract;
	int villagecriteria,templecriteria,cavecriteria,undergroundcriteria,nethercriteria;
	int lastmap;
	int lastmapemptycount;
	float expamt;
	int explv;
	boolean wedied;
	public ExplorerData(String playername, double xpos, double zpos) {
		this.player=playername;
		this.xprevious=xpos;
		this.zprevious=zpos;
		this.xlookprevious=xpos;
		this.zlookprevious=zpos;
		lasttype=Material.DIRT;
		lastinteract=Material.DIRT;
		awardinteract=Material.DIRT;
		villagecriteria=100;
		templecriteria=100;
		cavecriteria=100;
		undergroundcriteria=100;
		nethercriteria=100;
		this.expamt=Bukkit.getPlayer(playername).getExp();
		this.explv=Bukkit.getPlayer(playername).getLevel();
		this.wedied=false;
	}
}
