package RMI_Hieu;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer extends UnicastRemoteObject implements Calculator {
    protected CalculatorServer() throws RemoteException {
    }

    @Override
    public float hieu(float a, float b) throws RemoteException {
        return a-b;
    }
}
