package multiThread; //DoanSo.java

class Thread1 extends Thread {
	int num;
    String name;

    public Thread1(int _num, String _name) {
        name = _name;
        num = _num;
    }

    public void run() {
        int count=0;
        while (true) {
            try{
          int randomNumber = (int) (Math.random() * 100 + 1);
                System.out.println("Thread " + name + " doan: "+ randomNumber);
            Thread.sleep(1);
            
          if(randomNumber==num){
              count++;
              System.out.println(name + " doan trung " + count + " lan");
          }
            }catch(InterruptedException e){
                
            }
          if(count==10) break;
        }
    }
}

class Thread2 extends Thread{
	public void run() {
		
	}
}

public class lesson12 {

	public static void main(String[] args) {
		Thread1 L1=new Thread1(34,"Thread1");
		Thread1 L2=new Thread1(34,"Thread2");
		L1.start();
		L2.start();
	}

}
