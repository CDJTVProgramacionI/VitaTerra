package GUI;

import Game.Manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PantallaDesechos extends Pantalla implements IPantallaJuego
{
    public PantallaDesechos(InterfazDeUsuario interfaz, Manager manager) {
        super(interfaz);
    }

    @Override
    public void setArgumentos(String[] pasos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void inicializar() {
        String hexColor = "#B7D2B6";
        String hexColor2 = "#638C80";
        String hexColor3 = "#FFFFFF"; 

        panelPrincipal.setBackground(Color.decode(hexColor));
        panelPrincipal.setLayout(new GridBagLayout());
        setTitle("Desechos");
     
        //Panel etiquetas
        JPanel panelEtiquetas = new JPanel();
        panelEtiquetas.setLayout(new GridLayout(3, 0));
        panelEtiquetas.setBackground(Color.decode(hexColor));
        //Etiquetas turno, vidas y puntos
        JLabel turnoLabel = new JLabel("Turno");
        JLabel vidasLabel = new JLabel("Vidas");
        JLabel puntosLabel = new JLabel("Puntos");

        panelEtiquetas.add(turnoLabel);
        panelEtiquetas.add(vidasLabel);
        panelEtiquetas.add(puntosLabel);

        panelPrincipal.add(panelEtiquetas, new GridBagConstraints(1, 1, 1, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

        //Panel Botones de desechos
        
        JPanel panelBotones = new JPanel();
        Font font= new Font("Bauhaus 93", Font.BOLD, 18);
        Font font2 = new Font("MoolBoran", Font.BOLD, 14);
        panelBotones.setLayout(new GridLayout(3,3)); 
        panelBotones.setBackground(Color.decode(hexColor));

        
        JLabel eti = new JLabel("Desecho:", SwingConstants.CENTER);
        eti.setFont(font);
        eti.setForeground(Color.decode(hexColor2));
        panelBotones.add(eti); 

        JLabel vac = new JLabel(" ",SwingConstants.CENTER); 
        panelBotones.add(vac); 

        JLabel vac2 = new JLabel(" ",SwingConstants.CENTER); 
        panelBotones.add(vac2);

        //Botones de los desechos 
        JButton Des1 = new JButton("Des1");
        Des1.setBackground(Color.decode(hexColor2));
        Des1.setFont(font2);
        Des1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aqui va la lógica de confirmar el método
            }
        });
        panelBotones.add(Des1);

        JButton Des2 = new JButton("Des2");
        Des2.setBackground(Color.decode(hexColor2));
        Des2.setFont(font2);
        Des2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aqui va la lógica de confirmar el método
            }
        });
        panelBotones.add(Des2);

        JButton Des3 = new JButton("Des3");
        Des3.setBackground(Color.decode(hexColor2));
        Des3.setFont(font2);
        Des3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aqui va la lógica de confirmar el método
            }
        });
        panelBotones.add(Des3);

        JLabel vac4 = new JLabel(" ",SwingConstants.CENTER); 
        panelBotones.add(vac4); 

        JLabel vac5 = new JLabel(" ",SwingConstants.CENTER); 
        panelBotones.add(vac5);
        
        JLabel vac6 = new JLabel(" ",SwingConstants.CENTER); 
        panelBotones.add(vac6); 


        panelPrincipal.add(panelBotones, new GridBagConstraints(2, 1, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        }
}