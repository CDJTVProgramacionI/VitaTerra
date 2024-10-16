import java.util.ArrayList;

public class Manager {
    private InterfazDeUsuario iu;
    private ArrayList<Jugador> jugadores;

    //Constructor de clase
    public Manager() {
        /*
         * Se crean las pantallas a través de la interfaz de usuario
         * Se crean los jugadores sin valores iniciales
         */
        iu = new InterfazDeUsuario();
        jugadores = new ArrayList<Jugador>();
    };

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
