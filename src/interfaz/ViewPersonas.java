package interfaz;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Panel;
import java.awt.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import dao_ccdtye.Dao_CCDTyE;
import entidades.CCDTyE;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class ViewPersonas extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ViewPersonas() {
		setBackground(new Color(138, 135, 169));
		setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(12, 12, 34));
		panel.setBounds(81, 49, 718, 462);
		add(panel);
		panel.setLayout(null);
		

        DefaultListModel<CCDTyE> listModel = new DefaultListModel<>();
        ArrayList<CCDTyE> centros = new ArrayList<CCDTyE>();
        Dao_CCDTyE dao = new Dao_CCDTyE();
        centros = dao.getAllCCDTyE();
        for (CCDTyE ccdTyE : centros) {
            listModel.addElement(ccdTyE);
        }
		
        JList<CCDTyE> list = new JList<>(listModel);
        list.setBorder(new LineBorder(new Color(138, 135, 169), 4, true));
		
		list.setBackground(new Color(217, 217, 217));
		list.setBounds(266, 105, 185, 293);
		panel.add(list);
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
        scrollPane.setBounds(266, 105, 185, 293);
        panel.add(scrollPane);
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.setFont(new Font("M PLUS 1p", Font.PLAIN, 11));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(138, 135, 169));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(375, 419, 76, 32);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ver");
		btnNewButton_1.setFont(new Font("M PLUS 1p", Font.PLAIN, 11));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(138, 135, 169));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new AM_CCDTyE());
				marco.validate();
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new add_CCDTyE());
				marco.validate();
			}
		});
		btnNewButton_1.setBounds(266, 419, 76, 32);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("DETENIDOS IDENTIFICADOS");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("M PLUS 1p", Font.PLAIN, 11));
		lblNewLabel.setBounds(290, 62, 220, 32);
		panel.add(lblNewLabel);
		
		
		
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                CCDTyE selected = list.getSelectedValue();
                if (selected != null) {
                    
            		btnNewButton.addActionListener(new ActionListener() {
            			public void actionPerformed(ActionEvent e) {
            				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
            				marco.setContentPane(new AM_CCDTyE());
            				marco.validate();
            			}
            		});
                	
                	
                }
            }
        });

	}
}
