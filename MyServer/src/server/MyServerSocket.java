package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {
	final int PORT = 50000;
	ServerSocket serverSocket;
	Socket socket;

	MyServerSocket() {
		try {
			serverSocket = new ServerSocket(PORT);
			do {
				socket = serverSocket.accept();
				
				CommunicationWithClient cc = new CommunicationWithClient(socket);
				cc.start();
			} while (true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
