import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PantallaSeleccion extends Pantallas {
    @Override
    protected void inicializar() {
        String hexColor="#B7D2B6";
        String hexColor2="#638C80"; 
        panelPrincipal.setBackground(Color.decode(hexColor));
        panelPrincipal.setLayout(null);
        setTitle("Menu");

        Font font = new Font("Bauhaus 93", Font.BOLD, 18);
        JLabel InicioLabel = new JLabel("JUGAR",SwingConstants.CENTER);
        InicioLabel.setBounds(300,49,110,37);
        InicioLabel.setFont(font);
        panelPrincipal.add(InicioLabel); 
    
        // Crear boton que se supone va a llevar a las instrucciones  
        JButton boton1Jugador = new JButton("1 Jugador");
        boton1Jugador.setBounds(220,115,260,61);
        boton1Jugador.setBackground(Color.decode(hexColor2));
        boton1Jugador.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e){
                //lleva a la ventana de instrucciones (no se como hacerle perdon)
                //new Pantallas();
                new PantallaJugador(new Manager());
                dispose();  //Cierra el menu
            } 
        });
        panelPrincipal.add(boton1Jugador);

        JButton boton2Jugadores = new JButton("2 Jugadores");
        boton2Jugadores.setBounds(220,264,260,61);
        boton2Jugadores.setBackground(Color.decode(hexColor2));
        boton2Jugadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Pantalla2Jugadores(new Manager());
                dispose();
            }
        });
        panelPrincipal.add(boton2Jugadores);
    }
}