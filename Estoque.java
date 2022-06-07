import java.rmi.Naming;
import java.util.ArrayList;


public class Estoque {
    public static void main(String[] args) {

        try {
        Interface objRemoto = (Interface) Naming.lookup("rmi://LOCALHOST:1099/atendimento");
        
        int xsalada = 3;
        int xbacon = 3;
        int xtudo = 3;
        int sucoLaranja = 3;
        int limonade = 3;
        int pinkLimonade = 3;
        

        //ArrayList<Integer> pedidosLanche = new ArrayList<>();
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

        System.out.println("Quantidade em Estoque X-Salada: " + xsalada);
        System.out.println("Quantidade em Estoque X-Bacon: " + xbacon);
        System.out.println("Quantidade em Estoque X-Tudo: " + xtudo);
           

        for(int i = 0; i < objRemoto.pegarSucoEstoque().size(); i++) {
            int sucoAtual = (int) objRemoto.pegarSucoEstoque().get(i);

            if(sucoAtual == 1){
                sucoLaranja-= 1;
            }
            if(sucoAtual == 2){
                limonade-= 1;
            }
            if(sucoAtual == 3){
                pinkLimonade-=1;
            }
        }

        System.out.println("Quantidade em Estoque Suco Laranja: " + sucoLaranja);
        System.out.println("Quantidade em Estoque Limonade: " + limonade);
        System.out.println("Quantidade em Estoque Pink Limonade: " + pinkLimonade);

//------------Verificando se o aviso de item faltando, ja foi dado. Caso nao, envia o aviso para a cozinha--------------

        ArrayList <String> todosItens = new ArrayList<>();//enviara os itens pra cozinha pelo metodo
        ArrayList <String> itensServer = new ArrayList<>();
        String cl1, cl2, cl3, cs1, cs2, cs3;

        //Verifica se o servidor ja se comunicou com o estoque
        if (objRemoto.getConnection() == 0) {
            itensServer.add("nenhum");
        }else if(objRemoto.getConnection() == 1){
            objRemoto.getItensAviso().forEach((item) -> 
            itensServer.add(item));
        }

        //envia o aviso de comunicacao com o servidor
        objRemoto.setConnection(1);

        //armazena nas variaveis de controle, caso o item esteja com estoque baixo:
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

        if(pinkLimonade <=2){
            cs3= "yes";
        }else {
            cs3= "no";
        }

        //Verificando se os itens ja foram enviados para cozinha e se nao ja adicionar no array
        //para depois enviar

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
                if(itensServer.get(i).equals("Suco Laranja")){
                    counter = 1;
                }
                if(i == itensServer.size() -1) {
                    if(counter == 0){
                        todosItens.add("Suco Laranja");
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
                if(itensServer.get(i).equals("Pink Limonade")){
                    counter = 1;
                }
                if(i == itensServer.size() -1) {
                    if(counter == 0){
                        todosItens.add("Pink Limonade");
                    }
                }
            }
        }


        objRemoto.setItensAviso(todosItens);



        }catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
};






        











    //     ArrayList <Integer> avisoEstoque = new ArrayList<>();
    //     ArrayList <String> itensFaltando = new ArrayList<>();
    //     ArrayList <String> todosItens = new ArrayList<>();
    //     int l1, l2, l3, s1, s2, s3;
        
    //     //Na segunda execucao do estoque iniciara por esse if:
    //     if(objRemoto.getEstoqueWarning().isEmpty() == false){
    //         for(int j = 0; j < 6; j++){    
    //             int valor;
    //             valor = (int) objRemoto.getEstoqueWarning().get(j);
    //             avisoEstoque.add(valor);
    //          }
    //          l1 = avisoEstoque.get(0);
    //          l2 = avisoEstoque.get(1);
    //          l3 = avisoEstoque.get(2);
    //          s1 = avisoEstoque.get(3);
    //          s2 = avisoEstoque.get(4);
    //          s3 = avisoEstoque.get(5);

