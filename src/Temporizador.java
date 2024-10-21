import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class Temporizador
{
    private int segundos;
    private int decremento;
    private Timer timer;

    private TimerTask decrementTask = new TimerTask() {
        @Override
        public void run() {
            segundos -= decremento;
            if (segundos == 0) {;
                decremento = 0;
            }
        }
    };

    public Temporizador()
    {
        this.segundos = 0;
        this.timer = new Timer();
        this.decremento = 0;
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
