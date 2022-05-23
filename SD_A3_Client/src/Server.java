
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject {
    
    public Server() throws RemoteException{
        super();
        System.out.println("Servidor disponivel.");
    }
    
    public static void main(String[] args) {
        Registry registro = null;
        try {
            Atendimento obj = new Atendimento();
            
            Remote remote = UnicastRemoteObject.exportObject(obj,0);
            
            registro = LocateRegistry.createRegistry(1099);
            
            registro.rebind("atendimento", remote);
        }
        catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
}
