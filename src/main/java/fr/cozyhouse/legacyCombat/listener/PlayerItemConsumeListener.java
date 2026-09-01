package fr.cozyhouse.legacyCombat.listener;

import fr.cozyhouse.legacyCombat.LegacyCombat;
import fr.cozyhouse.legacyCombat.enumerator.ContainerKey;
import fr.cozyhouse.legacyCombat.enumerator.VisualEffect;
import fr.cozyhouse.legacyCombat.particules.ParticulesUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class PlayerItemConsumeListener implements Listener {

    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent e){
        if (Objects.requireNonNull(e.getItem().getItemMeta()).getPersistentDataContainer().has(ContainerKey.GAPPLE.key)){
            Bukkit.getScheduler().runTask(LegacyCombat.plugin, () ->
                    e.getPlayer().addPotionEffect(new PotionEffect(
                            PotionEffectType.REGENERATION, 30 * 20, 4, false, true)));
            Object visualValue = LegacyCombat.visualEffectManager.getValue(VisualEffect.GAPPEL_EFFECT);
            if (visualValue instanceof Boolean) {
                if ((Boolean) visualValue)
                    ParticulesUtils.spiralParticulesLoc(e.getPlayer().getLocation());
            }
        }
    }
}
