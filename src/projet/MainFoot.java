package projet;
import java.util.*;
import java.io.*;

public class MainFoot {
	
	static int nbTituMax = 9;
	static int nbRempMax = 5;
	
	/*
	public static void oldTest() {
		Club aa = new Club("a","a");
		Calendar d = new GregorianCalendar(2016,11,29);
		Joueur Test = new Joueur(144,"a","a",d, aa, "attaquant", 1);
		try {
			ObjectOutputStream sortie = new ObjectOutputStream (new FileOutputStream("listeTitulaires.txt"));
			sortie.writeObject(Test);
			sortie.flush();
	        sortie.close();
		}catch(FileNotFoundException e){System.out.println(e);}
		catch(IOException e){System.out.println(e);}
		System.out.println(Test);
		
		Object Test2 = null;
		try {
			ObjectInputStream entree = new ObjectInputStream (new FileInputStream("listeTitulaires.txt"));
			Test2 = entree.readObject();
		}
		catch(FileNotFoundException e){System.out.println(e);}
		catch(IOException e){System.out.println(e);}
		catch(ClassNotFoundException e){System.out.println(e);}
		System.out.println(Test2);

	}
	
public static void generateClubOLD(){ //Saisir manuellement un club dans un fichier
		
		
		String ville = "";
		String nom = "";
		String ligne = "";
		String club = "";
		boolean existe = false;
		try{		
			
			File clubs = new File("Clubs.txt");
			if (!clubs.exists()) clubs.createNewFile();
			Scanner sc = new Scanner(clubs);
			Scanner in = new Scanner(System.in);
			FileWriter fw = new FileWriter(clubs, true);
			PrintWriter pw = new PrintWriter(fw);
			System.out.println("Saisissez une ville :");
			ville = in.nextLine();
			System.out.println("Saisissez un nom :");
			nom = in.nextLine();
			club = ville+"/"+nom;
			
		    while (sc.hasNextLine()) {
		        ligne=sc.nextLine();
		        if (club.equals(ligne)){
		        	existe = true ;
		        	break;
		        }
		    }
		    if (existe) System.out.println("Le club existe déjà");
		    else pw.println(club);
		    in.close();
		    pw.close();
		    sc.close();
		}catch(IOException e){e.printStackTrace();}
	}
	*/
	public static void test() {
		  // TODO: À décommenter quand tu es prêt à tester l'enregistrement de l'objet Frappe
		  // NOTE: Un nom de variable de méthode ne doit JAMAIS commencer par une majuscule
		  // Frappe coup = new Frappe(calendrier, horaire, duree_frappe, force_max, v_max, m_max, p_max);
		  ArrayList<String> alrec = new ArrayList<String>();
		  ArrayList<String> allec = new ArrayList<String>();
		  // alrec.add(coup);
		  alrec.add("Pouet pouet pouet pouet!!");
		  //alrec.add("PAF PUF");
		  //for(int i = 0 ; i<100 ; i++)
		  //alrec.add("...");
		 
		  // TODO: À changer par ce que tu veux
		  //if(File("pouet-pouet.dat").exists())
		  File file = new File("pouet-pouet.dat");
		 
		  FileOutputStream fos = null;
		  ObjectOutputStream oos = null;
		  try {
		    fos = new FileOutputStream(file);
		    oos = new ObjectOutputStream(fos);
		    oos.writeObject(alrec);
		  } catch (FileNotFoundException fnfe) {
		    System.out.println("Could not find file");
		    fnfe.printStackTrace();
		  } catch (IOException ioe) {
		    System.out.println("I/O Exception while writing to file");
		    ioe.printStackTrace();
		  } finally {
		    if (fos != null) {
		      safeClose(fos);
		      // Pas besoin de fermer les autres, ils sont fermés automatiquement si tu fermes celui-là
		      // Si tu veux tester, il te suffit d'appeler oos.write(17); et oos.flush(); par exemple
		      // et Java répondra que le flux est déjà fermé (alors que tu as fermé fos, pas oos)
		    }
		  }
		   
		  // Maintenant que tout est fermé, on lit!
		   
		 
		  FileInputStream fis = null;
		  ObjectInputStream ois = null;
		  try {
		    fis = new FileInputStream(file);
		    ois = new ObjectInputStream(fis);
		     
		    System.out.println("Affichage des historiques :");
		    System.out.println("*************************");
		    allec = (ArrayList<String>) ois.readObject();
		    for (String i : allec) {
		      // Toujours mieux avec un bloc même s'il n'y a qu'une ligne, ça améliore la visibilité
		      System.out.println(i);
		    }
		  } catch (FileNotFoundException fnfe) {
		    System.out.println("Could not find file");
		    fnfe.printStackTrace();
		  } catch (ClassNotFoundException cnfe) {
		    System.out.println("File format is wrong :(");
		    cnfe.printStackTrace();
		  } catch (IOException ioe) {
		    System.out.println("I/O Exception while reading file");
		    ioe.printStackTrace();
		  } finally {
		    if (fis != null) {
		      safeClose(fis);
		    }
		  }
		}
		 
