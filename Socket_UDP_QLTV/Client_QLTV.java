package Socket_UDP_QLTV;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client_QLTV {

    public static final String SERVER_IP = "127.0.0.1";
    public static final int    SERVER_PORT = 7;

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            DatagramSocket my_Client = new DatagramSocket();
            InetAddress IP = InetAddress.getByName(SERVER_IP);

            byte[] data_send = new byte[4096];
            byte[] data_reie = new byte[4096];

            while (true){
                System.out.println("-------Menu------");
                System.out.println("1. Hiển thị sách");
                System.out.println("2. Mượn sách");
                System.out.println("3. Thoát");
                System.out.print("Chọn chức năng: ");
                int or = sc.nextInt();
                switch (or){
                    case 1:
                        data_send = "1".getBytes();
                        DatagramPacket send = new DatagramPacket(data_send, data_send.length,IP,SERVER_PORT);
                        my_Client.send(send);

                        DatagramPacket recie = new DatagramPacket(data_reie, data_reie.length);
                        my_Client.receive(recie);
                        String data = new String(recie.getData(),0,recie.getLength());
                        System.out.println("Danh sách thông tin sách trong thư viện");
                        System.out.println(data);
                        break;
                    case 2:
                        System.out.print("Nhập tên sách muốn mượn: ");
                        sc.nextLine();
                        String or1  = sc.nextLine();
                        System.out.print("Nhập tên người mượn: ");
                        String or2  = sc.nextLine();
                        data_send = (2+"$"+or1+"$"+or2).getBytes();
                        DatagramPacket send1 = new DatagramPacket(data_send, data_send.length,IP,SERVER_PORT);
                        my_Client.send(send1);

                        DatagramPacket recie1 = new DatagramPacket(data_reie, data_reie.length);
                        my_Client.receive(recie1);
                        String data1 = new String(recie1.getData(),0,recie1.getLength());
                        System.out.println("Đang tìm kiếm xin vui lòng đợi->");
                        System.out.println(data1);
                        break;
                    case 3:
                        data_send = "3".getBytes();
                        DatagramPacket send4 = new DatagramPacket(data_send, data_send.length ,IP,SERVER_PORT);
                        my_Client.send(send4);
                        my_Client.close();
                        return;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
