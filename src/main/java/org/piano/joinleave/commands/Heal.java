package org.piano.joinleave.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("Heal")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    p.setHealth(20.0);
                    p.setFoodLevel(20);
                    p.sendMessage(ChatColor.GREEN + "Byl jsi úspěšně dohealován!");
                } else if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage("Tento hráč není online!");
                    } else {
                        target.setHealth(20.0);
                        target.setFoodLevel(20);
                        p.sendMessage(ChatColor.GREEN + "Hráč " + target.getName() + " byl úspěšně dohealován!");
                    }
                }
                return true;
            }
        }
        return false;
    }
}
