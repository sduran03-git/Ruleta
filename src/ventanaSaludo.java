import javax.swing.*;

public class ventanaSaludo {

    private final JFrame frame = new JFrame("Casino Black Cat - Menú Principal");

    public ventanaSaludo() {
        JLabel mensaje = new JLabel("¡Bienvenido al sistema del Casino!", SwingConstants.CENTER);
        frame.add(mensaje);
    }

    public void mostrarVentana() {
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}