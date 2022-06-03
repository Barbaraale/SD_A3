import java.rmi.RemoteException;
import java.util.ArrayList;

public class Atendimento implements Interface{
    
    private int acumulador = 0;
    private ArrayList<Object> pedidos = new ArrayList<>();
    
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
            "\n1 - Debito"+
            "\n2 - Credito"+
            "\n3 - Pix"+
            "\n-------------------------------------------------------------------------------";    
    }
    
    @Override
    public ArrayList pedido(int numeroPedido, ArrayList lanches, ArrayList sucos) throws RemoteException {
        ArrayList<Object> p = new ArrayList<>();
        p.add(numeroPedido);
        p.add(lanches);
        p.add(sucos);
        pedidos.add(p);
        return pedidos;
    }  
    
    @Override
    public ArrayList pegarTodosPedidos()throws RemoteException {
        return pedidos;
    }

    @Override
    public Object pegarPedido(int x) throws RemoteException {
        Object t;
            t = pedidos.get(x);
        return t;
    }

    @Override
    public Object removerPedido(int x) throws RemoteException {
        pedidos.remove(x);
        return pedidos;
    }

//    @Override
//    public Object enviarPedido(int numeroPedido) throws RemoteException {
//        pedidos.forEach((index) -> 
//                index.forEach()
//        );
//    }
}
