public class Manager
{
    private InterfazDeUsuario iu;
    private Jugador[] jugadores;

    public Manager()
    {
        iu = new InterfazDeUsuario();
        jugadores = new Jugador[2];
    }

    public void jugar()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mostrarInfoJugador(Jugador jugador)
    {
        System.out.println("Nombre: " + jugador.getNombre());
        System.out.println("Puntaje: " + jugador.getPuntaje());
        System.out.println("Vidas: " + jugador.getVidas());
    }

    public void procesarRespuesta()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void irASiguienteNivel()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
