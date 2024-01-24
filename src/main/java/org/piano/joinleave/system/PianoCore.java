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
        pm.registerEvents(new PlayerConnection(this), PianoCore.Instance);
        pm.registerEvents(new DeathMessage(this), PianoCore.Instance);

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        getCommand("godmode").setExecutor(new GodMode(this));
        getCommand("gmc").setExecutor(new Gamemodes(this));
        getCommand("gms").setExecutor(new Gamemodes(this));
        getCommand("gmsp").setExecutor(new Gamemodes(this));
        getCommand("fly").setExecutor(new Fly(this));
        getCommand("heal").setExecutor(new Heal(this));
        getCommand("flyspeed").setExecutor(new Flyspeed(this));
        getCommand("die").setExecutor(new Other(this));
        getCommand("ping").setExecutor(new Other(this));
        getCommand("discord").setExecutor(new Other(this));
        getCommand("web").setExecutor(new Other(this));
        getCommand("repairall").setExecutor(new Other(this));
        getCommand("about").setExecutor(new Other(this));
        getCommand("inventory").setExecutor(new Inventory(this));
        getCommand("pihelp").setExecutor(new Help(this));
        getCommand("vanish").setExecutor(new Vanish(this));
        getCommand("day").setExecutor(new Time(this));
        getCommand("night").setExecutor(new Time(this));
        getCommand("sun").setExecutor(new Weather(this));
        getCommand("thunder").setExecutor(new Weather(this));
        getCommand("rain").setExecutor(new Weather(this));
        getCommand("home").setExecutor(new Home(this));
        getCommand("freeze").setExecutor(new Freeze(this));
        getCommand("rules").setExecutor(new Rules(this));
        getCommand("pireload").setExecutor(new Reload(this));

    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}


