package projet;
import java.util.Calendar;

/**
 * Classe creant les matchs
 * @author RENAULT Alexis
 * @author LEVEQUE Quentin
 * 
 */

public class Match implements Comparable<Match> {
	
	/*	On peut remplacer 2 joueurs, marquer un but, donner le score actuel
	 * 
	 */
	//Attributs
	/**
	 * La premiere equipe du match
	 */
	private Equipe equipe1 ;
	
	/**
	 * La deuxieme equipe du match
	 */
	private Equipe equipe2 ;
	
	/**
	 * L'arbitre du match
	 */
	private Arbitre arbitre ;
	
	/**
	 * L'heure de debut du match
	 */
	private Calendar heureDebut ;
	
	/**
	 * Le score de l'equipe 1
	 */
	private int scoreEquipe1 ;
	
	/**
	 * Le score de l'equipe 2
	 */
	private int scoreEquipe2 ;
	
	/**
	 * Etat du match pour savoir si le match est fini ou non
	 * true : le match est fini |
	 * false : le match n'est pas fini ou pas commence. Un match est donc initialise a false
	 */
	private boolean matchFini = false;
	
	//Constructeurs
	/**
	 * Constructeur de la classe Match
	 * @param e1 La premiere equipe du match
	 * @param e2 La deuxieme equipe du match
	 * @param a L'arbitre du match
	 * @param hD L'heure de debut du match
	 */
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
	/**
	 * getter de l'arbitre du match
	 * @return Retourne l'arbitre du match
	 */
	public Arbitre getArbitre() {
		return arbitre;
	}

	/**
	 * setter de l'arbitre du match
	 * @param a Le nouvel arbitre du match
	 */
	public void setArbitre(Arbitre a) {
		arbitre = a;
	}

	/**
	 * getter de l'heure du debut du match
	 * @return Retourne l'heure de debut du match
	 */
	public Calendar getHeureDebut() {
		return heureDebut;
	}

	/**
	 * getter du score de l'equipe 1 du match
	 * @return Retourne le score de l'equipe 1 du match
	 */
	public int getScoreEquipe1() {
		return scoreEquipe1;
	}

	/**
	 * getter du score de l'equipe 2 du match
	 * @return Retourne le score de l'equipe 2 du match
	 */
	public int getScoreEquipe2() {
		return scoreEquipe2;
	}
	
	/**
	 * Test pour savoir si le match est fini
	 * @return Retourne vrai si le match est fini, false sinon
	 */
	public boolean isMatchFini() {
		return matchFini;
	}

	/**
	 * setter de MatchFini
	 * @param matchFini Vrai si l'on veut finir le match, false sinon
	 */
	public void setMatchFini(boolean matchFini) {
		this.matchFini = matchFini;
	}

	/**
	 * getter de l'equipe 1 du match
	 * @return Retourne l'equipe 1 du match
	 */
	public Equipe getEquipe1() {
		return equipe1;
	}

	/**
	 * getter de l'equipe 2 du match
	 * @return Retourne l'equipe 2 du match
	 */
	public Equipe getEquipe2() {
		return equipe2;
	}
	
	//toString
	/**
	 * Redefinition de la methode toString() pour Match
	 * @return Retourne via une chaine de caractère l'etat du match
	 */
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
			gagnant ="L'equipe du club "+ equipe2.getClub().getNom() +" de "+equipe2.getClub().getVille()+" a gagné le match";
		}
		else
			gagnant = "Les deux equipes ont fini ex aeco";
			
		return "Ce match oppose l'équipe de " + equipe1.getClub() + " contre l'équipe de " + equipe2.getClub() +"\nLe match commence à : "+ heureDebut.get(Calendar.HOUR_OF_DAY)+":"+heureDebut.get(Calendar.MINUTE) +" le "+ heureDebut.get(Calendar.DAY_OF_MONTH)+" "+ (heureDebut.get(Calendar.MONTH)+1)+" " + heureDebut.get(Calendar.YEAR) + " et est arbitre par " + arbitre.getNom() + " " +arbitre.getPrenom()+" du club "+ arbitre.getClub()+"\n"+ score()+"\nLe match "+s+"\n"+gagnant+"\n";
	}
	
	/**
	 * Permet de faire maquer un joueur d'une des deux equipes.
	 * Le joueur doit etre dans l'une des deux equipes !
	 * Le joueur doit etre en jeu !
	 * @param j Le joueur qui a marque
	 * @throws IllegalArgumentException Le joueur n'est pas en jeu.
	 * @throws IllegalArgumentException Le joueur n'est dans aucune des 2 équipes.
	 */
	public void but(Joueur j) {
		//if(equipe1.estDansEquipe(j)){
		if(equipe1.getClub().equals(j.getClub())){
			if (j.isEnJeu()){
				//System.out.println("Oui oui");
				scoreEquipe1 ++;
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
				scoreEquipe2 ++;
				//System.out.println("But de " + j.getNom());
				//System.out.println(score());
			}else {
				throw new IllegalArgumentException("Le joueur n'est pas en jeu.");
			}
		}
		else
			throw new IllegalArgumentException("Le joueur n'est dans aucune des 2 équipes.");
			
	}
	
	/**
	 * Permet le remplacement d'un joueur en jeu par un joueur sur le banc
	 * Les deux joueurs ne doivent pas etre soit en meme temps sur le terrain soit sur le banc !
	 * @param j1 Le premier joueur que l'on veut remplacer ou remplacant
	 * @param j2 Le deuxieme joueur que l'on veut remplacer ou remplacant
	 * @throws IllegalArgumentException Les 2 joueurs sont tous les 2 en jeu ou hors jeu.
	 */
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
	
	/**
	 * Permet de renvoyer le score sous forme d'une chaine de caractere (utilise dans toString())
	 * @return Retourne le score sous forme d'une chaine de caractere
	 */
	public String score(){
		return ("Score : \n" + equipe1.getClub() + " : " + scoreEquipe1 + " - " + scoreEquipe2 + " : " + equipe2.getClub());
	}


	/**
	 * Met fin au match en  remettant tous les titulaires en jeu et les remplacant sur le banc et et matchFini a true
	 */
	public void finMatch() {
		equipe1.etatInitialEquipe();
		equipe2.etatInitialEquipe();
		System.out.println(score());
		matchFini = true;
	}
	
	/**
	 * Permet de renvoyer le numero de l'equipe gagnante :
	 * 1 si l'equipe 1 a gagne,
	 * 2 si l'equipe 2 a gagne,
	 * 0 si les deux equipe ont fini ex aequo
	 * @return Retourne le numero de l'equipe gagnante
	 */
	public int getGagnant(){
		if(scoreEquipe1 > scoreEquipe2){
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

	/**
	 * Redefinition de la methode compareTo() pour Match, comparant le numero du match
	 * @param arg0 Le match a comparer avec l'equipe actuelle
	 * @return Retourne un nombre negatif si la date de debut du match actuelle est inferieur a celui donne en parametre, 0 s'il est egal, ou positif s'il est superieur
	 */
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


