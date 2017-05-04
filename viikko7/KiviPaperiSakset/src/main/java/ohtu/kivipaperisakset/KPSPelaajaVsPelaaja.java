package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPS {

    private final Scanner scanner;

    public KPSPelaajaVsPelaaja(Scanner scanner) {
        this.scanner = scanner;
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = scanner.nextLine();

        while (siirtoOnOK(ekanSiirto) && siirtoOnOK(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();

            System.out.print("Toisen pelaajan siirto: ");
            tokanSiirto = scanner.nextLine();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
}
