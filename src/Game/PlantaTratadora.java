package Game;

import Excepciones.MetodoIncorrectoException;
import Excepciones.RespuestaIncorrectaException;

import java.util.ArrayList;

public class PlantaTratadora {
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

    public void setTratamiento(String[] pasos) throws MetodoIncorrectoException {
        if (pasos == null) throw new MetodoIncorrectoException();
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
        String[] tratamiento = this.tratamiento.clone();
        int pasosRestantes = tratamiento.length;
        for (int i = 0; i < pasosRestantes; i++) {
            int random = (int) (Math.random() * (pasosRestantes-i));
            pasosDesorganizados[i] = tratamiento[random];
            tratamiento[random] = tratamiento[(pasosRestantes - i - 1)];
        }
        return pasosDesorganizados;
    }

    public String[] getTratamientoDesorganizado()
    {
        return tratamientoDesorganizado;
    }

    public Contenedor getContenedor(int i) {
        return contenedores[i];
    }


    public String[] getMetodosParaContenedorN(int i) {
        String etiqueta = contenedores[i].getEtiqueta();
        return switch (etiqueta) {
            case "Baterías" -> metodosBaterias.split("\n");
            case "Biológicos" -> metodosBiologicos.split("\n");
            case "Cartón" -> metodosCarton.split("\n");
            case "Electrónicos" -> metodosElectronicos.split("\n");
            case "Medicamentos" -> metodosMedicamentos.split("\n");
            case "Orgánico" -> metodosOrganicos.split("\n");
            case "Papel" -> metodosPapel.split("\n");
            case "Plástico" -> metodosPlasticos.split("\n");
            case "Químicos" -> metodosQuimicos.split("\n");
            case "Vidrio" -> metodosVidrio.split("\n");
            default -> null;
        };
    }

    public boolean realizarTratamiento(ArrayList<Integer> pasosJugador) throws RespuestaIncorrectaException {
        for (int i = 0; i < pasosJugador.size(); i++) {
            if (!tratamientoDesorganizado[pasosJugador.get(i)].equals(tratamiento[i])) {
                throw new RespuestaIncorrectaException("Respuesta incorrecta: " + pasosJugador.get(i));
            }
        }
    return true;
    }
}