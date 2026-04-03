import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class affichageJoueurs extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnBack;
	private JButton btnSelection;
	private String valeurSelection;
	private DefaultTableModel model1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					affichageJoueurs frame = new affichageJoueurs();
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
	public affichageJoueurs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane(getTable());
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 10, 300, 200);
		contentPane.add(scrollPane);
		contentPane.add(getBtnBack());
		contentPane.add(getBtnSelection());
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			model1 = new DefaultTableModel() {
			    /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
			    public boolean isCellEditable(int row, int column) { //Empecher l'édition de la table
			        return false;
			    }
			};
			model1.addColumn("Prénom");
			model1.addColumn("Nom");

			ArrayList<Joueurs> listeJoueur = API.SelectionTousJoueurs();

			for (Joueurs j : listeJoueur) {
//			    System.out.println(j);
				model1.addRow(new Object[] { j.getPrenom(), j.getNom()});
			}

			table.setModel(model1);
			table.setBounds(10, 10, 300, 200);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return table;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Retour");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accueil accueil = new accueil();
					accueil.setVisible(true);
					dispose();
				}
			});
			btnBack.setBounds(320, 152, 104, 23);
		}
		return btnBack;
	}
	private JButton getBtnSelection() {
		if (btnSelection == null) {
			btnSelection = new JButton("Card joueur");
			btnSelection.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (table.getSelectedColumn() >= 0) {
						valeurSelection = model1.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString();
						System.out.println(valeurSelection);
					}
					
					informationsJoueur accueil = new informationsJoueur(valeurSelection);
					accueil.setVisible(true);
				}
			});
			btnSelection.setBounds(320, 97, 104, 23);
		}
		return btnSelection;
	}
}
