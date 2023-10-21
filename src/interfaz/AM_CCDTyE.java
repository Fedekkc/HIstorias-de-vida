package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import entidades.CCDTyE;
import dao_ccdtye.Dao_CCDTyE;

public class AM_CCDTyE extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AM_CCDTyE frame = new AM_CCDTyE();
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
	public AM_CCDTyE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		ArrayList<CCDTyE> centros = new ArrayList<CCDTyE>();
		Dao_CCDTyE dao = new Dao_CCDTyE();
		centros = dao.getAllCCDTyE();
		System.out.println("AAAA");
		for (CCDTyE ccdTyE : centros) {
			System.out.println(ccdTyE.getNombre());
			listModel.addElement(ccdTyE.getNombre());			
		}
		JList<String> list = new JList<>(listModel);

		
		JScrollPane scrollPane = new JScrollPane(list);
		contentPane.add(scrollPane);
	}

}
