package TCPSocket;

import java.io.*;
import java.net.*;

public class TCPClient {

	public static void main(String[] args) {
		try {
			Socket client = new Socket("localhost", 5000);
			System.out.println("Client is connected!");

			// Read data from Server
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while(true) {
				String data = br.readLine();
				System.out.println("Data from Server: " + data);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
