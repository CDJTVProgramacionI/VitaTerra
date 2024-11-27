import Game.Jugador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class manejoArchivos {

    //Atributos
    private String nombreArchivo;

    //Constructor
    public manejoArchivos (String nombreArchivo){
        this.nombreArchivo = nombreArchivo;
    }

    //Métodos
    public void escribirDatos(Jugador jugador) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            br.write(jugador.getInfo());
            br.newLine();
        } catch (IOException exc) {
            System.err.println("Error al escribir en el archivo: " + exc.getMessage());
        }
    }
}
