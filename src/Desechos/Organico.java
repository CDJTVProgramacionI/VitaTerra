package Desechos;

public class Organico extends Desecho {
    private boolean compostable;

    public Organico(String nombre, boolean compostable) {
        super(nombre, "Orgánico");
        this.compostable = compostable;
    }

    public static Desecho generaAleatorio() {
        int random = (int) (Math.random() * 6);
        return switch (random) {
            case 0 -> new Organico("Cáscara de plátano", true);
            case 1 -> new Organico("Cáscara de huevo", true);
            case 2 -> new Organico("Cáscara de naranja", false);
            case 3 -> new Organico("Cáscara de manzana", true);
            case 4 -> new Organico("Cáscara de piña", false);
            case 5 -> new Organico("Cáscara de sandía", true);
            default -> null;
        };
    }

    @Override
    public String getInfo()
    {
        return "Nombre: " + getNombre() + " Compostable: " + (compostable? "Sí" : "No");
    }

    @Override
    public String[] tratar(int metodo) {
        return switch (metodo) {
            case 1 -> compostar();
            case 2 -> biodigerir();
            default -> null;
        };
    }

    //Si es compostable, se puede compostar
    public String[] compostar() {
        if(compostable)
        {
            return new String[]{"Llenar compostador", "Revolver periódicamente", "Obtener abono"};
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
            return new String[]{"Llenar biodigestor", "Fermentar", "Obtener biogás"};
        }
        else
        {
            return null;
        }
    }
}
