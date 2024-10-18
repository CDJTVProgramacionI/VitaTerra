public class Main
{
    public static void main(String[] args) {
        //Crea el manager
        Manager juego = new Manager();

        //Instacias de nivel
        Nivel[] niveles=new Nivel[]{
                new Nivel(10, 1, Contenedor[] contenedores, 7, juego, 130),
                new Nivel(15, 1, Contenedor[] contenedores, 8, juego, 110),
                new Nivel(20, 2, Contenedor[] contenedores, 9, juego, 100)
        }
    }
}
