package app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import interfaz.ViewCCDTyE; // Asegúrate de importar la clase correcta

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
 
            JFrame mainWindow = new JFrame("View CCDTyE");
            ViewCCDTyE panel = new ViewCCDTyE();

            mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainWindow.add(panel);
            mainWindow.pack(); // Ajusta el tamaño del JFrame según su contenido
            mainWindow.setVisible(true);
        });
    }
}
