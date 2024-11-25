package Excepciones;

public class MetodoIncorrectoException extends RespuestaIncorrectaException {
    // Excepción que se lanza cuando se intenta tratar con un método incorrecto
    public MetodoIncorrectoException(String desecho, String metodo) {
        super("No puedes tratar " + desecho + " con el método " + metodo);
    }
}
