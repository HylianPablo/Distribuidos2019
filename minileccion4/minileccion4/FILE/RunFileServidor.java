package runfileserver;
import java.rmi.Remote;
import java.rmi.RemoteException;
import fileserver.FileLector;
import fileserver.FileLectorImpl;
import fileserver.FileServidorImpl;
import fileserver.FileServidor;

/**
 * Lanza el objeto remoto ObjetoFileServidor de tipo FileServidor.
 * @author cllamas
 */
public class RunFileServidor {
    public static void main(String[] args) {
        try {
        FileServidor cc = new FileServidorImpl();

        java.rmi.registry.Registry registro = java.rmi.registry.LocateRegistry.getRegistry("localhost",1099);

        registro.rebind("ObjetoFileServidor", cc);
        System.out.println("Objeto remoto 'ObjetoFileServidor' enlazado");
        } catch (RemoteException re) {
            re.printStackTrace(System.err);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
