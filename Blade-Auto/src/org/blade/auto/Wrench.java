package org.blade.auto;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class Wrench implements Listener {

	private Main plugin=Main.getPlugin(Main.class);
	public void customRecepie() {
		ItemStack wrench=new ItemStack(Material.BLAZE_ROD);
		ItemMeta meta=wrench.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA+"Wrench");
		wrench.setItemMeta(meta);
		
		@SuppressWarnings("deprecation")
		ShapedRecipe r =new ShapedRecipe(wrench);
		r.shape("#  "," $ ","  $");
		r.setIngredient('#', Material.IRON_INGOT);
		r.setIngredient('$', Material.STICK);
		plugin.getServer().addRecipe(r);
		
	}
	
}
