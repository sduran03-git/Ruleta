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

    static void main(String[] args) {
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
                """);
    }

    public static int leerOpcion(Scanner in) {
        int opcion = in.nextInt();
        in.nextLine();

        if (opcion >= 1 && opcion <= 3) {
            return opcion;
        }

        return 0;
    }

    public static void ejecutarOpcion(int opcion, Scanner in) {
        if (opcion == 1) {
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
        return rng.nextInt(37);
    }

    public static boolean evaluarResultado(int numero, char tipo) {
        if (numero == 0) {
            return false;
        }
        if (tipo == 'R') {
            return esRojo(numero);
        } else if (tipo == 'N') {
            return !esRojo(numero);
        } else if (tipo == 'P') {
            return (numero % 2 == 0);
        } else if (tipo == 'I') {
            return (numero % 2 != 0);
        }
        return false;
    }

    public static boolean esRojo(int n) {
        for (int rojo : numerosRojos) {
            if (rojo == n) {
                return true;
            }
        }
        return false;
    }

    public static void registrarResultado(int numero, int apuesta, boolean acierto) {
        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;

            historialSize++;
        } else {
            System.out.println("El historial está lleno. No se registrará esta ronda.");
        }
    }

    public static void mostrarResultado(int numero, char tipo, int monto, boolean acierto) {
        System.out.println("><><><RESULTADO DE LA RONDA><><><");
        System.out.println("Tu apuesta fue: " + tipo + ". El giro de ruleta resulto: " + numero);

        if (acierto) {
            System.out.println("¡Has acertado! Ganas $" + monto);
        } else {
            System.out.println("Has fallado. Pierdes $" + monto);
        }
        System.out.println("><><><><><><><><><><><><><><><><><");
    }

    public static void mostrarEstadisticas() {
        int apostado = 0, aciertos = 0, balance = 0;

        for (int i = 0; i < historialSize; i++) {
            apostado += historialApuestas[i];
            if (historialAciertos[i]) {
                aciertos++;
                balance += historialApuestas[i];
            } else {
                balance -= historialApuestas[i];
            }
        }

        double porcentaje = (historialSize > 0) ? (aciertos * 100.0) / historialSize : 0;
        System.out.printf("><><>< ESTADÍSTICAS (Rondas: %d) ><><><\n", historialSize);
        System.out.printf("Apostado: $%d | Aciertos: %d (%.1f%%) | Balance: $%d\n\n", apostado, aciertos, porcentaje, balance);
    }
}

