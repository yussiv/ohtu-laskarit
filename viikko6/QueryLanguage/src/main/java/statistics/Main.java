package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        Matcher m = new And( new HasAtLeast(10, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("\n----\n");
        
        m = new Or( new HasAtLeast(100, "points"),
                    new And(new PlaysIn("BOS"), new HasAtLeast(24, "goals"))
        );
        
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("\n----\n");
        
        m = new PlaysIn("WPG");
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("-------");
        
        m = new And(new PlaysIn("WPG"), new HasAtLeast(30, "assists"));
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        System.out.println("**********");
        m = new And(new PlaysIn("WPG"), new HasFewerThan(30, "assists"));
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("\n----\n");
        
        m = new And(new PlaysIn("MTL"), new Not(new HasFewerThan(30, "assists")));
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("********");
        
        m = new And(new PlaysIn("MTL"), new HasAtLeast(30, "assists"));
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("********");
        
        m = new Or(
                new And(new PlaysIn("MTL"), new HasAtLeast(30, "assists"), new HasFewerThan(27, "goals")),
                new And(new PlaysIn("MTL"), new PlaysIn("NYI"), new PlaysIn("MTL"))
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
