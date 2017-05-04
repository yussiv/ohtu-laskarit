package ohtu.kivipaperisakset;

public class KPS {
    private final Pelaaja ekaPelaaja;
    private final Pelaaja tokaPelaaja;
    private final Tuomari tuomari;

    public KPS(Pelaaja ekaPelaaja, Pelaaja tokaPelaaja) {
        this.ekaPelaaja = ekaPelaaja;
        this.tokaPelaaja = tokaPelaaja;
        this.tuomari = new Tuomari();
    }

    protected static boolean siirtoOnOK(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    public void pelaa() {
        String ekanSiirto, tokanSiirto;
        
        while (true) {
            System.out.println("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = ekaPelaaja.annaSiirto();
            
            if(tokaPelaaja.getClass() == Ihminen.class) {
                System.out.println("Toisen pelaajan siirto: ");
                tokanSiirto = tokaPelaaja.annaSiirto();
            } else {
                tokanSiirto = tokaPelaaja.annaSiirto();
                System.out.println("Tietokone valitsi: " + tokanSiirto);
            }
            
            if(!siirtoOnOK(ekanSiirto) || !siirtoOnOK(tokanSiirto))
                break;
            
            tokaPelaaja.asetaSiirto(ekanSiirto);
            
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari.tulostaPelitilanne() + "\n");
        }
        
        System.out.println("\nKiitos!");
        System.out.println(tuomari.tulostaPelitilanne());
    }
}
