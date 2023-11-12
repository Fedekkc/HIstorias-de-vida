package interfaz;

import java.awt.Color;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
import dao_detenido_identificado.Dao_Detenido_Identificado;
import dao_fuerzas.Dao_Fuerzas;
import entidades.CCDTyE;
import entidades.DetenidoIdentificado;
import interfaz.M_CCDTyE;
import java.awt.Dimension;
import javax.swing.JTextField;

public class AM_Identificados extends JPanel {
    private JTextField searchField;
    private DefaultListModel<DetenidoIdentificado> listModel;
    private Dao_Detenido_Identificado dao;

    public AM_Identificados() {
        setBackground(new Color(138, 135, 169));
        setMinimumSize(new Dimension(880, 560));

        listModel = new DefaultListModel<>(); // Inicializa listModel
        dao = new Dao_Detenido_Identificado();
        ArrayList<DetenidoIdentificado> detenidos = dao.getAllDetenidos_Identificados();
        for (DetenidoIdentificado detenido : detenidos) {
            listModel.addElement(detenido);
        }
        
        setLayout(null);
        JList<DetenidoIdentificado> list = new JList<>(listModel);
        list.setFont(new Font("M PLUS 1p", Font.BOLD, 12));
        list.setCellRenderer(new DefaultListCellRenderer() {
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
		list.setBounds(1, 37, 185, 413);
		list.setBackground(new Color(0, 0, 26));
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
        
        Panel panel_3 = new Panel();
        panel_3.setBackground(new Color(50, 49, 78));
        panel_3.setBounds(10, 38, 238, 451);
        add(panel_3);
        panel_3.setLayout(null);
		
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(10, 67, 218, 339);
        panel_3.add(scrollPane);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.setBackground(new Color(0, 0, 26));
		btnNewButton.setForeground(new Color(217, 217, 217));
		btnNewButton.setBounds(413, 417, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
            	
			}
		});
		panel.add(btnNewButton);
		

		
		JButton btnNewButton_1 = new JButton("Atrás");
		btnNewButton_1.setForeground(new Color(217, 217, 217));
		btnNewButton_1.setBackground(new Color(0, 0, 26));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new Menu_Personas());
				marco.validate();
            	
			}
		});
		btnNewButton_1.setBounds(111, 417, 98, 23);
		panel.add(btnNewButton_1);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(0, 0, 26));
		panel_1.setBounds(20, 69, 550, 342);
		panel.add(panel_1);
		panel_1.setLayout(null);
		

		
		JLabel nombreLabel = new JLabel("● Nombre: ");
		nombreLabel.setFont(new Font("M PLUS 1p", Font.BOLD, 13));
		nombreLabel.setForeground(new Color(217, 217, 217));
		nombreLabel.setBounds(10, 11, 495, 14);
		panel_1.add(nombreLabel);
		
		JLabel DNILabel = new JLabel("● DNI: ");
		DNILabel.setFont(new Font("M PLUS 1p", Font.BOLD, 13));
		DNILabel.setForeground(new Color(217, 217, 217));
		DNILabel.setBounds(10, 36, 495, 14);
		panel_1.add(DNILabel);
		
		JLabel lugarSecuestroLabel = new JLabel("● Lugar de secuestro:");
		lugarSecuestroLabel.setFont(new Font("M PLUS 1p", Font.BOLD, 13));
		lugarSecuestroLabel.setForeground(new Color(217, 217, 217));
		lugarSecuestroLabel.setBounds(10, 61, 495, 14);
		panel_1.add(lugarSecuestroLabel);
		
		JLabel ultVezLabel = new JLabel("● Ultima vez visto: ");
		ultVezLabel.setFont(new Font("M PLUS 1p", Font.BOLD, 13));
		ultVezLabel.setForeground(new Color(217, 217, 217));
		ultVezLabel.setBounds(10, 86, 495, 14);
		panel_1.add(ultVezLabel);
		
		JLabel biografiaLabel = new JLabel("● Biografia:");
		biografiaLabel.setVerticalAlignment(SwingConstants.TOP);
		biografiaLabel.setFont(new Font("M PLUS 1p", Font.BOLD, 13));
		biografiaLabel.setForeground(new Color(217, 217, 217));
		biografiaLabel.setBounds(10, 118, 495, 77);
		panel_1.add(biografiaLabel);
		
		JButton materialButton = new JButton("Material");
		materialButton.setBounds(220, 206, 89, 23);
		panel_1.add(materialButton);
		
		JLabel sobrevivioLabel = new JLabel("");
		sobrevivioLabel.setBounds(10, 317, 259, 14);
		panel_1.add(sobrevivioLabel);
		
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
		
		JButton refreshButton = new JButton("Actualizar");
		refreshButton.setForeground(new Color(217, 217, 217));
		refreshButton.setBackground(new Color(0, 0, 26));
		refreshButton.setBounds(135, 417, 93, 23);
		panel_3.add(refreshButton);
		
		searchField = new JTextField();
		searchField.setForeground(new Color(217, 217, 217));
		searchField.setBackground(new Color(0, 0, 26));
		searchField.setBounds(10, 24, 218, 32);
		panel_3.add(searchField);
		searchField.setColumns(10);
		
		JButton addButton = new JButton("Añadir");
		addButton.setForeground(new Color(217, 217, 217));
		addButton.setBackground(new Color(0, 0, 26));
		addButton.setBounds(10, 417, 93, 23);
		panel_3.add(addButton);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar");
		lblNewLabel_1.setForeground(new Color(217, 217, 217));
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		panel_3.add(lblNewLabel_1);
		


		
		
		final DetenidoIdentificado[] selected = {null}; 
		

		list.addListSelectionListener(new ListSelectionListener() {
		    @Override
		    
		    
		    public void valueChanged(ListSelectionEvent e) {
		    	Dao_Detenido_Identificado dao = new Dao_Detenido_Identificado();
		        selected[0] = list.getSelectedValue();
	                
	                if (selected[0] != null) {
	                    lblNewLabel.setText(selected[0].getNombre());
	                		        	
		            nombreLabel.setText("● Nombre: " + selected[0].getNombre());
		            DNILabel.setText("● DNI: " + selected[0].getDNI());
		            int ID = dao.getIdDetenidoIdentificado(selected[0].getNombre());
		            lugarSecuestroLabel.setText("● Lugar de secuestro: " + dao.getLugarDeSecuestro(ID));
		            ultVezLabel.setText("● Ultima vez visto: " + selected[0].getUltVezVisto());
		            biografiaLabel.setText("● Biografia: " + selected[0].getBiografiaPersonal());

	                }    
		    }
		});

		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new M_Detenido_Identificado(selected[0]));
				marco.validate();

		    }
		});
		refreshButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int selectedIndex = list.getSelectedIndex(); // Obtener el índice seleccionado antes de la actualización
		        listModel.clear(); // Limpiar el modelo de lista existente
		        ArrayList<DetenidoIdentificado> updatedDetenidos = dao.getAllDetenidos_Identificados(); // Obtener los datos actualizados
		        for (DetenidoIdentificado stopped : updatedDetenidos) {
		        	
		            listModel.addElement(stopped); 
		        }
		        

		        if (selectedIndex >= 0 && selectedIndex < listModel.getSize()) {
		            list.setSelectedIndex(selectedIndex);
		        }
		    }
		});

		searchField.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		    	filterList();
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		    	filterList();
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		    	filterList();
		    }
		});

	        
		addButton.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e)
			{
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new add_Detenido_Identificado());
				marco.validate();
			}
			
			
		});
		
		
	}
    
    
    
    
    private void filterList() {
        String searchTerm = searchField.getText().toLowerCase(); // Obtener el término de búsqueda en minúsculas
        listModel.clear(); // Limpiar el modelo de lista existente
        ArrayList<DetenidoIdentificado> updatedDetenidos = dao.getAllDetenidos_Identificados(); // Obtener los datos actualizados

        // Filtrar los elementos basados en el término de búsqueda
        for (DetenidoIdentificado stopped : updatedDetenidos) {
            if (stopped.getNombre().toLowerCase().contains(searchTerm)) {
                listModel.addElement(stopped); // Agregar los elementos coincidentes al modelo de lista
            }
        }
    }
}
