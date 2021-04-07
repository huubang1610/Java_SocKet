package RMI_Square;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            IAccount iAccount = new AccountServiceImp();
            LocateRegistry.createRegistry(6789);
            Naming.bind("rmi://192.168.1.230:6789/SeptemberRMI",iAccount);
        } catch (RemoteException | AlreadyBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
