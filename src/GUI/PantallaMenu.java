package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaMenu extends Pantallas {
    @Override
    protected void inicializar() {
        String hexColor="#B7D2B6"; 
        panelPrincipal.setBackground(Color.decode(hexColor));
        setTitle("Menu");
        JLabel InicioLabel = new JLabel("VITA TERRA",SwingConstants.CENTER);
        InicioLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panelPrincipal.add(InicioLabel); 
    
        // Crear boton que se supone va a llevar a las instrucciones  
        JButton botonInstruccion = new JButton("Instrucciones");
        botonInstruccion.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e){
                //lleva a la ventana de instrucciones (no se como hacerle perdon)
                //new Pantallas(); 
                dispose();  //Cierra el menu
            }
        });
        //Crear boton Jugar 
        JButton botonJugar = new JButton("Jugar"); 
        botonInstruccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //LLeva a la ventana de jugar 
                //new Pantallas(); 
                dispose(); 
            }
        });

        JButton botonSalir = new JButton("Salir"); 
        botonInstruccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //Sale del programa 
                //System.exit();  //?
            }
        });


        panelPrincipal.add(Box.createVerticalStrut(20)); 
        // Espacio entre el label y el primer botón 
        panelPrincipal.add(botonInstruccion); 
        panelPrincipal.add(Box.createVerticalStrut(10)); 
        // Espacio entre botones 
        panelPrincipal.add(botonJugar); 
        panelPrincipal.add(Box.createVerticalStrut(10)); 
        // Espacio entre botones panelPrincipal.add(botonSalir);
        panelPrincipal.add(botonSalir); 
        panelPrincipal.add(Box.createVerticalStrut(10)); 
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PantallaMenu();
            }
        });
    }
}
