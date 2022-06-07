package client;

import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;

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
        String connectLocation = "rmi://" + (args.length > 0 ? args[0] : Inet4Address.getLocalHost().getHostAddress()) + ":1099";
        System.out.println(connectLocation);

        try {
            //server = (IClient)Naming.lookup(connectLocation);
            System.out.println("======================");
            System.out.println("=EMULE================");
            System.out.println("======================");
            //Menu.inicio();
            System.out.println("Nome: " + args[1]);
        } catch (Exception e) {
            System.out.println("P2PClient failed.");
            e.printStackTrace();
        }
    }
}