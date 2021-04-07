package SocKet_Tcp_String;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ServerSocket my_Server = new ServerSocket(32);
        Socket server = my_Server.accept();
        DataOutputStream dos = new DataOutputStream(server.getOutputStream());
        DataInputStream dis = new DataInputStream(server.getInputStream());
        int number = dis.readUTF().length();
        dos.writeUTF(String.valueOf(number));
    }
}
