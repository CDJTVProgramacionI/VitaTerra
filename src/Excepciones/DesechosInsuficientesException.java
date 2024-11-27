package Excepciones;

public class DesechosInsuficientesException extends Exception {
    public DesechosInsuficientesException() {
        super("No hay suficientes desechos para continuar");
    }
}
