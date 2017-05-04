package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KPS {
    
    protected Scanner scanner;
    private final Tekoaly tekoaly;
    private final Tuomari tuomari;

    public KPSTekoaly(Scanner scanner, Tekoaly tekoaly) {
        this.scanner = scanner;
        this.tekoaly = tekoaly;
        this.tuomari = new Tuomari();
    }

    public void pelaa() {
        String ekanSiirto, tokanSiirto;
        
        while (true) {
            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();
            
            tokanSiirto = tekoaly.annaSiirto();
            System.out.println("Tietokone valitsi: " + tokanSiirto);
            
            if(!siirtoOnOK(ekanSiirto) || !siirtoOnOK(tokanSiirto))
                break;
            
            tekoaly.asetaSiirto(ekanSiirto);
            
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari.tulostaPelitilanne() + "\n");
        }
        
        System.out.println("\nKiitos!");
        System.out.println(tuomari.tulostaPelitilanne());
    }
}