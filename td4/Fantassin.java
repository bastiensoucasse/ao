public class Fantassin extends SoldatAbstrait {
    private static final int FORCE_FANTASSIN = 1;

    Fantassin(final int vie) {
        super(vie);
    }

    @Override
    public int force() {
        return FORCE_FANTASSIN;
    }

    @Override
    public int frapper() {
        System.out.println(this + " frappe de " + FORCE_FANTASSIN + ".");
        return FORCE_FANTASSIN;
    }
}
