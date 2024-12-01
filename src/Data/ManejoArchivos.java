package Data;

import java.io.*;
import java.util.ArrayList;

import Game.Jugador;


public class ManejoArchivos {

    //Atributos
    private String nombreArchivo;

    //Constructor
    public ManejoArchivos(String nombreArchivo){

        this.nombreArchivo = nombreArchivo;
    }

    //Métodos
    public void escribirDatos(Jugador jugador) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo, true))) {
            oos.writeObject(jugador);
        } catch (IOException exc) {
            System.err.println("Error al escribir en el archivo: " + exc.getMessage());
        }
    }

    public ArrayList<String[]> mostrarRegistro() {
        ArrayList<String[]> registros = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            //Lee objetos Jugador del archivo y los agrega a la lista de registros
            while (true) {
                Jugador jugador = (Jugador) ois.readObject();
                registros.add(jugador.getInfo());
            }
        } catch (IOException | ClassNotFoundException exc) {
            System.err.println("Error al leer el archivo: " + exc.getMessage());
        }
        return registros;
    }
}
