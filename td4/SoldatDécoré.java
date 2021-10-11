public abstract class SoldatDécoré extends SoldatAbstrait {
    private final Soldat soldat;

    SoldatDécoré(final int vie, final Soldat soldat) {
        super(vie);
        this.soldat = soldat;
    }

    @Override
    public int force() {
        return soldat.force();
    }

    @Override
    public int frapper() {
        return soldat.frapper();
    }

    @Override
    public boolean parer(final int force) {
        return soldat.parer(force);
    }
}
