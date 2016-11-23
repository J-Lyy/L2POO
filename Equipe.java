package projet;
import java.util.*;

public class Equipe {
	private Set<Joueur> titulaires;
	private Set<Joueur> remplaçant;
	private Joueur gardien;
	int comptTitulaire = 0;
	int comptRemplaçant = 0;
	
	public Equipe()
	{
		titulaires = new HashSet<>();
		remplaçant = new HashSet<>();
	}
	
	public void ajouter(Joueur j)
	{
		Iterator<Joueur> it = titulaires.iterator();
		Iterator<Joueur> it1 = remplaçant.iterator();
		
		while(it.hasNext())
		{
			Joueur j1 = it.next();
			if(j.equals(j1))
				throw new IllegalArgumentException("Joueur deja dans l'equipe");
		}
		while(it1.hasNext())
		{
			Joueur j2 = it.next();
			if(j.equals(j2))
				throw new IllegalArgumentException("Joueur deja dans l'equipe");
		}
		
		
		if(j.getPoste().equals("gardien"))
		{
			if(gardien==null)
				gardien = j;
			else
				throw new IllegalArgumentException("L'equipe a deja un gardien");
		}
			
		if(j.getPoste().equals("titulaire"))
		{
			if(comptTitulaire==9)
				throw new IllegalArgumentException("L'equipe a déjà assez de titulaire");
			titulaires.add(j);
			comptTitulaire++;
		}
		
		if(j.getPoste().equals("remplaçant"))
		{
			if(comptTitulaire==5)
				throw new IllegalArgumentException("L'equipe a déjà assez de remplaçant");
			remplaçant.add(j);
			comptRemplaçant++;
		}
			
	}
	
	public boolean equipeValide()
	{
		if((comptTitulaire == 9) && (comptRemplaçant>0) && (comptRemplaçant<6) && (gardien != null))
			return true;
		return false;
	}
	
	
}
