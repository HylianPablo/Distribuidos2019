package holaServer;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.util.HashMap;
import java.util.Map;
import java.rmi.server.ServerNotActiveException;

public class HolaImpl extends java.rmi.server.UnicastRemoteObject implements Hola, HolaRegistro {
   private Map<String,String> listado=null;

   public HolaImpl() throws RemoteException {
       super();
       listado = new HashMap<String,String>();
   }

   public String saluda(String nombre) throws RemoteException {
       String ip=null;
       try {
           ip = this.getClientHost();
       } catch (ServerNotActiveException snae) {
           snae.printStackTrace(System.err);
       }
       listado.put(ip, nombre);
       return "Hola, "+nombre+" !";
   }

   public Map<String,String> lista() {
       return listado;
   }
}
