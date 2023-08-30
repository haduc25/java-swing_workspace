package multiThread; // VD001.java

import javax.swing.JFrame;

//Luong 01
class Luong01 extends Thread {
	String ten;
	
	Luong01 (String _ten){
		super(_ten);
		ten = _ten;
	}
	
	public void run() {
		for (int i = 0; i < 200; i++) {
			try {
				System.out.println("Luồng " + ten + " xin chào: " + i);
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

//Luong 02
class Luong02 extends JFrame implements Runnable {
	
	String ten;
	
	Luong02(String _ten){
		ten = _ten;
	}
	
	public void run() {
		for (int i = 0; i < 200; i++) {
			try {
				double k = Math.pow(3, 7);
				System.out.println("Meow");
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class lesson1 {
	public static void main(String[] args) {
		Luong01 l1 = new Luong01("Minh");
		Luong01 l3 = new Luong01("Duc");
		
		Luong02 r2 = new Luong02("Luong 02");
		Thread l2 = new Thread(r2);
		
		l1.start();
		l3.start();
		l2.start();
	}
}
