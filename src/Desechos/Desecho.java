package Desechos;

public abstract class Desecho
{
    private String nombre;
    private String clasificacion;

    public Desecho(String nombre, String clasificacion) {
        this.nombre = nombre;
        this.clasificacion = clasificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClasificacion() {
        return clasificacion;
    }
}
