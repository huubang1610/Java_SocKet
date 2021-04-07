package SocketUDP_String;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server_String {
    public static void main(String[] args) {
        String data = null;
        try {
            DatagramSocket my_Socket = new DatagramSocket(7);
            byte[] data_recei = new byte[4096];
            byte[] data_send = new byte[4096];
            DatagramPacket recei = new DatagramPacket(data_recei, data_recei.length);
            my_Socket.receive(recei);
            data = new String(recei.getData(), 0, recei.getLength());
            System.out.println("1: "+data);
            data = data.toUpperCase();
            System.out.println("2: "+data);

            data_send = data.getBytes();
            DatagramPacket send = new DatagramPacket(data_send, data_send.length,recei.getAddress(), recei.getPort());
            my_Socket.send(send);

            my_Socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
