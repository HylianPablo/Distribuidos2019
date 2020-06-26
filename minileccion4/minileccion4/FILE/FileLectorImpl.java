package fileserver;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.*;


/**
 *
 * @author cllamas
 */
public class FileLectorImpl extends java.rmi.server.UnicastRemoteObject implements FileLector,Serializable {
    private final BufferedReader br;
    public FileLectorImpl(String nombre) throws RemoteException, FileNotFoundException {
        super();
        this.br = new BufferedReader(new FileReader(nombre));
    }

    @Override
    public String leeLinea() throws RemoteException, IOException {
        return br.readLine();
    }
}
