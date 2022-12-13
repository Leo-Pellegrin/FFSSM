/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.*;

public class Licence {

    public Personne possesseur;

    public String numero;

    public LocalDate delivrance;

    public Club club;

    public ArrayList<Plongee> plongees;

    public Licence(Personne possesseur, String numero, LocalDate delivrance, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.club = club;
        this.plongees = new ArrayList<Plongee>();
    }

    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDelivrance() {
        return delivrance;
    }

    public Club getClub() {
        return club;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ?
     * Une licence est valide pendant un an à compter de sa date de délivrance
     * @param d la date à tester
     * @return vrai si valide à la date d
     **/
    public boolean estValide(LocalDate d) {
        if(d.isBefore(this.getDelivrance().plusYears(1))){
            return true;
        }
        else{
            return false;
        }
    }

    // Ajoute la licence dans la liste des licencesDelivrees par le club
    public void addToClub(){
        this.getClub().addToLicenceDelivrees(this);
    }

    public void addToListePlongee(Plongee p){
        this.plongees.add(p);
    }

}
