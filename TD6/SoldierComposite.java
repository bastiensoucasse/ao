import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SoldierComposite implements Soldier {
    private final List<Soldier> soldiers = new ArrayList<>();

    @Override
    public int getLife() {
        int life = 0;
        for (final Soldier soldier : soldiers)
            life += soldier.getStrength();
        return life;
    }

    @Override
    public void setLife(final int life) {
        for (final Soldier soldier : soldiers)
            soldier.setLife(life);
    }

    @Override
    public int getStrength() {
        int strength = 0;
        for (final Soldier soldier : soldiers)
            strength += soldier.getStrength();
        return strength;
    }

    @Override
    public int hit() {
        int strength = 0;
        for (final Soldier soldier : soldiers)
            strength += soldier.hit();
        return strength;
    }

    @Override
    public boolean wardOff(final int strength) {
        boolean wardedOff = false;
        Iterator<Soldier> iterator = soldiers.iterator();
        while (iterator.hasNext()) {
            final Soldier soldier = (Soldier) iterator.next();
            final boolean soldierWardedOff = soldier.wardOff(strength / soldiers.size());
            if (soldierWardedOff)
                wardedOff = true;
            else
                iterator.remove();
        }
        return wardedOff;
    }

    @Override
    public boolean addShield() {
        boolean shieldAdded = true;
        for (final Soldier soldier : soldiers)
            if (!soldier.addShield())
                shieldAdded = false;
        return shieldAdded;
    }

    @Override
    public boolean addWeapon(final Weapon weapon) {
        boolean weaponAdded = true;
        for (final Soldier soldier : soldiers)
            if (!soldier.addWeapon(weapon))
                weaponAdded = false;
        return weaponAdded;
    }

    @Override
    public void accept(final SoldierVisitor soldierVisitor) {
        for (Soldier soldier : soldiers)
            soldier.accept(soldierVisitor);
    }

    public void add(final Soldier soldier) {
        soldiers.add(soldier);
    }

    public void remove(final Soldier soldier) {
        soldiers.remove(soldier);
    }
}
