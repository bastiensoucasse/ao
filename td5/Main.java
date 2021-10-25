public class Main {
    public static void main(final String[] args) {
        final Soldat ce = new ProxySoldat(new Cavalier(100)).addSword();
        final Soldat fb = new ProxySoldat(new Fantassin(50)).addShield();

        while (true)
        {
            if (!fb.parer(ce.frapper()) || !ce.parer(fb.frapper()))
                break;
        }
    }
}
