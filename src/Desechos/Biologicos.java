package Desechos;

public class Biologicos extends Desecho {

    private boolean peligroso;
    private int nivelMicroorganismos;

    public Biologicos(String nombre, boolean peligroso, int nivelMicroorganismos) {
        super(nombre, "Biológicos");
        this.peligroso = peligroso;
        this.nivelMicroorganismos = nivelMicroorganismos;
    }

    public static Desecho generaAleatorio() {
        int random = (int) (Math.random() * 7);
        return switch (random) {
            case 0 -> new Biologicos("Muestra de mucosa", true, 2);
            case 1 -> new Biologicos("Aguja", false, 6);
            case 2 -> new Biologicos("Muestra para análisis", true, 7);
            case 3 -> new Biologicos("Sangre infectada", true, 10);
            case 4 -> new Biologicos("Guantes", false, 1);
            case 5 -> new Biologicos("Mascarilla", false, 3);
            case 6 -> new Biologicos("Gasas", false, 4);
            default -> null;
        };
    }

    @Override
    public String getInfo() {
        return "Nombre: " + getNombre() + " Peligroso: " + (peligroso ? "Sí" : "No") + " Nivel de microorganismos: " + nivelMicroorganismos + "\n";
    }

    @Override
    public String[] tratar(int metodo) {
        return switch (metodo) {
            case 1 -> desinfectar();
            case 2 -> incinerar();
            case 3 -> radiar();
            case 4 -> pasarAutoclave();
            default -> null;
        };
    }

    //Si el nivel de microorganismos está entre 1 y 3, se puede desinfectar
    public String[] desinfectar()
    {
        if(!peligroso && nivelMicroorganismos >=1 && nivelMicroorganismos <= 3)
        {
            return new String[]{"Desinfectar con peróxido de hidrógeno","Rociar desinfectante","Dejar secar"};
        }
        else
        {
            return null;
        }
    }

    //Si el nivel de microorganismos está entre 4 y 5, se puede incinerar
    public String[] incinerar()
    {
        if(!peligroso && nivelMicroorganismos >=4 && nivelMicroorganismos <= 5)
        {
            return new String[]{"Prender incinerador a 1200°C","Quemar desechos","Recoger cenizas","Tratar cenizas"};
        }
        else
        {
            return null;
        }
    }

    //Si el nivel de microorganismos es mayor a 5, se puede radiar
    public String[] radiar()
    {
        if(!peligroso && nivelMicroorganismos > 5)
        {
            return new String[]{"Someter a rayos gamma","Controlar niveles de radiación","Aislar desechos"};
        }
        else
        {
            return null;
        }
    }

    //Si es peligroso, se puede pasar por autoclave
    public String[] pasarAutoclave(){
        if(peligroso)
        {
            return new String[]{"Introducir en bolsas especiales","Colocar material en el autoclave","Calentar y presurizar desechos","Enfriar desechos"};
        }
        else
        {
            return null;
        }
    }
}
