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

    public void procesarRespuesta(Jugador jugador, boolean restaTiempo, boolean esCorrecta, int puntos, int vidas) {
        /*
         * Revisa si la respuesta del jugador es correcta o no
         */
        if(esCorrecta && restaTiempo)
        {
            jugador.aumentarPuntosEn(puntos);
        } else if (!restaTiempo)
        {
            irAPantalla(12, null);
            jugadores.remove(jugador);
        } else
        {
            irAPantalla(7, null);
            jugador.disminuirVidasEn(vidas);
            if(!jugador.jugadorEstaVivo())
            {
                jugadores.remove(jugador);
            }
        }
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
