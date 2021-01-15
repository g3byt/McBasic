package mcbasic;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("fly")) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(sender.hasPermission("mcbasic.fly")) {
				if(args.length==0) {
				
					if(p.getAllowFlight()) {
						p.setAllowFlight(false);
						sender.sendMessage("§2Fly disabled");
						System.out.println("[MCBasic] "+p.getPlayer().getName()+" has disabled fly");
					}else {
						p.setAllowFlight(true);
						sender.sendMessage("§2Fly enabled");
						System.out.println("[MCBasic] "+p.getPlayer().getName()+" has enabled fly");
					}
					return true;
				}else if(args.length==1) {
					Player target = Bukkit.getServer().getPlayerExact(args[0]);
					Player player = (Player) sender;
					if(target!=null) {
						if(target.getAllowFlight()) {
							target.setAllowFlight(false);
							target.sendMessage("§2Fly disabled");
							sender.sendMessage("§2Now "+target.getPlayer().getName()+"§2 can't fly");
							System.out.println("[MCBasic] "+player.getPlayer().getName()+" has disabled fly for "+target.getPlayer().getName());
						}else {
							target.setAllowFlight(true);
							target.sendMessage("2eFly enabled");
							sender.sendMessage("§2Now "+target.getPlayer().getName()+"§2 can fly");
							System.out.println("[MCBasic] "+player.getPlayer().getName()+" has enabled fly for "+target.getPlayer().getName());
						}
						return true;
					}else {
						sender.sendMessage("§cPlayer not found");
						return true;
					}
						
				
				}
			}else {
				sender.sendMessage("§cYou don't have permissions to execute this command");
				return true;
			}
			
				
		}
		if(sender instanceof ConsoleCommandSender) {
			if(args.length==1) {
				Player target = Bukkit.getServer().getPlayerExact(args[0]);
				if(target!=null) {
					if(target.getAllowFlight()) {
						target.setAllowFlight(false);
						target.sendMessage("§2Fly disabled");
						sender.sendMessage("Now "+target.getPlayer().getName()+" can't fly");
						System.out.println("[MCBasic] Console has disabled fly for "+target.getPlayer().getName());
					}else {
						target.setAllowFlight(true);
						target.sendMessage("§2Fly enabled");
						sender.sendMessage("Now "+target.getPlayer().getName()+" can fly");
						System.out.println("[MCBasic] Console has enabled fly for "+target.getPlayer().getName());
					}
					return true;
				}else {
					sender.sendMessage("Player not found");
					return true;
				}
				
			} else {
				sender.sendMessage("§fUse: /fly [player name]");
			}
		}
		}
		return false;
	}
}
