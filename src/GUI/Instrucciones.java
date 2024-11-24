package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instrucciones extends Pantallas {
    @Override
    protected void inicializar() {
        //CREAR ETIQUETA QUE DIGA INSTRUCCIONES
        JLabel etiquetaInstrucciones = new JLabel("Instrucciones");
        //Ponerle fuente al texto
        etiquetaInstrucciones.setFont(new Font("Arial",Font.BOLD,30));
        //Ponerle color al texto
        etiquetaInstrucciones.setForeground(Color.BLACK);
        //Definir que no tenga color de fondo para qeu sea parte de la pantalla y no un recuadro
        etiquetaInstrucciones.setOpaque(false);
        //Centrar el texto de forma horizontal en la etiqueta
        etiquetaInstrucciones.setHorizontalAlignment(SwingConstants.CENTER);

        //Configurar GridBagLayout para la disposición o ubicación que quiero de la etiqueta
        GridBagConstraints disposicion1 = new GridBagConstraints();
        disposicion1.gridx=0;
        disposicion1.gridy=0;
        disposicion1.weightx=1.0;
        disposicion1.weighty=1.0;
        disposicion1.insets=new Insets(60,0,0,0); //margen superior
        disposicion1.anchor=GridBagConstraints.NORTH; //Pone la etiqueta en la parte superior del margen


        //CREAR CUADRO DE INSTRUCCIONES

       String inst="" +
               "1. Se presentan por nivel 10 desechos a clasficar dentro del contenedor correcto. " +
               "Por cada desecho clasificado\ncorrectamente se obtendrá una cierta cantidad de puntos " +
               "y por cada desecho clasificado incorrectamente se\npierde una cierta cantidad de vidas; " +
               "estas cantidades dependen del nivel en el que se encuentre el jugador.\n" +
               "2. Al conseguir clasificar el mínimo de desechos que tiene cada nivel, se pasa a una " +
               "segunda etapa que es\ntratar estos desechos en la planta tratadora. En esta etapa muestran "+
               "los pasos de cómo tratar cada desecho\ny se tiene que eligir el orden correcto en el que van " +
               "estos pasos.\n" +
               "3. Si el jugador trata correctamente la cantidad mínima de desechos del nivel, pasa al siguiente " +
               "nivel y si es el\núltimo nivel gana el juego.\n" +
               "4. El juego termina cuando se han clasificado todos los desechos o cuando el jugador pierde " +
               "todas sus vidas."



               ;
        JTextArea cuadroInstrucciones = new JTextArea(inst);
        //Ponerle fuente al texto del cuadro
        cuadroInstrucciones.setFont(new Font("Arial",Font.PLAIN,15));
        //Ponerle color al texto
        cuadroInstrucciones.setForeground(Color.BLACK);
        //Ponerle color de fondo al cuadro
        cuadroInstrucciones.setBackground(Color.YELLOW);
        //Hacer que el cuadro no sea editable
        cuadroInstrucciones.setEditable(false);
        //Agregarle borde al cuadro
        cuadroInstrucciones.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        //Configurar GridBagLayout para la disposición o ubicación que quiero del cuadro
        GridBagConstraints disposicion2 = new GridBagConstraints();
        disposicion2.gridx=0;
        disposicion2.gridy=0;
        disposicion2.weightx=1.0;
        disposicion2.weighty=1.0;
        disposicion2.insets=new Insets(10,10,10,10); //margen superior
        disposicion2.fill=GridBagConstraints.HORIZONTAL; //Estira el cuadro horizontalmente para llenar espacio disponible

        // Añadir la etiqueta al panel principal
        panelPrincipal.add(etiquetaInstrucciones, disposicion1);
        panelPrincipal.add(cuadroInstrucciones, disposicion2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Instrucciones();
            }
        });
    }
}