package Ejemplo3;

import java.io.IOException;
import java.io.InputStream;

public class Ejemplo2 {

    public static void main(String[] args) {
        Process p;
        InputStream is;
        ProcessBuilder pb;
        
        try {
            //Instancio el processBuilder con los argumentos correspondientes para que liste el directorio /home
            pb = new ProcessBuilder("bash", "-c", "dir /home");
            //Creo un proceso con el processBuilder
            p = pb.start();
            int c;
            //Obtengo el inputstream para poder leer lo que imprime en consola el proceso
            is = p.getInputStream();
            
            //Mientras la lectura del inputStream no sea -1 sigo leyendo e imprimiendo en la consola
            while((c = is.read()) != -1)
                System.out.print((char) c);
            
            //Al terminar cierro el inputStream
            is.close();
            
            int exitVal;
            //Espero a que el proceso termine y guardo el valor de salida para mostrarlo
            exitVal = p.waitFor();
            System.out.println("\nValor de salida: " + exitVal + " -> " + (exitVal == 0 ? "Todo correcto":"Error"));
            
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}