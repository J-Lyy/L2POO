package projet;

import java.util.Calendar;

/**
 * Classe creant les joueurs
 * @author RENAULT Alexis
 * @author LEVEQUE Quentin
 * 
 */

public class Joueur extends Licencie implements Comparable<Joueur> {
	/**
	 * Le poste du joueur, pouvant être soit attaquant, soit defenseur soit gardien
	 */
	private String poste;
	
	/**
	 * Le numéro de maillot du joueur
	 */
	private int numeroMaillot;
	
	/**
	 * Etat du joueur pour dire s'il en jeu (true) ou non (false).
	 * Initialise a false car le joueur n'est pas en jeu car aucun match n'a commence
	 */
	private boolean enJeu = false;
	
	/**
	 * Constructeur de la classe Arbitre
	 * @param numLic Le numéro de licence du joueur cree
	 * @param nom Le nom du joueur crée
	 * @param prenom Le prénom du joueur cree
	 * @param dateValidite La date du joueur de la licence de l'arbitre cree
	 * @param club Le club du joueur cree
	 * @param poste Le poste du joueur cree
	 * @param numeroDeMaillot Le numéro du maillot du joueur cree
	 * @throws IllegalArgumentException Le poste peut etre attaquant, defenseur ou gardien
	 */
	public Joueur(int numLic, String nom, String prenom, Calendar dateValidite, Club club, String poste, int numeroDeMaillot)
	{
		super(numLic,nom,prenom,dateValidite,club);
		if((!poste.equals("attaquant") && !poste.equals("defenseur") && !poste.equals("gardien")))
			throw new IllegalArgumentException("Le poste peut etre attaquant, defenseur ou gardien");
		this.poste = poste;
		this.numeroMaillot = numeroDeMaillot;
	}
	
	/**
	 * Redefinition de la methode toString() pour joueur
	 * @return Retourne via une chaine de caractère l'etat du joueur
	 */
	public String toString()
	{
		String s = "";
		if (enJeu)
			s += "actuellement en jeu" ;
		else
			s+= " actuellement sur le banc" ;
		return (super.toString() + " au poste " + poste + ", numéro " + numeroMaillot + s) ;
	}

	/**
	 * getter du numero de licence du joueur
	 * @return Retourne le numero de licence du joueur
	 */
	public int getNumeroDeLicence() {
		return numeroDeLicence;
	}
	
	/**
	 * setter du numero de licence du joueur
	 * @param numeroDeLicence Le nouveau numéro de licence du joueur
	 */
	public void setNumeroDeLicence(int numeroDeLicence) {
		this.numeroDeLicence = numeroDeLicence;
	}

	/**
	 * getter du nom du joueur
	 * @return Retourne le nom du joueur
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * setter du nom du joueur
	 * @param nom Le nouveau nom du joueur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * getter du prenom
	 * @return Retourne le prénom du joueur
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * setter du prenom du joueur
	 * @param prenom Le nouveau prenom du joueur
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * getter de la date de validite de la licence du joueur
	 * @return Retourne la date de validite de la licence du joueur
	 */
	public Calendar getDateDeValidite() {
		return dateDeValidite;
	}

	/**
	 * setter de la date de validite de la licence du joueur
	 * @param dateDeValidite Nouvelle date de validite de lia licence du joueur
	 */
	public void setDateDeValidite(Calendar dateDeValidite) {
		this.dateDeValidite = dateDeValidite;
	}

	/**
	 * getter du club du joueur
	 * @return Retourne le club du joueur
	 */
	public Club getClub() {
		return club;
	}

	/**
	 * setter du club du joueur
	 * @param club Le nouveau club du joueur
	 */
	public void setClub(Club club) {
		this.club = club;
	}

	/**
	 * getter du poste du joueur
	 * @return Retourne le poste du joueur
	 */
	public String getPoste() {
		return poste;
	}

	/**
	 * setter du poste du joueur
	 * @param poste Le nouveau poste du joueur
	 */
	public void setPoste(String poste) {
		this.poste = poste;
	}

	/**
	 * getter du numero de maillot
	 * @return Retourne le numero de maillot du joueur
	 */
	public int getNumeroMaillot() {
		return numeroMaillot;
	}

	/**
	 * setter du numero de maillot du joueur
	 * @param numeroMaillot Le nouveau numero de maillot du joueur
	 */
	public void setNumeroMaillot(int numeroMaillot) {
		this.numeroMaillot = numeroMaillot;
	}

	/**
	 * getter de enJeu 
	 * @return Retourne false si le joueur n'est pas en jeu, true sinon
	 */
	public boolean isEnJeu() {
		return enJeu;
	}

	/**
	 * setter de enJeu
	 * @param enJeu Redefini si le joueur est en jeu ou non
	 */
	public void setEnJeu(boolean enJeu) {
		this.enJeu = enJeu;
	}

	/**
	 * Redefinition de la methode compareTo() pour joueur, comparant le numero de maillot des joueurs
	 * @param j Le joueur a comparer avec le joueur actuel
	 * @return Retourne -1 si le numero de maillot du joueur actuel est inferieur a celui donne en parametre, 0 s'il est egal, ou 1 s'il est superieur
	 */
	public int compareTo(Joueur j) {
		if(this.numeroMaillot<j.numeroMaillot)
			return -1;
		if(this.numeroMaillot==j.numeroMaillot)
			return 0;
		return 1;
	}

	
	

}
