import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
public class MyClientSocket {
    public Socket socket;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));



    private Scanner scanner;
    public MyClientSocket(InetAddress serverAddress, int serverPort) throws Exception {
        this.socket = new Socket(serverAddress, serverPort);
        this.scanner = new Scanner(System.in);
    }

    public void start() throws IOException {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        String serverMsg, clientMsg = "";

        while (!clientMsg.equals("2")) {
            serverMsg = in.readLine();
            System.out.println("number of clients = " + serverMsg);
            System.out.print("Type 1 to continue, 2 to exit \n->");
            clientMsg =br.readLine();
            out.println(clientMsg);
            out.flush();

            }
        System.out.println("Disconnected !");

        }


    public static void main(String[] args) throws Exception {
        MyClientSocket client = new MyClientSocket( InetAddress.getLocalHost(),1027);
        System.out.println("\r\nConnected to Server: " + client.socket.getInetAddress());
        client.start();
    }
}