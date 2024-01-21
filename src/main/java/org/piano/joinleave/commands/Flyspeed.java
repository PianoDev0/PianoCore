package org.piano.joinleave.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.piano.joinleave.system.PianoCore;

public class Flyspeed implements CommandExecutor {

    private final PianoCore plugin;

    public Flyspeed(PianoCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("flyspeed")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (args.length == 1) {
                    try {
                        float speed = Float.parseFloat(args[0]);
                        if (speed >= 0.1 && speed <= 10) {
                            player.setFlySpeed(speed / 10);
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("flyspeed-set-message"))
                                    .replace("{speed}", args[0]));
                        } else {
                            player.sendMessage(ChatColor.RED + "Zadejte platnou rychlost od 1 do 10!");
                        }
                    } catch (NumberFormatException e) {
                        player.sendMessage(ChatColor.RED + "Zadejte platnou rychlost od 1 do 10!");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Použití: /flyspeed <rychlost>");
                }
                return true;
            }
        }
        return false;
    }
}
