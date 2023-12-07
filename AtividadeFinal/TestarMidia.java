package atividade3;

import java.util.Scanner;

public class TestaMidia {
    public static void main(String args[]) {
      
        midia[] lista = new midia[10];

        int opcao;

        
        for (int i = 0; i < 2; i++) {
            
            System.out.println("Digite 1 para CD e 2 para DVD");
            Scanner in = new Scanner(System.in);
            opcao = in.nextInt();

            if (opcao == 1) // Criar CD.
                lista[i] = new CD();
            else // Criar DVD.
                lista[i] = new DVD();

            lista[i].inserirDados(); 

            
            in.close();
        }

        
        for (int i = 0; i < 2; i++)
            System.out.println(lista[i].getDetalhes());
    }
}