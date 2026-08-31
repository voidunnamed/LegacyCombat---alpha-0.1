package fr.cozyhouse.legacyCombat.listener;

import fr.cozyhouse.legacyCombat.LegacyCombat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        e.setJoinMessage(e.getPlayer().getName() + " joined the server !");
        if (LegacyCombat.cooldownModule.getState())
            LegacyCombat.cooldownModule.neutralizer(e.getPlayer());
        else
            LegacyCombat.cooldownModule.activator(e.getPlayer());
    }
}
