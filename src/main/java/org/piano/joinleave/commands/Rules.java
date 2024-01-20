package org.piano.joinleave.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Rules implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("rules")) {
            sender.sendMessage(ChatColor.GOLD + "Pravidla serveru:");
            sender.sendMessage(ChatColor.YELLOW + "1. Respektuj ostatní hráče.");
            sender.sendMessage(ChatColor.YELLOW + "2. Nepoužívej cheaty ani hacky.");
            sender.sendMessage(ChatColor.YELLOW + "3. Nedělej spam nebo reklamu.");
            sender.sendMessage(ChatColor.YELLOW + "4. Nenič a nebourej cizích staveb.");
            sender.sendMessage(ChatColor.YELLOW + "5. Dodržuj obecná pravidla chování.");
            return true;
        }

        return false;
    }
}
