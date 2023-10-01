package multiThread; // VD11.java
import java.util.Iterator;

class Lop11 implements Runnable {
	public void run() {
		for (int i = 0; i <= 200; i++) {
			try {
				Thread.sleep(500);
				System.out.println("Luồng thực thi lớp 1: " + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


class Lop12 implements Runnable {
	public void run() {
		for (int i = 0; i <= 200; i++) {
			try {
				Thread.sleep(500);
				System.out.println("Luồng thực thi lớp 2: " + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


public class lesson6 {
	public static void main(String[] args) {
		Lop11 r1 = new Lop11();
		Lop12 r2 = new Lop12();
		
		Thread luong1 = new Thread(r1);
		Thread luong2 = new Thread(r2);
		
		luong1.start();
		luong2.start();
	}
}


