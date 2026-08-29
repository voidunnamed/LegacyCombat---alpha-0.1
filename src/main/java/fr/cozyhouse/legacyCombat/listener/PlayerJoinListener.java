package fr.cozyhouse.legacyCombat.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.nio.charset.StandardCharsets;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        e.setJoinMessage(e.getPlayer().getName() + " joined the server !");
    }
}
