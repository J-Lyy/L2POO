package projet;
import java.util.*;

/**
 * Classe créant le tournoi
 * @author RENAULT Alexis
 * @author LEVEQUE Quentin
 * 
 */

public class Tournoi {
	/**
	 * Le nombre d'equipes participantes au tournoi (la taille du tournoi)
	 */
	int nbEquipe;
	
	/**
	 * Le nombre de tour du tournoi
	 */
	int nbTours=0;
	
	/**
	 * Le numero du tour actuel, initialise a 1 pour le tour initial
	 */
	int tourActuel =1;
	
	/**
	 * L'ensemble des equipes du tournoi
	 */
	TreeSet<Equipe> equipes;
	
	/**
	 * L'ensemble des heures de debut des matchs du tournoi
	 */
	TreeSet<Calendar> date;
	
	/**
	 * L'ensemble des arbitres du tournoi
	 */
	HashSet<Arbitre> arbitres;
	
	/**
	 * L'ensemble des tours du tournoi
	 */
	Set<Tour> tours;
	
	/**
	 * Le constructeur de la classe Tournoi
	 * @param equipes L'ensemble des equipes du tournoi cree
	 * @param date L'ensemble des heures de debut des matchs du tournoi cree
	 * @param arbitre L'ensemble des arbitres du tournoi cree
	 */
	public Tournoi(TreeSet<Equipe>equipes, TreeSet<Calendar> date, HashSet<Arbitre> arbitre){
		double test  = equipes.size();
		while(test > 1){
			test=test/2; 
			nbTours++;
		}
		if(test != 1)
			throw new IllegalArgumentException("Le nombre d'equipe n'est pas un multiple de 2");
		//System.out.println(date.size());
		//System.out.println(equipes.size());
		if(date.size() < equipes.size()-1)
			throw new IllegalArgumentException("Nombre de dates incompatible");
		nbEquipe = equipes.size();
		this.equipes = equipes;
		this.date = date;
		this.arbitres = arbitre;	
		tours = new TreeSet<Tour>();
	}
	
	/**
	 * Permet de verifier si les equipes du tournoi sont toujours en lice ou non.
	 * Cree un nouvel ensemble avec uniquement les equipes encore en lice (ne modifie rien pour le tour initial) pour former l'ensemble d'equipe du tour suivant.
	 * Etant un TreeSet, les equipes seront directement dans le bon ordre pour les matchs du tour suivant.
	 * @return Retourne l'ensemble des equipes encore en lice
	 */
	public TreeSet<Equipe> equipesEnLice(){
		TreeSet<Equipe> enLice = new TreeSet<Equipe>();
		Iterator<Equipe> it = equipes.iterator();
		while(it.hasNext()){
			Equipe e = it.next();
			//System.out.println(e.isEnLice());
			if(e.isEnLice())
				enLice.add(e);
		}
		//System.out.println();
		return enLice;
	}
	
	/**
	 * Permet de creer un tour. 
	 * Si tourActuel = 1, on cree le tour initial
	 * Si tourActuel != 1, on cree le tour suivant en se servant du tour precedant.
	 * @throws IllegalArgumentException On ne peut appeler la fonction que si le tour precedant est fini, donc que tous les matchs du tour precedant sont termines.
	 * @throws IllegalArgumentException One ne peut pas appeler cette fonctione si le tournoi est deja termine
	 */
	public void tour(){
		if(tourActuel == 1){
			//System.out.println("bijour1 " +equipesEnLice().size());
			Tour tourInitial =new Tour(equipesEnLice(),tourActuel,nbEquipe,date,arbitres);
			tourInitial.tour();
			tours.add(tourInitial);
			//System.out.println("taille1 : " + tours.size());
			tourActuel++;
			//System.out.println(tourInitial);
		}
		else if(tourActuel<=nbTours){
			Iterator<Tour> it = tours.iterator();
			Tour t = null;
			while(it.hasNext()){
				 t = it.next();
				// System.out.println("tour t "+t.toString());
				 //System.out.println("\n\n\n"+t.getNumTour()+"\n\n\n");
			}
			if(t.tourFini()){
				//System.out.println(nbEquipe);
				//System.out.println("taille2.0 : " + tours.size());
				//System.out.println("bijour2 " +equipesEnLice().size());
				Tour tourSuivant = new Tour(equipesEnLice(),tourActuel,nbEquipe,date,arbitres);
				tourSuivant.tour();
				//System.out.println("\n\n\n"+tourSuivant.getNumTour()+"\n\n\n");
				tours.add(tourSuivant);
				//System.out.println("tour suivant : "+tourSuivant+"\n\n");
				//System.out.println("taille2 : " + tours.size());
				//System.out.println(tours.toString());
				tourActuel++;
			}
			else
				throw new IllegalArgumentException("Le tour n'est pas fini");
		}
		else
			throw new IllegalArgumentException("Le tournoi est termine");
				
		//public Tour(TreeSet<Equipe> equipeLice, int numTour, int tailleTournoi, TreeSet<Calendar> date, HashSet<Arbitre> arbitre){
	}
	
