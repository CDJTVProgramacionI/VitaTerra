public class Pantalla {


    private String textoActual;
    protected String [] argumentos;


    //Constructor pantalla
    public Pantalla (String textoActual, int cant_argumentos){

        this.textoActual = textoActual;
        this.argumentos = cant_argumentos <= 0 ? null : new String [cant_argumentos];
    }

    public void mostrar(){

        for(int i =  0; i < argumentos.length; i++){

            textoActual.replace("{"+i+"}", argumentos [i]);

        }

        System.out.println(textoActual);

    }

    public int getCantidadArgumentos(){

        return argumentos.length;

    }

    public void setArgumento(int i, String valor){

        if (i >= 0 && i < argumentos.length){

            argumentos [i] = valor;
        }

    }

}
