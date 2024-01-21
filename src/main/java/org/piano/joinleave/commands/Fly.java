package org.piano.joinleave.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.piano.joinleave.system.PianoCore;

public class Fly implements CommandExecutor {

    private final PianoCore plugin;

    public Fly(PianoCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("fly")) {
            if (sender instanceof Player p) {
                if (args.length == 0) {
                    toggleFly(p, p);
                } else if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage(ChatColor.RED + "Tento hráč není online!");
                    } else {
                        toggleFly(p, target);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private void toggleFly(Player sender, Player target) {
        if (target.getAllowFlight()) {
            target.setAllowFlight(false);
            target.setFlying(false);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("fly-off-message"))
                    .replace("{player}", target.getName()));
        } else {
            target.setAllowFlight(true);
            target.setFlying(true);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("fly-on-message"))
                    .replace("{player}", target.getName()));
        }
    }
}
