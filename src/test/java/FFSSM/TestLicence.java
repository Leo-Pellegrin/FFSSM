package FFSSM;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLicence {
    Licence l, l2; 
    Plongeur pg;
    Club c;
    Moniteur m;

    @BeforeEach
    public void setUp(){
        m = new Moniteur("73839", "Pellegrin", "Leo", "14 rue de Castres", "0781794004", LocalDate.of(2002, 12, 4), 3, 40, GroupeSanguin.AMOINS);
        pg = new Plongeur("377", "Baptiste", "Lolilo", "ENFER", "06060606", LocalDate.of(2000, 1, 1), 5, GroupeSanguin.BMOINS);
        c = new Club(m, "AquaPlanning", "la mer", "0728819");
        l = new Licence(pg, "382330", LocalDate.of(2022, 8, 10), c);
    }

    @Test
    public void testCreation(){
        assertTrue(l instanceof Licence);
    }

    @Test
    public void testEstValide(){
        l2 = new Licence(pg, "9463", LocalDate.of(2010, 8, 10), c);
        assertFalse(l2.estValide(LocalDate.now()));

        assertTrue(l.estValide(LocalDate.now()));
    }
}
