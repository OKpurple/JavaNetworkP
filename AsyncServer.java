import java.nio.channels.*;
import java.nio.*;
import java.util.Date;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.io.IOException;

public class AsyncServer{
	public AsyncServer(){
		System.out.println("Async Server Starting");
		try(AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open()){
			InetSocketAddress address = new InetSocketAddress("127.0.0.1", 5000);
			server.bind(address);

			System.out.println("waiting for the client");
			Future<AsynchronousSocketChannel> acceptResult = server.accept();

			System.out.println("not blocked");

			AsynchronousSocketChannel client = acceptResult.get();
			System.out.println("Client connected");
			while(true) {
				ByteBuffer buffer = ByteBuffer.allocate(64);
				Future result = client.read(buffer);

				int i = 0;
				while(!result.isDone()){
					System.out.println(i);
					i++;
					Thread.sleep(100);
				}
				buffer.flip();
				String message = new String(buffer.array());
				System.out.println(message);
				if (message.trim().equals("quit")) break;

			} 
		} catch( IOException | InterruptedException |ExecutionException e){

		} 
	}

	public static void main(String[] args) {
		new AsyncServer();
	}


}