package vna00_J_CSS;

final class ControlledStop implements Runnable { 
	
	private boolean done = false;

	@Override public void run() { 
		while (!isDone()) {
			try {
				// ...
				Thread.currentThread().sleep(1000); // Do something 
				shutdown();
				System.out.println(Thread.currentThread().getName());
				} catch(InterruptedException ie) {
				Thread.currentThread().interrupt(); // Reset interrupted status
			}
		}
	}
	
	public synchronized boolean isDone() { 
				return done;
	}

	public synchronized void shutdown() { 
				done = true;
	}
	
    public static void main(String[] args) throws Exception { 
		
		for (int i = 0; i < 5; i++) {
			ControlledStop cnTest = new ControlledStop();
			Thread t = new Thread (cnTest);
			t.start();
		}
	}
}
