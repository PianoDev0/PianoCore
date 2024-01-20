package org.piano.joinleave.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("fly")) {
            if (sender instanceof Player p) {
                if (args.length == 0) {
                    if (p.getAllowFlight()) {
                        p.setAllowFlight(false);
                        p.setFlying(false);
                        p.sendMessage(ChatColor.RED + "Létání bylo vypnuto!");
                    } else {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        p.sendMessage(ChatColor.GREEN + "Létání bylo zapnuto!");
                    }
                }else{
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage("Tento hráč není online!");
                    } else {
                        if (target.getAllowFlight()) {
                            target.setAllowFlight(false);
                            target.setFlying(false);
                            p.sendMessage(ChatColor.RED + "Létání bylo vypnuto pro hráče "+ target.getName() +"!");
                        } else {
                            target.setAllowFlight(true);
                            target.setFlying(true);
                            p.sendMessage(ChatColor.GREEN + "Létání bylo zapnuto pro hráče " + target.getName() + "!");
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
