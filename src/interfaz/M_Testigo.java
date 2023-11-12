package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import dao_detenido_identificado.Dao_Detenido_No_Identificado;
import dao_testigos.Dao_testigos;
import entidades.DetenidoNoIdentificado;
import entidades.Testigo;

import javax.swing.JLabel;
import java.awt.Font;

public class M_Testigo extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField Nombre;
    private JTextField DNI;
    private DetenidoNoIdentificado detenido; // Nuevo atributo
    private Testigo testigo;
    
    /**
     * Create the panel.
     */
    public M_Testigo(DetenidoNoIdentificado  detenido, Testigo testigo) {
        this.detenido = detenido;
        this.testigo = testigo;
        String oldDNI = testigo.getDNI();

        setBackground(new Color(138, 135, 169));
        setMinimumSize(new Dimension(400, 400));
        setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(880, 560));
        contentPanel.setMinimumSize(new Dimension(880, 560));
        contentPanel.setBackground(new Color(138, 135, 169));
        contentPanel.setLayout(null);

        Panel panel = new Panel();
        panel.setBounds(212, 70, 393, 287);
        panel.setBackground(new Color(50, 49, 78));
        contentPanel.add(panel);
        panel.setLayout(null);

        Nombre = new JTextField();
        Nombre.setForeground(new Color(108, 108, 108));
        Nombre.setHorizontalAlignment(SwingConstants.CENTER);
        Nombre.setText(testigo.getNombre());
        Nombre.setBounds(135, 41, 102, 30);
        panel.add(Nombre);
        Nombre.setColumns(10);

        DNI = new JTextField();
        DNI.setForeground(new Color(108, 108, 108));
        DNI.setHorizontalAlignment(SwingConstants.CENTER);
        DNI.setText(testigo.getDNI());
        DNI.setBounds(135, 82, 102, 30);
        panel.add(DNI);
        DNI.setColumns(10);




        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new AM_NoIdentificados());
				marco.validate();
            }
        });
        botonCancelar.setBounds(78, 195, 89, 23);
        panel.add(botonCancelar);

        JTextPane txtpnTestimonio = new JTextPane();
        txtpnTestimonio.setForeground(new Color(108, 108, 108));
        txtpnTestimonio.setText(testigo.getTestimonio());
        txtpnTestimonio.setBounds(119, 123, 139, 48);
        panel.add(txtpnTestimonio);

        add(contentPanel, BorderLayout.NORTH);
        
        JLabel lblNewLabel = new JLabel("Añadir Testigo\r\n");
        lblNewLabel.setBounds(313, 11, 485, 71);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("M PLUS 1p", Font.PLAIN, 24));
        contentPanel.add(lblNewLabel);
        Dao_Detenido_No_Identificado detenidoDao = new Dao_Detenido_No_Identificado();
        Dao_testigos testigosDao = new Dao_testigos(); 
        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String name = Nombre.getText();
        		String dni = DNI.getText();
        		String testimonio = txtpnTestimonio.getText();
        		Testigo newTestigo = new Testigo(name,dni,testimonio);
        		int id = testigosDao.getIDTestigo(oldDNI);
        		testigosDao.updateTestigo(id, newTestigo);
        		System.out.println("ID TESTIGO: " + String.valueOf(id));
        		detenido.setIdTestigo(id);
        		int ID_Detenido = detenidoDao.getIdDetenidoByIdTestigo(id);
        		System.out.println("ID Detenido: " + String.valueOf(ID_Detenido));
        		detenidoDao.updateDetenidoNoIdentificado(ID_Detenido, detenido);
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new AM_NoIdentificados());
				marco.validate();
        		
        		
        		
        		
        	}
        });
        botonAceptar.setBounds(195, 195, 89, 23);
        panel.add(botonAceptar);
    }
}
