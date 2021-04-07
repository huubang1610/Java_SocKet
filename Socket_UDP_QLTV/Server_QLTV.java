package Socket_UDP_QLTV;


import Socket_UDP_QLTC.File_Document;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

public class Server_QLTV {
    public static void main(String[] args) {
        List<Document> list = new ArrayList<>();
        Document d1 = new Document("01","Đắc nhân tâm", "Hữu Bằng");
        Document d2 = new Document("02","Lập trình OOP", "Chưa mượn");
        Document d3 = new Document("03","Khéo ăn nói lấy lòng thiên hạ", "Chưa mượn");
        Document d4 = new Document("04","Trên đường băng", "Chưa mượn");
        Document d5 = new Document("05","Dế mèn phưu lưu kí", "Chưa mượn");
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);
        list.add(d5);
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

                if (dl[0].equalsIgnoreCase("3")){
                    my_Socket.close();
                    return;
                }else {
                    if (dl[0].equalsIgnoreCase("1")) {
                        for (Document l : list) {
                            send_Client.append(l.toString()).append("\n");
                        }
                         data_send = String.valueOf(send_Client).getBytes();
                         DatagramPacket send = new DatagramPacket(data_send, data_send.length,recie.getAddress(), recie.getPort());
                         my_Socket.send(send);
                    } else if (dl[0].equalsIgnoreCase("2")) {
                        boolean check = false;
                        for (Document l : list) {
                            if (l.getTensach().equalsIgnoreCase(dl[1])){
                                l.setNguoimuon(dl[2]);
                                data_send = "Đã tìm thấy sách xin vui lòng đợi để nhận sách".getBytes();
                                DatagramPacket send = new DatagramPacket(data_send, data_send.length,recie.getAddress(), recie.getPort());
                                my_Socket.send(send);
                                check = true;
                            }
                        }
                        if(check == false){
                            data_send = "Xin lỗi! Chúng tôi không tìm thấy sách".getBytes();
                            DatagramPacket send2 = new DatagramPacket(data_send, data_send.length,recie.getAddress(), recie.getPort());
                            my_Socket.send(send2);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
