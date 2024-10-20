package Desechos;

public class Papel extends Desecho {

    private boolean entintado;
    public Papel(String nombre, boolean entintado){

        super(nombre, "Papel");
        this.entintado = entintado;
    }

    public static Desecho generaAleatorio() {
        int random = (int) (Math.random() * 6);
        return switch (random) {
            case 0 -> new Papel("Opalina", false);
            case 1 -> new Papel("Periódico", true);
            case 2 -> new Papel("Papel cartulina", false);
            case 3 -> new Papel("Papel bond", true);
            case 4 -> new Papel("Revista vieja", true);
            case 5 -> new Papel("Libro roto", true);
            default -> null;
        };
    }

    @Override
    public String getInfo()
    {
        return "Entintado: " + (entintado ? "Sí" : "No");
    }

    //Si eliges blanquear, el papel no debe estar entintado
    public String[] blanquear(){
        if(!entintado){
            return new String[]{"Papel blanqueado"};
        }
        else
        {
            return null;
        }
    }

    //Si eliges desintegrar, el papel debe estar entintado
    public String[] desintegrar(){
        if(entintado){
            return new String[]{"Papel desintegrado"};
        }
        else
        {
            return null;
        }
    }
}
