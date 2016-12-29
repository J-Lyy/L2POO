package projet;

import java.util.Calendar;

public class Joueur extends Licencie implements Comparable<Joueur> {
	private String poste;
	private int numeroMaillot;
	private boolean enJeu = false;
	
	public Joueur(int numLic, String nom, String prenom, Calendar dateValidite, Club club, String poste, int numeroDeMaillot)
	{
		super(numLic,nom,prenom,dateValidite,club);
		if((poste.equals("titulaire") && poste.equals("rempla�ant") && poste.equals("gardien")))
			throw new IllegalArgumentException("Le poste peut �tre titulaire, rempla�ant ou gardien");
		this.poste = poste;
		this.numeroMaillot = numeroDeMaillot;
	}
	
	public String toString()
	{
		String s = "";
		if (enJeu)
			s += "actuellement en jeu" ;
		else
			s+= " actuellement sur le banc" ;
		return (super.toString() + " au poste " + poste + ", numéro " + numeroMaillot + s) ;
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

	public boolean isEnJeu() {
		return enJeu;
	}

	public void setEnJeu(boolean enJeu) {
		this.enJeu = enJeu;
	}

	public int compareTo(Joueur j) {
		if(this.numeroMaillot<j.numeroMaillot)
			return -1;
		if(this.numeroMaillot==j.numeroMaillot)
			return 0;
		return 1;
	}

	
	

}
