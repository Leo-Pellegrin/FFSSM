/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.*;

public class Plongee {

	public Site lieu;

	public Moniteur chefDePalanquee;

	public LocalDate date;

	public int profondeur;

	public int duree;

	public ArrayList<Licence> palanquees;

	public Club organisateur;

	public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree, Club organisateur) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
		this.organisateur = organisateur;
		this.palanquees = new ArrayList<Licence>();
	}

	public void ajouteParticipant(Plongeur participant) {
		this.palanquees.add(participant.derniereLicence());
		participant.derniereLicence().addToListePlongee(this);
	}

	public LocalDate getDate() {
		return date;
	}

	/**
	 * Détermine si la plongée est conforme. 
	 * Une plongée est conforme si tous les plongeurs de la palanquée ont une
	 * licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
	 */
	public boolean estConforme() {
		for(int i = 0; i < palanquees.size(); i++){
			if(!(palanquees.get(i).estValide(this.date))) return false;
		}
		return true;
	}

}
