package Socket_UDP_GT;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server_GT {
    public static long tinhGiaithua(int n) {
        long giai_thua = 1;
        if (n == 0 || n == 1) {
            return giai_thua;
        } else {
            for (int i = 2; i <= n; i++) {
                giai_thua *= i;
            }
            return giai_thua;
        }
    }
    public static void main(String[] args) {
        String data = null;
        try {
            DatagramSocket my_Socket = new DatagramSocket(7);

            byte[] data_send = new byte[4096];
            byte[] data_recie = new byte[4096];

            DatagramPacket recie = new DatagramPacket(data_recie, data_recie.length);
            my_Socket.receive(recie);
            data = new String(recie.getData(),0, recie.getLength());
            int n = Integer.parseInt(data);
            data = String.valueOf(tinhGiaithua(n));

            data_send = data.getBytes();

            DatagramPacket send = new DatagramPacket(data_send, data_send.length,recie.getAddress(), recie.getPort());
            my_Socket.send(send);

            my_Socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
