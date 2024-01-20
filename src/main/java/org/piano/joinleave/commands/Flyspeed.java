package org.piano.joinleave.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Flyspeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("flyspeed")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 1) {
                    try {
                        float speed = Float.parseFloat(args[0]);
                        if (speed >= 0.1 && speed <= 10) {
                            p.setFlySpeed(speed / 10);
                            p.sendMessage(ChatColor.GREEN + "Rychlost létání byla nastavena na " + args[0] + "!");
                        } else {
                            p.sendMessage(ChatColor.RED + "Zadejte platnou rychlost od 1 do 10!");
                        }
                    } catch (NumberFormatException e) {
                        p.sendMessage(ChatColor.RED + "Zadejte platnou rychlost od 1 do 10!");
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Použití: /flyspeed <rychlost>");
                }
                return true;
            }
        }
        return false;
    }
}
