package projet;
import java.util.*;

/**
 * Classe créant le tournoi
 * @author RENAULT Alexis
 * @author LEVEQUE Quentin
 * 
 */

public class Tournoi {
	int nbEquipe;
	int nbTours=0;
	int tourActuel =1;
	Set<Equipe> equipes;
	TreeSet<Calendar> date;
	HashSet<Arbitre> arbitres;
	Set<Tour> tours;
	
	
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
	
	public TreeSet<Equipe> equipesEnLice(){
		TreeSet<Equipe> enLice = new TreeSet<Equipe>();
		Iterator<Equipe> it = equipes.iterator();
		while(it.hasNext()){
			Equipe e = it.next();
			if(e.isEnLice())
				enLice.add(e);
		}
		return enLice;
	}
	
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
		else{
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
				
		//public Tour(TreeSet<Equipe> equipeLice, int numTour, int tailleTournoi, TreeSet<Calendar> date, HashSet<Arbitre> arbitre){
	}
	
	public void lanceMatch(int numMatch){
		int i=0;
		Tour t = null;
		Iterator<Tour> it = tours.iterator();
		while(it.hasNext() && i<tourActuel){
			t = it.next();
			i++;
		}
		t.lancerMatch(numMatch);
	}
	
	public String toString(){
		String s = "";
		Iterator<Tour> it = tours.iterator();
		while(it.hasNext()){
			Tour t = it.next();
			//System.out.println("tailleS : " + tours.size());
			s+="Tour n°"+t.getNumTour()+" "+t.toString()+"\n";
			//System.out.println(t);
		}
		return s;
	}
}
