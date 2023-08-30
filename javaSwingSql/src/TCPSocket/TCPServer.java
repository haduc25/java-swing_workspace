package TCPSocket;

import java.net.*;
import java.io.*;
import java.util.*;

public class TCPServer {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(5000);
			System.out.println("Waiting for Client...");
			Socket server = ss.accept();
			System.out.println("Server is connected!");
			
			// Send data from Server to Client
			Scanner sc = new Scanner(System.in);
			PrintWriter pw = new PrintWriter(server.getOutputStream());
			
			while(true) {
				System.out.print("Enter Data: ");
				String data = sc.nextLine();
				pw.println(data);
				pw.flush();
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
