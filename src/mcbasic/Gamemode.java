package mcbasic;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("gamemode")) {
			if(sender instanceof Player) {
			Player p = (Player) sender;
			if(sender.hasPermission("mcbasic.gamemode")) {
				if(args.length==0) {
				p.sendMessage("§fUse: /gamemode 0|1|2|3 [player name]");
				}
				if(args.length==1) {
					if(args[0].equalsIgnoreCase("1")) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage("§2Gamemode set to Creative");
						System.out.println("[MCBasic] "+ p.getPlayer().getName()+" set his gamemode to Creative");
					}
					if(args[0].equalsIgnoreCase("0")) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage("§2Gamemode set to Survival");
						System.out.println("[MCBasic] "+ p.getPlayer().getName()+" set his gamemode to Survival");
					}
					if(args[0].equalsIgnoreCase("2")) {
						p.setGameMode(GameMode.ADVENTURE);
						p.sendMessage("§2Gamemode set to Adventure");
						System.out.println("[MCBasic] "+ p.getPlayer().getName()+" set his gamemode to Adventure");
					}
					if(args[0].equalsIgnoreCase("3")) {
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage("§2Gamemode set to Spectator");
						System.out.println("[MCBasic] "+ p.getPlayer().getName()+" set his gamemode to Spectator");
					}
					if(args[0].equalsIgnoreCase("creative")) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage("§2Gamemode set to Creative");
						System.out.println("[MCBasic] "+ p.getPlayer().getName()+" set his gamemode to Creative");
					}
					if(args[0].equalsIgnoreCase("survival")) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage("§2Gamemode set to Survival");
						System.out.println("[MCBasic] "+ p.getPlayer().getName()+" set his gamemode to Survival");
					}
					if(args[0].equalsIgnoreCase("adventure")) {
						p.setGameMode(GameMode.ADVENTURE);
						p.sendMessage("§2Gamemode set to Adventure");
						System.out.println("[MCBasic] "+ p.getPlayer().getName()+" set his gamemode to Adventure");
					}
					if(args[0].equalsIgnoreCase("spectator")) {
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage("§2Gamemode set to Spectator");
						System.out.println("[MCBasic] "+ p.getPlayer().getName()+" set his gamemode to Spectator");
					}
					return true;
				}
				if(args.length==2) {
					Player target = Bukkit.getServer().getPlayerExact(args[1]);
					Player player = (Player) sender;
					if(target!=null) {
						if(args[0].equalsIgnoreCase("1")) {
							target.setGameMode(GameMode.CREATIVE);
							target.sendMessage("§2Gamemode set to Creative");
							sender.sendMessage("§2"+target.getPlayer().getName()+"§2 is in Creative");
							System.out.println("[MCBasic] "+player.getPlayer().getName()+" set "+target.getPlayer().getName()+" gamemode to Creative");
						}
						if(args[0].equalsIgnoreCase("0")) {
							target.setGameMode(GameMode.SURVIVAL);
							target.sendMessage("§2Gamemode set to Survival");
							sender.sendMessage("§2"+target.getPlayer().getName()+"§2 is in Survival");
							System.out.println("[MCBasic] "+player.getPlayer().getName()+" set "+target.getPlayer().getName()+" gamemode to Survival");
						}
						if(args[0].equalsIgnoreCase("2")) {
							target.setGameMode(GameMode.ADVENTURE);
							target.sendMessage("§2Gamemode set to Adventure");
							sender.sendMessage("§2"+target.getPlayer().getName()+"§2 is in Creative");
							System.out.println("[MCBasic] "+player.getPlayer().getName()+" set "+target.getPlayer().getName()+" gamemode to Adventure");
						}
						if(args[0].equalsIgnoreCase("3")) {
							target.setGameMode(GameMode.SPECTATOR);
							target.sendMessage("§2Gamemode set to Spectator");
							sender.sendMessage("§2"+target.getPlayer().getName()+"§2 is in Spectator");
							System.out.println("[MCBasic] "+player.getPlayer().getName()+" set "+target.getPlayer().getName()+" gamemode to Spectator");
						}
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
				if(args.length==2) {
					Player target = Bukkit.getServer().getPlayerExact(args[1]);
					if(target!=null) {
						if(args[0].equalsIgnoreCase("1")) {
							target.setGameMode(GameMode.CREATIVE);
							target.sendMessage("§2Gamemode set to Creative");
							sender.sendMessage("You put "+target.getPlayer().getName()+" in Creative");
							System.out.println("[MCBasic] Console set "+target.getPlayer().getName()+" gamemode to Creative");
						}
						if(args[0].equalsIgnoreCase("0")) {
							target.setGameMode(GameMode.SURVIVAL);
							target.sendMessage("§2Gamemode set to Survival");
							sender.sendMessage("You put "+target.getPlayer().getName()+" in Survival");
							System.out.println("[MCBasic] Console set "+target.getPlayer().getName()+" gamemode to Survival");
						}
						if(args[0].equalsIgnoreCase("2")) {
							target.setGameMode(GameMode.ADVENTURE);
							target.sendMessage("§2Gamemode set to Adventure");
							sender.sendMessage("You put "+target.getPlayer().getName()+" in Adventure");
							System.out.println("[MCBasic] Console set "+target.getPlayer().getName()+" gamemode to Adventure");
						}
						if(args[0].equalsIgnoreCase("3")) {
							target.setGameMode(GameMode.SPECTATOR);
							target.sendMessage("§2Gamemode set to Spectator");
							sender.sendMessage("You put "+target.getPlayer().getName()+" in Spectator");
							System.out.println("[MCBasic] Console set "+target.getPlayer().getName()+" gamemode to Spectator");
						}
						return true;
					}else sender.sendMessage("Player not found");
					return true;
				} else {
					sender.sendMessage("§fUse: /gamemode 0|1|2|3 [player name]");
				}
			}
	}
		return false;
	}
	
}
