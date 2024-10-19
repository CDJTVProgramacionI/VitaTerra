package Desechos;

public class Quimicos extends Desecho {

    private boolean liquido;
    private boolean toxico;

    public Quimicos(String nombre, boolean liquido, boolean toxico){
        super(nombre,"Quimicos");
        this.liquido = liquido;
        this.toxico = toxico;
    }

    public static Desecho generaAleatorio() {
        int random = (int) (Math.random() * 6);
        return switch (random) {
            case 0 -> new Quimicos("Plomo", false, true);
            case 1 -> new Quimicos("Cloro", true, false);
            case 2 -> new Quimicos("Acido clorhidrico", true, true);
            case 3 -> new Quimicos("Estaño", false, false);
            case 4 -> new Quimicos("Acido acetico", true, false);
            case 5 -> new Quimicos("Acido fosforico", true, true);
            default -> null;
        };
    }

    @Override
    public String getInfo() {
        return "Liquido: " + (liquido? "Sí" : "No") + " Toxico: " + (toxico? "Sí" : "No");
    }

    //Si es no es toxico y no es liquido, se pasa por procesos quimicos
    public String[] procesosQuimicos()
    {
        if(!toxico && !liquido)
        {
            return new String[]{"Diluir"};
        }
        else
        {
            return null;
        }
    }

    //Si es toxico y liquido, se puede filtrar
    public String[] filtracionQuimicos(){
        if(toxico && liquido)
        {
            return new String[]{"Filtrar","Neutralizar"};
        }
        else
        {
            return null;
        }
    }

    //Si es toxico y no es liquido, se puede neutralizar
    public String[] neutralizar() {
        if(toxico && !liquido)
        {
            return new String[]{""};
        }
        else
        {
            return null;
        }
    }

    //Si no es toxico y es liquido, se puede diluir
    public String[] diluir(){
        if(!toxico && liquido)
        {
            return new String[]{""};
        }
        else
        {
            return null;
        }
    }
}
    

