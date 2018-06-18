package org.blade.auto;

import java.util.HashMap;

import org.blade.auto.AutoBench.AutoBench;
import org.blade.auto.AutoBench.AutoBenchAccept;
import org.blade.auto.AutoBench.AutoBenchMenu;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private ConfigManager cfmg;
	public HashMap<String,Long> ltable;
	
	@Override
	public void onEnable() {
		loadConfigManager();
		loadConfig();
		//eventhandler
		getServer().getPluginManager().registerEvents(new AutoBench(), this);
		getServer().getPluginManager().registerEvents(new AutoBenchMenu(), this);
		getServer().getPluginManager().registerEvents(new AutoBenchAccept(),this);
		//custom item
		ltable=new HashMap<String,Long>();
		if(cfmg.getTable().contains("Table")) {
			for(String key:cfmg.getTable().getConfigurationSection("Table").getKeys(false)) {
				ltable.put(key, System.currentTimeMillis());
				System.out.println(key);
			}
		}
		Wrench w=new Wrench();
		w.customRecepie();
	}
	@Override
	public void onDisable() {
		ltable.clear();
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
