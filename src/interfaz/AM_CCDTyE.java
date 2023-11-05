package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao_ccdtye.Dao_CCDTyE;
import dao_fuerzas.Dao_Fuerzas;
import entidades.CCDTyE;
import interfaz.M_CCDTyE;
import java.awt.Dimension;

public class AM_CCDTyE extends JPanel {

	/**
	 * Create the panel.
	 */
	public AM_CCDTyE() {
		setBackground(new Color(138, 135, 169));
		setMinimumSize(new Dimension(880, 560));
		
        DefaultListModel<CCDTyE> listModel = new DefaultListModel<>();
        ArrayList<CCDTyE> centros = new ArrayList<CCDTyE>();
        Dao_CCDTyE dao = new Dao_CCDTyE();
        centros = dao.getAllCCDTyE();
        for (CCDTyE ccdTyE : centros) {
            listModel.addElement(ccdTyE);
        }
		setLayout(null);
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
		add(list);
		list.setAlignmentY(Component.TOP_ALIGNMENT);
		list.setAlignmentX(Component.RIGHT_ALIGNMENT);
		list.setForeground(new Color(217, 217, 217));
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(254, 38, 580, 451);
		panel.setBackground(new Color(50, 49, 78));
		panel.setForeground(new Color(50, 49, 78));
		add(panel);
		panel.setLayout(null);
		panel.setLayout(null);
		
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(21, 38, 187, 451);
        add(scrollPane);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.setBackground(new Color(0, 0, 26));
		btnNewButton.setForeground(new Color(217, 217, 217));
		btnNewButton.setBounds(413, 417, 89, 23);
		panel.add(btnNewButton);
		

		
		JButton btnNewButton_1 = new JButton("Confirmar");
		btnNewButton_1.setForeground(new Color(217, 217, 217));
		btnNewButton_1.setBackground(new Color(0, 0, 26));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new ViewCCDTyE());
				marco.validate();
			}
		});
		btnNewButton_1.setBounds(111, 417, 89, 23);
		panel.add(btnNewButton_1);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(0, 0, 26));
		panel_1.setBounds(20, 69, 550, 342);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("● ID: ");
		lblNewLabel_1.setFont(new Font("M PLUS 1p", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(217, 217, 217));
		lblNewLabel_1.setBounds(10, 11, 495, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("● Nombre: ");
		lblNewLabel_1_1.setFont(new Font("M PLUS 1p", Font.BOLD, 13));
		lblNewLabel_1_1.setForeground(new Color(217, 217, 217));
		lblNewLabel_1_1.setBounds(10, 51, 495, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("● Ubicacion: ");
		lblNewLabel_1_1_1.setFont(new Font("M PLUS 1p", Font.BOLD, 13));
		lblNewLabel_1_1_1.setForeground(new Color(217, 217, 217));
		lblNewLabel_1_1_1.setBounds(10, 101, 495, 14);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("● Fecha de puesta en marcha:");
		lblNewLabel_1_1_1_1.setFont(new Font("M PLUS 1p", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setForeground(new Color(217, 217, 217));
		lblNewLabel_1_1_1_1.setBounds(10, 151, 495, 14);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("● Fecha de cierre:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("M PLUS 1p", Font.BOLD, 13));
		lblNewLabel_1_1_1_1_1.setForeground(new Color(217, 217, 217));
		lblNewLabel_1_1_1_1_1.setBounds(10, 201, 495, 14);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("● Fuerzas a cargo:");
		lblNewLabel_1_1_1_1_2.setFont(new Font("M PLUS 1p", Font.BOLD, 13));
		lblNewLabel_1_1_1_1_2.setForeground(new Color(217, 217, 217));
		lblNewLabel_1_1_1_1_2.setBounds(10, 251, 495, 14);
		panel_1.add(lblNewLabel_1_1_1_1_2);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(0, 0, 26));
		panel_2.setBounds(20, 10, 550, 41);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 0, 530, 41);
		panel_2.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("M PLUS 1p", Font.BOLD, 16));
		
		list.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                CCDTyE selected = list.getSelectedValue();
	                if (selected != null) {
	                    lblNewLabel.setText(selected.getNombre());
	                }
	            }
	        });

		final CCDTyE[] selected = {null}; // Declarar como final

		list.addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
		        selected[0] = list.getSelectedValue(); // Asignar el valor al objeto selected

		        if (selected[0] != null) {
		            lblNewLabel_1.setText("● ID: " + selected[0].getID());
		            lblNewLabel_1_1.setText("● Nombre: " + selected[0].getNombre());
		            lblNewLabel_1_1_1.setText("● Ubicacion: " + selected[0].getUbicacion());
		            lblNewLabel_1_1_1_1.setText("● Fecha de puesta en marcha: " + selected[0].getFechaPuestaEnMarcha());
		            lblNewLabel_1_1_1_1_1.setText("● Fecha de cierre: " + selected[0].getFechaCierre());

		            // Obtener nombres de las fuerzas al mando
		            ArrayList<Integer> fuerzasIDs = selected[0].getFuerzasAlMando();
		            System.out.println("IDs: " + fuerzasIDs.toString());
		            StringBuilder fuerzasNombres = new StringBuilder();
		            Dao_Fuerzas dao = new Dao_Fuerzas();
		            for (int fuerzaID : fuerzasIDs) {
		                String nombreFuerza = dao.getFuerzaNombre(fuerzaID);
		                System.out.println(nombreFuerza);
		                fuerzasNombres.append(nombreFuerza).append(", ");
		            }

		            if (fuerzasNombres.length() > 0) {
		                // Eliminar la coma y el espacio adicionales al final
		                fuerzasNombres.setLength(fuerzasNombres.length() - 2);
		            }
		            lblNewLabel_1_1_1_1_2.setText("● Fuerzas a cargo: " + fuerzasNombres.toString());
		        }
		    }
		});

		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (selected[0] != null) {
		            M_CCDTyE dialog = new M_CCDTyE(selected[0]);
		            dialog.setVisible(true);
		        }
		    }
		});

	        
		
	}
}
