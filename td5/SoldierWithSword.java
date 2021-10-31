public class SoldierWithSword extends SoldierDecorator {
    private static final int SWORD_STRENGTH = 5;

    SoldierWithSword(final Soldier soldat) {
        super(soldat);
    }

    @Override
    public int hit() {
        System.out.println(getSoldier() + " hits by " + SWORD_STRENGTH * getStrength() + ".");
        return SWORD_STRENGTH * getStrength();
    }
}
