package app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import interfaz.AM_CCDTyE;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
 
            AM_CCDTyE mainWindow = new AM_CCDTyE();


            mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Hola
            mainWindow.setVisible(true);
        });
    }
}
