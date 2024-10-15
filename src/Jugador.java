public class Jugador {

    //Atributos
    private String nombre; //Nombre del jugador
    private int puntos; //Cantidad de puntos del jugador
    private int vidas; //Cantidad de vidas del jugador

    //Constructor
    public Jugador(String nombre){

        this.nombre = nombre; //Asigna nombre al atributo nombre
        this.puntos = 0; //Inicializa en 0 la cantidad de puntos
        this.vidas = 5; //Inicializa en 5 la cantidad de vidas iniciales

    }


    //METODOS

    //Metodo para obtener nombre
    public String getNombre(){
        return nombre; //Retorna el nombre
    }

    //Metodo para obtener puntos
    public int getPuntos(){
        return puntos; //Retorna la cantidad de puntos
    }

    //Metodo para aumentar puntos
    public void aumentarPuntosEn(int puntosRespuestaCorrecta){

       //Suma los puntos con los puntos de las respuestas correctas de la clase Nivel??
        puntos += puntosRespuestaCorrecta;
    }

    //Metodo para disminuir vidas
    public void disminuirVidasEn(int vidasRespuestaIncorrecta){

        //A las vidas les resta las vidas de las respuestas incorrectas de la clase Nivel??
        vidas -= vidasRespuestaIncorrecta;
    }

    //Metodo para saber si el jugador está vivo
    public boolean jugadorEstaVivo(){

        //Verifica si la cantidad de vidas en mayor a 0, es decir, si está vivo el jugador
        //Si está vivo retorna true, sino retorna false
        return vidas > 0;
    }
}
