package projet;
import java.util.Calendar;

/**
 * Classe créant les matchs
 * @author RENAULT Alexis
 * @author LEVEQUE Quentin
 * 
 */

public class Match implements Comparable<Match> {
	
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
	private boolean matchFini = false;
	
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
	
	public boolean isMatchFini() {
		return matchFini;
	}

	public void setMatchFini(boolean matchFini) {
		this.matchFini = matchFini;
	}

	public Equipe getEquipe1() {
		return equipe1;
	}

	public Equipe getEquipe2() {
		return equipe2;
	}
	
	//toString

	public String toString(){
		String s="";
		String gagnant ="";
		if(isMatchFini()){
			s = "est fini";
		}
		else{
			s = "n'est pas fini";
		}
		if(getGagnant() == 1){
			gagnant ="L'equipe du club "+ equipe1.getClub().getNom() +" de "+equipe1.getClub().getVille()+" a gagné le match";
		}
		else if(getGagnant() == 2){
			gagnant ="L'equipe du club "+ equipe2.getClub().getNom() +" de "+equipe1.getClub().getVille()+" a gagné le match";
		}
		else
			gagnant = "Les deux equipes ont fini ex aeco";
			
		return "Ce match oppose l'équipe de " + equipe1.getClub() + " contre l'équipe de " + equipe2.getClub() +"\nLe match commence à : "+ heureDebut.get(Calendar.HOUR_OF_DAY)+":"+heureDebut.get(Calendar.MINUTE) +" le "+ heureDebut.get(Calendar.DAY_OF_MONTH)+" "+ (heureDebut.get(Calendar.MONTH)+1)+" " + heureDebut.get(Calendar.YEAR) + " et est arbitre par " + arbitre.getNom() + " " +arbitre.getPrenom()+" du club "+ arbitre.getClub()+"\n"+ score()+"\nLe match "+s+"\n"+gagnant+"\n";
	}
	
	public void but(Joueur j) {
		//if(equipe1.estDansEquipe(j)){
		if(equipe1.getClub().equals(j.getClub())){
			if (j.isEnJeu()){
				//System.out.println("Oui oui");
				addScore1();
				//System.out.println("But de " + j.getNom());
				//System.out.println(score());
			} else {
				throw new IllegalArgumentException("Le joueur n'est pas en jeu.");
			}
		}
		else if(equipe2.getClub().equals(j.getClub())){
		//else if(equipe2.estDansEquipe(j)){
			if (j.isEnJeu()){
				//System.out.println("Non non");
				addScore2();
				//System.out.println("But de " + j.getNom());
				//System.out.println(score());
			}else {
				throw new IllegalArgumentException("Le joueur n'est pas en jeu.");
			}
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
		matchFini = true;
	}
	
	public int getGagnant(){
		if(scoreEquipe1 >= scoreEquipe2){
			equipe2.setEnLice(false);
			equipe1.setVictoire(equipe1.getVictoire()+1);
			equipe2.setDefaite(equipe2.getDefaite()+1);
			return 1; //si equipe 1 gagne
			//return equipe1.getClub().getNom();
		}
			
		else{
			equipe1.setEnLice(false);
			equipe2.setVictoire(equipe2.getVictoire()+1);
			equipe1.setDefaite(equipe1.getDefaite()+1);
			return 2; // si equipe 2 gagne
			//return equipe2.getClub().getNom();
		}
			
		/*else
			return 0; // si match nul
			//return "Match null";*/
	}

	
	public int compareTo(Match arg0) {
		int x = this.heureDebut.get(Calendar.YEAR)-arg0.heureDebut.get(Calendar.YEAR);
		if(x == 0){
			x = this.heureDebut.get(Calendar.MONTH)-arg0.heureDebut.get(Calendar.MONTH);
			if(x == 0)
				x = this.heureDebut.get(Calendar.DAY_OF_MONTH)-arg0.heureDebut.get(Calendar.DAY_OF_MONTH);
				if(x == 0)
					x = this.heureDebut.get(Calendar.HOUR_OF_DAY)-arg0.heureDebut.get(Calendar.HOUR_OF_DAY);
					if(x == 0)
						x = this.heureDebut.get(Calendar.MINUTE)-arg0.heureDebut.get(Calendar.MINUTE);
		
		}
			
						
		return x;
				
	}
	
}


