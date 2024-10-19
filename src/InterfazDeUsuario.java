public class InterfazDeUsuario
{
    private Pantalla[] pantallas;

    public InterfazDeUsuario()
    {
        pantallas = new Pantalla[]
                {
                        new Menu("Bienvenid@ al juego Vita Terra\n1.Jugar\n2.Salir", 0),
                        new Menu("Elige la cantidad de jugadores:\n",0),
                        new Pantalla("Intrucciones:\n 1. Se presentan por nivel 10 desechos a clasficar" +
                                "dentro del contenedor correcto. Por cada desecho clasificado correctamente" +
                                "se obtendrá una cierta cantidad de puntos y por cada desecho clasificado" +
                                "incorrectamente se pierde una cierta cantidad de vidas; estas cantidades" +
                                "dependen del nivel en el que se encuentre el jugador.\n2. Al conseguir clasificar" +
                                "el mínimo de desechos que tiene cada nivel, se pasa a una segunda etapa que es tratar" +
                                "estos desechos en la planta tratadora. En esta etapa muestran los pasos de cómo tratar" +
                                "cada desecho y se tiene que eligir el orden correcto en el que van estos pasos.\n 3. Si" +
                                "el jugador trata correctamente la cantidad mínima de desechos del nivel, pasa al siguiente nivel" +
                                "y si es el último nivel gana el juego.\n4. El juego termina cuando se han clasificado todos" +
                                "los desechos o cuando el jugador pierde todas sus vidas.",0),
                        new Menu("Datos del jugador: {0}\nDesecho a clasificar: {1}\n¿En qué contenedor debes meter el desecho?\n" +
                                "Elige un contenedor de los siguientes:\n{2}", 3),
                        new Pantalla("¡Muy bien!, has clasificado correctamente la cantidad mínima de desechos para este nivel.\n" +
                                "Ahora continuamos llevando estos desechos a la Planta Tratadora", 0),
                        new Menu("Datos del jugador: {0}\nDesecho a tratar: {1}\n¿Cómo se trata este desecho?\n{2}", 3),
                        new Menu("¡Correcto!\nAhora organiza los pasos a seguir para tratar el desecho:\n{0}", 1),
                        new Pantalla("Incorrecto", 0),
                        new Pantalla("Fin del juego, perdiste", 0),
                        new Pantalla ("¡Felicidades!, {0} ganado", 1)
                };
    }

    public Pantalla cambiarAPantalla(int pantalla)
    {
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void borrarPantalla()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
