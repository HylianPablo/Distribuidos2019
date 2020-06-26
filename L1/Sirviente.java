package l1;

import java.net.*;
import java.io.*;

public class Sirviente implements Runnable{
	private Socket sock;
	private int num;

	public Sirviente(Socket s, int n){
		sock=s;
		num=n;
	}

	public void run(){
		try{
			servicio();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void servicio() throws IOException{
		InputStream in=sock.getInputStream();
		Reader r1 = new InputStreamReader(in);
		PrintStream outred;

		try(BufferedReader inred=new BufferedReader(r1)){
			OutputStream out=sock.getOutputStream();
			outred=new PrintStream(out);
			String linea;
			while((linea=inred.readLine())!=null){
				System.out.println("Cliente "+num+": "+linea);
				outred.println(linea);
				if(linea.equals("Adios."))
					break;
			}
		}
		outred.close();
		outred.close();
	}
}
