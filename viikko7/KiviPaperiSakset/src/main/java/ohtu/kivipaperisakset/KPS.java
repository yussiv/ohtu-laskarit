package ohtu.kivipaperisakset;

public abstract class KPS {

    protected static boolean siirtoOnOK(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    public abstract void pelaa();

}
