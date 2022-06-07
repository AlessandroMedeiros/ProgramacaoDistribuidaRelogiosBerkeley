package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.List;

public class ClientThread extends Thread {
    private byte[] buf = new byte[1024];

    @Override
    public void run() {
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                Client.datagramSocket.receive(packet);
                byte[] data = packet.getData();
                String received = new String(data, 0, buf.length).trim();
                buf = new byte[1024];
                System.out.println("\nRecebido: " + received);

                String nome = received.split(";")[1];
                byte[] timeToSend = ("name;" + nome + ";").getBytes();
                //@TODO Como enviar uma mensagem MULTICAST
                Client.datagramSocket.send(new DatagramPacket(timeToSend, timeToSend.length, packet.getAddress(), packet.getPort()));
                DatagramPacket datagramPacket = new DatagramPacket(buf, 1, 1024);
                Client.datagramSocket.receive(datagramPacket);
                datagramPacket.getData();
                //@TODO Cálcular o RTT de cada "client"



                //@TODO Mestre" cálcular a média dos "clients"
                //incluindo o atraso de um caminho (one way delay)


                //@TODO Remover os "clients" que tem a média


                //@TODO Enviar o atraso para cada "client"


                for (byte[] bytes : packets) {
                    DatagramPacket toSend = new DatagramPacket(bytes, bytes.length, packet.getAddress(), packet.getPort());
                    System.out.println("Enviando Pacote: " + toSend);
                    Client.datagramSocket.send(toSend);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}