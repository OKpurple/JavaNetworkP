import java.nio.channels.*;
import java.net.*;
import java.io.IOException;
import java.util.*;

public class PartsClient{

	public PartsClient(){
		System.out.println("Client Started");
		SocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);
		Scanner scanner = new Scanner(System.in);


		try(SocketChannel server = SocketChannel.open(serverAddress)){
			System.out.println("Connected to Server");
			while (true) {
				System.out.print("Enter part name:");
				String name = scanner.nextLine();
				HelperMethods.sendMessage(server, name);
				System.out.println("Price is : "+HelperMethods.receiveMessage(server));



			}
			
		}catch (IOException e){

		}
	}

	public static void main(String[] args) {
		new PartsClient();
	}

}