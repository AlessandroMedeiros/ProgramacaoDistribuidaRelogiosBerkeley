//package client;
//
//import java.io.IOException;
//import java.net.DatagramPacket;
//import java.net.InetAddress;
//import java.net.MulticastSocket;
//import java.util.Scanner;
//
//public class HelloChat {
//    public static void main(String[] args) {
//
//        try {
//            MulticastSocket socket = new MulticastSocket(5000);
//            InetAddress grupo = InetAddress.getByName("230.0.0.1");
//            socket.joinGroup(grupo);
//        } catch (Exception e) {
//        }
//
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            try {
//                byte[] entrada = new byte[1024];
//                DatagramPacket pacote = new DatagramPacket(entrada, entrada.length);
//                socket.setSoTimeout(500);
//                socket.receive(pacote);
//                String recebido = new String(pacote.getData(), 0, pacote.getLength());
//                System.out.println("Received: " + recebido);
//
//                if ("fim".equals(recebido))
//                    break;
//            } catch (IOException e) {
//            }
//
//            if (System.in.available() > 0) {
//                String mens = scanner.nextLine();
//
//                byte[] saida = new byte[1024];
//                saida = mens.getBytes();
//                DatagramPacket pacote = new DatagramPacket(saida, saida.length, grupo, 5000);
//                socket.send(pacote);
//            }
//        }
//
//        socket.leaveGroup(grupo);
//        socket.close();
//    }
//}
