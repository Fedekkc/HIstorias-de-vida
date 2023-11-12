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
import dao_detenido_identificado.Dao_Detenido_No_Identificado;
import dao_testigos.Dao_testigos;
import dao_fuerzas.Dao_Fuerzas;
import entidades.CCDTyE;
import entidades.DetenidoNoIdentificado;
import entidades.Fuerza;
import entidades.Testigo;

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





public class M_Detenido_No_Identificado extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private DetenidoNoIdentificado detenido;

	/**
	 * Create the panel.
	 */
	public M_Detenido_No_Identificado(DetenidoNoIdentificado detenido) {
		this.detenido = detenido;
		Dao_testigos daoTestigos = new Dao_testigos();
		
		Testigo testigo = daoTestigos.getTestigoByID(detenido.getIdTestigo());
		
		setMinimumSize(new Dimension(880, 560));
		setBackground(new Color(138, 135, 169));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 49, 78));
		panel.setBounds(222, 105, 479, 349);
		add(panel);
		panel.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setToolTipText("Apodo");
		txtNombre.setBounds(147, 35, 185, 26);
		txtNombre.setText(detenido.getApodo());
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar\r\n");
		btnCancelar.setBounds(128, 300, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new Menu_Personas());
				marco.validate();
			}});
		
		panel.add(btnCancelar);
		
		JTextPane txtpnDescripcinSignificativa = new JTextPane();
		txtpnDescripcinSignificativa.setText(detenido.getDescripcionSignificativa());
		txtpnDescripcinSignificativa.setToolTipText("Descripción");
		txtpnDescripcinSignificativa.setBounds(128, 97, 231, 123);
		panel.add(txtpnDescripcinSignificativa);
		
		JButton btnAadirTestigo = new JButton("Siguiente");
		btnAadirTestigo.setBounds(265, 300, 89, 23);
		panel.add(btnAadirTestigo);
		

		
		JLabel lblNewLabel = new JLabel("Descripción: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(128, 72, 231, 14);
		panel.add(lblNewLabel);
		
		JLabel lblApodo = new JLabel();
		lblApodo.setText("Apodo:");
		lblApodo.setHorizontalAlignment(SwingConstants.CENTER);
		lblApodo.setForeground(Color.WHITE);
		lblApodo.setBounds(147, 11, 185, 14);
		panel.add(lblApodo);
		
		btnAadirTestigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String apodo = txtNombre.getText();
				String descripcionSignificativa = txtpnDescripcinSignificativa.getText();
				DetenidoNoIdentificado detenido = new DetenidoNoIdentificado(apodo, descripcionSignificativa);			
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new M_Testigo(detenido, testigo));
				marco.validate();			
				
			}
			
		});
        
		

	}
}
