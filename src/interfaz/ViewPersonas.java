package interfaz;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class ViewPersonas extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ViewPersonas() {
		setBackground(new Color(138, 135, 169));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(22, 11, 285, 364);
		add(scrollPane);
		
		JList list = new JList();
		list.setBackground(new Color(50, 49, 78));
		list.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		scrollPane.setViewportView(list);
		
		JButton btnVer = new JButton("Ver");
		btnVer.setBounds(22, 396, 89, 23);
		add(btnVer);
		
		JButton btnAñadir = new JButton("Añadir");
		btnAñadir.setBounds(218, 396, 89, 23);
		add(btnAñadir);

	}
}
