package TCPSocket;

import java.net.*;
import java.io.*;

public class TCPServer3 {

	public static void main(String[] args) throws Exception {
		String xauNhan;
		
		ServerSocket ss = new ServerSocket(6789);
		System.out.println("wait for client...");
		Socket server = ss.accept();
		System.out.println("server connected!");
		
		BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(server.getInputStream()));
		DataOutputStream outputToClient = new DataOutputStream(server.getOutputStream());
		
		while(true) {
			xauNhan = inputFromClient.readLine();
			System.out.println("Dữ liệu nhận từ Client: " + xauNhan);
			outputToClient.writeBoolean(kiemTraDoiXung(xauNhan));
		}
	}
	
	public static boolean kiemTraDoiXung(String str) {
		if(str == null || str.length() == 1) return false;
		
		for (int i = 0; i < str.length() / 2; i++) {
			System.out.println("i= " + i + " k= " + (str.length()-i-1));
			if(str.charAt(i) != str.charAt(str.length()-i-1)) return false;
		}
		return true;
	}

}
