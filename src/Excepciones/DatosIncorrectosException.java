package Excepciones;

public class DatosIncorrectosException extends Exception {
    // Excepción que se lanza cuando se intenta introducir datos incorrectos
    public DatosIncorrectosException(String message) {
        super(message);
    }
}
