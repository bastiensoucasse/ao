public class SoldierCountVisitor implements SoldierVisitor {
    private int count;

    @Override
    public void visit(final Soldier soldier) {
        count++;
    }

    public void visitSoldier(final Soldier soldier) {
        count = 0;
        soldier.accept(this);
        System.out.println("All " + count + " soldiers are ready for the fight.");
    }
}
