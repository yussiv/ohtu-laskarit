
package statistics.matcher;

import statistics.Player;


public class HasFewerThan implements Matcher {
    private final HasAtLeast negation;

    public HasFewerThan(int value, String category) {
        negation = new HasAtLeast(value, category);
    }

    @Override
    public boolean matches(Player p) {
        return !negation.matches(p);
    }
    
}
