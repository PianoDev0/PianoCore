package org.piano.joinleave.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.ConsoleCommandSender;

public class Time implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((command.getName().equalsIgnoreCase("day") || command.getName().equalsIgnoreCase("night"))) {
            if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
                Player p = (sender instanceof Player) ? (Player) sender : null;


                World world = (p != null) ? p.getWorld() : Bukkit.getWorlds().get(0);

                long time = (command.getName().equalsIgnoreCase("day")) ? 0 : 13000;
                world.setTime(time);

                if (p != null) {
                    p.sendMessage(ChatColor.GREEN + "Čas nastaven na " + ((time == 0) ? "denní" : "noční") + "!");
                } else {
                    sender.sendMessage(ChatColor.GREEN + "Čas nastaven na " + ((time == 0) ? "denní" : "noční") + "!");
                }

                return true;
            }
        }
        return false;
    }
}

