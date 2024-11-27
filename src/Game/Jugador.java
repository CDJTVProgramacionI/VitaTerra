package Game;

import Excepciones.DatosIncorrectosException;

public class Jugador {

    //Atributos
    private String nombre; //Nombre del jugador
    private int puntos; //Cantidad de puntos del jugador
    private int vidas; //Cantidad de vidas del jugador
    private int edad; // Edad del jugador

    //Constructor
    public Jugador(String nombre, int edad) throws DatosIncorrectosException {

        // Validar que el nombre no esté vacío
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosIncorrectosException("El nombre no puede estar vacío.");
        }

        setEdad(edad);

        this.puntos = 0; //Inicializa en 0 la cantidad de puntos
        this.vidas = 5; //Inicializa en 5 la cantidad de vidas iniciales
    }


    //METODOS

    //Metodo para obtener info
    public String getInfo() {
        //Retorna el nombre, los puntos y las vidas del jugador
        return nombre + " Puntos:" + puntos + " Vidas:" + vidas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws DatosIncorrectosException {
        // Valida que la edad no sea negativa
        if (edad < 0) {
            throw new DatosIncorrectosException("La edad debe ser mayor que 0");
        }
        this.edad = edad;
    }

    //Metodo para aumentar puntos
    public void aumentarPuntosEn(int puntosRespuestaCorrecta) {

        //Suma los puntos con los puntos de las respuestas correctas de la clase Game.Nivel??
        puntos += puntosRespuestaCorrecta;
    }

    //Metodo para disminuir vidas
    public void disminuirVidasEn(int vidasRespuestaIncorrecta) {

        //A las vidas les resta las vidas de las respuestas incorrectas de la clase Game.Nivel??
        vidas -= vidasRespuestaIncorrecta;
    }

    //Metodo para saber si el jugador está vivo
    public boolean jugadorEstaVivo() {

        //Verifica si la cantidad de vidas en mayor a 0, es decir, si está vivo el jugador
        //Si está vivo retorna true, sino retorna false
        return vidas > 0;
    }
}
