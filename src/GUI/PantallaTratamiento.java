package GUI;

import Excepciones.DesechosInsuficientesException;
import Excepciones.RespuestaIncorrectaException;
import Excepciones.VidasInsuficientesException;
import Game.Manager;
import Game.Nivel;
import Game.PlantaTratadora;

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
    Manager gameManager;
    Nivel nivelData;
    public PantallaTratamiento(InterfazDeUsuario iu, Manager manager)
    {
        super(iu);
        this.pasos = new String[1];
        comboBoxes = new ArrayList<>();
        this.gameManager = manager;
    }

    @Override
    public void mostrar() {
        nivelData = gameManager.getNivelActual();
        panelPrincipal.removeAll();
        comboBoxes.clear();
        super.mostrar();
        organizarPasos();
    }

    private void organizarPasos()
    {
        //Llena datos de etiquetas
        String[] info = gameManager.getJugadorActual().getInfo();
        turnoLabel.setText("Turno: " + info[0]);
        puntosLabel.setText("Puntos: " + info[1]);
        vidasLabel.setText("Vidas: " + info[2]);

        String[] pasos = nivelData.getPlantaTratadora().getTratamientoDesorganizado();
        for (int i = 0; i < pasos.length; i++) {
            comboBoxes.add(new JComboBox<>(pasos));
            panelTratamiento.add(comboBoxes.get(i), new GridBagConstraints(i+1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        }
        gameManager.getTemporizador().comenzar();
    }

    @Override
    public void responder(int opc) {
        try {
            ArrayList<Integer> pasos = new ArrayList<>();
            for (JComboBox<String> comboBox : comboBoxes) {
                pasos.add(comboBox.getSelectedIndex());
            }
            gameManager.procesarRespuesta(pasos, nivelData.getPlantaTratadora());
            dispose();
            iu.mostrarPantalla(6);
        }
        catch (VidasInsuficientesException e) {
            gameManager.perder(e.getMessage());
        }
        catch (RespuestaIncorrectaException e)
        {
            try {
                gameManager.mostrarDialogo("Respuesta incorrecta", "La respuesta no es correcta");
                nivelData.decrementaDesechosCorrectos();
            }
            catch (DesechosInsuficientesException ex)
            {
                gameManager.perder(ex.getMessage());
                return;
            }
            dispose();
            iu.mostrarPantalla(6);
        }
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
        panelTratamiento.add(desechosLabel, new GridBagConstraints(0, 0, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //Botón de confirmación
        JButton confirmar = new JButton("Confirmar");
        confirmar.setBackground(Color.decode(hexColor2));
        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                responder(0);
            }
        });
        panelTratamiento.add(confirmar, new GridBagConstraints(0, 2, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //Agregando los componentes al panel principal
        panelPrincipal.add(panelTratamiento, new GridBagConstraints(2, 1, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //Imagen alusiva
        Image img = new ImageIcon("src/Imagenes/PlantaTratadora.jpg").getImage();
        ImageIcon icon = new ImageIcon(img.getScaledInstance(570, 400, Image.SCALE_SMOOTH));
        JLabel imagen = new JLabel();
        imagen.setIcon(icon);
        panelPrincipal.add(imagen, new GridBagConstraints(2, 2, 3, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    }
}