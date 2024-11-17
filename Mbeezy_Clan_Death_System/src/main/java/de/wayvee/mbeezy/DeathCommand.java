package de.wayvee.mbeezy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeathCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Nur Spieler können diesen Befehl nutzen,");
            return true;
        }

        int deaths = DeathManager.getDeaths(player);
        player.sendMessage("Du bit so kacke und schon " + deaths + " gestorben!!!");
        return true;
    }
}
