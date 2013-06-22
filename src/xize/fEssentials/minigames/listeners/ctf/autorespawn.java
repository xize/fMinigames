package xize.fEssentials.minigames.listeners.ctf;

import java.lang.reflect.Field;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

import xize.fEssentials.minigames.fMinigames;
import xize.fEssentials.minigames.registrations.ctf.ctfProvider;

public class autorespawn implements Listener {
	fMinigames plugin;
	public autorespawn(fMinigames plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void CtfPlayerOnDeath(PlayerDeathEvent e) {
		ctfProvider ctf = new ctfProvider(plugin);
		if(ctf.isSet(e.getEntity().getName())) {
			forceRespawn(e.getEntity(), plugin);
		}
	}
	
	public static void forceRespawn(Player player, Plugin plugin) {
		String version = autorespawn.getVersion(plugin);
		try {
			Class<?> packet = Class.forName("net.minecraft.server."+version.replace(".", "_") +".Packet205ClientCommand");
			Object name = packet.getConstructor(new Class[0]).newInstance(new Object[0]);
			Field a = packet.getDeclaredField("a");
			a.setAccessible(true);
			a.set(name, 1);
			Object nmsPlayer = Class.forName("org.bukkit.craftbukkit."+version.replace(".", "_")+".entity.CraftPlayer").getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
			Field con = Class.forName("net.minecraft.server."+version.replace(".", "_") +".EntityPlayer").getDeclaredField("playerConnection");
			con.setAccessible(true);
			Object handle = con.get(nmsPlayer);
			packet.getDeclaredMethod("handle", Class.forName("net.minecraft.server."+version.replace(".", "_") +".Connection")).invoke(name, handle);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static String getVersion(Plugin plugin) {
		String packageName = plugin.getServer().getClass().getPackage().getName();
		return packageName.substring(packageName.lastIndexOf('.') + 1);
	}

}