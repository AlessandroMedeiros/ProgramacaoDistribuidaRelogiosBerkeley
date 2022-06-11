package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        MulticastSocket socket = new MulticastSocket(5000);
        InetAddress grupo = InetAddress.getByName("230.0.0.1");
        socket.joinGroup(grupo);

        while (true) {
            byte[] saida = new byte[1024];
            saida = "Alessandro".getBytes();
            DatagramPacket pacote = new DatagramPacket(saida, saida.length, grupo, 5000);
            socket.send(pacote);
            Thread.sleep(5000);
        }

        /** @ TODO Como executar DUAS THREADS AM PARALELO???
         * Obs: preciso de dois while true rodando, um pra receber o pacote e outro para enviar

        while(true){
            byte[] entrada = new byte[1024];
            DatagramPacket pacoteEntrada = new DatagramPacket(entrada, entrada.length);
            socket.receive(pacoteEntrada);
            String recebido = new String(pacoteEntrada.getData(), 0, pacoteEntrada.getLength());
            System.out.println("Received: " + recebido);
        }
         */
    }
}