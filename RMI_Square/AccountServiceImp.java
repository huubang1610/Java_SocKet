package RMI_Square;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AccountServiceImp extends UnicastRemoteObject implements IAccount {
    protected AccountServiceImp() throws RemoteException {
    }

    @Override
    public int getUser(int a) throws RemoteException {
        return a*a;
    }
}
