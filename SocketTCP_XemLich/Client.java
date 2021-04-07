package SocketTCP_XemLich;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket myClient = new Socket("localHost", 3030);
        System.out.println("Da ket noi thanh cong voi Server");
        DataInputStream dis = new DataInputStream(myClient.getInputStream());
        DataOutputStream dos = new DataOutputStream(myClient.getOutputStream());
        String month, year;
        System.out.println("Nhap vao mot thang va nam bat ki: ");
        Scanner sc = new Scanner(System.in);
        month=sc.nextLine();
        year=sc.nextLine();
        System.out.println(month+"$"+year);
        dos.writeUTF(month);
        dos.writeUTF(year);
        String receiveText = dis.readUTF();
        System.out.println(receiveText);
        dos.close();
        dis.close();
        myClient.close();;
    }
}
