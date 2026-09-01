package fr.cozyhouse.legacyCombat.enumerator;

public enum VisualEffect {
    GAPPEL_EFFECT("gapple-effect", true);

    public final String name;
    public final boolean defaultValue;

    VisualEffect(String name, boolean defaultValue){
        this.name = name;
        this.defaultValue = defaultValue;
    }
}
