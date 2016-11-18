package projet;

import java.util.Calendar;

public class Arbitre extends Licencie {
	private int numeroDeLicence;
	private String nom;
	private String prenom;
	private Calendar dateDeValidite;
	private Club club;
	private int categorie;
	
	public Arbitre(int numLic, String nom, String prenom, Calendar dateValidite, Club club, String poste, int categorie)
	{
		super(numLic,nom,prenom,dateValidite,club);
		if((categorie<1) || (categorie>3))
			throw new IllegalArgumentException("La cat�gorie doit �tre comprise entre 1 et 3");
		this.categorie = categorie;
	}
}
