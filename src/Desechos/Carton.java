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
    public String[] tratar(String metodo)
    {
        return switch (metodo) {
            case "Reciclar capas" -> reciclarCapas();
            case "Compostar" -> compostar();
            case "Laminar" -> laminar();
            default -> null;
        };
    }

    //Si el cartón es multicapa, se puede reciclar
    public String[] reciclarCapas()
    {
        if(multicapa)
        {
            return new String[]{"Recolectando y clasificando","Triturando","colocando triturado en tanque de agua","Reciclando fibras de papel",""};
        }
        else
        {
            return null;
        }
    }

    //Si el cartón es monocapa y su grosor es menor o igual a 7, se puede compostar
    public String[] compostar()
    {
        if(grosor <=7 && !multicapa)
        {
            return new String[]{"Recolectando y Selecionando","Triturando","Mezclando con mas materiales organicos","Controlando humedad y aireación","Descomponiendo carton"};
        }
        else
        {
            return null;
        }
    }

    //Si el cartón es monocapa y su grosor es mayor a 7, se puede laminar
    public String[] laminar(){
        if(grosor > 7 && !multicapa)
        {
            return new String[]{"Cortando carton","Aplicando adhesivo","Presionando lamina protectora","Prensando","Secando","Cortando"};
        }
        else
        {
            return null;
        }
    }
}
