public class InterfazDeUsuario
{
    private Pantalla[] pantallas;
    private int pantallaActual;

    public InterfazDeUsuario()
    {
        //TODO: CREAR EL RESTO DE PANTALLAS
        pantallaActual = 0;
    }

    public Pantalla cambiarAPantalla(int pantalla)
    {
        pantallaActual = pantalla;
        mostrarPantalla();
        return pantallas[pantalla];
    }

    public void actualizarPantalla(int pantalla, String[] argumentos)
    {
        Pantalla pantallaActualizar = pantallas[pantalla];
        if(pantallaActualizar.getCantidadArgumentos() <= argumentos.length)
        {
            for (int i = 0; i < argumentos.length; i++)
            {
                pantallaActualizar.setArgumento(i, argumentos[i]);
            }
        }
    }

    private void mostrarPantalla()
    {
        borrarPantalla();
        pantallas[pantallaActual].mostrar();
    }

    private void borrarPantalla() {
        System.out.println("\u000C");
    }
}
