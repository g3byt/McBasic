package mcbasic;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {
  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
    if (Boolean.parseBoolean(Main.getInstance().getConfig().getString("settings.motd"))) {
      e.getPlayer().sendMessage("§aWelcome " + e.getPlayer().getName() + "§a to " + Main.getInstance().getConfig().getString("settings.server_name") + "§a!");
      if (Bukkit.getOnlinePlayers().size()<=1) {
    	  e.getPlayer().sendMessage("§aYou are the only player online");
      } else {
    	  e.getPlayer().sendMessage("§aThere are " + Bukkit.getOnlinePlayers().size() + "§a players online");
      }
      
    } 
  }
}
