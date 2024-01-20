package org.piano.joinleave.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.ConsoleCommandSender;

public class Gamemodes implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((command.getName().equalsIgnoreCase("gmc") || command.getName().equalsIgnoreCase("gms") || command.getName().equalsIgnoreCase("gmsp"))) {
            if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
                Player p = (sender instanceof Player) ? (Player) sender : null;

                if (args.length == 0) {
                    GameMode targetGameMode;
                    if (command.getName().equalsIgnoreCase("gmc")) {
                        targetGameMode = GameMode.CREATIVE;
                    } else if (command.getName().equalsIgnoreCase("gms")) {
                        targetGameMode = GameMode.SURVIVAL;
                    } else {
                        targetGameMode = GameMode.SPECTATOR;
                    }

                    setGameMode(p, targetGameMode);

                    if (p != null) {
                        p.sendMessage(ChatColor.GREEN + "Nastaveno na " + targetGameMode.toString().toLowerCase() + "!");
                    } else {
                        sender.sendMessage(ChatColor.GREEN + "Nastaveno na " + targetGameMode.toString().toLowerCase() + "!");
                    }

                    return true;
                } else if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        sender.sendMessage("Tento hráč není online!");
                        return true;
                    }

                    GameMode targetGameMode;
                    if (command.getName().equalsIgnoreCase("gmc")) {
                        targetGameMode = GameMode.CREATIVE;
                    } else if (command.getName().equalsIgnoreCase("gms")) {
                        targetGameMode = GameMode.SURVIVAL;
                    } else {
                        targetGameMode = GameMode.SPECTATOR;
                    }

                    setGameMode(target, targetGameMode);

                    if (p != null) {
                        p.sendMessage(ChatColor.GREEN + "Nastaveno na " + targetGameMode.toString().toLowerCase() + " pro hráče " + target.getName() + "!");
                    } else {
                        sender.sendMessage(ChatColor.GREEN + "Nastaveno na " + targetGameMode.toString().toLowerCase() + " pro hráče " + target.getName() + "!");
                    }

                    return true;
                }
            }
        }
        return false;
    }

    private void setGameMode(Player player, GameMode gameMode) {
        if (player != null) {
            player.setGameMode(gameMode);
        }
    }
}
