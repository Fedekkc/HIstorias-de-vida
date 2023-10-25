package interfaz;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import entidades.CCDTyE;
import dao_ccdtye.Dao_CCDTyE;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;

public class AM_CCDTyE extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AM_CCDTyE frame = new AM_CCDTyE();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AM_CCDTyE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(138, 138, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
        DefaultListModel<CCDTyE> listModel = new DefaultListModel<>();
        ArrayList<CCDTyE> centros = new ArrayList<CCDTyE>();
        Dao_CCDTyE dao = new Dao_CCDTyE();
        centros = dao.getAllCCDTyE();
        for (CCDTyE ccdTyE : centros) {
            listModel.addElement(ccdTyE);
        }
		contentPane.setLayout(null);
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
		contentPane.add(list);
		list.setAlignmentY(Component.TOP_ALIGNMENT);
		list.setAlignmentX(Component.RIGHT_ALIGNMENT);
		list.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setForeground(new Color(217, 217, 217));
		
		JPanel panel = new JPanel();
		panel.setBounds(254, 38, 580, 451);
		panel.setBackground(new Color(50, 49, 78));
		panel.setForeground(new Color(50, 49, 78));
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.setBackground(new Color(0, 0, 26));
		btnNewButton.setForeground(new Color(217, 217, 217));
		btnNewButton.setBounds(413, 417, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Añadir");
		btnNewButton_1.setForeground(new Color(217, 217, 217));
		btnNewButton_1.setBackground(new Color(0, 0, 26));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

	    list.addListSelectionListener(new ListSelectionListener() {
	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	                CCDTyE selected = list.getSelectedValue();
	                if (selected != null) {
	                    
	                	lblNewLabel_1.setText("● ID: " + selected.getID());
	                	lblNewLabel_1_1.setText("● Nombre: " + selected.getNombre());
	            		lblNewLabel_1_1_1.setText("● Ubicacion: " + selected.getUbicacion());
	            		lblNewLabel_1_1_1_1.setText("● Fecha de puesta en marcha: " + selected.getFechaPuestaEnMarcha());
	            		lblNewLabel_1_1_1_1_2.setText("● Fuerzas a cargo: " + selected.getFuerzasAlMando());

	                }
	            }
	        });
	        
		
	}
}
