package SocketUDP_GTTD;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client_GTTD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            DatagramSocket my_Client = new DatagramSocket();
            InetAddress IP = InetAddress.getByName("127.0.0.1");

            byte[] data_send = new byte[4096];
            byte[] data_recie = new byte[4096];

            System.out.print("Nhập số cần phân tích: ");
            String or = sc.nextLine();
            data_send = or.getBytes();
            DatagramPacket send = new DatagramPacket(data_send, data_send.length, IP, 7);
            my_Client.send(send);

            DatagramPacket recie = new DatagramPacket(data_recie, data_recie.length);
            my_Client.receive(recie);
            String data = new String(recie.getData(),0, recie.getLength());
            System.out.println("Số sau khi tính giá trị tuyệt đối là: "+data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
