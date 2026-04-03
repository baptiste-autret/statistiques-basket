import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class accueil extends JFrame {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btn_joueurs;
	private JButton btn_matchs;
	private JButton btn_stats;
	private accueil frame;
	private ArrayList<Joueurs> listJoueurs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accueil frame = new accueil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public accueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtn_joueurs());
		contentPane.add(getBtn_matchs());
		contentPane.add(getBtn_stats());
	}

	private JButton getBtn_joueurs() {
		if (btn_joueurs == null) {
			btn_joueurs = new JButton("Joueurs");
			btn_joueurs.setBounds(125, 50, 169, 23);
			btn_joueurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					affichageJoueurs informations = new affichageJoueurs();
					informations.setVisible(true);
					dispose();
				}
			});
		}
		return btn_joueurs;
	}
	private JButton getBtn_matchs() {
		if (btn_matchs == null) {
			btn_matchs = new JButton("Matchs");
			btn_matchs.setBounds(125, 111, 169, 23);
		}
		return btn_matchs;
	}
	private JButton getBtn_stats() {
		if (btn_stats == null) {
			btn_stats = new JButton("Stats");
			btn_stats.setBounds(125, 174, 169, 23);
		}
		return btn_stats;
	}
}
