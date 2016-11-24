package projet;

import java.util.*;

public class Equipe {
	private Set<Joueur> titulaires;
	private Set<Joueur> remplaçant;
	private Entraineur entraineur;
	int comptAttaquant = 0;
	int comptDefenseur = 0;

	public Equipe() {
		titulaires = new HashSet<>();
		remplaçant = new HashSet<>();
	}

	public void ajouterJoueur(Joueur j) {
		
		if(estDansEquipe(j))
			throw new IllegalArgumentException("Le joueur est deja dans l'equipe");
		
		if(j.getPoste().equals("gardien"))
			if (aGardien())
				throw new IllegalArgumentException("L'equipe a deja un gardien");
			else
				titulaires.add(j);

		if (j.getPoste().equals("attaquant")) {
			if (comptAttaquant == 4)
			{
				if(remplaçant.size()==5)
					throw new IllegalArgumentException("L'equipe n'a plus de place");
				remplaçant.add(j);
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
				if(remplaçant.size()==5)
					throw new IllegalArgumentException("L'equipe n'a plus de place");
				remplaçant.add(j);
			}
			else
			{
				titulaires.add(j);
				comptDefenseur++;
			}
				
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
		
		if(remplaçant.contains(j))
		{
			remplaçant.remove(j);
			return true;
		}
		
		return false;
	}

	public void ajouterEntraineur(Entraineur e) {
		if (entraineur == null)
			entraineur = e;
		else
			throw new IllegalArgumentException("L'equipe a deja un entraineur");
	}

	public void supprimerEntraineur() {
		if (entraineur == null)
			throw new IllegalArgumentException("L'equipe n'avait pas d'entraineur");
		entraineur = null;

	}

	public boolean equipeValide() {
		if(titulaires.size()==9 && remplaçant.size()>0 && remplaçant.size()<6 && aGardien())
			return true;
		return false;
	}
	
	public boolean estDansEquipe(Joueur j) {
		if(titulaires.contains(j) || remplaçant.contains(j))
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

	public String toString() {
		String s = "Les titulaires de l'equipe : \n";
		Iterator<Joueur> it = titulaires.iterator();
		while (it.hasNext()) {
			Joueur j1 = it.next();
			s += j1.toString() + "\n";
		}
		s += "Les remplaçant de l'equipe : \n";

		Iterator<Joueur> it1 = remplaçant.iterator();
		while (it1.hasNext()) {
			Joueur j1 = it1.next();
			s += j1.toString() + "\n";
		}
		return s;
	}

}
