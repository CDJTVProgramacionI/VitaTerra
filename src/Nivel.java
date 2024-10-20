import java.util.Scanner;

import Desechos.*;
import Desechos.Plastico;

public class Nivel {
    private int puntosPorRespuestaCorrecta;
    private int vidasRespuestaIncorrecta;
    private Contenedor[] contenedores;
    private int desechosMinimosParaSeguir;
    private Manager gameManager;
    private int segundosPorTurno;

    public Nivel(int puntosPorRespuestaCorrecta, int vidasRespuestaIncorrecta, Contenedor[] contenedores, int desechosMinimosParaSeguir, Manager gameManager, int segundosPorTurno) {
        this.puntosPorRespuestaCorrecta = puntosPorRespuestaCorrecta;
        this.vidasRespuestaIncorrecta = vidasRespuestaIncorrecta;
        this.contenedores = contenedores;
        this.desechosMinimosParaSeguir = desechosMinimosParaSeguir;
        this.gameManager = gameManager;
        this.segundosPorTurno = segundosPorTurno;
    }

    public boolean ejecutarConResultado() {
        Temporizador temporizador = new Temporizador();
        int numJugadores = gameManager.getNumeroDeJugadores() - 1;
        int desechosCorrectos = 0;

        for (int i = numJugadores; i >= 0; i--) {
            Jugador jugadorActual = gameManager.getNesimoJugador(i);
            temporizador.setTiempo(segundosPorTurno/3);

            gameManager.irAPantalla(11, new String[]{jugadorActual.getNombre()});

            for (int j = 0; j < 10 && JugadorVivoYConTiempo(jugadorActual, temporizador); j++) {
                String infoJugador = jugadorActual.getInfo();
                Desecho desecho = generarDesechoAleatorio();

                temporizador.comenzar();
                gameManager.irAPantalla(3, new String[]{infoJugador, desecho.getNombre(), generarListaContenedores(), String.valueOf(temporizador.getTiempo())});
                temporizador.detener();
                int respuesta = gameManager.getOpcionElegida();

                boolean respuestaCorrecta = contenedores[respuesta-1].insertarDesecho(desecho);
                gameManager.procesarRespuesta(jugadorActual, temporizador.restaTiempo(), respuestaCorrecta, puntosPorRespuestaCorrecta, vidasRespuestaIncorrecta);

                if(respuestaCorrecta)
                {
                    desechosCorrectos++;
                }

                if(!respuestaCorrecta && numJugadores > 1)
                {
                    break;
                }

            }

            Contenedor maxContenedor = getMaxContenedor();
            gameManager.irAPantalla(13, new String[]{maxContenedor.getEtiqueta(), String.valueOf(maxContenedor.getCantidadDesechos())});

            if (desechosCorrectos < desechosMinimosParaSeguir) {
                continue;
            }

            //Planta tratadora
            gameManager.irAPantalla(4, null);
        }

        temporizador.dispose();
        return gameManager.getNumeroDeJugadores() > 0;
    }

    private String generarListaContenedores() {

        String texto = "";
        for (int i = 0; i < contenedores.length; i++) {

            String etiqueta = contenedores[i].getEtiqueta();
            texto += (i + 1) + ". " + etiqueta + "\n";
        }
        return texto;
    }

    private Desecho generarDesechoAleatorio() {
        //Generar numero aleatorio entre 0 y la cantidad de contenedores
        int random = (int) (Math.random() * contenedores.length);

        //Obtener etiqueta del contenedor i
        String etiqueta = contenedores[random].getEtiqueta();

        //Crear desecho según la etiqueta obtenida
        return switch (etiqueta) {
            case "Plástico" -> Plastico.generaAleatorio();
            case "Papel" -> Papel.generaAleatorio();
            case "Vidrio" -> Vidrio.generaAleatorio();
            case "Orgánico" -> Organico.generaAleatorio();
            case "Baterías" -> Baterias.generaAleatorio();
            case "Electrónicos" -> Electronico.generaAleatorio();
            case "Cartón" -> Carton.generaAleatorio();
            case "Biológicos" -> Biologicos.generaAleatorio();
            case "Medicamentos" -> Medicamentos.generaAleatorio();
            case "Químicos" -> Quimicos.generaAleatorio();
            default -> null;
        };
    }

    private Contenedor getMaxContenedor()
    {
        Contenedor max = contenedores[0];
        for (Contenedor contenedor : contenedores) {
            if (contenedor.getCantidadDesechos() > max.getCantidadDesechos()) {
                max = contenedor;
            }
        }
        return max;
    }

    private boolean JugadorVivoYConTiempo(Jugador jugador, Temporizador temporizador) {
        return jugador.jugadorEstaVivo() && temporizador.restaTiempo();
    }
}
