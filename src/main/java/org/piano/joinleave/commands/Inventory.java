package org.piano.joinleave.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Inventory implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("inventory")) {
            if (sender instanceof Player ) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    p.openInventory(p.getInventory());
                    p.sendMessage(ChatColor.BLUE + "Otevíráš svůj inventář.");
                } else if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage("Tento hráč není online!");
                    } else {
                        p.openInventory(target.getInventory());
                        p.sendMessage(ChatColor.BLUE + "Otevíráš inventář hráče " + target.getName() + ".");
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Použití: /inventory [hráč]");
                }
                return true;
            }
        }

        return false;
    }
}
