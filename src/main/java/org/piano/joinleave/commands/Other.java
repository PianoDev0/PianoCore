package org.piano.joinleave.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class Other implements CommandExecutor  {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("die")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.setHealth(0.0);
                p.sendMessage(ChatColor.RED + "Úspěšně sis vzal život!");
                return true;
            }
        } else if (command.getName().equalsIgnoreCase("discord")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(ChatColor.BLUE + "Pozvánka na náš server: https://discord.gg/...");
                return true;
            }
        } else if (command.getName().equalsIgnoreCase("ping")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                int ping = p.getPing();
                p.sendMessage(ChatColor.BLUE + "Ping: " + ping + "ms");
                return true;
            }
        }else if (command.getName().equalsIgnoreCase("about")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage("§9§lO PianoCore: ");
                p.sendMessage("§bVerze: 1.0");
                p.sendMessage("§3Vývojář pluginu: PianoDev_");
                return true;
                }
        }else if (command.getName().equalsIgnoreCase("web")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(ChatColor.BLUE + "Odkaz na náš web: https://...");
                return true;
                }
            }
        return false;
    }
}
