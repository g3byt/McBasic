package mcbasic;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tphere implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if(cmd.getName().equalsIgnoreCase("tphere")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(sender.hasPermission("mcbasic.tphere")) {
					if(args.length==1) {
						Player target = Bukkit.getServer().getPlayerExact(args[0]);
						Player player = (Player) sender;
						if(target!=null) {
							target.teleport(((Player) p).getLocation());
							p.sendMessage("§2You teleported here §2"+target.getPlayer().getName()+"");
							System.out.println("[MCBasic] "+player.getPlayer().getName()+" teleported here "+target.getPlayer().getName());
							return true;
						}else sender.sendMessage("§cPlayer not found");
					} else {
						sender.sendMessage("§fUse: /tphere [player name]");
					}
				}else {
					sender.sendMessage("§cYou don't have permissions to execute this command");
					return true;
			}
			}	
		}
		return false;
	}
}
