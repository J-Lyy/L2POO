package projet;

import java.util.Calendar;

public class Entraineur extends Licencie{
	private int numeroDeLicence;
	private String nom;
	private String prenom;
	private Calendar dateDeValidite;
	private Club club;
	private int niveau;
	
	public Entraineur(int numLic, String nom, String prenom, Calendar dateValidite, Club club, int niveau)
	{
		super(numLic,nom,prenom,dateValidite,club);
		if((niveau<1) || (niveau>5))
		{
			throw new IllegalArgumentException("Le niveau doit �tre compris entre 1 et 5");
		}
		this.niveau = niveau;
	}
}
