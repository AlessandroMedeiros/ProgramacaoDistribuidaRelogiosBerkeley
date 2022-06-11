package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ClientThread extends Thread {
    private byte[] buf = new byte[1024];

    @Override
    public void run() {
        MulticastSocket socket = null;
        InetAddress grupo = null;

        try {
            grupo = InetAddress.getByName("230.0.0.1");
            socket = new MulticastSocket(5000);
            socket.joinGroup(grupo);
        } catch (Exception e) {

        }

        while (true) {
            try {
                byte[] entrada = new byte[1024];
                DatagramPacket pacote = new DatagramPacket(entrada, entrada.length);
                socket.setSoTimeout(500);
                socket.receive(pacote);
                String recebido = new String(pacote.getData(), 0, pacote.getLength());

                if(recebido.equals("Alessandro")) {
                    System.out.println("Received: " + recebido);
                    byte[] saida = new byte[1024];
                    saida = "Enzo".getBytes();
                    DatagramPacket pacoteSaida = new DatagramPacket(saida, saida.length, grupo, 5000);
                    socket.send(pacoteSaida);
                }

                if ("fim".equals(recebido))
                    break;
            } catch (IOException e) {
            }
        }


        /**
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
                MulticastSocket socket = new MulticastSocket(5000);
                InetAddress grupo = InetAddress.getByName("192.168.0.126");
                socket.joinGroup(grupo);


                //@TODO Cálcular o RTT de cada "client"


                //@TODO Mestre" cálcular a média dos "clients"
                //incluindo o atraso de um caminho (one way delay)


                //@TODO Remover os "clients" que tem a média


                //@TODO Enviar o atraso para cada "client"


//                for (byte[] bytes : packets) {
//                    DatagramPacket toSend = new DatagramPacket(bytes, bytes.length, packet.getAddress(), packet.getPort());
//                    System.out.println("Enviando Pacote: " + toSend);
//                    Client.datagramSocket.send(toSend);
//                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

         */
    }
}