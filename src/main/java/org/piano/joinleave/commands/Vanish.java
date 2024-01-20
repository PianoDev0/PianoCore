package org.piano.joinleave.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vanish implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("vanish")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    if (p.isInvisible()) {
                        p.setInvisible(false);
                        p.sendMessage(ChatColor.RED + "Vanish byl vypnut!");
                    } else {
                        p.setInvisible(true);
                        p.sendMessage(ChatColor.GREEN + "Vanish byl zapnut!");
                    }
                    return true;
                } else if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage("Tento hráč není online!");
                    } else {
                        if (target.isInvisible()) {
                            target.setInvisible(false);
                            p.sendMessage(ChatColor.RED + "Vanish byl vypnut pro hráče " + target.getName() + "!");
                        } else {
                            target.setInvisible(true);
                            p.sendMessage(ChatColor.GREEN + "Vanish byl zapnut pro hráče " + target.getName() + "!");
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
