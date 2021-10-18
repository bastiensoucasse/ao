public class SoldatAvecBouclier extends SoldatDécoré {
    private static final int SHIELD_STRENGTH = 3;

    SoldatAvecBouclier(final int vie, final Soldat soldat) {
        super(vie, soldat);
    }

    @Override
    public boolean parer(final int force) {
        System.out.println(soldat + " encaisse " + force / SHIELD_STRENGTH + ".");
        vie = (vie > force / SHIELD_STRENGTH) ? vie - force / SHIELD_STRENGTH : 0;
        if (vie > 0)
            System.out.println(soldat + " vie : " + vie);
        else
            System.out.println(soldat + " mort.");
        return vie > 0;
    }
}
