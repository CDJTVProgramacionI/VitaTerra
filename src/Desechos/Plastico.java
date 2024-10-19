package Desechos;

public class Plastico extends Desecho {
    private int espesura;

    public Plastico(String nombre, int espesura){
        super(nombre,"Plastico");
        this.espesura = espesura;
    }

    //Si la espesura es menor o igual a 5, se puede fusionar
    public String[] fusionar()
    {
        if(espesura <= 5)
        {
            return new String[] {"Se puede fusionar"};
        }
        else
        {
            return null;
        }
    }

    //Si la espesura es mayor a 5, se puede crear un ecoladrillo
    public String[] creaEcoladrillo(){
        if(espesura > 5)
        {
            return new String[] {"Se puede crear un ecoladrillo"};
        }
        else
        {
            return null;
        }
    }
}
