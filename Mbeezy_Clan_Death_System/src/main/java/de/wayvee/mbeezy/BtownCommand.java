package de.wayvee.mbeezy;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BtownCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Nur Spieler können diesen Befehl nutzen.");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "nutze: /btown <1|2>");
            return true;
        }

        ItemStack item;
        switch (args[0]) {
            case "1":
                item = createDiamondPickaxe();
                break;
            case "2":
                item = createEnchantedBook("Efficient Book", 0, 10, 10);
                break;
            default:
                player.sendMessage(ChatColor.RED + "Ungültige eingabe! Use 1 or 2.");
                return true;
        }

        player.getInventory().addItem(item);
        player.sendMessage(ChatColor.GREEN + "The item has been added to your inventory!");
        return true;
    }

    private ItemStack createDiamondPickaxe() {
        ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = pickaxe.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(ChatColor.AQUA + "Ultimate Pickaxe");
            meta.addEnchant(Enchantment.FORTUNE, 10, true);
            meta.addEnchant(Enchantment.EFFICIENCY, 10, true);
            meta.addEnchant(Enchantment.UNBREAKING, 10, true);
            pickaxe.setItemMeta(meta);
        }

        return pickaxe;
    }

    private ItemStack createEnchantedBook(String name, int luck, int efficiency, int unbreaking) {
        ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta meta = book.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(ChatColor.GOLD + name);
            if (luck > 0) {
                meta.addEnchant(Enchantment.FORTUNE, luck, true);
            }
            if (efficiency > 0) {
                meta.addEnchant(Enchantment.EFFICIENCY, efficiency, true);
            }
            if (unbreaking > 0) {
                meta.addEnchant(Enchantment.UNBREAKING, unbreaking, true);
            }
            book.setItemMeta(meta);
        }

        return book;
    }
}
