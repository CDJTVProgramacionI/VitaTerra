package Excepciones;

public class MetodoIncorrectoException extends RespuestaIncorrectaException {
    // Excepción que se lanza cuando se intenta tratar con un método incorrecto
    public MetodoIncorrectoException() {
        super("No puedes tratar el desecho con ese método ");
    }
}
