public class Main {
    public static void main(final String[] args) {
        final Soldat c = new Cavalier(100);
        final Soldat f = new Fantassin(50);
        int ncoups = 0;
        boolean vc = true;
        boolean vf = true;

        for (; (vf = f.parer(c.force())) && (vc = c.parer(f.force())); ncoups++)
            ;

        System.out.println("Mort du " + (vf ? "cavalier" : "fantassin") + " en " + ncoups + " coups");
    }
}
