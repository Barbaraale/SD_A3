
import java.rmi.RemoteException;

public class Atendimento implements Interface{
    
    public Atendimento() throws RemoteException{
        super();
        System.out.println("Novo Servidor Atendimento disponível.");
    }
    
    @Override
    public String exibirMenuPrincipal() throws RemoteException {
          return
            "***  MATRIX BURGERS  ***"+
            "\n-------------------------------------------------------------------------------"+
            "\nMENU PRINCIPAL"+
            "\n1 - LANCHES"+
            "\n2 - SUCOS"+
            "\n-------------------------------------------------------------------------------";
    }
   
    @Override
    public String exibirSubMenu() throws RemoteException {
          return
            "\n-------------------------------------------------------------------------------"+
            "\nMENU LANCHES"+
            "\n1 - X-SALADA = R$7,00"+
            "\n2 - X-BACON = R$9,00"+
            "\n3 - X-TUDO = R$12,00"+
            "\n-------------------------------------------------------------------------------";
    }
    
    @Override
    public double calcularTotal(double total) throws RemoteException {
        return total;
    }
}
