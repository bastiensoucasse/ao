public class Knight extends SoldierAbstract {
    private static final int KNIGHT_STRENGTH = 3;

    Knight(final String name,final int vie) {
        super(name, vie);
    }

    Knight(final int vie) {
        this("Knight", vie);
    }

    @Override
    public int getStrength() {
        return KNIGHT_STRENGTH;
    }

    @Override
    public int hit() {
        System.out.println(this + " hits by " + KNIGHT_STRENGTH + ".");
        return KNIGHT_STRENGTH;
    }
}