	/**
	 * Lance le match dont le numero est donne en parametre
	 * @param numMatch Le numero du match a lancer
	 * @throws IllegalArgumentException Le numero du match donne en parametre doit etre inferieur ou egal au nombre de match du tour et superieur a 0
	 */
	public void lanceMatch(int numMatch){
		int i=0;
		Tour t = null;
		Iterator<Tour> it = tours.iterator();
		while(it.hasNext() && i<tourActuel){
			t = it.next();
			i++;
		}
		if(numMatch<0 || t.getNbMatch()<numMatch)
			throw new IllegalArgumentException("Le numero du match est invalide");
		t.lancerMatch(numMatch);
	}
	
	/**
	 * Recherche une rencontre entre deux equipes
	 * @param e1 La premiere equipe de la rencontre
	 * @param e2 La deuxieme equipe de la rencontre
	 * @return Retourne le match s'il existe, sinon retourne null
	 */
	public Match rechercherRencontre(Equipe e1, Equipe e2){
		Iterator<Tour> it = tours.iterator();
		while(it.hasNext()){
			Tour t = it.next();
			Iterator<Match> it1 = t.getTour().iterator();
			while(it1.hasNext()){
				Match m = it1.next();
				if((m.getEquipe1().equals(e1) && m.getEquipe2().equals(e2)) || (m.getEquipe2().equals(e1) && m.getEquipe1().equals(e2)))
					return m;
			}
		}
		return null;
	}
	
	/**
	 * Donne le gagnant du tournoi
	 * @return Retourne l'equipe gagnante du tournoi 
	 */
	public Equipe gagnantTournoi(){
		Iterator<Tour> it = tours.iterator();
		Tour t = null;
		Match m = null;
		while(it.hasNext()){
			t = it.next();
		}
		/*if(tourActuel == nbTours){*/if(t.getNbMatch() == 1){
			Iterator<Match> it1 = t.getTour().iterator();
			while(it1.hasNext()){
				m = it1.next();
				//System.out.println("YOLO"+m);
			}
			
			if(m.isMatchFini()){
				if(m.getGagnant() == 1)
					return m.getEquipe1();
				else if(m.getGagnant() == 2)
					return m.getEquipe2();
			}
			else
				throw new IllegalArgumentException("Le dernier tour n'est pas fini");	
		}
		else
			throw new IllegalArgumentException("Le tournoi n'est pas fini");
		return null;	
	}
	
	public ArrayList<Joueur> troisMeilleusrButteurs(){
		int compt = 0;
		Joueur test = null;
		Joueur j = null;
		Joueur j1 = null;
		HashSet<Joueur> lesJoueurs = new HashSet<Joueur>();
		
		Iterator<Equipe> it1 = equipes.iterator();
		while(it1.hasNext()){
			Equipe e = it1.next();
			Iterator<Joueur> it2 = e.getTitulaires().iterator();
			while(it2.hasNext()){
				j = it2.next();
				lesJoueurs.add(j);
			}
			Iterator<Joueur> it3 = e.getRemplacant().iterator();
			while(it3.hasNext()){
				j = it3.next();
				lesJoueurs.add(j);
			}
		}	
		ArrayList<Joueur> troisMB= new ArrayList<Joueur>();
		for(int i=0;i<3;i++){
			Iterator<Joueur> it4 = lesJoueurs.iterator();
			while(it4.hasNext()){
				if(compt == 0){
					test = it4.next();
					j1 = test;
				}
				else{
					j1 = it4.next();
					if(j1.getNbBut()>test.getNbBut())
						test = j1;
				}
				compt++;
			}
			compt = 0;
			troisMB.add(test);
			lesJoueurs.remove(test);
			}
		return troisMB;
		
	}
	
	/**
	 * Redefinition de la methode toString() pour Tournoi
	 * @return Retourne via une chaine de caractère l'etat du tournoi
	 */
	public String toString(){
		String gagnant ="";
		Equipe e = gagnantTournoi();
		if(!e.equals(null))
			gagnant = "L'equipe gagnante du tournoi est l'equipe du club : "+e.getClub().getNom()+" de "+ e.getClub().getVille()+"\n";
		String s = "";
		Iterator<Tour> it = tours.iterator();
		int compt = 1;
		while(it.hasNext()){
			Tour t = it.next();
			//System.out.println("tailleS : " + tours.size());
			s+="Tour n°"+compt+" "+t.toString();
			//System.out.println(t);
			compt++;
		}
		s+=gagnant;
		return s;
	}
}
