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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class A_Testigo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField Nombre;
	private JTextField DNI;

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
		
		Nombre = new JTextField();
		Nombre.setForeground(new Color(108, 108, 108));
		Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		Nombre.setText("Nombre");
		Nombre.setBounds(135, 41, 102, 30);
		panel.add(Nombre);
		Nombre.setColumns(10);
		
		DNI = new JTextField();
		DNI.setForeground(new Color(108, 108, 108));
		DNI.setHorizontalAlignment(SwingConstants.CENTER);
		DNI.setText("DNI");
		DNI.setBounds(135, 82, 102, 30);
		panel.add(DNI);
		DNI.setColumns(10);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(195, 195, 89, 23);
		panel.add(botonAceptar);
		
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(78, 195, 89, 23);
		panel.add(botonCancelar);
		
		JTextPane txtpnTestimonio = new JTextPane();
		txtpnTestimonio.setForeground(new Color(108, 108, 108));
		txtpnTestimonio.setText("Testimonio");
		txtpnTestimonio.setBounds(119, 123, 139, 48);
		panel.add(txtpnTestimonio);
		
		List list = new List();
		list.setBounds(10, 10, 165, 379);
		list.setBackground(new Color(50, 49, 78));
		contentPanel.add(list);
	}
}
