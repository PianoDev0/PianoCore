package org.piano.joinleave.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathMessage implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        String playerName = event.getEntity().getName();

        String deathCause = event.getDeathMessage();

        String customDeathMessage = ChatColor.RED + playerName + " zemřel" + ((deathCause != null && !deathCause.isEmpty()) ? " (" + deathCause + ")" : "");

        event.setDeathMessage(customDeathMessage);
    }
}
