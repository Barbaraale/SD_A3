import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {

    public String exibirMenuPrincipal()throws RemoteException;
    public String exibirSubMenu()throws RemoteException;
    public double calcularTotal(double d) throws RemoteException;
    
}
