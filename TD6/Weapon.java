public enum Weapon {
    SWORD(5), BOW(3);

    private final int strength;

    private Weapon(final int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }
}
