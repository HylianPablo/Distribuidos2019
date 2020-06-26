package fileserver;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.*;

/**
 * Interfaz que construye un objeto remoto FileLector para leer archivos de texto.
 * @author cllamas
 */
public interface FileServidor extends Remote{
    public FileLector abre(String nombre) throws RemoteException, FileNotFoundException;
}
