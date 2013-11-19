package me.kaZep.Base;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

//A RecyclingCenterNode is basically one location that Recycling Centers can deposit to.
//When items are despawned, they check all recycling center nodes for possible places to
//deposit, choosing the closest one.
public class RecyclingCenterNode {
	
	public static double chanceincrease = 3.0; //The amount of chance that each item will increase the chest as it gets placed. Increase this for less items.
	public static double chestdecrease = 0.05; //The amount of chance that each item will decrease the chest. Increase this for more items.
	//Store our items we can give out array along with our rare items we might potentially track.
	public static int[] items = {1,3,4,5,6,12,13,14,15,17,18,20,22,23,24,25,27,28,39,31,32,33,35,37,38,39,40,41,42,44,45,46,47,48,49,50,53,54,57,58,61,65,66,67,69,70,72,76,77,78,80,81,82,84,85,86,87,88,89,91,96,98,101,102,103,106,107,108,109,111,112,113,114,116,121,122,123,126,128,130,131,133,134,135,136,138,139,143,145,146,147,148,151,152,154,155,156,157,158,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355,356,357,358,359,360,361,362,363,364,365,366,367,368,369,370,371,372,373,374,375,376,377,378,379,380,381,382,385,386,387,388,389,390,391,392,393,394,395,396,397,398,399,400,401,402,403,404,405,406,407,408,2256,2257,2258,2259,2260,2261,2262,2263,2264,2265,2266,2267};
	//Rare items can only be given out in quantities of 1. To prevent massive amounts of OP. 
	public static int[] rareitems = {173,263,256,257,258,265,267,306,307,308,309,417,266,283,284,285,286,314,315,316,317,322,418,57,264,276,277,278,279,310,311,312,313,419,14,15,16,21,73,56,129,41,46,57,116,122,133,130,146,151,264,266,276,277,278,279,293,310,311,312,313,368,381,406};
	public static int[] unalloweditems = {127,7,11,9,19,32,34,59,141,142,405,26,31,51,63,64,68,71,78,90,117,118,119,127,137,140,144,383};
	List<Location> locations; //List of all chest locations for this Node.
	int itemslot; //Stores the current item we are on in that chest. From 0-26.
	double chance; //The chance we will let an item in. This increases over time to prevent overpopulation.
	Main plugin;

	public RecyclingCenterNode(Main plugin) {
		this.locations = new ArrayList<Location>();
		itemslot = (int)(Math.random()*27d);
		chance = (int)(Math.random()*8d);
		this.plugin = plugin;
	}
	
	public RecyclingCenterNode(List<Location> locations, Main plugin) {
		this.locations = locations;
		itemslot = (int)(Math.random()*27d);
		chance = (int)(Math.random()*8d);
		this.plugin = plugin;
	}
	
	public void addChest(Location loc) {
		locations.add(loc);
	}
	
