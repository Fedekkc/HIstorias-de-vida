package interfaz;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JButton;

public class Menu_Personas extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Menu_Personas() {
		setBackground(new Color(138, 135, 169));
		setForeground(new Color(138, 135, 169));
		setMinimumSize(new Dimension(880, 560));
		setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(12, 12, 34));
		panel.setBounds(50, 59, 300, 442);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IDENTIFICADOS");
		lblNewLabel.setFont(new Font("M PLUS 1p", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(217, 217, 217));
		lblNewLabel.setBounds(10, 11, 280, 36);
		panel.add(lblNewLabel);
		
		JScrollBar identificadosScrollBar = new JScrollBar();
		identificadosScrollBar.setBounds(53, 68, 197, 305);
		panel.add(identificadosScrollBar);
		
		JButton addButton = new JButton("Añadir");
		addButton.setBounds(40, 397, 89, 23);
		panel.add(addButton);
		
		JButton viewButton = new JButton("Ver");
		viewButton.setBounds(175, 397, 89, 23);
		panel.add(viewButton);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(12, 12, 34));
		panel_1.setBounds(511, 59, 300, 442);
		add(panel_1);
		
		JLabel lblNoIdentificados = new JLabel("NO IDENTIFICADOS");
		lblNoIdentificados.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoIdentificados.setForeground(new Color(217, 217, 217));
		lblNoIdentificados.setFont(new Font("M PLUS 1p", Font.BOLD, 24));
		lblNoIdentificados.setBounds(10, 11, 280, 36);
		panel_1.add(lblNoIdentificados);
		
		JButton addButton_1 = new JButton("Añadir");
		addButton_1.setBounds(39, 392, 89, 23);
		panel_1.add(addButton_1);
		
		JButton viewButton_1 = new JButton("Ver");
		viewButton_1.setBounds(184, 392, 89, 23);
		panel_1.add(viewButton_1);
		
		JScrollBar noIdentificadosScrollBar = new JScrollBar();
		noIdentificadosScrollBar.setBounds(53, 68, 197, 305);
		panel_1.add(noIdentificadosScrollBar);

	}
}
