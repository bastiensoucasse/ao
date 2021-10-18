public class Cavalier extends SoldatAbstrait {
    private static final int FORCE_CAVALIER = 2;

    Cavalier(final int vie) {
        super(vie);
    }

    @Override
    public int force() {
        return FORCE_CAVALIER;
    }

    @Override
    public int frapper() {
        System.out.println(this + " frappe de " + FORCE_CAVALIER + ".");
        return FORCE_CAVALIER;
    }
}
