/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;


public class Ihminen implements Pelaaja {

    private final Scanner scanner;

    public Ihminen(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String annaSiirto() {
        return scanner.nextLine();
    }

    @Override
    public void asetaSiirto(String siirto) {
        // nada
    }
    
}
