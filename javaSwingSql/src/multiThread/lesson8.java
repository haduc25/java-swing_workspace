package multiThread; //YieldThreadExample.java

import java.util.Date; 

/* @Override
 * Override trong Java là gì? Overriding là một tính năng trong lập trình hướng đối tượng Java, 
 * cho phép một lớp con cung cấp một định nghĩa mới cho một phương thức đã được định nghĩa trong lớp cha của nó. 
 * Quá trình này giúp lớp con mở rộng hoặc thay đổi hành vi của lớp cha mà không làm thay đổi mã nguồn của lớp cha.
 * 
 * 
 * 
 */

public class lesson8 {
	private static Date importantEndTime;
	private static Date unImportantEndTime;

	public static void main(String[] args) {
		importantEndTime = new Date();
		unImportantEndTime = new Date();
		
		System.out.println("Create thread 1");
		
		Thread importantThread = new ImportantThread();
		
		// Sét đặt độ ưu tiên cao nhất cho thread này.
		importantThread.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println("Create thread 2");
		
		Thread unImportantThread = new UnImportantThread();
		
		// Sét đặt độ ưu tiên thấp nhất cho thread này.
		unImportantThread.setPriority(Thread.MIN_PRIORITY);
		
		// Start threads
		unImportantThread.start();
		importantThread.start();
	}
	
	// Một nhiệm vụ quan trọng, yêu cầu độ ưu tiên cao.
	static class ImportantThread extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 100000; i++) {
				System.out.println("\n Important work " + i);
				
				// Thông báo với hệ điều hành,
                // thread này nhường quyền ưu tiên cho các luồng khác.
				Thread.yield();
			}
			
			// Thời điểm kết thúc của thread này.
			importantEndTime = new Date();
			printTime();
		}
	}

	
	static class UnImportantThread extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 100000; i++) {
				System.out.println("\n  -- UnImportant work: " + i);
			}
			
			// Thời điểm kết thúc của thread này.
			unImportantEndTime = new Date();
			printTime();
		}
	}
	
	private static void printTime() {
		// Khoảng thời gian (Mili giây)
		long interval = unImportantEndTime.getTime() - importantEndTime.getTime();
		
		System.out.println("UnImportant Thread - Important Thread = " + interval + " milliseconds");
	}
}