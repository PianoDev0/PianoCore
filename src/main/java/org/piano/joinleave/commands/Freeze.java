package org.piano.joinleave.commands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Freeze implements CommandExecutor {

    private final Set<UUID> frozenPlayers = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            Player target = Bukkit.getPlayerExact(args[0]);

            if (target != null) {
                UUID targetUUID = target.getUniqueId();

                if (isPlayerFrozen(targetUUID)) {
                    unfreezePlayer(targetUUID);
                    target.sendMessage(ChatColor.GREEN + "Byl(a) jsi odmrazen(a).");
                    sender.sendMessage(ChatColor.GREEN + target.getName() + " byl(a) odmrazen(a).");
                } else {
                    freezePlayer(targetUUID);
                    sender.sendMessage(ChatColor.RED + target.getName() + " byl(a) zamrazen(a).");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Hráč s tímto jménem není online.");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Použití: /freeze <hráč>");
        }

        return true;
    }

    public boolean isPlayerFrozen(UUID playerUUID) {
        return frozenPlayers.contains(playerUUID);
    }

    public void freezePlayer(UUID playerUUID) {
        frozenPlayers.add(playerUUID);
        Player player = Bukkit.getPlayer(playerUUID);
        if (player != null) {
            player.setWalkSpeed(0);
        }
    }

    public void unfreezePlayer(UUID playerUUID) {
        frozenPlayers.remove(playerUUID);
        Player player = Bukkit.getPlayer(playerUUID);
        if (player != null) {
            player.setWalkSpeed(0.2f);
        }
    }
}

