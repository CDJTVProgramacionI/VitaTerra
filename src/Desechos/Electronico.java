package Desechos;

public class Electronico extends Desecho {
    private String estado;
    private int cantidadDeMetales;

    public Electronico(String nombre, String estado, int cantidadDeMetales) {
        super(nombre, "Electrónico");
        this.estado = estado;
        this.cantidadDeMetales = cantidadDeMetales;
    }

    public static Desecho generaAleatorio() {
        int random = (int) (Math.random() * 7);
        return switch (random) {
            case 0 -> new Electronico("Computadora", "bueno", 5);
            case 1 -> new Electronico("Celular", "malo", 2);
            case 2 -> new Electronico("Tablet", "malo", 4);
            case 3 -> new Electronico("Cámara", "bueno", 3);
            case 4 -> new Electronico("Televisor", "malo", 6);
            case 5 -> new Electronico("Consola", "bueno", 2);
            case 6 -> new Electronico("Impresora", "malo", 5);
            default -> null;
        };
    }

    @Override
    public String getInfo() {
        return "Nombre: " + getNombre() + " Estado: " + estado + " Cantidad de metales: " + cantidadDeMetales;
    }

    @Override
    public String[] tratar(int metodo) {
        return switch (metodo) {
            case 1 -> desensamblar();
            case 2 -> actualizar();
            case 3 -> bricolar();
            default -> null;
        };
    }

    //Si el estado es malo y la cantidad de metales es mayor a 3, se puede desensamblar
    public String[] desensamblar(){
        if(estado.equals("malo") && cantidadDeMetales > 3){
            return new String[] {"Separar componentes", "Valorar", "Reciclar", "Triturar"};
        }
        else
        {
            return null;
        }
    }

    //Si el estado es bueno, se puede actualizar
    public String[] actualizar() {
        if (estado.equals("bueno")) {
            return new String[]{"Desmontar", "Desoldar", "Limpiar", "Soldar nuevos componentes"};
        } else {
            return null;
        }
    }

    //Si el estado es malo y la cantidad de metales es menor o igual a 3, se puede bricolar
    public String[] bricolar() {
        if (estado.equals("malo") && cantidadDeMetales <= 3) {
            return new String[]{"Desmontar", "Reparar", "Sustituir componentes"};
        } else {
            return null;
        }
    }
}
