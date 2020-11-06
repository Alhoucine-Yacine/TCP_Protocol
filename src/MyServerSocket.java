
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class MyServerSocket {

        public int nbClients ;
        private ServerSocket server;
        public MyServerSocket(String ipAddress) throws Exception {
            setNbClients(0);
            if (ipAddress != null && !ipAddress.isEmpty())
                this.server = new ServerSocket(1027, 1, InetAddress.getByName(ipAddress));
            else
                this.server = new ServerSocket(0, 1, InetAddress.getLocalHost());
        }

    public int getNbClients() {
        return nbClients;
    }


    public void setNbClients(int nbClients) {
        this.nbClients = nbClients;
    }

    public void Incrementor(){
        this.nbClients++;

    }

    public void Decrementor(){
        this.nbClients--;

    }

    private void listen() throws Exception {
            while (true) {
                Socket client = this.server.accept();
                ReadThred readMsg = new ReadThred(client);
                String clientAddress = client.getInetAddress().getHostAddress();
                System.out.println("\r\nNew connection from " + clientAddress);
                Incrementor();
                readMsg.setServer(this);
                readMsg.start();
            }

        }
        public InetAddress getSocketAddress() {
            return this.server.getInetAddress();
        }

        public int getPort() {
            return this.server.getLocalPort();
        }
        public static void main(String[] args) throws Exception {

            InetAddress moi = InetAddress.getLocalHost();
            String ip =moi.getHostAddress();
            MyServerSocket app = new MyServerSocket(ip);
            System.out.println("\r\nRunning Server: " + "Host=" + app.getSocketAddress().getHostAddress() +" Port=" + app.getPort());

            app.listen();
        }
    }

