package multiThread; //DemMoSapxep.java

import javax.swing.JFrame;

class SapxepTang extends Thread {
	int MT[];
	
	SapxepTang(int M[]){
		MT = M;
	}
	
	public void setData(int M[]) {
		MT = M;
	}
	
	public void run() {
		for (int i = 0; i < MT.length - 1; i++) {
			for (int j = i + 1; j < MT.length; j++) {
				if(MT[j] < MT[i]) {
					int tg = MT[j];
					MT[j] = MT[i];
					MT[i] = tg;
				}
				
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Run luong 1");
			}
		}
	}
	
	synchronized int[] getData() {
		return MT;
	}
}


class SapxepGiam extends JFrame implements Runnable {
	int MG[];
	
	SapxepGiam(int M[]){
		MG = M;
	}
	
	public void run() {
		for (int i = 0; i < MG.length -1; i++) {
			for (int j = i + 1; j < MG.length; j++) {
				if(MG[j] > MG[i]) {
					int tg = MG[i];
					MG[j] = MG[i];
					MG[i] = tg;
				}
				
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Run luong 2");
			}
		}
	}
	
	synchronized int[] getData() {
		return MG;
	}
}


public class lesson9 {

	public static void main(String[] args) {
		int M[] = {2, 6, 1, 4, 7, 1};
		int M1[] = {5, 2, 1, 2, 9, 6};
		SapxepTang l1 = new SapxepTang(M);
		SapxepGiam r2 = new SapxepGiam(M1);
		
		Thread l2 = new Thread(r2);
		l1.start();
		l2.start();
		
		try {
			System.out.println("Waiting for threads to finish.");
			l1.join();
			l2.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int MT[] = l1.getData();
		int MG[] = r2.getData();
		
		for (int i = 0; i < MG.length; i++) {
			System.out.println(MT[i] + " ");
		}
		
		System.out.println();
		for (int i = 0; i < MG.length; i++) {
			System.out.println(MG[i] + " ");
		}
	}

}



