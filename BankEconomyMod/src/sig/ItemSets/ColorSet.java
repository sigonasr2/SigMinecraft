package sig.ItemSets;

import org.bukkit.Color;


/**
 * A collection of colors that defines an item set.
 */
public class ColorSet {
	Color helmet, chestplate, leggings, boots;
	/**
	 * 
	 * @param helmet The helmet's Color.
	 * @param chestplate The chestplate's Color.
	 * @param leggings The leggings' Color.
	 * @param boots The boots' Color.
	 */
	public ColorSet(Color helmet, Color chestplate, Color leggings, Color boots) {
		this.helmet=helmet;
		this.chestplate=chestplate;
		this.leggings=leggings;
		this.boots=boots;
	}
}