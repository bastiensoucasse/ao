public abstract class SoldierDecorator implements Soldier {
    private final Soldier soldier;

    SoldierDecorator(final Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public int getLife() {
        return soldier.getLife();
    }

    @Override
    public void setLife(final int life) {
        soldier.setLife(life);
    }

    @Override
    public int getStrength() {
        return soldier.getStrength();
    }

    @Override
    public int hit() {
        return soldier.hit();
    }

    @Override
    public boolean wardOff(final int strength) {
        return soldier.wardOff(strength);
    }

    @Override
    public String toString() {
        return soldier.toString();
    }

    public Soldier getSoldier() {
        return soldier;
    }
}
