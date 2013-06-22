package xize.fEssentials.minigames.configuration;

import xize.fEssentials.minigames.fMinigames;
import xize.fEssentials.minigames.configuration.ctf.CtfConfig;

public class config {
	fMinigames plugin;
	public config(fMinigames plugin) {
		this.plugin = plugin;
	}
	
	public void createConfigs() {
		CtfConfig ctf = new CtfConfig(plugin);
		ctf.createConfig();
	}

}
