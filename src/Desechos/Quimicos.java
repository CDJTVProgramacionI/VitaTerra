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

    @Override
    public String[] tratar(int metodo) {
        return switch (metodo) {
            case 1 -> procesosQuimicos();
            case 2 -> filtracionQuimicos();
            case 3 -> neutralizar();
            case 4 -> diluir();
            default -> null;
        };
    }

    //Si es no es toxico y no es liquido, se pasa por procesos quimicos
    public String[] procesosQuimicos()
    {
        if(!toxico && !liquido)
        {
            return new String[]{"Identificar desecho","Seleccionar tratamiento","Monitorear proceso","Controlar temperatura","Recolectar producto final"};
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
            return new String[]{"Selecionar filtro","Precipitar","Recoger residudos","Analizar liquido"};
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
            return new String[]{"Seleccionar neutralizante","Aplicar neutralizante","Ajustar PH","Verificar neutralizacion"};
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
            return new String[]{"Confirmar reactividad","Mezclar con agua","Medir concentracion","Verificar dilucion"};
        }
        else
        {
            return null;
        }
    }
}
    

