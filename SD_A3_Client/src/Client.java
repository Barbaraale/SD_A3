import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Listas dos pedidos
        ArrayList<String> lanches = new ArrayList<>();
        ArrayList<String> sucos = new ArrayList<>();
        //ArrayList<String> pedidos = new ArrayList<>();
        
        //Repetição
        char adicionar, voltar, confirmar;
        
        //Lanches
        int lanche, qntL1 = 0, qntL2 = 0, qntL3 = 0;
        String lanche1 = "X-SALADA", lanche2 = "X-BACON", lanche3 = "X-TUDO";
        double totalLanches = 0, precoL1 = 7.00, precoL2 = 9.00, precoL3 = 12.00;
        
        //Sucos
        int suco, qntS1 = 0, qntS2 = 0, qntS3 = 0;
        String suco1 = "SUCO DE LARANJA", suco2 = "LIMONADA", suco3 = "PINK LEMONADE";
        double totalSucos = 0, precoS1 = 10.00, precoS2 = 8.00, precoS3 = 15.00;
             
        System.out.println("Carregando o cliente.");
        
        try{
            Interface objRemoto = (Interface) Naming.lookup("rmi://LOCALHOST:1099/atendimento");
            
           System.out.print("\n***  MATRIX BURGERS  ***");
           
            do{
                String menuPrincipal = objRemoto.exibirMenuPrincipal();
                System.out.println(menuPrincipal);

                System.out.print("\nDigite o numero do menu desejado: ");
                int escolhaMenuPrincipal = input.nextInt();
        
                switch(escolhaMenuPrincipal){
                    case 1:
                        do{
                            String subMenuLanches = objRemoto.exibirSubMenuLanches();
                            System.out.println(subMenuLanches);

                            System.out.print("\nDigite o numero do lanche desejado: ");
                            lanche = input.nextInt();

                            switch(lanche){
                                case 1:
                                    System.out.print("\nDigite a quantidade de " + lanche1 + ": ");
                                    qntL1 = input.nextInt();
                                    lanches.add(lanche1 + " x " + qntL1);
                                    break;

                                case 2:
                                    System.out.print("\nDigite a quantidade de " + lanche2 + ": ");
                                    qntL2 = input.nextInt();
                                    lanches.add(lanche2 + " x " + qntL2);
                                    break;

                                case 3:
                                    System.out.print("\nDigite a quantidade de " + lanche3 + ": ");
                                    qntL3 = input.nextInt();
                                    lanches.add(lanche3 + " x " + qntL3);
                                    break;
                                
                                default:
                                    System.out.print("\nOpcao invalida, escolha os lanches de 1 a 3");
                                    break;
                            }
                            
                            System.out.println("\n-------------------------------------------------------------------------------");
                            System.out.println("\nLanches pedidos: " + lanches);
                            totalLanches = objRemoto. calcularTotalItem(precoL1, precoL2, precoL3, qntL1, qntL2, qntL3);
                            System.out.println("Total dos lanches pedidos: R$" + totalLanches);
                            System.out.println("\n-------------------------------------------------------------------------------");

                            System.out.print("\nDeseja adicionar mais lanches? (s/n): ");
                            adicionar = input.next().charAt(0);

                        }while(adicionar == 's' || adicionar == 'S');
                        break;

                    case 2: 
                        do{
                            String subMenuSucos = objRemoto.exibirSubMenuSucos();
                            System.out.println(subMenuSucos);

                            System.out.print("\nDigite o numero do suco desejado: ");
                            suco = input.nextInt();

                            switch(suco){
                                case 1:
                                    System.out.print("\nDigite a quantidade de " + suco1 + ": ");
                                    qntS1 = input.nextInt();
                                    sucos.add(suco1 + " x " + qntS1);
                                    break;

                                case 2:
                                    System.out.print("\nDigite a quantidade de " + suco2 + ": ");
                                    qntS2 = input.nextInt();
                                    sucos.add(suco2 + " x " + qntS2);
                                    break;

                                case 3:
                                    System.out.print("\nDigite a quantidade de " + suco3 + ": ");
                                    qntS3 = input.nextInt();
                                    sucos.add(suco3 + " x " + qntS3);
                                    break;
                                
                                default:
                                    System.out.print("\nOpcao invalida, escolha os sucos de 1 a 3");
                                    break;
                            }
                            
                            System.out.println("\n-------------------------------------------------------------------------------");
                            System.out.println("\nSucos pedidos: " + sucos);
                            totalSucos = objRemoto. calcularTotalItem(precoS1, precoS2, precoS3, qntS1, qntS2, qntS3);
                            System.out.println("Total dos sucos pedidos: R$" + totalSucos);
                            System.out.println("\n-------------------------------------------------------------------------------");

                            System.out.print("\nDeseja adicionar mais sucos? (s/n): ");
                            adicionar = input.next().charAt(0);

                        }while(adicionar == 's' || adicionar == 'S');
                        break;
                    
                    case 3:
                        break;
                        
                    default:
                        System.out.print("\nOpcao invalida, escolha de 1 a 3");
                        break;   
                }
                
                System.out.print("\nDeseja voltar para o menu principal? (s/n): ");
                voltar = input.next().charAt(0);
            
            }while(voltar == 's' || voltar == 'S');
            
            System.out.println("\n-------------------------------------------------------------------------------");
            System.out.print("\nPedido: " + lanches + sucos);
            double totalPedido = objRemoto.calcularTotalPedido(totalLanches, totalSucos);
            System.out.print("\nTotal: R$" + totalPedido);
            System.out.println("\n-------------------------------------------------------------------------------");
            
            System.out.print("Confirmar compra? (s/n): ");
            confirmar = input.next().charAt(0);
            
            if(confirmar == 's' || confirmar == 'S'){
                
                String opcao = objRemoto.opcaoPagamento();
                System.out.print(opcao);
                
                int numCompra = objRemoto.gerarNumeroPedido();
                System.out.print("Numero do pedido: " + numCompra);
            } 
            
        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
}
