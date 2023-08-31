package org.graffie.authie;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;
import java.util.stream.Collectors;

public class CommandHandler implements CommandExecutor {
    HashMap <UUID, Boolean> isStaff = new HashMap<>();



    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player playerSender = (Player) sender;
            sender.getEffectivePermissions().stream().filter(perm -> perm.getPermission().startsWith("authie.")).collect(Collectors.toList()).get(0);
            String perm = sender.getEffectivePermissions().stream().filter(perm1 -> perm1.getPermission().startsWith("authie.")).collect(Collectors.toList()).get(0).getPermission();
            String parent = perm.split("\\.")[1];
            isStaff.get(playerSender.getUniqueId());
            Boolean isPlayerStaff = isStaff.get(playerSender.getUniqueId());
            if (isPlayerStaff == null || isPlayerStaff == false) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + playerSender.getName() + " parent add " + parent);
                sender.sendMessage(Authie.getMessage("granted-perm"));
                isStaff.put(playerSender.getUniqueId(), true);
                return true;

            } else {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + playerSender.getName() + " parent remove " + parent);
                sender.sendMessage(Authie.getMessage("remove-perm-command"));
                isStaff.put(playerSender.getUniqueId(), false);
                return true;
            }
        }
        return false;
    }
}