    //      //Laco para adicionar os itens em baixa no array:
    //         if(avisoEstoque.get(0) == 0){
    //             if(xsalada <= 2 ) {
    //                 itensFaltando.add("X-Salada");
    //                 l1 = 1;
    //             }
    //         }
    //         if(avisoEstoque.get(1) == 0){
    //             if(xbacon <= 2) {
    //                 itensFaltando.add("X-Bacon");
    //                 l2 = 1;
    //             }
    //         }
    //         if(avisoEstoque.get(2) == 0){
    //             if(xtudo <= 2) {
    //                 itensFaltando.add("X-Tudo");
    //                 l3 =1;
    //             }
    //         }
    //         if(avisoEstoque.get(3) == 0){
    //             if(sucoLaranja <= 2) {
    //                 itensFaltando.add("Suco Laranja");
    //                 s1 = 1;
    //             }
    //         }
    //         if(avisoEstoque.get(4) == 0){
    //             if(limonade <= 2) {
    //                 itensFaltando.add("Limonada");
    //                 s2 = 1;
    //             }
    //         }
    //         if(avisoEstoque.get(5) == 0){
    //             if(pinkLimonade <= 2) {
    //                 itensFaltando.add("Pink Limonade");
    //                 s3 = 1;
    //             }     
    //         } 
    //         objRemoto.estoqueWarning(l1, l2, l3, s1, s2, s3);

    //     }
    // //na primeira execucao do estoque iniciara por aqui:
    // //___________________________________________________________________________
    //     else { 
    //         l1=0; l2=0; l3=0; s1=0; s2=0; s3=0;
    //         avisoEstoque.add(l1);
    //         avisoEstoque.add(l2);
    //         avisoEstoque.add(l3);
    //         avisoEstoque.add(s1);
    //         avisoEstoque.add(s2);
    //         avisoEstoque.add(s3);

    //        //Laco para adicionar os itens em baixa no array:
    //         if(avisoEstoque.get(0) == 0){
    //             if(xsalada <= 2 && l1 == 0) {
    //                 itensFaltando.add("X-Salada");
    //                 l1 = 1;
    //             }
    //         }
    //         if(avisoEstoque.get(1) == 0){
    //             if(xbacon <= 2) {
    //                 itensFaltando.add("X-Bacon");
    //                 l2 = 1;
    //             }
    //         }
    //         if(avisoEstoque.get(2) == 0){
    //             if(xtudo <= 2) {
    //                 itensFaltando.add("X-Tudo");
    //                 l3 =1;
    //             }
    //         }
    //         if(avisoEstoque.get(3) == 0){
    //             if(sucoLaranja <= 2) {
    //                 itensFaltando.add("Suco Laranja");
    //                 s1 = 1;
    //             }
    //         }
    //         if(avisoEstoque.get(4) == 0){
    //             if(limonade <= 2) {
    //                 itensFaltando.add("Limonada");
    //                 s2 = 1;
    //             }
    //         }
    //         if(avisoEstoque.get(5) == 0){
    //             if(pinkLimonade <= 2) {
    //                 itensFaltando.add("Pink Limonade");
    //                 s3 = 1;
    //             }     
    //         } 
    //         objRemoto.estoqueWarning(l1, l2, l3, s1, s2, s3);
    //     }
    // //_________________________________________________________________________________
    
    // //Laco para arrumar a exibicao dos itens em baixa para enviar para cozinha
    // int counterl1 =0, counterl2=0, counterl3=0, counters1=0, counters2=0, counters3=0;
            
