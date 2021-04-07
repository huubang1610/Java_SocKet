package SocketUDP_4;

import SocketUDP_3.Person3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server4 {

    public final static int  SERVER_PORT = 7;
    public final static String  url = "C:\\Users\\Admin\\IdeaProjects\\Socket\\src\\SocketUDP_4\\tudien";

    public static List<Word> setList(String path) throws FileNotFoundException {
        List<Word> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(path);
        Scanner sc = new Scanner(fis);

        while (sc.hasNextLine()){
            String str = sc.nextLine();
            String[] dl = str.split("\\$");
            if (dl.length != 2) continue;

            Word word = new Word();
            word.setEN(dl[0]);
            word.setVN(dl[1]);

            list.add(word);
        }
        return list;// trả về 1 list
    }
    public static void main(String[] args) {
        String data = null;
        List<Word> list = new ArrayList<>();
        StringBuffer send_client = new StringBuffer();// Phương thức này khá mới để nối từ
        try {
            DatagramSocket my_Socket = new DatagramSocket();
            System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
            my_Socket = new DatagramSocket(SERVER_PORT);
            System.out.println("Waiting for a client ...");

            byte[] data_recei = new byte[4096];
            byte[] data_send = new byte[4096];
            //Đóng gói dữ liệu lại
            DatagramPacket recei = new DatagramPacket(data_recei, data_recei.length);

            // Lấy dữ liệu từ Client gửi lên
            my_Socket.receive(recei);
            data = new String (recei.getData(),0, recei.getLength());
            list = setList(url);

            //Kiểm tra các điều kiên phù hợp với nó
            if (data.equalsIgnoreCase("all")){
                for (Word l: list) {
                    send_client.append(l.toString()).append("\n");
                }
            }else {
                for (Word l: list) {
                    if (data.equalsIgnoreCase(l.getEN())){
                        send_client.append(l.toString()).append("\n");
                    }
                }
            }
            data_send = send_client.toString().getBytes();
            //GỬi đáp trả Client
            DatagramPacket send = new DatagramPacket(data_send,
                    data_send.length,
                    recei.getAddress(),
                    recei.getPort());
            my_Socket.send(send);
            //Đóng lại

            my_Socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
