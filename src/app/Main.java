package src.app;
import java.util.Scanner;
import src.colaboradores.*;

public class Main {

    public static void main(String args[]) {
        System.out.println("#######################################################");
        System.out.println("## Bem vindo, ao Sistema de Produtividade Academica! ##");
        System.out.println("#######################################################");
        
        System.out.println("#######################################################");
        System.out.println("##             O que gostaria de Fazer?              ##");
        System.out.println("##             Escolha uma opcao abaixo!             ##");
        System.out.println("##             [1] Cadastrar Colaboradores!          ##");
        System.out.println("#######################################################");
        
        Cadastro cadastro = new Cadastro();
        
        while(0 != 1) {
            Scanner teclado = new Scanner(System.in);
            int escolha = Integer.parseInt(teclado.nextLine());

            // Quer adicionar um colaborador!
            if(escolha == 1) cadastro.adicionar();

        }


    }
} 