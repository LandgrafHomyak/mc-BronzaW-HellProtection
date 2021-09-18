package net.landgrafhomyak.BronzaW_HellProtection;


import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.player.*;

import static org.bukkit.Bukkit.getServer;

public class HellListener implements Listener {
    private void message(String name) {
        getServer().broadcastMessage(String.format("'%s' reached the border of the world and miraculously found a spawn behind it", name));
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (!event.getPlayer().isOp()) {
            if (event.getTo() != null) {
                if (event.getTo().getWorld().getEnvironment() == World.Environment.NETHER && event.getTo().getY() >= 127 || event.getTo().getY() <= 0) {
                    this.message(event.getPlayer().getName());
                    event.setCancelled(true);
                    event.getPlayer().teleport(getServer().getWorlds().get(0).getSpawnLocation());
                }
            }
        }
    }


    @EventHandler
    public void onTeleport(EntityTeleportEvent event) {
        if (event.getEntity().getType() == EntityType.PLAYER && !((Player) event.getEntity()).isOp()) {
            if (event.getTo() != null) {
                if (event.getTo().getWorld().getEnvironment() == World.Environment.NETHER && event.getTo().getY() >= 127 || event.getTo().getY() <= 0) {
                    this.message(event.getEntity().getName());
                    event.setCancelled(true);
                    event.getEntity().teleport(getServer().getWorlds().get(0).getSpawnLocation());
                }
            }
        }
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        if (!event.getPlayer().isOp()) {
            if (event.getTo() != null) {
                if (event.getTo().getWorld().getEnvironment() == World.Environment.NETHER && event.getTo().getY() >= 127 || event.getTo().getY() <= 0) {
                    this.message(event.getPlayer().getName());
                    event.setCancelled(true);
                    event.getPlayer().teleport(getServer().getWorlds().get(0).getSpawnLocation());
                }
            }
        }
    }
}