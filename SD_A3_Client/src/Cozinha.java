import java.rmi.Naming;
import java.util.ArrayList;

public class Cozinha {
    public static void main(String[] args) {
        
        System.out.println("Carregando o cliente.");
        
        try{
            Interface objRemoto = (Interface) Naming.lookup("rmi://LOCALHOST:1099/atendimento");
   
            System.out.print("Pedidos: " + objRemoto.pegarTodosPedidos());
//            System.out.print("\nPegar: "+ objRemoto.pegarPedido(1)); 
//            System.out.print("\nRemover: "+ objRemoto.removerPedido(0)); 
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
}
