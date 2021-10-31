public class SoldierWithBow extends SoldierDecorator {
    private static final int BOW_STRENGTH = 3;

    SoldierWithBow(final Soldier soldat) {
        super(soldat);
    }

    @Override
    public int hit() {
        System.out.println(getSoldier() + " hits by " + BOW_STRENGTH * getStrength() + ".");
        return BOW_STRENGTH * getStrength();
    }
}
