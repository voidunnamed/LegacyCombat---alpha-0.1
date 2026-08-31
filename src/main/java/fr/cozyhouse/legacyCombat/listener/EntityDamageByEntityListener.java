package fr.cozyhouse.legacyCombat.listener;

import fr.cozyhouse.legacyCombat.LegacyCombat;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class EntityDamageByEntityListener implements Listener {
    int count;

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e){
        Bukkit.getLogger().info(String.valueOf(e.getDamage()));
        if (e.getDamager() instanceof Player player){
            Bukkit.getLogger().info(String.valueOf(player.isSprinting()));
            Bukkit.getLogger().info(String.valueOf(Objects.requireNonNull(player.getAttribute(Objects.requireNonNull(Registry.ATTRIBUTE.get(NamespacedKey.minecraft("attack_speed"))))).getValue()));
        }
        Bukkit.getLogger().info(String.valueOf(e.getDamager().getFallDistance() > 0));
        count = 0;
        new BukkitRunnable() {
            @Override
            public void run() {
                count++;
                if (count < 3) {
                    Bukkit.getLogger().info(e.getEntity().getLocation().toString());
                } else {
                    this.cancel();
                }
            }
        }.runTaskTimer(LegacyCombat.plugin, 0L, 20L);
    }
}
