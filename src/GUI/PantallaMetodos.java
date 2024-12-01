package GUI;

import Desechos.Desecho;
import Excepciones.ContenedorVacioException;
import Excepciones.DesechosInsuficientesException;
import Excepciones.RespuestaIncorrectaException;
import Excepciones.VidasInsuficientesException;
import Game.Contenedor;
import Game.Manager;
import Game.Nivel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PantallaMetodos extends Pantalla implements IPantallaJuego
{
    Manager gameManager;
    JComboBox<String> metodosComboBox;
    Desecho desechoActual;
    ArrayList<Desecho> listaDesechos;
    Nivel nivelData;
    int desecho;

    public PantallaMetodos(InterfazDeUsuario iu, Manager manager)
    {
        super(iu);
        this.gameManager = manager;
    }

    @Override
    public void mostrar() {
        nivelData = gameManager.getNivelActual();
        nivelData.setPlantaTratadora();
        super.mostrar();
        vacíaContenedor(0);
    }

    @Override
    public void responder(int opc) {
        try {
            gameManager.procesarRespuesta(opc + 1, desechoActual, nivelData.getPlantaTratadora());
            trataDesecho();
        }
        catch (VidasInsuficientesException e) {
            gameManager.perder();
        }
        catch (RespuestaIncorrectaException e)
        {
            try
            {
                nivelData.decrementaDesechosCorrectos();
                gameManager.mostrarDialogo("Respuesta incorrecta", "La respuesta no es correcta");
                trataDesecho();
            }
            catch (DesechosInsuficientesException ex)
            {
                gameManager.mostrarDialogo("Fin del juego", "No clasificaste los suficientes desechos");
                iu.mostrarPantalla(0);
            }

        }
    }

    private void vacíaContenedor(int numContenedor)
    {
        Contenedor[] contenedores = nivelData.getContenedores();
        if(numContenedor >= contenedores.length)
        {
            //Se trataron todos los desechos
            iu.mostrarPantalla(7);
            return;
        }

        try {
            listaDesechos = nivelData.getContenedor(numContenedor).vaciarContenedor();
            metodosComboBox.removeAllItems();
            for(String metodo : nivelData.getPlantaTratadora().getMetodosParaContenedorN(numContenedor))
            {
                metodosComboBox.addItem(metodo);
            }
            desecho = 0;
            trataDesecho();
        }
        catch (ContenedorVacioException e) {
            vacíaContenedor(numContenedor + 1);
        }

    }

    private void trataDesecho()
    {
        if(desecho >= listaDesechos.size())
        {
            vacíaContenedor(1);
            return;
        }
        desechoActual = listaDesechos.get(desecho);
        desechosLabel.setText("Desecho: " + desechoActual.getInfo());
        desecho++;
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
        Image img = new ImageIcon("C:\\Users\\nanib\\Pictures\\Copias de seguridad\\Septiembre 2024\\WhatsApp Images\\IMG-20240906-WA0072.jpg").getImage();
        ImageIcon icon = new ImageIcon(img.getScaledInstance(570, 400, Image.SCALE_SMOOTH));
        JLabel imagen = new JLabel();
        imagen.setIcon(icon);
        panelPrincipal.add(imagen, new GridBagConstraints(2, 2, 3, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        }
}