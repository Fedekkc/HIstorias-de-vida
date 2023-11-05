package interfaz;

import javax.swing.JPanel;



import javax.swing.JScrollBar;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dao_ccdtye.Dao_CCDTyE;
import dao_fuerzas.Dao_Fuerzas;
import entidades.CCDTyE;
import entidades.Fuerza;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JFormattedTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;


//import org.jdatepicker.JDatePicker;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;





public class add_Detenido_Identificado extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JTextField txtTiempoEnCautiverio;

	/**
	 * Create the panel.
	 */
	public add_Detenido_Identificado() {
		setMinimumSize(new Dimension(880, 560));
		setBackground(new Color(138, 135, 169));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 49, 78));
		panel.setBounds(222, 96, 479, 349);
		add(panel);
		panel.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
		txtNombre.setToolTipText("Nombre");
		txtNombre.setBounds(10, 50, 188, 26);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setText("DNI");
		txtDNI.setBounds(10, 87, 188, 26);
		panel.add(txtDNI);
		txtDNI.setColumns(10);
		
		JTextPane txtBiografiaPersonal = new JTextPane();
		txtBiografiaPersonal.setBounds(208, 50, 261, 230);
		panel.add(txtBiografiaPersonal);
		
		JComboBox cbLugarDeSecuestro = new JComboBox();
		cbLugarDeSecuestro.setBounds(10, 124, 188, 22);
		panel.add(cbLugarDeSecuestro);
		
		txtTiempoEnCautiverio = new JTextField();
		txtTiempoEnCautiverio.setText("Tiempo en cautiverio");
		txtTiempoEnCautiverio.setBounds(10, 157, 188, 20);
		panel.add(txtTiempoEnCautiverio);
		txtTiempoEnCautiverio.setColumns(10);
		
		JCheckBox chckbxSeEncuentraAparecido = new JCheckBox("Es aparecido");
		chckbxSeEncuentraAparecido.setBounds(10, 188, 188, 23);
		panel.add(chckbxSeEncuentraAparecido);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(10, 257, 89, 23);
		panel.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(109, 257, 89, 23);
		panel.add(btnCancelar);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 218, 188, 20);
		panel.add(dateChooser);

	}
}
