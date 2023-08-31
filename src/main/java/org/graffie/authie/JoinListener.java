package org.graffie.authie;
import net.luckperms.api.node.NodeBuilder;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;

import static net.luckperms.api.node.NodeBuilder.*;

public class JoinListener implements Listener{

    private final LuckPerms luckPerms;
    private final FileConfiguration config;

    public JoinListener(LuckPerms luckPerms, FileConfiguration config) {
        this.luckPerms = luckPerms;
        this.config = config;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();

    }
    public void onPlayerQuit(PlayerQuitEvent event) {

    }
}
