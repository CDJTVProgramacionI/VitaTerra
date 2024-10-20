public class Main {
    public static void main(String[] args) {
        //Crea el manager
        Manager juego = new Manager();

        //Instancias de contenedores
        Contenedor[] contenedoresN1 = new Contenedor[]
                {
                        new Contenedor("Plástico"),
                        new Contenedor("Papel"),
                        new Contenedor("Orgánico"),
                };

        Contenedor[] contenedoresN2 = new Contenedor[]
                {
                        new Contenedor("Electrónicos"),
                        new Contenedor("Vidrio"),
                        new Contenedor("Baterías"),
                        new Contenedor("Cartón"),
                };

        Contenedor[] contenedoresN3 = new Contenedor[]
                {
                        new Contenedor("Biológicos"),
                        new Contenedor("Químicos"),
                        new Contenedor("Medicamentos"),
                };

        //Instacias de nivel
        Nivel[] niveles = new Nivel[]{
                new Nivel(10, 1, contenedoresN1, 7, juego, 130),
                new Nivel(15, 1, contenedoresN2, 8, juego, 110),
                new Nivel(20, 2, contenedoresN3, 9, juego, 100)
        };

        //Juego principal
        int opcion;
        do {
            //Ir a menu principal
            juego.irAPantalla(0, null);
            opcion = juego.getOpcionElegida();

            //Según lo elegido
            switch (opcion) {
                case 1:
                    Jugar(juego, niveles);
                    break;
                case 2:
                    //Muestra las instrucciones
                    juego.irAPantalla(2, null);
                    break;
                case 3:
                    //Sale del juego
                    System.out.println("Gracias por jugar");
                    break;
            }
        } while (opcion != 3);
    }

    public static void Jugar(Manager juego, Nivel[] niveles)
    {
        //Ir a pantalla de selección de jugadores
        juego.irAPantalla(1, null);
        juego.setJugadores();
        boolean hayJugadores = true;
        for (int i = 0; i < 3 && hayJugadores; i++) {
            //Jugar los niveles
            hayJugadores = niveles[i].ejecutarConResultado();

            if(hayJugadores && i < 2)
            {
                //Ir a pantalla de cambio de nivel
                juego.irAPantalla(10, null);
            }
        }

        if(hayJugadores)
        {
            //Crear texto de los ganadores
            String ganadores = "";
            for (int i = 0; i < juego.getNumeroDeJugadores(); i++)
            {
                Jugador jugador = juego.getNesimoJugador(i);
                ganadores += jugador.getInfo();
            }
            String[] argumentos = new String[]
                    {
                            juego.getNumeroDeJugadores() > 1 ? "han" : "has",
                    };

            //Ir a pantalla de ganadores
            juego.irAPantalla(9, argumentos);
        }
        else
        {
            //Ir a pantalla de perdedores
            juego.irAPantalla(8, null);
        }

        juego.reiniciarJugadores();
    }
}
