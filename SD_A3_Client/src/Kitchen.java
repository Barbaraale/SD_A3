import java.rmi.Naming;

public class Kitchen {
    public static void main(String[] args) {
        
        System.out.println("Carregando o cliente.");
        
        try{
            Interface objRemoto = (Interface) Naming.lookup("rmi://LOCALHOST:1099/atendimento");
            
            System.out.print(objRemoto.pegarPedido());
             
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
}
