package org.piano.joinleave.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.piano.joinleave.system.PianoCore;

public class PlayerConnection implements Listener {

    private final PianoCore plugin;

    public PlayerConnection(PianoCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        String joinMessage = plugin.getConfig().getString("join-message-format");

        joinMessage = joinMessage.replace("{player}", player.getName());

        e.setJoinMessage(joinMessage);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();


        String quitMessage = plugin.getConfig().getString("quit-message-format");


        quitMessage = quitMessage.replace("{player}", player.getName());

        e.setQuitMessage(quitMessage);
    }
}
