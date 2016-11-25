package projet;

import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
		
		Club club = new Club("sport","Orléans");
		//Club club1 = new Club("yolo","Strasbourg");
		Equipe e = new Equipe(club);
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
		Entraineur ent = new Entraineur(101,"u","v",Calendar.getInstance(),club,3);
		//Joueur j13= new Joueur(113,"z","y",Calendar.getInstance(),club1,"gardien",13);

		
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
		e.ajouterEntraineur(ent);
		//e.ajouterJoueur(j13);
		System.out.println(e.toString());
		
		if(e.equipeValide())
			System.out.println("équipe valide");
		else
			System.out.println("équipe non valide");

	}

}
