import java.rmi.Naming;

public class Estoque {
    public static void main(String[] args) {
        
        System.out.println("Carregando estoque.");
        
        try {
            Interface objRemoto = (Interface) Naming.lookup("rmi://LOCALHOST:1099/atendimento");

            int xsalada = 3;
            int xbacon = 3;
            int xtudo = 3;
            int sucoLaranja = 3;
            int limonade = 3;
            int sucoUva = 3;

            for(int i = 0; i < objRemoto.pegarLancheEstoque().size(); i++) {
                int lancheAtual = (int) objRemoto.pegarLancheEstoque().get(i);

                if(lancheAtual == 1){
                    xsalada-= 1;
                }
                if(lancheAtual == 2){
                    xbacon-= 1;
                }
                if(lancheAtual == 3){
                    xtudo-=1;
               }
            }

            System.out.println( "-------------------------------------------------------------------------------");
            System.out.println("QUANTIDADE EM ESTOQUE");
            System.out.println("X-Salada = " + xsalada);
            System.out.println("X-Bacon = " + xbacon);
            System.out.println("X-Tudo = " + xtudo);


            for(int i = 0; i < objRemoto.pegarSucoEstoque().size(); i++) {
                int sucoAtual = (int) objRemoto.pegarSucoEstoque().get(i);

                if(sucoAtual == 1){
                    sucoLaranja-= 1;
                }
                if(sucoAtual == 2){
                    limonade-= 1;
                }
                if(sucoAtual == 3){
                    sucoUva-=1;
                }
            }

            System.out.println(" ");
            System.out.println("Suco Laranja: " + sucoLaranja);
            System.out.println("Limonada: " + limonade);
            System.out.println("Suco de Uva: " + sucoUva);
            System.out.println("-------------------------------------------------------------------------------");
        
        } catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
}
