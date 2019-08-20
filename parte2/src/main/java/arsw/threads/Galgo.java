package arsw.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Un galgo que puede correr en un carril
 * 
 * @author rlopez
 * 
 */
public class Galgo extends Thread {
	private int paso;
	private Carril carril;
	RegistroLlegada regl;
        
        private static Lock lock = new ReentrantLock();
        public static Lock pauseLock = new ReentrantLock();
        public static boolean isPaused = false;

	public Galgo(Carril carril, String name, RegistroLlegada reg) {
		super(name);
		this.carril = carril;
		paso = 0;
		this.regl=reg;
	}

	public void corra() throws InterruptedException {
		while (paso < carril.size()) {
                    synchronized(pauseLock){
                        while(isPaused){
                            pauseLock.wait();
                        }
                    }
                    
                    Thread.sleep(100);
                    carril.setPasoOn(paso++);
                    carril.displayPasos(paso);

                    if (paso == carril.size()) {						
                            carril.finish();
                            synchronized(lock){
                                int ubicacion=regl.getUltimaPosicionAlcanzada();
                                regl.setUltimaPosicionAlcanzada(ubicacion+1);
                                System.out.println("El galgo "+this.getName()+" llego en la posicion "+ubicacion);
                                if (ubicacion==1){
                                        regl.setGanador(this.getName());
                                }
                            }
                    }
		}
	}


	@Override
	public void run() {
		
		try {
			corra();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
        

}
