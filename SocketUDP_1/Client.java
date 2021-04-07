package SocketUDP_1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

    public final static String SERVER_IP = "127.0.0.1";
    public final static int  SERVER_PORT = 7;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String data = null;
        try {
            DatagramSocket my_Client = new DatagramSocket();
            InetAddress IP = InetAddress.getByName(SERVER_IP);
            byte [] data_recei = new byte[4096];
            byte [] data_send = new byte[4096];
            //Client gửi dữ liệu lên máy chủ
            System.out.printf("Lời nhắn: ");
            String mess = sc.nextLine();
            data_send = (mess+"").getBytes();
            DatagramPacket send = new DatagramPacket(data_send, data_send.length,IP,SERVER_PORT);
            my_Client.send(send);
            // Nhận dữ liệu từ Server trả về

            DatagramPacket recei = new DatagramPacket(data_recei, data_recei.length);
            my_Client.receive(recei);
            data = new String(recei.getData(),0,recei.getLength());
            System.out.println("Server trả về là: "+data);

            // Đóng
            my_Client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
