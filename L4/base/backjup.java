package fileServidor;

public class FileServidorImpl extends java.rmi.server.UnicastRemoteObject implements FileServidor {
    public FileServidorImpl() throws java.rmi.RemoteException {
        super();
    }
    public void abreLee(String nombreArchivo, fileServidorCliente.FileReceptor receptor)
		    throws java.rmi.RemoteException , java.io.IOException, java.io.FileNotFoundException {

	Thread x=new Thread(new Runnable(){
		public void run(){
        	java.io.BufferedReader br;
		String linea;
		int index=0;
			try{
				while(true){
				br=new java.io.BufferedReader(new java.io.FileReader(nombreArchivo));
					for(int i=0;i<index;i++){
						linea=br.readLine();
					}
				while(br.ready()){
					receptor.recibeLinea(br.readLine());
					index++;
				}
				//try{
				//}catch(Exception e){}
				//if(linea!=null){
				//	linea=br.readLine();
				//}else{
				//	System.out.println("!");
				//	System.exit(0);
				//}
				try{
				Thread.sleep(12000);
				}catch(Exception ee){}
				}
			}catch(java.io.IOException e){}
		}
	});

	x.start();


	/*String linea=br.readLine();
	while(linea!=null){
	receptor.recibeLinea(linea);
	linea=br.readLine();
	}
        //algo*/
    }
}
