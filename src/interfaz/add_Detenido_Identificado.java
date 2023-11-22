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
import java.awt.Panel;



public class add_Detenido_Identificado extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JTextField textField;
    private DefaultListModel<CCDTyE> listModel;
    private Dao_CCDTyE Dao;
    private JLabel centrosLabel;
    private ArrayList<CCDTyE> ccdtyeArray;

	/**
	 * Create the panel.
	 */
	public add_Detenido_Identificado() {
		setMinimumSize(new Dimension(880, 560));
		setBackground(new Color(138, 135, 169));
		setLayout(null);
		ccdtyeArray = new ArrayList<>();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 49, 78));
		panel.setBounds(298, 74, 479, 349);
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
		txtBiografiaPersonal.setBounds(208, 25, 261, 148);
		panel.add(txtBiografiaPersonal);
		
		JComboBox cbLugarDeSecuestro = new JComboBox();
		cbLugarDeSecuestro.setBounds(10, 99, 188, 22);
		Dao_Lugares_de_secuestro dao = new Dao_Lugares_de_secuestro();
		ArrayList<String> listaLugares = new ArrayList<>();
		listaLugares = dao.getAllLugares_de_Secuestro();
		for (int i = 0; i <= listaLugares.size() - 1; i++) {
			cbLugarDeSecuestro.addItem(listaLugares.get(i));
		}
		cbLugarDeSecuestro.setSelectedIndex(2);

		panel.add(cbLugarDeSecuestro);
		
		JCheckBox chckbxSeEncuentraAparecido = new JCheckBox("Es aparecido");
		chckbxSeEncuentraAparecido.setBounds(10, 128, 188, 23);
		panel.add(chckbxSeEncuentraAparecido);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 158, 188, 20);
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
		JLabel iconLabel = new JLabel("");
		iconLabel.setForeground(new Color(255, 255, 255));
		iconLabel.setFont(new Font("M PLUS 1p", Font.BOLD, 14));
		iconLabel.setBounds(53, 221, 416, 25);
		
		final String[] fileRoute = { null };
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
	                    fileRoute[0] = selectedFile.getAbsolutePath();
	                    } else {
	                    iconLabel.setText("No hay archivos seleccionados.");
	                }
	            }
	        });
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
				if(fileRoute[0] != null)
				{
					detenido.setRutaMaterialAudiovisual(fileRoute[0]);
				}
				else
				{
					detenido.setRutaMaterialAudiovisual(null);
				}
				
				LocalDate localDate = instant.atZone(zone).toLocalDate();
				detenido.setUltVezVisto(localDate);
				detenido.setLugarSecuestro(cbLugarDeSecuestro.getSelectedIndex()+1);
				System.out.println("HOLA COMOE STAS: " + String.valueOf(detenido.getLugarSecuestro()));
				detenido.setTiempoEnCautiverio(i);
				detenido.setCentros(ccdtyeArray);
				Dao.addDetenidoIdentificado(detenido);
				
				
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new AM_Identificados());
				marco.validate();
			
			}});	

		panel.add(btnGuardar);


		uploadButton.setBounds(10, 220, 34, 23);
		panel.add(uploadButton);
		

		panel.add(iconLabel);
		
		JLabel centrosLabel = new JLabel("-");
		centrosLabel.setForeground(new Color(255, 255, 255));
		centrosLabel.setBackground(new Color(255, 255, 255));
		centrosLabel.setBounds(10, 189, 459, 20);
		panel.add(centrosLabel);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(50, 49, 78));
		panel_3.setBounds(27, 23, 238, 451);
		add(panel_3);
		panel_3.setLayout(null);
		

		
        listModel = new DefaultListModel<>(); // Inicializa listModel
        Dao = new Dao_CCDTyE();
        ArrayList<CCDTyE> centros = Dao.getAllCCDTyE();
        for (CCDTyE ccdTyE : centros) {
            listModel.addElement(ccdTyE);
        }
        
        setLayout(null);
        JList<CCDTyE> list = new JList<>(listModel);
        list.setBackground(new Color(0, 0, 26));
        list.setFont(new Font("M PLUS 1p", Font.BOLD, 12));
        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof CCDTyE) {
                    CCDTyE ccdTyE = (CCDTyE) value;
                    setText(ccdTyE.getNombre());
                }
                return this;
            }
        });
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 67, 218, 339);
		panel_3.add(scrollPane);
		textField = new JTextField();
		textField.setBounds(10, 24, 218, 32);
		textField.setForeground(new Color(217, 217, 217));
		textField.setColumns(10);
		textField.setBackground(new Color(0, 0, 26));
		panel_3.add(textField);
		
		JButton addButton = new JButton("Añadir");
		addButton.setBounds(10, 417, 80, 23);
		addButton.setForeground(new Color(217, 217, 217));
		addButton.setBackground(new Color(0, 0, 26));
		panel_3.add(addButton);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		lblNewLabel_1.setForeground(new Color(217, 217, 217));
		panel_3.add(lblNewLabel_1);
		
		JButton deleteButton = new JButton("Eliminar");
		deleteButton.setForeground(new Color(217, 217, 217));
		deleteButton.setBackground(new Color(0, 0, 26));
		deleteButton.setBounds(148, 417, 80, 23);
		panel_3.add(deleteButton);
		
	      addButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                CCDTyE selectedCCD = list.getSelectedValue();
	                if (selectedCCD != null) {
	                    // Añadir el nombre al label
	                    String currentText = centrosLabel.getText();
	                    if (currentText.equals("-")) {
	                        centrosLabel.setText(selectedCCD.getNombre());
	                    } else {
	                        centrosLabel.setText(currentText + ", " + selectedCCD.getNombre());
	                    }

	                    // Añadir el CCDTyE al ArrayList ccdtyeArray
	                    ccdtyeArray.add(selectedCCD);
	                }
	            }
	        });
	      
	      deleteButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if (!ccdtyeArray.isEmpty()) {
	                    // Eliminar el último CCDTyE del ArrayList ccdtyeArray
	                    ccdtyeArray.remove(ccdtyeArray.size() - 1);

	                    // Actualizar el label con los CCDTyE restantes
	                    if (!ccdtyeArray.isEmpty()) {
	                        StringBuilder newText = new StringBuilder();
	                        for (CCDTyE ccdTyE : ccdtyeArray) {
	                            newText.append(ccdTyE.getNombre()).append(", ");
	                        }
	                        newText.delete(newText.length() - 2, newText.length());  // Eliminar la última coma
	                        centrosLabel.setText(newText.toString());
	                    } else {
	                        centrosLabel.setText("-");
	                    }
	                }
	            }
	        });
	}
}
