package edu.eci.arsw.primefinder;

import java.io.IOException;
import java.security.Timestamp;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
            
            
//            // Question 1
//            PrimeFinderThread pft1=new PrimeFinderThread(0, 30000000);
//            pft1.start();
		
            
//            // Question 2
//            PrimeFinderThread pft1=new PrimeFinderThread(0, 30000000);
//            PrimeFinderThread pft2=new PrimeFinderThread(0, 30000000);
//            PrimeFinderThread pft3=new PrimeFinderThread(0, 30000000);
//
//            pft1.start();
//            pft2.start();
//            pft3.start();

            // Question 3
            
            PrimeFinderThread pft1=new PrimeFinderThread(0, 30000000);
            PrimeFinderThread pft2=new PrimeFinderThread(0, 30000000);
            PrimeFinderThread pft3=new PrimeFinderThread(0, 30000000);

            pft1.start();
            pft2.start();
            pft3.start();
            long loopTimestamp = System.currentTimeMillis();
            
            while(true){
                if(System.currentTimeMillis() - loopTimestamp > 5000){
                    pft1.pauseThread();
                    pft2.pauseThread();
                    pft3.pauseThread();
                    System.in.read();
                    pft1.resumeThread();
                    pft2.resumeThread();
                    pft3.resumeThread();
                    loopTimestamp = System.currentTimeMillis();
                }
                
                
            }
		
		
	}
	
}
