package TCPSocket;

import java.net.*;
import java.io.*;

public class TCPClient3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String sentence = "hello";
		String modifiedSentence = null;
		
		Socket client = new Socket("TONGUYENCNTT", 90);
		BufferedReader inputFromUser = new BufferedReader(new InputStreamReader(System.in));
		DataInputStream inputFromServer = new DataInputStream(client.getInputStream());
		DataOutputStream outputToServer = new DataOutputStream(client.getOutputStream());
	
		
		while(!sentence.equalsIgnoreCase("exit")) {
			System.out.print("Nhập vào xâu gửi: ");
			sentence = inputFromUser.readLine();
			outputToServer.writeBytes(sentence + '\n');
			
			String kq = inputFromServer.readLine();
			System.out.println(kq);
		}
		client.close();
		
	}

}
