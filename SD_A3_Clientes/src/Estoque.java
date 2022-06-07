import java.rmi.Naming;
import java.util.ArrayList;

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

            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
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
            System.out.println("Suco de Laranja: " + sucoLaranja);
            System.out.println("Limonada: " + limonade);
            System.out.println("Suco de Uva: " + sucoUva);
            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        
            ArrayList <String> todosItens = new ArrayList<>();
            ArrayList <String> itensServer = new ArrayList<>();
            String cl1, cl2, cl3, cs1, cs2, cs3;

            if (objRemoto.getConnection() == 0) {
                itensServer.add("nenhum");
            }else if(objRemoto.getConnection() == 1){
                objRemoto.getItensAviso().forEach((item) -> 
                itensServer.add(item));
            }

            objRemoto.setConnection(1);

            if(xsalada <=2){
                cl1= "yes";
            }else {
                cl1= "no";
            }

            if(xbacon <=2){
                cl2= "yes";
            }else {
                cl2= "no";
            }

            if(xtudo <=2){
                cl3= "yes";
            }else {
                cl3= "no";
            }

            if(sucoLaranja <=2){
                cs1= "yes";
            }else {
                cs1= "no";
            }

            if(limonade <=2){
                cs2= "yes";
            }else {
                cs2= "no";
            }

            if(sucoUva <=2){
                cs3= "yes";
            }else {
                cs3= "no";
            }

            if(cl1 == "yes") {
                int counter = 0;
                for(int i =0; i< itensServer.size(); i++){
                    if(itensServer.get(i).equals("X-Salada")){
                        counter = 1;
                    }
                    if(i == itensServer.size() -1) {
                        if(counter == 0){
                            todosItens.add("X-Salada");
                        }
                    }
                }
            }

            if(cl2 == "yes") {
                int counter = 0;
                for(int i =0; i< itensServer.size(); i++){
                    if(itensServer.get(i).equals("X-Bacon")){
                        counter = 1;
                    }
                    if(i == itensServer.size() -1) {
                        if(counter == 0){
                            todosItens.add("X-Bacon");
                        }
                    }
                }
            }

            if(cl3 == "yes") {
                int counter = 0;
                for(int i =0; i< itensServer.size(); i++){
                    if(itensServer.get(i).equals("X-Tudo")){
                        counter = 1;
                    }
                    if(i == itensServer.size() -1) {
                        if(counter == 0){
                            todosItens.add("X-Tudo");
                        }
                    }
                }
            }

            if(cs1 == "yes") {
                int counter = 0;
                for(int i =0; i< itensServer.size(); i++){
                    if(itensServer.get(i).equals("Suco de Laranja")){
                        counter = 1;
                    }
                    if(i == itensServer.size() -1) {
                        if(counter == 0){
                            todosItens.add("Suco de Laranja");
                        }
                    }
                }
            }

            if(cs2 == "yes") {
                int counter = 0;
                for(int i =0; i< itensServer.size(); i++){
                    if(itensServer.get(i).equals("Limonada")){
                        counter = 1;
                    }
                    if(i == itensServer.size() -1) {
                        if(counter == 0){
                            todosItens.add("Limonada");
                        }
                    }
                }
            }

            if(cs3 == "yes") {
                int counter = 0;
                for(int i =0; i< itensServer.size(); i++){
                    if(itensServer.get(i).equals("Suco de Uva")){
                        counter = 1;
                    }
                    if(i == itensServer.size() -1) {
                        if(counter == 0){
                            todosItens.add("Suco de Uva");
                        }
                    }
                }
            }
            
            objRemoto.setItensAviso(todosItens);
            
        } catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
}
