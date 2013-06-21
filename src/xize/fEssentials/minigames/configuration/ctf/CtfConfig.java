package xize.fEssentials.minigames.configuration.ctf;

import java.io.File;
import java.util.HashSet;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;

import xize.fEssentials.minigames.fMinigames;

public class CtfConfig {
	static fMinigames plugin;
	public CtfConfig(fMinigames plugin) {
		CtfConfig.plugin = plugin;
	}
	
	static Logger log = Logger.getLogger("Minecraft");
	private static HashSet<String> cmdList = new HashSet<String>();
	
	public static void createConfig() {
		cmdList.add("/spawn");
		cmdList.add("/tpa");
		cmdList.add("/tp");
		cmdList.add("/home");
		try {
			File f = new File(plugin.getDataFolder() + File.separator + "ctf.yml");
			if(f.exists()) {
				log.info("[fMiniGames] has found config file ctf.yml!");
			} else {
				FileConfiguration con = YamlConfiguration.loadConfiguration(f);
				FileConfigurationOptions opt = con.options();
				opt.header("This is the default ctf config!");
				con.set("ctf.system.enable", true);
				con.set("ctf.system.AutoScramble", false);
				con.set("ctf.system.autorespawn", true);
				con.set("ctf.system.kickIdlePlayers", true);
				con.set("ctf.system.captureTypeBlock", Material.PUMPKIN.getId());
				con.set("ctf.system.addChatTag", true);
				con.set("ctf.system.disableCommands", cmdList);
				con.set("ctf.system.funnyYouLose", true);
				con.save(f);
				cmdList.clear();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
