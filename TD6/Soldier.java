public interface Soldier {
    public int getLife();

    public void setLife(int life);

    public int getStrength();

    public int hit();

    public boolean wardOff(int strength);

    public boolean addShield();

    public boolean addWeapon(Weapon weapon);

    public void accept(SoldierVisitor soldierVisitor);
}
