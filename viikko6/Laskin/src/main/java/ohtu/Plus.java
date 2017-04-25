
package ohtu;

import javax.swing.JTextField;


public class Plus implements Komento {
    private Sovelluslogiikka logiikka;
    private JTextField syote;
    private JTextField tuote;

    public Plus(Sovelluslogiikka logiikka, JTextField syote, JTextField tuote) {
        this.logiikka = logiikka;
        this.syote = syote;
        this.tuote = tuote;
    }

    @Override
    public void suorita() {
        logiikka.plus(Integer.parseInt(syote.getText()));
        tuote.setText("" + logiikka.tulos());
        syote.setText("");
    }

    @Override
    public void peru() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
