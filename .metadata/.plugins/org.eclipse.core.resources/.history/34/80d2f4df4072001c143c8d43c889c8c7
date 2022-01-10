package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServerSocket {
	final int PORT = 50000;
	ServerSocket serverSocket;
	Socket socket;
	
	MyServerSocket(){
		try {
			serverSocket = new ServerSocket(PORT);
			socket = serverSocket.accept();
			
			infoInterchange();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void infoInterchange() {
		try {
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			//InputStream is = socket.getInputStream();
			//DataInputStream dis = new DataInputStream(is);
			
			Scanner sc = new Scanner(System.in);
			
			String mensaje = sc.nextLine();
			
			dos.writeUTF(mensaje);
			dos.flush();
			
			dos.close();
			os.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
