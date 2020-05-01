package eu.ase.httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPMultiThreadServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		boolean listening = true;
		
		try {
			int port = 4444; //Integer.parseInt(args[0]);
			serverSocket = new ServerSocket(port);
			System.out.println("Serverul de web DICE ruleaza in port TCP = "+port);
			while(listening) {
				try {
					Socket client = serverSocket.accept();
					
					HTTPMultiThreadServerClient objClient = new HTTPMultiThreadServerClient(client);
					objClient.start();
					
					//client.close();//NOOOOOOOOOOOOOOOOOO
				} catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
