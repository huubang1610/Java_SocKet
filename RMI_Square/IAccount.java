package RMI_Square;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAccount extends Remote {
    public int getUser(int a) throws RemoteException;
}
