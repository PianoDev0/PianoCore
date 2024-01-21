package org.piano.joinleave.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.piano.joinleave.system.PianoCore;

import java.util.List;

public class Rules implements CommandExecutor {

    private final PianoCore plugin;

    public Rules(PianoCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if (command.getName().equalsIgnoreCase("rules")) {
            List<String> rulesList = plugin.getConfig().getStringList("rules");

            if (!rulesList.isEmpty()) {

                for (String rule : rulesList) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', rule));
                }
            } else {
                p.sendMessage(ChatColor.RED + "Nebyla nalezena žádná pravidla.");
            }

            return true;
        }

        return false;
    }
}
