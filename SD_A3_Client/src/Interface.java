import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {

    public String exibirMenuPrincipal()throws RemoteException;
    public String exibirSubMenuLanches() throws RemoteException;
    public String exibirSubMenuSucos() throws RemoteException;
    public double calcularTotalItem(double p1, double p2, double p3, int q1, int q2, int q3) throws RemoteException;
    public double calcularTotalPedido (double totalLanches, double totalSucos) throws RemoteException;
    public String gerarPagamento()throws RemoteException;
    public int gerarNumeroPedido()throws RemoteException;
    public Object pedido(Object lanches, Object sucos, int numeroPedido)throws RemoteException;
    public Object pegarPedido()throws RemoteException;
}
