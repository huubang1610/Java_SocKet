package BookChat_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server_BC {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ServerSocket my_Server = new ServerSocket(32);
        Socket server = my_Server.accept();
        DataOutputStream dos = new DataOutputStream(server.getOutputStream());
        DataInputStream dis = new DataInputStream(server.getInputStream());
        while (true) {
            String send_Client = null;
            String mess_Client = null;
            mess_Client = dis.readUTF();
            if (mess_Client.equalsIgnoreCase("tam biet")){
                my_Server.close();
                return;
            }else {
                System.out.println("Client>> " + mess_Client);
                System.out.print("Server>> ");
                send_Client = sc.nextLine();
                if (send_Client.equalsIgnoreCase("tam biet")){
                    dos.writeUTF(send_Client);
                    my_Server.close();
                    return;
                }else {
                    dos.writeUTF(send_Client);
                }
            }

        }
    }
}
