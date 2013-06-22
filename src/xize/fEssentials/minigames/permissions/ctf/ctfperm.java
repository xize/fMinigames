package xize.fEssentials.minigames.permissions.ctf;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import xize.fEssentials.minigames.fMinigames;

public class ctfperm {
	fMinigames plugin;
	public ctfperm(fMinigames plugin) {
		this.plugin = plugin;
	}
	
	public void getPermissionsError(CommandSender sender, Command cmd, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ctf")) {
			sender.sendMessage(ChatColor.RED + "you do not have permissions for /" + cmd.getName() + ChatColor.GRAY + "\nfMinigames.commands.ctf");
		}
	}

}
