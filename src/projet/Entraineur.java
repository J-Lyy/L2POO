package projet;

import java.util.Calendar;

/**
 * Classe creant les entraineurs
 * @author RENAULT Alexis
 * @author LEVEQUE Quentin
 * 
 */

public class Entraineur extends Licencie {
	/**
	 * Niveau de l'entraineur pouvant aller de 1 à 5
	 */
	private int niveau;
	
	/**
	 * Constructeur de la classe Entraineur
	 * @param numLic Le numero de licence de l'entraineur cree
	 * @param nom Le nom de l'entraineur cree
	 * @param prenom Le prenom de l'entraineur cree
	 * @param dateValidite La date de validite de la licence de l'entraineur cree
	 * @param club Le club de l'entraineur cree
	 * @param niveau Le niveau de l'entraineur cree
	 */
	public Entraineur(int numLic, String nom, String prenom, Calendar dateValidite, Club club, int niveau) {
		super(numLic, nom, prenom, dateValidite, club);
		if ((niveau < 1) || (niveau > 5)) {
			throw new IllegalArgumentException("Le niveau doit être compris entre 1 et 5");
		}
		this.niveau = niveau;
	}
}