    //         for(int j =0; j<=itensFaltando.size(); j++) {
    //             if(itensFaltando.get(j) == "X-Salada" && counterl1 == 0){
    //                 counterl1 = 1;
    //                 todosItens.add("X-Salada");
    //             }
    //             if(itensFaltando.get(j) == "X-Bacon" && counterl2 == 0){
    //                 counterl2 = 1;
    //                 todosItens.add("X-Bacon");
    //             }
    //             if(itensFaltando.get(j) == "X-Tudo" && counterl3 == 0){
    //                 counterl3 = 1;
    //                 todosItens.add("X-Tudo");
    //             }
    //             if(itensFaltando.get(j) == "Suco Laranja" && counters1 ==0){
    //                 counters1 = 1;
    //                 todosItens.add("Suco Laranja");
    //             }
    //             if(itensFaltando.get(j) == "Limonada" && counters2 == 0){
    //                 counters2 =1;
    //                 todosItens.add("Limonada");
    //             }
    //             if(itensFaltando.get(j) == "Pink Limonade" && counters3 == 0){
    //                 counters3 = 1;
    //                 todosItens.add("Pink Limonade");
    //             } 
    //         }
    //         objRemoto.itemFaltando(todosItens); 

                
            //     else{
            // //Para o aviso ser enviado, o valor de cada posicao respectiva do item deve ser 0 
            //     if(xsalada <= 2 && l1 == 0 ) {
            //         System.out.println("Valor se for no if de 0: " + l1);
            //         l1 = 1;
            //         itensFaltando.add("X-Salada");
            //     }
            //     if(xbacon <= 2 && l2 == 0 ) {
            //         System.out.println("Valor se for no if de 0: " + l2);
            //         l2 = 1;
            //         itensFaltando.add("X-Bacon");
            //     }
            //     if(xtudo <= 2 && l3 == 0) {
            //         System.out.println("Valor se for no if de 0: " + l3);
            //         l3 = 1;
            //         itensFaltando.add("X-Tudo");
            //     }
            //     if(sucoLaranja <= 2 && s1 == 0 ) {
            //         System.out.println("Valor se for no if de 0: " + s1);
            //         s1 = 1;
            //         itensFaltando.add("Suco Laranja");
            //     }
            //     if(limonade <= 2 && s2 == 0) {
            //         System.out.println("Valor se for no if de 0: " + s2);
            //         s2 = 1;
            //         itensFaltando.add("Limonada");
            //     }
            //     if(pinkLimonade <= 2 && s3 == 0 ) {
            //         System.out.println("Valor se for no if de 0: " + s3);
            //         s3 = 1;
            //         itensFaltando.add("Pink Limonade");
            //     }     
            //     }
            // }

            // objRemoto.estoqueWarning(l1, l2, l3, s1, s2, s3);    
            // objRemoto.itemFaltando(itensFaltando); 
        

        /*
        int l1, l2, l3, s1, s2, s3;
        //controle de envio do aviso
      
        //Laco para receber cada valor do metodo getEstoqueWarning e adicionar na variavel local
        if(objRemoto.getEstoqueWarning().isEmpty() == false) {
            for(int j = 0; j < objRemoto.getEstoqueWarning().size(); j++){    
                int valor = 0;
                valor = (int) objRemoto.getEstoqueWarning().get(j);
                avisoEstoque.add(valor);
             }
        }else {
            l1=0;
            l2=0;
            l3=0;
            s1=0;
            s2=0;
            s3=0;
            avisoEstoque.add(l1);
            avisoEstoque.add(l2);
            avisoEstoque.add(l3);
            avisoEstoque.add(s1);
            avisoEstoque.add(s2);
            avisoEstoque.add(s3);
        }
        
        l1 = avisoEstoque.get(0);
        l2 = avisoEstoque.get(1);
        l3 = avisoEstoque.get(2);
        s1 = avisoEstoque.get(3);
        s2 = avisoEstoque.get(4);
        s3 = avisoEstoque.get(5);

        //Laco para verificar a quantidade de itens no estoque  
        //Para o aviso ser enviado, o valor de cada posicao respectiva do item deve ser 0          
            if(xsalada == 2 && l1 == 0 ) {
                l1 = 1;
                objRemoto.itemFaltando("X-Salada");
            }

            if(xbacon == 2 && l2 == 0 ) {
                l2 = 1;
                objRemoto.itemFaltando("X-Bacon");
            }
            if(xtudo == 2 && l3 == 0) {
                l3 = 1;
                objRemoto.itemFaltando("X-Tudo");
            }
            if(sucoLaranja == 2 && s1 == 0 ) {
                s1 = 1;
                objRemoto.itemFaltando("Suco Laranja");
            }
            if(limonade == 2 && s2 == 0) {
                s2 = 1;
                objRemoto.itemFaltando("Limonada");
            }
            if(pinkLimonade == 2 && s3 == 0 ) {
                s3 = 1;
                objRemoto.itemFaltando("Pink Limonade");
            }
        
        //enviando a lista de avisos atualizada para o servidor
        objRemoto.estoqueWarning(l1, l2, l3, s1, s2, s3);
        
        */

 