package interfaz;

import javax.swing.JPanel;



import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.io.File;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileSystemView;

import dao_ccdtye.Dao_CCDTyE;
import dao_fuerzas.Dao_Fuerzas;
import entidades.CCDTyE;
import entidades.Fuerza;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JFormattedTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;


//import org.jdatepicker.JDatePicker;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;

import dao_detenido_identificado.Dao_Detenido_Identificado;
import entidades.DetenidoIdentificado;
import dao_detenido_identificado.Dao_Lugares_de_secuestro;



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
		txtNombre.setBounds(10, 25, 188, 26);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setText("DNI");
		txtDNI.setBounds(10, 62, 188, 26);
		panel.add(txtDNI);
		txtDNI.setColumns(10);
		
		JTextPane txtBiografiaPersonal = new JTextPane();
		txtBiografiaPersonal.setMaximumSize(new Dimension(20, 20));
		txtBiografiaPersonal.setBounds(208, 25, 261, 185);
		panel.add(txtBiografiaPersonal);
		
		JComboBox cbLugarDeSecuestro = new JComboBox();
		cbLugarDeSecuestro.setBounds(10, 99, 188, 22);
		Dao_Lugares_de_secuestro dao = new Dao_Lugares_de_secuestro();
		ArrayList<String> listaLugares = new ArrayList<>();
		listaLugares = dao.getAllLugares_de_Secuestro();
		for (int i = 1; i <= listaLugares.size() - 1; i++) {
			cbLugarDeSecuestro.addItem(listaLugares.get(i));
		}
		panel.add(cbLugarDeSecuestro);
		
		txtTiempoEnCautiverio = new JTextField();
		txtTiempoEnCautiverio.setText("Tiempo en cautiverio");
		txtTiempoEnCautiverio.setBounds(10, 132, 188, 20);
		panel.add(txtTiempoEnCautiverio);
		txtTiempoEnCautiverio.setColumns(10);
		
		JCheckBox chckbxSeEncuentraAparecido = new JCheckBox("Es aparecido");
		chckbxSeEncuentraAparecido.setBounds(10, 159, 188, 23);
		panel.add(chckbxSeEncuentraAparecido);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 189, 188, 20);
		panel.add(dateChooser);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(109, 257, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new AM_Identificados());
				marco.validate();
			}
		});
		panel.add(btnCancelar);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(10, 257, 89, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dao_Detenido_Identificado Dao = new Dao_Detenido_Identificado();
				DetenidoIdentificado detenido = new DetenidoIdentificado();
				
				int i = Integer.parseInt(txtTiempoEnCautiverio.getText());
				detenido.setNombre(txtNombre.getText());
				detenido.setDNI(txtDNI.getText());
				detenido.setBiografiaPersonal(txtBiografiaPersonal.getText());
				Date date = dateChooser.getDate();
				Instant instant = date.toInstant();
				ZoneId zone = ZoneId.systemDefault();
				LocalDate localDate = instant.atZone(zone).toLocalDate();
				detenido.setUltVezVisto(localDate);
				detenido.setLugarSecuestro(cbLugarDeSecuestro.getSelectedIndex());;
				detenido.setTiempoEnCautiverio(i);
				Dao.addDetenidoIdentificado(detenido);
				
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new AM_Identificados());
				marco.validate();
			
			}});	
		JLabel iconLabel = new JLabel("");
		iconLabel.setForeground(new Color(255, 255, 255));
		iconLabel.setFont(new Font("M PLUS 1p", Font.BOLD, 14));
		iconLabel.setBounds(53, 221, 416, 25);
		panel.add(btnGuardar);
		JButton uploadButton = new JButton("...");
	       uploadButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                JFileChooser fileChooser = new JFileChooser();
	                // Configurar el diálogo para permitir solo la selección de archivos
	                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	                
	                int result = fileChooser.showOpenDialog(panel);
	                
	                
	                if (result == JFileChooser.APPROVE_OPTION) {
	                    File selectedFile = fileChooser.getSelectedFile();
	                    Icon fileIcon = FileSystemView.getFileSystemView().getSystemIcon(selectedFile);
	                    iconLabel.setIcon(fileIcon);
	                    iconLabel.setText(selectedFile.getName());	 
	                    } else {
	                    iconLabel.setText("No hay archivos seleccionados.");
	                }
	            }
	        });

		uploadButton.setBounds(10, 220, 34, 23);
		panel.add(uploadButton);
		

		panel.add(iconLabel);
	}
}
