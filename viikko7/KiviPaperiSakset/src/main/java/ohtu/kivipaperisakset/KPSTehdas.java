package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTehdas {

    public static KPS luoPeli(String valinta, Scanner lukija) {
        switch (valinta) {
            case "a":
                return new KPSPelaajaVsPelaaja(lukija);
            case "b":
                return new KPSTekoaly(lukija, new TekoalyPerus());
            case "c":
                return new KPSTekoaly(lukija, new TekoalyParannettu(20));
            default:
                return null;
        }
    }
    
    public static String haePeliVaihtoehdot() {
        return " (a) ihmistä vastaan"
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan";
    }
}
