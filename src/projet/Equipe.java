package projet;

import java.util.*;

/**
 * Classe creant les equipes
 * @author RENAULT Alexis
 * @author LEVEQUE Quentin
 * 
 */

public class Equipe implements Comparable<Equipe> {
	/**
	 * Ensemble des joueurs titulaires de l'equipe
	 */
	private Set<Joueur> titulaires;
	
	/**
	 * Ensemble des joueurs remplacant de l'equipe
	 */
	private Set<Joueur> remplacant;
	
	/**
	 * L'entraineur de l'equipe
	 */
	private Entraineur entraineur;
	
	/**
	 * Le club de l'equipe
	 */
	private Club club;
	
	/**
	 * Le compteur du nombre d'attaquant dans l'equipe pouvant aller jusqu'a 5
	 */
	private int comptAttaquant = 0;
	
	/**
	 * Le compteur du nombre de defenseur dans l'equipe pouvant aller jusqu'a 5
	 */
	private int comptDefenseur = 0;
	
	/**
	 * Etat de l'equipe pour savoir si elle est toujours en lice dans le tournoi ou non.
	 * Initialise a true car l'equipe n'a pas encore perdu un match
	 */
	private boolean enLice = true;
	
	/**
	 * Le numero de l'equipe (servant a trier les equipes)
	 */
	private int numEquipe;
	
	/**
	 * Le compteur de victoires de l'equipe
	 */
	private int victoire =0;
	
	/**
	 * Le compteur de defaites de l'equipe
	 */
	private int defaite = 0;
	
	/**
	 * Constructeur de la classe Equipe
	 * Les ensembles titulaires et remplacant sont definies en tant que TeeSet de Joueur pour pouvoir les trier par leur numero de maillot
	 * @param club Le club le l'equipe cree
	 * @param e L'entraineur de l'equipe cree
	 * @param numEquipe Le numero de l'equipe cree
	 */
	public Equipe(Club club, Entraineur e, int numEquipe) {
		titulaires = new TreeSet<Joueur>();
		remplacant = new TreeSet<Joueur>();
		this.club = club;
		entraineur = e ;
		this.numEquipe = numEquipe;
	}
	
	/**
	 * Methode permettant de rajouter un joueur a une equipe. 
	 * Si l'equipe n'a pas assez de joueur a un poste et que l'on passe en paramettre un joueur a ce poste la, il sera rajoute dans l'ensemble des titulaire. Sinon il sera rajoute dans l'ensemble des remplacant.
	 * S'il n'y plus de place ni dans l'un ni dans l'autre, la fonction renverra une erreur.
	 * Cela fonctionne de la meme maniere pour le gardien. 
	 * On ne peut pas ajouter de joueur dans l'equipe si ce joueur n'appartient pas au meme club que l'equipe, ni s'il appartient deja a l'equipe
	 * @param j Le joueur que l'on veut ajouter dans l'equipe
	 * @throws IllegalArgumentException Impossible d'ajouter dans l'equipe un joueur d'un autre club
	 * @throws IllegalArgumentException Le joueur est deja dans l'equipe
	 * @throws IllegalArgumentException L'equipe n'a plus de place
	 */ 
	public void ajouterJoueur(Joueur j) {
		
		if(!j.getClub().equals(club))
			throw new IllegalArgumentException("Impossible d'ajouter dans l'equipe un joueur d'un autre club");
		
		if(estDansEquipe(j))
			throw new IllegalArgumentException("Le joueur est deja dans l'equipe");
		
		if(j.getPoste().equals("gardien"))
			if (aGardien())
			{
				if(remplacant.size()==5)
					throw new IllegalArgumentException("L'equipe n'a plus de place");
				remplacant.add(j);
			}
			else{
				titulaires.add(j);
			}
		if (j.getPoste().equals("attaquant")) {
			if (comptAttaquant == 4)
			{
				if(remplacant.size()==5)
					throw new IllegalArgumentException("L'equipe n'a plus de place");
				remplacant.add(j);
			}
			else
			{
				titulaires.add(j);
				comptAttaquant++;
			}
		}

		if (j.getPoste().equals("defenseur")) {
			if (comptDefenseur == 4)
			{
				if(remplacant.size()==5)
					throw new IllegalArgumentException("L'equipe n'a plus de place");
				remplacant.add(j);
			}
			else
			{
				titulaires.add(j);
				comptDefenseur++;
			}
				
		}
	}
	
	/**
	 * Met a l'etat initial l'equipe, ce qui veut dire que tous les joueurs titulaires sont mis en jeu et que tous les joueurs remplacant sont mis sur le banc
	 */
	public void etatInitialEquipe(){
		Iterator<Joueur> it = titulaires.iterator();
		while (it.hasNext())
		{
			Joueur j1 = it.next();
			j1.setEnJeu(true);			
		}
		
		Iterator<Joueur> it2 = remplacant.iterator();
		while (it.hasNext()){
			Joueur j2 = it2.next();
			j2.setEnJeu(false);
		}
	}

