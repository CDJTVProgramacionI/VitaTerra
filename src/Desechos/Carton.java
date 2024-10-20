package Desechos;

public class Carton extends Desecho {
    private boolean multicapa;
    private int grosor;

    public Carton(String nombre, boolean multicapa, int grosor) {
        super(nombre, "Cartón");
        this.multicapa = multicapa;
        this.grosor = grosor;
    }

    public static Desecho generaAleatorio() {
        int random = (int) (Math.random() * 4);
        return switch (random) {
            case 0 -> new Carton("Tetrapack", true, 10);
            case 1 -> new Carton("Caja de pizza", false, 5);
            case 2 -> new Carton("Caja de zapatos", false, 7);
            case 3 -> new Carton("Caja de cereal", false, 3);
            default -> null;
        };
    }

    @Override
    public String getInfo()
    {
        return "Multicapa: " + (multicapa ? "Sí" : "No") + "Grosor: " + grosor;
    }

    @Override
    public String[] tratar(int metodo) {
        return switch (metodo) {
            case 1 -> reciclarCapas();
            case 2 -> compostar();
            case 3 -> laminar();
            default -> null;
        };
    }

    //Si el cartón es multicapa, se puede reciclar
    public String[] reciclarCapas() {
        if (multicapa) {
            return new String[]{"Enjuagar", "Separar", "Compactar"};
        } else {
            return null;
        }
    }

    //Si el cartón es monocapa y su grosor es menor o igual a 7, se puede compostar
    public String[] compostar() {
        if (grosor <= 7 && !multicapa) {
            return new String[]{"Cortar", "Humedecer", "Mezclar", "Descomponer", "Aplicar"};
        } else {
            return null;
        }
    }

    //Si el cartón es monocapa y su grosor es mayor a 7, se puede laminar
    public String[] laminar() {
        if (grosor > 7 && !multicapa) {
            return new String[]{"Cortar", "Aplanar", "Pegar", "Secar", "Prensar"};
        } else {
            return null;
        }
    }
}