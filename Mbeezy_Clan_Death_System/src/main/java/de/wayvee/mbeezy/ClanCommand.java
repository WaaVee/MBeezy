package de.wayvee.mbeezy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Nur Spieler können diesen Befehl nutzen.");
            return true;
        }

        if (args.length < 2) {
            player.sendMessage(ChatColor.RED + "nutze: /setclan <Farbe> <Name>");
            return true;
        }

        String colorCode = args[0].toUpperCase();
        String clanName = args[1];

        try {
            ChatColor color = ChatColor.valueOf(colorCode);
            ClanManager.setClan(player, color + "[" + clanName + "]" + ChatColor.RESET);
            player.sendMessage(ChatColor.GREEN + "Dein ClanTag wurde gesetzt als " + color + "[" + clanName + "]");
        } catch (IllegalArgumentException e) {
            player.sendMessage(ChatColor.RED + "Ungültige Farbe! Versuch eine andere Farbe.");
        }

        return true;
    }
}