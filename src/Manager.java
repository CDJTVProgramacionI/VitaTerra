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

    public Pantalla getPantallaActual() {
        return pantallaActual;
    }

    public void irAPantalla(int n, String[] argumentos) {
        /*
         * Cambia la pantalla actual a la pantalla n
         */
        if(argumentos != null)
        {
            iu.actualizarPantalla(n, argumentos);
        }
        pantallaActual = iu.cambiarAPantalla(n);
    }

    public void procesarRespuesta(Jugador jugador, boolean esCorrecta, int consecuencia) {
        /*
         * Revisa si la respuesta del jugador es correcta o no
         */
        if(esCorrecta)
        {
            jugador.aumentarPuntosEn(consecuencia);
        }
        else
        {
            jugador.disminuirVidasEn(consecuencia);
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
