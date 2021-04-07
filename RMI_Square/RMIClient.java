package RMI_Square;

import java.rmi.RemoteException;

public class RMIClient {
    public static void main(String[] args) {
        try {
            IAccount iAccount = new AccountServiceImp();
            int square = iAccount.getUser(7);
            System.out.println("Square: "+square);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
