package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import interfaz.ViewCCDTyE;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setBackground(new Color(138, 135, 169));
		setMinimumSize(new Dimension(880, 560));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 563);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(138, 135, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Centros de detencion");
		btnNewButton.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/ccdtye_pic.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	ViewCCDTyE AM = new ViewCCDTyE();
            	AM.setVisible(true);
            	
			}
			
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new ViewCCDTyE());
				marco.validate();
			}
		});
		btnNewButton.setBounds(31, 37, 380, 450);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Personas");
		btnNewButton_1.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/personas_pic.png")));
		btnNewButton_1.setBounds(456, 37, 380, 450);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new Menu_Personas());
				marco.validate();
			}
		});
		contentPane.add(btnNewButton_1);
		
		

	}
}
