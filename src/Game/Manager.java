package Game;

import Desechos.Desecho;
import Excepciones.MetodoIncorrectoException;
import Excepciones.RespuestaIncorrectaException;
import Excepciones.VidasInsuficientesException;
import GUI.*;
import Data.manejoArchivos;

import java.util.ArrayList;

public class Manager {
    private InterfazDeUsuario iu;
    private ArrayList<Jugador> jugadores;
    private int numJugadorActivo;
    private Nivel[] niveles;
    private int nivelActual;
    private Temporizador temporizador;
    private manejoArchivos archivo;

    //Constructor de clase
    public Manager(Nivel[] niveles) {
        /*
         * Se crean las pantallas a través de la interfaz de usuario
         * Se crean los jugadores sin valores iniciales
         */
        jugadores = new ArrayList<>();
        this.niveles = niveles;
        temporizador = new Temporizador(this);
        archivo = new manejoArchivos("Bitácora.vtr");
        iu = new InterfazDeUsuario(this);

        iu.mostrarPantalla(0);
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Temporizador getTemporizador() {
        return temporizador;
    }

    public Nivel getNivelActual() {
        return niveles[nivelActual];
    }

    public void mostrarDialogo(String tituloCuadro, String mensaje) {
        iu.construirDialogo(tituloCuadro, mensaje);
    }

    public void jugar(int nivel) {
        if (jugadores.isEmpty()){
            iu.construirDialogo("Fin del juego", "Ya no hay jugadores");
            iu.cierraPantalla();
            iu.mostrarPantalla(0);
            return;
        }

        nivelActual = nivel;

        if(nivel == 1)
        {
            iu.setPantalla(5, new PantallaDesechos2(iu, this));
        }
        else {
            iu.setPantalla(5, new PantallaDesechos(iu, this));
        }

        niveles[nivel].configurar(temporizador);
        iu.mostrarPantalla(5);
    }

    public Jugador getJugadorActual()
    {
        return jugadores.get(numJugadorActivo);
    }

    public void perder(String message)
    {
        iu.construirDialogo("Perdiste", message);
        archivo.escribirDatos(jugadores.get(numJugadorActivo));
        jugadores.remove(numJugadorActivo);
        if(jugadores.isEmpty())
        {
            iu.mostrarPantalla(0);
        }
        else
        {
            jugar(nivelActual);
        }
    }

    protected void finTiempo() {
        //Cuadro de dialogo se acabó el tiempo y quitar al jugador
        iu.construirDialogo( "Perdiste", "Se te acabó el tiempo");
        jugadores.remove(numJugadorActivo);
        jugar(nivelActual);
    }

    public void procesarRespuesta(int respuesta, Desecho desecho) throws RespuestaIncorrectaException, VidasInsuficientesException {
        /*
         * Revisa si la respuesta del jugador es correcta o no
         */

        temporizador.detener();

        //Obtener jugador activo
        Jugador jugador = jugadores.get(numJugadorActivo);
        //Obtener nivel actual
        Nivel nivelData = niveles[nivelActual];

        try
        {
            nivelData.getContenedor(respuesta).insertarDesecho(desecho);
            jugador.aumentarPuntosEn(nivelData.getPuntos());
        }
        catch (RespuestaIncorrectaException ex)
        {
            jugador.disminuirVidasEn(nivelData.getVidas());
            throw new RespuestaIncorrectaException(ex.getMessage());
        }
    }

    public void procesarRespuesta(int respuesta, Desecho desecho, PlantaTratadora planta) throws RespuestaIncorrectaException, VidasInsuficientesException {
        /*
         * Revisa si la respuesta del jugador es correcta o no
         */

        temporizador.detener();

        //Obtener jugador activo
        Jugador jugador = jugadores.get(numJugadorActivo);

        //Obtener nivel actual
        Nivel nivelData = niveles[nivelActual];

        try {
            String[] tratamiento = desecho.tratar(respuesta);
            planta.setTratamiento(tratamiento);
        } catch (MetodoIncorrectoException ex) {
            jugador.disminuirVidasEn(nivelData.getVidas());
            throw new RespuestaIncorrectaException(desecho.getNombre() + " no se puede tratar de esa forma");
        }
    }

    public void procesarRespuesta(ArrayList<Integer> pasos, PlantaTratadora planta) throws RespuestaIncorrectaException, VidasInsuficientesException {
        temporizador.detener();

        Jugador jugador = jugadores.get(numJugadorActivo);
        //Obtener nivel actual
        Nivel nivelData = niveles[nivelActual];

        try {
            planta.realizarTratamiento(pasos); //Lanza excepción si se equivoca
        } catch (RespuestaIncorrectaException ex) {
            jugador.disminuirVidasEn(nivelData.getVidas());
            throw new RespuestaIncorrectaException("Error en el tratamiento de desechos");
        }
    }

    public void ganar()
    {
        if (nivelActual == 2) {
            archivo.escribirDatos(getJugadorActual());
            iu.construirDialogo("Ganador", "¡Felicidades, GANASTE!");
            iu.cierraPantalla();
            iu.mostrarPantalla(0);
        }
        else {
            iu.cierraPantalla();
            numJugadorActivo++;
            if(numJugadorActivo >= jugadores.size())
            {
                numJugadorActivo = 0;
                nivelActual++;
            }
            jugar(nivelActual);
        }


    }
}
