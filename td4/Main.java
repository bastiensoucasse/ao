public class Main {
    public static void main(final String[] args) {
        // Initialize the fight
        final Soldier knight = new SoldierWithShield(new Knight(100));
        final Soldier infantryman = new SoldierWithSword(new Infantryman(100));

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
