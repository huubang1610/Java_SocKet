package SocKetTCP_SN;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket my_Client = new Socket("127.0.0.1", 8484);
        DataInputStream dis = new DataInputStream(my_Client.getInputStream());
        DataOutputStream dos = new DataOutputStream(my_Client.getOutputStream());
        System.out.print("Nhập số chọn: ");
        String send_Client = sc.nextLine();
        dos.writeUTF(send_Client);
        System.out.println(dis.readUTF());

    }
}
