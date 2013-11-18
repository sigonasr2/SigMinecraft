package me.kaZep.Base;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.enchantments.Enchantment;


public class EnchantLevelDatabase {
	public List<StoreValues> stone_hoe = new ArrayList<StoreValues>();
	public List<StoreValues> stone_shovel = new ArrayList<StoreValues>();
	public List<StoreValues> stone_pickaxe = new ArrayList<StoreValues>();
	public List<StoreValues> leather_boots = new ArrayList<StoreValues>();
	public List<StoreValues> leather_cap = new ArrayList<StoreValues>();
	public List<StoreValues> leather_pants = new ArrayList<StoreValues>();
	public List<StoreValues> leather_tunic = new ArrayList<StoreValues>();
	public List<StoreValues> iron_shovel = new ArrayList<StoreValues>();
	public List<StoreValues> iron_axe = new ArrayList<StoreValues>();
	public List<StoreValues> iron_boots = new ArrayList<StoreValues>();
	public List<StoreValues> iron_pickaxe = new ArrayList<StoreValues>();
	public List<StoreValues> iron_helmet = new ArrayList<StoreValues>();
	public List<StoreValues> golden_shovel = new ArrayList<StoreValues>();
	public List<StoreValues> golden_axe = new ArrayList<StoreValues>();
	public List<StoreValues> iron_leggings = new ArrayList<StoreValues>();
	public List<StoreValues> diamond_shovel = new ArrayList<StoreValues>();
	public List<StoreValues> diamond_axe = new ArrayList<StoreValues>();
	public List<StoreValues> diamond_hoe = new ArrayList<StoreValues>();
	public List<StoreValues> golden_boots = new ArrayList<StoreValues>();
	public List<StoreValues> iron_chestplate = new ArrayList<StoreValues>();
	public List<StoreValues> golden_helmet = new ArrayList<StoreValues>();
	public List<StoreValues> diamond_pickaxe = new ArrayList<StoreValues>();
	public List<StoreValues> diamond_boots = new ArrayList<StoreValues>();
	public List<StoreValues> golden_leggings = new ArrayList<StoreValues>();
	public List<StoreValues> golden_chestplate = new ArrayList<StoreValues>();
	public List<StoreValues> diamond_helmet = new ArrayList<StoreValues>();
	public List<StoreValues> diamond_leggings = new ArrayList<StoreValues>();
	public List<StoreValues> diamond_chestplate = new ArrayList<StoreValues>();
	public List<StoreValues> wood_sword = new ArrayList<StoreValues>();
	public List<StoreValues> bow = new ArrayList<StoreValues>();
	public List<StoreValues> iron_sword = new ArrayList<StoreValues>();
	public List<StoreValues> gold_sword = new ArrayList<StoreValues>();
	public List<StoreValues> diamond_sword = new ArrayList<StoreValues>();
	public List<StoreValues> chain_helmet = new ArrayList<StoreValues>();;
	public List<StoreValues> chain_chestplate = new ArrayList<StoreValues>();;
	public List<StoreValues> chain_leggings = new ArrayList<StoreValues>();;
	public List<StoreValues> chain_boots = new ArrayList<StoreValues>();;
	public EnchantLevelDatabase() {
		stone_hoe.add(new StoreValues(0.359,Enchantment.DURABILITY,1,5));
		stone_shovel.add(new StoreValues(0.636,Enchantment.DIG_SPEED,1,5));
		stone_shovel.add(new StoreValues(0.359,Enchantment.DURABILITY,1,5));
		stone_pickaxe.add(new StoreValues(0.636,Enchantment.DIG_SPEED,1,5));
		stone_pickaxe.add(new StoreValues(0.359,Enchantment.DURABILITY,1,5)); // OOPS ^.^
		leather_boots.add(new StoreValues(0.359,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		leather_boots.add(new StoreValues(0.212,Enchantment.PROTECTION_FALL,1,5));
		leather_boots.add(new StoreValues(0.113,Enchantment.PROTECTION_PROJECTILE,2,5));
		leather_boots.add(new StoreValues(0.084,Enchantment.PROTECTION_PROJECTILE,1,5));
		leather_boots.add(new StoreValues(0.081,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		leather_boots.add(new StoreValues(0.065,Enchantment.PROTECTION_FIRE,1,5));
		leather_boots.add(new StoreValues(0.052,Enchantment.PROTECTION_FALL,2,5));
		leather_boots.add(new StoreValues(0.025,Enchantment.PROTECTION_ENVIRONMENTAL,2,5));
		leather_boots.add(new StoreValues(0.001,Enchantment.PROTECTION_EXPLOSIONS,2,5));
		leather_cap.add(new StoreValues(0.405,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		leather_cap.add(new StoreValues(0.146,Enchantment.WATER_WORKER,1,5));
		leather_cap.add(new StoreValues(0.119,Enchantment.PROTECTION_PROJECTILE,2,5));
		leather_cap.add(new StoreValues(0.094,Enchantment.PROTECTION_PROJECTILE,1,5));
		leather_cap.add(new StoreValues(0.082,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		leather_cap.add(new StoreValues(0.069,Enchantment.PROTECTION_FIRE,1,5));
		leather_cap.add(new StoreValues(0.048,Enchantment.OXYGEN,1,5));
		leather_cap.add(new StoreValues(0.029,Enchantment.PROTECTION_ENVIRONMENTAL,2,5));
		leather_cap.add(new StoreValues(0.0001,Enchantment.PROTECTION_EXPLOSIONS,2,5));
		leather_pants.add(new StoreValues(0.451,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		leather_pants.add(new StoreValues(0.135,Enchantment.PROTECTION_PROJECTILE,2,5));
		leather_pants.add(new StoreValues(0.104,Enchantment.PROTECTION_PROJECTILE,1,5));
		leather_pants.add(new StoreValues(0.100,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		leather_pants.add(new StoreValues(0.079,Enchantment.PROTECTION_FIRE,1,5));
		leather_pants.add(new StoreValues(0.032,Enchantment.PROTECTION_ENVIRONMENTAL,2,5));
		leather_pants.add(new StoreValues(0.0001,Enchantment.PROTECTION_EXPLOSIONS,2,5));
		leather_tunic.add(new StoreValues(0.442,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		leather_tunic.add(new StoreValues(0.140,Enchantment.PROTECTION_PROJECTILE,2,5));
		leather_tunic.add(new StoreValues(0.102,Enchantment.PROTECTION_PROJECTILE,1,5));
		leather_tunic.add(new StoreValues(0.094,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		leather_tunic.add(new StoreValues(0.079,Enchantment.PROTECTION_FIRE,1,5));
		leather_tunic.add(new StoreValues(0.053,Enchantment.THORNS,1,5));
		leather_tunic.add(new StoreValues(0.028,Enchantment.PROTECTION_ENVIRONMENTAL,2,5));
		leather_tunic.add(new StoreValues(0.001,Enchantment.PROTECTION_EXPLOSIONS,2,5));
		iron_shovel.add(new StoreValues(0.506,Enchantment.DIG_SPEED,1,5));
		iron_shovel.add(new StoreValues(0.355,Enchantment.DURABILITY,1,5));
		iron_shovel.add(new StoreValues(0.126,Enchantment.DIG_SPEED,2,5));
		iron_shovel.add(new StoreValues(0.06,Enchantment.DURABILITY,2,5));
		iron_axe.add(new StoreValues(0.506,Enchantment.DIG_SPEED,1,5));
		iron_axe.add(new StoreValues(0.355,Enchantment.DURABILITY,1,5));
		iron_axe.add(new StoreValues(0.126,Enchantment.DIG_SPEED,2,5));
		iron_axe.add(new StoreValues(0.06,Enchantment.DURABILITY,2,5));
		iron_boots.add(new StoreValues(0.41,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		iron_boots.add(new StoreValues(0.265,Enchantment.PROTECTION_FALL,1,5));
		iron_boots.add(new StoreValues(0.143,Enchantment.PROTECTION_PROJECTILE,1,5));
		iron_boots.add(new StoreValues(0.082,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		iron_boots.add(new StoreValues(0.065,Enchantment.PROTECTION_PROJECTILE,2,5));
		iron_boots.add(new StoreValues(0.022,Enchantment.PROTECTION_FIRE,1,5));
		iron_boots.add(new StoreValues(0.006,Enchantment.PROTECTION_FALL,2,5));
		iron_pickaxe.add(new StoreValues(0.504,Enchantment.DIG_SPEED,1,5));
		iron_pickaxe.add(new StoreValues(0.354,Enchantment.DURABILITY,1,5));
		iron_pickaxe.add(new StoreValues(0.129,Enchantment.DIG_SPEED,2,5));
		iron_pickaxe.add(new StoreValues(0.06,Enchantment.DURABILITY,2,5));
		iron_helmet.add(new StoreValues(0.471,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		iron_helmet.add(new StoreValues(0.161,Enchantment.WATER_WORKER,1,5));
		iron_helmet.add(new StoreValues(0.16,Enchantment.PROTECTION_PROJECTILE,1,5));
		iron_helmet.add(new StoreValues(0.092,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		iron_helmet.add(new StoreValues(0.072,Enchantment.PROTECTION_PROJECTILE,2,5));
		iron_helmet.add(new StoreValues(0.022,Enchantment.PROTECTION_FIRE,1,5));
		iron_helmet.add(new StoreValues(0.015,Enchantment.OXYGEN,1,5));
		golden_shovel.add(new StoreValues(0.364,Enchantment.DIG_SPEED,2,5));
		golden_shovel.add(new StoreValues(0.256,Enchantment.DIG_SPEED,1,5));
		golden_shovel.add(new StoreValues(0.253,Enchantment.DURABILITY,1,5));
		golden_shovel.add(new StoreValues(0.101,Enchantment.DURABILITY,2,5));
		golden_shovel.add(new StoreValues(0.01,Enchantment.LOOT_BONUS_BLOCKS,1,5));
		golden_shovel.add(new StoreValues(0.006,Enchantment.SILK_TOUCH,1,5));
		golden_axe.add(new StoreValues(0.364,Enchantment.DIG_SPEED,2,5));
		golden_axe.add(new StoreValues(0.256,Enchantment.DIG_SPEED,1,5));
		golden_axe.add(new StoreValues(0.253,Enchantment.DURABILITY,1,5));
		golden_axe.add(new StoreValues(0.101,Enchantment.DURABILITY,2,5));
		golden_axe.add(new StoreValues(0.01,Enchantment.LOOT_BONUS_BLOCKS,1,5));
		golden_axe.add(new StoreValues(0.006,Enchantment.SILK_TOUCH,1,5));
		iron_leggings.add(new StoreValues(0.523,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		iron_leggings.add(new StoreValues(0.178,Enchantment.PROTECTION_PROJECTILE,1,5));
		iron_leggings.add(new StoreValues(0.101,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		iron_leggings.add(new StoreValues(0.083,Enchantment.PROTECTION_PROJECTILE,2,5));
		iron_leggings.add(new StoreValues(0.025,Enchantment.PROTECTION_FIRE,1,5));
		diamond_shovel.add(new StoreValues(0.623,Enchantment.DIG_SPEED,1,5));
		diamond_shovel.add(new StoreValues(0.356,Enchantment.DURABILITY,1,5));
		diamond_shovel.add(new StoreValues(0.014,Enchantment.DIG_SPEED,2,5));
		diamond_axe.add(new StoreValues(0.623,Enchantment.DIG_SPEED,1,5));
		diamond_axe.add(new StoreValues(0.356,Enchantment.DURABILITY,1,5));
		diamond_axe.add(new StoreValues(0.014,Enchantment.DIG_SPEED,2,5));
		golden_boots.add(new StoreValues(0.187,Enchantment.PROTECTION_ENVIRONMENTAL,2,5));
		golden_boots.add(new StoreValues(0.158,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		golden_boots.add(new StoreValues(0.155,Enchantment.PROTECTION_FALL,2,5));
		golden_boots.add(new StoreValues(0.131,Enchantment.PROTECTION_FIRE,1,5));
		golden_boots.add(new StoreValues(0.112,Enchantment.PROTECTION_PROJECTILE,2,5));
		golden_boots.add(new StoreValues(0.082,Enchantment.PROTECTION_FALL,1,5));
		golden_boots.add(new StoreValues(0.042,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		golden_boots.add(new StoreValues(0.033,Enchantment.PROTECTION_PROJECTILE,3,5));
		golden_boots.add(new StoreValues(0.030,Enchantment.PROTECTION_EXPLOSIONS,2,5));
		golden_boots.add(new StoreValues(0.026,Enchantment.PROTECTION_PROJECTILE,1,5));
		golden_boots.add(new StoreValues(0.023,Enchantment.PROTECTION_FALL,3,5));
		golden_boots.add(new StoreValues(0.005,Enchantment.PROTECTION_FIRE,2,5));
		iron_chestplate.add(new StoreValues(0.525,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		iron_chestplate.add(new StoreValues(0.172,Enchantment.PROTECTION_PROJECTILE,1,5));
		iron_chestplate.add(new StoreValues(0.10,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		iron_chestplate.add(new StoreValues(0.083,Enchantment.PROTECTION_PROJECTILE,2,5));
		iron_chestplate.add(new StoreValues(0.025,Enchantment.PROTECTION_FIRE,1,5));
		iron_chestplate.add(new StoreValues(0.019,Enchantment.THORNS,1,5));
		golden_helmet.add(new StoreValues(0.189,Enchantment.PROTECTION_ENVIRONMENTAL,2,5));
		golden_helmet.add(new StoreValues(0.175,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		golden_helmet.add(new StoreValues(0.134,Enchantment.WATER_WORKER,1,5));
		golden_helmet.add(new StoreValues(0.132,Enchantment.PROTECTION_FIRE,1,5));
		golden_helmet.add(new StoreValues(0.118,Enchantment.PROTECTION_PROJECTILE,2,5));
		golden_helmet.add(new StoreValues(0.101,Enchantment.OXYGEN,1,5));
		golden_helmet.add(new StoreValues(0.042,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		golden_helmet.add(new StoreValues(0.038,Enchantment.PROTECTION_PROJECTILE,3,5));
		golden_helmet.add(new StoreValues(0.03,Enchantment.PROTECTION_PROJECTILE,2,5));
		golden_helmet.add(new StoreValues(0.028,Enchantment.PROTECTION_EXPLOSIONS,2,5));
		golden_helmet.add(new StoreValues(0.004,Enchantment.PROTECTION_FIRE,2,5));
		golden_helmet.add(new StoreValues(0.001,Enchantment.OXYGEN,2,5));
		diamond_pickaxe.add(new StoreValues(0.618,Enchantment.DIG_SPEED,1,5));
		diamond_pickaxe.add(new StoreValues(0.361,Enchantment.DURABILITY,1,5));
		diamond_pickaxe.add(new StoreValues(0.16,Enchantment.DIG_SPEED,2,5));
		diamond_boots.add(new StoreValues(0.413,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		diamond_boots.add(new StoreValues(0.264,Enchantment.PROTECTION_FALL,1,5));
		diamond_boots.add(new StoreValues(0.137,Enchantment.PROTECTION_PROJECTILE,1,5));
		diamond_boots.add(new StoreValues(0.081,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		diamond_boots.add(new StoreValues(0.069,Enchantment.PROTECTION_PROJECTILE,2,5));
		diamond_boots.add(new StoreValues(0.021,Enchantment.PROTECTION_FIRE,1,5));
		diamond_boots.add(new StoreValues(0.007,Enchantment.PROTECTION_FALL,2,5));
		golden_leggings.add(new StoreValues(0.231,Enchantment.PROTECTION_ENVIRONMENTAL,2,5));
		golden_leggings.add(new StoreValues(0.199,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		golden_leggings.add(new StoreValues(0.151,Enchantment.PROTECTION_FIRE,1,5));
		golden_leggings.add(new StoreValues(0.138,Enchantment.PROTECTION_PROJECTILE,2,5));
		golden_leggings.add(new StoreValues(0.05,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		golden_leggings.add(new StoreValues(0.042,Enchantment.PROTECTION_PROJECTILE,3,5));
		golden_leggings.add(new StoreValues(0.041,Enchantment.PROTECTION_PROJECTILE,1,5));
		golden_leggings.add(new StoreValues(0.029,Enchantment.PROTECTION_EXPLOSIONS,2,5));
		golden_leggings.add(new StoreValues(0.006,Enchantment.PROTECTION_FIRE,2,5));
		golden_chestplate.add(new StoreValues(0.211,Enchantment.PROTECTION_ENVIRONMENTAL,2,5));
		golden_chestplate.add(new StoreValues(0.192,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		golden_chestplate.add(new StoreValues(0.147,Enchantment.PROTECTION_FIRE,1,5));
		golden_chestplate.add(new StoreValues(0.129,Enchantment.PROTECTION_PROJECTILE,2,5));
		golden_chestplate.add(new StoreValues(0.129,Enchantment.THORNS,1,5));
		golden_chestplate.add(new StoreValues(0.049,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		golden_chestplate.add(new StoreValues(0.042,Enchantment.PROTECTION_PROJECTILE,3,5));
		golden_chestplate.add(new StoreValues(0.034,Enchantment.PROTECTION_EXPLOSIONS,2,5));
		golden_chestplate.add(new StoreValues(0.032,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		golden_chestplate.add(new StoreValues(0.005,Enchantment.PROTECTION_FIRE,2,5));
		diamond_helmet.add(new StoreValues(0.471,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		diamond_helmet.add(new StoreValues(0.158,Enchantment.WATER_WORKER,1,5));
		diamond_helmet.add(new StoreValues(0.153,Enchantment.PROTECTION_PROJECTILE,1,5));
		diamond_helmet.add(new StoreValues(0.096,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		diamond_helmet.add(new StoreValues(0.076,Enchantment.PROTECTION_PROJECTILE,2,5));
		diamond_helmet.add(new StoreValues(0.023,Enchantment.PROTECTION_FIRE,1,5));
		diamond_helmet.add(new StoreValues(0.015,Enchantment.OXYGEN,1,5));
		diamond_leggings.add(new StoreValues(0.519,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		diamond_leggings.add(new StoreValues(0.178,Enchantment.PROTECTION_PROJECTILE,1,5));
		diamond_leggings.add(new StoreValues(0.102,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		diamond_leggings.add(new StoreValues(0.087,Enchantment.PROTECTION_PROJECTILE,2,5));
		diamond_leggings.add(new StoreValues(0.024,Enchantment.PROTECTION_FIRE,1,5));
		diamond_chestplate.add(new StoreValues(0.512,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		diamond_chestplate.add(new StoreValues(0.176,Enchantment.PROTECTION_PROJECTILE,1,5));
		diamond_chestplate.add(new StoreValues(0.104,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		diamond_chestplate.add(new StoreValues(0.081,Enchantment.PROTECTION_PROJECTILE,2,5));
		diamond_chestplate.add(new StoreValues(0.026,Enchantment.PROTECTION_FIRE,1,5));
		diamond_chestplate.add(new StoreValues(0.021,Enchantment.THORNS,1,5));
		wood_sword.add(new StoreValues(0.333,Enchantment.DAMAGE_ALL,1,5));
		wood_sword.add(new StoreValues(0.241,Enchantment.KNOCKBACK,1,5));
		wood_sword.add(new StoreValues(0.180,Enchantment.DAMAGE_ARTHROPODS,1,5));
		wood_sword.add(new StoreValues(0.173,Enchantment.DAMAGE_UNDEAD,1,5));
		wood_sword.add(new StoreValues(0.035,Enchantment.FIRE_ASPECT,1,5));
		wood_sword.add(new StoreValues(0.026,Enchantment.DAMAGE_ALL,2,5));
		wood_sword.add(new StoreValues(0.003,Enchantment.DAMAGE_ARTHROPODS,2,5));
		wood_sword.add(new StoreValues(0.002,Enchantment.DAMAGE_UNDEAD,2,5));
		bow.add(new StoreValues(0.926,Enchantment.ARROW_DAMAGE,1,5));
		iron_sword.add(new StoreValues(0.333,Enchantment.DAMAGE_ALL,1,5));
		iron_sword.add(new StoreValues(0.241,Enchantment.KNOCKBACK,1,5));
		iron_sword.add(new StoreValues(0.180,Enchantment.DAMAGE_ARTHROPODS,1,5));
		iron_sword.add(new StoreValues(0.173,Enchantment.DAMAGE_UNDEAD,1,5));
		iron_sword.add(new StoreValues(0.035,Enchantment.FIRE_ASPECT,1,5));
		iron_sword.add(new StoreValues(0.026,Enchantment.DAMAGE_ALL,2,5));
		iron_sword.add(new StoreValues(0.003,Enchantment.DAMAGE_ARTHROPODS,2,5));
		iron_sword.add(new StoreValues(0.002,Enchantment.DAMAGE_UNDEAD,2,5));
		gold_sword.add(new StoreValues(0.333,Enchantment.KNOCKBACK,1,5));
		gold_sword.add(new StoreValues(0.241,Enchantment.DAMAGE_ALL,1,5));
		gold_sword.add(new StoreValues(0.180,Enchantment.DAMAGE_ALL,2,5));
		gold_sword.add(new StoreValues(0.173,Enchantment.DAMAGE_ARTHROPODS,1,5));
		gold_sword.add(new StoreValues(0.035,Enchantment.DAMAGE_UNDEAD,1,5));
		gold_sword.add(new StoreValues(0.026,Enchantment.FIRE_ASPECT,1,5));
		gold_sword.add(new StoreValues(0.003,Enchantment.DAMAGE_UNDEAD,2,5));
		gold_sword.add(new StoreValues(0.002,Enchantment.DAMAGE_ARTHROPODS,2,5));
		gold_sword.add(new StoreValues(0.002,Enchantment.LOOT_BONUS_MOBS,1,5));
		diamond_sword.add(new StoreValues(0.365,Enchantment.DAMAGE_ALL,1,5));
		diamond_sword.add(new StoreValues(0.247,Enchantment.KNOCKBACK,1,5));
		diamond_sword.add(new StoreValues(0.187,Enchantment.DAMAGE_ARTHROPODS,1,5));
		diamond_sword.add(new StoreValues(0.185,Enchantment.DAMAGE_UNDEAD,1,5));
		diamond_sword.add(new StoreValues(0.01,Enchantment.FIRE_ASPECT,1,5));
		stone_hoe.add(new StoreValues(0.359,Enchantment.DURABILITY,2,10));
		stone_shovel.add(new StoreValues(0.575,Enchantment.DIG_SPEED,2,10));
		stone_shovel.add(new StoreValues(0.255,Enchantment.DURABILITY,1,10));
		stone_shovel.add(new StoreValues(0.118,Enchantment.DURABILITY,2,10));
		stone_shovel.add(new StoreValues(0.04,Enchantment.DIG_SPEED,1,10));
		stone_shovel.add(new StoreValues(0.01,Enchantment.LOOT_BONUS_BLOCKS,1,10));
		stone_shovel.add(new StoreValues(0.01,Enchantment.SILK_TOUCH,1,10));
		stone_pickaxe.add(new StoreValues(0.575,Enchantment.DIG_SPEED,2,10));
		stone_pickaxe.add(new StoreValues(0.255,Enchantment.DURABILITY,1,10));
		stone_pickaxe.add(new StoreValues(0.118,Enchantment.DURABILITY,2,10));
		stone_pickaxe.add(new StoreValues(0.04,Enchantment.DIG_SPEED,1,10));
		stone_pickaxe.add(new StoreValues(0.01,Enchantment.LOOT_BONUS_BLOCKS,1,10));
		stone_pickaxe.add(new StoreValues(0.01,Enchantment.SILK_TOUCH,1,10));
		leather_boots.add(new StoreValues(0.305,Enchantment.PROTECTION_ENVIRONMENTAL,2,10));
		leather_boots.add(new StoreValues(0.237,Enchantment.PROTECTION_FALL,2,10));
		leather_boots.add(new StoreValues(0.152,Enchantment.PROTECTION_FIRE,1,10));
		leather_boots.add(new StoreValues(0.104,Enchantment.PROTECTION_PROJECTILE,2,10));
		leather_boots.add(new StoreValues(0.062,Enchantment.PROTECTION_PROJECTILE,3,10));
		leather_boots.add(new StoreValues(0.05,Enchantment.PROTECTION_EXPLOSIONS,2,10));
		leather_boots.add(new StoreValues(0.027,Enchantment.PROTECTION_FALL,3,10));
		leather_boots.add(new StoreValues(0.025,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		leather_boots.add(new StoreValues(0.013,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		leather_boots.add(new StoreValues(0.004,Enchantment.PROTECTION_FIRE,2,10));
		leather_boots.add(new StoreValues(0.003,Enchantment.PROTECTION_FALL,1,10));
		leather_cap.add(new StoreValues(0.405,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		leather_cap.add(new StoreValues(0.146,Enchantment.WATER_WORKER,1,10));
		leather_cap.add(new StoreValues(0.119,Enchantment.PROTECTION_PROJECTILE,2,10));
		leather_cap.add(new StoreValues(0.094,Enchantment.PROTECTION_PROJECTILE,1,10));
		leather_cap.add(new StoreValues(0.082,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		leather_cap.add(new StoreValues(0.069,Enchantment.PROTECTION_FIRE,1,10));
		leather_cap.add(new StoreValues(0.048,Enchantment.OXYGEN,1,10));
		leather_cap.add(new StoreValues(0.029,Enchantment.PROTECTION_ENVIRONMENTAL,2,10));
		leather_cap.add(new StoreValues(0.0001,Enchantment.PROTECTION_EXPLOSIONS,2,10));
		leather_pants.add(new StoreValues(0.451,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		leather_pants.add(new StoreValues(0.135,Enchantment.PROTECTION_PROJECTILE,2,10));
		leather_pants.add(new StoreValues(0.104,Enchantment.PROTECTION_PROJECTILE,1,10));
		leather_pants.add(new StoreValues(0.100,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		leather_pants.add(new StoreValues(0.079,Enchantment.PROTECTION_FIRE,1,10));
		leather_pants.add(new StoreValues(0.032,Enchantment.PROTECTION_ENVIRONMENTAL,2,10));
		leather_pants.add(new StoreValues(0.0001,Enchantment.PROTECTION_EXPLOSIONS,2,10));
		leather_tunic.add(new StoreValues(0.442,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		leather_tunic.add(new StoreValues(0.140,Enchantment.PROTECTION_PROJECTILE,2,10));
		leather_tunic.add(new StoreValues(0.102,Enchantment.PROTECTION_PROJECTILE,1,10));
		leather_tunic.add(new StoreValues(0.094,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		leather_tunic.add(new StoreValues(0.079,Enchantment.PROTECTION_FIRE,1,10));
		leather_tunic.add(new StoreValues(0.053,Enchantment.THORNS,1,10));
		leather_tunic.add(new StoreValues(0.028,Enchantment.PROTECTION_ENVIRONMENTAL,2,10));
		leather_tunic.add(new StoreValues(0.001,Enchantment.PROTECTION_EXPLOSIONS,2,10));
		iron_shovel.add(new StoreValues(0.506,Enchantment.DIG_SPEED,1,10));
		iron_shovel.add(new StoreValues(0.355,Enchantment.DURABILITY,1,10));
		iron_shovel.add(new StoreValues(0.126,Enchantment.DIG_SPEED,2,10));
		iron_shovel.add(new StoreValues(0.06,Enchantment.DURABILITY,2,10));
		iron_axe.add(new StoreValues(0.506,Enchantment.DIG_SPEED,1,10));
		iron_axe.add(new StoreValues(0.355,Enchantment.DURABILITY,1,10));
		iron_axe.add(new StoreValues(0.126,Enchantment.DIG_SPEED,2,10));
		iron_axe.add(new StoreValues(0.06,Enchantment.DURABILITY,2,10));
		iron_boots.add(new StoreValues(0.41,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		iron_boots.add(new StoreValues(0.265,Enchantment.PROTECTION_FALL,1,10));
		iron_boots.add(new StoreValues(0.143,Enchantment.PROTECTION_PROJECTILE,1,10));
		iron_boots.add(new StoreValues(0.082,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		iron_boots.add(new StoreValues(0.065,Enchantment.PROTECTION_PROJECTILE,2,10));
		iron_boots.add(new StoreValues(0.022,Enchantment.PROTECTION_FIRE,1,10));
		iron_boots.add(new StoreValues(0.006,Enchantment.PROTECTION_FALL,2,10));
		iron_pickaxe.add(new StoreValues(0.504,Enchantment.DIG_SPEED,1,10));
		iron_pickaxe.add(new StoreValues(0.354,Enchantment.DURABILITY,1,10));
		iron_pickaxe.add(new StoreValues(0.129,Enchantment.DIG_SPEED,2,10));
		iron_pickaxe.add(new StoreValues(0.06,Enchantment.DURABILITY,2,10));
		iron_helmet.add(new StoreValues(0.471,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		iron_helmet.add(new StoreValues(0.161,Enchantment.WATER_WORKER,1,10));
		iron_helmet.add(new StoreValues(0.16,Enchantment.PROTECTION_PROJECTILE,1,10));
		iron_helmet.add(new StoreValues(0.092,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		iron_helmet.add(new StoreValues(0.072,Enchantment.PROTECTION_PROJECTILE,2,10));
		iron_helmet.add(new StoreValues(0.022,Enchantment.PROTECTION_FIRE,1,10));
		iron_helmet.add(new StoreValues(0.015,Enchantment.OXYGEN,1,10));
		golden_shovel.add(new StoreValues(0.364,Enchantment.DIG_SPEED,2,10));
		golden_shovel.add(new StoreValues(0.256,Enchantment.DIG_SPEED,1,10));
		golden_shovel.add(new StoreValues(0.253,Enchantment.DURABILITY,1,10));
		golden_shovel.add(new StoreValues(0.101,Enchantment.DURABILITY,2,10));
		golden_shovel.add(new StoreValues(0.01,Enchantment.LOOT_BONUS_BLOCKS,1,10));
		golden_shovel.add(new StoreValues(0.006,Enchantment.SILK_TOUCH,1,10));
		golden_axe.add(new StoreValues(0.364,Enchantment.DIG_SPEED,2,10));
		golden_axe.add(new StoreValues(0.256,Enchantment.DIG_SPEED,1,10));
		golden_axe.add(new StoreValues(0.253,Enchantment.DURABILITY,1,10));
		golden_axe.add(new StoreValues(0.101,Enchantment.DURABILITY,2,10));
		golden_axe.add(new StoreValues(0.01,Enchantment.LOOT_BONUS_BLOCKS,1,10));
		golden_axe.add(new StoreValues(0.006,Enchantment.SILK_TOUCH,1,10));
		iron_leggings.add(new StoreValues(0.523,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		iron_leggings.add(new StoreValues(0.178,Enchantment.PROTECTION_PROJECTILE,1,10));
		iron_leggings.add(new StoreValues(0.101,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		iron_leggings.add(new StoreValues(0.083,Enchantment.PROTECTION_PROJECTILE,2,10));
		iron_leggings.add(new StoreValues(0.025,Enchantment.PROTECTION_FIRE,1,10));
		diamond_shovel.add(new StoreValues(0.623,Enchantment.DIG_SPEED,1,10));
		diamond_shovel.add(new StoreValues(0.356,Enchantment.DURABILITY,1,10));
		diamond_shovel.add(new StoreValues(0.014,Enchantment.DIG_SPEED,2,10));
		diamond_axe.add(new StoreValues(0.623,Enchantment.DIG_SPEED,1,10));
		diamond_axe.add(new StoreValues(0.356,Enchantment.DURABILITY,1,10));
		diamond_axe.add(new StoreValues(0.014,Enchantment.DIG_SPEED,2,10));
		golden_boots.add(new StoreValues(0.187,Enchantment.PROTECTION_ENVIRONMENTAL,2,10));
		golden_boots.add(new StoreValues(0.158,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		golden_boots.add(new StoreValues(0.155,Enchantment.PROTECTION_FALL,2,10));
		golden_boots.add(new StoreValues(0.131,Enchantment.PROTECTION_FIRE,1,10));
		golden_boots.add(new StoreValues(0.112,Enchantment.PROTECTION_PROJECTILE,2,10));
		golden_boots.add(new StoreValues(0.082,Enchantment.PROTECTION_FALL,1,10));
		golden_boots.add(new StoreValues(0.042,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		golden_boots.add(new StoreValues(0.033,Enchantment.PROTECTION_PROJECTILE,3,10));
		golden_boots.add(new StoreValues(0.030,Enchantment.PROTECTION_EXPLOSIONS,2,10));
		golden_boots.add(new StoreValues(0.026,Enchantment.PROTECTION_PROJECTILE,1,10));
		golden_boots.add(new StoreValues(0.023,Enchantment.PROTECTION_FALL,3,10));
		golden_boots.add(new StoreValues(0.005,Enchantment.PROTECTION_FIRE,2,10));
		iron_chestplate.add(new StoreValues(0.525,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		iron_chestplate.add(new StoreValues(0.172,Enchantment.PROTECTION_PROJECTILE,1,10));
		iron_chestplate.add(new StoreValues(0.10,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		iron_chestplate.add(new StoreValues(0.083,Enchantment.PROTECTION_PROJECTILE,2,10));
		iron_chestplate.add(new StoreValues(0.025,Enchantment.PROTECTION_FIRE,1,10));
		iron_chestplate.add(new StoreValues(0.019,Enchantment.THORNS,1,10));
		golden_helmet.add(new StoreValues(0.189,Enchantment.PROTECTION_ENVIRONMENTAL,2,10));
		golden_helmet.add(new StoreValues(0.175,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		golden_helmet.add(new StoreValues(0.134,Enchantment.WATER_WORKER,1,10));
		golden_helmet.add(new StoreValues(0.132,Enchantment.PROTECTION_FIRE,1,10));
		golden_helmet.add(new StoreValues(0.118,Enchantment.PROTECTION_PROJECTILE,2,10));
		golden_helmet.add(new StoreValues(0.101,Enchantment.OXYGEN,1,10));
		golden_helmet.add(new StoreValues(0.042,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		golden_helmet.add(new StoreValues(0.038,Enchantment.PROTECTION_PROJECTILE,3,10));
		golden_helmet.add(new StoreValues(0.03,Enchantment.PROTECTION_PROJECTILE,2,10));
		golden_helmet.add(new StoreValues(0.028,Enchantment.PROTECTION_EXPLOSIONS,2,10));
		golden_helmet.add(new StoreValues(0.004,Enchantment.PROTECTION_FIRE,2,10));
		golden_helmet.add(new StoreValues(0.001,Enchantment.OXYGEN,2,10));
		diamond_pickaxe.add(new StoreValues(0.618,Enchantment.DIG_SPEED,1,10));
		diamond_pickaxe.add(new StoreValues(0.361,Enchantment.DURABILITY,1,10));
		diamond_pickaxe.add(new StoreValues(0.16,Enchantment.DIG_SPEED,2,10));
		diamond_boots.add(new StoreValues(0.413,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		diamond_boots.add(new StoreValues(0.264,Enchantment.PROTECTION_FALL,1,10));
		diamond_boots.add(new StoreValues(0.137,Enchantment.PROTECTION_PROJECTILE,1,10));
		diamond_boots.add(new StoreValues(0.081,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		diamond_boots.add(new StoreValues(0.069,Enchantment.PROTECTION_PROJECTILE,2,10));
		diamond_boots.add(new StoreValues(0.021,Enchantment.PROTECTION_FIRE,1,10));
		diamond_boots.add(new StoreValues(0.007,Enchantment.PROTECTION_FALL,2,10));
		golden_leggings.add(new StoreValues(0.231,Enchantment.PROTECTION_ENVIRONMENTAL,2,10));
		golden_leggings.add(new StoreValues(0.199,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		golden_leggings.add(new StoreValues(0.151,Enchantment.PROTECTION_FIRE,1,10));
		golden_leggings.add(new StoreValues(0.138,Enchantment.PROTECTION_PROJECTILE,2,10));
		golden_leggings.add(new StoreValues(0.05,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		golden_leggings.add(new StoreValues(0.042,Enchantment.PROTECTION_PROJECTILE,3,10));
		golden_leggings.add(new StoreValues(0.041,Enchantment.PROTECTION_PROJECTILE,1,10));
		golden_leggings.add(new StoreValues(0.029,Enchantment.PROTECTION_EXPLOSIONS,2,10));
		golden_leggings.add(new StoreValues(0.006,Enchantment.PROTECTION_FIRE,2,10));
		golden_chestplate.add(new StoreValues(0.211,Enchantment.PROTECTION_ENVIRONMENTAL,2,10));
		golden_chestplate.add(new StoreValues(0.192,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		golden_chestplate.add(new StoreValues(0.147,Enchantment.PROTECTION_FIRE,1,10));
		golden_chestplate.add(new StoreValues(0.129,Enchantment.PROTECTION_PROJECTILE,2,10));
		golden_chestplate.add(new StoreValues(0.129,Enchantment.THORNS,1,10));
		golden_chestplate.add(new StoreValues(0.049,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		golden_chestplate.add(new StoreValues(0.042,Enchantment.PROTECTION_PROJECTILE,3,10));
		golden_chestplate.add(new StoreValues(0.034,Enchantment.PROTECTION_EXPLOSIONS,2,10));
		golden_chestplate.add(new StoreValues(0.032,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		golden_chestplate.add(new StoreValues(0.005,Enchantment.PROTECTION_FIRE,2,10));
		diamond_helmet.add(new StoreValues(0.471,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		diamond_helmet.add(new StoreValues(0.158,Enchantment.WATER_WORKER,1,10));
		diamond_helmet.add(new StoreValues(0.153,Enchantment.PROTECTION_PROJECTILE,1,10));
		diamond_helmet.add(new StoreValues(0.096,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		diamond_helmet.add(new StoreValues(0.076,Enchantment.PROTECTION_PROJECTILE,2,10));
		diamond_helmet.add(new StoreValues(0.023,Enchantment.PROTECTION_FIRE,1,10));
		diamond_helmet.add(new StoreValues(0.015,Enchantment.OXYGEN,1,10));
		diamond_leggings.add(new StoreValues(0.519,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		diamond_leggings.add(new StoreValues(0.178,Enchantment.PROTECTION_PROJECTILE,1,10));
		diamond_leggings.add(new StoreValues(0.102,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		diamond_leggings.add(new StoreValues(0.087,Enchantment.PROTECTION_PROJECTILE,2,10));
		diamond_leggings.add(new StoreValues(0.024,Enchantment.PROTECTION_FIRE,1,10));
		diamond_chestplate.add(new StoreValues(0.512,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		diamond_chestplate.add(new StoreValues(0.176,Enchantment.PROTECTION_PROJECTILE,1,10));
		diamond_chestplate.add(new StoreValues(0.104,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		diamond_chestplate.add(new StoreValues(0.081,Enchantment.PROTECTION_PROJECTILE,2,10));
		diamond_chestplate.add(new StoreValues(0.026,Enchantment.PROTECTION_FIRE,1,10));
		diamond_chestplate.add(new StoreValues(0.021,Enchantment.THORNS,1,10));
		chain_helmet.add(new StoreValues(0.471,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		chain_helmet.add(new StoreValues(0.161,Enchantment.WATER_WORKER,1,5));
		chain_helmet.add(new StoreValues(0.16,Enchantment.PROTECTION_PROJECTILE,1,5));
		chain_helmet.add(new StoreValues(0.092,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		chain_helmet.add(new StoreValues(0.072,Enchantment.PROTECTION_PROJECTILE,2,5));
		chain_helmet.add(new StoreValues(0.022,Enchantment.PROTECTION_FIRE,1,5));
		chain_helmet.add(new StoreValues(0.015,Enchantment.OXYGEN,1,5));
		chain_boots.add(new StoreValues(0.41,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		chain_boots.add(new StoreValues(0.265,Enchantment.PROTECTION_FALL,1,5));
		chain_boots.add(new StoreValues(0.143,Enchantment.PROTECTION_PROJECTILE,1,5));
		chain_boots.add(new StoreValues(0.082,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		chain_boots.add(new StoreValues(0.065,Enchantment.PROTECTION_PROJECTILE,2,5));
		chain_boots.add(new StoreValues(0.022,Enchantment.PROTECTION_FIRE,1,5));
		chain_boots.add(new StoreValues(0.006,Enchantment.PROTECTION_FALL,2,5));
		chain_leggings.add(new StoreValues(0.523,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		chain_leggings.add(new StoreValues(0.178,Enchantment.PROTECTION_PROJECTILE,1,5));
		chain_leggings.add(new StoreValues(0.101,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		chain_leggings.add(new StoreValues(0.083,Enchantment.PROTECTION_PROJECTILE,2,5));
		chain_leggings.add(new StoreValues(0.025,Enchantment.PROTECTION_FIRE,1,5));
		chain_chestplate.add(new StoreValues(0.525,Enchantment.PROTECTION_ENVIRONMENTAL,1,5));
		chain_chestplate.add(new StoreValues(0.172,Enchantment.PROTECTION_PROJECTILE,1,5));
		chain_chestplate.add(new StoreValues(0.10,Enchantment.PROTECTION_EXPLOSIONS,1,5));
		chain_chestplate.add(new StoreValues(0.083,Enchantment.PROTECTION_PROJECTILE,2,5));
		chain_chestplate.add(new StoreValues(0.025,Enchantment.PROTECTION_FIRE,1,5));
		chain_chestplate.add(new StoreValues(0.019,Enchantment.THORNS,1,5));
		chain_boots.add(new StoreValues(0.41,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		chain_boots.add(new StoreValues(0.265,Enchantment.PROTECTION_FALL,1,10));
		chain_boots.add(new StoreValues(0.143,Enchantment.PROTECTION_PROJECTILE,1,10));
		chain_boots.add(new StoreValues(0.082,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		chain_boots.add(new StoreValues(0.065,Enchantment.PROTECTION_PROJECTILE,2,10));
		chain_boots.add(new StoreValues(0.022,Enchantment.PROTECTION_FIRE,1,10));
		chain_boots.add(new StoreValues(0.006,Enchantment.PROTECTION_FALL,2,10));
		chain_helmet.add(new StoreValues(0.471,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		chain_helmet.add(new StoreValues(0.161,Enchantment.WATER_WORKER,1,10));
		chain_helmet.add(new StoreValues(0.16,Enchantment.PROTECTION_PROJECTILE,1,10));
		chain_helmet.add(new StoreValues(0.092,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		chain_helmet.add(new StoreValues(0.072,Enchantment.PROTECTION_PROJECTILE,2,10));
		chain_helmet.add(new StoreValues(0.022,Enchantment.PROTECTION_FIRE,1,10));
		chain_helmet.add(new StoreValues(0.015,Enchantment.OXYGEN,1,10));
		chain_leggings.add(new StoreValues(0.523,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		chain_leggings.add(new StoreValues(0.178,Enchantment.PROTECTION_PROJECTILE,1,10));
		chain_leggings.add(new StoreValues(0.101,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		chain_leggings.add(new StoreValues(0.083,Enchantment.PROTECTION_PROJECTILE,2,10));
		chain_leggings.add(new StoreValues(0.025,Enchantment.PROTECTION_FIRE,1,10));
		chain_chestplate.add(new StoreValues(0.525,Enchantment.PROTECTION_ENVIRONMENTAL,1,10));
		chain_chestplate.add(new StoreValues(0.172,Enchantment.PROTECTION_PROJECTILE,1,10));
		chain_chestplate.add(new StoreValues(0.10,Enchantment.PROTECTION_EXPLOSIONS,1,10));
		chain_chestplate.add(new StoreValues(0.083,Enchantment.PROTECTION_PROJECTILE,2,10));
		chain_chestplate.add(new StoreValues(0.025,Enchantment.PROTECTION_FIRE,1,10));
		chain_chestplate.add(new StoreValues(0.019,Enchantment.THORNS,1,10));

	}
}
