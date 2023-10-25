package interfaz;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JList;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTextField;

import dao_ccdtye.Dao_CCDTyE;
import entidades.CCDTyE;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;

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
		setBackground(new Color(138, 135, 169));
		setLayout(null);
		
		DefaultListModel<CCDTyE> listModel = new DefaultListModel<>();
        ArrayList<CCDTyE> centros = new ArrayList<CCDTyE>();
        Dao_CCDTyE dao = new Dao_CCDTyE();
        centros = dao.getAllCCDTyE();
        for (CCDTyE ccdTyE : centros) {
            listModel.addElement(ccdTyE);
        }
		JList list = new JList();
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setBackground(new Color(50, 49, 78));
		list.setBounds(26, 11, 152, 538);
		add(list);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 49, 78));
		panel.setBounds(300, 100, 479, 349);
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
		panel.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar\r\n");
		btnCancelar.setBounds(300, 299, 89, 23);
		panel.add(btnCancelar);
		
		JComboBox cboxFuerzasACargo = new JComboBox();
		cboxFuerzasACargo.setToolTipText("Fuerzas a cargo");
		cboxFuerzasACargo.setBounds(10, 223, 459, 22);
		panel.add(cboxFuerzasACargo);

	}
}
