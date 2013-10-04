package me.cyberpew.moovr;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoovrBlock implements Listener {
	
private Moovr plugin;

public MoovrBlock(Moovr p) {
	plugin = p;
}
	
	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent event) {
		
		event.getFrom().getBlock().getLocation().equals(event.getTo().getBlock().getLocation());
		Player player = event.getPlayer();
		Block block = player.getLocation().getBlock();
		if(block.getType() == Material.POWERED_RAIL) {
			Block blockUnder = block.getRelative(BlockFace.DOWN);
			if(blockUnder.getType() == Material.GOLD_BLOCK){
				if (player.hasPermission("moovr.use")){
					float walkspeed = (float) plugin.getConfig().getDouble("moovr.walkspeed");
					player.setWalkSpeed(walkspeed);
				}
			}
		}else{
			float defaultwalkspeed = 0.2F;
			player.setWalkSpeed(defaultwalkspeed);
		}
	}
}
