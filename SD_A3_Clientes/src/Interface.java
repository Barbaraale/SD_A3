import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Interface extends Remote{
    
    public String exibirMenuPrincipal()throws RemoteException;
    public String exibirSubMenuLanches() throws RemoteException;
    public String exibirSubMenuSucos() throws RemoteException;
    public double calcularTotalItem(double p1, double p2, double p3, int q1, int q2, int q3) throws RemoteException;
    public double calcularTotalPedido (double totalLanches, double totalSucos) throws RemoteException;
    public String gerarPagamento()throws RemoteException;
    public int gerarNumeroPedido()throws RemoteException;
    public void criandoPedidoCompleto(int numeroPedido, ArrayList lanches, ArrayList sucos) throws RemoteException;
    public void criandoPedidoLanches(int numeroPedido, ArrayList lanches) throws RemoteException;
    public void criandoPedidoSucos(int numeroPedido, ArrayList sucos) throws RemoteException;
    public ArrayList pegarTodosPedidos()throws RemoteException;
    public ArrayList pegarPedido(int indice) throws RemoteException;
    public void removerPedido(int indice)throws RemoteException;
    public void pedidoPronto (Object numeroPedido)throws RemoteException;
    public ArrayList pegarPedidoPronto() throws RemoteException;
    public void enviarLancheEstoque(ArrayList<Integer> controleEstoqueLanche) throws RemoteException;
    public void enviarSucoEstoque(ArrayList<Integer> controleEstoqueSuco) throws RemoteException;
    public ArrayList pegarLancheEstoque() throws RemoteException;
    public ArrayList pegarSucoEstoque() throws RemoteException;
    public int getConnection() throws RemoteException;
    public int setConnection(int num) throws RemoteException;
    public ArrayList<String> setItensAviso(ArrayList<String> todosItens)throws RemoteException;
    public ArrayList<String> getItensAviso()throws RemoteException;
    
}
