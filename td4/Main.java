public class Main {
    public static void main(final String[] args) {
        final Soldat c = new Cavalier(100);
        final SoldatDécoré ce = new SoldatAvecEpée(0, c);
        final Soldat f = new Fantassin(50);
        final SoldatDécoré fb = new SoldatAvecBouclier(0, f);

        while (true)
        {
            if (!fb.parer(ce.frapper()) || !ce.parer(fb.frapper()))
                break;
        }
    }
}
