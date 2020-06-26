package ejemplo.ip;

import java.io.*;
import java.net.*;

public class IPAddrTest{

	public static void main(String args[]){
		try{
			InetAddress ip= InetAddress.getByName("localhost"); 
			System.out.println("IpAddress: "+ip.toString());
			String name = ip.getHostName(); 
			System.out.println("Host name: "+name);
			name=ip.getCanonicalHostName();	
			System.out.println("Host Nombre Completo: "+name);
		}catch(UnknownHostException e){
			e.printStackTrace();
		}
	}
}
