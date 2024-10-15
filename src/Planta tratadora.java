// Clase abstracta Desecho
abstract class Desecho {
    private String nombre;
    private String clasificacion;

    public Desecho(String nombre, String clasificacion) {
        this.nombre = nombre;
        this.clasificacion = clasificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    // Método abstracto para que cada tipo de desecho implemente su tratamiento
    public abstract void procesar();
}

// Vidrio
class Vidrio extends Desecho {
    public Vidrio(String nombre) {
        super(nombre, "Vidrio");
    }

    @Override
    public void procesar() {
        triturar();
        fundir();
        eliminarImpurezas();
        almacenarCalcin();
    }

    private void triturar() {
        System.out.println("Vidrio: Triturando...");
    }

    private void fundir() {
        System.out.println("Vidrio: Fundiendo...");
    }

    private void eliminarImpurezas() {
        System.out.println("Vidrio: Eliminando impurezas...");
    }

    private void almacenarCalcin() {
        System.out.println("Vidrio: Almacenando calcin...");
    }
}

// Biologicos
class Biologicos extends Desecho {
    public Biologicos(String nombre) {
        super(nombre, "Biológicos");
    }

    @Override
    public void procesar() {
        System.out.println("Tratando desechos biológicos...");
    }
}

// Baterias
class Baterias extends Desecho {
    public Baterias(String nombre) {
        super(nombre, "Baterías");
    }

    @Override
    public void procesar() {
        preparar();
        triturar();
        separar();
        fundir();
        refinar();
    }

    private void preparar() {
        System.out.println("Batería: Preparando...");
    }

    private void triturar() {
        System.out.println("Batería: Triturando...");
    }

    private void separar() {
        System.out.println("Batería: Separando componentes...");
    }

    private void fundir() {
        System.out.println("Batería: Fundiendo...");
    }

    private void refinar() {
        System.out.println("Batería: Refinando materiales...");
    }
}

// Químicos
class Quimicos extends Desecho {
    public Quimicos(String nombre) {
        super(nombre, "Químicos");
    }

    @Override
    public void procesar() {
        separar();
        neutralizar();
        diluir();
        tratar();
    }

    private void separar() {
        System.out.println("Químicos: Separando...");
    }

    private void neutralizar() {
        System.out.println("Químicos: Neutralizando...");
    }

    private void diluir() {
        System.out.println("Químicos: Diluyendo...");
    }

    private void tratar() {
        System.out.println("Químicos: Tratando...");
    }
}

// Carton
class Carton extends Desecho {
    public Carton(String nombre) {
        super(nombre, "Cartón");
    }

    @Override
    public void procesar() {
        triturar();
        pulpear();
        refinar();
        formarHojas();
        enrrollar();
    }

    private void triturar() {
        System.out.println("Cartón: Triturando...");
    }

    private void pulpear() {
        System.out.println("Cartón: Pulpeando...");
    }

    private void refinar() {
        System.out.println("Cartón: Refinando...");
    }

    private void formarHojas() {
        System.out.println("Cartón: Formando hojas...");
    }

    private void enrrollar() {
        System.out.println("Cartón: Enrollando...");
    }
}

// Clase Contenedor
class Contenedor {
    private String etiqueta;
    private ArrayList<Desecho> desechos;

    public Contenedor(String etiqueta) {
        this.etiqueta = etiqueta;
        this.desechos = new ArrayList<>();
    }

    public void insertarDesecho(Desecho desecho) {
        desechos.add(desecho);
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public int getCantidadDesechos() {
        return desechos.size();
    }

    public void procesarDesechos() {
        System.out.println("Procesando desechos en el contenedor: " + etiqueta);
        for (Desecho desecho : desechos) {
            System.out.println("Procesando " + desecho.getNombre() + " (" + desecho.getClasificacion() + ")");
            desecho.procesar();
        }
    }
}

// Clase Main para ejecutar el programa
public class PlantaTratadora {
    public static void main(String[] args) {
        // Crear desechos
        Vidrio vidrio = new Vidrio("Vidrio reciclable");
        Baterias baterias = new Baterias("Batería de coche");
        Quimicos quimicos = new Quimicos("Residuos tóxicos");

        // Crear contenedores
        Contenedor contenedorVidrio = new Contenedor("Contenedor de Vidrio");
        Contenedor contenedorBaterias = new Contenedor("Contenedor de Baterías");
        Contenedor contenedorQuimicos = new Contenedor("Contenedor de Químicos");

        // Insertar desechos en los contenedores
        contenedorVidrio.insertarDesecho(vidrio);
        contenedorBaterias.insertarDesecho(baterias);
        contenedorQuimicos.insertarDesecho(quimicos);

        // Procesar desechos
        contenedorVidrio.procesarDesechos();
        contenedorBaterias.procesarDesechos();
        contenedorQuimicos.procesarDesechos();
    }
}
