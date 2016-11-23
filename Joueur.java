package projet;

import java.util.Calendar;

public class Joueur extends Licencie {
	private String poste;
	private int numeroMaillot;
	
	public Joueur(int numLic, String nom, String prenom, Calendar dateValidite, Club club, String poste, int numeroDeMaillot)
	{
		super(numLic,nom,prenom,dateValidite,club);
		if((poste.equals("titulaire") && poste.equals("remplaçant") && poste.equals("gardien")))
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
	
	public String toString()
	{
		return (poste+" "+nom+" "+prenom+" du club "+club+" de numero de maillot : "+numeroMaillot);
	}

	public int getNumeroDeLicence() {
		return numeroDeLicence;
	}

	public void setNumeroDeLicence(int numeroDeLicence) {
		this.numeroDeLicence = numeroDeLicence;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Calendar getDateDeValidite() {
		return dateDeValidite;
	}

	public void setDateDeValidite(Calendar dateDeValidite) {
		this.dateDeValidite = dateDeValidite;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public int getNumeroMaillot() {
		return numeroMaillot;
	}

	public void setNumeroMaillot(int numeroMaillot) {
		this.numeroMaillot = numeroMaillot;
	}
	

}
