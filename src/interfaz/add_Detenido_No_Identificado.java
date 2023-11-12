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
import javax.swing.SwingConstants;





public class add_Detenido_No_Identificado extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;

	/**
	 * Create the panel.
	 */
	public add_Detenido_No_Identificado() {
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
		panel.setBounds(222, 105, 479, 349);
		add(panel);
		panel.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setToolTipText("Apodo");
		txtNombre.setBounds(147, 35, 185, 26);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar\r\n");
		btnGuardar.setBounds(270, 300, 89, 23);

		
		panel.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar\r\n");
		btnCancelar.setBounds(128, 300, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new ViewCCDTyE());
				marco.validate();
			}});
		
		panel.add(btnCancelar);
		
		JTextPane txtpnDescripcinSignificativa = new JTextPane();
		txtpnDescripcinSignificativa.setToolTipText("Descripción");
		txtpnDescripcinSignificativa.setBounds(128, 97, 231, 123);
		panel.add(txtpnDescripcinSignificativa);
		
		JButton btnAadirTestigo = new JButton("Añadir Testigo");
		btnAadirTestigo.setBounds(178, 251, 123, 23);
		panel.add(btnAadirTestigo);
		
		btnAadirTestigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            A_Testigo dialog = new A_Testigo();
	            dialog.setVisible(true);
				
			}
			
		});
		
		JLabel lblNewLabel = new JLabel("Descripción Significativa\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(128, 72, 231, 14);
		panel.add(lblNewLabel);
		
		JLabel lblApodo = new JLabel("Apodo");
		lblApodo.setHorizontalAlignment(SwingConstants.CENTER);
		lblApodo.setForeground(Color.WHITE);
		lblApodo.setBounds(147, 11, 185, 14);
		panel.add(lblApodo);
        
		

	}
}
