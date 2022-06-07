import java.rmi.Naming;
import java.util.Scanner;

public class Cozinha {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Carregando cozinha.");
        
        try{
            Interface objRemoto = (Interface) Naming.lookup("rmi://LOCALHOST:1099/atendimento");

            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
            System.out.println("ITENS EM BAIXA: ");
            System.out.println(objRemoto.getItensAviso());
            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
            
            while(objRemoto.pegarTodosPedidos().isEmpty() == false){
                System.out.print("PEDIDOS");
                    for(int i = 0; i < objRemoto.pegarTodosPedidos().size(); i++) {
                        System.out.print("\n" + objRemoto.pegarPedido(i));           
                    }
                System.out.print("\n-----------------------------------------------------------------------------------------------------------------------");

                System.out.print("\nDigite o numero do pedido finalizado: ");
                int num = input.nextInt();

                for(int j = 0; j < objRemoto.pegarTodosPedidos().size(); j++){    
                    if(objRemoto.pegarPedido(j).get(0).equals(num)){
                        objRemoto.pedidoPronto(objRemoto.pegarPedido(j).get(0));
                        objRemoto.removerPedido(j);               
                    } 
                }
            }
            System.out.print("-----------------------------------------------------------------------------------------------------------------------");
            System.out.print("\nPEDIDOS");
            System.out.print("\n[Sem pedidos]");
            System.out.print("\n-----------------------------------------------------------------------------------------------------------------------\n");
           
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
}
