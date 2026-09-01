package fr.cozyhouse.legacyCombat.listener;

import fr.cozyhouse.legacyCombat.LegacyCombat;
import fr.cozyhouse.legacyCombat.enumerator.CombatParam;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.UseCooldownComponent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        if (e.getHand() != EquipmentSlot.HAND)
            return;
        if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK)
            return;

        ItemStack item = e.getItem();
        if (item == null || item.getType() != Material.ENDER_PEARL)
            return;

        Bukkit.getLogger().info("[DEBUG] Pearl throw intercepted, cancelling vanilla");
        e.setCancelled(true);

        Player player = e.getPlayer();

        ItemMeta meta = item.getItemMeta();

        assert meta != null;
        meta.setUseCooldown(null);
        item.setItemMeta(meta);
        player.getInventory().setItemInMainHand(item);

        item.setItemMeta(meta);
        player.getInventory().setItemInMainHand(item);

        player.launchProjectile(EnderPearl.class, player.getLocation().getDirection().multiply(1.5));
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDER_PEARL_THROW, 0.5f, 0.4f);

        if (player.getGameMode() != GameMode.CREATIVE)
            item.setAmount(item.getAmount() - 1);
    }
}
