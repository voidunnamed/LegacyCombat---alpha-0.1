package fr.cozyhouse.legacyCombat.enumerator;

public enum CombatParam {
    REACH("reach", 3.0D),
    UNDER_PEARL_COOLDOWN("under-pearl-cooldown", 0);

    public final String name;
    public final Object defaultValue;

    CombatParam(String name, Object defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }
}
