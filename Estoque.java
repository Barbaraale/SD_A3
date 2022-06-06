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
        ArrayList <Integer> avisoEstoque = new ArrayList<>();
        

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

//------------Verificando o estoque e caso algum item esteja baixo envia o aviso para cozinha-------
        
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
            if(xsalada <= 2 && l1 == 0 ) {
                l1 = 1;
                objRemoto.itemFaltando("X-Salada");
            }

            if(xbacon <= 2 && l2 == 0 ) {
                l2 = 1;
                objRemoto.itemFaltando("X-Bacon");
            }
            if(xtudo <= 2 && l3 == 0) {
                l3 = 1;
                objRemoto.itemFaltando("X-Tudo");
            }
            if(sucoLaranja <= 2 && s1 == 0 ) {
                s1 = 1;
                objRemoto.itemFaltando("Suco Laranja");
            }
            if(limonade <= 2 && s2 == 0) {
                s2 = 1;
                objRemoto.itemFaltando("Limonada");
            }
            if(pinkLimonade <= 2 && s3 == 0 ) {
                s3 = 1;
                objRemoto.itemFaltando("Pink Limonade");
            }
        
        //enviando a lista de avisos atualizada para o servidor
        objRemoto.estoqueWarning(l1, l2, l3, s1, s2, s3);
        
        
    } catch(Exception e){
        System.out.println("Erro: "+ e.getMessage());
    }

    }
}
