public class SoldierPrintVisitor implements SoldierVisitor {
    @Override
    public void visit(final Soldier soldier) {
        System.out.println(soldier + " is ready.");
    }

    public void visitSoldier(final Soldier soldier) {
        soldier.accept(this);
    }
}
