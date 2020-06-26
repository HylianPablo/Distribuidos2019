package fileservercliente;

import fileserver.FileLector;
import fileserver.FileServidor;
import fileserver.FileServidorImpl;
import fileserver.FileLectorImpl;
import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.BufferedReader;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.*;

/**
 * Cliente de prueba de FileServer
 * @author cllamas
 */
public class FileServerCliente implements Serializable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws WriteAbortedException,NotSerializableException{
        String nombreArchivo = "Hola.txt";
        FileLector fl;
        FileServidor fs;
        String linea;

        try {
	    java.rmi.registry.Registry registro = java.rmi.registry.LocateRegistry.getRegistry("localhost",1099);	
            fs = (FileServidor) registro.lookup("ObjetoFileServidor");

            try {
                fl =fs.abre(nombreArchivo);
                try {
                    while (null != (linea = fl.leeLinea())) {
                        System.out.println(nombreArchivo+ ": "+linea);
                    }
                } catch (EOFException ioe) {
                    System.err.println("Archivo finalizado con EOFException");
                } catch (Exception ex) {
                    ex.printStackTrace(System.err);
                }
            } catch (FileNotFoundException fnfe) {
                System.err.println("El archivo " + nombreArchivo + " no existe.");
            } catch (Exception ex) {
                ex.printStackTrace(System.err);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
