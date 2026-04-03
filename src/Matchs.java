public class Matchs {
	private int matchID; // lien avec slatcard
	private String adversaire;
	private String date;
	private String lieu;
	private String resultat;
	private String difScore;
	
	
	public Matchs(int matchID, String adversaire, String date, String lieu, String resultat, String difScore) {
		super();
		this.matchID = matchID;
		this.adversaire = adversaire;
		this.date = date;
		this.lieu = lieu;
		this.resultat = resultat;
		this.difScore = difScore;
	}


	public int getMatchID() {
		return matchID;
	}
	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}
	public String getAdversaire() {
		return adversaire;
	}
	public void setAdversaire(String adversaire) {
		this.adversaire = adversaire;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	public String getDifScore() {
		return difScore;
	}
	public void setDifScore(String difScore) {
		this.difScore = difScore;
	}

	
	@Override
	public String toString() {
		return "Matchs [matchID=" + matchID + ", adversaire=" + adversaire + ", date=" + date + ", lieu=" + lieu
				+ ", resultat=" + resultat + ", difScore=" + difScore + "]";
	}
}
