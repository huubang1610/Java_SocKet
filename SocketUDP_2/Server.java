package SocketUDP_2;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

    public final static int  SERVER_PORT = 7;

    public static void main(String[] args) {
        String data = null;
        try {
            DatagramSocket my_Socket = new DatagramSocket();
            System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
            my_Socket = new DatagramSocket(SERVER_PORT);
            System.out.println("Server started: " + my_Socket.getSoTimeout());
            System.out.println("Waiting for a client ...");

            byte[] data_recei = new byte[4096];
            byte[] data_send = new byte[4096];
            //Đóng gói dữ liệu lại
            DatagramPacket recei = new DatagramPacket(data_recei, data_recei.length);
            // Lấy dữ liệu từ Client gửi lên
            my_Socket.receive(recei);
            data = new String (recei.getData(),0, recei.getLength());
            String [] dlnhan = data.split("/");
            System.out.println("Dữ liệu  Client gửi lên là");
            System.out.println("Fullname: " +dlnhan[0]);
            System.out.println("ID: "+dlnhan[1]);
            System.out.println("Address: "+dlnhan[2]);
            System.out.println("Birth: "+dlnhan[3]);
            System.out.println("Point 1: "+dlnhan[4]);
            System.out.println("Point 2: "+dlnhan[5]);
            System.out.println("Point 3: "+dlnhan[6]);

            //GỬi đáp trả Client

            data_send = ("Xin chào Client").getBytes();
            DatagramPacket send = new DatagramPacket(data_send, data_send.length,recei.getAddress(), recei.getPort());
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
