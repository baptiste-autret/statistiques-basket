import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GestionXML {

	// -------------------------------------------------------------
	// UTILITAIRES
	// -------------------------------------------------------------

	public static ArrayList<Joueurs> lireFichierXMLJoueur(String nomFichier) {
		ArrayList<Joueurs> listeJoueurs = new ArrayList<>();
		try {

			File fichier = new File(nomFichier + ".xml");
			if (!fichier.exists()) {
				System.out.println("Le fichier n'existe pas !");
				return null;
			}
			if (fichier.length() == 0) {
				System.out.println("Le fichier est vide !");
				return null;
			}

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(fichier);
			document.getDocumentElement().normalize();

			NodeList nodeList = document.getElementsByTagName("joueur");

			if (nodeList.getLength() == 0) {
				System.out.println("Aucun langage trouvé dans le fichier.");
				return null;
			}

//			System.out.println("\nContenu du fichier XML Joueurs :");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					// Vérifie la présence de chaque balise avant de l'utiliser
					Node nomNode = element.getElementsByTagName("Nom").item(0);
					Node prenomNode = element.getElementsByTagName("Prenom").item(0);
					Node ageNode = element.getElementsByTagName("Age").item(0);
					Node poidsNode = element.getElementsByTagName("Poids").item(0);
					Node tailleNode = element.getElementsByTagName("Taille").item(0);
					Node imageNode = element.getElementsByTagName("Image").item(0);

					String nom = nomNode.getTextContent().trim();
					String prenom = prenomNode.getTextContent().trim();
					int age = Integer.parseInt(ageNode.getTextContent().trim());
					int poids = Integer.parseInt(poidsNode.getTextContent().trim());
					int taille = Integer.parseInt(tailleNode.getTextContent().trim());
					URL image = new URL(imageNode.getTextContent().trim());

					Joueurs l = new Joueurs(nom, prenom, age, poids, taille, image);
					listeJoueurs.add(l);
//					System.out.println(l);

				}
			}
		} catch (Exception e) {
			System.out.println("Erreur lors de la lecture du fichier XML");
			e.printStackTrace();
		}
		return listeJoueurs;
	}

	public static ArrayList<Matchs> lireFichierXMLMatchs(String nomFichier) {
		ArrayList<Matchs> listeMatchs = new ArrayList<>();
		try {

			File fichier = new File(nomFichier + ".xml");
			if (!fichier.exists()) {
				System.out.println("Le fichier n'existe pas !");
				return null;
			}
			if (fichier.length() == 0) {
				System.out.println("Le fichier est vide !");
				return null;
			}

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(fichier);
			document.getDocumentElement().normalize();

			NodeList nodeList = document.getElementsByTagName("match");

			if (nodeList.getLength() == 0) {
				System.out.println("Aucun match trouvé dans le fichier.");
				return null;
			}

//			System.out.println("\nContenu du fichier XML Matchs :");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					// Vérifie la présence de chaque balise avant de l'utiliser
					Node matchIDNode = element.getElementsByTagName("MatchID").item(0);
					Node adversaireNode = element.getElementsByTagName("Adversaire").item(0);
					Node dateNode = element.getElementsByTagName("Date").item(0);
					Node lieuNode = element.getElementsByTagName("Lieu").item(0);
					Node resultatNode = element.getElementsByTagName("Resultat").item(0);
					Node difScoreNode = element.getElementsByTagName("DiffScore").item(0);

					int matchID = Integer.parseInt(matchIDNode.getTextContent().trim());
					String adversaire = adversaireNode.getTextContent().trim();
					String date = dateNode.getTextContent().trim();
					String lieu = lieuNode.getTextContent().trim();
					String resultat = resultatNode.getTextContent().trim();
					String difScore = difScoreNode.getTextContent().trim();

					Matchs l = new Matchs(matchID, adversaire, date, lieu, resultat, difScore);
					listeMatchs.add(l);
//					System.out.println(l);
				}
			}
		} catch (Exception e) {
			System.out.println("Erreur lors de la lecture du fichier XML");
			e.printStackTrace();
		}
		return listeMatchs;
	}
	
	public static Joueurs getJoueur(String nom) {
		
		return null;
	}

//	public static ArrayList<Statcards> lireFichierXMLStatcards(String nomFichier) {
//		ArrayList<Statcards> listeStatcards = new ArrayList<>();
//		try {
//
//			File fichier = new File(nomFichier + ".xml");
//			if (!fichier.exists()) {
//				System.out.println("Le fichier n'existe pas !");
//				return null;
//			}
//			if (fichier.length() == 0) {
//				System.out.println("Le fichier est vide !");
//				return null;
//			}
//
//			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder builder = factory.newDocumentBuilder();
//			Document document = builder.parse(fichier);
//			document.getDocumentElement().normalize();
//
//			NodeList nodeList = document.getElementsByTagName("Stats");
//
//			if (nodeList.getLength() == 0) {
//				System.out.println("Aucune stats trouvée dans statcards");
//				return null;
//			}
//
////			System.out.println("\nContenu du fichier XML Statcards :");
//			for (int i = 0; i < nodeList.getLength(); i++) {
//				Node node = nodeList.item(i);
//				if (node.getNodeType() == Node.ELEMENT_NODE) {
//					Element element = (Element) node;
//
//					// Vérifie la présence de chaque balise avant de l'utiliser
//					Node nomNode = element.getElementsByTagName("Nom").item(0);
//					Node matchIDNode = element.getElementsByTagName("MatchID").item(0);
//					Node TDJeuNode = element.getElementsByTagName("TDJeu").item(0);
//					Node pointsNode = element.getElementsByTagName("Points").item(0);
//					Node rebondsNode = element.getElementsByTagName("Rebonds").item(0);
//					Node passeDNode = element.getElementsByTagName("Passe_D").item(0);
//
//					Joueurs joueur = API.SelectionJoueurByNom(nomNode.getTextContent());
//					Matchs match = API.SelectionMatchByID(matchIDNode.getTextContent());
//					String TDJeu = TDJeuNode.getTextContent().trim();
//					String points = pointsNode.getTextContent().trim();
//					int rebonds = Integer.parseInt(rebondsNode.getTextContent().trim());
//					int passeD = Integer.parseInt(passeDNode.getTextContent().trim());
//
//					Statcards l = new Statcards(joueur, match, TDJeu, points, rebonds, passeD);
//					listeStatcards.add(l);
////					System.out.println(l);
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("Erreur lors de la lecture du fichier XML");
//			e.printStackTrace();
//		}
//		return listeStatcards;
//	}
}
