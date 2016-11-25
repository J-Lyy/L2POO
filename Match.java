package projet;
import java.util.Calendar;

public class Match {
	
	/*	On peut remplacer 2 joueurs, marquer un but, donner le score actuel
	 * 
	 */
	//Attributs
	private Equipe equipe1 ;
	private Equipe equipe2 ;
	private Arbitre arbitre ;
	private Calendar heureDebut ;
	private int scoreEquipe1 ;
	private int scoreEquipe2 ;
	
	//Constructeurs
	public Match(Equipe e1, Equipe e2, Arbitre a, Calendar hD) {
		// Mettre un arbitre impartial
		equipe1 = e1;
		equipe1.etatInitialEquipe(); // Met en jeu les titulaires et sur le banc les remplacants
		equipe2 = e2;
		equipe2.etatInitialEquipe(); // Idem equipe 2
		arbitre = a;
		heureDebut = hD;
		scoreEquipe1 = 0;
		scoreEquipe2 = 0;
		
	}
	
	//Get and Set
	public Arbitre getArbitre() {
		return arbitre;
	}

	public void setArbitre(Arbitre a) {
		arbitre = a;
	}

	public Calendar getHeureDebut() {
		return heureDebut;
	}


	public int getScoreEquipe1() {
		return scoreEquipe1;
	}


	public int getScoreEquipe2() {
		return scoreEquipe2;
	}
	
	//toString
	
	public String toString(){
		return ("Ce match oppose l'équipe de " + equipe1.getClub() + " contre l'équipe de " + equipe2.getClub() +"\nLe match commence à : " + heureDebut.toString() + " et est arbitre par " + arbitre.toString() + " " + score()  );
	}
	
	public void but(Joueur j) {
		if(equipe1.estDansEquipe(j)){
			if (j.isEnJeu()){
				System.out.println("Oui oui");
				addScore1();
				System.out.println("But de " + j.getNom());
				System.out.println(score());
			} else {
				throw new IllegalArgumentException("Le joueur n'est pas en jeu.");
			}
		}
		else if(equipe2.estDansEquipe(j)){
			if (j.isEnJeu()){
				System.out.println("Non non");
				addScore2();
				System.out.println("But de " + j.getNom());
				System.out.println(score());
			}else 
				throw new IllegalArgumentException("Le joueur n'est pas en jeu.");
		}
		else
			throw new IllegalArgumentException("Le joueur n'est dans aucune des 2 équipes.");
			
	}
	
	public void remplacement(Joueur j1, Joueur j2) {
		if(j1.isEnJeu() && !j2.isEnJeu()){
			j1.setEnJeu(false);
			j2.setEnJeu(true);
		}else if(!j1.isEnJeu() && j2.isEnJeu()){
			j1.setEnJeu(true);
			j2.setEnJeu(false);
		}
		else throw new IllegalArgumentException("Les 2 joueurs sont tous les 2 en jeu ou hors jeu.");
	}
		
	/*public void debutMatch(){
		System.out.println("Le match a commencé !");
	}*/
	
	public String score(){
		return ("Score : \n" + equipe1.getClub() + " : " + scoreEquipe1 + " - " + scoreEquipe2 + " : " + equipe2.getClub());
	}
	public int addScore1(){
		return scoreEquipe1 ++;
	}
	public int addScore2(){
		return scoreEquipe2 ++;
	}

	public void finMatch() {
		equipe1.etatInitialEquipe();
		equipe2.etatInitialEquipe();
		System.out.println(score());
	}
	
}


