import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CuadrosDialogo extends JDialog {
    private JLabel etqMensaje;
    private JButton botonAceptar;

    //Constructor de la clase
    public CuadrosDialogo(Frame ventanaP, String tituloCuadro, String mensaje) {
        //LLama al constructor de la superclase JDialog
        super(ventanaP, tituloCuadro, true); //el cuadro queda con el modal true para que se bloquean las interacciones con otras ventanas hasta que se cierre el cuadro
        //Establcer el diseño del cuadro
        setLayout(new BorderLayout());

        //Panel para centrar etiqueta
        JPanel centrarP = new JPanel(new BorderLayout());
        //ETIQUETA del mensaje para el cuadro de diálogo
        etqMensaje = new JLabel(mensaje, SwingConstants.CENTER); //Crea nueva etiqueta con el mensaje que se pasa en los parámetros del constructor
        centrarP.add(etqMensaje,BorderLayout.CENTER);
        add(centrarP,BorderLayout.CENTER);


        //BOTÓN "aceptar"
        botonAceptar = new JButton("Aceptar"); //Crea botón
        //Para cerrar el cuadro al hacer clic:
        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });
        add(botonAceptar,BorderLayout.SOUTH); //Añade la el botón en el sur del cuadro de diálogo

        //Tamaño del cuadro de diálogo
        setSize(300, 150);
        setLocationRelativeTo(ventanaP); //lo pone en el centro de la ventana principal

    }
}

