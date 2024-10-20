import Desechos.Desecho;
import java.util.ArrayList;
import java.util.Scanner;

class PlantaTratadora {
    private ArrayList<Contenedor> contenedores;

    // Constructor que recibe una lista de contenedores
    public PlantaTratadora(ArrayList<Contenedor> contenedores) {
        this.contenedores = contenedores; // Asignar la lista recibida
    }

    /*public boolean realizarTratamiento(Desecho desecho, Scanner scanner, boolean tiempoAgotado) {
        ArrayList<String> pasosCorrectos = desecho.getPasosCorrectos();
        ArrayList<String> pasosJugador = new ArrayList<>();

        // Validar si los pasos seleccionados coinciden con los correctos
        return pasosJugador.equals(pasosCorrectos);
    }*/
}