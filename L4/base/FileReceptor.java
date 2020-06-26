package fileServidorCliente;

public interface FileReceptor extends java.rmi.Remote{
	public void recibeLinea(String linea) throws java.rmi.RemoteException;
}
