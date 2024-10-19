package Desechos;

public class Biologicos extends Desecho {

    private boolean peligrosos;
    private int nivelMicroorganismos;

    public Biologicos(String nombre, boolean peligrosos, int nivelMicroorganismos) {
        super(nombre, "Biológicos");
        this.peligrosos = peligrosos;
        this.nivelMicroorganismos = nivelMicroorganismos;
    }

    //Si el nivel de microorganismos está entre 1 y 3, se puede desinfectar
    public String[] desinfectar()
    {
        if(!peligrosos && nivelMicroorganismos >=1 && nivelMicroorganismos <= 3)
        {
            return new String[]{"Desinfectado"};
        }
        else
        {
            return null;
        }
    }

    //Si el nivel de microorganismos está entre 4 y 5, se puede incinerar
    public String[] incinerar()
    {
        if(!peligrosos && nivelMicroorganismos >=4 && nivelMicroorganismos <= 5)
        {
            return new String[]{"Incinerado"};
        }
        else
        {
            return null;
        }
    }

    //Si el nivel de microorganismos es mayor a 5, se puede radiar
    public String[] radiar()
    {
        if(!peligrosos && nivelMicroorganismos > 5)
        {
            return new String[]{"Radiado"};
        }
        else
        {
            return null;
        }
    }

    //Si es peligroso, se puede pasar por autoclave
    public String[] pasarAutoclave(){
        if(peligrosos)
        {
            return new String[]{"Pasar por autoclave"};
        }
        else
        {
            return null;
        }
    }
}