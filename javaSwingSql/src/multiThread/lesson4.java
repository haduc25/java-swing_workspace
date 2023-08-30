package multiThread; // VD2.java

class RunX implements Runnable{
	private String prefix="";
	
	public RunX(String _prefix) {
		prefix = _prefix;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				System.out.println(prefix + i);
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class lesson4 {
	public static void main(String[] args) {
		RunX r1 = new RunX("Luồng thứ 1: ");
		RunX r2 = new RunX("Luồng thứ 2: ");
		RunX r3 = new RunX("Luồng thứ 3: ");
		RunX r4 = new RunX("Luồng thứ 4: ");
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		Thread t4 = new Thread(r4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
