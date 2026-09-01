package fr.cozyhouse.legacyCombat.config;

import fr.cozyhouse.legacyCombat.LegacyCombat;
import fr.cozyhouse.legacyCombat.enumerator.Section;
import fr.cozyhouse.legacyCombat.enumerator.VisualEffect;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;

public class VisualEffectManager {

    private final Map<VisualEffect, Object> values;

    public VisualEffectManager(){
        this.values = new HashMap<>();
        registerCombatParam();
    }

    public void registerCombatParam(){
        var config = LegacyCombat.configManager.getConfig();
        String basePath = LegacyCombat.configManager.getSections().get(Section.GENERAL).getCurrentPath()
                + "." + Section.VISUAL_EFFECT.name;

        ConfigurationSection combatParamSection = LegacyCombat.configManager.getOrCreateSection(basePath, Section.VISUAL_EFFECT);
        if (combatParamSection == null) return;

        boolean changed = false;
        for (VisualEffect param : VisualEffect.values()) {
            String path = basePath + "." + param.name;
            if (!config.contains(path)) {
                config.set(path, param.defaultValue);
                changed = true;
            }
            values.put(param, config.get(path));
        }

        if (changed)
            LegacyCombat.configManager.saveConfig();
    }

    public Object getValue(VisualEffect param){
        return values.get(param);
    }
}
