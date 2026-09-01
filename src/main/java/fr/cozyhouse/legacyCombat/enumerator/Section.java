package fr.cozyhouse.legacyCombat.enumerator;

public enum Section {
    GENERAL("General"), COMBATPARAM("combat-param"), VISUAL_EFFECT("visual-effect");

    public final String name;

    Section(String name) {
        this.name = name;
    }
}
