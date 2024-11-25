package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla2Jugadores extends Pantallas {
    @Override
    public void inicializar() {
        String hexColor="#B7D2B6";
        String hexColor2="#638C80";
        panelPrincipal.setBackground(Color.decode(hexColor));
        panelPrincipal.setLayout(null);
        setTitle("Menu");

        Font font = new Font("Bauhaus 93", Font.BOLD, 18);
        JLabel InicioLabel = new JLabel("2 Jugadores",SwingConstants.CENTER);
        InicioLabel.setBounds(300,49,110,37);
        InicioLabel.setFont(font);
        panelPrincipal.add(InicioLabel);

        //Crear etiqueta para el nombre del jugador 1
        JLabel nombreJugador = new JLabel("Nombre del jugador 1:");
        nombreJugador.setBounds(40,115,260,61);
        panelPrincipal.add(nombreJugador);

        //Crear etiqueta para el nombre del jugador 2
        JLabel nombreJugador2 = new JLabel("Nombre del jugador 2:");
        nombreJugador2.setBounds(390,115,260,61);
        panelPrincipal.add(nombreJugador2);

        //Crear campo de texto para el nombre del jugador 1
        JTextField campoNombre = new JTextField();
        campoNombre.setBounds(40,170,260,61);
        panelPrincipal.add(campoNombre);

        //Crear campo de texto para el nombre del jugador 2
        JTextField campoNombre2 = new JTextField();
        campoNombre2.setBounds(390,170,260,61);
        panelPrincipal.add(campoNombre2);

        //Crear etiqueta para la edad del jugador 1
        JLabel edadJugador = new JLabel("Edad del jugador 1:");
        edadJugador.setBounds(40,225,260,61);
        panelPrincipal.add(edadJugador);

        //Crear etiqueta para la edad del jugador 2
        JLabel edadJugador2 = new JLabel("Edad del jugador 2:");
        edadJugador2.setBounds(390,225,260,61);
        panelPrincipal.add(edadJugador2);

        //Crear campo de texto para la edad del jugador 1
        JTextField campoEdad = new JTextField();
        campoEdad.setBounds(40,280,260,61);
        panelPrincipal.add(campoEdad);

        //Crear campo de texto para la edad del jugador 2
        JTextField campoEdad2 = new JTextField();
        campoEdad2.setBounds(390,280,260,61);
        panelPrincipal.add(campoEdad2);

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
        new Pantalla2Jugadores();
    }
}
