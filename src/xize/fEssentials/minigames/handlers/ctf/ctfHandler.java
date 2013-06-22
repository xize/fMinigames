package xize.fEssentials.minigames.handlers.ctf;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

import xize.fEssentials.minigames.fMinigames;
import xize.fEssentials.minigames.listeners.ctf.autorespawn;

public class ctfHandler {
	fMinigames plugin;
	public ctfHandler(fMinigames plugin) {
		this.plugin = plugin;
	}
	
	public void launch() {
		if(getKey("ctf.system.autorespawn")) {getListener(new autorespawn(plugin));}
	}
	
	public boolean getKey(String path) {
		try {
			File f = new File(plugin.getDataFolder() + File.separator + "ctf.yml");
			if(f.exists()) {
				FileConfiguration con = YamlConfiguration.loadConfiguration(f);
				if(con.getBoolean(path)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void getListener(Listener listener) {
		Bukkit.getPluginManager().registerEvents(listener, plugin);
	}

}
