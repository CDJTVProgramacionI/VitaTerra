import Desechos.Desecho;
import Excepciones.ContenedorVacioException;
import Excepciones.RespuestaIncorrectaException;

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
    public boolean insertarDesecho(Desecho desecho) throws RespuestaIncorrectaException {
        if (desecho.getClasificacion().equals(etiqueta)) {
            desechos.add(desecho);
            return true;
        } else {
            throw new RespuestaIncorrectaException(desecho.getNombre() + " se debe clasificar en " + desecho.getClasificacion());
        }
    }

    public ArrayList<Desecho> vaciarContenedor() throws ContenedorVacioException {
        if (desechos.isEmpty()) {
            // Si el contenedor está vacío, lanzamos la excepción
            throw new ContenedorVacioException();
        }
        ArrayList<Desecho> desechosVaciados = new ArrayList<Desecho>(this.desechos); // Crea una copia de la lista de desechos
        this.desechos.clear(); // Limpia la lista de desechos
        return desechosVaciados; // Retorna la lista de desechos vaciados
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
