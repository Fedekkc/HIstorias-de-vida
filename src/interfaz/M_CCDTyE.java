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
import javax.swing.JDialog;
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



public class M_CCDTyE extends JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
    private JTextField txtUbicacion;
    private CCDTyE ccdTyE; // Variable para almacenar el CCDTyE seleccionado


	/**
	 * Create the panel.
	 */
	public M_CCDTyE(CCDTyE ccdtye) {
		this.ccdTyE = ccdtye;
		setMinimumSize(new Dimension(880, 560));
		setBackground(new Color(138, 135, 169));
		setLayout(null);
		
		DefaultListModel<CCDTyE> listModel = new DefaultListModel<>();
        ArrayList<CCDTyE> centros = new ArrayList<CCDTyE>();
        Dao_CCDTyE dao = new Dao_CCDTyE();
        centros = dao.getAllCCDTyE();
        for (CCDTyE ccdTyE : centros) {
            listModel.addElement(ccdTyE);
        }
        JList<CCDTyE> list = new JList<>(listModel);
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
		list.setBounds(21, 38, 187, 451);
		list.setBackground(new Color(50, 49, 78));
		//contentPane.add(list);
		list.setAlignmentY(Component.TOP_ALIGNMENT);
		list.setAlignmentX(Component.RIGHT_ALIGNMENT);
		list.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setForeground(new Color(217, 217, 217));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 49, 78));
		panel.setBounds(222, 96, 479, 349);
		add(panel);
		panel.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setText(ccdtye.getNombre());
		txtNombre.setToolTipText("Nombre");
		txtNombre.setBounds(10, 30, 459, 26);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtUbicacion = new JTextField(ccdtye.getUbicacion());
		txtUbicacion.setToolTipText("Ubicacion");
		txtUbicacion.setColumns(10);
		txtUbicacion.setBounds(10, 89, 459, 26);
		panel.add(txtUbicacion);
		
		JButton btnGuardar = new JButton("Guardar\r\n");
		btnGuardar.setBounds(80, 299, 89, 23);

		
		panel.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar\r\n");
		btnCancelar.setBounds(300, 299, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor((Component) e.getSource());
		        dialog.dispose();
		    }
		});
		
		panel.add(btnCancelar);
		
		JDateChooser dateChooser = new JDateChooser();
		LocalDate localDate = ccdtye.getFechaPuestaEnMarcha();
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		dateChooser.setDate(date);
		dateChooser.setBounds(10, 159, 188, 26);
		panel.add(dateChooser);
		
		JLabel lblNewLabel = new JLabel("Fecha de puesta en Marcha");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 139, 146, 14);
		panel.add(lblNewLabel);
		
		JLabel lblFechaDeSuspensin = new JLabel("Fecha de suspensión");
		lblFechaDeSuspensin.setForeground(new Color(255, 255, 255));
		lblFechaDeSuspensin.setBackground(new Color(240, 240, 240));
		lblFechaDeSuspensin.setBounds(282, 139, 146, 14);
		panel.add(lblFechaDeSuspensin);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		localDate = ccdtye.getFechaCierre();
		date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		dateChooser_1.setDate(date);
		dateChooser_1.setBounds(281, 159, 188, 26);
		panel.add(dateChooser_1);
		

		
		
		
		JCheckBox chckbxPolicia = new JCheckBox("Policía"); // 1
		chckbxPolicia.setBounds(192, 219, 97, 23);
		
		panel.add(chckbxPolicia);
		
		JCheckBox chckbxEjercito = new JCheckBox("Ejercito"); // 2
		chckbxEjercito.setBounds(192, 273, 97, 23);
		panel.add(chckbxEjercito);
		
		JCheckBox chckbxGendarmeria = new JCheckBox("Gendarmeria"); // 3
		chckbxGendarmeria.setBounds(192, 247, 97, 23);
		panel.add(chckbxGendarmeria);
		
		ArrayList<Integer> fuerzas = new ArrayList<>(); 
		
		fuerzas = ccdtye.getFuerzasAlMando();
		
		for (int fuerza : fuerzas) {
		    if (fuerza == 1) {
		        chckbxPolicia.setSelected(true);
		    } else if (fuerza == 2) {
		        chckbxEjercito.setSelected(true);
		    } else if (fuerza == 3) {
		        chckbxGendarmeria.setSelected(true);
		    }
		}

		
		JLabel lblUbicacin = new JLabel("Ubicación");
		lblUbicacin.setForeground(Color.WHITE);
		lblUbicacin.setBounds(10, 67, 146, 14);
		panel.add(lblUbicacin);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(10, 11, 146, 14);
		panel.add(lblNombre);
		
		JLabel lblFuerzasAlMando = new JLabel("Fuerzas al mando");
		lblFuerzasAlMando.setForeground(Color.WHITE);
		lblFuerzasAlMando.setBounds(192, 198, 146, 14);
		panel.add(lblFuerzasAlMando);
        
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dao_CCDTyE Dao = new Dao_CCDTyE();
				
				ArrayList<Integer> fuerzasACargo = new ArrayList<Integer>();
				
				
				ccdtye.setNombre(txtNombre.getText());
				ccdtye.setUbicacion(txtUbicacion.getText());

				
				Date date = dateChooser.getDate();
				Instant instant = date.toInstant();
				ZoneId zone = ZoneId.systemDefault();
				LocalDate localDate = instant.atZone(zone).toLocalDate();
				ccdtye.setFechaCierre(localDate);
				Dao_Fuerzas daoFuerzas = new Dao_Fuerzas();
				if (chckbxPolicia.isSelected()) 
				{
					String name = chckbxPolicia.getText();
					int ID_Policia = daoFuerzas.getFuerzaID(name);
					fuerzasACargo.add(ID_Policia);
				}
				
				if (chckbxEjercito.isSelected()) 
				{
					String name = chckbxEjercito.getText();
					int ID_Ejercito = daoFuerzas.getFuerzaID(name);
					fuerzasACargo.add(ID_Ejercito);
				}
				if (chckbxGendarmeria.isSelected()) 
				{
					String name = chckbxGendarmeria.getText();
					int ID_Gendarmeria = daoFuerzas.getFuerzaID(name);
					fuerzasACargo.add(ID_Gendarmeria);
				}
				ccdtye.setFuerzasAlMando(fuerzasACargo);
				fuerzasACargo = ccdtye.getFuerzasAlMando();
				System.out.println(fuerzasACargo);
				//ccdtye.setFuerzasAlMando(fuerzasACargo);
				
				date = dateChooser_1.getDate();
				instant = date.toInstant();
				zone = ZoneId.systemDefault();
				localDate = instant.atZone(zone).toLocalDate();
				
				ccdtye.setFechaPuestaEnMarcha(localDate);
				
				Dao.addCCDTyE(ccdtye);
				//Dao.addFuerzas(ccdtye);
			
			}});

	}
}
