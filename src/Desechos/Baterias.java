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
            case 0 -> new Baterias("Batería de Niquel-Cadmio", "Niquel-Cadmio");
            case 1 -> new Baterias("Batería de Plomo-Acido", "Plomo-Acido");
            case 2 -> new Baterias("Batería de Litio", "Litio");
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
            return new String[]{"Recolectando y separando baterias","Desmontado","Tratando","Separando por flotacion cadmio del niquel","Destilando cadmio","Purificando Niquel"};
        }
        else
        {
            return null;
        }
    }

    @Override
    public String[] tratar(int metodo) {
        return switch (metodo) {
            case 1 -> recuperarMateriales();
            case 2 -> neutralizar();
            case 3 -> extraerQuimicos();
            default -> null;
        };
    }

    //Si es Plomo-Acido, se puede neutralizar
    public String[] neutralizar(){
        if(tipo.equals(("Plomo-Acido"))){
            return new String[]{"Recolectand y separando baterias", "Desmontando","neutralizando con carbonato de sodio","Fundiendo y purficando plomo","Limpiando y reciclando carcasa de baterias"};
        }
        else{
            return null;
        }
    }

    //Si es Litio, se puede extraer quimicos
    public String[] extraerQuimicos(){
        if(tipo.equals("Litio"))
        {
            return new String[]{"Recolectando y clasificando baterias", "Descargando bateria","Desmontando y triturando","","Separando y recuperando cobre, aluminio y electrodos de litio", "disolverviendo electrodos extrayendo litio","Recuperando litio"};
        }
        else
        {
            return null;
        }
    }
}


