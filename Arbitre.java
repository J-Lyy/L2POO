package projet;

import java.util.Calendar;

public class Arbitre extends Licencie {
	private int categorie;
	
	public Arbitre(int numLic, String nom, String prenom, Calendar dateValidite, Club club, int categorie)
	{
		super(numLic,nom,prenom,dateValidite,club);
		if((categorie<1) || (categorie>3))
			throw new IllegalArgumentException("La catégorie doit être comprise entre 1 et 3");
		this.categorie = categorie;
	}
}
