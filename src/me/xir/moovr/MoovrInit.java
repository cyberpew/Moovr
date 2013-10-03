package me.xir.moovr;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MoovrInit extends JavaPlugin implements Listener {
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		this.saveDefaultConfig();
	}
	
	public void onDisable(){
		
	}
	
	public Player sender;
	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent event) {
		
		if(event.isCancelled()||event.getFrom().getBlock().getLocation()==event.getFrom().getBlock().getLocation())
			return;
		Player player = event.getPlayer();
		Block block = player.getLocation().getBlock();
		if(block.getType() == Material.POWERED_RAIL) {
			Block blockUnder = block.getRelative(BlockFace.DOWN);
			if(blockUnder.getType() == Material.GOLD_BLOCK){
				float walkspeed = this.getConfig().getInt("walkspeed");
				player.setWalkSpeed(walkspeed);
			}
		}else{
			float defaultwalkspeed = 0.2F;
			player.setWalkSpeed(defaultwalkspeed);
		}
	}
}
