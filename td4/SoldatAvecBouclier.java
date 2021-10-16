public class SoldatAvecBouclier extends SoldatDécoré {
    private static final int SHIELD_STRENGTH = 3;

    SoldatAvecBouclier(final int vie, final Soldat soldat) {
        super(vie, soldat);
    }

    @Override
    public boolean parer(final int force) {
        vie = (vie > force / SHIELD_STRENGTH) ? vie - force / SHIELD_STRENGTH : 0;
        return vie > 0;
    }
}
