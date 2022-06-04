import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        //Listas 
        ArrayList<String> arrayLanches = new ArrayList<>();
        ArrayList<String> arraySucos = new ArrayList<>();
        
        //Repetição
        char adicionar, voltar, confirmar;
        
        //Lanches
        int escolhaLanche, qntL1 = 0, qntL2 = 0, qntL3 = 0;
        String lanche1 = "X-SALADA", lanche2 = "X-BACON", lanche3 = "X-TUDO";
        double totalLanches = 0, precoL1 = 7.00, precoL2 = 9.00, precoL3 = 12.00;
        
        //Sucos
        int escolhaSuco, qntS1 = 0, qntS2 = 0, qntS3 = 0;
        String suco1 = "SUCO DE LARANJA", suco2 = "LIMONADA", suco3 = "PINK LEMONADE";
        double totalSucos = 0, precoS1 = 10.00, precoS2 = 8.00, precoS3 = 15.00;
             
        System.out.println("Carregando o cliente.");
        
        try{
            Interface objRemoto = (Interface) Naming.lookup("rmi://LOCALHOST:1099/atendimento");
            
            System.out.print("\n***  MATRIX BURGERS  ***\n");
           
            do{
                String menuPrincipal = objRemoto.exibirMenuPrincipal();
                System.out.print(menuPrincipal);

                System.out.print("\nDigite a opcao desejada: ");
                int escolhaMenuPrincipal = input.nextInt();
        
                switch(escolhaMenuPrincipal){
                    case 1:
                        do{
                            System.out.print(objRemoto.exibirSubMenuLanches());
                            
                            System.out.print("\nDigite o numero do lanche desejado: ");
                            escolhaLanche = input.nextInt();

                            switch(escolhaLanche){
                                case 1:
                                    System.out.print("Digite a quantidade de " + lanche1 + ": ");
                                    qntL1 = input.nextInt();
                                    arrayLanches.add(lanche1 + " x " + qntL1);
                                    break;

                                case 2:
                                    System.out.print("Digite a quantidade de " + lanche2 + ": ");
                                    qntL2 = input.nextInt();
                                    arrayLanches.add(lanche2 + " x " + qntL2);
                                    break;

                                case 3:
                                    System.out.print("Digite a quantidade de " + lanche3 + ": ");
                                    qntL3 = input.nextInt();
                                    arrayLanches.add(lanche3 + " x " + qntL3);
                                    break;
                                    
                                case 4:
                                    System.exit(0);
                                    break;
                                
                                default:
                                    System.out.print("Opcao invalida, escolha de 1 a 4\n");
                                    break;
                            }
                            
                            if(escolhaLanche >= 1 && escolhaLanche <= 4){
                                System.out.println("-------------------------------------------------------------------------------");
                                System.out.println("Lanches pedidos: " + arrayLanches);
                                totalLanches = objRemoto. calcularTotalItem(precoL1, precoL2, precoL3, qntL1, qntL2, qntL3);
                                System.out.println("Total dos lanches pedidos: R$" + totalLanches);
                                System.out.println("-------------------------------------------------------------------------------");
                            }

                            System.out.print("Deseja adicionar lanches? (s - sim / n - nao): ");
                            adicionar = input.next().charAt(0);

                        }while(adicionar == 's' || adicionar == 'S');
                        break;

                    case 2: 
                        do{
                            System.out.print(objRemoto.exibirSubMenuSucos());

                            System.out.print("\nDigite o numero do suco desejado: ");
                            escolhaSuco = input.nextInt();

                            switch(escolhaSuco){
                                case 1:
                                    System.out.print("Digite a quantidade de " + suco1 + ": ");
                                    qntS1 = input.nextInt();
                                    arraySucos.add(suco1 + " x " + qntS1);
                                    break;

                                case 2:
                                    System.out.print("Digite a quantidade de " + suco2 + ": ");
                                    qntS2 = input.nextInt();
                                    arraySucos.add(suco2 + " x " + qntS2);
                                    break;

                                case 3:
                                    System.out.print("Digite a quantidade de " + suco3 + ": ");
                                    qntS3 = input.nextInt();
                                    arraySucos.add(suco3 + " x " + qntS3);
                                    break;
                                    
                                case 4:
                                    System.exit(0);
                                    break;
                                
                                default:
                                    System.out.print("Opcao invalida, escolha de 1 a 4\n");
                                    break;
                            }
                            
                            if(escolhaSuco >= 1 && escolhaSuco <= 4){
                                System.out.println("-------------------------------------------------------------------------------");
                                System.out.println("Sucos pedidos: " + arraySucos);
                                totalSucos = objRemoto. calcularTotalItem(precoS1, precoS2, precoS3, qntS1, qntS2, qntS3);
                                System.out.println("Total dos sucos pedidos: R$" + totalSucos);
                                System.out.println("-------------------------------------------------------------------------------");
                            }
                           
                            System.out.print("Deseja adicionar sucos? (s - sim / n - nao): ");
                            adicionar = input.next().charAt(0);

                        }while(adicionar == 's' || adicionar == 'S');
                        break;
                    
                    case 3:
                        System.exit(0);
                        break;
                        
                    default:
                        System.out.print("Opcao invalida, escolha de 1 a 3.\n");
                        break;   
                }
                
                System.out.print("Deseja voltar para o menu principal? (s - sim / n - nao): ");
                voltar = input.next().charAt(0);
                
            }while(voltar == 's' || voltar == 'S');

            if(arrayLanches.isEmpty() == false || arraySucos.isEmpty() == false){
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("Pedido: " + arrayLanches + arraySucos);
                System.out.println("Total: R$" + objRemoto.calcularTotalPedido(totalLanches, totalSucos));
                System.out.println("-------------------------------------------------------------------------------");

                System.out.print("Confirmar compra? (s - sim / n - nao): ");
                confirmar = input.next().charAt(0);

                if(confirmar == 's' || confirmar == 'S'){
                    System.out.print(objRemoto.gerarPagamento());
                    
                    System.out.print("\nDigite a opcao de pagamento desejada: ");
                    int escolhaPagamento = input.nextInt();
                    
                    System.out.print("PAGAMENTO EFETUADO COM SUCESSO!");

                    int numCompra = objRemoto.gerarNumeroPedido();
                    System.out.println("\nNumero do pedido: " + numCompra);
                    objRemoto.criandoPedido(numCompra,arrayLanches, arraySucos);          
                } 
            }

        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
}
