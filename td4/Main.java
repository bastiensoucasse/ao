public class Main {
    public static void main(final String[] args) {
        final SoldierDecorator knight = new SoldierWithSword(new Knight(100));
        final SoldierDecorator fantassin = new SoldierWithShield(new Fantassin(100));

        while (true) {
            if (!knight.wardOff(fantassin.hit()) || !fantassin.wardOff(knight.hit()))
                break;
        }
    }
}
