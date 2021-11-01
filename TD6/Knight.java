public class Knight extends SoldierAbstract {
    private static final int KNIGHT_STRENGTH = 3;

    Knight(final String name, final int life) {
        super(name, life);
    }

    Knight(final int life) {
        this("Knight", life);
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

    @Override
    public void accept(final SoldierVisitor soldierVisitor) {
        soldierVisitor.visit(this);
    }
}
