package Data;

import java.io.*;
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
            oos.writeObject(jugador.getInfo());
        } catch (IOException exc) {
            System.err.println("Error al escribir en el archivo: " + exc.getMessage());
        }
    }

    public void mostrarRegistro() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            while(ois.available()>0){
                Jugador jugador = (Jugador) ois.readObject();
                System.out.println(jugador);
            }
        } catch (IOException exc) {
            System.err.println("Error al escribir en el archivo: " + exc.getMessage());
        }
        catch (ClassNotFoundException exc) {
            System.err.println("Error al escribir en el archivo: " + exc.getMessage());
        }
    }


}
