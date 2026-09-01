package fr.cozyhouse.legacyCombat;

import fr.cozyhouse.legacyCombat.commands.CommandManager;
import fr.cozyhouse.legacyCombat.config.CombatParamManager;
import fr.cozyhouse.legacyCombat.config.ConfigManager;
import fr.cozyhouse.legacyCombat.config.VisualEffectManager;
import fr.cozyhouse.legacyCombat.listener.EntityDamageByEntityListener;
import fr.cozyhouse.legacyCombat.listener.PlayerInteractListener;
import fr.cozyhouse.legacyCombat.listener.PlayerItemConsumeListener;
import fr.cozyhouse.legacyCombat.listener.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class LegacyCombat extends JavaPlugin {

    static public LegacyCombat plugin;
    static public CooldownModule cooldownModule;
    static public ReachModule reachModule;
    static public ConfigManager configManager;
    static public CombatParamManager combatParamManager;
    static public VisualEffectManager visualEffectManager;
    static public GappleModule gappleModule;

    @Override
    public void onEnable() {
        plugin = this;
        configManager = new ConfigManager();
        combatParamManager = new CombatParamManager();
        visualEffectManager = new VisualEffectManager();

        Bukkit.getLogger().info("LegacyCombat activated");
        Bukkit.getLogger().info("Version : " + plugin.getDescription().getVersion());

        Objects.requireNonNull(this.getCommand("legacycombat")).setExecutor(new CommandManager());

        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerItemConsumeListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);

        cooldownModule = new CooldownModule();
        reachModule = new ReachModule();
        gappleModule = new GappleModule();
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
