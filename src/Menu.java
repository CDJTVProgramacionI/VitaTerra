import java.util.Scanner;

public class Menu extends Pantalla
{
    private int opcionElegida;

    @Override
    public void mostrar()
    {
        //Crea un objeto escaner
        Scanner scanner = new Scanner(System.in);
        super.mostrar(); //Muestra las opciones
        do
        {
            System.out.println("Elige una opción:");
            opcionElegida = scanner.nextInt(); //Lee la opción del usuario

            //Validar
            if(opcionElegida <= 0 || opcionElegida > argumentos.length)
            {
                System.out.println("Opción no válida");
            }

        }while(opcionElegida <= 0 || opcionElegida > argumentos.length);

    }

    public int getOpcionElegida() {
        return opcionElegida;
    }
}
