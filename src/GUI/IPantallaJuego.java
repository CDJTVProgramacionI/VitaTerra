package GUI;

import javax.swing.*;

public interface IPantallaJuego
{
    void responder(int opc);
    JLabel turnoLabel = new JLabel("Turno");
    JLabel vidasLabel = new JLabel("Vidas");
    JLabel puntosLabel = new JLabel("Puntos");
    JLabel desechosLabel = new JLabel("Desechos");
}
