package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaJugador extends Pantallas {
    @Override
    public void inicializar() {
        String hexColor="#B7D2B6";
        String hexColor2="#638C80";
        panelPrincipal.setBackground(Color.decode(hexColor));
        panelPrincipal.setLayout(null);
        setTitle("Menu");

        Font font = new Font("Bauhaus 93", Font.BOLD, 18);
        JLabel InicioLabel = new JLabel("1 Jugador",SwingConstants.CENTER);
        InicioLabel.setBounds(300,49,110,37);
        InicioLabel.setFont(font);
        panelPrincipal.add(InicioLabel);

        //Crear etiqueta para el nombre del jugador
        JLabel nombreJugador = new JLabel("Nombre del jugador:");
        nombreJugador.setBounds(220,115,260,61);
        panelPrincipal.add(nombreJugador);

        //Crear campo de texto para el nombre del jugador
        JTextField campoNombre = new JTextField();
        campoNombre.setBounds(220,170,260,61);
        panelPrincipal.add(campoNombre);

        //Crear etiqueta para la edad del jugador
        JLabel edadJugador = new JLabel("Edad del jugador:");
        edadJugador.setBounds(220,225,260,61);
        panelPrincipal.add(edadJugador);

        //Crear campo de texto para la edad del jugador
        JTextField campoEdad = new JTextField();
        campoEdad.setBounds(220,280,260,61);
        panelPrincipal.add(campoEdad);

        // Crear boton para jugar
        JButton botonJugar = new JButton("Jugar");
        botonJugar.setBounds(220,380,260,61);
        botonJugar.setBackground(Color.decode(hexColor2));
        botonJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //lleva a la ventana de instrucciones (no se como hacerle perdon)
                //new Pantallas();
                dispose();  //Cierra el menu
            }
        });
        panelPrincipal.add(botonJugar);
    }

    public static void main(String[] args) {
        new PantallaJugador();
    }
}
