package projet;

import java.io.Serializable;

/**
 * Classe créant les clubs
 * @author RENAULT Alexis
 * @author LEVEQUE Quentin
 * 
 */

public class Club implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Nom du club
	 */
	private String nom;
	/**
	 * Ville du club
	 */
	private String ville;

	/**
	 * Constructeur de la classe Club
	 * @param nom Le nom du club cree
	 * @param ville La ville du club cree
	 */
	public Club(String nom, String ville) {
		this.nom = nom;
		this.ville = ville;
	}

	/**
	 * Redefinition de la methode toString() pour club
	 * @return Retourne via une chaine de caractere l'état du club
	 */
	public String toString() {
		return ("Club " + nom + " de " + ville);
	}

	/**
	 * getter du nom du club
	 * @return Retourne le nom du club 
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * setter du nom du club
	 * @param nom Le nouveau nom du club
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * getter de la ville du club
	 * @return Retourne la ville du club
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * setter de la ville du club
	 * @param ville La nouvelle ville du club
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
 
	/**
	 * Redefinition de la methode equals() pour club
	 * @param obj L'element a comparer avec le club actuel
	 * @return Retourne true si les deux club sont égaux, sinon false
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Club other = (Club) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}
	
	

}
