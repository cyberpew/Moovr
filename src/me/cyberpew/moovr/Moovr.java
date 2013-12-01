package me.cyberpew.moovr;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.MetricsLite;

public class Moovr extends JavaPlugin implements Listener {
	
	public void onEnable(){
		Logger logger = Logger.getLogger("Minecraft");
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new MoovrBlock(this), this);
		
		saveDefaultConfig();
		
		//Add PluginMetrics
        try {
            MetricsLite metrics = new MetricsLite(this);
            metrics.start();
        } catch (IOException e) {
        		logger.log(Level.SEVERE, e.getMessage());
        }
	}
	
	public void onDisable(){
		
	}
	
	public Player sender;
	

}
