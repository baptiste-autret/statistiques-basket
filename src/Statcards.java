
public class Statcards {
	private Joueurs joueurs; 
	private Matchs matchs; 
//	private String nom; //recuperation avec joueurs
//	private int matchID; //recuperation avec matchs
	private String TDJeu;
	private String points;
	private int rebonds;
	private int passe_D;
	
	
	
	public Statcards(Joueurs joueurs, Matchs matchs, String tDJeu, String points, int rebonds, int passe_D) {
		super();
		this.joueurs = joueurs;
		this.matchs = matchs;
		this.TDJeu = tDJeu;
		this.points = points;
		this.rebonds = rebonds;
		this.passe_D = passe_D;
	}
	
	
	public Joueurs getJoueurs() {
		return joueurs;
	}
	public void setJoueurs(Joueurs joueurs) {
		this.joueurs = joueurs;
	}
	public Matchs getMatchs() {
		return matchs;
	}
	public void setMatchs(Matchs matchs) {
		this.matchs = matchs;
	}
	public String getTDJeu() {
		return TDJeu;
	}
	public void setTDJeu(String tDJeu) {
		TDJeu = tDJeu;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	public int getRebonds() {
		return rebonds;
	}
	public void setRebonds(int rebonds) {
		this.rebonds = rebonds;
	}
	public int getPasse_D() {
		return passe_D;
	}
	public void setPasse_D(int passe_D) {
		this.passe_D = passe_D;
	}

	
	@Override
	public String toString() {
		return "Statcards [joueurs=" + joueurs + ", matchs=" + matchs + ", TDJeu=" + TDJeu + ", points=" + points
				+ ", rebonds=" + rebonds + ", passe_D=" + passe_D + "]";
	}
}
