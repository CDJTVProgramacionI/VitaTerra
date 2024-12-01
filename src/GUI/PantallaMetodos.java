package GUI;

import Game.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaMetodos extends Pantalla implements IPantallaJuego
{
    String[] metodos;
    JComboBox<String> metodosComboBox;

    public PantallaMetodos(InterfazDeUsuario iu, Manager manager)
    {
        super(iu);
        this.metodos = new String[1];
    }

    @Override
    protected void inicializar() {
        String hexColor = "#B7D2B6";
        String hexColor2 = "#638C80";
        panelPrincipal.setBackground(Color.decode(hexColor));
        panelPrincipal.setLayout(new GridBagLayout());
        setTitle("Métodos");

        //Panel etiquetas
        JPanel panelEtiquetas = new JPanel();
        panelEtiquetas.setLayout(new GridLayout(3, 0));
        panelEtiquetas.setBackground(Color.decode(hexColor));

        //Etiquetas turno, vidas y puntos
        panelEtiquetas.add(turnoLabel);
        panelEtiquetas.add(vidasLabel);
        panelEtiquetas.add(puntosLabel);

        panelPrincipal.add(panelEtiquetas, new GridBagConstraints(1, 1, 1, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

        //Panel selección de método
        JPanel panelMetodo = new JPanel();
        panelMetodo.setLayout(new GridLayout(2, 2));
        panelMetodo.setBackground(Color.decode(hexColor));

        //Etiqueta desecho
        JLabel desechoLabel = new JLabel("Desecho");
        panelMetodo.add(desechoLabel);

        //Grid [1,1] vacio
        panelMetodo.add(new JLabel());


        //ComboBox
        metodosComboBox = new JComboBox<>();
        panelMetodo.add(metodosComboBox);

        //Botón de confirmación
        JButton confirmar = new JButton("Confirmar");
        confirmar.setBackground(Color.decode(hexColor2));
        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aqui va la lógica de confirmar el método
            }
        });
        panelMetodo.add(confirmar);

        //Agregando los componentes al panel principal
        panelPrincipal.add(panelMetodo, new GridBagConstraints(2, 1, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //Imagen alusiva
        Image img = new ImageIcon("C:\\Users\\nanib\\Pictures\\Copias de seguridad\\Septiembre 2024\\WhatsApp Images\\IMG-20240906-WA0072.jpg").getImage();
        ImageIcon icon = new ImageIcon(img.getScaledInstance(570, 400, Image.SCALE_SMOOTH));
        JLabel imagen = new JLabel();
        imagen.setIcon(icon);
        panelPrincipal.add(imagen, new GridBagConstraints(2, 2, 3, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        }
}