public class Main {
    public static void main(final String[] args) {
        // Create the participants
        final SoldierProxy knight = new SoldierProxy(new Knight(100));
        final SoldierProxy infantryman = new SoldierProxy(new Infantryman(100));

        // Equip Knight
        knight.addWeapon(Weapons.SHIELD);
        knight.addWeapon(Weapons.BOW);
        knight.addWeapon(Weapons.BOW);

        // Equip Infantryman
        infantryman.addWeapon(Weapons.SHIELD);
        infantryman.addWeapon(Weapons.SHIELD);
        infantryman.addWeapon(Weapons.SWORD);

        // Simulate the fight
        while (true) {
            if (!knight.wardOff(infantryman.hit()) || !infantryman.wardOff(knight.hit()))
                break;
        }
    }
}
