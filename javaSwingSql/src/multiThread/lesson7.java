package multiThread; // WaitNotifyDemo.java

/* synchronized
 * Một khối `Synchronized` block đánh dấu một phương thức hay một khối mã là được đồng bộ. 
 * Sử dụng khối đồng bộ trong Java có thể tránh xảy ra xung đột.
 * 
 * https://viblo.asia/p/java-synchronized-blocks-jlA7GK04vKZQ
 */

class Q{
	int n;
	boolean valueSet = false;
	synchronized int get() {
		while(!valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Got: " + n);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		valueSet = false;
		notify();
        return n;
	}
	
	synchronized void put(int n) {
		try {
			while(valueSet) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.n = n;
			valueSet = true;
			System.out.println("Put: " + n);
			Thread.sleep(500);
			notify();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Producer implements Runnable {
	Q q;
	Producer(Q _q){
		this.q = _q;
		new Thread(this, "Producer").start();
	}
	
	public void run() {
		int i = 0;
		while(true) {
			q.put(i++);
		}
	}
}

class Consumer implements Runnable {
	Q q;
	Consumer(Q _q){
		this.q = _q;
		new Thread(this, "Consumer").start();
	}
	
	public void run() {
		while(true) {
			q.get();
		}
	}
}

public class lesson7 {

	public static void main(String[] args) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		System.out.println("Press Control-C to stop.");
	}

}
