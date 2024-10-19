package Desechos;

public class Organico extends Desecho {
    private boolean compostable;

    public Organico(String nombre, boolean compostable) {
        super(nombre, "organico");
        this.compostable = compostable;
    }

    //Si es compostable, se puede compostar
    public String[] compostar() {
        if(compostable)
        {
            return new String[]{"Compostar"};
        }
        else
        {
            return null;
        }
    }

    //Si no es compostable, se puede biodigerir
    public String[] biodigerir() {
        if(!compostable)
        {
            return new String[]{"Biodigerir"};
        }
        else
        {
            return null;
        }
    }
}
