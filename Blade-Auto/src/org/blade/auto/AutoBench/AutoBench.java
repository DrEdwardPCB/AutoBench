package org.blade.auto.AutoBench;

import org.blade.auto.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class AutoBench implements Listener{
	private Main plugin=Main.getPlugin(Main.class);
	
	@EventHandler
	public void onMarked(PlayerInteractEvent e) {
		if(!e.hasBlock()) {return;}
		if(!e.hasItem()) {return;}
		if(e.getAction()==Action.RIGHT_CLICK_BLOCK&&e.getClickedBlock().getType().equals(Material.WORKBENCH)) {
			if(!e.getItem().hasItemMeta()) {return;}
			if(e.getItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+"Wrench")) {
				Block block=e.getClickedBlock();
				if(plugin.getcfmg().getTable().get("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ())==null) {
					newTable(block);
				}
				e.setCancelled(true);
				AutoBenchMenu am=new AutoBenchMenu();
				am.generateAutoTable(block.getLocation().getBlockX(),block.getLocation().getBlockY(),block.getLocation().getBlockZ(),e.getPlayer());
			}
		}else {
			return;
		}
		
	}
	@EventHandler
	public void onDestroy(BlockBreakEvent e) {
		Location l=e.getBlock().getLocation();
		if(plugin.getcfmg().getTable().contains("Table."+l.getBlockX()+","+l.getBlockY()+","+l.getBlockZ())) {
			AutoBenchMenu am=new AutoBenchMenu();
			am.popoutstuff(l);
			plugin.getcfmg().getTable().set("Table."+l.getBlockX()+","+l.getBlockY()+","+l.getBlockZ(),null);
		}
		plugin.getcfmg().saveTable();
		
	}
	
	public void newTable(Block block) {
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Location.x",block.getLocation().getBlockX());
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Location.y",block.getLocation().getBlockY());
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Location.z",block.getLocation().getBlockZ());
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.0.item","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.1.item","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.2.item","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.3.item","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.4.item","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.5.item","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.6.item","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.7.item","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.8.item","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.0.count","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.1.count","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.2.count","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.3.count","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.4.count","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.5.count","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.6.count","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.7.count","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.8.count","");
		plugin.getcfmg().getTable().set("Table."+block.getLocation().getBlockX()+","+block.getLocation().getBlockY()+","+block.getLocation().getBlockZ()+".Recipe.result.item","");
		plugin.getcfmg().saveTable();
	}

}
