package projet;

import java.util.*;
import java.math.*;

/**
 * Classe créant les tours
 * @author RENAULT Alexis
 * @author LEVEQUE Quentin
 * 
 */

public class Tour implements Comparable<Tour>{
	/**
	 * L'ensemble des equipes en lice a ce tour
	 */
	private Set<Equipe> equipeLice;
	
	/**
	 * L'ensemble des matchs a ce tour
	 */
	private Set<Match> tour;
	
	/**
	 * Le numero du tour
	 */
	private static int numTour;
	
	/**
	 * Le nombre de match a ce tour
	 */
	private int nbMatch;
	
	/**
	 * L'ensemble des heures de debut des matchs
	 */
	private Set<Calendar> heureDebut ;
	
	/**
	 * L'ensemble des arbitres
	 */
	private Set<Arbitre> arbitre;
	
	/**
	 * Le constructeur de la classe Tour
	 * Ici le TreeSet d'equioeLice n'a pas d'importance pour le tour initial car les equipes seront prises aleatoirement mais sera utile pour les tours suivant où les equipes seront prises dans l'ordre
	 * L'ensemble des heures de debut est trie car on prend les heures dans l'ordre.
	 * @param equipeLice L'ensemble des equipes en lice, allant former les matchs de ce tour
	 * @param numTour Le numero du tour cree
	 * @param tailleTournoi Le nombre d'equipe participant au tournoi (des le premier tour)
	 * @param date L'ensemble d'heure de debut des matchs du tour
	 * @param arbitre L'ensemble d'arbitre du tournoi
	 */
	public Tour(TreeSet<Equipe> equipeLice, int numTour, int tailleTournoi, TreeSet<Calendar> date, HashSet<Arbitre> arbitre){
		this.equipeLice = equipeLice;
		tour = new TreeSet<Match>();
		this.numTour = numTour;
		nbMatch = tailleTournoi/(2*numTour);
		heureDebut = date;
		this.arbitre = arbitre;
	}
	
	/**
	 * Permet de renvoyer, si possible, un arbitre impartial, ce qui veut dire, n'appartenant pas a un des deux clubs des equipes jouant le match.
	 * Si cela n'est pas possible, on prendra le dernier selectionne.
	 * @throws IllegalArgumentException Le tableau d'arbitre ne doit pas etre vide
	 * @param e1 La premiere equipe du match
	 * @param e2 La deuxieme equipe du match
	 * @return Retourne si possible un arbitre impartial, sinon le dernier selectionne
	 */
	public int arbitreImpartial(Equipe e1, Equipe e2){
		int tailleArbitre = arbitre.size();
		int numArbitre;
		int compt =0;
		Iterator<Arbitre> it = arbitre.iterator();
		Arbitre a = null;
		if(it.hasNext())
			 a = it.next();
		else throw new IllegalArgumentException("Aucun arbitre disponible");
		do{
			compt++;
			numArbitre = 1+(int)Math.random()*(tailleArbitre-1);
			for (int i = 1;it.hasNext() && i<numArbitre;i++)
			{
				a = it.next();	
			}
			}while(a.getClub().equals(e1.getClub()) && a.getClub().equals(e2.getClub()) && compt<tailleArbitre*2);
			//sort si l'arbitre n'est pas du meme club que l'une des equipes ou si on a cherche trop longtemps (pour eviter une boucle infinie)
		
		return numArbitre;
	}
	
