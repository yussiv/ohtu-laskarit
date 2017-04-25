
package ohtu;

import java.util.Stack;
import javax.swing.JTextField;


public class Nollaus implements Komento {
    private Sovelluslogiikka logiikka;
    private JTextField syote;
    private JTextField tuote;
    private Stack<String> historia;

    public Nollaus(Sovelluslogiikka logiikka, JTextField syote, JTextField tuote) {
        this.logiikka = logiikka;
        this.syote = syote;
        this.tuote = tuote;
        this.historia = new Stack<>();
    }

    @Override
    public void suorita() {
        historia.add(tuote.getText());
        logiikka.nollaa();
        tuote.setText("" + logiikka.tulos());
        syote.setText("");
    }

    @Override
    public void peru() {
        if(!historia.isEmpty()) {
            tuote.setText(historia.pop());
        }
    }
    
}
