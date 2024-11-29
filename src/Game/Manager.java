package Game;

import Desechos.Desecho;
import Excepciones.DesechosInsuficientesException;
import Excepciones.MetodoIncorrectoException;
import Excepciones.RespuestaIncorrectaException;
import Excepciones.VidasInsuficientesException;
import GUI.InterfazDeUsuario;

import java.awt.*;
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

        iu.mostrarPantalla(0);
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void mostrarDialogo(Frame ventanaP, String tituloCuadro, String mensaje) {
        iu.construirDialogo(ventanaP, tituloCuadro, mensaje);
    }

    public void jugar(int nivel)
    {
        if(nivel == 3)
        {
            //TODO: Pantalla de ganador
            iu.construirDialogo(,"Ganador","¡Felicidades, GANASTE!");
            return;
        }

        nivelActual = nivel;
      try {
        niveles[nivel].ejecutar(this, temporizador, jugador);
        jugar(nivel + 1);
      } catch ( RespuestaIncorrectaException ex) {
          iu.construirDialogo(,"Incorrecto", "Respuesta incorrecta");
    } catch (DesechosInsuficientesException ex) {
          iu.construirDialogo(,"Perdiste", "Perdiste, no clasifiscaste los desechos suficientes");
      }


    public void esperarPantalla(String pantalla, String[] argumentos) throws RespuestaIncorrectaException
    {
        try
        {
            //TODO: Esperar a que se obtenga una respuesta de la pantalla en turno
        }
        catch (VidasInsuficientesException ex)
        {
            //JOU: Hacer cuadro de diálogo de "perdiste(esperar a que Dani agregue la pantalla principal)"
            iu.construirDialogo(,"Perdiste", "Se te acabaron las vidas");
            jugadores.remove(numJugadorActivo);
            jugar(nivelActual);
        }
    }

    protected void finTiempo() {
        //Cuadro de dialogo se acabó el tiempo y quitar al jugador
        iu.construirDialogo(,"Perdiste", "Se te acabó el tiempo");
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

        boolean esCorrecta = nivelData.getContenedor(respuesta).insertarDesecho(desecho);

        if(esCorrecta)
        {
            jugador.aumentarPuntosEn(nivelData.getPuntos());
        }
        else
        {
            jugador.disminuirVidasEn(nivelData.getVidas());
            throw new RespuestaIncorrectaException(desecho.getNombre() + " se debe clasificar en " + desecho.getClasificacion());
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

        try
        {
            String[] tratamiento = desecho.tratar(respuesta);
            planta.setTratamiento(tratamiento);
        }
        catch (MetodoIncorrectoException ex) {
            jugador.disminuirVidasEn(nivelData.getVidas());
            throw new RespuestaIncorrectaException(desecho.getNombre() + " no se puede tratar de esa forma");
        }
    }

    public void procesarRespuesta(ArrayList<Integer> pasos, PlantaTratadora planta) throws RespuestaIncorrectaException, VidasInsuficientesException
    {
        temporizador.detener();

        Jugador jugador = jugadores.get(numJugadorActivo);
        //Obtener nivel actual
        Nivel nivelData = niveles[nivelActual];

        try
        {
            planta.realizarTratamiento(pasos); //Lanza excepción si se equivoca
        }catch (RespuestaIncorrectaException ex)
        {
            jugador.disminuirVidasEn(nivelData.getVidas());
            throw new RespuestaIncorrectaException("Error en el tratamiento de desechos");
        }
    }

    public void confirmarJugadorConDesechosMinimos(int desechosMinimos, int desechosCorrectos) throws DesechosInsuficientesException
    {
        Jugador jugador = jugadores.get(numJugadorActivo);
        if (desechosCorrectos < desechosMinimos)
        {
            //Cuadro de dialogo no lograste clasificar y tratar suficientes desechos
            iu.construirDialogo(,"Fin de tu turno", "No lograste clasificar y tratar suficientes desechos");
            jugadores.remove(jugador);
            throw new DesechosInsuficientesException();
        }

    }
}
