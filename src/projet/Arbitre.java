package projet;

import java.util.Calendar;

/**
 * Classe creant les arbitres
 * @author RENAULT Alexis
 * @author LEVEQUE Quentin
 * 
 */

public class Arbitre extends Licencie {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Categorie de l'arbitre pouvant etre compris entre 1 et 3
	 */
	private int categorie;
	
	/**
	 * Constructeur de la classe Arbitre
	 * @param numLic Le numero de licence de l'arbitre cree
	 * @param nom Le nom de l'arbitre cree
	 * @param prenom Le prenom de l'arbitre cree
	 * @param dateValidite La date de validite de la licence de l'arbitre cree
	 * @param club Le club de l'arbitre cree
	 * @param categorie La categorie de l'arbitre cree
	 */
	public Arbitre(int numLic, String nom, String prenom, Calendar dateValidite, Club club, int categorie)
	{
		super(numLic,nom,prenom,dateValidite,club);
		if((categorie<1) || (categorie>3))
			throw new IllegalArgumentException("La catégorie doit être comprise entre 1 et 3");
		this.categorie = categorie;
	}
	
	
}
