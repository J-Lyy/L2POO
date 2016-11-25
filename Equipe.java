package projet;

import java.util.*;

public class Equipe {
	private Set<Joueur> titulaires;
	private Set<Joueur> remplacant;
	private Entraineur entraineur;
	private Club club;
	private int comptAttaquant = 0;
	private int comptDefenseur = 0;

	public Equipe(Club club, Entraineur e) {
		titulaires = new TreeSet<>();
		remplacant = new TreeSet<>();
		this.club = club;
		entraineur = e ;
	}

	public void ajouterJoueur(Joueur j) {
		
		if(!j.getClub().equals(club))
			throw new IllegalArgumentException("Impossible d'ajouter dans l'equipe un joueur d'un autre club");
		
		if(estDansEquipe(j))
			throw new IllegalArgumentException("Le joueur est deja dans l'equipe");
		
		if(j.getPoste().equals("gardien"))
			if (aGardien())
			{
				if(remplacant.size()==5)
					throw new IllegalArgumentException("L'equipe n'a plus de place");
				remplacant.add(j);
			}
			else{
				titulaires.add(j);
			}
		if (j.getPoste().equals("attaquant")) {
			if (comptAttaquant == 4)
			{
				if(remplacant.size()==5)
					throw new IllegalArgumentException("L'equipe n'a plus de place");
				remplacant.add(j);
			}
			else
			{
				titulaires.add(j);
				comptAttaquant++;
			}
		}

		if (j.getPoste().equals("defenseur")) {
			if (comptDefenseur == 4)
			{
				if(remplacant.size()==5)
					throw new IllegalArgumentException("L'equipe n'a plus de place");
				remplacant.add(j);
			}
			else
			{
				titulaires.add(j);
				comptDefenseur++;
			}
				
		}
	}
	
	public void etatInitialEquipe(){
		Iterator<Joueur> it = titulaires.iterator();
		while (it.hasNext())
		{
			Joueur j1 = it.next();
			j1.setEnJeu(true);			
		}
		
		Iterator<Joueur> it2 = remplacant.iterator();
		while (it.hasNext()){
			Joueur j2 = it2.next();
			j2.setEnJeu(false);
		}
	}

	public boolean supprimerJoueur(Joueur j) {
		if(titulaires.contains(j))
		{
			if(j.getPoste().equals("attaquant"))
				comptAttaquant--;
			
			if(j.getPoste().equals("defenseur"))
				comptDefenseur--;
			
			titulaires.remove(j);
			return true;
		}
		
		if(remplacant.contains(j))
		{
			remplacant.remove(j);
			return true;
		}
		
		return false;
	}

	public boolean equipeValide() {
		if(titulaires.size()==9 && remplacant.size()>0 && remplacant.size()<6 && aGardien())
			return true;
		return false;
	}
	
	public boolean estDansEquipe(Joueur j) {
		if(titulaires.contains(j) || remplacant.contains(j))
			return true;
		return false;
	}
	
	public boolean aGardien() {
		Iterator<Joueur> it = titulaires.iterator();
		while (it.hasNext())
		{
			Joueur j1 = it.next();
			if(j1.getPoste().equals("gardien"))
				return true;				
		}
		return false;
	}
	
	public boolean estTitulaire(Joueur j)
	{
		if(titulaires.contains(j))
			return true;
		return false;
	}

	public String toString() {
		String s = "Les titulaires de l'equipe : \n";
		Iterator<Joueur> it = titulaires.iterator();
		while (it.hasNext()) {
			Joueur j1 = it.next();
			s += j1.toString() + "\n";
		}
		s += "Les remplacant de l'equipe : \n";

		Iterator<Joueur> it1 = remplacant.iterator();
		while (it1.hasNext()) {
			Joueur j1 = it1.next();
			s += j1.toString() + "\n";
		}
		return s;
	}

	public Club getClub() {
		return club;
	}

	public void setEntraineur(Entraineur entraineur) {
		this.entraineur = entraineur;
	}
	
	

}
