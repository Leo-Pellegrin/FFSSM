/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.*;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public ArrayList<Embauche> employeurs;
    public ArrayList<Plongee> plongeesDirigees;

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, int numeroDiplome, GroupeSanguin groupe) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau, groupe);
        this.numeroDiplome = numeroDiplome;
        this.employeurs = new ArrayList<Embauche>();
        this.plongeesDirigees = new ArrayList<Plongee>();
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeur() {
        if(this.employeurs.size() == 0) return Optional.ofNullable(null);
        employeurs.sort((o1, o2) -> o1.getDebut().compareTo(o2.getDebut()));
        return Optional.ofNullable(employeurs.get(employeurs.size() - 1).getEmployeur());
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
        Embauche e = new Embauche(debutNouvelle, this, employeur);
        this.employeurs.add(e);         
    }

    public void terminerEmbauche(LocalDate fin){
        if(this.employeurs.size() == 0) return;
        employeurs.sort((o1, o2) -> o1.getDebut().compareTo(o2.getDebut()));
        employeurs.get(employeurs.size() - 1).terminer(fin);
    }

    public List<Embauche> emplois() {
        return this.employeurs;
    }

}
