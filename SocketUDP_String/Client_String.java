package SocketUDP_String;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client_String {

    public final static String SERVER_IP = "127.0.0.1";
    public final static int  SERVER_PORT = 7;

    public static void main(String[] args) {
        String data = null;
        try {
            Scanner sc = new Scanner(System.in);
            DatagramSocket my_Client = new DatagramSocket();
            InetAddress IP = InetAddress.getByName(SERVER_IP);
            byte[] data_recei = new byte[4096];
            byte[] data_send = new byte[4096];

            System.out.println("Nhập chuỗi: ");
            String mess = sc.nextLine();
            data_send = mess.getBytes();
            DatagramPacket send = new DatagramPacket(data_send, data_send.length,IP,SERVER_PORT);
            my_Client.send(send);

            DatagramPacket recie = new DatagramPacket(data_recei, data_recei.length);
            my_Client.receive(recie);
            data = new String(recie.getData(),0, recie.getLength());

            System.out.println("Chuỗi viết hoa là: "+data);

            my_Client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
