package Desechos;

public class Carton extends Desecho {
    private boolean multicapa;
    private int grosor;

    public Carton(String nombre, boolean multicapa, int grosor) {
        super(nombre, "Cartón");
        this.multicapa = multicapa;
        this.grosor = grosor;
    }

    //Si el cartón es multicapa, se puede reciclar
    public String[] reciclarCapas()
    {
        if(multicapa)
        {
            return new String[]{};
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
            return new String[]{};
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
            return new String[]{};
        }
        else
        {
            return null;
        }
    }
}