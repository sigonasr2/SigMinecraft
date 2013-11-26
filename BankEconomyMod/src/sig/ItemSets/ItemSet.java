package sig.ItemSets;

import org.bukkit.Color;

public class ItemSet {
	String name = ""; //The name of the ItemSet.
	String description = ""; //The description of the ItemSet.
	String[] effectlist = {"","",""};
	ColorSet colors = null;
	public ItemSet(String name, ColorSet colors, String description,
			String effect1, String effect2, String effect3) {
		this.name=name;
		this.colors=colors;
		this.description=description;
		this.effectlist[0]=effect1;
		this.effectlist[1]=effect2;
		this.effectlist[2]=effect3;
	}
	/*
	private static String[] sets = {"Acrobat", "Angel", "Berserker", "Blackguard", "Chilling", "Flaming",
		"Glacial", "Guardian", "Holy", "Meteoric", "Monk", "Nature", "Priest", "Ruby", "Sapphire", "Spiritual",
		"Summoner", "Trickster", "Venomous", "Visionary", "Warrior", "Witch-hunter"}; //Holds all the sets that exist.
	private static ColorSet[] colorsets = { ColorSet(Color.AQUA,Color.AQUA,Color.AQUA,Color.AQUA),
		
	};
	private static ColorSet ColorSet(Color col1, Color col2, Color col3,
			Color col4) {
		return ColorSet(col1,col2,col3,col4);
	}*/
}