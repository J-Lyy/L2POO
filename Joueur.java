package projet;

import java.util.Calendar;

public class Joueur extends Licencie {
	private int numeroDeLicence;
	private String nom;
	private String prenom;
	private Calendar dateDeValidite;
	private Club club;
	private String poste;
	private int numeroMaillot;
	
	public Joueur(int numLic, String nom, String prenom, Calendar dateValidite, Club club, String poste, int numeroDeMaillot)
	{
		super(numLic,nom,prenom,dateValidite,club);
		if((poste.equals("titulaire") || poste.equals("remplaçant") || poste.equals("gardien")))
			throw new IllegalArgumentException("Le poste peut être titulaire, remplaçant ou gardien");
		this.poste = poste;
		this.numeroMaillot = numeroDeMaillot;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (numeroDeLicence != other.numeroDeLicence)
			return false;
		return true;
	}
	

}
