import java.nio.channels.*;
import java.nio.*;
import java.util.Date;
import java.net.*;

public class TimeServer  {
	public static void main(String[] args) {
		try{
			ServerSocketChannel server = ServerSocketChannel.open();
			server.socket().bind(new InetSocketAddress(5000));

			while(true){
				String message = "Date: " + new Date(System.currentTimeMillis());
				System.out.println("Message : "+message);
				System.out.println("waiting for clients...");
				SocketChannel client = server.accept();
			//blocking
				while(true){
					if (client != null){
						ByteBuffer buffer = ByteBuffer.allocate(16);

						message = "Date: " + new Date(System.currentTimeMillis());

						buffer.put(message.getBytes());
						buffer.flip();

						while(buffer.hasRemaining()){
							client.write(buffer);
						}

					}
					Thread.sleep(1000);
				}
			}
		}catch (Exception e){}

	}
}