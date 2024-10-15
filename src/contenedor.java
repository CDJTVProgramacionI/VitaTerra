public class Contenedor {
    // Atributos
    private String etiqueta; // Etiqueta del contenedor
    private int cantidadDesechos; // Cantidad de desechos en el contenedor

    // Constructor
    public Contenedor(String etiqueta) {
        this.etiqueta = etiqueta;
        this.cantidadDesechos = 0; // Inicializa la cantidad de desechos a 0
    }

    // Método para insertar un desecho
    public void insertarDesecho() {
        cantidadDesechos++; // Aumenta la cantidad de desechos
    }

    // Método para obtener la etiqueta
    public String getEtiqueta() {
        return etiqueta; // Retorna la etiqueta del contenedor
    }

    // Método para obtener la cantidad de desechos
    public int getCantidadDesechos() {
        return cantidadDesechos; // Retorna la cantidad de desechos
    }
}
