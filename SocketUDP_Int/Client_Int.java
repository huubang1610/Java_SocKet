package SocketUDP_Int;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client_Int {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            DatagramSocket my_Client = new DatagramSocket();
            InetAddress IP = InetAddress.getByName("127.0.0.1");
             byte[] data_send = new byte[4096];
             byte[] data_recei = new byte[4096];

            System.out.print("Nhập số cần phân tích: ");
            String or = sc.nextLine();
            data_send = or.getBytes();
            DatagramPacket send = new DatagramPacket(data_send, data_send.length,IP,7);
            my_Client.send(send);

            DatagramPacket recie = new DatagramPacket(data_recei, data_recei.length);
            my_Client.receive(recie);
            String data = new String(recie.getData(), 0, recie.getLength());
            System.out.println("Phân tích được là: "+data);
            my_Client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
