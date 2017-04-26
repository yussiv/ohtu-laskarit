
package statistics.matcher;

import statistics.Player;


public class Any implements Matcher {

    @Override
    public boolean matches(Player p) {
        return true;
    }
    
}
