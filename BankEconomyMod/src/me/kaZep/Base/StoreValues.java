package me.kaZep.Base;

import org.bukkit.enchantments.Enchantment;

public class StoreValues {
	double chance;
	Enchantment enchant;
	int level;
	int enchantlevel;
	StoreValues(double chance, Enchantment enchant,int level,int enchantlevel) {
		this.chance=chance;
		this.enchant=enchant;
		this.level=level;
		this.enchantlevel=enchantlevel;
	}
}