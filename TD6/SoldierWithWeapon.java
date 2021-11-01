public class SoldierWithWeapon extends SoldierDecorator {
    private static final int MAX_WEAR_LEVEL = 10;

    private final Weapon weapon;
    private int wearLevel = 0;

    SoldierWithWeapon(final Soldier soldier, final Weapon weapon) {
        super(soldier);
        this.weapon = weapon;
    }

    @Override
    public int hit() {
        if (wearLevel > MAX_WEAR_LEVEL)
            return super.hit();

        wearLevel++;
        System.out.println(getSoldier() + " hits by " + weapon.getStrength() * getStrength() + ".");
        if (wearLevel > MAX_WEAR_LEVEL)
            System.out.println(getSoldier() + " is now without " + weapon + ".");
        return weapon.getStrength() * getStrength();
    }
}
