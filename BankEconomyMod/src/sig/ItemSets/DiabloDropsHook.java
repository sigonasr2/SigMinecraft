package sig.ItemSets;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import com.modcrafting.diablodrops.DiabloDrops;

public class DiabloDropsHook {
	/**
	 * 
	 * (Note that these are defined in /plugins/Diablodrops/tier.yml. They could be modified if you really wanted to!
	 * Legendary - (Gold Color) Up to 7 enchantments, up to level 10.
	 * Lore - (Yellow Color) Up to 7 enchantments, up to level 9.
	 * Magical - (Blue Color) Up to 3 enchantments, up to level 4.
	 * Rare - (Red Color) Up to 5 enchantments, up to level 5.
	 * Set - (Green Color) Up to 7 enchantments, up to level 6.
	 * Unidentified - (Magic Letters) Up to 10 enchantments, up to level 10.
	 * 
	 */
	public enum Tier {Legendary, Lore, Magical, Rare, Set, Unidentified};
	
	public static ItemStack getRandomItem() {
		return DiabloDrops.getInstance().getDropAPI().getItem();
	}
	public static ItemStack getRandomItem(Material mat) {
		//Returns a random Diablodrops item that is of a certain material type..
		return DiabloDrops.getInstance().getDropAPI().getItem(mat);
	}
	public static ItemStack getTierItem(Tier tier) {
		//Returns a random Diablodrops item that is of a certain tier type.. (Use the Tier enum types)
		return DiabloDrops.getInstance().getDropAPI().getItem(DiabloDrops.getInstance().getDropAPI().getTier(tier.name()));
	}
	public static ItemStack getTierItem(Material mat, Tier tier) {
		//Returns a random Diablodrops item that is of a certain material type and tier type.. (Use the Tier enum types)
		return DiabloDrops.getInstance().getDropAPI().getItem(mat, DiabloDrops.getInstance().getDropAPI().getTier(tier.name()));
	}
	public static ItemStack getItem(ItemStack i) {
		//Turns an item into a Diablodrops special item.
		return DiabloDrops.getInstance().getDropAPI().getItem(i);
	}
	public static void fillChest(Block b, int size) {
		//Fills a specified chest in the world with loot.
		DiabloDrops.getInstance().getDropAPI().fillChest(b, size);
	}
}
