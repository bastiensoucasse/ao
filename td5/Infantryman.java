public class Infantryman extends SoldierAbstract {
    private static final int INFANTRYMAN_STRENGTH = 2;

    Infantryman(final String name, final int vie) {
        super(name, vie);
    }

    Infantryman(final int vie) {
        this("Infantryman", vie);
    }

    @Override
    public int getStrength() {
        return INFANTRYMAN_STRENGTH;
    }

    @Override
    public int hit() {
        System.out.println(this + " hits by " + INFANTRYMAN_STRENGTH + ".");
        return INFANTRYMAN_STRENGTH;
    }
}
