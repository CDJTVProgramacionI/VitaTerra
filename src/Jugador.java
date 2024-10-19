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

    //Metodo para obtener info
    public String getInfo()
    {
        //Retorna el nombre, los puntos y las vidas del jugador
        return nombre + " Puntos:" + puntos + " Vidas:" + vidas;
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
