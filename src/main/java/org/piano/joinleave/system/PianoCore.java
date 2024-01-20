package org.piano.joinleave.system;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.piano.joinleave.commands.*;
import org.piano.joinleave.events.DeathMessage;
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
        pm.registerEvents(new DeathMessage(), PianoCore.Instance);

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
        getCommand("web").setExecutor(new Other());
        getCommand("about").setExecutor(new Other());
        getCommand("inventory").setExecutor(new Inventory());
        getCommand("help").setExecutor(new Help());
        getCommand("day").setExecutor(new Time());
        getCommand("night").setExecutor(new Time());
        getCommand("sun").setExecutor(new Weather());
        getCommand("thunder").setExecutor(new Weather());



    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}


