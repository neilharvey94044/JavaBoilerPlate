/**
 * 
 */
package org.ndhit.bp;

/**
 * @author Neil Harvey
 *
 */
public class BoilerPlateThreads {

	public static void bpThreadRun() {
		
		// test primitive protection using synchronized
		BoilerPlateThreads.bpPrimitiveSynchronizedTest();
	}
	
	/*
	 * Demonstrates how synchronized protects operations on a primitive type
	 * and what goes wrong when it's not used.
	 */
	public static void bpPrimitiveSynchronizedTest() {
		
		Counter c = new Counter();
		final int REPEAT = 10_000_000;
		
		
		Runnable r = () -> {
			for(int i =0; i < REPEAT; i++) {
				c.increment();
			}
		};
		

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		}
		catch (InterruptedException e) {
			System.out.println(e);
		}
		int anomoly = (2 * REPEAT) - c.getIncrement();
		double perc = ((anomoly +0.0) * 100)/ (2 * REPEAT);
		System.out.println("Updates: " + c.getIncrement() + " Lost updates: " + anomoly + " ; % = " + perc);
	}
	
	
}
