package fileservercliente;

public class FileServerCliente {
    public static void main(String[] args) {
        String nombreArchivo = "Hola.txt";
        try {
            fileServidorCliente.FileReceptor fr=new fileServidorCliente.FileReceptorImpl();
            fileServidor.FileServidor fs;
            String linea;
	    java.rmi.registry.Registry registro = java.rmi.registry.LocateRegistry.getRegistry("localhost",1099);	
            fs = (fileServidor.FileServidor) registro.lookup("ObjetoFileServidor");
            fs.abreLee(nombreArchivo,fr);
	    //System.exit(0);
        } catch (java.rmi.RemoteException re) {
            System.err.println("...");
        } catch (java.io.FileNotFoundException fnfe) {
            System.err.println("El archivo " + nombreArchivo + " no existe.");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
