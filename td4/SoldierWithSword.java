public class SoldierWithSword extends SoldierDecorator {
    private static final int STRENGTH = 5;

    SoldierWithSword(final Soldier soldier) {
        super(soldier);
    }

    @Override
    public int hit() {
        System.out.println(getSoldier() + " hits by " + STRENGTH * getStrength() + ".");
        return STRENGTH * getStrength();
    }
}
