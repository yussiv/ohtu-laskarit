package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] luvut;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IllegalArgumentException("Kapasiteetti ei voi olla negatiivinen");
        }
        if (kasvatuskoko < 1) {
            throw new IllegalArgumentException("Kasvatuskoko tulee olla positiivinen kokonaisluku");
        }
        this.luvut = new int[kapasiteetti];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            kasvataEhkaTaulukkoa();
            luvut[alkioidenLkm] = luku;
            alkioidenLkm++;
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        return etsi(luku) != -1;
    }

    public boolean poista(int luku) {
        int kohta = etsi(luku);
        if (kohta != -1) {
            alkioidenLkm--;
            for (int j = kohta; j < alkioidenLkm; j++) {
                luvut[j] = luvut[j + 1];
            }
            return true;
        }

        return false;
    }

    private int etsi(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                return i;
            }
        }
        return -1;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < alkioidenLkm; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        switch (alkioidenLkm) {
            case 0:
                return "{}";
            default:
                String tuotos = "{";
                for (int i = 0; i < alkioidenLkm - 1; i++) {
                    tuotos += luvut[i];
                    tuotos += ", ";
                }
                tuotos += luvut[alkioidenLkm - 1];
                tuotos += "}";
                return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] uusiTaulukko = new int[alkioidenLkm];
        kopioiTaulukko(luvut, uusiTaulukko);
        return uusiTaulukko;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = a.kloonaa();
        for (int i = 0; i < b.alkioidenLkm; i++) {
            yhdiste.lisaa(b.luvut[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        for (int j = 0; j < b.alkioidenLkm; j++) {
            int luku = b.luvut[j];
            if (a.kuuluu(luku)) {
                leikkaus.lisaa(luku);
            }
        }
        return leikkaus;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotus = a.kloonaa();
        for (int i = 0; i < b.alkioidenLkm; i++) {
            erotus.poista(i);
        }
        return erotus;
    }

    private IntJoukko kloonaa() {
        int[] uudetLuvut = new int[luvut.length];
        kopioiTaulukko(luvut, uudetLuvut);
        IntJoukko uusiJoukko = new IntJoukko();
        uusiJoukko.kasvatuskoko = kasvatuskoko;
        uusiJoukko.luvut = uudetLuvut;
        uusiJoukko.alkioidenLkm = alkioidenLkm;

        return uusiJoukko;
    }

    /**
     * Tuplaa lukutaulukon koon, jos taulukko on täynnä.
     */
    private void kasvataEhkaTaulukkoa() {
        if(alkioidenLkm == luvut.length) {
            int[] isompiTaulukko = new int[luvut.length * 2 + 1];
            kopioiTaulukko(luvut, isompiTaulukko);
            luvut = isompiTaulukko;
        }
    }

}
