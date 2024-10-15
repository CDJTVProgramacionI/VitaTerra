public class Pantalla {


    private String textoActual;
    private String [] argumentos;


    //Constructor pantalla
    public Pantalla (String textoActual, String[] ar){

        this.textoActual = textoActual;
        this.argumentos = ar;
        
    }

    public void mostrar(){

        for(int i =  0; i < argumentos.length; i++){

            textoActual.replace("{"+i+"}", argumentos [i]);

        }

        System.out.println(textoActual);

    }

    public void setArgumento(int i, String valor){

        if (i >= 0 && i < argumentos.length){

            argumentos [i] = valor;
        }

    }

}
