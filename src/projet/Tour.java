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
	private Set<Equipe> equipeLice;
	private Set<Match> tour;
	private static int numTour;
	private int nbMatch;
	private Set<Calendar> heureDebut ;
	private Set<Arbitre> arbitre;
	
	public Tour(TreeSet<Equipe> equipeLice, int numTour, int tailleTournoi, TreeSet<Calendar> date, HashSet<Arbitre> arbitre){
		this.equipeLice = equipeLice;
		tour = new TreeSet<Match>();
		this.numTour = numTour;
		nbMatch = tailleTournoi/(2*numTour);
		heureDebut = date;
		this.arbitre = arbitre;
	}
	
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
	
	
	public void tour(){
		Equipe e1 = null;
		Equipe e2 = null;
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
				tour.add(new Match(e1,e2,a,c));	
				//System.out.println(tour);
			}
		}
		else{
			Iterator<Equipe> it = equipeLice.iterator();
			while(it.hasNext()){
				e1 = it.next();
				if(it.hasNext())
					e2=it.next();
				else throw new IllegalArgumentException("Nombre d'equipe impair");
				
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
				
				
			}
		}
	}
	
	public void lancerMatch(int numMatch){
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
		m.setMatchFini(true);
	}
	
	
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

	
	public int compareTo(Tour o) {
		if(this.numTour>o.numTour)
			return 1;
		if(this.numTour<o.numTour)
			return -1;
		return 0;
	}

	public static int getNumTour() {
		return numTour;
	}
	
}
