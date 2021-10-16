abstract class SoldatAbstrait implements Soldat {
    protected int vie;

    SoldatAbstrait(final int vie) {
        this.vie = vie;
    }

    @Override
    public boolean parer(final int force) {
        vie = (vie > force) ? vie - force : 0;
        return vie > 0;
    }
}
