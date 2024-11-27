import Game.Contenedor;
import Game.Jugador;
import Game.Manager;
import Game.Nivel;

public class Main {
    public static void main(String[] args) {
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
                new Nivel(10, 1, contenedoresN1, 7, 280),
                new Nivel(15, 1, contenedoresN2, 8,  260),
                new Nivel(20, 2, contenedoresN3, 9,  250)
        };

        //Crea el manager
        Manager juego = new Manager(niveles);

    }
}