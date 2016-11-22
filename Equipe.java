package projet;
import java.util.*;

public class Equipe {
	private Set<Joueur> joueurs;
	
	public Equipe()
	{
		joueurs = new HashSet<>();
	}
	
	public void ajouter(Joueur j)
	{
		Iterator<Joueur> it = joueurs.iterator();
		int comptTitulaire = 0;
		int comptRemplaçant = 0;
		while(it.hasNext())
		{
			Joueur j1 = it.next();
			if(j.getPoste().equals(j1.getPoste()))
				throw new IllegalArgumentException("Joueur deja dans l'equipe");
			
			if(j.getPoste().equals("gardien") && j1.getPoste().equals("gardien"))
				throw new IllegalArgumentException("L'equipe a deja un gardien");
			
			if(j1.getPoste().equals("titulaire"))
				comptTitulaire++;
			
			if(j1.getPoste().equals("remplaçant"))
				comptRemplaçant++;
				
		}
		joueurs.add(j);
	}
}
