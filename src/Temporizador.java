import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class Temporizador
{
    private int segundos;
    private Timer timer = new Timer();
    private Scanner scanner;

    private TimerTask decrementTask = new TimerTask() {
        @Override
        public void run() {
            segundos--;
            if (segundos == 0) {
                scanner.close();
                timer.cancel();
            }
        }
    };

    public Temporizador()
    {
        this.segundos = 0;
    }

    public void comenzar()
    {
        timer.schedule(decrementTask, 0, 1000);
    }

    public void detener()
    {
        timer.cancel();
    }

    public boolean restaTiempo()
    {
        return segundos > 0;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setTiempo(int segundos) {
        this.segundos = segundos;
    }

}
