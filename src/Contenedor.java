import Desechos.Desecho;

import java.util.ArrayList;

public class Contenedor {
    // Atributos
    private String etiqueta; // Etiqueta del contenedor
    private ArrayList<Desecho> desechos; // Cantidad de desechos en el contenedor

    // Constructor
    public Contenedor(String etiqueta) {
        this.etiqueta = etiqueta;
        this.desechos = new ArrayList<Desecho>(); // Inicializa la lista de desechos
    }

    // Método para insertar un desecho
    public boolean insertarDesecho(Desecho desecho) {
        if (desecho.getClasificacion().equals(etiqueta)) {
            desechos.add(desecho); // Aumenta la cantidad de desechos si la clasificación coincide exactamente
            return true;
        } else return false;
    }

    public ArrayList<Desecho> vaciarContenedor() {
        ArrayList<Desecho> desechos = new ArrayList<Desecho>(this.desechos); // Crea una copia de la lista de desechos
        this.desechos.clear(); // Limpia la lista de desechos
        return desechos; // Retorna la lista de desechos
    }

    // Método para obtener la etiqueta
    public String getEtiqueta() {
        return etiqueta; // Retorna la etiqueta del contenedor
    }

    // Método para obtener la cantidad de desechos
    public int getCantidadDesechos() {
        return desechos.size(); // Retorna la cantidad de desechos
    }
}
