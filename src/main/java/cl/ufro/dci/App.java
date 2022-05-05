package cl.ufro.dci;

import cl.ufro.dci.controlador.ExtractorUF;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        ExtractorUF uf = new ExtractorUF();
        System.out.println("UF: "+uf.obtenerUF());
    }
}
