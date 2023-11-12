package interfaz;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import dao_detenido_identificado.Dao_Detenido_Identificado;
import dao_detenido_identificado.Dao_Detenido_No_Identificado;
import entidades.CCDTyE;
import entidades.DetenidoIdentificado;
import entidades.DetenidoNoIdentificado;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_Personas extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Menu_Personas() {
		Dao_Detenido_No_Identificado dao_No_Identificado = new Dao_Detenido_No_Identificado();
		Dao_Detenido_Identificado dao_Identificado = new Dao_Detenido_Identificado();
		
		setBackground(new Color(138, 135, 169));
		setForeground(new Color(138, 135, 169));
		setMinimumSize(new Dimension(880, 560));
		setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(12, 12, 34));
		panel.setBounds(50, 59, 300, 442);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IDENTIFICADOS");
		lblNewLabel.setFont(new Font("M PLUS 1p", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(217, 217, 217));
		lblNewLabel.setBounds(10, 11, 280, 36);
		panel.add(lblNewLabel);
		
		JButton viewIdentificadoButton = new JButton("Ver");
		viewIdentificadoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new AM_Identificados());
				marco.validate();
				
			}
		});
		viewIdentificadoButton.setBounds(100, 395, 89, 23);
		panel.add(viewIdentificadoButton);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(12, 12, 34));
		panel_1.setBounds(511, 59, 300, 442);
		add(panel_1);
		
		JLabel lblNoIdentificados = new JLabel("NO IDENTIFICADOS");
		lblNoIdentificados.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoIdentificados.setForeground(new Color(217, 217, 217));
		lblNoIdentificados.setFont(new Font("M PLUS 1p", Font.BOLD, 24));
		lblNoIdentificados.setBounds(10, 11, 280, 36);
		panel_1.add(lblNoIdentificados);

		
		JButton viewNoIdentificadoButton = new JButton("Ver");
		viewNoIdentificadoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new AM_NoIdentificados());
				marco.validate();
			}
		});
		viewNoIdentificadoButton.setBounds(114, 394, 89, 23);
		panel_1.add(viewNoIdentificadoButton);
		
		

		DefaultListModel<DetenidoIdentificado> identificadosListModel = new DefaultListModel<>();
		JList<DetenidoIdentificado> identificadosList = new JList<>(identificadosListModel);
		JScrollPane identificadosScrollPane = new JScrollPane(identificadosList);
		identificadosScrollPane.setBounds(53, 68, 197, 305);
		panel.add(identificadosScrollPane);
		
		
		for (DetenidoIdentificado persona : dao_Identificado.getAllDetenidos_Identificados()) {
			identificadosListModel.addElement(persona);
			
		}
		
        identificadosList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof DetenidoIdentificado) {
                    DetenidoIdentificado detenidoIdentificado = (DetenidoIdentificado) value;
                    setText(detenidoIdentificado.getNombre());
                }
                return this;
            }
        });



		
		
		DefaultListModel<DetenidoNoIdentificado> noIdentificadosListModel = new DefaultListModel<>();
		JList<DetenidoNoIdentificado> noIdentificadosList = new JList<>(noIdentificadosListModel);
		JScrollPane noIdentificadosScrollPane = new JScrollPane(noIdentificadosList);
		noIdentificadosScrollPane.setBounds(53, 68, 197, 305);
		panel_1.add(noIdentificadosScrollPane);
		
		
		for (DetenidoNoIdentificado persona : dao_No_Identificado.getAllDetenidoNoIdentificado()) {
			noIdentificadosListModel.addElement(persona);
			
		}
		
        noIdentificadosList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof DetenidoNoIdentificado) {
                    DetenidoNoIdentificado detenidoNoIdentificado = (DetenidoNoIdentificado) value;
                    setText(detenidoNoIdentificado.getApodo());
                }
                return this;
            }
        });
        
        JButton backButton = new JButton("Volver");
        backButton.setBounds(50, 525, 89, 23);
        backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow MW = new MainWindow();
		        
            	MW.setVisible(true);
            	MW.validate();
		        // Ocultar el JPanel actual
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Menu_Personas.this);
                currentFrame.dispose();
		        setVisible(false);
			}
		});
        add(backButton);

		// Asegúrate de ajustar y personalizar la lógica según tus necesidades específicas.


	}
}
