public class SoldatAvecBouclier extends SoldatDécoré {
    SoldatAvecBouclier(final int vie, final Soldat soldat) {
        super(vie, soldat);
    }

    @Override
    public boolean parer(final int force) {
        // TODO
        return false;
    }
}
