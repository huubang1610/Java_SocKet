package RMI_Hieu;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    public float hieu (float a, float b) throws RemoteException;
}
