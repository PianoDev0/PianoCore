package org.piano.joinleave.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemodes implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("gmc")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(ChatColor.GREEN + "Nastaveno na creative!");
                } else if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage("Tento hráč není online!");
                    } else {
                        target.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(ChatColor.GREEN + "Nastaveno na creative pro hráče " + target.getName() + "!");
                    }
                }
                return true;
            }
        } else if (command.getName().equalsIgnoreCase("gms")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(ChatColor.GREEN + "Nastaveno na survival!");
                } else if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage("Tento hráč není online!");
                    } else {
                        target.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(ChatColor.GREEN + "Nastaveno na survival pro hráče " + target.getName() + "!");
                    }
                }
                return true;
            }
        } else if (command.getName().equalsIgnoreCase("gmsp")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(ChatColor.GREEN + "Nastaveno na spectator!");
                } else if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage("Tento hráč není online!");
                    } else {
                        target.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(ChatColor.GREEN + "Nastaveno na spectator pro hráče " + target.getName() + "!");
                    }
                }
                return true;
            }
        }
        return false;
    }
}
