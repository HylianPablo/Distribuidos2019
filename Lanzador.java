package ejemplo.threads;

public class Lanzador{
	public static void main(String args[]){
		Runnable tarea1 =new Reloj("Pedro",1000);
		Runnable tarea2 =new Reloj("	Pablo",2100);
		Thread trabajador1 = new Thread(tarea1,"hilo de tarea1 Reloj");
		Thread trabajador2 = new Thread(tarea2,"hilo de tarea2 Reloj");

		trabajador1.start();	//Pero esto llama al run del padre Thread
		trabajador2.start();	//Pero esto llama al run del padre Thread

		//Al ejecutar utilizar . y no / en la ruta del paquete, pues no es un directorio

	}
}
