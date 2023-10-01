package multiThread; // MyApplet.java

import java.applet.Applet;
import java.awt.*;


public class lesson13 extends Applet implements Runnable {
	Thread t;
	int k;
	
	public void init() {
		t = new Thread(this);
		t.start();
	}
	
	public void paint(Graphics g) {
		g.drawString("i= " + k, 30, 30);
	}
	
	public void run() {
		for (int i = 0; i <= 20; i++) {
			try {
				k++;
				System.out.println("chay");
				repaint();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

