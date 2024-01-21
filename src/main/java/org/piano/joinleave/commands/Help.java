package org.piano.joinleave.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.piano.joinleave.system.PianoCore;

import java.util.List;

public class Help implements CommandExecutor {

    private final PianoCore plugin;

    public Help(PianoCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("help")) {
            if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("help-command-title")));
                List<String> commandList = plugin.getConfig().getStringList("help-command-list");
                for (String commandMessage : commandList) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', commandMessage));
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("help-command-no-permission")));
            }
            return true;
        }
        return false;
    }
}

