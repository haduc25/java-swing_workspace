package multiThread; // DemoJoin.java

/* Thread.isAlive()
 * trả về true nếu thread này là alive, mà là bất cứ thời gian nào sau khi thread này đã 
 * được bắt đầu nhưng trước khi nó run tới khi kết thúc
 */

class JoinThread implements Runnable {
	Thread t;
	String name; // tên thread
	
	public JoinThread(String threadName) {
		name = threadName;
		t = new Thread(this, name);
		System.out.println("New thread: " + t);
		t.start(); //Start the thread
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 100; i++) {
				System.out.println(name + ": " + i);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + " exiting.");
	}
	
}

public class lesson10 {

	public static void main(String[] args) {
		JoinThread thread1 = new JoinThread("Thread 1");
		JoinThread thread2 = new JoinThread("Thread 2");
		JoinThread thread3 = new JoinThread("Thread 3");

		System.out.println("Thread 1 is alive: " + thread1.t.isAlive());
		System.out.println("Thread 2 is alive: " + thread3.t.isAlive());
		System.out.println("Thread 3 is alive: " + thread3.t.isAlive());
		
		// Chờ các thread kết thúc
		try {
			System.out.println("Waiting for threads to finish.");
			thread1.t.join();
			thread2.t.join();
			thread3.t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("Thread 1 is alive: " + thread1.t.isAlive());
	     System.out.println("Thread 2 is alive: " + thread2.t.isAlive());
	     System.out.println("Thread 3 is alive: " + thread3.t.isAlive());
	     System.out.println("Main thread exiting.");
	}

}
