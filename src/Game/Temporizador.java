package Game;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Temporizador
{
    private int segundos;
    private int decremento;
    private Timer timer;
    private Manager gameManager;
    private JLabel tiempoRestante;
    private JDialog dialog;

    private TimerTask decrementTask = new TimerTask() {
        @Override
        public void run() {
            segundos -= decremento;
            tiempoRestante.setText("Tiempo restante: " + segAMinutos());
            if (segundos == 0) {;
                decremento = 0;
                gameManager.finTiempo();
                dialog.setVisible(false);
            }
        }
    };

    public Temporizador(Manager gameManager)
    {
        this.segundos = 1;
        this.timer = new Timer();
        this.decremento = 0;
        this.gameManager = gameManager;
        dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        dialog.setSize(200, 100);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setResizable(false);

        tiempoRestante = new JLabel();
        dialog.add(tiempoRestante);
        timer.schedule(decrementTask, 0, 1000);
    }

    public void comenzar()
    {
        decremento = 1;
        dialog.setVisible(true);
    }

    public void detener()
    {
        decremento = 0;
        dialog.setVisible(false);
    }

    public void dispose()
    {
        timer.cancel();
    }

    public void setTiempo(int segundos)
    {
        decremento = 0;
        this.segundos = segundos;
    }

    public String segAMinutos()
    {
        int minutos = segundos / 60;
        int segundos = this.segundos % 60;
        if (segundos < 10) {
            return minutos + ":0" + segundos;
        }
        return minutos + ":" + segundos;
    }

}
