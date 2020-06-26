package fileServidor;

public class FileServidorImpl extends java.rmi.server.UnicastRemoteObject implements FileServidor,Runnable {
	String a;
	fileServidorCliente.FileReceptor r;
	java.io.BufferedReader br; 
    public FileServidorImpl() throws java.rmi.RemoteException {
        super();
    }
    public void abreLee(String nombreArchivo, fileServidorCliente.FileReceptor receptor)
		    throws java.rmi.RemoteException , java.io.IOException, java.io.FileNotFoundException {

	a=nombreArchivo;
	r=receptor;
	Thread x = new Thread(this);
	x.start();
    }

    public void run(){
	    try{
		    int index=0;
		    int timeout=0;
		    while(true){
			    br=new java.io.BufferedReader(new java.io.FileReader(a));
			    for(int i=0;i<index;i++){
				    br.readLine();
				}
			    while(br.ready()){
				    String linea=br.readLine();
				    if(linea!=null){
				    r.recibeLinea(linea);
				    index++;
				    //timeout=0;
				    }
			    }
			    Thread.sleep(2000);
			    timeout++;
			    if(timeout>2){
				    System.exit(0);
			    }
		    }
	    }catch(Exception e){}
    }
}
			  

