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
    private PlantaTratadora plantaTratadora;

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

    public Contenedor[] getContenedores() {
        return contenedores;
    }

    public void aumentaDesechosCorrectos() {
        desechosCorrectos++;
    }

    public void decrementaDesechosCorrectos() throws DesechosInsuficientesException
    {
        desechosCorrectos--;
        verificaDesechos();
    }

    public Contenedor getMaxContenedor() {
        Contenedor max = contenedores[0];
        for (Contenedor contenedor : contenedores) {
            if (contenedor.getCantidadDesechos() > max.getCantidadDesechos()) {
                max = contenedor;
            }
        }
        return max;
    }

    public void setPlantaTratadora() {
        this.plantaTratadora = new PlantaTratadora(contenedores);
    }

    public PlantaTratadora getPlantaTratadora() {
        return plantaTratadora;
    }


    public void verificaDesechos() throws DesechosInsuficientesException
    {
        //Si no se llega a la cantidad de desechos mínimos, se acaba el turno
        if (desechosCorrectos < desechosMinimosParaSeguir) {
            throw new DesechosInsuficientesException();
        }
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
