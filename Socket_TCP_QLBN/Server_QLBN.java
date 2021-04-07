package Socket_TCP_QLBN;

import TCP_QLNV.Person;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server_QLBN {

    public static final String url = "C:\\Users\\Admin\\IdeaProjects\\Socket\\src\\Socket_TCP_QLBN\\DsN";


    public static List<Doccument> getList(String path) throws FileNotFoundException {
        List<Doccument> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(path);
        Scanner sc = new Scanner(fis);

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String dl[] = str.split("\\$");
            if (dl.length != 3) continue;
            Doccument d = new Doccument();
            d.setSonha(dl[0]);
            d.setGiaban(dl[1]);
            d.setTinhtrang(dl[2]);

            list.add(d);
        }
        return list;
    }
    public static void save(List<Doccument> list,String path){
        try {
            FileWriter fw = new FileWriter(path);
            for (Doccument d : list) {
                fw.write(d.getSonha()+"$"+d.getGiaban()+"$"+d.getTinhtrang()+"\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.print("Loi ghi file!!!");
        }
    }

    public static void main(String[] args) throws IOException {
        List<Doccument>  list = getList(url);
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
                save(list,url);
                my_Server.close();
                return;
            } else {
                if (dl[0].equalsIgnoreCase("1")) {
                    for (Doccument d : list) {
                        send_client.append(d.toString()).append("\n");
                    }
                    dos.writeUTF(String.valueOf(send_client));
                } else if (dl[0].equalsIgnoreCase("3")) {
                    for (Doccument d : list) {
                        if (dl[1].equalsIgnoreCase(d.getSonha())) {
                            if (d.getTinhtrang().equalsIgnoreCase("True")){
                                send_client = new StringBuffer("Nhà đã được mua xin mời chọn căn khác");
                                dos.writeUTF(String.valueOf(send_client));
                            }else {
                                d.setTinhtrang("True");
                                send_client.append(d.toString()).append("\n").
                                        append("Bạn đã mua nhà này và thông tin nhà đã được thay đổi");
                                dos.writeUTF(String.valueOf(send_client));
                            }
                        }
                    }
                } else {
                    Doccument d = new Doccument();

                    d.setSonha(dl[1]);
                    d.setGiaban(dl[2]);
                    d.setTinhtrang(dl[3]);

                    list.add(d);
                    save(list,url);
                    dos.writeUTF("Thêm vào thành công!");
                }
            }
        }
    }
}
