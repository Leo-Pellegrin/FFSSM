package FFSSM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class TestPlongee {

    Plongee p, p2;
    Moniteur m;
    Club c;
    Plongeur pg, pg2;

    @BeforeEach
    public void setUp(){
        m = new Moniteur("73839", "Pellegrin", "Leo", "14 rue de Castres", "0781794004", LocalDate.of(2002, 12, 4), 3, 40, GroupeSanguin.AMOINS);
        c = new Club(m, "AquaPlanning", "la mer", "0728819");
        p = new Plongee(new Site("Marseille", "Calanque"), m, LocalDate.of(2022, 12, 13), 50, 1, c);
        pg = new Plongeur("377", "Baptiste", "Lolilo", "ENFER", "06060606", LocalDate.of(2000, 1, 1), 5, GroupeSanguin.BMOINS);
    
       
    }

    @Test
    public void testCreation(){
        assertTrue(p instanceof Plongee);
    }
    
    @Test void testAjouteParticipant(){
        pg.ajouterLicence("34994", LocalDate.of(2017, 8, 2), c);
        p.ajouteParticipant(pg);

        assertEquals(p.palanquees.get(0).getPossesseur(), pg);
    }

    @Test void testEstConforme(){
        pg.ajouterLicence("34994", LocalDate.of(2017, 8, 2), c);
        p.ajouteParticipant(pg);
        assertFalse(p.estConforme());

        pg2 = new Plongeur("3993", "Garcion", "Lois", "paradis", "83739303", LocalDate.of(2002, 1, 10), 2, GroupeSanguin.BPLUS);
        pg2.ajouterLicence("8383", LocalDate.of(2022, 10, 1), c);

        p2 = new Plongee(new Site("Dijon", "foret"), m, LocalDate.of(2022, 12, 13), 50, 1, c);
        p2.ajouteParticipant(pg2);

        assertTrue(p2.estConforme());
    }
}
