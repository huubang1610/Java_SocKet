package SocketUDP_1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {


    public static void main(String[] args) {
        String data = null;
        try {
            DatagramSocket my_Socket = new DatagramSocket(7);
            byte[] data_recei = new byte[4096];
            byte[] data_send = new byte[4096];
            //Đóng gói dữ liệu lại
            DatagramPacket recei = new DatagramPacket(data_recei, data_recei.length);
            // Lấy dữ liệu từ Client gửi lên
            my_Socket.receive(recei);
            data = new String (recei.getData(),0, recei.getLength());
            System.out.println("Dữ liệu  Client gửi lên là: " +data);

            //GỬi đáp trả Client

            data_send = ("Xin chào Client").getBytes();
            DatagramPacket send = new DatagramPacket(data_send, data_send.length,recei.getAddress(), recei.getPort());
            my_Socket.send(send);

            //Đóng lại

            my_Socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
