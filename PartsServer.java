import java.util.*;
import java.nio.channels.*;
import java.net.*;
import java.io.IOException;

public class PartsServer{
	private static final HashMap<String, Integer> db  = new HashMap<>();

	public void init(){
		db.put("Hammer", 5000);
		db.put("Driver", 4000);
		db.put("Wrench", 10000);

	}

	public PartsServer(){
		System.out.println("PartsServer Started");
		init();

		try{
			ServerSocketChannel server = ServerSocketChannel.open();
			server.socket().bind(new InetSocketAddress(5000));

			boolean on = true;
			while (on){
				System.out.println("waiting for clients...");
				SocketChannel client = server.accept();

				new Thread(new ClientHandler(client)).start();

			}
		} catch (IOException e){

		}
	}

	public static int getPrice(String name){
		return db.get(name);
	}

	public static void main(String[] args) {
		new PartsServer();
	}
}