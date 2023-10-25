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
import java.util.ArrayList;

import javax.swing.JTextField;

import dao_ccdtye.Dao_CCDTyE;
import dao_fuerzas.Dao_Fuerzas;
import entidades.CCDTyE;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JFormattedTextField;




public class add_CCDTyE extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtUbicacion;
	private JTextField txtFechaDeInicio;
	private JTextField txtFechaDeSuspension;

	/**
	 * Create the panel.
	 */
	public add_CCDTyE() {
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
		txtNombre.setText("Nombre");
		txtNombre.setToolTipText("Nombre");
		txtNombre.setBounds(10, 30, 459, 26);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtUbicacion = new JTextField();
		txtUbicacion.setText("Ubicacion");
		txtUbicacion.setToolTipText("Ubicacion");
		txtUbicacion.setColumns(10);
		txtUbicacion.setBounds(10, 89, 459, 26);
		panel.add(txtUbicacion);
		
		txtFechaDeInicio = new JTextField();
		txtFechaDeInicio.setText("Fecha de inicio");
		txtFechaDeInicio.setColumns(10);
		txtFechaDeInicio.setBounds(10, 159, 188, 26);
		panel.add(txtFechaDeInicio);
		
		txtFechaDeSuspension = new JTextField();
		txtFechaDeSuspension.setText("Fecha de Suspension");
		txtFechaDeSuspension.setColumns(10);
		txtFechaDeSuspension.setBounds(281, 159, 188, 26);
		panel.add(txtFechaDeSuspension);
		
		JButton btnGuardar = new JButton("Guardar\r\n");
		btnGuardar.setBounds(80, 299, 89, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dao_CCDTyE Dao = new Dao_CCDTyE();
				CCDTyE ccdtye = new CCDTyE();
				
				ccdtye.setNombre();
				ccdtye.setUbicacion();
				//ccdtye.setFechaPuestaEnMarcha(null);
				//ccdtye.setFechaCierre(null);
				
				
				
				
				
				Dao.addCCDTyE(ccdtye);
			
			}});
		
		panel.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar\r\n");
		btnCancelar.setBounds(300, 299, 89, 23);
		panel.add(btnCancelar);
		
		JComboBox cboxFuerzasACargo = new JComboBox();
		cboxFuerzasACargo.setToolTipText("Fuerzas a cargo");
		cboxFuerzasACargo.setBounds(10, 223, 459, 22);
		panel.add(cboxFuerzasACargo);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(10, 196, 188, 20);
		panel.add(formattedTextField);
		Dao_Fuerzas Dao = new Dao_Fuerzas();
        ArrayList<String> nombresFuerzas = Dao.getAllFuerzas(); // Supongamos que tienes un método getAllFuerzasNames() que devuelve los nombres de todas las fuerzas
        for (String nombre : nombresFuerzas) {
            cboxFuerzasACargo.addItem(nombre);
        }

	}
}
