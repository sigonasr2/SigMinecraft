package sig.ItemSets;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemSetList {
	enum Armor {HELMET, CHESTPLATE, LEGGINGS, BOOTS};
	List<ItemSet> itemsetlist = null;
	/**
	 * Initializes the Item Set list for adding data and manipulating.
	 */
	public void Init() {
		itemsetlist = new ArrayList<ItemSet>();
	}
	/**
	 * 
	 * @param set The ItemSet to add to the list.
	 * @return Returns the size of the item set list after adding in the ItemSet.
	 */
	public int addSet(ItemSet set) {
		itemsetlist.add(set);
		return itemsetlist.size();
	}
	/**
	 * 
	 * @param title The title of the item set.
	 * @return Returns the size of the item list after removing the ItemSet.
	 */
	public int removeSet(String title) {
		int itemset_slot=-1;
		if ((itemset_slot=getSetSlot(title))!=-1) {
			itemsetlist.remove(itemset_slot);
		}
		return itemsetlist.size();
	}
	/**
	 * Generates a random set item.
	 * @return Returns the ItemStack of the new set item.
	 */
	public ItemStack randomizeSetItem() {
		
	}
	/**
	 * The function that hooks into the rest of the item sets.
	 * @param item The ItemStack to check.
	 * @return Returns true if this item is identified as a set item,
	 *  false otherwise.
	 */
	public boolean isSetItem(ItemStack item) {
		//A set item is identified by its name. It could be unidentified too.
		if (item.hasItemMeta()) {
			ItemMeta meta = item.getItemMeta();
			String name = meta.getDisplayName();
			//Parse the name and see if it has the characteristics of a set item.
			if (name.contains(ChatColor.GREEN+"") || name.contains(ChatColor.GREEN+""+ChatColor.MAGIC+"")) {
				//It is considered a set item.
				return true;
			} else {
				return false;
			}
		} else {
			//If it has no metadata, it can't possible be a set item.
			return false;
		}
	}
	/**
	 * Extracts the set name from the item.
	 * @param item The ItemStack to extract the item from.
	 * @return Returns the name of the set. Returns null
	 *  if this item is not a set item.
	 */
	public String getSetName(ItemStack item) {
		if (item.hasItemMeta()) {
			ItemMeta meta = item.getItemMeta();
			String name = meta.getDisplayName();
			//Parse the name and see if it has the characteristics of a set item.
			if (name.contains(ChatColor.GREEN+"") || name.contains(ChatColor.GREEN+""+ChatColor.MAGIC+"")) {
				//Return the first name.
				if (name.contains(ChatColor.GREEN+""+ChatColor.MAGIC+"")) {
					return name.substring(name.indexOf(ChatColor.GREEN+""+ChatColor.MAGIC+""), name.indexOf(" "));
				} else {
					return name.substring(name.indexOf(ChatColor.GREEN+""), name.indexOf(" "));
				}
			} else {
				return null;
			}
		} else {
			//If it has no metadata, it can't possible be a set item.
			return null;
		}
	}
	/**
	 * 
	 * @param set_slot The slot in the item set list.
	 * @return Returns the title of the item set.
	 */
	public String getSetTitle(int set_slot) {
		return itemsetlist.get(set_slot).name;
	}
	/**
	 * 
	 * @param title The title of the set.
	 * @param type The armor type.
	 * @return Returns the color of the specified armor type in the item set.
	 * 	Returns null if it couldn't find the item set or an invalid armor
	 *  type was provided.
	 */
	public Color getSetColor(String title,Armor type) {
		int set_slot=-1;
		if ((set_slot=getSetSlot(title))!=-1) {
			switch (type) {
				case HELMET: {
					return itemsetlist.get(set_slot).colors.helmet;
				}
				case CHESTPLATE: {
					return itemsetlist.get(set_slot).colors.chestplate;
				}
				case LEGGINGS: {
					return itemsetlist.get(set_slot).colors.leggings;
				}
				case BOOTS: {
					return itemsetlist.get(set_slot).colors.boots;
				}
				default:{
					return null;
				}
			}
		} else {
			return null;
		}
	}
	/**
	 * 
	 * @param title A title of an item set.
	 * @return Returns the number of the slot in the itemsetlist if it is found.
	 *  Otherwise returns -1.
	 */
	private int getSetSlot(String title) {
		for (int i=0;i<itemsetlist.size();i++) {
			if (itemsetlist.get(i).name.equalsIgnoreCase(title)) {
				return i;
			}
		}
		return -1;
	}
}
