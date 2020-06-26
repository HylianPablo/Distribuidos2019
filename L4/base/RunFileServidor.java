package runfileserver;

public class RunFileServidor {
    public static void main(String[] args) {
        try {
        fileServidor.FileServidor cc = new fileServidor.FileServidorImpl();

        java.rmi.registry.Registry registro = java.rmi.registry.LocateRegistry.getRegistry("localhost",1099);

        registro.rebind("ObjetoFileServidor", cc);
        System.out.println("Objeto remoto 'ObjetoFileServidor' enlazado");

	String nombreArchivo="Hola.txt";
	String linea;


        } catch (java.rmi.RemoteException re) {
            re.printStackTrace(System.err);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
