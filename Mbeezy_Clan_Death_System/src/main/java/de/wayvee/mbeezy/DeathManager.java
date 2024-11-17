package de.wayvee.mbeezy;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class DeathManager {
    private static final Map<Player, Integer> deathCounts = new HashMap<>();

    public static void incrementDeaths(Player player) {
        deathCounts.put(player, getDeaths(player) + 1);
        ClanManager.updatePlayerDisplay(player);
    }

    public static int getDeaths(Player player) {
        return deathCounts.getOrDefault(player, 0);
    }
}
