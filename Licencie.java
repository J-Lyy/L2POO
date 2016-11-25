package projet;
import java.util.Calendar;

public abstract class Licencie {
	protected int numeroDeLicence;
	protected String nom;
	protected String prenom;
	protected Calendar dateDeValidite;
	protected Club club;
	
	public Licencie(int numLic, String nom, String prenom, Calendar dateValidite, Club club)
	{
		numeroDeLicence = numLic;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeValidite = dateValidite;
		this.club = club;
	}

	public int getNumeroDeLicence() {
		return numeroDeLicence;
	}

	public void setNumeroDeLicence(int numeroDeLicence) {
		this.numeroDeLicence = numeroDeLicence;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Calendar getDateDeValidite() {
		return dateDeValidite;
	}

	public void setDateDeValidite(Calendar dateDeValidite) {
		this.dateDeValidite = dateDeValidite;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
	
	public String toString(){
		return (nom + " " + prenom + " dans le club : " + club + " de numéro de license " + numeroDeLicence + " expirant le " + dateDeValidite ) ;
	}
}
