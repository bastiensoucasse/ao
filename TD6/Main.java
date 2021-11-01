public class Main {
    public static final int SOLDIERS_COUNT = 5;

    public static void main(final String[] args) {
        // Initialize the fight
        System.out.println("--- Preparation ---");
        final SoldierComposite soldiers = new SoldierComposite();
        final SoldierComposite army1 = new SoldierComposite();
        final SoldierComposite knights1 = new SoldierComposite();
        final SoldierComposite infantrymen1 = new SoldierComposite();
        final SoldierComposite army2 = new SoldierComposite();
        final SoldierComposite knights2 = new SoldierComposite();
        final SoldierComposite infantrymen2 = new SoldierComposite();

        // Create and equip the army 1
        for (int i = 1; i <= SOLDIERS_COUNT / 2; i++)
            knights1.add(new SoldierProxy(new Knight("Knight #1." + i, 100)));
        for (int i = 1; i <= SOLDIERS_COUNT; i++)
            infantrymen1.add(new SoldierProxy(new Infantryman("Infantryman #1." + i, 100)));
        knights1.addShield();
        knights1.addWeapon(Weapon.BOW);
        infantrymen1.addShield();
        infantrymen1.addWeapon(Weapon.SWORD);
        army1.add(knights1);
        army1.add(infantrymen1);

        // Create and equip the army 2
        for (int i = 1; i <= SOLDIERS_COUNT; i++)
            knights2.add(new SoldierProxy(new Knight("Knight #2." + i, 100)));
        for (int i = 1; i <= SOLDIERS_COUNT / 2; i++)
            infantrymen2.add(new SoldierProxy(new Infantryman("Infantryman #2." + i, 100)));
        knights2.addShield();
        knights2.addWeapon(Weapon.BOW);
        infantrymen2.addShield();
        infantrymen2.addWeapon(Weapon.SWORD);
        army2.add(knights2);
        army2.add(infantrymen2);

        // Regroup the soldiers
        soldiers.add(army1);
        soldiers.add(army2);

        // Visit the soldiers
        SoldierVisitor soldierPrintVisitor = new SoldierPrintVisitor();
        SoldierVisitor soldierCountVisitor = new SoldierCountVisitor();
        soldierPrintVisitor.visitSoldier(soldiers);
        soldierCountVisitor.visitSoldier(soldiers);

        // Simulate the fight
        int round = 0;
        while (true) {
            round++;
            System.out.println("--- Round: #" + round + " ---");
            System.out.print("Army 1: ");
            soldierCountVisitor.visitSoldier(army1);
            System.out.print("Army 2: ");
            soldierCountVisitor.visitSoldier(army2);
            if (!army2.wardOff(army1.hit()) || !army1.wardOff(army2.hit()))
                break;
        }
    }
}
