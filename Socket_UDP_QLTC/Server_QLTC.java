package Socket_UDP_QLTC;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Server_QLTC {

    public final static int  SERVER_PORT = 7;

    public static void main(String[] args) {
        List<File_Document> list = new ArrayList<>();
        File_Document f = new File_Document("5000","Thêm vào +5000");
        list.add(f);
        try {
            DatagramSocket my_Socket = new DatagramSocket(7);
            byte[] data_send = new byte[4096];
            byte[] data_recie = new byte[4096];
            String data = null;

            while (true){
                DatagramPacket recie = new DatagramPacket(data_recie, data_recie.length);
                 my_Socket.receive(recie);
                 data = new String(recie.getData(), 0, recie.getLength());
                 String dl[] = data.split("\\$");
                 StringBuffer send_Client = new StringBuffer();
                 if (dl[0].equalsIgnoreCase("cloes")){
                     my_Socket.close();
                     return;
                 }else {
                     File_Document f1 = new File_Document();
                         if (dl[0].equalsIgnoreCase("show")){
                             for (File_Document l : list) {
                                 send_Client.append(l.toString()).append("\n");
                             }
                             data_send = String.valueOf(send_Client).getBytes();
                             DatagramPacket send = new DatagramPacket(data_send, data_send.length,recie.getAddress(), recie.getPort());
                             my_Socket.send(send);

                         }else if (dl[0].equalsIgnoreCase("sum")){
                             int sum = Integer.parseInt(f.getTotal())+Integer.parseInt(dl[1]);
                             f1.setTotal(String.valueOf(sum));
                             f1.setHistory("Thêm vào +"+dl[1]);
                             list.add(f1);
                             data_send = "Đã thêm vào tài khoản!".getBytes();
                             DatagramPacket send = new DatagramPacket(data_send, data_send.length,recie.getAddress(), recie.getPort());
                             my_Socket.send(send);
                         }else {
                             int hieu = Integer.parseInt(f.getTotal())-Integer.parseInt(dl[1]);
                             f1.setTotal(String.valueOf(hieu));
                             f1.setHistory("Xuất ra -"+dl[1]);
                             list.add(f1);
                             data_send = "Đã xuất ra khỏi tài khoản!".getBytes();
                             DatagramPacket send = new DatagramPacket(data_send, data_send.length,recie.getAddress(), recie.getPort());
                             my_Socket.send(send);
                         }

                 }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
