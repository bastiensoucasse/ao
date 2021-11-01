public class Infantryman extends SoldierAbstract {
    private static final int INFANTRYMAN_STRENGTH = 2;

    Infantryman(final String name, final int life) {
        super(name, life);
    }

    Infantryman(final int life) {
        this("Infantryman", life);
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

    @Override
    public void accept(final SoldierVisitor soldierVisitor) {
        soldierVisitor.visit(this);
    }
}
