package de.wayvee.mbeezy;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        //Register Commands
        getCommand("setclan").setExecutor(new ClanCommand());
        getCommand("deaths").setExecutor(new DeathCommand());
        getCommand("btown").setExecutor(new BtownCommand());


        //Register Event Listener
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getLogger().info("Mbeezy_Clan_Death_System ist gestartet!!!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Mbeezy_Clan_Death_System ist beendet!");
    }

    public static Main getInstance() {
        return instance;
    }
}
