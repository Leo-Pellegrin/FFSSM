package FFSSM;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMoniteur {
    Embauche e1, e2;
    Club c;
    Moniteur m;

    @BeforeEach
    public void setUp(){
        m = new Moniteur("73839", "Pellegrin", "Leo", "14 rue de Castres", "0781794004", LocalDate.of(2002, 12, 4), 3, 40, GroupeSanguin.AMOINS);
        c = new Club(m, "AquaPlanning", "la mer", "0728819");
        e1 = new Embauche(LocalDate.of(2017, 3, 26), m, c);

        m.nouvelleEmbauche(c, LocalDate.of(2017, 3, 26));
        m.nouvelleEmbauche(c, LocalDate.of(2022, 1, 1));
    }

    @Test
    public void testCreation(){
        assertTrue(e1 instanceof Embauche);
    }

    @Test // Test employeur() et nouvelleEmbauche()
    public void testEmployeur(){
        assertEquals(c, m.employeur().get());
    }

    @Test // TerminerEmbauche
    public void testTerminerEmbauche(){
        m.terminerEmbauche(LocalDate.of(2022, 12, 4));
        List<Embauche> l = m.emplois();
        assertTrue(l.get(l.size() - 1).estTerminee());
    }

    @Test
    public void testEmplois(){
        assertEquals(2, m.emplois().size());
    }
}
