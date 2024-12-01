package GUI;

import Desechos.*;
import Excepciones.DesechosInsuficientesException;
import Excepciones.RespuestaIncorrectaException;
import Excepciones.VidasInsuficientesException;
import Game.Contenedor;
import Game.Manager;
import Game.Nivel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PantallaDesechos extends Pantalla implements IPantallaJuego {
    Manager gameManager;
    Nivel nivelData;
    int desechos;
    Desecho desechoActual;

    public PantallaDesechos(InterfazDeUsuario interfaz, Manager manager) {
        super(interfaz);
        this.gameManager = manager;
        this.desechos = 0;
    }

    @Override
    public void mostrar() {
        nivelData = gameManager.getNivelActual();
        super.mostrar();
        generaDesecho();
    }

    private void generaDesecho() {
        desechoActual = generarDesechoAleatorio(nivelData.getContenedores());
        //Mostrar desecho en pantalla
        desechosLabel.setText("Desecho: " + desechoActual.getNombre());
        gameManager.getTemporizador().comenzar();
        desechos++;
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
        panelEtiquetas.add(turnoLabel);
        panelEtiquetas.add(vidasLabel);
        panelEtiquetas.add(puntosLabel);

        panelPrincipal.add(panelEtiquetas, new GridBagConstraints(1, 1, 1, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

        //Panel Botones de desechos
        JPanel panelBotones = new JPanel();
        Font font = new Font("Bauhaus 93", Font.BOLD, 18);
        Font font2 = new Font("MoolBoran", Font.BOLD, 14);
        panelBotones.setLayout(new GridLayout(3, 3));
        panelBotones.setBackground(Color.decode(hexColor));


        desechosLabel.setFont(font);
        desechosLabel.setForeground(Color.decode(hexColor2));
        panelBotones.add(desechosLabel);

        JLabel vac = new JLabel(" ", SwingConstants.CENTER);
        panelBotones.add(vac);

        JLabel vac2 = new JLabel(" ", SwingConstants.CENTER);
        panelBotones.add(vac2);

        //Botones de los desechos 
        JButton Des1 = new JButton();
        Image icon = new ImageIcon("src/Imagenes/" + nivelData.getContenedor(0).getEtiqueta() + ".jpg").getImage();
        Des1.setIcon(new ImageIcon(icon.getScaledInstance(150, 200, Image.SCALE_SMOOTH)));

        Des1.setBackground(Color.decode(hexColor2));
        Des1.setFont(font2);
        Des1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                responder(0);
            }
        });
        panelBotones.add(Des1);

        JButton Des2 = new JButton();
        Image icon2 = new ImageIcon("src/Imagenes/" + nivelData.getContenedor(1).getEtiqueta() + ".jpg").getImage();
        Des2.setIcon(new ImageIcon(icon2.getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
        Des2.setBackground(Color.decode(hexColor2));
        Des2.setFont(font2);
        Des2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                responder(1);
            }
        });
        panelBotones.add(Des2);

        JButton Des3 = new JButton();
        Image icon3 = new ImageIcon("src/Imagenes/" + nivelData.getContenedor(2).getEtiqueta() + ".jpg").getImage();
        Des3.setIcon(new ImageIcon(icon3.getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
        Des3.setBackground(Color.decode(hexColor2));
        Des3.setFont(font2);
        Des3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                responder(2);
            }
        });
        panelBotones.add(Des3);

        JLabel vac4 = new JLabel(" ", SwingConstants.CENTER);
        panelBotones.add(vac4);

        JLabel vac5 = new JLabel(" ", SwingConstants.CENTER);
        panelBotones.add(vac5);

        JLabel vac6 = new JLabel(" ", SwingConstants.CENTER);
        panelBotones.add(vac6);


        panelPrincipal.add(panelBotones, new GridBagConstraints(2, 1, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    }

    @Override
    public void responder(int opc) {
        try {
            gameManager.procesarRespuesta(opc, desechoActual);
            if (desechos >= 10)
            {
                //Mostrar contenedor con más desechos
                Contenedor maxContenedor = nivelData.getMaxContenedor();
                gameManager.mostrarDialogo("Contenedor con más desechos", maxContenedor.getEtiqueta() + " tiene " + maxContenedor.getCantidadDesechos() + " desechos.");
                nivelData.verificaDesechos();

                iu.mostrarPantalla(6); //Tratamiento pt 1
            }
            else
            {
                nivelData.aumentaDesechosCorrectos();
                generaDesecho();
            }
        } catch (VidasInsuficientesException |DesechosInsuficientesException ex) {
            gameManager.perder();
        } catch (RespuestaIncorrectaException ex) {
            gameManager.mostrarDialogo("Incorrecto", "Respuesta incorrecta");
            generaDesecho();
        }
    }

    private Desecho generarDesechoAleatorio(Contenedor[] contenedores) {
        //Generar numero aleatorio entre 0 y la cantidad de contenedores
        int random = (int) (Math.random() * contenedores.length);

        //Obtener etiqueta del contenedor i
        String etiqueta = contenedores[random].getEtiqueta();

        //Crear desecho según la etiqueta obtenida
        return switch (etiqueta) {
            case "Plástico" -> Plastico.generaAleatorio();
            case "Papel" -> Papel.generaAleatorio();
            case "Vidrio" -> Vidrio.generaAleatorio();
            case "Orgánico" -> Organico.generaAleatorio();
            case "Baterías" -> Baterias.generaAleatorio();
            case "Electrónicos" -> Electronico.generaAleatorio();
            case "Cartón" -> Carton.generaAleatorio();
            case "Biológicos" -> Biologicos.generaAleatorio();
            case "Medicamentos" -> Medicamentos.generaAleatorio();
            case "Químicos" -> Quimicos.generaAleatorio();
            default -> null;
        };
    }
}