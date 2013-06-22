package xize.fEssentials.minigames.commands.ctf;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import xize.fEssentials.minigames.fMinigames;
import xize.fEssentials.minigames.permissions.ctf.ctfperm;
import xize.fEssentials.minigames.registrations.ctf.ctfProvider;

public class cmdctf {
	fMinigames plugin;
	public cmdctf(fMinigames plugin) {
		this.plugin = plugin;
	}
	
	public boolean execute(CommandSender sender, Command cmd, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ctf")) {
			if(sender.hasPermission("fMinigames.commands.ctf")) {
				ctfProvider ctf = new ctfProvider(plugin);
				if(args.length == 0) {
					sender.sendMessage(ChatColor.GOLD + ".oO___[Capture the flag]___Oo.");
					sender.sendMessage(ChatColor.GRAY + "this plugin is coded by Xeph0re a.k.a xize");
					sender.sendMessage(ChatColor.DARK_GRAY + "Default: " + ChatColor.GRAY + "/ctf join " + ChatColor.WHITE + ": join the arena");
					sender.sendMessage(ChatColor.DARK_GRAY + "Default: " + ChatColor.GRAY + "/ctf leave " + ChatColor.WHITE + ": leave the arena");
					sender.sendMessage(ChatColor.DARK_GRAY + "Default: " + ChatColor.GRAY + "/ctf score " + ChatColor.WHITE + ": see the scores between teams!");
					if(sender.hasPermission("fMinigames.commands.ctf.admin")) {
						sendAdminCommands(sender);
					}
				} else if(args.length == 1) {
					if(args[0].equalsIgnoreCase("help")) {
						sender.sendMessage(ChatColor.GOLD + ".oO___[Capture the flag]___Oo.");
						sender.sendMessage(ChatColor.GRAY + "this plugin is coded by Xeph0re a.k.a xize");
						sender.sendMessage(ChatColor.DARK_GRAY + "Default: " + ChatColor.GRAY + "/ctf join " + ChatColor.WHITE + ": join the arena");
						sender.sendMessage(ChatColor.DARK_GRAY + "Default: " + ChatColor.GRAY + "/ctf leave " + ChatColor.WHITE + ": leave the arena");
						sender.sendMessage(ChatColor.DARK_GRAY + "Default: " + ChatColor.GRAY + "/ctf score " + ChatColor.WHITE + ": see the scores between teams!");
						if(sender.hasPermission("fMinigames.commands.ctf.admin")) {
							sendAdminCommands(sender);
						}
					} else if(args[0].equalsIgnoreCase("join")) {
						try {
							Player p = (Player) sender;
							File dir = new File(plugin.getDataFolder() + File.separator + "ctf");
							File[] list = dir.listFiles();
							for(File f : list) {
								FileConfiguration con = YamlConfiguration.loadConfiguration(f);
								if(!con.isBoolean("spawnpoint.inuse")) {
									con.set("spawnpoint.inuse", true);
									con.set("spawnpoint.owner", sender.getName());
									ctf.addPlayer(sender.getName());
									Location loc = new Location(Bukkit.getWorld(con.getString("World")), (double) con.getInt("x"), (double) con.getInt("y"), (double) con.getInt("z"), (float) con.getInt("yaw"), (float) con.getInt("pitch"));
									loc.getWorld().refreshChunk(loc.getChunk().getX(), loc.getChunk().getZ());
									Bukkit.broadcastMessage("");
									p.teleport(loc);
									return false;
								}
							}
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				ctfperm permission = new ctfperm(plugin);
				permission.getPermissionsError(sender, cmd, args);
			}
			
		}
		return false;
	}
	
	public void sendAdminCommands(CommandSender sender) {
		sender.sendMessage(ChatColor.RED + "Admin: " + ChatColor.GRAY + "/ctf scramble " + ChatColor.WHITE + ": Scramble teams forced");
		sender.sendMessage(ChatColor.RED + "Admin: " + ChatColor.GRAY + "/ctf setMaxPlayers <number> " + ChatColor.WHITE + ": set the max players amount for the arena each team is devided by 2 from this count");
		sender.sendMessage(ChatColor.RED + "Admin: " + ChatColor.GRAY + "/ctf setCaptureBlock " + ChatColor.WHITE + ": allows capture block mode so you can set the block location");
		sender.sendMessage(ChatColor.RED + "Admin: " + ChatColor.GRAY + "/ctf setspawnpoint red " + ChatColor.WHITE + ": set a spawnpoint for team red");
		sender.sendMessage(ChatColor.RED + "Admin: " + ChatColor.GRAY + "/ctf setspawnpoint blue " + ChatColor.WHITE + ": set a spawnpoint for team blue");
		sender.sendMessage(ChatColor.RED + "Admin: " + ChatColor.GRAY + "/ctf spawnpoints " + ChatColor.WHITE + ": get a list of all id's per team!");
		sender.sendMessage(ChatColor.RED + "Admin: " + ChatColor.GRAY + "/ctf delspawnpoint id " + ChatColor.WHITE + ": deletes the spawnpoint");
		sender.sendMessage(ChatColor.RED + "Admin: " + ChatColor.GRAY + "/ctf modifyspawnpoint id " + ChatColor.WHITE + ": change the spawnpoint to another location");
		sender.sendMessage(ChatColor.RED + "Admin: " + ChatColor.GRAY + "/ctf modifyspawnpoint confirm " + ChatColor.WHITE + ": set the new location of the modified spawnpoint");
		sender.sendMessage(ChatColor.RED + "Admin: " + ChatColor.GRAY + "/ctf removeArena " + ChatColor.WHITE + ": remove the default arena!");
	}

}