		private static void safeClose(Closeable closeable) {
		  // Permet d'éviter de faire des try/catch autour des .close()
		  try {
		    closeable.close();
		  } catch (IOException ioe) {
		    throw new RuntimeException(ioe);
		  }
		}
	
	
	
	
	
	
	
	
	
	
	
	
/*	
//	@SuppressWarnings("unchecked")
	public static Set<Joueur> listeTitulaires() {
		Set<Joueur> laListe = new TreeSet<Joueur>();
		try {
			ObjectInputStream entree = new ObjectInputStream (new FileInputStream("listeTitulaires.txt"));
			laListe = (Set<Joueur>)entree.readObject();
		}
		catch(FileNotFoundException e){System.out.println(e);}
		catch(IOException e){System.out.println(e);}
		catch(ClassNotFoundException e){System.out.println(e);}
		System.out.println(laListe);
		return laListe;
	}
*/	
	//------------------------------------------------- GENERATORS -------------------------------------------------//
	public static int generateNumLicense(){	//Auto-Incrémente dans un fichier
		String ligne = "";
		int last = 0;
		try{		
			
			File licenses = new File("Licenses.txt");
			if (!licenses.exists()) licenses.createNewFile();
			Scanner sc = new Scanner(licenses);
			FileWriter fw = new FileWriter(licenses, true);
			PrintWriter pw = new PrintWriter(fw);
			
		    while (sc.hasNextLine()) {
		        ligne=sc.nextLine();
		        if (!sc.hasNextLine()){
		        	Scanner num = new Scanner(ligne);
		        	last = Integer.parseInt(num.next())+1;
		        	num.close();
		        }
		    }
		    pw.println(last);
		    pw.close();
		    sc.close();
		}catch(IOException e){e.printStackTrace();}
	    return last ;
	}
	
	public static Object generateRandom(String type,Club club,int arg1, String arg2){ //Generateur aleatoire de joueurs, d'entraineurs et d'arbitres
		int num = generateNumLicense();
		int taille = 16; //Les 2 tableaux sont de taille 16
		//int randomName = new Random().nextInt(array.length);
		String[]tabPrenom = {"Adrien","Noryan","William","Jayson","Dali","Jean","Paul","David","Didier","Luc","Theo","Philippe","Valentin","Nils","Emile","Nicolas"} ;
		String[]tabNom = {"Boucher","Dupond","Lepatissier","Sheinback","Ali-ama","Ferral","Dectro","Moissoneuse-Batteuse","Valjean","Potter","Grossetete","Nanami","Dugrandpuit","Lamotte-Terrebasse","Conservateur","Drogba"};
		String randomPrenom = tabPrenom[new Random().nextInt(taille)];
		String randomNom = tabNom[new Random().nextInt(taille)];
		Object generated = null;

		Calendar dateValidite = new GregorianCalendar(2018,(new Random().nextInt(12))+1,(new Random().nextInt(28))+1);
		if (type.equals("Player")){
			String poste = arg2;
			int numeroDeMaillot = arg1;
			generated = new Joueur(num,randomPrenom,randomNom,dateValidite,club,poste,numeroDeMaillot);	
		}
		else if(type.equals("Entraineur")){
			int niveau = arg1;
			generated = new Entraineur(num,randomPrenom,randomNom,dateValidite,club,niveau);	
		}
		else if(type.equals("Arbitre")){
			
		}
		return generated ;
	}
	
