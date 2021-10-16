public class SoldatAvecEpée extends SoldatDécoré {
    private static final int SWORD_STRENGTH = 3;

    SoldatAvecEpée(final int vie, final Soldat soldat) {
        super(vie, soldat);
    }

    @Override
    public int frapper() {
        return SWORD_STRENGTH * force();
    }
}
