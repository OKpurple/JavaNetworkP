import java.nio.channels.*;
import java.nio.*;
import java.util.Date;
import java.net.*;
import java.util.*;

public class ChattingServer {
	public static void main(String[] args) {
		try{
			ServerSocketChannel server = ServerSocketChannel.open();
			server.socket().bind(new InetSocketAddress(5000));

			boolean on = true;
			while (on){
				System.out.println("waiting for clients...");
				SocketChannel client = server.accept();

				System.out.println("client connected");
				String msg;
				Scanner scanner = new Scanner(System.in);
				while (true){
					//send to client
					System.out.print("input : ");
					msg = scanner.nextLine();
					if (msg.equals("quit")){
						on = false;
						break;
					} else {
						// HelperMethods.sendFixedLengthMessage(client, msg);
						HelperMethods.sendMessage(client, msg);
						System.out.println("Sent msg : "+msg);
						// System.out.println("Received msg : " + HelperMethods.receiveFixedLengthMessage(client));
						System.out.println("Received msg : " + HelperMethods.receiveMessage(client));
					}
				}




			}
		} catch (Exception e){

		}

	}
}