package TCP_QLNV;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client_qlnv {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket my_Client = new Socket("127.0.0.1", 8484);
        DataInputStream dis = new DataInputStream(my_Client.getInputStream());
        DataOutputStream dos = new DataOutputStream(my_Client.getOutputStream());
        String send_cliend = null;
        while (true){
            System.out.println("----Chức năng-----");
            System.out.println("1. Xem danh sách nhân viên");
            System.out.println("2. Thêm nhân viên");
            System.out.println("3. Tìm nhân viên");
            System.out.println("4. Close");
            System.out.print("Xin mời lựa chọn chức năng: ");
            int or = sc.nextInt();
            switch (or){
                case 1:
                    send_cliend = "1$all";
                    dos.writeUTF(send_cliend);
                    System.out.println(dis.readUTF());
                    break;
                case 2:
                    Person p = new Person();
                    System.out.print("Nhập tên: ");
                    sc.nextLine();
                    p.setName(sc.nextLine());
                    System.out.print("Ngày sinh: ");
                    p.setDateOfBirth(sc.nextLine());
                    System.out.print("Chức danh: ");
                    p.setTitle(sc.nextLine());
                    send_cliend = 2+"$"+p.getName()+"$"+p.getDateOfBirth()+"$"+p.getTitle();
                    dos.writeUTF(send_cliend);
                    System.out.println(dis.readUTF());
                    break;
                case 3:
                    System.out.print("\nNhập tên muốn tìm kiếm: ");
                    sc.nextLine();
                    send_cliend = sc.nextLine();
                    dos.writeUTF(3+"$"+send_cliend);
                    System.out.println(dis.readUTF());
                    break;
                case 4:
                    send_cliend = "close";
                    dos.writeUTF(4+"$"+send_cliend);
                    my_Client.close();
                    return;
            }
        }
    }
}
