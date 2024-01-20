package org.piano.joinleave.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("help")) {
            if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
                sender.sendMessage(ChatColor.GREEN + "Seznam příkazů:");
                sender.sendMessage(ChatColor.GOLD + "/die" + ChatColor.WHITE + " - Jednoduchá cesta jak si vzít život");
                sender.sendMessage(ChatColor.GOLD + "/discord" + ChatColor.WHITE + " - Discord Invite");
                sender.sendMessage(ChatColor.GOLD + "/ping" + ChatColor.WHITE + " - Vypíše ping serveru");
                sender.sendMessage(ChatColor.GOLD + "/godmode" + ChatColor.WHITE + " - Zapne godmode");
                sender.sendMessage(ChatColor.GOLD + "/vanish" + ChatColor.WHITE + " - Zapne vanish");
                sender.sendMessage(ChatColor.GOLD + "/heal" + ChatColor.WHITE + " - Vyhealuje hráče");
                sender.sendMessage(ChatColor.GOLD + "/gmc" + ChatColor.WHITE + " - Nastaví creative");
                sender.sendMessage(ChatColor.GOLD + "/gms" + ChatColor.WHITE + " - Nastaví survival");
                sender.sendMessage(ChatColor.GOLD + "/gmsp" + ChatColor.WHITE + " - Nastaví spectator");
                sender.sendMessage(ChatColor.GOLD + "/fly" + ChatColor.WHITE + " - Zapne/vypne létání");
                sender.sendMessage(ChatColor.GOLD + "/flyspeed" + ChatColor.WHITE + " - Nastaví rychlost létání");
                sender.sendMessage(ChatColor.GOLD + "/about" + ChatColor.WHITE + " - Napíše info o pluginu");
                sender.sendMessage(ChatColor.GOLD + "/web" + ChatColor.WHITE + " - Odkaz na náš web");
                sender.sendMessage(ChatColor.GOLD + "/inventory" + ChatColor.WHITE + " - Otevře inventář hráče");
                sender.sendMessage(ChatColor.GOLD + "/sun" + ChatColor.WHITE + " - Nastaví počasí na slunečno");
                sender.sendMessage(ChatColor.GOLD + "/thunder" + ChatColor.WHITE + " - Nastaví počasí na bouřku");
                sender.sendMessage(ChatColor.GOLD + "/day" + ChatColor.WHITE + " - Nastaví den");
                sender.sendMessage(ChatColor.GOLD + "/night" + ChatColor.WHITE + " - Nastaví noc");
                sender.sendMessage(ChatColor.GOLD + "/home [set]" + ChatColor.WHITE + " - Teleportuje vás domů");
                sender.sendMessage(ChatColor.GOLD + "/freeze" + ChatColor.WHITE + " - Zmrazí hráče");
                sender.sendMessage(ChatColor.GOLD + "/rules" + ChatColor.WHITE + " - Zobrazí pravidla serveru");
            } else {
                sender.sendMessage(ChatColor.RED + "Tento příkaz může použít pouze hráč v hře nebo konzole.");
            }
            return true;
        }
        return false;
    }
}
