package ejemplo.handmadeecho;

import java.io.*;
import java.net.*;

public class EchoServer{

	protected static boolean serverContinue=true;
	protected Socket clientSocket;

	public static void main(String args[]) throws IOException{

		ServerSocket serverSocket = null;

		try{
			serverSocket=new ServerSocket(10007);
			System.out.println("Connection Socket Created");
			try{
				while(serverContinue){
					System.out.println("Waiting for connection");
					serverSocket.setSoTimeout(10000);
					try{
						new EchoServer(serverSocket.accept());
					}catch(SocketTimeoutException ste){
						System.out.println("Timeout Ocurred");
					}
				}
			}catch(IOException e){
				System.err.println("Accept failed.");
				System.exit(1);
			}
		}catch(IOException e){
			System.err.println("Could not listen on port: 10007.");
			System.exit(1);
		}
		finally{
			try{
				System.out.println("Closing Server Connection Socket");
				serverSocket.close();
			}catch(IOException e){
				System.err.println("Could not close port 10007.");
				System.exit(1);
			}

		}
	}

	private EchoServer(Socket clientSoc){
		clientSocket=clientSoc;
		run();
	}

	public void run(){
		System.out.println("New Communication Thread Started");

		try{
			PrintWriter out=new PrintWriter(clientSocket.getOutputStream(),true);
			BufferedReader in =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String inputLine;

			while((inputLine=in.readLine())!=null){
				System.out.println("Server: "+inputLine);

				if(inputLine.equals("?"))
					inputLine=new String ("\"Bye.\" ends Client, "+"\"End Server.\" ends Server");

				out.println(inputLine);

				if(inputLine.equals("Bye."))
					break;
				if(inputLine.equals("End Server."))
					serverContinue=false;
			}
			out.close();
			in.close();
			clientSocket.close();
		}
		catch(IOException e){
			System.err.println("Problem with Communication Server");
			System.exit(1);
		}
	}
}

