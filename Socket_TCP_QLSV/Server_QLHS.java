package Socket_TCP_QLSV;



import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server_QLHS {


    public static final  String url = "C:\\Users\\Admin\\IdeaProjects\\Socket\\src\\Socket_TCP_QLSV\\Students";

    public static List<Students> getList(String path) throws FileNotFoundException {
        List<Students> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(path);
        Scanner sc = new Scanner(fis);

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String dl[] = str.split("\\$");
            if (dl.length != 4) continue;
            Students s = new Students();
            s.setName(dl[0]);
            s.setDateOfBirth(dl[1]);
            s.setMSV(dl[2]);
            s.setAddress(dl[3]);

            list.add(s);
        }
        return list;
    }

    public static void save(List<Students> list, String path) {
        try {
            FileWriter fw = new FileWriter(path);
            for (Students l : list) {
                fw.write(l.getName()+ "$" + l.getDateOfBirth()+ "$" + l.getMSV() + "$"+l.getAddress()+ "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.print("Loi ghi file!!!");
        }
    }

    public static void main(String[] args) throws IOException {
        List<Students> list = getList(url);
        ServerSocket my_Server = new ServerSocket(32);
        Socket server = my_Server.accept();
        DataInputStream dis = new DataInputStream(server.getInputStream());
        DataOutputStream dos = new DataOutputStream(server.getOutputStream());


        while (true) {
            String mess_Client = null;
            StringBuffer send_client = new StringBuffer();

            mess_Client = dis.readUTF();
            String dl[] = mess_Client.split("\\$");

            if (dl[0].equalsIgnoreCase("6")) {
                save(list, url);
                my_Server.close();
                return;
            } else {
                if (dl[0].equalsIgnoreCase("3")) {
                    for (Students l : list) {
                        if (dl[1].equalsIgnoreCase(l.getName())) {
                            send_client.append(l.toString()).append("\n");
                        }
                    }
                    dos.writeUTF(String.valueOf(send_client));
                } else if (dl[0].equalsIgnoreCase("2")){
                    Students s = new Students();
                    s.setName(dl[1]);
                    s.setDateOfBirth(dl[2]);
                    s.setMSV(dl[3]);
                    s.setAddress(dl[4]);

                    list.add(s);
                    dos.writeUTF("Thêm vào thành công!");
                }
                else if (dl[0].equalsIgnoreCase("5")){
                    for (Students l : list) {
                        if (dl[1].equalsIgnoreCase(l.getAddress())) {
                            send_client.append(l.toString()).append("\n");
                        }
                    }
                    dos.writeUTF(String.valueOf(send_client));
                }
                else if (dl[0].equalsIgnoreCase("4")){
                    for (Students l : list) {
                        if (dl[1].equalsIgnoreCase(l.getDateOfBirth())) {
                            send_client.append(l.toString()).append("\n");
                        }
                    }
                    dos.writeUTF(String.valueOf(send_client));
                }
                else if (dl[0].equalsIgnoreCase("1")){
                    for (Students l : list) {
                            send_client.append(l.toString()).append("\n");
                    }
                    dos.writeUTF(String.valueOf(send_client));
                }
            }
        }
    }
}