	/**
	 * Supprime un joueur de l'equipe donne en parametre
	 * @param j Joueur a supprimer
	 * @return Retourne true si la suppression s'est bien faite, sinon false
	 */
	public boolean supprimerJoueur(Joueur j) {
		if(titulaires.contains(j))
		{
			if(j.getPoste().equals("attaquant"))
				comptAttaquant--;
			
			if(j.getPoste().equals("defenseur"))
				comptDefenseur--;
			
			titulaires.remove(j);
			return true;
		}
		
		if(remplacant.contains(j))
		{
			remplacant.remove(j);
			return true;
		}
		
		return false;
	}

	/**
	 * Teste si l'equipe est valide, ce qui veut dire si celle-ci a bien 9 titulaires dont un gardien et qu'elle possede entre 1 et 5 remplacant
	 * @return retourne true si l'equipe est valide, sinon false
	 */
	public boolean equipeValide() {
		if(titulaires.size()==9 && remplacant.size()>0 && remplacant.size()<6 && aGardien())
			return true;
		return false;
	}
	
	/**
	 * Teste si un joueur est dans l'equipe
	 * @param j Joueur dont on veut savoir s'il apparatient a l'equipe ou non
	 * @return Retourne true si le joueur appartient a l'equipe, false sinon
	 */
	public boolean estDansEquipe(Joueur j) {
		if(titulaires.contains(j) || remplacant.contains(j))
			return true;
		return false;
	}
	
	/**
	 * Teste si l'equipe possede un gardien
	 * @return Retourne true si l'equipe possede un gardien, false sinon
	 */
	public boolean aGardien() {
		Iterator<Joueur> it = titulaires.iterator();
		while (it.hasNext())
		{
			Joueur j1 = it.next();
			if(j1.getPoste().equals("gardien"))
				return true;				
		}
		return false;
	}
	
	/**
	 * Teste si le joueur est titulaire
	 * @param j Joueur a tester
	 * @return Retourner vrai si le joueur est titulaire, false sinon
	 */
	public boolean estTitulaire(Joueur j)
	{
		if(titulaires.contains(j))
			return true;
		return false;
	}

	/**
	 * Redefinition de la methode toString() pour Equipe
	 * @return Retourne via une chaine de caractère l'etat de l'equipe
	 */
	public String toString() {
		String s = "Les titulaires de l'equipe : \n";
		Iterator<Joueur> it = titulaires.iterator();
		while (it.hasNext()) {
			Joueur j1 = it.next();
			s += j1.toString() + "\n";
		}
		s += "Les remplacant de l'equipe : \n";

		Iterator<Joueur> it1 = remplacant.iterator();
		while (it1.hasNext()) {
			Joueur j1 = it1.next();
			s += j1.toString() + "\n";
		}
		return s;
	}

	/**
	 * getter des titulaires de l'equipe
	 * @return Retourne l'ensemble des titulaires de l'equipe
	 */
	public Set<Joueur> getTitulaires() {
		return titulaires;
	}

	/**
	 * getter du club de l'equipe
	 * @return Retourne le club de l'equipe
	 */
	public Club getClub() {
		return club;
	}

	/**
	 * Teste si l'equipe est en lice ou non
	 * @return Retourne true si l'equipe est en lice, false sinon
	 */
	public boolean isEnLice() {
		return enLice;
	}

	/**
	 * setter de enLice
	 * @param enLice Nouvel etat de enLice : true pour la mettre en lice ou false pour la mettre hors jeu
	 */
	public void setEnLice(boolean enLice) {
		this.enLice = enLice;
	}

	/**
	 * setter de l'entraineur de l'equipe
	 * @param entraineur Nouvel entraineur de l'equipe
	 */
	public void setEntraineur(Entraineur entraineur) {
		this.entraineur = entraineur;
	}
	
	/**
	 * getter du numero de l'equipe
	 * @return Retourne le numero de l'equipe
	 */
	public int getNumEquipe() {
		return numEquipe;
	}

	/**
	 * setter du numero de l'equipe
	 * @param numEquipe Nouveau numero de l'equipe
	 */
	public void setNumEquipe(int numEquipe) {
		this.numEquipe = numEquipe;
	}

	/**
	 * getter du nombre de victoire de l'equipe
	 * @return Retourne le nombre de victoire de l'equipe
	 */
	public int getVictoire() {
		return victoire;
	}

	/**
	 * setter du nombre de victoire de l'equipe
	 * @param victoire Nouveau nombre de victoire de l'equipe
	 */
	public void setVictoire(int victoire) {
		this.victoire = victoire;
	}

	/**
	 * getter du nombre de defaite de l'equipe
	 * @return Retourne le nombre de defaite de l'equipe
	 */
	public int getDefaite() {
		return defaite;
	}

	/**
	 * setter du nombre de defaite de l'equipe
	 * @param defaite Nouveau nombre de defaite de l'equipe
	 */
	public void setDefaite(int defaite) {
		this.defaite = defaite;
	}

	/**
	 * Redefinition de la methode compareTo() pour Equipe, comparant le numero de l'equipe
	 * @param arg0 L'equipe a comparer avec l'equipe actuelle
	 * @return Retourne -1 si le numero de l'equipe actuelle est inferieur a celui donne en parametre, 0 s'il est egal, ou 1 s'il est superieur
	 */
	public int compareTo(Equipe arg0) {
		if(this.numEquipe > arg0.numEquipe)
			return 1;
		if(this.numEquipe < arg0.numEquipe)
			return -1;
		return 0;
		
	}


}
