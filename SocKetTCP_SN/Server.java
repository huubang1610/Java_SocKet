package SocKetTCP_SN;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static boolean isPrimeNumber(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ServerSocket my_Server = new ServerSocket(8484);
        Socket server = my_Server.accept();
        DataOutputStream dos = new DataOutputStream(server.getOutputStream());
        DataInputStream dis = new DataInputStream(server.getInputStream());
        int a = Integer.parseInt(dis.readUTF());
        if (isPrimeNumber(a) == true){
            dos.writeUTF(a + "\tlà số nguyên tố");
        }else {
            dos.writeUTF(a + "\tKhông là số nguyên tố");
        }
        my_Server.close();
    }
}
