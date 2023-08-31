package org.graffie.authie;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import net.luckperms.api.LuckPerms;

public final class Authie extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        reloadConfig();
        config = getConfig();
        getCommand("authie").setExecutor(new CommandHandler());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static String getMessage(String path) {
        return config.getString("messages." + path);
    }
    public static FileConfiguration config;
}
