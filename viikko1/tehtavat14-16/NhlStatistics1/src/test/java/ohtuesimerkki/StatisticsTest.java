
package ohtuesimerkki;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    } 
    
    @Test
    public void searchReturnsPlayer() {
        Player player = stats.search("Kurri");
        String name = player.getName();
        assertEquals("Kurri", name);
    }
    
    @Test
    public void searchReturnsNull() {
        Player player = stats.search("Muumi");
        assertNull(player);
    }
    
    @Test
    public void teamReturnsPlayersOfTeam() {
        List<Player> playersOfTeam = stats.team("PIT");
        Player player = playersOfTeam.get(0);
        String name = player.getName();
        assertEquals("Lemieux", name);
    }
    
    @Test
    public void teamReturnsEmptyList() {
        List<Player> playersOfTeam = stats.team("LOL");
        assertTrue(playersOfTeam.isEmpty());
    }
    
    @Test
    public void topScoresReturnsTopScores() {
        List<Player> topScores = stats.topScorers(1);
        Player player = topScores.get(0);
        String name = player.getName();
        assertEquals("Gretzky", name);
    }
    
}
