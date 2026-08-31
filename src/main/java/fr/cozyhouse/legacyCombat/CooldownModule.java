package fr.cozyhouse.legacyCombat;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

public class CooldownModule {

    private boolean state;

    public CooldownModule(){
        this.state = false;
    }

    private static final NamespacedKey ATTACK_SPEED_KEY =
            NamespacedKey.minecraft("attack_speed");

    public void changeState(boolean state){
        this.state = state;
        for (Player player : Bukkit.getOnlinePlayers()){
            if (state)
                neutralizer(player);
            else
                activator(player);
        }
    }

    public boolean getState(){
        return this.state;
    }

    public void neutralizer(Player player){
        Attribute attackSpeed = Registry.ATTRIBUTE.get(ATTACK_SPEED_KEY);
        if (attackSpeed == null)
            return;
        AttributeInstance instance = player.getAttribute(attackSpeed);
        if (instance != null) {
            instance.setBaseValue(1024.0D);
        }
    }

    public void activator(Player player){
        Attribute attackSpeed = Registry.ATTRIBUTE.get(ATTACK_SPEED_KEY);
        if (attackSpeed == null){
           return;
        }
        AttributeInstance instance = player.getAttribute(attackSpeed);
        if (instance != null){
            instance.setBaseValue(4.0D);
        }
    }

}
