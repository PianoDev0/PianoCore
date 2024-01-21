package org.piano.joinleave.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.ConsoleCommandSender;
import org.piano.joinleave.system.PianoCore;

public class Weather implements CommandExecutor {

    private final PianoCore plugin;

    public Weather(PianoCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((command.getName().equalsIgnoreCase("sun") || command.getName().equalsIgnoreCase("thunder"))) {
            if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
                Player p = (sender instanceof Player) ? (Player) sender : null;

                World world = (p != null) ? p.getWorld() : Bukkit.getWorlds().get(0);

                boolean isSunCommand = command.getName().equalsIgnoreCase("sun");
                world.setStorm(!isSunCommand);
                world.setThundering(isSunCommand);

                String weatherType = isSunCommand ? "sunny" : "stormy";

                if (p != null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("weather-set-message-" + weatherType)));
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("weather-set-message-" + weatherType)));
                }

                return true;
            }
        }
        return false;
    }
}

