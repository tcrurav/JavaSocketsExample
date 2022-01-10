package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClientSocket {
	final String HOST = "localhost";
	final int PORT = 50000; 
	
	Socket socket;
	
	MyClientSocket(){
		try {
			socket = new Socket(HOST, PORT);
			
			infoInterchange();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void infoInterchange() {
		try {
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			String messageFromServer = dis.readUTF();
			
			System.out.println(messageFromServer);
			
			dis.close();
			is.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
