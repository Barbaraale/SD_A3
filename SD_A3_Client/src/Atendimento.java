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
            "\n-------------------------------------------------------------------------------"+
            "\nMENU PRINCIPAL"+
            "\n1 - LANCHES"+
            "\n2 - SUCOS"+
            "\n-------------------------------------------------------------------------------";
    }
   
    @Override
    public String exibirSubMenuLanches() throws RemoteException {
          return
            "\n-------------------------------------------------------------------------------"+
            "\nMENU LANCHES"+
            "\n1 - X-SALADA = R$7,00"+
            "\n2 - X-BACON = R$9,00"+
            "\n3 - X-TUDO = R$12,00"+
            "\n-------------------------------------------------------------------------------"+
            "\nDigite o numero do lanche desejado: ";
    }
    
    @Override
    public String exibirSubMenuSucos() throws RemoteException {
          return
            "\n-------------------------------------------------------------------------------"+
            "\nMENU SUCOS"+
            "\n1 - SUCO DE LARANJA = R$10,00"+
            "\n2 - LIMONADA = R$8,00"+
            "\n3 - PINK LEMONADE = R$15,00"+
            "\n-------------------------------------------------------------------------------"+
            "\nDigite o numero do suco desejado: ";
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

//    @Override
//    public String gerarPagamento() throws RemoteException {
//        return 
//            "\n-------------------------------------------------------------------------------"+
//            "\nFORMAS DE PAGAMENTO"+
//            "\n1 - Débito"+
//            "\n2 - Crédito"+
//            "\n3 - Pix"+
//            "\n-------------------------------------------------------------------------------"+     
//        
//            "Digite a opcao de pagamento desejada: ";
//    }

    @Override
    public String opcaoPagamento() throws RemoteException {
        return 
            "\n-------------------------------------------------------------------------------"+
            "\nFORMAS DE PAGAMENTO"+
            "\n1 - Débito"+
            "\n2 - Crédito"+
            "\n3 - Pix"+
            "\n-------------------------------------------------------------------------------"+
            "\nDigite a opcao de pagamento desejada: ";
    }

    @Override
    public Object pedido(Object lanches, Object sucos, int numeroPedido) throws RemoteException {
        pedidos.add(lanches);
        pedidos.add(sucos);
        pedidos.add(numeroPedido);
        return pedidos;
    }  

    @Override
    public Object pegarPedido() throws RemoteException {
        return pedidos;
    }

}
