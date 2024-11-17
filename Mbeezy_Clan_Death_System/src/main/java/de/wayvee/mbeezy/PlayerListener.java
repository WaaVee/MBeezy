package de.wayvee.mbeezy;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        DeathManager.incrementDeaths(event.getEntity());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        ClanManager.updatePlayerDisplay(event.getPlayer());
    }
}
