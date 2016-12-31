package projet;
import java.util.Calendar;

/**
 * Classe creant les licences
 * @author RENAULT Alexis
 * @author LEVEQUE Quentin
 * 
 */

public abstract class Licencie {

	/**
	 * Numero de la licence du joueur/entraineur/arbitre
	 */	
	protected int numeroDeLicence;
	
	/**
	 * Nom du joueur/entraineur/arbitre
	 */	
	
	protected String nom;
	/**
	 * Prenom du joueur/entraineur/arbitre
	 */	
	
	protected String prenom;
	/**
	 * Date jusqu'a laquelle la licence du joueur/entraineur/arbitre est valide
	 */	
	
	protected Calendar dateDeValidite
	/**
	 * Le club du joueur/entraineur/arbitre
	 */	;
	
	protected Club club;
	
	/**
	 * Constructeur de la classe Licencie
	 * @param numLic Le numero de licence du joueur/entraineur/arbitre cree
	 * @param nom Le nom du joueur/entraineur/arbitre cree
	 * @param prenom Le prenom du joueur/entraineur/arbitre cree
	 * @param dateValidite La date de validite de la licence du joueur/entraineur/arbitre cree
	 * @param club Le club du joueur/entraineur/arbitre cree
	 */
	
	public Licencie(int numLic, String nom, String prenom, Calendar dateValidite, Club club)
	{
		numeroDeLicence = numLic;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeValidite = dateValidite;
		this.club = club;
	}

	/**
	 * getter de numeroDeLicence
	 * @return numeroDeLicence Retourne le numero de licence
	 */
	public int getNumeroDeLicence() {
		return numeroDeLicence;
	}
	
	/**
	 * setter de numeroDeLicence
	 * @param numeroDeLicence Le nouveau numero de licence
	 */

	public void setNumeroDeLicence(int numeroDeLicence) {
		this.numeroDeLicence = numeroDeLicence;
	}
	
	/**
	 * getter de nom
	 * @return Retourne le nom
	 */

	public String getNom() {
		return nom;
	}
	
	/**
	 * setter de nom
	 * @param nom Le nouveau nom
	 */

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * getter de prenom
	 * @return Retourne le prenom
	 */

	public String getPrenom() {
		return prenom;
	}

	/**
	 * setter de prenom
	 * @param prenom Le nouveau prenom
	 */
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * getter de la date de validite
	 * @return Retourne la date de validite
	 */

	public Calendar getDateDeValidite() {
		return dateDeValidite;
	}
	
	/**
	 * setter de la date de validite
	 * @param dateDeValidite La nouvelle date de validite
	 */

	public void setDateDeValidite(Calendar dateDeValidite) {
		this.dateDeValidite = dateDeValidite;
	}
	
	/**
	 * getter du club
	 * @return Retourne le club
	 */

	public Club getClub() {
		return club;
	}
	
	/**
	 * setter du club
	 * @param club Le nouveau club
	 */

	public void setClub(Club club) {
		this.club = club;
	}
	
	/**
	 * Redefinition de la methode toString() pour Licencie
	 * @return Retourne via une chaine de caractere l'état de la licence
	 */
	public String toString(){
		return (nom + " " + prenom + " dans le club : " + club + " de numéro de license " + numeroDeLicence + " expirant le " + dateDeValidite.get(Calendar.DAY_OF_MONTH)+" "+ (dateDeValidite.get(Calendar.MONTH)+1)+" " + dateDeValidite.get(Calendar.YEAR)+"\n") ;
	}
	
	/**
	 * Redefinition de la methode equals() pour Licencie
	 * @param obj La deuxième licence à comparer avec l'actuelle
	 */
	
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
