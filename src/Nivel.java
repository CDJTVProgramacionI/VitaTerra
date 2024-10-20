import Desechos.*;
import Desechos.Plastico;

import java.util.ArrayList;
import java.util.Arrays;

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
            temporizador.setTiempo(segundosPorTurno);

            //Texto de inicio de turno
            gameManager.irAPantalla(11, new String[]{jugadorActual.getNombre()});

            //Clasificar desechos
            for (int j = 0; j < 10 && jugadorVivoYConTiempo(jugadorActual, temporizador); j++) {
                Desecho desecho = generarDesechoAleatorio();

                temporizador.comenzar();
                gameManager.irAPantalla(3, new String[]{jugadorActual.getInfo(), desecho.getNombre(), generarListaContenedores(), String.valueOf(temporizador.getTiempo())});
                temporizador.detener();

                if (gameManager.procesarRespuesta(jugadorActual, temporizador.restaTiempo(), this, desecho)) {
                    desechosCorrectos++;
                }
            }

            //Mostrar contenedor con más desechos
            Contenedor maxContenedor = getMaxContenedor();
            gameManager.irAPantalla(13, new String[]{maxContenedor.getEtiqueta(), String.valueOf(maxContenedor.getCantidadDesechos())});

            //Si no se llega a la cantidad de desechos mínimos, se salta al siguiente jugador
            if (desechosCorrectos < desechosMinimosParaSeguir)
            {
                gameManager.confirmarJugadorConDesechosMinimos(jugadorActual, desechosMinimosParaSeguir, desechosCorrectos);
                continue;
            }

            //Texto de conexión
            gameManager.irAPantalla(4, null); // Llamar a ver plata tratadora

            PlantaTratadora planta = new PlantaTratadora(contenedores);

            // Bucle que se repite mientras haya contenedores sin revisar y el jugador esté vivo
            for (int j = 0; j < contenedores.length && jugadorVivoYConTiempo(jugadorActual, temporizador) && desechosCorrectos >= desechosMinimosParaSeguir; j++) {
                Contenedor contenedorActual = planta.getContenedor(j); // Obtener el i-ésimo contenedor
                ArrayList<Desecho> desechos = contenedorActual.vaciarContenedor(); // Vaciar el contenedor
                for(int des = 0; des < desechos.size() && jugadorVivoYConTiempo(jugadorActual, temporizador); des++)
                {
                    Desecho desecho = desechos.get(des);
                    //Elije tratamiento
                    String metodos = planta.getMetodosParaContenedorN(j);

                    temporizador.comenzar();
                    //Mostrar métodos de tratamiento
                    gameManager.irAPantalla(5, new String[]{jugadorActual.getInfo(), desecho.getInfo(), metodos, String.valueOf(temporizador.getTiempo())}); // Llamar a ver plata tratadora
                    temporizador.detener();

                    if(gameManager.procesarRespuesta(jugadorActual, temporizador.restaTiempo(), this, desecho, planta))
                    {
                        ArrayList<Integer> pasosJugador = new ArrayList<Integer>();
                        temporizador.comenzar();
                        for(int k = 0; k < planta.getCantidadPasos(); k++)
                        {
                            //Mostrar pasos de tratamiento
                            gameManager.irAPantalla(6, new String[]{jugadorActual.getInfo(), desecho.getInfo(), planta.getTratamientoDesorganizado(), String.valueOf(temporizador.getTiempo()), String.valueOf(k + 1)});
                            pasosJugador.add(gameManager.getOpcionElegida());
                        }
                        temporizador.detener();
                        if(!gameManager.procesarRespuesta(jugadorActual, temporizador.restaTiempo(), this, pasosJugador, planta))
                        {
                            desechosCorrectos--;
                        }
                    }
                    else
                    {
                        desechosCorrectos--;
                    }
                }
            }

            //Confirmar que jugador ha clasificado y tratado suficientes desechos
            gameManager.confirmarJugadorConDesechosMinimos(jugadorActual, desechosMinimosParaSeguir, desechosCorrectos);
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

    private Contenedor getMaxContenedor() {
        Contenedor max = contenedores[0];
        for (Contenedor contenedor : contenedores) {
            if (contenedor.getCantidadDesechos() > max.getCantidadDesechos()) {
                max = contenedor;
            }
        }
        return max;
    }

    private boolean jugadorVivoYConTiempo(Jugador jugador, Temporizador temporizador) {
        return jugador.jugadorEstaVivo() && temporizador.restaTiempo();
    }

    public Contenedor getContenedor(int i) {
        return contenedores[i];
    }

    private boolean respuestaCorrectaYMultijugador(boolean ultimaRespuestaCorrecta, int numJugadores) {
        return ultimaRespuestaCorrecta && numJugadores > 1;
    }

    public int getPuntos() {
        return puntosPorRespuestaCorrecta;
    }

    public int getVidas() {
        return vidasRespuestaIncorrecta;
    }
}
