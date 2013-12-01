package me.cyberpew.moovr;

import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

public class Moovr extends JavaPlugin implements Listener {
	
	public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new MoovrBlock(this), this);
		
		saveDefaultConfig();
		
		//Add PluginMetrics
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
		    // Failed to submit the stats :-(
		}
	}
	
	public void onDisable(){
		
	}
	
	public Player sender;
	

}
