package l1;

import java.net.*;
import java.io.*;

public class Cliente{
	public static final int PORT=2000;

	public static void main(String args[])throws IOException{
		String linea=null;
		Socket cliente=new Socket("localhost",PORT);

		try{
			Reader t1 = new InputStreamReader(System.in);
			BufferedReader inteclado=new BufferedReader(t1);

			InputStream in = cliente.getInputStream();
			Reader r1 =new InputStreamReader(in);
			BufferedReader inred = new BufferedReader(r1);

			OutputStream out = cliente.getOutputStream();
			PrintStream outred = new PrintStream(out);

			while(true){
				System.out.print("Cliente: ");
				linea=inteclado.readLine();
				outred.println(linea);

				linea=inred.readLine();
				System.out.println("Recibido: "+linea);
				if(linea.equals("Adios."))
					break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

					

