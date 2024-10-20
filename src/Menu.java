import java.util.Scanner;

public class Menu extends Pantalla
{
    private int cantOpciones;
    private int opcionElegida;
    private Scanner scanner;

    public Menu(String textoActual, int cant_argumentos, int cantOpciones)
    {
        super(textoActual, cant_argumentos);
        scanner = new Scanner(System.in);
        this.cantOpciones = cantOpciones;
    }

    @Override
    public void mostrar()
    {
        super.mostrar(); //Muestra las opciones
        do
        {
            System.out.println("Elige una opción:");
            opcionElegida = scanner.nextInt(); //Lee la opción del usuario

            //Validar
            if(opcionElegida <= 0 || opcionElegida > cantOpciones)
            {
                System.out.println("Opción no válida");
            }

        }while(opcionElegida <= 0 || opcionElegida > cantOpciones);
    }

    public int getOpcionElegida() {
        return opcionElegida;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
