package TCPSocket;

import java.net.*;
import java.io.*;

public class TCPServer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String xauNhan, xauGui;
			
			ServerSocket ss = new ServerSocket(6789);
			System.out.println("wait for client...");
			Socket server = ss.accept();
			System.out.println("server connected!");
			
			BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(server.getInputStream()));
			DataOutputStream outputToClient = new DataOutputStream(server.getOutputStream());
			
			while(true) {
				xauNhan = inputFromClient.readLine();
				System.out.println("Du Lieu Nhan tu Client: " + xauNhan);
			    xauGui = xauNhan.toUpperCase() + '\n';
			    outputToClient.writeBytes(xauGui);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
