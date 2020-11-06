import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ReadThred extends Thread {
    MyServerSocket server;
    BufferedReader in;
    PrintWriter out;
    Socket connection;
    private Scanner scanner;


    public void setServer (MyServerSocket server) {
        this.server=server;

    }

    public int getNbClients(){
        return this.server.getNbClients();
    }

    public ReadThred(Socket connection)  {
        try {
            this.connection = connection;
            InputStream in = connection.getInputStream();
            OutputStream out = connection.getOutputStream();
            this.in = new BufferedReader(new InputStreamReader(in));
            this.out = new PrintWriter(out);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void run(){
        String clientMsg="";
        while (!clientMsg.equals("2")){
        out.println(this.server.getNbClients());
        out.flush();
            try {
                clientMsg=in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.server.Decrementor();
    }
}
