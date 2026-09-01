package fr.cozyhouse.legacyCombat;

import fr.cozyhouse.legacyCombat.enumerator.CombatParam;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import java.util.Objects;

public class ReachModule {

    public void changeReach(Player player) {
        Object reachValue = LegacyCombat.combatParamManager.getValue(CombatParam.REACH);
        if (reachValue instanceof Double) {
            Objects.requireNonNull(player.getAttribute(Attribute.ENTITY_INTERACTION_RANGE)).setBaseValue((Double) reachValue);
            player.sendMessage("Reach has been modify to : " + reachValue);
        }
    }
}
