package Desechos;

public class Papel extends Desecho {

    private boolean entintado;
    public Papel(String nombre, boolean entintado){

        super(nombre, "organico");
        this.entintado = entintado;
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
