package xize.fEssentials.minigames.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import xize.fEssentials.minigames.fMinigames;
import xize.fEssentials.minigames.commands.ctf.cmdctf;

public class command implements CommandExecutor {
	fMinigames plugin;
	public command(fMinigames plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ctf")) {
			cmdctf ctf = new cmdctf(plugin);
			return ctf.execute(sender, cmd, args);
		}
		return false;
	}

}