	public void swapItem(RecyclingCenterNode center) {
		//Swaps an item with another Recycling Center.
		int chest=(int)(Math.random()*locations.size());
		int chest2=(int)(Math.random()*locations.size());
		ItemStack item1 = null;
		ItemStack item2 = null;
		if (locations.get(chest).getBlock().getState() instanceof Chest) {
			Chest c = (Chest)locations.get(chest).getBlock().getState();
			int my_itemslot = (int)(Math.random()*27);
			if (c.getBlockInventory().getItem(my_itemslot)!=null) {
				item1 = c.getBlockInventory().getItem(my_itemslot);
				c.getBlockInventory().remove(my_itemslot);
			}
		}
		chest2=(int)(Math.random()*center.locations.size());
		if (center.locations.get(chest2).getBlock().getState() instanceof Chest) {
			Chest c = (Chest)center.locations.get(chest2).getBlock().getState();
			int my_itemslot = (int)(Math.random()*27);
			if (c.getBlockInventory().getItem(my_itemslot)!=null) {
				item2 = c.getBlockInventory().getItem(my_itemslot);
				c.getBlockInventory().remove(my_itemslot);
			}
		}
		if (item2!=null) {
			if (locations.get(chest).getBlock().getState() instanceof Chest) {
				Chest c = (Chest)locations.get(chest).getBlock().getState();
				int my_itemslot = (int)(Math.random()*27);
				if (c.getBlockInventory().getItem(my_itemslot)!=null) {
					c.getBlockInventory().remove(my_itemslot);
				}
				c.getBlockInventory().setItem(my_itemslot,item2);
			}
		}
		if (item1!=null) {
			if (center.locations.get(chest2).getBlock().getState() instanceof Chest) {
				Chest c = (Chest)center.locations.get(chest2).getBlock().getState();
				int my_itemslot = (int)(Math.random()*27);
				if (c.getBlockInventory().getItem(my_itemslot)!=null) {
					c.getBlockInventory().remove(my_itemslot);
				}
				c.getBlockInventory().setItem(my_itemslot,item1);
			}
		}
	}
	
	public void recycleItem(ItemStack item) {
		if (item.getItemMeta().hasDisplayName()==false) {
			//Choose one of the random recycling centers.
			int center=(int)(Math.random()*locations.size());
			double tempchance = chance; //Store the current chance so we can check for duplicates.
			if (locations.get(center).getBlock().getState() instanceof Chest) {
				Chest c = (Chest)locations.get(center).getBlock().getState();
				  for (int y=0;y<27;y++) {
					  if (c.getBlockInventory().getItem(y)!=null && c.getBlockInventory().getItem(y).getType()==item.getType()) {
						  tempchance*=2.0d;
					  }
				  }
				  if (Math.random()*tempchance<1.0d) {
					  boolean contains=false;
					  for (int k=0;k<unalloweditems.length;k++) {
						  if (itemslot==unalloweditems[k]) {
							  contains=true;
							  break;
						  }
					  }
					  if (!contains) { //Make sure this is not an invalid item.
						  //Deposit item. Set chance higher.
						  if (c.getBlockInventory().getItem(itemslot)!=null) {
							  c.getBlockInventory().remove(itemslot);
						  }
						  c.getBlockInventory().setItem(itemslot,item);
						  itemslot=(itemslot+1)%27;
						  chance+=chanceincrease;
						  //Random item chance increases as we get more and more drops.
						  if (this.plugin.randomitemchance>8.0d) {
							  this.plugin.randomitemchance-=1d;
						  }
					  }
				  } else {
					  if (Math.random()*this.plugin.randomitemchance<1.0d) {
						  int item1 = items[(int)(Math.random()*items.length)];
						  ItemStack newitem = item;
						  newitem.setTypeId(item1);
						  boolean contains=false;
						  for (int k=0;k<rareitems.length;k++) {
							  if (item1==rareitems[k]) {
								  contains=true;
								  break;
							  }
						  }
						  if (contains) {
							  //This is a rare item! We increase the random item chance a ton! Also only allow 1 to be in there.
							  newitem.setAmount(1);
							  this.plugin.randomitemchance+=1600d;
						  }
						  if (c.getBlockInventory().getItem(itemslot)!=null) {
							  c.getBlockInventory().remove(itemslot);
						  }
						  c.getBlockInventory().setItem(itemslot,newitem);
						  //Regardless if it's rare or not, increase the random item chance by 100. We won't do this again for awhile.
						  this.plugin.randomitemchance+=300d;
					  } else {
						  if (this.plugin.randomitemchance>8.0d) {
							  this.plugin.randomitemchance-=1d;
						  }
					  }
					  if (chance>=chestdecrease) {
						  //Lower this value so next time there is a higher chance we deposit an item here.
						chance-=chestdecrease;
					  }
					  itemslot=(itemslot+1)%27;
				  }
			}
		}
	}
}