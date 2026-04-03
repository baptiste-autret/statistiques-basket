import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class informationsJoueur extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAge;
	private JLabel lblTaille;
	private JLabel lblPoid;
	private JButton btnRetour;
	private String prenomJoueur;
	private String nomJoueur;
	private Joueurs joueur;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lbl_imageJoueur;

	/**
	 * Launch the application.
	 * 
	 * @wbp.parser.constructor
	 */

	public informationsJoueur(String prenomJoueur, String nomJoueur, Joueurs joueur) throws HeadlessException {
		super();
		this.prenomJoueur = prenomJoueur;
		this.nomJoueur = nomJoueur;
		this.joueur = joueur;
		getContentPane().setLayout(null);
		getContentPane().add(getLbl_imageJoueur());
		getContentPane().add(getLblAge());
		getContentPane().add(getLblTaille());
		getContentPane().add(getLblPoid());
		
	}

	/**
	 * Create the frame.
	 */
	public informationsJoueur(String nom) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		nomJoueur = nom;

		joueur = API.SelectionJoueurByNom(nomJoueur);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblAge());
		contentPane.add(getLblTaille());
		contentPane.add(getLblPoid());
		contentPane.add(getBtnRetour());
	}

	private JLabel getLblAge() {
		if (lblAge == null) {
			lblAge = new JLabel("Age : " + joueur.getAge());
			lblAge.setBounds(200, 104, 75, 14);
		}
		return lblAge;
	}

	private JLabel getLblTaille() {
		if (lblTaille == null) {
			lblTaille = new JLabel("Taille : " + joueur.getTaille());
			lblTaille.setBounds(200, 80, 75, 14);
		}
		return lblTaille;
	}

	private JLabel getLblPoid() {
		if (lblPoid == null) {
			lblPoid = new JLabel("Poid : " + joueur.getPoid() + " kg");
			lblPoid.setBounds(200, 129, 75, 14);
		}
		return lblPoid;
	}

	private JButton getBtnRetour() {
		if (btnRetour == null) {
			btnRetour = new JButton("Retour");
			btnRetour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					affichageJoueurs pageAvant = new affichageJoueurs();
					pageAvant.setVisible(true);
					dispose();
				}
			});
			btnRetour.setBounds(162, 192, 89, 23);
		}
		return btnRetour;
	}

	private JLabel getLbl_imageJoueur() {
		if (lbl_imageJoueur == null) {
			lbl_imageJoueur = new JLabel("mdr");
			lbl_imageJoueur.setIcon(new ImageIcon(joueur.getImage()));
			lbl_imageJoueur.setBounds(200, 11, 46, 14);
		}
		return lbl_imageJoueur;
	}
}
