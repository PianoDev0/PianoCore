package org.piano.joinleave.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.piano.joinleave.system.PianoCore;

public class Vanish implements CommandExecutor {

    private final PianoCore plugin;

    public Vanish(PianoCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("vanish")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;

                if (args.length == 0) {
                    toggleVanish(p, p);
                    return true;
                } else if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage(ChatColor.RED + "Tento hráč není online!");
                    } else {
                        toggleVanish(p, target);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void toggleVanish(Player sender, Player target) {
        if (target.isInvisible()) {
            target.setInvisible(false);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("vanish-off-message"))
                    .replace("{player}", target.getName()));
        } else {
            target.setInvisible(true);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("vanish-on-message"))
                    .replace("{player}", target.getName()));
        }
    }
}
