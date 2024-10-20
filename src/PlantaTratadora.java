import Desechos.Desecho;
import java.util.ArrayList;
import java.util.Scanner;

class PlantaTratadora {
    private ArrayList<Contenedor> contenedores;

    private final String metodosBaterias = "1.Recuperar materiales\n2. Neutralizar\n3. Extraer químicos";
    private final String metodosBiologicos = "1. Desinfectar\n2. Incinerar\n3. Radiar\n4.Usar autoclave";
    private final String metodosCarton = "1. Reciclar capas\n2. Compostar\n3. Laminar";
    private final String metodosElectronicos = "1. Desensamblar\n2. Actualizar\n3. Bricolar";
    private final String metodosMedicamentos = "1. Incinerar\n2. Neutralizar\n3. Triturar\n4. Diluir";
    private final String metodosOrganicos = "1. Compostar\n2. Biodigerir";
    private final String metodosPapel = "1. Blanquear\n2. Desintegrar";
    private final String metodosPlasticos = "1. Fusionar\n2. Crear ecoladrillo";
    private final String metodosQuimicos = "1. Procesar quimicos\n2. Filtrar\n3. Neutralizar\n4. Diluir";
    private final String metodosVidrio = "1. Fundir\n2. Desinfectar\n3. Crear Material";


    // Constructor que recibe una lista de contenedores
    public PlantaTratadora(ArrayList<Contenedor> contenedores) {
        this.contenedores = contenedores; // Asignar la lista recibida
    }

    public String getMetodosParaContenedorN(int i) {
        String etiqueta = contenedores.get(i).getEtiqueta();
        return switch (etiqueta) {
            case "Baterias" -> metodosBaterias;
            case "Biologicos" -> metodosBiologicos;
            case "Carton" -> metodosCarton;
            case "Electronicos" -> metodosElectronicos;
            case "Medicamentos" -> metodosMedicamentos;
            case "Organicos" -> metodosOrganicos;
            case "Papel" -> metodosPapel;
            case "Plasticos" -> metodosPlasticos;
            case "Quimicos" -> metodosQuimicos;
            case "Vidrio" -> metodosVidrio;
            default -> "No se encontraron métodos para el contenedor";
        };
    }



    public boolean realizarTratamiento(Desecho desecho, ArrayList<String> pasosCorrectos) {
        ArrayList<String> pasosJugador = new ArrayList<>();

        boolean respCorrecta = true;

        // Validar si los pasos seleccionados coinciden con los correctos
        for(String paso : pasosJugador)
        {
            respCorrecta &= paso.equals(pasosCorrectos);
        }

        return respCorrecta;
    }
}