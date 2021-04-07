package SocketTCP_QLKS;

import TCP_QLNV.Person;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server_QLKS {

    public static final String url = "C:\\Users\\Admin\\IdeaProjects\\Socket\\src\\SocketTCP_QLKS\\Custormer";

    public static List<Doccument_Custormer> getList(String path) throws FileNotFoundException {
        List<Doccument_Custormer> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(path);
        Scanner sc = new Scanner(fis);

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String dl[] = str.split("\\$");
            if (dl.length != 3) continue;
            Doccument_Custormer dc = new Doccument_Custormer();
            dc.setID(dl[0]);
            dc.setName(dl[1]);
            dc.setPhanloai(dl[2]);

            list.add(dc);
        }
        return list;
    }

    public static void save(List<Doccument_Custormer> list, String path) {
        try {
            FileWriter fw = new FileWriter(path);
            for (Doccument_Custormer l : list) {
                fw.write(l.getID() + "$" + l.getName() + "$" + l.getPhanloai() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.print("Loi ghi file!!!");
        }
    }

    public static float Total (Doccument_Custormer dc, int day){
        float sum =0;
        if (dc.getPhanloai().equalsIgnoreCase("S")){
            sum = 500 * day;
        }else if(dc.getPhanloai().equalsIgnoreCase("A")){
            sum = 250 * day;
        }else{
            sum = 100 * day;
        }
        return sum;
    }


    public static void main(String[] args) throws IOException {
        List<Doccument_Custormer> list = getList(url);
        ServerSocket my_Server = new ServerSocket(32);
        Socket server = my_Server.accept();
        DataInputStream dis = new DataInputStream(server.getInputStream());
        DataOutputStream dos = new DataOutputStream(server.getOutputStream());


        while (true) {
            String mess_Client = null;
            StringBuffer send_client = new StringBuffer();

            mess_Client = dis.readUTF();
            String dl[] = mess_Client.split("\\$");

            if (dl[0].equalsIgnoreCase("3")) {
                save(list, url);
                my_Server.close();
                return;
            } else {
                 if (dl[0].equalsIgnoreCase("2")) {
                     float total = 0;
                    for (Doccument_Custormer l : list) {
                        if (dl[1].equalsIgnoreCase(l.getName())) {
                            total = Total(l, Integer.parseInt(dl[2]));
                            send_client.append(l.toString()).append("\n Tổng tiền phải thanh toán là: "+total).append("\n");
                        }
                    }
                    dos.writeUTF(String.valueOf(send_client));
                } else if (dl[0].equalsIgnoreCase("1")){
                    Doccument_Custormer dc = new Doccument_Custormer();
                    dc.setID(dl[1]);
                    dc.setName(dl[2]);
                    dc.setPhanloai(dl[3]);

                    list.add(dc);
                    dos.writeUTF("Thêm vào thành công!");
                }
            }
        }
    }
}
