package Socket_UDP_GT;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client_GT {

    public final static String SERVER_IP = "127.0.0.1";
    public final static int  SERVER_PORT = 7;

    public static void main(String[] args) {
        String data = null;
        try {
            Scanner sc = new Scanner(System.in);
            DatagramSocket my_CLient = new DatagramSocket();
            InetAddress IP = InetAddress.getByName(SERVER_IP);

            byte[] data_send = new byte[4096];
            byte[] data_recie = new byte[4096];

            System.out.print("Số cần tính: ");
            String or = sc.nextLine();
            data_send = or.getBytes();
            DatagramPacket send = new DatagramPacket(data_send,data_send.length,IP,SERVER_PORT);
            my_CLient.send(send);

            DatagramPacket recie = new DatagramPacket(data_recie, data_recie.length);
            my_CLient.receive(recie);
            data = new String(recie.getData(),0, recie.getLength());

            System.out.println("Giai thừa của "+or+" là: "+data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
