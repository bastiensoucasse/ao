public class SoldierWithShield extends SoldierDecorator {
    private static final int DURABILITY = 3;

    SoldierWithShield(final Soldier soldier) {
        super(soldier);
    }

    @Override
    public boolean wardOff(final int strength) {
        final int takes = strength > DURABILITY ? strength - DURABILITY : 0;
        System.out.print(getSoldier() + " takes " + takes);
        int life = getLife();
        setLife(getLife() > takes ? life - takes : 0);
        life = getLife();
        if (life > 0)
            System.out.println(" and now has " + life + " left.");
        else
            System.out.println(" and is now dead.");
        return life > 0;
    }
}
