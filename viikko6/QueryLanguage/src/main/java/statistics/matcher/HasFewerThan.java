
package statistics.matcher;

import statistics.Player;


public class HasFewerThan implements Matcher {
    private final HasAtLeast negation;
    private Matcher matcher;

    public HasFewerThan(Matcher matcher, int value, String category) {
        this.matcher = matcher;
        negation = new HasAtLeast(new Any(), value, category);
    }

    @Override
    public boolean matches(Player p) {
        return !negation.matches(p) && matcher.matches(p);
    }
    
}
