package TCP_QLNV;


import TestTN_TCP.File_Document;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Server_qlnv {

    public static final String url = "C:\\Users\\Admin\\IdeaProjects\\Socket\\src\\TCP_QLNV\\DsNV";


    public static List<Person> getList(String path) throws FileNotFoundException {
        List<Person> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(path);
        Scanner sc = new Scanner(fis);

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String dl[] = str.split("\\$");
            if (dl.length != 3) continue;
            Person p = new Person();

            p.setName(dl[0]);
            p.setDateOfBirth(dl[1]);
            p.setTitle(dl[2]);

            list.add(p);
        }
        return list;
    }
    public static void save(List<Person> list,String path){
        try {
            FileWriter fw = new FileWriter(path);
            for (Person l : list) {
                fw.write(l.getName()+"$"+l.getDateOfBirth()+"$"+l.getTitle()+"\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.printf("Loi ghi file!!!");
        }
    }

    public static void main(String[] args) throws IOException {
        List<Person>  list = getList(url);
        ServerSocket my_Server = new ServerSocket(32);
        Socket server = my_Server.accept();
        DataInputStream dis = new DataInputStream(server.getInputStream());
        DataOutputStream dos = new DataOutputStream(server.getOutputStream());


        while (true) {
            String mess_Client = null;
            StringBuffer send_client = new StringBuffer();

            mess_Client = dis.readUTF();
            String dl[] = mess_Client.split("\\$");

            if (dl[0].equalsIgnoreCase("4")) {
                my_Server.close();
                return;
            } else {
                if (dl[0].equalsIgnoreCase("1")) {
                    for (Person l : list) {
                        send_client.append(l.toString()).append("\n");
                    }
                    dos.writeUTF(String.valueOf(send_client));
                } else if (dl[0].equalsIgnoreCase("3")) {
                    for (Person l : list) {
                        if (dl[1].equalsIgnoreCase(l.getName())) {
                            send_client.append(l.toString()).append("\n");
                        }
                    }
                    dos.writeUTF(String.valueOf(send_client));
                } else {
                    Person p = new Person();

                    p.setName(dl[1]);
                    p.setDateOfBirth(dl[2]);
                    p.setTitle(dl[3]);

                    list.add(p);
                    save(list,url);
                    dos.writeUTF("Thêm vào thành công!");
                }
            }
        }
    }
}
