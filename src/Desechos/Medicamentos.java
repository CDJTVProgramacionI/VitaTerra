package Desechos;

public class Medicamentos extends Desecho {

    private boolean inflamable;
    private boolean reactivo;
    private boolean solido;

    public Medicamentos(String nombre, boolean inflamable, boolean reactivo, boolean solido) {
        super(nombre, "Medicamento");
        this.inflamable = inflamable;
        this.reactivo = reactivo;
        this.solido = solido;
    }

    public static Desecho generaAleatorio() {
        int random = (int) (Math.random() * 6);
        return switch (random) {
            case 0 -> new Medicamentos("Paracetamol", false, false, true);
            case 1 -> new Medicamentos("Ibuprofeno", false, false, true);
            case 2 -> new Medicamentos("Amoxicilina", false, true, true);
            case 3 -> new Medicamentos("Omeprazol", false, false, false);
            case 4 -> new Medicamentos("Diazepam", true, false, true);
            case 5 -> new Medicamentos("Insulina", false, true, false);
            default -> null;
        };
    }

    @Override
    public String getInfo(){
        return "Inflamable: " + (inflamable? "Sí" : "No") + " Reactivo: " + (reactivo? "Sí" : "No") + " Solido: " + (solido? "Si" : "No");
    }

    //Si es inflamable y no es reactivo, se puede incinerar
    public String[] incinerar(){
        if(inflamable && !reactivo)
        {
            return new String[]{"Incinerado"};
        }
        else
        {
            return null;
        }
    }

    //Si es reactivo, se puede neutralizar
    public String[] neutralizar(){
        if(reactivo)
        {
            return new String[]{"Neutralizado"};
        }
        else
        {
            return null;
        }
    }

    //Si no es reactivo, inflamable y es solido, se puede triturar
    public String[] triturar(){
        if(!reactivo && !inflamable && solido)
        {
            return new String[]{"Triturado"};
        }
        else
        {
            return null;
        }
    }

    //Si no es reactivo, inflamable y no es solido, se puede diluir
    public String[] diluir(){
        if(!reactivo && !inflamable && !solido)
        {
            return new String[]{"Diluido"};
        }
        else
        {
            return null;
        }
    }
    
}
