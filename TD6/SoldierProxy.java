import java.util.HashSet;
import java.util.Set;

public class SoldierProxy implements Soldier {
    private Soldier soldier;

    private boolean hasShield = false;
    private final Set<Weapon> weapons = new HashSet<>();

    public SoldierProxy(final Soldier soldier) {
        this.soldier = soldier;
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
    public boolean addShield() {
        if (hasShield) {
            System.err.println("Could not equip " + this + " with second SHIELD.");
            return false;
        }

        soldier = new SoldierWithShield(soldier);

        hasShield = true;
        System.out.println(this + " is now equipped with SHIELD.");
        return true;
    }

    @Override
    public boolean addWeapon(final Weapon weapon) {
        if (weapons.contains(weapon)) {
            System.err.println("Could not equip " + this + " with second " + weapon + ".");
            return false;
        }

        soldier = new SoldierWithWeapon(soldier, weapon);

        weapons.add(weapon);
        System.out.println(this + " is now equipped with " + weapon + ".");
        return true;
    }

    @Override
    public void accept(final SoldierVisitor soldierVisitor) {
        soldier.accept(soldierVisitor);
    }

    @Override
    public String toString() {
        return soldier.toString();
    }
}
