package BookChat_TCP;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client_BC {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket my_Client = new Socket("127.0.0.1", 32);
        DataInputStream dis = new DataInputStream(my_Client.getInputStream());
        DataOutputStream dos = new DataOutputStream(my_Client.getOutputStream());
        while (true){
            String send_server = null;
            String mess_server = null;
            System.out.print("\nClient>> ");
            send_server  = sc.nextLine();
            dos.writeUTF(send_server);
            if(send_server.equalsIgnoreCase("tam biet")){
                my_Client.close();
                return;
            }else {
                mess_server = dis.readUTF();
                System.out.print("Server>> "+mess_server);
                if (mess_server.equalsIgnoreCase("tam biet")){
                    my_Client.close();
                    return;
                }
            }

        }
    }
}
