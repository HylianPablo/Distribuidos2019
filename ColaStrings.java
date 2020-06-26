package ejemplo.Servidor;

import java.util.*;

public class ColaStrings{
	private ArrayList<String> lista = new ArrayList<>();

	public synchronized void push(final String p){
		lista.add(p);
		this.notify(); //Da información de que ha llegado el String
	}

	public synchronized String pop(){
		while(lista.size()==0){
			try{this.wait();
			}catch(final InterruptedException e){}
		}
		return lista.remove(0);
	}

	public boolean estaVacia(){
		return lista.isEmpty();
	}
}

