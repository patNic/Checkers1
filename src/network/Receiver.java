package network;

import java.io.ObjectInputStream;
import java.net.Socket;

/*import checkers_entities.Tile;
import checkers_gui.Board;*/

public class Receiver extends Thread {
	private Socket socket;
	private Object obj;
	public Receiver(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		while(true) {
			try {
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				System.out.println("waiting to receive . . .");
				obj = in.readObject();
				
				/*Tile tile = (Tile) obj;
				Board.ownTile = tile;
				System.out.println("\n==I received tile with id "+tile.getTilePiece().getPieceId());*/
			}catch(Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
		
	}
	public Object getObjectReceived() {
		return obj;
	}
	public void setObjectNull() {
		obj = null;
	}
}
