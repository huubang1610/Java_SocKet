package Socket_TCP_QLBN;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client_QLBN {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket my_Client = new Socket("127.0.0.1",32);
        DataOutputStream dos = new DataOutputStream(my_Client.getOutputStream());
        DataInputStream dis = new DataInputStream(my_Client.getInputStream());
        String send_cliend = null;
        while (true){
            System.out.println("----Chức năng-----");
            System.out.println("1. Xem danh sách nhà");
            System.out.println("2. Thêm nhà");
            System.out.println("3. Mua nhà");
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
                    Doccument d = new Doccument();
                    System.out.print("SỐ nhà: ");
                    sc.nextLine();
                    d.setSonha(sc.nextLine());
                    System.out.print("Giá bán: ");
                    d.setGiaban(sc.nextLine());
                    System.out.print("Tình trạng nhà: ");
                    d.setTinhtrang(sc.nextLine());
                    send_cliend = 2+"$"+d.getSonha()+"$"+d.getGiaban()+"$"+d.getTinhtrang();
                    dos.writeUTF(send_cliend);
                    System.out.println(dis.readUTF());
                    break;
                case 3:
                    System.out.print("\nNhập số nhà muốn mua: ");
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
