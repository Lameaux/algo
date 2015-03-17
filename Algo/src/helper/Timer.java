package helper;

import java.util.concurrent.TimeUnit;

/**
 * Measure execution time
 * @author sergii.sizov
 *
 */
public class Timer {
	private long startTime;
	private long endTime;
	
	public Timer() {
		startTime = System.nanoTime();
		endTime = startTime;
	}
	
	/**
	 * (Re)start timer
	 */
	public void start() {
		startTime = System.nanoTime();
	}
	
	/**
	 * Stop timer
	 */
	public void end() {
		endTime = System.nanoTime();
	}
	
	/**
	 * Interval in nanos
	 * @return
	 */
	public long getDiffNanos() {
		return endTime - startTime;
	}

	/**
	 * Interval in millis
	 * @return
	 */
	public long getDiffMillis() {
		return TimeUnit.NANOSECONDS.toMillis(getDiffNanos());
	}

	/**
	 * Interval in seconds
	 * @return
	 */
	public long getDiffSeconds() {
		return TimeUnit.NANOSECONDS.toSeconds(getDiffNanos());
	}
	
	/**
	 * Prints user-friendly result depending on the size
	 * @return
	 */
	public String getDiffNicely() {
		
		long seconds = getDiffSeconds();
		if (seconds > 0) {
			return seconds + " s";
		}
		long millis = getDiffMillis();
		if (millis > 0) {
			return millis + " ms";
		}
		return getDiffNanos() + " ns";		
		
	}
	
}