	public static void generateClub(){ //Crée un fichier .dat vide dans le dossier club
		Scanner in = new Scanner(System.in);
		System.out.println("Saisissez une ville :");
		String nomClub = "club/"+in.nextLine();
		System.out.println("Saisissez un nom :");
		nomClub+="_"+in.nextLine()+".dat";
		//in.close();
		File club = new File(nomClub); //Nom du fichier club à ajouter
		
		File dossier = new File("club");
		String curDir = System.getProperty("user.dir");
		curDir+="/club"; //Chemin du répertoire club
		
		try{
			if (!dossier.isDirectory()) dossier.delete();
			if ((!dossier.exists()))(new File(curDir)).mkdirs();
			if (!club.exists()) club.createNewFile();
			else System.out.println("Le club existe déjà");	
		}catch(IOException e){e.printStackTrace();}
	}
	
	public static TreeSet<Equipe> selectEquipesTournoi(int nbEquipe){
		File[] f = null;
		TreeSet<Equipe> equipesTournoi = new TreeSet<Equipe>();
		int cpt = 1;
		File dossier = new File("club");
		f = dossier.listFiles();
		Scanner in = new Scanner (System.in);
		
		
		System.out.println("Voici la liste des clubs : ");
		
		ArrayList<File> listeEquipe = new ArrayList<File>();
		for (File i :f){
			listeEquipe.add(i);
		}
		Iterator<File> it =listeEquipe.iterator();
		for (int j = 0; j<nbEquipe;j++){
			System.out.println("oui");
			cpt = 1 ;
			while(it.hasNext()){
				File fichier = it.next();
				System.out.println(cpt+"-"+fichier);
				cpt++;
			}
			
			
			String numClub = "";
			boolean exit = false;
			while (!exit){
				System.out.println("Entrez un entier positif qui va jusqu'à "+(cpt-1));
				while(!in.hasNextInt()){
					
					numClub = in.next();
					
				}
				numClub = in.next();
				Iterator<File> it2 = listeEquipe.iterator();
				int cpt2 = 1;
				int numClub1 = Integer.parseInt(numClub);
				File fichier1 = null;
				if (numClub1<=cpt){
					exit = true;
					while(it2.hasNext() && cpt2<=numClub1){
						fichier1 = it2.next();
					}
					
					
					try{
						//FileInputStream entree = null;
						//ObjectInputStream ois = null;
						System.out.println(fichier1);
						FileInputStream entree= new FileInputStream(fichier1);
						ObjectInputStream ois = new ObjectInputStream(entree);
						Equipe aRentrer = (Equipe)ois.readObject();
						equipesTournoi.add(aRentrer);
						listeEquipe.remove(fichier1);
						safeClose(entree);
					}catch(FileNotFoundException e){e.printStackTrace();} 
					catch (IOException e) {	e.printStackTrace();} 
					catch (ClassNotFoundException e) {e.printStackTrace();}
					
				}
				else System.out.println("Entrez un entier positif qui va jusqu'à "+cpt);
			}
		}
		return equipesTournoi;
	}
	/*
	public static void serializeEquipe(Equipe e, File f){
		Equipe e1 = e;
		try{
			 FileOutputStream outputFileStream = new FileOutputStream(f);
		     ObjectOutputStream outputStream = new ObjectOutputStream(outputFileStream);
		     outputStream.writeObject(e1);
		      outputStream.close();
		      outputFileStream.close();
		}
		catch(IOException ee){	ee.printStackTrace();} 
	}
	*/
	public static Club selectClub(boolean empty){
		File[] f = null;
		File dossier = new File("club");
		if(empty){
			f = dossier.listFiles(new FileFilter(){
				public boolean accept(File pathname) {
					return (pathname.length()==0);
				}
			});
			System.out.println("Les clubs vides sont : ");
		}
		else {
			f = dossier.listFiles();
			System.out.println("Voici la liste des clubs : ");
		}
		
		
		String nom ="";
		int cpt = 0;
		
		Scanner club=null;
		
		for (File i : f){
				cpt+=1;
				nom = i.getName();
				club = new Scanner(cpt+"-"+nom).useDelimiter(".dat");
				System.out.println(club.next());
		}
		safeClose(club);
		if(cpt == 0){ 
			if(empty) System.out.println("Aucun club n'est vide");
			else System.out.println("Il n'y a aucun club");
		} 
		else System.out.println("Saisir le numéro correspondant au club");

		Scanner numSelec = new Scanner(System.in);
		String numClub = "";
		boolean exit = false;
		int index = 0;
		while (!exit){
			while(!numSelec.hasNextInt()){
				numClub = numSelec.next();
				System.out.println("Entrez un entier positif qui va jusqu'à "+cpt);
			}
			numClub = numSelec.next();
			index = Integer.parseInt(numClub);
			if (index<=cpt) exit = true;
			else System.out.println("Entrez un entier positif qui va jusqu'à "+cpt);
		}
		//scsc.close();
		System.out.println(numClub);
		String buildClub = (f[index-1]).getName();
		
		Scanner analyse = new Scanner(buildClub).useDelimiter("\\\\");
		buildClub = analyse.next(); // ville_nom.dat
		
		analyse= (new Scanner(buildClub)).useDelimiter(".dat");
		buildClub=analyse.next(); //	ville_nom
		
		analyse= new Scanner(buildClub).useDelimiter("_");
		String villeClub = analyse.next();
		String nomClub = analyse.next();
		Club newClub = new Club(nomClub, villeClub);
		safeClose(analyse);
		return newClub;
	}
	
