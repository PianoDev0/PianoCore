package org.piano.joinleave.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.piano.joinleave.system.PianoCore;

public class GodMode implements CommandExecutor {

    private final PianoCore plugin;

    public GodMode(PianoCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("godmode")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    toggleGodMode(p);
                    return true;
                } else if (args.length == 1) {
                    Player target = Bukkit.getServer().getPlayerExact(args[0]);

                    if (target == null) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("godmode-player-not-online")));
                    } else {
                        toggleGodMode(target);
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(target.isInvulnerable() ? "godmode-enabled-message-other" : "godmode-disabled-message-other"))
                                .replace("{player}", target.getName()));
                        return true;
                    }
                }
            } else if (sender instanceof ConsoleCommandSender) {
                if (args.length == 1) {
                    Player target = Bukkit.getServer().getPlayerExact(args[0]);

                    if (target == null) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("godmode-player-not-online")));
                    } else {
                        toggleGodMode(target);
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString(target.isInvulnerable() ? "godmode-enabled-message-other" : "godmode-disabled-message-other"))
                                .replace("{player}", target.getName()));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void toggleGodMode(Player player) {
        if (player.isInvulnerable()) {
            player.setInvulnerable(false);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("godmode-disabled-message")));
        } else {
            player.setInvulnerable(true);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("godmode-enabled-message")));
        }
    }
}
