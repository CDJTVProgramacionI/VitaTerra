package GUI;

import Game.Manager;

import java.awt.*;

public class InterfazDeUsuario
{
    private Pantalla[] pantallas;
    private Pantalla pantallaActual;

    public InterfazDeUsuario(Manager gameManager)
    {
        pantallas = new Pantalla[]
                {
                        new PantallaMenu(this), //0
                        new PantallaSeleccion(this), //1
                        new Instrucciones(this), //2
                        new PantallaJugador(this, gameManager), //3
                        new Pantalla2Jugadores(this, gameManager), //4
                        new PantallaDesechos(this, gameManager), //5
                        new PantallaMetodos(this, gameManager), //6
                        new PantallaTratamiento(this, gameManager), //7
                };
    }

    public void setPantalla(int numPantalla, Pantalla pantalla)
    {
        pantallas[numPantalla] = pantalla;
    }

    public void mostrarPantalla(int pantalla)
    {
        pantallas[pantalla].mostrar();
        pantallaActual = pantallas[pantalla];
    }

    public void cierraPantalla()
    {
        pantallaActual.dispose();
    }

    public IPantallaJuego getPantallaJuego(int pantalla) throws IllegalArgumentException
    {
        if (pantalla <5 || pantalla > 7)
        {
            throw new IllegalArgumentException("La pantalla solicitada no es de juego");
        }

        return (IPantallaJuego) pantallas[pantalla];
    }

    public void construirDialogo(String tituloCuadro, String mensaje) {
        CuadrosDialogo cuadroUno=new CuadrosDialogo(pantallaActual,tituloCuadro,mensaje);
        cuadroUno.setVisible(true);
    }
}
