public class StopWatch {
	private long startTime;
	private long endTime;
	private long elapsed;
	public static void main(String[] args) {
		double sumNum = 0;
		StopWatch stopwatch = new StopWatch();
		for(int i = 0; i <= 1000; i++) {
			sumNum += i;
		}
		stopwatch.stop();
		long period = stopwatch.getElapsedTime();
		System.out.println(period);
	}

	public StopWatch() {
		startTime = System.currentTimeMillis();
	}

	public void start() {
		startTime = System.currentTimeMillis();
	}

	public void stop() {
		endTime = System.currentTimeMillis();
	}

	public long getElapsedTime() {
		elapsed = this.endTime - this.startTime;
		return elapsed;
	}
}