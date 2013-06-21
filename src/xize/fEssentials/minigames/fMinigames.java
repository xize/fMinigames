package xize.fEssentials.minigames;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import xize.fEssentials.minigames.configuration.config;

public class fMinigames extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	private config Config = new config(this);
	
	public void onEnable() {
		if(Bukkit.getPluginManager().isPluginEnabled("fEssentials")) {
			log.info("[fMiniGames] MiniGames plugin enabled!");
			Config.createConfigs();
		} else {
			log.info("[fMiniGames] The minigames plugin has been disabled, fEssentials core is needed to enable this plugin part!");
			Bukkit.getPluginManager().disablePlugin(this);
		}
	}
	
	public void onDisable() {
		log.info("[fMiniGames] MiniGames plugin disabled!");
	}

}
