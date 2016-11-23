package projet;
import java.util.*;

public class Equipe {
	private Set<Joueur> titulaires;
	private Set<Joueur> remplaçant;
	private Joueur gardien;
	private Entraineur entraineur;
	int comptTitulaire = 0;
	int comptRemplaçant = 0;
	
	public Equipe()
	{
		titulaires = new HashSet<>();
		remplaçant = new HashSet<>();
	}
	
	public void ajouterJoueur(Joueur j)
	{
		Iterator<Joueur> it = titulaires.iterator();
		Iterator<Joueur> it1 = remplaçant.iterator();
		
		while(it.hasNext())
		{
			Joueur j1 = it.next();
			if(j.equals(j1))
				throw new IllegalArgumentException("Le joueur est deja dans l'equipe");
		}
		while(it1.hasNext())
		{
			Joueur j2 = it1.next();
			if(j.equals(j2))
				throw new IllegalArgumentException("Le joueur est deja dans l'equipe");
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
	
	public boolean supprimerJoueur(Joueur j)
	{
		if(j.getPoste().equals("gardien") && (gardien != null))
		{
			gardien = null;
			return true;
		}
		else
		{
			if(j.getPoste().equals("titulaire"))
			{
				Iterator<Joueur> it = titulaires.iterator();
				while(it.hasNext())
				{
					Joueur j1 = it.next();
					if(j.equals(j1))
					{
						titulaires.remove(j1);
						return true;
					}
				}
			}
			if(j.getPoste().equals("remplaçant"))
			{
				Iterator<Joueur> it = remplaçant.iterator();
				while(it.hasNext())
				{
					Joueur j1 = it.next();
					if(j.equals(j1))
					{
						remplaçant.remove(j1);
						return true;
					}
				}						
			}
		}
		return false;
	}
	
	public void ajouterEntraineur(Entraineur e)
	{
		if(entraineur == null)
			entraineur = e;
		else
			throw new IllegalArgumentException("L'equipe a deja un entraineur");
	}
	
	public void supprimerEntraineur()
	{
		if(entraineur == null)
			throw new IllegalArgumentException("L'equipe n'avait pas d'entraineur");
		entraineur = null;
			
	}
	
	public boolean equipeValide()
	{
		if((comptTitulaire == 9) && (comptRemplaçant>0) && (comptRemplaçant<6) && (gardien != null))
			return true;
		return false;
	}
	
	public String toString()
	{
		String s ="Les titulaires de l'equipe : \n";
		Iterator<Joueur> it = titulaires.iterator();
		while(it.hasNext())
		{
			Joueur j1 = it.next();
			s+=j1.toString()+"\n";
		}
		s+="Les remplaçant de l'equipe : \n";
		
		Iterator<Joueur> it1 = remplaçant.iterator();
		while(it1.hasNext())
		{
			Joueur j1 = it1.next();
			s+=j1.toString()+"\n";
		}
		return s;
	}
	
}