	public static Joueur numeroLicValide(Equipe e, int numLic1){
		Iterator<Joueur> it = e.getTitulaires().iterator();
		Joueur joueur = null;
		boolean trouve = false;
		while(it.hasNext()){
			Joueur j1 = it.next();
			if(numLic1 == j1.getNumeroDeLicence()){
				joueur = j1;
				trouve = true;
				break;
			}
		}
		if(!trouve){
			Iterator<Joueur> it1 = e.getRemplacant().iterator();
			while(it1.hasNext()){
				Joueur j2 = it1.next();
				if(numLic1 == j2.getNumeroDeLicence()){
					joueur = j2;
				}
			}
		}
		return joueur;
	}
	
	public static Equipe modifierClub(Club toModif){
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		File club = new File("club/"+toModif.getVille()+"_"+toModif.getNom()+".dat");
		System.out.println(club.getName());
		Equipe lEquipe = null;
		  try {
		    fis = new FileInputStream(club);
		    ois = new ObjectInputStream(fis);
		    lEquipe = (Equipe)ois.readObject();
		    Scanner in = new Scanner(System.in);
		    String modifier="";
		    do{
		    	System.out.println("\n\nSélectionner un choix de 1 à 5 :"
			    		+ "\n1-Ajouter un joueur"
			    		+ "\n2-Echanger le numéro de maillot de 2 joueurs"
			    		+ "\n3-Echanger le poste de 2 joueurs"
			    		+ "\n4-Supprimer un joueur"
			    		+ "\n5-Retour");
		    	modifier = in.next();
		    	switch(modifier){
		    		
		    		case "1": {
		    			int numLicense = generateNumLicense();
		    			System.out.println("Saisir le nom du joueur");
		    			String nom = in.next();
		    			System.out.println("Saisir son prénom");
		    			String prenom = in.next();
		    			Calendar dateValidite = new GregorianCalendar(2018,(new Random().nextInt(12))+1,(new Random().nextInt(28))+1);
		    			System.out.println("Saisissez son poste: 'attaquant','defenseur','gardien'");
		    			boolean continu=true;
		    			do{
		    				String poste = in.next();
		    				if (poste.equals("attaquant") || poste.equals("defenseur") || poste.equals("gardien")){
		    					Joueur j = new Joueur(numLicense, nom, prenom, dateValidite, toModif, poste, 1);
		    					lEquipe.ajouterJoueur(j);
		    					continu =  false;
		    				} else System.out.println("Saisissez un poste valide : 'attaquant','defenseur','gardien'");
		    			}
		    			while(continu);
		    			System.out.println("\n"+lEquipe);
		    			break;
		    		}
		    			
		    		case "2":{
		    			System.out.println("\n"+lEquipe);
		    			Joueur j1 = null;
		    			Joueur j2 = null;
		    			do{
		    				System.out.println("\n\nDonner un numéro de license valide pour le premier joueur");
		    				if(in.hasNextInt()){
		    					int numLicense1 = Integer.parseInt(in.next());
		    					j1 = numeroLicValide(lEquipe, numLicense1);
		    				}
		    			}while(j1.equals(null));
		    				
			    		do{
		    				System.out.println("Donner un numéro de license valide pour le deuxième joueur");
			    			if(in.hasNextInt()){
			    				int numLicense2 = Integer.parseInt(in.next());
				    			j2 = numeroLicValide(lEquipe, numLicense2);
			    			}
			    		}while(j2.equals(null));
			    			lEquipe.echangerNumeros(j1, j2);
			    			System.out.println("\n"+lEquipe);
		    		}
		    		
		    		case "3":{
		    			System.out.println("\n"+lEquipe);
		    			Joueur j1 = null;
		    			Joueur j2 = null;
		    			boolean test1 = false;
			    		boolean test2 = false;
			    		do{
			    			do{
			    				do{
				    				System.out.println("\n\nDonner un numéro de license valide pour le premier joueur");
				    				if(in.hasNextInt()){
				    					int numLicense1 = Integer.parseInt(in.next());
				    					j1 = numeroLicValide(lEquipe, numLicense1);
				    				}
				    			}while(j1.equals(null));
				    				
					    		do{
				    				System.out.println("Donner un numéro de license valide pour le deuxième joueur");
					    			if(in.hasNextInt()){
					    				int numLicense2 = Integer.parseInt(in.next());
						    			j2 = numeroLicValide(lEquipe, numLicense2);
					    			}
					    		}while(j2.equals(null));
					    		if(lEquipe.estTitulaire(j1) && lEquipe.estTitulaire(j2))
					    			test1 = true;
					    		if(lEquipe.estTitulaire(j1) == false && lEquipe.estTitulaire(j2) == false )
					    			test2 = true;
					    		if(j1.getPoste().equals(j2.getPoste()))
					    			System.out.println("Les deux joueurs ne doivent pas avoir le même poste");
			    			}while((j1.getPoste().equals(j2.getPoste())));
			    			if(!test1 && !test2)
				    			System.out.println("Les deux joueurs doivent être tous les deux titulaires ou tous les deux remplaçants");
			    		}while(!test1 && !test2 );
		    			
			    			lEquipe.changerPoste(j1, j2);
			    			System.out.println("\n"+lEquipe);
		    		}
		    		case "4":{
		    			System.out.println("\n"+lEquipe);
		    			Joueur j1 = null;
		    			do{
		    				System.out.println("\n\nDonner un numéro de license valide du joueur à supprimer");
		    				if(in.hasNextInt()){
		    					int numLicense = Integer.parseInt(in.next());
		    					j1 = numeroLicValide(lEquipe, numLicense);
		    				}
		    			}while(j1.equals(null));
		    			lEquipe.supprimerJoueur(j1);
		    		}
		    		
		    		default: System.out.println("Commande invalide");
		    	}		
		    }while(!modifier.equals("5"));
		    

		  } catch (FileNotFoundException fnfe) {
		    System.out.println("Could not find file");
		    fnfe.printStackTrace();
		  } catch (ClassNotFoundException cnfe) {
		    System.out.println("File format is wrong :(");
		    cnfe.printStackTrace();
		  } catch (IOException ioe) {
		    System.out.println("I/O Exception while reading file");
		    ioe.printStackTrace();
		  } finally {
		    if (fis != null) {
		      safeClose(fis);
		    }
		  }
		  return lEquipe;
	}
	
	
	
	
	
