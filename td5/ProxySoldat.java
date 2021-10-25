public class ProxySoldat implements Soldat {

    private Soldat soldat;

    public ProxySoldat(int vie, Soldat soldat) {
        this.soldat = soldat;
    }

    public int force() {
        return soldat.force();
    }

    public int frapper() {
        return soldat.frapper();
    }

    public boolean parer(final int force) {
        return soldat.parer(force);
    }

    public Soldat addShield() {
        return new SoldatAvecBouclier(, soldat);
    }

    public Soldat addSword() {
        return new SoldatAvecEpée(0, soldat);
    }
}
