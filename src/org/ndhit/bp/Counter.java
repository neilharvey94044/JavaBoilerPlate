package org.ndhit.bp;

/**
 * @author nharvey
 *
 */
public class Counter {
	private int i = 0;
	
	
	/**
	 * Remove synchronized to see anomaly from non-threadsafe code
	 */
	public synchronized int increment() {
		return i = i +1;
	}
	
	/**
	 * Remove synchronized to see anomoly from non-threadsafe code
	 */
	public synchronized int getIncrement() {
		return i;
	}

}
