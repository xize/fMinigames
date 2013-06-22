package xize.fEssentials.minigames.registrations.ctf;

import java.util.HashSet;

import xize.fEssentials.minigames.fMinigames;

public class ctfProvider {
	fMinigames plugin;
	public ctfProvider(fMinigames plugin) {
		this.plugin = plugin;
	}
	
	protected static HashSet<String> players = new HashSet<String>();
	
	public void addPlayer(String player) {
		if(!players.contains(player)) {
			players.add(player);
		} else {
			return;
		}
	}
	
	public void removePlayer(String player) {
		if(players.contains(player)) {
			players.remove(player);
		} else {
			return;
		}
	}
	
	public boolean isSet(String player) {
		if(players.contains(player)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Integer getArenaCount() {
		return players.size();
	}

}
