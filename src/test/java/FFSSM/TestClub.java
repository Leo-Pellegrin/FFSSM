package FFSSM;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestClub {
    Moniteur m, pre;
    Club c;
    Plongeur p;
    Plongee pe;

    @BeforeEach
    public void setUp(){
        m = new Moniteur("73839", "Pellegrin", "Leo", "14 rue de Castres", "0781794004", LocalDate.of(2002, 12, 4), 3, 40, GroupeSanguin.AMOINS);
        c = new Club(m, "AquaPlanning", "la mer", "0728819");
    
        p = new Plongeur("377", "Baptiste", "Lolilo", "ENFER", "06060606", LocalDate.of(2000, 1, 1), 5, GroupeSanguin.BMOINS);
        pe = new Plongee(new Site("Nice", "Mer"), m, LocalDate.of(2022, 12, 13), 40, 1, c);
    
        pre = new Moniteur("3IBF3f", "Lopez", "Damien", "14 rue de Castres", "0781794004", LocalDate.of(2002, 12, 4), 3, 40, GroupeSanguin.AMOINS);

    }

    @Test
    public void testCreation(){
        assertTrue(c instanceof Club);
    }


    //organisePlongee et plongeesNonConformes
    @Test
    public void testplongeesNonConformes(){
        p.ajouterLicence("34994", LocalDate.of(2017, 8, 2), c);
        pe.ajouteParticipant(p);
        c.organisePlongee(pe);

        int i = c.plongeesNonConformes().size();
        assertEquals(1, i);
        assertTrue(c.plongeesNonConformes().contains(pe));
    }

    @Test
    public void testDirecteur(){
        c.setPresident(pre);
        assertEquals(pre, c.getPresident());
    }
}
