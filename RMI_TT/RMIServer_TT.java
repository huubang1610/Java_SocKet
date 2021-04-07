package RMI_TT;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class RMIServer_TT {
    public static void main(String[] args) {
        try {
            Calculator calculator = new CalculatorService();
            LocateRegistry.createRegistry(6789);
            Naming.bind("rmi://192.168.1.230:6789/SeptemberRMI",calculator);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
