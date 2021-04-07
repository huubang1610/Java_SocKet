package RMI_Hieu;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMI_Server {
    public static void main(String[] args) {
        try {
            Calculator calculator = new CalculatorServer();
            LocateRegistry.createRegistry(6789);
            Naming.bind("127.0.0.1",calculator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
