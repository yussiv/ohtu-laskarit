package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            tulostaOhje();

            String vastaus = scanner.nextLine();
            KPS peli = KPSTehdas.luoPeli(vastaus, scanner);
            if (peli == null) {
                break;
            }
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            peli.pelaa();
        }
    }

    private static void tulostaOhje() {
        System.out.println("\nValitse pelataanko"
                + "\n" + KPSTehdas.haePeliVaihtoehdot()
                + "\nmuilla valinnoilla lopetataan");
    }
}
