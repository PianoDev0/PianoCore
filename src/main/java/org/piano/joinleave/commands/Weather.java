package org.piano.joinleave.commands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.ConsoleCommandSender;

public class Weather implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((command.getName().equalsIgnoreCase("sun") || command.getName().equalsIgnoreCase("thunder"))) {
            if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
                Player p = (sender instanceof Player) ? (Player) sender : null;


                World world = (p != null) ? p.getWorld() : Bukkit.getWorlds().get(0);

                boolean isSunCommand = command.getName().equalsIgnoreCase("sun");
                world.setStorm(!isSunCommand);
                world.setThundering(isSunCommand);

                if (p != null) {
                    p.sendMessage(ChatColor.GREEN + "Počasí nastaveno na " + (isSunCommand ? "slunečné" : "bouřlivé") + "!");
                } else {
                    sender.sendMessage(ChatColor.GREEN + "Počasí nastaveno na " + (isSunCommand ? "slunečné" : "bouřlivé") + "!");
                }

                return true;
            }
        }
        return false;
    }
}

