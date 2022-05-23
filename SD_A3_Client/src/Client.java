import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Listas dos pedidos
        ArrayList<String> lanches = new ArrayList<>();
        
        //Repetição
        char adicionar, voltar;
        
        //Escolha do menu
        int escolhaMenuPrincipal;
        
        //Lanches
        int lanche, qntL1 = 0, qntL2 = 0, qntL3 = 0;
        String lanche1 = "X-SALADA", lanche2 = "X-BACON", lanche3 = "X-TUDO";
        double totalLanches = 0, precoL1 = 7.00, precoL2 = 9.00, precoL3 = 12.00;
       
        System.out.println("Carregando o cliente.");
        
        try{
            Interface objRemoto = (Interface) Naming.lookup("rmi://LOCALHOST:1099/atendimento");
           
            do{
                String menuPrincipal = objRemoto.exibirMenuPrincipal();
                System.out.println(menuPrincipal);

                System.out.print("\nDigite o numero do menu desejado: ");
                escolhaMenuPrincipal = input.nextInt();
        
                switch(escolhaMenuPrincipal){
                    case 1:
                        do{
                            String subMenu = objRemoto.exibirSubMenu();
                            System.out.println(subMenu);

                            System.out.print("\nDigite o numero do lanche desejado: ");
                            lanche = input.nextInt();

                            switch(lanche){
                                case 1:
                                    System.out.print("\nDigite a quantidade: ");
                                    qntL1 = input.nextInt();
                                    lanches.add(lanche1 + " x " + qntL1);
                                    break;

                                case 2:
                                    System.out.print("\nDigite a quantidade: ");
                                    qntL2 = input.nextInt();
                                    lanches.add(lanche2 + " x " + qntL2);
                                    break;

                                case 3:
                                    System.out.print("\nDigite a quantidade: ");
                                    qntL3 = input.nextInt();
                                    lanches.add(lanche3 + " x " + qntL3);
                                    break;
                                
                                default:
                                    System.out.print("\nOpcao invalida, escolha de 1 a 3");
                                    break;
                            }

                            System.out.print("\nDeseja adicionar mais lanches? (s/n): ");
                            adicionar = input.next().charAt(0);

                        }while(adicionar == 's' || adicionar == 'S');

                        System.out.println("\nLanches pedidos: " + lanches);
                        totalLanches = objRemoto.calcularTotal((precoL1 * qntL1) + (precoL2 * qntL2) + (precoL3 * qntL3));
                        System.out.println("\nTotal dos lanches pedidos: " + totalLanches);
                        System.out.println("\n-------------------------------------------------------------------------------");

                        break;

                    case 2: //continuar case default tbm
                        System.out.println("Sucos");
                        System.out.println("Suco 1 - R$1,00");
                        System.out.println("Suco 2 - R$2,00");
                        break;
                    
                    default:
                        System.out.print("\nOpcao invalida, escolha de 1 a 2");
                        break;   
                }
            
                System.out.print("\nDeseja voltar para o menu principal? (s/n): ");
                voltar = input.next().charAt(0);
            
            }while(voltar == 's' || voltar == 'S');
            
            
            //double valor = objRemoto.calcularTotal(12.00, qnt);
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
}
