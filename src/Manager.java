public class Manager
{
    private InterfazDeUsuario iu;
    private Jugador[] jugadores;

    //Constructor de clase
    public Manager()
    {
        /*
        * Se crean las pantallas a través de la interfaz de usuario
        * Se crean los jugadores sin valores iniciales
        */
        iu = new InterfazDeUsuario();
        jugadores = new Jugador[2];
    }

    public void jugar()
    {
        /*
        * Llama a la interfaz de usuario a comenzar con el Nivel 1
         */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mostrarInfoJugador(Jugador jugador)
    {
        /*
        * Muestra la información del jugador seleccionado
        *
        * @param jugador:  Jugador a mostrar
         */
        System.out.println("Nombre: " + jugador.getNombre());
        System.out.println("Puntaje: " + jugador.getPuntaje());
        System.out.println("Vidas: " + jugador.getVidas());
    }

    public void procesarRespuesta()
    {
        /*
        * Revisa si la respuesta del jugador es correcta o no
         */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void irASiguienteNivel()
    {
        /*
        * Revisa si el jugador cuenta con los requisitos para avanzar de nivel
        * Si es así, llama a la interfaz de usuario a avanzar de nivel
         */
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
