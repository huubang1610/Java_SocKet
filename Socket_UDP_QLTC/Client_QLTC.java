package Socket_UDP_QLTC;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Client_QLTC {
    public final static String SERVER_IP = "127.0.0.1";
    public final static int  SERVER_PORT = 7;
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            DatagramSocket my_Socket = new DatagramSocket();
            InetAddress IP = InetAddress.getByName(SERVER_IP);
            byte[] data_send = new byte[4096];
            byte[] data_recie = new byte[4096];
            String data = null;
            while (true){
                System.out.println("-------Menu------");
                System.out.println("1. Thu tiền");
                System.out.println("2. Chi tiền");
                System.out.println("3. Show lịch sử giao dịch");
                System.out.println("4. Thoát");
                System.out.print("Chọn chức năng: ");
                int or = sc.nextInt();
                switch (or){
                    case 1:
                        System.out.print("Nhập số tiền thêm vào: ");
                        sc.nextLine();
                        String number = sc.nextLine();
                        data_send = ("sum$"+number).getBytes();
                        DatagramPacket send = new DatagramPacket(data_send, data_send.length ,IP,SERVER_PORT);
                        my_Socket.send(send);

                        DatagramPacket recie = new DatagramPacket(data_recie, data_recie.length);
                        my_Socket.receive(recie);
                        data = new String(recie.getData(), 0, recie.getLength());
                        System.out.println(data);
                        break;
                    case 2:
                        System.out.print("Nhập số tiền xuất ra: ");
                        sc.nextLine();
                        String number1 = sc.nextLine();
                        data_send = ("hieu$"+number1).getBytes();
                        DatagramPacket send1 = new DatagramPacket(data_send, data_send.length ,IP,SERVER_PORT);
                        my_Socket.send(send1);

                        DatagramPacket recie1 = new DatagramPacket(data_recie, data_recie.length);
                        my_Socket.receive(recie1);
                        data = new String(recie1.getData(), 0, recie1.getLength());
                        System.out.println(data);
                        break;
                    case 3:
                        data_send = "show".getBytes();
                        DatagramPacket send3 = new DatagramPacket(data_send, data_send.length ,IP,SERVER_PORT);
                        my_Socket.send(send3);

                        DatagramPacket recie3 = new DatagramPacket(data_recie, data_recie.length);
                        my_Socket.receive(recie3);
                        data = new String(recie3.getData(), 0, recie3.getLength());
                        System.out.println(data);
                        break;
                    case 4:
                        data_send = "close".getBytes();
                        DatagramPacket send4 = new DatagramPacket(data_send, data_send.length ,IP,SERVER_PORT);
                        my_Socket.send(send4);
                        my_Socket.close();
                        return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
