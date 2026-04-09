import javax.swing.*;
import java.awt.*;

public class ventanaSaludo {

    private final JFrame frame = new JFrame("RULETA - Casino Black Cat");
    private final JPanel panelMenu = new JPanel();
    private final JPanel panelContenido = new JPanel();
    private final JButton btnInicio = new JButton("Inicio");
    private final JButton btnJugar = new JButton("Jugar");
    private final JButton btnHistorial = new JButton("Historial");
    private final JButton btnSalir = new JButton("Salir");

    public ventanaSaludo() {
        configurarVentana();
        configurarMenu();
        configurarContenido();
        asignarEventos();
    }

    private void configurarVentana() {
        frame.setSize(550, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(15, 15));
        frame.setLocationRelativeTo(null);
    }

    private void configurarMenu() {
        panelMenu.setLayout(new GridLayout(4, 1, 5, 15));
        panelMenu.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));

        panelMenu.add(btnInicio);
        panelMenu.add(btnJugar);
        panelMenu.add(btnHistorial);
        panelMenu.add(btnSalir);

        frame.add(panelMenu, BorderLayout.WEST);
    }

    private void configurarContenido() {
        String texto = "<html><h3>Bienvenido/a al menú principal.</h3>" +
                "<p>A la izquierda tienes:</p>" +
                "<ul><li><b>Jugar:</b> abre la ventana de juego.</li>" +
                "<li><b>Historial:</b> abre la ventana de historial.</li>" +
                "<li><b>Salir:</b> cierra sesión y vuelve al login.</li></ul></html>";

        JLabel lblMensaje = new JLabel(texto);
        lblMensaje.setVerticalAlignment(SwingConstants.TOP);

        panelContenido.setLayout(new BorderLayout());
        panelContenido.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
        panelContenido.add(lblMensaje, BorderLayout.CENTER);

        frame.add(panelContenido, BorderLayout.CENTER);
    }


    private void asignarEventos() {
        btnSalir.addActionListener(e -> cerrarSesion());
        btnJugar.addActionListener(e -> abrirJuego());
    }

    private void cerrarSesion() {
        frame.dispose();
        ventanaLogin login = new ventanaLogin();
        login.mostrarVentana();
    }

    private void abrirJuego() {
        JOptionPane.showMessageDialog(frame, "Aquí se abrirá la Ventana de Juego (Paso 3)");
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}