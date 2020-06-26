package fileServidorCliente;

public class FileReceptorImpl extends java.rmi.server.UnicastRemoteObject implements FileReceptor {
	public FileReceptorImpl() throws java.rmi.RemoteException{
		super();
	}

	public void recibeLinea(String linea) throws java.rmi.RemoteException{
		System.out.println(linea);
	}
}
