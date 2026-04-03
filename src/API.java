import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class API {
	 private static Connection con = Connexion.getInstance();
	 
	public static void InnerMatchs(Matchs aAjouter) {
		String sql = "INSERT INTO matchs () VALUES(?,?,?,?,?,?)";
		try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			preparedStatement.setInt(1, aAjouter.getMatchID());
			preparedStatement.setString(2, aAjouter.getAdversaire());
			preparedStatement.setString(3, aAjouter.getDate());
			preparedStatement.setString(4, aAjouter.getLieu());
			preparedStatement.setString(5, aAjouter.getResultat());
			preparedStatement.setString(6, aAjouter.getDifScore());

			preparedStatement.executeUpdate();

			System.out.println("Ajout du match numéro" + aAjouter.getMatchID() + " réussi avec succès !");
		} catch (SQLException e) {
		}
	}

	
	public static void InnerJoueurs(Joueurs aAjouter) {
		String sql = "INSERT INTO joueurs () VALUES(?,?,?,?,?,?)";
		try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			preparedStatement.setString(1, aAjouter.getNom());
			preparedStatement.setString(2, aAjouter.getPrenom());
			preparedStatement.setInt(3, aAjouter.getAge());
			preparedStatement.setInt(4, aAjouter.getPoid());
			preparedStatement.setInt(5, aAjouter.getTaille());
			preparedStatement.setURL(6, aAjouter.getImage());

			preparedStatement.executeUpdate();

			System.out.println("Ajout de " + aAjouter.getNom() + " réussi avec succès !");
		} catch (SQLException e) {
		}
	}

	
	public static void InnerStatcards(Statcards aAjouter) {
		String sql = "INSERT INTO statcards () VALUES(?,?,?,?,?,?)";
		try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			preparedStatement.setString(1, aAjouter.getJoueurs().getNom());
			preparedStatement.setInt(2, aAjouter.getMatchs().getMatchID());
			preparedStatement.setString(3, aAjouter.getTDJeu());
			preparedStatement.setString(4, aAjouter.getPoints());
			preparedStatement.setInt(5, aAjouter.getRebonds());
			preparedStatement.setInt(6, aAjouter.getPasse_D());

			preparedStatement.executeUpdate();

			System.out.println("Ajout de la statcards" + aAjouter.getJoueurs() + " réussi avec succès !");
		} catch (SQLException e) {
		}
	}
	
	
	public static Matchs SelectionMatchByID(String idmatch) {
		String request = "SELECT * FROM matchs WHERE MatchID = '" + idmatch + "';";
		try {
			Statement requete = con.createStatement();
			ResultSet resultat = requete.executeQuery(request);
			
			while (resultat.next()) {
				Matchs match = new Matchs(resultat.getInt("MatchID"), resultat.getString("Adversaire"), resultat.getString("Date"), resultat.getString("Lieu"), resultat.getString("Resultat"), resultat.getString("DifScore")); // typedechet et habitation
				return match;
			};
		} 
		catch (Exception e) {
			System.out.println("Errreur : ");
			System.out.println(e);
		}
		return null;
	}
	
	public static Joueurs SelectionJoueurByNom(String nom) {
		String request = "SELECT * FROM joueurs WHERE nom = '" + nom + "';";
		try {
			Statement requete = con.createStatement();
			ResultSet resultat = requete.executeQuery(request);
			
			while (resultat.next()) {
				Joueurs joueur = new Joueurs(resultat.getString("nom"), resultat.getString("prenom"), resultat.getInt("age"), resultat.getInt("poid"), resultat.getInt("taille"), resultat.getURL("image"));
				return joueur;
			};
		} 
		catch (Exception e) {
			System.out.println("Errreur : ");
			System.out.println(e);
		}
		return null;
	}
	
	public static ArrayList<Joueurs> SelectionTousJoueurs() {
		ArrayList<Joueurs> listeJoueur = new ArrayList<Joueurs>();
		String request = "SELECT * FROM joueurs;";
		
		try {
			Statement requete = con.createStatement();
			ResultSet resultat = requete.executeQuery(request);
			
			while (resultat.next()) {
				Joueurs joueur = new Joueurs(resultat.getString("nom"), resultat.getString("prenom"), resultat.getInt("age"), resultat.getInt("poid"), resultat.getInt("taille"), resultat.getURL("image"));
				listeJoueur.add(joueur);
			};
				return listeJoueur;
		} 
		catch (Exception e) {
			System.out.println("Errreur : ");
			System.out.println(e);
		}
		return null;
	}
}
