package org.blade.auto.AutoBench;

import java.util.ArrayList;
import java.util.HashMap;

import org.blade.auto.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Hopper;

public class AutoBenchAccept implements Listener{
	private Main plugin=Main.getPlugin(Main.class);
	//listen to above hopper
	@EventHandler
	public void Inventorytransfer(InventoryMoveItemEvent e) {
		
		if(e.getDestination().getLocation().getBlock().getType()==Material.HOPPER) {
			Hopper hop=(Hopper) e.getDestination().getLocation().getBlock().getState().getData();
			if(hop.isPowered()) {
				return;
			}
			if(hop.getFacing().equals(BlockFace.DOWN)) {
				Location loc=e.getDestination().getLocation();
				Location locs=new Location(loc.getWorld(),loc.getX(),loc.getY()-1,loc.getZ());
				//System.out.println(locs.getBlockX()+" "+locs.getBlockY()+" "+locs.getBlockZ());
				//System.out.println(plugin.getcfmg().getTable().contains("Table."+locs.getBlockX()+","+locs.getBlockY()+","+locs.getBlockZ()+".Location.x"));
				if(plugin.getcfmg().getTable().contains("Table."+locs.getBlockX()+","+locs.getBlockY()+","+locs.getBlockZ()+".Location.x")) {
					//System.out.println("4");
					//hashmap key=item name storing Arraylist of id from 0-8;
					HashMap<ItemStack,ArrayList<Integer>> ih = new HashMap<ItemStack,ArrayList<Integer>>();
					for(int i=0;i<9;i++) {
						if(!plugin.getcfmg().getTable().get("Table."+locs.getBlockX()+","+locs.getBlockY()+","+locs.getBlockZ()+".Recipe."+i+".item").equals("")) {
							//System.out.println(i);
							if(ih.containsKey(plugin.getcfmg().getTable().get("Table."+locs.getBlockX()+","+locs.getBlockY()+","+locs.getBlockZ()+".Recipe."+i+".item"))) {
								ih.get(plugin.getcfmg().getTable().get("Table."+locs.getBlockX()+","+locs.getBlockY()+","+locs.getBlockZ()+".Recipe."+i+".item")).add(i);
							}else {
								ArrayList<Integer>ic = new ArrayList<Integer>();
								ic.add(i);
								ih.put((ItemStack)plugin.getcfmg().getTable().get("Table."+locs.getBlockX()+","+locs.getBlockY()+","+locs.getBlockZ()+".Recipe."+i+".item"), ic);
							}
						}
					}
					//putting the item inside the count accordingly
					if(ih.containsKey(e.getItem())) {
						int min_number=100;
						int min_id=-1;
						for(int i:ih.get(e.getItem())) {
							if(plugin.getcfmg().getTable().getInt("Table."+locs.getBlockX()+","+locs.getBlockY()+","+locs.getBlockZ()+".Recipe."+i+".count")<min_number) {
								min_number=plugin.getcfmg().getTable().getInt("Table."+locs.getBlockX()+","+locs.getBlockY()+","+locs.getBlockZ()+".Recipe."+i+".count");
								min_id=i;
							}
						}
						plugin.getcfmg().getTable().set("Table."+locs.getBlockX()+","+locs.getBlockY()+","+locs.getBlockZ()+".Recipe."+min_id+".count",plugin.getcfmg().getTable().getInt("Table."+locs.getBlockX()+","+locs.getBlockY()+","+locs.getBlockZ()+".Recipe."+min_id+".count")+1);
						plugin.getcfmg().saveTable();
						plugin.getServer().getScheduler().runTaskLater(plugin,
								new Runnable() {
							public void run() {
								e.getDestination().remove(e.getItem());
							}
						}
								, 2L);
					}	
					//check whether all item >1
					boolean canCraft=true;
					for(ItemStack key:ih.keySet()) {
						for(int i:ih.get(key)) {
							if(plugin.getcfmg().getTable().getInt("Table."+locs.getBlockX()+","+locs.getBlockY()+","+locs.getBlockZ()+".Recipe."+i+".count")==0) {
								//System.out.println(i);
								canCraft=false;
							}
						}
					}
					if(canCraft&&!plugin.getcfmg().getTable().getString("Table."+locs.getBlockX()+","+locs.getBlockY()+","+locs.getBlockZ()+".Recipe.result.item").equals("")) {

						for(int i=0;i<9;i++) {
							if(!plugin.getcfmg().getTable().getString("Table."+locs.getBlockX()+","+locs.getBlockY()+","+locs.getBlockZ()+".Recipe."+i+".item").equals("")) {
								plugin.getcfmg().getTable().set("Table."+locs.getBlockX()+","+locs.getBlockY()+","+locs.getBlockZ()+".Recipe."+i+".count",plugin.getcfmg().getTable().getInt("Table."+locs.getBlockX()+","+locs.getBlockY()+","+locs.getBlockZ()+".Recipe."+i+".count")-1);
								plugin.getcfmg().saveTable();
							}
									
						}
						locs.getWorld().dropItem(locs,(ItemStack)plugin.getcfmg().getTable().get("Table."+locs.getBlockX()+","+locs.getBlockY()+","+locs.getBlockZ()+".Recipe.result.item"));
						System.out.println("successfully create an item");
						//e.getDestination().remove(e.getItem());
					}
					//ih.clear();
				}else {
					return;
				}
			}else {
				return;
			}
		}else {
			return;
		}
	}

}
