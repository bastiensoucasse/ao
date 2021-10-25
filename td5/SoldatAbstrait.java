abstract class SoldatAbstrait implements Soldat {
    protected int vie;

    SoldatAbstrait(final int vie) {
        this.vie = vie;
    }

    @Override
    public boolean parer(final int force) {
        System.out.println(this + " encaisse " + force + ".");
        vie = (vie > force) ? vie - force : 0;
        if (vie > 0)
            System.out.println(this + " vie : " + vie);
        else
            System.out.println(this + " mort.");
        return vie > 0;
    }
}
