import java.rmi.RemoteException;
import java.util.ArrayList;

public class Atendimento implements Interface{
    
    private int acumulador = 0;
    private ArrayList<ArrayList> pedidos = new ArrayList<>();
    private ArrayList<Object> numeros = new ArrayList<>();
    
    public Atendimento() throws RemoteException{
        super();
        System.out.println("Servidor disponivel.");
    }
    
    @Override
    public String exibirMenuPrincipal() throws RemoteException {
          return
            "-------------------------------------------------------------------------------"+
            "\nMENU PRINCIPAL"+
            "\n1 - LANCHES"+
            "\n2 - SUCOS"+
            "\n"+
            "\nCANCELAR PEDIDO"+
            "\n3 - SAIR"+
            "\n-------------------------------------------------------------------------------";
    }
   
    @Override
    public String exibirSubMenuLanches() throws RemoteException {
          return
            "-------------------------------------------------------------------------------"+
            "\nMENU LANCHES"+
            "\n1 - X-SALADA = R$7,00"+
            "\n2 - X-BACON = R$9,00"+
            "\n3 - X-TUDO = R$12,00"+
            "\n"+
            "\nCANCELAR PEDIDO"+
            "\n4 - SAIR"+
            "\n-------------------------------------------------------------------------------";
    }
    
    @Override
    public String exibirSubMenuSucos() throws RemoteException {
          return
            "-------------------------------------------------------------------------------"+
            "\nMENU SUCOS"+
            "\n1 - SUCO DE LARANJA = R$10,00"+
            "\n2 - LIMONADA = R$8,00"+
            "\n3 - PINK LEMONADE = R$15,00"+
            "\n"+
            "\nCANCELAR PEDIDO"+
            "\n4 - SAIR"+
            "\n-------------------------------------------------------------------------------";
    }
    
    @Override
    public double  calcularTotalItem (double p1, double p2, double p3, int q1, int q2, int q3) throws RemoteException {
        double total = (p1 * q1) + (p2 * q2) + (p3 * q3);
        return total;
    }

    @Override
    public double calcularTotalPedido(double totalLanches, double totalSucos) throws RemoteException {
        double totalPedido = totalLanches + totalSucos;
        return totalPedido;
    }

    @Override
    public int gerarNumeroPedido() throws RemoteException {
        int i = 0;
        i++;
        acumulador = acumulador + i;
        return acumulador;
    }

    @Override
    public String gerarPagamento() throws RemoteException {
        return 
            "-------------------------------------------------------------------------------"+
            "\nFORMAS DE PAGAMENTO"+
            "\n1 - DEBITO"+
            "\n2 - CREDITO"+
            "\n3 - PIX"+
             "\n"+
            "\nCANCELAR PEDIDO"+
            "\n4 - SAIR"+
            "\n-------------------------------------------------------------------------------";  
    }
    
    @Override
    public void criandoPedidoCompleto(int numeroPedido, ArrayList lanches, ArrayList sucos) throws RemoteException {
        ArrayList<Object> pedido = new ArrayList<>();
        pedido.add(numeroPedido);
        pedido.add(lanches);
        pedido.add(sucos);
        pedidos.add(pedido);
    }  
    
    @Override
    public void criandoPedidoLanches(int numeroPedido, ArrayList lanches) throws RemoteException {
        ArrayList<Object> pedido = new ArrayList<>();
        pedido.add(numeroPedido);
        pedido.add(lanches);
        pedidos.add(pedido);
    }
    
    @Override
    public void criandoPedidoSucos(int numeroPedido, ArrayList sucos) throws RemoteException {
        ArrayList<Object> pedido = new ArrayList<>();
        pedido.add(numeroPedido);
        pedido.add(sucos);
        pedidos.add(pedido);
    }
    
    @Override
    public ArrayList pegarTodosPedidos()throws RemoteException {
        return pedidos;
    }

    @Override
    public ArrayList pegarPedido(int indice) throws RemoteException {
        ArrayList p = pedidos.get(indice);
        return p;
    }

    @Override
    public void removerPedido(int indice) throws RemoteException {
        pedidos.remove(indice);
    }

    @Override
    public void pedidoPronto(Object numeroPedido) throws RemoteException {
        numeros.add(numeroPedido);
    }
    
    @Override
    public ArrayList pegarPedidoPronto() throws RemoteException {
        return numeros;
    }

}
