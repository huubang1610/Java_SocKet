package SocketUDP_Int;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server_Int {
    public static void main(String[] args) {
        try {
            DatagramSocket my_Socket = new DatagramSocket(7);

            byte[] data_send = new byte[4096];
            byte[] data_recie = new byte[4096];
            String data = null;
            DatagramPacket recie = new DatagramPacket(data_recie, data_recie.length);
            my_Socket.receive(recie);
            data = new String(recie.getData(), 0, recie.getLength());
            int or = Integer.parseInt(data);
            switch (or){
                case 0:
                    data_send = "Không".getBytes();
                    DatagramPacket send = new DatagramPacket(data_send, data_send.length,recie.getAddress(),recie.getPort());
                    my_Socket.send(send);
                    break;
                case 1:
                    data_send = "Một".getBytes();
                    DatagramPacket send1 = new DatagramPacket(data_send, data_send.length,recie.getAddress(),recie.getPort());
                    my_Socket.send(send1);
                    break;
                case 2:
                    data_send = "Hai".getBytes();
                    DatagramPacket send2 = new DatagramPacket(data_send, data_send.length,recie.getAddress(),recie.getPort());
                    my_Socket.send(send2);
                    break;
                case 3:
                    data_send = "Ba".getBytes();
                    DatagramPacket send3 = new DatagramPacket(data_send, data_send.length,recie.getAddress(),recie.getPort());
                    my_Socket.send(send3);
                    break;
                case 4:
                    data_send = "Bốn".getBytes();
                    DatagramPacket send4 = new DatagramPacket(data_send, data_send.length,recie.getAddress(),recie.getPort());
                    my_Socket.send(send4);
                    break;
                case 5:
                    data_send = "Năm".getBytes();
                    DatagramPacket send5 = new DatagramPacket(data_send, data_send.length,recie.getAddress(),recie.getPort());
                    my_Socket.send(send5);
                    break;
                case 6:
                    data_send = "Sáu".getBytes();
                    DatagramPacket send6 = new DatagramPacket(data_send, data_send.length,recie.getAddress(),recie.getPort());
                    my_Socket.send(send6);
                    break;
                case 7:
                    data_send = "Bảy".getBytes();
                    DatagramPacket send7 = new DatagramPacket(data_send, data_send.length,recie.getAddress(),recie.getPort());
                    my_Socket.send(send7);
                    break;
                case 8:
                    data_send = "Tám".getBytes();
                    DatagramPacket send8 = new DatagramPacket(data_send, data_send.length,recie.getAddress(),recie.getPort());
                    my_Socket.send(send8);
                    break;
                case 9:
                    data_send = "Chín".getBytes();
                    DatagramPacket send9 = new DatagramPacket(data_send, data_send.length,recie.getAddress(),recie.getPort());
                    my_Socket.send(send9);
                    break;
            }

            my_Socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
