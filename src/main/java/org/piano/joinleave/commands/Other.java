package org.piano.joinleave.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.piano.joinleave.system.PianoCore;

public class Other implements CommandExecutor {

    private final PianoCore plugin;

    public Other(PianoCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("die")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.setHealth(0.0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("die-command-success")));
                return true;
            }
        } else if (command.getName().equalsIgnoreCase("discord")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("discord-command-message")));
                return true;
            }
        } else if (command.getName().equalsIgnoreCase("ping")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                int ping = p.getPing();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("ping-command-message").replace("%ping%", String.valueOf(ping))));
                return true;
            }
        } else if (command.getName().equalsIgnoreCase("about")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                for (String line : plugin.getConfig().getStringList("about-command-message")) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                }
                return true;
            }
        } else if (command.getName().equalsIgnoreCase("web")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("web-command-message")));
                return true;
            }
        }
        return false;
    }
}
