package multiThread;

import javax.swing.JFrame;



class Luong1 extends Thread {
		String ten;
		Luong1(ThreadGroup tg, String _ten){
			super(tg, _ten);
			ten = _ten;
		}
		
		public void run() {
			for (int i = 0; i <= 200; i++) {
				try {
					System.out.println("Tên luồng: " + ten + " xin chào: " + i);
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
class Luong2 extends JFrame implements Runnable {
		String ten;
		
		Luong2(String _ten){
			ten = _ten;
		}
		
		public void run() {
			for (int i = 0; i <= 200; i++) {
				try {
					double k = Math.pow(3, 7);
					System.out.println("==== Meow ====");
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
public class lesson2 {
	public static void main(String[] args) {
		ThreadGroup tgroup1 = new ThreadGroup("nhom1");
		Luong1 l1 = new Luong1(tgroup1, "Luong A");
		Luong1 l3 = new Luong1(tgroup1, "Luong B");
		Luong2 r2 = new Luong2("Luong 2");
		
		Thread l2 = new Thread(r2);
		l2.setName("abcd");

		System.out.println("L2 là: " + l2.getName());
		l1.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println("L1 ID: " + l1.getId() + " ưu tiên: " + l1.getPriority() + " ");
		l1.start();
		l2.start();
		l3.start();
	}

}
