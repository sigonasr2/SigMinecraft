package sig.ItemSets;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import com.modcrafting.diablodrops.DiabloDrops;

public class DiabloDropsHook {
	enum Tier {Legendary, Lore, Magical, Rare, Set, Unidentified};
	
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
	public void fillChest(Block b, int size) {
		//Fills a specified chest in the world with loot.
		DiabloDrops.getInstance().getDropAPI().fillChest(b, size);
	}
}
