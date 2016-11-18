package projet;

public class Club {
	private String nom;
	private String ville;
	
	public Club(String nom, String Ville)
	{
		this.nom = nom;
		this.ville = ville;
	}
	
	public String toString()
	{
		return ("Club "+nom+" dans la ville : "+ville);
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	

}
