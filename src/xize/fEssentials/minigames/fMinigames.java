package xize.fEssentials.minigames;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class fMinigames extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable() {
		if(Bukkit.getPluginManager().isPluginEnabled("fEssentials")) {
			log.info("[fMiniGames] MiniGames plugin enabled!");	
		} else {
			log.info("[fMiniGames] The minigames plugin has been disabled, fEssentials core is needed to enable this plugin part!");
			Bukkit.getPluginManager().disablePlugin(this);
		}
	}
	
	public void onDisable() {
		log.info("[fMiniGames] MiniGames plugin disabled!");
	}

}
