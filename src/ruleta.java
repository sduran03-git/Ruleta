import java.util.Random;

public class ruleta {
    public static final int MAX_HISTORIAL = 100;
    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;
    public static Random rng = new Random();
    public static int[] numerosRojos = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};

    public static int girarRuleta() {
        return rng.nextInt(37);
    }

    public static boolean evaluarResultado(int numero, char tipo) {
        if (numero == 0) return false;
        if (tipo == 'R') return esRojo(numero);
        if (tipo == 'N') return !esRojo(numero);
        if (tipo == 'P') return (numero % 2 == 0);
        if (tipo == 'I') return (numero % 2 != 0);
        return false;
    }

    public static boolean esRojo(int n) {
        for (int rojo : numerosRojos) {
            if (rojo == n) return true;
        }
        return false;
    }

    public static void registrarResultado(int numero, int apuesta, boolean acierto) {
        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;
            historialSize++;
        }
    }

    public static String obtenerEstadisticas() {
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
        return String.format("Apostado: $%d | Aciertos: %d (%.1f%%) | Balance: $%d",
                apostado, aciertos, porcentaje, balance);
    }
}