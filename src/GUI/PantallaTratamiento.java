package GUI;

import Game.Manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class PantallaTratamiento extends Pantalla implements IPantallaJuego
{
    String[] pasos;
    ArrayList<JComboBox<String>> comboBoxes;
    JPanel panelTratamiento;
    public PantallaTratamiento(InterfazDeUsuario iu, Manager manager)
    {
        super(iu);
        this.pasos = new String[1];
        comboBoxes = new ArrayList<>();
    }

    @Override
    protected void inicializar() {
        String hexColor = "#B7D2B6";
        String hexColor2 = "#638C80";
        panelPrincipal.setBackground(Color.decode(hexColor));
        panelPrincipal.setLayout(new GridBagLayout());
        setTitle("Tratamiento");

        //Panel etiquetas
        JPanel panelEtiquetas = new JPanel();
        panelEtiquetas.setLayout(new GridLayout(3, 0));
        panelEtiquetas.setBackground(Color.decode(hexColor));

        //Etiquetas turno, vidas y puntos
        panelEtiquetas.add(turnoLabel);
        panelEtiquetas.add(vidasLabel);
        panelEtiquetas.add(puntosLabel);

        panelPrincipal.add(panelEtiquetas, new GridBagConstraints(1, 1, 1, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

        //Panel organizar tratamiento
        panelTratamiento = new JPanel();
        panelTratamiento.setLayout(new GridBagLayout());
        panelTratamiento.setBackground(Color.decode(hexColor));

        //Etiqueta info
        JLabel desechoLabel = new JLabel("Info");
        panelTratamiento.add(desechoLabel, new GridBagConstraints(0, 0, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));



        //Botón de confirmación
        JButton confirmar = new JButton("Confirmar");
        confirmar.setBackground(Color.decode(hexColor2));
        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Aqui va la lógica de confirmar el método
            }
        });
        panelTratamiento.add(confirmar, new GridBagConstraints(0, 2, 5, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //Agregando los componentes al panel principal
        panelPrincipal.add(panelTratamiento, new GridBagConstraints(2, 1, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //Imagen alusiva
        Image img = new ImageIcon("C:\\Users\\nanib\\Pictures\\Copias de seguridad\\Septiembre 2024\\WhatsApp Images\\IMG-20240906-WA0072.jpg").getImage();
        ImageIcon icon = new ImageIcon(img.getScaledInstance(570, 400, Image.SCALE_SMOOTH));
        JLabel imagen = new JLabel();
        imagen.setIcon(icon);
        panelPrincipal.add(imagen, new GridBagConstraints(2, 2, 3, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    }
}