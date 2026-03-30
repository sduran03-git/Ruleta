import java.util.Random;
import java.util.Scanner;
public class Ruleta {
    public static final int MAX_HISTORIAL = 100;
    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;
    public static Random rng = new Random();
    public static int[] numerosRojos =
            {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};
    public static int[] numerosNegros =
            {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};
    }

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner in = new Scanner(System.in);
        int opcionElegida;
        do {
            mostrarMenu();
            opcionElegida = leerOpcion(in);
            ejecutarOpcion(opcionElegida, in);
        } while (opcionElegida != 3);
    }

    public static void mostrarMenu() {
        System.out.println("""
                Bienvenido al casino Black Cat, por favor selecciona una opcion:
                (1) Iniciar Ronda
                (2) Ver estadísticas
                (3) Salir
                """);}

    public static int leerOpcion(Scanner in) {
        int opcion = in.nextInt();
        in.nextLine();

        if (opcion >= 1 && opcion <= 3) {
            return opcion;
        }

        return 0;
    }

    public static void ejecutarOpcion(int opcion, Scanner in) {
        if (opcion == 1){
            iniciarRonda(in);
        } else if (opcion == 2) {
            mostrarEstadisticas();
        } else if (opcion == 3) {
            System.out.println("¡Gracias por visitar el Casino Black Cat! Saliendo...");
        } else {
            System.out.println("Opción inválida. Por favor, intente de nuevo.");
        }
    }

    public static void iniciarRonda(Scanner in) {
        char tipo = leerTipoApuesta(in);

        System.out.print("Ingrese el monto a apostar: $");
        int monto = in.nextInt();
        in.nextLine();

        int numero = girarRuleta();
        boolean acierto = evaluarResultado(numero, tipo);

        mostrarResultado(numero, tipo, monto, acierto);
        registrarResultado(numero, monto, acierto);
    }

    public static char leerTipoApuesta(Scanner in) {
        System.out.println("Tipos de apuesta: Rojo, Negro, Par, Impar");
        System.out.print("Ingrese su elección: ");
        String palabra = in.next().toUpperCase();
        in.nextLine();

        return palabra.charAt(0);
    }

    public static int girarRuleta() {
        return 0;
    }
    /**
     * Evalúa si la apuesta realizada por el jugador fue acertada.
     * @param numero número obtenido en la ruleta.
     * @param tipo tipo de apuesta elegida.
     * @return true si acertó, false si perdió.
     */
    public static boolean evaluarResultado(int numero, char tipo) {
        return false;
    }
    /**
     * Determina si un número corresponde a color rojo.
     * @param n número de la ruleta.
     * @return true si es rojo, false en caso contrario.
     */
    public static boolean esRojo(int n) {
        return false;
    }
/**
 * Registra los resultados de la ronda en los arreglos de historial.
 * @param numero número obtenido en la ruleta.
 * @param apuesta monto apostado.
 * @param acierto si el jugador acertó o no.
 */
    public static void registrarResultado(int numero, int apuesta, boolean acierto) {}
    /**
     * Muestra en consola el resultado de la ronda.
     * @param numero número obtenido en la ruleta.
     * @param tipo tipo de apuesta realizada.
     * @param monto monto apostado.
     * @param acierto si el jugador ganó o perdió.
     */
    public static void mostrarResultado(int numero, char tipo, int monto, boolean
            acierto) {}
    /**
     * Muestra estadísticas generales de todas las rondas jugadas.
     */
    public static void mostrarEstadisticas() {}
}
