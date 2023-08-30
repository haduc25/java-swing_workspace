package multiThread; // VD2.java


class ThreadX extends Thread {
	private String ten = "";
	
	public ThreadX(String _ten) {
		ten = _ten;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				System.out.println("Tên luồng: " + ten +  i);
				System.out.println("Độ ưu tiên " + this.getPriority());
				System.out.println();
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


public class lesson3 {
	
	public static void main(String[] args) {
		ThreadX t1 = new ThreadX("Luồng thứ 1: ");
		ThreadX t2 = new ThreadX("Luồng thứ 2: ");
		ThreadX t3 = new ThreadX("Luồng thứ 3: ");
		
		t1.setName("Luồng 1");
		t2.setName("Luồng 2");
		t3.setName("Luồng 3");
		
		System.out.println("ID luồng 1: " + t1.getId());
		System.out.println("ID luồng 2: " + t2.getId());
		System.out.println("ID luồng 3: " + t3.getId());
		
		System.out.println("Tên luồng 1: " + t1.getName());
		System.out.println("Tên luồng 2: " + t2.getName());
		System.out.println("Tên luồng 3: " + t3.getName());
		
		t3.setPriority(Thread.MAX_PRIORITY);
		t1.setPriority(1);
		t2.setPriority(5);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
