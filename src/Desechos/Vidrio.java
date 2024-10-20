package Desechos;

public class Vidrio extends Desecho {

    private boolean envase;
    private boolean roto;

    public Vidrio(String nombre, boolean envase, boolean roto) {

        super(nombre, "Vidrio");
        this.envase = envase;
        this.roto = roto;
    }

    public static Desecho generaAleatorio() {
        int random = (int) (Math.random() * 6);
        return switch (random) {
            case 0 -> new Vidrio("Botella de vidrio", true, false);
            case 1 -> new Vidrio("Vaso de vidrio", true, false);
            case 2 -> new Vidrio("Plato de vidrio", false, true);
            case 3 -> new Vidrio("Vasija de vidrio", true, true);
            case 4 -> new Vidrio("Cenicero de vidrio", false, false);
            case 5 -> new Vidrio("Cristal decorativo", false, true);
            default -> null;
        };
    }

    @Override
    public String getInfo() {
        return "Es Envase: " + (envase ? "Sí" : "No") + " Roto: " + (roto ? "Sí" : "No");
    }

    @Override
    public String[] tratar(int metodo) {
        return switch (metodo) {
            case 1 -> fundir();
            case 2 -> desinfectar();
            case 3 -> crearMaterial();
            default -> null;
        };
    }

    //Si eliges fundir, el vidrio debe ser un envase y roto
    public String[] fundir() {
        if (envase && roto) {
            return new String[]{"Mezclar", "Triturar", "Fusionar", "Moldear"};
        } else {
            return null;
        }
    }

    //Si eliges desinfectar, el vidrio debe ser un envase y no debe estar roto
    public String[] desinfectar() {
        if (envase && !roto) {
            return new String[]{"Lavar", "Desinfectar por calor", "Enfriar"};
        } else {
            return null;
        }
    }

    //Si eliges crearMaterial, el vidrio no debe ser un envase
    public String[] crearMaterial() {
        if (!envase) {
            return new String[]{"Clasificar por color", "Limpiar", "Triturar", "Fundir", "Moldear", "Enfriar"};
        } else {
            return null;
        }
    }
}
