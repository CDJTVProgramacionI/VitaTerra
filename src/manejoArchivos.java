import java.io.*;


public class manejoArchivos {

    //Atributos
    private String nombreArchivo;

    //Constructor
    public manejoArchivos (String nombreArchivo){

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

    public void mostrarRegistro(Jugador jugador) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            while(ois.available()>0){
                Jugador jugador = (Jugador) ois.readObject();
                System.out.println(Jugador);
            }
        } catch (IOException exc) {
            System.err.println("Error al escribir en el archivo: " + exc.getMessage());
        }
    }


}