	/**
	 * Methode principale de Tour permettant de creer le tour avec ses matchs.
	 * Si numTour = 1, on cree le tour initial en prenant au hasard les equipes pour former les matchs.
	 * Si numTour != 1, on se sert des gagnant du tour precedant pour former les matchs du tour.
	 * @throws IllegalArgumentException Le nombre d'equipe doit etre multiple de 2
	 */
	public void tour(){
		//System.out.println("coucou");
		Equipe e1 = null;
		Equipe e2 = null;
		Equipe test1 = null;
		Equipe test2 = null;
		int compt =0;
		Calendar c = null;
		//int numDate = 0;
						
		if(numTour == 1){ //tour initial
			int numEquipe1;
			int numEquipe2;
			int i =0;
			
			int numEquipe = 1;
			while(i!=equipeLice.size()){
				numEquipe1 = 1+(int)(Math.random()*(equipeLice.size()-1));
				Iterator<Equipe> it = equipeLice.iterator();
				//System.out.println(numEquipe1);
				for (int j = 0;it.hasNext() && j<numEquipe1;j++){
					e1 = it.next();
				}
				//System.out.println("e1 : "+e1);
				equipeLice.remove(e1);
				e1.setNumEquipe(numEquipe);
				numEquipe++;
				
				numEquipe2 = 1+(int)(Math.random()*(equipeLice.size()-1));
				Iterator<Equipe> it1 = equipeLice.iterator();
				for (int j = 0;it1.hasNext() && j<numEquipe2;j++){
					e2 = it1.next();
				}
				//System.out.println("e2 : "+e2);
				equipeLice.remove(e2);
				e2.setNumEquipe(numEquipe);
				numEquipe++;
				
				int numArbitre = arbitreImpartial(e1,e2);
				//System.out.println(numArbitre);
				Arbitre a = null;
				Iterator<Arbitre> it2 = arbitre.iterator();
				for (int j = 0;it2.hasNext() && j<numArbitre;j++){
					a = it2.next();
					//System.out.println("a1 : "+a);
				}
				
				Iterator<Calendar> it3 = heureDebut.iterator();
				if(it3.hasNext())
				//for(int k = 0;k<=numDate && it3.hasNext();k++){
					c = it3.next();
				//System.out.println(c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE) +" le "+ c.get(Calendar.DAY_OF_MONTH)+" "+ (c.get(Calendar.MONTH)+1)+" " + c.get(Calendar.YEAR)+"\n");
				heureDebut.remove(c);
				//}
				//numDate++;
				//System.out.println("BIJOUR " +new Match(e1,e2,a,c)+"\n\n");
				tour.add(new Match(e1,e2,a,c));	
				//System.out.println("je test "+tour);
			}
		}
		else{
			//System.out.println(equipeLice.size());
			Iterator<Equipe> it = equipeLice.iterator();
			while(it.hasNext()){
				if(compt != 0){
					e1 = test1;
				}
				else
					e1 = it.next();
				if(it.hasNext()){
					if(compt != 0){
						e2 = test1;
					}
					else
						e2=it.next();
				}
					
				else throw new IllegalArgumentException("Le nombre d'equipe doit etre multiple de 2");
				
				int numArbitre = arbitreImpartial(e1,e2);
				Arbitre a = null;
				Iterator<Arbitre> it2 = arbitre.iterator();
				for (int j = 0;it2.hasNext() && j<numArbitre;j++){
					a = it2.next();
				}
				
				Iterator<Calendar> it3 = heureDebut.iterator();
				//for(int k = 0;k<=numDate && it3.hasNext();k++){
				if(it3.hasNext())
					c = it3.next();
				heureDebut.remove(c);
				//}
				//numDate++;
				tour.add(new Match(e1,e2,a,c));	
				if(it.hasNext()){
					test1 = it.next();
					if(it.hasNext()){
						test2 = it.next();
					}
				}
				
				equipeLice.remove(e1);
				//System.out.println(equipeLice.size());
				equipeLice.remove(e2);
				//System.out.println(equipeLice.size());
				compt++;
				//System.out.println("je test "+tour);
			}
		}
	}
	
	/**
	 * Permet de lancer un match du tour, determinant aleatoirement le resultat (avec un maximum de 10 buts)
	 * @param numMatch Le numero du match que l'on veut lancer
	 * @throws IllegalArgumentException NumMatch doit etre inferieur ou egal au nombre de match
	 */
	public void lancerMatch(int numMatch){
		if(numMatch>nbMatch)
			throw new IllegalArgumentException("Le numero du match est invalide");
		int i =0;
		Match m = null;
		Joueur joueur =null;
		Iterator<Match> it = tour.iterator();
		while(it.hasNext() && i< numMatch){
			m = it.next();
			i++;
		}
		int nbBut = (int)(1+Math.random()*(10-1));
		for(int j = 0;j<nbBut;j++){
			int indexJoueur = (int)(1+Math.random()*(18-1));
			if(indexJoueur<=9){
				int index = 0;
				Iterator<Joueur> it1 = m.getEquipe1().getTitulaires().iterator();
				while(it1.hasNext() && index !=9 && index != indexJoueur){
					joueur = it1.next();
					index++;
				}
			}
				else{
					int index = 9;
					Iterator<Joueur> it1 = m.getEquipe2().getTitulaires().iterator();
					while(it1.hasNext() && index !=18 && index != indexJoueur){
						joueur = it1.next();
						index++;
				}
			}
			m.but(joueur);
		}
		m.finMatch();
	}
	
	/**
	 * Teste si le tour est fini, ce qui veut dire que tous les matchs de ce tour sont termines
	 * @return Retourne true si tous les matchs sont termines, sinon false
	 */
	public boolean tourFini(){
		Iterator<Match> it = tour.iterator();
		int compt = 0;
		while(it.hasNext()){
			Match m = it.next();
			if(m.isMatchFini())
				compt++;
		}
		if(compt == nbMatch)
			return true;
		return false;
	}
	
	
	/**
	 * getter de l'ensemble des matchs du tour
	 * @return Retourne l'ensemble des matchs de ce tours
	 */
	public Set<Match> getTour() {
		return tour;
	}

	/**
	 * getter du nombre de match de ce tour
	 * @return Retourne le nombre de match de ce tour
	 */
	public int getNbMatch() {
		return nbMatch;
	}
	
	/**
	 * getter de numero du tour
	 * @return Retourne le numero du tour
	 */
	public static int getNumTour() {
		return numTour;
	}

	/**
	 * Redefinition de la methode toString() pour Tour
	 * @return Retourne via une chaine de caractère l'etat du tour
	 */
	public String toString(){
		String s ="";
		int compt = 1;
		Iterator<Match> it = tour.iterator();
		while(it.hasNext()){
			Match m = it.next();
			//System.out.println(m);
			s+="Match n°"+compt +" : "+ m.toString()+"\n";
			compt++;
		}
		return s;
	}

	/**
	 * Redefinition de la methode compareTo() pour Tour, comparant le numero du tour
	 * @param o Le tour a comparer avec le tour actuel
	 * @return Retourne -1 si lle numero du tour actuel est inferieur a celui donne en parametre, 0 s'il est egal, ou positif s'il est superieur
	 */
	public int compareTo(Tour o) {
		if(this.numTour>o.numTour)
			return 1;
		if(this.numTour<o.numTour)
			return -1;
		return 1;
	}
	
}
