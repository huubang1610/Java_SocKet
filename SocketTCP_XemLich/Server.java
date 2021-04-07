package SocketTCP_XemLich;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(3030);
        System.out.println("Server dang doi...");
        Socket myServer = server.accept();
        System.out.println("Ket noi thanh cong voi Client");
        DataInputStream dis = new DataInputStream(myServer.getInputStream());
        DataOutputStream dos = new DataOutputStream(myServer.getOutputStream());
        String month1;
        String year1;
        month1=dis.readUTF();
        year1=dis.readUTF();
        int month = Integer.parseInt(month1);
        int year = Integer.parseInt(year1);
        System.out.println(month+"$"+year);
        String sendText="";
        switch(month){
            case 1:
                sendText="Co 31 ngay";
                break;
            case 3:
                sendText="Co 31 ngay";
                break;
            case 5:
                sendText="Co 31 ngay";
                break;
            case 7:
                sendText="Co 31 ngay";
                break;
            case 8:
                sendText="Co 31 ngay";
                break;
            case 10:
                sendText="Co 31 ngay";
                break;
            case 12:
                sendText="Co 31 ngay";
                break;
            case 4:
                sendText="co 30 ngay";
                break;
            case 6:
                sendText="co 30 ngay";
                break;
            case 9:
                sendText="co 30 ngay";
                break;
            case 11:
                sendText="co 30 ngay";
                break;
            case 2:
                if((year%4==0 && year%100!=0) || (year%400==0)){
                    sendText="co 29 ngay";
                }else{
                    sendText="co 28 ngay";
                }
                break;
        }
        dos.writeUTF(sendText);
        dis.close();
        dos.close();
        myServer.close();
    }
}
