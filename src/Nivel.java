import java.util.Scanner;

import Desechos.*;
import Desechos.Plastico;

public class Nivel {
    private int puntosPorRespuestaCorrecta;
    private int vidasRespuestaIncorrecta;
    private Contenedor[] contenedores;
    private Desecho[] desechos;
    private int desechosMinimosParaSeguir;
    private Manager gameManager;
    private int segundosPorTurno;

    public Nivel(int puntosPorRespuestaCorrecta, int vidasRespuestaIncorrecta, Contenedor[] contenedores, int desechosMinimosParaSeguir, Manager gameManager, int segundosPorTurno) {
        this.puntosPorRespuestaCorrecta = puntosPorRespuestaCorrecta;
        this.vidasRespuestaIncorrecta = vidasRespuestaIncorrecta;
        this.contenedores = contenedores;
        this.desechos = generarListaDesechos();
        this.desechosMinimosParaSeguir = desechosMinimosParaSeguir;
        this.gameManager = gameManager;
        this.segundosPorTurno = segundosPorTurno;
    }

    public boolean ejecutarConResultado() {
        Temporizador temporizador = new Temporizador();
        return true;
    }

    private Desecho[] generarListaDesechos() {
        Desecho[] desechos = new Desecho[10];
        for (int i = 0; i < 10; i++) {
            //Generar numero aleatorio entre 0 y la cantidad de contenedores
            int random = (int) (Math.random() * contenedores.length);
            //Obtener etiqueta del contenedor i
            String etiqueta = contenedores[random].getEtiqueta();

            //Crear desecho según la etiqueta obtenida
            switch (etiqueta) {
                case "Plástico":
                    desechos[i] = Plastico.generaAleatorio();
                    break;
                case "Papel":
                    desechos[i] = Papel.generaAleatorio();
                    break;
                case "Vidrio":
                    desechos[i] = Vidrio.generaAleatorio();
                    break;
                case "Orgánico":
                    desechos[i] = Organico.generaAleatorio();
                    break;
                case "Baterías":
                    desechos[i] = Baterias.generaAleatorio();
                    break;
                case "Electrónicos":
                    desechos[i] = Electronico.generaAleatorio();
                    break;
                case "Cartón":
                    desechos[i] = Carton.generaAleatorio();
                    break;
                case "Biológicos":
                    desechos[i] = Biologicos.generaAleatorio();
                    break;
                case "Medicamentos":
                    desechos[i] = Medicamentos.generaAleatorio();
                    break;
                case "Químicos":
                    desechos[i] = Quimicos.generaAleatorio();
                    break;
            }
        }

        return desechos;
    }

    private boolean JugadorVivoYConTiempo(Jugador jugador, Temporizador temporizador) {
        return jugador.jugadorEstaVivo() && temporizador.restaTiempo();
    }
}
