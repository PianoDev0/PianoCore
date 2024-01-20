package org.piano.joinleave.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class GodMode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("godmode")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    if (p.isInvulnerable()) {
                        p.setInvulnerable(false);
                        p.sendMessage(ChatColor.RED + "GodMode byl vypnut!");
                    } else {
                        p.setInvulnerable(true);
                        p.sendMessage(ChatColor.GREEN + "GodMode byl zapnut!");
                    }
                    return true;
                } else if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage("Tento hráč není online!");
                    } else {
                        if (target.isInvulnerable()) {
                            target.setInvulnerable(false);
                            p.sendMessage(ChatColor.RED + "GodMode byl vypnut pro hráče " + target.getName() + "!");
                        } else {
                            target.setInvulnerable(true);
                            p.sendMessage(ChatColor.GREEN + "GodMode byl zapnut pro hráče " + target.getName() + "!");
                        }
                        return true;
                    }
                }
            } else if (sender instanceof ConsoleCommandSender) {
                if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        sender.sendMessage("Tento hráč není online!");
                    } else {
                        if (target.isInvulnerable()) {
                            target.setInvulnerable(false);
                            sender.sendMessage("GodMode byl vypnut pro hráče " + target.getName() + "!");
                        } else {
                            target.setInvulnerable(true);
                            sender.sendMessage("GodMode byl zapnut pro hráče " + target.getName() + "!");
                        }
                        return true;
                    }
                } else {
                    sender.sendMessage("Musíš zadat jméno hráče jako argument z konzole.");

                    return true;
                }
            }
        }
        return false;
    }
}

