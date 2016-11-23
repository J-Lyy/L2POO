package projet;

import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
		
		Club club = new Club("sport","Orléans");
		Equipe e = new Equipe();
		Joueur j1 = new Joueur(101,"Jean","David",Calendar.getInstance(),club,"titulaire",1);
		Joueur j2 = new Joueur(111,"a","k",Calendar.getInstance(),club,"titulaire",2);
		Joueur j3 = new Joueur(121,"b","l",Calendar.getInstance(),club,"titulaire",3);
		Joueur j4 = new Joueur(131,"c","m",Calendar.getInstance(),club,"titulaire",4);
		Joueur j5 = new Joueur(141,"d","n",Calendar.getInstance(),club,"titulaire",5);
		Joueur j6 = new Joueur(151,"e","o",Calendar.getInstance(),club,"titulaire",6);
		Joueur j7 = new Joueur(161,"f","p",Calendar.getInstance(),club,"titulaire",7);
		Joueur j8 = new Joueur(171,"g","q",Calendar.getInstance(),club,"titulaire",8);
		Joueur j9 = new Joueur(181,"h","r",Calendar.getInstance(),club,"titulaire",9);
		Joueur j10 = new Joueur(191,"i","s",Calendar.getInstance(),club,"titulaire",10);
		Joueur j11= new Joueur(102,"j","t",Calendar.getInstance(),club,"remplaçant",11);
		Joueur j12= new Joueur(112,"u","v",Calendar.getInstance(),club,"gardien",12);
		Entraineur ent = new Entraineur(101,"u","v",Calendar.getInstance(),club,3);
		
		e.ajouterJoueur(j1);
		e.ajouterJoueur(j2);
		e.ajouterJoueur(j3);
		e.ajouterJoueur(j4);
		e.ajouterJoueur(j5);
		e.ajouterJoueur(j6);
		e.ajouterJoueur(j7);
		e.ajouterJoueur(j8);
		e.ajouterJoueur(j9);
		//e.ajouterJoueur(j10);
		e.ajouterJoueur(j11);
		e.ajouterJoueur(j12);
		e.ajouterEntraineur(ent);
		System.out.println(e.toString());
		
		if(e.equipeValide())
			System.out.println("équipe valide");
		else
			System.out.println("équipe non valide");

	}

}
