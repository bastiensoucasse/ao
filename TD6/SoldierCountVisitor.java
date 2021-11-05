public class SoldierCountVisitor implements SoldierVisitor {
    private int knights;
    private int infantrymen;

    @Override
    public void visit(final Soldier soldier) {
        if (soldier instanceof Knight)
            knights++;
        if (soldier instanceof Infantryman)
            infantrymen++;
    }

    @Override
    public void visitSoldier(final Soldier soldier) {
        knights = 0;
        infantrymen = 0;
        soldier.accept(this);
        System.out.println("All " + knights + " knights and " + infantrymen + " infantrymen are ready for the fight.");
    }
}
