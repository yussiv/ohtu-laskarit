package ohtu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Tapahtumankuuntelija implements ActionListener {

    private JButton nollaa;
    private JButton undo;
    private Sovelluslogiikka sovellus;
    private Map<JButton, Komento> komennot;
    private Stack<Komento> historia;

    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.nollaa = nollaa;
        this.undo = undo;
        this.historia = new Stack<>();
        this.sovellus = new Sovelluslogiikka();
        this.komennot = new HashMap<>();
        this.komennot.put(miinus, new Miinus(sovellus, syotekentta, tuloskentta));
        this.komennot.put(plus, new Plus(sovellus, syotekentta, tuloskentta));
        this.komennot.put(nollaa, new Nollaus(sovellus, syotekentta, tuloskentta));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int arvo = 0;

        Komento komento = komennot.get((JButton) ae.getSource());
        if (komento != null) {
            komento.suorita();
            historia.add(komento);
        } else {
            historia.pop().peru();
        }

        nollaa.setEnabled(sovellus.tulos() != 0);
        undo.setEnabled(!historia.isEmpty());
    }

}
