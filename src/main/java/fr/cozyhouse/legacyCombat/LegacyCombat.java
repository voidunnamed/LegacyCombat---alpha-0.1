package fr.cozyhouse.legacyCombat;

import fr.cozyhouse.legacyCombat.commands.CommandManager;
import fr.cozyhouse.legacyCombat.listener.EntityDamageByEntityListener;
import fr.cozyhouse.legacyCombat.listener.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class LegacyCombat extends JavaPlugin {

    static public LegacyCombat plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getLogger().info("LegacyCombat activated");
        Bukkit.getLogger().info("Version : " + plugin.getDescription().getVersion());
        Objects.requireNonNull(this.getCommand("legacycombat")).setExecutor(new CommandManager());
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
