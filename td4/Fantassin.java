public class Fantassin extends SoldierAbstract {
    private static final int FANTASSIN_STRENGTH = 1;

    Fantassin(final int vie) {
        super(vie);
    }

    @Override
    public int strength() {
        return FANTASSIN_STRENGTH;
    }

    @Override
    public int hit() {
        System.out.println(this + " frappe de " + FANTASSIN_STRENGTH + ".");
        return FANTASSIN_STRENGTH;
    }
}
