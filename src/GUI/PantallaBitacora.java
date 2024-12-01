package GUI;

import Data.ManejoArchivos;
import Game.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PantallaBitacora extends Pantalla {
    public PantallaBitacora(InterfazDeUsuario iu) {
        super(iu);
    }

    @Override
    protected void inicializar() {
        String hexColor = "#B7D2B6";
        String hexColor2 = "#f1f7f9";
        String hexColor3 = "#638C80";
        panelPrincipal.setLayout(null);
        //se define color de la pantalla 
        panelPrincipal.setBackground(Color.decode(hexColor));
        JLabel etiquetaInstrucciones = new JLabel("Bitácora");
        //Ponerle fuente al texto
        etiquetaInstrucciones.setFont(new Font("Arial", Font.BOLD, 30));
        //Ponerle color al texto
        etiquetaInstrucciones.setForeground(Color.decode(hexColor3));
        //Centrar el texto de forma horizontal en la etiqueta
        etiquetaInstrucciones.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaInstrucciones.setBounds(200, 5, 300, 100);
        //Configurar GridBagLayout para la disposición o ubicación que quiero de la etiqueta
        GridBagConstraints disposicion1 = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(50, 0, 0, 0), 0, 0);

        //Lee el archivo
        ManejoArchivos archivo = new ManejoArchivos("Bitácora.vtr");
        ArrayList<String[]> registros = archivo.mostrarRegistro();

        //Crear cuadro de bitacora
        JPanel cuadroBitacora = new JPanel();
        cuadroBitacora.setBounds(40, 90, 600, 300);
        cuadroBitacora.setBackground(Color.decode(hexColor2));
        cuadroBitacora.setLayout(new GridLayout(registros.size() + 1, 4));

        JLabel etiqueta = new JLabel("Nombre");
        cuadroBitacora.add(etiqueta);
        JLabel etiqueta2 = new JLabel("Edad");
        cuadroBitacora.add(etiqueta2);
        JLabel etiqueta3 = new JLabel("Puntos");
        cuadroBitacora.add(etiqueta3);
        JLabel etiqueta4 = new JLabel("Vidas");
        cuadroBitacora.add(etiqueta4);

        for (String[] registro : registros) {
            for (String dato : registro) {
                JLabel datoLabel = new JLabel(dato);
                cuadroBitacora.add(datoLabel);
            }
        }

        //Configurar GridBagLayout para la disposición o ubicación que quiero del cuadro
        GridBagConstraints disposicion2 = new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0);
        JButton BotonRegresar = new JButton("Regresar");
        BotonRegresar.setBounds(285, 410, 120, 30);
        BotonRegresar.setBackground(Color.decode(hexColor3));
        BotonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lleva a la ventana de instrucciones (no se como hacerle perdon)
                iu.mostrarPantalla(0);
                dispose();  //Cierra el menu
            }
        });

        panelPrincipal.add(BotonRegresar);

        // Añadir la etiqueta al panel principal
        panelPrincipal.add(etiquetaInstrucciones, disposicion1);
        panelPrincipal.add(cuadroBitacora, disposicion2);
    }

    public static void main(String[] args) {
        PantallaBitacora pantalla = new PantallaBitacora(new InterfazDeUsuario(new Manager(null)));
        pantalla.mostrar();
    }
}