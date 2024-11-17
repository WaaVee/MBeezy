package de.wayvee.mbeezy;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;


public class ClanManager {
    private static final Map<Player, String> playerClans = new HashMap<>();

    public static void setClan(Player player, String clantag) {
        playerClans.put(player, clantag);
        updatePlayerDisplay(player);
    }

    public static String getClan(Player player) {
        return playerClans.getOrDefault(player, "");
    }

    public static void updatePlayerDisplay(Player player) {
        String clanTag = getClan(player);
        int deaths = DeathManager.getDeaths(player);

        player.setPlayerListName(clanTag + " " + player.getName() + " [" + deaths + "Tode]");
        player.setCustomName(clanTag + " " + player.getName());
        player.setCustomNameVisible(true);
    }
}