package l1;

import java.net.*;
import java.io.*;

public class Servidor{
	public static final int PORT=2000;
	public static int num=0;

	public static void main(String args[]) throws IOException{
		ServerSocket servidor = new ServerSocket(PORT);

		for(;;){
			System.out.println("---Servidor aceptando conexiones---");
			try{
				Socket sock=servidor.accept();
				num++;
				Runnable service = new Sirviente(sock,num);
				new Thread(service).start();
				System.out.println("Cliente "+num+" aceptado.");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
