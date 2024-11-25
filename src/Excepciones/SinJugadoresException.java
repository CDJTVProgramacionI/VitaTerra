package Excepciones;

public class SinJugadoresException extends Exception {
    // Excepción que se lanza cuando no hay jugadores en la partida
    public SinJugadoresException() {
        super("Todos los jugadores han perdido");
    }
}
