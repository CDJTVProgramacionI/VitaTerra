public class InterfazDeUsuario
{
    private Pantalla[] pantallas;
    private int pantallaActual;

    public InterfazDeUsuario()
    {
        //TODO: CREAR EL RESTO DE PANTALLAS
        pantallaActual = 0;
    }

    public void cambiarAPantalla(int pantalla)
    {
        pantallaActual = 0;
        mostrarPantalla();
    }

    private void mostrarPantalla()
    {
        borrarPantalla();
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void borrarPantalla()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getPantallaActual() {
        return pantallaActual;
    }
}
