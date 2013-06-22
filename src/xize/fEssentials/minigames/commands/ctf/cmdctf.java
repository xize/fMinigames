package xize.fEssentials.minigames.commands.ctf;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import xize.fEssentials.minigames.fMinigames;
import xize.fEssentials.minigames.registrations.ctf.ctfProvider;

public class cmdctf {
	fMinigames plugin;
	public cmdctf(fMinigames plugin) {
		this.plugin = plugin;
	}
	
	public boolean execute(CommandSender sender, Command cmd, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ctf")) {
			ctfProvider ctf = new ctfProvider(plugin);
			if(ctf.isSet(sender.getName())) {
				sender.sendMessage(ChatColor.GREEN + "you are no longer auto respawn!");
				ctf.removePlayer(sender.getName());
			} else if(!ctf.isSet(sender.getName())) {
				sender.sendMessage(ChatColor.GREEN + "Autorespawn on!");
				ctf.addPlayer(sender.getName());
			}
		}
		return false;
	}

}
