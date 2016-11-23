package projet;
import java.util.*;

public class Equipe {
	private Set<Joueur> titulaires;
	private Set<Joueur> rempla�ant;
	private Joueur gardien;
	int comptTitulaire = 0;
	int comptRempla�ant = 0;
	
	public Equipe()
	{
		titulaires = new HashSet<>();
		rempla�ant = new HashSet<>();
	}
	
	public void ajouter(Joueur j)
	{
		Iterator<Joueur> it = titulaires.iterator();
		Iterator<Joueur> it1 = rempla�ant.iterator();
		
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
				throw new IllegalArgumentException("L'equipe a d�j� assez de titulaire");
			titulaires.add(j);
			comptTitulaire++;
		}
		
		if(j.getPoste().equals("rempla�ant"))
		{
			if(comptTitulaire==5)
				throw new IllegalArgumentException("L'equipe a d�j� assez de rempla�ant");
			rempla�ant.add(j);
			comptRempla�ant++;
		}
			
	}
	
	public boolean equipeValide()
	{
		if((comptTitulaire == 9) && (comptRempla�ant>0) && (comptRempla�ant<6) && (gardien != null))
			return true;
		return false;
	}
	
	
}
