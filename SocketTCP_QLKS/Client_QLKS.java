package SocketTCP_QLKS;


import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

public class Client_QLKS {
    public static void main(String[] args) throws IOException {
        Socket my_Client = new Socket("127.0.0.1",32);
        DataInputStream dis = new DataInputStream(my_Client.getInputStream());
        DataOutputStream dos = new DataOutputStream(my_Client.getOutputStream());
        Scanner sc = new Scanner(System.in);
        String send_cliend = null;
        while (true){
            System.out.println("----Chức năng-----");
            System.out.println("1. Thêm khách hàng thuê phòng");
            System.out.println("2. Tính tiền phòng của khách hàng trả");
            System.out.println("3. Close");
            System.out.print("Xin mời lựa chọn chức năng: ");
            int or = sc.nextInt();
            switch (or){
                case 1:
                    Doccument_Custormer dc = new Doccument_Custormer();
                    System.out.print("ID: ");
                    sc.nextLine();
                    dc.setID(sc.nextLine());
                    System.out.print("Name: ");
                    dc.setName(sc.nextLine());
                    System.out.print("Loại phòng: ");
                    dc.setPhanloai(sc.nextLine());
                    send_cliend = "1"+"$"+dc.getID()+"$"+dc.getName()+"$"+dc.getPhanloai();
                    dos.writeUTF(send_cliend);

                    System.out.println(dis.readUTF());
                    break;
                case 2:
                    System.out.print("Nhập tên khách hàng: ");
                    sc.nextLine();
                    send_cliend = sc.nextLine();
                    System.out.print("Số ngày ở: ");
                    String day = sc.nextLine();
                    dos.writeUTF(2+"$"+send_cliend+"$"+day);
                    System.out.println(dis.readUTF()+"$");
                    break;
                case 3:
                    send_cliend = "close";
                    dos.writeUTF(3+"$"+send_cliend);
                    my_Client.close();
                    return;
            }
        }
    }
}
