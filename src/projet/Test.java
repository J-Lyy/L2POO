package projet;

import java.util.Calendar;
import java.util.*;

/**
 * Classe test
 * @author RENAULT Alexis
 * @author LEVEQUE Quentin
 * 
 */

public class Test {

	public static void main(String[] args) {
		
		
		//Truc à mettre 
		Calendar today = Calendar.getInstance();
		Calendar d = new GregorianCalendar(2016,11,29);
		d.set(Calendar.HOUR_OF_DAY, 18);
		d.set(Calendar.MINUTE, 10);
		
		Calendar d1 = new GregorianCalendar(2017,0,5);
		d1.set(Calendar.HOUR_OF_DAY, 10);
		d1.set(Calendar.MINUTE, 30);
		
		Calendar d2 = new GregorianCalendar(2017,0,10);
		d2.set(Calendar.HOUR_OF_DAY, 15);
		d2.set(Calendar.MINUTE, 30);
		/*Calendar cal = Calendar.getInstance();
		cal.setTime(date.getTime();
		cal.add(Calendar.DAY_OF_MONTH, nbJour);*/


		
		//Creation de la premiere equipe :
		Club club = new Club("sport","Orleans");
		//Club club1 = new Club("yolo","Strasbourg");
		Entraineur ent = new Entraineur(101,"u","v",Calendar.getInstance(),club,3);
		Equipe e = new Equipe(club,ent,1);
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
		
		//Joueur j13= new Joueur(113,"z","y",Calendar.getInstance(),club,"attaquant",13);

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
		
		/*if(e.equipeValide())
			System.out.println("equipe valide");
		else
			System.out.println("equipe non valide");*/
		
		
		
		//Creation de la deuxieme equipe
		Club club2 = new Club("1","1");
		//Club club1 = new Club("yolo","Strasbourg");
		Entraineur entraineur2 = new Entraineur(202,"uu","nv",Calendar.getInstance(),club2,3);
		Equipe jjj = new Equipe(club2,entraineur2,2);
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
		
		//Creation de la troisième equipe
		Club club3 = new Club("2","2");
		//Club club1 = new Club("yolo","Strasbourg");
		Entraineur entraineur3 = new Entraineur(2020,"uuu","nv",Calendar.getInstance(),club3,3);
		Equipe jjjj = new Equipe(club3,entraineur3,3);
		Joueur jjj1 = new Joueur(2010,"Jeaaaan","Darrvid",Calendar.getInstance(),club3,"attaquant",1);
		Joueur jjj2 = new Joueur(2110,"azzz","kaa",Calendar.getInstance(),club3,"attaquant",2);
		Joueur jjj3 = new Joueur(2210,"bzzz","laa",Calendar.getInstance(),club3,"attaquant",3);
		Joueur jjj4 = new Joueur(2310,"czzz","maa",Calendar.getInstance(),club3,"attaquant",4);
		Joueur jjj5 = new Joueur(2410,"zzzd","aan",Calendar.getInstance(),club3,"defenseur",5);
		Joueur jjj6 = new Joueur(2510,"ezzz","oaa",Calendar.getInstance(),club3,"defenseur",6);
		Joueur jjj7 = new Joueur(2610,"zzzf","paa",Calendar.getInstance(),club3,"defenseur",7);
		Joueur jjj8 = new Joueur(2710,"zzzg","qaa",Calendar.getInstance(),club3,"defenseur",8);
		Joueur jjj9 = new Joueur(2810,"zhzz","raa",Calendar.getInstance(),club3,"attaquant",9);
		Joueur jjj10 = new Joueur(2910,"zizz","saa",Calendar.getInstance(),club3,"gardien",10);
		Joueur jjj11= new Joueur(2020,"jzzz","taaa",Calendar.getInstance(),club3,"defenseur",11);
		Joueur jjj12= new Joueur(2120,"uzzz","aaav",Calendar.getInstance(),club3,"gardien",12);
		
		//Joueur j13= new Joueur(113,"z","y",Calendar.getInstance(),club1,"gardien",13);

		//Ajout des joueurs
		jjjj.ajouterJoueur(jjj1);
		jjjj.ajouterJoueur(jjj2);
		jjjj.ajouterJoueur(jjj3);
		jjjj.ajouterJoueur(jjj4);
		jjjj.ajouterJoueur(jjj5);
		jjjj.ajouterJoueur(jjj6);
		jjjj.ajouterJoueur(jjj7);
		jjjj.ajouterJoueur(jjj8);
		jjjj.ajouterJoueur(jjj9);
		jjjj.ajouterJoueur(jjj10);
		jjjj.ajouterJoueur(jjj11);
		jjjj.ajouterJoueur(jjj12);
		
		
		//Creation de la quatrieme equipe
		Club club4 = new Club("3","3");
		//Club club1 = new Club("yolo","Strasbourg");
		Entraineur entraineur4 = new Entraineur(20200,"uuuu","nv",Calendar.getInstance(),club4,3);
		Equipe jjjjj = new Equipe(club4,entraineur3,4);
		Joueur jjjj1 = new Joueur(20100,"Jeaaaaan","Daarrvid",Calendar.getInstance(),club4,"attaquant",1);
		Joueur jjjj2 = new Joueur(21100,"azzzz","kaaa",Calendar.getInstance(),club4,"attaquant",2);
		Joueur jjjj3 = new Joueur(22100,"bzzzz","laaa",Calendar.getInstance(),club4,"attaquant",3);
		Joueur jjjj4 = new Joueur(23100,"czzzz","maaa",Calendar.getInstance(),club4,"attaquant",4);
		Joueur jjjj5 = new Joueur(24100,"zzzzd","aaan",Calendar.getInstance(),club4,"defenseur",5);
		Joueur jjjj6 = new Joueur(25100,"ezzzz","oaaa",Calendar.getInstance(),club4,"defenseur",6);
		Joueur jjjj7 = new Joueur(26100,"zzzzf","paaa",Calendar.getInstance(),club4,"defenseur",7);
		Joueur jjjj8 = new Joueur(27100,"zzzzg","qaaa",Calendar.getInstance(),club4,"defenseur",8);
		Joueur jjjj9 = new Joueur(28100,"zhzzz","raaa",Calendar.getInstance(),club4,"attaquant",9);
		Joueur jjjj10 = new Joueur(29100,"zizzz","saaa",Calendar.getInstance(),club4,"gardien",10);
		Joueur jjjj11= new Joueur(20200,"jzzzz","taaaa",Calendar.getInstance(),club4,"defenseur",11);
		Joueur jjjj12= new Joueur(21200,"uzzzz","aaaav",Calendar.getInstance(),club4,"gardien",12);
		
		//Joueur j13= new Joueur(113,"z","y",Calendar.getInstance(),club1,"gardien",13);

		//Ajout des joueurs
		jjjjj.ajouterJoueur(jjjj1);
		jjjjj.ajouterJoueur(jjjj2);
		jjjjj.ajouterJoueur(jjjj3);
		jjjjj.ajouterJoueur(jjjj4);
		jjjjj.ajouterJoueur(jjjj5);
		jjjjj.ajouterJoueur(jjjj6);
		jjjjj.ajouterJoueur(jjjj7);
		jjjjj.ajouterJoueur(jjjj8);
		jjjjj.ajouterJoueur(jjjj9);
		jjjjj.ajouterJoueur(jjjj10);
		jjjjj.ajouterJoueur(jjjj11);
		jjjjj.ajouterJoueur(jjjj12);
		
		Arbitre arbitro1 = new Arbitre(501, "arara", " araraez", d, club3, 1 );
		Arbitre arbitro2 = new Arbitre(5001, "arara", " araraez", today, club4, 1 );
		
		TreeSet<Equipe> eL = new TreeSet<Equipe>();
		eL.add(e);
		eL.add(jjj);
		eL.add(jjjj);
		eL.add(jjjjj);
		//System.out.println(eL);

		TreeSet<Calendar> c = new TreeSet<Calendar>();
		c.add(d);
		c.add(today);
		c.add(d1);
		c.add(d2);
		String s="";
		Iterator<Calendar> it = c.iterator();
		/*while(it.hasNext())
		{
			Calendar c1=it.next();
			s+=c1.get(Calendar.HOUR_OF_DAY)+":"+c1.get(Calendar.MINUTE) +" le "+ c1.get(Calendar.DAY_OF_MONTH)+" "+ (c1.get(Calendar.MONTH)+1)+" " + c1.get(Calendar.YEAR)+"\n";
		}
		System.out.println(s);*/
		//System.out.println(heureDebut.get(Calendar.HOUR)+":"+heureDebut.get(Calendar.MINUTE) +" le"+ heureDebut.get(Calendar.DAY_OF_MONTH)+" "+ (heureDebut.get(Calendar.MONTH)+1)+" " + heureDebut.get(Calendar.YEAR));
		HashSet<Arbitre> a = new HashSet<Arbitre>();
		a.add(arbitro);
		a.add(arbitro1);
		a.add(arbitro2);
		//System.out.println(a);

		
		
		
		//creation du tournoi
		Tournoi tournoi = new Tournoi(eL,c,a);
		//tournoi.equipesEnLice();
		tournoi.tour();
		//System.out.println(tournoi.toString());
		tournoi.lanceMatch(1);
		tournoi.lanceMatch(2);
		//System.out.println("nop "+tournoi.equipesEnLice().size());
		//System.out.println(tournoi.toString());
		//tournoi.equipesEnLice();
		tournoi.tour();
		tournoi.lanceMatch(1);
		System.out.println(tournoi.toString());
		System.out.println();
		System.out.println(e);
		System.out.println(jjj);
		System.out.println(jjjj);
		System.out.println(jjjjj);

		System.out.println("meilleurs butteurs :\n"+ tournoi.troisMeilleusrButteurs());
		//System.out.println(tournoi.rechercherRencontre(jjj, jjjj));
		/*Tour tourI = new Tour(eL,1,4,c,a);
		tourI.tour();
		//System.out.println(tourI.toString());
		tourI.lancerMatch(2);
		System.out.println(tourI.toString());*/

		
		
		
		
		
		
		/*Match arar = new Match(e,jjj, arbitro,today);
		arar.but(jj2);
		arar.toString();
		arar.but(j2);
		arar.toString();*/
		
		//System.out.println(e.toString());
		//System.out.println(jjj.toString());

	}

}
