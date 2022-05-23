
import java.rmi.RemoteException;

public class Atendimento implements Interface{
    
    public Atendimento() throws RemoteException{
        super();
        System.out.println("Servidor disponivel.");
    }
    
    @Override
    public String exibirMenuPrincipal() throws RemoteException {
          return
            "\n***  MATRIX BURGERS  ***"+
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
    public double calcularTotal(double p1, double p2, double p3, int q1, int q2, int q3) throws RemoteException {
        double total = (p1 * q1) + (p2 * q2) + (p3 * q3);
        return total;
    }
}
