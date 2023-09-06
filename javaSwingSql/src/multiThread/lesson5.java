package multiThread; // VD3.java

class RunX2 implements Runnable {
	private String prefix;
	public RunX2(String _prefix) {
		prefix = _prefix;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(prefix + i);
		}
	}
}

public class lesson5 {
	public static void main(String[] args) {
		// TODO Auto-generated
		RunX2 r1 = new RunX2("Luồng thứ 1: ");
		RunX2 r2 = new RunX2("Luồng thứ 2: ");
		RunX2 r3 = new RunX2("Luồng thứ 3: ");
		RunX2 r4 = new RunX2("Luồng thứ 4: ");

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
