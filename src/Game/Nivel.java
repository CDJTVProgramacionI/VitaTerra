package Game;

import Desechos.*;
import Desechos.Plastico;
import Excepciones.DesechosInsuficientesException;
import Excepciones.RespuestaIncorrectaException;

import java.util.ArrayList;

public class Nivel {
    private int puntosPorRespuestaCorrecta;
    private int vidasRespuestaIncorrecta;
    private Contenedor[] contenedores;
    private int desechosMinimosParaSeguir;
    private int segundosPorTurno;

    public Nivel(int puntosPorRespuestaCorrecta, int vidasRespuestaIncorrecta, Contenedor[] contenedores, int desechosMinimosParaSeguir, int segundosPorTurno) {
        this.puntosPorRespuestaCorrecta = puntosPorRespuestaCorrecta;
        this.vidasRespuestaIncorrecta = vidasRespuestaIncorrecta;
        this.contenedores = contenedores;
        this.desechosMinimosParaSeguir = desechosMinimosParaSeguir;
        this.segundosPorTurno = segundosPorTurno;
    }

    public void ejecutar(Manager gameManager, Temporizador temporizador, Jugador jugadorActual) throws DesechosInsuficientesException {
        int desechosCorrectos = 0;

        temporizador.setTiempo(segundosPorTurno);
        //TODO: Inicio de turno

        //Clasificar desechos
        for (int j = 0; j < 10; j++) {
            Desecho desecho = generarDesechoAleatorio();

            temporizador.comenzar();
            gameManager.esperarPantalla("Clasificar", new String[]
                    {
                            jugadorActual.getInfo(),
                            desecho.getNombre(),
                            generarListaContenedores(),
                            String.valueOf(temporizador.getTiempo())
                    });


            desechosCorrectos++;
        }

        //Mostrar contenedor con más desechos
        Contenedor maxContenedor = getMaxContenedor();
        gameManager.irAPantalla(13, new String[]{maxContenedor.getEtiqueta(), String.valueOf(maxContenedor.getCantidadDesechos())});

        //Si no se llega a la cantidad de desechos mínimos, se acaba el turno
        if (desechosCorrectos < desechosMinimosParaSeguir || !jugadorVivoYConTiempo(jugadorActual, temporizador)) {
            throw new DesechosInsuficientesException();
        }

        PlantaTratadora planta = new PlantaTratadora(contenedores);

        // Bucle que se repite mientras haya contenedores sin revisar y el jugador esté vivo
        for (int j = 0; j < contenedores.length; j++) {
            Contenedor contenedorActual = planta.getContenedor(j); // Obtener el i-ésimo contenedor
            ArrayList<Desecho> desechos = contenedorActual.vaciarContenedor(); // Vaciar el contenedor
            for (int des = 0; des < desechos.size(); des++) {
                Desecho desecho = desechos.get(des);
                //Elije tratamiento
                String metodos = planta.getMetodosParaContenedorN(j);

                temporizador.comenzar();
                //Mostrar métodos de tratamiento
                gameManager.esperarPantalla("Métodos",
                        new String[]
                                {
                                        jugadorActual.getInfo(),
                                        desecho.getInfo(),
                                        metodos,
                                        String.valueOf(temporizador.getTiempo())
                                });

                ArrayList<Integer> pasosJugador = new ArrayList<Integer>();
                temporizador.comenzar();
                for (int k = 0; k < planta.getCantidadPasos(); k++) {
                    //Mostrar pasos de tratamiento
                    gameManager.esperarPantalla("Tratamiento",
                            new String[]
                                    {
                                            jugadorActual.getInfo(),
                                            desecho.getInfo(),
                                            planta.getTratamientoDesorganizado(),
                                            String.valueOf(temporizador.getTiempo()),
                                            String.valueOf(k + 1)
                                    });
                }

                if (desechosCorrectos < desechosMinimosParaSeguir) {
                    throw new DesechosInsuficientesException();
                }
            }

            //Confirmar que jugador ha clasificado y tratado suficientes desechos
            gameManager.confirmarJugadorConDesechosMinimos(jugadorActual, desechosMinimosParaSeguir, desechosCorrectos);
        }
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
