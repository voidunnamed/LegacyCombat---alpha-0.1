package fr.cozyhouse.legacyCombat;

import fr.cozyhouse.legacyCombat.enumerator.ContainerKey;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class GappleModule {

    private boolean visualEfect;

    public GappleModule(){
        createRecipe();
        visualEfect = true;
    }

    public ItemStack createCustomGapple(){
        ItemStack gapple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        ItemMeta gappleMeta = gapple.getItemMeta();
        if (gappleMeta == null)
            return gapple;
        PersistentDataContainer container = gappleMeta.getPersistentDataContainer();
        container.set(ContainerKey.GAPPLE.key, PersistentDataType.BOOLEAN, true);
        gapple.setItemMeta(gappleMeta);
        return gapple;
    }

    public void changeVisualEffect(){
        if (visualEfect)
            visualEfect = false;
        else
            visualEfect = true;
    }

    public boolean getVisualEffect(){
        return this.visualEfect;
    }

    public void createRecipe(){
        ShapedRecipe recipe = new ShapedRecipe(
                new NamespacedKey(LegacyCombat.plugin, "legacy_notch_apple"),
                createCustomGapple());
        recipe.shape("BBB", "BAB", "BBB");
        recipe.setIngredient('B', Material.GOLD_BLOCK);
        recipe.setIngredient('A', Material.APPLE);
        if (Bukkit.getBukkitVersion().contains("1.21.11"))
            Bukkit.addRecipe(recipe);
    }
}
