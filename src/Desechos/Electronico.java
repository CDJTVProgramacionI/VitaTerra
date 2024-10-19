package Desechos;

public class Electronico extends Desecho {
    private String estado;
    private int cantidadDeMetales;

    public Electronico(String nombre, String estado, int cantidadDeMetales){
        super(nombre,"Electrónico");
        this.estado = estado;
        this.cantidadDeMetales = cantidadDeMetales;
    }

    //Si el estado es malo y la cantidad de metales es mayor a 3, se puede desensamblar
    public String[] desensamblar(){
        if(estado.equals("malo") && cantidadDeMetales > 3){
            return new String[]{};
        }
        else
        {
            return null;
        }
    }

    //Si el estado es bueno, se puede actualizar
    public String[] actualizar(){
        if(estado.equals("bueno")){
            return new String[]{};
        }
        else
        {
            return null;
        }
    }

    //Si el estado es malo y la cantidad de metales es menor o igual a 3, se puede bricolar
    public String[] bricolar(){
        if(estado.equals("malo") && cantidadDeMetales <= 3){
            return new String[]{};
        }
        else
        {
            return null;
        }
    }
}
