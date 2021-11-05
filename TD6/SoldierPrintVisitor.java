public class SoldierPrintVisitor implements SoldierVisitor {
    @Override
    public void visit(final Soldier soldier) {
        System.out.println(soldier + " is ready.");
    }

    @Override
    public void visitSoldier(final Soldier soldier) {
        soldier.accept(this);
    }
}
