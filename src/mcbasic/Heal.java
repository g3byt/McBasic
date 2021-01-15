package mcbasic;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor{
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("heal")) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(sender.hasPermission("mcbasic.heal")) {
				if(args.length==0) {
				 p.setHealth(p.getMaxHealth());
				 p.sendMessage("§2Healed");
				 System.out.println("[MCBasic] "+ p.getPlayer().getName()+" has healed himself");
					}
				if(args.length==1) {
					Player target = Bukkit.getServer().getPlayerExact(args[0]);
					Player player = (Player) sender;
					if(target!=null) {
						target.setHealth(target.getMaxHealth());
						target.sendMessage("§2You have been healed");
						sender.sendMessage("§2You healed "+target.getPlayer().getName()+"");
						System.out.println("[MCBasic] "+player.getPlayer().getName()+" healed "+target.getPlayer().getName());
						return true;
					}else sender.sendMessage("§cPlayer not found");
					return true;
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
					target.setHealth(target.getMaxHealth());
					target.sendMessage("2eYou have been healed");
					sender.sendMessage("You healed "+target.getPlayer().getName()+"");
					System.out.println("[MCBasic] Console healed "+target.getPlayer().getName());
					return true;
				}else sender.sendMessage("Player not found");
				return true;
			} else {
				sender.sendMessage("§fUse: /heal [player name]");
			}
		}
		}
			
		
		return false;
		
	}

}
