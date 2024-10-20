import Desechos.Desecho;

import java.util.ArrayList;

class PlantaTratadora {
    private Contenedor[] contenedores;
    private String[] tratamiento;
    private String[] tratamientoDesorganizado;

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
    public PlantaTratadora(Contenedor[] contenedores) {
        this.contenedores = contenedores; // Asignar la lista recibida
    }

    public void setTratamiento(String[] pasos) {
        this.tratamiento = pasos;
        tratamientoDesorganizado = desorganizarTratamiento();
    }

    public int getCantidadPasos()
    {
        return tratamiento.length;
    }

    private String[] desorganizarTratamiento()
    {
        String[] pasosDesorganizados = new String[tratamiento.length];
        int pasosRestantes = tratamiento.length;
        for (int i = 0; i < pasosRestantes; i++) {
            int random = (int) (Math.random() * pasosRestantes);
            pasosDesorganizados[i] = tratamiento[random];
            tratamiento[random] = tratamiento[pasosRestantes - 1];
            pasosRestantes--;
        }
        return pasosDesorganizados;
    }

    public String getTratamientoDesorganizado()
    {
        String texto = "";
        for (int i = 0; i < tratamientoDesorganizado.length; i++) {
            texto += (i + 1) + ". " + tratamientoDesorganizado[i] + "\n";
        }
        return texto;
    }

    public Contenedor getContenedor(int i) {
        return contenedores[i];
    }


    public String getMetodosParaContenedorN(int i) {
        String etiqueta = contenedores[i].getEtiqueta();
        return switch (etiqueta) {
            case "Baterías" -> metodosBaterias;
            case "Biológicos" -> metodosBiologicos;
            case "Cartón" -> metodosCarton;
            case "Electrónicos" -> metodosElectronicos;
            case "Medicamentos" -> metodosMedicamentos;
            case "Orgánico" -> metodosOrganicos;
            case "Papel" -> metodosPapel;
            case "Plástico" -> metodosPlasticos;
            case "Químicos" -> metodosQuimicos;
            case "Vidrio" -> metodosVidrio;
            default -> "No se encontraron métodos para el contenedor";
        };
    }

    public boolean realizarTratamiento(ArrayList<Integer> pasosJugador) {
        for (int i = 0; i < pasosJugador.size(); i++) {
            if (!tratamientoDesorganizado[i].equals(tratamiento[pasosJugador.get(i) - 1])) {
                return false;
            }
        }
        return true;
    }
}