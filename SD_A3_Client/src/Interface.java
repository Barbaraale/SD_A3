import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {

    public String exibirMenuPrincipal()throws RemoteException;
    public String exibirSubMenu()throws RemoteException;
    public double calcularTotal(double p1, double p2, double p3, int q1, int q2, int q3) throws RemoteException;   
}
