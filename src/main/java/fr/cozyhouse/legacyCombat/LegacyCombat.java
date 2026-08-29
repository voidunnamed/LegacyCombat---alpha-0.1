package fr.cozyhouse.legacyCombat;

import fr.cozyhouse.legacyCombat.commands.CommandManager;
import fr.cozyhouse.legacyCombat.listener.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class LegacyCombat extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("LegacyCombat activated");
        Bukkit.getLogger().info("Version : " + Bukkit.getVersion());
        Objects.requireNonNull(this.getCommand("legacycombat")).setExecutor(new CommandManager());
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
