package src.app;
import java.util.Scanner;
import src.colaboradores.*;

public class Main {

    public static void main(String args[]) {
        System.out.println("#######################################################");
        System.out.println("## Bem vindo, ao Sistema de Produtividade Academica! ##");
        System.out.println("#######################################################");
        
        GerenciamentoColaboradores GereColaboradores = new GerenciamentoColaboradores();
        
        while(0 != 1) {
            
            System.out.println("#######################################################");
            System.out.println("##             O que gostaria de Fazer?              ##");
            System.out.println("##             Escolha uma opcao abaixo!             ##");
            System.out.println("##            [1] Cadastrar Colaboradores!           ##");
            System.out.println("##             [2] Consultar Colaborador!            ##");
            System.out.println("#######################################################");
            
            System.out.print("## ");
            Scanner teclado = new Scanner(System.in);
            int escolha = Integer.parseInt(teclado.nextLine());

            // Quer adicionar um colaborador!
            if(escolha == 1) GereColaboradores.adicionar();

            // Quer consultar um colaborador!
            else if(escolha == 2) GereColaboradores.consultar();

        }

    }
} 