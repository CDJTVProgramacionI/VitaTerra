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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void mostrarPantalla()
    {
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
