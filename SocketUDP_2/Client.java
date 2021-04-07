package SocketUDP_2;

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

            // Nhập thông tin
            Person s = new Person();
            System.out.printf("Nhập thông tin người dùng\n");
            System.out.printf("Fullname: ");
            s.Fullname = sc.nextLine();
            System.out.printf("ID: ");
            s.ID = sc.nextLine();
            System.out.printf("Address: ");
            s.Arrdess = sc.nextLine();
            System.out.printf("Birth: ");
            s.Birth = sc.nextLine();
            System.out.printf("Point 1: ");
            s.mon1 = sc.nextFloat();
            System.out.printf("Point 2: ");
            s.mon2 = sc.nextFloat();
            System.out.printf("Point 3: ");
            s.mon3 = sc.nextFloat();

            data_send = (s.getFullname()+"/"+s.getID()+"/"+s.getArrdess()+"/"+s.getBirth()+
                    "/"+s.getMon1()+"/"+s.getMon2()+"/"+s.getMon3()+"/").getBytes();
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
