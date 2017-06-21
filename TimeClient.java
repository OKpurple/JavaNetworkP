import java.nio.channels.*;
import java.nio.*;
import java.net.*;

public class TimeClient  {
	public static void main(String[] args) {
		try (SocketChannel server = SocketChannel.open(new InetSocketAddress("127.0.0.1", 5000))){
			ByteBuffer buffer = ByteBuffer.allocate(64);
			int byteRead = server.read(buffer);
			while (true){
				buffer.flip();
				while(buffer.hasRemaining()){
					System.out.print((char) buffer.get());
				}
				System.out.println();
				byteRead=server.read(buffer);
			}
		} catch (Exception e){

		}
	}
}