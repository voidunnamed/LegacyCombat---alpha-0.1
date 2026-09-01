package fr.cozyhouse.legacyCombat.config;

import fr.cozyhouse.legacyCombat.LegacyCombat;
import fr.cozyhouse.legacyCombat.enumerator.Section;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager {

    private FileConfiguration config;
    private File configFile;
    private final Map<Section, ConfigurationSection> sections;

    public ConfigManager(){
        this.sections = new HashMap<>();
        createFile();
        createYaml();
        createDefaultSection();
    }

    public Map<Section, ConfigurationSection> getSections(){
        return this.sections;
    }

    public void addSection(Section sectionName, ConfigurationSection section){
        this.sections.put(sectionName, section);
    }

    public void removeSection(Section sectionName, ConfigurationSection section){
        this.sections.remove(sectionName, section);
    }

    public void createFile(){
        try{
            File directory = new File(LegacyCombat.plugin.getDataFolder(), "LegacyConfig");
            if (!directory.exists() && !directory.mkdirs()){
                LegacyCombat.plugin.getLogger().severe("An error occurred while creating directory");
                return;
            }
            configFile = new File(directory , "config.yml");
            if (configFile.createNewFile())
                LegacyCombat.plugin.getLogger().info("Config file created");
            else
                LegacyCombat.plugin.getLogger().info("Config file already exist");
        } catch (IOException e) {
            LegacyCombat.plugin.getLogger().severe("An error occurred while creating Config file");
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfig(){
        return this.config;
    }

    public void saveConfig(){
        try {
            this.config.save(this.configFile);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void createYaml(){
        this.config = new YamlConfiguration();
        try {
            config.load(configFile);
        } catch (IOException | InvalidConfigurationException e){
            e.printStackTrace();
        }
    }

    public void createDefaultSection(){
        if (this.config.contains(Section.GENERAL.name)){
            sections.put(Section.GENERAL, this.config.getConfigurationSection(Section.GENERAL.name));
            return;
        }
        ConfigurationSection generalSection = this.config.createSection(Section.GENERAL.name);
        sections.put(Section.GENERAL, generalSection);
        saveConfig();
    }

    public ConfigurationSection getOrCreateSection(String path, Section key){
        ConfigurationSection section = this.config.isConfigurationSection(path)
                ? this.config.getConfigurationSection(path)
                : this.config.createSection(path);
        if (key != null)
            addSection(key, section);
        return section;
    }
}
