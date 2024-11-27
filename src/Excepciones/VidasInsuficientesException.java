package Excepciones;

public class VidasInsuficientesException extends Exception {
    public VidasInsuficientesException() {
        super("No tienes suficientes vidas para continuar.");
    }
}
