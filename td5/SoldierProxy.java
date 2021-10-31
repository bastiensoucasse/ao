import java.util.HashSet;
import java.util.Set;

public class SoldierProxy implements Soldier {
    private Soldier soldier;

    private Set<Weapons> weapons;

    public SoldierProxy(final Soldier soldier) {
        this.soldier = soldier;
        this.weapons = new HashSet<>();
        System.out.println(soldier + " has now joined the fight.");
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

    public boolean addWeapon(final Weapons weapon) {
        if (weapons.contains(weapon)) {
            System.err.println("Could not equip " + this + " with second " + weapon + ".");
            return false;
        }

        switch (weapon) {
        case SHIELD:
            soldier = new SoldierWithShield(soldier);
            break;
        case SWORD:
            soldier = new SoldierWithSword(soldier);
            break;
        case BOW:
            soldier = new SoldierWithBow(soldier);
            break;
        default:
            System.err.println("Unkown weapon: " + weapon + ".");
            return false;
        }

        weapons.add(weapon);
        System.out.println(this + " is now equipped with " + weapon + ".");
        return true;
    }
}