	public static void buildAllTeamRandomly(int nbTeam){	//Genere le fichier serialize que l'on va donner au Tournoi
		for (int i = 1 ; i<=nbTeam ; i++){
			
		}
	}
	
	
	public static Equipe construireEquipeRandom(Club clubi, int numEquipe){
		int tailleEquipe = nbTituMax+1+(int)Math.random()*(nbRempMax-1);
		Entraineur entraino = (Entraineur) generateRandom("Entraineur", clubi,new Random().nextInt(5)+1,"");
		String[]randPoste = {"attaquant","defenseur","gardien"};
		
		Equipe lEquipe = new Equipe (clubi, entraino, numEquipe);
		String poste = "";
		Joueur unJoueur = null;
		
		
		for (int i = 1 ; i <= tailleEquipe ; i++){
			if (i==1) poste = "gardien";
			else if (i<=(nbTituMax/2)+1) poste = "attaquant";
			else if (i<=nbTituMax) poste = "defenseur";
			else poste= randPoste[new Random().nextInt(3)];
			unJoueur = (Joueur) generateRandom("Player", clubi, i, poste);
			lEquipe.ajouterJoueur(unJoueur);
		}
		//System.out.println(lEquipe);
		return lEquipe;
		/*
		// TODO: À décommenter quand tu es prêt à tester l'enregistrement de l'objet Frappe
		  // NOTE: Un nom de variable de méthode ne doit JAMAIS commencer par une majuscule
		  // Frappe coup = new Frappe(calendrier, horaire, duree_frappe, force_max, v_max, m_max, p_max);
		  ArrayList<String> alrec = new ArrayList<String>();
		  ArrayList<String> allec = new ArrayList<String>();
		  // alrec.add(coup);
		  alrec.add("Pouet pouet pouet pouet!!");
		  alrec.add("PAF PUF");
		  alrec.add("...");
		 
		  // TODO: À changer par ce que tu veux
		  File file = new File("pouet-pouet.dat");
		 
		  FileOutputStream fos = null;
		  ObjectOutputStream oos = null;
		  try {
		    fos = new FileOutputStream(file);
		    oos = new ObjectOutputStream(fos);
		    oos.writeObject(alrec);
		  } catch (FileNotFoundException fnfe) {
		    System.out.println("Could not find file");
		    fnfe.printStackTrace();
		  } catch (IOException ioe) {
		    System.out.println("I/O Exception while writing to file");
		    ioe.printStackTrace();
		  } finally {
		    if (fos != null) {
		      safeClose(fos);
		      // Pas besoin de fermer les autres, ils sont fermés automatiquement si tu fermes celui-là
		      // Si tu veux tester, il te suffit d'appeler oos.write(17); et oos.flush(); par exemple
		      // et Java répondra que le flux est déjà fermé (alors que tu as fermé fos, pas oos)
		    }
		  }
		
		Club aa = new Club("a","a");
		Joueur oui = new Joueur(1,"a","a",Calendar.getInstance(), aa, "attaquant", 1);
		Joueur non = new Joueur(2,"aa","aa",Calendar.getInstance(), aa, "attaquant", 2);
		Set<Joueur> laListe = new TreeSet<Joueur>();
		laListe.add(oui);
		laListe.add(non);
		try {
			ObjectOutputStream sortie = new ObjectOutputStream (new FileOutputStream("listeTitulaires.txt"));
			sortie.writeObject(laListe);
		}
		catch(FileNotFoundException e){System.out.println(e);}
		catch(IOException e){System.out.println(e);}
		*/
	}
	
