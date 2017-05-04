package ohtu.kivipaperisakset;

public class TekoalyPerus implements Tekoaly {

    private int siirto;

    public TekoalyPerus() {
        siirto = 0;
    }

    public String annaSiirto() {
        siirto++;
        siirto = siirto % 3;
        String[] vaihtoehdot = new String[]{"k", "p", "s"};

        return vaihtoehdot[siirto];
    }

    public void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään 
    }
}
