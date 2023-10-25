package app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import interfaz.MainWindow; // Asegúrate de importar la clase MainWindow

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainWindow.pack(); // Ajusta el tamaño del JFrame según su contenido
            mainWindow.setVisible(true);
        });
    }
}
