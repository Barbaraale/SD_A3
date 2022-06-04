import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

public class Cozinha {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Carregando o cliente.");
        
        try{
            Interface objRemoto = (Interface) Naming.lookup("rmi://LOCALHOST:1099/atendimento");
  
            while(objRemoto.pegarTodosPedidos().isEmpty() == false){
                System.out.print("-------------------------------------------------------------------------------");
                System.out.print("\nPEDIDOS");
                if(objRemoto.pegarTodosPedidos().isEmpty() == true){
                    System.out.print("\n[Sem pedidos]");
                }else{
                    for(int i = 0; i < objRemoto.pegarTodosPedidos().size(); i++) {
                        System.out.print("\n" + objRemoto.pegarPedido(i));           
                    }
                }
                System.out.print("\n-------------------------------------------------------------------------------");

                System.out.print("\nDigite o numero do pedido finalizado: ");
                int num = input.nextInt();

                for(int j = 0; j < objRemoto.pegarTodosPedidos().size(); j++){    
                    ArrayList a = objRemoto.pegarPedido(j);

                    if(a.get(0).equals(num)){
                        objRemoto.removerPedido(j);
                    } 
                }
            }
       
            System.out.print("-------------------------------------------------------------------------------");
            System.out.print("\nPEDIDOS");
            if(objRemoto.pegarTodosPedidos().isEmpty() == true){
                System.out.print("\n[Sem pedidos]");
            }else{
                for(int i = 0; i < objRemoto.pegarTodosPedidos().size(); i++) {
                    System.out.print("\n" + objRemoto.pegarPedido(i));           
                }
            }
            System.out.print("\n-------------------------------------------------------------------------------");
           
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
}
