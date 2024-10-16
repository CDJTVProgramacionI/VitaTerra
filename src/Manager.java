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

    public int irAMenu(int numPantalla)
    {
        Menu menu = (Menu) iu.cambiarAPantalla(numPantalla);
        menu.mostrar();
        return menu.getOpcionElegida();
    }

    public void irAPantalla(int numPantalla)
    {
        iu.cambiarAPantalla(numPantalla);
    }

    public void irAMenu(int numPantalla, String[] argumentos)
    {
        iu.actualizarPantalla(numPantalla, argumentos);
        Menu menu = (Menu) iu.cambiarAPantalla(numPantalla);
        menu.mostrar();
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
