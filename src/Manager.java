import Desechos.Desecho;

import java.util.ArrayList;

public class Manager {
    private InterfazDeUsuario iu;
    private ArrayList<Jugador> jugadores;
    private Pantalla pantallaActual;

    //Constructor de clase
    public Manager() {
        /*
         * Se crean las pantallas a través de la interfaz de usuario
         * Se crean los jugadores sin valores iniciales
         */
        iu = new InterfazDeUsuario();
        jugadores = new ArrayList<Jugador>();
    };

    public int getOpcionElegida() {
        return ((Menu)pantallaActual).getOpcionElegida();
    }

    public void setJugadores()
    {
        int cantidadJugadores = getOpcionElegida();
        for(int i = cantidadJugadores; i > 0; i--)
        {
            jugadores.add(new Jugador("Jugador " + (i)));
        }
    }

    public int getNumeroDeJugadores() {
        return jugadores.size();
    }

    public void irAPantalla(int n, String[] argumentos) {
        /*
         * Cambia la pantalla actual a la pantalla n
         */
        if(argumentos != null)
        {
            iu.actualizarPantalla(n, argumentos);
        }
        pantallaActual = iu.mostrarPantalla(n);

        //Esperar tecla solo si es pantalla
        if(pantallaActual.getClass().equals(Pantalla.class))
        {
            pantallaActual.esperarTecla();
        }
    }

    public boolean procesarRespuesta(Jugador jugador, boolean restaTiempo, Nivel nivelData, Desecho desecho) {
        /*
         * Revisa si la respuesta del jugador es correcta o no
         */

        int respuesta = getOpcionElegida() - 1;
        boolean esCorrecta = nivelData.getContenedor(respuesta).insertarDesecho(desecho);

        if(esCorrecta && restaTiempo)
        {
            jugador.aumentarPuntosEn(nivelData.getPuntos());
        } else if (!restaTiempo)
        {
            //Mostrar pantalla se acabó el tiempo y quitar al jugador
            irAPantalla(12, null);
            jugadores.remove(jugador);
        } else
        {
            //Mostrar pantalla respuesta incorrecta
            irAPantalla(7, null);
            jugador.disminuirVidasEn(nivelData.getVidas());
            if(!jugador.jugadorEstaVivo())
            {
                jugadores.remove(jugador);
            }
        }
        return esCorrecta;
    }

    public void reiniciarJugadores() {
        /*
         * Reinicia los valores de los jugadores
         */

        jugadores = new ArrayList<Jugador>();
    }

    public Jugador getNesimoJugador(int n) {
        return jugadores.get(n);
    }
}
