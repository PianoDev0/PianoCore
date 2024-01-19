package org.piano.joinleave.system;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.piano.joinleave.events.PlayerConnection;

public final class PianoCore extends JavaPlugin {

    public static PianoCore Instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Instance = this;
        Bukkit.getConsoleSender().sendMessage("[PianoCore] Plugin byl správně načten!!");

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerConnection(), PianoCore.Instance);
    }

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
        }
        // /ping
        else if (command.getName().equalsIgnoreCase("ping")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                int ping = p.getPing();
                p.sendMessage(ChatColor.BLUE + "Ping: " + ping + "ms");
                return true;
            }
        }
        // /godmode
        else if (command.getName().equalsIgnoreCase("godmode")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    if (p.isInvulnerable()) {
                        p.setInvulnerable(false);
                        p.sendMessage(ChatColor.RED + "GodMode byl vypnut!");
                    } else {
                        p.setInvulnerable(true);
                        p.sendMessage(ChatColor.GREEN + "GodMode byl zapnut!");
                    }
                    return true;
                } else if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage("Tento hráč není online!");
                    } else {
                        if (target.isInvulnerable()) {
                            target.setInvulnerable(false);
                            p.sendMessage(ChatColor.RED + "GodMode byl vypnut pro hráče " + target.getName() + "!");
                        } else {
                            target.setInvulnerable(true);
                            p.sendMessage(ChatColor.GREEN + "GodMode byl zapnut pro hráče " + target.getName() + "!");
                        }
                    }
                    return true;
                }
            }
        }
        // /vanish
        else if (command.getName().equalsIgnoreCase("vanish")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    if (p.isInvisible()) {
                        p.setInvisible(false);
                        p.sendMessage(ChatColor.RED + "Vanish byl vypnut!");
                    } else {
                        p.setInvisible(true);
                        p.sendMessage(ChatColor.GREEN + "Vanish byl zapnut!");
                    }
                    return true;
                }           
                else if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage("Tento hráč není online!");
                    } else {
                        if (target.isInvisible()) {
                            target.setInvisible(false);
                            p.sendMessage(ChatColor.RED + "Vanish byl vypnut pro hráče " + target.getName() + "!");
                        } else {
                            target.setInvisible(true);
                            p.sendMessage(ChatColor.GREEN + "Vanish byl zapnut pro hráče " + target.getName() + "!");
                        }
                    }
                    return true;
                }
            }
        }
        // /heal
        else if (command.getName().equalsIgnoreCase("heal")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    p.setHealth(20.0);
                    p.sendMessage(ChatColor.GREEN + "Byl jsi úspěšně dohealován!");
                } else if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage("Tento hráč není online!");
                    } else {
                        target.setHealth(20.0);
                        p.sendMessage(ChatColor.GREEN + "Hráč " + target.getName() + " byl úspěšně dohealován!");
                    }
                }
                return true;
            }
        }
        // /gmc
        else if (command.getName().equalsIgnoreCase("gmc")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(ChatColor.GREEN + "Nastaveno na creative!");
                } else if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage("Tento hráč není online!");
                    } else {
                        target.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(ChatColor.GREEN + "Nastaveno na creative pro hráče " + target.getName() + "!");
                    }
                }
                return true;
            }
        }
        // /gms
        else if (command.getName().equalsIgnoreCase("gms")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(ChatColor.GREEN + "Nastaveno na survival!");
                } else if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage("Tento hráč není online!");
                    } else {
                        target.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(ChatColor.GREEN + "Nastaveno na survival pro hráče " + target.getName() + "!");
                    }
                }
                return true;
            }
        }
        // /gmsp
        else if (command.getName().equalsIgnoreCase("gmsp")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(ChatColor.GREEN + "Nastaveno na spectator!");
                } else if (args.length == 1) {
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if (target == null) {
                        p.sendMessage("Tento hráč není online!");
                    } else {
                        target.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(ChatColor.GREEN + "Nastaveno na spectator pro hráče " + target.getName() + "!");
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

