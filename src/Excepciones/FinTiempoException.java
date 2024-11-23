package Excepciones;

public class FinTiempoException extends Exception {
    // Excepción que se lanza cuando se acaba el tiempo de un jugador
    public FinTiempoException(String nombreJugador) {
        // Se le pasa el nombre del jugador que se le ha acabado el tiempo
        super("Se ha acabado el tiempo del jugador" + nombreJugador);
    }
}
