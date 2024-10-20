public class InterfazDeUsuario
{
    private Pantalla[] pantallas;

    public InterfazDeUsuario()
    {
        pantallas = new Pantalla[]
                {
                        new Menu("Bienvenid@ al juego Vita Terra\n1.Jugar\n2.Ver Instrucciones\n3.Salir", 0, 3),
                        new Menu("Elige la cantidad de jugadores:\n1. Un jugador\n2. Dos Jugadores",0, 2),
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
                        new Menu("Tiempo restante {3} segundos\nDatos del jugador: {0}\nDesecho a clasificar: {1}\n¿En qué contenedor debes meter el desecho?\n" +
                                "Elige un contenedor de los siguientes:\n{2}", 4, 4),
                        new Pantalla("¡Muy bien!, has clasificado correctamente la cantidad mínima de desechos para este nivel.\n" +
                                "Ahora continuamos llevando estos desechos a la Planta Tratadora", 0),
                        new Menu("Tiempo restante {3} segundos\nDatos del jugador: {0}\nDesecho a tratar: {1}\n¿Cómo se trata este desecho?\n{2}", 4, 4),
                        new Menu("¡Correcto!\nAhora organiza los pasos a seguir para tratar el desecho:\n{0}", 1, 4),
                        new Pantalla("Incorrecto", 0),
                        new Pantalla("Fin del juego, perdiste", 0),
                        new Pantalla ("¡Felicidades!, {0} ganado", 1),
                        new Pantalla("¡Vamos al siguiente nivel!", 0),
                        new Pantalla("¡Ahora es turno del {0}!", 1),
                        new Pantalla("¡Se acabó el tiempo!", 0),
                        new Pantalla("El contenedor {0} es el más lleno con {1} desechos", 2)
                };
    }

    public Pantalla mostrarPantalla(int pantalla)
    {
        borrarPantalla();
        pantallas[pantalla].mostrar();
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

    private void borrarPantalla()
    {
        for (int i = 0; i < 50; i++)
        {
            System.out.println();
        }
    }

}
