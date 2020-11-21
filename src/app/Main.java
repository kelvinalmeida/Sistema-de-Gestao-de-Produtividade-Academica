package src.app;
import java.util.Scanner;
import src.colaboradores.*;
import src.projetos.*;

public class Main {

    public static void main(String args[]) {
        System.out.println("#######################################################");
        System.out.println("## Bem vindo, ao Sistema de Produtividade Academica! ##");
        System.out.println("#######################################################");
        
        // Instancias únicas que vão gerenciar!
        GerenciamentoColaboradores GereColaboradores = new GerenciamentoColaboradores();
        GerenciarProgetos GereProjetos = new GerenciarProgetos(GereColaboradores);
        
        while(0 != 1) {
            
            System.out.println("#######################################################");
            System.out.println("##             O que gostaria de Fazer?              ##");
            System.out.println("##             Escolha uma opcao abaixo!             ##");
            System.out.println("##            [1] Cadastrar Colaboradores!           ##");
            System.out.println("##               [2] Cadastrar Projeto!              ##");
            System.out.println("##               [3] Alocar Colaborador!             ##");
            System.out.println("##             [4] Consultar Colaborador!            ##");
            System.out.println("##               [0] Finalizar Programa!             ##");
            System.out.println("#######################################################");

            System.out.print("## ");
            Scanner teclado = new Scanner(System.in);
            int escolha = Integer.parseInt(teclado.nextLine());

            // Quer adicionar um colaborador!
            if(escolha == 1) GereColaboradores.adicionar();
            
            // Quer adicionar um Projeto!
            else if(escolha == 2) GereProjetos.adicionar();

            // Alocar colaborador!
            else if(escolha == 3) GereProjetos.alocar();
            
            // Quer consultar um colaborador!
            else if(escolha == 4) GereColaboradores.consultar();
            
            
            
            else if(escolha == 0) {
                System.out.println("## **FINALIZADO!");
                System.out.println("#######################################################");
                break;
            }

        }

    }
} 