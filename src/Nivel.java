import java.util.Scanner;

public class Nivel
{
    private int puntosPorRespuestaCorrecta;
    private int vidasRespuestaIncorrecta;
    private Contenedor[] contenedores;
    private Desecho[] desechos;
    private int desechosMinimosParaSeguir;
    private Manager gameManager;
    private int segundosPorTurno;

    public Nivel(int puntosPorRespuestaCorrecta, int vidasRespuestaIncorrecta, Contenedor[] contenedores, int desechosMinimosParaSeguir, Manager gameManager, int segundosPorTurno)
    {
        this.puntosPorRespuestaCorrecta = puntosPorRespuestaCorrecta;
        this.vidasRespuestaIncorrecta = vidasRespuestaIncorrecta;
        this.contenedores = contenedores;
        this.desechos = generarListaDesechos();
        this.desechosMinimosParaSeguir = desechosMinimosParaSeguir;
        this.gameManager = gameManager;
        this.segundosPorTurno = segundosPorTurno;
    }

    public boolean ejecutarConResultado()
    {
        return true;
    }

    private Desecho[] generarListaDesechos()
    {
        return null;
    }
}
