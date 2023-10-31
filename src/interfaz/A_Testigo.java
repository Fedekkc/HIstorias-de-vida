package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.List;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

public class A_Testigo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			A_Testigo dialog = new A_Testigo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public A_Testigo() {
		setBackground(new Color(138, 135, 169));
		setMinimumSize(new Dimension(400, 400));
		setBounds(100, 100, 658, 438);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(138, 135, 169));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(212, 70, 348, 257);
		panel.setBackground(new Color(50, 49, 78));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		List list = new List();
		list.setBounds(10, 10, 165, 379);
		list.setBackground(new Color(50, 49, 78));
		contentPanel.add(list);
	}
}
