package fr.cozyhouse.legacyCombat.enumerator;

import fr.cozyhouse.legacyCombat.LegacyCombat;
import org.bukkit.NamespacedKey;

public enum ContainerKey {
    GAPPLE(new NamespacedKey(LegacyCombat.plugin, "old_apple"), "old_apple");

    public final NamespacedKey key;
    public final String name;

    ContainerKey(NamespacedKey key, String name){
        this.key = key;
        this.name = name;
    }
}
