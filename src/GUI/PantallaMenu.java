package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 


public class PantallaMenu extends Pantalla {
    public PantallaMenu(InterfazDeUsuario iu) {
        super(iu);
    }

    @Override
    protected void inicializar() {
        String hexColor="#B7D2B6";
        String hexColor2="#638C80"; 
        panelPrincipal.setBackground(Color.decode(hexColor));
        panelPrincipal.setLayout(null);
        setTitle("Menu");

        Font font = new Font("Bauhaus 93", Font.BOLD, 18);
        JLabel InicioLabel = new JLabel("VITA TERRA",SwingConstants.CENTER);
        InicioLabel.setBounds(300,49,110,37);
        InicioLabel.setFont(font);
        panelPrincipal.add(InicioLabel); 
    
        // Crear boton que lleva a jugar
        JButton botonJugar = new JButton("Jugar");
        botonJugar.setBounds(220,115,260,61);
        botonJugar.setBackground(Color.decode(hexColor2));
        botonJugar.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e){
                //lleva a la ventana de instrucciones (no se como hacerle perdon)
                //new Pantallas();
                iu.mostrarPantalla(1);
                dispose();  //Cierra el menu
            } 
        });
        panelPrincipal.add(botonJugar); 

        //Crear boton Jugar 
        JButton botonInstruccion = new JButton("Intrucciones"); 
        botonInstruccion.setBounds(220,189,260,61);
        botonInstruccion.setBackground(Color.decode(hexColor2));
        botonInstruccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //LLeva a la ventana de instrucciones
                iu.mostrarPantalla(2);
                dispose(); 
            }
        });
        panelPrincipal.add(botonInstruccion);

        JButton botonSalir = new JButton("Salir"); 
        botonSalir.setBounds(220,264,260,61);
        botonSalir.setBackground(Color.decode(hexColor2));
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //Sale del programa 
                dispose();
            }
        });
        panelPrincipal.add(botonSalir); 

    }
}