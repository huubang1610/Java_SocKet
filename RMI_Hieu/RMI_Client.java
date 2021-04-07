package RMI_Hieu;

import java.rmi.RemoteException;
import java.util.Scanner;

public class RMI_Client {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Calculator calculator = new CalculatorServer();
            System.out.print("Nhập số a: ");
            float a = sc.nextInt();
            System.out.print("Nhập số b: ");
            float b = sc.nextInt();
            float c = calculator.hieu(a,b);
            System.out.println(""+a+" - "+b+" = "+c);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
