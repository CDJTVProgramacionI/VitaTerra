package GUI;

import Desechos.Desecho;
import Excepciones.ContenedorVacioException;
import Excepciones.DesechosInsuficientesException;
import Excepciones.RespuestaIncorrectaException;
import Excepciones.VidasInsuficientesException;
import Game.Manager;
import Game.Nivel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaMetodos extends Pantalla implements IPantallaJuego
{
    Manager gameManager;
    JComboBox<String> metodosComboBox;
    Desecho desechoActual;
    Nivel nivelData;
    int numContenedor;

    public PantallaMetodos(InterfazDeUsuario iu, Manager manager)
    {
        super(iu);
        this.gameManager = manager;
    }

    @Override
    public void mostrar() {
        nivelData = gameManager.getNivelActual();
        nivelData.setPlantaTratadora();
        panelPrincipal.removeAll();
        super.mostrar();
        trataDesecho();
    }

    @Override
    public void responder(int opc) {
        try {
            gameManager.procesarRespuesta(opc + 1, desechoActual, nivelData.getPlantaTratadora());
            iu.mostrarPantalla(7);
            dispose();
        }
        catch (VidasInsuficientesException e) {
            gameManager.perder(e.getMessage());
        }
        catch (RespuestaIncorrectaException e)
        {
            try
            {
                gameManager.mostrarDialogo("Respuesta incorrecta", "La respuesta no es correcta");
                nivelData.decrementaDesechosCorrectos();
                trataDesecho();
            }
            catch (DesechosInsuficientesException ex)
            {
                gameManager.perder(ex.getMessage());
            }

        }
    }

    private void trataDesecho()
    {
        if(numContenedor >= nivelData.getContenedores().length)
        {
            numContenedor = 0;
            dispose();
            gameManager.ganar();
            return;
        }
        //Llena datos de etiquetas
        String[] info = gameManager.getJugadorActual().getInfo();
        turnoLabel.setText("Turno: " + info[0]);
        puntosLabel.setText("Puntos: " + info[2]);
        vidasLabel.setText("Vidas: " + info[3]);

        try
        {
            metodosComboBox.removeAllItems();
            for (String metodo : nivelData.getPlantaTratadora().getMetodosParaContenedorN(numContenedor))
            {
                metodosComboBox.addItem(metodo);
            }
            desechoActual = nivelData.getContenedor(numContenedor).sacarDesecho();
            desechosLabel.setText("Desecho: " + desechoActual.getInfo());
            gameManager.getTemporizador().comenzar();
        }
        catch (ContenedorVacioException e)
        {
            numContenedor++;
            trataDesecho();
        }

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
        panelMetodo.add(desechosLabel);

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
                responder(metodosComboBox.getSelectedIndex());
            }
        });
        panelMetodo.add(confirmar);

        //Agregando los componentes al panel principal
        panelPrincipal.add(panelMetodo, new GridBagConstraints(2, 1, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //Imagen alusiva
        Image img = new ImageIcon("src/Imagenes/PlantaTratadora.jpg").getImage();
        ImageIcon icon = new ImageIcon(img.getScaledInstance(570, 400, Image.SCALE_SMOOTH));
        JLabel imagen = new JLabel();
        imagen.setIcon(icon);
        panelPrincipal.add(imagen, new GridBagConstraints(2, 2, 3, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        }
}