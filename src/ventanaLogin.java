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
// TODO: mostrar ventana
    }
    /**
     * Maneja el evento de login al presionar el botón.
     * Debe validar credenciales y abrir la siguiente ventana o mostrar error.
     */
    private void login() {
// TODO: implementar lógica de login
    }
    /**
     * Valida las credenciales del usuario contra el arreglo hardcoded.
     *
     * @param u nombre de usuario ingresado
     * @param p clave ingresada
     * @return el nombre del usuario si es válido, o cadena vacía si no coincide
     */
    private String validarCredenciales(String u, String p) {
// TODO: recorrer arreglo y validar credenciales
        return "";
    }
/**
 * Abre la ventana de registro para crear un nuevo usuario.
 * Debe cerrar la ventana actual e invocar a VentanaRegistro.
 */
 void abrirRegistro() {
// TODO: abrir ventana de registro y cerrar login
    }
}
