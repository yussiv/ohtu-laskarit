package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        MatchBuilder match = new MatchBuilder();
        
//        Matcher m = new And( new HasAtLeast(10, "goals"),
//                             new HasAtLeast(10, "assists"),
//                             new PlaysIn("PHI")
//        );
        Matcher m = match.hasAtLeast(10, "goals")
                .hasAtLeast(10, "assists")
                .playsIn("PHI").build();
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("\n----\n");
        
//        m = new Or( new HasAtLeast(100, "points"),
//                    new And(new PlaysIn("BOS"), new HasAtLeast(24, "goals"))
//        );
        m = match.oneOf(
                match.hasAtLeast(100, "points").build(), 
                match.playsIn("BOS").hasAtLeast(24, "goals").build()
        ).build();
        
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("\n----\n");
        
        m = match.playsIn("WPG").build();
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("-------");
        
        m = match.playsIn("WPG").hasAtLeast(30, "assists").build();
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        System.out.println("**********");
        m = match.playsIn("WPG").hasFewerThan(30, "assists").build();
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("\n----\n");
        
        m = match.not(match.hasFewerThan(30, "assists").build()).playsIn("MTL").build();
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("********");
        
        m = match.playsIn("MTL").hasAtLeast(30, "assists").build();
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("********");
        
        m = match.oneOf(
                match.playsIn("MTL").hasAtLeast(30, "assists").hasFewerThan(27, "goals").build(),
                match.playsIn("MTL").playsIn("NYI").playsIn("MTL").build()
        ).build();
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
