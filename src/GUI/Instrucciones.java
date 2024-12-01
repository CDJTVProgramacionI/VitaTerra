package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instrucciones extends Pantalla {
    public Instrucciones(InterfazDeUsuario iu) {
        super(iu);
    }

    @Override
    protected void inicializar() {
        String hexColor="#B7D2B6";
        String hexColor2="#f1f7f9";
        String hexColor3="#638C80";
        panelPrincipal.setLayout(null); 
        //se define color de la pantalla 
        panelPrincipal.setBackground(Color.decode(hexColor));
        //CREAR ETIQUETA QUE DIGA INSTRUCCIONES
        JLabel etiquetaInstrucciones = new JLabel("Instrucciones");
        //Ponerle fuente al texto
        etiquetaInstrucciones.setFont(new Font("Arial",Font.BOLD,30));
        //Ponerle color al texto
        etiquetaInstrucciones.setForeground(Color.decode(hexColor3));
        //Definir que no tenga color de fondo para qeu sea parte de la pantalla y no un recuadro
        etiquetaInstrucciones.setOpaque(false);
        //Centrar el texto de forma horizontal en la etiqueta
        etiquetaInstrucciones.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaInstrucciones.setBounds(200,05,300,100);
        //Configurar GridBagLayout para la disposición o ubicación que quiero de la etiqueta
        GridBagConstraints disposicion1 = new GridBagConstraints();
        disposicion1.gridx=0;
        disposicion1.gridy=0;
        disposicion1.weightx=1.0;
        disposicion1.weighty=1.0;
        disposicion1.insets=new Insets(50,0,0,0); //margen superior
        disposicion1.anchor=GridBagConstraints.NORTH; //Pone la etiqueta en la parte superior del margen


        //CREAR CUADRO DE INSTRUCCIONES

       String inst="" +
               "1. Se presentan por nivel 10 desechos a clasficar dentro del contenedor correcto. " +
               "Por cada\ndesecho clasificado correctamente se obtendrá una cierta cantidad de puntos " +
               "y por cada\ndesecho clasificado incorrectamente se pierde una cierta cantidad de vidas; " +
               "estas cantidades\ndependen del nivel en el que se encuentre el jugador.\n" +
               "\n2. Al conseguir clasificar el mínimo de desechos que tiene cada nivel, se pasa a una " +
               "segunda\netapa que es tratar estos desechos en la planta tratadora. En esta etapa muestran "+
               "los pasos\nde cómo tratar cada desecho y se tiene que eligir el orden correcto en el que van " +
               "estos pasos.\n" +
               "\n3. Si el jugador trata correctamente la cantidad mínima de desechos del nivel, pasa al siguiente\n" +
               "nivel y si es elúltimo nivel gana el juego.\n" +
               "\n4. El juego termina cuando se han clasificado todos los desechos o cuando el jugador pierde\n" +
               "todas sus vidas."



               ;
        JTextArea cuadroInstrucciones = new JTextArea(inst);
        //Ponerle fuente al texto del cuadro
        cuadroInstrucciones.setFont(new Font("Calibri",Font.PLAIN,14));
        //Definr posicion del cuadro de texto
        cuadroInstrucciones.setBounds(40,90,600,300);
        //Ponerle color al texto
        cuadroInstrucciones.setForeground(Color.BLACK);
        //Ponerle color de fondo al cuadro
        cuadroInstrucciones.setBackground(Color.decode(hexColor2));
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

        JButton BotonRegresar = new JButton("Regresar");
        BotonRegresar.setBounds(285,410,120,30);
        BotonRegresar.setBackground(Color.decode(hexColor3));
        BotonRegresar.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e){
                //lleva a la ventana de instrucciones (no se como hacerle perdon)
                iu.mostrarPantalla(0);
                dispose();  //Cierra el menu
            } 
        });

        panelPrincipal.add(BotonRegresar); 

        // Añadir la etiqueta al panel principal
        panelPrincipal.add(etiquetaInstrucciones, disposicion1);
        panelPrincipal.add(cuadroInstrucciones, disposicion2);
    }
}