package server;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.LocalTime;

public class Server {

  public static void main(String[] args) throws UnknownHostException {
    try {
      System.setProperty("java.rmi.server.hostname", Inet4Address.getLocalHost().getHostAddress());
      LocateRegistry.createRegistry(1099);
      System.out.println("RMI registry ready.");
    } catch (RemoteException e) {
      System.out.println("RMI registry already running.");
    }
    try {
      // String server = "rmi://" + Inet4Address.getLocalHost().getHostAddress() +
      // ":1099";
      Naming.rebind(ServerClock.class.getSimpleName(), new ServerClock(LocalTime.now()));
      System.out.println("Server is ready.");
      System.out.println("URL: " + Inet4Address.getLocalHost().getHostAddress() + ":1099");
    } catch (Exception e) {
      System.out.println("Server failed:");
      e.printStackTrace();
    }
  }
}
