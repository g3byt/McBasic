package mcbasic;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join2 implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if(Boolean.parseBoolean(Main.getInstance().getConfig().getString("settings.join-quit_message"))) {
			Player player = e.getPlayer();
			e.setJoinMessage("§f[§a+§f] §e"+player.getPlayer().getName()+"§e joined the server!" );

			
		}
		
	}

}
