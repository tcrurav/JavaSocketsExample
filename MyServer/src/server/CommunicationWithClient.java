package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CommunicationWithClient extends Thread{
	Socket socket;

	public CommunicationWithClient(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		infoInterchange();
	}
	
	private void infoInterchange() {
		try {
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);

			String message = "";
			final String EXIT = "EXIT";

			do {
				message = dis.readUTF();
				System.out.println("Recieved from Client: " + message);
				dos.writeUTF("Received. Any other message? (EXIT to finish)");
				dos.flush();
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
