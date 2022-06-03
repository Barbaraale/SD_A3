import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Interface extends Remote {
    
    public String exibirMenuPrincipal()throws RemoteException;
    public String exibirSubMenuLanches() throws RemoteException;
    public String exibirSubMenuSucos() throws RemoteException;
    public double calcularTotalItem(double p1, double p2, double p3, int q1, int q2, int q3) throws RemoteException;
    public double calcularTotalPedido (double totalLanches, double totalSucos) throws RemoteException;
    public String gerarPagamento()throws RemoteException;
    public int gerarNumeroPedido()throws RemoteException;
    public ArrayList pedido(int numeroPedido, ArrayList lanches, ArrayList sucos) throws RemoteException;
    public ArrayList pegarTodosPedidos()throws RemoteException;
    public Object pegarPedido(int x) throws RemoteException;
    public Object removerPedido(int x)throws RemoteException;
    
//    public Object enviarPedido(int numeroPedido)throws RemoteException;
    
}
