public class Main {
    public static void main(final String[] args) {
        // Initialize the fight
        System.out.println("--- Preparation ---");
        final SoldierProxy knight = new SoldierProxy(new Knight(100));
        final SoldierProxy infantryman = new SoldierProxy(new Infantryman(100));

        // Equip Knight
        knight.addShield();
        knight.addWeapon(Weapon.BOW);

        // Equip Infantryman
        infantryman.addShield();
        infantryman.addWeapon(Weapon.SWORD);

        // Simulate the fight
        int round = 0;
        while (true) {
            round++;
            System.out.println("--- Round: #" + round + " ---");
            if (!knight.wardOff(infantryman.hit()) || !infantryman.wardOff(knight.hit()))
                break;
        }
    }
}
