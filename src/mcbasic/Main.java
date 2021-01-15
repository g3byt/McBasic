package mcbasic;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static Main plugin;
	
	public void onEnable() {
		plugin = this;
		
		System.out.println("[MCBasic] Plugin is enabled");
		System.out.println("[MCBasic] Plugin made by Marbanz");
		
		Bukkit.getPluginManager().registerEvents(new Join2(), this);
		Bukkit.getPluginManager().registerEvents(new Join(), this);
		Bukkit.getPluginManager().registerEvents(new Quit(), this);
		getCommand("fly").setExecutor(new Fly());
		getCommand("gamemode").setExecutor(new Gamemode());
		getCommand("heal").setExecutor(new Heal());
		getCommand("feed").setExecutor(new Feed());
		getCommand("playertp").setExecutor(new Tp());
		getCommand("tphere").setExecutor(new Tphere());
		saveDefaultConfig();
		new Update(this, 85523).getLatestVersion(version -> {
            if(this.getDescription().getVersion().equalsIgnoreCase(version)) {
                System.out.println("[MCBasic] Plugin is up to date");
            } else {
            	Log.warn("MCBasic need to be updated. Download: https://www.spigotmc.org/resources/mcbasic.85523/ ");
            }

        });
	}
	
	public void onDisable() {
		System.out.println("[MCBasic] Plugin is disabled");
	}
	public static Main getInstance() {
		return plugin;
	}

	
}

