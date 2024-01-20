package org.piano.joinleave.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("heal")) {
            Player target = null;

            if (sender instanceof Player) {
                Player p = (Player) sender;

                if (args.length == 1) {
                    String playerName = args[0];
                    target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage(ChatColor.RED + "Tento hráč není online!");
                        return true;
                    }
                } else {
                    p.setHealth(20.0);
                    p.setFoodLevel(30);
                    p.sendMessage(ChatColor.GREEN + "Byl jsi úspěšně dohealován!");
                    return true;
                }
            } else if (sender instanceof ConsoleCommandSender || sender instanceof BlockCommandSender) {
                if (args.length == 1) {
                    String playerName = args[0];
                    target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        sender.sendMessage("Tento hráč není online!");
                        return true;
                    }
                } else {
                    sender.sendMessage("Musíš zadat jméno hráče jako argument z konzole nebo command blocku.");
                    return true;
                }
            }

            if (target != null) {
                target.setHealth(20.0);
                target.setFoodLevel(30);
                sender.sendMessage(ChatColor.GREEN + "Hráč " + target.getName() + " byl úspěšně dohealován!");
                return true;
            }
        }
        return false;
    }
}
