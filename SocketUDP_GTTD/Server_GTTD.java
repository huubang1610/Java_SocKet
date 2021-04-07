package SocketUDP_GTTD;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server_GTTD {
    public static void main(String[] args) {
        try {
            DatagramSocket my_Socket = new DatagramSocket(7);
             byte[] data_send = new byte[4096];
             byte[] data_recie = new byte[4096];

            DatagramPacket recie = new DatagramPacket(data_recie, data_recie.length);
            my_Socket.receive(recie);
            String data = new String(recie.getData(),0, recie.getLength());
            int number = Math.abs(Integer.parseInt(data));

            data_send = String.valueOf(number).getBytes();
            DatagramPacket send = new DatagramPacket(data_send, data_send.length,recie.getAddress(),recie.getPort());
            my_Socket.send(send);

            my_Socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
