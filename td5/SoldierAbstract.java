public abstract class SoldierAbstract implements Soldier {
    private String name;
    private int life;

    SoldierAbstract(final String name, final int life) {
        this.name = name;
        this.life = life;
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void setLife(final int life) {
        this.life = life;
    }

    @Override
    public boolean wardOff(final int strength) {
        System.out.print(this + " takes " + strength);
        life = (life > strength) ? life - strength : 0;
        if (life > 0)
            System.out.println(" and now has " + life + " left.");
        else
            System.out.println(" and is now dead.");
        return life > 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
