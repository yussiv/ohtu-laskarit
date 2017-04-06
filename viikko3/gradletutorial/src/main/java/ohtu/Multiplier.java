package ohtu;

public class Multiplier {

    private int value;

    public Multiplier(int value) {
        this.value = value;
    }

    public int multipliedBy(int other) {
        return value * other;
    }
    
    public void pointlessFunction() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.println("x");
            }
        }
    }
}
