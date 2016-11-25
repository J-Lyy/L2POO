package projet;

public class Match {
	//Attributs
	private Equipe equipe1 ;
	private Equipe equipe2 ;
	private Arbitre arbitre ;
	//private Heure heureDebut ;
	private int scoreEquipe1 ;
	private int scoreEquipe2 ;
	
	//Constructeurs
	public Match(Equipe e1, Equipe e2, Arbitre a, int se1, int se2) {
		equipe1 = e1;
		equipe2 = e2;
		arbitre = a;
		scoreEquipe1 = se1;
		scoreEquipe2 = se2;
		
	}
	public int addScore1(){
		return 0;
	}
	public int addScore2(){
		return 0;
	}
}


/*
Créer une classe Matchpour simuler un match.  
Un  match   est  caractérisé  par  deux équipes,
un  arbitre, une heure   de  début et  le score  de chaque équipe
*/