package fileServidor;

public interface FileServidor extends java.rmi.Remote {
    public void  abreLee(String nombreArchivo, fileServidorCliente.FileReceptor receptor)
		    throws java.io.IOException, java.rmi.RemoteException, java.io.FileNotFoundException;
}
