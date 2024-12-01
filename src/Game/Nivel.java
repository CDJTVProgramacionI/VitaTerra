package Game;

import Desechos.*;
import Excepciones.DesechosInsuficientesException;
import Excepciones.RespuestaIncorrectaException;
import Excepciones.ContenedorVacioException;

import java.util.ArrayList;

public class Nivel {
    private int puntosPorRespuestaCorrecta;
    private int vidasRespuestaIncorrecta;
    private Contenedor[] contenedores;
    private int desechosMinimosParaSeguir;
    private int segundosPorTurno;
    private int desechosCorrectos;

    public Nivel(int puntosPorRespuestaCorrecta, int vidasRespuestaIncorrecta, Contenedor[] contenedores, int desechosMinimosParaSeguir, int segundosPorTurno) {
        this.puntosPorRespuestaCorrecta = puntosPorRespuestaCorrecta;
        this.vidasRespuestaIncorrecta = vidasRespuestaIncorrecta;
        this.contenedores = contenedores;
        this.desechosMinimosParaSeguir = desechosMinimosParaSeguir;
        this.segundosPorTurno = segundosPorTurno;
    }

    public void configurar(Temporizador temporizador){
        desechosCorrectos = 0;
        temporizador.setTiempo(segundosPorTurno);
    }

    private String generarListaContenedores() {

        String texto = "";
        for (int i = 0; i < contenedores.length; i++) {

            String etiqueta = contenedores[i].getEtiqueta();
            texto += (i + 1) + ". " + etiqueta + "\n";
        }
        return texto;
    }

    public Contenedor[] getContenedores() {
        return contenedores;
    }

    public void aumentaDesechosCorrectos() {
        desechosCorrectos++;
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

    public Contenedor getContenedor(int i) {
        return contenedores[i];
    }

    public int getPuntos() {
        return puntosPorRespuestaCorrecta;
    }

    public int getVidas() {
        return vidasRespuestaIncorrecta;
    }
}
