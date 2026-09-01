package fr.cozyhouse.legacyCombat.config;

import fr.cozyhouse.legacyCombat.LegacyCombat;
import fr.cozyhouse.legacyCombat.enumerator.CombatParam;
import fr.cozyhouse.legacyCombat.enumerator.Section;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;

public class CombatParamManager {

    private final Map<CombatParam, Object> values;

    public CombatParamManager(){
        this.values = new HashMap<>();
        registerCombatParam();
    }

    public void registerCombatParam(){
        var config = LegacyCombat.configManager.getConfig();
        String basePath = LegacyCombat.configManager.getSections().get(Section.GENERAL).getCurrentPath()
                + "." + Section.COMBATPARAM.name;

        ConfigurationSection combatParamSection = LegacyCombat.configManager.getOrCreateSection(basePath, Section.COMBATPARAM);
        if (combatParamSection == null) return;

        boolean changed = false;
        for (CombatParam param : CombatParam.values()) {
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

    public Object getValue(CombatParam param){
        return values.get(param);
    }
}
