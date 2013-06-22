package xize.fEssentials.minigames.handlers;

import xize.fEssentials.minigames.fMinigames;
import xize.fEssentials.minigames.handlers.ctf.ctfHandler;

public class handler {
	fMinigames plugin;
	public handler(fMinigames plugin) {
		this.plugin = plugin;
	}
	
	public void startListeners() {
		ctfHandler ctf = new ctfHandler(plugin);
		ctf.launch();
	}

}
