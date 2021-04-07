package TestTN_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client_TN {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket my_Client = new Socket("127.0.0.1", 32);
        DataInputStream dis = new DataInputStream(my_Client.getInputStream());
        DataOutputStream dos = new DataOutputStream(my_Client.getOutputStream());
        System.out.print("Bạn muốn bắt đầu trò chơi không(YES/NO): ");
        String send_Server = sc.nextLine();
        dos.writeUTF(send_Server);
        String mess_Client = null;
        int number = 0;
        int str = 0;
        while (true){
            mess_Client = dis.readUTF();
            String[] dl = mess_Client.split("/");
            File_Document f = new File_Document();

            f.setDeBai(dl[0]);
            f.setDaA(dl[1]);
            f.setDaB(dl[2]);
            f.setDaC(dl[3]);
            f.setDaD(dl[4]);
            f.setKey(dl[5]);
            number = Integer.parseInt(dl[6]);

            System.out.println("ĐB.\t"+f.getDeBai());
            System.out.println("A.\t"+f.getDaA());
            System.out.println("B.\t"+f.getDaB());
            System.out.println("C.\t"+f.getDaC());
            System.out.println("D.\t"+f.getDaD());

            System.out.print("Xin mời chọn đáp án: ");
            String or = sc.nextLine();
            str++;

            if (or.equalsIgnoreCase(f.getKey())){
                System.out.println("Chúc mừng bạn trả lời chinh xác !");
                send_Server="next";
            }else {
                System.out.println("Bạn đã trả lời sai đáp án đúng là: "+f.getKey());
                send_Server = "no";
                my_Client.close();
                return;
            }
            if (str == number){
                return;
            }
            dos.writeUTF(send_Server);
        }
    }
}
