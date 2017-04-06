/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Heptaurus
 */
public class StatisticsTest {

    class ReaderStub implements Reader {

        @Override
        public List<Player> getPlayers() {
            List<Player> players = new ArrayList<>();
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));

            return players;
        }

    }
    
    private Statistics stats;

    public StatisticsTest() {
    }

    @Before
    public void setUp() {
        stats = new Statistics(new ReaderStub());
    }

    @Test
    public void canFindPlayer() {
        assertNotNull(stats.search("Semenko"));
        assertNotNull(stats.search("Lemieux"));
        assertNotNull(stats.search("Kurri"));
    }

    @Test
    public void returnsNullForNonExistentPlayer() {
        assertNull(stats.search("Luukkainen"));
    }
    
    @Test
    public void findsByTeam() {
        List<Player> team = stats.team("PIT");
        assertEquals(1, team.size());
        assertEquals("Lemieux", team.get(0).getName());
        
        team = stats.team("Matti");
        assertEquals(0, team.size());
    }

    @Test
    public void findsTopScorers() {
        List<Player> team = stats.topScorers(2);
        assertEquals(2, team.size());
        assertEquals("Lemieux", team.get(0).getName());
        assertEquals("Kurri", team.get(1).getName());
    }
}
