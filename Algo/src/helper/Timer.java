package helper;

import java.util.concurrent.TimeUnit;

public class Timer {
	private long startTime;
	private long endTime;
	
	public Timer() {
		startTime = System.nanoTime();
		endTime = startTime;
	}
	
	public void start() {
		startTime = System.nanoTime();
	}
	
	public void end() {
		endTime = System.nanoTime();
	}
	
	public long getDiffNanos() {
		return endTime - startTime;
	}

	public long getDiffMillis() {
		return TimeUnit.NANOSECONDS.toMillis(getDiffNanos());
	}

	public long getDiffSeconds() {
		return TimeUnit.NANOSECONDS.toSeconds(getDiffNanos());
	}
	
	
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
