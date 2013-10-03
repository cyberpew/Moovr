package me.cyberpew.moovr;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Moovr extends JavaPlugin implements Listener {
	
	public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new MoovrBlock(this), this);
		
		saveDefaultConfig();
	}
	
	public void onDisable(){
		
	}
	
	public Player sender;
	

}
