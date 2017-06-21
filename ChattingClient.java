import java.nio.channels.*;
import java.nio.*;
import java.net.*;
import java.util.*;

public class ChattingClient {
	public static void main(String[] args) {
		try (SocketChannel server = SocketChannel.open(new InetSocketAddress("127.0.0.1", 5000))){
			String msg;
			Scanner scanner = new Scanner(System.in);
			while (true){
				// System.out.println("msg from server :"+HelperMethods.receiveFixedLengthMessage(server));
				System.out.println("msg from server :"+HelperMethods.receiveMessage(server));

				System.out.print("input : ");
				msg = scanner.nextLine();
				if (msg.equals("quit")) {
					break;
				} else {
					// HelperMethods.sendFixedLengthMessage(server, msg);
					HelperMethods.sendMessage(server, msg);

				}
			}

		} catch (Exception e){

		}			
	}
}