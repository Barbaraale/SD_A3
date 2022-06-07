import java.rmi.Naming;

public class Painel {
    public static void main(String[] args) {
      
        System.out.println("Carregando painel.");
        
        try{
            Interface objRemoto = (Interface) Naming.lookup("rmi://LOCALHOST:1099/atendimento");
            
            System.out.print("-----------------------------------------------------------------------------------------------------------------------");
            System.out.print("\nPEDIDOS PRONTOS\n");
            System.out.print(objRemoto.pegarPedidoPronto());
            System.out.print("\n-----------------------------------------------------------------------------------------------------------------------\n");
        
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
}
