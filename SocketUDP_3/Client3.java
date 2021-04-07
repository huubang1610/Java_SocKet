package SocketUDP_3;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client3 {

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

            // Nhập thông tin
                System.out.println("Chức Năng");
                System.out.println("1. Xem tất cả dữ liệu");
                System.out.println("2. Tìm kiếm thông tin ");
                System.out.printf("Clinet>> ");
                String or = sc.nextLine();
                switch (or){
                    case "1":
                        or="all";
                    break;
                    case "2":
                        System.out.printf("Search Name:  ");
                        or = sc.nextLine();
                        break;
                }
                //Gửi thông tin yêu cầu Server chạy
            data_send = or.getBytes();
            DatagramPacket send = new DatagramPacket(data_send,data_send.length,IP,SERVER_PORT);
            my_Client.send(send);

            // Nhận dữ liệu từ Server trả về

            DatagramPacket recei = new DatagramPacket(data_recei, data_recei.length);
            my_Client.receive(recei);
            String dl = new String (recei.getData(),0, recei.getLength());
            System.out.println("Server>>\n "+dl);

            // Đóng
            my_Client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
