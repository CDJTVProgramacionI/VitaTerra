package Excepciones;

public class RespuestaIncorrectaException extends Exception {
    // Excepción que se lanza cuando se introduce una respuesta incorrecta
    public RespuestaIncorrectaException(String message) {
        super(message);
    }
}
