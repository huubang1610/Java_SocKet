package RMI_TT;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    public float sum (float a, float b) throws RemoteException;
    public float hieu (float a, float b) throws RemoteException;
    public float tich (float a, float b) throws RemoteException;
    public float thuong (float a, float b) throws RemoteException;
}
