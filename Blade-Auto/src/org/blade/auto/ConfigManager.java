package org.blade.auto;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
	
	private Main plugin=Main.getPlugin(Main.class);
	//Files and file configs
	public FileConfiguration autoTablecfg;
	public File autoTable;
	public void setup() {
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		autoTable= new File(plugin.getDataFolder(),"autoTable.yml");
		if(!autoTable.exists()) {
			try{
				autoTable.createNewFile();
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN+"The autoTable.yml file has been created successfully");
			}catch(IOException e) {
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"Could not create autoTable.yml file");
			}
		}
		autoTablecfg=YamlConfiguration.loadConfiguration(autoTable);
	}
	public FileConfiguration getTable() {
		return autoTablecfg;
	}
	public void saveTable() {
		try {
			autoTablecfg.save(autoTable);
			//Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN+"The autoTable.yml file has been save successfully");
		}catch(IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"Could not save autoTable.yml file");
		}
	}
	public void reloadTable() {
		autoTablecfg=YamlConfiguration.loadConfiguration(autoTable);
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.BLUE+"The autoTable.yml file has been reload");
	}

}