	public static void enregistrerScore(Tour tour){
		File score = new File("score/tournoi"+tour.getNumTour()+"txt");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try{
			
		}
	}
	
	public static void saveTeam(Equipe toSave){
		Club clubToSave = toSave.getClub();
		File team = new File("club/"+clubToSave.getVille()+"_"+clubToSave.getNom()+".dat");
		System.out.println(team.toString());
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			if (team.exists()) if (team.length()!=0) team.delete();
			if (!team.exists()) team.createNewFile();
		    fos = new FileOutputStream(team);
		    oos = new ObjectOutputStream(fos);
		    oos.writeObject(toSave);
		}catch (FileNotFoundException fnfe) {
		    System.out.println("Could not find file");
		    fnfe.printStackTrace();
		}catch (IOException ioe) {
		    System.out.println("I/O Exception while writing to file");
		    ioe.printStackTrace();
		} finally {
		    if (fos != null) {
		     safeClose(fos);
		   }
		 }
	}
	
	public static boolean isPowerOfTwo(long value) {
		if ( Long.bitCount(value)==1 ) return true;
		return false;
	}
	 
		
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// TODO Auto-generated method stub
		String menu = "";
		//ajouterJoueur();
		//listeTitulaires();
		test();
		System.out.println("J");
		//generateNumLicense();
		
	//	Club aa = new Club("a","a");
		//Equipe j = construireEquipeRandom(aa, 1);
		//saveTeam(j);
		//safeClose(in);
		
		/*generateClub(); //Cree le nouveau club en tant que fichier.dat
		Equipe j = construireEquipeRandom(selectClub(true),1); //Selectionne un club.dat VIDE et construit une équipe aléatoirement holy shit
		saveTeam(j); //Sauve la team dans le fichier !!!!
		System.out.println(j+"\n");*/
		modifierClub(selectClub(false));
		
		//safeClose(in);
		//selectEquipesTournoi(8);
		
		
		
		
		
		
		
		
		
		
		
		/*
		do{
			System.out.println("Tapez votre choix ou J pour quitter : \n"
					+ "1 - Participants \n"
					+ "2 - Equipes \n"
					+ "3 - Tournoi");
			menu = in.next();
			//Selectionne un choix
			
			switch(menu){
			// 1 - Participants -----------------------------------------------------------------------------
				case "1": 
					do{
						System.out.println("\n1 - Voir la liste des joueurs \n"
										   + "2 - Ajouter quelqu'un \n"
										   + "3 - Créer une license \n"
										   + "4 - Retour \n");
						menu = in.next();
						switch(menu){
							case "1":	
								do{
									System.out.println("\n1 - Liste des titulaires \n"
												 	   + "2 - Liste des remplaçants \n"
												 	   + "3 - Retour \n");
									menu = in.next();
									switch(menu){
										case "1":
											System.out.println("Affiche les titulaires"); 		// FONCTION POUR AFFICHER LES TITULAIRES
											break;
										case "2":
											System.out.println("Affiche les remplaçants");		// FONCTION POUR AFFICHER LES REMPLACANTS
											break;
										case "3": break; //Revient dans le Menu "Participants"
										default:
											System.out.println("Saisissez un entier entre 1 et 3 \n"); //Erreur
											break;
									}
								}while(!menu.equals("3"));
								menu="";
								break;
							case "2":
								do{
									System.out.println("\n1 - Joueur \n"
										 	   + "2 - Entraineur \n"
										 	   + "3 - Arbitre \n"
										 	   + "4 - Retour \n");
									menu = in.next();
									switch(menu){
										case "1":
											System.out.println("Ajoute un joueur");				// FONCTION POUR AJOUTER UN JOUEUR
											break;
										case "2":
											System.out.println("Ajoute un entraineur");			// FONCTION POUR AJOUTER UN ENTRAINEUR
											break;
										case "3":
											System.out.println("Ajoute un arbitre");			// FONCTION POUR AJOUTER UN ARBITRE
											break;
										case "4": break; //Revient dans le Menu "Participants"
										default:
											System.out.println("Saisir un nombre entre 1 et 4 \n");//Erreur
									}
								}while(!menu.equals("4"));
								menu="";
							case "3":
																								// FONCTION POUR CREER UNE LICENSE
								break;
							case "4": break; //Revient au menu |Participants-Equipes-Tournoi| from Participants
							default:
								System.out.println("Saisir un nombre entre 1 et 4 \n");					
						}
					}while(!menu.equals("4"));
					break;
					
					
					
			// 2 - Equipes -----------------------------------------------------------------------------		
				case "2": // 2 - Equipes
					do{
						System.out.println("\n1 - Voir une équipe \n"
										   + "2 - Créer une équipe \n"
										   + "3 - Retour \n");
						menu = in.next();
						switch(menu){
							case "1":
																								// FONCTION POUR VOIR UNE EQUIPE
								break;
							case "2":
																								// FONCTION POUR CREER UNE EQUIPE
								break;
							case "3": break; //Revient au menu |Participants-Equipes-Tournoi| from Equipes
							default:
								System.out.println("Saisir un nombre entre 1 et 3 \n");
						}
					}while(!menu.equals("3"));
					break;
				case "3": // 3 - Tournoi
					System.out.println("\n1 - Créer un tour \n"
									   + "2 - Rechercher une rencontre \n"
									   + "3 - Donner les statistiques du tournoi \n");
					break;
				case "J": break;
				default:
					System.out.println("Saisissez un entier valide, 1, 2 ou 3.");
					break;
					
			}
			
		}while(!menu.equals("J")); */
		System.out.println("Fin");
	}
}
