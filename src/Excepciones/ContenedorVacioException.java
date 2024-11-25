package Excepciones;

public class ContenedorVacioException extends Exception {
    // Excepción que se lanza cuando se intenta acceder a un contenedor vacío
    public ContenedorVacioException() {
        super("");
    }
}
