package org.piano.joinleave.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.piano.joinleave.system.PianoCore;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Home implements CommandExecutor {

    private final Map<UUID, Location> playerHomes = new HashMap<>();
    private final File configFile;
    private final FileConfiguration config;

    public Home(PianoCore plugin) {
        this.configFile = new File(plugin.getDataFolder(), "homes.yml");
        this.config = YamlConfiguration.loadConfiguration(configFile);
        loadHomes();
    }

    private void loadHomes() {
        ConfigurationSection homesSection = config.getConfigurationSection("homes");
        if (homesSection != null) {
            for (String uuidString : homesSection.getKeys(false)) {
                UUID playerUUID = UUID.fromString(uuidString);
                Location homeLocation = (Location) homesSection.get(uuidString);
                playerHomes.put(playerUUID, homeLocation);
            }
        }
    }

    private void saveHomes() {
        ConfigurationSection homesSection = config.createSection("homes");
        for (Map.Entry<UUID, Location> entry : playerHomes.entrySet()) {
            homesSection.set(entry.getKey().toString(), entry.getValue());
        }

        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Tento příkaz může být použit pouze hráčem.");
            return true;
        }

        Player player = (Player) sender;
        UUID playerUUID = player.getUniqueId();

        if (command.getName().equalsIgnoreCase("home")) {
            if (args.length == 0) {
                if (playerHomes.containsKey(playerUUID)) {
                    player.teleport(playerHomes.get(playerUUID));
                    player.sendMessage(ChatColor.GREEN + "Teleportován(a) na svůj domov.");
                } else {
                    player.sendMessage(ChatColor.RED + "Nejprve si nastav svůj domov pomocí /home set.");
                }
            } else if (args.length == 1 && args[0].equalsIgnoreCase("set")) {
                playerHomes.put(playerUUID, player.getLocation());
                saveHomes(); // Save homes to the configuration file
                player.sendMessage(ChatColor.GREEN + "Domov byl nastaven na tuto pozici.");
            } else {
                player.sendMessage(ChatColor.RED + "Použití: /home [set]");
            }
            return true;
        }

        return false;
    }
}
