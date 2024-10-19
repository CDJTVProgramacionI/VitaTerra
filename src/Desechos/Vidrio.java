package Desechos;

public class Vidrio extends Desecho {

    private boolean envase;
    private boolean roto;

    public Vidrio(String nombre, boolean envase, boolean roto) {

        super(nombre, "Vidrio");
        this.envase = envase;
        this.roto = roto;
    }

    //Si eliges fundir, el vidrio debe ser un envase y roto
    public String[] fundir() {
        if (envase && roto) {
            return new String[]{"Vidrio fundido"};
        } else {
            return null;
        }
    }

    //Si eliges desinfectar, el vidrio debe ser un envase y no debe estar roto
    public String[] desinfectar() {
        if (envase && !roto) {
            return new String[]{"Vidrio desinfectado"};
        } else {
            return null;
        }
    }

    //Si eliges crearMaterial, el vidrio no debe ser un envase
    public String[] crearMaterial() {
        if (!envase) {
            return new String[]{"Material de vidrio"};
        } else {
            return null;
        }
    }
}
