package ejemplo.threads;

public class Reloj implements Runnable{

	private final String nombre;
	private final long delta;

	public Reloj(String n, long d){
		nombre=new String(n);
		delta=d;
	}

	public void run(){
		while(true){
			System.out.println(nombre+" : "+new java.util.Date());
			try{ Thread.sleep(delta);	//ms
			}catch(InterruptedException x){
				System.err.println("Reloj.run: Imterrupted," + x.getMessage());
			}
		}
	}

}
