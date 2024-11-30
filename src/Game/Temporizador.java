package Game;

import java.util.Timer;
import java.util.TimerTask;

public class Temporizador
{
    private int segundos;
    private int decremento;
    private Timer timer;
    private Manager gameManager;

    private TimerTask decrementTask = new TimerTask() {
        @Override
        public void run() {
            segundos -= decremento;
            if (segundos == 0) {;
                decremento = 0;
                gameManager.finTiempo();
            }
        }
    };

    public Temporizador(Manager gameManager)
    {
        this.segundos = 1;
        this.timer = new Timer();
        this.decremento = 0;
        this.gameManager = gameManager;
        timer.schedule(decrementTask, 0, 1000);
    }

    public void comenzar()
    {
        decremento = 1;
    }

    public void detener()
    {
        decremento = 0;
    }

    public boolean restaTiempo()
    {
        return segundos > 0;
    }

    public void dispose()
    {
        timer.cancel();
    }

    public int getTiempo()
    {
        return segundos;
    }

    public void setTiempo(int segundos)
    {
        decremento = 0;
        this.segundos = segundos;
    }

}
