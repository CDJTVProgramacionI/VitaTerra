package GUI;

import Game.Manager;

public class InterfazDeUsuario
{
    private Pantalla[] pantallas;

    public InterfazDeUsuario(Manager gameManager)
    {
        pantallas = new Pantalla[]
                {
                        new PantallaMenu(this), //0
                        new PantallaSeleccion(this), //1
                        new Instrucciones(this), //2
                        new PantallaJugador(this, gameManager), //3
                        new Pantalla2Jugadores(this, gameManager), //4
                        //TODO: Pantalla clasificacion desechos //5
                        //TODO: Pantalla tratamiento desechos //6
                        //TODO: Pantalla organización de tratamiento //7
                };
    }

    public Pantalla mostrarPantalla(int pantalla)
    {
        pantallas[pantalla].mostrar();
        return pantallas[pantalla];
    }
}
