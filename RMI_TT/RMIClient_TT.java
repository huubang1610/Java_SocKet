package RMI_TT;

import java.rmi.RemoteException;
import java.util.Scanner;

public class RMIClient_TT {
    public static void main(String[] args) {
        try {
            Calculator calculator = new CalculatorService();
            Scanner sc = new Scanner(System.in);
            float a = sc.nextFloat();
            float b = sc.nextFloat();
            float sum = calculator.sum(a,b);
            float hieu = calculator.hieu(a,b);
            float tich = calculator.tich(a,b);
            float thuong = calculator.thuong(a,b);
            System.out.println("Sum= "+sum+"\tHieu= "+hieu+"\tTich= "+tich+"\tThuong= "+thuong);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
