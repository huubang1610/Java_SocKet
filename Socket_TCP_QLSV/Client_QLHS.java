package Socket_TCP_QLSV;

import SocketTCP_QLKS.Doccument_Custormer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client_QLHS {
    public static void main(String[] args) throws IOException {
        Socket my_Client = new Socket("127.0.0.1",32);
        DataInputStream dis = new DataInputStream(my_Client.getInputStream());
        DataOutputStream dos = new DataOutputStream(my_Client.getOutputStream());
        Scanner sc = new Scanner(System.in);
        String send_cliend = null;
        while (true){
            System.out.println("----Chức năng-----");
            System.out.println("1.Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên mới");
            System.out.println("3. Xem thông tin sinh viên");
            System.out.println("4. Tìm kiếm theo năm sinh");
            System.out.println("5. Tìm kiếm theo quê quán");
            System.out.println("6. Close");
            System.out.print("Xin mời lựa chọn : ");
            int o = sc.nextInt();
            switch (o){
                case 1:
                    send_cliend = "1$show";
                    dos.writeUTF(send_cliend);
                    System.out.println(dis.readUTF());
                    break;
                case 2:
                    Students s = new Students();
                    System.out.print("Name: ");
                    sc.nextLine();
                    s.setName(sc.nextLine());
                    System.out.print("Date of Birth: ");
                    s.setDateOfBirth(sc.nextLine());
                    System.out.print("MSV: ");
                    s.setMSV(sc.nextLine());
                    System.out.print("Address: ");
                    s.setAddress(sc.nextLine());

                    send_cliend = 2+"$"+s.getName()+"$"+s.getDateOfBirth()+"$"+s.getMSV()+"$"+s.getAddress();

                    dos.writeUTF(send_cliend);

                    System.out.println(dis.readUTF());
                    break;
                case 3:
                    System.out.print("Nhập tên cần xem: ");
                    sc.nextLine();
                    send_cliend = sc.nextLine();
                    dos.writeUTF(3+"$"+send_cliend);

                    System.out.println(dis.readUTF());
                    break;
                case 4:
                    System.out.print("Nhập năm sinh cần tìm: ");
                    sc.nextLine();
                    send_cliend = sc.nextLine();
                    dos.writeUTF(4+"$"+send_cliend);

                    System.out.println("Những người có năm sinh "+send_cliend+" là: ");
                    System.out.println(dis.readUTF());
                    break;
                case 5:
                    System.out.print("Nhập quê quán cần tìm: ");
                    sc.nextLine();
                    send_cliend = sc.nextLine();
                    dos.writeUTF(5+"$"+send_cliend);

                    System.out.println("Những người quê quán "+send_cliend+" là: ");
                    System.out.println(dis.readUTF());
                    break;
                case 6:
                    send_cliend = "close";
                    dos.writeUTF(6+"$"+send_cliend);
                    my_Client.close();
                    return;
            }
        }

    }
}
