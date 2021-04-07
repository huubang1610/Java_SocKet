package RMI_TT;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorService extends UnicastRemoteObject implements Calculator {
    protected CalculatorService() throws RemoteException {
    }

    @Override
    public float sum(float a, float b) throws RemoteException {
        return a+b;
    }

    @Override
    public float hieu(float a, float b) throws RemoteException {
        return a-b;
    }

    @Override
    public float tich(float a, float b) throws RemoteException {
        return a*b;
    }

    @Override
    public float thuong(float a, float b) throws RemoteException {
        return a/b;
    }
}
