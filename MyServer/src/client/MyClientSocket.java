package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

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
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			String messageFromServer;
			String message;
			Scanner sc = new Scanner(System.in);
			final String EXIT = "EXIT";
			
			System.out.println("Any message to send? (EXIT to finish");
			do {
				message = sc.nextLine();
				dos.writeUTF(message);
				dos.flush();
				messageFromServer = dis.readUTF();
				System.out.println("message from server: " + messageFromServer);
			} while (!message.equals(EXIT));
			
			dos.close();
			os.close();
			
			dis.close();
			is.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
