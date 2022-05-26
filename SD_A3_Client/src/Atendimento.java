import java.rmi.RemoteException;

public class Atendimento implements Interface{
    
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
            "\n3 - SAIR"+
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
            "\n-------------------------------------------------------------------------------";
    }
    
    @Override
    public String exibirSubMenuSucos() throws RemoteException {
          return
            "\n-------------------------------------------------------------------------------"+
            "\nMENU SUCOS"+
            "\n1 - SUCO DE LARANJA = R$10,00"+
            "\n2 - LIMONADA = R$8,00"+
            "\n3 - PINK LEMONADE = R$15,00"+
            "\n-------------------------------------------------------------------------------";
    }
    
    @Override
    public double calcularTotal(double p1, double p2, double p3, int q1, int q2, int q3) throws RemoteException {
        double total = (p1 * q1) + (p2 * q2) + (p3 * q3);
        return total;
    }

    @Override
    public double calcularTotalPedido(double totalLanches, double totalSucos) throws RemoteException {
        double totalPedido = totalLanches + totalSucos;
        return totalPedido;
    }

}
