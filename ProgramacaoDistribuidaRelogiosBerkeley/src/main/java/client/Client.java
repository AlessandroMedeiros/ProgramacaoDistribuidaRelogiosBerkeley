package client;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client {
    public static DatagramSocket datagramSocket;
    public static InetAddress inetAddress;
    public static int port;

    static {
        try {
            datagramSocket = new DatagramSocket();
            port = datagramSocket.getLocalPort();
            inetAddress = InetAddress.getByName("localhost");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        ClientThread clientThread = new ClientThread();
        clientThread.run();
    }
}