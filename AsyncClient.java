import java.nio.channels.*;
import java.nio.*;
import java.util.Date;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.io.IOException;

public class AsyncClient{
	public AsyncClient(){
		System.out.println("Client Starting");
		try (AsynchronousSocketChannel client = AsynchronousSocketChannel.open() ){
 			InetSocketAddress address = new InetSocketAddress("127.0.0.1", 5000);

 			Future connectResult = client.connect(address);

 			connectResult.get();

 			System.out.println("Client Connected");
 			Scanner scanner = new Scanner(System.in);
 			while(true){
 				System.out.print(">");
 				String message = scanner.nextLine();
 				ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
 				
 				Future result  = client.write(buffer);

 				System.out.println("playing");

 				while(!result.isDone()){

 				}

 				if (message.equals("quit")){
 					break;
 				}


 			}

		} catch (Exception e){

		}
	}

	public static void main(String[] args) {
		new AsyncClient();
	}
}