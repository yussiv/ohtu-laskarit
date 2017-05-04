package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTehdas {

    public static KPS luoPeli(String valinta, Scanner lukija) {
        Ihminen ekaPelaaja = new Ihminen(lukija);
        switch (valinta) {
            case "a":
                return new KPS(ekaPelaaja, new Ihminen(lukija));
            case "b":
                return new KPS(ekaPelaaja, new TekoalyPerus());
            case "c":
                return new KPS(ekaPelaaja, new TekoalyParannettu(20));
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
