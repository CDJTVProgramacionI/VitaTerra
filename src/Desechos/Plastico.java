package Desechos;

public class Plastico extends Desecho {
    private int espesura;

    public Plastico(String nombre, int espesura){
        super(nombre,"Plástico");
        this.espesura = espesura;
    }

    public static Desecho generaAleatorio() {
        int random = (int) (Math.random() * 6);
        return switch (random) {
            case 0 -> new Plastico("Botella de agua", 3);
            case 1 -> new Plastico("Bolsa de supermercado", 2);
            case 2 -> new Plastico("Envase de yogurt", 1);
            case 3 -> new Plastico("Envase de shampoo", 4);
            case 4 -> new Plastico("Envase de aceite", 5);
            case 5 -> new Plastico("Envase de detergente", 6);
            default -> null;
        };
    }

    @Override
    public String getInfo() {
        return "Espesura: " + espesura;
    }

    @Override
    public String[] tratar(String metodo) {
        return switch (metodo) {
            case "Fusionar" -> fusionar();
            case "Crear ecoladrillo" -> creaEcoladrillo();
            default -> null;
        };
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
