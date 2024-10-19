package Desechos;

public class Baterias extends Desecho {

    private String tipo;

    public Baterias(String nombre, String tipo) {
        super(nombre, "Baterías");
        this.tipo = tipo;
    }

    public static Desecho generaAleatorio() {
        int random = (int) (Math.random() * 3);
        return switch (random) {
            case 0 -> new Baterias("Niquel-Cadmio", "Niquel-Cadmio");
            case 1 -> new Baterias("Plomo-Acido", "Plomo-Acido");
            case 2 -> new Baterias("Litio", "Litio");
            default -> null;
        };
    }

    @Override
    public String getInfo() {
        return "tipo: " + tipo;
    }

    //Si es Niquel-Cadmio, se puede recuperar
    public String[] recuperarMateriales()
    {
        if(tipo.equals("Niquel-Cadmio"))
        {
            return new String[]{"Litio", "Cobre", "Aluminio"};
        }
        else
        {
            return null;
        }
    }

    //Si es Plomo-Acido, se puede neutralizar
    public String[] neutralizar(){
        if(tipo.equals(("Plomo-Acido"))){
            return new String[]{"Agua", "Bicarbonato de sodio"};
        }
        else{
            return null;
        }
    }

    //Si es Litio, se puede extraer quimicos
    public String[] extraerQuimicos(){
        if(tipo.equals("Litio"))
        {
            return new String[]{"Cobre", "Aluminio"};
        }
        else
        {
            return null;
        }
    }
}


