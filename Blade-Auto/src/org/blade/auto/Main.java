package org.blade.auto;

import org.blade.auto.AutoBench.AutoBench;
import org.blade.auto.AutoBench.AutoBenchAccept;
import org.blade.auto.AutoBench.AutoBenchMenu;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private ConfigManager cfmg;
	
	@Override
	public void onEnable() {
		loadConfigManager();
		loadConfig();
		//eventhandler
		getServer().getPluginManager().registerEvents(new AutoBench(), this);
		getServer().getPluginManager().registerEvents(new AutoBenchMenu(), this);
		getServer().getPluginManager().registerEvents(new AutoBenchAccept(),this);
		//custom item
		Wrench w=new Wrench();
		w.customRecepie();
	}
	@Override
	public void onDisable() {
		
	}
//custom config for data storage	
	public void loadConfigManager() {
		cfmg=new ConfigManager();
		cfmg.setup();
		cfmg.saveTable();
		cfmg.reloadTable();
	}
	public ConfigManager getcfmg() {
		return cfmg;
	}
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	

}
