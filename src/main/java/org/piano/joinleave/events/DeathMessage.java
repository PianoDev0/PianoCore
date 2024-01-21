package org.piano.joinleave.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.piano.joinleave.system.PianoCore;

public class DeathMessage implements Listener {

    private final PianoCore plugin;

    public DeathMessage(PianoCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        String playerName = event.getEntity().getName();
        String deathCause = event.getDeathMessage();

        String customDeathMessage = plugin.getConfig().getString("death-message-format");


        customDeathMessage = customDeathMessage.replace("{player}", playerName)
                .replace("{cause}", (deathCause != null && !deathCause.isEmpty()) ? "(" + deathCause + ")" : "");

        event.setDeathMessage(ChatColor.translateAlternateColorCodes('&', customDeathMessage));
    }
}
