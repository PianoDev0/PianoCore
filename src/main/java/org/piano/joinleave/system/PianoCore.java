package org.piano.joinleave.system;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.piano.joinleave.commands.*;
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

        getCommand("godmode").setExecutor(new GodMode());
        getCommand("gmc").setExecutor(new Gamemodes());
        getCommand("gms").setExecutor(new Gamemodes());
        getCommand("gmsp").setExecutor(new Gamemodes());
        getCommand("fly").setExecutor(new Fly());
        getCommand("heal").setExecutor(new Heal());
        getCommand("flyspeed").setExecutor(new Flyspeed());
        getCommand("die").setExecutor(new Other());
        getCommand("ping").setExecutor(new Other());
        getCommand("discord").setExecutor(new Other());



    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}


