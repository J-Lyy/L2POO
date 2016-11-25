package projet;

import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
		
		
		//Truc à mettre 
		Calendar today = Calendar.getInstance();
		
		


		
		//Creation de la premiere equipe :
		Club club = new Club("sport","Orleans");
		//Club club1 = new Club("yolo","Strasbourg");
		Entraineur ent = new Entraineur(101,"u","v",Calendar.getInstance(),club,3);
		Equipe e = new Equipe(club,ent);
		Joueur j1 = new Joueur(101,"Jean","David",Calendar.getInstance(),club,"attaquant",1);
		Joueur j2 = new Joueur(111,"a","k",Calendar.getInstance(),club,"attaquant",2);
		Joueur j3 = new Joueur(121,"b","l",Calendar.getInstance(),club,"attaquant",3);
		Joueur j4 = new Joueur(131,"c","m",Calendar.getInstance(),club,"attaquant",4);
		Joueur j5 = new Joueur(141,"d","n",Calendar.getInstance(),club,"defenseur",5);
		Joueur j6 = new Joueur(151,"e","o",Calendar.getInstance(),club,"defenseur",6);
		Joueur j7 = new Joueur(161,"f","p",Calendar.getInstance(),club,"defenseur",7);
		Joueur j8 = new Joueur(171,"g","q",Calendar.getInstance(),club,"defenseur",8);
		Joueur j9 = new Joueur(181,"h","r",Calendar.getInstance(),club,"attaquant",9);
		Joueur j10 = new Joueur(191,"i","s",Calendar.getInstance(),club,"gardien",10);
		Joueur j11= new Joueur(102,"j","t",Calendar.getInstance(),club,"defenseur",11);
		Joueur j12= new Joueur(112,"u","v",Calendar.getInstance(),club,"gardien",12);
		
		//Joueur j13= new Joueur(113,"z","y",Calendar.getInstance(),club1,"gardien",13);

		//Ajout des joueurs
		e.ajouterJoueur(j1);
		e.ajouterJoueur(j2);
		e.ajouterJoueur(j3);
		e.ajouterJoueur(j4);
		e.ajouterJoueur(j5);
		e.ajouterJoueur(j6);
		e.ajouterJoueur(j7);
		e.ajouterJoueur(j8);
		e.ajouterJoueur(j9);
		e.ajouterJoueur(j10);
		e.ajouterJoueur(j11);
		e.ajouterJoueur(j12);
		//e.ajouterJoueur(j13);
		//System.out.println(e.toString());
		
		if(e.equipeValide())
			System.out.println("equipe valide");
		else
			System.out.println("equipe non valide");
		
		
		
		//Creation de la deuxieme equipe
		Club club2 = new Club("arar","Orlearrraans");
		//Club club1 = new Club("yolo","Strasbourg");
		Entraineur entraineur2 = new Entraineur(201,"uu","nv",Calendar.getInstance(),club2,3);
		Equipe jjj = new Equipe(club2,entraineur2);
		Joueur jj1 = new Joueur(201,"Jeaaan","Darrvid",Calendar.getInstance(),club2,"attaquant",1);
		Joueur jj2 = new Joueur(211,"azz","ka",Calendar.getInstance(),club2,"attaquant",2);
		Joueur jj3 = new Joueur(221,"bzz","la",Calendar.getInstance(),club2,"attaquant",3);
		Joueur jj4 = new Joueur(231,"czz","ma",Calendar.getInstance(),club2,"attaquant",4);
		Joueur jj5 = new Joueur(241,"zzd","an",Calendar.getInstance(),club2,"defenseur",5);
		Joueur jj6 = new Joueur(251,"ezz","oa",Calendar.getInstance(),club2,"defenseur",6);
		Joueur jj7 = new Joueur(261,"zzf","pa",Calendar.getInstance(),club2,"defenseur",7);
		Joueur jj8 = new Joueur(271,"zzg","qa",Calendar.getInstance(),club2,"defenseur",8);
		Joueur jj9 = new Joueur(281,"zhz","ra",Calendar.getInstance(),club2,"attaquant",9);
		Joueur jj10 = new Joueur(291,"ziz","sa",Calendar.getInstance(),club2,"gardien",10);
		Joueur jj11= new Joueur(202,"jzz","taa",Calendar.getInstance(),club2,"defenseur",11);
		Joueur jj12= new Joueur(212,"uzz","aav",Calendar.getInstance(),club2,"gardien",12);
		
		//Joueur j13= new Joueur(113,"z","y",Calendar.getInstance(),club1,"gardien",13);

		//Ajout des joueurs
		jjj.ajouterJoueur(jj1);
		jjj.ajouterJoueur(jj2);
		jjj.ajouterJoueur(jj3);
		jjj.ajouterJoueur(jj4);
		jjj.ajouterJoueur(jj5);
		jjj.ajouterJoueur(jj6);
		jjj.ajouterJoueur(jj7);
		jjj.ajouterJoueur(jj8);
		jjj.ajouterJoueur(jj9);
		jjj.ajouterJoueur(jj10);
		jjj.ajouterJoueur(jj11);
		jjj.ajouterJoueur(jj12);
		
		
		
		Arbitre arbitro = new Arbitre(51, "arar", " araraez", today, club, 1 );
		Match arar = new Match(e,jjj, arbitro,today);
		arar.but(jj2);
		arar.but(j2);
		arar.toString();

	}

}
