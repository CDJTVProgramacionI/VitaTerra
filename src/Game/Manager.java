package Game;

import Desechos.Desecho;
import Excepciones.MetodoIncorrectoException;
import Excepciones.RespuestaIncorrectaException;
import GUI.InterfazDeUsuario;

import java.util.ArrayList;

public class Manager {
    private InterfazDeUsuario iu;
    private ArrayList<Jugador> jugadores;
    private int numJugadorActivo;
    private Nivel[] niveles;
    private int nivelActual;
    private Temporizador temporizador;

    //Constructor de clase
    public Manager(Nivel[] niveles) {
        /*
         * Se crean las pantallas a través de la interfaz de usuario
         * Se crean los jugadores sin valores iniciales
         */
        iu = new InterfazDeUsuario(this);
        jugadores = new ArrayList<>();
        this.niveles = niveles;
        Temporizador temporizador = new Temporizador(this);
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getNumeroDeJugadores() {
        return jugadores.size();
    }

    public void Jugar(int nivel)
    {
        if(nivel == 3)
        {
            //TODO: Pantalla de ganador
            return;
        }

        nivelActual = nivel;
        for(Jugador jugador : jugadores)
        {
            niveles[nivel].ejecutar(this, temporizador, jugador);
            Jugar(nivel + 1);
        }
    }

    public void esperarPantalla(String pantalla, String[] argumentos)
    {
        //TODO: Esperar a que se obtenga una respuesta de la pantalla en turno
    }

    protected void finTiempo() {
        //Cuadro de dialogo se acabó el tiempo y quitar al jugador
        iu.mostrarPantalla(12);
        jugadores.remove(numJugadorActivo);
    }

    public void procesarRespuesta(int respuesta, Desecho desecho) throws RespuestaIncorrectaException {
        /*
         * Revisa si la respuesta del jugador es correcta o no
         */

        temporizador.detener();

        //Obtener jugador activo
        Jugador jugador = jugadores.get(numJugadorActivo);
        //Obtener nivel actual
        Nivel nivelData = niveles[nivelActual];

        boolean esCorrecta = nivelData.getContenedor(respuesta).insertarDesecho(desecho);

        if(esCorrecta)
        {
            jugador.aumentarPuntosEn(nivelData.getPuntos());
        }
        else
        {
            throw new RespuestaIncorrectaException(desecho.getNombre() + " se debe clasificar en " + desecho.getClasificacion());
        }
    }

    public void procesarRespuesta(int respuesta, Desecho desecho, PlantaTratadora planta) throws RespuestaIncorrectaException {
        /*
         * Revisa si la respuesta del jugador es correcta o no
         */

        try
        {
            String[] tratamiento = desecho.tratar(respuesta);
            planta.setTratamiento(tratamiento);
        }
        catch (MetodoIncorrectoException ex) {
            throw new RespuestaIncorrectaException(desecho.getNombre() + " no se puede tratar de esa forma");
        }
    }

    public void procesarRespuesta(Nivel nivelData, ArrayList<Integer> pasos, PlantaTratadora planta) throws RespuestaIncorrectaException
    {
        Jugador jugador = jugadores.get(numJugadorActivo);

        planta.realizarTratamiento(pasos);
        jugador.aumentarPuntosEn(nivelData.getPuntos());
    }

    public void confirmarJugadorConDesechosMinimos(int desechosMinimos, int desechosCorrectos)
    {
        Jugador jugador = jugadores.get(numJugadorActivo);
        if (desechosCorrectos < desechosMinimos && jugador.jugadorEstaVivo())
        {
            //Cuadro de dialogo no lograste clasificar y tratar suficientes desechos
            iu.mostrarPantalla(14);
            jugadores.remove(jugador);
        }

    }

    public void reiniciarJugadores() {
        /*
         * Reinicia los valores de los jugadores
         */

        jugadores.clear();
    }

    public Jugador getNesimoJugador(int n) {
        numJugadorActivo = n;
        return jugadores.get(n);
    }
}
