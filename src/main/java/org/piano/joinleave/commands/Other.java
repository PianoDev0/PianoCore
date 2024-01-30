package org.piano.joinleave.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
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
        } else if (command.getName().equalsIgnoreCase("repairall")) {
            if (sender instanceof Player p) {
                repairAllItems(p);
                p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("repairall-success-message"));
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "Tento příkaz může používat pouze hráč.");
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

    private void repairAllItems(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null && item.getType() != Material.AIR) {
                item.setDurability((short) 0);
            }
        }

        ItemStack handItem = player.getInventory().getItemInMainHand();
        if (handItem != null && handItem.getType() != Material.AIR) {
            handItem.setDurability((short) 0);
        }
    }
}
