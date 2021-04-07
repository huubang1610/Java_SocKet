package SocKet_Tcp_String;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket my_Client = new Socket("127.0.0.1", 32);
        DataInputStream dis = new DataInputStream(my_Client.getInputStream());
        DataOutputStream dos = new DataOutputStream(my_Client.getOutputStream());
        System.out.print("Nhập từ: ");
        String or = sc.nextLine();
        dos.writeUTF(or);
        System.out.println("Độ dài của chuỗi là: "+dis.readUTF());
    }
}
