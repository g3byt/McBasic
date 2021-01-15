package mcbasic;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Quit implements Listener{
	
	@EventHandler
	public void onJoin(PlayerQuitEvent e) {
		if(Boolean.parseBoolean(Main.getInstance().getConfig().getString("settings.join-quit_message"))) {
			Player player = e.getPlayer();
			e.setQuitMessage("§f[§c-§f]§e"+player.getPlayer().getName()+"§e left the server!" );
			
		}
		
	}

}