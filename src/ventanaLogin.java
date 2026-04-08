import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;

public class ventanaLogin {
    public static final List<Usuario> USUARIOS = new ArrayList<>();

    private final JFrame frame = new JFrame("Login Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");

    public ventanaLogin() {
        inicializarUsuarios();
        configurarVentana();
        btnIngresar.addActionListener(e -> login());
    }

    private void inicializarUsuarios() {
        if (USUARIOS.isEmpty()) {
            USUARIOS.add(new Usuario("donnie", "1234", "Don Donnie"));
            USUARIOS.add(new Usuario("jugador1", "abcd", "Albert"));
        }
    }

    private void configurarVentana() {
        frame.setLayout(new GridLayout(3, 2, 10, 10));
        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(new JLabel(""));
        frame.add(btnIngresar);
    }

    public void mostrarVentana() {
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private void login() {
        String u = txtUsuario.getText();
        String p = new String(txtClave.getPassword());
        String nombre = validarCredenciales(u, p);

        if (!nombre.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "¡Acceso concedido! Bienvenido, " + nombre);
        } else {
            JOptionPane.showMessageDialog(frame, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String validarCredenciales(String u, String p) {
        for (Usuario usr : USUARIOS) {
            if (usr.validarCredenciales(u, p)) {
                return usr.getNombre();
            }
        }
        return "";
    }

    public void abrirRegistro() {
        frame.dispose();
    }
}
