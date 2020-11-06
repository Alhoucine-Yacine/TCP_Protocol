import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client2 {


        public static void main (String[] args) throws Exception {
            MyClientSocket client = new MyClientSocket( InetAddress.getLocalHost(),1027);
            System.out.println("\r\nConnected to Server: " + client.socket.getInetAddress());
            client.start();

        }

}
