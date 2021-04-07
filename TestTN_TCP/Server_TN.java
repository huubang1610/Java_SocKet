package TestTN_TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Server_TN {

    public static final String url = "C:\\Users\\Admin\\IdeaProjects\\Socket\\src\\TestTN_TCP\\NHDT";


    public static List<File_Document> getList(String path) throws FileNotFoundException {
        List<File_Document> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(path);
        Scanner sc = new Scanner(fis);

        while (sc.hasNextLine()){
            String str = sc.nextLine();
            String dl[] = str.split("\\$");
            if (dl.length!=6) continue;
            File_Document f = new File_Document();

            f.setDeBai(dl[0]);
            f.setDaA(dl[1]);
            f.setDaB(dl[2]);
            f.setDaC(dl[3]);
            f.setDaD(dl[4]);
            f.setKey(dl[5]);

            list.add(f);
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket my_Server = new ServerSocket(32);
        Socket server = my_Server.accept();
        DataInputStream dis = new DataInputStream(server.getInputStream());
        DataOutputStream dos = new DataOutputStream(server.getOutputStream());
        List<File_Document> list = getList(url);
        String mess_Client = null;
        String send_client = null;
        int number =0;
         while (true){
             mess_Client = dis.readUTF();
             if (mess_Client.equalsIgnoreCase("no")){
                 my_Server.close();
                 return;
             }else{
                     send_client = (list.get(number).getDeBai()+"/"+list.get(number).getDaA()+
                             "/"+list.get(number).getDaB()+"/"+ list.get(number).getDaC()+"/"
                             +list.get(number).getDaD()+"/"+list.get(number).getKey()+"/"+list.size());
                     number++;
                 dos.writeUTF(send_client);
                 if (number >= list.size()) break;
             }
         }
    }
}
