import java.net.URL;

public class Joueurs {
	String nom;
	String prenom;
	int age;
	int poid;
	int taille;
	URL image;

	public Joueurs(String nom, String prenom, int age, int poid, int taille, URL image) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.poid = poid;
		this.taille = taille;
		this.image = image;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPoid() {
		return poid;
	}

	public void setPoid(int poid) {
		this.poid = poid;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public URL getImage() {
		return image;
	}
	
	public void setImage(URL image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Joueurs [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", poid=" + poid + ", taille=" + taille
				+", image=" + image + "]";
	}
}
