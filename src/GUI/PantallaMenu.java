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
        JLabel InicioLabel = new JLabel("VITA TERRA", SwingConstants.CENTER);
        InicioLabel.setBounds(300,49,110,37);
        InicioLabel.setFont(font);
        panelPrincipal.add(InicioLabel); 
    
        // Crear boton que va a llevar a las instrucciones  
        JButton botonJugar = new JButton("Jugar");
        botonJugar.setBounds(220,115,260,61);
        botonJugar.setBackground(Color.decode(hexColor2));
        botonJugar.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e){
                iu.mostrarPantalla(1); //Lleva a la pantalla de seleccion
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
                iu.mostrarPantalla(2); //Lleva a la pantalla de instrucciones
                dispose(); 
            }
        });
        panelPrincipal.add(botonInstruccion);

        //Crear boton para ver archivos
        JButton botonarc = new JButton("Archivos"); 
        botonarc.setBounds(220,263,260,61);
        botonarc.setBackground(Color.decode(hexColor2));
        botonarc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                iu.mostrarPantalla(8); //Lleva a la pantalla de archivos
                dispose();
            }
        });
        panelPrincipal.add(botonarc); 

        //Crear boton para salir 
        JButton botonSalir = new JButton("Salir"); 
        botonSalir.setBounds(220,337,260,61);
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
