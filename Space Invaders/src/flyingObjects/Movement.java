package flyingObjects;

public abstract class Movement {
	
	int speed;
	Thread movement;
	
	public Movement(int speed) {
		this.speed = speed;
		movement = new Thread(new Runnable() {
			public void run() {
				while (true) {
					System.out.println("Thread is now working!");
					oneCycle();
					sleep(speed);
				}
			}
		});
	}
	
	public void start() {
		movement.start();
		System.out.println("start()");
	}
	
	private void sleep(int speed) {
		try {
			Thread.sleep(1000 / speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected abstract void oneCycle();
}
