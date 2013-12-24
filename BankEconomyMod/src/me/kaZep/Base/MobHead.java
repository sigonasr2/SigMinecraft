package me.kaZep.Base;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;


/**
 * Represents a mob head
 */
public class MobHead {
	public enum MobHeadType {
		SKELETON, WITHER_SKELETON, ZOMBIE, CREEPER,
		SPIDER, ENDERMAN, CAVE_SPIDER, BLAZE, GHAST,
		ZOMBIE_PIGMAN, MAGMA_CUBE
	}
	public enum MobHeadRareType {
		RARE_TYPE_A, RARE_TYPE_B
	}
	MobHeadType head_type = null;
	MobHeadRareType rare_head_type =null;
	boolean rare_head=false;
	boolean is_powered=false;
	/**
	 * Compares if two MobHeads are equal to each other
	 * @param m The MobHead to compare to this MobHead.
	 * @return true if the two mob heads are the same,
	 *  false otherwise.
	 */
	public boolean equals(MobHead m) {
		if (head_type.equals(m.head_type) &&
				rare_head_type.equals(m.rare_head_type) &&
				is_powered==m.is_powered && rare_head==m.rare_head) {
			return true;
		}
		return false;
	}
	/**
	 * Returns the ItemStack version of this defined Mob Head.
	 * This is useful for creating new heads that have specific
	 * attributes.
	 * @return 
	 */
	public ItemStack getItemStack() {
		ItemStack finalhead = new ItemStack(Material.AIR);
		if (!rare_head) {
			switch (head_type) {
				case SKELETON:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					ItemMeta meta = newhead.getItemMeta();
					String key = "mob.skeleton";
					meta.setDisplayName(ChatColor.WHITE+"Skeleton Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
					List<String> newlore = new ArrayList<String>();
					newlore.add(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Ranged Damage");
					meta.setLore(newlore);
					newhead.setItemMeta(meta);
					finalhead = newhead;
				}break;
				case WITHER_SKELETON:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)1);
					ItemMeta meta = newhead.getItemMeta();
					String key = "mob.witherskeleton";
					meta.setDisplayName(ChatColor.WHITE+"Wither Skeleton Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
					List<String> newlore = new ArrayList<String>();
					newlore.add(ChatColor.LIGHT_PURPLE+"+5 "+ChatColor.GOLD+"second "+ChatColor.GRAY+"Wither I"+ChatColor.GOLD+" duration");
					newlore.add(ChatColor.GOLD+" on hit.");
					meta.setLore(newlore);
					newhead.setItemMeta(meta);
					finalhead = newhead;
				}break;
				case ZOMBIE:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)2);
					ItemMeta meta = newhead.getItemMeta();
					String key = "mob.zombie";
					meta.setDisplayName(ChatColor.WHITE+"Zombie Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
					List<String> newlore = new ArrayList<String>();
					newlore.add(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Lifesteal");
					meta.setLore(newlore);
					newhead.setItemMeta(meta);
					finalhead = newhead;
				}break;
				case CREEPER:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)4);
					ItemMeta meta = newhead.getItemMeta();
					String key = "mob.creeper";
					meta.setDisplayName(ChatColor.WHITE+"Creeper Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
					List<String> newlore = new ArrayList<String>();
					newlore.add(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"AoE Damage");
					meta.setLore(newlore);
					newhead.setItemMeta(meta);
					finalhead = newhead;
				}break;
				case SPIDER:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)SkullType.PLAYER.ordinal());
					SkullMeta skullMeta = (SkullMeta) newhead.getItemMeta();
					String key = "mob.spider";
					skullMeta.setDisplayName(ChatColor.WHITE+"Spider Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
				        skullMeta.setOwner("MHF_Spider");
				        newhead.setItemMeta(skullMeta);
					ItemMeta meta = newhead.getItemMeta();
					List<String> newlore = new ArrayList<String>();
					newlore.add(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"Slow on hit");
					meta.setLore(newlore);
					newhead.setItemMeta(meta);
					finalhead = newhead;
				}break;
				case ENDERMAN:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)SkullType.PLAYER.ordinal());
					SkullMeta skullMeta = (SkullMeta) newhead.getItemMeta();
					String key = "mob.enderman";
					skullMeta.setDisplayName(ChatColor.WHITE+"Enderman Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
				        skullMeta.setOwner("MHF_Enderman");
					List<String> newlore = new ArrayList<String>();
					newlore.add(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Critical Chance");
					skullMeta.setLore(newlore);
			        newhead.setItemMeta(skullMeta);
					finalhead = newhead;
				}break;
				case CAVE_SPIDER:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)SkullType.PLAYER.ordinal());
					SkullMeta skullMeta = (SkullMeta) newhead.getItemMeta();
					String key = "mob.cavespider";
					skullMeta.setDisplayName(ChatColor.WHITE+"Cave Spider Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
				        skullMeta.setOwner("MHF_CaveSpider");
					List<String> newlore = new ArrayList<String>();
					newlore.add(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"second Poison duration");
					newlore.add(ChatColor.GOLD+" on hit.");
					skullMeta.setLore(newlore);
			        newhead.setItemMeta(skullMeta);
					finalhead = newhead;
				}break;
				case BLAZE:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)SkullType.PLAYER.ordinal());
					SkullMeta skullMeta = (SkullMeta) newhead.getItemMeta();
					String key = "mob.blaze";
					skullMeta.setDisplayName(ChatColor.WHITE+"Blaze Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
				        skullMeta.setOwner("MHF_Blaze");
					List<String> newlore = new ArrayList<String>();
					newlore.add(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"second ignite duration");
					newlore.add(ChatColor.GOLD+" on hit.");
					skullMeta.setLore(newlore);
			        newhead.setItemMeta(skullMeta);
					finalhead = newhead;
				}break;
				case GHAST:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)SkullType.PLAYER.ordinal());
					SkullMeta skullMeta = (SkullMeta) newhead.getItemMeta();
					String key = "mob.ghast";
					skullMeta.setDisplayName(ChatColor.WHITE+"Ghast Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
				        skullMeta.setOwner("MHF_Ghast");
					List<String> newlore = new ArrayList<String>();
					newlore.add(ChatColor.LIGHT_PURPLE+"-1% "+ChatColor.GOLD+"damage taken on hit");
					skullMeta.setLore(newlore);
			        newhead.setItemMeta(skullMeta);
					finalhead = newhead;
				}break;
				case ZOMBIE_PIGMAN:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)SkullType.PLAYER.ordinal());
					SkullMeta skullMeta = (SkullMeta) newhead.getItemMeta();
					String key = "mob.zombiepigman";
					skullMeta.setDisplayName(ChatColor.WHITE+"Zombie Pigman Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
				        skullMeta.setOwner("MHF_PigZombie");
					List<String> newlore = new ArrayList<String>();
					newlore.add(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"chance of being fully");
					newlore.add(ChatColor.GOLD+" healed on kill.");
					skullMeta.setLore(newlore);
			        newhead.setItemMeta(skullMeta);
					finalhead = newhead;
				}break;
				case MAGMA_CUBE:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)SkullType.PLAYER.ordinal());
					SkullMeta skullMeta = (SkullMeta) newhead.getItemMeta();
					String key = "mob.magmacube";
					skullMeta.setDisplayName(ChatColor.WHITE+"Magma Cube Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
				        skullMeta.setOwner("MHF_LavaSlime");
					List<String> newlore = new ArrayList<String>();
					newlore.add(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"chance of setting the");
					newlore.add(ChatColor.GOLD+" mob and surrounding mobs on fire");
					newlore.add(ChatColor.GOLD+" for 10 seconds.");
					skullMeta.setLore(newlore);
			        newhead.setItemMeta(skullMeta);
					finalhead = newhead;
				}break;
			}
		} else {
			switch (head_type) {
				case WITHER_SKELETON:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)1);
					ItemMeta meta = newhead.getItemMeta();
					String key = "mob.rarewitherskeleton";
					meta.setDisplayName(ChatColor.BLUE+"Rare Wither Skeleton Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
					List<String> newlore = new ArrayList<String>();
					newlore.add(ChatColor.LIGHT_PURPLE+"+15 "+ChatColor.GOLD+"second "+ChatColor.GRAY+"Wither III"+ChatColor.GOLD+" duration");
					newlore.add(ChatColor.GOLD+" on hit.");
					meta.setLore(newlore);
					newhead.setItemMeta(meta);
					newhead.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
					finalhead = newhead;
				}break;
				case SKELETON:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					ItemMeta meta = newhead.getItemMeta();
					String key = "mob.rareskeleton";
					meta.setDisplayName(ChatColor.BLUE+"Rare Skeleton Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
					List<String> newlore = new ArrayList<String>();
					if (rare_head_type==MobHeadRareType.RARE_TYPE_A) {
						newlore.add(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"Ranged Damage");
					} else {
						newlore.add(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"m/s Projectile Speed");
					}
					meta.setLore(newlore);
					newhead.setItemMeta(meta);
					newhead.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
					finalhead = newhead;
				}break;
				case ZOMBIE:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)2);
					ItemMeta meta = newhead.getItemMeta();
					String key = "mob.rarezombie";
					meta.setDisplayName(ChatColor.BLUE+"Rare Zombie Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
					List<String> newlore = new ArrayList<String>();
					if (rare_head_type==MobHeadRareType.RARE_TYPE_A) {
						newlore.add(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"Lifesteal");
					} else {
						newlore.add(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"Max Health");
					}
					meta.setLore(newlore);
					newhead.setItemMeta(meta);
					newhead.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
					finalhead = newhead;
				}break;
				case CREEPER:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)4);
					ItemMeta meta = newhead.getItemMeta();
					String key = "mob.rarecreeper";
					meta.setDisplayName(ChatColor.BLUE+"Rare Creeper Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
					List<String> newlore = new ArrayList<String>();
					if (rare_head_type==MobHeadRareType.RARE_TYPE_A) {
						newlore.add(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"Damage to all nearby enemies.");
					} else {
						newlore.add(ChatColor.LIGHT_PURPLE+"+20% "+ChatColor.GOLD+"AoE Damage");
					}
					meta.setLore(newlore);
					newhead.setItemMeta(meta);
					newhead.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
					finalhead = newhead;
				}break;
				case SPIDER:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)SkullType.PLAYER.ordinal());
					SkullMeta skullMeta = (SkullMeta) newhead.getItemMeta();
	  		        skullMeta.setOwner("MHF_Spider");
					String key = "mob.rarespider";
					skullMeta.setDisplayName(ChatColor.BLUE+"Rare Spider Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
	  		        newhead.setItemMeta(skullMeta);
					ItemMeta meta = newhead.getItemMeta();
					//meta.setDisplayName(ChatColor.BLUE+"Rare Spider Head");
					List<String> newlore = new ArrayList<String>();
					if (rare_head_type==MobHeadRareType.RARE_TYPE_A) {
						newlore.add(ChatColor.LIGHT_PURPLE+"+2 "+ChatColor.GOLD+"second Poison duration");
						newlore.add(ChatColor.GOLD+" on hit.");
					} else {
						newlore.add(ChatColor.LIGHT_PURPLE+"+15% "+ChatColor.GOLD+"Slow on hit");
					}
					meta.setLore(newlore);
					newhead.setItemMeta(meta);
					newhead.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
					finalhead = newhead;
				}break;
				case ENDERMAN:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)SkullType.PLAYER.ordinal());
					SkullMeta skullMeta = (SkullMeta) newhead.getItemMeta();
	  		        skullMeta.setOwner("MHF_Enderman");
					String key = "mob.rareenderman";
					skullMeta.setDisplayName(ChatColor.BLUE+"Rare Enderman Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
					List<String> newlore = new ArrayList<String>();
					if (rare_head_type==MobHeadRareType.RARE_TYPE_A) {
						newlore.add(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Item Drop Amount Increase");
					} else {
						newlore.add(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"Critical Chance");
					}
					skullMeta.setLore(newlore);
	  		        newhead.setItemMeta(skullMeta);
					newhead.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
					finalhead = newhead;
				}break;
				case CAVE_SPIDER:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)SkullType.PLAYER.ordinal());
					SkullMeta skullMeta = (SkullMeta) newhead.getItemMeta();
					String key = "mob.rarecavespider";
					skullMeta.setDisplayName(ChatColor.BLUE+"Rare Cave Spider Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
	  		        skullMeta.setOwner("MHF_CaveSpider");
					List<String> newlore = new ArrayList<String>();
					if (rare_head_type==MobHeadRareType.RARE_TYPE_A) {
						newlore.add(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"of snaring a target");
						newlore.add(ChatColor.GOLD+" for 5 seconds.");
					} else {
						newlore.add(ChatColor.LIGHT_PURPLE+"+3 "+ChatColor.GOLD+"second Poison duration");
						newlore.add(ChatColor.GOLD+" on hit.");
					}
					skullMeta.setLore(newlore);
	  		        newhead.setItemMeta(skullMeta);
					newhead.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
					finalhead = newhead;
				}break;
				case BLAZE:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)SkullType.PLAYER.ordinal());
					SkullMeta skullMeta = (SkullMeta) newhead.getItemMeta();
					String key = "mob.rareblaze";
					skullMeta.setDisplayName(ChatColor.BLUE+"Rare Blaze Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
	  		        skullMeta.setOwner("MHF_Blaze");
					List<String> newlore = new ArrayList<String>();
					if (rare_head_type==MobHeadRareType.RARE_TYPE_A) {
						newlore.add(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"chance to send enemy");
						newlore.add(ChatColor.GOLD+" airborne.");
					} else {
						newlore.add(ChatColor.LIGHT_PURPLE+"+3 "+ChatColor.GOLD+"second ignite duration");
						newlore.add(ChatColor.GOLD+" on hit.");
					}
					skullMeta.setLore(newlore);
	  		        newhead.setItemMeta(skullMeta);
					newhead.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
					finalhead = newhead;
				}break;
				case GHAST:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)SkullType.PLAYER.ordinal());
					SkullMeta skullMeta = (SkullMeta) newhead.getItemMeta();
					String key = "mob.rareghast";
					skullMeta.setDisplayName(ChatColor.BLUE+"Rare Ghast Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
	  		        skullMeta.setOwner("MHF_Ghast");
					List<String> newlore = new ArrayList<String>();
					if (rare_head_type==MobHeadRareType.RARE_TYPE_A) {
						newlore.add(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"chance to send down");
						newlore.add(ChatColor.GOLD+" lightning on a target.");
					} else {
						newlore.add(ChatColor.LIGHT_PURPLE+"-5% "+ChatColor.GOLD+"damage taken on hit");
					}
					skullMeta.setLore(newlore);
	  		        newhead.setItemMeta(skullMeta);
					newhead.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
					finalhead = newhead;
				}break;
				case ZOMBIE_PIGMAN:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)SkullType.PLAYER.ordinal());
					SkullMeta skullMeta = (SkullMeta) newhead.getItemMeta();
					String key = "mob.rarezombiepigman";
					skullMeta.setDisplayName(ChatColor.BLUE+"Rare Pig Zombie Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
	  		        skullMeta.setOwner("MHF_PigZombie");
					List<String> newlore = new ArrayList<String>();
					if (rare_head_type==MobHeadRareType.RARE_TYPE_A) {
						newlore.add(ChatColor.LIGHT_PURPLE+"+10% "+ChatColor.GOLD+"chance of dropping a");
						newlore.add(ChatColor.GOLD+" Golden Nugget on a kill.");
					} else {
						newlore.add(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"chance of being fully");
						newlore.add(ChatColor.GOLD+" healed on kill.");
					}
					skullMeta.setLore(newlore);
	  		        newhead.setItemMeta(skullMeta);
					newhead.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
					finalhead = newhead;
				}break;
				case MAGMA_CUBE:{
					ItemStack newhead = new ItemStack(Material.SKULL_ITEM);
					newhead.setDurability((short)SkullType.PLAYER.ordinal());
					SkullMeta skullMeta = (SkullMeta) newhead.getItemMeta();
					String key = "mob.raremagmacube";
					skullMeta.setDisplayName(ChatColor.BLUE+"Rare Magma Cube Head "+ChatColor.ITALIC+"#"+Main.plugin.getConfig().getInt(key));
					Main.plugin.getConfig().set(key, Main.plugin.getConfig().getInt(key)+1);
	  		        skullMeta.setOwner("MHF_LavaSlime");
					List<String> newlore = new ArrayList<String>();
					if (rare_head_type==MobHeadRareType.RARE_TYPE_A) {
						newlore.add(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"chance of burning an");
						newlore.add(ChatColor.GOLD+" enemy to a crisp.");
					} else {
						newlore.add(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"chance of setting the");
						newlore.add(ChatColor.GOLD+" mob and surrounding mobs on fire");
						newlore.add(ChatColor.GOLD+" for 10 seconds.");
					}
					skullMeta.setLore(newlore);
	  		        newhead.setItemMeta(skullMeta);
					newhead.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
					finalhead = newhead;
				}break;
			}
		}
		//Bukkit.getLogger().info("Mobhead is "+toString()+" currently.");
		if (is_powered) {
			short numb = finalhead.clone().getDurability();
			ItemStack poweredhead = convertToPoweredHead(finalhead.clone());
			//Bukkit.getLogger().info("Converted head item is "+this.plugin.convertToPoweredHead(result.getMatrix()[i]).toString());
			poweredhead.setDurability(numb);
			finalhead = poweredhead;
		}
		return finalhead;
	}

    /**
     * Attempts to get the mob head object that
     * corresponds to this item, by checking its lore.
     * @param item The item to check for.
     * @return Returns null if this item is not a
     *  valid mob head. Returns the MobHead object
     *  otherwise.
     */
    static public MobHead getMobHead(ItemStack item) {
    	if (item!=null && item.getType()==Material.SKULL_ITEM && item.hasItemMeta() && item.getItemMeta().hasLore()) {
    		List<String> getLore = item.getItemMeta().getLore();
    		MobHeadType headtype = null;
    		MobHeadRareType raretype = null;
    		boolean powered = false;
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5 "+ChatColor.GOLD+"second "+ChatColor.GRAY+"Wither I"+ChatColor.GOLD+" duration")) {
    			//return new MobHead(MobHeadType.WITHER_SKELETON);
    			headtype=MobHeadType.WITHER_SKELETON;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Ranged Damage")) {
    			//return new MobHead(MobHeadType.SKELETON);
    			headtype=MobHeadType.SKELETON;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Lifesteal")) {
    			//return new MobHead(MobHeadType.ZOMBIE);
    			headtype=MobHeadType.ZOMBIE;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"AoE Damage") ||
    				getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"AoE Damage"+ChatColor.BLUE+" &")) {
    			//return new MobHead(MobHeadType.CREEPER);
    			headtype=MobHeadType.CREEPER;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"Slow on hit") ||
    				getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"Slow on hit"+ChatColor.BLUE+" &")) {
    			//return new MobHead(MobHeadType.SPIDER);
    			headtype=MobHeadType.SPIDER;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Critical Chance") ||
    				getLore.contains(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Critical Chance"+ChatColor.BLUE+" &")) {
    			//return new MobHead(MobHeadType.ENDERMAN);
    			headtype=MobHeadType.ENDERMAN;
    		}
    		if ((getLore.contains(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"second Poison duration") ||
    				getLore.contains(ChatColor.LIGHT_PURPLE+"+2 "+ChatColor.GOLD+"second Poison duration")) &&
    				!getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"Slow on hit"+ChatColor.BLUE+" &")) {
    			//return new MobHead(MobHeadType.CAVE_SPIDER);
    			headtype=MobHeadType.CAVE_SPIDER;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"second ignite duration")) {
    			//return new MobHead(MobHeadType.BLAZE);
    			headtype=MobHeadType.BLAZE;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"-1% "+ChatColor.GOLD+"damage taken on hit") ||
    				getLore.contains(ChatColor.LIGHT_PURPLE+"-1% "+ChatColor.GOLD+"damage taken on hit"+ChatColor.BLUE+" &")) {
    			//return new MobHead(MobHeadType.GHAST);
    			headtype=MobHeadType.GHAST;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"chance of being fully")) {
    			//return new MobHead(MobHeadType.ZOMBIE_PIGMAN);
    			headtype=MobHeadType.ZOMBIE_PIGMAN;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"chance of setting the")) {
    			//return new MobHead(MobHeadType.MAGMA_CUBE);
    			headtype=MobHeadType.MAGMA_CUBE;
    		}
    		boolean ampersand=false;
			for (int i=0;i<getLore.size();i++) {
				if (getLore.get(i).contains(ChatColor.BLUE+" &")) {
					powered=true;
					ampersand=true;
				}
			}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+15 "+ChatColor.GOLD+"second "+ChatColor.GRAY+"Wither III"+ChatColor.GOLD+" duration")) {
    			//return new MobHead(MobHeadType.WITHER_SKELETON, true, MobHeadRareType.RARE_TYPE_A);
    			headtype=MobHeadType.WITHER_SKELETON;
    			raretype=MobHeadRareType.RARE_TYPE_A;
    		}
    		if (getLore.contains(ChatColor.GOLD+"Stacks Wither effect by 1")) {
    			headtype=MobHeadType.WITHER_SKELETON;
    			powered=true;
    		}
    		if (getLore.contains(ChatColor.GOLD+"Stacks Wither effect by 2")) {
    			headtype=MobHeadType.WITHER_SKELETON;
    			raretype=MobHeadRareType.RARE_TYPE_A;
    			powered=true;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"Ranged Damage")) {
    			//return new MobHead(MobHeadType.SKELETON, true, MobHeadRareType.RARE_TYPE_A);
    			headtype=MobHeadType.SKELETON;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_A;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"m/s Projectile Speed")) {
    			//return new MobHead(MobHeadType.SKELETON, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.SKELETON;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_B;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"Lifesteal")) {
    			//return new MobHead(MobHeadType.ZOMBIE, true, MobHeadRareType.RARE_TYPE_A);
    			headtype=MobHeadType.ZOMBIE;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_A;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"Max Health")) {
    			//return new MobHead(MobHeadType.ZOMBIE, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.ZOMBIE;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_B;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"Damage to all nearby enemies.")) {
    			//return new MobHead(MobHeadType.CREEPER, true, MobHeadRareType.RARE_TYPE_A);
    			headtype=MobHeadType.ZOMBIE;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_A;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+20% "+ChatColor.GOLD+"AoE Damage")) {
    			//return new MobHead(MobHeadType.CREEPER, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.CREEPER;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_B;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+2 "+ChatColor.GOLD+"second Poison duration") &&
    				!getLore.contains(ChatColor.GOLD+" on hit."+ChatColor.BLUE+" &")) {
    			//return new MobHead(MobHeadType.SPIDER, true, MobHeadRareType.RARE_TYPE_A);
    			headtype=MobHeadType.SPIDER;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_A;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+15% "+ChatColor.GOLD+"Slow on hit")) {
    			//return new MobHead(MobHeadType.SPIDER, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.SPIDER;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_B;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Item Drop Amount Increase")) {
    			//return new MobHead(MobHeadType.ENDERMAN, true, MobHeadRareType.RARE_TYPE_A);
    			headtype=MobHeadType.ENDERMAN;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_A;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"Critical Chance")) {
    			//return new MobHead(MobHeadType.ENDERMAN, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.ENDERMAN;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_B;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"of snaring a target")) {
    			//return new MobHead(MobHeadType.CAVE_SPIDER, true, MobHeadRareType.RARE_TYPE_A);
    			headtype=MobHeadType.CAVE_SPIDER;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_A;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+3 "+ChatColor.GOLD+"second Poison duration")) {
    			//return new MobHead(MobHeadType.CAVE_SPIDER, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.CAVE_SPIDER;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_B;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"chance to send enemy")) {
    			//return new MobHead(MobHeadType.BLAZE, true, MobHeadRareType.RARE_TYPE_A);
    			headtype=MobHeadType.BLAZE;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_A;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+3 "+ChatColor.GOLD+"second ignite duration")) {
    			//return new MobHead(MobHeadType.BLAZE, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.BLAZE;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_B;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"chance to send down")) {
    			//return new MobHead(MobHeadType.GHAST, true, MobHeadRareType.RARE_TYPE_A);
    			headtype=MobHeadType.GHAST;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_A;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"-5% "+ChatColor.GOLD+"damage taken on hit")) {
    			//return new MobHead(MobHeadType.GHAST, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.GHAST;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_B;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+10% "+ChatColor.GOLD+"chance of dropping a")) {
    			//return new MobHead(MobHeadType.ZOMBIE_PIGMAN, true, MobHeadRareType.RARE_TYPE_A);
    			headtype=MobHeadType.ZOMBIE_PIGMAN;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_A;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"chance of being fully")) {
    			//return new MobHead(MobHeadType.ZOMBIE_PIGMAN, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.ZOMBIE_PIGMAN;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_B;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"chance of burning an")) {
    			//return new MobHead(MobHeadType.BLAZE, true, MobHeadRareType.RARE_TYPE_A);
    			headtype=MobHeadType.BLAZE;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_A;}
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"chance of setting the")) {
    			//return new MobHead(MobHeadType.BLAZE, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.BLAZE;
    			if (!ampersand) {raretype=MobHeadRareType.RARE_TYPE_B;}
    		}
    		////////////////////////////////////////////
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"-10% "+ChatColor.GOLD+"damage taken on hit"+ChatColor.BLUE+" &")) {
    			//return new MobHead(MobHeadType.BLAZE, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.GHAST;
    			raretype=MobHeadRareType.RARE_TYPE_A;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5 "+ChatColor.GOLD+"second ignite duration")) {
    			//return new MobHead(MobHeadType.BLAZE, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.BLAZE;
    			raretype=MobHeadRareType.RARE_TYPE_A;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5 "+ChatColor.GOLD+"second Poison duration")) {
    			//return new MobHead(MobHeadType.BLAZE, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.CAVE_SPIDER;
    			raretype=MobHeadRareType.RARE_TYPE_A;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+10% "+ChatColor.GOLD+"Critical Chance"+ChatColor.BLUE+" &")) {
    			//return new MobHead(MobHeadType.BLAZE, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.ENDERMAN;
    			raretype=MobHeadRareType.RARE_TYPE_A;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+30% "+ChatColor.GOLD+"Slow on hit"+ChatColor.BLUE+" &")) {
    			//return new MobHead(MobHeadType.BLAZE, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.SPIDER;
    			raretype=MobHeadRareType.RARE_TYPE_A;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+30% "+ChatColor.GOLD+"AoE Damage"+ChatColor.BLUE+" &")) {
    			//return new MobHead(MobHeadType.BLAZE, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.CREEPER;
    			raretype=MobHeadRareType.RARE_TYPE_A;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"Lifesteal"+ChatColor.BLUE+" &")) {
    			//return new MobHead(MobHeadType.BLAZE, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.ZOMBIE;
    			raretype=MobHeadRareType.RARE_TYPE_A;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"Ranged Damage"+ChatColor.BLUE+" &")) {
    			//return new MobHead(MobHeadType.BLAZE, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.SKELETON;
    			raretype=MobHeadRareType.RARE_TYPE_A;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+10% "+ChatColor.GOLD+"chance of setting the")) {
    			//return new MobHead(MobHeadType.BLAZE, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.MAGMA_CUBE;
    			raretype=MobHeadRareType.RARE_TYPE_A;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"chance of being fully")) {
    			//return new MobHead(MobHeadType.BLAZE, true, MobHeadRareType.RARE_TYPE_B);
    			headtype=MobHeadType.ZOMBIE_PIGMAN;
    			raretype=MobHeadRareType.RARE_TYPE_A;
    		}
    		if (getLore.contains(ChatColor.GOLD+"Stacks Wither effect by 2") || getLore.contains(ChatColor.GOLD+"Stacks Wither effect by 1")) {
    			powered=true;
    		}
    		if (raretype!=null) {
    			return new MobHead(headtype,true,raretype,powered);
    		} else {
    			return new MobHead(headtype,false,powered);
    		}
    	}
    	return null;
    }
    
    /**
     * Checks if the given head is powered or
     * unpowered.
     * @param head The mob head to check for.
     * @return Returns true if the head is unpowered
     * or false otherwise.
     */
    static public boolean isUnpoweredHead(MobHead head) {
    	return !head.is_powered;
    }

    /**
     * Converts an unpowered mob head to a powered
     * version. If this head is not an unpowered version
     * or something bad happens along the way, it
     * simply returns the same ItemStack that was
     * given.
     * @param item The head item we are converting.
     * @return The converted mob head. (Or the same
     *  mob head that was given if something bad
     *  happened.)
     */
    static public ItemStack convertToPoweredHead(ItemStack item) {
    	if (item!=null && item.getType()==Material.SKULL_ITEM && item.hasItemMeta() && item.getItemMeta().hasLore()) {
    		ItemStack newitem = new ItemStack(Material.SKULL_ITEM);
    		List<String> getLore = item.getItemMeta().getLore();
    		ItemMeta newitem_meta = item.getItemMeta();
    		newitem.setData(item.getData());
    		if (newitem_meta.getDisplayName().contains("Rare")) { 
    			newitem_meta.setDisplayName(ChatColor.BLUE+"Powered "+newitem_meta.getDisplayName());
    		} else {
    			newitem_meta.setDisplayName(ChatColor.RESET+"Powered "+newitem_meta.getDisplayName());
    		}
    		newitem.setItemMeta(newitem_meta);
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5 "+ChatColor.GOLD+"second "+ChatColor.GRAY+"Wither I"+ChatColor.GOLD+" duration")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.GOLD+"Stacks Wither effect by 1");
    			newLore.add(ChatColor.GOLD+"per hit for 5 seconds.");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Ranged Damage")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Ranged Damage "+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"m/s Projectile Speed");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Lifesteal")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Lifesteal"+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"Max Health");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"AoE Damage")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"AoE Damage"+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"Damage over time to");
    			newLore.add(ChatColor.GOLD+" all nearby enemies.");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"Slow on hit")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"Slow on hit"+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"second Poison duration");
    			newLore.add(ChatColor.GOLD+" on hit.");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Critical Chance")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Critical Chance"+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Item Drop Increase");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"second Poison duration")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+2 "+ChatColor.GOLD+"second Poison duration");
    			newLore.add(ChatColor.GOLD+" on hit."+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"chance of snaring the");
    			newLore.add(ChatColor.GOLD+" target for 5 seconds.");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"second ignite duration")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"second ignite duration");
    			newLore.add(ChatColor.GOLD+" on hit."+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"chance of sending the");
    			newLore.add(ChatColor.GOLD+" enemy airborne.");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"-1% "+ChatColor.GOLD+"damage taken on hit")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"-1% "+ChatColor.GOLD+"damage taken on hit"+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"chance to send down");
    			newLore.add(ChatColor.GOLD+" lightning onto your enemy.");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"chance of being fully")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"chance of being fully");
    			newLore.add(ChatColor.GOLD+" healed on a kill."+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"chance of dropping a");
    			newLore.add(ChatColor.GOLD+" Golden Nugget on a kill");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"chance of setting the")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"chance of setting the");
    			newLore.add(ChatColor.GOLD+" mob and surrounding mobs on fire");
    			newLore.add(ChatColor.GOLD+" for 10 seconds."+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"chance of burning an");
    			newLore.add(ChatColor.GOLD+" enemy to a crisp.");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+15 "+ChatColor.GOLD+"second "+ChatColor.GRAY+"Wither III"+ChatColor.GOLD+" duration")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.GOLD+"Stacks Wither effect by 2");
    			newLore.add(ChatColor.GOLD+"per hit for 20 seconds.");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"Ranged Damage") ||
    				getLore.contains(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"m/s Projectile Speed")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"Ranged Damage"+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+3 "+ChatColor.GOLD+"m/s Projectile Speed");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"Lifesteal") ||
    				getLore.contains(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"Max Health")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"Lifesteal"+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+4 "+ChatColor.GOLD+"Max Health");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1 "+ChatColor.GOLD+"Damage to all nearby enemies.") ||
    				getLore.contains(ChatColor.LIGHT_PURPLE+"+20% "+ChatColor.GOLD+"AoE Damage")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+30% "+ChatColor.GOLD+"AoE Damage"+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+3 "+ChatColor.GOLD+"Damage over time to");
    			newLore.add(ChatColor.GOLD+" all nearby enemies.");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+2 "+ChatColor.GOLD+"second Poison duration") ||
    				getLore.contains(ChatColor.LIGHT_PURPLE+"+15% "+ChatColor.GOLD+"Slow on hit")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+30% "+ChatColor.GOLD+"Slow on hit"+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+5 "+ChatColor.GOLD+"second Poison duration");
    			newLore.add(ChatColor.GOLD+" on hit.");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+1% "+ChatColor.GOLD+"Item Drop Amount Increase") ||
    				getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"Critical Chance")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+10% "+ChatColor.GOLD+"Critical Chance"+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"Item Drop Increase");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"of snaring a target") ||
    				getLore.contains(ChatColor.LIGHT_PURPLE+"+3 "+ChatColor.GOLD+"second Poison duration")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+5 "+ChatColor.GOLD+"second Poison duration");
    			newLore.add(ChatColor.GOLD+" on hit."+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+8% "+ChatColor.GOLD+"chance of snaring the");
    			newLore.add(ChatColor.GOLD+" target for 5 seconds.");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"chance to send enemy") ||
    				getLore.contains(ChatColor.LIGHT_PURPLE+"+3 "+ChatColor.GOLD+"second ignite duration")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+5 "+ChatColor.GOLD+"second ignite duration");
    			newLore.add(ChatColor.GOLD+" on hit."+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+10% "+ChatColor.GOLD+"chance of sending the");
    			newLore.add(ChatColor.GOLD+" enemy airborne.");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"chance to send down") ||
    				getLore.contains(ChatColor.LIGHT_PURPLE+"-5% "+ChatColor.GOLD+"damage taken on hit")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"-10% "+ChatColor.GOLD+"damage taken on hit"+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+10% "+ChatColor.GOLD+"chance to send down");
    			newLore.add(ChatColor.GOLD+" lightning onto your enemy.");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+10% "+ChatColor.GOLD+"chance of dropping a") ||
    				getLore.contains(ChatColor.LIGHT_PURPLE+"+3% "+ChatColor.GOLD+"chance of being fully")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"chance of being fully");
    			newLore.add(ChatColor.GOLD+" healed on a kill."+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+20% "+ChatColor.GOLD+"chance of dropping a");
    			newLore.add(ChatColor.GOLD+" Golden Nugget on a kill");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    		if (getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"chance of burning an") ||
    				getLore.contains(ChatColor.LIGHT_PURPLE+"+5% "+ChatColor.GOLD+"chance of setting the")) {
    			ItemMeta meta = newitem.getItemMeta();
    			List<String> newLore = new ArrayList<String>();
    			newLore.add(ChatColor.LIGHT_PURPLE+"+10% "+ChatColor.GOLD+"chance of setting the");
    			newLore.add(ChatColor.GOLD+" mob and surrounding mobs on fire");
    			newLore.add(ChatColor.GOLD+" for 10 seconds."+ChatColor.BLUE+" &");
    			newLore.add(ChatColor.LIGHT_PURPLE+"+10% "+ChatColor.GOLD+"chance of burning an");
    			newLore.add(ChatColor.GOLD+" enemy to a crisp.");
    			meta.setLore(newLore);
    			newitem.setItemMeta(meta);
    			return newitem;
    		}
    	}
    	return item;
    }
	@Override
	public String toString() {
		return "MobHead(Type: "+(head_type!=null?head_type.name():"null")+", Rare Type: "+(rare_head_type!=null?rare_head_type.name():"null")+", is_rare:"+rare_head+", is_powered:"+is_powered+")";
	}
	public MobHead(MobHeadType head_type) {
		MobHead(head_type, false, MobHeadRareType.RARE_TYPE_A, false);
	}
	public MobHead(MobHeadType head_type, boolean is_rare) {
		MobHead(head_type, is_rare, MobHeadRareType.RARE_TYPE_A, false);
	}
	public MobHead(MobHeadType head_type, boolean is_rare, MobHeadRareType rare_head_type) {
		MobHead(head_type, is_rare, rare_head_type, false);
	}
	public MobHead(MobHeadType head_type, boolean is_rare, boolean is_powered) {
		MobHead(head_type, is_rare, MobHeadRareType.RARE_TYPE_A, is_powered);
	}
	public MobHead(MobHeadType head_type, boolean is_rare, MobHeadRareType rare_head_type, boolean is_powered) {
		MobHead(head_type, is_rare, rare_head_type, is_powered);
	}
	void MobHead(MobHeadType head_type, boolean is_rare, MobHeadRareType rare_head_type, boolean is_powered) {
		this.head_type=head_type;
		this.rare_head_type=rare_head_type;
		this.rare_head=is_rare;
		this.is_powered=is_powered;
	}
}