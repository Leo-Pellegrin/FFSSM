package FFSSM;

import java.time.LocalDate;
import java.util.*;

public class Plongeur extends Personne {
    private int niveau;
    private ArrayList<Licence> licences;
    private GroupeSanguin groupe;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin groupe){
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.groupe = groupe;
        this.licences = new ArrayList<Licence>();
    }

    public void ajouterLicence(String numero, LocalDate delivrance, Club c){
        Licence l = new Licence(this, numero, delivrance, c);
        licences.add(l);
        l.addToClub();
    }

    public Licence derniereLicence(){
        licences.sort((o1, o2) -> o1.getDelivrance().compareTo(o2.getDelivrance()));
        return licences.get(licences.size() - 1);
    }


    // Ajout inutile
    public ArrayList<Licence> getLicenceValide(){
        ArrayList<Licence> llicences = new ArrayList<Licence>();
        for(int i = 0; i < licences.size(); i++){
            if(licences.get(i).estValide(LocalDate.now())){
                llicences.add(licences.get(i));
            }
        }
        return llicences;
    }

}
