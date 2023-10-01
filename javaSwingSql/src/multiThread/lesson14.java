package multiThread; //MyThread.java
import java.io.*;

public class lesson14 extends Thread {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println("The current Thread is: " + t);
		t.setName("MyJavaThread");
		System.out.println("The thread is now named: " + t);

		try {
			for(int i = 0; i <3;i++){
				System.out.println(i);
				Thread.sleep(1500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
